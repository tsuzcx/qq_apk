package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "currentSelectedUserId", "", "hadShowCloseNote", "", "isOpen", "mOriginalToCompare", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mUserinfoListItems", "mainSwitch", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "userInfoList", "Landroid/support/v7/widget/RecyclerView;", "wxaUserInfoListOperationController", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController;", "checkUserInfoModified", "finish", "", "getLayoutId", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "processMainSwitchClick", "check", "showUserInfoPanel", "open", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandUserInfoAuthorizeUI
  extends MMActivity
{
  public static final AppBrandUserInfoAuthorizeUI.a nYe;
  private boolean VC;
  private HashMap _$_findViewCache;
  private com.tencent.mm.ui.base.q gxX;
  private final List<i.a> nXX;
  private List<i.a> nXY;
  private boolean nXZ;
  private int nYa;
  private MMSwitchBtn nYb;
  private com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b nYc;
  private RecyclerView nYd;
  
  static
  {
    AppMethodBeat.i(180683);
    nYe = new AppBrandUserInfoAuthorizeUI.a((byte)0);
    AppMethodBeat.o(180683);
  }
  
  public AppBrandUserInfoAuthorizeUI()
  {
    AppMethodBeat.i(180682);
    this.nXX = ((List)new ArrayList());
    AppMethodBeat.o(180682);
  }
  
  private final boolean bXH()
  {
    AppMethodBeat.i(180681);
    Object localObject1 = this.nXY;
    boolean bool2;
    if ((localObject1 == null) || (((List)localObject1).size() != this.nXX.size()))
    {
      bool2 = true;
      AppMethodBeat.o(180681);
      return bool2;
    }
    localObject1 = ((Iterable)this.nXX).iterator();
    boolean bool1 = false;
    for (;;)
    {
      bool2 = bool1;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      i.a locala1 = (i.a)((Iterator)localObject1).next();
      Object localObject2 = this.nXY;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        int i = 0;
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          i.a locala2 = (i.a)((Iterator)localObject2).next();
          if (locala1.lGW == locala2.lGW) {
            i = 1;
          }
        }
      }
      int j = 0;
      if (j == 0) {
        bool1 = true;
      }
    }
  }
  
  private final void iQ(boolean paramBoolean)
  {
    AppMethodBeat.i(180679);
    View localView = findViewById(2131309640);
    p.g(localView, "this.findViewById<View>(R.id.user_info_panel)");
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(180679);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(229538);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(229538);
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
    localIntent.putExtra("key_result_user_info_list_been_modified", bXH());
    localIntent.putExtra("key_result_is_open", this.VC);
    localIntent.putExtra("key_result_selected_user_id", this.nYa);
    setResult(-1, localIntent);
    super.finish();
    AppMethodBeat.o(180680);
  }
  
  public final int getLayoutId()
  {
    return 2131493110;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(180678);
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.nYc;
    if (paramConfiguration == null) {
      p.btv("wxaUserInfoListOperationController");
    }
    if (paramConfiguration != null)
    {
      paramConfiguration = paramConfiguration.lHR;
      if (paramConfiguration != null)
      {
        paramConfiguration.gNq();
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
    setMMTitle(2131756161);
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
      this.VC = bool;
      iQ(this.VC);
      if ((localObject1 != null) && (str != null)) {
        break label166;
      }
      com.tencent.e.f.h.hkS();
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
    this.nYa = ((MMUserAvatarInfo)localObject1).lHH;
    paramBundle = findViewById(2131304334);
    Object localObject2 = (MMSwitchBtn)paramBundle;
    ((MMSwitchBtn)localObject2).setCheck(this.VC);
    ((MMSwitchBtn)localObject2).setSwitchListener((MMSwitchBtn.a)new d(this));
    p.g(paramBundle, "this.findViewById<MMSwit…)\n            }\n        }");
    this.nYb = ((MMSwitchBtn)paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_nickname");
      if (paramBundle != null) {
        break label658;
      }
      paramBundle = "";
    }
    label658:
    for (;;)
    {
      p.g(paramBundle, "intent.run { extras?.get…ing(KEY_NICKNAME) } ?: \"\"");
      localObject2 = findViewById(2131299495);
      p.g(localObject2, "this.findViewById<TextView>(R.id.desc)");
      localObject2 = (TextView)localObject2;
      Object localObject3 = ae.SYK;
      localObject3 = getString(2131756160);
      p.g(localObject3, "getString(R.string.appbr…g_usernifo_authrize_desc)");
      localObject3 = String.format((String)localObject3, Arrays.copyOf(new Object[] { paramBundle }, 1));
      p.g(localObject3, "java.lang.String.format(format, *args)");
      ((TextView)localObject2).setText((CharSequence)localObject3);
      localObject2 = findViewById(2131309629);
      p.g(localObject2, "this.findViewById<TextView>(R.id.user_Info_desc)");
      localObject2 = (TextView)localObject2;
      localObject3 = ae.SYK;
      localObject3 = getString(2131756164);
      p.g(localObject3, "getString(R.string.appbr…rize_user_info_list_desc)");
      paramBundle = String.format((String)localObject3, Arrays.copyOf(new Object[] { paramBundle }, 1));
      p.g(paramBundle, "java.lang.String.format(format, *args)");
      ((TextView)localObject2).setText((CharSequence)paramBundle);
      paramBundle = findViewById(2131309639);
      localObject2 = (RecyclerView)paramBundle;
      p.g(localObject2, "it");
      ((RecyclerView)localObject2).setNestedScrollingEnabled(false);
      p.g(paramBundle, "this.findViewById<Recycl…Enabled = false\n        }");
      this.nYd = ((RecyclerView)paramBundle);
      this.nYc = new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b((Context)this, (MMUserAvatarInfo)localObject1, "", (b.c)new f(this, str));
      paramBundle = this.nYc;
      if (paramBundle == null) {
        p.btv("wxaUserInfoListOperationController");
      }
      paramBundle.lHQ = ((a.a)new g(this));
      paramBundle = new i(this.nXX);
      localObject1 = this.nYd;
      if (localObject1 == null) {
        p.btv("userInfoList");
      }
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)paramBundle);
      localObject1 = this.nYd;
      if (localObject1 == null) {
        p.btv("userInfoList");
      }
      getContext();
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      localObject1 = this.nYd;
      if (localObject1 == null) {
        p.btv("userInfoList");
      }
      ((RecyclerView)localObject1).setItemAnimator(null);
      paramBundle.oqX = ((i.d)new b(this));
      paramBundle.nbX = ((i.b)new c(this));
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
    com.tencent.mm.ui.base.q localq = this.gxX;
    if (localq != null)
    {
      localq.dismiss();
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$7$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "index", "", "plugin-appbrand-integration_release"})
  public static final class b
    implements i.d
  {
    b(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI) {}
    
    public final void a(View paramView, i.a parama, int paramInt)
    {
      AppMethodBeat.i(229529);
      p.h(paramView, "v");
      p.h(parama, "item");
      parama = AppBrandUserInfoAuthorizeUI.e(this.nYf);
      TouchableLayout.a locala = TouchableLayout.Rni;
      int i = TouchableLayout.hfC();
      locala = TouchableLayout.Rni;
      parama.a(paramView, paramInt, i, TouchableLayout.hfD());
      AppMethodBeat.o(229529);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$7$2", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "plugin-appbrand-integration_release"})
  public static final class c
    implements i.b
  {
    c(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI) {}
    
    public final void a(i.a parama)
    {
      AppMethodBeat.i(229530);
      p.h(parama, "item");
      AppBrandUserInfoAuthorizeUI.e(this.nYf).b(parama);
      AppBrandUserInfoAuthorizeUI.a(this.nYf, parama.lGW);
      AppMethodBeat.o(229530);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onStatusChange", "com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$3$1"})
  static final class d
    implements MMSwitchBtn.a
  {
    d(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(180663);
      AppBrandUserInfoAuthorizeUI.a(this.nYf, paramBoolean);
      AppMethodBeat.o(180663);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(180664);
      this.nYf.finish();
      AppMethodBeat.o(180664);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$5", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "onItemListChanged", "", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "updateAddNewAvatarEntry", "isBan", "", "reachMaxCount", "limitWording", "", "avatarWording", "goAddUserPage", "Lkotlin/Function2;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
  public static final class f
    implements b.c
  {
    f(String paramString) {}
    
    public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, final m<? super Activity, ? super String, x> paramm)
    {
      AppMethodBeat.i(229532);
      p.h(paramString1, "limitWording");
      p.h(paramString2, "avatarWording");
      p.h(paramm, "goAddUserPage");
      paramString1 = (TextView)this.nYf.findViewById(2131309646);
      paramString2 = this.nYf.findViewById(2131299323);
      if ((paramBoolean1) || (paramBoolean2)) {
        if (!paramBoolean1)
        {
          p.g(paramString1, "userReachMaxCountTip");
          paramString1.setVisibility(0);
          p.g(paramString2, "createNewUser");
          paramString2.setVisibility(8);
        }
      }
      for (;;)
      {
        paramString2.setOnClickListener((View.OnClickListener)new a(this, paramm));
        AppMethodBeat.o(229532);
        return;
        p.g(paramString1, "userReachMaxCountTip");
        paramString1.setVisibility(8);
        p.g(paramString2, "createNewUser");
        paramString2.setVisibility(8);
        continue;
        p.g(paramString1, "userReachMaxCountTip");
        paramString1.setVisibility(8);
        p.g(paramString2, "createNewUser");
        paramString2.setVisibility(0);
      }
    }
    
    public final void bz(List<i.a> paramList)
    {
      AppMethodBeat.i(229533);
      p.h(paramList, "items");
      if (AppBrandUserInfoAuthorizeUI.a(this.nYf) == null) {
        AppBrandUserInfoAuthorizeUI.a(this.nYf, (List)new ArrayList((Collection)paramList));
      }
      AppBrandUserInfoAuthorizeUI.b(this.nYf).clear();
      AppBrandUserInfoAuthorizeUI.b(this.nYf).addAll((Collection)paramList);
      paramList = AppBrandUserInfoAuthorizeUI.c(this.nYf).getAdapter();
      if (paramList != null)
      {
        paramList.notifyDataSetChanged();
        AppMethodBeat.o(229533);
        return;
      }
      AppMethodBeat.o(229533);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(AppBrandUserInfoAuthorizeUI.f paramf, m paramm) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(229531);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$5$updateAddNewAvatarEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramView = paramm;
        localObject = this.nYg.nYf.getContext();
        p.g(localObject, "context");
        paramView.invoke(localObject, this.nYg.kPQ);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$5$updateAddNewAvatarEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(229531);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$6", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "onResult", "", "ret", "", "onStart", "plugin-appbrand-integration_release"})
  public static final class g
    implements a.a
  {
    public final void bES()
    {
      AppMethodBeat.i(229536);
      com.tencent.mm.ui.base.q localq = AppBrandUserInfoAuthorizeUI.d(this.nYf);
      if (localq != null)
      {
        localq.dismiss();
        AppMethodBeat.o(229536);
        return;
      }
      AppMethodBeat.o(229536);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(229535);
      if (AppBrandUserInfoAuthorizeUI.d(this.nYf) == null)
      {
        localObject = this.nYf;
        Context localContext = (Context)this.nYf.getContext();
        this.nYf.getString(2131755998);
        AppBrandUserInfoAuthorizeUI.a((AppBrandUserInfoAuthorizeUI)localObject, com.tencent.mm.ui.base.h.a(localContext, 3, this.nYf.getString(2131756156), false, (DialogInterface.OnCancelListener)AppBrandUserInfoAuthorizeUI.g.a.nYi));
      }
      Object localObject = AppBrandUserInfoAuthorizeUI.d(this.nYf);
      if (localObject != null)
      {
        ((com.tencent.mm.ui.base.q)localObject).show();
        AppMethodBeat.o(229535);
        return;
      }
      AppMethodBeat.o(229535);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    k(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    l(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUserInfoAuthorizeUI
 * JD-Core Version:    0.7.0.1
 */