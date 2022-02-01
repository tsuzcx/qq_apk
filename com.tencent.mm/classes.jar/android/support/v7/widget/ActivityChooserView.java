package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.b;
import android.support.v7.a.a.a;
import android.support.v7.view.menu.s;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.List;

public class ActivityChooserView
  extends ViewGroup
{
  PopupWindow.OnDismissListener afJ;
  private final ImageView ajA;
  final FrameLayout ajB;
  final ImageView ajC;
  private final int ajD;
  b ajE;
  final DataSetObserver ajF = new DataSetObserver()
  {
    public final void onChanged()
    {
      super.onChanged();
      ActivityChooserView.this.ajv.notifyDataSetChanged();
    }
    
    public final void onInvalidated()
    {
      super.onInvalidated();
      ActivityChooserView.this.ajv.notifyDataSetInvalidated();
    }
  };
  private final ViewTreeObserver.OnGlobalLayoutListener ajG = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      if (ActivityChooserView.this.iY())
      {
        if (ActivityChooserView.this.isShown()) {
          break label31;
        }
        ActivityChooserView.this.getListPopupWindow().dismiss();
      }
      label31:
      do
      {
        return;
        ActivityChooserView.this.getListPopupWindow().show();
      } while (ActivityChooserView.this.ajE == null);
      ActivityChooserView.this.ajE.J(true);
    }
  };
  private ListPopupWindow ajH;
  boolean ajI;
  int ajJ = 4;
  int ajK;
  final a ajv;
  private final b ajw;
  final View ajx;
  final Drawable ajy;
  final FrameLayout ajz;
  private boolean mIsAttachedToWindow;
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActivityChooserView, paramInt, 0);
    this.ajJ = ((TypedArray)localObject).getInt(1, 4);
    paramAttributeSet = ((TypedArray)localObject).getDrawable(0);
    ((TypedArray)localObject).recycle();
    LayoutInflater.from(getContext()).inflate(2131492914, this, true);
    this.ajw = new b();
    this.ajx = findViewById(2131296453);
    this.ajy = this.ajx.getBackground();
    this.ajB = ((FrameLayout)findViewById(2131299440));
    this.ajB.setOnClickListener(this.ajw);
    this.ajB.setOnLongClickListener(this.ajw);
    this.ajC = ((ImageView)this.ajB.findViewById(2131302526));
    localObject = (FrameLayout)findViewById(2131300229);
    ((FrameLayout)localObject).setOnClickListener(this.ajw);
    ((FrameLayout)localObject).setAccessibilityDelegate(new View.AccessibilityDelegate()
    {
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        paramAnonymousView = android.support.v4.view.a.c.a(paramAnonymousAccessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 19) {
          paramAnonymousView.Ro.setCanOpenPopup(true);
        }
      }
    });
    ((FrameLayout)localObject).setOnTouchListener(new ab((View)localObject)
    {
      public final s hO()
      {
        return ActivityChooserView.this.getListPopupWindow();
      }
      
      protected final boolean hP()
      {
        ActivityChooserView.this.iW();
        return true;
      }
      
      protected final boolean iI()
      {
        ActivityChooserView.this.iX();
        return true;
      }
    });
    this.ajz = ((FrameLayout)localObject);
    this.ajA = ((ImageView)((FrameLayout)localObject).findViewById(2131302526));
    this.ajA.setImageDrawable(paramAttributeSet);
    this.ajv = new a();
    this.ajv.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        super.onChanged();
        ActivityChooserView localActivityChooserView = ActivityChooserView.this;
        if (localActivityChooserView.ajv.getCount() > 0)
        {
          localActivityChooserView.ajz.setEnabled(true);
          int i = localActivityChooserView.ajv.ajM.iM();
          int j = localActivityChooserView.ajv.ajM.getHistorySize();
          if ((i != 1) && ((i <= 1) || (j <= 0))) {
            break label186;
          }
          localActivityChooserView.ajB.setVisibility(0);
          Object localObject = localActivityChooserView.ajv.ajM.iN();
          PackageManager localPackageManager = localActivityChooserView.getContext().getPackageManager();
          localActivityChooserView.ajC.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
          if (localActivityChooserView.ajK != 0)
          {
            localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
            localObject = localActivityChooserView.getContext().getString(localActivityChooserView.ajK, new Object[] { localObject });
            localActivityChooserView.ajB.setContentDescription((CharSequence)localObject);
          }
        }
        for (;;)
        {
          if (localActivityChooserView.ajB.getVisibility() != 0) {
            break label198;
          }
          localActivityChooserView.ajx.setBackgroundDrawable(localActivityChooserView.ajy);
          return;
          localActivityChooserView.ajz.setEnabled(false);
          break;
          label186:
          localActivityChooserView.ajB.setVisibility(8);
        }
        label198:
        localActivityChooserView.ajx.setBackgroundDrawable(null);
      }
    });
    paramContext = paramContext.getResources();
    this.ajD = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(2131165673));
  }
  
  final void bA(int paramInt)
  {
    if (this.ajv.ajM == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.ajG);
    boolean bool;
    int i;
    label62:
    label93:
    ListPopupWindow localListPopupWindow;
    if (this.ajB.getVisibility() == 0)
    {
      bool = true;
      int j = this.ajv.ajM.iM();
      if (!bool) {
        break label212;
      }
      i = 1;
      if ((paramInt == 2147483647) || (j <= i + paramInt)) {
        break label217;
      }
      this.ajv.setShowFooterView(true);
      this.ajv.bB(paramInt - 1);
      localListPopupWindow = getListPopupWindow();
      if (!localListPopupWindow.arA.isShowing())
      {
        if ((!this.ajI) && (bool)) {
          break label236;
        }
        this.ajv.g(true, bool);
      }
    }
    for (;;)
    {
      localListPopupWindow.setContentWidth(Math.min(this.ajv.iZ(), this.ajD));
      localListPopupWindow.show();
      if (this.ajE != null) {
        this.ajE.J(true);
      }
      localListPopupWindow.arc.setContentDescription(getContext().getString(2131755091));
      localListPopupWindow.arc.setSelector(new ColorDrawable(0));
      return;
      bool = false;
      break;
      label212:
      i = 0;
      break label62;
      label217:
      this.ajv.setShowFooterView(false);
      this.ajv.bB(paramInt);
      break label93;
      label236:
      this.ajv.g(false, false);
    }
  }
  
  public c getDataModel()
  {
    return this.ajv.ajM;
  }
  
  ListPopupWindow getListPopupWindow()
  {
    if (this.ajH == null)
    {
      this.ajH = new ListPopupWindow(getContext());
      this.ajH.setAdapter(this.ajv);
      this.ajH.arp = this;
      this.ajH.setModal(true);
      this.ajH.ars = this.ajw;
      this.ajH.setOnDismissListener(this.ajw);
    }
    return this.ajH;
  }
  
  public final boolean iW()
  {
    if ((getListPopupWindow().arA.isShowing()) || (!this.mIsAttachedToWindow)) {
      return false;
    }
    this.ajI = false;
    bA(this.ajJ);
    return true;
  }
  
  public final boolean iX()
  {
    if (getListPopupWindow().arA.isShowing())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.ajG);
      }
    }
    return true;
  }
  
  public final boolean iY()
  {
    return getListPopupWindow().arA.isShowing();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c localc = this.ajv.ajM;
    if (localc != null) {
      localc.registerObserver(this.ajF);
    }
    this.mIsAttachedToWindow = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.ajv.ajM;
    if (localObject != null) {
      ((c)localObject).unregisterObserver(this.ajF);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.ajG);
    }
    if (iY()) {
      iX();
    }
    this.mIsAttachedToWindow = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ajx.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!iY()) {
      iX();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.ajx;
    int i = paramInt2;
    if (this.ajB.getVisibility() != 0) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localView, paramInt1, i);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(c paramc)
  {
    a locala = this.ajv;
    c localc = locala.ajL.ajv.ajM;
    if ((localc != null) && (locala.ajL.isShown())) {
      localc.unregisterObserver(locala.ajL.ajF);
    }
    locala.ajM = paramc;
    if ((paramc != null) && (locala.ajL.isShown())) {
      paramc.registerObserver(locala.ajL.ajF);
    }
    locala.notifyDataSetChanged();
    if (getListPopupWindow().arA.isShowing())
    {
      iX();
      iW();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.ajK = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.ajA.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.ajA.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.ajJ = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.afJ = paramOnDismissListener;
  }
  
  public void setProvider(b paramb)
  {
    this.ajE = paramb;
  }
  
  final class a
    extends BaseAdapter
  {
    c ajM;
    private int ajN = 4;
    boolean ajO;
    private boolean ajP;
    private boolean ajQ;
    
    a() {}
    
    public final void bB(int paramInt)
    {
      if (this.ajN != paramInt)
      {
        this.ajN = paramInt;
        notifyDataSetChanged();
      }
    }
    
    public final void g(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.ajO != paramBoolean1) || (this.ajP != paramBoolean2))
      {
        this.ajO = paramBoolean1;
        this.ajP = paramBoolean2;
        notifyDataSetChanged();
      }
    }
    
    public final int getCount()
    {
      int j = this.ajM.iM();
      int i = j;
      if (!this.ajO)
      {
        i = j;
        if (this.ajM.iN() != null) {
          i = j - 1;
        }
      }
      j = Math.min(i, this.ajN);
      i = j;
      if (this.ajQ) {
        i = j + 1;
      }
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        return null;
      }
      int i = paramInt;
      if (!this.ajO)
      {
        i = paramInt;
        if (this.ajM.iN() != null) {
          i = paramInt + 1;
        }
      }
      return this.ajM.by(i);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      if ((this.ajQ) && (paramInt == getCount() - 1)) {
        return 1;
      }
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        if (paramView != null)
        {
          localView = paramView;
          if (paramView.getId() == 1) {}
        }
        else
        {
          localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(2131492915, paramViewGroup, false);
          localView.setId(1);
          ((TextView)localView.findViewById(2131309195)).setText(ActivityChooserView.this.getContext().getString(2131755090));
        }
        return localView;
      }
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getId() == 2131303232) {}
      }
      else
      {
        localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(2131492915, paramViewGroup, false);
      }
      paramView = ActivityChooserView.this.getContext().getPackageManager();
      paramViewGroup = (ImageView)localView.findViewById(2131302468);
      ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
      paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
      ((TextView)localView.findViewById(2131309195)).setText(localResolveInfo.loadLabel(paramView));
      if ((this.ajO) && (paramInt == 0) && (this.ajP))
      {
        localView.setActivated(true);
        return localView;
      }
      localView.setActivated(false);
      return localView;
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
    
    public final int iZ()
    {
      int k = this.ajN;
      this.ajN = 2147483647;
      int m = View.MeasureSpec.makeMeasureSpec(0, 0);
      int n = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i1 = getCount();
      int i = 0;
      View localView = null;
      int j = 0;
      while (i < i1)
      {
        localView = getView(i, localView, null);
        localView.measure(m, n);
        j = Math.max(j, localView.getMeasuredWidth());
        i += 1;
      }
      this.ajN = k;
      return j;
    }
    
    public final void setShowFooterView(boolean paramBoolean)
    {
      if (this.ajQ != paramBoolean)
      {
        this.ajQ = paramBoolean;
        notifyDataSetChanged();
      }
    }
  }
  
  final class b
    implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
  {
    b() {}
    
    public final void onClick(View paramView)
    {
      if (paramView == ActivityChooserView.this.ajB)
      {
        ActivityChooserView.this.iX();
        paramView = ActivityChooserView.this.ajv.ajM.iN();
        int i = ActivityChooserView.this.ajv.ajM.a(paramView);
        Object localObject = ActivityChooserView.this.ajv.ajM.bz(i);
        if (localObject != null)
        {
          ((Intent)localObject).addFlags(524288);
          paramView = ActivityChooserView.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "android/support/v7/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "android/support/v7/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        return;
      }
      if (paramView == ActivityChooserView.this.ajz)
      {
        ActivityChooserView.this.ajI = false;
        ActivityChooserView.this.bA(ActivityChooserView.this.ajJ);
        return;
      }
      throw new IllegalArgumentException();
    }
    
    public final void onDismiss()
    {
      if (ActivityChooserView.this.afJ != null) {
        ActivityChooserView.this.afJ.onDismiss();
      }
      if (ActivityChooserView.this.ajE != null) {
        ActivityChooserView.this.ajE.J(false);
      }
    }
    
    public final void onItemClick(AdapterView<?> arg1, View paramView, int paramInt, long paramLong)
    {
      switch (((ActivityChooserView.a)???.getAdapter()).getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        ActivityChooserView.this.bA(2147483647);
      }
      do
      {
        return;
        ActivityChooserView.this.iX();
        if (!ActivityChooserView.this.ajI) {
          break;
        }
      } while (paramInt <= 0);
      paramView = ActivityChooserView.this.ajv.ajM;
      for (;;)
      {
        synchronized (paramView.aji)
        {
          paramView.iP();
          c.a locala1 = (c.a)paramView.ajj.get(paramInt);
          c.a locala2 = (c.a)paramView.ajj.get(0);
          if (locala2 != null)
          {
            f = locala2.weight - locala1.weight + 5.0F;
            paramView.a(new c.c(new ComponentName(locala1.resolveInfo.activityInfo.packageName, locala1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
            return;
          }
        }
        float f = 1.0F;
      }
      if (ActivityChooserView.this.ajv.ajO) {}
      for (;;)
      {
        paramView = ActivityChooserView.this.ajv.ajM.bz(paramInt);
        if (paramView == null) {
          break;
        }
        paramView.addFlags(524288);
        ??? = ActivityChooserView.this.getContext();
        paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(???, paramView.axQ(), "android/support/v7/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ???.startActivity((Intent)paramView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(???, "android/support/v7/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        return;
        paramInt += 1;
      }
    }
    
    public final boolean onLongClick(View paramView)
    {
      if (paramView == ActivityChooserView.this.ajB)
      {
        if (ActivityChooserView.this.ajv.getCount() > 0)
        {
          ActivityChooserView.this.ajI = true;
          ActivityChooserView.this.bA(ActivityChooserView.this.ajJ);
        }
        return true;
      }
      throw new IllegalArgumentException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView
 * JD-Core Version:    0.7.0.1
 */