package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.b;
import android.support.v7.a.a.d;
import android.support.v7.a.a.f;
import android.support.v7.a.a.g;
import android.support.v7.a.a.h;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class ActivityChooserView
  extends ViewGroup
{
  PopupWindow.OnDismissListener UT;
  final ActivityChooserView.a YH;
  private final ActivityChooserView.b YI;
  final View YJ;
  final Drawable YK;
  final FrameLayout YL;
  private final ImageView YM;
  final FrameLayout YN;
  final ImageView YO;
  private final int YP;
  b YQ;
  final DataSetObserver YR = new ActivityChooserView.1(this);
  private final ViewTreeObserver.OnGlobalLayoutListener YS = new ActivityChooserView.2(this);
  private ListPopupWindow YT;
  boolean YU;
  int YV = 4;
  int YW;
  private boolean hD;
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ActivityChooserView, paramInt, 0);
    this.YV = ((TypedArray)localObject).getInt(a.j.ActivityChooserView_initialActivityCount, 4);
    paramAttributeSet = ((TypedArray)localObject).getDrawable(a.j.ActivityChooserView_expandActivityOverflowButtonDrawable);
    ((TypedArray)localObject).recycle();
    LayoutInflater.from(getContext()).inflate(a.g.abc_activity_chooser_view, this, true);
    this.YI = new ActivityChooserView.b(this);
    this.YJ = findViewById(a.f.activity_chooser_view_content);
    this.YK = this.YJ.getBackground();
    this.YN = ((FrameLayout)findViewById(a.f.default_activity_button));
    this.YN.setOnClickListener(this.YI);
    this.YN.setOnLongClickListener(this.YI);
    this.YO = ((ImageView)this.YN.findViewById(a.f.image));
    localObject = (FrameLayout)findViewById(a.f.expand_activities_button);
    ((FrameLayout)localObject).setOnClickListener(this.YI);
    ((FrameLayout)localObject).setAccessibilityDelegate(new ActivityChooserView.3(this));
    ((FrameLayout)localObject).setOnTouchListener(new ActivityChooserView.4(this, (View)localObject));
    this.YL = ((FrameLayout)localObject);
    this.YM = ((ImageView)((FrameLayout)localObject).findViewById(a.f.image));
    this.YM.setImageDrawable(paramAttributeSet);
    this.YH = new ActivityChooserView.a(this);
    this.YH.registerDataSetObserver(new ActivityChooserView.5(this));
    paramContext = paramContext.getResources();
    this.YP = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
  }
  
  final void bj(int paramInt)
  {
    if (this.YH.YY == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.YS);
    boolean bool;
    int i;
    label62:
    label94:
    ListPopupWindow localListPopupWindow;
    if (this.YN.getVisibility() == 0)
    {
      bool = true;
      int j = this.YH.YY.fO();
      if (!bool) {
        break label213;
      }
      i = 1;
      if ((paramInt == 2147483647) || (j <= i + paramInt)) {
        break label218;
      }
      this.YH.setShowFooterView(true);
      this.YH.bk(paramInt - 1);
      localListPopupWindow = getListPopupWindow();
      if (!localListPopupWindow.afe.isShowing())
      {
        if ((!this.YU) && (bool)) {
          break label237;
        }
        this.YH.f(true, bool);
      }
    }
    for (;;)
    {
      localListPopupWindow.setContentWidth(Math.min(this.YH.fY(), this.YP));
      localListPopupWindow.show();
      if (this.YQ != null) {
        this.YQ.E(true);
      }
      localListPopupWindow.aeH.setContentDescription(getContext().getString(a.h.abc_activitychooserview_choose_application));
      localListPopupWindow.aeH.setSelector(new ColorDrawable(0));
      return;
      bool = false;
      break;
      label213:
      i = 0;
      break label62;
      label218:
      this.YH.setShowFooterView(false);
      this.YH.bk(paramInt);
      break label94;
      label237:
      this.YH.f(false, false);
    }
  }
  
  public final boolean fV()
  {
    if ((getListPopupWindow().afe.isShowing()) || (!this.hD)) {
      return false;
    }
    this.YU = false;
    bj(this.YV);
    return true;
  }
  
  public final boolean fW()
  {
    if (getListPopupWindow().afe.isShowing())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.YS);
      }
    }
    return true;
  }
  
  public final boolean fX()
  {
    return getListPopupWindow().afe.isShowing();
  }
  
  public d getDataModel()
  {
    return this.YH.YY;
  }
  
  ListPopupWindow getListPopupWindow()
  {
    if (this.YT == null)
    {
      this.YT = new ListPopupWindow(getContext());
      this.YT.setAdapter(this.YH);
      this.YT.aeU = this;
      this.YT.setModal(true);
      this.YT.aeW = this.YI;
      this.YT.setOnDismissListener(this.YI);
    }
    return this.YT;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    d locald = this.YH.YY;
    if (locald != null) {
      locald.registerObserver(this.YR);
    }
    this.hD = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.YH.YY;
    if (localObject != null) {
      ((d)localObject).unregisterObserver(this.YR);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.YS);
    }
    if (fX()) {
      fW();
    }
    this.hD = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.YJ.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!fX()) {
      fW();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.YJ;
    int i = paramInt2;
    if (this.YN.getVisibility() != 0) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localView, paramInt1, i);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(d paramd)
  {
    ActivityChooserView.a locala = this.YH;
    d locald = locala.YX.YH.YY;
    if ((locald != null) && (locala.YX.isShown())) {
      locald.unregisterObserver(locala.YX.YR);
    }
    locala.YY = paramd;
    if ((paramd != null) && (locala.YX.isShown())) {
      paramd.registerObserver(locala.YX.YR);
    }
    locala.notifyDataSetChanged();
    if (getListPopupWindow().afe.isShowing())
    {
      fW();
      fV();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.YW = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.YM.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.YM.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.YV = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.UT = paramOnDismissListener;
  }
  
  public void setProvider(b paramb)
  {
    this.YQ = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView
 * JD-Core Version:    0.7.0.1
 */