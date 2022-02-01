package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c.a;
import com.tencent.mm.plugin.appbrand.ui.a.b.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.view.TouchableLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUserProfileAuthorizeUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "currentSelectedUserId", "", "hadShowCloseNote", "", "isOpen", "mOriginalToCompare", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mUserinfoListItems", "mainSwitch", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "userInfoList", "Landroidx/recyclerview/widget/RecyclerView;", "wxaUserInfoListOperationController", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController;", "checkUserInfoModified", "finish", "", "getLayoutId", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "processMainSwitchClick", "check", "showUserInfoPanel", "open", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandUserProfileAuthorizeUI
  extends MMActivity
{
  public static final AppBrandUserProfileAuthorizeUI.a ufQ;
  private boolean hU;
  private w lKp;
  private final List<k.a> ufH;
  private List<k.a> ufI;
  private boolean ufJ;
  private int ufK;
  private MMSwitchBtn ufL;
  private com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b ufM;
  private RecyclerView ufN;
  
  static
  {
    AppMethodBeat.i(322354);
    ufQ = new AppBrandUserProfileAuthorizeUI.a((byte)0);
    AppMethodBeat.o(322354);
  }
  
  public AppBrandUserProfileAuthorizeUI()
  {
    AppMethodBeat.i(322273);
    this.ufH = ((List)new ArrayList());
    AppMethodBeat.o(322273);
  }
  
  private static final void a(AppBrandUserProfileAuthorizeUI paramAppBrandUserProfileAuthorizeUI, final boolean paramBoolean)
  {
    AppMethodBeat.i(322292);
    s.u(paramAppBrandUserProfileAuthorizeUI, "this$0");
    kotlin.g.a.a locala1 = (kotlin.g.a.a)new f(paramAppBrandUserProfileAuthorizeUI);
    kotlin.g.a.a locala2 = (kotlin.g.a.a)new g(paramAppBrandUserProfileAuthorizeUI, paramBoolean);
    if ((!paramBoolean) && (!paramAppBrandUserProfileAuthorizeUI.ufJ))
    {
      paramAppBrandUserProfileAuthorizeUI.ufJ = true;
      b.a locala = com.tencent.mm.plugin.appbrand.ui.a.b.ugG;
      paramAppBrandUserProfileAuthorizeUI = paramAppBrandUserProfileAuthorizeUI.getContext();
      s.s(paramAppBrandUserProfileAuthorizeUI, "context");
      b.a.a((Context)paramAppBrandUserProfileAuthorizeUI, new AppBrandUserProfileAuthorizeUI..ExternalSyntheticLambda2(locala2), new AppBrandUserProfileAuthorizeUI..ExternalSyntheticLambda1(locala1), new AppBrandUserProfileAuthorizeUI..ExternalSyntheticLambda0(locala1));
      AppMethodBeat.o(322292);
      return;
    }
    locala2.invoke();
    AppMethodBeat.o(322292);
  }
  
  private static final boolean a(AppBrandUserProfileAuthorizeUI paramAppBrandUserProfileAuthorizeUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(322289);
    s.u(paramAppBrandUserProfileAuthorizeUI, "this$0");
    paramAppBrandUserProfileAuthorizeUI.finish();
    AppMethodBeat.o(322289);
    return false;
  }
  
  private static final void b(kotlin.g.a.a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(322306);
    s.u(parama, "$cancelCloseAuthorize");
    parama.invoke();
    AppMethodBeat.o(322306);
  }
  
  private static final void c(kotlin.g.a.a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(322296);
    s.u(parama, "$doCloseAuthorize");
    parama.invoke();
    AppMethodBeat.o(322296);
  }
  
  private final boolean cLG()
  {
    boolean bool = true;
    AppMethodBeat.i(322285);
    Object localObject1 = this.ufI;
    int i;
    if ((localObject1 != null) && (((List)localObject1).size() == this.ufH.size()))
    {
      i = 1;
      if (i != 0) {
        break label55;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(322285);
      return bool;
      i = 0;
      break;
      label55:
      localObject1 = ((Iterable)this.ufH).iterator();
      bool = false;
      while (((Iterator)localObject1).hasNext())
      {
        k.a locala1 = (k.a)((Iterator)localObject1).next();
        Object localObject2 = this.ufI;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          i = 0;
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            k.a locala2 = (k.a)((Iterator)localObject2).next();
            if (locala1.rFX == locala2.rFX) {
              i = 1;
            }
          }
        }
        int j = 0;
        if (j == 0) {
          bool = true;
        }
      }
    }
  }
  
  private static final void d(kotlin.g.a.a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(322301);
    s.u(parama, "$cancelCloseAuthorize");
    parama.invoke();
    AppMethodBeat.o(322301);
  }
  
  private final void kZ(boolean paramBoolean)
  {
    AppMethodBeat.i(322277);
    View localView = findViewById(ba.f.user_profile_panel);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(322277);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(322404);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_user_info_list_been_modified", cLG());
    localIntent.putExtra("key_result_is_open", this.hU);
    localIntent.putExtra("key_result_selected_user_id", this.ufK);
    setResult(-1, localIntent);
    super.finish();
    AppMethodBeat.o(322404);
  }
  
  public final int getLayoutId()
  {
    return ba.g.app_brand_user_profile_authorize_ui;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(322396);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b localb = this.ufM;
    paramConfiguration = localb;
    if (localb == null)
    {
      s.bIx("wxaUserInfoListOperationController");
      paramConfiguration = null;
    }
    paramConfiguration.cqu();
    AppMethodBeat.o(322396);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(322385);
    super.onCreate(paramBundle);
    setBackBtn(new AppBrandUserProfileAuthorizeUI..ExternalSyntheticLambda3(this));
    setMMTitle(ba.i.appbrand_setting_userinfo_authrize_title);
    paramBundle = getIntent().getExtras();
    Object localObject1;
    Object localObject2;
    if (paramBundle == null)
    {
      localObject1 = null;
      paramBundle = getIntent().getExtras();
      if (paramBundle != null) {
        break label129;
      }
      localObject2 = null;
      label59:
      paramBundle = getIntent().getExtras();
      if (paramBundle != null) {
        break label141;
      }
      paramBundle = null;
      label73:
      if (paramBundle != null) {
        break label155;
      }
    }
    label129:
    label141:
    label155:
    for (boolean bool = false;; bool = paramBundle.booleanValue())
    {
      this.hU = bool;
      kZ(this.hU);
      if ((localObject1 != null) && (localObject2 != null)) {
        break label163;
      }
      h.jXD();
      finish();
      AppMethodBeat.o(322385);
      return;
      localObject1 = (MMUserAvatarInfo)paramBundle.getParcelable("key_user_info");
      break;
      localObject2 = paramBundle.getString("key_app_id");
      break label59;
      paramBundle = Boolean.valueOf(paramBundle.getBoolean("key_is_state_open"));
      break label73;
    }
    label163:
    this.ufK = ((MMUserAvatarInfo)localObject1).rHa;
    paramBundle = findViewById(ba.f.main_switch);
    Object localObject3 = (MMSwitchBtn)paramBundle;
    ((MMSwitchBtn)localObject3).setCheck(this.hU);
    ((MMSwitchBtn)localObject3).setSwitchListener(new AppBrandUserProfileAuthorizeUI..ExternalSyntheticLambda4(this));
    localObject3 = ah.aiuX;
    s.s(paramBundle, "this.findViewById<MMSwit…)\n            }\n        }");
    this.ufL = ((MMSwitchBtn)paramBundle);
    localObject3 = (TextView)findViewById(ba.f.scope_desc);
    if (TextUtils.isEmpty((CharSequence)((MMUserAvatarInfo)localObject1).rHg))
    {
      paramBundle = (CharSequence)getString(ba.i.appbrand_setting_usernifo_authrize_page_switch_title);
      ((TextView)localObject3).setText(paramBundle);
      TextView localTextView = (TextView)findViewById(ba.f.user_Info_desc);
      if (!TextUtils.isEmpty((CharSequence)((MMUserAvatarInfo)localObject1).rHf)) {
        break label680;
      }
      paramBundle = am.aixg;
      String str = getString(ba.i.appbrand_setting_usernifo_authrize_user_info_list_desc);
      s.s(str, "getString(R.string.appbr…rize_user_info_list_desc)");
      paramBundle = getIntent().getExtras();
      if (paramBundle != null) {
        break label669;
      }
      paramBundle = null;
      label329:
      localObject3 = paramBundle;
      if (paramBundle == null) {
        localObject3 = "";
      }
      paramBundle = String.format(str, Arrays.copyOf(new Object[] { localObject3 }, 1));
      s.s(paramBundle, "java.lang.String.format(format, *args)");
      paramBundle = (CharSequence)paramBundle;
      label372:
      localTextView.setText(paramBundle);
      localObject3 = (TextView)findViewById(ba.f.list_title);
      if (!TextUtils.isEmpty((CharSequence)((MMUserAvatarInfo)localObject1).rHh)) {
        break label691;
      }
      paramBundle = (CharSequence)getString(ba.i.appbrand_setting_usernifo_authrize_list_title);
      label414:
      ((TextView)localObject3).setText(paramBundle);
      paramBundle = findViewById(ba.f.user_info_list);
      ((RecyclerView)paramBundle).setNestedScrollingEnabled(false);
      localObject3 = ah.aiuX;
      s.s(paramBundle, "this.findViewById<Recycl…Enabled = false\n        }");
      this.ufN = ((RecyclerView)paramBundle);
      this.ufM = new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b((Context)this, (MMUserAvatarInfo)localObject1, "", (b.c)new b(this, (String)localObject2));
      paramBundle = this.ufM;
      if (paramBundle != null) {
        break label702;
      }
      s.bIx("wxaUserInfoListOperationController");
      paramBundle = null;
      label505:
      paramBundle.rHr = ((a.a)new c(this));
      localObject2 = new com.tencent.mm.plugin.appbrand.widget.dialog.k(this.ufH);
      paramBundle = this.ufN;
      if (paramBundle != null) {
        break label705;
      }
      s.bIx("userInfoList");
      paramBundle = null;
      label550:
      paramBundle.setAdapter((RecyclerView.a)localObject2);
      paramBundle = this.ufN;
      if (paramBundle != null) {
        break label708;
      }
      s.bIx("userInfoList");
      paramBundle = null;
    }
    label669:
    label680:
    label691:
    label702:
    label705:
    label708:
    for (;;)
    {
      getContext();
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      localObject1 = this.ufN;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("userInfoList");
        paramBundle = null;
      }
      paramBundle.setItemAnimator(null);
      ((com.tencent.mm.plugin.appbrand.widget.dialog.k)localObject2).uCV = ((k.d)new d(this));
      ((com.tencent.mm.plugin.appbrand.widget.dialog.k)localObject2).thf = ((k.b)new e(this));
      AppMethodBeat.o(322385);
      return;
      paramBundle = (CharSequence)((MMUserAvatarInfo)localObject1).rHg;
      break;
      paramBundle = paramBundle.getString("key_nickname");
      break label329;
      paramBundle = (CharSequence)((MMUserAvatarInfo)localObject1).rHf;
      break label372;
      paramBundle = (CharSequence)((MMUserAvatarInfo)localObject1).rHh;
      break label414;
      break label505;
      break label550;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(322391);
    super.onDestroy();
    w localw = this.lKp;
    if (localw != null) {
      localw.dismiss();
    }
    AppMethodBeat.o(322391);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserProfileAuthorizeUI$onCreate$6", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "onCreateUserActionUpdate", "", "action", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener$CreateUserAction;", "onItemListChanged", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "updateAddNewAvatarEntry", "isBan", "", "reachMaxCount", "limitWording", "", "avatarWording", "goAddUserPage", "Lkotlin/Function2;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.c
  {
    b(AppBrandUserProfileAuthorizeUI paramAppBrandUserProfileAuthorizeUI, String paramString) {}
    
    private static final void a(m paramm, AppBrandUserProfileAuthorizeUI paramAppBrandUserProfileAuthorizeUI, String paramString, View paramView)
    {
      AppMethodBeat.i(322105);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramm);
      localb.cH(paramAppBrandUserProfileAuthorizeUI);
      localb.cH(paramString);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandUserProfileAuthorizeUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramm, "$goAddUserPage");
      s.u(paramAppBrandUserProfileAuthorizeUI, "this$0");
      paramAppBrandUserProfileAuthorizeUI = paramAppBrandUserProfileAuthorizeUI.getContext();
      s.s(paramAppBrandUserProfileAuthorizeUI, "context");
      paramm.invoke(paramAppBrandUserProfileAuthorizeUI, paramString);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/AppBrandUserProfileAuthorizeUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(322105);
    }
    
    public final void a(b.c.a parama)
    {
      AppMethodBeat.i(322118);
      s.u(parama, "action");
      AppMethodBeat.o(322118);
    }
    
    public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, m<? super Activity, ? super String, ah> paramm)
    {
      AppMethodBeat.i(322114);
      s.u(paramString1, "limitWording");
      s.u(paramString2, "avatarWording");
      s.u(paramm, "goAddUserPage");
      paramString1 = (TextView)this.ufR.findViewById(ba.f.user_reach_max_count_tip);
      paramString2 = this.ufR.findViewById(ba.f.create_new_user);
      if ((paramBoolean1) || (paramBoolean2)) {
        if (!paramBoolean1)
        {
          paramString1.setVisibility(0);
          paramString2.setVisibility(8);
        }
      }
      for (;;)
      {
        paramString2.setOnClickListener(new AppBrandUserProfileAuthorizeUI.b..ExternalSyntheticLambda0(paramm, this.ufR, this.eug));
        AppMethodBeat.o(322114);
        return;
        paramString1.setVisibility(8);
        paramString2.setVisibility(8);
        continue;
        paramString1.setVisibility(8);
        paramString2.setVisibility(0);
      }
    }
    
    public final void di(List<k.a> paramList)
    {
      AppMethodBeat.i(322122);
      s.u(paramList, "items");
      if (AppBrandUserProfileAuthorizeUI.a(this.ufR) == null) {
        AppBrandUserProfileAuthorizeUI.a(this.ufR, (List)new ArrayList((Collection)paramList));
      }
      AppBrandUserProfileAuthorizeUI.b(this.ufR).clear();
      AppBrandUserProfileAuthorizeUI.b(this.ufR).addAll((Collection)paramList);
      RecyclerView localRecyclerView = AppBrandUserProfileAuthorizeUI.c(this.ufR);
      paramList = localRecyclerView;
      if (localRecyclerView == null)
      {
        s.bIx("userInfoList");
        paramList = null;
      }
      paramList = paramList.getAdapter();
      if (paramList != null) {
        paramList.bZE.notifyChanged();
      }
      AppMethodBeat.o(322122);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserProfileAuthorizeUI$onCreate$7", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "onResult", "", "ret", "", "onStart", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements a.a
  {
    c(AppBrandUserProfileAuthorizeUI paramAppBrandUserProfileAuthorizeUI) {}
    
    private static final void c(DialogInterface paramDialogInterface) {}
    
    public final void cqs()
    {
      AppMethodBeat.i(322157);
      w localw = AppBrandUserProfileAuthorizeUI.d(this.ufR);
      if (localw != null) {
        localw.dismiss();
      }
      AppMethodBeat.o(322157);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(322148);
      if (AppBrandUserProfileAuthorizeUI.d(this.ufR) == null)
      {
        localObject = this.ufR;
        Context localContext = (Context)this.ufR.getContext();
        this.ufR.getString(ba.i.app_tip);
        AppBrandUserProfileAuthorizeUI.a((AppBrandUserProfileAuthorizeUI)localObject, com.tencent.mm.ui.base.k.a(localContext, 3, this.ufR.getString(ba.i.appbrand_setting_do_delete), false, AppBrandUserProfileAuthorizeUI.c..ExternalSyntheticLambda0.INSTANCE));
      }
      Object localObject = AppBrandUserProfileAuthorizeUI.d(this.ufR);
      if (localObject != null) {
        ((w)localObject).show();
      }
      AppMethodBeat.o(322148);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserProfileAuthorizeUI$onCreate$8$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "index", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements k.d
  {
    d(AppBrandUserProfileAuthorizeUI paramAppBrandUserProfileAuthorizeUI) {}
    
    public final void a(View paramView, k.a parama, int paramInt)
    {
      AppMethodBeat.i(322134);
      s.u(paramView, "v");
      s.u(parama, "item");
      Object localObject = AppBrandUserProfileAuthorizeUI.g(this.ufR);
      parama = (k.a)localObject;
      if (localObject == null)
      {
        s.bIx("wxaUserInfoListOperationController");
        parama = null;
      }
      localObject = TouchableLayout.agKp;
      int i = TouchableLayout.jMn();
      localObject = TouchableLayout.agKp;
      parama.a(paramView, paramInt, i, TouchableLayout.jMo());
      AppMethodBeat.o(322134);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/AppBrandUserProfileAuthorizeUI$onCreate$8$2", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements k.b
  {
    e(AppBrandUserProfileAuthorizeUI paramAppBrandUserProfileAuthorizeUI) {}
    
    public final void a(k.a parama)
    {
      AppMethodBeat.i(322117);
      s.u(parama, "item");
      com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b localb2 = AppBrandUserProfileAuthorizeUI.g(this.ufR);
      com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b localb1 = localb2;
      if (localb2 == null)
      {
        s.bIx("wxaUserInfoListOperationController");
        localb1 = null;
      }
      localb1.b(parama);
      AppBrandUserProfileAuthorizeUI.a(this.ufR, parama.rFX);
      AppMethodBeat.o(322117);
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(AppBrandUserProfileAuthorizeUI paramAppBrandUserProfileAuthorizeUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(AppBrandUserProfileAuthorizeUI paramAppBrandUserProfileAuthorizeUI, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUserProfileAuthorizeUI
 * JD-Core Version:    0.7.0.1
 */