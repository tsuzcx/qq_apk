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
  PopupWindow.OnDismissListener acL;
  final Drawable agA;
  final FrameLayout agB;
  private final ImageView agC;
  final FrameLayout agD;
  final ImageView agE;
  private final int agF;
  b agG;
  final DataSetObserver agH = new DataSetObserver()
  {
    public final void onChanged()
    {
      super.onChanged();
      ActivityChooserView.this.agx.notifyDataSetChanged();
    }
    
    public final void onInvalidated()
    {
      super.onInvalidated();
      ActivityChooserView.this.agx.notifyDataSetInvalidated();
    }
  };
  private final ViewTreeObserver.OnGlobalLayoutListener agI = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      if (ActivityChooserView.this.ir())
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
      } while (ActivityChooserView.this.agG == null);
      ActivityChooserView.this.agG.K(true);
    }
  };
  private ListPopupWindow agJ;
  boolean agK;
  int agL = 4;
  int agM;
  final a agx;
  private final b agy;
  final View agz;
  private boolean nt;
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActivityChooserView, paramInt, 0);
    this.agL = ((TypedArray)localObject).getInt(1, 4);
    paramAttributeSet = ((TypedArray)localObject).getDrawable(0);
    ((TypedArray)localObject).recycle();
    LayoutInflater.from(getContext()).inflate(2131492897, this, true);
    this.agy = new b();
    this.agz = findViewById(2131296421);
    this.agA = this.agz.getBackground();
    this.agD = ((FrameLayout)findViewById(2131298949));
    this.agD.setOnClickListener(this.agy);
    this.agD.setOnLongClickListener(this.agy);
    this.agE = ((ImageView)this.agD.findViewById(2131300914));
    localObject = (FrameLayout)findViewById(2131299601);
    ((FrameLayout)localObject).setOnClickListener(this.agy);
    ((FrameLayout)localObject).setAccessibilityDelegate(new View.AccessibilityDelegate()
    {
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        paramAnonymousView = android.support.v4.view.a.c.a(paramAnonymousAccessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 19) {
          paramAnonymousView.Op.setCanOpenPopup(true);
        }
      }
    });
    ((FrameLayout)localObject).setOnTouchListener(new ab((View)localObject)
    {
      protected final boolean hZ()
      {
        ActivityChooserView.this.iq();
        return true;
      }
      
      public final s hh()
      {
        return ActivityChooserView.this.getListPopupWindow();
      }
      
      protected final boolean hi()
      {
        ActivityChooserView.this.ip();
        return true;
      }
    });
    this.agB = ((FrameLayout)localObject);
    this.agC = ((ImageView)((FrameLayout)localObject).findViewById(2131300914));
    this.agC.setImageDrawable(paramAttributeSet);
    this.agx = new a();
    this.agx.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        super.onChanged();
        ActivityChooserView localActivityChooserView = ActivityChooserView.this;
        if (localActivityChooserView.agx.getCount() > 0)
        {
          localActivityChooserView.agB.setEnabled(true);
          int i = localActivityChooserView.agx.agO.ie();
          int j = localActivityChooserView.agx.agO.getHistorySize();
          if ((i != 1) && ((i <= 1) || (j <= 0))) {
            break label186;
          }
          localActivityChooserView.agD.setVisibility(0);
          Object localObject = localActivityChooserView.agx.agO.jdMethod_if();
          PackageManager localPackageManager = localActivityChooserView.getContext().getPackageManager();
          localActivityChooserView.agE.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
          if (localActivityChooserView.agM != 0)
          {
            localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
            localObject = localActivityChooserView.getContext().getString(localActivityChooserView.agM, new Object[] { localObject });
            localActivityChooserView.agD.setContentDescription((CharSequence)localObject);
          }
        }
        for (;;)
        {
          if (localActivityChooserView.agD.getVisibility() != 0) {
            break label198;
          }
          localActivityChooserView.agz.setBackgroundDrawable(localActivityChooserView.agA);
          return;
          localActivityChooserView.agB.setEnabled(false);
          break;
          label186:
          localActivityChooserView.agD.setVisibility(8);
        }
        label198:
        localActivityChooserView.agz.setBackgroundDrawable(null);
      }
    });
    paramContext = paramContext.getResources();
    this.agF = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(2131165655));
  }
  
  final void bz(int paramInt)
  {
    if (this.agx.agO == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.agI);
    boolean bool;
    int i;
    label62:
    label93:
    ListPopupWindow localListPopupWindow;
    if (this.agD.getVisibility() == 0)
    {
      bool = true;
      int j = this.agx.agO.ie();
      if (!bool) {
        break label212;
      }
      i = 1;
      if ((paramInt == 2147483647) || (j <= i + paramInt)) {
        break label217;
      }
      this.agx.setShowFooterView(true);
      this.agx.bA(paramInt - 1);
      localListPopupWindow = getListPopupWindow();
      if (!localListPopupWindow.aoA.isShowing())
      {
        if ((!this.agK) && (bool)) {
          break label236;
        }
        this.agx.g(true, bool);
      }
    }
    for (;;)
    {
      localListPopupWindow.setContentWidth(Math.min(this.agx.is(), this.agF));
      localListPopupWindow.show();
      if (this.agG != null) {
        this.agG.K(true);
      }
      localListPopupWindow.aod.setContentDescription(getContext().getString(2131755078));
      localListPopupWindow.aod.setSelector(new ColorDrawable(0));
      return;
      bool = false;
      break;
      label212:
      i = 0;
      break label62;
      label217:
      this.agx.setShowFooterView(false);
      this.agx.bA(paramInt);
      break label93;
      label236:
      this.agx.g(false, false);
    }
  }
  
  public c getDataModel()
  {
    return this.agx.agO;
  }
  
  ListPopupWindow getListPopupWindow()
  {
    if (this.agJ == null)
    {
      this.agJ = new ListPopupWindow(getContext());
      this.agJ.setAdapter(this.agx);
      this.agJ.aoq = this;
      this.agJ.setModal(true);
      this.agJ.aos = this.agy;
      this.agJ.setOnDismissListener(this.agy);
    }
    return this.agJ;
  }
  
  public final boolean ip()
  {
    if ((getListPopupWindow().aoA.isShowing()) || (!this.nt)) {
      return false;
    }
    this.agK = false;
    bz(this.agL);
    return true;
  }
  
  public final boolean iq()
  {
    if (getListPopupWindow().aoA.isShowing())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.agI);
      }
    }
    return true;
  }
  
  public final boolean ir()
  {
    return getListPopupWindow().aoA.isShowing();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c localc = this.agx.agO;
    if (localc != null) {
      localc.registerObserver(this.agH);
    }
    this.nt = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.agx.agO;
    if (localObject != null) {
      ((c)localObject).unregisterObserver(this.agH);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.agI);
    }
    if (ir()) {
      iq();
    }
    this.nt = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.agz.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!ir()) {
      iq();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.agz;
    int i = paramInt2;
    if (this.agD.getVisibility() != 0) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localView, paramInt1, i);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(c paramc)
  {
    a locala = this.agx;
    c localc = locala.agN.agx.agO;
    if ((localc != null) && (locala.agN.isShown())) {
      localc.unregisterObserver(locala.agN.agH);
    }
    locala.agO = paramc;
    if ((paramc != null) && (locala.agN.isShown())) {
      paramc.registerObserver(locala.agN.agH);
    }
    locala.notifyDataSetChanged();
    if (getListPopupWindow().aoA.isShowing())
    {
      iq();
      ip();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.agM = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.agC.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.agC.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.agL = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.acL = paramOnDismissListener;
  }
  
  public void setProvider(b paramb)
  {
    this.agG = paramb;
  }
  
  final class a
    extends BaseAdapter
  {
    c agO;
    private int agP = 4;
    boolean agQ;
    private boolean agR;
    private boolean agS;
    
    a() {}
    
    public final void bA(int paramInt)
    {
      if (this.agP != paramInt)
      {
        this.agP = paramInt;
        notifyDataSetChanged();
      }
    }
    
    public final void g(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.agQ != paramBoolean1) || (this.agR != paramBoolean2))
      {
        this.agQ = paramBoolean1;
        this.agR = paramBoolean2;
        notifyDataSetChanged();
      }
    }
    
    public final int getCount()
    {
      int j = this.agO.ie();
      int i = j;
      if (!this.agQ)
      {
        i = j;
        if (this.agO.jdMethod_if() != null) {
          i = j - 1;
        }
      }
      j = Math.min(i, this.agP);
      i = j;
      if (this.agS) {
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
      if (!this.agQ)
      {
        i = paramInt;
        if (this.agO.jdMethod_if() != null) {
          i = paramInt + 1;
        }
      }
      return this.agO.bx(i);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      if ((this.agS) && (paramInt == getCount() - 1)) {
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
      if ((this.agQ) && (paramInt == 0) && (this.agR))
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
    
    public final int is()
    {
      int k = this.agP;
      this.agP = 2147483647;
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
      this.agP = k;
      return j;
    }
    
    public final void setShowFooterView(boolean paramBoolean)
    {
      if (this.agS != paramBoolean)
      {
        this.agS = paramBoolean;
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
      if (paramView == ActivityChooserView.this.agD)
      {
        ActivityChooserView.this.iq();
        paramView = ActivityChooserView.this.agx.agO.jdMethod_if();
        int i = ActivityChooserView.this.agx.agO.a(paramView);
        Object localObject = ActivityChooserView.this.agx.agO.by(i);
        if (localObject != null)
        {
          ((Intent)localObject).addFlags(524288);
          paramView = ActivityChooserView.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "android/support/v7/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "android/support/v7/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        return;
      }
      if (paramView == ActivityChooserView.this.agB)
      {
        ActivityChooserView.this.agK = false;
        ActivityChooserView.this.bz(ActivityChooserView.this.agL);
        return;
      }
      throw new IllegalArgumentException();
    }
    
    public final void onDismiss()
    {
      if (ActivityChooserView.this.acL != null) {
        ActivityChooserView.this.acL.onDismiss();
      }
      if (ActivityChooserView.this.agG != null) {
        ActivityChooserView.this.agG.K(false);
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
        ActivityChooserView.this.iq();
        if (!ActivityChooserView.this.agK) {
          break;
        }
      } while (paramInt <= 0);
      paramView = ActivityChooserView.this.agx.agO;
      for (;;)
      {
        synchronized (paramView.agk)
        {
          paramView.ih();
          c.a locala1 = (c.a)paramView.agl.get(paramInt);
          c.a locala2 = (c.a)paramView.agl.get(0);
          if (locala2 != null)
          {
            f = locala2.weight - locala1.weight + 5.0F;
            paramView.a(new c.c(new ComponentName(locala1.resolveInfo.activityInfo.packageName, locala1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
            return;
          }
        }
        float f = 1.0F;
      }
      if (ActivityChooserView.this.agx.agQ) {}
      for (;;)
      {
        paramView = ActivityChooserView.this.agx.agO.by(paramInt);
        if (paramView == null) {
          break;
        }
        paramView.addFlags(524288);
        ??? = ActivityChooserView.this.getContext();
        paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(???, paramView.adn(), "android/support/v7/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ???.startActivity((Intent)paramView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(???, "android/support/v7/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        return;
        paramInt += 1;
      }
    }
    
    public final boolean onLongClick(View paramView)
    {
      if (paramView == ActivityChooserView.this.agD)
      {
        if (ActivityChooserView.this.agx.getCount() > 0)
        {
          ActivityChooserView.this.agK = true;
          ActivityChooserView.this.bz(ActivityChooserView.this.agL);
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