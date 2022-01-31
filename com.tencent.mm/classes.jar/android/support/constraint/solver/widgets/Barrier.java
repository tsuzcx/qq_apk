package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;

public class Barrier
  extends Helper
{
  public static final int BOTTOM = 3;
  public static final int LEFT = 0;
  public static final int RIGHT = 1;
  public static final int TOP = 2;
  private boolean mAllowsGoneWidget = true;
  private int mBarrierType = 0;
  private ArrayList<ResolutionAnchor> mNodes = new ArrayList(4);
  
  public void addToSolver(LinearSystem paramLinearSystem)
  {
    this.mListAnchors[0] = this.mLeft;
    this.mListAnchors[2] = this.mTop;
    this.mListAnchors[1] = this.mRight;
    this.mListAnchors[3] = this.mBottom;
    int i = 0;
    while (i < this.mListAnchors.length)
    {
      this.mListAnchors[i].mSolverVariable = paramLinearSystem.createObjectVariable(this.mListAnchors[i]);
      i += 1;
    }
    ConstraintAnchor localConstraintAnchor;
    ConstraintWidget localConstraintWidget;
    boolean bool;
    if ((this.mBarrierType >= 0) && (this.mBarrierType < 4))
    {
      localConstraintAnchor = this.mListAnchors[this.mBarrierType];
      i = 0;
      if (i >= this.mWidgetsCount) {
        break label599;
      }
      localConstraintWidget = this.mWidgets[i];
      if ((this.mAllowsGoneWidget) || (localConstraintWidget.allowedInBarrier())) {
        if (((this.mBarrierType == 0) || (this.mBarrierType == 1)) && (localConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      label164:
      label194:
      label196:
      SolverVariable localSolverVariable;
      if ((this.mBarrierType == 0) || (this.mBarrierType == 1))
      {
        if (getParent().getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          bool = false;
        }
        i = 0;
        if (i >= this.mWidgetsCount) {
          break label364;
        }
        localConstraintWidget = this.mWidgets[i];
        if ((this.mAllowsGoneWidget) || (localConstraintWidget.allowedInBarrier()))
        {
          localSolverVariable = paramLinearSystem.createObjectVariable(localConstraintWidget.mListAnchors[this.mBarrierType]);
          localConstraintWidget.mListAnchors[this.mBarrierType].mSolverVariable = localSolverVariable;
          if ((this.mBarrierType != 0) && (this.mBarrierType != 2)) {
            break label349;
          }
          paramLinearSystem.addLowerBarrier(localConstraintAnchor.mSolverVariable, localSolverVariable, bool);
        }
      }
      for (;;)
      {
        i += 1;
        break label196;
        if (((this.mBarrierType == 2) || (this.mBarrierType == 3)) && (localConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
        {
          bool = true;
          break label164;
        }
        i += 1;
        break;
        if (getParent().getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          break label194;
        }
        bool = false;
        break label194;
        label349:
        paramLinearSystem.addGreaterBarrier(localConstraintAnchor.mSolverVariable, localSolverVariable, bool);
      }
      label364:
      if (this.mBarrierType == 0)
      {
        paramLinearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 6);
        if (!bool) {
          paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 5);
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.mBarrierType != 1) {
                break;
              }
              paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 6);
            } while (bool);
            paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 5);
            return;
            if (this.mBarrierType != 2) {
              break;
            }
            paramLinearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 6);
          } while (bool);
          paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 5);
          return;
        } while (this.mBarrierType != 3);
        paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 6);
      } while (bool);
      paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 5);
      return;
      label599:
      bool = false;
    }
  }
  
  public boolean allowedInBarrier()
  {
    return true;
  }
  
  public boolean allowsGoneWidget()
  {
    return this.mAllowsGoneWidget;
  }
  
  public void analyze(int paramInt)
  {
    if (this.mParent == null) {}
    ResolutionAnchor localResolutionAnchor;
    label109:
    label118:
    do
    {
      do
      {
        return;
      } while (!((ConstraintWidgetContainer)this.mParent).optimizeFor(2));
      switch (this.mBarrierType)
      {
      default: 
        return;
      case 0: 
        localResolutionAnchor = this.mLeft.getResolutionNode();
        localResolutionAnchor.setType(5);
        if ((this.mBarrierType != 0) && (this.mBarrierType != 1)) {
          break label240;
        }
        this.mTop.getResolutionNode().resolve(null, 0.0F);
        this.mBottom.getResolutionNode().resolve(null, 0.0F);
        this.mNodes.clear();
        paramInt = 0;
      }
    } while (paramInt >= this.mWidgetsCount);
    Object localObject = this.mWidgets[paramInt];
    if ((this.mAllowsGoneWidget) || (((ConstraintWidget)localObject).allowedInBarrier())) {
      switch (this.mBarrierType)
      {
      default: 
        localObject = null;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        this.mNodes.add(localObject);
        ((ResolutionAnchor)localObject).addDependent(localResolutionAnchor);
      }
      paramInt += 1;
      break label118;
      localResolutionAnchor = this.mRight.getResolutionNode();
      break;
      localResolutionAnchor = this.mTop.getResolutionNode();
      break;
      localResolutionAnchor = this.mBottom.getResolutionNode();
      break;
      label240:
      this.mLeft.getResolutionNode().resolve(null, 0.0F);
      this.mRight.getResolutionNode().resolve(null, 0.0F);
      break label109;
      localObject = ((ConstraintWidget)localObject).mLeft.getResolutionNode();
      continue;
      localObject = ((ConstraintWidget)localObject).mRight.getResolutionNode();
      continue;
      localObject = ((ConstraintWidget)localObject).mTop.getResolutionNode();
      continue;
      localObject = ((ConstraintWidget)localObject).mBottom.getResolutionNode();
    }
  }
  
  public void resetResolutionNodes()
  {
    super.resetResolutionNodes();
    this.mNodes.clear();
  }
  
  public void resolve()
  {
    float f = 3.4028235E+38F;
    ResolutionAnchor localResolutionAnchor1;
    ResolutionAnchor localResolutionAnchor2;
    int i;
    label59:
    Object localObject;
    switch (this.mBarrierType)
    {
    default: 
    case 0: 
      do
      {
        return;
        localResolutionAnchor1 = this.mLeft.getResolutionNode();
        int j = this.mNodes.size();
        localResolutionAnchor2 = null;
        i = 0;
        if (i >= j) {
          break;
        }
        localObject = (ResolutionAnchor)this.mNodes.get(i);
      } while (((ResolutionAnchor)localObject).state != 1);
      if ((this.mBarrierType == 0) || (this.mBarrierType == 2))
      {
        if (((ResolutionAnchor)localObject).resolvedOffset >= f) {
          break label329;
        }
        f = ((ResolutionAnchor)localObject).resolvedOffset;
        localResolutionAnchor2 = ((ResolutionAnchor)localObject).resolvedTarget;
      }
      break;
    }
    label329:
    for (;;)
    {
      i += 1;
      break label59;
      localResolutionAnchor1 = this.mRight.getResolutionNode();
      f = 0.0F;
      break;
      localResolutionAnchor1 = this.mTop.getResolutionNode();
      break;
      localResolutionAnchor1 = this.mBottom.getResolutionNode();
      f = 0.0F;
      break;
      if (((ResolutionAnchor)localObject).resolvedOffset > f)
      {
        f = ((ResolutionAnchor)localObject).resolvedOffset;
        localResolutionAnchor2 = ((ResolutionAnchor)localObject).resolvedTarget;
        continue;
        if (LinearSystem.getMetrics() != null)
        {
          localObject = LinearSystem.getMetrics();
          ((Metrics)localObject).barrierConnectionResolved += 1L;
        }
        localResolutionAnchor1.resolvedTarget = localResolutionAnchor2;
        localResolutionAnchor1.resolvedOffset = f;
        localResolutionAnchor1.didResolve();
        switch (this.mBarrierType)
        {
        default: 
          return;
        case 0: 
          this.mRight.getResolutionNode().resolve(localResolutionAnchor2, f);
          return;
        case 1: 
          this.mLeft.getResolutionNode().resolve(localResolutionAnchor2, f);
          return;
        case 2: 
          this.mBottom.getResolutionNode().resolve(localResolutionAnchor2, f);
          return;
        }
        this.mTop.getResolutionNode().resolve(localResolutionAnchor2, f);
        return;
      }
    }
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean)
  {
    this.mAllowsGoneWidget = paramBoolean;
  }
  
  public void setBarrierType(int paramInt)
  {
    this.mBarrierType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.Barrier
 * JD-Core Version:    0.7.0.1
 */