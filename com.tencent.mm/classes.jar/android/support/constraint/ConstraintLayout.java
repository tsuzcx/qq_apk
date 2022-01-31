package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.widgets.Analyzer;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.support.constraint.solver.widgets.ResolutionAnchor;
import android.support.constraint.solver.widgets.ResolutionDimension;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout
  extends ViewGroup
{
  static final boolean ALLOWS_EMBEDDED = false;
  private static final boolean CACHE_MEASURED_DIMENSION = false;
  private static final boolean DEBUG = false;
  public static final int DESIGN_INFO_ID = 0;
  private static final String TAG = "ConstraintLayout";
  private static final boolean USE_CONSTRAINTS_HELPER = true;
  public static final String VERSION = "ConstraintLayout-1.1.3";
  SparseArray<View> mChildrenByIds = new SparseArray();
  private ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList(4);
  private ConstraintSet mConstraintSet = null;
  private int mConstraintSetId = -1;
  private HashMap<String, Integer> mDesignIds = new HashMap();
  private boolean mDirtyHierarchy = true;
  private int mLastMeasureHeight = -1;
  int mLastMeasureHeightMode = 0;
  int mLastMeasureHeightSize = -1;
  private int mLastMeasureWidth = -1;
  int mLastMeasureWidthMode = 0;
  int mLastMeasureWidthSize = -1;
  ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
  private int mMaxHeight = 2147483647;
  private int mMaxWidth = 2147483647;
  private Metrics mMetrics;
  private int mMinHeight = 0;
  private int mMinWidth = 0;
  private int mOptimizationLevel = 7;
  private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList(100);
  
  public ConstraintLayout(Context paramContext)
  {
    super(paramContext);
    init(null);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private final ConstraintWidget getTargetWidget(int paramInt)
  {
    if (paramInt == 0) {
      return this.mLayoutWidget;
    }
    View localView2 = (View)this.mChildrenByIds.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView2 = findViewById(paramInt);
      localView1 = localView2;
      if (localView2 != null)
      {
        localView1 = localView2;
        if (localView2 != this)
        {
          localView1 = localView2;
          if (localView2.getParent() == this)
          {
            onViewAdded(localView2);
            localView1 = localView2;
          }
        }
      }
    }
    if (localView1 == this) {
      return this.mLayoutWidget;
    }
    if (localView1 == null) {
      return null;
    }
    return ((LayoutParams)localView1.getLayoutParams()).widget;
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    this.mLayoutWidget.setCompanionWidget(this);
    this.mChildrenByIds.put(getId(), this);
    this.mConstraintSet = null;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      if (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == 3) {
          this.mMinWidth = paramAttributeSet.getDimensionPixelOffset(k, this.mMinWidth);
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == 4)
          {
            this.mMinHeight = paramAttributeSet.getDimensionPixelOffset(k, this.mMinHeight);
          }
          else if (k == 1)
          {
            this.mMaxWidth = paramAttributeSet.getDimensionPixelOffset(k, this.mMaxWidth);
          }
          else if (k == 2)
          {
            this.mMaxHeight = paramAttributeSet.getDimensionPixelOffset(k, this.mMaxHeight);
          }
          else if (k == 59)
          {
            this.mOptimizationLevel = paramAttributeSet.getInt(k, this.mOptimizationLevel);
          }
          else if (k == 8)
          {
            k = paramAttributeSet.getResourceId(k, 0);
            try
            {
              this.mConstraintSet = new ConstraintSet();
              this.mConstraintSet.load(getContext(), k);
              this.mConstraintSetId = k;
            }
            catch (Resources.NotFoundException localNotFoundException)
            {
              for (;;)
              {
                this.mConstraintSet = null;
              }
            }
          }
        }
      }
      paramAttributeSet.recycle();
    }
    this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
  }
  
  private void internalMeasureChildren(int paramInt1, int paramInt2)
  {
    int i3 = getPaddingTop() + getPaddingBottom();
    int i4 = getPaddingLeft() + getPaddingRight();
    int i5 = getChildCount();
    int n = 0;
    View localView;
    LayoutParams localLayoutParams;
    ConstraintWidget localConstraintWidget;
    int i1;
    int i2;
    int i;
    label183:
    int k;
    int j;
    label210:
    int m;
    label228:
    boolean bool;
    if (n < i5)
    {
      localView = getChildAt(n);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        localConstraintWidget = localLayoutParams.widget;
        if ((!localLayoutParams.isGuideline) && (!localLayoutParams.isHelper))
        {
          localConstraintWidget.setVisibility(localView.getVisibility());
          i1 = localLayoutParams.width;
          i2 = localLayoutParams.height;
          if ((!localLayoutParams.horizontalDimensionFixed) && (!localLayoutParams.verticalDimensionFixed) && ((localLayoutParams.horizontalDimensionFixed) || (localLayoutParams.matchConstraintDefaultWidth != 1)) && (localLayoutParams.width != -1) && ((localLayoutParams.verticalDimensionFixed) || ((localLayoutParams.matchConstraintDefaultHeight != 1) && (localLayoutParams.height != -1)))) {
            break label381;
          }
          i = 1;
          k = 0;
          j = 0;
          if (i == 0) {
            break label494;
          }
          if (i1 != 0) {
            break label386;
          }
          k = getChildMeasureSpec(paramInt1, i4, -2);
          i = 1;
          if (i2 != 0) {
            break label431;
          }
          m = getChildMeasureSpec(paramInt2, i3, -2);
          j = 1;
          localView.measure(k, m);
          if (this.mMetrics != null)
          {
            Metrics localMetrics = this.mMetrics;
            localMetrics.measures += 1L;
          }
          if (i1 != -2) {
            break label475;
          }
          bool = true;
          label272:
          localConstraintWidget.setWidthWrapContent(bool);
          if (i2 != -2) {
            break label481;
          }
          bool = true;
          label289:
          localConstraintWidget.setHeightWrapContent(bool);
          m = localView.getMeasuredWidth();
          k = localView.getMeasuredHeight();
        }
      }
    }
    for (;;)
    {
      localConstraintWidget.setWidth(m);
      localConstraintWidget.setHeight(k);
      if (i != 0) {
        localConstraintWidget.setWrapWidth(m);
      }
      if (j != 0) {
        localConstraintWidget.setWrapHeight(k);
      }
      if (localLayoutParams.needsBaseline)
      {
        i = localView.getBaseline();
        if (i != -1) {
          localConstraintWidget.setBaselineDistance(i);
        }
      }
      n += 1;
      break;
      label381:
      i = 0;
      break label183;
      label386:
      if (i1 == -1)
      {
        k = getChildMeasureSpec(paramInt1, i4, -1);
        i = 0;
        break label210;
      }
      i = k;
      if (i1 == -2) {
        i = 1;
      }
      k = getChildMeasureSpec(paramInt1, i4, i1);
      break label210;
      label431:
      if (i2 == -1)
      {
        m = getChildMeasureSpec(paramInt2, i3, -1);
        j = 0;
        break label228;
      }
      if (i2 == -2) {}
      for (j = 1;; j = 0)
      {
        m = getChildMeasureSpec(paramInt2, i3, i2);
        break;
        label475:
        bool = false;
        break label272;
        label481:
        bool = false;
        break label289;
        return;
      }
      label494:
      m = 0;
      k = i2;
      i = j;
      j = m;
      m = i1;
    }
  }
  
  private void internalMeasureDimensions(int paramInt1, int paramInt2)
  {
    int i7 = getPaddingTop() + getPaddingBottom();
    int i8 = getPaddingLeft() + getPaddingRight();
    int i9 = getChildCount();
    int i = 0;
    View localView;
    LayoutParams localLayoutParams;
    ConstraintWidget localConstraintWidget;
    int m;
    int n;
    label143:
    int j;
    int k;
    int i1;
    Object localObject;
    boolean bool;
    while (i < i9)
    {
      localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        localConstraintWidget = localLayoutParams.widget;
        if ((!localLayoutParams.isGuideline) && (!localLayoutParams.isHelper))
        {
          localConstraintWidget.setVisibility(localView.getVisibility());
          m = localLayoutParams.width;
          n = localLayoutParams.height;
          if ((m != 0) && (n != 0)) {
            break label143;
          }
          localConstraintWidget.getResolutionWidth().invalidate();
          localConstraintWidget.getResolutionHeight().invalidate();
        }
      }
      i += 1;
      continue;
      j = 0;
      k = 0;
      if (m == -2) {
        j = 1;
      }
      i1 = getChildMeasureSpec(paramInt1, i8, m);
      if (n == -2) {
        k = 1;
      }
      localView.measure(i1, getChildMeasureSpec(paramInt2, i7, n));
      if (this.mMetrics != null)
      {
        localObject = this.mMetrics;
        ((Metrics)localObject).measures += 1L;
      }
      if (m == -2)
      {
        bool = true;
        label229:
        localConstraintWidget.setWidthWrapContent(bool);
        if (n != -2) {
          break label378;
        }
      }
      label378:
      for (bool = true;; bool = false)
      {
        localConstraintWidget.setHeightWrapContent(bool);
        m = localView.getMeasuredWidth();
        n = localView.getMeasuredHeight();
        localConstraintWidget.setWidth(m);
        localConstraintWidget.setHeight(n);
        if (j != 0) {
          localConstraintWidget.setWrapWidth(m);
        }
        if (k != 0) {
          localConstraintWidget.setWrapHeight(n);
        }
        if (localLayoutParams.needsBaseline)
        {
          j = localView.getBaseline();
          if (j != -1) {
            localConstraintWidget.setBaselineDistance(j);
          }
        }
        if ((!localLayoutParams.horizontalDimensionFixed) || (!localLayoutParams.verticalDimensionFixed)) {
          break;
        }
        localConstraintWidget.getResolutionWidth().resolve(m);
        localConstraintWidget.getResolutionHeight().resolve(n);
        break;
        bool = false;
        break label229;
      }
    }
    this.mLayoutWidget.solveGraph();
    int i4 = 0;
    label543:
    ResolutionAnchor localResolutionAnchor2;
    ResolutionAnchor localResolutionAnchor3;
    int i5;
    label600:
    int i6;
    if (i4 < i9)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        localConstraintWidget = localLayoutParams.widget;
        if ((!localLayoutParams.isGuideline) && (!localLayoutParams.isHelper))
        {
          localConstraintWidget.setVisibility(localView.getVisibility());
          n = localLayoutParams.width;
          m = localLayoutParams.height;
          if ((n == 0) || (m == 0))
          {
            localObject = localConstraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
            ResolutionAnchor localResolutionAnchor1 = localConstraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getResolutionNode();
            if ((localConstraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).getTarget() == null) || (localConstraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget() == null)) {
              break label1033;
            }
            k = 1;
            localResolutionAnchor2 = localConstraintWidget.getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
            localResolutionAnchor3 = localConstraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getResolutionNode();
            if ((localConstraintWidget.getAnchor(ConstraintAnchor.Type.TOP).getTarget() == null) || (localConstraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget() == null)) {
              break label1039;
            }
            i5 = 1;
            if ((n != 0) || (m != 0) || (k == 0) || (i5 == 0))
            {
              i6 = 0;
              if (this.mLayoutWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                break label1045;
              }
              j = 1;
              label639:
              if (this.mLayoutWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                break label1051;
              }
              i = 1;
              label654:
              if (j == 0) {
                localConstraintWidget.getResolutionWidth().invalidate();
              }
              if (i == 0) {
                localConstraintWidget.getResolutionHeight().invalidate();
              }
              if (n != 0) {
                break label1083;
              }
              if ((j == 0) || (!localConstraintWidget.isSpreadWidth()) || (k == 0) || (!((ResolutionAnchor)localObject).isResolved()) || (!localResolutionAnchor1.isResolved())) {
                break label1056;
              }
              n = (int)(localResolutionAnchor1.getResolvedValue() - ((ResolutionAnchor)localObject).getResolvedValue());
              localConstraintWidget.getResolutionWidth().resolve(n);
              k = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      label745:
      int i2 = getChildMeasureSpec(paramInt1, i8, n);
      int i3 = n;
      i1 = k;
      n = j;
      label767:
      if (m == 0) {
        if ((i != 0) && (localConstraintWidget.isSpreadHeight()) && (i5 != 0) && (localResolutionAnchor2.isResolved()) && (localResolutionAnchor3.isResolved()))
        {
          k = (int)(localResolutionAnchor3.getResolvedValue() - localResolutionAnchor2.getResolvedValue());
          localConstraintWidget.getResolutionHeight().resolve(k);
          j = 0;
        }
      }
      for (;;)
      {
        label832:
        i5 = getChildMeasureSpec(paramInt2, i7, k);
        m = k;
        k = i5;
        label850:
        localView.measure(i2, k);
        if (this.mMetrics != null)
        {
          localObject = this.mMetrics;
          ((Metrics)localObject).measures += 1L;
        }
        if (i3 == -2)
        {
          bool = true;
          label894:
          localConstraintWidget.setWidthWrapContent(bool);
          if (m != -2) {
            break label1188;
          }
          bool = true;
          label911:
          localConstraintWidget.setHeightWrapContent(bool);
          k = localView.getMeasuredWidth();
          m = localView.getMeasuredHeight();
          localConstraintWidget.setWidth(k);
          localConstraintWidget.setHeight(m);
          if (i1 != 0) {
            localConstraintWidget.setWrapWidth(k);
          }
          if (j != 0) {
            localConstraintWidget.setWrapHeight(m);
          }
          if (n == 0) {
            break label1194;
          }
          localConstraintWidget.getResolutionWidth().resolve(k);
          label985:
          if (i == 0) {
            break label1205;
          }
          localConstraintWidget.getResolutionHeight().resolve(m);
        }
        for (;;)
        {
          if (localLayoutParams.needsBaseline)
          {
            i = localView.getBaseline();
            if (i != -1) {
              localConstraintWidget.setBaselineDistance(i);
            }
          }
          i4 += 1;
          break;
          label1033:
          k = 0;
          break label543;
          label1039:
          i5 = 0;
          break label600;
          label1045:
          j = 0;
          break label639;
          label1051:
          i = 0;
          break label654;
          label1056:
          i2 = getChildMeasureSpec(paramInt1, i8, -2);
          j = 0;
          i1 = 1;
          i3 = n;
          n = j;
          break label767;
          label1083:
          if (n == -1)
          {
            i2 = getChildMeasureSpec(paramInt1, i8, -1);
            i1 = 0;
            i3 = n;
            n = j;
            break label767;
          }
          if (n != -2) {
            break label1227;
          }
          k = 1;
          break label745;
          k = getChildMeasureSpec(paramInt2, i7, -2);
          j = 1;
          i = 0;
          break label850;
          if (m == -1)
          {
            k = getChildMeasureSpec(paramInt2, i7, -1);
            j = i6;
            break label850;
          }
          if (m != -2) {
            break label1217;
          }
          j = 1;
          k = m;
          break label832;
          bool = false;
          break label894;
          label1188:
          bool = false;
          break label911;
          label1194:
          localConstraintWidget.getResolutionWidth().remove();
          break label985;
          label1205:
          localConstraintWidget.getResolutionHeight().remove();
        }
        return;
        label1217:
        j = 0;
        k = m;
      }
      label1227:
      k = 0;
    }
  }
  
  private void setChildrenConstraints()
  {
    boolean bool = isInEditMode();
    int i9 = getChildCount();
    Object localObject3;
    if (bool)
    {
      i = 0;
      while (i < i9)
      {
        localObject3 = getChildAt(i);
        try
        {
          localObject2 = getResources().getResourceName(((View)localObject3).getId());
          setDesignInformation(0, localObject2, Integer.valueOf(((View)localObject3).getId()));
          j = ((String)localObject2).indexOf('/');
          localObject1 = localObject2;
          if (j != -1) {
            localObject1 = ((String)localObject2).substring(j + 1);
          }
          getTargetWidget(((View)localObject3).getId()).setDebugName((String)localObject1);
        }
        catch (Resources.NotFoundException localNotFoundException1)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject1;
            int i5;
            int k;
            int m;
            int i3;
            int i4;
            float f2;
            int i7;
            int i8;
            int i6;
            continue;
            float f1 = f2;
            int n = i1;
            int i1 = i2;
            int i2 = i3;
            i = k;
            int j = m;
          }
        }
        i += 1;
      }
    }
    else
    {
      i = 0;
      while (i < i9)
      {
        localObject1 = getViewWidget(getChildAt(i));
        if (localObject1 != null) {
          ((ConstraintWidget)localObject1).reset();
        }
        i += 1;
      }
      if (this.mConstraintSetId != -1)
      {
        i = 0;
        while (i < i9)
        {
          localObject1 = getChildAt(i);
          if ((((View)localObject1).getId() == this.mConstraintSetId) && ((localObject1 instanceof Constraints))) {
            this.mConstraintSet = ((Constraints)localObject1).getConstraintSet();
          }
          i += 1;
        }
      }
      if (this.mConstraintSet != null) {
        this.mConstraintSet.applyToInternal(this);
      }
      this.mLayoutWidget.removeAllChildren();
      j = this.mConstraintHelpers.size();
      if (j > 0)
      {
        i = 0;
        while (i < j)
        {
          ((ConstraintHelper)this.mConstraintHelpers.get(i)).updatePreLayout(this);
          i += 1;
        }
      }
      i = 0;
      while (i < i9)
      {
        localObject1 = getChildAt(i);
        if ((localObject1 instanceof Placeholder)) {
          ((Placeholder)localObject1).updatePreLayout(this);
        }
        i += 1;
      }
      i5 = 0;
      if (i5 < i9)
      {
        localObject3 = getChildAt(i5);
        localObject2 = getViewWidget((View)localObject3);
        if (localObject2 != null)
        {
          localObject1 = (LayoutParams)((View)localObject3).getLayoutParams();
          ((LayoutParams)localObject1).validate();
          if (!((LayoutParams)localObject1).helped) {
            break label526;
          }
          ((LayoutParams)localObject1).helped = false;
          label375:
          ((ConstraintWidget)localObject2).setVisibility(((View)localObject3).getVisibility());
          if (((LayoutParams)localObject1).isInPlaceholder) {
            ((ConstraintWidget)localObject2).setVisibility(8);
          }
          ((ConstraintWidget)localObject2).setCompanionWidget(localObject3);
          this.mLayoutWidget.add((ConstraintWidget)localObject2);
          if ((!((LayoutParams)localObject1).verticalDimensionFixed) || (!((LayoutParams)localObject1).horizontalDimensionFixed)) {
            this.mVariableDimensionsWidgets.add(localObject2);
          }
          if (!((LayoutParams)localObject1).isGuideline) {
            break label629;
          }
          localObject2 = (android.support.constraint.solver.widgets.Guideline)localObject2;
          j = ((LayoutParams)localObject1).resolvedGuideBegin;
          i = ((LayoutParams)localObject1).resolvedGuideEnd;
          f1 = ((LayoutParams)localObject1).resolvedGuidePercent;
          if (Build.VERSION.SDK_INT < 17)
          {
            j = ((LayoutParams)localObject1).guideBegin;
            i = ((LayoutParams)localObject1).guideEnd;
            f1 = ((LayoutParams)localObject1).guidePercent;
          }
          if (f1 == -1.0F) {
            break label599;
          }
          ((android.support.constraint.solver.widgets.Guideline)localObject2).setGuidePercent(f1);
        }
        label526:
        label599:
        label629:
        while ((((LayoutParams)localObject1).leftToLeft == -1) && (((LayoutParams)localObject1).leftToRight == -1) && (((LayoutParams)localObject1).rightToLeft == -1) && (((LayoutParams)localObject1).rightToRight == -1) && (((LayoutParams)localObject1).startToStart == -1) && (((LayoutParams)localObject1).startToEnd == -1) && (((LayoutParams)localObject1).endToStart == -1) && (((LayoutParams)localObject1).endToEnd == -1) && (((LayoutParams)localObject1).topToTop == -1) && (((LayoutParams)localObject1).topToBottom == -1) && (((LayoutParams)localObject1).bottomToTop == -1) && (((LayoutParams)localObject1).bottomToBottom == -1) && (((LayoutParams)localObject1).baselineToBaseline == -1) && (((LayoutParams)localObject1).editorAbsoluteX == -1) && (((LayoutParams)localObject1).editorAbsoluteY == -1) && (((LayoutParams)localObject1).circleConstraint == -1) && (((LayoutParams)localObject1).width != -1) && (((LayoutParams)localObject1).height != -1)) {
          for (;;)
          {
            for (;;)
            {
              i5 += 1;
              break;
              if (!bool) {
                break label375;
              }
              try
              {
                String str = getResources().getResourceName(((View)localObject3).getId());
                setDesignInformation(0, str, Integer.valueOf(((View)localObject3).getId()));
                str = str.substring(str.indexOf("id/") + 3);
                getTargetWidget(((View)localObject3).getId()).setDebugName(str);
              }
              catch (Resources.NotFoundException localNotFoundException2) {}
            }
            break label375;
            if (j != -1) {
              ((android.support.constraint.solver.widgets.Guideline)localObject2).setGuideBegin(j);
            } else if (i != -1) {
              ((android.support.constraint.solver.widgets.Guideline)localObject2).setGuideEnd(i);
            }
          }
        }
        k = ((LayoutParams)localObject1).resolvedLeftToLeft;
        m = ((LayoutParams)localObject1).resolvedLeftToRight;
        i3 = ((LayoutParams)localObject1).resolvedRightToLeft;
        i2 = ((LayoutParams)localObject1).resolvedRightToRight;
        i4 = ((LayoutParams)localObject1).resolveGoneLeftMargin;
        i1 = ((LayoutParams)localObject1).resolveGoneRightMargin;
        f2 = ((LayoutParams)localObject1).resolvedHorizontalBias;
        if (Build.VERSION.SDK_INT < 17)
        {
          k = ((LayoutParams)localObject1).leftToLeft;
          m = ((LayoutParams)localObject1).leftToRight;
          i7 = ((LayoutParams)localObject1).rightToLeft;
          i8 = ((LayoutParams)localObject1).rightToRight;
          i6 = ((LayoutParams)localObject1).goneLeftMargin;
          n = ((LayoutParams)localObject1).goneRightMargin;
          f1 = ((LayoutParams)localObject1).horizontalBias;
          i = k;
          j = m;
          if (k == -1)
          {
            i = k;
            j = m;
            if (m == -1)
            {
              if (((LayoutParams)localObject1).startToStart == -1) {
                break label1331;
              }
              i = ((LayoutParams)localObject1).startToStart;
              j = m;
            }
          }
          label940:
          f2 = f1;
          i1 = n;
          i2 = i8;
          i3 = i7;
          i4 = i6;
          k = i;
          m = j;
          if (i7 == -1)
          {
            f2 = f1;
            i1 = n;
            i2 = i8;
            i3 = i7;
            i4 = i6;
            k = i;
            m = j;
            if (i8 == -1)
            {
              if (((LayoutParams)localObject1).endToStart != -1)
              {
                i2 = ((LayoutParams)localObject1).endToStart;
                i1 = i8;
                i4 = i6;
                label1026:
                if (((LayoutParams)localObject1).circleConstraint == -1) {
                  break label1412;
                }
                localObject3 = getTargetWidget(((LayoutParams)localObject1).circleConstraint);
                if (localObject3 != null) {
                  ((ConstraintWidget)localObject2).connectCircularConstraint((ConstraintWidget)localObject3, ((LayoutParams)localObject1).circleAngle, ((LayoutParams)localObject1).circleRadius);
                }
                if ((bool) && ((((LayoutParams)localObject1).editorAbsoluteX != -1) || (((LayoutParams)localObject1).editorAbsoluteY != -1))) {
                  ((ConstraintWidget)localObject2).setOrigin(((LayoutParams)localObject1).editorAbsoluteX, ((LayoutParams)localObject1).editorAbsoluteY);
                }
                if (((LayoutParams)localObject1).horizontalDimensionFixed) {
                  break label1971;
                }
                if (((LayoutParams)localObject1).width != -1) {
                  break label1954;
                }
                ((ConstraintWidget)localObject2).setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.LEFT).mMargin = ((LayoutParams)localObject1).leftMargin;
                ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = ((LayoutParams)localObject1).rightMargin;
                label1163:
                if (((LayoutParams)localObject1).verticalDimensionFixed) {
                  break label2009;
                }
                if (((LayoutParams)localObject1).height != -1) {
                  break label1992;
                }
                ((ConstraintWidget)localObject2).setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.TOP).mMargin = ((LayoutParams)localObject1).topMargin;
                ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = ((LayoutParams)localObject1).bottomMargin;
              }
              for (;;)
              {
                if (((LayoutParams)localObject1).dimensionRatio != null) {
                  ((ConstraintWidget)localObject2).setDimensionRatio(((LayoutParams)localObject1).dimensionRatio);
                }
                ((ConstraintWidget)localObject2).setHorizontalWeight(((LayoutParams)localObject1).horizontalWeight);
                ((ConstraintWidget)localObject2).setVerticalWeight(((LayoutParams)localObject1).verticalWeight);
                ((ConstraintWidget)localObject2).setHorizontalChainStyle(((LayoutParams)localObject1).horizontalChainStyle);
                ((ConstraintWidget)localObject2).setVerticalChainStyle(((LayoutParams)localObject1).verticalChainStyle);
                ((ConstraintWidget)localObject2).setHorizontalMatchStyle(((LayoutParams)localObject1).matchConstraintDefaultWidth, ((LayoutParams)localObject1).matchConstraintMinWidth, ((LayoutParams)localObject1).matchConstraintMaxWidth, ((LayoutParams)localObject1).matchConstraintPercentWidth);
                ((ConstraintWidget)localObject2).setVerticalMatchStyle(((LayoutParams)localObject1).matchConstraintDefaultHeight, ((LayoutParams)localObject1).matchConstraintMinHeight, ((LayoutParams)localObject1).matchConstraintMaxHeight, ((LayoutParams)localObject1).matchConstraintPercentHeight);
                break;
                label1331:
                i = k;
                j = m;
                if (((LayoutParams)localObject1).startToEnd == -1) {
                  break label940;
                }
                j = ((LayoutParams)localObject1).startToEnd;
                i = k;
                break label940;
                f2 = f1;
                i1 = n;
                i2 = i8;
                i3 = i7;
                i4 = i6;
                k = i;
                m = j;
                if (((LayoutParams)localObject1).endToEnd == -1) {
                  break label2036;
                }
                i1 = ((LayoutParams)localObject1).endToEnd;
                i2 = i7;
                i4 = i6;
                break label1026;
                label1412:
                if (i != -1)
                {
                  localObject3 = getTargetWidget(i);
                  if (localObject3 != null) {
                    ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)localObject3, ConstraintAnchor.Type.LEFT, ((LayoutParams)localObject1).leftMargin, i4);
                  }
                  label1449:
                  if (i2 == -1) {
                    break label1810;
                  }
                  localObject3 = getTargetWidget(i2);
                  if (localObject3 != null) {
                    ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget)localObject3, ConstraintAnchor.Type.LEFT, ((LayoutParams)localObject1).rightMargin, n);
                  }
                  label1488:
                  if (((LayoutParams)localObject1).topToTop == -1) {
                    break label1852;
                  }
                  localObject3 = getTargetWidget(((LayoutParams)localObject1).topToTop);
                  if (localObject3 != null) {
                    ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.TOP, (ConstraintWidget)localObject3, ConstraintAnchor.Type.TOP, ((LayoutParams)localObject1).topMargin, ((LayoutParams)localObject1).goneTopMargin);
                  }
                  if (((LayoutParams)localObject1).bottomToTop == -1) {
                    break label1903;
                  }
                  localObject3 = getTargetWidget(((LayoutParams)localObject1).bottomToTop);
                  if (localObject3 != null) {
                    ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget)localObject3, ConstraintAnchor.Type.TOP, ((LayoutParams)localObject1).bottomMargin, ((LayoutParams)localObject1).goneBottomMargin);
                  }
                }
                for (;;)
                {
                  label1536:
                  if (((LayoutParams)localObject1).baselineToBaseline != -1)
                  {
                    Object localObject4 = (View)this.mChildrenByIds.get(((LayoutParams)localObject1).baselineToBaseline);
                    localObject3 = getTargetWidget(((LayoutParams)localObject1).baselineToBaseline);
                    if ((localObject3 != null) && (localObject4 != null) && ((((View)localObject4).getLayoutParams() instanceof LayoutParams)))
                    {
                      localObject4 = (LayoutParams)((View)localObject4).getLayoutParams();
                      ((LayoutParams)localObject1).needsBaseline = true;
                      ((LayoutParams)localObject4).needsBaseline = true;
                      ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.BASELINE).connect(((ConstraintWidget)localObject3).getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, ConstraintAnchor.Strength.STRONG, 0, true);
                      ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.TOP).reset();
                      ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
                    }
                  }
                  if ((f1 >= 0.0F) && (f1 != 0.5F)) {
                    ((ConstraintWidget)localObject2).setHorizontalBiasPercent(f1);
                  }
                  if ((((LayoutParams)localObject1).verticalBias < 0.0F) || (((LayoutParams)localObject1).verticalBias == 0.5F)) {
                    break;
                  }
                  ((ConstraintWidget)localObject2).setVerticalBiasPercent(((LayoutParams)localObject1).verticalBias);
                  break;
                  if (j == -1) {
                    break label1449;
                  }
                  localObject3 = getTargetWidget(j);
                  if (localObject3 == null) {
                    break label1449;
                  }
                  ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)localObject3, ConstraintAnchor.Type.RIGHT, ((LayoutParams)localObject1).leftMargin, i4);
                  break label1449;
                  label1810:
                  if (i1 == -1) {
                    break label1488;
                  }
                  localObject3 = getTargetWidget(i1);
                  if (localObject3 == null) {
                    break label1488;
                  }
                  ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget)localObject3, ConstraintAnchor.Type.RIGHT, ((LayoutParams)localObject1).rightMargin, n);
                  break label1488;
                  label1852:
                  if (((LayoutParams)localObject1).topToBottom == -1) {
                    break label1536;
                  }
                  localObject3 = getTargetWidget(((LayoutParams)localObject1).topToBottom);
                  if (localObject3 == null) {
                    break label1536;
                  }
                  ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.TOP, (ConstraintWidget)localObject3, ConstraintAnchor.Type.BOTTOM, ((LayoutParams)localObject1).topMargin, ((LayoutParams)localObject1).goneTopMargin);
                  break label1536;
                  label1903:
                  if (((LayoutParams)localObject1).bottomToBottom != -1)
                  {
                    localObject3 = getTargetWidget(((LayoutParams)localObject1).bottomToBottom);
                    if (localObject3 != null) {
                      ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget)localObject3, ConstraintAnchor.Type.BOTTOM, ((LayoutParams)localObject1).bottomMargin, ((LayoutParams)localObject1).goneBottomMargin);
                    }
                  }
                }
                label1954:
                ((ConstraintWidget)localObject2).setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                ((ConstraintWidget)localObject2).setWidth(0);
                break label1163;
                label1971:
                ((ConstraintWidget)localObject2).setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ((ConstraintWidget)localObject2).setWidth(((LayoutParams)localObject1).width);
                break label1163;
                label1992:
                ((ConstraintWidget)localObject2).setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                ((ConstraintWidget)localObject2).setHeight(0);
                continue;
                label2009:
                ((ConstraintWidget)localObject2).setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ((ConstraintWidget)localObject2).setHeight(((LayoutParams)localObject1).height);
              }
            }
          }
        }
      }
      else
      {
        return;
      }
    }
  }
  
  private void setSelfDimensionBehaviour(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int j = getPaddingTop();
    int k = getPaddingBottom();
    int n = getPaddingLeft();
    int i1 = getPaddingRight();
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.FIXED;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
    getLayoutParams();
    switch (m)
    {
    default: 
      paramInt1 = 0;
      switch (i)
      {
      default: 
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      this.mLayoutWidget.setMinWidth(0);
      this.mLayoutWidget.setMinHeight(0);
      this.mLayoutWidget.setHorizontalDimensionBehaviour(localDimensionBehaviour1);
      this.mLayoutWidget.setWidth(paramInt1);
      this.mLayoutWidget.setVerticalDimensionBehaviour(localDimensionBehaviour2);
      this.mLayoutWidget.setHeight(paramInt2);
      this.mLayoutWidget.setMinWidth(this.mMinWidth - getPaddingLeft() - getPaddingRight());
      this.mLayoutWidget.setMinHeight(this.mMinHeight - getPaddingTop() - getPaddingBottom());
      return;
      localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      break;
      localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      paramInt1 = 0;
      break;
      paramInt1 = Math.min(this.mMaxWidth, paramInt1) - (n + i1);
      break;
      localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      continue;
      localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      paramInt2 = 0;
      continue;
      paramInt2 = Math.min(this.mMaxHeight, paramInt2) - (j + k);
    }
  }
  
  private void updateHierarchy()
  {
    int k = 0;
    int m = getChildCount();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (getChildAt(i).isLayoutRequested()) {
          j = 1;
        }
      }
      else
      {
        if (j != 0)
        {
          this.mVariableDimensionsWidgets.clear();
          setChildrenConstraints();
        }
        return;
      }
      i += 1;
    }
  }
  
  private void updatePostMeasures()
  {
    int j = 0;
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      View localView = getChildAt(i);
      if ((localView instanceof Placeholder)) {
        ((Placeholder)localView).updatePostMeasure(this);
      }
      i += 1;
    }
    k = this.mConstraintHelpers.size();
    if (k > 0)
    {
      i = j;
      while (i < k)
      {
        ((ConstraintHelper)this.mConstraintHelpers.get(i)).updatePostMeasure(this);
        i += 1;
      }
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14) {
      onViewAdded(paramView);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (isInEditMode())
    {
      int j = getChildCount();
      float f1 = getWidth();
      float f2 = getHeight();
      int i = 0;
      while (i < j)
      {
        Object localObject = getChildAt(i);
        if (((View)localObject).getVisibility() != 8)
        {
          localObject = ((View)localObject).getTag();
          if ((localObject != null) && ((localObject instanceof String)))
          {
            localObject = ((String)localObject).split(",");
            if (localObject.length == 4)
            {
              int m = Integer.parseInt(localObject[0]);
              int i1 = Integer.parseInt(localObject[1]);
              int n = Integer.parseInt(localObject[2]);
              int k = Integer.parseInt(localObject[3]);
              m = (int)(m / 1080.0F * f1);
              i1 = (int)(i1 / 1920.0F * f2);
              n = (int)(n / 1080.0F * f1);
              k = (int)(k / 1920.0F * f2);
              localObject = new Paint();
              ((Paint)localObject).setColor(-65536);
              paramCanvas.drawLine(m, i1, m + n, i1, (Paint)localObject);
              paramCanvas.drawLine(m + n, i1, m + n, i1 + k, (Paint)localObject);
              paramCanvas.drawLine(m + n, i1 + k, m, i1 + k, (Paint)localObject);
              paramCanvas.drawLine(m, i1 + k, m, i1, (Paint)localObject);
              ((Paint)localObject).setColor(-16711936);
              paramCanvas.drawLine(m, i1, m + n, i1 + k, (Paint)localObject);
              paramCanvas.drawLine(m, i1 + k, m + n, i1, (Paint)localObject);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void fillMetrics(Metrics paramMetrics)
  {
    this.mMetrics = paramMetrics;
    this.mLayoutWidget.fillMetrics(paramMetrics);
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public Object getDesignInformation(int paramInt, Object paramObject)
  {
    if ((paramInt == 0) && ((paramObject instanceof String)))
    {
      paramObject = (String)paramObject;
      if ((this.mDesignIds != null) && (this.mDesignIds.containsKey(paramObject))) {
        return this.mDesignIds.get(paramObject);
      }
    }
    return null;
  }
  
  public int getMaxHeight()
  {
    return this.mMaxHeight;
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public int getMinHeight()
  {
    return this.mMinHeight;
  }
  
  public int getMinWidth()
  {
    return this.mMinWidth;
  }
  
  public int getOptimizationLevel()
  {
    return this.mLayoutWidget.getOptimizationLevel();
  }
  
  public View getViewById(int paramInt)
  {
    return (View)this.mChildrenByIds.get(paramInt);
  }
  
  public final ConstraintWidget getViewWidget(View paramView)
  {
    if (paramView == this) {
      return this.mLayoutWidget;
    }
    if (paramView == null) {
      return null;
    }
    return ((LayoutParams)paramView.getLayoutParams()).widget;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      ConstraintWidget localConstraintWidget = localLayoutParams.widget;
      if (((localView.getVisibility() != 8) || (localLayoutParams.isGuideline) || (localLayoutParams.isHelper) || (paramBoolean)) && (!localLayoutParams.isInPlaceholder))
      {
        paramInt3 = localConstraintWidget.getDrawX();
        paramInt4 = localConstraintWidget.getDrawY();
        int i = localConstraintWidget.getWidth() + paramInt3;
        int j = localConstraintWidget.getHeight() + paramInt4;
        localView.layout(paramInt3, paramInt4, i, j);
        if ((localView instanceof Placeholder))
        {
          localView = ((Placeholder)localView).getContent();
          if (localView != null)
          {
            localView.setVisibility(0);
            localView.layout(paramInt3, paramInt4, i, j);
          }
        }
      }
      paramInt1 += 1;
    }
    paramInt2 = this.mConstraintHelpers.size();
    if (paramInt2 > 0)
    {
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        ((ConstraintHelper)this.mConstraintHelpers.get(paramInt1)).updatePostLayout(this);
        paramInt1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    System.currentTimeMillis();
    int j = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int k = getPaddingLeft();
    int m = getPaddingTop();
    this.mLayoutWidget.setX(k);
    this.mLayoutWidget.setY(m);
    this.mLayoutWidget.setMaxWidth(this.mMaxWidth);
    this.mLayoutWidget.setMaxHeight(this.mMaxHeight);
    Object localObject;
    boolean bool;
    int i6;
    int i7;
    int i;
    int i1;
    label171:
    label200:
    int i4;
    int i8;
    int i9;
    int i10;
    label567:
    label583:
    label618:
    View localView;
    label748:
    int i5;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject = this.mLayoutWidget;
      if (getLayoutDirection() == 1)
      {
        bool = true;
        ((ConstraintWidgetContainer)localObject).setRtl(bool);
      }
    }
    else
    {
      setSelfDimensionBehaviour(paramInt1, paramInt2);
      i6 = this.mLayoutWidget.getWidth();
      i7 = this.mLayoutWidget.getHeight();
      i = 0;
      if (this.mDirtyHierarchy)
      {
        this.mDirtyHierarchy = false;
        updateHierarchy();
        i = 1;
      }
      if ((this.mOptimizationLevel & 0x8) != 8) {
        break label1077;
      }
      i1 = 1;
      if (i1 == 0) {
        break label1083;
      }
      this.mLayoutWidget.preOptimize();
      this.mLayoutWidget.optimizeForDimensions(i6, i7);
      internalMeasureDimensions(paramInt1, paramInt2);
      updatePostMeasures();
      if ((getChildCount() > 0) && (i != 0)) {
        Analyzer.determineGroups(this.mLayoutWidget);
      }
      if (this.mLayoutWidget.mGroupsWrapOptimized)
      {
        if ((this.mLayoutWidget.mHorizontalWrapOptimized) && (j == -2147483648))
        {
          if (this.mLayoutWidget.mWrapFixedWidth < n) {
            this.mLayoutWidget.setWidth(this.mLayoutWidget.mWrapFixedWidth);
          }
          this.mLayoutWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        if ((this.mLayoutWidget.mVerticalWrapOptimized) && (i2 == -2147483648))
        {
          if (this.mLayoutWidget.mWrapFixedHeight < i3) {
            this.mLayoutWidget.setHeight(this.mLayoutWidget.mWrapFixedHeight);
          }
          this.mLayoutWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
      }
      if ((this.mOptimizationLevel & 0x20) == 32)
      {
        i = this.mLayoutWidget.getWidth();
        i4 = this.mLayoutWidget.getHeight();
        if ((this.mLastMeasureWidth != i) && (j == 1073741824)) {
          Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 0, i);
        }
        if ((this.mLastMeasureHeight != i4) && (i2 == 1073741824)) {
          Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 1, i4);
        }
        if ((this.mLayoutWidget.mHorizontalWrapOptimized) && (this.mLayoutWidget.mWrapFixedWidth > n)) {
          Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 0, n);
        }
        if ((this.mLayoutWidget.mVerticalWrapOptimized) && (this.mLayoutWidget.mWrapFixedHeight > i3)) {
          Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 1, i3);
        }
      }
      if (getChildCount() > 0) {
        solveLinearSystem("First pass");
      }
      j = 0;
      i = 0;
      i8 = this.mVariableDimensionsWidgets.size();
      i9 = m + getPaddingBottom();
      i10 = k + getPaddingRight();
      if (i8 <= 0) {
        break label1380;
      }
      m = 0;
      if (this.mLayoutWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        break label1092;
      }
      i2 = 1;
      if (this.mLayoutWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        break label1098;
      }
      i3 = 1;
      j = Math.max(this.mLayoutWidget.getWidth(), this.mMinWidth);
      k = Math.max(this.mLayoutWidget.getHeight(), this.mMinHeight);
      i4 = 0;
      if (i4 >= i8) {
        break label1136;
      }
      localObject = (ConstraintWidget)this.mVariableDimensionsWidgets.get(i4);
      localView = (View)((ConstraintWidget)localObject).getCompanionWidget();
      if (localView == null) {
        break label1576;
      }
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams.isHelper) || (localLayoutParams.isGuideline) || (localView.getVisibility() == 8) || ((i1 != 0) && (((ConstraintWidget)localObject).getResolutionWidth().isResolved()) && (((ConstraintWidget)localObject).getResolutionHeight().isResolved()))) {
        break label1576;
      }
      if ((localLayoutParams.width != -2) || (!localLayoutParams.horizontalDimensionFixed)) {
        break label1104;
      }
      n = getChildMeasureSpec(paramInt1, i10, localLayoutParams.width);
      if ((localLayoutParams.height != -2) || (!localLayoutParams.verticalDimensionFixed)) {
        break label1120;
      }
      i5 = getChildMeasureSpec(paramInt2, i9, localLayoutParams.height);
      label779:
      localView.measure(n, i5);
      if (this.mMetrics != null)
      {
        Metrics localMetrics = this.mMetrics;
        localMetrics.additionalMeasures += 1L;
      }
      n = localView.getMeasuredWidth();
      i5 = localView.getMeasuredHeight();
      if (n == ((ConstraintWidget)localObject).getWidth()) {
        break label1561;
      }
      ((ConstraintWidget)localObject).setWidth(n);
      if (i1 != 0) {
        ((ConstraintWidget)localObject).getResolutionWidth().resolve(n);
      }
      if ((i2 == 0) || (((ConstraintWidget)localObject).getRight() <= j)) {
        break label1554;
      }
      m = Math.max(j, ((ConstraintWidget)localObject).getRight() + ((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
      label898:
      j = 1;
      label901:
      if (i5 == ((ConstraintWidget)localObject).getHeight()) {
        break label1547;
      }
      ((ConstraintWidget)localObject).setHeight(i5);
      if (i1 != 0) {
        ((ConstraintWidget)localObject).getResolutionHeight().resolve(i5);
      }
      if ((i3 == 0) || (((ConstraintWidget)localObject).getBottom() <= k)) {
        break label1540;
      }
      j = Math.max(k, ((ConstraintWidget)localObject).getBottom() + ((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
      label972:
      n = 1;
      k = j;
      label979:
      j = n;
      if (localLayoutParams.needsBaseline)
      {
        i5 = localView.getBaseline();
        j = n;
        if (i5 != -1)
        {
          j = n;
          if (i5 != ((ConstraintWidget)localObject).getBaselineDistance())
          {
            ((ConstraintWidget)localObject).setBaselineDistance(i5);
            j = 1;
          }
        }
      }
      if (Build.VERSION.SDK_INT < 11) {
        break label1529;
      }
      i = combineMeasuredStates(i, localView.getMeasuredState());
      n = j;
      j = m;
    }
    for (;;)
    {
      i4 += 1;
      m = n;
      break label618;
      bool = false;
      break;
      label1077:
      i1 = 0;
      break label171;
      label1083:
      internalMeasureChildren(paramInt1, paramInt2);
      break label200;
      label1092:
      i2 = 0;
      break label567;
      label1098:
      i3 = 0;
      break label583;
      label1104:
      n = View.MeasureSpec.makeMeasureSpec(((ConstraintWidget)localObject).getWidth(), 1073741824);
      break label748;
      label1120:
      i5 = View.MeasureSpec.makeMeasureSpec(((ConstraintWidget)localObject).getHeight(), 1073741824);
      break label779;
      label1136:
      if (m != 0)
      {
        this.mLayoutWidget.setWidth(i6);
        this.mLayoutWidget.setHeight(i7);
        if (i1 != 0) {
          this.mLayoutWidget.solveGraph();
        }
        solveLinearSystem("2nd pass");
        m = 0;
        if (this.mLayoutWidget.getWidth() < j)
        {
          this.mLayoutWidget.setWidth(j);
          m = 1;
        }
        if (this.mLayoutWidget.getHeight() < k)
        {
          this.mLayoutWidget.setHeight(k);
          m = 1;
        }
        if (m != 0) {
          solveLinearSystem("3rd pass");
        }
      }
      k = 0;
      for (;;)
      {
        j = i;
        if (k >= i8) {
          break;
        }
        localObject = (ConstraintWidget)this.mVariableDimensionsWidgets.get(k);
        localView = (View)((ConstraintWidget)localObject).getCompanionWidget();
        if ((localView != null) && ((localView.getMeasuredWidth() != ((ConstraintWidget)localObject).getWidth()) || (localView.getMeasuredHeight() != ((ConstraintWidget)localObject).getHeight())) && (((ConstraintWidget)localObject).getVisibility() != 8))
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(((ConstraintWidget)localObject).getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(((ConstraintWidget)localObject).getHeight(), 1073741824));
          if (this.mMetrics != null)
          {
            localObject = this.mMetrics;
            ((Metrics)localObject).additionalMeasures += 1L;
          }
        }
        k += 1;
      }
      label1380:
      i = this.mLayoutWidget.getWidth() + i10;
      k = this.mLayoutWidget.getHeight() + i9;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramInt1 = resolveSizeAndState(i, paramInt1, j);
        i = resolveSizeAndState(k, paramInt2, j << 16);
        paramInt2 = Math.min(this.mMaxWidth, paramInt1 & 0xFFFFFF);
        i = Math.min(this.mMaxHeight, i & 0xFFFFFF);
        paramInt1 = paramInt2;
        if (this.mLayoutWidget.isWidthMeasuredTooSmall()) {
          paramInt1 = paramInt2 | 0x1000000;
        }
        paramInt2 = i;
        if (this.mLayoutWidget.isHeightMeasuredTooSmall()) {
          paramInt2 = i | 0x1000000;
        }
        setMeasuredDimension(paramInt1, paramInt2);
        this.mLastMeasureWidth = paramInt1;
        this.mLastMeasureHeight = paramInt2;
        return;
      }
      setMeasuredDimension(i, k);
      this.mLastMeasureWidth = i;
      this.mLastMeasureHeight = k;
      return;
      label1529:
      n = j;
      j = m;
      continue;
      label1540:
      j = k;
      break label972;
      label1547:
      n = j;
      break label979;
      label1554:
      m = j;
      break label898;
      label1561:
      n = m;
      m = j;
      j = n;
      break label901;
      label1576:
      n = m;
    }
  }
  
  public void onViewAdded(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewAdded(paramView);
    }
    Object localObject = getViewWidget(paramView);
    if (((paramView instanceof Guideline)) && (!(localObject instanceof android.support.constraint.solver.widgets.Guideline)))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      ((LayoutParams)localObject).widget = new android.support.constraint.solver.widgets.Guideline();
      ((LayoutParams)localObject).isGuideline = true;
      ((android.support.constraint.solver.widgets.Guideline)((LayoutParams)localObject).widget).setOrientation(((LayoutParams)localObject).orientation);
    }
    if ((paramView instanceof ConstraintHelper))
    {
      localObject = (ConstraintHelper)paramView;
      ((ConstraintHelper)localObject).validateParams();
      ((LayoutParams)paramView.getLayoutParams()).isHelper = true;
      if (!this.mConstraintHelpers.contains(localObject)) {
        this.mConstraintHelpers.add(localObject);
      }
    }
    this.mChildrenByIds.put(paramView.getId(), paramView);
    this.mDirtyHierarchy = true;
  }
  
  public void onViewRemoved(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewRemoved(paramView);
    }
    this.mChildrenByIds.remove(paramView.getId());
    ConstraintWidget localConstraintWidget = getViewWidget(paramView);
    this.mLayoutWidget.remove(localConstraintWidget);
    this.mConstraintHelpers.remove(paramView);
    this.mVariableDimensionsWidgets.remove(localConstraintWidget);
    this.mDirtyHierarchy = true;
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14) {
      onViewRemoved(paramView);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    this.mDirtyHierarchy = true;
    this.mLastMeasureWidth = -1;
    this.mLastMeasureHeight = -1;
    this.mLastMeasureWidthSize = -1;
    this.mLastMeasureHeightSize = -1;
    this.mLastMeasureWidthMode = 0;
    this.mLastMeasureHeightMode = 0;
  }
  
  public void setConstraintSet(ConstraintSet paramConstraintSet)
  {
    this.mConstraintSet = paramConstraintSet;
  }
  
  public void setDesignInformation(int paramInt, Object paramObject1, Object paramObject2)
  {
    if ((paramInt == 0) && ((paramObject1 instanceof String)) && ((paramObject2 instanceof Integer)))
    {
      if (this.mDesignIds == null) {
        this.mDesignIds = new HashMap();
      }
      String str = (String)paramObject1;
      paramInt = str.indexOf("/");
      paramObject1 = str;
      if (paramInt != -1) {
        paramObject1 = str.substring(paramInt + 1);
      }
      paramInt = ((Integer)paramObject2).intValue();
      this.mDesignIds.put(paramObject1, Integer.valueOf(paramInt));
    }
  }
  
  public void setId(int paramInt)
  {
    this.mChildrenByIds.remove(getId());
    super.setId(paramInt);
    this.mChildrenByIds.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (paramInt == this.mMaxHeight) {
      return;
    }
    this.mMaxHeight = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (paramInt == this.mMaxWidth) {
      return;
    }
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt == this.mMinHeight) {
      return;
    }
    this.mMinHeight = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt == this.mMinWidth) {
      return;
    }
    this.mMinWidth = paramInt;
    requestLayout();
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.mLayoutWidget.setOptimizationLevel(paramInt);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  protected void solveLinearSystem(String paramString)
  {
    this.mLayoutWidget.layout();
    if (this.mMetrics != null)
    {
      paramString = this.mMetrics;
      paramString.resolutions += 1L;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int END = 7;
    public static final int HORIZONTAL = 0;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int VERTICAL = 1;
    public int baselineToBaseline = -1;
    public int bottomToBottom = -1;
    public int bottomToTop = -1;
    public float circleAngle = 0.0F;
    public int circleConstraint = -1;
    public int circleRadius = 0;
    public boolean constrainedHeight = false;
    public boolean constrainedWidth = false;
    public String dimensionRatio = null;
    int dimensionRatioSide = 1;
    float dimensionRatioValue = 0.0F;
    public int editorAbsoluteX = -1;
    public int editorAbsoluteY = -1;
    public int endToEnd = -1;
    public int endToStart = -1;
    public int goneBottomMargin = -1;
    public int goneEndMargin = -1;
    public int goneLeftMargin = -1;
    public int goneRightMargin = -1;
    public int goneStartMargin = -1;
    public int goneTopMargin = -1;
    public int guideBegin = -1;
    public int guideEnd = -1;
    public float guidePercent = -1.0F;
    public boolean helped = false;
    public float horizontalBias = 0.5F;
    public int horizontalChainStyle = 0;
    boolean horizontalDimensionFixed = true;
    public float horizontalWeight = -1.0F;
    boolean isGuideline = false;
    boolean isHelper = false;
    boolean isInPlaceholder = false;
    public int leftToLeft = -1;
    public int leftToRight = -1;
    public int matchConstraintDefaultHeight = 0;
    public int matchConstraintDefaultWidth = 0;
    public int matchConstraintMaxHeight = 0;
    public int matchConstraintMaxWidth = 0;
    public int matchConstraintMinHeight = 0;
    public int matchConstraintMinWidth = 0;
    public float matchConstraintPercentHeight = 1.0F;
    public float matchConstraintPercentWidth = 1.0F;
    boolean needsBaseline = false;
    public int orientation = -1;
    int resolveGoneLeftMargin = -1;
    int resolveGoneRightMargin = -1;
    int resolvedGuideBegin;
    int resolvedGuideEnd;
    float resolvedGuidePercent;
    float resolvedHorizontalBias = 0.5F;
    int resolvedLeftToLeft = -1;
    int resolvedLeftToRight = -1;
    int resolvedRightToLeft = -1;
    int resolvedRightToRight = -1;
    public int rightToLeft = -1;
    public int rightToRight = -1;
    public int startToEnd = -1;
    public int startToStart = -1;
    public int topToBottom = -1;
    public int topToTop = -1;
    public float verticalBias = 0.5F;
    public int verticalChainStyle = 0;
    boolean verticalDimensionFixed = true;
    public float verticalWeight = -1.0F;
    ConstraintWidget widget = new ConstraintWidget();
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int k = paramContext.getIndexCount();
      int i = 0;
      if (i < k)
      {
        int j = paramContext.getIndex(i);
        switch (Table.map.get(j))
        {
        }
        for (;;)
        {
          i += 1;
          break;
          this.leftToLeft = paramContext.getResourceId(j, this.leftToLeft);
          if (this.leftToLeft == -1)
          {
            this.leftToLeft = paramContext.getInt(j, -1);
            continue;
            this.leftToRight = paramContext.getResourceId(j, this.leftToRight);
            if (this.leftToRight == -1)
            {
              this.leftToRight = paramContext.getInt(j, -1);
              continue;
              this.rightToLeft = paramContext.getResourceId(j, this.rightToLeft);
              if (this.rightToLeft == -1)
              {
                this.rightToLeft = paramContext.getInt(j, -1);
                continue;
                this.rightToRight = paramContext.getResourceId(j, this.rightToRight);
                if (this.rightToRight == -1)
                {
                  this.rightToRight = paramContext.getInt(j, -1);
                  continue;
                  this.topToTop = paramContext.getResourceId(j, this.topToTop);
                  if (this.topToTop == -1)
                  {
                    this.topToTop = paramContext.getInt(j, -1);
                    continue;
                    this.topToBottom = paramContext.getResourceId(j, this.topToBottom);
                    if (this.topToBottom == -1)
                    {
                      this.topToBottom = paramContext.getInt(j, -1);
                      continue;
                      this.bottomToTop = paramContext.getResourceId(j, this.bottomToTop);
                      if (this.bottomToTop == -1)
                      {
                        this.bottomToTop = paramContext.getInt(j, -1);
                        continue;
                        this.bottomToBottom = paramContext.getResourceId(j, this.bottomToBottom);
                        if (this.bottomToBottom == -1)
                        {
                          this.bottomToBottom = paramContext.getInt(j, -1);
                          continue;
                          this.baselineToBaseline = paramContext.getResourceId(j, this.baselineToBaseline);
                          if (this.baselineToBaseline == -1)
                          {
                            this.baselineToBaseline = paramContext.getInt(j, -1);
                            continue;
                            this.circleConstraint = paramContext.getResourceId(j, this.circleConstraint);
                            if (this.circleConstraint == -1)
                            {
                              this.circleConstraint = paramContext.getInt(j, -1);
                              continue;
                              this.circleRadius = paramContext.getDimensionPixelSize(j, this.circleRadius);
                              continue;
                              this.circleAngle = (paramContext.getFloat(j, this.circleAngle) % 360.0F);
                              if (this.circleAngle < 0.0F)
                              {
                                this.circleAngle = ((360.0F - this.circleAngle) % 360.0F);
                                continue;
                                this.editorAbsoluteX = paramContext.getDimensionPixelOffset(j, this.editorAbsoluteX);
                                continue;
                                this.editorAbsoluteY = paramContext.getDimensionPixelOffset(j, this.editorAbsoluteY);
                                continue;
                                this.guideBegin = paramContext.getDimensionPixelOffset(j, this.guideBegin);
                                continue;
                                this.guideEnd = paramContext.getDimensionPixelOffset(j, this.guideEnd);
                                continue;
                                this.guidePercent = paramContext.getFloat(j, this.guidePercent);
                                continue;
                                this.orientation = paramContext.getInt(j, this.orientation);
                                continue;
                                this.startToEnd = paramContext.getResourceId(j, this.startToEnd);
                                if (this.startToEnd == -1)
                                {
                                  this.startToEnd = paramContext.getInt(j, -1);
                                  continue;
                                  this.startToStart = paramContext.getResourceId(j, this.startToStart);
                                  if (this.startToStart == -1)
                                  {
                                    this.startToStart = paramContext.getInt(j, -1);
                                    continue;
                                    this.endToStart = paramContext.getResourceId(j, this.endToStart);
                                    if (this.endToStart == -1)
                                    {
                                      this.endToStart = paramContext.getInt(j, -1);
                                      continue;
                                      this.endToEnd = paramContext.getResourceId(j, this.endToEnd);
                                      if (this.endToEnd == -1)
                                      {
                                        this.endToEnd = paramContext.getInt(j, -1);
                                        continue;
                                        this.goneLeftMargin = paramContext.getDimensionPixelSize(j, this.goneLeftMargin);
                                        continue;
                                        this.goneTopMargin = paramContext.getDimensionPixelSize(j, this.goneTopMargin);
                                        continue;
                                        this.goneRightMargin = paramContext.getDimensionPixelSize(j, this.goneRightMargin);
                                        continue;
                                        this.goneBottomMargin = paramContext.getDimensionPixelSize(j, this.goneBottomMargin);
                                        continue;
                                        this.goneStartMargin = paramContext.getDimensionPixelSize(j, this.goneStartMargin);
                                        continue;
                                        this.goneEndMargin = paramContext.getDimensionPixelSize(j, this.goneEndMargin);
                                        continue;
                                        this.horizontalBias = paramContext.getFloat(j, this.horizontalBias);
                                        continue;
                                        this.verticalBias = paramContext.getFloat(j, this.verticalBias);
                                        continue;
                                        this.dimensionRatio = paramContext.getString(j);
                                        this.dimensionRatioValue = (0.0F / 0.0F);
                                        this.dimensionRatioSide = -1;
                                        if (this.dimensionRatio != null)
                                        {
                                          int m = this.dimensionRatio.length();
                                          j = this.dimensionRatio.indexOf(',');
                                          if ((j > 0) && (j < m - 1))
                                          {
                                            paramAttributeSet = this.dimensionRatio.substring(0, j);
                                            if (paramAttributeSet.equalsIgnoreCase("W"))
                                            {
                                              this.dimensionRatioSide = 0;
                                              label1491:
                                              j += 1;
                                            }
                                          }
                                          float f1;
                                          float f2;
                                          for (;;)
                                          {
                                            for (;;)
                                            {
                                              int n = this.dimensionRatio.indexOf(':');
                                              if ((n < 0) || (n >= m - 1)) {
                                                break label1653;
                                              }
                                              paramAttributeSet = this.dimensionRatio.substring(j, n);
                                              String str = this.dimensionRatio.substring(n + 1);
                                              if ((paramAttributeSet.length() <= 0) || (str.length() <= 0)) {
                                                break;
                                              }
                                              try
                                              {
                                                f1 = Float.parseFloat(paramAttributeSet);
                                                f2 = Float.parseFloat(str);
                                                if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
                                                  break;
                                                }
                                                if (this.dimensionRatioSide != 1) {
                                                  break label1637;
                                                }
                                                this.dimensionRatioValue = Math.abs(f2 / f1);
                                              }
                                              catch (NumberFormatException paramAttributeSet) {}
                                            }
                                            break;
                                            if (!paramAttributeSet.equalsIgnoreCase("H")) {
                                              break label1491;
                                            }
                                            this.dimensionRatioSide = 1;
                                            break label1491;
                                            j = 0;
                                          }
                                          label1637:
                                          f1 /= f2;
                                          this.dimensionRatioValue = Math.abs(f1);
                                          continue;
                                          label1653:
                                          paramAttributeSet = this.dimensionRatio.substring(j);
                                          if (paramAttributeSet.length() > 0)
                                          {
                                            try
                                            {
                                              this.dimensionRatioValue = Float.parseFloat(paramAttributeSet);
                                            }
                                            catch (NumberFormatException paramAttributeSet) {}
                                            continue;
                                            this.horizontalWeight = paramContext.getFloat(j, this.horizontalWeight);
                                            continue;
                                            this.verticalWeight = paramContext.getFloat(j, this.verticalWeight);
                                            continue;
                                            this.horizontalChainStyle = paramContext.getInt(j, 0);
                                            continue;
                                            this.verticalChainStyle = paramContext.getInt(j, 0);
                                            continue;
                                            this.constrainedWidth = paramContext.getBoolean(j, this.constrainedWidth);
                                            continue;
                                            this.constrainedHeight = paramContext.getBoolean(j, this.constrainedHeight);
                                            continue;
                                            this.matchConstraintDefaultWidth = paramContext.getInt(j, 0);
                                            if (this.matchConstraintDefaultWidth == 1)
                                            {
                                              continue;
                                              this.matchConstraintDefaultHeight = paramContext.getInt(j, 0);
                                              if (this.matchConstraintDefaultHeight == 1)
                                              {
                                                continue;
                                                try
                                                {
                                                  this.matchConstraintMinWidth = paramContext.getDimensionPixelSize(j, this.matchConstraintMinWidth);
                                                }
                                                catch (Exception paramAttributeSet) {}
                                                if (paramContext.getInt(j, this.matchConstraintMinWidth) == -2)
                                                {
                                                  this.matchConstraintMinWidth = -2;
                                                  continue;
                                                  try
                                                  {
                                                    this.matchConstraintMaxWidth = paramContext.getDimensionPixelSize(j, this.matchConstraintMaxWidth);
                                                  }
                                                  catch (Exception paramAttributeSet) {}
                                                  if (paramContext.getInt(j, this.matchConstraintMaxWidth) == -2)
                                                  {
                                                    this.matchConstraintMaxWidth = -2;
                                                    continue;
                                                    this.matchConstraintPercentWidth = Math.max(0.0F, paramContext.getFloat(j, this.matchConstraintPercentWidth));
                                                    continue;
                                                    try
                                                    {
                                                      this.matchConstraintMinHeight = paramContext.getDimensionPixelSize(j, this.matchConstraintMinHeight);
                                                    }
                                                    catch (Exception paramAttributeSet) {}
                                                    if (paramContext.getInt(j, this.matchConstraintMinHeight) == -2)
                                                    {
                                                      this.matchConstraintMinHeight = -2;
                                                      continue;
                                                      try
                                                      {
                                                        this.matchConstraintMaxHeight = paramContext.getDimensionPixelSize(j, this.matchConstraintMaxHeight);
                                                      }
                                                      catch (Exception paramAttributeSet) {}
                                                      if (paramContext.getInt(j, this.matchConstraintMaxHeight) == -2)
                                                      {
                                                        this.matchConstraintMaxHeight = -2;
                                                        continue;
                                                        this.matchConstraintPercentHeight = Math.max(0.0F, paramContext.getFloat(j, this.matchConstraintPercentHeight));
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      paramContext.recycle();
      validate();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.guideBegin = paramLayoutParams.guideBegin;
      this.guideEnd = paramLayoutParams.guideEnd;
      this.guidePercent = paramLayoutParams.guidePercent;
      this.leftToLeft = paramLayoutParams.leftToLeft;
      this.leftToRight = paramLayoutParams.leftToRight;
      this.rightToLeft = paramLayoutParams.rightToLeft;
      this.rightToRight = paramLayoutParams.rightToRight;
      this.topToTop = paramLayoutParams.topToTop;
      this.topToBottom = paramLayoutParams.topToBottom;
      this.bottomToTop = paramLayoutParams.bottomToTop;
      this.bottomToBottom = paramLayoutParams.bottomToBottom;
      this.baselineToBaseline = paramLayoutParams.baselineToBaseline;
      this.circleConstraint = paramLayoutParams.circleConstraint;
      this.circleRadius = paramLayoutParams.circleRadius;
      this.circleAngle = paramLayoutParams.circleAngle;
      this.startToEnd = paramLayoutParams.startToEnd;
      this.startToStart = paramLayoutParams.startToStart;
      this.endToStart = paramLayoutParams.endToStart;
      this.endToEnd = paramLayoutParams.endToEnd;
      this.goneLeftMargin = paramLayoutParams.goneLeftMargin;
      this.goneTopMargin = paramLayoutParams.goneTopMargin;
      this.goneRightMargin = paramLayoutParams.goneRightMargin;
      this.goneBottomMargin = paramLayoutParams.goneBottomMargin;
      this.goneStartMargin = paramLayoutParams.goneStartMargin;
      this.goneEndMargin = paramLayoutParams.goneEndMargin;
      this.horizontalBias = paramLayoutParams.horizontalBias;
      this.verticalBias = paramLayoutParams.verticalBias;
      this.dimensionRatio = paramLayoutParams.dimensionRatio;
      this.dimensionRatioValue = paramLayoutParams.dimensionRatioValue;
      this.dimensionRatioSide = paramLayoutParams.dimensionRatioSide;
      this.horizontalWeight = paramLayoutParams.horizontalWeight;
      this.verticalWeight = paramLayoutParams.verticalWeight;
      this.horizontalChainStyle = paramLayoutParams.horizontalChainStyle;
      this.verticalChainStyle = paramLayoutParams.verticalChainStyle;
      this.constrainedWidth = paramLayoutParams.constrainedWidth;
      this.constrainedHeight = paramLayoutParams.constrainedHeight;
      this.matchConstraintDefaultWidth = paramLayoutParams.matchConstraintDefaultWidth;
      this.matchConstraintDefaultHeight = paramLayoutParams.matchConstraintDefaultHeight;
      this.matchConstraintMinWidth = paramLayoutParams.matchConstraintMinWidth;
      this.matchConstraintMaxWidth = paramLayoutParams.matchConstraintMaxWidth;
      this.matchConstraintMinHeight = paramLayoutParams.matchConstraintMinHeight;
      this.matchConstraintMaxHeight = paramLayoutParams.matchConstraintMaxHeight;
      this.matchConstraintPercentWidth = paramLayoutParams.matchConstraintPercentWidth;
      this.matchConstraintPercentHeight = paramLayoutParams.matchConstraintPercentHeight;
      this.editorAbsoluteX = paramLayoutParams.editorAbsoluteX;
      this.editorAbsoluteY = paramLayoutParams.editorAbsoluteY;
      this.orientation = paramLayoutParams.orientation;
      this.horizontalDimensionFixed = paramLayoutParams.horizontalDimensionFixed;
      this.verticalDimensionFixed = paramLayoutParams.verticalDimensionFixed;
      this.needsBaseline = paramLayoutParams.needsBaseline;
      this.isGuideline = paramLayoutParams.isGuideline;
      this.resolvedLeftToLeft = paramLayoutParams.resolvedLeftToLeft;
      this.resolvedLeftToRight = paramLayoutParams.resolvedLeftToRight;
      this.resolvedRightToLeft = paramLayoutParams.resolvedRightToLeft;
      this.resolvedRightToRight = paramLayoutParams.resolvedRightToRight;
      this.resolveGoneLeftMargin = paramLayoutParams.resolveGoneLeftMargin;
      this.resolveGoneRightMargin = paramLayoutParams.resolveGoneRightMargin;
      this.resolvedHorizontalBias = paramLayoutParams.resolvedHorizontalBias;
      this.widget = paramLayoutParams.widget;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public void reset()
    {
      if (this.widget != null) {
        this.widget.reset();
      }
    }
    
    @TargetApi(17)
    public void resolveLayoutDirection(int paramInt)
    {
      int i = 0;
      int j = this.leftMargin;
      int k = this.rightMargin;
      super.resolveLayoutDirection(paramInt);
      this.resolvedRightToLeft = -1;
      this.resolvedRightToRight = -1;
      this.resolvedLeftToLeft = -1;
      this.resolvedLeftToRight = -1;
      this.resolveGoneLeftMargin = -1;
      this.resolveGoneRightMargin = -1;
      this.resolveGoneLeftMargin = this.goneLeftMargin;
      this.resolveGoneRightMargin = this.goneRightMargin;
      this.resolvedHorizontalBias = this.horizontalBias;
      this.resolvedGuideBegin = this.guideBegin;
      this.resolvedGuideEnd = this.guideEnd;
      this.resolvedGuidePercent = this.guidePercent;
      label128:
      label321:
      if (1 == getLayoutDirection())
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label442;
        }
        if (this.startToEnd == -1) {
          break label359;
        }
        this.resolvedRightToLeft = this.startToEnd;
        paramInt = 1;
        if (this.endToStart != -1)
        {
          this.resolvedLeftToRight = this.endToStart;
          paramInt = 1;
        }
        if (this.endToEnd != -1)
        {
          this.resolvedLeftToLeft = this.endToEnd;
          paramInt = 1;
        }
        if (this.goneStartMargin != -1) {
          this.resolveGoneRightMargin = this.goneStartMargin;
        }
        if (this.goneEndMargin != -1) {
          this.resolveGoneLeftMargin = this.goneEndMargin;
        }
        if (paramInt != 0) {
          this.resolvedHorizontalBias = (1.0F - this.horizontalBias);
        }
        if ((this.isGuideline) && (this.orientation == 1))
        {
          if (this.guidePercent == -1.0F) {
            break label382;
          }
          this.resolvedGuidePercent = (1.0F - this.guidePercent);
          this.resolvedGuideBegin = -1;
          this.resolvedGuideEnd = -1;
        }
        label255:
        if ((this.endToStart == -1) && (this.endToEnd == -1) && (this.startToStart == -1) && (this.startToEnd == -1))
        {
          if (this.rightToLeft == -1) {
            break label541;
          }
          this.resolvedRightToLeft = this.rightToLeft;
          if ((this.rightMargin <= 0) && (k > 0)) {
            this.rightMargin = k;
          }
          if (this.leftToLeft == -1) {
            break label578;
          }
          this.resolvedLeftToLeft = this.leftToLeft;
          if ((this.leftMargin <= 0) && (j > 0)) {
            this.leftMargin = j;
          }
        }
      }
      label359:
      label382:
      do
      {
        do
        {
          return;
          paramInt = 0;
          break;
          paramInt = i;
          if (this.startToStart == -1) {
            break label128;
          }
          this.resolvedRightToRight = this.startToStart;
          paramInt = 1;
          break label128;
          if (this.guideBegin != -1)
          {
            this.resolvedGuideEnd = this.guideBegin;
            this.resolvedGuideBegin = -1;
            this.resolvedGuidePercent = -1.0F;
            break label255;
          }
          if (this.guideEnd == -1) {
            break label255;
          }
          this.resolvedGuideBegin = this.guideEnd;
          this.resolvedGuideEnd = -1;
          this.resolvedGuidePercent = -1.0F;
          break label255;
          if (this.startToEnd != -1) {
            this.resolvedLeftToRight = this.startToEnd;
          }
          if (this.startToStart != -1) {
            this.resolvedLeftToLeft = this.startToStart;
          }
          if (this.endToStart != -1) {
            this.resolvedRightToLeft = this.endToStart;
          }
          if (this.endToEnd != -1) {
            this.resolvedRightToRight = this.endToEnd;
          }
          if (this.goneStartMargin != -1) {
            this.resolveGoneLeftMargin = this.goneStartMargin;
          }
          if (this.goneEndMargin == -1) {
            break label255;
          }
          this.resolveGoneRightMargin = this.goneEndMargin;
          break label255;
          if (this.rightToRight == -1) {
            break label321;
          }
          this.resolvedRightToRight = this.rightToRight;
          if ((this.rightMargin > 0) || (k <= 0)) {
            break label321;
          }
          this.rightMargin = k;
          break label321;
        } while (this.leftToRight == -1);
        this.resolvedLeftToRight = this.leftToRight;
      } while ((this.leftMargin > 0) || (j <= 0));
      label442:
      label578:
      this.leftMargin = j;
      label541:
    }
    
    public void validate()
    {
      this.isGuideline = false;
      this.horizontalDimensionFixed = true;
      this.verticalDimensionFixed = true;
      if ((this.width == -2) && (this.constrainedWidth))
      {
        this.horizontalDimensionFixed = false;
        this.matchConstraintDefaultWidth = 1;
      }
      if ((this.height == -2) && (this.constrainedHeight))
      {
        this.verticalDimensionFixed = false;
        this.matchConstraintDefaultHeight = 1;
      }
      if ((this.width == 0) || (this.width == -1))
      {
        this.horizontalDimensionFixed = false;
        if ((this.width == 0) && (this.matchConstraintDefaultWidth == 1))
        {
          this.width = -2;
          this.constrainedWidth = true;
        }
      }
      if ((this.height == 0) || (this.height == -1))
      {
        this.verticalDimensionFixed = false;
        if ((this.height == 0) && (this.matchConstraintDefaultHeight == 1))
        {
          this.height = -2;
          this.constrainedHeight = true;
        }
      }
      if ((this.guidePercent != -1.0F) || (this.guideBegin != -1) || (this.guideEnd != -1))
      {
        this.isGuideline = true;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        if (!(this.widget instanceof android.support.constraint.solver.widgets.Guideline)) {
          this.widget = new android.support.constraint.solver.widgets.Guideline();
        }
        ((android.support.constraint.solver.widgets.Guideline)this.widget).setOrientation(this.orientation);
      }
    }
    
    static class Table
    {
      public static final int ANDROID_ORIENTATION = 1;
      public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
      public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
      public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
      public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
      public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
      public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
      public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
      public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
      public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
      public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
      public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
      public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
      public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
      public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
      public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
      public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
      public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
      public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
      public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
      public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
      public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
      public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
      public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
      public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
      public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
      public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
      public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
      public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
      public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
      public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
      public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
      public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
      public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
      public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
      public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
      public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
      public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
      public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
      public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
      public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
      public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
      public static final int LAYOUT_GONE_MARGIN_END = 26;
      public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
      public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
      public static final int LAYOUT_GONE_MARGIN_START = 25;
      public static final int LAYOUT_GONE_MARGIN_TOP = 22;
      public static final int UNUSED = 0;
      public static final SparseIntArray map;
      
      static
      {
        SparseIntArray localSparseIntArray = new SparseIntArray();
        map = localSparseIntArray;
        localSparseIntArray.append(34, 8);
        map.append(35, 9);
        map.append(37, 10);
        map.append(38, 11);
        map.append(43, 12);
        map.append(42, 13);
        map.append(16, 14);
        map.append(15, 15);
        map.append(13, 16);
        map.append(17, 2);
        map.append(19, 3);
        map.append(18, 4);
        map.append(51, 49);
        map.append(52, 50);
        map.append(23, 5);
        map.append(24, 6);
        map.append(25, 7);
        map.append(0, 1);
        map.append(39, 17);
        map.append(40, 18);
        map.append(22, 19);
        map.append(21, 20);
        map.append(55, 21);
        map.append(58, 22);
        map.append(56, 23);
        map.append(53, 24);
        map.append(57, 25);
        map.append(54, 26);
        map.append(30, 29);
        map.append(44, 30);
        map.append(20, 44);
        map.append(32, 45);
        map.append(46, 46);
        map.append(31, 47);
        map.append(45, 48);
        map.append(11, 27);
        map.append(10, 28);
        map.append(47, 31);
        map.append(26, 32);
        map.append(49, 33);
        map.append(48, 34);
        map.append(50, 35);
        map.append(28, 36);
        map.append(27, 37);
        map.append(29, 38);
        map.append(33, 39);
        map.append(41, 40);
        map.append(36, 41);
        map.append(14, 42);
        map.append(12, 43);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.ConstraintLayout
 * JD-Core Version:    0.7.0.1
 */