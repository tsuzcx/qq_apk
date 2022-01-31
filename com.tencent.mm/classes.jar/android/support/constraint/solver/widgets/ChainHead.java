package android.support.constraint.solver.widgets;

import java.util.ArrayList;

public class ChainHead
{
  private boolean mDefined;
  protected ConstraintWidget mFirst;
  protected ConstraintWidget mFirstMatchConstraintWidget;
  protected ConstraintWidget mFirstVisibleWidget;
  protected boolean mHasComplexMatchWeights;
  protected boolean mHasDefinedWeights;
  protected boolean mHasUndefinedWeights;
  protected ConstraintWidget mHead;
  private boolean mIsRtl = false;
  protected ConstraintWidget mLast;
  protected ConstraintWidget mLastMatchConstraintWidget;
  protected ConstraintWidget mLastVisibleWidget;
  private int mOrientation;
  protected float mTotalWeight = 0.0F;
  protected ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
  protected int mWidgetsCount;
  protected int mWidgetsMatchCount;
  
  public ChainHead(ConstraintWidget paramConstraintWidget, int paramInt, boolean paramBoolean)
  {
    this.mFirst = paramConstraintWidget;
    this.mOrientation = paramInt;
    this.mIsRtl = paramBoolean;
  }
  
  private void defineChainProperties()
  {
    boolean bool = true;
    int j = this.mOrientation * 2;
    Object localObject2 = this.mFirst;
    Object localObject1 = this.mFirst;
    int i = 0;
    while (i == 0)
    {
      this.mWidgetsCount += 1;
      ((ConstraintWidget)localObject1).mNextChainWidget[this.mOrientation] = null;
      ((ConstraintWidget)localObject1).mListNextMatchConstraintsWidget[this.mOrientation] = null;
      if (((ConstraintWidget)localObject1).getVisibility() != 8)
      {
        if (this.mFirstVisibleWidget == null) {
          this.mFirstVisibleWidget = ((ConstraintWidget)localObject1);
        }
        this.mLastVisibleWidget = ((ConstraintWidget)localObject1);
        if ((localObject1.mListDimensionBehaviors[this.mOrientation] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && ((localObject1.mResolvedMatchConstraintDefault[this.mOrientation] == 0) || (localObject1.mResolvedMatchConstraintDefault[this.mOrientation] == 3) || (localObject1.mResolvedMatchConstraintDefault[this.mOrientation] == 2)))
        {
          this.mWidgetsMatchCount += 1;
          float f = localObject1.mWeight[this.mOrientation];
          if (f > 0.0F) {
            this.mTotalWeight += localObject1.mWeight[this.mOrientation];
          }
          if (isMatchConstraintEqualityCandidate((ConstraintWidget)localObject1, this.mOrientation))
          {
            if (f >= 0.0F) {
              break label386;
            }
            this.mHasUndefinedWeights = true;
            label215:
            if (this.mWeightedMatchConstraintsWidgets == null) {
              this.mWeightedMatchConstraintsWidgets = new ArrayList();
            }
            this.mWeightedMatchConstraintsWidgets.add(localObject1);
          }
          if (this.mFirstMatchConstraintWidget == null) {
            this.mFirstMatchConstraintWidget = ((ConstraintWidget)localObject1);
          }
          if (this.mLastMatchConstraintWidget != null) {
            this.mLastMatchConstraintWidget.mListNextMatchConstraintsWidget[this.mOrientation] = localObject1;
          }
          this.mLastMatchConstraintWidget = ((ConstraintWidget)localObject1);
        }
      }
      if (localObject2 != localObject1) {
        ((ConstraintWidget)localObject2).mNextChainWidget[this.mOrientation] = localObject1;
      }
      localObject2 = localObject1.mListAnchors[(j + 1)].mTarget;
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = ((ConstraintAnchor)localObject2).mOwner;
        if (localObject3.mListAnchors[j].mTarget != null)
        {
          localObject2 = localObject3;
          if (localObject3.mListAnchors[j].mTarget.mOwner == localObject1) {
            break label366;
          }
        }
      }
      for (localObject2 = null;; localObject2 = null)
      {
        label366:
        if (localObject2 == null) {
          break label400;
        }
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break;
        label386:
        this.mHasDefinedWeights = true;
        break label215;
      }
      label400:
      i = 1;
      localObject2 = localObject1;
    }
    this.mLast = ((ConstraintWidget)localObject1);
    if ((this.mOrientation == 0) && (this.mIsRtl))
    {
      this.mHead = this.mLast;
      if ((!this.mHasDefinedWeights) || (!this.mHasUndefinedWeights)) {
        break label469;
      }
    }
    for (;;)
    {
      this.mHasComplexMatchWeights = bool;
      return;
      this.mHead = this.mFirst;
      break;
      label469:
      bool = false;
    }
  }
  
  private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    return (paramConstraintWidget.getVisibility() != 8) && (paramConstraintWidget.mListDimensionBehaviors[paramInt] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && ((paramConstraintWidget.mResolvedMatchConstraintDefault[paramInt] == 0) || (paramConstraintWidget.mResolvedMatchConstraintDefault[paramInt] == 3));
  }
  
  public void define()
  {
    if (!this.mDefined) {
      defineChainProperties();
    }
    this.mDefined = true;
  }
  
  public ConstraintWidget getFirst()
  {
    return this.mFirst;
  }
  
  public ConstraintWidget getFirstMatchConstraintWidget()
  {
    return this.mFirstMatchConstraintWidget;
  }
  
  public ConstraintWidget getFirstVisibleWidget()
  {
    return this.mFirstVisibleWidget;
  }
  
  public ConstraintWidget getHead()
  {
    return this.mHead;
  }
  
  public ConstraintWidget getLast()
  {
    return this.mLast;
  }
  
  public ConstraintWidget getLastMatchConstraintWidget()
  {
    return this.mLastMatchConstraintWidget;
  }
  
  public ConstraintWidget getLastVisibleWidget()
  {
    return this.mLastVisibleWidget;
  }
  
  public float getTotalWeight()
  {
    return this.mTotalWeight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.ChainHead
 * JD-Core Version:    0.7.0.1
 */