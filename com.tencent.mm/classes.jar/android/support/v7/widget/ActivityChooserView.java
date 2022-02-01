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
  PopupWindow.OnDismissListener adF;
  b ahA;
  final DataSetObserver ahB = new DataSetObserver()
  {
    public final void onChanged()
    {
      super.onChanged();
      ActivityChooserView.this.ahr.notifyDataSetChanged();
    }
    
    public final void onInvalidated()
    {
      super.onInvalidated();
      ActivityChooserView.this.ahr.notifyDataSetInvalidated();
    }
  };
  private final ViewTreeObserver.OnGlobalLayoutListener ahC = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      if (ActivityChooserView.this.iz())
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
      } while (ActivityChooserView.this.ahA == null);
      ActivityChooserView.this.ahA.K(true);
    }
  };
  private ListPopupWindow ahD;
  boolean ahE;
  int ahF = 4;
  int ahG;
  final a ahr;
  private final b ahs;
  final View aht;
  final Drawable ahu;
  final FrameLayout ahv;
  private final ImageView ahw;
  final FrameLayout ahx;
  final ImageView ahy;
  private final int ahz;
  private boolean ou;
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActivityChooserView, paramInt, 0);
    this.ahF = ((TypedArray)localObject).getInt(1, 4);
    paramAttributeSet = ((TypedArray)localObject).getDrawable(0);
    ((TypedArray)localObject).recycle();
    LayoutInflater.from(getContext()).inflate(2131492897, this, true);
    this.ahs = new b();
    this.aht = findViewById(2131296421);
    this.ahu = this.aht.getBackground();
    this.ahx = ((FrameLayout)findViewById(2131298949));
    this.ahx.setOnClickListener(this.ahs);
    this.ahx.setOnLongClickListener(this.ahs);
    this.ahy = ((ImageView)this.ahx.findViewById(2131300914));
    localObject = (FrameLayout)findViewById(2131299601);
    ((FrameLayout)localObject).setOnClickListener(this.ahs);
    ((FrameLayout)localObject).setAccessibilityDelegate(new View.AccessibilityDelegate()
    {
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        paramAnonymousView = android.support.v4.view.a.c.a(paramAnonymousAccessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 19) {
          paramAnonymousView.Pm.setCanOpenPopup(true);
        }
      }
    });
    ((FrameLayout)localObject).setOnTouchListener(new ab((View)localObject)
    {
      public final s hp()
      {
        return ActivityChooserView.this.getListPopupWindow();
      }
      
      protected final boolean hq()
      {
        ActivityChooserView.this.ix();
        return true;
      }
      
      protected final boolean ii()
      {
        ActivityChooserView.this.iy();
        return true;
      }
    });
    this.ahv = ((FrameLayout)localObject);
    this.ahw = ((ImageView)((FrameLayout)localObject).findViewById(2131300914));
    this.ahw.setImageDrawable(paramAttributeSet);
    this.ahr = new a();
    this.ahr.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        super.onChanged();
        ActivityChooserView localActivityChooserView = ActivityChooserView.this;
        if (localActivityChooserView.ahr.getCount() > 0)
        {
          localActivityChooserView.ahv.setEnabled(true);
          int i = localActivityChooserView.ahr.ahI.im();
          int j = localActivityChooserView.ahr.ahI.getHistorySize();
          if ((i != 1) && ((i <= 1) || (j <= 0))) {
            break label186;
          }
          localActivityChooserView.ahx.setVisibility(0);
          Object localObject = localActivityChooserView.ahr.ahI.in();
          PackageManager localPackageManager = localActivityChooserView.getContext().getPackageManager();
          localActivityChooserView.ahy.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
          if (localActivityChooserView.ahG != 0)
          {
            localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
            localObject = localActivityChooserView.getContext().getString(localActivityChooserView.ahG, new Object[] { localObject });
            localActivityChooserView.ahx.setContentDescription((CharSequence)localObject);
          }
        }
        for (;;)
        {
          if (localActivityChooserView.ahx.getVisibility() != 0) {
            break label198;
          }
          localActivityChooserView.aht.setBackgroundDrawable(localActivityChooserView.ahu);
          return;
          localActivityChooserView.ahv.setEnabled(false);
          break;
          label186:
          localActivityChooserView.ahx.setVisibility(8);
        }
        label198:
        localActivityChooserView.aht.setBackgroundDrawable(null);
      }
    });
    paramContext = paramContext.getResources();
    this.ahz = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(2131165655));
  }
  
  final void bz(int paramInt)
  {
    if (this.ahr.ahI == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.ahC);
    boolean bool;
    int i;
    label62:
    label93:
    ListPopupWindow localListPopupWindow;
    if (this.ahx.getVisibility() == 0)
    {
      bool = true;
      int j = this.ahr.ahI.im();
      if (!bool) {
        break label212;
      }
      i = 1;
      if ((paramInt == 2147483647) || (j <= i + paramInt)) {
        break label217;
      }
      this.ahr.setShowFooterView(true);
      this.ahr.bA(paramInt - 1);
      localListPopupWindow = getListPopupWindow();
      if (!localListPopupWindow.apw.isShowing())
      {
        if ((!this.ahE) && (bool)) {
          break label236;
        }
        this.ahr.g(true, bool);
      }
    }
    for (;;)
    {
      localListPopupWindow.setContentWidth(Math.min(this.ahr.iA(), this.ahz));
      localListPopupWindow.show();
      if (this.ahA != null) {
        this.ahA.K(true);
      }
      localListPopupWindow.aoY.setContentDescription(getContext().getString(2131755078));
      localListPopupWindow.aoY.setSelector(new ColorDrawable(0));
      return;
      bool = false;
      break;
      label212:
      i = 0;
      break label62;
      label217:
      this.ahr.setShowFooterView(false);
      this.ahr.bA(paramInt);
      break label93;
      label236:
      this.ahr.g(false, false);
    }
  }
  
  public c getDataModel()
  {
    return this.ahr.ahI;
  }
  
  ListPopupWindow getListPopupWindow()
  {
    if (this.ahD == null)
    {
      this.ahD = new ListPopupWindow(getContext());
      this.ahD.setAdapter(this.ahr);
      this.ahD.apl = this;
      this.ahD.setModal(true);
      this.ahD.apn = this.ahs;
      this.ahD.setOnDismissListener(this.ahs);
    }
    return this.ahD;
  }
  
  public final boolean ix()
  {
    if ((getListPopupWindow().apw.isShowing()) || (!this.ou)) {
      return false;
    }
    this.ahE = false;
    bz(this.ahF);
    return true;
  }
  
  public final boolean iy()
  {
    if (getListPopupWindow().apw.isShowing())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.ahC);
      }
    }
    return true;
  }
  
  public final boolean iz()
  {
    return getListPopupWindow().apw.isShowing();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c localc = this.ahr.ahI;
    if (localc != null) {
      localc.registerObserver(this.ahB);
    }
    this.ou = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.ahr.ahI;
    if (localObject != null) {
      ((c)localObject).unregisterObserver(this.ahB);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.ahC);
    }
    if (iz()) {
      iy();
    }
    this.ou = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.aht.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!iz()) {
      iy();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.aht;
    int i = paramInt2;
    if (this.ahx.getVisibility() != 0) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localView, paramInt1, i);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(c paramc)
  {
    a locala = this.ahr;
    c localc = locala.ahH.ahr.ahI;
    if ((localc != null) && (locala.ahH.isShown())) {
      localc.unregisterObserver(locala.ahH.ahB);
    }
    locala.ahI = paramc;
    if ((paramc != null) && (locala.ahH.isShown())) {
      paramc.registerObserver(locala.ahH.ahB);
    }
    locala.notifyDataSetChanged();
    if (getListPopupWindow().apw.isShowing())
    {
      iy();
      ix();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.ahG = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.ahw.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.ahw.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.ahF = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.adF = paramOnDismissListener;
  }
  
  public void setProvider(b paramb)
  {
    this.ahA = paramb;
  }
  
  final class a
    extends BaseAdapter
  {
    c ahI;
    private int ahJ = 4;
    boolean ahK;
    private boolean ahL;
    private boolean ahM;
    
    a() {}
    
    public final void bA(int paramInt)
    {
      if (this.ahJ != paramInt)
      {
        this.ahJ = paramInt;
        notifyDataSetChanged();
      }
    }
    
    public final void g(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.ahK != paramBoolean1) || (this.ahL != paramBoolean2))
      {
        this.ahK = paramBoolean1;
        this.ahL = paramBoolean2;
        notifyDataSetChanged();
      }
    }
    
    public final int getCount()
    {
      int j = this.ahI.im();
      int i = j;
      if (!this.ahK)
      {
        i = j;
        if (this.ahI.in() != null) {
          i = j - 1;
        }
      }
      j = Math.min(i, this.ahJ);
      i = j;
      if (this.ahM) {
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
      if (!this.ahK)
      {
        i = paramInt;
        if (this.ahI.in() != null) {
          i = paramInt + 1;
        }
      }
      return this.ahI.bx(i);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      if ((this.ahM) && (paramInt == getCount() - 1)) {
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
      if ((this.ahK) && (paramInt == 0) && (this.ahL))
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
    
    public final int iA()
    {
      int k = this.ahJ;
      this.ahJ = 2147483647;
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
      this.ahJ = k;
      return j;
    }
    
    public final void setShowFooterView(boolean paramBoolean)
    {
      if (this.ahM != paramBoolean)
      {
        this.ahM = paramBoolean;
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
      if (paramView == ActivityChooserView.this.ahx)
      {
        ActivityChooserView.this.iy();
        paramView = ActivityChooserView.this.ahr.ahI.in();
        int i = ActivityChooserView.this.ahr.ahI.a(paramView);
        Object localObject = ActivityChooserView.this.ahr.ahI.by(i);
        if (localObject != null)
        {
          ((Intent)localObject).addFlags(524288);
          paramView = ActivityChooserView.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "android/support/v7/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "android/support/v7/widget/ActivityChooserView$Callbacks", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        return;
      }
      if (paramView == ActivityChooserView.this.ahv)
      {
        ActivityChooserView.this.ahE = false;
        ActivityChooserView.this.bz(ActivityChooserView.this.ahF);
        return;
      }
      throw new IllegalArgumentException();
    }
    
    public final void onDismiss()
    {
      if (ActivityChooserView.this.adF != null) {
        ActivityChooserView.this.adF.onDismiss();
      }
      if (ActivityChooserView.this.ahA != null) {
        ActivityChooserView.this.ahA.K(false);
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
        ActivityChooserView.this.iy();
        if (!ActivityChooserView.this.ahE) {
          break;
        }
      } while (paramInt <= 0);
      paramView = ActivityChooserView.this.ahr.ahI;
      for (;;)
      {
        synchronized (paramView.ahe)
        {
          paramView.iq();
          c.a locala1 = (c.a)paramView.ahf.get(paramInt);
          c.a locala2 = (c.a)paramView.ahf.get(0);
          if (locala2 != null)
          {
            f = locala2.weight - locala1.weight + 5.0F;
            paramView.a(new c.c(new ComponentName(locala1.resolveInfo.activityInfo.packageName, locala1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
            return;
          }
        }
        float f = 1.0F;
      }
      if (ActivityChooserView.this.ahr.ahK) {}
      for (;;)
      {
        paramView = ActivityChooserView.this.ahr.ahI.by(paramInt);
        if (paramView == null) {
          break;
        }
        paramView.addFlags(524288);
        ??? = ActivityChooserView.this.getContext();
        paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(???, paramView.aeD(), "android/support/v7/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ???.startActivity((Intent)paramView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(???, "android/support/v7/widget/ActivityChooserView$Callbacks", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        return;
        paramInt += 1;
      }
    }
    
    public final boolean onLongClick(View paramView)
    {
      if (paramView == ActivityChooserView.this.ahx)
      {
        if (ActivityChooserView.this.ahr.getCount() > 0)
        {
          ActivityChooserView.this.ahE = true;
          ActivityChooserView.this.bz(ActivityChooserView.this.ahF);
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