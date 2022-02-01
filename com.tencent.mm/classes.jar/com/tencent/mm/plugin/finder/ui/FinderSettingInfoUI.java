package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.HeadImgAndNamePreference;
import com.tencent.mm.ui.base.preference.HeadImgAndNamePreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "CREATER_GUIDE_URL", "", "CREATER_GUIDE_URL_EN", "CREATER_GUIDE_URL_Traditional", "TAG", "myFinderUser", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateView", "plugin-finder_release"})
public final class FinderSettingInfoUI
  extends MMPreference
  implements com.tencent.mm.al.f
{
  private final String TAG = "Finder.FinderSettingInfoUI";
  private String sEO;
  private com.tencent.mm.plugin.finder.api.g sGW;
  private String sGY = "https://kf.qq.com/touch/scene_product.html?scene_id=kf7428";
  private String sGZ = "https://kf.qq.com/touch/scene_faq.html?scene_id=kf7467";
  private String sHa = "https://kf.qq.com/touch/scene_faq.html?scene_id=kf7468";
  private asp shx;
  
  private final void updateView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(204178);
    Object localObject1 = c.rHn;
    localObject1 = bt.nullAsNil(this.sEO);
    p.g(localObject1, "Util.nullAsNil(myFinderUser)");
    this.sGW = c.a.agW((String)localObject1);
    if (this.sGW == null)
    {
      finish();
      AppMethodBeat.o(204178);
      return;
    }
    localObject1 = getPreferenceScreen().aVD("settings_avatar");
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.HeadImgAndNamePreference");
      AppMethodBeat.o(204178);
      throw ((Throwable)localObject1);
    }
    localObject1 = (HeadImgAndNamePreference)localObject1;
    ((HeadImgAndNamePreference)localObject1).a((HeadImgAndNamePreference.a)new c(this));
    Object localObject2 = (Context)this;
    com.tencent.mm.plugin.finder.api.g localg = this.sGW;
    if (localg == null) {
      p.gfZ();
    }
    ((HeadImgAndNamePreference)localObject1).setTitle((CharSequence)k.c((Context)localObject2, (CharSequence)localg.VC()));
    ((HeadImgAndNamePreference)localObject1).fzz();
    ((HeadImgAndNamePreference)localObject1).aVC(this.sEO);
    ((HeadImgAndNamePreference)localObject1).d((View.OnClickListener)new d(this));
    localObject1 = this.shx;
    if (localObject1 != null)
    {
      localObject1 = ((asp)localObject1).GqI;
      if (localObject1 != null) {
        break label249;
      }
      getPreferenceScreen().cP("settings_data", true);
      localObject1 = getPreferenceScreen();
      localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cFd()) {
        break label283;
      }
    }
    label283:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject1).cP("settings_creater_guide", bool1);
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(204178);
      return;
      localObject1 = null;
      break;
      label249:
      localObject2 = getPreferenceScreen();
      if (!((ach)localObject1).enable) {}
      for (bool1 = true;; bool1 = false)
      {
        ((com.tencent.mm.ui.base.preference.f)localObject2).cP("settings_data", bool1);
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
    this.sEO = u.aAu();
    ad.i(this.TAG, "myFinderUser " + this.sEO);
    setMMTitle(2131759349);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    com.tencent.mm.kernel.g.aiU().a(3761, (com.tencent.mm.al.f)this);
    paramBundle = new ax(2);
    com.tencent.mm.kernel.g.aiU().b((n)paramBundle);
    AppMethodBeat.o(167614);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204176);
    com.tencent.mm.kernel.g.aiU().b(3761, (com.tencent.mm.al.f)this);
    super.onDestroy();
    AppMethodBeat.o(204176);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(167616);
    if (paramPreference == null) {
      p.gfZ();
    }
    paramf = paramPreference.getKey();
    ad.i(this.TAG, "click ".concat(String.valueOf(paramf)));
    if (paramf == null) {}
    do
    {
      for (;;)
      {
        AppMethodBeat.o(167616);
        return true;
        switch (paramf.hashCode())
        {
        default: 
          break;
        case -1298291467: 
          if (paramf.equals("settings_avatar"))
          {
            paramPreference = new Intent();
            paramPreference.setClass((Context)this, FinderSettingDetailInfoUI.class);
            paramf = getContext();
            paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
            com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.ahp(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramf.startActivity((Intent)paramPreference.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramf = h.soM;
            h.c((Context)this, 1L, 1L);
          }
          break;
        case -604702652: 
          if (paramf.equals("settings_auth"))
          {
            paramf = new vm();
            paramf.dJF.userName = "gh_4ee148a6ecaa@app";
            paramf.dJF.appId = "wxdfda2588e999a42d";
            paramf.dJF.dJH = "pages/index/index.html";
            paramf.dJF.scene = 1201;
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)paramf);
            paramf = h.soM;
            h.c((Context)this, 3L, 1L);
          }
          break;
        case -604632506: 
          if (paramf.equals("settings_data"))
          {
            paramf = this.shx;
            if (paramf != null)
            {
              paramf = paramf.GqI;
              if (paramf != null)
              {
                if (paramf.GbQ != 1) {
                  break label655;
                }
                if (!bt.isNullOrNil(paramf.kwk))
                {
                  paramPreference = new Intent();
                  paramPreference.putExtra("rawUrl", paramf.kwk);
                  com.tencent.mm.bs.d.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
                }
              }
            }
          }
          break;
        case -843864278: 
          if (paramf.equals("settings_qrcode"))
          {
            paramf = com.tencent.mm.plugin.finder.utils.a.sKD;
            com.tencent.mm.plugin.finder.utils.a.eR((Context)this);
            paramf = h.soM;
            h.c((Context)this, 2L, 1L);
          }
          break;
        }
      }
    } while (!paramf.equals("settings_creater_guide"));
    paramPreference = new Intent();
    if (ac.fkp()) {
      paramf = this.sGY;
    }
    for (;;)
    {
      ad.i(this.TAG, "url = ".concat(String.valueOf(paramf)));
      paramPreference.putExtra("rawUrl", paramf);
      com.tencent.mm.bs.d.b((Context)this, "webview", ".ui.tools.WebViewUI", paramPreference);
      paramf = h.soM;
      h.c((Context)this, 4L, 1L);
      break;
      if (!paramf.equals("settings_privacy")) {
        break;
      }
      paramPreference = new Intent();
      paramPreference.setClass((Context)this, FinderSettingPrivacyUI.class);
      paramf = getContext();
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.ahp(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf = h.soM;
      h.c((Context)this, 5L, 1L);
      break;
      label655:
      if (paramf.GbQ != 2) {
        break;
      }
      paramPreference = new vm();
      paramPreference.dJF.userName = paramf.GbR;
      paramPreference.dJF.dJH = paramf.GbS;
      paramPreference.dJF.scene = 1201;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)paramPreference);
      break;
      if (ac.fkq())
      {
        paramf = this.sGZ;
      }
      else
      {
        p.i(ac.fks(), "en");
        paramf = this.sHa;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167615);
    super.onResume();
    getContentView().post((Runnable)new b(this));
    h localh = h.soM;
    h.c((Context)this, 1L, 2L);
    localh = h.soM;
    h.c((Context)this, 2L, 2L);
    localh = h.soM;
    h.c((Context)this, 3L, 2L);
    localh = h.soM;
    h.c((Context)this, 4L, 2L);
    localh = h.soM;
    h.c((Context)this, 5L, 2L);
    AppMethodBeat.o(167615);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject = null;
    AppMethodBeat.i(204177);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene ");
    if (paramn != null) {}
    for (paramString = Integer.valueOf(paramn.getType());; paramString = null)
    {
      ad.i(str, paramString + " scene:" + paramn);
      paramString = localObject;
      if (paramn != null) {
        paramString = Integer.valueOf(paramn.getType());
      }
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(204177);
      return;
    }
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(204177);
        throw paramString;
      }
      this.shx = ((ax)paramn).cyJ();
      if (this.shx != null) {
        updateView();
      }
    }
    AppMethodBeat.o(204177);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167610);
      this.sHb.finish();
      AppMethodBeat.o(167610);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167611);
      FinderSettingInfoUI.a(this.sHb);
      AppMethodBeat.o(167611);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$1", "Lcom/tencent/mm/ui/base/preference/HeadImgAndNamePreference$IAvatarLoaderEx;", "loadAvatar", "", "username", "", "icon", "Landroid/widget/ImageView;", "isRound", "", "plugin-finder_release"})
  public static final class c
    implements HeadImgAndNamePreference.a
  {
    public final void b(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(167612);
      p.h(paramString, "username");
      p.h(paramImageView, "icon");
      if (FinderSettingInfoUI.b(this.sHb) == null)
      {
        ad.e(FinderSettingInfoUI.c(this.sHb), "error self contact is null");
        AppMethodBeat.o(167612);
        return;
      }
      paramString = i.sja;
      paramString = i.cCC();
      Object localObject = FinderSettingInfoUI.b(this.sHb);
      if (localObject == null) {
        p.gfZ();
      }
      localObject = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject).field_avatarUrl);
      i locali = i.sja;
      paramString.a(localObject, paramImageView, i.a(i.a.sjd));
      AppMethodBeat.o(167612);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167613);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      if (FinderSettingInfoUI.d(this.sHb) != null)
      {
        paramView = new Intent();
        localObject = FinderSettingInfoUI.b(this.sHb);
        if (localObject == null) {
          p.gfZ();
        }
        paramView.putStringArrayListExtra("key_url_list", j.ac(new String[] { ((com.tencent.mm.plugin.finder.api.g)localObject).cxL() }));
        paramView.putExtra("key_preview_avatar", true);
        localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.H((Context)this.sHb, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167613);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingInfoUI
 * JD-Core Version:    0.7.0.1
 */