package com.facebook.yoga;

public class YogaNative
{
  static native void jni_YGConfigFreeJNI(long paramLong);
  
  static native long jni_YGConfigNewJNI();
  
  static native void jni_YGConfigSetExperimentalFeatureEnabledJNI(long paramLong, int paramInt, boolean paramBoolean);
  
  static native void jni_YGConfigSetLoggerJNI(long paramLong, YogaLogger paramYogaLogger);
  
  static native void jni_YGConfigSetPointScaleFactorJNI(long paramLong, float paramFloat);
  
  static native void jni_YGConfigSetPrintTreeFlagJNI(long paramLong, boolean paramBoolean);
  
  static native void jni_YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviourJNI(long paramLong, boolean paramBoolean);
  
  static native void jni_YGConfigSetUseLegacyStretchBehaviourJNI(long paramLong, boolean paramBoolean);
  
  static native void jni_YGConfigSetUseWebDefaultsJNI(long paramLong, boolean paramBoolean);
  
  static native void jni_YGNodeCalculateLayoutJNI(long paramLong, float paramFloat1, float paramFloat2, long[] paramArrayOfLong, YogaNodeJNIBase[] paramArrayOfYogaNodeJNIBase);
  
  static native void jni_YGNodeClearChildrenJNI(long paramLong);
  
  static native long jni_YGNodeCloneJNI(long paramLong);
  
  static native void jni_YGNodeCopyStyleJNI(long paramLong1, long paramLong2);
  
  static native void jni_YGNodeFreeJNI(long paramLong);
  
  static native void jni_YGNodeInsertChildJNI(long paramLong1, long paramLong2, int paramInt);
  
  static native boolean jni_YGNodeIsDirtyJNI(long paramLong);
  
  static native boolean jni_YGNodeIsReferenceBaselineJNI(long paramLong);
  
  static native void jni_YGNodeMarkDirtyAndPropogateToDescendantsJNI(long paramLong);
  
  static native void jni_YGNodeMarkDirtyJNI(long paramLong);
  
  static native long jni_YGNodeNewJNI();
  
  static native long jni_YGNodeNewWithConfigJNI(long paramLong);
  
  static native void jni_YGNodePrintJNI(long paramLong);
  
  static native void jni_YGNodeRemoveChildJNI(long paramLong1, long paramLong2);
  
  static native void jni_YGNodeResetJNI(long paramLong);
  
  static native void jni_YGNodeSetHasBaselineFuncJNI(long paramLong, boolean paramBoolean);
  
  static native void jni_YGNodeSetHasMeasureFuncJNI(long paramLong, boolean paramBoolean);
  
  static native void jni_YGNodeSetIsReferenceBaselineJNI(long paramLong, boolean paramBoolean);
  
  static native void jni_YGNodeSetStyleInputsJNI(long paramLong, float[] paramArrayOfFloat, int paramInt);
  
  static native int jni_YGNodeStyleGetAlignContentJNI(long paramLong);
  
  static native int jni_YGNodeStyleGetAlignItemsJNI(long paramLong);
  
  static native int jni_YGNodeStyleGetAlignSelfJNI(long paramLong);
  
  static native float jni_YGNodeStyleGetAspectRatioJNI(long paramLong);
  
  static native float jni_YGNodeStyleGetBorderJNI(long paramLong, int paramInt);
  
  static native int jni_YGNodeStyleGetDirectionJNI(long paramLong);
  
  static native int jni_YGNodeStyleGetDisplayJNI(long paramLong);
  
  static native long jni_YGNodeStyleGetFlexBasisJNI(long paramLong);
  
  static native int jni_YGNodeStyleGetFlexDirectionJNI(long paramLong);
  
  static native float jni_YGNodeStyleGetFlexGrowJNI(long paramLong);
  
  static native float jni_YGNodeStyleGetFlexJNI(long paramLong);
  
  static native float jni_YGNodeStyleGetFlexShrinkJNI(long paramLong);
  
  static native int jni_YGNodeStyleGetFlexWrapJNI(long paramLong);
  
