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
  private static final Interpolator avs = new DecelerateInterpolator();
  int ahu;
  Runnable avl;
  LinearLayoutCompat avm;
  private Spinner avn;
  private boolean avo;
  int avp;
  int avq;
  private int avr;
  
  private boolean mi()
  {
    return (this.avn != null) && (this.avn.getParent() == this);
  }
  
  private boolean mj()
  {
    if (!mi()) {
      return false;
    }
    removeView(this.avn);
    addView(this.avm, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.avn.getSelectedItemPosition());
    return false;
  }
  
  public final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.avl != null) {
      post(this.avl);
    }
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = a.ab(getContext());
    TypedArray localTypedArray = paramConfiguration.mContext.obtainStyledAttributes(null, a.a.ActionBar, 2130968603, 0);
    int j = localTypedArray.getLayoutDimension(13, 0);
    Resources localResources = paramConfiguration.mContext.getResources();
    int i = j;
    if (!paramConfiguration.hC()) {
      i = Math.min(j, localResources.getDimensionPixelSize(2131165659));
    }
    localTypedArray.recycle();
    setContentHeight(i);
    this.avq = paramConfiguration.mContext.getResources().getDimensionPixelSize(2131165660);
  }
  
  public final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.avl != null) {
      removeCallbacks(this.avl);
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
      int j = this.avm.getChildCount();
      if ((j <= 1) || ((i != 1073741824) && (i != -2147483648))) {
        break label326;
      }
      if (j <= 2) {
        break label313;
      }
      this.avp = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label68:
      this.avp = Math.min(this.avp, this.avq);
      label83:
      i = View.MeasureSpec.makeMeasureSpec(this.ahu, 1073741824);
      if ((bool) || (!this.avo)) {
        break label334;
      }
      label105:
      if (paramInt2 == 0) {
        break label347;
      }
      this.avm.measure(0, i);
      if (this.avm.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label339;
      }
      if (!mi())
      {
        if (this.avn == null)
        {
          AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, 2130968610);
          localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
          localAppCompatSpinner.setOnItemSelectedListener(this);
          this.avn = localAppCompatSpinner;
        }
        removeView(this.avm);
        addView(this.avn, new ViewGroup.LayoutParams(-2, -1));
        if (this.avn.getAdapter() == null) {
          this.avn.setAdapter(new a());
        }
        if (this.avl != null)
        {
          removeCallbacks(this.avl);
          this.avl = null;
        }
        this.avn.setSelection(this.avr);
      }
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, i);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        setTabSelected(this.avr);
      }
      return;
      bool = false;
      break;
      label313:
      this.avp = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label68;
      label326:
      this.avp = -1;
      break label83;
      label334:
      paramInt2 = 0;
      break label105;
      label339:
      mj();
      continue;
      label347:
      mj();
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public final void setAllowCollapse(boolean paramBoolean)
  {
    this.avo = paramBoolean;
  }
  
  public final void setContentHeight(int paramInt)
  {
    this.ahu = paramInt;
    requestLayout();
  }
  
  public final void setTabSelected(int paramInt)
  {
    this.avr = paramInt;
    int j = this.avm.getChildCount();
    int i = 0;
    if (i < j)
    {
      final View localView = this.avm.getChildAt(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool)
        {
          localView = this.avm.getChildAt(paramInt);
          if (this.avl != null) {
            removeCallbacks(this.avl);
          }
          this.avl = new Runnable()
          {
            public final void run()
            {
              int i = localView.getLeft();
              int j = (ar.this.getWidth() - localView.getWidth()) / 2;
              ar.this.smoothScrollTo(i - j, 0);
              ar.this.avl = null;
            }
          };
          post(this.avl);
        }
        i += 1;
        break;
      }
    }
    if ((this.avn != null) && (paramInt >= 0)) {
      this.avn.setSelection(paramInt);
    }
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      return ar.this.avm.getChildCount();
    }
    
    public final Object getItem(int paramInt)
    {
      return ((ar.b)ar.this.avm.getChildAt(paramInt)).avw;
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
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, paramView.ahu));
        return paramViewGroup;
      }
      paramViewGroup = (ar.b)paramView;
      paramViewGroup.avw = ((ActionBar.a)getItem(paramInt));
      paramViewGroup.update();
      return paramView;
    }
  }
  
  final class b
    extends LinearLayout
  {
    private TextView Ws;
    private ImageView Xx;
    private View ahJ;
    private final int[] avv = { 16842964 };
    ActionBar.a avw;
    
    public b(Context paramContext, ActionBar.a parama)
    {
      super(null, 2130968605);
      this.avw = parama;
      this$1 = az.a(paramContext, null, this.avv, 2130968605, 0);
      if (ar.this.hasValue(0)) {
        setBackgroundDrawable(ar.this.getDrawable(0));
      }
      ar.this.ayy.recycle();
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
      if ((ar.this.avp > 0) && (getMeasuredWidth() > ar.this.avp)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(ar.this.avp, 1073741824), paramInt2);
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
      Object localObject1 = this.avw;
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
        this.ahJ = ((View)localObject2);
        if (this.Ws != null) {
          this.Ws.setVisibility(8);
        }
        if (this.Xx != null)
        {
          this.Xx.setVisibility(8);
          this.Xx.setImageDrawable(null);
        }
        return;
      }
      if (this.ahJ != null)
      {
        removeView(this.ahJ);
        this.ahJ = null;
      }
      Object localObject3 = ((ActionBar.a)localObject1).getIcon();
      localObject2 = ((ActionBar.a)localObject1).getText();
      int i;
      if (localObject3 != null)
      {
        Object localObject4;
        if (this.Xx == null)
        {
          localObject4 = new AppCompatImageView(getContext());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          this.Xx = ((ImageView)localObject4);
        }
        this.Xx.setImageDrawable((Drawable)localObject3);
        this.Xx.setVisibility(0);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label356;
        }
        i = 1;
        label209:
        if (i == 0) {
          break label361;
        }
        if (this.Ws == null)
        {
          localObject3 = new AppCompatTextView(getContext(), null, 2130968606);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).gravity = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          this.Ws = ((TextView)localObject3);
        }
        this.Ws.setText((CharSequence)localObject2);
        this.Ws.setVisibility(0);
        label299:
        if (this.Xx != null) {
          this.Xx.setContentDescription(((ActionBar.a)localObject1).getContentDescription());
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
        if (this.Xx == null) {
          break;
        }
        this.Xx.setVisibility(8);
        this.Xx.setImageDrawable(null);
        break;
        label356:
        i = 0;
        break label209;
        label361:
        if (this.Ws == null) {
          break label299;
        }
        this.Ws.setVisibility(8);
        this.Ws.setText(null);
        break label299;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ar
 * JD-Core Version:    0.7.0.1
 */