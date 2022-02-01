package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
import androidx.appcompat.a.a;
import androidx.appcompat.a.d;
import androidx.appcompat.a.j;
import androidx.appcompat.app.ActionBar.a;
import androidx.appcompat.view.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class w
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  private static final Interpolator tU;
  int nH;
  Runnable tN;
  LinearLayoutCompat tO;
  private Spinner tP;
  private boolean tQ;
  int tR;
  int tS;
  private int tT;
  
  static
  {
    AppMethodBeat.i(241555);
    tU = new DecelerateInterpolator();
    AppMethodBeat.o(241555);
  }
  
  private boolean dT()
  {
    AppMethodBeat.i(241540);
    if ((this.tP != null) && (this.tP.getParent() == this))
    {
      AppMethodBeat.o(241540);
      return true;
    }
    AppMethodBeat.o(241540);
    return false;
  }
  
  private boolean dU()
  {
    AppMethodBeat.i(241542);
    if (!dT())
    {
      AppMethodBeat.o(241542);
      return false;
    }
    removeView(this.tP);
    addView(this.tO, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.tP.getSelectedItemPosition());
    AppMethodBeat.o(241542);
    return false;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(241548);
    super.onAttachedToWindow();
    if (this.tN != null) {
      post(this.tN);
    }
    AppMethodBeat.o(241548);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(241546);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = a.I(getContext());
    TypedArray localTypedArray = paramConfiguration.mContext.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
    int j = localTypedArray.getLayoutDimension(a.j.ActionBar_height, 0);
    Resources localResources = paramConfiguration.mContext.getResources();
    int i = j;
    if (!paramConfiguration.bz()) {
      i = Math.min(j, localResources.getDimensionPixelSize(a.d.abc_action_bar_stacked_max_height));
    }
    localTypedArray.recycle();
    setContentHeight(i);
    this.tS = paramConfiguration.mContext.getResources().getDimensionPixelSize(a.d.abc_action_bar_stacked_tab_max_width);
    AppMethodBeat.o(241546);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(241550);
    super.onDetachedFromWindow();
    if (this.tN != null) {
      removeCallbacks(this.tN);
    }
    AppMethodBeat.o(241550);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    AppMethodBeat.i(241539);
    int i = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    if (i == 1073741824)
    {
      bool = true;
      setFillViewport(bool);
      int j = this.tO.getChildCount();
      if ((j <= 1) || ((i != 1073741824) && (i != -2147483648))) {
        break label337;
      }
      if (j <= 2) {
        break label324;
      }
      this.tR = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label73:
      this.tR = Math.min(this.tR, this.tS);
      label88:
      i = View.MeasureSpec.makeMeasureSpec(this.nH, 1073741824);
      if ((bool) || (!this.tQ)) {
        break label345;
      }
      label110:
      if (paramInt2 == 0) {
        break label358;
      }
      this.tO.measure(0, i);
      if (this.tO.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label350;
      }
      if (!dT())
      {
        if (this.tP == null)
        {
          AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, a.a.actionDropDownStyle);
          localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
          localAppCompatSpinner.setOnItemSelectedListener(this);
          this.tP = localAppCompatSpinner;
        }
        removeView(this.tO);
        addView(this.tP, new ViewGroup.LayoutParams(-2, -1));
        if (this.tP.getAdapter() == null) {
          this.tP.setAdapter(new a());
        }
        if (this.tN != null)
        {
          removeCallbacks(this.tN);
          this.tN = null;
        }
        this.tP.setSelection(this.tT);
      }
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, i);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        setTabSelected(this.tT);
      }
      AppMethodBeat.o(241539);
      return;
      bool = false;
      break;
      label324:
      this.tR = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label73;
      label337:
      this.tR = -1;
      break label88;
      label345:
      paramInt2 = 0;
      break label110;
      label350:
      dU();
      continue;
      label358:
      dU();
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void setAllowCollapse(boolean paramBoolean)
  {
    this.tQ = paramBoolean;
  }
  
  public void setContentHeight(int paramInt)
  {
    AppMethodBeat.i(241545);
    this.nH = paramInt;
    requestLayout();
    AppMethodBeat.o(241545);
  }
  
  public void setTabSelected(int paramInt)
  {
    AppMethodBeat.i(241544);
    this.tT = paramInt;
    int j = this.tO.getChildCount();
    int i = 0;
    if (i < j)
    {
      final View localView = this.tO.getChildAt(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool)
        {
          localView = this.tO.getChildAt(paramInt);
          if (this.tN != null) {
            removeCallbacks(this.tN);
          }
          this.tN = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(241522);
              int i = localView.getLeft();
              int j = (w.this.getWidth() - localView.getWidth()) / 2;
              w.this.smoothScrollTo(i - j, 0);
              w.this.tN = null;
              AppMethodBeat.o(241522);
            }
          };
          post(this.tN);
        }
        i += 1;
        break;
      }
    }
    if ((this.tP != null) && (paramInt >= 0)) {
      this.tP.setSelection(paramInt);
    }
    AppMethodBeat.o(241544);
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(241525);
      int i = w.this.tO.getChildCount();
      AppMethodBeat.o(241525);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(241527);
      ActionBar.a locala = ((w.b)w.this.tO.getChildAt(paramInt)).tY;
      AppMethodBeat.o(241527);
      return locala;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(241530);
      if (paramView == null)
      {
        paramViewGroup = w.this;
        paramView = (ActionBar.a)getItem(paramInt);
        paramView = new w.b(paramViewGroup, paramViewGroup.getContext(), paramView);
        paramView.setBackgroundDrawable(null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, paramViewGroup.nH));
      }
      for (;;)
      {
        AppMethodBeat.o(241530);
        return paramView;
        paramViewGroup = (w.b)paramView;
        paramViewGroup.tY = ((ActionBar.a)getItem(paramInt));
        paramViewGroup.update();
      }
    }
  }
  
  final class b
    extends LinearLayout
  {
    private ImageView eL;
    private View nX;
    private TextView rR;
    private final int[] tX;
    ActionBar.a tY;
    
    public b(Context paramContext, ActionBar.a parama)
    {
      super(null, a.a.actionBarTabStyle);
      AppMethodBeat.i(241533);
      this.tX = new int[] { 16842964 };
      this.tY = parama;
      this$1 = ac.a(paramContext, null, this.tX, a.a.actionBarTabStyle, 0);
      if (w.this.aC(0)) {
        setBackgroundDrawable(w.this.getDrawable(0));
      }
      w.this.wA.recycle();
      setGravity(8388627);
      update();
      AppMethodBeat.o(241533);
    }
    
    public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(241535);
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.a.class.getName());
      AppMethodBeat.o(241535);
    }
    
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      AppMethodBeat.i(241536);
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.a.class.getName());
      AppMethodBeat.o(241536);
    }
    
    public final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(241537);
      super.onMeasure(paramInt1, paramInt2);
      if ((w.this.tR > 0) && (getMeasuredWidth() > w.this.tR)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(w.this.tR, 1073741824), paramInt2);
      }
      AppMethodBeat.o(241537);
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      AppMethodBeat.i(241534);
      if (isSelected() != paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean)) {
          sendAccessibilityEvent(4);
        }
        AppMethodBeat.o(241534);
        return;
      }
    }
    
    public final void update()
    {
      AppMethodBeat.i(241538);
      Object localObject1 = this.tY;
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
        this.nX = ((View)localObject2);
        if (this.rR != null) {
          this.rR.setVisibility(8);
        }
        if (this.eL != null)
        {
          this.eL.setVisibility(8);
          this.eL.setImageDrawable(null);
        }
        AppMethodBeat.o(241538);
        return;
      }
      if (this.nX != null)
      {
        removeView(this.nX);
        this.nX = null;
      }
      Object localObject3 = ((ActionBar.a)localObject1).getIcon();
      localObject2 = ((ActionBar.a)localObject1).getText();
      int i;
      if (localObject3 != null)
      {
        Object localObject4;
        if (this.eL == null)
        {
          localObject4 = new AppCompatImageView(getContext());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          this.eL = ((ImageView)localObject4);
        }
        this.eL.setImageDrawable((Drawable)localObject3);
        this.eL.setVisibility(0);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label372;
        }
        i = 1;
        label219:
        if (i == 0) {
          break label377;
        }
        if (this.rR == null)
        {
          localObject3 = new AppCompatTextView(getContext(), null, a.a.actionBarTabTextStyle);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).gravity = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          this.rR = ((TextView)localObject3);
        }
        this.rR.setText((CharSequence)localObject2);
        this.rR.setVisibility(0);
        label310:
        if (this.eL != null) {
          this.eL.setContentDescription(((ActionBar.a)localObject1).getContentDescription());
        }
        if (i == 0) {
          break label404;
        }
      }
      label404:
      for (localObject1 = null;; localObject1 = ((ActionBar.a)localObject1).getContentDescription())
      {
        ae.a(this, (CharSequence)localObject1);
        AppMethodBeat.o(241538);
        return;
        if (this.eL == null) {
          break;
        }
        this.eL.setVisibility(8);
        this.eL.setImageDrawable(null);
        break;
        label372:
        i = 0;
        break label219;
        label377:
        if (this.rR == null) {
          break label310;
        }
        this.rR.setVisibility(8);
        this.rR.setText(null);
        break label310;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.w
 * JD-Core Version:    0.7.0.1
 */