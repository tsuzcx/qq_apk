package androidx.appcompat.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
  private boolean mIsAttachedToWindow;
  PopupWindow.OnDismissListener mQ;
  final a qO;
  private final ActivityChooserView.b qP;
  final View qQ;
  final Drawable qR;
  final FrameLayout qS;
  private final ImageView qT;
  final FrameLayout qU;
  final ImageView qV;
  private final int qW;
  b qX;
  final DataSetObserver qY;
  private final ViewTreeObserver.OnGlobalLayoutListener qZ;
  private ListPopupWindow ra;
  boolean rb;
  int rc;
  int rd;
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199751);
    this.qY = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(200232);
        super.onChanged();
        ActivityChooserView.this.qO.notifyDataSetChanged();
        AppMethodBeat.o(200232);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(200239);
        super.onInvalidated();
        ActivityChooserView.this.qO.notifyDataSetInvalidated();
        AppMethodBeat.o(200239);
      }
    };
    this.qZ = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(200224);
        if (ActivityChooserView.this.ei())
        {
          if (!ActivityChooserView.this.isShown())
          {
            ActivityChooserView.this.getListPopupWindow().dismiss();
            AppMethodBeat.o(200224);
            return;
          }
          ActivityChooserView.this.getListPopupWindow().show();
          if (ActivityChooserView.this.qX != null) {
            ActivityChooserView.this.qX.aD(true);
          }
        }
        AppMethodBeat.o(200224);
      }
    };
    this.rc = 4;
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ActivityChooserView, paramInt, 0);
    this.rc = ((TypedArray)localObject).getInt(a.j.ActivityChooserView_initialActivityCount, 4);
    paramAttributeSet = ((TypedArray)localObject).getDrawable(a.j.ActivityChooserView_expandActivityOverflowButtonDrawable);
    ((TypedArray)localObject).recycle();
    LayoutInflater.from(getContext()).inflate(a.g.abc_activity_chooser_view, this, true);
    this.qP = new ActivityChooserView.b(this);
    this.qQ = findViewById(a.f.activity_chooser_view_content);
    this.qR = this.qQ.getBackground();
    this.qU = ((FrameLayout)findViewById(a.f.default_activity_button));
    this.qU.setOnClickListener(this.qP);
    this.qU.setOnLongClickListener(this.qP);
    this.qV = ((ImageView)this.qU.findViewById(a.f.image));
    localObject = (FrameLayout)findViewById(a.f.expand_activities_button);
    ((FrameLayout)localObject).setOnClickListener(this.qP);
    ((FrameLayout)localObject).setAccessibilityDelegate(new View.AccessibilityDelegate()
    {
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        AppMethodBeat.i(200234);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        d.a(paramAnonymousAccessibilityNodeInfo).EW();
        AppMethodBeat.o(200234);
      }
    });
    ((FrameLayout)localObject).setOnTouchListener(new r((View)localObject)
    {
      public final s cJ()
      {
        AppMethodBeat.i(200202);
        ListPopupWindow localListPopupWindow = ActivityChooserView.this.getListPopupWindow();
        AppMethodBeat.o(200202);
        return localListPopupWindow;
      }
      
      protected final boolean cK()
      {
        AppMethodBeat.i(200207);
        ActivityChooserView.this.ea();
        AppMethodBeat.o(200207);
        return true;
      }
      
      protected final boolean dK()
      {
        AppMethodBeat.i(200213);
        ActivityChooserView.this.eb();
        AppMethodBeat.o(200213);
        return true;
      }
    });
    this.qS = ((FrameLayout)localObject);
    this.qT = ((ImageView)((FrameLayout)localObject).findViewById(a.f.image));
    this.qT.setImageDrawable(paramAttributeSet);
    this.qO = new a();
    this.qO.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(200211);
        super.onChanged();
        ActivityChooserView localActivityChooserView = ActivityChooserView.this;
        if (localActivityChooserView.qO.getCount() > 0)
        {
          localActivityChooserView.qS.setEnabled(true);
          int i = localActivityChooserView.qO.rf.dP();
          int j = localActivityChooserView.qO.rf.dS();
          if ((i != 1) && ((i <= 1) || (j <= 0))) {
            break label196;
          }
          localActivityChooserView.qU.setVisibility(0);
          Object localObject = localActivityChooserView.qO.rf.dQ();
          PackageManager localPackageManager = localActivityChooserView.getContext().getPackageManager();
          localActivityChooserView.qV.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
          if (localActivityChooserView.rd != 0)
          {
            localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
            localObject = localActivityChooserView.getContext().getString(localActivityChooserView.rd, new Object[] { localObject });
            localActivityChooserView.qU.setContentDescription((CharSequence)localObject);
          }
        }
        for (;;)
        {
          if (localActivityChooserView.qU.getVisibility() != 0) {
            break label208;
          }
          localActivityChooserView.qQ.setBackgroundDrawable(localActivityChooserView.qR);
          AppMethodBeat.o(200211);
          return;
          localActivityChooserView.qS.setEnabled(false);
          break;
          label196:
          localActivityChooserView.qU.setVisibility(8);
        }
        label208:
        localActivityChooserView.qQ.setBackgroundDrawable(null);
        AppMethodBeat.o(200211);
      }
    });
    paramContext = paramContext.getResources();
    this.qW = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    AppMethodBeat.o(199751);
  }
  
  final void an(int paramInt)
  {
    AppMethodBeat.i(199804);
    Object localObject;
    if (this.qO.rf == null)
    {
      localObject = new IllegalStateException("No data model. Did you call #setDataModel?");
      AppMethodBeat.o(199804);
      throw ((Throwable)localObject);
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.qZ);
    boolean bool;
    int i;
    if (this.qU.getVisibility() == 0)
    {
      bool = true;
      int j = this.qO.rf.dP();
      if (!bool) {
        break label232;
      }
      i = 1;
      label76:
      if ((paramInt == 2147483647) || (j <= i + paramInt)) {
        break label237;
      }
      this.qO.setShowFooterView(true);
      this.qO.ao(paramInt - 1);
      label108:
      localObject = getListPopupWindow();
      if (!((ListPopupWindow)localObject).ux.isShowing())
      {
        if ((!this.rb) && (bool)) {
          break label256;
        }
        this.qO.d(true, bool);
      }
    }
    for (;;)
    {
      ((ListPopupWindow)localObject).setContentWidth(Math.min(this.qO.ej(), this.qW));
      ((ListPopupWindow)localObject).show();
      if (this.qX != null) {
        this.qX.aD(true);
      }
      ((ListPopupWindow)localObject).tX.setContentDescription(getContext().getString(a.h.abc_activitychooserview_choose_application));
      ((ListPopupWindow)localObject).tX.setSelector(new ColorDrawable(0));
      AppMethodBeat.o(199804);
      return;
      bool = false;
      break;
      label232:
      i = 0;
      break label76;
      label237:
      this.qO.setShowFooterView(false);
      this.qO.ao(paramInt);
      break label108;
      label256:
      this.qO.d(false, false);
    }
  }
  
  public final boolean ea()
  {
    AppMethodBeat.i(199789);
    if ((getListPopupWindow().ux.isShowing()) || (!this.mIsAttachedToWindow))
    {
      AppMethodBeat.o(199789);
      return false;
    }
    this.rb = false;
    an(this.rc);
    AppMethodBeat.o(199789);
    return true;
  }
  
  public final boolean eb()
  {
    AppMethodBeat.i(199811);
    if (getListPopupWindow().ux.isShowing())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.qZ);
      }
    }
    AppMethodBeat.o(199811);
    return true;
  }
  
  public final boolean ei()
  {
    AppMethodBeat.i(369510);
    boolean bool = getListPopupWindow().ux.isShowing();
    AppMethodBeat.o(369510);
    return bool;
  }
  
  public c getDataModel()
  {
    return this.qO.rf;
  }
  
  ListPopupWindow getListPopupWindow()
  {
    AppMethodBeat.i(199908);
    if (this.ra == null)
    {
      this.ra = new ListPopupWindow(getContext());
      this.ra.setAdapter(this.qO);
      this.ra.ul = this;
      this.ra.eK();
      this.ra.un = this.qP;
      this.ra.setOnDismissListener(this.qP);
    }
    ListPopupWindow localListPopupWindow = this.ra;
    AppMethodBeat.o(199908);
    return localListPopupWindow;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(199829);
    super.onAttachedToWindow();
    c localc = this.qO.rf;
    if (localc != null) {
      localc.registerObserver(this.qY);
    }
    this.mIsAttachedToWindow = true;
    AppMethodBeat.o(199829);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(199843);
    super.onDetachedFromWindow();
    Object localObject = this.qO.rf;
    if (localObject != null) {
      ((c)localObject).unregisterObserver(this.qY);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.qZ);
    }
    if (ei()) {
      eb();
    }
    this.mIsAttachedToWindow = false;
    AppMethodBeat.o(199843);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199866);
    this.qQ.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!ei()) {
      eb();
    }
    AppMethodBeat.o(199866);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199856);
    View localView = this.qQ;
    int i = paramInt2;
    if (this.qU.getVisibility() != 0) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localView, paramInt1, i);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
    AppMethodBeat.o(199856);
  }
  
  public void setActivityChooserModel(c paramc)
  {
    AppMethodBeat.i(199761);
    a locala = this.qO;
    c localc = locala.re.qO.rf;
    if ((localc != null) && (locala.re.isShown())) {
      localc.unregisterObserver(locala.re.qY);
    }
    locala.rf = paramc;
    if ((paramc != null) && (locala.re.isShown())) {
      paramc.registerObserver(locala.re.qY);
    }
    locala.notifyDataSetChanged();
    if (getListPopupWindow().ux.isShowing())
    {
      eb();
      ea();
    }
    AppMethodBeat.o(199761);
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.rd = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    AppMethodBeat.i(199776);
    String str = getContext().getString(paramInt);
    this.qT.setContentDescription(str);
    AppMethodBeat.o(199776);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199768);
    this.qT.setImageDrawable(paramDrawable);
    AppMethodBeat.o(199768);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.rc = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mQ = paramOnDismissListener;
  }
  
  public void setProvider(b paramb)
  {
    this.qX = paramb;
  }
  
  final class a
    extends BaseAdapter
  {
    c rf;
    private int rg = 4;
    boolean rh;
    private boolean ri;
    private boolean rj;
    
    a() {}
    
    public final void ao(int paramInt)
    {
      AppMethodBeat.i(200237);
      if (this.rg != paramInt)
      {
        this.rg = paramInt;
        notifyDataSetChanged();
      }
      AppMethodBeat.o(200237);
    }
    
    public final void d(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(200252);
      if ((this.rh != paramBoolean1) || (this.ri != paramBoolean2))
      {
        this.rh = paramBoolean1;
        this.ri = paramBoolean2;
        notifyDataSetChanged();
      }
      AppMethodBeat.o(200252);
    }
    
    public final int ej()
    {
      AppMethodBeat.i(200231);
      int k = this.rg;
      this.rg = 2147483647;
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
      this.rg = k;
      AppMethodBeat.o(200231);
      return j;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(200199);
      int j = this.rf.dP();
      int i = j;
      if (!this.rh)
      {
        i = j;
        if (this.rf.dQ() != null) {
          i = j - 1;
        }
      }
      j = Math.min(i, this.rg);
      i = j;
      if (this.rj) {
        i = j + 1;
      }
      AppMethodBeat.o(200199);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(200206);
      switch (getItemViewType(paramInt))
      {
      default: 
        localObject = new IllegalArgumentException();
        AppMethodBeat.o(200206);
        throw ((Throwable)localObject);
      case 1: 
        AppMethodBeat.o(200206);
        return null;
      }
      int i = paramInt;
      if (!this.rh)
      {
        i = paramInt;
        if (this.rf.dQ() != null) {
          i = paramInt + 1;
        }
      }
      Object localObject = this.rf.al(i);
      AppMethodBeat.o(200206);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(200189);
      if ((this.rj) && (paramInt == getCount() - 1))
      {
        AppMethodBeat.o(200189);
        return 1;
      }
      AppMethodBeat.o(200189);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(200222);
      View localView;
      switch (getItemViewType(paramInt))
      {
      default: 
        paramView = new IllegalArgumentException();
        AppMethodBeat.o(200222);
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
        AppMethodBeat.o(200222);
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
      if ((this.rh) && (paramInt == 0) && (this.ri)) {
        localView.setActivated(true);
      }
      for (;;)
      {
        AppMethodBeat.o(200222);
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
      AppMethodBeat.i(200245);
      if (this.rj != paramBoolean)
      {
        this.rj = paramBoolean;
        notifyDataSetChanged();
      }
      AppMethodBeat.o(200245);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserView
 * JD-Core Version:    0.7.0.1
 */