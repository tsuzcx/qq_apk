package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.a;
import android.support.v7.a.a.d;
import android.support.v7.a.a.j;
import android.support.v7.app.ActionBar.a;
import android.support.v7.view.a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;

public final class aq
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  private static final Interpolator aiS = new DecelerateInterpolator();
  int WE;
  Runnable aiL;
  LinearLayoutCompat aiM;
  private Spinner aiN;
  private boolean aiO;
  int aiP;
  int aiQ;
  private int aiR;
  
  private boolean iq()
  {
    return (this.aiN != null) && (this.aiN.getParent() == this);
  }
  
  private boolean ir()
  {
    if (!iq()) {
      return false;
    }
    removeView(this.aiN);
    addView(this.aiM, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.aiN.getSelectedItemPosition());
    return false;
  }
  
  public final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.aiL != null) {
      post(this.aiL);
    }
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = a.T(getContext());
    TypedArray localTypedArray = paramConfiguration.mContext.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
    int j = localTypedArray.getLayoutDimension(a.j.ActionBar_height, 0);
    Resources localResources = paramConfiguration.mContext.getResources();
    int i = j;
    if (!paramConfiguration.eM()) {
      i = Math.min(j, localResources.getDimensionPixelSize(a.d.abc_action_bar_stacked_max_height));
    }
    localTypedArray.recycle();
    setContentHeight(i);
    this.aiQ = paramConfiguration.mContext.getResources().getDimensionPixelSize(a.d.abc_action_bar_stacked_tab_max_width);
  }
  
  public final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.aiL != null) {
      removeCallbacks(this.aiL);
    }
  }
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    int i = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    if (i == 1073741824)
    {
      bool = true;
      setFillViewport(bool);
      int j = this.aiM.getChildCount();
      if ((j <= 1) || ((i != 1073741824) && (i != -2147483648))) {
        break label327;
      }
      if (j <= 2) {
        break label314;
      }
      this.aiP = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label68:
      this.aiP = Math.min(this.aiP, this.aiQ);
      label83:
      i = View.MeasureSpec.makeMeasureSpec(this.WE, 1073741824);
      if ((bool) || (!this.aiO)) {
        break label335;
      }
      label105:
      if (paramInt2 == 0) {
        break label348;
      }
      this.aiM.measure(0, i);
      if (this.aiM.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label340;
      }
      if (!iq())
      {
        if (this.aiN == null)
        {
          AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, a.a.actionDropDownStyle);
          localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
          localAppCompatSpinner.setOnItemSelectedListener(this);
          this.aiN = localAppCompatSpinner;
        }
        removeView(this.aiM);
        addView(this.aiN, new ViewGroup.LayoutParams(-2, -1));
        if (this.aiN.getAdapter() == null) {
          this.aiN.setAdapter(new a());
        }
        if (this.aiL != null)
        {
          removeCallbacks(this.aiL);
          this.aiL = null;
        }
        this.aiN.setSelection(this.aiR);
      }
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, i);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        setTabSelected(this.aiR);
      }
      return;
      bool = false;
      break;
      label314:
      this.aiP = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label68;
      label327:
      this.aiP = -1;
      break label83;
      label335:
      paramInt2 = 0;
      break label105;
      label340:
      ir();
      continue;
      label348:
      ir();
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public final void setAllowCollapse(boolean paramBoolean)
  {
    this.aiO = paramBoolean;
  }
  
  public final void setContentHeight(int paramInt)
  {
    this.WE = paramInt;
    requestLayout();
  }
  
  public final void setTabSelected(int paramInt)
  {
    this.aiR = paramInt;
    int j = this.aiM.getChildCount();
    int i = 0;
    if (i < j)
    {
      final View localView = this.aiM.getChildAt(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool)
        {
          localView = this.aiM.getChildAt(paramInt);
          if (this.aiL != null) {
            removeCallbacks(this.aiL);
          }
          this.aiL = new Runnable()
          {
            public final void run()
            {
              int i = localView.getLeft();
              int j = (aq.this.getWidth() - localView.getWidth()) / 2;
              aq.this.smoothScrollTo(i - j, 0);
              aq.this.aiL = null;
            }
          };
          post(this.aiL);
        }
        i += 1;
        break;
      }
    }
    if ((this.aiN != null) && (paramInt >= 0)) {
      this.aiN.setSelection(paramInt);
    }
  }
  
  private final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      return aq.this.aiM.getChildCount();
    }
    
    public final Object getItem(int paramInt)
    {
      return ((aq.b)aq.this.aiM.getChildAt(paramInt)).aiW;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = aq.this;
        paramViewGroup = (ActionBar.a)getItem(paramInt);
        paramViewGroup = new aq.b(paramView, paramView.getContext(), paramViewGroup);
        paramViewGroup.setBackgroundDrawable(null);
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, paramView.WE));
        return paramViewGroup;
      }
      paramViewGroup = (aq.b)paramView;
      paramViewGroup.aiW = ((ActionBar.a)getItem(paramInt));
      paramViewGroup.update();
      return paramView;
    }
  }
  
  private final class b
    extends LinearLayout
  {
    private final int[] aiV = { 16842964 };
    ActionBar.a aiW;
    private View la;
    private TextView lh;
    private ImageView li;
    
    public b(Context paramContext, ActionBar.a parama)
    {
      super(null, a.a.actionBarTabStyle);
      this.aiW = parama;
      this$1 = ax.a(paramContext, null, this.aiV, a.a.actionBarTabStyle, 0);
      if (aq.this.hasValue(0)) {
        setBackgroundDrawable(aq.this.getDrawable(0));
      }
      aq.this.alZ.recycle();
      setGravity(8388627);
      update();
    }
    
    public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.a.class.getName());
    }
    
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.a.class.getName());
    }
    
    public final void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if ((aq.this.aiP > 0) && (getMeasuredWidth() > aq.this.aiP)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(aq.this.aiP, 1073741824), paramInt2);
      }
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      if (isSelected() != paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean)) {
          sendAccessibilityEvent(4);
        }
        return;
      }
    }
    
    public final void update()
    {
      Object localObject1 = this.aiW;
      Object localObject2 = ((ActionBar.a)localObject1).getCustomView();
      if (localObject2 != null)
      {
        localObject1 = ((View)localObject2).getParent();
        if (localObject1 != this)
        {
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localObject2);
          }
          addView((View)localObject2);
        }
        this.la = ((View)localObject2);
        if (this.lh != null) {
          this.lh.setVisibility(8);
        }
        if (this.li != null)
        {
          this.li.setVisibility(8);
          this.li.setImageDrawable(null);
        }
        return;
      }
      if (this.la != null)
      {
        removeView(this.la);
        this.la = null;
      }
      Object localObject3 = ((ActionBar.a)localObject1).getIcon();
      localObject2 = ((ActionBar.a)localObject1).getText();
      int i;
      if (localObject3 != null)
      {
        Object localObject4;
        if (this.li == null)
        {
          localObject4 = new AppCompatImageView(getContext());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          this.li = ((ImageView)localObject4);
        }
        this.li.setImageDrawable((Drawable)localObject3);
        this.li.setVisibility(0);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label357;
        }
        i = 1;
        label209:
        if (i == 0) {
          break label362;
        }
        if (this.lh == null)
        {
          localObject3 = new AppCompatTextView(getContext(), null, a.a.actionBarTabTextStyle);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).gravity = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          this.lh = ((TextView)localObject3);
        }
        this.lh.setText((CharSequence)localObject2);
        this.lh.setVisibility(0);
        label300:
        if (this.li != null) {
          this.li.setContentDescription(((ActionBar.a)localObject1).getContentDescription());
        }
        if (i == 0) {
          break label389;
        }
      }
      label389:
      for (localObject1 = null;; localObject1 = ((ActionBar.a)localObject1).getContentDescription())
      {
        az.a(this, (CharSequence)localObject1);
        return;
        if (this.li == null) {
          break;
        }
        this.li.setVisibility(8);
        this.li.setImageDrawable(null);
        break;
        label357:
        i = 0;
        break label209;
        label362:
        if (this.lh == null) {
          break label300;
        }
        this.lh.setVisibility(8);
        this.lh.setText(null);
        break label300;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.aq
 * JD-Core Version:    0.7.0.1
 */