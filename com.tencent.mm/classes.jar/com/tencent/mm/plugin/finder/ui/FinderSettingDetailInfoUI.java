package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.x;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import kotlin.a.j;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_DISTRICT", "REQUEST_SEX", "TAG", "", "myFinderUser", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showProgress", "updateView", "plugin-finder_release"})
public class FinderSettingDetailInfoUI
  extends MMPreference
  implements i, ai<azg>
{
  private final String TAG = "Finder.FinderSettingDetailInfoUI";
  private HashMap _$_findViewCache;
  private bed udb;
  private ProgressDialog vIA;
  private final int vIw = 1000;
  private final int vIx = 1001;
  private final int vOj = 1002;
  private final int vOk = 1003;
  private String vOl;
  private com.tencent.mm.plugin.finder.api.g vOm;
  
  private static void doPrepareUser()
  {
    AppMethodBeat.i(167603);
    cd localcd = new cd(2);
    com.tencent.mm.kernel.g.azz().b((q)localcd);
    AppMethodBeat.o(167603);
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(167604);
    Object localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
    this.vOm = c.a.asG(Util.nullAsNil(this.vOl));
    if (this.vOm == null)
    {
      finish();
      AppMethodBeat.o(167604);
      return;
    }
    localObject1 = getPreferenceScreen().bmg("settings_avatar");
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.HeadImgNewPreference");
      AppMethodBeat.o(167604);
      throw ((Throwable)localObject1);
    }
    localObject1 = (HeadImgNewPreference)localObject1;
    ((HeadImgNewPreference)localObject1).a((HeadImgNewPreference.a)new b(this));
    ((HeadImgNewPreference)localObject1).gLE();
    ((HeadImgNewPreference)localObject1).bmf(this.vOl);
    ((HeadImgNewPreference)localObject1).h((View.OnClickListener)new c(this));
    Object localObject3 = getPreferenceScreen().bmg("settings_nickname");
    ((Preference)localObject3).gLS();
    localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    int i = ((e)localObject1).azQ().getInt(ar.a.Okh, 0);
    Log.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(i) });
    Object localObject2;
    if (((i & 0x2) != 0) && (this.udb != null))
    {
      p.g(localObject3, "prefNickname");
      Object localObject4 = (Context)this;
      localObject1 = this.udb;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((bed)localObject1).verifyInfo;
      if (localObject1 != null)
      {
        localObject2 = ((azn)localObject1).LJq;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((Preference)localObject3).setSummary((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject4, (CharSequence)getString(2131760337, new Object[] { localObject1 })));
      localObject1 = getPreferenceScreen().bmg("settings_signature");
      ((Preference)localObject1).gLS();
      p.g(localObject1, "prefSignature");
      localObject2 = (Context)this;
      localObject3 = this.vOm;
      if (localObject3 == null) {
        p.hyc();
      }
      ((Preference)localObject1).setSummary((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject3).field_signature));
      localObject1 = getPreferenceScreen().bmg("settings_sex");
      localObject2 = this.vOm;
      if (localObject2 == null) {
        break label727;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_authInfo;
      if ((localObject2 == null) || (((FinderAuthInfo)localObject2).authIconType != 2)) {
        break label727;
      }
      i = 1;
      label377:
      if (i == 0) {
        break label732;
      }
      p.g(localObject1, "prefSex");
      ((Preference)localObject1).setSummary((CharSequence)getString(2131760564));
      ((Preference)localObject1).alO(8);
      ((Preference)localObject1).setEnabled(false);
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      i = ((e)localObject1).azQ().getInt(ar.a.Okw, 0);
      Log.i(this.TAG, "updateView userExtFlag:".concat(String.valueOf(i)));
      localObject1 = getPreferenceScreen().bmg("settings_district");
      if ((i & 0x4) <= 0) {
        break label985;
      }
      localObject2 = this.vOm;
      if (localObject2 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_extInfo;
        if (localObject4 != null)
        {
          Log.i(this.TAG, "countryCode " + ((app)localObject4).country + " provinceCode " + ((app)localObject4).fuJ + " cityCode " + ((app)localObject4).fuK);
          RegionCodeDecoder.gEm();
          localObject2 = RegionCodeDecoder.getCountry(((app)localObject4).country);
          RegionCodeDecoder.gEm();
          localObject3 = RegionCodeDecoder.mV(((app)localObject4).country, ((app)localObject4).fuJ);
          RegionCodeDecoder.gEm();
          localObject4 = RegionCodeDecoder.br(((app)localObject4).country, ((app)localObject4).fuJ, ((app)localObject4).fuK);
          if (Util.isNullOrNil((String)localObject4)) {
            break label891;
          }
          p.g(localObject1, "prefDistrict");
          ((Preference)localObject1).setSummary((CharSequence)(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).It((String)localObject3) + " " + (String)localObject4));
        }
      }
    }
    label727:
    label985:
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(167604);
      return;
      p.g(localObject3, "prefNickname");
      localObject1 = (Context)this;
      localObject2 = this.vOm;
      if (localObject2 == null) {
        p.hyc();
      }
      ((Preference)localObject3).setSummary((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject2).getNickname()));
      break;
      i = 0;
      break label377;
      label732:
      localObject2 = this.vOm;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_extInfo;
        if (localObject2 != null)
        {
          Log.i(this.TAG, "sex " + ((app)localObject2).fuA);
          if (((app)localObject2).fuA == 1)
          {
            p.g(localObject1, "prefSex");
            ((Preference)localObject1).setSummary((CharSequence)getString(2131765721));
          }
        }
      }
      for (;;)
      {
        ((Preference)localObject1).alO(0);
        ((Preference)localObject1).setEnabled(true);
        break;
        if (((app)localObject2).fuA == 2)
        {
          p.g(localObject1, "prefSex");
          ((Preference)localObject1).setSummary((CharSequence)getString(2131765720));
        }
        else
        {
          p.g(localObject1, "prefSex");
          ((Preference)localObject1).setSummary((CharSequence)"");
          continue;
          p.g(localObject1, "prefSex");
          ((Preference)localObject1).setSummary((CharSequence)"");
        }
      }
      label891:
      if (!Util.isNullOrNil((String)localObject3))
      {
        p.g(localObject1, "prefDistrict");
        ((Preference)localObject1).setSummary((CharSequence)((String)localObject2 + ' ' + (String)localObject3));
      }
      else if (!Util.isNullOrNil((String)localObject2))
      {
        p.g(localObject1, "prefDistrict");
        ((Preference)localObject1).setSummary((CharSequence)localObject2);
      }
      else
      {
        p.g(localObject1, "prefDistrict");
        ((Preference)localObject1).setSummary((CharSequence)"");
        continue;
        p.g(localObject1, "prefDistrict");
        ((Preference)localObject1).setSummary((CharSequence)"");
      }
    }
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252666);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252666);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252665);
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
    AppMethodBeat.o(252665);
    return localView1;
  }
  
  public int getResourceId()
  {
    return 2132017221;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(167608);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.vIw)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.a.i((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.aSY());
        if ((!Util.isNullOrNil(paramIntent)) && (com.tencent.mm.vfs.s.YS(paramIntent)))
        {
          getIntent().putExtra("key_source_img_path", paramIntent);
          paramIntent = com.tencent.mm.plugin.finder.utils.a.vUU;
          com.tencent.mm.plugin.finder.utils.a.b((Activity)this, getIntent(), this.vIx);
          AppMethodBeat.o(167608);
          return;
        }
        Log.w(this.TAG, "no img select");
        AppMethodBeat.o(167608);
      }
    }
    else
    {
      if (paramInt1 != this.vIx) {
        break label285;
      }
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        paramIntent = paramIntent.getStringExtra("key_result_img_path");
        if ((Util.isNullOrNil(paramIntent)) || (!com.tencent.mm.vfs.s.YS(paramIntent))) {
          break label268;
        }
        Log.i(this.TAG, "avatar file length %d KB", new Object[] { Long.valueOf(com.tencent.mm.vfs.s.boW(paramIntent) / 1024L) });
        localObject1 = (x)com.tencent.mm.kernel.g.af(x.class);
        p.g(paramIntent, "avatarPath");
        ((x)localObject1).c(paramIntent, (ai)this);
        paramIntent = this.vIA;
        if (paramIntent != null) {
          paramIntent.dismiss();
        }
        this.vIA = ((ProgressDialog)h.a((Context)this, getString(2131755978), false, null));
      }
    }
    label261:
    label268:
    label285:
    do
    {
      AppMethodBeat.o(167608);
      return;
      Log.w(this.TAG, "no avatar set");
      AppMethodBeat.o(167608);
      return;
      if (paramInt1 != this.vOj) {
        break;
      }
    } while ((paramIntent == null) || (paramInt2 != -1));
    Object localObject2 = paramIntent.getStringExtra("Country");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = paramIntent.getStringExtra("Contact_Province");
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    localObject3 = paramIntent.getStringExtra("Contact_City");
    paramIntent = (Intent)localObject3;
    if (localObject3 == null) {
      paramIntent = "";
    }
    Log.i(this.TAG, "countryCode " + (String)localObject1 + " provinceCode" + (String)localObject2 + " cityCode" + paramIntent);
    if (p.j(localObject1, "unshow"))
    {
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      paramInt1 = ((e)localObject1).azQ().getInt(ar.a.Okw, 0);
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      ((e)localObject1).azQ().set(ar.a.Okw, Integer.valueOf(paramInt1 & 0xFFFFFFFB));
      localObject1 = "";
    }
    label570:
    label980:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      localObject3 = this.vOm;
      Object localObject4;
      if (localObject3 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo;
        if (localObject4 == null) {
          break label570;
        }
        ((app)localObject4).country = ((String)localObject1);
        ((app)localObject4).fuJ = ((String)localObject2);
      }
      for (((app)localObject4).fuK = paramIntent;; ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo.fuK = paramIntent)
      {
        localObject4 = com.tencent.mm.plugin.finder.api.c.tsp;
        c.a.c((com.tencent.mm.plugin.finder.api.g)localObject3);
        ((x)com.tencent.mm.kernel.g.af(x.class)).a((String)localObject1, (String)localObject2, paramIntent, paramInt1, (ai)this);
        break;
        ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo = new app();
        ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo.country = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo.fuJ = ((String)localObject2);
      }
      if ((paramInt1 != this.vOk) || (paramIntent == null) || (paramInt2 != -1)) {
        break label261;
      }
      localObject1 = paramIntent.getStringExtra("key_output_sex");
      paramIntent = (Intent)localObject1;
      if (localObject1 == null) {
        paramIntent = "";
      }
      if (((CharSequence)paramIntent).length() > 0)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label261;
        }
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        paramInt1 = ((e)localObject1).azQ().getInt(ar.a.Okw, 0);
        localObject1 = this.vOm;
        if (localObject1 == null) {
          break;
        }
      }
      switch (paramIntent.hashCode())
      {
      default: 
      case -1278174388: 
        label736:
        do
        {
          AppMethodBeat.o(167608);
          return;
          paramInt1 = 0;
          break;
        } while (!paramIntent.equals("female"));
        paramIntent = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo;
        if (paramIntent != null)
        {
          paramIntent.fuA = 2;
          paramIntent = com.tencent.mm.plugin.finder.api.c.tsp;
          c.a.c((com.tencent.mm.plugin.finder.api.g)localObject1);
          paramIntent = com.tencent.mm.kernel.g.aAh();
          p.g(paramIntent, "MMKernel.storage()");
          paramIntent.azQ().set(ar.a.Okw, Integer.valueOf(paramInt1 | 0x8));
          paramIntent = (x)com.tencent.mm.kernel.g.af(x.class);
          localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo;
          if (localObject1 == null) {
            break label1009;
          }
        }
        break;
      }
      label877:
      label1009:
      for (paramInt1 = ((app)localObject1).fuA;; paramInt1 = 0)
      {
        paramIntent.a(paramInt1, (ai)this);
        break;
        if (!paramIntent.equals("male")) {
          break label736;
        }
        paramIntent = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo;
        if (paramIntent != null)
        {
          paramIntent.fuA = 1;
          paramIntent = com.tencent.mm.plugin.finder.api.c.tsp;
          c.a.c((com.tencent.mm.plugin.finder.api.g)localObject1);
          paramIntent = com.tencent.mm.kernel.g.aAh();
          p.g(paramIntent, "MMKernel.storage()");
          paramIntent.azQ().set(ar.a.Okw, Integer.valueOf(paramInt1 | 0x8));
          paramIntent = (x)com.tencent.mm.kernel.g.af(x.class);
          localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo;
          if (localObject1 == null) {
            break label980;
          }
        }
        for (paramInt1 = ((app)localObject1).fuA;; paramInt1 = 0)
        {
          paramIntent.a(paramInt1, (ai)this);
          break;
          ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo = new app();
          ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo.fuA = 1;
          break label877;
        }
        ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo = new app();
        ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo.fuA = 2;
        break label773;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167601);
    super.onCreate(paramBundle);
    this.vOl = z.aUg();
    Log.i(this.TAG, "myFinderUser " + this.vOl);
    setMMTitle(2131760558);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    com.tencent.mm.kernel.g.azz().a(3761, (i)this);
    AppMethodBeat.o(167601);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(167609);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(3761, (i)this);
    AppMethodBeat.o(167609);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    int j = 0;
    AppMethodBeat.i(167605);
    if (paramPreference == null) {
      p.hyc();
    }
    paramf = paramPreference.getKey();
    Log.i(this.TAG, "click ".concat(String.valueOf(paramf)));
    if (paramf == null) {}
    do
    {
      for (;;)
      {
        AppMethodBeat.o(167605);
        return true;
        switch (paramf.hashCode())
        {
        default: 
          break;
        case -1298291467: 
          if (paramf.equals("settings_avatar"))
          {
            paramf = com.tencent.mm.plugin.finder.spam.a.vwk;
            if (!com.tencent.mm.plugin.finder.spam.a.avp("personalInfo")) {
              com.tencent.mm.pluginsdk.ui.tools.s.o((Activity)this, this.vIw);
            }
          }
          break;
        }
      }
    } while (!paramf.equals("settings_district"));
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("GetAddress", true);
    ((Intent)localObject).putExtra("ShowSelectedLocation", true);
    ((Intent)localObject).putExtra("SetSelectLocation", true);
    paramf = com.tencent.mm.kernel.g.aAh();
    p.g(paramf, "MMKernel.storage()");
    if ((paramf.azQ().getInt(ar.a.Okw, 0) & 0x4) == 0) {
      ((Intent)localObject).putExtra("SelectedCountryCode", "unshow");
    }
    for (;;)
    {
      paramf = this.vOm;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.fuJ;
          paramf = paramPreference;
          if (paramPreference != null) {
            break label264;
          }
        }
      }
      paramf = "";
      label264:
      ((Intent)localObject).putExtra("SelectedProvinceCode", paramf);
      paramf = this.vOm;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.fuK;
          paramf = paramPreference;
          if (paramPreference != null) {
            break label307;
          }
        }
      }
      paramf = "";
      label307:
      ((Intent)localObject).putExtra("SelectedCityCode", paramf);
      ((Intent)localObject).putExtra("NeedUnshowItem", false);
      com.tencent.mm.br.c.c((Context)getContext(), ".ui.tools.MultiStageCitySelectUI", (Intent)localObject, this.vOj);
      break;
      if (!paramf.equals("settings_sex")) {
        break;
      }
      paramf = new Intent();
      paramPreference = com.tencent.mm.kernel.g.aAh();
      p.g(paramPreference, "MMKernel.storage()");
      int i;
      if ((paramPreference.azQ().getInt(ar.a.Okw, 0) & 0x8) > 0)
      {
        paramPreference = this.vOm;
        i = j;
        if (paramPreference != null)
        {
          paramPreference = paramPreference.field_extInfo;
          i = j;
          if (paramPreference != null) {
            i = paramPreference.fuA;
          }
        }
        if (i == 1) {
          paramf.putExtra("key_input_sex", "male");
        }
      }
      for (;;)
      {
        paramPreference = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.a((MMActivity)this, paramf, this.vOk);
        break;
        if (!paramf.equals("settings_signature")) {
          break;
        }
        paramf = new Intent();
        paramf.putExtra("key_scene", 2);
        paramPreference = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.N((Context)this, paramf);
        break;
        if (!paramf.equals("settings_nickname")) {
          break;
        }
        if (this.udb != null)
        {
          paramf = com.tencent.mm.kernel.g.aAh();
          p.g(paramf, "MMKernel.storage()");
          i = paramf.azQ().getInt(ar.a.Okh, 0);
          Log.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(i) });
          if ((i & 0x2) != 0)
          {
            r localr = (r)com.tencent.mm.kernel.g.af(r.class);
            Context localContext = (Context)this;
            paramf = this.udb;
            if (paramf == null) {
              p.hyc();
            }
            paramf = paramf.verifyInfo;
            if (paramf != null)
            {
              paramPreference = paramf.appName;
              paramf = paramPreference;
              if (paramPreference != null) {}
            }
            else
            {
              paramf = "";
            }
            paramPreference = this.udb;
            if (paramPreference == null) {
              p.hyc();
            }
            paramPreference = paramPreference.verifyInfo;
            if (paramPreference != null)
            {
              localObject = paramPreference.LJp;
              paramPreference = (Preference)localObject;
              if (localObject != null) {}
            }
            else
            {
              paramPreference = "";
            }
            localr.a(localContext, paramf, null, 0, 0, paramPreference, new AppBrandStatObject());
            break;
          }
          paramf = new Intent();
          paramf.putExtra("key_scene", 1);
          paramPreference = com.tencent.mm.plugin.finder.utils.a.vUU;
          com.tencent.mm.plugin.finder.utils.a.N((Context)this, paramf);
          break;
        }
        doPrepareUser();
        break;
        if (i == 2)
        {
          paramf.putExtra("key_input_sex", "female");
        }
        else
        {
          paramf.putExtra("key_input_sex", "");
          continue;
          paramf.putExtra("key_input_sex", "");
        }
      }
      paramf = this.vOm;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.country;
          paramf = paramPreference;
          if (paramPreference != null) {
            break label798;
          }
        }
      }
      paramf = "";
      label798:
      ((Intent)localObject).putExtra("SelectedCountryCode", paramf);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(167602);
    super.onResume();
    doPrepareUser();
    updateView();
    AppMethodBeat.o(167602);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Object localObject = null;
    AppMethodBeat.i(167607);
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
      AppMethodBeat.o(167607);
      return;
    }
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(167607);
        throw paramString;
      }
      this.udb = ((cd)paramq).cZc();
      if (this.udb != null) {
        updateView();
      }
    }
    AppMethodBeat.o(167607);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167598);
      this.vOn.finish();
      AppMethodBeat.o(167598);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$1", "Lcom/tencent/mm/ui/base/preference/HeadImgNewPreference$IAvatarLoaderEx;", "loadAvatar", "", "username", "", "icon", "Landroid/widget/ImageView;", "isRound", "", "plugin-finder_release"})
  public static final class b
    implements HeadImgNewPreference.a
  {
    public final void b(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(167599);
      p.h(paramString, "username");
      p.h(paramImageView, "icon");
      if (FinderSettingDetailInfoUI.a(this.vOn) == null)
      {
        Log.e(FinderSettingDetailInfoUI.b(this.vOn), "error self contact is null");
        AppMethodBeat.o(167599);
        return;
      }
      paramString = m.uJa;
      paramString = m.dka();
      Object localObject = FinderSettingDetailInfoUI.a(this.vOn);
      if (localObject == null) {
        p.hyc();
      }
      localObject = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject).field_avatarUrl);
      m localm = m.uJa;
      paramString.a(localObject, paramImageView, m.a(m.a.uJe));
      AppMethodBeat.o(167599);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167600);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (FinderSettingDetailInfoUI.c(this.vOn) != null)
      {
        paramView = new Intent();
        localObject = FinderSettingDetailInfoUI.a(this.vOn);
        if (localObject == null) {
          p.hyc();
        }
        paramView.putStringArrayListExtra("key_url_list", j.ac(new String[] { ((com.tencent.mm.plugin.finder.api.g)localObject).cXH() }));
        paramView.putExtra("key_preview_avatar", true);
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.M((Context)this.vOn, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167600);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingDetailInfoUI
 * JD-Core Version:    0.7.0.1
 */