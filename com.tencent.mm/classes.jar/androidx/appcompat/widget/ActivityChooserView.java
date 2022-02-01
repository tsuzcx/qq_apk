package androidx.appcompat.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.a.d;
import androidx.appcompat.a.f;
import androidx.appcompat.a.g;
import androidx.appcompat.a.h;
import androidx.appcompat.a.j;
import androidx.appcompat.view.menu.s;
import androidx.core.g.a.d;
import androidx.core.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActivityChooserView
  extends ViewGroup
{
  PopupWindow.OnDismissListener lT;
  private boolean mIsAttachedToWindow;
  final a pR;
  private final ActivityChooserView.b pS;
  final View pT;
  final Drawable pU;
  final FrameLayout pV;
  private final ImageView pW;
  final FrameLayout pX;
  final ImageView pY;
  private final int pZ;
  b qa;
  final DataSetObserver qb;
  private final ViewTreeObserver.OnGlobalLayoutListener qc;
  private ListPopupWindow qd;
  boolean qe;
  int qf;
  int qg;
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(240618);
    this.qb = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(240508);
        super.onChanged();
        ActivityChooserView.this.pR.notifyDataSetChanged();
        AppMethodBeat.o(240508);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(240511);
        super.onInvalidated();
        ActivityChooserView.this.pR.notifyDataSetInvalidated();
        AppMethodBeat.o(240511);
      }
    };
    this.qc = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(240518);
        if (ActivityChooserView.this.dj())
        {
          if (!ActivityChooserView.this.isShown())
          {
            ActivityChooserView.this.getListPopupWindow().dismiss();
            AppMethodBeat.o(240518);
            return;
          }
          ActivityChooserView.this.getListPopupWindow().show();
          if (ActivityChooserView.this.qa != null) {
            ActivityChooserView.this.qa.X(true);
          }
        }
        AppMethodBeat.o(240518);
      }
    };
    this.qf = 4;
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ActivityChooserView, paramInt, 0);
    this.qf = ((TypedArray)localObject).getInt(a.j.ActivityChooserView_initialActivityCount, 4);
    paramAttributeSet = ((TypedArray)localObject).getDrawable(a.j.ActivityChooserView_expandActivityOverflowButtonDrawable);
    ((TypedArray)localObject).recycle();
    LayoutInflater.from(getContext()).inflate(a.g.abc_activity_chooser_view, this, true);
    this.pS = new ActivityChooserView.b(this);
    this.pT = findViewById(a.f.activity_chooser_view_content);
    this.pU = this.pT.getBackground();
    this.pX = ((FrameLayout)findViewById(a.f.default_activity_button));
    this.pX.setOnClickListener(this.pS);
    this.pX.setOnLongClickListener(this.pS);
    this.pY = ((ImageView)this.pX.findViewById(a.f.image));
    localObject = (FrameLayout)findViewById(a.f.expand_activities_button);
    ((FrameLayout)localObject).setOnClickListener(this.pS);
    ((FrameLayout)localObject).setAccessibilityDelegate(new View.AccessibilityDelegate()
    {
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        AppMethodBeat.i(240532);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        paramAnonymousView = d.a(paramAnonymousAccessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 19) {
          paramAnonymousView.Ov.setCanOpenPopup(true);
        }
        AppMethodBeat.o(240532);
      }
    });
    ((FrameLayout)localObject).setOnTouchListener(new r((View)localObject)
    {
      public final s bQ()
      {
        AppMethodBeat.i(240539);
        ListPopupWindow localListPopupWindow = ActivityChooserView.this.getListPopupWindow();
        AppMethodBeat.o(240539);
        return localListPopupWindow;
      }
      
      protected final boolean bR()
      {
        AppMethodBeat.i(240541);
        ActivityChooserView.this.dh();
        AppMethodBeat.o(240541);
        return true;
      }
      
      protected final boolean cR()
      {
        AppMethodBeat.i(240543);
        ActivityChooserView.this.di();
        AppMethodBeat.o(240543);
        return true;
      }
    });
    this.pV = ((FrameLayout)localObject);
    this.pW = ((ImageView)((FrameLayout)localObject).findViewById(a.f.image));
    this.pW.setImageDrawable(paramAttributeSet);
    this.pR = new a();
    this.pR.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(240554);
        super.onChanged();
        ActivityChooserView localActivityChooserView = ActivityChooserView.this;
        if (localActivityChooserView.pR.getCount() > 0)
        {
          localActivityChooserView.pV.setEnabled(true);
          int i = localActivityChooserView.pR.qi.cW();
          int j = localActivityChooserView.pR.qi.cZ();
          if ((i != 1) && ((i <= 1) || (j <= 0))) {
            break label196;
          }
          localActivityChooserView.pX.setVisibility(0);
          Object localObject = localActivityChooserView.pR.qi.cX();
          PackageManager localPackageManager = localActivityChooserView.getContext().getPackageManager();
          localActivityChooserView.pY.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
          if (localActivityChooserView.qg != 0)
          {
            localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
            localObject = localActivityChooserView.getContext().getString(localActivityChooserView.qg, new Object[] { localObject });
            localActivityChooserView.pX.setContentDescription((CharSequence)localObject);
          }
        }
        for (;;)
        {
          if (localActivityChooserView.pX.getVisibility() != 0) {
            break label208;
          }
          localActivityChooserView.pT.setBackgroundDrawable(localActivityChooserView.pU);
          AppMethodBeat.o(240554);
          return;
          localActivityChooserView.pV.setEnabled(false);
          break;
          label196:
          localActivityChooserView.pX.setVisibility(8);
        }
        label208:
        localActivityChooserView.pT.setBackgroundDrawable(null);
        AppMethodBeat.o(240554);
      }
    });
    paramContext = paramContext.getResources();
    this.pZ = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    AppMethodBeat.o(240618);
  }
  
  final void ap(int paramInt)
  {
    AppMethodBeat.i(240631);
    Object localObject;
    if (this.pR.qi == null)
    {
      localObject = new IllegalStateException("No data model. Did you call #setDataModel?");
      AppMethodBeat.o(240631);
      throw ((Throwable)localObject);
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.qc);
    boolean bool;
    int i;
    if (this.pX.getVisibility() == 0)
    {
      bool = true;
      int j = this.pR.qi.cW();
      if (!bool) {
        break label232;
      }
      i = 1;
      label76:
      if ((paramInt == 2147483647) || (j <= i + paramInt)) {
        break label237;
      }
      this.pR.setShowFooterView(true);
      this.pR.aq(paramInt - 1);
      label108:
      localObject = getListPopupWindow();
      if (!((ListPopupWindow)localObject).ty.isShowing())
      {
        if ((!this.qe) && (bool)) {
          break label256;
        }
        this.pR.d(true, bool);
      }
    }
    for (;;)
    {
      ((ListPopupWindow)localObject).setContentWidth(Math.min(this.pR.dk(), this.pZ));
      ((ListPopupWindow)localObject).show();
      if (this.qa != null) {
        this.qa.X(true);
      }
      ((ListPopupWindow)localObject).sY.setContentDescription(getContext().getString(a.h.abc_activitychooserview_choose_application));
      ((ListPopupWindow)localObject).sY.setSelector(new ColorDrawable(0));
      AppMethodBeat.o(240631);
      return;
      bool = false;
      break;
      label232:
      i = 0;
      break label76;
      label237:
      this.pR.setShowFooterView(false);
      this.pR.aq(paramInt);
      break label108;
      label256:
      this.pR.d(false, false);
    }
  }
  
  public final boolean dh()
  {
    AppMethodBeat.i(240629);
    if ((getListPopupWindow().ty.isShowing()) || (!this.mIsAttachedToWindow))
    {
      AppMethodBeat.o(240629);
      return false;
    }
    this.qe = false;
    ap(this.qf);
    AppMethodBeat.o(240629);
    return true;
  }
  
  public final boolean di()
  {
    AppMethodBeat.i(240634);
    if (getListPopupWindow().ty.isShowing())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.qc);
      }
    }
    AppMethodBeat.o(240634);
    return true;
  }
  
  public final boolean dj()
  {
    AppMethodBeat.i(292983);
    boolean bool = getListPopupWindow().ty.isShowing();
    AppMethodBeat.o(292983);
    return bool;
  }
  
  public c getDataModel()
  {
    return this.pR.qi;
  }
  
  ListPopupWindow getListPopupWindow()
  {
    AppMethodBeat.i(240645);
    if (this.qd == null)
    {
      this.qd = new ListPopupWindow(getContext());
      this.qd.setAdapter(this.pR);
      this.qd.tl = this;
      this.qd.P(true);
      this.qd.tp = this.pS;
      this.qd.setOnDismissListener(this.pS);
    }
    ListPopupWindow localListPopupWindow = this.qd;
    AppMethodBeat.o(240645);
    return localListPopupWindow;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(240636);
    super.onAttachedToWindow();
    c localc = this.pR.qi;
    if (localc != null) {
      localc.registerObserver(this.qb);
    }
    this.mIsAttachedToWindow = true;
    AppMethodBeat.o(240636);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(240637);
    super.onDetachedFromWindow();
    Object localObject = this.pR.qi;
    if (localObject != null) {
      ((c)localObject).unregisterObserver(this.qb);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.qc);
    }
    if (dj()) {
      di();
    }
    this.mIsAttachedToWindow = false;
    AppMethodBeat.o(240637);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(240641);
    this.pT.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!dj()) {
      di();
    }
    AppMethodBeat.o(240641);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240639);
    View localView = this.pT;
    int i = paramInt2;
    if (this.pX.getVisibility() != 0) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localView, paramInt1, i);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
    AppMethodBeat.o(240639);
  }
  
  public void setActivityChooserModel(c paramc)
  {
    AppMethodBeat.i(240621);
    a locala = this.pR;
    c localc = locala.qh.pR.qi;
    if ((localc != null) && (locala.qh.isShown())) {
      localc.unregisterObserver(locala.qh.qb);
    }
    locala.qi = paramc;
    if ((paramc != null) && (locala.qh.isShown())) {
      paramc.registerObserver(locala.qh.qb);
    }
    locala.notifyDataSetChanged();
    if (getListPopupWindow().ty.isShowing())
    {
      di();
      dh();
    }
    AppMethodBeat.o(240621);
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.qg = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    AppMethodBeat.i(240626);
    String str = getContext().getString(paramInt);
    this.pW.setContentDescription(str);
    AppMethodBeat.o(240626);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(240624);
    this.pW.setImageDrawable(paramDrawable);
    AppMethodBeat.o(240624);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.qf = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.lT = paramOnDismissListener;
  }
  
  public void setProvider(b paramb)
  {
    this.qa = paramb;
  }
  
  public static class InnerLayout
    extends LinearLayout
  {
    private static final int[] mb = { 16842964 };
    
    public InnerLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(240600);
      paramContext = ac.a(paramContext, paramAttributeSet, mb);
      setBackgroundDrawable(paramContext.getDrawable(0));
      paramContext.wA.recycle();
      AppMethodBeat.o(240600);
    }
  }
  
  final class a
    extends BaseAdapter
  {
    c qi;
    private int qj = 4;
    boolean qk;
    private boolean ql;
    private boolean qm;
    
    a() {}
    
    public final void aq(int paramInt)
    {
      AppMethodBeat.i(240570);
      if (this.qj != paramInt)
      {
        this.qj = paramInt;
        notifyDataSetChanged();
      }
      AppMethodBeat.o(240570);
    }
    
    public final void d(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(240574);
      if ((this.qk != paramBoolean1) || (this.ql != paramBoolean2))
      {
        this.qk = paramBoolean1;
        this.ql = paramBoolean2;
        notifyDataSetChanged();
      }
      AppMethodBeat.o(240574);
    }
    
    public final int dk()
    {
      AppMethodBeat.i(240569);
      int k = this.qj;
      this.qj = 2147483647;
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
      this.qj = k;
      AppMethodBeat.o(240569);
      return j;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(240563);
      int j = this.qi.cW();
      int i = j;
      if (!this.qk)
      {
        i = j;
        if (this.qi.cX() != null) {
          i = j - 1;
        }
      }
      j = Math.min(i, this.qj);
      i = j;
      if (this.qm) {
        i = j + 1;
      }
      AppMethodBeat.o(240563);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(240564);
      switch (getItemViewType(paramInt))
      {
      default: 
        localObject = new IllegalArgumentException();
        AppMethodBeat.o(240564);
        throw ((Throwable)localObject);
      case 1: 
        AppMethodBeat.o(240564);
        return null;
      }
      int i = paramInt;
      if (!this.qk)
      {
        i = paramInt;
        if (this.qi.cX() != null) {
          i = paramInt + 1;
        }
      }
      Object localObject = this.qi.an(i);
      AppMethodBeat.o(240564);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(240559);
      if ((this.qm) && (paramInt == getCount() - 1))
      {
        AppMethodBeat.o(240559);
        return 1;
      }
      AppMethodBeat.o(240559);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(240566);
      View localView;
      switch (getItemViewType(paramInt))
      {
      default: 
        paramView = new IllegalArgumentException();
        AppMethodBeat.o(240566);
        throw paramView;
      case 1: 
        if (paramView != null)
        {
          localView = paramView;
          if (paramView.getId() == 1) {}
        }
        else
        {
          localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, paramViewGroup, false);
          localView.setId(1);
          ((TextView)localView.findViewById(a.f.title)).setText(ActivityChooserView.this.getContext().getString(a.h.abc_activity_chooser_view_see_all));
        }
        AppMethodBeat.o(240566);
        return localView;
      }
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getId() == a.f.list_item) {}
      }
      else
      {
        localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, paramViewGroup, false);
      }
      paramView = ActivityChooserView.this.getContext().getPackageManager();
      paramViewGroup = (ImageView)localView.findViewById(a.f.icon);
      ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
      paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
      ((TextView)localView.findViewById(a.f.title)).setText(localResolveInfo.loadLabel(paramView));
      if ((this.qk) && (paramInt == 0) && (this.ql)) {
        localView.setActivated(true);
      }
      for (;;)
      {
        AppMethodBeat.o(240566);
        return localView;
        localView.setActivated(false);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
    
    public final void setShowFooterView(boolean paramBoolean)
    {
      AppMethodBeat.i(240572);
      if (this.qm != paramBoolean)
      {
        this.qm = paramBoolean;
        notifyDataSetChanged();
      }
      AppMethodBeat.o(240572);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserView
 * JD-Core Version:    0.7.0.1
 */