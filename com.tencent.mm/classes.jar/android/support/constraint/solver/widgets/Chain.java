package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;

class Chain
{
  private static final boolean DEBUG = false;
  
  static void applyChainConstraints(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt)
  {
    int k = 0;
    int i;
    ChainHead[] arrayOfChainHead;
    int j;
    if (paramInt == 0)
    {
      i = paramConstraintWidgetContainer.mHorizontalChainsSize;
      arrayOfChainHead = paramConstraintWidgetContainer.mHorizontalChainsArray;
      j = 0;
    }
    while (k < i)
    {
      ChainHead localChainHead = arrayOfChainHead[k];
      localChainHead.define();
      if ((!paramConstraintWidgetContainer.optimizeFor(4)) || (!Optimizer.applyChainOptimized(paramConstraintWidgetContainer, paramLinearSystem, paramInt, j, localChainHead))) {
        applyChainConstraints(paramConstraintWidgetContainer, paramLinearSystem, paramInt, j, localChainHead);
      }
      k += 1;
      continue;
      j = 2;
      i = paramConstraintWidgetContainer.mVerticalChainsSize;
      arrayOfChainHead = paramConstraintWidgetContainer.mVerticalChainsArray;
    }
  }
  
  static void applyChainConstraints(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt1, int paramInt2, ChainHead paramChainHead)
  {
    ConstraintWidget localConstraintWidget1 = paramChainHead.mFirst;
    ConstraintWidget localConstraintWidget2 = paramChainHead.mLast;
    Object localObject1 = paramChainHead.mFirstVisibleWidget;
    ConstraintWidget localConstraintWidget3 = paramChainHead.mLastVisibleWidget;
    Object localObject5 = paramChainHead.mHead;
    int i2 = 0;
    float f2 = paramChainHead.mTotalWeight;
    int n;
    int i;
    label75:
    int j;
    label87:
    int k;
    label99:
    int i1;
    int m;
    if (paramConstraintWidgetContainer.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
    {
      n = 1;
      if (paramInt1 != 0) {
        break label450;
      }
      if (((ConstraintWidget)localObject5).mHorizontalChainStyle != 0) {
        break label432;
      }
      i = 1;
      if (((ConstraintWidget)localObject5).mHorizontalChainStyle != 1) {
        break label438;
      }
      j = 1;
      if (((ConstraintWidget)localObject5).mHorizontalChainStyle != 2) {
        break label444;
      }
      k = 1;
      i1 = k;
      localObject3 = localConstraintWidget1;
      m = i;
      k = j;
    }
    label115:
    Object localObject2;
    label211:
    label246:
    Object localObject4;
    for (;;)
    {
      if (i2 != 0) {
        break label582;
      }
      localObject2 = localObject3.mListAnchors[paramInt2];
      i = 4;
      if ((n != 0) || (i1 != 0)) {
        i = 1;
      }
      j = ((ConstraintAnchor)localObject2).getMargin();
      int i3 = j;
      if (((ConstraintAnchor)localObject2).mTarget != null)
      {
        i3 = j;
        if (localObject3 != localConstraintWidget1) {
          i3 = j + ((ConstraintAnchor)localObject2).mTarget.getMargin();
        }
      }
      if ((i1 != 0) && (localObject3 != localConstraintWidget1) && (localObject3 != localObject1))
      {
        j = 6;
        if (((ConstraintAnchor)localObject2).mTarget != null)
        {
          if (localObject3 != localObject1) {
            break label546;
          }
          paramLinearSystem.addGreaterThan(((ConstraintAnchor)localObject2).mSolverVariable, ((ConstraintAnchor)localObject2).mTarget.mSolverVariable, i3, 5);
          paramLinearSystem.addEquality(((ConstraintAnchor)localObject2).mSolverVariable, ((ConstraintAnchor)localObject2).mTarget.mSolverVariable, i3, j);
        }
        if (n != 0)
        {
          if ((((ConstraintWidget)localObject3).getVisibility() != 8) && (localObject3.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
            paramLinearSystem.addGreaterThan(localObject3.mListAnchors[(paramInt2 + 1)].mSolverVariable, localObject3.mListAnchors[paramInt2].mSolverVariable, 0, 5);
          }
          paramLinearSystem.addGreaterThan(localObject3.mListAnchors[paramInt2].mSolverVariable, paramConstraintWidgetContainer.mListAnchors[paramInt2].mSolverVariable, 0, 6);
        }
        localObject2 = localObject3.mListAnchors[(paramInt2 + 1)].mTarget;
        if (localObject2 == null) {
          break label570;
        }
        localObject4 = ((ConstraintAnchor)localObject2).mOwner;
        if (localObject4.mListAnchors[paramInt2].mTarget != null)
        {
          localObject2 = localObject4;
          if (localObject4.mListAnchors[paramInt2].mTarget.mOwner == localObject3) {
            break label414;
          }
        }
      }
      label414:
      label432:
      label438:
      label570:
      for (localObject2 = null;; localObject2 = null)
      {
        if (localObject2 == null) {
          break label576;
        }
        localObject3 = localObject2;
        break label115;
        n = 0;
        break;
        i = 0;
        break label75;
        j = 0;
        break label87;
        label444:
        k = 0;
        break label99;
        label450:
        if (((ConstraintWidget)localObject5).mVerticalChainStyle == 0)
        {
          i = 1;
          label461:
          if (((ConstraintWidget)localObject5).mVerticalChainStyle != 1) {
            break label510;
          }
          j = 1;
          label473:
          if (((ConstraintWidget)localObject5).mVerticalChainStyle != 2) {
            break label516;
          }
        }
        for (k = 1;; k = 0)
        {
          localObject3 = localConstraintWidget1;
          i1 = k;
          k = j;
          m = i;
          break;
          i = 0;
          break label461;
          label510:
          j = 0;
          break label473;
        }
        j = i;
        if (m == 0) {
          break label211;
        }
        j = i;
        if (n == 0) {
          break label211;
        }
        j = 4;
        break label211;
        paramLinearSystem.addGreaterThan(((ConstraintAnchor)localObject2).mSolverVariable, ((ConstraintAnchor)localObject2).mTarget.mSolverVariable, i3, 6);
        break label246;
      }
      label516:
      label546:
      label576:
      i2 = 1;
    }
    label582:
    if ((localConstraintWidget3 != null) && (localConstraintWidget2.mListAnchors[(paramInt2 + 1)].mTarget != null))
    {
      localObject2 = localConstraintWidget3.mListAnchors[(paramInt2 + 1)];
      paramLinearSystem.addLowerThan(((ConstraintAnchor)localObject2).mSolverVariable, localConstraintWidget2.mListAnchors[(paramInt2 + 1)].mTarget.mSolverVariable, -((ConstraintAnchor)localObject2).getMargin(), 5);
    }
    if (n != 0) {
      paramLinearSystem.addGreaterThan(paramConstraintWidgetContainer.mListAnchors[(paramInt2 + 1)].mSolverVariable, localConstraintWidget2.mListAnchors[(paramInt2 + 1)].mSolverVariable, localConstraintWidget2.mListAnchors[(paramInt2 + 1)].getMargin(), 6);
    }
    Object localObject3 = paramChainHead.mWeightedMatchConstraintsWidgets;
    float f3;
    if (localObject3 != null)
    {
      j = ((ArrayList)localObject3).size();
      if (j > 1)
      {
        paramConstraintWidgetContainer = null;
        f3 = 0.0F;
        if ((!paramChainHead.mHasUndefinedWeights) || (paramChainHead.mHasComplexMatchWeights)) {
          break label2446;
        }
        f2 = paramChainHead.mWidgetsMatchCount;
      }
    }
    label1285:
    label1798:
    label2440:
    label2446:
    for (;;)
    {
      i = 0;
      float f1;
      Object localObject6;
      SolverVariable localSolverVariable;
      Object localObject7;
      if (i < j)
      {
        localObject2 = (ConstraintWidget)((ArrayList)localObject3).get(i);
        float f4 = localObject2.mWeight[paramInt1];
        f1 = f4;
        if (f4 < 0.0F) {
          if (paramChainHead.mHasComplexMatchWeights) {
            paramLinearSystem.addEquality(localObject2.mListAnchors[(paramInt2 + 1)].mSolverVariable, localObject2.mListAnchors[paramInt2].mSolverVariable, 0, 4);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          f1 = 1.0F;
          if (f1 == 0.0F)
          {
            paramLinearSystem.addEquality(localObject2.mListAnchors[(paramInt2 + 1)].mSolverVariable, localObject2.mListAnchors[paramInt2].mSolverVariable, 0, 6);
          }
          else
          {
            if (paramConstraintWidgetContainer != null)
            {
              localObject4 = paramConstraintWidgetContainer.mListAnchors[paramInt2].mSolverVariable;
              paramConstraintWidgetContainer = paramConstraintWidgetContainer.mListAnchors[(paramInt2 + 1)].mSolverVariable;
              localObject6 = localObject2.mListAnchors[paramInt2].mSolverVariable;
              localSolverVariable = localObject2.mListAnchors[(paramInt2 + 1)].mSolverVariable;
              localObject7 = paramLinearSystem.createRow();
              ((ArrayRow)localObject7).createRowEqualMatchDimensions(f3, f2, f1, (SolverVariable)localObject4, paramConstraintWidgetContainer, (SolverVariable)localObject6, localSolverVariable);
              paramLinearSystem.addConstraint((ArrayRow)localObject7);
            }
            f3 = f1;
            paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject2;
          }
        }
      }
      label1309:
      if ((localObject1 != null) && ((localObject1 == localConstraintWidget3) || (i1 != 0)))
      {
        localObject3 = localConstraintWidget1.mListAnchors[paramInt2];
        localObject2 = localConstraintWidget2.mListAnchors[(paramInt2 + 1)];
        if (localConstraintWidget1.mListAnchors[paramInt2].mTarget != null)
        {
          paramConstraintWidgetContainer = localConstraintWidget1.mListAnchors[paramInt2].mTarget.mSolverVariable;
          if (localConstraintWidget2.mListAnchors[(paramInt2 + 1)].mTarget == null) {
            break label1350;
          }
          paramChainHead = localConstraintWidget2.mListAnchors[(paramInt2 + 1)].mTarget.mSolverVariable;
          label1065:
          if (localObject1 == localConstraintWidget3)
          {
            localObject3 = localObject1.mListAnchors[paramInt2];
            localObject2 = localObject1.mListAnchors[(paramInt2 + 1)];
          }
          if ((paramConstraintWidgetContainer != null) && (paramChainHead != null)) {
            if (paramInt1 != 0) {
              break label1356;
            }
          }
        }
        label1201:
        label1218:
        label1350:
        label1356:
        for (f1 = ((ConstraintWidget)localObject5).mHorizontalBiasPercent;; f1 = ((ConstraintWidget)localObject5).mVerticalBiasPercent)
        {
          paramInt1 = ((ConstraintAnchor)localObject3).getMargin();
          i = ((ConstraintAnchor)localObject2).getMargin();
          paramLinearSystem.addCentering(((ConstraintAnchor)localObject3).mSolverVariable, paramConstraintWidgetContainer, paramInt1, f1, paramChainHead, ((ConstraintAnchor)localObject2).mSolverVariable, i, 5);
          if (((m != 0) || (k != 0)) && (localObject1 != null))
          {
            localObject3 = localObject1.mListAnchors[paramInt2];
            localObject2 = localConstraintWidget3.mListAnchors[(paramInt2 + 1)];
            if (((ConstraintAnchor)localObject3).mTarget == null) {
              break label2395;
            }
            paramChainHead = ((ConstraintAnchor)localObject3).mTarget.mSolverVariable;
            if (((ConstraintAnchor)localObject2).mTarget == null) {
              break label2401;
            }
            paramConstraintWidgetContainer = ((ConstraintAnchor)localObject2).mTarget.mSolverVariable;
            if (localConstraintWidget2 != localConstraintWidget3)
            {
              paramConstraintWidgetContainer = localConstraintWidget2.mListAnchors[(paramInt2 + 1)];
              if (paramConstraintWidgetContainer.mTarget == null) {
                break label2406;
              }
              paramConstraintWidgetContainer = paramConstraintWidgetContainer.mTarget.mSolverVariable;
            }
            label1250:
            if (localObject1 != localConstraintWidget3) {
              break label2418;
            }
            localObject2 = localObject1.mListAnchors[paramInt2];
            localObject3 = localObject1.mListAnchors[(paramInt2 + 1)];
            localObject1 = localObject2;
            localObject2 = localObject3;
            if ((paramChainHead != null) && (paramConstraintWidgetContainer != null))
            {
              paramInt1 = ((ConstraintAnchor)localObject1).getMargin();
              if (localConstraintWidget3 != null) {
                break label2411;
              }
              localObject3 = localConstraintWidget2;
              paramInt2 = localObject3.mListAnchors[(paramInt2 + 1)].getMargin();
              paramLinearSystem.addCentering(((ConstraintAnchor)localObject1).mSolverVariable, paramChainHead, paramInt1, 0.5F, paramConstraintWidgetContainer, ((ConstraintAnchor)localObject2).mSolverVariable, paramInt2, 5);
            }
          }
          return;
          paramConstraintWidgetContainer = null;
          break;
          paramChainHead = null;
          break label1065;
        }
      }
      if ((m != 0) && (localObject1 != null))
      {
        if ((paramChainHead.mWidgetsMatchCount > 0) && (paramChainHead.mWidgetsCount == paramChainHead.mWidgetsMatchCount)) {}
        for (n = 1;; n = 0)
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (localObject2 == null) {
            break label1736;
          }
          for (paramChainHead = localObject2.mNextChainWidget[paramInt1]; (paramChainHead != null) && (paramChainHead.getVisibility() == 8); paramChainHead = paramChainHead.mNextChainWidget[paramInt1]) {}
        }
        if ((paramChainHead != null) || (localObject2 == localConstraintWidget3))
        {
          localObject5 = localObject2.mListAnchors[paramInt2];
          localSolverVariable = ((ConstraintAnchor)localObject5).mSolverVariable;
          if (((ConstraintAnchor)localObject5).mTarget == null) {
            break label1738;
          }
          paramConstraintWidgetContainer = ((ConstraintAnchor)localObject5).mTarget.mSolverVariable;
          label1500:
          if (localObject3 == localObject2) {
            break label1743;
          }
          paramConstraintWidgetContainer = localObject3.mListAnchors[(paramInt2 + 1)].mSolverVariable;
          label1520:
          localObject4 = paramConstraintWidgetContainer;
          label1523:
          paramConstraintWidgetContainer = null;
          i1 = ((ConstraintAnchor)localObject5).getMargin();
          j = localObject2.mListAnchors[(paramInt2 + 1)].getMargin();
          if (paramChainHead == null) {
            break label1798;
          }
          localObject5 = paramChainHead.mListAnchors[paramInt2];
          paramConstraintWidgetContainer = ((ConstraintAnchor)localObject5).mSolverVariable;
          label1566:
          localObject6 = localObject2.mListAnchors[(paramInt2 + 1)].mSolverVariable;
          i = j;
          if (localObject5 != null) {
            i = j + ((ConstraintAnchor)localObject5).getMargin();
          }
          j = i1;
          if (localObject3 != null) {
            j = i1 + localObject3.mListAnchors[(paramInt2 + 1)].getMargin();
          }
          if ((localSolverVariable != null) && (localObject4 != null) && (paramConstraintWidgetContainer != null) && (localObject6 != null))
          {
            if (localObject2 == localObject1) {
              j = localObject1.mListAnchors[paramInt2].getMargin();
            }
            if (localObject2 == localConstraintWidget3) {
              i = localConstraintWidget3.mListAnchors[(paramInt2 + 1)].getMargin();
            }
            i1 = 4;
            if (n != 0) {
              i1 = 6;
            }
            paramLinearSystem.addCentering(localSolverVariable, (SolverVariable)localObject4, j, 0.5F, paramConstraintWidgetContainer, (SolverVariable)localObject6, i, i1);
          }
        }
        if (((ConstraintWidget)localObject2).getVisibility() == 8) {
          break label2440;
        }
      }
      for (paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject2;; paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject3)
      {
        localObject2 = paramChainHead;
        localObject3 = paramConstraintWidgetContainer;
        break label1408;
        label1736:
        break;
        label1738:
        paramConstraintWidgetContainer = null;
        break label1500;
        label1743:
        localObject4 = paramConstraintWidgetContainer;
        if (localObject2 != localObject1) {
          break label1523;
        }
        localObject4 = paramConstraintWidgetContainer;
        if (localObject3 != localObject2) {
          break label1523;
        }
        if (localConstraintWidget1.mListAnchors[paramInt2].mTarget != null)
        {
          paramConstraintWidgetContainer = localConstraintWidget1.mListAnchors[paramInt2].mTarget.mSolverVariable;
          break label1520;
        }
        paramConstraintWidgetContainer = null;
        break label1520;
        localObject6 = localConstraintWidget2.mListAnchors[(paramInt2 + 1)].mTarget;
        localObject5 = localObject6;
        if (localObject6 == null) {
          break label1566;
        }
        paramConstraintWidgetContainer = ((ConstraintAnchor)localObject6).mSolverVariable;
        localObject5 = localObject6;
        break label1566;
        if ((k == 0) || (localObject1 == null)) {
          break;
        }
        if ((paramChainHead.mWidgetsMatchCount > 0) && (paramChainHead.mWidgetsCount == paramChainHead.mWidgetsMatchCount)) {}
        for (i = 1;; i = 0)
        {
          localObject2 = localObject1;
          paramChainHead = (ChainHead)localObject1;
          label1876:
          if (paramChainHead == null) {
            break label2239;
          }
          for (paramConstraintWidgetContainer = paramChainHead.mNextChainWidget[paramInt1]; (paramConstraintWidgetContainer != null) && (paramConstraintWidgetContainer.getVisibility() == 8); paramConstraintWidgetContainer = paramConstraintWidgetContainer.mNextChainWidget[paramInt1]) {}
        }
        if ((paramChainHead != localObject1) && (paramChainHead != localConstraintWidget3) && (paramConstraintWidgetContainer != null)) {
          if (paramConstraintWidgetContainer == localConstraintWidget3)
          {
            paramConstraintWidgetContainer = null;
            label1944:
            localObject4 = paramChainHead.mListAnchors[paramInt2];
            localSolverVariable = ((ConstraintAnchor)localObject4).mSolverVariable;
            localObject7 = localObject2.mListAnchors[(paramInt2 + 1)].mSolverVariable;
            localObject3 = null;
            i1 = ((ConstraintAnchor)localObject4).getMargin();
            n = paramChainHead.mListAnchors[(paramInt2 + 1)].getMargin();
            if (paramConstraintWidgetContainer != null)
            {
              localObject6 = paramConstraintWidgetContainer.mListAnchors[paramInt2];
              localObject4 = ((ConstraintAnchor)localObject6).mSolverVariable;
              if (((ConstraintAnchor)localObject6).mTarget != null)
              {
                localObject3 = ((ConstraintAnchor)localObject6).mTarget.mSolverVariable;
                label2035:
                localObject5 = localObject3;
                localObject3 = localObject6;
                label2043:
                j = n;
                if (localObject3 != null) {
                  j = n + ((ConstraintAnchor)localObject3).getMargin();
                }
                n = i1;
                if (localObject2 != null) {
                  n = i1 + localObject2.mListAnchors[(paramInt2 + 1)].getMargin();
                }
                i1 = 4;
                if (i != 0) {
                  i1 = 6;
                }
                localObject3 = paramConstraintWidgetContainer;
                if (localSolverVariable != null)
                {
                  localObject3 = paramConstraintWidgetContainer;
                  if (localObject7 != null)
                  {
                    localObject3 = paramConstraintWidgetContainer;
                    if (localObject4 != null)
                    {
                      localObject3 = paramConstraintWidgetContainer;
                      if (localObject5 != null) {
                        paramLinearSystem.addCentering(localSolverVariable, (SolverVariable)localObject7, n, 0.5F, (SolverVariable)localObject4, (SolverVariable)localObject5, j, i1);
                      }
                    }
                  }
                }
              }
            }
          }
        }
        for (localObject3 = paramConstraintWidgetContainer;; localObject3 = paramConstraintWidgetContainer)
        {
          if (paramChainHead.getVisibility() != 8) {}
          for (paramConstraintWidgetContainer = paramChainHead;; paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject2)
          {
            paramChainHead = (ChainHead)localObject3;
            localObject2 = paramConstraintWidgetContainer;
            break label1876;
            localObject3 = null;
            break label2035;
            localObject5 = paramChainHead.mListAnchors[(paramInt2 + 1)].mTarget;
            if (localObject5 != null) {
              localObject3 = ((ConstraintAnchor)localObject5).mSolverVariable;
            }
            localObject6 = paramChainHead.mListAnchors[(paramInt2 + 1)].mSolverVariable;
            localObject4 = localObject3;
            localObject3 = localObject5;
            localObject5 = localObject6;
            break label2043;
            label2239:
            paramConstraintWidgetContainer = localObject1.mListAnchors[paramInt2];
            paramChainHead = localConstraintWidget1.mListAnchors[paramInt2].mTarget;
            localObject2 = localConstraintWidget3.mListAnchors[(paramInt2 + 1)];
            localObject3 = localConstraintWidget2.mListAnchors[(paramInt2 + 1)].mTarget;
            if (paramChainHead != null)
            {
              if (localObject1 == localConstraintWidget3) {
                break label2352;
              }
              paramLinearSystem.addEquality(paramConstraintWidgetContainer.mSolverVariable, paramChainHead.mSolverVariable, paramConstraintWidgetContainer.getMargin(), 5);
            }
            for (;;)
            {
              if ((localObject3 == null) || (localObject1 == localConstraintWidget3)) {
                break label2393;
              }
              paramLinearSystem.addEquality(((ConstraintAnchor)localObject2).mSolverVariable, ((ConstraintAnchor)localObject3).mSolverVariable, -((ConstraintAnchor)localObject2).getMargin(), 5);
              break;
              label2352:
              if (localObject3 != null) {
                paramLinearSystem.addCentering(paramConstraintWidgetContainer.mSolverVariable, paramChainHead.mSolverVariable, paramConstraintWidgetContainer.getMargin(), 0.5F, ((ConstraintAnchor)localObject2).mSolverVariable, ((ConstraintAnchor)localObject3).mSolverVariable, ((ConstraintAnchor)localObject2).getMargin(), 5);
              }
            }
            label2393:
            break;
            label2395:
            paramChainHead = null;
            break label1201;
            label2401:
            paramConstraintWidgetContainer = null;
            break label1218;
            label2406:
            paramConstraintWidgetContainer = null;
            break label1250;
            label2411:
            localObject3 = localConstraintWidget3;
            break label1309;
            label2418:
            localObject1 = localObject3;
            break label1285;
          }
          break label1944;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.Chain
 * JD-Core Version:    0.7.0.1
 */