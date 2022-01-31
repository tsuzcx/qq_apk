package android.support.constraint.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstraintWidgetGroup
{
  public List<ConstraintWidget> mConstrainedGroup;
  public final int[] mGroupDimensions = { this.mGroupWidth, this.mGroupHeight };
  int mGroupHeight = -1;
  int mGroupWidth = -1;
  public boolean mSkipSolver = false;
  List<ConstraintWidget> mStartHorizontalWidgets = new ArrayList();
  List<ConstraintWidget> mStartVerticalWidgets = new ArrayList();
  List<ConstraintWidget> mUnresolvedWidgets = new ArrayList();
  HashSet<ConstraintWidget> mWidgetsToSetHorizontal = new HashSet();
  HashSet<ConstraintWidget> mWidgetsToSetVertical = new HashSet();
  List<ConstraintWidget> mWidgetsToSolve = new ArrayList();
  
  ConstraintWidgetGroup(List<ConstraintWidget> paramList)
  {
    this.mConstrainedGroup = paramList;
  }
  
  ConstraintWidgetGroup(List<ConstraintWidget> paramList, boolean paramBoolean)
  {
    this.mConstrainedGroup = paramList;
    this.mSkipSolver = paramBoolean;
  }
  
  private void getWidgetsToSolveTraversal(ArrayList<ConstraintWidget> paramArrayList, ConstraintWidget paramConstraintWidget)
  {
    if (paramConstraintWidget.mGroupsToSolver) {}
    for (;;)
    {
      return;
      paramArrayList.add(paramConstraintWidget);
      paramConstraintWidget.mGroupsToSolver = true;
      if (!paramConstraintWidget.isFullyResolved())
      {
        Object localObject;
        if ((paramConstraintWidget instanceof Helper))
        {
          localObject = (Helper)paramConstraintWidget;
          j = ((Helper)localObject).mWidgetsCount;
          i = 0;
          while (i < j)
          {
            getWidgetsToSolveTraversal(paramArrayList, localObject.mWidgets[i]);
            i += 1;
          }
        }
        int j = paramConstraintWidget.mListAnchors.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramConstraintWidget.mListAnchors[i].mTarget;
          if (localObject != null)
          {
            ConstraintWidget localConstraintWidget = ((ConstraintAnchor)localObject).mOwner;
            if ((localObject != null) && (localConstraintWidget != paramConstraintWidget.getParent())) {
              getWidgetsToSolveTraversal(paramArrayList, localConstraintWidget);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void updateResolvedDimension(ConstraintWidget paramConstraintWidget)
  {
    if ((!paramConstraintWidget.mOptimizerMeasurable) || (paramConstraintWidget.isFullyResolved())) {
      return;
    }
    int j;
    ConstraintAnchor localConstraintAnchor;
    label40:
    int i;
    if (paramConstraintWidget.mRight.mTarget != null)
    {
      j = 1;
      if (j == 0) {
        break label207;
      }
      localConstraintAnchor = paramConstraintWidget.mRight.mTarget;
      if (localConstraintAnchor == null) {
        break label436;
      }
      if (!localConstraintAnchor.mOwner.mOptimizerMeasured) {
        updateResolvedDimension(localConstraintAnchor.mOwner);
      }
      if (localConstraintAnchor.mType != ConstraintAnchor.Type.RIGHT) {
        break label219;
      }
      i = localConstraintAnchor.mOwner.mX;
      i = localConstraintAnchor.mOwner.getWidth() + i;
    }
    for (;;)
    {
      label96:
      if (j != 0) {
        i -= paramConstraintWidget.mRight.getMargin();
      }
      for (;;)
      {
        paramConstraintWidget.setHorizontalDimension(i - paramConstraintWidget.getWidth(), i);
        if (paramConstraintWidget.mBaseline.mTarget == null) {
          break label260;
        }
        localConstraintAnchor = paramConstraintWidget.mBaseline.mTarget;
        if (!localConstraintAnchor.mOwner.mOptimizerMeasured) {
          updateResolvedDimension(localConstraintAnchor.mOwner);
        }
        i = localConstraintAnchor.mOwner.mY;
        i = localConstraintAnchor.mOwner.mBaselineDistance + i - paramConstraintWidget.mBaselineDistance;
        paramConstraintWidget.setVerticalDimension(i, paramConstraintWidget.mHeight + i);
        paramConstraintWidget.mOptimizerMeasured = true;
        return;
        j = 0;
        break;
        label207:
        localConstraintAnchor = paramConstraintWidget.mLeft.mTarget;
        break label40;
        label219:
        if (localConstraintAnchor.mType != ConstraintAnchor.Type.LEFT) {
          break label436;
        }
        i = localConstraintAnchor.mOwner.mX;
        break label96;
        i += paramConstraintWidget.mLeft.getMargin() + paramConstraintWidget.getWidth();
      }
      label260:
      int k;
      if (paramConstraintWidget.mBottom.mTarget != null)
      {
        k = 1;
        if (k == 0) {
          break label381;
        }
        localConstraintAnchor = paramConstraintWidget.mBottom.mTarget;
        label287:
        j = i;
        if (localConstraintAnchor != null)
        {
          if (!localConstraintAnchor.mOwner.mOptimizerMeasured) {
            updateResolvedDimension(localConstraintAnchor.mOwner);
          }
          if (localConstraintAnchor.mType != ConstraintAnchor.Type.BOTTOM) {
            break label393;
          }
          j = localConstraintAnchor.mOwner.mY + localConstraintAnchor.mOwner.getHeight();
        }
        label343:
        if (k == 0) {
          break label418;
        }
      }
      label393:
      label418:
      for (i = j - paramConstraintWidget.mBottom.getMargin();; i = j + (paramConstraintWidget.mTop.getMargin() + paramConstraintWidget.getHeight()))
      {
        paramConstraintWidget.setVerticalDimension(i - paramConstraintWidget.getHeight(), i);
        paramConstraintWidget.mOptimizerMeasured = true;
        return;
        k = 0;
        break;
        label381:
        localConstraintAnchor = paramConstraintWidget.mTop.mTarget;
        break label287;
        j = i;
        if (localConstraintAnchor.mType != ConstraintAnchor.Type.TOP) {
          break label343;
        }
        j = localConstraintAnchor.mOwner.mY;
        break label343;
      }
      label436:
      i = 0;
    }
  }
  
  void addWidgetsToSet(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramInt == 0) {
      this.mWidgetsToSetHorizontal.add(paramConstraintWidget);
    }
    while (paramInt != 1) {
      return;
    }
    this.mWidgetsToSetVertical.add(paramConstraintWidget);
  }
  
  public List<ConstraintWidget> getStartWidgets(int paramInt)
  {
    if (paramInt == 0) {
      return this.mStartHorizontalWidgets;
    }
    if (paramInt == 1) {
      return this.mStartVerticalWidgets;
    }
    return null;
  }
  
  Set<ConstraintWidget> getWidgetsToSet(int paramInt)
  {
    if (paramInt == 0) {
      return this.mWidgetsToSetHorizontal;
    }
    if (paramInt == 1) {
      return this.mWidgetsToSetVertical;
    }
    return null;
  }
  
  List<ConstraintWidget> getWidgetsToSolve()
  {
    if (!this.mWidgetsToSolve.isEmpty()) {
      return this.mWidgetsToSolve;
    }
    int j = this.mConstrainedGroup.size();
    int i = 0;
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mConstrainedGroup.get(i);
      if (!localConstraintWidget.mOptimizerMeasurable) {
        getWidgetsToSolveTraversal((ArrayList)this.mWidgetsToSolve, localConstraintWidget);
      }
      i += 1;
    }
    this.mUnresolvedWidgets.clear();
    this.mUnresolvedWidgets.addAll(this.mConstrainedGroup);
    this.mUnresolvedWidgets.removeAll(this.mWidgetsToSolve);
    return this.mWidgetsToSolve;
  }
  
  void updateUnresolvedWidgets()
  {
    int j = this.mUnresolvedWidgets.size();
    int i = 0;
    while (i < j)
    {
      updateResolvedDimension((ConstraintWidget)this.mUnresolvedWidgets.get(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.ConstraintWidgetGroup
 * JD-Core Version:    0.7.0.1
 */