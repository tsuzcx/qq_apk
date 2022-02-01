package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
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
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "currentSelectedUserId", "", "hadShowCloseNote", "", "isOpen", "mOriginalToCompare", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mUserinfoListItems", "mainSwitch", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "userInfoList", "Landroidx/recyclerview/widget/RecyclerView;", "wxaUserInfoListOperationController", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController;", "checkUserInfoModified", "finish", "", "getLayoutId", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "processMainSwitchClick", "check", "showUserInfoPanel", "open", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandUserInfoAuthorizeUI
  extends MMActivity
{
  public static final AppBrandUserInfoAuthorizeUI.a qZO;
  private HashMap _$_findViewCache;
  private boolean gZ;
  private s jhZ;
  private final List<h.a> qZH;
  private List<h.a> qZI;
  private boolean qZJ;
  private int qZK;
  private MMSwitchBtn qZL;
  private com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b qZM;
  private RecyclerView qZN;
  
  static
  {
    AppMethodBeat.i(180683);
    qZO = new AppBrandUserInfoAuthorizeUI.a((byte)0);
    AppMethodBeat.o(180683);
  }
  
  public AppBrandUserInfoAuthorizeUI()
  {
    AppMethodBeat.i(180682);
    this.qZH = ((List)new ArrayList());
    AppMethodBeat.o(180682);
  }
  
  private final boolean ckr()
  {
    AppMethodBeat.i(180681);
    Object localObject1 = this.qZI;
    boolean bool2;
    if ((localObject1 == null) || (((List)localObject1).size() != this.qZH.size()))
    {
      bool2 = true;
      AppMethodBeat.o(180681);
      return bool2;
    }
    localObject1 = ((Iterable)this.qZH).iterator();
    boolean bool1 = false;
    for (;;)
    {
      bool2 = bool1;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      h.a locala1 = (h.a)((Iterator)localObject1).next();
      Object localObject2 = this.qZI;
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
          h.a locala2 = (h.a)((Iterator)localObject2).next();
          if (locala1.oCE == locala2.oCE) {
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
  
  private final void jN(boolean paramBoolean)
  {
    AppMethodBeat.i(180679);
    View localView = findViewById(au.f.user_info_panel);
    p.j(localView, "this.findViewById<View>(R.id.user_info_panel)");
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
    AppMethodBeat.i(282743);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(282743);
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
    localIntent.putExtra("key_result_user_info_list_been_modified", ckr());
    localIntent.putExtra("key_result_is_open", this.gZ);
    localIntent.putExtra("key_result_selected_user_id", this.qZK);
    setResult(-1, localIntent);
    super.finish();
    AppMethodBeat.o(180680);
  }
  
  public final int getLayoutId()
  {
    return au.g.app_brand_user_info_authorize_ui;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(180678);
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.qZM;
    if (paramConfiguration == null) {
      p.bGy("wxaUserInfoListOperationController");
    }
    if (paramConfiguration != null)
    {
      paramConfiguration = paramConfiguration.oEa;
      if (paramConfiguration != null)
      {
        paramConfiguration.cFD();
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
    setMMTitle(au.i.appbrand_setting_usernifo_authrize_list_title);
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
      this.gZ = bool;
      jN(this.gZ);
      if ((localObject1 != null) && (str != null)) {
        break label166;
      }
      com.tencent.d.f.h.ioq();
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
    this.qZK = ((MMUserAvatarInfo)localObject1).oDQ;
    paramBundle = findViewById(au.f.main_switch);
    Object localObject2 = (MMSwitchBtn)paramBundle;
    ((MMSwitchBtn)localObject2).setCheck(this.gZ);
    ((MMSwitchBtn)localObject2).setSwitchListener((MMSwitchBtn.a)new d(this));
    p.j(paramBundle, "this.findViewById<MMSwit…)\n            }\n        }");
    this.qZL = ((MMSwitchBtn)paramBundle);
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
      p.j(paramBundle, "intent.run { extras?.get…ing(KEY_NICKNAME) } ?: \"\"");
      localObject2 = findViewById(au.f.desc);
      p.j(localObject2, "this.findViewById<TextView>(R.id.desc)");
      localObject2 = (TextView)localObject2;
      Object localObject3 = af.aaBG;
      localObject3 = getString(au.i.appbrand_setting_usernifo_authrize_desc);
      p.j(localObject3, "getString(R.string.appbr…g_usernifo_authrize_desc)");
      localObject3 = String.format((String)localObject3, Arrays.copyOf(new Object[] { paramBundle }, 1));
      p.j(localObject3, "java.lang.String.format(format, *args)");
      ((TextView)localObject2).setText((CharSequence)localObject3);
      localObject2 = findViewById(au.f.user_Info_desc);
      p.j(localObject2, "this.findViewById<TextView>(R.id.user_Info_desc)");
      localObject2 = (TextView)localObject2;
      localObject3 = af.aaBG;
      localObject3 = getString(au.i.appbrand_setting_usernifo_authrize_user_info_list_desc);
      p.j(localObject3, "getString(R.string.appbr…rize_user_info_list_desc)");
      paramBundle = String.format((String)localObject3, Arrays.copyOf(new Object[] { paramBundle }, 1));
      p.j(paramBundle, "java.lang.String.format(format, *args)");
      ((TextView)localObject2).setText((CharSequence)paramBundle);
      paramBundle = findViewById(au.f.user_info_list);
      localObject2 = (RecyclerView)paramBundle;
      p.j(localObject2, "it");
      ((RecyclerView)localObject2).setNestedScrollingEnabled(false);
      p.j(paramBundle, "this.findViewById<Recycl…Enabled = false\n        }");
      this.qZN = ((RecyclerView)paramBundle);
      this.qZM = new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b((Context)this, (MMUserAvatarInfo)localObject1, "", (b.c)new f(this, str));
      paramBundle = this.qZM;
      if (paramBundle == null) {
        p.bGy("wxaUserInfoListOperationController");
      }
      paramBundle.oDZ = ((a.a)new g(this));
      paramBundle = new com.tencent.mm.plugin.appbrand.widget.dialog.h(this.qZH);
      localObject1 = this.qZN;
      if (localObject1 == null) {
        p.bGy("userInfoList");
      }
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)paramBundle);
      localObject1 = this.qZN;
      if (localObject1 == null) {
        p.bGy("userInfoList");
      }
      getContext();
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      localObject1 = this.qZN;
      if (localObject1 == null) {
        p.bGy("userInfoList");
      }
      ((RecyclerView)localObject1).setItemAnimator(null);
      paramBundle.rsu = ((h.d)new b(this));
      paramBundle.qcl = ((h.b)new c(this));
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
    s locals = this.jhZ;
    if (locals != null)
    {
      locals.dismiss();
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$7$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "index", "", "plugin-appbrand-integration_release"})
  public static final class b
    implements h.d
  {
    b(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI) {}
    
    public final void a(View paramView, h.a parama, int paramInt)
    {
      AppMethodBeat.i(275107);
      p.k(paramView, "v");
      p.k(parama, "item");
      parama = AppBrandUserInfoAuthorizeUI.e(this.qZP);
      TouchableLayout.a locala = TouchableLayout.YOD;
      int i = TouchableLayout.igZ();
      locala = TouchableLayout.YOD;
      parama.a(paramView, paramInt, i, TouchableLayout.iha());
      AppMethodBeat.o(275107);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$7$2", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "plugin-appbrand-integration_release"})
  public static final class c
    implements h.b
  {
    c(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI) {}
    
    public final void a(h.a parama)
    {
      AppMethodBeat.i(283827);
      p.k(parama, "item");
      AppBrandUserInfoAuthorizeUI.e(this.qZP).b(parama);
      AppBrandUserInfoAuthorizeUI.a(this.qZP, parama.oCE);
      AppMethodBeat.o(283827);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onStatusChange", "com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$3$1"})
  static final class d
    implements MMSwitchBtn.a
  {
    d(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(180663);
      AppBrandUserInfoAuthorizeUI.a(this.qZP, paramBoolean);
      AppMethodBeat.o(180663);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(180664);
      this.qZP.finish();
      AppMethodBeat.o(180664);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$5", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "onCreateUserActionUpdate", "", "action", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener$CreateUserAction;", "onItemListChanged", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "updateAddNewAvatarEntry", "isBan", "", "reachMaxCount", "limitWording", "", "avatarWording", "goAddUserPage", "Lkotlin/Function2;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
  public static final class f
    implements b.c
  {
    f(String paramString) {}
    
    public final void a(b.c.a parama)
    {
      AppMethodBeat.i(269414);
      p.k(parama, "action");
      AppMethodBeat.o(269414);
    }
    
    public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, final m<? super Activity, ? super String, x> paramm)
    {
      AppMethodBeat.i(269413);
      p.k(paramString1, "limitWording");
      p.k(paramString2, "avatarWording");
      p.k(paramm, "goAddUserPage");
      paramString1 = (TextView)this.qZP.findViewById(au.f.user_reach_max_count_tip);
      paramString2 = this.qZP.findViewById(au.f.create_new_user);
      if ((paramBoolean1) || (paramBoolean2)) {
        if (!paramBoolean1)
        {
          p.j(paramString1, "userReachMaxCountTip");
          paramString1.setVisibility(0);
          p.j(paramString2, "createNewUser");
          paramString2.setVisibility(8);
        }
      }
      for (;;)
      {
        paramString2.setOnClickListener((View.OnClickListener)new a(this, paramm));
        AppMethodBeat.o(269413);
        return;
        p.j(paramString1, "userReachMaxCountTip");
        paramString1.setVisibility(8);
        p.j(paramString2, "createNewUser");
        paramString2.setVisibility(8);
        continue;
        p.j(paramString1, "userReachMaxCountTip");
        paramString1.setVisibility(8);
        p.j(paramString2, "createNewUser");
        paramString2.setVisibility(0);
      }
    }
    
    public final void bx(List<h.a> paramList)
    {
      AppMethodBeat.i(269415);
      p.k(paramList, "items");
      if (AppBrandUserInfoAuthorizeUI.a(this.qZP) == null) {
        AppBrandUserInfoAuthorizeUI.a(this.qZP, (List)new ArrayList((Collection)paramList));
      }
      AppBrandUserInfoAuthorizeUI.b(this.qZP).clear();
      AppBrandUserInfoAuthorizeUI.b(this.qZP).addAll((Collection)paramList);
      paramList = AppBrandUserInfoAuthorizeUI.c(this.qZP).getAdapter();
      if (paramList != null)
      {
        paramList.notifyDataSetChanged();
        AppMethodBeat.o(269415);
        return;
      }
      AppMethodBeat.o(269415);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(AppBrandUserInfoAuthorizeUI.f paramf, m paramm) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(279065);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$5$updateAddNewAvatarEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramView = paramm;
        localObject = this.qZQ.qZP.getContext();
        p.j(localObject, "context");
        paramView.invoke(localObject, this.qZQ.cBD);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$5$updateAddNewAvatarEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279065);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$6", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "onResult", "", "ret", "", "onStart", "plugin-appbrand-integration_release"})
  public static final class g
    implements a.a
  {
    public final void bQw()
    {
      AppMethodBeat.i(284622);
      s locals = AppBrandUserInfoAuthorizeUI.d(this.qZP);
      if (locals != null)
      {
        locals.dismiss();
        AppMethodBeat.o(284622);
        return;
      }
      AppMethodBeat.o(284622);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(284621);
      if (AppBrandUserInfoAuthorizeUI.d(this.qZP) == null)
      {
        localObject = this.qZP;
        Context localContext = (Context)this.qZP.getContext();
        this.qZP.getString(au.i.app_tip);
        AppBrandUserInfoAuthorizeUI.a((AppBrandUserInfoAuthorizeUI)localObject, com.tencent.mm.ui.base.h.a(localContext, 3, this.qZP.getString(au.i.appbrand_setting_do_delete), false, (DialogInterface.OnCancelListener)AppBrandUserInfoAuthorizeUI.g.a.qZS));
      }
      Object localObject = AppBrandUserInfoAuthorizeUI.d(this.qZP);
      if (localObject != null)
      {
        ((s)localObject).show();
        AppMethodBeat.o(284621);
        return;
      }
      AppMethodBeat.o(284621);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    k(AppBrandUserInfoAuthorizeUI paramAppBrandUserInfoAuthorizeUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "invoke"})
  static final class l
    extends q
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