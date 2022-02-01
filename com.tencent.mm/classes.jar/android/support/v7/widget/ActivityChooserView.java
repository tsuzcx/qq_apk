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
  PopupWindow.OnDismissListener afw;
  final a aji;
  private final b ajj;
  final View ajk;
  final Drawable ajl;
  final FrameLayout ajm;
  private final ImageView ajn;
  final FrameLayout ajo;
  final ImageView ajp;
  private final int ajq;
  b ajr;
  final DataSetObserver ajs = new DataSetObserver()
  {
    public final void onChanged()
    {
      super.onChanged();
      ActivityChooserView.this.aji.notifyDataSetChanged();
    }
    
    public final void onInvalidated()
    {
      super.onInvalidated();
      ActivityChooserView.this.aji.notifyDataSetInvalidated();
    }
  };
  private final ViewTreeObserver.OnGlobalLayoutListener ajt = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      if (ActivityChooserView.this.iP())
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
      } while (ActivityChooserView.this.ajr == null);
      ActivityChooserView.this.ajr.K(true);
    }
  };
  private ListPopupWindow aju;
  boolean ajv;
  int ajw = 4;
  int ajx;
  private boolean qm;
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActivityChooserView, paramInt, 0);
    this.ajw = ((TypedArray)localObject).getInt(1, 4);
    paramAttributeSet = ((TypedArray)localObject).getDrawable(0);
    ((TypedArray)localObject).recycle();
    LayoutInflater.from(getContext()).inflate(2131492897, this, true);
    this.ajj = new b();
    this.ajk = findViewById(2131296421);
    this.ajl = this.ajk.getBackground();
    this.ajo = ((FrameLayout)findViewById(2131298949));
    this.ajo.setOnClickListener(this.ajj);
    this.ajo.setOnLongClickListener(this.ajj);
    this.ajp = ((ImageView)this.ajo.findViewById(2131300914));
    localObject = (FrameLayout)findViewById(2131299601);
    ((FrameLayout)localObject).setOnClickListener(this.ajj);
    ((FrameLayout)localObject).setAccessibilityDelegate(new View.AccessibilityDelegate()
    {
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        paramAnonymousView = android.support.v4.view.a.c.a(paramAnonymousAccessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 19) {
          paramAnonymousView.Rb.setCanOpenPopup(true);
        }
      }
    });
    ((FrameLayout)localObject).setOnTouchListener(new ab((View)localObject)
    {
      public final s hF()
      {
        return ActivityChooserView.this.getListPopupWindow();
      }
      
      protected final boolean hG()
      {
        ActivityChooserView.this.iN();
        return true;
      }
      
      protected final boolean iz()
      {
        ActivityChooserView.this.iO();
        return true;
      }
    });
    this.ajm = ((FrameLayout)localObject);
    this.ajn = ((ImageView)((FrameLayout)localObject).findViewById(2131300914));
    this.ajn.setImageDrawable(paramAttributeSet);
    this.aji = new a();
    this.aji.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        super.onChanged();
        ActivityChooserView localActivityChooserView = ActivityChooserView.this;
        if (localActivityChooserView.aji.getCount() > 0)
        {
          localActivityChooserView.ajm.setEnabled(true);
          int i = localActivityChooserView.aji.ajz.iD();
          int j = localActivityChooserView.aji.ajz.getHistorySize();
          if ((i != 1) && ((i <= 1) || (j <= 0))) {
            break label186;
          }
          localActivityChooserView.ajo.setVisibility(0);
          Object localObject = localActivityChooserView.aji.ajz.iE();
          PackageManager localPackageManager = localActivityChooserView.getContext().getPackageManager();
          localActivityChooserView.ajp.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
          if (localActivityChooserView.ajx != 0)
          {
            localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
            localObject = localActivityChooserView.getContext().getString(localActivityChooserView.ajx, new Object[] { localObject });
            localActivityChooserView.ajo.setContentDescription((CharSequence)localObject);
          }
        }
        for (;;)
        {
          if (localActivityChooserView.ajo.getVisibility() != 0) {
            break label198;
          }
          localActivityChooserView.ajk.setBackgroundDrawable(localActivityChooserView.ajl);
          return;
          localActivityChooserView.ajm.setEnabled(false);
          break;
          label186:
          localActivityChooserView.ajo.setVisibility(8);
        }
        label198:
        localActivityChooserView.ajk.setBackgroundDrawable(null);
      }
    });
    paramContext = paramContext.getResources();
    this.ajq = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(2131165655));
  }
  
  final void bz(int paramInt)
  {
    if (this.aji.ajz == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.ajt);
    boolean bool;
    int i;
    label62:
    label93:
    ListPopupWindow localListPopupWindow;
    if (this.ajo.getVisibility() == 0)
    {
      bool = true;
      int j = this.aji.ajz.iD();
      if (!bool) {
        break label212;
      }
      i = 1;
      if ((paramInt == 2147483647) || (j <= i + paramInt)) {
        break label217;
      }
      this.aji.setShowFooterView(true);
      this.aji.bA(paramInt - 1);
      localListPopupWindow = getListPopupWindow();
      if (!localListPopupWindow.arn.isShowing())
      {
        if ((!this.ajv) && (bool)) {
          break label236;
        }
        this.aji.g(true, bool);
      }
    }
    for (;;)
    {
      localListPopupWindow.setContentWidth(Math.min(this.aji.iQ(), this.ajq));
      localListPopupWindow.show();
      if (this.ajr != null) {
        this.ajr.K(true);
      }
      localListPopupWindow.aqQ.setContentDescription(getContext().getString(2131755078));
      localListPopupWindow.aqQ.setSelector(new ColorDrawable(0));
      return;
      bool = false;
      break;
      label212:
      i = 0;
      break label62;
      label217:
      this.aji.setShowFooterView(false);
      this.aji.bA(paramInt);
      break label93;
      label236:
      this.aji.g(false, false);
    }
  }
  
  public c getDataModel()
  {
    return this.aji.ajz;
  }
  
  ListPopupWindow getListPopupWindow()
  {
    if (this.aju == null)
    {
      this.aju = new ListPopupWindow(getContext());
      this.aju.setAdapter(this.aji);
      this.aju.ard = this;
      this.aju.setModal(true);
      this.aju.arf = this.ajj;
      this.aju.setOnDismissListener(this.ajj);
    }
    return this.aju;
  }
  
  public final boolean iN()
  {
    if ((getListPopupWindow().arn.isShowing()) || (!this.qm)) {
      return false;
    }
    this.ajv = false;
    bz(this.ajw);
    return true;
  }
  
  public final boolean iO()
  {
    if (getListPopupWindow().arn.isShowing())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.ajt);
      }
    }
    return true;
  }
  
  public final boolean iP()
  {
    return getListPopupWindow().arn.isShowing();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c localc = this.aji.ajz;
    if (localc != null) {
      localc.registerObserver(this.ajs);
    }
    this.qm = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.aji.ajz;
    if (localObject != null) {
      ((c)localObject).unregisterObserver(this.ajs);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.ajt);
    }
    if (iP()) {
      iO();
    }
    this.qm = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ajk.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!iP()) {
      iO();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.ajk;
    int i = paramInt2;
    if (this.ajo.getVisibility() != 0) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localView, paramInt1, i);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(c paramc)
  {
    a locala = this.aji;
    c localc = locala.ajy.aji.ajz;
    if ((localc != null) && (locala.ajy.isShown())) {
      localc.unregisterObserver(locala.ajy.ajs);
    }
    locala.ajz = paramc;
    if ((paramc != null) && (locala.ajy.isShown())) {
      paramc.registerObserver(locala.ajy.ajs);
    }
    locala.notifyDataSetChanged();
    if (getListPopupWindow().arn.isShowing())
    {
      iO();
      iN();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.ajx = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.ajn.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.ajn.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.ajw = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.afw = paramOnDismissListener;
  }
  
  public void setProvider(b paramb)
  {
    this.ajr = paramb;
  }
  
  final class a
    extends BaseAdapter
  {
    private int ajA = 4;
    boolean ajB;
    private boolean ajC;
    private boolean ajD;
    c ajz;
    
    a() {}
    
    public final void bA(int paramInt)
    {
      if (this.ajA != paramInt)
      {
        this.ajA = paramInt;
        notifyDataSetChanged();
      }
    }
    
    public final void g(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.ajB != paramBoolean1) || (this.ajC != paramBoolean2))
      {
        this.ajB = paramBoolean1;
        this.ajC = paramBoolean2;
        notifyDataSetChanged();
      }
    }
    
    public final int getCount()
    {
      int j = this.ajz.iD();
      int i = j;
      if (!this.ajB)
      {
        i = j;
        if (this.ajz.iE() != null) {
          i = j - 1;
        }
      }
      j = Math.min(i, this.ajA);
      i = j;
      if (this.ajD) {
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
      if (!this.ajB)
      {
        i = paramInt;
        if (this.ajz.iE() != null) {
          i = paramInt + 1;
        }
      }
      return this.ajz.bx(i);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      if ((this.ajD) && (paramInt == getCount() - 1)) {
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
          localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(2131492898, paramViewGroup, false);
          localView.setId(1);
          ((TextView)localView.findViewById(2131305902)).setText(ActivityChooserView.this.getContext().getString(2131755077));
        }
        return localView;
      }
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getId() == 2131301447) {}
      }
      else
      {
        localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(2131492898, paramViewGroup, false);
      }
      paramView = ActivityChooserView.this.getContext().getPackageManager();
      paramViewGroup = (ImageView)localView.findViewById(2131300874);
      ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
      paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
      ((TextView)localView.findViewById(2131305902)).setText(localResolveInfo.loadLabel(paramView));
      if ((this.ajB) && (paramInt == 0) && (this.ajC))
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
    
    public final int iQ()
    {
      int k = this.ajA;
      this.ajA = 2147483647;
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
      this.ajA = k;
      return j;
    }
    
    public final void setShowFooterView(boolean paramBoolean)
    {
      if (this.ajD != paramBoolean)
      {
        this.ajD = paramBoolean;
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
      if (paramView == ActivityChooserView.this.ajo)
      {
        ActivityChooserView.this.iO();
        paramView = ActivityChooserView.this.aji.ajz.iE();
        int i = ActivityChooserView.this.aji.ajz.a(paramView);
        Object localObject = ActivityChooserView.this.aji.ajz.by(i);
        if (localObject != null)
        {
          ((Intent)localObject).addFlags(524288);
          paramView = ActivityChooserView.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "android/support/v7/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "android/support/v7/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        return;
      }
      if (paramView == ActivityChooserView.this.ajm)
      {
        ActivityChooserView.this.ajv = false;
        ActivityChooserView.this.bz(ActivityChooserView.this.ajw);
        return;
      }
      throw new IllegalArgumentException();
    }
    
    public final void onDismiss()
    {
      if (ActivityChooserView.this.afw != null) {
        ActivityChooserView.this.afw.onDismiss();
      }
      if (ActivityChooserView.this.ajr != null) {
        ActivityChooserView.this.ajr.K(false);
      }
    }
    
    public final void onItemClick(AdapterView<?> arg1, View paramView, int paramInt, long paramLong)
    {
      switch (((ActivityChooserView.a)???.getAdapter()).getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        ActivityChooserView.this.bz(2147483647);
      }
      do
      {
        return;
        ActivityChooserView.this.iO();
        if (!ActivityChooserView.this.ajv) {
          break;
        }
      } while (paramInt <= 0);
      paramView = ActivityChooserView.this.aji.ajz;
      for (;;)
      {
        synchronized (paramView.aiV)
        {
          paramView.iG();
          c.a locala1 = (c.a)paramView.aiW.get(paramInt);
          c.a locala2 = (c.a)paramView.aiW.get(0);
          if (locala2 != null)
          {
            f = locala2.weight - locala1.weight + 5.0F;
            paramView.a(new c.c(new ComponentName(locala1.resolveInfo.activityInfo.packageName, locala1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
            return;
          }
        }
        float f = 1.0F;
      }
      if (ActivityChooserView.this.aji.ajB) {}
      for (;;)
      {
        paramView = ActivityChooserView.this.aji.ajz.by(paramInt);
        if (paramView == null) {
          break;
        }
        paramView.addFlags(524288);
        ??? = ActivityChooserView.this.getContext();
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(???, paramView.ahp(), "android/support/v7/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ???.startActivity((Intent)paramView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(???, "android/support/v7/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        return;
        paramInt += 1;
      }
    }
    
    public final boolean onLongClick(View paramView)
    {
      if (paramView == ActivityChooserView.this.ajo)
      {
        if (ActivityChooserView.this.aji.getCount() > 0)
        {
          ActivityChooserView.this.ajv = true;
          ActivityChooserView.this.bz(ActivityChooserView.this.ajw);
        }
        return true;
      }
      throw new IllegalArgumentException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView
 * JD-Core Version:    0.7.0.1
 */