package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.extension.reddot.e;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.HeadImgAndNamePreference;
import com.tencent.mm.ui.base.preference.HeadImgAndNamePreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import d.a.j;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "CREATER_GUIDE_URL", "", "CREATER_GUIDE_URL_EN", "CREATER_GUIDE_URL_Traditional", "TAG", "hasExposeOriginalTips", "myFinderUser", "originalTag", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "updateView", "plugin-finder_release"})
public final class FinderSettingInfoUI
  extends MMPreference
  implements com.tencent.mm.ak.f
{
  private final String TAG = "Finder.FinderSettingInfoUI";
  private String sPN;
  private com.tencent.mm.plugin.finder.api.g sRT;
  private final String sRV = "setting_original";
  private String sRW = "https://kf.qq.com/touch/scene_product.html?scene_id=kf7428";
  private String sRX = "https://kf.qq.com/touch/scene_faq.html?scene_id=kf7467";
  private String sRY = "https://kf.qq.com/touch/scene_faq.html?scene_id=kf7468";
  private String sRZ = "";
  private atf sqs;
  
  private final void updateView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(204780);
    Object localObject1 = c.rPy;
    this.sRT = c.a.ahT(bu.nullAsNil(this.sPN));
    if (this.sRT == null)
    {
      finish();
      AppMethodBeat.o(204780);
      return;
    }
    localObject1 = getPreferenceScreen().aXe("settings_avatar");
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.HeadImgAndNamePreference");
      AppMethodBeat.o(204780);
      throw ((Throwable)localObject1);
    }
    localObject1 = (HeadImgAndNamePreference)localObject1;
    ((HeadImgAndNamePreference)localObject1).a((HeadImgAndNamePreference.a)new c(this));
    Object localObject2 = (Context)this;
    com.tencent.mm.plugin.finder.api.g localg = this.sRT;
    if (localg == null) {
      p.gkB();
    }
    ((HeadImgAndNamePreference)localObject1).setTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)localg.VK()));
    ((HeadImgAndNamePreference)localObject1).fDB();
    ((HeadImgAndNamePreference)localObject1).aXd(this.sPN);
    ((HeadImgAndNamePreference)localObject1).d((View.OnClickListener)new d(this));
    getPreferenceScreen().cT(this.sRV, true);
    localObject1 = com.tencent.mm.plugin.finder.utils.k.sWF;
    if (com.tencent.mm.plugin.finder.utils.k.cNS())
    {
      getPreferenceScreen().cT(this.sRV, false);
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBC(), (LifecycleOwner)this, (Observer)new e(this));
      localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
      com.tencent.mm.plugin.finder.report.i.c((Context)this, 6L, 2L);
    }
    localObject1 = this.sqs;
    if (localObject1 != null)
    {
      localObject1 = ((atf)localObject1).GKg;
      if (localObject1 != null) {
        break label329;
      }
      getPreferenceScreen().cT("settings_data", true);
      localObject1 = getPreferenceScreen();
      localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cHa()) {
        break label364;
      }
    }
    label329:
    label364:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject1).cT("settings_creater_guide", bool1);
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(204780);
      return;
      localObject1 = null;
      break;
      localObject2 = getPreferenceScreen();
      if (!((acq)localObject1).enable) {}
      for (bool1 = true;; bool1 = false)
      {
        ((com.tencent.mm.ui.base.preference.f)localObject2).cT("settings_data", bool1);
        break;
      }
    }
  }
  
  public final int getResourceId()
  {
    return 2131951680;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167614);
    super.onCreate(paramBundle);
    this.sPN = com.tencent.mm.model.v.aAK();
    ae.i(this.TAG, "myFinderUser " + this.sPN);
    setMMTitle(2131759349);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    getPreferenceScreen().cT(this.sRV, true);
    getPreferenceScreen().notifyDataSetChanged();
    com.tencent.mm.kernel.g.ajj().a(3761, (com.tencent.mm.ak.f)this);
    paramBundle = new ay(2);
    com.tencent.mm.kernel.g.ajj().b((n)paramBundle);
    AppMethodBeat.o(167614);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204778);
    com.tencent.mm.kernel.g.ajj().b(3761, (com.tencent.mm.ak.f)this);
    super.onDestroy();
    AppMethodBeat.o(204778);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(167616);
    if (paramPreference == null) {
      p.gkB();
    }
    paramf = paramPreference.getKey();
    ae.i(this.TAG, "click ".concat(String.valueOf(paramf)));
    if (p.i(paramf, "settings_avatar"))
    {
      paramPreference = new Intent();
      paramPreference.setClass((Context)this, FinderSettingDetailInfoUI.class);
      paramf = getContext();
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.ahE(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf = com.tencent.mm.plugin.finder.report.i.syT;
      com.tencent.mm.plugin.finder.report.i.c((Context)this, 1L, 1L);
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(167616);
        return true;
        if (p.i(paramf, "settings_auth"))
        {
          paramf = new vq();
          paramf.dKT.userName = "gh_4ee148a6ecaa@app";
          paramf.dKT.appId = "wxdfda2588e999a42d";
          paramf.dKT.dKV = "pages/index/index.html";
          paramf.dKT.scene = 1201;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)paramf);
          paramf = com.tencent.mm.plugin.finder.report.i.syT;
          com.tencent.mm.plugin.finder.report.i.c((Context)this, 3L, 1L);
        }
        else if (p.i(paramf, "settings_qrcode"))
        {
          paramf = com.tencent.mm.plugin.finder.utils.a.sVQ;
          com.tencent.mm.plugin.finder.utils.a.eV((Context)this);
          paramf = com.tencent.mm.plugin.finder.report.i.syT;
          com.tencent.mm.plugin.finder.report.i.c((Context)this, 2L, 1L);
        }
        else if (p.i(paramf, "settings_privacy"))
        {
          paramPreference = new Intent();
          paramPreference.setClass((Context)this, FinderSettingPrivacyUI.class);
          paramf = getContext();
          paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
          com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.ahE(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramf.startActivity((Intent)paramPreference.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramf = com.tencent.mm.plugin.finder.report.i.syT;
          com.tencent.mm.plugin.finder.report.i.c((Context)this, 5L, 1L);
        }
        else
        {
          if (!p.i(paramf, "settings_data")) {
            break;
          }
          paramf = this.sqs;
          if (paramf != null)
          {
            paramf = paramf.GKg;
            if (paramf != null) {
              if (paramf.Gux == 1)
              {
                if (!bu.isNullOrNil(paramf.kzz))
                {
                  paramPreference = new Intent();
                  paramPreference.putExtra("rawUrl", paramf.kzz);
                  com.tencent.mm.br.d.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
                }
              }
              else if (paramf.Gux == 2)
              {
                paramPreference = new vq();
                paramPreference.dKT.userName = paramf.Guy;
                paramPreference.dKT.dKV = paramf.Guz;
                paramPreference.dKT.scene = 1201;
                com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)paramPreference);
              }
            }
          }
        }
      }
      if (p.i(paramf, "settings_creater_guide"))
      {
        paramPreference = new Intent();
        if (ad.foj()) {
          paramf = this.sRW;
        }
        for (;;)
        {
          ae.i(this.TAG, "url = ".concat(String.valueOf(paramf)));
          paramPreference.putExtra("rawUrl", paramf);
          com.tencent.mm.br.d.b((Context)this, "webview", ".ui.tools.WebViewUI", paramPreference);
          paramf = com.tencent.mm.plugin.finder.report.i.syT;
          com.tencent.mm.plugin.finder.report.i.c((Context)this, 4L, 1L);
          break;
          if (ad.fok())
          {
            paramf = this.sRX;
          }
          else
          {
            p.i(ad.fom(), "en");
            paramf = this.sRY;
          }
        }
      }
    } while (!p.i(paramf, this.sRV));
    paramf = getPreferenceScreen().aXe(this.sRV);
    if (paramf == null)
    {
      paramf = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.newtips.NewTipPreference");
      AppMethodBeat.o(167616);
      throw paramf;
    }
    paramf = (NewTipPreference)paramf;
    paramPreference = com.tencent.mm.plugin.finder.report.i.syT;
    com.tencent.mm.plugin.finder.report.i.a((Context)this, 6L, 1L, paramf.dxA());
    paramf = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    p.g(paramf, "MMKernel.plugin(PluginFinder::class.java)");
    paramPreference = ((PluginFinder)paramf).getRedDotManager().aii("OriginalEntrance");
    paramf = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    p.g(paramf, "MMKernel.plugin(PluginFinder::class.java)");
    com.tencent.mm.plugin.finder.extension.reddot.i locali = ((PluginFinder)paramf).getRedDotManager().aij("OriginalEntrance");
    if ((locali != null) && (paramPreference != null))
    {
      paramf = h.syO;
      paramf = FinderReporterUIC.tnG;
      paramf = FinderReporterUIC.a.fc((Context)this);
      if (paramf == null) {
        break label994;
      }
    }
    label994:
    for (paramf = paramf.cQZ();; paramf = null)
    {
      h.a("10", locali, paramPreference, 2, paramf, 0, 0, 96);
      paramf = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(paramf, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramf).getRedDotManager().aih("OriginalEntrance");
      paramf = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(paramf, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramf).getRedDotManager().e("FinderSetting", new int[] { 1000 });
      paramf = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(paramf, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramf).getRedDotManager().e("ProfileEntrance", new int[] { 1000 });
      paramf = com.tencent.mm.plugin.finder.storage.b.sHP;
      paramf = com.tencent.mm.plugin.finder.storage.b.cKH();
      getIntent().putExtra("rawUrl", paramf);
      com.tencent.mm.br.d.b((Context)this, "webview", ".ui.tools.WebViewUI", getIntent());
      break;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167615);
    super.onResume();
    getContentView().post((Runnable)new b(this));
    com.tencent.mm.plugin.finder.report.i locali = com.tencent.mm.plugin.finder.report.i.syT;
    com.tencent.mm.plugin.finder.report.i.c((Context)this, 1L, 2L);
    locali = com.tencent.mm.plugin.finder.report.i.syT;
    com.tencent.mm.plugin.finder.report.i.c((Context)this, 2L, 2L);
    locali = com.tencent.mm.plugin.finder.report.i.syT;
    com.tencent.mm.plugin.finder.report.i.c((Context)this, 3L, 2L);
    locali = com.tencent.mm.plugin.finder.report.i.syT;
    com.tencent.mm.plugin.finder.report.i.c((Context)this, 4L, 2L);
    locali = com.tencent.mm.plugin.finder.report.i.syT;
    com.tencent.mm.plugin.finder.report.i.c((Context)this, 5L, 2L);
    AppMethodBeat.o(167615);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject = null;
    AppMethodBeat.i(204779);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene ");
    if (paramn != null) {}
    for (paramString = Integer.valueOf(paramn.getType());; paramString = null)
    {
      ae.i(str, paramString + " scene:" + paramn);
      paramString = localObject;
      if (paramn != null) {
        paramString = Integer.valueOf(paramn.getType());
      }
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(204779);
      return;
    }
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(204779);
        throw paramString;
      }
      this.sqs = ((ay)paramn).cAk();
      if (this.sqs != null) {
        updateView();
      }
    }
    AppMethodBeat.o(204779);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(204781);
    super.onStop();
    this.sRZ = "";
    AppMethodBeat.o(204781);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167610);
      this.sSa.finish();
      AppMethodBeat.o(167610);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167611);
      FinderSettingInfoUI.a(this.sSa);
      AppMethodBeat.o(167611);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$1", "Lcom/tencent/mm/ui/base/preference/HeadImgAndNamePreference$IAvatarLoaderEx;", "loadAvatar", "", "username", "", "icon", "Landroid/widget/ImageView;", "isRound", "", "plugin-finder_release"})
  public static final class c
    implements HeadImgAndNamePreference.a
  {
    public final void b(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(167612);
      p.h(paramString, "username");
      p.h(paramImageView, "icon");
      if (FinderSettingInfoUI.b(this.sSa) == null)
      {
        ae.e(FinderSettingInfoUI.c(this.sSa), "error self contact is null");
        AppMethodBeat.o(167612);
        return;
      }
      paramString = com.tencent.mm.plugin.finder.loader.i.srW;
      paramString = com.tencent.mm.plugin.finder.loader.i.cEo();
      Object localObject = FinderSettingInfoUI.b(this.sSa);
      if (localObject == null) {
        p.gkB();
      }
      localObject = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject).field_avatarUrl);
      com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.srW;
      paramString.a(localObject, paramImageView, com.tencent.mm.plugin.finder.loader.i.a(i.a.srZ));
      AppMethodBeat.o(167612);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167613);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      if (FinderSettingInfoUI.d(this.sSa) != null)
      {
        paramView = new Intent();
        localObject = FinderSettingInfoUI.b(this.sSa);
        if (localObject == null) {
          p.gkB();
        }
        paramView.putStringArrayListExtra("key_url_list", j.ab(new String[] { ((com.tencent.mm.plugin.finder.api.g)localObject).czm() }));
        paramView.putExtra("key_preview_avatar", true);
        localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.H((Context)this.sSa, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167613);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class e<T>
    implements Observer<g.a>
  {
    e(FinderSettingInfoUI paramFinderSettingInfoUI) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingInfoUI
 * JD-Core Version:    0.7.0.1
 */