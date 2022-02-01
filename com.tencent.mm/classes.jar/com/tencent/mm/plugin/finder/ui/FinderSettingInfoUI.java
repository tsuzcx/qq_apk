package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.m;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.feed.ui.FinderAccountManagent;
import com.tencent.mm.plugin.finder.feed.ui.FinderAccountManagent.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.service.m;
import com.tencent.mm.plugin.finder.utils.ai;
import com.tencent.mm.plugin.findersdk.b.b;
import com.tencent.mm.plugin.findersdk.b.b.a;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "accountExtConfig", "Lcom/tencent/mm/protocal/protobuf/AccountExtraSettingConfig;", "loadingComponent", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "getLoadingComponent", "()Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "setLoadingComponent", "(Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;)V", "myFinderUser", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "profileSettingCallback", "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$profileSettingCallback$1", "Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$profileSettingCallback$1;", "profileSettingTag", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "resetLoading", "switchWxProfileSetting", "updateView", "isFromSceneEnd", "plugin-finder_release"})
public final class FinderSettingInfoUI
  extends MMPreference
  implements com.tencent.mm.an.i
{
  private final String Avg;
  private final c Avh;
  private final String TAG;
  private HashMap _$_findViewCache;
  private ble wZz;
  private av xLd;
  private String xTq;
  private com.tencent.mm.plugin.finder.api.i xTr;
  b ywG;
  
  public FinderSettingInfoUI()
  {
    AppMethodBeat.i(267649);
    this.TAG = "Finder.FinderSettingInfoUI";
    this.Avg = "settings_show_my_finder";
    this.Avh = new c(this);
    AppMethodBeat.o(267649);
  }
  
  private final void jq(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(267646);
    Object localObject = d.wZQ;
    this.xTr = d.a.aAK(Util.nullAsNil(this.xTq));
    if (this.xTr == null)
    {
      finish();
      AppMethodBeat.o(267646);
      return;
    }
    localObject = this.wZz;
    com.tencent.mm.ui.base.preference.f localf;
    int i;
    if (localObject != null)
    {
      localObject = ((ble)localObject).SWe;
      if (localObject != null) {
        break label222;
      }
      getPreferenceScreen().dz("settings_data", true);
      localObject = ai.AFJ;
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localf = getPreferenceScreen();
      p.j(localf, "preferenceScreen");
      if ((ai.a((Context)localObject, localf, this.Avg)) && (paramBoolean))
      {
        localObject = n.zWF;
        n.b((Context)this, 12L, 2L);
      }
      if (this.xLd == null) {
        break label257;
      }
      i = 1;
      label155:
      localObject = getPreferenceScreen();
      if (i != 0) {
        break label262;
      }
    }
    label257:
    label262:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("account_management", paramBoolean);
      if (i != 0)
      {
        localObject = n.zWF;
        n.b((Context)this, 10L, 2L);
      }
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(267646);
      return;
      localObject = null;
      break;
      label222:
      localf = getPreferenceScreen();
      if (!((afc)localObject).enable) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localf.dz("settings_data", bool1);
        break;
      }
      i = 0;
      break label155;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(267651);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(267651);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(267650);
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
    AppMethodBeat.o(267650);
    return localView1;
  }
  
  public final int getResourceId()
  {
    return b.m.finder_setting_info_pref;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167614);
    super.onCreate(paramBundle);
    this.xTq = z.bdh();
    Log.i(this.TAG, "myFinderUser " + this.xTq);
    setMMTitle(b.j.finder_setting_manager);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    getPreferenceScreen().dz(this.Avg, true);
    getPreferenceScreen().notifyDataSetChanged();
    h.aGY().a(3761, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(167614);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(267644);
    h.aGY().b(3761, (com.tencent.mm.an.i)this);
    super.onDestroy();
    AppMethodBeat.o(267644);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(167616);
    if (paramPreference == null) {
      p.iCn();
    }
    paramf = paramPreference.getKey();
    Log.i(this.TAG, "click ".concat(String.valueOf(paramf)));
    if (p.h(paramf, "settings_avatar"))
    {
      paramPreference = new Intent();
      paramPreference.setClass((Context)this, FinderSettingDetailInfoUI.class);
      paramf = getContext();
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aFh(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf = n.zWF;
      n.b((Context)this, 1L, 1L);
    }
    for (;;)
    {
      AppMethodBeat.o(167616);
      return true;
      if (p.h(paramf, "settings_qrcode"))
      {
        paramf = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.fH((Context)this);
        paramf = n.zWF;
        n.b((Context)this, 2L, 1L);
      }
      else if (p.h(paramf, "settings_privacy"))
      {
        paramPreference = new Intent();
        paramPreference.setClass((Context)this, FinderSettingPrivacyUI.class);
        paramf = getContext();
        paramPreference = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aFh(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramf.startActivity((Intent)paramPreference.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramf = n.zWF;
        n.b((Context)this, 5L, 1L);
      }
      else if (p.h(paramf, "settings_data"))
      {
        paramf = this.wZz;
        if (paramf != null)
        {
          paramf = paramf.SWe;
          if (paramf != null) {
            if (paramf.Srz == 1)
            {
              if (!Util.isNullOrNil(paramf.ozt))
              {
                paramPreference = new Intent();
                paramPreference.putExtra("rawUrl", paramf.ozt);
                c.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
              }
            }
            else if (paramf.Srz == 2)
            {
              paramPreference = new xw();
              paramPreference.fWN.userName = paramf.SrA;
              paramPreference.fWN.fWP = paramf.SrB;
              paramPreference.fWN.scene = 1201;
              EventCenter.instance.publish((IEvent)paramPreference);
            }
          }
        }
      }
      else if (p.h(paramf, this.Avg))
      {
        paramf = h.aHG();
        p.j(paramf, "MMKernel.storage()");
        paramf.aHp().set(ar.a.VBs, Integer.valueOf(1));
        paramf = h.aHG();
        p.j(paramf, "MMKernel.storage()");
        paramf.aHp().set(ar.a.VBt, Integer.valueOf(1));
        paramf = n.zWF;
        n.b((Context)this, 12L, 1L);
        paramf = getPreferenceScreen().byG(this.Avg);
        if (paramf == null)
        {
          paramf = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
          AppMethodBeat.o(167616);
          throw paramf;
        }
        boolean bool = ((CheckBoxPreference)paramf).isChecked();
        paramf = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (bool != com.tencent.mm.plugin.finder.utils.aj.eed())
        {
          Log.i(this.TAG, "change isShowAtWxProfile, now:".concat(String.valueOf(bool)));
          paramf = this.ywG;
          if (paramf != null) {
            paramf.end();
          }
          paramf = b.Bvw;
          paramf = getContext();
          p.j(paramf, "context");
          this.ywG = b.a.d((Context)paramf, getContext().getString(b.j.app_waiting), 500L);
          paramf = this.ywG;
          if (paramf != null) {
            paramf.begin();
          }
          ((m)h.ae(m.class)).a(bool, (com.tencent.mm.plugin.findersdk.a.aj)this.Avh);
        }
      }
      else if (p.h(paramf, "account_management"))
      {
        paramf = new Intent();
        paramPreference = n.zWF;
        n.b((Context)this, 10L, 1L);
        paramPreference = this.xLd;
        if (paramPreference != null)
        {
          FinderAccountManagent.a locala = FinderAccountManagent.xLf;
          paramf.putExtra(FinderAccountManagent.duG(), paramPreference.toByteArray());
          paramPreference = com.tencent.mm.plugin.finder.utils.a.ACH;
          com.tencent.mm.plugin.finder.utils.a.ao((Context)this, paramf);
        }
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167615);
    super.onResume();
    getContentView().post((Runnable)new b(this));
    Object localObject = n.zWF;
    n.b((Context)this, 1L, 2L);
    localObject = n.zWF;
    n.b((Context)this, 2L, 2L);
    localObject = n.zWF;
    n.b((Context)this, 5L, 2L);
    localObject = new ch(2);
    h.aGY().b((q)localObject);
    AppMethodBeat.o(167615);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Object localObject = null;
    AppMethodBeat.i(267645);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene ");
    if (paramq != null) {}
    for (paramString = Integer.valueOf(paramq.getType());; paramString = null)
    {
      Log.i(str, paramString + " scene:" + paramq);
      paramString = localObject;
      if (paramq != null) {
        paramString = Integer.valueOf(paramq.getType());
      }
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(267645);
      return;
    }
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(267645);
        throw paramString;
      }
      this.wZz = ((ch)paramq).dnR();
      paramString = this.wZz;
      if (paramString != null)
      {
        this.xLd = paramString.SWn;
        jq(true);
        AppMethodBeat.o(267645);
        return;
      }
    }
    AppMethodBeat.o(267645);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(267648);
    super.onStop();
    AppMethodBeat.o(267648);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167610);
      this.Avi.finish();
      AppMethodBeat.o(167610);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167611);
      FinderSettingInfoUI.a(this.Avi);
      AppMethodBeat.o(167611);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$profileSettingCallback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.plugin.findersdk.a.aj<bfc>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingInfoUI
 * JD-Core Version:    0.7.0.1
 */