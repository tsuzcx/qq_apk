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
    AppMethodBeat.i(18105);
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
      AppMethodBeat.o(18105);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(18105);
  }
  
  public YogaNode(YogaConfig paramYogaConfig)
  {
    AppMethodBeat.i(18106);
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
      AppMethodBeat.o(18106);
      throw paramYogaConfig;
    }
    AppMethodBeat.o(18106);
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
    AppMethodBeat.i(18111);
    if (paramYogaNode.mParent != null)
    {
      paramYogaNode = new IllegalStateException("Child already has a parent, it must be removed first.");
      AppMethodBeat.o(18111);
      throw paramYogaNode;
    }
    if (this.mChildren == null) {
      this.mChildren = new ArrayList(4);
    }
    this.mChildren.add(paramInt, paramYogaNode);
    paramYogaNode.mParent = this;
    jni_YGNodeInsertChild(this.mNativePointer, paramYogaNode.mNativePointer, paramInt);
    AppMethodBeat.o(18111);
  }
  
  public final float baseline(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(18189);
    paramFloat1 = this.mBaselineFunction.baseline(this, paramFloat1, paramFloat2);
    AppMethodBeat.o(18189);
    return paramFloat1;
  }
  
  public void calculateLayout(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(18115);
    jni_YGNodeCalculateLayout(this.mNativePointer, paramFloat1, paramFloat2);
    AppMethodBeat.o(18115);
  }
  
  public YogaNode clone()
  {
    AppMethodBeat.i(18112);
    YogaNode localYogaNode = (YogaNode)super.clone();
    localYogaNode.mNativePointer = jni_YGNodeClone(this.mNativePointer, localYogaNode);
    if (this.mChildren != null) {}
    for (List localList = (List)((ArrayList)this.mChildren).clone();; localList = null)
    {
      localYogaNode.mChildren = localList;
      AppMethodBeat.o(18112);
      return localYogaNode;
    }
  }
  
  public void copyStyle(YogaNode paramYogaNode)
  {
    AppMethodBeat.i(18119);
    jni_YGNodeCopyStyle(this.mNativePointer, paramYogaNode.mNativePointer);
    AppMethodBeat.o(18119);
  }
  
  public void dirty()
  {
    AppMethodBeat.i(18116);
    jni_YGNodeMarkDirty(this.mNativePointer);
    AppMethodBeat.o(18116);
  }
  
  public void dirtyAllDescendants()
  {
    AppMethodBeat.i(18117);
    jni_YGNodeMarkDirtyAndPropogateToDescendants(this.mNativePointer);
    AppMethodBeat.o(18117);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(18107);
    try
    {
      jni_YGNodeFree(this.mNativePointer);
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(18107);
    }
  }
  
  public YogaAlign getAlignContent()
  {
    AppMethodBeat.i(18130);
    YogaAlign localYogaAlign = YogaAlign.fromInt(jni_YGNodeStyleGetAlignContent(this.mNativePointer));
    AppMethodBeat.o(18130);
    return localYogaAlign;
  }
  
  public YogaAlign getAlignItems()
  {
    AppMethodBeat.i(18126);
    YogaAlign localYogaAlign = YogaAlign.fromInt(jni_YGNodeStyleGetAlignItems(this.mNativePointer));
    AppMethodBeat.o(18126);
    return localYogaAlign;
  }
  
  public YogaAlign getAlignSelf()
  {
    AppMethodBeat.i(18128);
    YogaAlign localYogaAlign = YogaAlign.fromInt(jni_YGNodeStyleGetAlignSelf(this.mNativePointer));
    AppMethodBeat.o(18128);
    return localYogaAlign;
  }
  
  public float getAspectRatio()
  {
    AppMethodBeat.i(18180);
    float f = jni_YGNodeStyleGetAspectRatio(this.mNativePointer);
    AppMethodBeat.o(18180);
    return f;
  }
  
  public float getBorder(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(18155);
    if ((this.mEdgeSetFlag & 0x4) != 4)
    {
      AppMethodBeat.o(18155);
      return 1.0E+021F;
    }
    float f = jni_YGNodeStyleGetBorder(this.mNativePointer, paramYogaEdge.intValue());
    AppMethodBeat.o(18155);
    return f;
  }
  
  public YogaNode getChildAt(int paramInt)
  {
    AppMethodBeat.i(18110);
    YogaNode localYogaNode = (YogaNode)this.mChildren.get(paramInt);
    AppMethodBeat.o(18110);
    return localYogaNode;
  }
  
  public int getChildCount()
  {
    AppMethodBeat.i(18109);
    if (this.mChildren == null)
    {
      AppMethodBeat.o(18109);
      return 0;
    }
    int i = this.mChildren.size();
    AppMethodBeat.o(18109);
    return i;
  }
  
  public Object getData()
  {
    return this.mData;
  }
  
  public YogaDisplay getDisplay()
  {
    AppMethodBeat.i(18137);
    YogaDisplay localYogaDisplay = YogaDisplay.fromInt(jni_YGNodeStyleGetDisplay(this.mNativePointer));
    AppMethodBeat.o(18137);
    return localYogaDisplay;
  }
  
  public YogaValue getFlexBasis()
  {
    AppMethodBeat.i(18144);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetFlexBasis(this.mNativePointer);
    AppMethodBeat.o(18144);
    return localYogaValue;
  }
  
  public YogaFlexDirection getFlexDirection()
  {
    AppMethodBeat.i(18122);
    YogaFlexDirection localYogaFlexDirection = YogaFlexDirection.fromInt(jni_YGNodeStyleGetFlexDirection(this.mNativePointer));
    AppMethodBeat.o(18122);
    return localYogaFlexDirection;
  }
  
  public float getFlexGrow()
  {
    AppMethodBeat.i(18140);
    float f = jni_YGNodeStyleGetFlexGrow(this.mNativePointer);
    AppMethodBeat.o(18140);
    return f;
  }
  
  public float getFlexShrink()
  {
    AppMethodBeat.i(18142);
    float f = jni_YGNodeStyleGetFlexShrink(this.mNativePointer);
    AppMethodBeat.o(18142);
    return f;
  }
  
  public YogaValue getHeight()
  {
    AppMethodBeat.i(18164);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetHeight(this.mNativePointer);
    AppMethodBeat.o(18164);
    return localYogaValue;
  }
  
  public YogaJustify getJustifyContent()
  {
    AppMethodBeat.i(18124);
    YogaJustify localYogaJustify = YogaJustify.fromInt(jni_YGNodeStyleGetJustifyContent(this.mNativePointer));
    AppMethodBeat.o(18124);
    return localYogaJustify;
  }
  
  public float getLayoutBorder(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(18184);
    switch (1.$SwitchMap$com$facebook$yoga$YogaEdge[paramYogaEdge.ordinal()])
    {
    default: 
      paramYogaEdge = new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
      AppMethodBeat.o(18184);
      throw paramYogaEdge;
    case 1: 
      f = this.mBorderLeft;
      AppMethodBeat.o(18184);
      return f;
    case 2: 
      f = this.mBorderTop;
      AppMethodBeat.o(18184);
      return f;
    case 3: 
      f = this.mBorderRight;
      AppMethodBeat.o(18184);
      return f;
    case 4: 
      f = this.mBorderBottom;
      AppMethodBeat.o(18184);
      return f;
    case 5: 
      if (getLayoutDirection() == YogaDirection.RTL)
      {
        f = this.mBorderRight;
        AppMethodBeat.o(18184);
        return f;
      }
      f = this.mBorderLeft;
      AppMethodBeat.o(18184);
      return f;
    }
    if (getLayoutDirection() == YogaDirection.RTL)
    {
      f = this.mBorderLeft;
      AppMethodBeat.o(18184);
      return f;
    }
    float f = this.mBorderRight;
    AppMethodBeat.o(18184);
    return f;
  }
  
  public YogaDirection getLayoutDirection()
  {
    AppMethodBeat.i(18185);
    YogaDirection localYogaDirection = YogaDirection.fromInt(this.mLayoutDirection);
    AppMethodBeat.o(18185);
    return localYogaDirection;
  }
  
  public float getLayoutHeight()
  {
    return this.mHeight;
  }
  
  public float getLayoutMargin(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(18182);
    switch (1.$SwitchMap$com$facebook$yoga$YogaEdge[paramYogaEdge.ordinal()])
    {
    default: 
      paramYogaEdge = new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
      AppMethodBeat.o(18182);
      throw paramYogaEdge;
    case 1: 
      f = this.mMarginLeft;
      AppMethodBeat.o(18182);
      return f;
    case 2: 
      f = this.mMarginTop;
      AppMethodBeat.o(18182);
      return f;
    case 3: 
      f = this.mMarginRight;
      AppMethodBeat.o(18182);
      return f;
    case 4: 
      f = this.mMarginBottom;
      AppMethodBeat.o(18182);
      return f;
    case 5: 
      if (getLayoutDirection() == YogaDirection.RTL)
      {
        f = this.mMarginRight;
        AppMethodBeat.o(18182);
        return f;
      }
      f = this.mMarginLeft;
      AppMethodBeat.o(18182);
      return f;
    }
    if (getLayoutDirection() == YogaDirection.RTL)
    {
      f = this.mMarginLeft;
      AppMethodBeat.o(18182);
      return f;
    }
    float f = this.mMarginRight;
    AppMethodBeat.o(18182);
    return f;
  }
  
  public float getLayoutPadding(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(18183);
    switch (1.$SwitchMap$com$facebook$yoga$YogaEdge[paramYogaEdge.ordinal()])
    {
    default: 
      paramYogaEdge = new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
      AppMethodBeat.o(18183);
      throw paramYogaEdge;
    case 1: 
      f = this.mPaddingLeft;
      AppMethodBeat.o(18183);
      return f;
    case 2: 
      f = this.mPaddingTop;
      AppMethodBeat.o(18183);
      return f;
    case 3: 
      f = this.mPaddingRight;
      AppMethodBeat.o(18183);
      return f;
    case 4: 
      f = this.mPaddingBottom;
      AppMethodBeat.o(18183);
      return f;
    case 5: 
      if (getLayoutDirection() == YogaDirection.RTL)
      {
        f = this.mPaddingRight;
        AppMethodBeat.o(18183);
        return f;
      }
      f = this.mPaddingLeft;
      AppMethodBeat.o(18183);
      return f;
    }
    if (getLayoutDirection() == YogaDirection.RTL)
    {
      f = this.mPaddingLeft;
      AppMethodBeat.o(18183);
      return f;
    }
    float f = this.mPaddingRight;
    AppMethodBeat.o(18183);
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
    AppMethodBeat.i(18148);
    if ((this.mEdgeSetFlag & 0x1) != 1)
    {
      paramYogaEdge = YogaValue.UNDEFINED;
      AppMethodBeat.o(18148);
      return paramYogaEdge;
    }
    paramYogaEdge = (YogaValue)jni_YGNodeStyleGetMargin(this.mNativePointer, paramYogaEdge.intValue());
    AppMethodBeat.o(18148);
    return paramYogaEdge;
  }
  
  public YogaValue getMaxHeight()
  {
    AppMethodBeat.i(18177);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetMaxHeight(this.mNativePointer);
    AppMethodBeat.o(18177);
    return localYogaValue;
  }
  
  public YogaValue getMaxWidth()
  {
    AppMethodBeat.i(18174);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetMaxWidth(this.mNativePointer);
    AppMethodBeat.o(18174);
    return localYogaValue;
  }
  
  public YogaValue getMinHeight()
  {
    AppMethodBeat.i(18171);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetMinHeight(this.mNativePointer);
    AppMethodBeat.o(18171);
    return localYogaValue;
  }
  
  public YogaValue getMinWidth()
  {
    AppMethodBeat.i(18168);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetMinWidth(this.mNativePointer);
    AppMethodBeat.o(18168);
    return localYogaValue;
  }
  
  public YogaOverflow getOverflow()
  {
    AppMethodBeat.i(18135);
    YogaOverflow localYogaOverflow = YogaOverflow.fromInt(jni_YGNodeStyleGetOverflow(this.mNativePointer));
    AppMethodBeat.o(18135);
    return localYogaOverflow;
  }
  
  public YogaValue getPadding(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(18152);
    if ((this.mEdgeSetFlag & 0x2) != 2)
    {
      paramYogaEdge = YogaValue.UNDEFINED;
      AppMethodBeat.o(18152);
      return paramYogaEdge;
    }
    paramYogaEdge = (YogaValue)jni_YGNodeStyleGetPadding(this.mNativePointer, paramYogaEdge.intValue());
    AppMethodBeat.o(18152);
    return paramYogaEdge;
  }
  
  public YogaNode getParent()
  {
    return this.mParent;
  }
  
  public YogaValue getPosition(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(18157);
    if (!this.mHasSetPosition)
    {
      paramYogaEdge = YogaValue.UNDEFINED;
      AppMethodBeat.o(18157);
      return paramYogaEdge;
    }
    paramYogaEdge = (YogaValue)jni_YGNodeStyleGetPosition(this.mNativePointer, paramYogaEdge.intValue());
    AppMethodBeat.o(18157);
    return paramYogaEdge;
  }
  
  public YogaPositionType getPositionType()
  {
    AppMethodBeat.i(18132);
    YogaPositionType localYogaPositionType = YogaPositionType.fromInt(jni_YGNodeStyleGetPositionType(this.mNativePointer));
    AppMethodBeat.o(18132);
    return localYogaPositionType;
  }
  
  public YogaDirection getStyleDirection()
  {
    AppMethodBeat.i(18120);
    YogaDirection localYogaDirection = YogaDirection.fromInt(jni_YGNodeStyleGetDirection(this.mNativePointer));
    AppMethodBeat.o(18120);
    return localYogaDirection;
  }
  
  public YogaValue getWidth()
  {
    AppMethodBeat.i(18160);
    YogaValue localYogaValue = (YogaValue)jni_YGNodeStyleGetWidth(this.mNativePointer);
    AppMethodBeat.o(18160);
    return localYogaValue;
  }
  
  public boolean hasNewLayout()
  {
    return this.mHasNewLayout;
  }
  
  public int indexOf(YogaNode paramYogaNode)
  {
    AppMethodBeat.i(18114);
    if (this.mChildren == null)
    {
      AppMethodBeat.o(18114);
      return -1;
    }
    int i = this.mChildren.indexOf(paramYogaNode);
    AppMethodBeat.o(18114);
    return i;
  }
  
  public boolean isDirty()
  {
    AppMethodBeat.i(18118);
    boolean bool = jni_YGNodeIsDirty(this.mNativePointer);
    AppMethodBeat.o(18118);
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
    AppMethodBeat.i(18187);
    if (!isMeasureDefined())
    {
      RuntimeException localRuntimeException = new RuntimeException("Measure function isn't defined!");
      AppMethodBeat.o(18187);
      throw localRuntimeException;
    }
    long l = this.mMeasureFunction.measure(this, paramFloat1, YogaMeasureMode.fromInt(paramInt1), paramFloat2, YogaMeasureMode.fromInt(paramInt2));
    AppMethodBeat.o(18187);
    return l;
  }
  
  public void print()
  {
    AppMethodBeat.i(18190);
    jni_YGNodePrint(this.mNativePointer);
    AppMethodBeat.o(18190);
  }
  
  public YogaNode removeChildAt(int paramInt)
  {
    AppMethodBeat.i(18113);
    YogaNode localYogaNode = (YogaNode)this.mChildren.remove(paramInt);
    localYogaNode.mParent = null;
    jni_YGNodeRemoveChild(this.mNativePointer, localYogaNode.mNativePointer);
    AppMethodBeat.o(18113);
    return localYogaNode;
  }
  
  public void reset()
  {
    AppMethodBeat.i(18108);
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
    AppMethodBeat.o(18108);
  }
  
  public void setAlignContent(YogaAlign paramYogaAlign)
  {
    AppMethodBeat.i(18131);
    jni_YGNodeStyleSetAlignContent(this.mNativePointer, paramYogaAlign.intValue());
    AppMethodBeat.o(18131);
  }
  
  public void setAlignItems(YogaAlign paramYogaAlign)
  {
    AppMethodBeat.i(18127);
    jni_YGNodeStyleSetAlignItems(this.mNativePointer, paramYogaAlign.intValue());
    AppMethodBeat.o(18127);
  }
  
  public void setAlignSelf(YogaAlign paramYogaAlign)
  {
    AppMethodBeat.i(18129);
    jni_YGNodeStyleSetAlignSelf(this.mNativePointer, paramYogaAlign.intValue());
    AppMethodBeat.o(18129);
  }
  
  public void setAspectRatio(float paramFloat)
  {
    AppMethodBeat.i(18181);
    jni_YGNodeStyleSetAspectRatio(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18181);
  }
  
  public void setBaselineFunction(YogaBaselineFunction paramYogaBaselineFunction)
  {
    AppMethodBeat.i(18188);
    this.mBaselineFunction = paramYogaBaselineFunction;
    long l = this.mNativePointer;
    if (paramYogaBaselineFunction != null) {}
    for (boolean bool = true;; bool = false)
    {
      jni_YGNodeSetHasBaselineFunc(l, bool);
      AppMethodBeat.o(18188);
      return;
    }
  }
  
  public void setBorder(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(18156);
    this.mEdgeSetFlag |= 0x4;
    jni_YGNodeStyleSetBorder(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(18156);
  }
  
  public void setData(Object paramObject)
  {
    this.mData = paramObject;
  }
  
  public void setDirection(YogaDirection paramYogaDirection)
  {
    AppMethodBeat.i(18121);
    jni_YGNodeStyleSetDirection(this.mNativePointer, paramYogaDirection.intValue());
    AppMethodBeat.o(18121);
  }
  
  public void setDisplay(YogaDisplay paramYogaDisplay)
  {
    AppMethodBeat.i(18138);
    jni_YGNodeStyleSetDisplay(this.mNativePointer, paramYogaDisplay.intValue());
    AppMethodBeat.o(18138);
  }
  
  public void setFlex(float paramFloat)
  {
    AppMethodBeat.i(18139);
    jni_YGNodeStyleSetFlex(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18139);
  }
  
  public void setFlexBasis(float paramFloat)
  {
    AppMethodBeat.i(18145);
    jni_YGNodeStyleSetFlexBasis(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18145);
  }
  
  public void setFlexBasisAuto()
  {
    AppMethodBeat.i(18147);
    jni_YGNodeStyleSetFlexBasisAuto(this.mNativePointer);
    AppMethodBeat.o(18147);
  }
  
  public void setFlexBasisPercent(float paramFloat)
  {
    AppMethodBeat.i(18146);
    jni_YGNodeStyleSetFlexBasisPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18146);
  }
  
  public void setFlexDirection(YogaFlexDirection paramYogaFlexDirection)
  {
    AppMethodBeat.i(18123);
    jni_YGNodeStyleSetFlexDirection(this.mNativePointer, paramYogaFlexDirection.intValue());
    AppMethodBeat.o(18123);
  }
  
  public void setFlexGrow(float paramFloat)
  {
    AppMethodBeat.i(18141);
    jni_YGNodeStyleSetFlexGrow(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18141);
  }
  
  public void setFlexShrink(float paramFloat)
  {
    AppMethodBeat.i(18143);
    jni_YGNodeStyleSetFlexShrink(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18143);
  }
  
  public void setHeight(float paramFloat)
  {
    AppMethodBeat.i(18165);
    jni_YGNodeStyleSetHeight(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18165);
  }
  
  public void setHeightAuto()
  {
    AppMethodBeat.i(18167);
    jni_YGNodeStyleSetHeightAuto(this.mNativePointer);
    AppMethodBeat.o(18167);
  }
  
  public void setHeightPercent(float paramFloat)
  {
    AppMethodBeat.i(18166);
    jni_YGNodeStyleSetHeightPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18166);
  }
  
  public void setJustifyContent(YogaJustify paramYogaJustify)
  {
    AppMethodBeat.i(18125);
    jni_YGNodeStyleSetJustifyContent(this.mNativePointer, paramYogaJustify.intValue());
    AppMethodBeat.o(18125);
  }
  
  public void setMargin(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(18149);
    this.mEdgeSetFlag |= 0x1;
    jni_YGNodeStyleSetMargin(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(18149);
  }
  
  public void setMarginAuto(YogaEdge paramYogaEdge)
  {
    AppMethodBeat.i(18151);
    this.mEdgeSetFlag |= 0x1;
    jni_YGNodeStyleSetMarginAuto(this.mNativePointer, paramYogaEdge.intValue());
    AppMethodBeat.o(18151);
  }
  
  public void setMarginPercent(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(18150);
    this.mEdgeSetFlag |= 0x1;
    jni_YGNodeStyleSetMarginPercent(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(18150);
  }
  
  public void setMaxHeight(float paramFloat)
  {
    AppMethodBeat.i(18178);
    jni_YGNodeStyleSetMaxHeight(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18178);
  }
  
  public void setMaxHeightPercent(float paramFloat)
  {
    AppMethodBeat.i(18179);
    jni_YGNodeStyleSetMaxHeightPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18179);
  }
  
  public void setMaxWidth(float paramFloat)
  {
    AppMethodBeat.i(18175);
    jni_YGNodeStyleSetMaxWidth(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18175);
  }
  
  public void setMaxWidthPercent(float paramFloat)
  {
    AppMethodBeat.i(18176);
    jni_YGNodeStyleSetMaxWidthPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18176);
  }
  
  public void setMeasureFunction(YogaMeasureFunction paramYogaMeasureFunction)
  {
    AppMethodBeat.i(18186);
    this.mMeasureFunction = paramYogaMeasureFunction;
    long l = this.mNativePointer;
    if (paramYogaMeasureFunction != null) {}
    for (boolean bool = true;; bool = false)
    {
      jni_YGNodeSetHasMeasureFunc(l, bool);
      AppMethodBeat.o(18186);
      return;
    }
  }
  
  public void setMinHeight(float paramFloat)
  {
    AppMethodBeat.i(18172);
    jni_YGNodeStyleSetMinHeight(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18172);
  }
  
  public void setMinHeightPercent(float paramFloat)
  {
    AppMethodBeat.i(18173);
    jni_YGNodeStyleSetMinHeightPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18173);
  }
  
  public void setMinWidth(float paramFloat)
  {
    AppMethodBeat.i(18169);
    jni_YGNodeStyleSetMinWidth(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18169);
  }
  
  public void setMinWidthPercent(float paramFloat)
  {
    AppMethodBeat.i(18170);
    jni_YGNodeStyleSetMinWidthPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18170);
  }
  
  public void setOverflow(YogaOverflow paramYogaOverflow)
  {
    AppMethodBeat.i(18136);
    jni_YGNodeStyleSetOverflow(this.mNativePointer, paramYogaOverflow.intValue());
    AppMethodBeat.o(18136);
  }
  
  public void setPadding(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(18153);
    this.mEdgeSetFlag |= 0x2;
    jni_YGNodeStyleSetPadding(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(18153);
  }
  
  public void setPaddingPercent(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(18154);
    this.mEdgeSetFlag |= 0x2;
    jni_YGNodeStyleSetPaddingPercent(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(18154);
  }
  
  public void setPosition(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(18158);
    this.mHasSetPosition = true;
    jni_YGNodeStyleSetPosition(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(18158);
  }
  
  public void setPositionPercent(YogaEdge paramYogaEdge, float paramFloat)
  {
    AppMethodBeat.i(18159);
    this.mHasSetPosition = true;
    jni_YGNodeStyleSetPositionPercent(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
    AppMethodBeat.o(18159);
  }
  
  public void setPositionType(YogaPositionType paramYogaPositionType)
  {
    AppMethodBeat.i(18133);
    jni_YGNodeStyleSetPositionType(this.mNativePointer, paramYogaPositionType.intValue());
    AppMethodBeat.o(18133);
  }
  
  public void setWidth(float paramFloat)
  {
    AppMethodBeat.i(18161);
    jni_YGNodeStyleSetWidth(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18161);
  }
  
  public void setWidthAuto()
  {
    AppMethodBeat.i(18163);
    jni_YGNodeStyleSetWidthAuto(this.mNativePointer);
    AppMethodBeat.o(18163);
  }
  
  public void setWidthPercent(float paramFloat)
  {
    AppMethodBeat.i(18162);
    jni_YGNodeStyleSetWidthPercent(this.mNativePointer, paramFloat);
    AppMethodBeat.o(18162);
  }
  
  public void setWrap(YogaWrap paramYogaWrap)
  {
    AppMethodBeat.i(18134);
    jni_YGNodeStyleSetFlexWrap(this.mNativePointer, paramYogaWrap.intValue());
    AppMethodBeat.o(18134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.yoga.YogaNode
 * JD-Core Version:    0.7.0.1
 */