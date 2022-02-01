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
  private static final Interpolator asH = new DecelerateInterpolator();
  int aew;
  Runnable asA;
  LinearLayoutCompat asB;
  private Spinner asC;
  private boolean asD;
  int asE;
  int asF;
  private int asG;
  
  private boolean lD()
  {
    return (this.asC != null) && (this.asC.getParent() == this);
  }
  
  private boolean lE()
  {
    if (!lD()) {
      return false;
    }
    removeView(this.asC);
    addView(this.asB, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.asC.getSelectedItemPosition());
    return false;
  }
  
  public final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.asA != null) {
      post(this.asA);
    }
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = a.Y(getContext());
    TypedArray localTypedArray = paramConfiguration.mContext.obtainStyledAttributes(null, a.a.ActionBar, 2130968602, 0);
    int j = localTypedArray.getLayoutDimension(13, 0);
    Resources localResources = paramConfiguration.mContext.getResources();
    int i = j;
    if (!paramConfiguration.gV()) {
      i = Math.min(j, localResources.getDimensionPixelSize(2131165641));
    }
    localTypedArray.recycle();
    setContentHeight(i);
    this.asF = paramConfiguration.mContext.getResources().getDimensionPixelSize(2131165642);
  }
  
  public final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.asA != null) {
      removeCallbacks(this.asA);
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
      int j = this.asB.getChildCount();
      if ((j <= 1) || ((i != 1073741824) && (i != -2147483648))) {
        break label326;
      }
      if (j <= 2) {
        break label313;
      }
      this.asE = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label68:
      this.asE = Math.min(this.asE, this.asF);
      label83:
      i = View.MeasureSpec.makeMeasureSpec(this.aew, 1073741824);
      if ((bool) || (!this.asD)) {
        break label334;
      }
      label105:
      if (paramInt2 == 0) {
        break label347;
      }
      this.asB.measure(0, i);
      if (this.asB.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label339;
      }
      if (!lD())
      {
        if (this.asC == null)
        {
          AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, 2130968609);
          localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
          localAppCompatSpinner.setOnItemSelectedListener(this);
          this.asC = localAppCompatSpinner;
        }
        removeView(this.asB);
        addView(this.asC, new ViewGroup.LayoutParams(-2, -1));
        if (this.asC.getAdapter() == null) {
          this.asC.setAdapter(new a());
        }
        if (this.asA != null)
        {
          removeCallbacks(this.asA);
          this.asA = null;
        }
        this.asC.setSelection(this.asG);
      }
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, i);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        setTabSelected(this.asG);
      }
      return;
      bool = false;
      break;
      label313:
      this.asE = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label68;
      label326:
      this.asE = -1;
      break label83;
      label334:
      paramInt2 = 0;
      break label105;
      label339:
      lE();
      continue;
      label347:
      lE();
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public final void setAllowCollapse(boolean paramBoolean)
  {
    this.asD = paramBoolean;
  }
  
  public final void setContentHeight(int paramInt)
  {
    this.aew = paramInt;
    requestLayout();
  }
  
  public final void setTabSelected(int paramInt)
  {
    this.asG = paramInt;
    int j = this.asB.getChildCount();
    int i = 0;
    if (i < j)
    {
      final View localView = this.asB.getChildAt(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool)
        {
          localView = this.asB.getChildAt(paramInt);
          if (this.asA != null) {
            removeCallbacks(this.asA);
          }
          this.asA = new Runnable()
          {
            public final void run()
            {
              int i = localView.getLeft();
              int j = (ar.this.getWidth() - localView.getWidth()) / 2;
              ar.this.smoothScrollTo(i - j, 0);
              ar.this.asA = null;
            }
          };
          post(this.asA);
        }
        i += 1;
        break;
      }
    }
    if ((this.asC != null) && (paramInt >= 0)) {
      this.asC.setSelection(paramInt);
    }
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      return ar.this.asB.getChildCount();
    }
    
    public final Object getItem(int paramInt)
    {
      return ((ar.b)ar.this.asB.getChildAt(paramInt)).asL;
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
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, paramView.aew));
        return paramViewGroup;
      }
      paramViewGroup = (ar.b)paramView;
      paramViewGroup.asL = ((ActionBar.a)getItem(paramInt));
      paramViewGroup.update();
      return paramView;
    }
  }
  
  final class b
    extends LinearLayout
  {
    private TextView Tu;
    private ImageView Uz;
    private View aeL;
    private final int[] asK = { 16842964 };
    ActionBar.a asL;
    
    public b(Context paramContext, ActionBar.a parama)
    {
      super(null, 2130968604);
      this.asL = parama;
      this$1 = az.a(paramContext, null, this.asK, 2130968604, 0);
      if (ar.this.hasValue(0)) {
        setBackgroundDrawable(ar.this.getDrawable(0));
      }
      ar.this.avP.recycle();
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
      if ((ar.this.asE > 0) && (getMeasuredWidth() > ar.this.asE)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(ar.this.asE, 1073741824), paramInt2);
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
      Object localObject1 = this.asL;
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
        this.aeL = ((View)localObject2);
        if (this.Tu != null) {
          this.Tu.setVisibility(8);
        }
        if (this.Uz != null)
        {
          this.Uz.setVisibility(8);
          this.Uz.setImageDrawable(null);
        }
        return;
      }
      if (this.aeL != null)
      {
        removeView(this.aeL);
        this.aeL = null;
      }
      Object localObject3 = ((ActionBar.a)localObject1).getIcon();
      localObject2 = ((ActionBar.a)localObject1).getText();
      int i;
      if (localObject3 != null)
      {
        Object localObject4;
        if (this.Uz == null)
        {
          localObject4 = new AppCompatImageView(getContext());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          this.Uz = ((ImageView)localObject4);
        }
        this.Uz.setImageDrawable((Drawable)localObject3);
        this.Uz.setVisibility(0);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label356;
        }
        i = 1;
        label209:
        if (i == 0) {
          break label361;
        }
        if (this.Tu == null)
        {
          localObject3 = new AppCompatTextView(getContext(), null, 2130968605);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).gravity = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          this.Tu = ((TextView)localObject3);
        }
        this.Tu.setText((CharSequence)localObject2);
        this.Tu.setVisibility(0);
        label299:
        if (this.Uz != null) {
          this.Uz.setContentDescription(((ActionBar.a)localObject1).getContentDescription());
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
        if (this.Uz == null) {
          break;
        }
        this.Uz.setVisibility(8);
        this.Uz.setImageDrawable(null);
        break;
        label356:
        i = 0;
        break label209;
        label361:
        if (this.Tu == null) {
          break label299;
        }
        this.Tu.setVisibility(8);
        this.Tu.setText(null);
        break label299;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ar
 * JD-Core Version:    0.7.0.1
 */