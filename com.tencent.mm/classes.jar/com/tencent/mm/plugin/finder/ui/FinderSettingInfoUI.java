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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.HeadImgAndNamePreference;
import com.tencent.mm.ui.base.preference.HeadImgAndNamePreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import d.a.j;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "myFinderUser", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateView", "plugin-finder_release"})
public final class FinderSettingInfoUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  private final String TAG = "Finder.FinderSettingInfoUI";
  private String rJO;
  private com.tencent.mm.plugin.finder.api.f rLB;
  private aoy rsp;
  
  private final void cL()
  {
    AppMethodBeat.i(203363);
    Object localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
    localObject1 = bs.nullAsNil(this.rJO);
    d.g.b.k.g(localObject1, "Util.nullAsNil(myFinderUser)");
    this.rLB = b.a.adh((String)localObject1);
    if (this.rLB == null)
    {
      finish();
      AppMethodBeat.o(203363);
      return;
    }
    localObject1 = getPreferenceScreen().aPN("settings_avatar");
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.HeadImgAndNamePreference");
      AppMethodBeat.o(203363);
      throw ((Throwable)localObject1);
    }
    localObject1 = (HeadImgAndNamePreference)localObject1;
    ((HeadImgAndNamePreference)localObject1).a((HeadImgAndNamePreference.a)new c(this));
    Object localObject2 = (Context)this;
    com.tencent.mm.plugin.finder.api.f localf = this.rLB;
    if (localf == null) {
      d.g.b.k.fOy();
    }
    ((HeadImgAndNamePreference)localObject1).setTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)localf.Tn()));
    ((HeadImgAndNamePreference)localObject1).fjk();
    ((HeadImgAndNamePreference)localObject1).aPM(this.rJO);
    ((HeadImgAndNamePreference)localObject1).f((View.OnClickListener)new d(this));
    localObject1 = this.rsp;
    if (localObject1 != null) {}
    for (localObject1 = ((aoy)localObject1).EHT; localObject1 == null; localObject1 = null)
    {
      getPreferenceScreen().cK("settings_data", true);
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(203363);
      return;
    }
    localObject2 = getPreferenceScreen();
    if (!((aah)localObject1).enable) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject2).cK("settings_data", bool);
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
    this.rJO = u.axE();
    ac.i(this.TAG, "myFinderUser " + this.rJO);
    setMMTitle(2131759349);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    com.tencent.mm.kernel.g.agi().a(3761, (com.tencent.mm.ak.g)this);
    paramBundle = new aq(2);
    com.tencent.mm.kernel.g.agi().b((n)paramBundle);
    AppMethodBeat.o(167614);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203361);
    com.tencent.mm.kernel.g.agi().b(3761, (com.tencent.mm.ak.g)this);
    super.onDestroy();
    AppMethodBeat.o(203361);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(167616);
    if (paramPreference == null) {
      d.g.b.k.fOy();
    }
    paramf = paramPreference.getKey();
    ac.i(this.TAG, "click ".concat(String.valueOf(paramf)));
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
          paramPreference = new com.tencent.mm.hellhoundlib.b.a().ba(paramPreference);
          com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.aeD(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramf.startActivity((Intent)paramPreference.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        break;
      case -604702652: 
        if (paramf.equals("settings_auth"))
        {
          paramf = new ut();
          paramf.dxt.userName = "gh_4ee148a6ecaa@app";
          paramf.dxt.appId = "wxdfda2588e999a42d";
          paramf.dxt.dxv = "pages/index/index.html";
          paramf.dxt.scene = 1201;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)paramf);
        }
        break;
      case -604632506: 
        if (paramf.equals("settings_data"))
        {
          paramf = this.rsp;
          if (paramf != null)
          {
            paramf = paramf.EHT;
            if (paramf != null) {
              if (paramf.Euw == 1)
              {
                if (bs.isNullOrNil(paramf.kbL)) {
                  continue;
                }
                paramPreference = new Intent();
                paramPreference.putExtra("rawUrl", paramf.kbL);
                com.tencent.mm.br.d.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
              }
            }
          }
        }
        break;
      case -843864278: 
        if (paramf.equals("settings_qrcode"))
        {
          paramf = com.tencent.mm.plugin.finder.utils.a.rOv;
          com.tencent.mm.plugin.finder.utils.a.eR((Context)this);
        }
        break;
      case -1271745684: 
        if (paramf.equals("settings_privacy"))
        {
          paramPreference = new Intent();
          paramPreference.setClass((Context)this, FinderSettingPrivacyUI.class);
          paramf = getContext();
          paramPreference = new com.tencent.mm.hellhoundlib.b.a().ba(paramPreference);
          com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.aeD(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramf.startActivity((Intent)paramPreference.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          if (paramf.Euw == 2)
          {
            paramPreference = new ut();
            paramPreference.dxt.userName = paramf.Eux;
            paramPreference.dxt.dxv = paramf.Euy;
            paramPreference.dxt.scene = 1201;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)paramPreference);
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
    AppMethodBeat.i(203362);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene ");
    if (paramn != null) {}
    for (paramString = Integer.valueOf(paramn.getType());; paramString = null)
    {
      ac.i(str, paramString + " scene:" + paramn);
      paramString = localObject;
      if (paramn != null) {
        paramString = Integer.valueOf(paramn.getType());
      }
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(203362);
      return;
    }
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(203362);
        throw paramString;
      }
      this.rsp = ((aq)paramn).csO();
      if (this.rsp != null) {
        cL();
      }
    }
    AppMethodBeat.o(203362);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167610);
      this.rLD.finish();
      AppMethodBeat.o(167610);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167611);
      FinderSettingInfoUI.a(this.rLD);
      AppMethodBeat.o(167611);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$1", "Lcom/tencent/mm/ui/base/preference/HeadImgAndNamePreference$IAvatarLoaderEx;", "loadAvatar", "", "username", "", "icon", "Landroid/widget/ImageView;", "isRound", "", "plugin-finder_release"})
  public static final class c
    implements HeadImgAndNamePreference.a
  {
    public final void b(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(167612);
      d.g.b.k.h(paramString, "username");
      d.g.b.k.h(paramImageView, "icon");
      if (FinderSettingInfoUI.b(this.rLD) == null)
      {
        ac.e(FinderSettingInfoUI.c(this.rLD), "error self contact is null");
        AppMethodBeat.o(167612);
        return;
      }
      paramString = h.rtK;
      paramString = h.cwo();
      Object localObject = FinderSettingInfoUI.b(this.rLD);
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      localObject = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.f)localObject).field_avatarUrl);
      h localh = h.rtK;
      paramString.a(localObject, paramImageView, h.a(h.a.rtN));
      AppMethodBeat.o(167612);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167613);
      if (FinderSettingInfoUI.d(this.rLD) != null)
      {
        paramView = new Intent();
        Object localObject = FinderSettingInfoUI.b(this.rLD);
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        paramView.putStringArrayListExtra("key_url_list", j.ab(new String[] { ((com.tencent.mm.plugin.finder.api.f)localObject).crZ() }));
        paramView.putExtra("key_preview_avatar", true);
        localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.G((Context)this.rLD, paramView);
      }
      AppMethodBeat.o(167613);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingInfoUI
 * JD-Core Version:    0.7.0.1
 */