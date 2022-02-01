package com.facebook.yoga;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class YogaNodeJNIBase
  extends YogaNode
  implements Cloneable
{
  private static final byte BORDER = 4;
  private static final byte DOES_LEGACY_STRETCH_BEHAVIOUR = 8;
  private static final byte HAS_NEW_LAYOUT = 16;
  private static final byte LAYOUT_BORDER_START_INDEX = 14;
  private static final byte LAYOUT_DIRECTION_INDEX = 5;
  private static final byte LAYOUT_EDGE_SET_FLAG_INDEX = 0;
  private static final byte LAYOUT_HEIGHT_INDEX = 2;
  private static final byte LAYOUT_LEFT_INDEX = 3;
  private static final byte LAYOUT_MARGIN_START_INDEX = 6;
  private static final byte LAYOUT_PADDING_START_INDEX = 10;
  private static final byte LAYOUT_TOP_INDEX = 4;
  private static final byte LAYOUT_WIDTH_INDEX = 1;
  private static final byte MARGIN = 1;
  private static final byte PADDING = 2;
  private float[] arr = null;
  private YogaBaselineFunction mBaselineFunction;
  private List<YogaNodeJNIBase> mChildren;
  private Object mData;
  private boolean mHasNewLayout = true;
  private int mLayoutDirection = 0;
  private YogaMeasureFunction mMeasureFunction;
  protected long mNativePointer;
  private YogaNodeJNIBase mOwner;
  
  YogaNodeJNIBase()
  {
    this(YogaNative.jni_YGNodeNewJNI());
  }
  
  private YogaNodeJNIBase(long paramLong)
  {
    if (paramLong == 0L) {
      throw new IllegalStateException("Failed to allocate native memory");
    }
    this.mNativePointer = paramLong;
  }
  
  YogaNodeJNIBase(YogaConfig paramYogaConfig)
  {
    this(YogaNative.jni_YGNodeNewWithConfigJNI(((YogaConfigJNIBase)paramYogaConfig).mNativePointer));
  }
  
  private void clearChildren()
  {
    this.mChildren = null;
    YogaNative.jni_YGNodeClearChildrenJNI(this.mNativePointer);
  }
  
  private final long replaceChild(YogaNodeJNIBase paramYogaNodeJNIBase, int paramInt)
  {
    if (this.mChildren == null) {
      throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
    }
    this.mChildren.remove(paramInt);
    this.mChildren.add(paramInt, paramYogaNodeJNIBase);
    paramYogaNodeJNIBase.mOwner = this;
    return paramYogaNodeJNIBase.mNativePointer;
  }
  
  private static YogaValue valueFromLong(long paramLong)
  {
    return new YogaValue(Float.intBitsToFloat((int)paramLong), (int)(paramLong >> 32));
  }
  
  public void addChildAt(YogaNode paramYogaNode, int paramInt)
  {
    paramYogaNode = (YogaNodeJNIBase)paramYogaNode;
    if (paramYogaNode.mOwner != null) {
      throw new IllegalStateException("Child already has a parent, it must be removed first.");
    }
    if (this.mChildren == null) {
      this.mChildren = new ArrayList(4);
    }
    this.mChildren.add(paramInt, paramYogaNode);
    paramYogaNode.mOwner = this;
    YogaNative.jni_YGNodeInsertChildJNI(this.mNativePointer, paramYogaNode.mNativePointer, paramInt);
  }
  
  public final float baseline(float paramFloat1, float paramFloat2)
  {
    return this.mBaselineFunction.baseline(this, paramFloat1, paramFloat2);
  }
  
  public void calculateLayout(float paramFloat1, float paramFloat2)
  {
    int j = 0;
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(this);
    int i = 0;
    while (i < ((ArrayList)localObject1).size())
    {
      localObject2 = ((YogaNodeJNIBase)((ArrayList)localObject1).get(i)).mChildren;
      if (localObject2 != null) {
        ((ArrayList)localObject1).addAll((Collection)localObject2);
      }
      i += 1;
    }
    localObject1 = (YogaNodeJNIBase[])((ArrayList)localObject1).toArray(new YogaNodeJNIBase[((ArrayList)localObject1).size()]);
    Object localObject2 = new long[localObject1.length];
    i = j;
    while (i < localObject1.length)
    {
      localObject2[i] = localObject1[i].mNativePointer;
      i += 1;
    }
    YogaNative.jni_YGNodeCalculateLayoutJNI(this.mNativePointer, paramFloat1, paramFloat2, (long[])localObject2, (YogaNodeJNIBase[])localObject1);
  }
  
  public YogaNodeJNIBase cloneWithChildren()
  {
    try
    {
      YogaNodeJNIBase localYogaNodeJNIBase = (YogaNodeJNIBase)super.clone();
      long l = YogaNative.jni_YGNodeCloneJNI(this.mNativePointer);
      localYogaNodeJNIBase.mOwner = null;
      localYogaNodeJNIBase.mNativePointer = l;
      int i = 0;
      while (i < localYogaNodeJNIBase.getChildCount())
      {
        localYogaNodeJNIBase.swapChildAt(localYogaNodeJNIBase.getChildAt(i).cloneWithChildren(), i);
        i += 1;
      }
      return localCloneNotSupportedException;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
  
  public YogaNodeJNIBase cloneWithoutChildren()
  {
    try
    {
      YogaNodeJNIBase localYogaNodeJNIBase = (YogaNodeJNIBase)super.clone();
      long l = YogaNative.jni_YGNodeCloneJNI(this.mNativePointer);
      localYogaNodeJNIBase.mOwner = null;
      localYogaNodeJNIBase.mNativePointer = l;
      localYogaNodeJNIBase.clearChildren();
      return localYogaNodeJNIBase;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
  
  public void copyStyle(YogaNode paramYogaNode)
  {
    YogaNative.jni_YGNodeCopyStyleJNI(this.mNativePointer, ((YogaNodeJNIBase)paramYogaNode).mNativePointer);
  }
  
  public void dirty()
  {
    YogaNative.jni_YGNodeMarkDirtyJNI(this.mNativePointer);
  }
  
  public void dirtyAllDescendants()
  {
    YogaNative.jni_YGNodeMarkDirtyAndPropogateToDescendantsJNI(this.mNativePointer);
  }
  
  public YogaAlign getAlignContent()
  {
    return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignContentJNI(this.mNativePointer));
  }
  
  public YogaAlign getAlignItems()
  {
    return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignItemsJNI(this.mNativePointer));
  }
  
  public YogaAlign getAlignSelf()
  {
    return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignSelfJNI(this.mNativePointer));
  }
  
  public float getAspectRatio()
  {
    return YogaNative.jni_YGNodeStyleGetAspectRatioJNI(this.mNativePointer);
  }
  
  public float getBorder(YogaEdge paramYogaEdge)
  {
    return YogaNative.jni_YGNodeStyleGetBorderJNI(this.mNativePointer, paramYogaEdge.intValue());
  }
  
  public YogaNodeJNIBase getChildAt(int paramInt)
  {
    if (this.mChildren == null) {
      throw new IllegalStateException("YogaNode does not have children");
    }
    return (YogaNodeJNIBase)this.mChildren.get(paramInt);
  }
  
  public int getChildCount()
  {
    if (this.mChildren == null) {
      return 0;
    }
    return this.mChildren.size();
  }
  
  public Object getData()
  {
    return this.mData;
  }
  
  public YogaDisplay getDisplay()
  {
    return YogaDisplay.fromInt(YogaNative.jni_YGNodeStyleGetDisplayJNI(this.mNativePointer));
  }
  
  public boolean getDoesLegacyStretchFlagAffectsLayout()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.arr != null)
    {
      bool1 = bool2;
      if (((int)this.arr[0] & 0x8) == 8) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public float getFlex()
  {
    return YogaNative.jni_YGNodeStyleGetFlexJNI(this.mNativePointer);
  }
  
  public YogaValue getFlexBasis()
  {
    return valueFromLong(YogaNative.jni_YGNodeStyleGetFlexBasisJNI(this.mNativePointer));
  }
  
  public YogaFlexDirection getFlexDirection()
  {
    return YogaFlexDirection.fromInt(YogaNative.jni_YGNodeStyleGetFlexDirectionJNI(this.mNativePointer));
  }
  
  public float getFlexGrow()
  {
    return YogaNative.jni_YGNodeStyleGetFlexGrowJNI(this.mNativePointer);
  }
  
  public float getFlexShrink()
  {
    return YogaNative.jni_YGNodeStyleGetFlexShrinkJNI(this.mNativePointer);
  }
  
  public YogaValue getHeight()
  {
    return valueFromLong(YogaNative.jni_YGNodeStyleGetHeightJNI(this.mNativePointer));
  }
  
  public YogaJustify getJustifyContent()
  {
    return YogaJustify.fromInt(YogaNative.jni_YGNodeStyleGetJustifyContentJNI(this.mNativePointer));
  }
  
  public float getLayoutBorder(YogaEdge paramYogaEdge)
  {
    int j = 0;
    if ((this.arr != null) && (((int)this.arr[0] & 0x4) == 4))
    {
      int i;
      if (((int)this.arr[0] & 0x1) == 1)
      {
        i = 0;
        label37:
        if (((int)this.arr[0] & 0x2) != 2) {
          break label120;
        }
      }
      for (;;)
      {
        i = 14 - i - j;
        switch (1.$SwitchMap$com$facebook$yoga$YogaEdge[paramYogaEdge.ordinal()])
        {
        default: 
          throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
          i = 4;
          break label37;
          label120:
          j = 4;
        }
      }
      return this.arr[i];
      return this.arr[(i + 1)];
      return this.arr[(i + 2)];
      return this.arr[(i + 3)];
      if (getLayoutDirection() == YogaDirection.RTL) {
        return this.arr[(i + 2)];
      }
      return this.arr[i];
      if (getLayoutDirection() == YogaDirection.RTL) {
        return this.arr[i];
      }
      return this.arr[(i + 2)];
    }
    return 0.0F;
  }
  
  public YogaDirection getLayoutDirection()
  {
    if (this.arr != null) {}
    for (int i = (int)this.arr[5];; i = this.mLayoutDirection) {
      return YogaDirection.fromInt(i);
    }
  }
  
  public float getLayoutHeight()
  {
    if (this.arr != null) {
      return this.arr[2];
    }
    return 0.0F;
  }
  
  public float getLayoutMargin(YogaEdge paramYogaEdge)
  {
    if ((this.arr != null) && (((int)this.arr[0] & 0x1) == 1))
    {
      switch (1.$SwitchMap$com$facebook$yoga$YogaEdge[paramYogaEdge.ordinal()])
      {
      default: 
        throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
      case 1: 
        return this.arr[6];
      case 2: 
        return this.arr[7];
      case 3: 
        return this.arr[8];
      case 4: 
        return this.arr[9];
      case 5: 
        if (getLayoutDirection() == YogaDirection.RTL) {
          return this.arr[8];
        }
        return this.arr[6];
      }
      if (getLayoutDirection() == YogaDirection.RTL) {
        return this.arr[6];
      }
      return this.arr[8];
    }
    return 0.0F;
  }
  
  public float getLayoutPadding(YogaEdge paramYogaEdge)
  {
    int i = 0;
    if ((this.arr != null) && (((int)this.arr[0] & 0x2) == 2))
    {
      if (((int)this.arr[0] & 0x1) == 1) {}
      for (;;)
      {
        i = 10 - i;
        switch (1.$SwitchMap$com$facebook$yoga$YogaEdge[paramYogaEdge.ordinal()])
        {
        default: 
          throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
          i = 4;
        }
      }
      return this.arr[i];
      return this.arr[(i + 1)];
      return this.arr[(i + 2)];
      return this.arr[(i + 3)];
      if (getLayoutDirection() == YogaDirection.RTL) {
        return this.arr[(i + 2)];
      }
      return this.arr[i];
      if (getLayoutDirection() == YogaDirection.RTL) {
        return this.arr[i];
      }
      return this.arr[(i + 2)];
    }
    return 0.0F;
  }
  
  public float getLayoutWidth()
  {
    if (this.arr != null) {
      return this.arr[1];
    }
    return 0.0F;
  }
  
  public float getLayoutX()
  {
    if (this.arr != null) {
      return this.arr[3];
    }
    return 0.0F;
  }
  
  public float getLayoutY()
  {
    if (this.arr != null) {
      return this.arr[4];
    }
    return 0.0F;
  }
  
  public YogaValue getMargin(YogaEdge paramYogaEdge)
  {
    return valueFromLong(YogaNative.jni_YGNodeStyleGetMarginJNI(this.mNativePointer, paramYogaEdge.intValue()));
  }
  
  public YogaValue getMaxHeight()
  {
    return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxHeightJNI(this.mNativePointer));
  }
  
  public YogaValue getMaxWidth()
  {
    return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxWidthJNI(this.mNativePointer));
  }
  
  public YogaValue getMinHeight()
  {
    return valueFromLong(YogaNative.jni_YGNodeStyleGetMinHeightJNI(this.mNativePointer));
  }
  
  public YogaValue getMinWidth()
  {
    return valueFromLong(YogaNative.jni_YGNodeStyleGetMinWidthJNI(this.mNativePointer));
  }
  
  public YogaOverflow getOverflow()
  {
    return YogaOverflow.fromInt(YogaNative.jni_YGNodeStyleGetOverflowJNI(this.mNativePointer));
  }
  
  public YogaNodeJNIBase getOwner()
  {
    return this.mOwner;
  }
  
  public YogaValue getPadding(YogaEdge paramYogaEdge)
  {
    return valueFromLong(YogaNative.jni_YGNodeStyleGetPaddingJNI(this.mNativePointer, paramYogaEdge.intValue()));
  }
  
  @Deprecated
  public YogaNodeJNIBase getParent()
  {
    return getOwner();
  }
  
  public YogaValue getPosition(YogaEdge paramYogaEdge)
  {
    return valueFromLong(YogaNative.jni_YGNodeStyleGetPositionJNI(this.mNativePointer, paramYogaEdge.intValue()));
  }
  
  public YogaPositionType getPositionType()
  {
    return YogaPositionType.fromInt(YogaNative.jni_YGNodeStyleGetPositionTypeJNI(this.mNativePointer));
  }
  
  public YogaDirection getStyleDirection()
  {
    return YogaDirection.fromInt(YogaNative.jni_YGNodeStyleGetDirectionJNI(this.mNativePointer));
  }
  
  public YogaValue getWidth()
  {
    return valueFromLong(YogaNative.jni_YGNodeStyleGetWidthJNI(this.mNativePointer));
  }
  
  public YogaWrap getWrap()
  {
    return YogaWrap.fromInt(YogaNative.jni_YGNodeStyleGetFlexWrapJNI(this.mNativePointer));
  }
  
  public boolean hasNewLayout()
  {
    boolean bool = false;
    if (this.arr != null)
    {
      if (((int)this.arr[0] & 0x10) == 16) {
        bool = true;
      }
      return bool;
    }
    return this.mHasNewLayout;
  }
  
  public int indexOf(YogaNode paramYogaNode)
  {
    if (this.mChildren == null) {
      return -1;
    }
    return this.mChildren.indexOf(paramYogaNode);
  }
  
  public boolean isBaselineDefined()
  {
    return this.mBaselineFunction != null;
  }
  
  public boolean isDirty()
  {
    return YogaNative.jni_YGNodeIsDirtyJNI(this.mNativePointer);
  }
  
  public boolean isMeasureDefined()
  {
    return this.mMeasureFunction != null;
  }
  
  public boolean isReferenceBaseline()
  {
    return YogaNative.jni_YGNodeIsReferenceBaselineJNI(this.mNativePointer);
  }
  
  public void markLayoutSeen()
  {
    if (this.arr != null) {
      this.arr[0] = ((int)this.arr[0] & 0xFFFFFFEF);
    }
    this.mHasNewLayout = false;
  }
  
  public final long measure(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2)
  {
    if (!isMeasureDefined()) {
      throw new RuntimeException("Measure function isn't defined!");
    }
    return this.mMeasureFunction.measure(this, paramFloat1, YogaMeasureMode.fromInt(paramInt1), paramFloat2, YogaMeasureMode.fromInt(paramInt2));
  }
  
  public void print()
  {
    YogaNative.jni_YGNodePrintJNI(this.mNativePointer);
  }
  
  public YogaNodeJNIBase removeChildAt(int paramInt)
  {
    if (this.mChildren == null) {
      throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
    }
    YogaNodeJNIBase localYogaNodeJNIBase = (YogaNodeJNIBase)this.mChildren.remove(paramInt);
    localYogaNodeJNIBase.mOwner = null;
    YogaNative.jni_YGNodeRemoveChildJNI(this.mNativePointer, localYogaNodeJNIBase.mNativePointer);
    return localYogaNodeJNIBase;
  }
  
  public void reset()
  {
    this.mMeasureFunction = null;
    this.mBaselineFunction = null;
    this.mData = null;
    this.arr = null;
    this.mHasNewLayout = true;
    this.mLayoutDirection = 0;
    YogaNative.jni_YGNodeResetJNI(this.mNativePointer);
  }
  
  public void setAlignContent(YogaAlign paramYogaAlign)
  {
    YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.mNativePointer, paramYogaAlign.intValue());
  }
  
  public void setAlignItems(YogaAlign paramYogaAlign)
  {
    YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.mNativePointer, paramYogaAlign.intValue());
  }
  
  public void setAlignSelf(YogaAlign paramYogaAlign)
  {
    YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.mNativePointer, paramYogaAlign.intValue());
  }
  
  public void setAspectRatio(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.mNativePointer, paramFloat);
  }
  
  public void setBaselineFunction(YogaBaselineFunction paramYogaBaselineFunction)
  {
    this.mBaselineFunction = paramYogaBaselineFunction;
    long l = this.mNativePointer;
    if (paramYogaBaselineFunction != null) {}
    for (boolean bool = true;; bool = false)
    {
      YogaNative.jni_YGNodeSetHasBaselineFuncJNI(l, bool);
      return;
    }
  }
  
  public void setBorder(YogaEdge paramYogaEdge, float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetBorderJNI(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }
  
  public void setData(Object paramObject)
  {
    this.mData = paramObject;
  }
  
  public void setDirection(YogaDirection paramYogaDirection)
  {
    YogaNative.jni_YGNodeStyleSetDirectionJNI(this.mNativePointer, paramYogaDirection.intValue());
  }
  
  public void setDisplay(YogaDisplay paramYogaDisplay)
  {
    YogaNative.jni_YGNodeStyleSetDisplayJNI(this.mNativePointer, paramYogaDisplay.intValue());
  }
  
  public void setFlex(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetFlexJNI(this.mNativePointer, paramFloat);
  }
  
  public void setFlexBasis(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.mNativePointer, paramFloat);
  }
  
  public void setFlexBasisAuto()
  {
    YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.mNativePointer);
  }
  
  public void setFlexBasisPercent(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetFlexBasisPercentJNI(this.mNativePointer, paramFloat);
  }
  
  public void setFlexDirection(YogaFlexDirection paramYogaFlexDirection)
  {
    YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.mNativePointer, paramYogaFlexDirection.intValue());
  }
  
  public void setFlexGrow(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.mNativePointer, paramFloat);
  }
  
  public void setFlexShrink(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.mNativePointer, paramFloat);
  }
  
  public void setHeight(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetHeightJNI(this.mNativePointer, paramFloat);
  }
  
  public void setHeightAuto()
  {
    YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.mNativePointer);
  }
  
  public void setHeightPercent(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.mNativePointer, paramFloat);
  }
  
  public void setIsReferenceBaseline(boolean paramBoolean)
  {
    YogaNative.jni_YGNodeSetIsReferenceBaselineJNI(this.mNativePointer, paramBoolean);
  }
  
  public void setJustifyContent(YogaJustify paramYogaJustify)
  {
    YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.mNativePointer, paramYogaJustify.intValue());
  }
  
  public void setMargin(YogaEdge paramYogaEdge, float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetMarginJNI(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }
  
  public void setMarginAuto(YogaEdge paramYogaEdge)
  {
    YogaNative.jni_YGNodeStyleSetMarginAutoJNI(this.mNativePointer, paramYogaEdge.intValue());
  }
  
  public void setMarginPercent(YogaEdge paramYogaEdge, float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetMarginPercentJNI(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }
  
  public void setMaxHeight(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.mNativePointer, paramFloat);
  }
  
  public void setMaxHeightPercent(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetMaxHeightPercentJNI(this.mNativePointer, paramFloat);
  }
  
  public void setMaxWidth(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.mNativePointer, paramFloat);
  }
  
  public void setMaxWidthPercent(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetMaxWidthPercentJNI(this.mNativePointer, paramFloat);
  }
  
  public void setMeasureFunction(YogaMeasureFunction paramYogaMeasureFunction)
  {
    this.mMeasureFunction = paramYogaMeasureFunction;
    long l = this.mNativePointer;
    if (paramYogaMeasureFunction != null) {}
    for (boolean bool = true;; bool = false)
    {
      YogaNative.jni_YGNodeSetHasMeasureFuncJNI(l, bool);
      return;
    }
  }
  
  public void setMinHeight(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.mNativePointer, paramFloat);
  }
  
  public void setMinHeightPercent(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetMinHeightPercentJNI(this.mNativePointer, paramFloat);
  }
  
  public void setMinWidth(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.mNativePointer, paramFloat);
  }
  
  public void setMinWidthPercent(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetMinWidthPercentJNI(this.mNativePointer, paramFloat);
  }
  
  public void setOverflow(YogaOverflow paramYogaOverflow)
  {
    YogaNative.jni_YGNodeStyleSetOverflowJNI(this.mNativePointer, paramYogaOverflow.intValue());
  }
  
  public void setPadding(YogaEdge paramYogaEdge, float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetPaddingJNI(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }
  
  public void setPaddingPercent(YogaEdge paramYogaEdge, float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetPaddingPercentJNI(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }
  
  public void setPosition(YogaEdge paramYogaEdge, float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetPositionJNI(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }
  
  public void setPositionPercent(YogaEdge paramYogaEdge, float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetPositionPercentJNI(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }
  
  public void setPositionType(YogaPositionType paramYogaPositionType)
  {
    YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.mNativePointer, paramYogaPositionType.intValue());
  }
  
  public void setWidth(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetWidthJNI(this.mNativePointer, paramFloat);
  }
  
  public void setWidthAuto()
  {
    YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.mNativePointer);
  }
  
  public void setWidthPercent(float paramFloat)
  {
    YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.mNativePointer, paramFloat);
  }
  
  public void setWrap(YogaWrap paramYogaWrap)
  {
    YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.mNativePointer, paramYogaWrap.intValue());
  }
  
  public void swapChildAt(YogaNode paramYogaNode, int paramInt)
  {
    paramYogaNode = (YogaNodeJNIBase)paramYogaNode;
    this.mChildren.remove(paramInt);
    this.mChildren.add(paramInt, paramYogaNode);
    paramYogaNode.mOwner = this;
    YogaNative.jni_YGNodeSwapChildJNI(this.mNativePointer, paramYogaNode.mNativePointer, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.facebook.yoga.YogaNodeJNIBase
 * JD-Core Version:    0.7.0.1
 */