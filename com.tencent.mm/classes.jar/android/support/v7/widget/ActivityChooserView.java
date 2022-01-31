package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.b;
import android.support.v7.a.a.a;
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
  PopupWindow.OnDismissListener VG;
  private final int ZA;
  b ZB;
  final DataSetObserver ZC = new ActivityChooserView.1(this);
  private final ViewTreeObserver.OnGlobalLayoutListener ZD = new ActivityChooserView.2(this);
  private ListPopupWindow ZE;
  boolean ZF;
  int ZG = 4;
  int ZH;
  final ActivityChooserView.a Zs;
  private final ActivityChooserView.b Zt;
  final View Zu;
  final Drawable Zv;
  final FrameLayout Zw;
  private final ImageView Zx;
  final FrameLayout Zy;
  final ImageView Zz;
  private boolean iA;
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActivityChooserView, paramInt, 0);
    this.ZG = ((TypedArray)localObject).getInt(0, 4);
    paramAttributeSet = ((TypedArray)localObject).getDrawable(1);
    ((TypedArray)localObject).recycle();
    LayoutInflater.from(getContext()).inflate(2130968590, this, true);
    this.Zt = new ActivityChooserView.b(this);
    this.Zu = findViewById(2131820925);
    this.Zv = this.Zu.getBackground();
    this.Zy = ((FrameLayout)findViewById(2131820927));
    this.Zy.setOnClickListener(this.Zt);
    this.Zy.setOnLongClickListener(this.Zt);
    this.Zz = ((ImageView)this.Zy.findViewById(2131820629));
    localObject = (FrameLayout)findViewById(2131820926);
    ((FrameLayout)localObject).setOnClickListener(this.Zt);
    ((FrameLayout)localObject).setAccessibilityDelegate(new ActivityChooserView.3(this));
    ((FrameLayout)localObject).setOnTouchListener(new ActivityChooserView.4(this, (View)localObject));
    this.Zw = ((FrameLayout)localObject);
    this.Zx = ((ImageView)((FrameLayout)localObject).findViewById(2131820629));
    this.Zx.setImageDrawable(paramAttributeSet);
    this.Zs = new ActivityChooserView.a(this);
    this.Zs.registerDataSetObserver(new ActivityChooserView.5(this));
    paramContext = paramContext.getResources();
    this.ZA = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(2131427360));
  }
  
  final void bh(int paramInt)
  {
    if (this.Zs.ZJ == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.ZD);
    boolean bool;
    int i;
    label62:
    label93:
    ListPopupWindow localListPopupWindow;
    if (this.Zy.getVisibility() == 0)
    {
      bool = true;
      int j = this.Zs.ZJ.gI();
      if (!bool) {
        break label212;
      }
      i = 1;
      if ((paramInt == 2147483647) || (j <= i + paramInt)) {
        break label217;
      }
      this.Zs.setShowFooterView(true);
      this.Zs.bi(paramInt - 1);
      localListPopupWindow = getListPopupWindow();
      if (!localListPopupWindow.aht.isShowing())
      {
        if ((!this.ZF) && (bool)) {
          break label236;
        }
        this.Zs.g(true, bool);
      }
    }
    for (;;)
    {
      localListPopupWindow.setContentWidth(Math.min(this.Zs.gV(), this.ZA));
      localListPopupWindow.show();
      if (this.ZB != null) {
        this.ZB.E(true);
      }
      localListPopupWindow.agW.setContentDescription(getContext().getString(2131296261));
      localListPopupWindow.agW.setSelector(new ColorDrawable(0));
      return;
      bool = false;
      break;
      label212:
      i = 0;
      break label62;
      label217:
      this.Zs.setShowFooterView(false);
      this.Zs.bi(paramInt);
      break label93;
      label236:
      this.Zs.g(false, false);
    }
  }
  
  public final boolean gS()
  {
    if ((getListPopupWindow().aht.isShowing()) || (!this.iA)) {
      return false;
    }
    this.ZF = false;
    bh(this.ZG);
    return true;
  }
  
  public final boolean gT()
  {
    if (getListPopupWindow().aht.isShowing())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.ZD);
      }
    }
    return true;
  }
  
  public final boolean gU()
  {
    return getListPopupWindow().aht.isShowing();
  }
  
  public c getDataModel()
  {
    return this.Zs.ZJ;
  }
  
  ListPopupWindow getListPopupWindow()
  {
    if (this.ZE == null)
    {
      this.ZE = new ListPopupWindow(getContext());
      this.ZE.setAdapter(this.Zs);
      this.ZE.ahj = this;
      this.ZE.setModal(true);
      this.ZE.ahl = this.Zt;
      this.ZE.setOnDismissListener(this.Zt);
    }
    return this.ZE;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c localc = this.Zs.ZJ;
    if (localc != null) {
      localc.registerObserver(this.ZC);
    }
    this.iA = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.Zs.ZJ;
    if (localObject != null) {
      ((c)localObject).unregisterObserver(this.ZC);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.ZD);
    }
    if (gU()) {
      gT();
    }
    this.iA = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.Zu.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!gU()) {
      gT();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.Zu;
    int i = paramInt2;
    if (this.Zy.getVisibility() != 0) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localView, paramInt1, i);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(c paramc)
  {
    ActivityChooserView.a locala = this.Zs;
    c localc = locala.ZI.Zs.ZJ;
    if ((localc != null) && (locala.ZI.isShown())) {
      localc.unregisterObserver(locala.ZI.ZC);
    }
    locala.ZJ = paramc;
    if ((paramc != null) && (locala.ZI.isShown())) {
      paramc.registerObserver(locala.ZI.ZC);
    }
    locala.notifyDataSetChanged();
    if (getListPopupWindow().aht.isShowing())
    {
      gT();
      gS();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.ZH = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.Zx.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.Zx.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.ZG = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.VG = paramOnDismissListener;
  }
  
  public void setProvider(b paramb)
  {
    this.ZB = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView
 * JD-Core Version:    0.7.0.1
 */