package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.a;
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

public final class ar
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  private static final Interpolator ali = new DecelerateInterpolator();
  int Xr;
  Runnable alb;
  LinearLayoutCompat alc;
  private Spinner ald;
  private boolean ale;
  int alf;
  int alg;
  private int alh;
  
  private boolean kc()
  {
    return (this.ald != null) && (this.ald.getParent() == this);
  }
  
  private boolean kd()
  {
    if (!kc()) {
      return false;
    }
    removeView(this.ald);
    addView(this.alc, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.ald.getSelectedItemPosition());
    return false;
  }
  
  public final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.alb != null) {
      post(this.alb);
    }
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = a.W(getContext());
    TypedArray localTypedArray = paramConfiguration.mContext.obtainStyledAttributes(null, a.a.ActionBar, 2130772139, 0);
    int j = localTypedArray.getLayoutDimension(0, 0);
    Resources localResources = paramConfiguration.mContext.getResources();
    int i = j;
    if (!paramConfiguration.fz()) {
      i = Math.min(j, localResources.getDimensionPixelSize(2131427922));
    }
    localTypedArray.recycle();
    setContentHeight(i);
    this.alg = paramConfiguration.mContext.getResources().getDimensionPixelSize(2131427923);
  }
  
  public final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.alb != null) {
      removeCallbacks(this.alb);
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
      int j = this.alc.getChildCount();
      if ((j <= 1) || ((i != 1073741824) && (i != -2147483648))) {
        break label326;
      }
      if (j <= 2) {
        break label313;
      }
      this.alf = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label68:
      this.alf = Math.min(this.alf, this.alg);
      label83:
      i = View.MeasureSpec.makeMeasureSpec(this.Xr, 1073741824);
      if ((bool) || (!this.ale)) {
        break label334;
      }
      label105:
      if (paramInt2 == 0) {
        break label347;
      }
      this.alc.measure(0, i);
      if (this.alc.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label339;
      }
      if (!kc())
      {
        if (this.ald == null)
        {
          AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, 2130772168);
          localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
          localAppCompatSpinner.setOnItemSelectedListener(this);
          this.ald = localAppCompatSpinner;
        }
        removeView(this.alc);
        addView(this.ald, new ViewGroup.LayoutParams(-2, -1));
        if (this.ald.getAdapter() == null) {
          this.ald.setAdapter(new a());
        }
        if (this.alb != null)
        {
          removeCallbacks(this.alb);
          this.alb = null;
        }
        this.ald.setSelection(this.alh);
      }
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, i);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        setTabSelected(this.alh);
      }
      return;
      bool = false;
      break;
      label313:
      this.alf = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label68;
      label326:
      this.alf = -1;
      break label83;
      label334:
      paramInt2 = 0;
      break label105;
      label339:
      kd();
      continue;
      label347:
      kd();
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public final void setAllowCollapse(boolean paramBoolean)
  {
    this.ale = paramBoolean;
  }
  
  public final void setContentHeight(int paramInt)
  {
    this.Xr = paramInt;
    requestLayout();
  }
  
  public final void setTabSelected(int paramInt)
  {
    this.alh = paramInt;
    int j = this.alc.getChildCount();
    int i = 0;
    if (i < j)
    {
      final View localView = this.alc.getChildAt(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool)
        {
          localView = this.alc.getChildAt(paramInt);
          if (this.alb != null) {
            removeCallbacks(this.alb);
          }
          this.alb = new Runnable()
          {
            public final void run()
            {
              int i = localView.getLeft();
              int j = (ar.this.getWidth() - localView.getWidth()) / 2;
              ar.this.smoothScrollTo(i - j, 0);
              ar.this.alb = null;
            }
          };
          post(this.alb);
        }
        i += 1;
        break;
      }
    }
    if ((this.ald != null) && (paramInt >= 0)) {
      this.ald.setSelection(paramInt);
    }
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      return ar.this.alc.getChildCount();
    }
    
    public final Object getItem(int paramInt)
    {
      return ((ar.b)ar.this.alc.getChildAt(paramInt)).alm;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = ar.this;
        paramViewGroup = (ActionBar.a)getItem(paramInt);
        paramViewGroup = new ar.b(paramView, paramView.getContext(), paramViewGroup);
        paramViewGroup.setBackgroundDrawable(null);
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, paramView.Xr));
        return paramViewGroup;
      }
      paramViewGroup = (ar.b)paramView;
      paramViewGroup.alm = ((ActionBar.a)getItem(paramInt));
      paramViewGroup.update();
      return paramView;
    }
  }
  
  final class b
    extends LinearLayout
  {
    private final int[] all = { 16842964 };
    ActionBar.a alm;
    private View lX;
    private TextView md;
    private ImageView me;
    
    public b(Context paramContext, ActionBar.a parama)
    {
      super(null, 2130772133);
      this.alm = parama;
      this$1 = az.a(paramContext, null, this.all, 2130772133, 0);
      if (ar.this.hasValue(0)) {
        setBackgroundDrawable(ar.this.getDrawable(0));
      }
      ar.this.aoo.recycle();
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
      if ((ar.this.alf > 0) && (getMeasuredWidth() > ar.this.alf)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(ar.this.alf, 1073741824), paramInt2);
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
      Object localObject1 = this.alm;
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
        this.lX = ((View)localObject2);
        if (this.md != null) {
          this.md.setVisibility(8);
        }
        if (this.me != null)
        {
          this.me.setVisibility(8);
          this.me.setImageDrawable(null);
        }
        return;
      }
      if (this.lX != null)
      {
        removeView(this.lX);
        this.lX = null;
      }
      Object localObject3 = ((ActionBar.a)localObject1).getIcon();
      localObject2 = ((ActionBar.a)localObject1).getText();
      int i;
      if (localObject3 != null)
      {
        Object localObject4;
        if (this.me == null)
        {
          localObject4 = new AppCompatImageView(getContext());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          this.me = ((ImageView)localObject4);
        }
        this.me.setImageDrawable((Drawable)localObject3);
        this.me.setVisibility(0);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label356;
        }
        i = 1;
        label209:
        if (i == 0) {
          break label361;
        }
        if (this.md == null)
        {
          localObject3 = new AppCompatTextView(getContext(), null, 2130772135);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).gravity = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          this.md = ((TextView)localObject3);
        }
        this.md.setText((CharSequence)localObject2);
        this.md.setVisibility(0);
        label299:
        if (this.me != null) {
          this.me.setContentDescription(((ActionBar.a)localObject1).getContentDescription());
        }
        if (i == 0) {
          break label388;
        }
      }
      label388:
      for (localObject1 = null;; localObject1 = ((ActionBar.a)localObject1).getContentDescription())
      {
        bb.a(this, (CharSequence)localObject1);
        return;
        if (this.me == null) {
          break;
        }
        this.me.setVisibility(8);
        this.me.setImageDrawable(null);
        break;
        label356:
        i = 0;
        break label209;
        label361:
        if (this.md == null) {
          break label299;
        }
        this.md.setVisibility(8);
        this.md.setText(null);
        break label299;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ar
 * JD-Core Version:    0.7.0.1
 */