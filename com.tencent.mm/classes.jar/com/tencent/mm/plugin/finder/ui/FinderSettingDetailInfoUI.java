package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.m;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.service.m;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.bfm;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.f.a;
import java.util.HashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_DISTRICT", "REQUEST_SEX", "TAG", "", "myFinderUser", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showProgress", "updateView", "plugin-finder_release"})
public class FinderSettingDetailInfoUI
  extends MMPreference
  implements com.tencent.mm.an.i, aj<bfc>
{
  private ProgressDialog Apv;
  private final int Avd = 1002;
  private final int Ave = 1003;
  private final String TAG = "Finder.FinderSettingDetailInfoUI";
  private HashMap _$_findViewCache;
  private ble wZz;
  private final int xOK = 1000;
  private final int xOL = 1001;
  private String xTq;
  private com.tencent.mm.plugin.finder.api.i xTr;
  
  private static void doPrepareUser()
  {
    AppMethodBeat.i(167603);
    ch localch = new ch(2);
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)localch);
    AppMethodBeat.o(167603);
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(167604);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    this.xTr = d.a.aAK(Util.nullAsNil(this.xTq));
    if (this.xTr == null)
    {
      finish();
      AppMethodBeat.o(167604);
      return;
    }
    localObject1 = getPreferenceScreen().byG("settings_avatar");
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.HeadImgNewPreference");
      AppMethodBeat.o(167604);
      throw ((Throwable)localObject1);
    }
    localObject1 = (HeadImgNewPreference)localObject1;
    ((HeadImgNewPreference)localObject1).a((HeadImgNewPreference.a)new d(this));
    ((HeadImgNewPreference)localObject1).hKG();
    ((HeadImgNewPreference)localObject1).byF(this.xTq);
    ((HeadImgNewPreference)localObject1).j((View.OnClickListener)new e(this));
    Object localObject3 = getPreferenceScreen().byG("settings_nickname");
    ((Preference)localObject3).hLa();
    localObject1 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.VyF, 0);
    Log.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(i) });
    Object localObject2;
    if (((i & 0x2) != 0) && (this.wZz != null))
    {
      p.j(localObject3, "prefNickname");
      Object localObject4 = (Context)this;
      i = b.j.finder_nickname_verfiy_tip;
      localObject1 = this.wZz;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = ((ble)localObject1).verifyInfo;
      if (localObject1 != null)
      {
        localObject2 = ((bfm)localObject1).SQh;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((Preference)localObject3).aF((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject4, (CharSequence)getString(i, new Object[] { localObject1 })));
      localObject1 = getPreferenceScreen().byG("settings_signature");
      ((Preference)localObject1).hLa();
      p.j(localObject1, "prefSignature");
      localObject2 = (Context)this;
      localObject3 = this.xTr;
      if (localObject3 == null) {
        p.iCn();
      }
      ((Preference)localObject1).aF((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)((com.tencent.mm.plugin.finder.api.i)localObject3).field_signature));
      localObject1 = getPreferenceScreen().byG("settings_sex");
      localObject2 = this.xTr;
      if (localObject2 == null) {
        break label729;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.api.i)localObject2).field_authInfo;
      if ((localObject2 == null) || (((FinderAuthInfo)localObject2).authIconType != 2)) {
        break label729;
      }
      i = 1;
      label379:
      if (i == 0) {
        break label734;
      }
      p.j(localObject1, "prefSex");
      ((Preference)localObject1).aF((CharSequence)getString(b.j.finder_sex_enterprise_tip));
      ((Preference)localObject1).auO(8);
      ((Preference)localObject1).setEnabled(false);
      localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      i = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.Vzn, 0);
      Log.i(this.TAG, "updateView userExtFlag:".concat(String.valueOf(i)));
      localObject1 = getPreferenceScreen().byG("settings_district");
      if ((i & 0x4) <= 0) {
        break label987;
      }
      localObject2 = this.xTr;
      if (localObject2 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.finder.api.i)localObject2).field_extInfo;
        if (localObject4 != null)
        {
          Log.i(this.TAG, "countryCode " + ((ard)localObject4).country + " provinceCode " + ((ard)localObject4).province + " cityCode " + ((ard)localObject4).city);
          RegionCodeDecoder.hAC();
          localObject2 = RegionCodeDecoder.bxo(((ard)localObject4).country);
          RegionCodeDecoder.hAC();
          localObject3 = RegionCodeDecoder.nN(((ard)localObject4).country, ((ard)localObject4).province);
          RegionCodeDecoder.hAC();
          localObject4 = RegionCodeDecoder.bm(((ard)localObject4).country, ((ard)localObject4).province, ((ard)localObject4).city);
          if (Util.isNullOrNil((String)localObject4)) {
            break label893;
          }
          p.j(localObject1, "prefDistrict");
          ((Preference)localObject1).aF((CharSequence)(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PL((String)localObject3) + " " + (String)localObject4));
        }
      }
    }
    label729:
    label987:
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(167604);
      return;
      p.j(localObject3, "prefNickname");
      localObject1 = (Context)this;
      localObject2 = this.xTr;
      if (localObject2 == null) {
        p.iCn();
      }
      ((Preference)localObject3).aF((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)((com.tencent.mm.plugin.finder.api.i)localObject2).getNickname()));
      break;
      i = 0;
      break label379;
      label734:
      localObject2 = this.xTr;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.api.i)localObject2).field_extInfo;
        if (localObject2 != null)
        {
          Log.i(this.TAG, "sex " + ((ard)localObject2).sex);
          if (((ard)localObject2).sex == 1)
          {
            p.j(localObject1, "prefSex");
            ((Preference)localObject1).aF((CharSequence)getString(b.j.sex_male));
          }
        }
      }
      for (;;)
      {
        ((Preference)localObject1).auO(0);
        ((Preference)localObject1).setEnabled(true);
        break;
        if (((ard)localObject2).sex == 2)
        {
          p.j(localObject1, "prefSex");
          ((Preference)localObject1).aF((CharSequence)getString(b.j.sex_female));
        }
        else
        {
          p.j(localObject1, "prefSex");
          ((Preference)localObject1).aF((CharSequence)"");
          continue;
          p.j(localObject1, "prefSex");
          ((Preference)localObject1).aF((CharSequence)"");
        }
      }
      label893:
      if (!Util.isNullOrNil((String)localObject3))
      {
        p.j(localObject1, "prefDistrict");
        ((Preference)localObject1).aF((CharSequence)((String)localObject2 + ' ' + (String)localObject3));
      }
      else if (!Util.isNullOrNil((String)localObject2))
      {
        p.j(localObject1, "prefDistrict");
        ((Preference)localObject1).aF((CharSequence)localObject2);
      }
      else
      {
        p.j(localObject1, "prefDistrict");
        ((Preference)localObject1).aF((CharSequence)"");
        continue;
        p.j(localObject1, "prefDistrict");
        ((Preference)localObject1).aF((CharSequence)"");
      }
    }
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(272325);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(272325);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(272324);
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
    AppMethodBeat.o(272324);
    return localView1;
  }
  
  public int getResourceId()
  {
    return b.m.finder_setting_detail_info_pref;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(167608);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.xOK)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.b.h((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.bbW());
        if ((!Util.isNullOrNil(paramIntent)) && (com.tencent.mm.vfs.u.agG(paramIntent)))
        {
          getIntent().putExtra("key_source_img_path", paramIntent);
          paramIntent = com.tencent.mm.plugin.finder.utils.a.ACH;
          com.tencent.mm.plugin.finder.utils.a.c((Activity)this, getIntent(), this.xOL);
          AppMethodBeat.o(167608);
          return;
        }
        Log.w(this.TAG, "no img select");
        AppMethodBeat.o(167608);
      }
    }
    else
    {
      if (paramInt1 != this.xOL) {
        break label285;
      }
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        paramIntent = paramIntent.getStringExtra("key_result_img_path");
        if ((Util.isNullOrNil(paramIntent)) || (!com.tencent.mm.vfs.u.agG(paramIntent))) {
          break label268;
        }
        Log.i(this.TAG, "avatar file length %d KB", new Object[] { Long.valueOf(com.tencent.mm.vfs.u.bBQ(paramIntent) / 1024L) });
        localObject1 = (m)com.tencent.mm.kernel.h.ae(m.class);
        p.j(paramIntent, "avatarPath");
        ((m)localObject1).c(paramIntent, (aj)this);
        paramIntent = this.Apv;
        if (paramIntent != null) {
          paramIntent.dismiss();
        }
        this.Apv = ((ProgressDialog)com.tencent.mm.ui.base.h.a((Context)this, getString(b.j.app_sending), false, null));
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
      if (paramInt1 != this.Avd) {
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
    if (p.h(localObject1, "unshow"))
    {
      localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      paramInt1 = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.Vzn, 0);
      localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.Vzn, Integer.valueOf(paramInt1 & 0xFFFFFFFB));
      localObject1 = "";
    }
    label570:
    label980:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      localObject3 = this.xTr;
      Object localObject4;
      if (localObject3 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.finder.api.i)localObject3).field_extInfo;
        if (localObject4 == null) {
          break label570;
        }
        ((ard)localObject4).country = ((String)localObject1);
        ((ard)localObject4).province = ((String)localObject2);
      }
      for (((ard)localObject4).city = paramIntent;; ((com.tencent.mm.plugin.finder.api.i)localObject3).field_extInfo.city = paramIntent)
      {
        localObject4 = com.tencent.mm.plugin.finder.api.d.wZQ;
        d.a.c((com.tencent.mm.plugin.finder.api.i)localObject3);
        ((m)com.tencent.mm.kernel.h.ae(m.class)).a((String)localObject1, (String)localObject2, paramIntent, paramInt1, (aj)this);
        break;
        ((com.tencent.mm.plugin.finder.api.i)localObject3).field_extInfo = new ard();
        ((com.tencent.mm.plugin.finder.api.i)localObject3).field_extInfo.country = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.api.i)localObject3).field_extInfo.province = ((String)localObject2);
      }
      if ((paramInt1 != this.Ave) || (paramIntent == null) || (paramInt2 != -1)) {
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
        localObject1 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        paramInt1 = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.Vzn, 0);
        localObject1 = this.xTr;
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
        paramIntent = ((com.tencent.mm.plugin.finder.api.i)localObject1).field_extInfo;
        if (paramIntent != null)
        {
          paramIntent.sex = 2;
          paramIntent = com.tencent.mm.plugin.finder.api.d.wZQ;
          d.a.c((com.tencent.mm.plugin.finder.api.i)localObject1);
          paramIntent = com.tencent.mm.kernel.h.aHG();
          p.j(paramIntent, "MMKernel.storage()");
          paramIntent.aHp().set(ar.a.Vzn, Integer.valueOf(paramInt1 | 0x8));
          paramIntent = (m)com.tencent.mm.kernel.h.ae(m.class);
          localObject1 = ((com.tencent.mm.plugin.finder.api.i)localObject1).field_extInfo;
          if (localObject1 == null) {
            break label1009;
          }
        }
        break;
      }
      label877:
      label1009:
      for (paramInt1 = ((ard)localObject1).sex;; paramInt1 = 0)
      {
        paramIntent.a(paramInt1, (aj)this);
        break;
        if (!paramIntent.equals("male")) {
          break label736;
        }
        paramIntent = ((com.tencent.mm.plugin.finder.api.i)localObject1).field_extInfo;
        if (paramIntent != null)
        {
          paramIntent.sex = 1;
          paramIntent = com.tencent.mm.plugin.finder.api.d.wZQ;
          d.a.c((com.tencent.mm.plugin.finder.api.i)localObject1);
          paramIntent = com.tencent.mm.kernel.h.aHG();
          p.j(paramIntent, "MMKernel.storage()");
          paramIntent.aHp().set(ar.a.Vzn, Integer.valueOf(paramInt1 | 0x8));
          paramIntent = (m)com.tencent.mm.kernel.h.ae(m.class);
          localObject1 = ((com.tencent.mm.plugin.finder.api.i)localObject1).field_extInfo;
          if (localObject1 == null) {
            break label980;
          }
        }
        for (paramInt1 = ((ard)localObject1).sex;; paramInt1 = 0)
        {
          paramIntent.a(paramInt1, (aj)this);
          break;
          ((com.tencent.mm.plugin.finder.api.i)localObject1).field_extInfo = new ard();
          ((com.tencent.mm.plugin.finder.api.i)localObject1).field_extInfo.sex = 1;
          break label877;
        }
        ((com.tencent.mm.plugin.finder.api.i)localObject1).field_extInfo = new ard();
        ((com.tencent.mm.plugin.finder.api.i)localObject1).field_extInfo.sex = 2;
        break label773;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167601);
    super.onCreate(paramBundle);
    this.xTq = z.bdh();
    Log.i(this.TAG, "myFinderUser " + this.xTq);
    setMMTitle(b.j.finder_setting_detail_info);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    com.tencent.mm.kernel.h.aGY().a(3761, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(167601);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(167609);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(3761, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(167609);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int j = 0;
    AppMethodBeat.i(167605);
    if (paramPreference == null) {
      p.iCn();
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
            paramf = com.tencent.mm.plugin.findersdk.c.a.Bwg;
            if (!com.tencent.mm.plugin.findersdk.c.a.aGS("personalInfo")) {
              com.tencent.mm.pluginsdk.ui.tools.u.p((Activity)this, this.xOK);
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
    paramf = com.tencent.mm.kernel.h.aHG();
    p.j(paramf, "MMKernel.storage()");
    if ((paramf.aHp().getInt(ar.a.Vzn, 0) & 0x4) == 0) {
      ((Intent)localObject).putExtra("SelectedCountryCode", "unshow");
    }
    for (;;)
    {
      paramf = this.xTr;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.province;
          paramf = paramPreference;
          if (paramPreference != null) {
            break label264;
          }
        }
      }
      paramf = "";
      label264:
      ((Intent)localObject).putExtra("SelectedProvinceCode", paramf);
      paramf = this.xTr;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.city;
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
      c.d((Context)getContext(), ".ui.tools.MultiStageCitySelectUI", (Intent)localObject, this.Avd);
      break;
      if (!paramf.equals("settings_sex")) {
        break;
      }
      paramf = new Intent();
      paramPreference = com.tencent.mm.kernel.h.aHG();
      p.j(paramPreference, "MMKernel.storage()");
      int i;
      if ((paramPreference.aHp().getInt(ar.a.Vzn, 0) & 0x8) > 0)
      {
        paramPreference = this.xTr;
        i = j;
        if (paramPreference != null)
        {
          paramPreference = paramPreference.field_extInfo;
          i = j;
          if (paramPreference != null) {
            i = paramPreference.sex;
          }
        }
        if (i == 1) {
          paramf.putExtra("key_input_sex", "male");
        }
      }
      for (;;)
      {
        paramPreference = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.a((MMActivity)this, paramf, this.Ave);
        break;
        if (!paramf.equals("settings_signature")) {
          break;
        }
        paramf = new Intent();
        paramf.putExtra("key_scene", 2);
        paramPreference = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.N((Context)this, paramf);
        break;
        if (!paramf.equals("settings_nickname")) {
          break;
        }
        if (this.wZz != null)
        {
          paramf = com.tencent.mm.kernel.h.aHG();
          p.j(paramf, "MMKernel.storage()");
          i = paramf.aHp().getInt(ar.a.VyF, 0);
          Log.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(i) });
          paramf = com.tencent.mm.kernel.h.aHG();
          p.j(paramf, "MMKernel.storage()");
          localObject = paramf.aHp().get(ar.a.VCq, Integer.valueOf(0));
          Log.i(this.TAG, "auth_verify_identity %d", new Object[] { localObject });
          if ((i & 0x2) != 0)
          {
            r localr = (r)com.tencent.mm.kernel.h.ae(r.class);
            Context localContext = (Context)this;
            paramf = this.wZz;
            if (paramf == null) {
              p.iCn();
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
            paramPreference = this.wZz;
            if (paramPreference == null) {
              p.iCn();
            }
            paramPreference = paramPreference.verifyInfo;
            if (paramPreference != null)
            {
              localObject = paramPreference.SQg;
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
          paramf = new b(this);
          paramPreference = new c(this);
          if (!p.h(localObject, Integer.valueOf(1)))
          {
            if (p.h(localObject, Integer.valueOf(2)))
            {
              paramPreference.QA(b.j.finder_account_reviewing_content);
              break;
            }
            if (p.h(localObject, Integer.valueOf(3)))
            {
              localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
              localObject = d.a.aAK(z.bdh());
              if (localObject != null)
              {
                if (((com.tencent.mm.plugin.finder.api.i)localObject).field_authInfo.authIconType != 2) {
                  break label836;
                }
                paramPreference.QA(b.j.finder_account_auth_content);
              }
              for (;;)
              {
                paramPreference.QA(b.j.finder_account_auth_content);
                break;
                label836:
                paramf.invoke();
              }
            }
          }
          paramf.invoke();
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
      paramf = this.xTr;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.country;
          paramf = paramPreference;
          if (paramPreference != null) {
            break label936;
          }
        }
      }
      paramf = "";
      label936:
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
      this.wZz = ((ch)paramq).dnR();
      if (this.wZz != null) {
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167598);
      this.Avf.finish();
      AppMethodBeat.o(167598);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"jumpModNameUI", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(274480);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_scene", 1);
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.N((Context)this.Avf, localIntent);
      AppMethodBeat.o(274480);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"showTipsDialog", "", "content", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    c(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI)
    {
      super();
    }
    
    public final void QA(int paramInt)
    {
      AppMethodBeat.i(282808);
      f.a locala = new f.a(MMApplicationContext.getContext());
      locala.bBl(this.Avf.getString(paramInt)).HL(true);
      locala.bBp(this.Avf.getString(b.j.finder_account_review_confirm));
      locala.icD();
      locala.show();
      AppMethodBeat.o(282808);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$1", "Lcom/tencent/mm/ui/base/preference/HeadImgNewPreference$IAvatarLoaderEx;", "loadAvatar", "", "username", "", "icon", "Landroid/widget/ImageView;", "isRound", "", "plugin-finder_release"})
  public static final class d
    implements HeadImgNewPreference.a
  {
    public final void b(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(167599);
      p.k(paramString, "username");
      p.k(paramImageView, "icon");
      if (FinderSettingDetailInfoUI.a(this.Avf) == null)
      {
        Log.e(FinderSettingDetailInfoUI.b(this.Avf), "error self contact is null");
        AppMethodBeat.o(167599);
        return;
      }
      paramString = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramString = com.tencent.mm.plugin.finder.loader.t.dJh();
      Object localObject = FinderSettingDetailInfoUI.a(this.Avf);
      if (localObject == null) {
        p.iCn();
      }
      localObject = new e(((com.tencent.mm.plugin.finder.api.i)localObject).field_avatarUrl);
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramString.a(localObject, paramImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      AppMethodBeat.o(167599);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167600);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (FinderSettingDetailInfoUI.c(this.Avf) != null)
      {
        paramView = new Intent();
        localObject = FinderSettingDetailInfoUI.a(this.Avf);
        if (localObject == null) {
          p.iCn();
        }
        paramView.putStringArrayListExtra("key_url_list", j.ag(new String[] { ((com.tencent.mm.plugin.finder.api.i)localObject).Mm() }));
        paramView.putExtra("key_preview_avatar", true);
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.M((Context)this.Avf, paramView);
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