package com.tencent.mm.plugin.car_license_plate.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
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
import com.tencent.mm.plugin.car_license_plate.a.e.a;
import com.tencent.mm.plugin.car_license_plate.api.entity.MMCarLicensePlateInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.TouchableLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateBaseActivity;", "()V", "emptyView", "Landroid/view/View;", "loadingView", "presenter", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$Presenter;", "recyclerAdapter", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter;", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/MRecyclerView;", "viewCallback", "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1;", "viewModel", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewModel;", "finish", "", "getLayoutId", "", "onPostCreate", "savedInstanceState", "Landroid/os/Bundle;", "provideCustomActivityContentView", "Companion", "ListAdapter", "ListDiffCallback", "ListItemAnimator", "ListVHText", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CarLicensePlateListUI
  extends CarLicensePlateBaseActivity
{
  public static final CarLicensePlateListUI.a wcX;
  private View njN;
  private View vDA;
  private CarLicensePlateListViewContract.ViewModel wcY;
  private CarLicensePlateListViewContract.a wcZ;
  private MRecyclerView wda;
  private b wdb;
  private final f wdc;
  
  static
  {
    AppMethodBeat.i(277804);
    wcX = new CarLicensePlateListUI.a((byte)0);
    AppMethodBeat.o(277804);
  }
  
  public CarLicensePlateListUI()
  {
    AppMethodBeat.i(277790);
    this.wdc = new f(this);
    AppMethodBeat.o(277790);
  }
  
  private static final boolean a(CarLicensePlateListUI paramCarLicensePlateListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(277792);
    s.u(paramCarLicensePlateListUI, "this$0");
    paramCarLicensePlateListUI.onBackPressed();
    AppMethodBeat.o(277792);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(277831);
    Object localObject = this.wcY;
    Intent localIntent;
    if (localObject != null)
    {
      localIntent = new Intent();
      localObject = ((CarLicensePlateListViewContract.ViewModel)localObject).wdm;
      if (localObject != null) {
        break label64;
      }
    }
    label64:
    for (localObject = null;; localObject = ((MMCarLicensePlateInfo)localObject).wbK)
    {
      localIntent.putExtra("RESULT_KEY_UPDATED_LIST", (Serializable)localObject);
      localObject = ah.aiuX;
      setResult(-1, localIntent);
      super.finish();
      AppMethodBeat.o(277831);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onPostCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(277823);
    super.onPostCreate(paramBundle);
    setMMTitle(getString(a.g.car_license_plate_main_title));
    setActionbarColor(androidx.core.content.a.w((Context)this, a.b.white));
    setBackBtn(new CarLicensePlateListUI..ExternalSyntheticLambda0(this), a.f.actionbar_icon_dark_back);
    setBackBtnColorFilter(a.b.actionbar_title_color);
    getContentView().setBackgroundColor(androidx.core.content.a.w((Context)this, a.b.white));
    getController().setNavigationbarColor(androidx.core.content.a.w((Context)this, a.b.white));
    getIntent().setExtrasClassLoader(CarLicensePlateListViewContract.ViewModel.class.getClassLoader());
    this.wcY = ((CarLicensePlateListViewContract.ViewModel)getIntent().getParcelableExtra("INTENT_KEY_VIEW_MODEL"));
    this.wcZ = ((CarLicensePlateListViewContract.a)new d(e.a.wca));
    paramBundle = this.wcZ;
    Object localObject2;
    if (paramBundle == null)
    {
      s.bIx("presenter");
      paramBundle = null;
      localObject2 = this.wdc;
      ((f)localObject2).init();
      ah localah = ah.aiuX;
      paramBundle.a((CarLicensePlateListViewContract.b)localObject2);
      if (this.wcY == null) {
        break label302;
      }
      localObject2 = this.wcZ;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("presenter");
        paramBundle = null;
      }
      localObject2 = this.wcY;
      s.checkNotNull(localObject2);
      paramBundle.a((CarLicensePlateListViewContract.ViewModel)localObject2);
      label231:
      paramBundle = this.wcZ;
      if (paramBundle != null) {
        break label333;
      }
      s.bIx("presenter");
      paramBundle = localObject1;
      label248:
      this.wcY = paramBundle.cqq();
      paramBundle = this.wcY;
      if ((paramBundle == null) || (paramBundle.wdn != true)) {
        break label336;
      }
    }
    label302:
    label333:
    label336:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.CarLicensePlateListUI", s.X("onPostCreate, viewModel.callbackAfterCreated:", Boolean.valueOf(bool)));
      AppMethodBeat.o(277823);
      return;
      break;
      localObject2 = this.wcZ;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("presenter");
        paramBundle = null;
      }
      paramBundle.diX();
      break label231;
      break label248;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final View provideCustomActivityContentView()
  {
    AppMethodBeat.i(277815);
    View localView = (View)new TouchableLayout((Context)this);
    AppMethodBeat.o(277815);
    return localView;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "(Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI;)V", "plateNoList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "clearPlateNoList", "", "getAdapterPositionForChildView", "", "v", "Landroid/view/View;", "getItemCount", "getItemId", "", "position", "onBindViewHolder", "holder", "onClick", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onLongClick", "", "updatePlateNoList", "newList", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
    extends RecyclerView.a<RecyclerView.v>
    implements View.OnClickListener, View.OnLongClickListener
  {
    final ArrayList<String> wbK;
    
    public b()
    {
      AppMethodBeat.i(277614);
      this.wbK = new ArrayList();
      AppMethodBeat.o(277614);
    }
    
    private static final void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(277631);
      paramContextMenu.add(0, 0, 0, (CharSequence)MMApplicationContext.getString(a.g.app_delete));
      AppMethodBeat.o(277631);
    }
    
    private static final void a(CarLicensePlateListUI paramCarLicensePlateListUI, String paramString, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(277644);
      s.u(paramCarLicensePlateListUI, "this$0");
      paramDialogInterface = CarLicensePlateListUI.a(paramCarLicensePlateListUI);
      paramCarLicensePlateListUI = paramDialogInterface;
      if (paramDialogInterface == null)
      {
        s.bIx("presenter");
        paramCarLicensePlateListUI = null;
      }
      paramCarLicensePlateListUI.akp(paramString);
      AppMethodBeat.o(277644);
    }
    
    private static final void a(CarLicensePlateListUI paramCarLicensePlateListUI, String paramString, MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(277649);
      s.u(paramCarLicensePlateListUI, "this$0");
      if ((paramMenuItem.getGroupId() == 0) && (paramMenuItem.getItemId() == 0)) {
        k.a((Context)paramCarLicensePlateListUI, paramCarLicensePlateListUI.getString(a.g.car_license_plate_delete_double_check_alert_msg), "", paramCarLicensePlateListUI.getString(a.g.app_delete), paramCarLicensePlateListUI.getString(a.g.app_cancel), new CarLicensePlateListUI.b..ExternalSyntheticLambda0(paramCarLicensePlateListUI, paramString), null, a.b.alert_btn_color_warn);
      }
      AppMethodBeat.o(277649);
    }
    
    private final int eK(View paramView)
    {
      Object localObject2 = null;
      AppMethodBeat.i(277621);
      MRecyclerView localMRecyclerView = CarLicensePlateListUI.b(this.wdd);
      Object localObject1 = localMRecyclerView;
      if (localMRecyclerView == null)
      {
        s.bIx("recyclerView");
        localObject1 = null;
      }
      localObject1 = ((MRecyclerView)localObject1).bj(paramView);
      if (localObject1 == null)
      {
        AppMethodBeat.o(277621);
        return -1;
      }
      paramView = CarLicensePlateListUI.b(this.wdd);
      if (paramView == null)
      {
        s.bIx("recyclerView");
        paramView = localObject2;
      }
      for (;;)
      {
        int i = paramView.P((RecyclerView.v)localObject1);
        AppMethodBeat.o(277621);
        return i;
      }
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(277671);
      s.u(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(a.e.car_license_plate_list_item_type_text, paramViewGroup, false);
      paramViewGroup.setOnClickListener((View.OnClickListener)this);
      paramViewGroup.setOnLongClickListener((View.OnLongClickListener)this);
      ah localah = ah.aiuX;
      s.s(paramViewGroup, "from(parent.context).inf…dapter)\n                }");
      paramViewGroup = (RecyclerView.v)new CarLicensePlateListUI.e(paramViewGroup);
      AppMethodBeat.o(277671);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(277683);
      s.u(paramv, "holder");
      paramv = (CarLicensePlateListUI.e)paramv;
      Object localObject = this.wbK.get(paramInt);
      s.s(localObject, "plateNoList[position]");
      localObject = (String)localObject;
      s.u(localObject, "plateNo");
      if (((String)localObject).length() >= 7)
      {
        paramv.wdg.setText((CharSequence)(i.bD((String)localObject, 0, 2) + " · " + i.bD((String)localObject, 2, ((String)localObject).length())));
        paramv.wdg.setContentDescription((CharSequence)localObject);
      }
      AppMethodBeat.o(277683);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(277688);
      int i = this.wbK.size();
      AppMethodBeat.o(277688);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(277715);
      String str = (String)p.ae((List)this.wbK, paramInt);
      if (str == null)
      {
        AppMethodBeat.o(277715);
        return -1L;
      }
      long l = str.hashCode();
      AppMethodBeat.o(277715);
      return l;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(277699);
      Object localObject = new b();
      ((b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
      if (paramView == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(277699);
        return;
      }
      int i = eK(paramView);
      String str = (String)p.ae((List)this.wbK, i);
      paramView = (CharSequence)str;
      if ((paramView == null) || (paramView.length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject = CarLicensePlateListUI.a(this.wdd);
          paramView = (View)localObject;
          if (localObject == null)
          {
            s.bIx("presenter");
            paramView = null;
          }
          paramView.ako(str);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(277699);
        return;
      }
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(277707);
      Object localObject1 = new b();
      ((b)localObject1).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject1).aYj());
      if (paramView == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(277707);
        return false;
      }
      int i = eK(paramView);
      Object localObject2 = (String)p.ae((List)this.wbK, i);
      localObject1 = (CharSequence)localObject2;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (i = 1; i == 0; i = 0)
      {
        localObject1 = new CarLicensePlateListUI.b.a(paramView, paramView.getContext());
        Object localObject3 = this.wdd;
        CarLicensePlateListUI.b..ExternalSyntheticLambda1 localExternalSyntheticLambda1 = CarLicensePlateListUI.b..ExternalSyntheticLambda1.INSTANCE;
        localObject2 = new CarLicensePlateListUI.b..ExternalSyntheticLambda2((CarLicensePlateListUI)localObject3, (String)localObject2);
        localObject3 = TouchableLayout.agKp;
        i = TouchableLayout.jMn();
        localObject3 = TouchableLayout.agKp;
        ((CarLicensePlateListUI.b.a)localObject1).a(paramView, localExternalSyntheticLambda1, (u.i)localObject2, i, TouchableLayout.jMo());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(277707);
        return true;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(277707);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewCallback;", "getActivityForResult", "Landroid/app/Activity;", "getCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "init", "", "onRenderData", "data", "Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "onRenderError", "exception", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiException;", "onRenderLoading", "request", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewCallback$Request;", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements CarLicensePlateListViewContract.b
  {
    f(CarLicensePlateListUI paramCarLicensePlateListUI) {}
    
    private static final void c(CarLicensePlateListUI paramCarLicensePlateListUI, View paramView)
    {
      AppMethodBeat.i(277615);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramCarLicensePlateListUI);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramCarLicensePlateListUI, "this$0");
      paramView = CarLicensePlateListUI.a(paramCarLicensePlateListUI);
      paramCarLicensePlateListUI = paramView;
      if (paramView == null)
      {
        s.bIx("presenter");
        paramCarLicensePlateListUI = null;
      }
      paramCarLicensePlateListUI.diY();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277615);
    }
    
    private static final void d(CarLicensePlateListUI paramCarLicensePlateListUI, View paramView)
    {
      AppMethodBeat.i(277628);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramCarLicensePlateListUI);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramCarLicensePlateListUI, "this$0");
      paramView = CarLicensePlateListUI.a(paramCarLicensePlateListUI);
      paramCarLicensePlateListUI = paramView;
      if (paramView == null)
      {
        s.bIx("presenter");
        paramCarLicensePlateListUI = null;
      }
      paramCarLicensePlateListUI.diY();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277628);
    }
    
    public final void a(com.tencent.mm.plugin.car_license_plate.a.d paramd)
    {
      AppMethodBeat.i(277698);
      s.u(paramd, "exception");
      if ((paramd.wbX instanceof c)) {
        com.tencent.mm.plugin.car_license_plate.b.a.b(paramd);
      }
      AppMethodBeat.o(277698);
    }
    
    public final void a(MMCarLicensePlateInfo paramMMCarLicensePlateInfo)
    {
      Object localObject2 = null;
      int j = 1;
      AppMethodBeat.i(277690);
      View localView = CarLicensePlateListUI.f(this.wdd);
      Object localObject1 = localView;
      if (localView == null)
      {
        s.bIx("loadingView");
        localObject1 = null;
      }
      ((View)localObject1).setVisibility(8);
      if (paramMMCarLicensePlateInfo != null)
      {
        localObject1 = paramMMCarLicensePlateInfo.wbK;
        if (localObject1 != null) {
          if (!((Collection)localObject1).isEmpty())
          {
            i = 1;
            if (i != 1) {
              break label282;
            }
            i = 1;
            label80:
            if (i == 0) {
              break label373;
            }
            localObject2 = CarLicensePlateListUI.e(this.wdd);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("emptyView");
              localObject1 = null;
            }
            ((View)localObject1).setVisibility(8);
            localObject2 = CarLicensePlateListUI.b(this.wdd);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("recyclerView");
              localObject1 = null;
            }
            ((MRecyclerView)localObject1).setVisibility(0);
            localObject2 = CarLicensePlateListUI.d(this.wdd);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("recyclerAdapter");
              localObject1 = null;
            }
            paramMMCarLicensePlateInfo = paramMMCarLicensePlateInfo.wbK;
            s.u(paramMMCarLicensePlateInfo, "newList");
            if (!((CarLicensePlateListUI.b)localObject1).wbK.isEmpty()) {
              break label292;
            }
            if (((Collection)paramMMCarLicensePlateInfo).isEmpty()) {
              break label287;
            }
            i = 1;
            label211:
            if (i != 0)
            {
              ((CarLicensePlateListUI.b)localObject1).wbK.addAll((Collection)paramMMCarLicensePlateInfo);
              ((CarLicensePlateListUI.b)localObject1).bA(0, paramMMCarLicensePlateInfo.size());
            }
            label238:
            paramMMCarLicensePlateInfo = CarLicensePlateListUI.g(this.wdd);
            if ((paramMMCarLicensePlateInfo == null) || (paramMMCarLicensePlateInfo.wdn != true)) {
              break label368;
            }
          }
        }
      }
      label282:
      label287:
      label292:
      label368:
      for (int i = j;; i = 0)
      {
        if (i == 0) {
          break label492;
        }
        this.wdd.finish();
        AppMethodBeat.o(277690);
        return;
        i = 0;
        break;
        i = 0;
        break label80;
        i = 0;
        break label211;
        localObject2 = g.a((g.a)new CarLicensePlateListUI.c(new ArrayList((Collection)((CarLicensePlateListUI.b)localObject1).wbK), new ArrayList((Collection)paramMMCarLicensePlateInfo)), true);
        ((CarLicensePlateListUI.b)localObject1).wbK.clear();
        ((CarLicensePlateListUI.b)localObject1).wbK.addAll((Collection)paramMMCarLicensePlateInfo);
        ((g.b)localObject2).a((RecyclerView.a)localObject1);
        break label238;
      }
      label373:
      localObject1 = CarLicensePlateListUI.e(this.wdd);
      paramMMCarLicensePlateInfo = (MMCarLicensePlateInfo)localObject1;
      if (localObject1 == null)
      {
        s.bIx("emptyView");
        paramMMCarLicensePlateInfo = null;
      }
      paramMMCarLicensePlateInfo.setVisibility(0);
      localObject1 = CarLicensePlateListUI.b(this.wdd);
      paramMMCarLicensePlateInfo = (MMCarLicensePlateInfo)localObject1;
      if (localObject1 == null)
      {
        s.bIx("recyclerView");
        paramMMCarLicensePlateInfo = null;
      }
      paramMMCarLicensePlateInfo.setVisibility(8);
      paramMMCarLicensePlateInfo = CarLicensePlateListUI.d(this.wdd);
      if (paramMMCarLicensePlateInfo == null)
      {
        s.bIx("recyclerAdapter");
        paramMMCarLicensePlateInfo = (MMCarLicensePlateInfo)localObject2;
        if (((Collection)paramMMCarLicensePlateInfo.wbK).isEmpty()) {
          break label501;
        }
      }
      label492:
      label501:
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramMMCarLicensePlateInfo.bB(0, paramMMCarLicensePlateInfo.wbK.size());
          paramMMCarLicensePlateInfo.wbK.clear();
        }
        AppMethodBeat.o(277690);
        return;
        break;
      }
    }
    
    public final void a(CarLicensePlateListViewContract.b.a parama)
    {
      Object localObject = null;
      AppMethodBeat.i(277672);
      s.u(parama, "request");
      if (CarLicensePlateListViewContract.b.a.wdh == parama)
      {
        View localView = CarLicensePlateListUI.f(this.wdd);
        parama = localView;
        if (localView == null)
        {
          s.bIx("loadingView");
          parama = null;
        }
        parama.setVisibility(0);
        localView = CarLicensePlateListUI.e(this.wdd);
        parama = localView;
        if (localView == null)
        {
          s.bIx("emptyView");
          parama = null;
        }
        parama.setVisibility(8);
        parama = CarLicensePlateListUI.b(this.wdd);
        if (parama != null) {
          break label104;
        }
        s.bIx("recyclerView");
        parama = localObject;
      }
      label104:
      for (;;)
      {
        parama.setVisibility(8);
        AppMethodBeat.o(277672);
        return;
      }
    }
    
    public final Activity cqr()
    {
      return (Activity)this.wdd;
    }
    
    public final void init()
    {
      Object localObject3 = null;
      AppMethodBeat.i(277653);
      Object localObject1 = CarLicensePlateListUI.c(this.wdd);
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(277653);
        throw ((Throwable)localObject1);
      }
      ViewGroup localViewGroup = (ViewGroup)localObject1;
      Object localObject4 = this.wdd;
      LayoutInflater.from((Context)localObject4).inflate(a.e.car_license_plate_list_empty_view, localViewGroup, true);
      localObject1 = localViewGroup.findViewById(a.d.car_license_plate_list_empty_view);
      s.s(localObject1, "contentView.findViewById…se_plate_list_empty_view)");
      CarLicensePlateListUI.a((CarLicensePlateListUI)localObject4, (View)localObject1);
      Object localObject2 = CarLicensePlateListUI.e((CarLicensePlateListUI)localObject4);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("emptyView");
        localObject1 = null;
      }
      ((View)localObject1).findViewById(a.d.btn_add).setOnClickListener(new CarLicensePlateListUI.f..ExternalSyntheticLambda1((CarLicensePlateListUI)localObject4));
      LayoutInflater.from((Context)localObject4).inflate(a.e.car_license_plate_list_loading_view, localViewGroup, true);
      localObject1 = localViewGroup.findViewById(a.d.car_license_plate_list_loading_view);
      s.s(localObject1, "contentView.findViewById…_plate_list_loading_view)");
      CarLicensePlateListUI.b((CarLicensePlateListUI)localObject4, (View)localObject1);
      localObject1 = new CarPlateListRecyclerViewBase((Context)localObject4);
      localViewGroup.addView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
      ((CarPlateListRecyclerViewBase)localObject1).setLayoutManager((RecyclerView.LayoutManager)new CarLicensePlateListUI.viewCallback.1.init.1.2.1((CarLicensePlateListUI)localObject4));
      ((CarPlateListRecyclerViewBase)localObject1).setPadding(0, ((CarPlateListRecyclerViewBase)localObject1).getResources().getDimensionPixelSize(a.c.Edge_1_5_A), 0, 0);
      localObject2 = LayoutInflater.from((Context)localObject4).inflate(a.e.car_license_plate_list_item_type_add, (ViewGroup)localObject1, false);
      ((View)localObject2).setOnClickListener(new CarLicensePlateListUI.f..ExternalSyntheticLambda0((CarLicensePlateListUI)localObject4));
      ((CarPlateListRecyclerViewBase)localObject1).et((View)localObject2);
      localObject2 = ah.aiuX;
      CarLicensePlateListUI.a((CarLicensePlateListUI)localObject4, (MRecyclerView)localObject1);
      localObject1 = CarLicensePlateListUI.b(this.wdd);
      if (localObject1 == null)
      {
        s.bIx("recyclerView");
        localObject1 = null;
        ((MRecyclerView)localObject1).setItemAnimator((RecyclerView.f)new CarLicensePlateListUI.d(this.wdd));
        localObject1 = this.wdd;
        localObject2 = new CarLicensePlateListUI.b(this.wdd);
        ((CarLicensePlateListUI.b)localObject2).bf(true);
        localObject4 = ah.aiuX;
        CarLicensePlateListUI.a((CarLicensePlateListUI)localObject1, (CarLicensePlateListUI.b)localObject2);
        localObject1 = CarLicensePlateListUI.b(this.wdd);
        if (localObject1 != null) {
          break label463;
        }
        s.bIx("recyclerView");
        localObject1 = null;
        label370:
        localObject4 = CarLicensePlateListUI.d(this.wdd);
        localObject2 = localObject4;
        if (localObject4 == null)
        {
          s.bIx("recyclerAdapter");
          localObject2 = null;
        }
        ((MRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
        localObject2 = CarLicensePlateListUI.e(this.wdd);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("emptyView");
          localObject1 = null;
        }
        ((View)localObject1).setVisibility(8);
        localObject1 = CarLicensePlateListUI.b(this.wdd);
        if (localObject1 != null) {
          break label466;
        }
        s.bIx("recyclerView");
        localObject1 = localObject3;
      }
      label463:
      label466:
      for (;;)
      {
        ((MRecyclerView)localObject1).setVisibility(8);
        AppMethodBeat.o(277653);
        return;
        break;
        break label370;
      }
    }
    
    public final aq wd()
    {
      return this.wdd.mainScope;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListUI
 * JD-Core Version:    0.7.0.1
 */