  static native long jni_YGNodeStyleGetHeightJNI(long paramLong);
  
  static native int jni_YGNodeStyleGetJustifyContentJNI(long paramLong);
  
  static native long jni_YGNodeStyleGetMarginJNI(long paramLong, int paramInt);
  
  static native long jni_YGNodeStyleGetMaxHeightJNI(long paramLong);
  
  static native long jni_YGNodeStyleGetMaxWidthJNI(long paramLong);
  
  static native long jni_YGNodeStyleGetMinHeightJNI(long paramLong);
  
  static native long jni_YGNodeStyleGetMinWidthJNI(long paramLong);
  
  static native int jni_YGNodeStyleGetOverflowJNI(long paramLong);
  
  static native long jni_YGNodeStyleGetPaddingJNI(long paramLong, int paramInt);
  
  static native long jni_YGNodeStyleGetPositionJNI(long paramLong, int paramInt);
  
  static native int jni_YGNodeStyleGetPositionTypeJNI(long paramLong);
  
  static native long jni_YGNodeStyleGetWidthJNI(long paramLong);
  
  static native void jni_YGNodeStyleSetAlignContentJNI(long paramLong, int paramInt);
  
  static native void jni_YGNodeStyleSetAlignItemsJNI(long paramLong, int paramInt);
  
  static native void jni_YGNodeStyleSetAlignSelfJNI(long paramLong, int paramInt);
  
  static native void jni_YGNodeStyleSetAspectRatioJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetBorderJNI(long paramLong, int paramInt, float paramFloat);
  
  static native void jni_YGNodeStyleSetDirectionJNI(long paramLong, int paramInt);
  
  static native void jni_YGNodeStyleSetDisplayJNI(long paramLong, int paramInt);
  
  static native void jni_YGNodeStyleSetFlexBasisAutoJNI(long paramLong);
  
  static native void jni_YGNodeStyleSetFlexBasisJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetFlexBasisPercentJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetFlexDirectionJNI(long paramLong, int paramInt);
  
  static native void jni_YGNodeStyleSetFlexGrowJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetFlexJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetFlexShrinkJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetFlexWrapJNI(long paramLong, int paramInt);
  
  static native void jni_YGNodeStyleSetHeightAutoJNI(long paramLong);
  
  static native void jni_YGNodeStyleSetHeightJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetHeightPercentJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetJustifyContentJNI(long paramLong, int paramInt);
  
  static native void jni_YGNodeStyleSetMarginAutoJNI(long paramLong, int paramInt);
  
  static native void jni_YGNodeStyleSetMarginJNI(long paramLong, int paramInt, float paramFloat);
  
  static native void jni_YGNodeStyleSetMarginPercentJNI(long paramLong, int paramInt, float paramFloat);
  
  static native void jni_YGNodeStyleSetMaxHeightJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetMaxHeightPercentJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetMaxWidthJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetMaxWidthPercentJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetMinHeightJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetMinHeightPercentJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetMinWidthJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetMinWidthPercentJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetOverflowJNI(long paramLong, int paramInt);
  
  static native void jni_YGNodeStyleSetPaddingJNI(long paramLong, int paramInt, float paramFloat);
  
  static native void jni_YGNodeStyleSetPaddingPercentJNI(long paramLong, int paramInt, float paramFloat);
  
  static native void jni_YGNodeStyleSetPositionJNI(long paramLong, int paramInt, float paramFloat);
  
  static native void jni_YGNodeStyleSetPositionPercentJNI(long paramLong, int paramInt, float paramFloat);
  
  static native void jni_YGNodeStyleSetPositionTypeJNI(long paramLong, int paramInt);
  
  static native void jni_YGNodeStyleSetWidthAutoJNI(long paramLong);
  
  static native void jni_YGNodeStyleSetWidthJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeStyleSetWidthPercentJNI(long paramLong, float paramFloat);
  
  static native void jni_YGNodeSwapChildJNI(long paramLong1, long paramLong2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaNative
 * JD-Core Version:    0.7.0.1
 */