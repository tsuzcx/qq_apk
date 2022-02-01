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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.aje;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import d.a.j;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_DISTRICT", "REQUEST_SEX", "TAG", "", "myFinderUser", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showProgress", "updateView", "plugin-finder_release"})
public class FinderSettingDetailInfoUI
  extends MMPreference
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.i.a.k<amj>
{
  private final String TAG = "Finder.FinderSettingDetailInfoUI";
  private final int rGm = 1000;
  private final int rGn = 1001;
  private ProgressDialog rGq;
  private String rJO;
  private final int rLA = 1003;
  private com.tencent.mm.plugin.finder.api.f rLB;
  private final int rLz = 1002;
  private aoy rsp;
  
  private final void cL()
  {
    AppMethodBeat.i(167604);
    Object localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
    localObject1 = bs.nullAsNil(this.rJO);
    d.g.b.k.g(localObject1, "Util.nullAsNil(myFinderUser)");
    this.rLB = b.a.adh((String)localObject1);
    if (this.rLB == null)
    {
      finish();
      AppMethodBeat.o(167604);
      return;
    }
    localObject1 = getPreferenceScreen().aPN("settings_avatar");
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.HeadImgNewPreference");
      AppMethodBeat.o(167604);
      throw ((Throwable)localObject1);
    }
    localObject1 = (HeadImgNewPreference)localObject1;
    ((HeadImgNewPreference)localObject1).a((HeadImgNewPreference.a)new b(this));
    ((HeadImgNewPreference)localObject1).fjk();
    ((HeadImgNewPreference)localObject1).aPM(this.rJO);
    ((HeadImgNewPreference)localObject1).f((View.OnClickListener)new c(this));
    localObject1 = getPreferenceScreen().aPN("settings_nickname");
    ((Preference)localObject1).fju();
    Object localObject2 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    int i = ((e)localObject2).agA().getInt(ah.a.GUi, 0);
    ac.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(i) });
    Object localObject3;
    if (((i & 0x2) != 0) && (this.rsp != null))
    {
      d.g.b.k.g(localObject1, "prefNickname");
      localObject2 = (Context)this;
      localObject3 = this.rsp;
      if (localObject3 == null) {
        d.g.b.k.fOy();
      }
      ((Preference)localObject1).setSummary((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)getString(2131759285, new Object[] { ((aoy)localObject3).verifyInfo.EFK })));
      localObject1 = getPreferenceScreen().aPN("settings_signature");
      ((Preference)localObject1).fju();
      d.g.b.k.g(localObject1, "prefSignature");
      localObject2 = (Context)this;
      localObject3 = this.rLB;
      if (localObject3 == null) {
        d.g.b.k.fOy();
      }
      ((Preference)localObject1).setSummary((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject3).field_signature));
      localObject1 = getPreferenceScreen().aPN("settings_sex");
      localObject2 = this.rLB;
      if (localObject2 == null) {
        break label712;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.api.f)localObject2).field_authInfo;
      if ((localObject2 == null) || (((FinderAuthInfo)localObject2).authIconType != 2)) {
        break label712;
      }
      i = 1;
      label362:
      if (i == 0) {
        break label717;
      }
      d.g.b.k.g(localObject1, "prefSex");
      ((Preference)localObject1).setSummary((CharSequence)getString(2131766496));
      ((Preference)localObject1).aam(8);
      ((Preference)localObject1).setEnabled(false);
      localObject1 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      i = ((e)localObject1).agA().getInt(ah.a.GUq, 0);
      ac.i(this.TAG, "updateView userExtFlag:".concat(String.valueOf(i)));
      localObject1 = getPreferenceScreen().aPN("settings_district");
      if ((i & 0x4) <= 0) {
        break label970;
      }
      localObject2 = this.rLB;
      if (localObject2 != null)
      {
        Object localObject4 = ((com.tencent.mm.plugin.finder.api.f)localObject2).field_extInfo;
        if (localObject4 != null)
        {
          ac.i(this.TAG, "countryCode " + ((aje)localObject4).country + " provinceCode " + ((aje)localObject4).exV + " cityCode " + ((aje)localObject4).exW);
          RegionCodeDecoder.fcs();
          localObject2 = RegionCodeDecoder.getCountry(((aje)localObject4).country);
          RegionCodeDecoder.fcs();
          localObject3 = RegionCodeDecoder.lC(((aje)localObject4).country, ((aje)localObject4).exV);
          RegionCodeDecoder.fcs();
          localObject4 = RegionCodeDecoder.aX(((aje)localObject4).country, ((aje)localObject4).exV, ((aje)localObject4).exW);
          if (bs.isNullOrNil((String)localObject4)) {
            break label876;
          }
          d.g.b.k.g(localObject1, "prefDistrict");
          ((Preference)localObject1).setSummary((CharSequence)(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wm((String)localObject3) + " " + (String)localObject4));
        }
      }
    }
    label712:
    label970:
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(167604);
      return;
      d.g.b.k.g(localObject1, "prefNickname");
      localObject2 = (Context)this;
      localObject3 = this.rLB;
      if (localObject3 == null) {
        d.g.b.k.fOy();
      }
      ((Preference)localObject1).setSummary((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject3).Tn()));
      break;
      i = 0;
      break label362;
      label717:
      localObject2 = this.rLB;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.api.f)localObject2).field_extInfo;
        if (localObject2 != null)
        {
          ac.i(this.TAG, "sex " + ((aje)localObject2).exL);
          if (((aje)localObject2).exL == 1)
          {
            d.g.b.k.g(localObject1, "prefSex");
            ((Preference)localObject1).setSummary((CharSequence)getString(2131763533));
          }
        }
      }
      for (;;)
      {
        ((Preference)localObject1).aam(0);
        ((Preference)localObject1).setEnabled(true);
        break;
        if (((aje)localObject2).exL == 2)
        {
          d.g.b.k.g(localObject1, "prefSex");
          ((Preference)localObject1).setSummary((CharSequence)getString(2131763532));
        }
        else
        {
          d.g.b.k.g(localObject1, "prefSex");
          ((Preference)localObject1).setSummary((CharSequence)"");
          continue;
          d.g.b.k.g(localObject1, "prefSex");
          ((Preference)localObject1).setSummary((CharSequence)"");
        }
      }
      label876:
      if (!bs.isNullOrNil((String)localObject3))
      {
        d.g.b.k.g(localObject1, "prefDistrict");
        ((Preference)localObject1).setSummary((CharSequence)((String)localObject2 + ' ' + (String)localObject3));
      }
      else if (!bs.isNullOrNil((String)localObject2))
      {
        d.g.b.k.g(localObject1, "prefDistrict");
        ((Preference)localObject1).setSummary((CharSequence)localObject2);
      }
      else
      {
        d.g.b.k.g(localObject1, "prefDistrict");
        ((Preference)localObject1).setSummary((CharSequence)"");
        continue;
        d.g.b.k.g(localObject1, "prefDistrict");
        ((Preference)localObject1).setSummary((CharSequence)"");
      }
    }
  }
  
  private static void doPrepareUser()
  {
    AppMethodBeat.i(167603);
    aq localaq = new aq(2);
    com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)localaq);
    AppMethodBeat.o(167603);
  }
  
  public int getResourceId()
  {
    return 2131951679;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(167608);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.rGm)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.a.i((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.awL());
        if ((!bs.isNullOrNil(paramIntent)) && (com.tencent.mm.vfs.i.eA(paramIntent)))
        {
          getIntent().putExtra("key_source_img_path", paramIntent);
          paramIntent = com.tencent.mm.plugin.finder.utils.a.rOv;
          com.tencent.mm.plugin.finder.utils.a.b((Activity)this, getIntent(), this.rGn);
          AppMethodBeat.o(167608);
          return;
        }
        ac.w(this.TAG, "no img select");
        AppMethodBeat.o(167608);
      }
    }
    else
    {
      if (paramInt1 != this.rGn) {
        break label285;
      }
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        paramIntent = paramIntent.getStringExtra("key_result_img_path");
        if ((bs.isNullOrNil(paramIntent)) || (!com.tencent.mm.vfs.i.eA(paramIntent))) {
          break label268;
        }
        ac.i(this.TAG, "avatar file length %d KB", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aSp(paramIntent) / 1024L) });
        localObject1 = (com.tencent.mm.plugin.i.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.i.class);
        d.g.b.k.g(paramIntent, "avatarPath");
        ((com.tencent.mm.plugin.i.a.i)localObject1).a(paramIntent, (com.tencent.mm.plugin.i.a.k)this);
        paramIntent = this.rGq;
        if (paramIntent != null) {
          paramIntent.dismiss();
        }
        this.rGq = ((ProgressDialog)com.tencent.mm.ui.base.h.b((Context)this, getString(2131755886), false, null));
      }
    }
    label261:
    label268:
    label285:
    do
    {
      AppMethodBeat.o(167608);
      return;
      ac.w(this.TAG, "no avatar set");
      AppMethodBeat.o(167608);
      return;
      if (paramInt1 != this.rLz) {
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
    ac.i(this.TAG, "countryCode " + (String)localObject1 + " provinceCode" + (String)localObject2 + " cityCode" + paramIntent);
    if (d.g.b.k.g(localObject1, "unshow"))
    {
      localObject1 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      paramInt1 = ((e)localObject1).agA().getInt(ah.a.GUq, 0);
      localObject1 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      ((e)localObject1).agA().set(ah.a.GUq, Integer.valueOf(paramInt1 & 0xFFFFFFFB));
      localObject1 = "";
    }
    label570:
    label980:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      localObject3 = this.rLB;
      Object localObject4;
      if (localObject3 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.finder.api.f)localObject3).field_extInfo;
        if (localObject4 == null) {
          break label570;
        }
        ((aje)localObject4).country = ((String)localObject1);
        ((aje)localObject4).exV = ((String)localObject2);
      }
      for (((aje)localObject4).exW = paramIntent;; ((com.tencent.mm.plugin.finder.api.f)localObject3).field_extInfo.exW = paramIntent)
      {
        localObject4 = com.tencent.mm.plugin.finder.api.b.qWt;
        b.a.b((com.tencent.mm.plugin.finder.api.f)localObject3);
        ((com.tencent.mm.plugin.i.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.i.class)).a((String)localObject1, (String)localObject2, paramIntent, paramInt1, (com.tencent.mm.plugin.i.a.k)this);
        break;
        ((com.tencent.mm.plugin.finder.api.f)localObject3).field_extInfo = new aje();
        ((com.tencent.mm.plugin.finder.api.f)localObject3).field_extInfo.country = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.api.f)localObject3).field_extInfo.exV = ((String)localObject2);
      }
      if ((paramInt1 != this.rLA) || (paramIntent == null) || (paramInt2 != -1)) {
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
        localObject1 = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(localObject1, "MMKernel.storage()");
        paramInt1 = ((e)localObject1).agA().getInt(ah.a.GUq, 0);
        localObject1 = this.rLB;
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
        paramIntent = ((com.tencent.mm.plugin.finder.api.f)localObject1).field_extInfo;
        if (paramIntent != null)
        {
          paramIntent.exL = 2;
          paramIntent = com.tencent.mm.plugin.finder.api.b.qWt;
          b.a.b((com.tencent.mm.plugin.finder.api.f)localObject1);
          paramIntent = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(paramIntent, "MMKernel.storage()");
          paramIntent.agA().set(ah.a.GUq, Integer.valueOf(paramInt1 | 0x8));
          paramIntent = (com.tencent.mm.plugin.i.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.i.class);
          localObject1 = ((com.tencent.mm.plugin.finder.api.f)localObject1).field_extInfo;
          if (localObject1 == null) {
            break label1009;
          }
        }
        break;
      }
      label877:
      label1009:
      for (paramInt1 = ((aje)localObject1).exL;; paramInt1 = 0)
      {
        paramIntent.a(paramInt1, (com.tencent.mm.plugin.i.a.k)this);
        break;
        if (!paramIntent.equals("male")) {
          break label736;
        }
        paramIntent = ((com.tencent.mm.plugin.finder.api.f)localObject1).field_extInfo;
        if (paramIntent != null)
        {
          paramIntent.exL = 1;
          paramIntent = com.tencent.mm.plugin.finder.api.b.qWt;
          b.a.b((com.tencent.mm.plugin.finder.api.f)localObject1);
          paramIntent = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(paramIntent, "MMKernel.storage()");
          paramIntent.agA().set(ah.a.GUq, Integer.valueOf(paramInt1 | 0x8));
          paramIntent = (com.tencent.mm.plugin.i.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.i.class);
          localObject1 = ((com.tencent.mm.plugin.finder.api.f)localObject1).field_extInfo;
          if (localObject1 == null) {
            break label980;
          }
        }
        for (paramInt1 = ((aje)localObject1).exL;; paramInt1 = 0)
        {
          paramIntent.a(paramInt1, (com.tencent.mm.plugin.i.a.k)this);
          break;
          ((com.tencent.mm.plugin.finder.api.f)localObject1).field_extInfo = new aje();
          ((com.tencent.mm.plugin.finder.api.f)localObject1).field_extInfo.exL = 1;
          break label877;
        }
        ((com.tencent.mm.plugin.finder.api.f)localObject1).field_extInfo = new aje();
        ((com.tencent.mm.plugin.finder.api.f)localObject1).field_extInfo.exL = 2;
        break label773;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167601);
    super.onCreate(paramBundle);
    this.rJO = u.axE();
    ac.i(this.TAG, "myFinderUser " + this.rJO);
    setMMTitle(2131759348);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    com.tencent.mm.kernel.g.agi().a(3761, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(167601);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(167609);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(3761, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(167609);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int j = 0;
    AppMethodBeat.i(167605);
    if (paramPreference == null) {
      d.g.b.k.fOy();
    }
    paramf = paramPreference.getKey();
    ac.i(this.TAG, "click ".concat(String.valueOf(paramf)));
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
            paramf = com.tencent.mm.plugin.finder.spam.a.rBD;
            if (!com.tencent.mm.plugin.finder.spam.a.aed("personalInfo")) {
              com.tencent.mm.pluginsdk.ui.tools.q.o((Activity)this, this.rGm);
            }
          }
          break;
        }
      }
    } while (!paramf.equals("settings_district"));
    paramf = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.czE() == 1)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("GetAddress", true);
      ((Intent)localObject).putExtra("ShowSelectedLocation", true);
      ((Intent)localObject).putExtra("SetSelectLocation", true);
      paramf = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramf, "MMKernel.storage()");
      if ((paramf.agA().getInt(ah.a.GUq, 0) & 0x4) == 0) {
        ((Intent)localObject).putExtra("SelectedCountryCode", "unshow");
      }
      for (;;)
      {
        paramf = this.rLB;
        if (paramf != null)
        {
          paramf = paramf.field_extInfo;
          if (paramf != null)
          {
            paramPreference = paramf.exV;
            paramf = paramPreference;
            if (paramPreference != null) {
              break label275;
            }
          }
        }
        paramf = "";
        label275:
        ((Intent)localObject).putExtra("SelectedProvinceCode", paramf);
        paramf = this.rLB;
        if (paramf != null)
        {
          paramf = paramf.field_extInfo;
          if (paramf != null)
          {
            paramPreference = paramf.exW;
            paramf = paramPreference;
            if (paramPreference != null) {
              break label318;
            }
          }
        }
        paramf = "";
        label318:
        ((Intent)localObject).putExtra("SelectedCityCode", paramf);
        ((Intent)localObject).putExtra("NeedUnshowItem", true);
        com.tencent.mm.br.d.c((Context)getContext(), ".ui.tools.MultiStageCitySelectUI", (Intent)localObject, this.rLz);
        break;
        if (!paramf.equals("settings_sex")) {
          break;
        }
        paramf = new Intent();
        paramPreference = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramPreference, "MMKernel.storage()");
        int i;
        if ((paramPreference.agA().getInt(ah.a.GUq, 0) & 0x8) > 0)
        {
          paramPreference = this.rLB;
          i = j;
          if (paramPreference != null)
          {
            paramPreference = paramPreference.field_extInfo;
            i = j;
            if (paramPreference != null) {
              i = paramPreference.exL;
            }
          }
          if (i == 1) {
            paramf.putExtra("key_input_sex", "male");
          }
        }
        for (;;)
        {
          paramPreference = com.tencent.mm.plugin.finder.utils.a.rOv;
          com.tencent.mm.plugin.finder.utils.a.a((MMActivity)this, paramf, this.rLA);
          break;
          if (!paramf.equals("settings_signature")) {
            break;
          }
          paramf = new Intent();
          paramf.putExtra("key_scene", 2);
          paramPreference = com.tencent.mm.plugin.finder.utils.a.rOv;
          com.tencent.mm.plugin.finder.utils.a.H((Context)this, paramf);
          break;
          if (!paramf.equals("settings_nickname")) {
            break;
          }
          if (this.rsp != null)
          {
            paramf = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramf, "MMKernel.storage()");
            i = paramf.agA().getInt(ah.a.GUi, 0);
            ac.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(i) });
            if ((i & 0x2) != 0)
            {
              paramf = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
              paramPreference = (Context)this;
              localObject = this.rsp;
              if (localObject == null) {
                d.g.b.k.fOy();
              }
              localObject = ((aoy)localObject).verifyInfo.appName;
              aoy localaoy = this.rsp;
              if (localaoy == null) {
                d.g.b.k.fOy();
              }
              paramf.a(paramPreference, (String)localObject, null, 0, 0, localaoy.verifyInfo.EFJ, new AppBrandStatObject());
              break;
            }
            paramf = new Intent();
            paramf.putExtra("key_scene", 1);
            paramPreference = com.tencent.mm.plugin.finder.utils.a.rOv;
            com.tencent.mm.plugin.finder.utils.a.H((Context)this, paramf);
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
        paramf = this.rLB;
        if (paramf != null)
        {
          paramf = paramf.field_extInfo;
          if (paramf != null)
          {
            paramPreference = paramf.country;
            paramf = paramPreference;
            if (paramPreference != null) {
              break label776;
            }
          }
        }
        paramf = "";
        label776:
        ((Intent)localObject).putExtra("SelectedCountryCode", paramf);
      }
    }
    Object localObject = new Intent();
    paramf = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(paramf, "MMKernel.storage()");
    if ((paramf.agA().getInt(ah.a.GUq, 0) & 0x4) == 0) {
      ((Intent)localObject).putExtra("SelectedCountryCode", "unshow");
    }
    for (;;)
    {
      paramf = this.rLB;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.exV;
          paramf = paramPreference;
          if (paramPreference != null) {
            break label869;
          }
        }
      }
      paramf = "";
      label869:
      ((Intent)localObject).putExtra("SelectedProvinceCode", paramf);
      paramf = this.rLB;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.exW;
          paramf = paramPreference;
          if (paramPreference != null) {
            break label912;
          }
        }
      }
      paramf = "";
      label912:
      ((Intent)localObject).putExtra("SelectedCityCode", paramf);
      paramf = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.b((MMActivity)this, (Intent)localObject, this.rLz);
      break;
      paramf = this.rLB;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.country;
          paramf = paramPreference;
          if (paramPreference != null) {
            break label975;
          }
        }
      }
      paramf = "";
      label975:
      ((Intent)localObject).putExtra("SelectedCountryCode", paramf);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(167602);
    super.onResume();
    doPrepareUser();
    cL();
    AppMethodBeat.o(167602);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    Object localObject = null;
    AppMethodBeat.i(167607);
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
      AppMethodBeat.o(167607);
      return;
    }
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(167607);
        throw paramString;
      }
      this.rsp = ((aq)paramn).csO();
      if (this.rsp != null) {
        cL();
      }
    }
    AppMethodBeat.o(167607);
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
    a(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167598);
      this.rLC.finish();
      AppMethodBeat.o(167598);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$1", "Lcom/tencent/mm/ui/base/preference/HeadImgNewPreference$IAvatarLoaderEx;", "loadAvatar", "", "username", "", "icon", "Landroid/widget/ImageView;", "isRound", "", "plugin-finder_release"})
  public static final class b
    implements HeadImgNewPreference.a
  {
    public final void b(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(167599);
      d.g.b.k.h(paramString, "username");
      d.g.b.k.h(paramImageView, "icon");
      if (FinderSettingDetailInfoUI.a(this.rLC) == null)
      {
        ac.e(FinderSettingDetailInfoUI.b(this.rLC), "error self contact is null");
        AppMethodBeat.o(167599);
        return;
      }
      paramString = com.tencent.mm.plugin.finder.loader.h.rtK;
      paramString = com.tencent.mm.plugin.finder.loader.h.cwo();
      Object localObject = FinderSettingDetailInfoUI.a(this.rLC);
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      localObject = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.f)localObject).field_avatarUrl);
      com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.rtK;
      paramString.a(localObject, paramImageView, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtN));
      AppMethodBeat.o(167599);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167600);
      if (FinderSettingDetailInfoUI.c(this.rLC) != null)
      {
        paramView = new Intent();
        Object localObject = FinderSettingDetailInfoUI.a(this.rLC);
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        paramView.putStringArrayListExtra("key_url_list", j.ab(new String[] { ((com.tencent.mm.plugin.finder.api.f)localObject).crZ() }));
        paramView.putExtra("key_preview_avatar", true);
        localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.G((Context)this.rLC, paramView);
      }
      AppMethodBeat.o(167600);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingDetailInfoUI
 * JD-Core Version:    0.7.0.1
 */