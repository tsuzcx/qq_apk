package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class YogaNode
  implements Cloneable
{
  private static final int BORDER = 4;
  private static final int MARGIN = 1;
  private static final int PADDING = 2;
  private YogaBaselineFunction mBaselineFunction;
  private float mBorderBottom;
  private float mBorderLeft;
  private float mBorderRight;
  private float mBorderTop;
  private List<YogaNode> mChildren;
  private Object mData;
  private int mEdgeSetFlag;
  private boolean mHasNewLayout;
  private boolean mHasSetPosition;
  private float mHeight;
  private int mLayoutDirection;
  private float mLeft;
  private float mMarginBottom;
  private float mMarginLeft;
  private float mMarginRight;
  private float mMarginTop;
  private YogaMeasureFunction mMeasureFunction;
  private long mNativePointer;
  private float mPaddingBottom;
  private float mPaddingLeft;
  private float mPaddingRight;
  private float mPaddingTop;
  private YogaNode mParent;
  private float mTop;
  private float mWidth;
  
  public YogaNode()
  {
    AppMethodBeat.i(144082);
    this.mEdgeSetFlag = 0;
    this.mHasSetPosition = false;
    this.mWidth = 1.0E+021F;
    this.mHeight = 1.0E+021F;
    this.mTop = 1.0E+021F;
    this.mLeft = 1.0E+021F;
    this.mMarginLeft = 0.0F;
    this.mMarginTop = 0.0F;
    this.mMarginRight = 0.0F;
    this.mMarginBottom = 0.0F;
    this.mPaddingLeft = 0.0F;
    this.mPaddingTop = 0.0F;
    this.mPaddingRight = 0.0F;
    this.mPaddingBottom = 0.0F;
    this.mBorderLeft = 0.0F;
    this.mBorderTop = 0.0F;
    this.mBorderRight = 0.0F;
    this.mBorderBottom = 0.0F;
    this.mLayoutDirection = 0;
    this.mHasNewLayout = true;
    this.mNativePointer = jni_YGNodeNew();
    if (this.mNativePointer == 0L)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Failed to allocate native memory");
      AppMethodBeat.o(144082);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(144082);
  }
  
  public YogaNode(YogaConfig paramYogaConfig)
  {
    AppMethodBeat.i(144083);
    this.mEdgeSetFlag = 0;
    this.mHasSetPosition = false;
    this.mWidth = 1.0E+021F;
    this.mHeight = 1.0E+021F;
    this.mTop = 1.0E+021F;
    this.mLeft = 1.0E+021F;
    this.mMarginLeft = 0.0F;
    this.mMarginTop = 0.0F;
    this.mMarginRight = 0.0F;
    this.mMarginBottom = 0.0F;
    this.mPaddingLeft = 0.0F;
    this.mPaddingTop = 0.0F;
    this.mPaddingRight = 0.0F;
    this.mPaddingBottom = 0.0F;
    this.mBorderLeft = 0.0F;
    this.mBorderTop = 0.0F;
    this.mBorderRight = 0.0F;
    this.mBorderBottom = 0.0F;
    this.mLayoutDirection = 0;
    this.mHasNewLayout = true;
    this.mNativePointer = jni_YGNodeNewWithConfig(paramYogaConfig.mNativePointer);
    if (this.mNativePointer == 0L)
    {
      paramYogaConfig = new IllegalStateException("Failed to allocate native memory");
      AppMethodBeat.o(144083);
      throw paramYogaConfig;
    }
    AppMethodBeat.o(144083);
  }
  
  private native void jni_YGNodeCalculateLayout(long paramLong, float paramFloat1, float paramFloat2);
  
  private native long jni_YGNodeClone(long paramLong, Object paramObject);
  
  private native void jni_YGNodeCopyStyle(long paramLong1, long paramLong2);
  
  private native void jni_YGNodeFree(long paramLong);
  
  static native int jni_YGNodeGetInstanceCount();
  
  private native void jni_YGNodeInsertChild(long paramLong1, long paramLong2, int paramInt);
  
  private native boolean jni_YGNodeIsDirty(long paramLong);
  
  private native void jni_YGNodeMarkDirty(long paramLong);
  
  private native void jni_YGNodeMarkDirtyAndPropogateToDescendants(long paramLong);
  
  private native long jni_YGNodeNew();
  
  private native long jni_YGNodeNewWithConfig(long paramLong);
  
  private native void jni_YGNodePrint(long paramLong);
  
  private native void jni_YGNodeRemoveChild(long paramLong1, long paramLong2);
  
  private native void jni_YGNodeReset(long paramLong);
  
  private native void jni_YGNodeSetHasBaselineFunc(long paramLong, boolean paramBoolean);
  
  private native void jni_YGNodeSetHasMeasureFunc(long paramLong, boolean paramBoolean);
  
  private native int jni_YGNodeStyleGetAlignContent(long paramLong);
  
  private native int jni_YGNodeStyleGetAlignItems(long paramLong);
  
  private native int jni_YGNodeStyleGetAlignSelf(long paramLong);
  
  private native float jni_YGNodeStyleGetAspectRatio(long paramLong);
  
  private native float jni_YGNodeStyleGetBorder(long paramLong, int paramInt);
  
  private native int jni_YGNodeStyleGetDirection(long paramLong);
  
  private native int jni_YGNodeStyleGetDisplay(long paramLong);
  
  private native Object jni_YGNodeStyleGetFlexBasis(long paramLong);
  
  private native int jni_YGNodeStyleGetFlexDirection(long paramLong);
  
  private native float jni_YGNodeStyleGetFlexGrow(long paramLong);
  
  private native float jni_YGNodeStyleGetFlexShrink(long paramLong);
  
  private native Object jni_YGNodeStyleGetHeight(long paramLong);
  
  private native int jni_YGNodeStyleGetJustifyContent(long paramLong);
  
  private native Object jni_YGNodeStyleGetMargin(long paramLong, int paramInt);
  
  private native Object jni_YGNodeStyleGetMaxHeight(long paramLong);
  
  private native Object jni_YGNodeStyleGetMaxWidth(long paramLong);
  
  private native Object jni_YGNodeStyleGetMinHeight(long paramLong);
  
  private native Object jni_YGNodeStyleGetMinWidth(long paramLong);
  
  private native int jni_YGNodeStyleGetOverflow(long paramLong);
  
  private native Object jni_YGNodeStyleGetPadding(long paramLong, int paramInt);
  
  private native Object jni_YGNodeStyleGetPosition(long paramLong, int paramInt);
  
  private native int jni_YGNodeStyleGetPositionType(long paramLong);
  
  private native Object jni_YGNodeStyleGetWidth(long paramLong);
  
  private native void jni_YGNodeStyleSetAlignContent(long paramLong, int paramInt);
  
  private native void jni_YGNodeStyleSetAlignItems(long paramLong, int paramInt);
  
  private native void jni_YGNodeStyleSetAlignSelf(long paramLong, int paramInt);
  
  private native void jni_YGNodeStyleSetAspectRatio(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetBorder(long paramLong, int paramInt, float paramFloat);
  
  private native void jni_YGNodeStyleSetDirection(long paramLong, int paramInt);
  
  private native void jni_YGNodeStyleSetDisplay(long paramLong, int paramInt);
  
  private native void jni_YGNodeStyleSetFlex(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetFlexBasis(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetFlexBasisAuto(long paramLong);
  
  private native void jni_YGNodeStyleSetFlexBasisPercent(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetFlexDirection(long paramLong, int paramInt);
  
  private native void jni_YGNodeStyleSetFlexGrow(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetFlexShrink(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetFlexWrap(long paramLong, int paramInt);
  
  private native void jni_YGNodeStyleSetHeight(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetHeightAuto(long paramLong);
  
  private native void jni_YGNodeStyleSetHeightPercent(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetJustifyContent(long paramLong, int paramInt);
  
  private native void jni_YGNodeStyleSetMargin(long paramLong, int paramInt, float paramFloat);
  
  private native void jni_YGNodeStyleSetMarginAuto(long paramLong, int paramInt);
  
  private native void jni_YGNodeStyleSetMarginPercent(long paramLong, int paramInt, float paramFloat);
  
  private native void jni_YGNodeStyleSetMaxHeight(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetMaxHeightPercent(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetMaxWidth(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetMaxWidthPercent(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetMinHeight(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetMinHeightPercent(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetMinWidth(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetMinWidthPercent(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetOverflow(long paramLong, int paramInt);
  
  private native void jni_YGNodeStyleSetPadding(long paramLong, int paramInt, float paramFloat);
  
  private native void jni_YGNodeStyleSetPaddingPercent(long paramLong, int paramInt, float paramFloat);
  
  private native void jni_YGNodeStyleSetPosition(long paramLong, int paramInt, float paramFloat);
  
  private native void jni_YGNodeStyleSetPositionPercent(long paramLong, int paramInt, float paramFloat);
  
  private native void jni_YGNodeStyleSetPositionType(long paramLong, int paramInt);
  
  private native void jni_YGNodeStyleSetWidth(long paramLong, float paramFloat);
  
  private native void jni_YGNodeStyleSetWidthAuto(long paramLong);
  
  private native void jni_YGNodeStyleSetWidthPercent(long paramLong, float paramFloat);
  
  public void addChildAt(YogaNode paramYogaNode, int paramInt)
  {
    AppMethodBeat.i(144088);
    if (paramYogaNode.mParent != null)
    {
      paramYogaNode = new IllegalStateException("Child already has a parent, it must be removed first.");
      AppMethodBeat.o(144088);
      throw paramYogaNode;
    }
    if (this.mChildren == null) {
      this.mChildren = new ArrayList(4);
    }
    this.mChildren.add(paramInt, paramYogaNode);
    paramYogaNode.mParent = this;
    jni_YGNodeInsertChild(this.mNativePointer, paramYogaNode.mNativePointer, paramInt);
    AppMethodBeat.o(144088);
  }
  
  public final float baseline(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(144166);
    paramFloat1 = this.mBaselineFunction.baseline(this, paramFloat1, paramFloat2);
    AppMethodBeat.o(144166);
    return paramFloat1;
  }
  
  public void calculateLayout(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(144092);
    jni_YGNodeCalculateLayout(this.mNativePointer, paramFloat1, paramFloat2);
    AppMethodBeat.o(144092);
  }
  
  public YogaNode clone()
  {
    AppMethodBeat.i(144089);
    YogaNode localYogaNode = (YogaNode)super.clone();
    localYogaNode.mNativePointer = jni_YGNodeClone(this.mNativePointer, localYogaNode);
    if (this.mChildren != null) {}
    for (List localList = (List)((ArrayList)this.mChildren).clone();; localList = null)
    {
      localYogaNode.mChildren = localList;
      AppMethodBeat.o(144089);
      return localYogaNode;
    }
  }
  
  public void copyStyle(YogaNode paramYogaNode)
  {
    AppMethodBeat.i(144096);
    jni_YGNodeCopyStyle(this.mNativePointer, paramYogaNode.mNativePointer);
    AppMethodBeat.o(144096);
  }
  
  public void dirty()
  {
    AppMethodBeat.i(144093);
    jni_YGNodeMarkDirty(this.mNativePointer);
    AppMethodBeat.o(144093);
  }
  
  public void dirtyAllDescendants()
  {
    AppMethodBeat.i(144094);
    jni_YGNodeMarkDirtyAndPropogateToDescendants(this.mNativePointer);
    AppMethodBeat.o(144094);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(144084);
    try
    {
      jni_YGNodeFree(this.mNativePointer);
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(144084);
    }
  }
  
  public YogaAlign getAlignContent()
  {
    AppMethodBeat.i(144107);
    YogaAlign localYogaAlign = YogaAlign.fromInt(jni_YGNodeStyleGetAlignContent(this.mNativePointer));
    AppMethodBeat.o(144107);
    return localYogaAlign;
  }
  
  public YogaAlign getAlignItems()
  {
    AppMethodBeat.i(144103);
    YogaAlign localYogaAlign = YogaAlign.fromInt(jni_YGNodeStyleGetAlignItems(this.mNativePointer));
    AppMethodBeat.o(144103);
    return localYogaAlign;
  }
  
  public YogaAlign getAlignSelf()
  {
    AppMethodBeat.i(144105);
    YogaAlign localYogaAlign = YogaAlign.fromInt(jni_YGNodeStyleGetAlignSelf(this.mNativePointer));
    AppMethodBeat.o(144105);
    return localYogaAlign;
  }
  
  public float getAspectRatio()
  {
    AppMethodBeat.i(144157);
    float f = jni_YGNodeStyleGetAspectRatio(this.mNativePointer);
    AppMethodBeat.o(144157);
    return f;
  }
  
  public float getBorder(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(144132);
    if ((this.mEdgeSetFlag & 0x4) != 4)
    {
      AppMethodBeat.o(144132);
      return 1.0E+021F;
    }
    float f = jni_YGNodeStyleGetBorder(this.mNativePointer, paramYogaEdge.intValue());
    AppMethodBeat.o(144132);
    return f;
  }
  
  public YogaNode getChildAt(int paramInt)
  {
    AppMethodBeat.i(144087);
    YogaNode localYogaNode = (YogaNode)this.mChildren.get(paramInt);
    AppMethodBeat.o(144087);
    return localYogaNode;
  }
  
  public int getChildCount()
  {
    AppMethodBeat.i(144086);
    if (this.mChildren == null)
    {
      AppMethodBeat.o(144086);
      return 0;
    }
    int i = this.mChildren.size();
    AppMethodBeat.o(144086);
    return i;
  }
  
  public Object getData()
  {
    return this.mData;
  }
  
  public YogaDisplay getDisplay()
  {
    AppMethodBeat.i(144114);
    YogaDisplay localYogaDisplay = YogaDisplay.fromInt(jni_YGNodeStyleGetDisplay(this.mNativePointer));
    AppMethodBeat.o(144114);
    return localYogaDisplay;
  }
  
  public YogaValue getFlexBasis()
  {
    AppMethodBeat.i(144121);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetFlexBasis(this.mNativePointer);
    AppMethodBeat.o(144121);
    return localYogaValue;
  }
  
  public YogaFlexDirection getFlexDirection()
  {
    AppMethodBeat.i(144099);
    YogaFlexDirection localYogaFlexDirection = YogaFlexDirection.fromInt(jni_YGNodeStyleGetFlexDirection(this.mNativePointer));
    AppMethodBeat.o(144099);
    return localYogaFlexDirection;
  }
  
  public float getFlexGrow()
  {
    AppMethodBeat.i(144117);
    float f = jni_YGNodeStyleGetFlexGrow(this.mNativePointer);
    AppMethodBeat.o(144117);
    return f;
  }
  
  public float getFlexShrink()
  {
    AppMethodBeat.i(144119);
    float f = jni_YGNodeStyleGetFlexShrink(this.mNativePointer);
    AppMethodBeat.o(144119);
    return f;
  }
  
  public YogaValue getHeight()
  {
    AppMethodBeat.i(144141);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetHeight(this.mNativePointer);
    AppMethodBeat.o(144141);
    return localYogaValue;
  }
  
  public YogaJustify getJustifyContent()
  {
    AppMethodBeat.i(144101);
    YogaJustify localYogaJustify = YogaJustify.fromInt(jni_YGNodeStyleGetJustifyContent(this.mNativePointer));
    AppMethodBeat.o(144101);
    return localYogaJustify;
  }
  
  public float getLayoutBorder(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(144161);
    switch (YogaNode.1.$SwitchMap$com$facebook$yoga$YogaEdge[paramYogaEdge.ordinal()])
    {
    default: 
      paramYogaEdge = new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
      AppMethodBeat.o(144161);
      throw paramYogaEdge;
    case 1: 
      f = this.mBorderLeft;
      AppMethodBeat.o(144161);
      return f;
    case 2: 
      f = this.mBorderTop;
      AppMethodBeat.o(144161);
      return f;
    case 3: 
      f = this.mBorderRight;
      AppMethodBeat.o(144161);
      return f;
    case 4: 
      f = this.mBorderBottom;
      AppMethodBeat.o(144161);
      return f;
    case 5: 
      if (getLayoutDirection() == YogaDirection.RTL)
      {
        f = this.mBorderRight;
        AppMethodBeat.o(144161);
        return f;
      }
      f = this.mBorderLeft;
      AppMethodBeat.o(144161);
      return f;
    }
    if (getLayoutDirection() == YogaDirection.RTL)
    {
      f = this.mBorderLeft;
      AppMethodBeat.o(144161);
      return f;
    }
    float f = this.mBorderRight;
    AppMethodBeat.o(144161);
    return f;
  }
  
  public YogaDirection getLayoutDirection()
  {
    AppMethodBeat.i(144162);
    YogaDirection localYogaDirection = YogaDirection.fromInt(this.mLayoutDirection);
    AppMethodBeat.o(144162);
    return localYogaDirection;
  }
  
  public float getLayoutHeight()
  {
    return this.mHeight;
  }
  
  public float getLayoutMargin(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(144159);
    switch (YogaNode.1.$SwitchMap$com$facebook$yoga$YogaEdge[paramYogaEdge.ordinal()])
    {
    default: 
      paramYogaEdge = new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
      AppMethodBeat.o(144159);
      throw paramYogaEdge;
    case 1: 
      f = this.mMarginLeft;
      AppMethodBeat.o(144159);
      return f;
    case 2: 
      f = this.mMarginTop;
      AppMethodBeat.o(144159);
      return f;
    case 3: 
      f = this.mMarginRight;
      AppMethodBeat.o(144159);
      return f;
    case 4: 
      f = this.mMarginBottom;
      AppMethodBeat.o(144159);
      return f;
    case 5: 
      if (getLayoutDirection() == YogaDirection.RTL)
      {
        f = this.mMarginRight;
        AppMethodBeat.o(144159);
        return f;
      }
      f = this.mMarginLeft;
      AppMethodBeat.o(144159);
      return f;
    }
    if (getLayoutDirection() == YogaDirection.RTL)
    {
      f = this.mMarginLeft;
      AppMethodBeat.o(144159);
      return f;
    }
    float f = this.mMarginRight;
    AppMethodBeat.o(144159);
    return f;
  }
  
  public float getLayoutPadding(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(144160);
    switch (YogaNode.1.$SwitchMap$com$facebook$yoga$YogaEdge[paramYogaEdge.ordinal()])
    {
    default: 
      paramYogaEdge = new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
      AppMethodBeat.o(144160);
      throw paramYogaEdge;
    case 1: 
      f = this.mPaddingLeft;
      AppMethodBeat.o(144160);
      return f;
    case 2: 
      f = this.mPaddingTop;
      AppMethodBeat.o(144160);
      return f;
    case 3: 
      f = this.mPaddingRight;
      AppMethodBeat.o(144160);
      return f;
    case 4: 
      f = this.mPaddingBottom;
      AppMethodBeat.o(144160);
      return f;
    case 5: 
      if (getLayoutDirection() == YogaDirection.RTL)
      {
        f = this.mPaddingRight;
        AppMethodBeat.o(144160);
        return f;
      }
      f = this.mPaddingLeft;
      AppMethodBeat.o(144160);
      return f;
    }
    if (getLayoutDirection() == YogaDirection.RTL)
    {
      f = this.mPaddingLeft;
      AppMethodBeat.o(144160);
      return f;
    }
    float f = this.mPaddingRight;
    AppMethodBeat.o(144160);
    return f;
  }
  
  public float getLayoutWidth()
  {
    return this.mWidth;
  }
  
  public float getLayoutX()
  {
    return this.mLeft;
  }
  
  public float getLayoutY()
  {
    return this.mTop;
  }
  
  public YogaValue getMargin(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(144125);
    if ((this.mEdgeSetFlag & 0x1) != 1)
    {
      paramYogaEdge = YogaValue.UNDEFINED;
      AppMethodBeat.o(144125);
      return paramYogaEdge;
    }
    paramYogaEdge = (YogaValue)jni_YGNodeStyleGetMargin(this.mNativePointer, paramYogaEdge.intValue());
    AppMethodBeat.o(144125);
    return paramYogaEdge;
  }
  
  public YogaValue getMaxHeight()
  {
    AppMethodBeat.i(144154);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetMaxHeight(this.mNativePointer);
    AppMethodBeat.o(144154);
    return localYogaValue;
  }
  
  public YogaValue getMaxWidth()
  {
    AppMethodBeat.i(144151);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetMaxWidth(this.mNativePointer);
    AppMethodBeat.o(144151);
    return localYogaValue;
  }
  
  public YogaValue getMinHeight()
  {
    AppMethodBeat.i(144148);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetMinHeight(this.mNativePointer);
    AppMethodBeat.o(144148);
    return localYogaValue;
  }
  
  public YogaValue getMinWidth()
  {
    AppMethodBeat.i(144145);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetMinWidth(this.mNativePointer);
    AppMethodBeat.o(144145);
    return localYogaValue;
  }
  
  public YogaOverflow getOverflow()
  {
    AppMethodBeat.i(144112);
    YogaOverflow localYogaOverflow = YogaOverflow.fromInt(jni_YGNodeStyleGetOverflow(this.mNativePointer));
    AppMethodBeat.o(144112);
    return localYogaOverflow;
  }
  
  public YogaValue getPadding(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(144129);
    if ((this.mEdgeSetFlag & 0x2) != 2)
    {
      paramYogaEdge = YogaValue.UNDEFINED;
      AppMethodBeat.o(144129);
      return paramYogaEdge;
    }
    paramYogaEdge = (YogaValue)jni_YGNodeStyleGetPadding(this.mNativePointer, paramYogaEdge.intValue());
    AppMethodBeat.o(144129);
    return paramYogaEdge;
  }
  
  public YogaNode getParent()
  {
    return this.mParent;
  }
  
  public YogaValue getPosition(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(144134);
    if (!this.mHasSetPosition)
    {
      paramYogaEdge = YogaValue.UNDEFINED;
      AppMethodBeat.o(144134);
      return paramYogaEdge;
    }
    paramYogaEdge = (YogaValue)jni_YGNodeStyleGetPosition(this.mNativePointer, paramYogaEdge.intValue());
    AppMethodBeat.o(144134);
    return paramYogaEdge;
  }
  
  public YogaPositionType getPositionType()
  {
    AppMethodBeat.i(144109);
    YogaPositionType localYogaPositionType = YogaPositionType.fromInt(jni_YGNodeStyleGetPositionType(this.mNativePointer));
    AppMethodBeat.o(144109);
    return localYogaPositionType;
  }
  
  public YogaDirection getStyleDirection()
  {
    AppMethodBeat.i(144097);
    YogaDirection localYogaDirection = YogaDirection.fromInt(jni_YGNodeStyleGetDirection(this.mNativePointer));
    AppMethodBeat.o(144097);
    return localYogaDirection;
  }
  
  public YogaValue getWidth()
  {
    AppMethodBeat.i(144137);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetWidth(this.mNativePointer);
    AppMethodBeat.o(144137);
    return localYogaValue;
  }
  
  public boolean hasNewLayout()
  {
    return this.mHasNewLayout;
  }
  
  public int indexOf(YogaNode paramYogaNode)
  {
    AppMethodBeat.i(144091);
    if (this.mChildren == null)
    {
      AppMethodBeat.o(144091);
      return -1;
    }
    int i = this.mChildren.indexOf(paramYogaNode);
    AppMethodBeat.o(144091);
    return i;
  }
  
  public boolean isDirty()
  {
    AppMethodBeat.i(144095);
    boolean bool = jni_YGNodeIsDirty(this.mNativePointer);
    AppMethodBeat.o(144095);
    return bool;
  }
  
  public boolean isMeasureDefined()
  {
    return this.mMeasureFunction != null;
  }
  
  public void markLayoutSeen()
  {
    this.mHasNewLayout = false;
  }
  
  public final long measure(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2)
  {
    AppMethodBeat.i(144164);
    if (!isMeasureDefined())
    {
      RuntimeException localRuntimeException = new RuntimeException("Measure function isn't defined!");
      AppMethodBeat.o(144164);
      throw localRuntimeException;
    }
    long l = this.mMeasureFunction.measure(this, paramFloat1, YogaMeasureMode.fromInt(paramInt1), paramFloat2, YogaMeasureMode.fromInt(paramInt2));
    AppMethodBeat.o(144164);
    return l;
  }
  
  public void print()
  {
    AppMethodBeat.i(144167);
    jni_YGNodePrint(this.mNativePointer);
    AppMethodBeat.o(144167);
  }
  
  public YogaNode removeChildAt(int paramInt)
  {
    AppMethodBeat.i(144090);
    YogaNode localYogaNode = (YogaNode)this.mChildren.remove(paramInt);
    localYogaNode.mParent = null;
    jni_YGNodeRemoveChild(this.mNativePointer, localYogaNode.mNativePointer);
    AppMethodBeat.o(144090);
    return localYogaNode;
  }
  
  public void reset()
  {
    AppMethodBeat.i(144085);
    this.mEdgeSetFlag = 0;
    this.mHasSetPosition = false;
    this.mHasNewLayout = true;
    this.mWidth = 1.0E+021F;
    this.mHeight = 1.0E+021F;
    this.mTop = 1.0E+021F;
    this.mLeft = 1.0E+021F;
    this.mMarginLeft = 0.0F;
    this.mMarginTop = 0.0F;
    this.mMarginRight = 0.0F;
    this.mMarginBottom = 0.0F;
    this.mPaddingLeft = 0.0F;
    this.mPaddingTop = 0.0F;
    this.mPaddingRight = 0.0F;
    this.mPaddingBottom = 0.0F;
    this.mBorderLeft = 0.0F;
    this.mBorderTop = 0.0F;
    this.mBorderRight = 0.0F;
    this.mBorderBottom = 0.0F;
    this.mLayoutDirection = 0;
    this.mMeasureFunction = null;
    this.mBaselineFunction = null;
    this.mData = null;
    jni_YGNodeReset(this.mNativePointer);
    AppMethodBeat.o(144085);
  }
  
  public void setAlignContent(YogaAlign paramYogaAlign)
  {
    AppMethodBeat.i(144108);
    jni_YGNodeStyleSetAlignContent(this.mNativePointer, paramYogaAlign.intValue());
    AppMethodBeat.o(144108);
  }
  
  public void setAlignItems(YogaAlign paramYogaAlign)
  {
    AppMethodBeat.i(144104);
    jni_YGNodeStyleSetAlignItems(this.mNativePointer, paramYogaAlign.intValue());
    AppMethodBeat.o(144104);
  }
  
  public void setAlignSelf(YogaAlign paramYogaAlign)
  {
    AppMethodBeat.i(144106);
    jni_YGNodeStyleSetAlignSelf(this.mNativePointer, paramYogaAlign.intValue());
    AppMethodBeat.o(144106);
  }
  
  public void setAspectRatio(float paramFloat)
  {
    AppMethodBeat.i(144158);
    jni_YGNodeStyleSetAspectRatio(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144158);
  }
  
  public void setBaselineFunction(YogaBaselineFunction paramYogaBaselineFunction)
  {
    AppMethodBeat.i(144165);
    this.mBaselineFunction = paramYogaBaselineFunction;
    long l = this.mNativePointer;
    if (paramYogaBaselineFunction != null) {}
    for (boolean bool = true;; bool = false)
    {
      jni_YGNodeSetHasBaselineFunc(l, bool);
      AppMethodBeat.o(144165);
      return;
    }
  }
  
  public void setBorder(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(144133);
    this.mEdgeSetFlag |= 0x4;
    jni_YGNodeStyleSetBorder(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(144133);
  }
  
  public void setData(Object paramObject)
  {
    this.mData = paramObject;
  }
  
  public void setDirection(YogaDirection paramYogaDirection)
  {
    AppMethodBeat.i(144098);
    jni_YGNodeStyleSetDirection(this.mNativePointer, paramYogaDirection.intValue());
    AppMethodBeat.o(144098);
  }
  
  public void setDisplay(YogaDisplay paramYogaDisplay)
  {
    AppMethodBeat.i(144115);
    jni_YGNodeStyleSetDisplay(this.mNativePointer, paramYogaDisplay.intValue());
    AppMethodBeat.o(144115);
  }
  
  public void setFlex(float paramFloat)
  {
    AppMethodBeat.i(144116);
    jni_YGNodeStyleSetFlex(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144116);
  }
  
  public void setFlexBasis(float paramFloat)
  {
    AppMethodBeat.i(144122);
    jni_YGNodeStyleSetFlexBasis(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144122);
  }
  
  public void setFlexBasisAuto()
  {
    AppMethodBeat.i(144124);
    jni_YGNodeStyleSetFlexBasisAuto(this.mNativePointer);
    AppMethodBeat.o(144124);
  }
  
  public void setFlexBasisPercent(float paramFloat)
  {
    AppMethodBeat.i(144123);
    jni_YGNodeStyleSetFlexBasisPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144123);
  }
  
  public void setFlexDirection(YogaFlexDirection paramYogaFlexDirection)
  {
    AppMethodBeat.i(144100);
    jni_YGNodeStyleSetFlexDirection(this.mNativePointer, paramYogaFlexDirection.intValue());
    AppMethodBeat.o(144100);
  }
  
  public void setFlexGrow(float paramFloat)
  {
    AppMethodBeat.i(144118);
    jni_YGNodeStyleSetFlexGrow(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144118);
  }
  
  public void setFlexShrink(float paramFloat)
  {
    AppMethodBeat.i(144120);
    jni_YGNodeStyleSetFlexShrink(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144120);
  }
  
  public void setHeight(float paramFloat)
  {
    AppMethodBeat.i(144142);
    jni_YGNodeStyleSetHeight(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144142);
  }
  
  public void setHeightAuto()
  {
    AppMethodBeat.i(144144);
    jni_YGNodeStyleSetHeightAuto(this.mNativePointer);
    AppMethodBeat.o(144144);
  }
  
  public void setHeightPercent(float paramFloat)
  {
    AppMethodBeat.i(144143);
    jni_YGNodeStyleSetHeightPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144143);
  }
  
  public void setJustifyContent(YogaJustify paramYogaJustify)
  {
    AppMethodBeat.i(144102);
    jni_YGNodeStyleSetJustifyContent(this.mNativePointer, paramYogaJustify.intValue());
    AppMethodBeat.o(144102);
  }
  
  public void setMargin(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(144126);
    this.mEdgeSetFlag |= 0x1;
    jni_YGNodeStyleSetMargin(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(144126);
  }
  
  public void setMarginAuto(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(144128);
    this.mEdgeSetFlag |= 0x1;
    jni_YGNodeStyleSetMarginAuto(this.mNativePointer, paramYogaEdge.intValue());
    AppMethodBeat.o(144128);
  }
  
  public void setMarginPercent(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(144127);
    this.mEdgeSetFlag |= 0x1;
    jni_YGNodeStyleSetMarginPercent(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(144127);
  }
  
  public void setMaxHeight(float paramFloat)
  {
    AppMethodBeat.i(144155);
    jni_YGNodeStyleSetMaxHeight(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144155);
  }
  
  public void setMaxHeightPercent(float paramFloat)
  {
    AppMethodBeat.i(144156);
    jni_YGNodeStyleSetMaxHeightPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144156);
  }
  
  public void setMaxWidth(float paramFloat)
  {
    AppMethodBeat.i(144152);
    jni_YGNodeStyleSetMaxWidth(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144152);
  }
  
  public void setMaxWidthPercent(float paramFloat)
  {
    AppMethodBeat.i(144153);
    jni_YGNodeStyleSetMaxWidthPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144153);
  }
  
  public void setMeasureFunction(YogaMeasureFunction paramYogaMeasureFunction)
  {
    AppMethodBeat.i(144163);
    this.mMeasureFunction = paramYogaMeasureFunction;
    long l = this.mNativePointer;
    if (paramYogaMeasureFunction != null) {}
    for (boolean bool = true;; bool = false)
    {
      jni_YGNodeSetHasMeasureFunc(l, bool);
      AppMethodBeat.o(144163);
      return;
    }
  }
  
  public void setMinHeight(float paramFloat)
  {
    AppMethodBeat.i(144149);
    jni_YGNodeStyleSetMinHeight(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144149);
  }
  
  public void setMinHeightPercent(float paramFloat)
  {
    AppMethodBeat.i(144150);
    jni_YGNodeStyleSetMinHeightPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144150);
  }
  
  public void setMinWidth(float paramFloat)
  {
    AppMethodBeat.i(144146);
    jni_YGNodeStyleSetMinWidth(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144146);
  }
  
  public void setMinWidthPercent(float paramFloat)
  {
    AppMethodBeat.i(144147);
    jni_YGNodeStyleSetMinWidthPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144147);
  }
  
  public void setOverflow(YogaOverflow paramYogaOverflow)
  {
    AppMethodBeat.i(144113);
    jni_YGNodeStyleSetOverflow(this.mNativePointer, paramYogaOverflow.intValue());
    AppMethodBeat.o(144113);
  }
  
  public void setPadding(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(144130);
    this.mEdgeSetFlag |= 0x2;
    jni_YGNodeStyleSetPadding(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(144130);
  }
  
  public void setPaddingPercent(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(144131);
    this.mEdgeSetFlag |= 0x2;
    jni_YGNodeStyleSetPaddingPercent(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(144131);
  }
  
  public void setPosition(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(144135);
    this.mHasSetPosition = true;
    jni_YGNodeStyleSetPosition(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(144135);
  }
  
  public void setPositionPercent(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(144136);
    this.mHasSetPosition = true;
    jni_YGNodeStyleSetPositionPercent(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(144136);
  }
  
  public void setPositionType(YogaPositionType paramYogaPositionType)
  {
    AppMethodBeat.i(144110);
    jni_YGNodeStyleSetPositionType(this.mNativePointer, paramYogaPositionType.intValue());
    AppMethodBeat.o(144110);
  }
  
  public void setWidth(float paramFloat)
  {
    AppMethodBeat.i(144138);
    jni_YGNodeStyleSetWidth(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144138);
  }
  
  public void setWidthAuto()
  {
    AppMethodBeat.i(144140);
    jni_YGNodeStyleSetWidthAuto(this.mNativePointer);
    AppMethodBeat.o(144140);
  }
  
  public void setWidthPercent(float paramFloat)
  {
    AppMethodBeat.i(144139);
    jni_YGNodeStyleSetWidthPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144139);
  }
  
  public void setWrap(YogaWrap paramYogaWrap)
  {
    AppMethodBeat.i(144111);
    jni_YGNodeStyleSetFlexWrap(this.mNativePointer, paramYogaWrap.intValue());
    AppMethodBeat.o(144111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaNode
 * JD-Core Version:    0.7.0.1
 */