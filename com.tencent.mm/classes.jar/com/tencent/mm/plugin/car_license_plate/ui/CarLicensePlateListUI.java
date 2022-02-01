package com.tencent.mm.plugin.car_license_plate.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.h.a;
import androidx.recyclerview.widget.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.car_license_plate.a.b;
import com.tencent.mm.plugin.car_license_plate.a.c;
import com.tencent.mm.plugin.car_license_plate.a.d;
import com.tencent.mm.plugin.car_license_plate.a.e;
import com.tencent.mm.plugin.car_license_plate.a.f;
import com.tencent.mm.plugin.car_license_plate.a.g;
import com.tencent.mm.plugin.car_license_plate.a.c;
import com.tencent.mm.plugin.car_license_plate.a.d;
import com.tencent.mm.plugin.car_license_plate.a.e.a;
import com.tencent.mm.plugin.car_license_plate.api.entity.MMCarLicensePlateInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.w;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlinx.coroutines.ak;
import org.apache.commons.b.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateBaseActivity;", "()V", "emptyView", "Landroid/view/View;", "loadingView", "presenter", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$Presenter;", "recyclerAdapter", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter;", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/MRecyclerView;", "viewCallback", "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1;", "viewModel", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewModel;", "finish", "", "getLayoutId", "", "onPostCreate", "savedInstanceState", "Landroid/os/Bundle;", "provideCustomActivityContentView", "Companion", "ListAdapter", "ListDiffCallback", "ListVHText", "plugin-car-license-plate_release"})
public final class CarLicensePlateListUI
  extends CarLicensePlateBaseActivity
{
  public static final CarLicensePlateListUI.a sYJ;
  private HashMap _$_findViewCache;
  private View kGT;
  private CarLicensePlateListViewContract.ViewModel sYE;
  private CarLicensePlateListViewContract.a sYF;
  private MRecyclerView sYG;
  private b sYH;
  private final f sYI;
  private View sxR;
  
  static
  {
    AppMethodBeat.i(187124);
    sYJ = new CarLicensePlateListUI.a((byte)0);
    AppMethodBeat.o(187124);
  }
  
  public CarLicensePlateListUI()
  {
    AppMethodBeat.i(187122);
    this.sYI = new f(this);
    AppMethodBeat.o(187122);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(187162);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(187162);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(187161);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(187161);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(187117);
    Object localObject = this.sYE;
    Intent localIntent;
    if (localObject != null)
    {
      localIntent = new Intent();
      localObject = ((CarLicensePlateListViewContract.ViewModel)localObject).sYX;
      if (localObject == null) {
        break label63;
      }
    }
    label63:
    for (localObject = ((MMCarLicensePlateInfo)localObject).sXr;; localObject = null)
    {
      localIntent.putExtra("RESULT_KEY_UPDATED_LIST", (Serializable)localObject);
      setResult(-1, localIntent);
      super.finish();
      AppMethodBeat.o(187117);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onPostCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(187114);
    super.onPostCreate(paramBundle);
    setMMTitleColor(androidx.core.content.a.w((Context)this, a.b.action_bar_tittle_color));
    setMMTitle(getString(a.g.car_license_plate_main_title));
    setActionbarColor(androidx.core.content.a.w((Context)this, a.b.white));
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this), a.f.actionbar_icon_dark_back);
    setBackBtnColorFilter(androidx.core.content.a.w((Context)this, a.b.action_bar_tittle_color));
    getContentView().setBackgroundColor(androidx.core.content.a.w((Context)this, a.b.white));
    getController().setNavigationbarColor(androidx.core.content.a.w((Context)this, a.b.white));
    getIntent().setExtrasClassLoader(CarLicensePlateListViewContract.ViewModel.class.getClassLoader());
    this.sYE = ((CarLicensePlateListViewContract.ViewModel)getIntent().getParcelableExtra("INTENT_KEY_VIEW_MODEL"));
    this.sYF = ((CarLicensePlateListViewContract.a)new e(e.a.sXF));
    paramBundle = this.sYF;
    if (paramBundle == null) {
      p.bGy("presenter");
    }
    Object localObject1 = this.sYI;
    Object localObject2 = ((f)localObject1).sYK.getContentView();
    if (localObject2 == null)
    {
      paramBundle = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(187114);
      throw paramBundle;
    }
    localObject2 = (ViewGroup)localObject2;
    LayoutInflater.from((Context)((f)localObject1).sYK).inflate(a.e.car_license_plate_list_empty_view, (ViewGroup)localObject2, true);
    CarLicensePlateListUI localCarLicensePlateListUI = ((f)localObject1).sYK;
    Object localObject3 = ((ViewGroup)localObject2).findViewById(a.d.car_license_plate_list_empty_view);
    p.j(localObject3, "contentView.findViewById…se_plate_list_empty_view)");
    localCarLicensePlateListUI.sxR = ((View)localObject3);
    c(((f)localObject1).sYK).findViewById(a.d.btn_add).setOnClickListener((View.OnClickListener)new CarLicensePlateListUI.f.a((f)localObject1));
    LayoutInflater.from((Context)((f)localObject1).sYK).inflate(a.e.car_license_plate_list_loading_view, (ViewGroup)localObject2, true);
    localCarLicensePlateListUI = ((f)localObject1).sYK;
    localObject3 = ((ViewGroup)localObject2).findViewById(a.d.car_license_plate_list_loading_view);
    p.j(localObject3, "contentView.findViewById…_plate_list_loading_view)");
    localCarLicensePlateListUI.kGT = ((View)localObject3);
    localCarLicensePlateListUI = ((f)localObject1).sYK;
    localObject3 = new MRecyclerView((Context)((f)localObject1).sYK);
    ((ViewGroup)localObject2).addView((View)localObject3, new ViewGroup.LayoutParams(-1, -1));
    ((MRecyclerView)localObject3).setLayoutManager((RecyclerView.LayoutManager)new CarLicensePlateListUI.viewCallback.1.init..inlined.let.lambda.2((ViewGroup)localObject2, (f)localObject1));
    ((MRecyclerView)localObject3).setPadding(0, ((MRecyclerView)localObject3).getResources().getDimensionPixelSize(a.c.Edge_1_5_A), 0, 0);
    View localView = LayoutInflater.from((Context)((f)localObject1).sYK).inflate(a.e.car_license_plate_list_item_type_add, (ViewGroup)localObject3, false);
    localView.setOnClickListener((View.OnClickListener)new CarLicensePlateListUI.f.b((ViewGroup)localObject2, (f)localObject1));
    ((MRecyclerView)localObject3).dG(localView);
    localCarLicensePlateListUI.sYG = ((MRecyclerView)localObject3);
    ((f)localObject1).sYK.sYH = new b(((f)localObject1).sYK);
    b(((f)localObject1).sYK).setAdapter((RecyclerView.a)e(((f)localObject1).sYK));
    c(((f)localObject1).sYK).setVisibility(8);
    b(((f)localObject1).sYK).setVisibility(8);
    paramBundle.a((CarLicensePlateListViewContract.b)localObject1);
    if (this.sYE != null)
    {
      paramBundle = this.sYF;
      if (paramBundle == null) {
        p.bGy("presenter");
      }
      localObject1 = this.sYE;
      if (localObject1 == null) {
        p.iCn();
      }
      paramBundle.a((CarLicensePlateListViewContract.ViewModel)localObject1);
      paramBundle = this.sYF;
      if (paramBundle == null) {
        p.bGy("presenter");
      }
      this.sYE = paramBundle.bQt();
      paramBundle = new StringBuilder("onPostCreate, viewModel.callbackAfterCreated:");
      localObject1 = this.sYE;
      if ((localObject1 == null) || (((CarLicensePlateListViewContract.ViewModel)localObject1).sYY != true)) {
        break label691;
      }
    }
    label691:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.CarLicensePlateListUI", bool);
      AppMethodBeat.o(187114);
      return;
      paramBundle = this.sYF;
      if (paramBundle == null) {
        p.bGy("presenter");
      }
      paramBundle.cFE();
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final View provideCustomActivityContentView()
  {
    AppMethodBeat.i(187112);
    View localView = (View)new TouchableLayout((Context)this);
    AppMethodBeat.o(187112);
    return localView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "(Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI;)V", "plateNoList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "clearPlateNoList", "", "getAdapterPositionForChildView", "", "v", "Landroid/view/View;", "getItemCount", "onBindViewHolder", "holder", "position", "onClick", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onLongClick", "", "updatePlateNoList", "newList", "plugin-car-license-plate_release"})
  final class b
    extends RecyclerView.a<RecyclerView.v>
    implements View.OnClickListener, View.OnLongClickListener
  {
    final ArrayList<String> sXr;
    
    public b()
    {
      AppMethodBeat.i(186967);
      this.sXr = new ArrayList();
      AppMethodBeat.o(186967);
    }
    
    private final int dW(View paramView)
    {
      AppMethodBeat.i(186964);
      paramView = CarLicensePlateListUI.b(this.sYK).aQ(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(186964);
        return -1;
      }
      int i = CarLicensePlateListUI.b(this.sYK).U(paramView);
      AppMethodBeat.o(186964);
      return i;
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(186954);
      p.k(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(a.e.car_license_plate_list_item_type_text, paramViewGroup, false);
      paramViewGroup.setOnClickListener((View.OnClickListener)this);
      paramViewGroup.setOnLongClickListener((View.OnLongClickListener)this);
      p.j(paramViewGroup, "LayoutInflater.from(pare…dapter)\n                }");
      paramViewGroup = (RecyclerView.v)new CarLicensePlateListUI.d(paramViewGroup);
      AppMethodBeat.o(186954);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(186957);
      p.k(paramv, "holder");
      paramv = (CarLicensePlateListUI.d)paramv;
      Object localObject = this.sXr.get(paramInt);
      p.j(localObject, "plateNoList[position]");
      localObject = (String)localObject;
      p.k(localObject, "plateNo");
      if (((String)localObject).length() >= 7)
      {
        paramv.sYQ.setText((CharSequence)(g.bh((String)localObject, 0, 2) + " · " + g.bh((String)localObject, 2, ((String)localObject).length())));
        paramv.sYQ.setContentDescription((CharSequence)localObject);
      }
      AppMethodBeat.o(186957);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(186958);
      int i = this.sXr.size();
      AppMethodBeat.o(186958);
      return i;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186959);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      if (paramView == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186959);
        return;
      }
      int i = dW(paramView);
      paramView = (String)j.M((List)this.sXr, i);
      localObject = (CharSequence)paramView;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          CarLicensePlateListUI.a(this.sYK).aqJ(paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186959);
        return;
      }
    }
    
    public final boolean onLongClick(final View paramView)
    {
      AppMethodBeat.i(186961);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject1).aFi());
      if (paramView == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(186961);
        return false;
      }
      int i = dW(paramView);
      Object localObject2 = (String)j.M((List)this.sXr, i);
      localObject1 = (CharSequence)localObject2;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (i = 1; i == 0; i = 0)
      {
        localObject1 = new b(paramView, paramView.getContext());
        View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)c.sYN;
        localObject2 = (q.g)new a(this, paramView, (String)localObject2);
        TouchableLayout.a locala = TouchableLayout.YOD;
        i = TouchableLayout.igZ();
        locala = TouchableLayout.YOD;
        ((b)localObject1).a(paramView, localOnCreateContextMenuListener, (q.g)localObject2, i, TouchableLayout.iha());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(186961);
        return true;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(186961);
      return false;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter$onLongClick$2$2"})
    static final class a
      implements q.g
    {
      a(CarLicensePlateListUI.b paramb, View paramView, String paramString) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(187814);
        p.j(paramMenuItem, "menuItem");
        if ((paramMenuItem.getGroupId() == 0) && (paramMenuItem.getItemId() == 0)) {
          CarLicensePlateListUI.a(this.sYL.sYK).aqK(this.sYM);
        }
        AppMethodBeat.o(187814);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter$onLongClick$1", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "dismiss", "", "show", "xDown", "", "yDown", "plugin-car-license-plate_release"})
    public static final class b
      extends com.tencent.mm.ui.widget.b.a
    {
      b(View paramView, Context paramContext)
      {
        super();
      }
      
      public final boolean cFD()
      {
        AppMethodBeat.i(186507);
        ViewParent localViewParent = this.jLx.getParent();
        if (localViewParent != null) {
          localViewParent.requestDisallowInterceptTouchEvent(false);
        }
        boolean bool = super.cFD();
        AppMethodBeat.o(186507);
        return bool;
      }
      
      public final boolean eY(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(186506);
        ViewParent localViewParent = this.jLx.getParent();
        if (localViewParent != null) {
          localViewParent.requestDisallowInterceptTouchEvent(true);
        }
        boolean bool = super.eY(paramInt1, paramInt2);
        AppMethodBeat.o(186506);
        return bool;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "<anonymous parameter 2>", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
    static final class c
      implements View.OnCreateContextMenuListener
    {
      public static final c sYN;
      
      static
      {
        AppMethodBeat.i(187563);
        sYN = new c();
        AppMethodBeat.o(187563);
      }
      
      public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
      {
        AppMethodBeat.i(187559);
        paramContextMenu.add(0, 0, 0, (CharSequence)MMApplicationContext.getString(a.g.app_delete));
        AppMethodBeat.o(187559);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListVHText;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "text", "Landroid/widget/TextView;", "renderPlateNo", "", "plateNo", "", "plugin-car-license-plate_release"})
  static final class d
    extends RecyclerView.v
  {
    final TextView sYQ;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(186333);
      paramView = paramView.findViewById(a.d.text);
      if (paramView == null) {
        p.iCn();
      }
      this.sYQ = ((TextView)paramView);
      AppMethodBeat.o(186333);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(CarLicensePlateListUI paramCarLicensePlateListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(187233);
      this.sYK.onBackPressed();
      AppMethodBeat.o(187233);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewCallback;", "getActivityForResult", "Landroid/app/Activity;", "getCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "init", "", "onRenderData", "data", "Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "onRenderError", "exception", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiException;", "onRenderLoading", "request", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewCallback$Request;", "plugin-car-license-plate_release"})
  public static final class f
    implements CarLicensePlateListViewContract.b
  {
    public final void a(d paramd)
    {
      AppMethodBeat.i(187371);
      p.k(paramd, "exception");
      if ((paramd.sXC instanceof c)) {
        com.tencent.mm.plugin.car_license_plate.b.a.b(paramd);
      }
      AppMethodBeat.o(187371);
    }
    
    public final void a(MMCarLicensePlateInfo paramMMCarLicensePlateInfo)
    {
      AppMethodBeat.i(187369);
      CarLicensePlateListUI.d(this.sYK).setVisibility(8);
      if (paramMMCarLicensePlateInfo != null)
      {
        Object localObject = paramMMCarLicensePlateInfo.sXr;
        if (localObject != null)
        {
          if (!((Collection)localObject).isEmpty())
          {
            i = 1;
            if (i != 1) {
              break label261;
            }
            CarLicensePlateListUI.c(this.sYK).setVisibility(8);
            CarLicensePlateListUI.b(this.sYK).setVisibility(0);
            localObject = CarLicensePlateListUI.e(this.sYK);
            paramMMCarLicensePlateInfo = paramMMCarLicensePlateInfo.sXr;
            p.k(paramMMCarLicensePlateInfo, "newList");
            if (!((CarLicensePlateListUI.b)localObject).sXr.isEmpty()) {
              break label183;
            }
            if (((Collection)paramMMCarLicensePlateInfo).isEmpty()) {
              break label178;
            }
            i = 1;
            label115:
            if (i != 0)
            {
              ((CarLicensePlateListUI.b)localObject).sXr.addAll((Collection)paramMMCarLicensePlateInfo);
              ((CarLicensePlateListUI.b)localObject).aG(0, paramMMCarLicensePlateInfo.size());
            }
          }
          for (;;)
          {
            paramMMCarLicensePlateInfo = CarLicensePlateListUI.f(this.sYK);
            if (paramMMCarLicensePlateInfo == null) {
              break label255;
            }
            if (paramMMCarLicensePlateInfo.sYY != true) {
              break label332;
            }
            this.sYK.finish();
            AppMethodBeat.o(187369);
            return;
            i = 0;
            break;
            label178:
            i = 0;
            break label115;
            label183:
            h.b localb = h.a((h.a)new CarLicensePlateListUI.c(new ArrayList((Collection)((CarLicensePlateListUI.b)localObject).sXr), new ArrayList((Collection)paramMMCarLicensePlateInfo)), true);
            ((CarLicensePlateListUI.b)localObject).sXr.clear();
            ((CarLicensePlateListUI.b)localObject).sXr.addAll((Collection)paramMMCarLicensePlateInfo);
            localb.a((RecyclerView.a)localObject);
          }
          label255:
          AppMethodBeat.o(187369);
          return;
        }
      }
      label261:
      CarLicensePlateListUI.c(this.sYK).setVisibility(0);
      CarLicensePlateListUI.b(this.sYK).setVisibility(8);
      paramMMCarLicensePlateInfo = CarLicensePlateListUI.e(this.sYK);
      if (!((Collection)paramMMCarLicensePlateInfo.sXr).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramMMCarLicensePlateInfo.aH(0, paramMMCarLicensePlateInfo.sXr.size());
          paramMMCarLicensePlateInfo.sXr.clear();
        }
        label332:
        AppMethodBeat.o(187369);
        return;
      }
    }
    
    public final void a(CarLicensePlateListViewContract.b.a parama)
    {
      AppMethodBeat.i(187366);
      p.k(parama, "request");
      if (CarLicensePlateListViewContract.b.a.sYT == parama)
      {
        CarLicensePlateListUI.d(this.sYK).setVisibility(0);
        CarLicensePlateListUI.c(this.sYK).setVisibility(8);
        CarLicensePlateListUI.b(this.sYK).setVisibility(8);
      }
      AppMethodBeat.o(187366);
    }
    
    public final ak bQu()
    {
      return this.sYK.oDi;
    }
    
    public final Activity bQv()
    {
      return (Activity)this.sYK;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1$init$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(CarLicensePlateListUI.f paramf) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(187242);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1$init$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        CarLicensePlateListUI.a(this.sYR.sYK).cFF();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1$init$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187242);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1$init$1$2$footer$1$1", "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1$$special$$inlined$apply$lambda$1", "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1$$special$$inlined$apply$lambda$3"})
    static final class b
      implements View.OnClickListener
    {
      b(ViewGroup paramViewGroup, CarLicensePlateListUI.f paramf) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(186439);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1$init$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        CarLicensePlateListUI.a(this.sYR.sYK).cFF();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1$init$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186439);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListUI
 * JD-Core Version:    0.7.0.1
 */