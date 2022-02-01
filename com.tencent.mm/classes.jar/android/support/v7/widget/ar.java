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
  private static final Interpolator avu = new DecelerateInterpolator();
  int ahh;
  Runnable avn;
  LinearLayoutCompat avo;
  private Spinner avp;
  private boolean avq;
  int avr;
  int avs;
  private int avt;
  
  private boolean me()
  {
    return (this.avp != null) && (this.avp.getParent() == this);
  }
  
  private boolean mf()
  {
    if (!me()) {
      return false;
    }
    removeView(this.avp);
    addView(this.avo, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.avp.getSelectedItemPosition());
    return false;
  }
  
  public final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.avn != null) {
      post(this.avn);
    }
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = a.aa(getContext());
    TypedArray localTypedArray = paramConfiguration.mContext.obtainStyledAttributes(null, a.a.ActionBar, 2130968602, 0);
    int j = localTypedArray.getLayoutDimension(13, 0);
    Resources localResources = paramConfiguration.mContext.getResources();
    int i = j;
    if (!paramConfiguration.ht()) {
      i = Math.min(j, localResources.getDimensionPixelSize(2131165641));
    }
    localTypedArray.recycle();
    setContentHeight(i);
    this.avs = paramConfiguration.mContext.getResources().getDimensionPixelSize(2131165642);
  }
  
  public final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.avn != null) {
      removeCallbacks(this.avn);
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
      int j = this.avo.getChildCount();
      if ((j <= 1) || ((i != 1073741824) && (i != -2147483648))) {
        break label326;
      }
      if (j <= 2) {
        break label313;
      }
      this.avr = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label68:
      this.avr = Math.min(this.avr, this.avs);
      label83:
      i = View.MeasureSpec.makeMeasureSpec(this.ahh, 1073741824);
      if ((bool) || (!this.avq)) {
        break label334;
      }
      label105:
      if (paramInt2 == 0) {
        break label347;
      }
      this.avo.measure(0, i);
      if (this.avo.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label339;
      }
      if (!me())
      {
        if (this.avp == null)
        {
          AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, 2130968609);
          localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
          localAppCompatSpinner.setOnItemSelectedListener(this);
          this.avp = localAppCompatSpinner;
        }
        removeView(this.avo);
        addView(this.avp, new ViewGroup.LayoutParams(-2, -1));
        if (this.avp.getAdapter() == null) {
          this.avp.setAdapter(new a());
        }
        if (this.avn != null)
        {
          removeCallbacks(this.avn);
          this.avn = null;
        }
        this.avp.setSelection(this.avt);
      }
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, i);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        setTabSelected(this.avt);
      }
      return;
      bool = false;
      break;
      label313:
      this.avr = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label68;
      label326:
      this.avr = -1;
      break label83;
      label334:
      paramInt2 = 0;
      break label105;
      label339:
      mf();
      continue;
      label347:
      mf();
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public final void setAllowCollapse(boolean paramBoolean)
  {
    this.avq = paramBoolean;
  }
  
  public final void setContentHeight(int paramInt)
  {
    this.ahh = paramInt;
    requestLayout();
  }
  
  public final void setTabSelected(int paramInt)
  {
    this.avt = paramInt;
    int j = this.avo.getChildCount();
    int i = 0;
    if (i < j)
    {
      final View localView = this.avo.getChildAt(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool)
        {
          localView = this.avo.getChildAt(paramInt);
          if (this.avn != null) {
            removeCallbacks(this.avn);
          }
          this.avn = new Runnable()
          {
            public final void run()
            {
              int i = localView.getLeft();
              int j = (ar.this.getWidth() - localView.getWidth()) / 2;
              ar.this.smoothScrollTo(i - j, 0);
              ar.this.avn = null;
            }
          };
          post(this.avn);
        }
        i += 1;
        break;
      }
    }
    if ((this.avp != null) && (paramInt >= 0)) {
      this.avp.setSelection(paramInt);
    }
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      return ar.this.avo.getChildCount();
    }
    
    public final Object getItem(int paramInt)
    {
      return ((ar.b)ar.this.avo.getChildAt(paramInt)).avy;
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
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, paramView.ahh));
        return paramViewGroup;
      }
      paramViewGroup = (ar.b)paramView;
      paramViewGroup.avy = ((ActionBar.a)getItem(paramInt));
      paramViewGroup.update();
      return paramView;
    }
  }
  
  final class b
    extends LinearLayout
  {
    private TextView Wf;
    private ImageView Xk;
    private View ahw;
    private final int[] avx = { 16842964 };
    ActionBar.a avy;
    
    public b(Context paramContext, ActionBar.a parama)
    {
      super(null, 2130968604);
      this.avy = parama;
      this$1 = az.a(paramContext, null, this.avx, 2130968604, 0);
      if (ar.this.hasValue(0)) {
        setBackgroundDrawable(ar.this.getDrawable(0));
      }
      ar.this.ayA.recycle();
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
      if ((ar.this.avr > 0) && (getMeasuredWidth() > ar.this.avr)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(ar.this.avr, 1073741824), paramInt2);
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
      Object localObject1 = this.avy;
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
        this.ahw = ((View)localObject2);
        if (this.Wf != null) {
          this.Wf.setVisibility(8);
        }
        if (this.Xk != null)
        {
          this.Xk.setVisibility(8);
          this.Xk.setImageDrawable(null);
        }
        return;
      }
      if (this.ahw != null)
      {
        removeView(this.ahw);
        this.ahw = null;
      }
      Object localObject3 = ((ActionBar.a)localObject1).getIcon();
      localObject2 = ((ActionBar.a)localObject1).getText();
      int i;
      if (localObject3 != null)
      {
        Object localObject4;
        if (this.Xk == null)
        {
          localObject4 = new AppCompatImageView(getContext());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          this.Xk = ((ImageView)localObject4);
        }
        this.Xk.setImageDrawable((Drawable)localObject3);
        this.Xk.setVisibility(0);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label356;
        }
        i = 1;
        label209:
        if (i == 0) {
          break label361;
        }
        if (this.Wf == null)
        {
          localObject3 = new AppCompatTextView(getContext(), null, 2130968605);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).gravity = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          this.Wf = ((TextView)localObject3);
        }
        this.Wf.setText((CharSequence)localObject2);
        this.Wf.setVisibility(0);
        label299:
        if (this.Xk != null) {
          this.Xk.setContentDescription(((ActionBar.a)localObject1).getContentDescription());
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
        if (this.Xk == null) {
          break;
        }
        this.Xk.setVisibility(8);
        this.Xk.setImageDrawable(null);
        break;
        label356:
        i = 0;
        break label209;
        label361:
        if (this.Wf == null) {
          break label299;
        }
        this.Wf.setVisibility(8);
        this.Wf.setText(null);
        break label299;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ar
 * JD-Core Version:    0.7.0.1
 */