package android.support.constraint.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Analyzer
{
  public static void determineGroups(ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    if ((paramConstraintWidgetContainer.getOptimizationLevel() & 0x20) != 32)
    {
      singleGroup(paramConstraintWidgetContainer);
      return;
    }
    paramConstraintWidgetContainer.mSkipSolver = true;
    paramConstraintWidgetContainer.mGroupsWrapOptimized = false;
    paramConstraintWidgetContainer.mHorizontalWrapOptimized = false;
    paramConstraintWidgetContainer.mVerticalWrapOptimized = false;
    Object localObject1 = paramConstraintWidgetContainer.mChildren;
    List localList = paramConstraintWidgetContainer.mWidgetGroups;
    int i;
    int j;
    if (paramConstraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
    {
      i = 1;
      if (paramConstraintWidgetContainer.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        break label147;
      }
      j = 1;
      label73:
      if ((i == 0) && (j == 0)) {
        break label152;
      }
    }
    Object localObject2;
    label147:
    label152:
    for (boolean bool = true;; bool = false)
    {
      localList.clear();
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)((Iterator)localObject2).next();
        localConstraintWidget.mBelongingGroup = null;
        localConstraintWidget.mGroupsToSolver = false;
        localConstraintWidget.resetResolutionNodes();
      }
      i = 0;
      break;
      j = 0;
      break label73;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ConstraintWidget)((Iterator)localObject1).next();
      if ((((ConstraintWidget)localObject2).mBelongingGroup == null) && (!determineGroups((ConstraintWidget)localObject2, localList, bool)))
      {
        singleGroup(paramConstraintWidgetContainer);
        paramConstraintWidgetContainer.mSkipSolver = false;
        return;
      }
    }
    localObject1 = localList.iterator();
    int k = 0;
    int m = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ConstraintWidgetGroup)((Iterator)localObject1).next();
      m = Math.max(m, getMaxDimension((ConstraintWidgetGroup)localObject2, 0));
      k = Math.max(k, getMaxDimension((ConstraintWidgetGroup)localObject2, 1));
    }
    if (i != 0)
    {
      paramConstraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      paramConstraintWidgetContainer.setWidth(m);
      paramConstraintWidgetContainer.mGroupsWrapOptimized = true;
      paramConstraintWidgetContainer.mHorizontalWrapOptimized = true;
      paramConstraintWidgetContainer.mWrapFixedWidth = m;
    }
    if (j != 0)
    {
      paramConstraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      paramConstraintWidgetContainer.setHeight(k);
      paramConstraintWidgetContainer.mGroupsWrapOptimized = true;
      paramConstraintWidgetContainer.mVerticalWrapOptimized = true;
      paramConstraintWidgetContainer.mWrapFixedHeight = k;
    }
    setPosition(localList, 0, paramConstraintWidgetContainer.getWidth());
    setPosition(localList, 1, paramConstraintWidgetContainer.getHeight());
  }
  
  private static boolean determineGroups(ConstraintWidget paramConstraintWidget, List<ConstraintWidgetGroup> paramList, boolean paramBoolean)
  {
    ConstraintWidgetGroup localConstraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList(), true);
    paramList.add(localConstraintWidgetGroup);
    return traverse(paramConstraintWidget, localConstraintWidgetGroup, paramList, paramBoolean);
  }
  
  private static int getMaxDimension(ConstraintWidgetGroup paramConstraintWidgetGroup, int paramInt)
  {
    int k = paramInt * 2;
    List localList = paramConstraintWidgetGroup.getStartWidgets(paramInt);
    int m = localList.size();
    int i = 0;
    int j = 0;
    if (i < m)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)localList.get(i);
      if ((localConstraintWidget.mListAnchors[(k + 1)].mTarget == null) || ((localConstraintWidget.mListAnchors[k].mTarget != null) && (localConstraintWidget.mListAnchors[(k + 1)].mTarget != null))) {}
      for (boolean bool = true;; bool = false)
      {
        j = Math.max(j, getMaxDimensionTraversal(localConstraintWidget, paramInt, bool, 0));
        i += 1;
        break;
      }
    }
    paramConstraintWidgetGroup.mGroupDimensions[paramInt] = j;
    return j;
  }
  
  private static int getMaxDimensionTraversal(ConstraintWidget paramConstraintWidget, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (!paramConstraintWidget.mOptimizerMeasurable)
    {
      paramInt2 = 0;
      return paramInt2;
    }
    int k;
    int i1;
    int n;
    int j;
    label61:
    int i2;
    int m;
    label94:
    int i3;
    int i6;
    int i8;
    if ((paramConstraintWidget.mBaseline.mTarget != null) && (paramInt1 == 1))
    {
      k = 1;
      if (!paramBoolean) {
        break label221;
      }
      i1 = paramConstraintWidget.getBaselineDistance();
      n = paramConstraintWidget.getHeight() - paramConstraintWidget.getBaselineDistance();
      j = paramInt1 * 2;
      i = j + 1;
      if ((paramConstraintWidget.mListAnchors[i].mTarget == null) || (paramConstraintWidget.mListAnchors[j].mTarget != null)) {
        break label252;
      }
      i2 = -1;
      m = i;
      i3 = paramInt2;
      if (k != 0) {
        i3 = paramInt2 - i1;
      }
      i6 = paramConstraintWidget.mListAnchors[m].getMargin() * i2 + getParentBiasOffset(paramConstraintWidget, paramInt1);
      i8 = i6 + i3;
      if (paramInt1 != 0) {
        break label266;
      }
    }
    int i7;
    label266:
    for (paramInt2 = paramConstraintWidget.getWidth();; paramInt2 = paramConstraintWidget.getHeight())
    {
      i7 = paramInt2 * i2;
      localObject = paramConstraintWidget.mListAnchors[m].getResolutionNode().dependents.iterator();
      for (paramInt2 = 0; ((Iterator)localObject).hasNext(); paramInt2 = Math.max(paramInt2, getMaxDimensionTraversal(((ResolutionAnchor)((Iterator)localObject).next()).myAnchor.mOwner, paramInt1, paramBoolean, i8))) {}
      k = 0;
      break;
      label221:
      i1 = paramConstraintWidget.getHeight() - paramConstraintWidget.getBaselineDistance();
      n = paramConstraintWidget.getBaselineDistance();
      i = paramInt1 * 2;
      j = i + 1;
      break label61;
      label252:
      i2 = 1;
      m = j;
      j = i;
      break label94;
    }
    Object localObject = paramConstraintWidget.mListAnchors[j].getResolutionNode().dependents.iterator();
    for (int i = 0; ((Iterator)localObject).hasNext(); i = Math.max(i, getMaxDimensionTraversal(((ResolutionAnchor)((Iterator)localObject).next()).myAnchor.mOwner, paramInt1, paramBoolean, i7 + i8))) {}
    int i4;
    int i5;
    if (k != 0)
    {
      i4 = i + n;
      i5 = paramInt2 - i1;
      if (paramInt1 == 1)
      {
        localObject = paramConstraintWidget.mBaseline.getResolutionNode().dependents.iterator();
        paramInt2 = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label505;
        }
        ResolutionAnchor localResolutionAnchor = (ResolutionAnchor)((Iterator)localObject).next();
        if (i2 == 1)
        {
          paramInt2 = Math.max(paramInt2, getMaxDimensionTraversal(localResolutionAnchor.myAnchor.mOwner, paramInt1, paramBoolean, i1 + i8));
          continue;
          if (paramInt1 == 0) {}
          for (i4 = paramConstraintWidget.getWidth();; i4 = paramConstraintWidget.getHeight())
          {
            i4 = i4 * i2 + i;
            i5 = paramInt2;
            break;
          }
        }
        else
        {
          paramInt2 = Math.max(paramInt2, getMaxDimensionTraversal(localResolutionAnchor.myAnchor.mOwner, paramInt1, paramBoolean, n * i2 + i8));
        }
      }
      label505:
      i = paramInt2;
      if (paramConstraintWidget.mBaseline.getResolutionNode().dependents.size() > 0)
      {
        i = paramInt2;
        if (k == 0)
        {
          if (i2 != 1) {
            break label719;
          }
          i = paramInt2 + i1;
        }
      }
    }
    for (;;)
    {
      label544:
      n = Math.max(i5, Math.max(i4, i)) + i6;
      paramInt2 = i3 + i6;
      i = paramInt2 + i7;
      if (i2 == -1) {}
      for (;;)
      {
        if (paramBoolean)
        {
          Optimizer.setOptimizedWidget(paramConstraintWidget, paramInt1, i);
          paramConstraintWidget.setFrame(i, paramInt2, paramInt1);
        }
        for (;;)
        {
          if ((paramConstraintWidget.getDimensionBehaviour(paramInt1) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.mDimensionRatio != 0.0F)) {
            paramConstraintWidget.mBelongingGroup.addWidgetsToSet(paramConstraintWidget, paramInt1);
          }
          paramInt2 = n;
          if (paramConstraintWidget.mListAnchors[m].mTarget == null) {
            break;
          }
          paramInt2 = n;
          if (paramConstraintWidget.mListAnchors[j].mTarget == null) {
            break;
          }
          localObject = paramConstraintWidget.getParent();
          paramInt2 = n;
          if (paramConstraintWidget.mListAnchors[m].mTarget.mOwner != localObject) {
            break;
          }
          paramInt2 = n;
          if (paramConstraintWidget.mListAnchors[j].mTarget.mOwner != localObject) {
            break;
          }
          paramConstraintWidget.mBelongingGroup.addWidgetsToSet(paramConstraintWidget, paramInt1);
          return n;
          label719:
          i = paramInt2 - n;
          break label544;
          paramConstraintWidget.mBelongingGroup.addWidgetsToSet(paramConstraintWidget, paramInt1);
          paramConstraintWidget.setRelativePositioning(i, paramInt1);
        }
        k = paramInt2;
        paramInt2 = i;
        i = k;
      }
      i = 0;
    }
  }
  
  private static int getParentBiasOffset(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    int i = paramInt * 2;
    ConstraintAnchor localConstraintAnchor1 = paramConstraintWidget.mListAnchors[i];
    ConstraintAnchor localConstraintAnchor2 = paramConstraintWidget.mListAnchors[(i + 1)];
    if ((localConstraintAnchor1.mTarget != null) && (localConstraintAnchor1.mTarget.mOwner == paramConstraintWidget.mParent) && (localConstraintAnchor2.mTarget != null) && (localConstraintAnchor2.mTarget.mOwner == paramConstraintWidget.mParent))
    {
      i = paramConstraintWidget.mParent.getLength(paramInt);
      if (paramInt == 0) {}
      for (float f = paramConstraintWidget.mHorizontalBiasPercent;; f = paramConstraintWidget.mVerticalBiasPercent)
      {
        paramInt = paramConstraintWidget.getLength(paramInt);
        return (int)(f * (i - localConstraintAnchor1.getMargin() - localConstraintAnchor2.getMargin() - paramInt));
      }
    }
    return 0;
  }
  
  private static void invalidate(ConstraintWidgetContainer paramConstraintWidgetContainer, ConstraintWidget paramConstraintWidget, ConstraintWidgetGroup paramConstraintWidgetGroup)
  {
    paramConstraintWidgetGroup.mSkipSolver = false;
    paramConstraintWidgetContainer.mSkipSolver = false;
    paramConstraintWidget.mOptimizerMeasurable = false;
  }
  
  private static int resolveDimensionRatio(ConstraintWidget paramConstraintWidget)
  {
    int i = -1;
    if (paramConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      if (paramConstraintWidget.mDimensionRatioSide == 0)
      {
        i = (int)(paramConstraintWidget.getHeight() * paramConstraintWidget.mDimensionRatio);
        paramConstraintWidget.setWidth(i);
      }
    }
    while (paramConstraintWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      for (;;)
      {
        return i;
        i = (int)(paramConstraintWidget.getHeight() / paramConstraintWidget.mDimensionRatio);
      }
    }
    if (paramConstraintWidget.mDimensionRatioSide == 1) {}
    for (i = (int)(paramConstraintWidget.getWidth() * paramConstraintWidget.mDimensionRatio);; i = (int)(paramConstraintWidget.getWidth() / paramConstraintWidget.mDimensionRatio))
    {
      paramConstraintWidget.setHeight(i);
      return i;
    }
  }
  
  private static void setConnection(ConstraintAnchor paramConstraintAnchor)
  {
    ResolutionAnchor localResolutionAnchor = paramConstraintAnchor.getResolutionNode();
    if ((paramConstraintAnchor.mTarget != null) && (paramConstraintAnchor.mTarget.mTarget != paramConstraintAnchor)) {
      paramConstraintAnchor.mTarget.getResolutionNode().addDependent(localResolutionAnchor);
    }
  }
  
  public static void setPosition(List<ConstraintWidgetGroup> paramList, int paramInt1, int paramInt2)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((ConstraintWidgetGroup)paramList.get(i)).getWidgetsToSet(paramInt1).iterator();
      while (localIterator.hasNext())
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)localIterator.next();
        if (localConstraintWidget.mOptimizerMeasurable) {
          updateSizeDependentWidgets(localConstraintWidget, paramInt1, paramInt2);
        }
      }
      i += 1;
    }
  }
  
  private static void singleGroup(ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    paramConstraintWidgetContainer.mWidgetGroups.clear();
    paramConstraintWidgetContainer.mWidgetGroups.add(0, new ConstraintWidgetGroup(paramConstraintWidgetContainer.mChildren));
  }
  
  private static boolean traverse(ConstraintWidget paramConstraintWidget, ConstraintWidgetGroup paramConstraintWidgetGroup, List<ConstraintWidgetGroup> paramList, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramConstraintWidget == null) {
      bool1 = true;
    }
    Object localObject;
    int i;
    label313:
    label326:
    label840:
    label975:
    do
    {
      ConstraintWidgetContainer localConstraintWidgetContainer;
      do
      {
        return bool1;
        paramConstraintWidget.mOptimizerMeasured = false;
        localConstraintWidgetContainer = (ConstraintWidgetContainer)paramConstraintWidget.getParent();
        if (paramConstraintWidget.mBelongingGroup != null) {
          break label840;
        }
        paramConstraintWidget.mOptimizerMeasurable = true;
        paramConstraintWidgetGroup.mConstrainedGroup.add(paramConstraintWidget);
        paramConstraintWidget.mBelongingGroup = paramConstraintWidgetGroup;
        if ((paramConstraintWidget.mLeft.mTarget != null) || (paramConstraintWidget.mRight.mTarget != null) || (paramConstraintWidget.mTop.mTarget != null) || (paramConstraintWidget.mBottom.mTarget != null) || (paramConstraintWidget.mBaseline.mTarget != null) || (paramConstraintWidget.mCenter.mTarget != null)) {
          break;
        }
        invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
        bool1 = bool2;
      } while (paramBoolean);
      if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mBottom.mTarget != null))
      {
        localConstraintWidgetContainer.getVerticalDimensionBehaviour();
        localObject = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (paramBoolean)
        {
          invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
          return false;
        }
        if ((paramConstraintWidget.mTop.mTarget.mOwner != paramConstraintWidget.getParent()) || (paramConstraintWidget.mBottom.mTarget.mOwner != paramConstraintWidget.getParent())) {
          invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
        }
      }
      if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mRight.mTarget != null))
      {
        localConstraintWidgetContainer.getHorizontalDimensionBehaviour();
        localObject = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (paramBoolean)
        {
          invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
          return false;
        }
        if ((paramConstraintWidget.mLeft.mTarget.mOwner != paramConstraintWidget.getParent()) || (paramConstraintWidget.mRight.mTarget.mOwner != paramConstraintWidget.getParent())) {
          invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
        }
      }
      if (paramConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        i = 1;
        if (paramConstraintWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          break label801;
        }
        j = 1;
        if (((i ^ j) == 0) || (paramConstraintWidget.mDimensionRatio == 0.0F)) {
          break label807;
        }
        resolveDimensionRatio(paramConstraintWidget);
      }
      do
      {
        do
        {
          if (((paramConstraintWidget.mLeft.mTarget == null) && (paramConstraintWidget.mRight.mTarget == null)) || ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mLeft.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mRight.mTarget == null)) || ((paramConstraintWidget.mRight.mTarget != null) && (paramConstraintWidget.mRight.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mLeft.mTarget == null)) || ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mLeft.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mRight.mTarget != null) && (paramConstraintWidget.mRight.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mCenter.mTarget == null) && (!(paramConstraintWidget instanceof Guideline)) && (!(paramConstraintWidget instanceof Helper)))) {
            paramConstraintWidgetGroup.mStartHorizontalWidgets.add(paramConstraintWidget);
          }
          if (((paramConstraintWidget.mTop.mTarget == null) && (paramConstraintWidget.mBottom.mTarget == null)) || ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mTop.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mBottom.mTarget == null)) || ((paramConstraintWidget.mBottom.mTarget != null) && (paramConstraintWidget.mBottom.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mTop.mTarget == null)) || ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mTop.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mBottom.mTarget != null) && (paramConstraintWidget.mBottom.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mCenter.mTarget == null) && (paramConstraintWidget.mBaseline.mTarget == null) && (!(paramConstraintWidget instanceof Guideline)) && (!(paramConstraintWidget instanceof Helper)))) {
            paramConstraintWidgetGroup.mStartVerticalWidgets.add(paramConstraintWidget);
          }
          if (!(paramConstraintWidget instanceof Helper)) {
            break label965;
          }
          invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
          bool1 = bool2;
          if (paramBoolean) {
            break;
          }
          localObject = (Helper)paramConstraintWidget;
          i = 0;
          for (;;)
          {
            if (i >= ((Helper)localObject).mWidgetsCount) {
              break label965;
            }
            bool1 = bool2;
            if (!traverse(localObject.mWidgets[i], paramConstraintWidgetGroup, paramList, paramBoolean)) {
              break;
            }
            i += 1;
          }
          i = 0;
          break label313;
          j = 0;
          break label326;
        } while ((paramConstraintWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT));
        invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
      } while (!paramBoolean);
      return false;
      if (paramConstraintWidget.mBelongingGroup != paramConstraintWidgetGroup)
      {
        paramConstraintWidgetGroup.mConstrainedGroup.addAll(paramConstraintWidget.mBelongingGroup.mConstrainedGroup);
        paramConstraintWidgetGroup.mStartHorizontalWidgets.addAll(paramConstraintWidget.mBelongingGroup.mStartHorizontalWidgets);
        paramConstraintWidgetGroup.mStartVerticalWidgets.addAll(paramConstraintWidget.mBelongingGroup.mStartVerticalWidgets);
        if (!paramConstraintWidget.mBelongingGroup.mSkipSolver) {
          paramConstraintWidgetGroup.mSkipSolver = false;
        }
        paramList.remove(paramConstraintWidget.mBelongingGroup);
        paramConstraintWidget = paramConstraintWidget.mBelongingGroup.mConstrainedGroup.iterator();
        while (paramConstraintWidget.hasNext()) {
          ((ConstraintWidget)paramConstraintWidget.next()).mBelongingGroup = paramConstraintWidgetGroup;
        }
      }
      return true;
      int j = paramConstraintWidget.mListAnchors.length;
      i = 0;
      if (i >= j) {
        break label1078;
      }
      localObject = paramConstraintWidget.mListAnchors[i];
      if ((((ConstraintAnchor)localObject).mTarget == null) || (((ConstraintAnchor)localObject).mTarget.mOwner == paramConstraintWidget.getParent())) {
        break;
      }
      if (((ConstraintAnchor)localObject).mType != ConstraintAnchor.Type.CENTER) {
        break label1070;
      }
      invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
      bool1 = bool2;
    } while (paramBoolean);
    for (;;)
    {
      label801:
      label807:
      label965:
      bool1 = bool2;
      if (!traverse(((ConstraintAnchor)localObject).mTarget.mOwner, paramConstraintWidgetGroup, paramList, paramBoolean)) {
        break;
      }
      i += 1;
      break label975;
      label1070:
      setConnection((ConstraintAnchor)localObject);
    }
    label1078:
    return true;
  }
  
  private static void updateSizeDependentWidgets(ConstraintWidget paramConstraintWidget, int paramInt1, int paramInt2)
  {
    int j = paramInt1 * 2;
    ConstraintAnchor localConstraintAnchor1 = paramConstraintWidget.mListAnchors[j];
    ConstraintAnchor localConstraintAnchor2 = paramConstraintWidget.mListAnchors[(j + 1)];
    if ((localConstraintAnchor1.mTarget != null) && (localConstraintAnchor2.mTarget != null)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Optimizer.setOptimizedWidget(paramConstraintWidget, paramInt1, getParentBiasOffset(paramConstraintWidget, paramInt1) + localConstraintAnchor1.getMargin());
      return;
    }
    if ((paramConstraintWidget.mDimensionRatio != 0.0F) && (paramConstraintWidget.getDimensionBehaviour(paramInt1) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
    {
      paramInt2 = resolveDimensionRatio(paramConstraintWidget);
      i = (int)paramConstraintWidget.mListAnchors[j].getResolutionNode().resolvedOffset;
      localConstraintAnchor2.getResolutionNode().resolvedTarget = localConstraintAnchor1.getResolutionNode();
      localConstraintAnchor2.getResolutionNode().resolvedOffset = paramInt2;
      localConstraintAnchor2.getResolutionNode().state = 1;
      paramConstraintWidget.setFrame(i, i + paramInt2, paramInt1);
      return;
    }
    paramInt2 -= paramConstraintWidget.getRelativePositioning(paramInt1);
    i = paramInt2 - paramConstraintWidget.getLength(paramInt1);
    paramConstraintWidget.setFrame(i, paramInt2, paramInt1);
    Optimizer.setOptimizedWidget(paramConstraintWidget, paramInt1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.Analyzer
 * JD-Core Version:    0.7.0.1
 */