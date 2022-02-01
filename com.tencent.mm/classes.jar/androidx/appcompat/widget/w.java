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
  private static final Interpolator uT;
  int oG;
  Runnable uM;
  LinearLayoutCompat uN;
  private Spinner uO;
  private boolean uP;
  int uQ;
  int uR;
  private int uS;
  
  static
  {
    AppMethodBeat.i(199858);
    uT = new DecelerateInterpolator();
    AppMethodBeat.o(199858);
  }
  
  private boolean eT()
  {
    AppMethodBeat.i(199835);
    if ((this.uO != null) && (this.uO.getParent() == this))
    {
      AppMethodBeat.o(199835);
      return true;
    }
    AppMethodBeat.o(199835);
    return false;
  }
  
  private boolean eU()
  {
    AppMethodBeat.i(199847);
    if (!eT())
    {
      AppMethodBeat.o(199847);
      return false;
    }
    removeView(this.uO);
    addView(this.uN, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.uO.getSelectedItemPosition());
    AppMethodBeat.o(199847);
    return false;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(199919);
    super.onAttachedToWindow();
    if (this.uM != null) {
      post(this.uM);
    }
    AppMethodBeat.o(199919);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(199909);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = a.I(getContext());
    TypedArray localTypedArray = paramConfiguration.mContext.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
    int j = localTypedArray.getLayoutDimension(a.j.ActionBar_height, 0);
    Resources localResources = paramConfiguration.mContext.getResources();
    int i = j;
    if (!paramConfiguration.cs()) {
      i = Math.min(j, localResources.getDimensionPixelSize(a.d.abc_action_bar_stacked_max_height));
    }
    localTypedArray.recycle();
    setContentHeight(i);
    this.uR = paramConfiguration.mContext.getResources().getDimensionPixelSize(a.d.abc_action_bar_stacked_tab_max_width);
    AppMethodBeat.o(199909);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(199923);
    super.onDetachedFromWindow();
    if (this.uM != null) {
      removeCallbacks(this.uM);
    }
    AppMethodBeat.o(199923);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    AppMethodBeat.i(199877);
    int i = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    if (i == 1073741824)
    {
      bool = true;
      setFillViewport(bool);
      int j = this.uN.getChildCount();
      if ((j <= 1) || ((i != 1073741824) && (i != -2147483648))) {
        break label337;
      }
      if (j <= 2) {
        break label324;
      }
      this.uQ = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label73:
      this.uQ = Math.min(this.uQ, this.uR);
      label88:
      i = View.MeasureSpec.makeMeasureSpec(this.oG, 1073741824);
      if ((bool) || (!this.uP)) {
        break label345;
      }
      label110:
      if (paramInt2 == 0) {
        break label358;
      }
      this.uN.measure(0, i);
      if (this.uN.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label350;
      }
      if (!eT())
      {
        if (this.uO == null)
        {
          AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, a.a.actionDropDownStyle);
          localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
          localAppCompatSpinner.setOnItemSelectedListener(this);
          this.uO = localAppCompatSpinner;
        }
        removeView(this.uN);
        addView(this.uO, new ViewGroup.LayoutParams(-2, -1));
        if (this.uO.getAdapter() == null) {
          this.uO.setAdapter(new a());
        }
        if (this.uM != null)
        {
          removeCallbacks(this.uM);
          this.uM = null;
        }
        this.uO.setSelection(this.uS);
      }
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, i);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        setTabSelected(this.uS);
      }
      AppMethodBeat.o(199877);
      return;
      bool = false;
      break;
      label324:
      this.uQ = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label73;
      label337:
      this.uQ = -1;
      break label88;
      label345:
      paramInt2 = 0;
      break label110;
      label350:
      eU();
      continue;
      label358:
      eU();
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void setAllowCollapse(boolean paramBoolean)
  {
    this.uP = paramBoolean;
  }
  
  public void setContentHeight(int paramInt)
  {
    AppMethodBeat.i(199900);
    this.oG = paramInt;
    requestLayout();
    AppMethodBeat.o(199900);
  }
  
  public void setTabSelected(int paramInt)
  {
    AppMethodBeat.i(199893);
    this.uS = paramInt;
    int j = this.uN.getChildCount();
    int i = 0;
    if (i < j)
    {
      final View localView = this.uN.getChildAt(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool)
        {
          localView = this.uN.getChildAt(paramInt);
          if (this.uM != null) {
            removeCallbacks(this.uM);
          }
          this.uM = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200241);
              int i = localView.getLeft();
              int j = (w.this.getWidth() - localView.getWidth()) / 2;
              w.this.smoothScrollTo(i - j, 0);
              w.this.uM = null;
              AppMethodBeat.o(200241);
            }
          };
          post(this.uM);
        }
        i += 1;
        break;
      }
    }
    if ((this.uO != null) && (paramInt >= 0)) {
      this.uO.setSelection(paramInt);
    }
    AppMethodBeat.o(199893);
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(200088);
      int i = w.this.uN.getChildCount();
      AppMethodBeat.o(200088);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(200097);
      ActionBar.a locala = ((w.b)w.this.uN.getChildAt(paramInt)).uX;
      AppMethodBeat.o(200097);
      return locala;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(200112);
      if (paramView == null)
      {
        paramViewGroup = w.this;
        paramView = (ActionBar.a)getItem(paramInt);
        paramView = new w.b(paramViewGroup, paramViewGroup.getContext(), paramView);
        paramView.setBackgroundDrawable(null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, paramViewGroup.oG));
      }
      for (;;)
      {
        AppMethodBeat.o(200112);
        return paramView;
        paramViewGroup = (w.b)paramView;
        paramViewGroup.uX = ((ActionBar.a)getItem(paramInt));
        paramViewGroup.update();
      }
    }
  }
  
  final class b
    extends LinearLayout
  {
    private ImageView fN;
    private View oW;
    private TextView sQ;
    private final int[] uW;
    ActionBar.a uX;
    
    public b(Context paramContext, ActionBar.a parama)
    {
      super(null, a.a.actionBarTabStyle);
      AppMethodBeat.i(200095);
      this.uW = new int[] { 16842964 };
      this.uX = parama;
      this$1 = ac.a(paramContext, null, this.uW, a.a.actionBarTabStyle, 0);
      if (w.this.az(0)) {
        setBackgroundDrawable(w.this.getDrawable(0));
      }
      w.this.xv.recycle();
      setGravity(8388627);
      update();
      AppMethodBeat.o(200095);
    }
    
    public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(200126);
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.a.class.getName());
      AppMethodBeat.o(200126);
    }
    
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      AppMethodBeat.i(200138);
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.a.class.getName());
      AppMethodBeat.o(200138);
    }
    
    public final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(200153);
      super.onMeasure(paramInt1, paramInt2);
      if ((w.this.uQ > 0) && (getMeasuredWidth() > w.this.uQ)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(w.this.uQ, 1073741824), paramInt2);
      }
      AppMethodBeat.o(200153);
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      AppMethodBeat.i(200109);
      if (isSelected() != paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean)) {
          sendAccessibilityEvent(4);
        }
        AppMethodBeat.o(200109);
        return;
      }
    }
    
    public final void update()
    {
      AppMethodBeat.i(200179);
      Object localObject1 = this.uX;
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
        this.oW = ((View)localObject2);
        if (this.sQ != null) {
          this.sQ.setVisibility(8);
        }
        if (this.fN != null)
        {
          this.fN.setVisibility(8);
          this.fN.setImageDrawable(null);
        }
        AppMethodBeat.o(200179);
        return;
      }
      if (this.oW != null)
      {
        removeView(this.oW);
        this.oW = null;
      }
      Object localObject3 = ((ActionBar.a)localObject1).getIcon();
      localObject2 = ((ActionBar.a)localObject1).getText();
      int i;
      if (localObject3 != null)
      {
        Object localObject4;
        if (this.fN == null)
        {
          localObject4 = new AppCompatImageView(getContext());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          this.fN = ((ImageView)localObject4);
        }
        this.fN.setImageDrawable((Drawable)localObject3);
        this.fN.setVisibility(0);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label372;
        }
        i = 1;
        label219:
        if (i == 0) {
          break label377;
        }
        if (this.sQ == null)
        {
          localObject3 = new AppCompatTextView(getContext(), null, a.a.actionBarTabTextStyle);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).gravity = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          this.sQ = ((TextView)localObject3);
        }
        this.sQ.setText((CharSequence)localObject2);
        this.sQ.setVisibility(0);
        label310:
        if (this.fN != null) {
          this.fN.setContentDescription(((ActionBar.a)localObject1).getContentDescription());
        }
        if (i == 0) {
          break label404;
        }
      }
      label404:
      for (localObject1 = null;; localObject1 = ((ActionBar.a)localObject1).getContentDescription())
      {
        ae.a(this, (CharSequence)localObject1);
        AppMethodBeat.o(200179);
        return;
        if (this.fN == null) {
          break;
        }
        this.fN.setVisibility(8);
        this.fN.setImageDrawable(null);
        break;
        label372:
        i = 0;
        break label219;
        label377:
        if (this.sQ == null) {
          break label310;
        }
        this.sQ.setVisibility(8);
        this.sQ.setText(null);
        break label310;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.w
 * JD-Core Version:    0.7.0.1
 */