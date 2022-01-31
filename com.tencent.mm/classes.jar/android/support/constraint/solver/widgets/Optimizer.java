package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;

public class Optimizer
{
  static final int FLAG_CHAIN_DANGLING = 1;
  static final int FLAG_RECOMPUTE_BOUNDS = 2;
  static final int FLAG_USE_OPTIMIZE = 0;
  public static final int OPTIMIZATION_BARRIER = 2;
  public static final int OPTIMIZATION_CHAIN = 4;
  public static final int OPTIMIZATION_DIMENSIONS = 8;
  public static final int OPTIMIZATION_DIRECT = 1;
  public static final int OPTIMIZATION_GROUPS = 32;
  public static final int OPTIMIZATION_NONE = 0;
  public static final int OPTIMIZATION_RATIO = 16;
  public static final int OPTIMIZATION_STANDARD = 7;
  static boolean[] flags = new boolean[3];
  
  static void analyze(int paramInt, ConstraintWidget paramConstraintWidget)
  {
    int j = 0;
    paramConstraintWidget.updateResolutionNodes();
    ResolutionAnchor localResolutionAnchor1 = paramConstraintWidget.mLeft.getResolutionNode();
    ResolutionAnchor localResolutionAnchor2 = paramConstraintWidget.mTop.getResolutionNode();
    ResolutionAnchor localResolutionAnchor3 = paramConstraintWidget.mRight.getResolutionNode();
    ResolutionAnchor localResolutionAnchor4 = paramConstraintWidget.mBottom.getResolutionNode();
    int i;
    if ((paramInt & 0x8) == 8)
    {
      paramInt = 1;
      if ((paramConstraintWidget.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (!optimizableMatchConstraint(paramConstraintWidget, 0))) {
        break label328;
      }
      i = 1;
      label75:
      if ((localResolutionAnchor1.type != 4) && (localResolutionAnchor3.type != 4))
      {
        if ((paramConstraintWidget.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED) && ((i == 0) || (paramConstraintWidget.getVisibility() != 8))) {
          break label599;
        }
        if ((paramConstraintWidget.mLeft.mTarget != null) || (paramConstraintWidget.mRight.mTarget != null)) {
          break label347;
        }
        localResolutionAnchor1.setType(1);
        localResolutionAnchor3.setType(1);
        if (paramInt == 0) {
          break label333;
        }
        localResolutionAnchor3.dependsOn(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
      }
      label166:
      i = j;
      if (paramConstraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        i = j;
        if (optimizableMatchConstraint(paramConstraintWidget, 1)) {
          i = 1;
        }
      }
      if ((localResolutionAnchor2.type != 4) && (localResolutionAnchor4.type != 4))
      {
        if ((paramConstraintWidget.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED) && ((i == 0) || (paramConstraintWidget.getVisibility() != 8))) {
          break label1212;
        }
        if ((paramConstraintWidget.mTop.mTarget != null) || (paramConstraintWidget.mBottom.mTarget != null)) {
          break label906;
        }
        localResolutionAnchor2.setType(1);
        localResolutionAnchor4.setType(1);
        if (paramInt == 0) {
          break label892;
        }
        localResolutionAnchor4.dependsOn(localResolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
        label283:
        if (paramConstraintWidget.mBaseline.mTarget != null)
        {
          paramConstraintWidget.mBaseline.getResolutionNode().setType(1);
          localResolutionAnchor2.dependsOn(1, paramConstraintWidget.mBaseline.getResolutionNode(), -paramConstraintWidget.mBaselineDistance);
        }
      }
    }
    label328:
    label333:
    label347:
    label892:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            paramInt = 0;
            break;
            i = 0;
            break label75;
            localResolutionAnchor3.dependsOn(localResolutionAnchor1, paramConstraintWidget.getWidth());
            break label166;
            if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mRight.mTarget == null))
            {
              localResolutionAnchor1.setType(1);
              localResolutionAnchor3.setType(1);
              if (paramInt != 0)
              {
                localResolutionAnchor3.dependsOn(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
                break label166;
              }
              localResolutionAnchor3.dependsOn(localResolutionAnchor1, paramConstraintWidget.getWidth());
              break label166;
            }
            if ((paramConstraintWidget.mLeft.mTarget == null) && (paramConstraintWidget.mRight.mTarget != null))
            {
              localResolutionAnchor1.setType(1);
              localResolutionAnchor3.setType(1);
              localResolutionAnchor1.dependsOn(localResolutionAnchor3, -paramConstraintWidget.getWidth());
              if (paramInt != 0)
              {
                localResolutionAnchor1.dependsOn(localResolutionAnchor3, -1, paramConstraintWidget.getResolutionWidth());
                break label166;
              }
              localResolutionAnchor1.dependsOn(localResolutionAnchor3, -paramConstraintWidget.getWidth());
              break label166;
            }
            if ((paramConstraintWidget.mLeft.mTarget == null) || (paramConstraintWidget.mRight.mTarget == null)) {
              break label166;
            }
            localResolutionAnchor1.setType(2);
            localResolutionAnchor3.setType(2);
            if (paramInt != 0)
            {
              paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor1);
              paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor3);
              localResolutionAnchor1.setOpposite(localResolutionAnchor3, -1, paramConstraintWidget.getResolutionWidth());
              localResolutionAnchor3.setOpposite(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
              break label166;
            }
            localResolutionAnchor1.setOpposite(localResolutionAnchor3, -paramConstraintWidget.getWidth());
            localResolutionAnchor3.setOpposite(localResolutionAnchor1, paramConstraintWidget.getWidth());
            break label166;
            if (i == 0) {
              break label166;
            }
            i = paramConstraintWidget.getWidth();
            localResolutionAnchor1.setType(1);
            localResolutionAnchor3.setType(1);
            if ((paramConstraintWidget.mLeft.mTarget == null) && (paramConstraintWidget.mRight.mTarget == null))
            {
              if (paramInt != 0)
              {
                localResolutionAnchor3.dependsOn(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
                break label166;
              }
              localResolutionAnchor3.dependsOn(localResolutionAnchor1, i);
              break label166;
            }
            if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mRight.mTarget == null))
            {
              if (paramInt != 0)
              {
                localResolutionAnchor3.dependsOn(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
                break label166;
              }
              localResolutionAnchor3.dependsOn(localResolutionAnchor1, i);
              break label166;
            }
            if ((paramConstraintWidget.mLeft.mTarget == null) && (paramConstraintWidget.mRight.mTarget != null))
            {
              if (paramInt != 0)
              {
                localResolutionAnchor1.dependsOn(localResolutionAnchor3, -1, paramConstraintWidget.getResolutionWidth());
                break label166;
              }
              localResolutionAnchor1.dependsOn(localResolutionAnchor3, -i);
              break label166;
            }
            if ((paramConstraintWidget.mLeft.mTarget == null) || (paramConstraintWidget.mRight.mTarget == null)) {
              break label166;
            }
            if (paramInt != 0)
            {
              paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor1);
              paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor3);
            }
            if (paramConstraintWidget.mDimensionRatio == 0.0F)
            {
              localResolutionAnchor1.setType(3);
              localResolutionAnchor3.setType(3);
              localResolutionAnchor1.setOpposite(localResolutionAnchor3, 0.0F);
              localResolutionAnchor3.setOpposite(localResolutionAnchor1, 0.0F);
              break label166;
            }
            localResolutionAnchor1.setType(2);
            localResolutionAnchor3.setType(2);
            localResolutionAnchor1.setOpposite(localResolutionAnchor3, -i);
            localResolutionAnchor3.setOpposite(localResolutionAnchor1, i);
            paramConstraintWidget.setWidth(i);
            break label166;
            localResolutionAnchor4.dependsOn(localResolutionAnchor2, paramConstraintWidget.getHeight());
            break label283;
            if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mBottom.mTarget == null))
            {
              localResolutionAnchor2.setType(1);
              localResolutionAnchor4.setType(1);
              if (paramInt != 0) {
                localResolutionAnchor4.dependsOn(localResolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
              }
              while (paramConstraintWidget.mBaselineDistance > 0)
              {
                paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, localResolutionAnchor2, paramConstraintWidget.mBaselineDistance);
                return;
                localResolutionAnchor4.dependsOn(localResolutionAnchor2, paramConstraintWidget.getHeight());
              }
            }
            else if ((paramConstraintWidget.mTop.mTarget == null) && (paramConstraintWidget.mBottom.mTarget != null))
            {
              localResolutionAnchor2.setType(1);
              localResolutionAnchor4.setType(1);
              if (paramInt != 0) {
                localResolutionAnchor2.dependsOn(localResolutionAnchor4, -1, paramConstraintWidget.getResolutionHeight());
              }
              while (paramConstraintWidget.mBaselineDistance > 0)
              {
                paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, localResolutionAnchor2, paramConstraintWidget.mBaselineDistance);
                return;
                localResolutionAnchor2.dependsOn(localResolutionAnchor4, -paramConstraintWidget.getHeight());
              }
            }
            else if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mBottom.mTarget != null))
            {
              localResolutionAnchor2.setType(2);
              localResolutionAnchor4.setType(2);
              if (paramInt != 0)
              {
                localResolutionAnchor2.setOpposite(localResolutionAnchor4, -1, paramConstraintWidget.getResolutionHeight());
                localResolutionAnchor4.setOpposite(localResolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
                paramConstraintWidget.getResolutionHeight().addDependent(localResolutionAnchor2);
                paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor4);
              }
              while (paramConstraintWidget.mBaselineDistance > 0)
              {
                paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, localResolutionAnchor2, paramConstraintWidget.mBaselineDistance);
                return;
                localResolutionAnchor2.setOpposite(localResolutionAnchor4, -paramConstraintWidget.getHeight());
                localResolutionAnchor4.setOpposite(localResolutionAnchor2, paramConstraintWidget.getHeight());
              }
            }
          }
        } while (i == 0);
        i = paramConstraintWidget.getHeight();
        localResolutionAnchor2.setType(1);
        localResolutionAnchor4.setType(1);
        if ((paramConstraintWidget.mTop.mTarget == null) && (paramConstraintWidget.mBottom.mTarget == null))
        {
          if (paramInt != 0)
          {
            localResolutionAnchor4.dependsOn(localResolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
            return;
          }
          localResolutionAnchor4.dependsOn(localResolutionAnchor2, i);
          return;
        }
        if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mBottom.mTarget == null))
        {
          if (paramInt != 0)
          {
            localResolutionAnchor4.dependsOn(localResolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
            return;
          }
          localResolutionAnchor4.dependsOn(localResolutionAnchor2, i);
          return;
        }
        if ((paramConstraintWidget.mTop.mTarget == null) && (paramConstraintWidget.mBottom.mTarget != null))
        {
          if (paramInt != 0)
          {
            localResolutionAnchor2.dependsOn(localResolutionAnchor4, -1, paramConstraintWidget.getResolutionHeight());
            return;
          }
          localResolutionAnchor2.dependsOn(localResolutionAnchor4, -i);
          return;
        }
      } while ((paramConstraintWidget.mTop.mTarget == null) || (paramConstraintWidget.mBottom.mTarget == null));
      if (paramInt != 0)
      {
        paramConstraintWidget.getResolutionHeight().addDependent(localResolutionAnchor2);
        paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor4);
      }
      if (paramConstraintWidget.mDimensionRatio == 0.0F)
      {
        localResolutionAnchor2.setType(3);
        localResolutionAnchor4.setType(3);
        localResolutionAnchor2.setOpposite(localResolutionAnchor4, 0.0F);
        localResolutionAnchor4.setOpposite(localResolutionAnchor2, 0.0F);
        return;
      }
      localResolutionAnchor2.setType(2);
      localResolutionAnchor4.setType(2);
      localResolutionAnchor2.setOpposite(localResolutionAnchor4, -i);
      localResolutionAnchor4.setOpposite(localResolutionAnchor2, i);
      paramConstraintWidget.setHeight(i);
    } while (paramConstraintWidget.mBaselineDistance <= 0);
    label599:
    paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, localResolutionAnchor2, paramConstraintWidget.mBaselineDistance);
    label906:
    label1212:
    return;
  }
  
  static boolean applyChainOptimized(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt1, int paramInt2, ChainHead paramChainHead)
  {
    paramConstraintWidgetContainer = paramChainHead.mFirst;
    ConstraintWidget localConstraintWidget1 = paramChainHead.mLast;
    ConstraintWidget localConstraintWidget2 = paramChainHead.mFirstVisibleWidget;
    ConstraintWidget localConstraintWidget3 = paramChainHead.mLastVisibleWidget;
    Object localObject1 = paramChainHead.mHead;
    int n = 0;
    int i1 = 0;
    float f6 = paramChainHead.mTotalWeight;
    paramChainHead = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    int k;
    int m;
    label79:
    int i;
    label91:
    float f5;
    float f3;
    int j;
    label103:
    float f2;
    label139:
    float f1;
    if (paramInt1 == 0) {
      if (((ConstraintWidget)localObject1).mHorizontalChainStyle == 0)
      {
        k = 1;
        if (((ConstraintWidget)localObject1).mHorizontalChainStyle != 1) {
          break label280;
        }
        m = 1;
        if (((ConstraintWidget)localObject1).mHorizontalChainStyle != 2) {
          break label286;
        }
        i = 1;
        f5 = 0.0F;
        f3 = 0.0F;
        j = 0;
        localObject1 = paramConstraintWidgetContainer;
        if (n != 0) {
          break label522;
        }
        if (((ConstraintWidget)localObject1).getVisibility() == 8) {
          break label1744;
        }
        j += 1;
        if (paramInt1 != 0) {
          break label348;
        }
        f2 = ((ConstraintWidget)localObject1).getWidth() + f5;
        f1 = f2;
        if (localObject1 != localConstraintWidget2) {
          f1 = f2 + localObject1.mListAnchors[paramInt2].getMargin();
        }
        f2 = f1;
        if (localObject1 != localConstraintWidget3) {
          f2 = f1 + localObject1.mListAnchors[(paramInt2 + 1)].getMargin();
        }
        f3 = f3 + localObject1.mListAnchors[paramInt2].getMargin() + localObject1.mListAnchors[(paramInt2 + 1)].getMargin();
        f5 = f2;
      }
    }
    label280:
    label286:
    label303:
    label1334:
    label1719:
    label1737:
    label1744:
    for (;;)
    {
      int i2 = i1;
      if (((ConstraintWidget)localObject1).getVisibility() != 8)
      {
        i2 = i1;
        if (localObject1.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          if (paramInt1 == 0)
          {
            if (((ConstraintWidget)localObject1).mMatchConstraintDefaultWidth != 0)
            {
              return false;
              k = 0;
              break;
              m = 0;
              break label79;
              i = 0;
              break label91;
              if (((ConstraintWidget)localObject1).mVerticalChainStyle == 0)
              {
                k = 1;
                if (((ConstraintWidget)localObject1).mVerticalChainStyle != 1) {
                  break label336;
                }
              }
              label336:
              for (m = 1;; m = 0)
              {
                if (((ConstraintWidget)localObject1).mVerticalChainStyle != 2) {
                  break label342;
                }
                i = 1;
                break;
                k = 0;
                break label303;
              }
              label342:
              i = 0;
              break label91;
              label348:
              f2 = ((ConstraintWidget)localObject1).getHeight() + f5;
              break label139;
            }
            if ((((ConstraintWidget)localObject1).mMatchConstraintMinWidth == 0) && (((ConstraintWidget)localObject1).mMatchConstraintMaxWidth == 0)) {
              break label408;
            }
            return false;
          }
          if (((ConstraintWidget)localObject1).mMatchConstraintDefaultHeight != 0) {
            return false;
          }
          if ((((ConstraintWidget)localObject1).mMatchConstraintMinHeight != 0) || (((ConstraintWidget)localObject1).mMatchConstraintMaxHeight != 0)) {
            return false;
          }
          if (((ConstraintWidget)localObject1).mDimensionRatio != 0.0F) {
            return false;
          }
          i2 = i1 + 1;
        }
      }
      paramChainHead = localObject1.mListAnchors[(paramInt2 + 1)].mTarget;
      if (paramChainHead != null)
      {
        localObject2 = paramChainHead.mOwner;
        if (localObject2.mListAnchors[paramInt2].mTarget != null)
        {
          paramChainHead = (ChainHead)localObject2;
          if (localObject2.mListAnchors[paramInt2].mTarget.mOwner == localObject1) {
            break label490;
          }
        }
      }
      for (paramChainHead = null;; paramChainHead = null)
      {
        label490:
        if (paramChainHead == null) {
          break label512;
        }
        i1 = i2;
        localObject1 = paramChainHead;
        break;
      }
      n = 1;
      i1 = i2;
      break label103;
      Object localObject2 = paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode();
      paramChainHead = localConstraintWidget1.mListAnchors[(paramInt2 + 1)].getResolutionNode();
      if ((((ResolutionAnchor)localObject2).target == null) || (paramChainHead.target == null)) {
        return false;
      }
      if ((((ResolutionAnchor)localObject2).target.state != 1) || (paramChainHead.target.state != 1)) {
        return false;
      }
      if ((i1 > 0) && (i1 != j)) {
        return false;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      if ((i != 0) || (k != 0) || (m != 0))
      {
        if (localConstraintWidget2 != null) {
          f2 = localConstraintWidget2.mListAnchors[paramInt2].getMargin();
        }
        f1 = f2;
        if (localConstraintWidget3 != null) {
          f1 = f2 + localConstraintWidget3.mListAnchors[(paramInt2 + 1)].getMargin();
        }
      }
      float f4 = ((ResolutionAnchor)localObject2).target.resolvedOffset;
      f2 = paramChainHead.target.resolvedOffset;
      if (f4 < f2) {
        f2 = f2 - f4 - f5;
      }
      for (;;)
      {
        if ((i1 > 0) && (i1 == j)) {
          if ((((ConstraintWidget)localObject1).getParent() != null) && (localObject1.getParent().mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT))
          {
            return false;
            f2 = f4 - f2 - f5;
          }
          else
          {
            f3 = f2 + f5 - f3;
            f2 = f4;
            if (paramConstraintWidgetContainer != null)
            {
              if (LinearSystem.sMetrics != null)
              {
                paramChainHead = LinearSystem.sMetrics;
                paramChainHead.nonresolvedWidgets -= 1L;
                paramChainHead = LinearSystem.sMetrics;
                paramChainHead.resolvedWidgets += 1L;
                paramChainHead = LinearSystem.sMetrics;
                paramChainHead.chainConnectionResolved += 1L;
              }
              paramChainHead = paramConstraintWidgetContainer.mNextChainWidget[paramInt1];
              if ((paramChainHead == null) && (paramConstraintWidgetContainer != localConstraintWidget1)) {
                break label1737;
              }
              f1 = f3 / i1;
              if (f6 > 0.0F)
              {
                if (paramConstraintWidgetContainer.mWeight[paramInt1] == -1.0F) {
                  f1 = 0.0F;
                }
              }
              else
              {
                label884:
                if (paramConstraintWidgetContainer.getVisibility() == 8) {
                  f1 = 0.0F;
                }
                f2 += paramConstraintWidgetContainer.mListAnchors[paramInt2].getMargin();
                paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().resolve(((ResolutionAnchor)localObject2).resolvedTarget, f2);
                paramConstraintWidgetContainer.mListAnchors[(paramInt2 + 1)].getResolutionNode().resolve(((ResolutionAnchor)localObject2).resolvedTarget, f2 + f1);
                paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().addResolvedValue(paramLinearSystem);
                paramConstraintWidgetContainer.mListAnchors[(paramInt2 + 1)].getResolutionNode().addResolvedValue(paramLinearSystem);
              }
            }
          }
        }
      }
      for (f1 = f1 + f2 + paramConstraintWidgetContainer.mListAnchors[(paramInt2 + 1)].getMargin();; f1 = f2)
      {
        paramConstraintWidgetContainer = paramChainHead;
        f2 = f1;
        break;
        f1 = paramConstraintWidgetContainer.mWeight[paramInt1] * f3 / f6;
        break label884;
        return true;
        if (f2 < 0.0F)
        {
          i = 1;
          k = 0;
        }
        for (m = 0;; m = n)
        {
          if (i != 0)
          {
            f1 = f4 + (f2 - f1) * paramConstraintWidgetContainer.getBiasPercent(paramInt1);
            if (paramConstraintWidgetContainer == null) {
              break label1696;
            }
            if (LinearSystem.sMetrics != null)
            {
              paramChainHead = LinearSystem.sMetrics;
              paramChainHead.nonresolvedWidgets -= 1L;
              paramChainHead = LinearSystem.sMetrics;
              paramChainHead.resolvedWidgets += 1L;
              paramChainHead = LinearSystem.sMetrics;
              paramChainHead.chainConnectionResolved += 1L;
            }
            paramChainHead = paramConstraintWidgetContainer.mNextChainWidget[paramInt1];
            if ((paramChainHead == null) && (paramConstraintWidgetContainer != localConstraintWidget1)) {
              break label1719;
            }
            if (paramInt1 == 0)
            {
              f2 = paramConstraintWidgetContainer.getWidth();
              f1 += paramConstraintWidgetContainer.mListAnchors[paramInt2].getMargin();
              paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().resolve(((ResolutionAnchor)localObject2).resolvedTarget, f1);
              paramConstraintWidgetContainer.mListAnchors[(paramInt2 + 1)].getResolutionNode().resolve(((ResolutionAnchor)localObject2).resolvedTarget, f1 + f2);
              paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().addResolvedValue(paramLinearSystem);
              paramConstraintWidgetContainer.mListAnchors[(paramInt2 + 1)].getResolutionNode().addResolvedValue(paramLinearSystem);
              f1 = f2 + f1 + paramConstraintWidgetContainer.mListAnchors[(paramInt2 + 1)].getMargin();
            }
          }
          for (;;)
          {
            paramConstraintWidgetContainer = paramChainHead;
            break;
            f2 = paramConstraintWidgetContainer.getHeight();
            break label1159;
            if ((m != 0) || (k != 0)) {
              if (m != 0) {
                f1 = f2 - f1;
              }
            }
            for (;;)
            {
              f2 = f1 / (j + 1);
              if (k != 0)
              {
                if (j > 1) {
                  f2 = f1 / (j - 1);
                }
              }
              else {
                if (paramConstraintWidgetContainer.getVisibility() == 8) {
                  break label1705;
                }
              }
              for (f1 = f4 + f2;; f1 = f4)
              {
                f3 = f1;
                if (k != 0)
                {
                  f3 = f1;
                  if (j > 1) {
                    f3 = localConstraintWidget2.mListAnchors[paramInt2].getMargin() + f4;
                  }
                }
                if ((m != 0) && (localConstraintWidget2 != null)) {
                  f1 = f3 + localConstraintWidget2.mListAnchors[paramInt2].getMargin();
                }
                for (;;)
                {
                  if (paramConstraintWidgetContainer != null)
                  {
                    if (LinearSystem.sMetrics != null)
                    {
                      paramChainHead = LinearSystem.sMetrics;
                      paramChainHead.nonresolvedWidgets -= 1L;
                      paramChainHead = LinearSystem.sMetrics;
                      paramChainHead.resolvedWidgets += 1L;
                      paramChainHead = LinearSystem.sMetrics;
                      paramChainHead.chainConnectionResolved += 1L;
                    }
                    paramChainHead = paramConstraintWidgetContainer.mNextChainWidget[paramInt1];
                    if (paramChainHead == null)
                    {
                      f3 = f1;
                      if (paramConstraintWidgetContainer != localConstraintWidget1) {}
                    }
                    else
                    {
                      if (paramInt1 != 0) {
                        break label1686;
                      }
                    }
                    for (f3 = paramConstraintWidgetContainer.getWidth();; f3 = paramConstraintWidgetContainer.getHeight())
                    {
                      f4 = f1;
                      if (paramConstraintWidgetContainer != localConstraintWidget2) {
                        f4 = f1 + paramConstraintWidgetContainer.mListAnchors[paramInt2].getMargin();
                      }
                      paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().resolve(((ResolutionAnchor)localObject2).resolvedTarget, f4);
                      paramConstraintWidgetContainer.mListAnchors[(paramInt2 + 1)].getResolutionNode().resolve(((ResolutionAnchor)localObject2).resolvedTarget, f4 + f3);
                      paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().addResolvedValue(paramLinearSystem);
                      paramConstraintWidgetContainer.mListAnchors[(paramInt2 + 1)].getResolutionNode().addResolvedValue(paramLinearSystem);
                      f1 = f4 + (paramConstraintWidgetContainer.mListAnchors[(paramInt2 + 1)].getMargin() + f3);
                      f3 = f1;
                      if (paramChainHead != null)
                      {
                        f3 = f1;
                        if (paramChainHead.getVisibility() != 8) {
                          f3 = f1 + f2;
                        }
                      }
                      paramConstraintWidgetContainer = paramChainHead;
                      f1 = f3;
                      break label1411;
                      if (k == 0) {
                        break label1712;
                      }
                      f1 = f2 - f1;
                      break;
                      f2 = f1 / 2.0F;
                      break label1334;
                    }
                  }
                  return true;
                  f1 = f3;
                }
              }
              f1 = f2;
            }
          }
          n = k;
          k = m;
        }
      }
    }
  }
  
  static void checkMatchParent(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget)
  {
    int i;
    int j;
    if ((paramConstraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      i = paramConstraintWidget.mLeft.mMargin;
      j = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.mMargin;
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(i, j);
    }
    if ((paramConstraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      i = paramConstraintWidget.mTop.mMargin;
      j = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.mMargin;
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
      if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
      {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      }
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(i, j);
    }
  }
  
  private static boolean optimizableMatchConstraint(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    int i = 1;
    if (paramConstraintWidget.mListDimensionBehaviors[paramInt] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {}
    do
    {
      for (;;)
      {
        return false;
        if (paramConstraintWidget.mDimensionRatio == 0.0F) {
          break;
        }
        paramConstraintWidget = paramConstraintWidget.mListDimensionBehaviors;
        if (paramInt == 0) {}
        for (paramInt = i; paramConstraintWidget[paramInt] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT; paramInt = 0) {
          return false;
        }
      }
      if (paramInt != 0) {
        break;
      }
    } while ((paramConstraintWidget.mMatchConstraintDefaultWidth != 0) || (paramConstraintWidget.mMatchConstraintMinWidth != 0) || (paramConstraintWidget.mMatchConstraintMaxWidth != 0));
    do
    {
      return true;
      if ((paramConstraintWidget.mMatchConstraintDefaultHeight != 0) || (paramConstraintWidget.mMatchConstraintMinHeight != 0)) {
        break;
      }
    } while (paramConstraintWidget.mMatchConstraintMaxHeight == 0);
    return false;
  }
  
  static void setOptimizedWidget(ConstraintWidget paramConstraintWidget, int paramInt1, int paramInt2)
  {
    int i = paramInt1 * 2;
    int j = i + 1;
    paramConstraintWidget.mListAnchors[i].getResolutionNode().resolvedTarget = paramConstraintWidget.getParent().mLeft.getResolutionNode();
    paramConstraintWidget.mListAnchors[i].getResolutionNode().resolvedOffset = paramInt2;
    paramConstraintWidget.mListAnchors[i].getResolutionNode().state = 1;
    paramConstraintWidget.mListAnchors[j].getResolutionNode().resolvedTarget = paramConstraintWidget.mListAnchors[i].getResolutionNode();
    paramConstraintWidget.mListAnchors[j].getResolutionNode().resolvedOffset = paramConstraintWidget.getLength(paramInt1);
    paramConstraintWidget.mListAnchors[j].getResolutionNode().state = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.Optimizer
 * JD-Core Version:    0.7.0.1
 */