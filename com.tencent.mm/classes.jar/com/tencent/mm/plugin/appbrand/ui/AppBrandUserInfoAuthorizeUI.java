package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import d.g.a.m;
import d.g.b.k;
import d.g.b.z;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "currentSelectedUserId", "", "hadShowCloseNote", "", "isOpen", "mOriginalToCompare", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mUserinfoListItems", "mainSwitch", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "wxaUserInfoListOperationController", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController;", "checkUserInfoModified", "finish", "", "getLayoutId", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "processMainSwitchClick", "check", "showUserInfoPanel", "open", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandUserInfoAuthorizeUI
  extends MMActivity
{
  public static final AppBrandUserInfoAuthorizeUI.a lDu;
  private boolean SE;
  private HashMap _$_findViewCache;
  private p ftP;
  private final List<o.a> lDo;
  private List<o.a> lDp;
  private boolean lDq;
  private int lDr;
  private MMSwitchBtn lDs;
  private b lDt;
  
  static
  {
    AppMethodBeat.i(180683);
    lDu = new AppBrandUserInfoAuthorizeUI.a((byte)0);
    AppMethodBeat.o(180683);
  }
  
  public AppBrandUserInfoAuthorizeUI()
  {
    AppMethodBeat.i(180682);
    this.lDo = ((List)new ArrayList());
    AppMethodBeat.o(180682);
  }
  
  private final boolean boG()
  {
    AppMethodBeat.i(180681);
    Object localObject1 = this.lDp;
    boolean bool2;
    if ((localObject1 == null) || (((List)localObject1).size() != this.lDo.size())) {
      bool2 = true;
    }
    boolean bool1;
    do
    {
      AppMethodBeat.o(180681);
      return bool2;
      localObject1 = ((Iterable)this.lDo).iterator();
      bool1 = false;
      bool2 = bool1;
    } while (!((Iterator)localObject1).hasNext());
    o.a locala1 = (o.a)((Iterator)localObject1).next();
    Object localObject2 = this.lDp;
    label112:
    int j;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      int i = 0;
      j = i;
      if (!((Iterator)localObject2).hasNext()) {
        break label156;
      }
      o.a locala2 = (o.a)((Iterator)localObject2).next();
      if (locala1.jEi != locala2.jEi) {
        break label168;
      }
      i = 1;
    }
    label156:
    label168:
    for (;;)
    {
      break label112;
      j = 0;
      if (j == 0) {
        bool1 = true;
      }
      for (;;)
      {
        break;
      }
    }
  }
  
  private final void hc(boolean paramBoolean)
  {
    AppMethodBeat.i(180679);
    LinearLayout localLinearLayout = (LinearLayout)_$_findCachedViewById(2131306240);
    k.g(localLinearLayout, "user_info_panel");
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      AppMethodBeat.o(180679);
      return;
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(180688);
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
    AppMethodBeat.o(180688);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(180680);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_user_info_list_been_modified", boG());
    localIntent.putExtra("key_result_is_open", this.SE);
    localIntent.putExtra("key_result_selected_user_id", this.lDr);
    setResult(-1, localIntent);
    super.finish();
    AppMethodBeat.o(180680);
  }
  
  public final int getLayoutId()
  {
    return 2131493070;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(180678);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.lDt;
    if (paramConfiguration == null) {
      k.aPZ("wxaUserInfoListOperationController");
    }
    if (paramConfiguration != null)
    {
      paramConfiguration = paramConfiguration.jEQ;
      if (paramConfiguration != null)
      {
        paramConfiguration.eVf();
        AppMethodBeat.o(180678);
        return;
      }
      AppMethodBeat.o(180678);
      return;
    }
    AppMethodBeat.o(180678);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(180676);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    setMMTitle(2131756046);
    paramBundle = getIntent().getExtras();
    Object localObject1;
    final String str;
    if (paramBundle != null)
    {
      localObject1 = (MMUserAvatarInfo)paramBundle.getParcelable("key_user_info");
      paramBundle = getIntent().getExtras();
      if (paramBundle == null) {
        break label150;
      }
      str = paramBundle.getString("key_app_id");
      label77:
      paramBundle = getIntent().getExtras();
      if (paramBundle == null) {
        break label156;
      }
      paramBundle = Boolean.valueOf(paramBundle.getBoolean("key_is_state_open"));
      label100:
      if (paramBundle == null) {
        break label161;
      }
    }
    label150:
    label156:
    label161:
    for (boolean bool = paramBundle.booleanValue();; bool = false)
    {
      this.SE = bool;
      hc(this.SE);
      if ((localObject1 != null) && (str != null)) {
        break label166;
      }
      com.tencent.d.f.h.fmz();
      finish();
      AppMethodBeat.o(180676);
      return;
      localObject1 = null;
      break;
      str = null;
      break label77;
      paramBundle = null;
      break label100;
    }
    label166:
    this.lDr = ((MMUserAvatarInfo)localObject1).jEG;
    paramBundle = _$_findCachedViewById(2131301997);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMSwitchBtn");
      AppMethodBeat.o(180676);
      throw paramBundle;
    }
    paramBundle = (MMSwitchBtn)paramBundle;
    paramBundle.setCheck(this.SE);
    paramBundle.setSwitchListener((MMSwitchBtn.a)new d(this));
    this.lDs = paramBundle;
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_nickname");
      if (paramBundle != null) {
        break label645;
      }
      paramBundle = "";
    }
    label645:
    for (;;)
    {
      TextView localTextView = (TextView)_$_findCachedViewById(2131298996);
      k.g(localTextView, "desc");
      Object localObject2 = z.Jhz;
      localObject2 = getString(2131756045);
      k.g(localObject2, "getString(R.string.appbr…g_usernifo_authrize_desc)");
      localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { paramBundle }, 1));
      k.g(localObject2, "java.lang.String.format(format, *args)");
      localTextView.setText((CharSequence)localObject2);
      localTextView = (TextView)_$_findCachedViewById(2131306230);
      k.g(localTextView, "user_Info_desc");
      localObject2 = z.Jhz;
      localObject2 = getString(2131756049);
      k.g(localObject2, "getString(R.string.appbr…rize_user_info_list_desc)");
      paramBundle = String.format((String)localObject2, Arrays.copyOf(new Object[] { paramBundle }, 1));
      k.g(paramBundle, "java.lang.String.format(format, *args)");
      localTextView.setText((CharSequence)paramBundle);
      paramBundle = (RecyclerView)_$_findCachedViewById(2131306239);
      k.g(paramBundle, "user_info_list");
      paramBundle.setNestedScrollingEnabled(false);
      this.lDt = new b((Context)this, (MMUserAvatarInfo)localObject1, "", (b.c)new f(this, str));
      paramBundle = this.lDt;
      if (paramBundle == null) {
        k.aPZ("wxaUserInfoListOperationController");
      }
      paramBundle.jEP = ((a.a)new g(this));
      paramBundle = new o(this.lDo);
      localObject1 = (RecyclerView)_$_findCachedViewById(2131306239);
      k.g(localObject1, "user_info_list");
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)paramBundle);
      localObject1 = (RecyclerView)_$_findCachedViewById(2131306239);
      k.g(localObject1, "user_info_list");
      getContext();
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
      localObject1 = (RecyclerView)_$_findCachedViewById(2131306239);
      k.g(localObject1, "user_info_list");
      ((RecyclerView)localObject1).setItemAnimator(null);
      paramBundle.lZF = ((o.c)new b(this));
      paramBundle.lZr = ((o.b)new c(this));
      AppMethodBeat.o(180676);
      return;
      paramBundle = null;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(180677);
    super.onDestroy();
    p localp = this.ftP;
    if (localp != null)
    {
      localp.dismiss();
      AppMethodBeat.o(180677);
      return;
    }
    AppMethodBeat.o(180677);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$6$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "index", "", "plugin-appbrand-integration_release"})
  public static final class b
    implements o.c
  {
    b(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI) {}
    
    public final void a(View paramView, o.a parama, int paramInt)
    {
      AppMethodBeat.i(180661);
      k.h(paramView, "v");
      k.h(parama, "item");
      parama = AppBrandUserInfoAuthorizeUI.d(this.lDv);
      TouchableLayout.a locala = TouchableLayout.HYe;
      int i = TouchableLayout.fiK();
      locala = TouchableLayout.HYe;
      parama.a(paramView, paramInt, i, TouchableLayout.fiL());
      AppMethodBeat.o(180661);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$6$2", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "plugin-appbrand-integration_release"})
  public static final class c
    implements o.b
  {
    c(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI) {}
    
    public final void a(o.a parama)
    {
      AppMethodBeat.i(180662);
      k.h(parama, "item");
      AppBrandUserInfoAuthorizeUI.d(this.lDv).b(parama);
      AppBrandUserInfoAuthorizeUI.a(this.lDv, parama.jEi);
      AppMethodBeat.o(180662);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "onStatusChange", "com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$3$1"})
  static final class d
    implements MMSwitchBtn.a
  {
    d(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(180663);
      AppBrandUserInfoAuthorizeUI.a(this.lDv, paramBoolean);
      AppMethodBeat.o(180663);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(180664);
      this.lDv.finish();
      AppMethodBeat.o(180664);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$4", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "onItemListChanged", "", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "updateAddNewAvatarEntry", "isBan", "", "reachMaxCount", "limitWording", "", "avatarWording", "goAddUserPage", "Lkotlin/Function2;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
  public static final class f
    implements b.c
  {
    f(String paramString) {}
    
    public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, final m<? super Activity, ? super String, y> paramm)
    {
      AppMethodBeat.i(180666);
      k.h(paramString1, "limitWording");
      k.h(paramString2, "avatarWording");
      k.h(paramm, "goAddUserPage");
      if ((paramBoolean1) || (paramBoolean2)) {
        if (!paramBoolean1)
        {
          paramString1 = (TextView)this.lDv._$_findCachedViewById(2131306247);
          k.g(paramString1, "user_reach_max_count_tip");
          paramString1.setVisibility(0);
          paramString1 = (LinearLayout)this.lDv._$_findCachedViewById(2131298856);
          k.g(paramString1, "create_new_user");
          paramString1.setVisibility(8);
        }
      }
      for (;;)
      {
        ((LinearLayout)this.lDv._$_findCachedViewById(2131298856)).setOnClickListener((View.OnClickListener)new a(this, paramm));
        AppMethodBeat.o(180666);
        return;
        paramString1 = (TextView)this.lDv._$_findCachedViewById(2131306247);
        k.g(paramString1, "user_reach_max_count_tip");
        paramString1.setVisibility(8);
        paramString1 = (LinearLayout)this.lDv._$_findCachedViewById(2131298856);
        k.g(paramString1, "create_new_user");
        paramString1.setVisibility(8);
        continue;
        paramString1 = (TextView)this.lDv._$_findCachedViewById(2131306247);
        k.g(paramString1, "user_reach_max_count_tip");
        paramString1.setVisibility(8);
        paramString1 = (LinearLayout)this.lDv._$_findCachedViewById(2131298856);
        k.g(paramString1, "create_new_user");
        paramString1.setVisibility(0);
      }
    }
    
    public final void bl(List<o.a> paramList)
    {
      AppMethodBeat.i(180667);
      k.h(paramList, "items");
      if (AppBrandUserInfoAuthorizeUI.a(this.lDv) == null) {
        AppBrandUserInfoAuthorizeUI.a(this.lDv, (List)new ArrayList((Collection)paramList));
      }
      AppBrandUserInfoAuthorizeUI.b(this.lDv).clear();
      AppBrandUserInfoAuthorizeUI.b(this.lDv).addAll((Collection)paramList);
      paramList = (RecyclerView)this.lDv._$_findCachedViewById(2131306239);
      k.g(paramList, "user_info_list");
      paramList = paramList.getAdapter();
      if (paramList != null)
      {
        paramList.notifyDataSetChanged();
        AppMethodBeat.o(180667);
        return;
      }
      AppMethodBeat.o(180667);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(AppBrandUserInfoAuthorizeUI.f paramf, m paramm) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(180665);
        paramView = paramm;
        AppCompatActivity localAppCompatActivity = this.lDw.lDv.getContext();
        k.g(localAppCompatActivity, "context");
        paramView.n(localAppCompatActivity, this.lDw.iQm);
        AppMethodBeat.o(180665);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$5", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "onResult", "", "ret", "", "onStart", "plugin-appbrand-integration_release"})
  public static final class g
    implements a.a
  {
    public final void aYu()
    {
      AppMethodBeat.i(180670);
      p localp = AppBrandUserInfoAuthorizeUI.c(this.lDv);
      if (localp != null)
      {
        localp.dismiss();
        AppMethodBeat.o(180670);
        return;
      }
      AppMethodBeat.o(180670);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(180669);
      if (AppBrandUserInfoAuthorizeUI.c(this.lDv) == null)
      {
        localObject = this.lDv;
        Context localContext = (Context)this.lDv.getContext();
        this.lDv.getString(2131755906);
        AppBrandUserInfoAuthorizeUI.a((AppBrandUserInfoAuthorizeUI)localObject, com.tencent.mm.ui.base.h.a(localContext, 3, this.lDv.getString(2131756041), false, (DialogInterface.OnCancelListener)AppBrandUserInfoAuthorizeUI.g.a.lDy));
      }
      Object localObject = AppBrandUserInfoAuthorizeUI.c(this.lDv);
      if (localObject != null)
      {
        ((p)localObject).show();
        AppMethodBeat.o(180669);
        return;
      }
      AppMethodBeat.o(180669);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    k(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    l(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUserInfoAuthorizeUI
 * JD-Core Version:    0.7.0.1
 */