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
import com.tencent.mm.g.a.uj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.y;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.dyb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.HeadImgAndNamePreference;
import com.tencent.mm.ui.base.preference.HeadImgAndNamePreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import d.a.j;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "myFinderUser", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateView", "plugin-finder_release"})
public final class FinderSettingInfoUI
  extends MMPreference
  implements com.tencent.mm.al.g
{
  private final String TAG = "Finder.FinderSettingInfoUI";
  private alv qBp;
  private String qOy;
  private com.tencent.mm.plugin.finder.api.f qPM;
  
  private final void cE()
  {
    AppMethodBeat.i(199390);
    Object localObject1 = com.tencent.mm.plugin.finder.api.b.qnX;
    localObject1 = bt.nullAsNil(this.qOy);
    d.g.b.k.g(localObject1, "Util.nullAsNil(myFinderUser)");
    this.qPM = b.a.YL((String)localObject1);
    if (this.qPM == null)
    {
      finish();
      AppMethodBeat.o(199390);
      return;
    }
    localObject1 = getPreferenceScreen().aKk("settings_avatar");
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.HeadImgAndNamePreference");
      AppMethodBeat.o(199390);
      throw ((Throwable)localObject1);
    }
    localObject1 = (HeadImgAndNamePreference)localObject1;
    ((HeadImgAndNamePreference)localObject1).a((HeadImgAndNamePreference.a)new c(this));
    Object localObject2 = (Context)this;
    com.tencent.mm.plugin.finder.api.f localf = this.qPM;
    if (localf == null) {
      d.g.b.k.fvU();
    }
    ((HeadImgAndNamePreference)localObject1).setTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)localf.Su()));
    ((HeadImgAndNamePreference)localObject1).eTy();
    ((HeadImgAndNamePreference)localObject1).aKj(this.qOy);
    ((HeadImgAndNamePreference)localObject1).f((View.OnClickListener)new d(this));
    localObject1 = this.qBp;
    if (localObject1 != null) {}
    for (localObject1 = ((alv)localObject1).LyJ; localObject1 == null; localObject1 = null)
    {
      getPreferenceScreen().cE("settings_data", true);
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(199390);
      return;
    }
    localObject2 = getPreferenceScreen();
    if (!((dyb)localObject1).enable) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject2).cE("settings_data", bool);
      break;
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
    this.qOy = u.aqO();
    ad.i(this.TAG, "myFinderUser " + this.qOy);
    setMMTitle(2131759349);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    com.tencent.mm.kernel.g.aeS().a(3761, (com.tencent.mm.al.g)this);
    paramBundle = new y(2);
    com.tencent.mm.kernel.g.aeS().b((n)paramBundle);
    AppMethodBeat.o(167614);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(199388);
    com.tencent.mm.kernel.g.aeS().b(3761, (com.tencent.mm.al.g)this);
    super.onDestroy();
    AppMethodBeat.o(199388);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(167616);
    if (paramPreference == null) {
      d.g.b.k.fvU();
    }
    paramf = paramPreference.getKey();
    ad.i(this.TAG, "click ".concat(String.valueOf(paramf)));
    if (paramf == null) {}
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
          paramPreference = new com.tencent.mm.hellhoundlib.b.a().bd(paramPreference);
          com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.adn(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramf.startActivity((Intent)paramPreference.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        break;
      case -604702652: 
        if (paramf.equals("settings_auth"))
        {
          paramf = new uj();
          paramf.dzH.userName = "gh_4ee148a6ecaa@app";
          paramf.dzH.appId = "wxdfda2588e999a42d";
          paramf.dzH.dzJ = "pages/index/index.html";
          paramf.dzH.scene = 1201;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)paramf);
        }
        break;
      case -604632506: 
        if (paramf.equals("settings_data"))
        {
          paramf = this.qBp;
          if (paramf != null)
          {
            paramf = paramf.LyJ;
            if (paramf != null) {
              if (paramf.Lxf == 1)
              {
                if (bt.isNullOrNil(paramf.jBp)) {
                  continue;
                }
                paramPreference = new Intent();
                paramPreference.putExtra("rawUrl", paramf.jBp);
                com.tencent.mm.bs.d.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
              }
            }
          }
        }
        break;
      case -843864278: 
        if (paramf.equals("settings_qrcode"))
        {
          paramf = com.tencent.mm.plugin.finder.utils.a.qSb;
          com.tencent.mm.plugin.finder.utils.a.eJ((Context)this);
        }
        break;
      case -1271745684: 
        if (paramf.equals("settings_privacy"))
        {
          paramPreference = new Intent();
          paramPreference.setClass((Context)this, FinderSettingPrivacyUI.class);
          paramf = getContext();
          paramPreference = new com.tencent.mm.hellhoundlib.b.a().bd(paramPreference);
          com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.adn(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramf.startActivity((Intent)paramPreference.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          if (paramf.Lxf == 2)
          {
            paramPreference = new uj();
            paramPreference.dzH.userName = paramf.Lxg;
            paramPreference.dzH.dzJ = paramf.Lxh;
            paramPreference.dzH.scene = 1201;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)paramPreference);
          }
        }
        break;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167615);
    super.onResume();
    getContentView().post((Runnable)new b(this));
    AppMethodBeat.o(167615);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject = null;
    AppMethodBeat.i(199389);
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
      AppMethodBeat.o(199389);
      return;
    }
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(199389);
        throw paramString;
      }
      this.qBp = ((y)paramn).ckV();
      if (this.qBp != null) {
        cE();
      }
    }
    AppMethodBeat.o(199389);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167610);
      this.qPO.finish();
      AppMethodBeat.o(167610);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167611);
      FinderSettingInfoUI.a(this.qPO);
      AppMethodBeat.o(167611);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$1", "Lcom/tencent/mm/ui/base/preference/HeadImgAndNamePreference$IAvatarLoaderEx;", "loadAvatar", "", "username", "", "icon", "Landroid/widget/ImageView;", "isRound", "", "plugin-finder_release"})
  public static final class c
    implements HeadImgAndNamePreference.a
  {
    public final void b(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(167612);
      d.g.b.k.h(paramString, "username");
      d.g.b.k.h(paramImageView, "icon");
      if (FinderSettingInfoUI.b(this.qPO) == null)
      {
        ad.e(FinderSettingInfoUI.c(this.qPO), "error self contact is null");
        AppMethodBeat.o(167612);
        return;
      }
      paramString = h.qCF;
      paramString = h.cmV();
      Object localObject = FinderSettingInfoUI.b(this.qPO);
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      localObject = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.f)localObject).field_avatarUrl);
      h localh = h.qCF;
      paramString.a(localObject, paramImageView, h.a(h.a.qCI));
      AppMethodBeat.o(167612);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167613);
      if (FinderSettingInfoUI.d(this.qPO) != null)
      {
        paramView = new Intent();
        Object localObject = FinderSettingInfoUI.b(this.qPO);
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        paramView.putStringArrayListExtra("key_url_list", j.Z(new String[] { ((com.tencent.mm.plugin.finder.api.f)localObject).cks() }));
        localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.D((Context)this.qPO, paramView);
      }
      AppMethodBeat.o(167613);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingInfoUI
 * JD-Core Version:    0.7.0.1
 */