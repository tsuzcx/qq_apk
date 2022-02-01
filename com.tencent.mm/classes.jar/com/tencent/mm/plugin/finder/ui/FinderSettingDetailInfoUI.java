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
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.vfs.o;
import d.a.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_DISTRICT", "REQUEST_SEX", "TAG", "", "myFinderUser", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showProgress", "updateView", "plugin-finder_release"})
public class FinderSettingDetailInfoUI
  extends MMPreference
  implements com.tencent.mm.ak.f, s<aqf>
{
  private final String TAG = "Finder.FinderSettingDetailInfoUI";
  private final int sMD = 1000;
  private final int sME = 1001;
  private ProgressDialog sMH;
  private String sPN;
  private final int sRR = 1002;
  private final int sRS = 1003;
  private com.tencent.mm.plugin.finder.api.g sRT;
  private atf sqs;
  
  private static void doPrepareUser()
  {
    AppMethodBeat.i(167603);
    ay localay = new ay(2);
    com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)localay);
    AppMethodBeat.o(167603);
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(167604);
    Object localObject1 = c.rPy;
    this.sRT = c.a.ahT(bu.nullAsNil(this.sPN));
    if (this.sRT == null)
    {
      finish();
      AppMethodBeat.o(167604);
      return;
    }
    localObject1 = getPreferenceScreen().aXe("settings_avatar");
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.HeadImgNewPreference");
      AppMethodBeat.o(167604);
      throw ((Throwable)localObject1);
    }
    localObject1 = (HeadImgNewPreference)localObject1;
    ((HeadImgNewPreference)localObject1).a((HeadImgNewPreference.a)new b(this));
    ((HeadImgNewPreference)localObject1).fDB();
    ((HeadImgNewPreference)localObject1).aXd(this.sPN);
    ((HeadImgNewPreference)localObject1).d((View.OnClickListener)new c(this));
    Object localObject3 = getPreferenceScreen().aXe("settings_nickname");
    ((Preference)localObject3).fDL();
    localObject1 = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject1, "MMKernel.storage()");
    int i = ((e)localObject1).ajA().getInt(am.a.Jbp, 0);
    ae.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(i) });
    Object localObject2;
    if (((i & 0x2) != 0) && (this.sqs != null))
    {
      d.g.b.p.g(localObject3, "prefNickname");
      Object localObject4 = (Context)this;
      localObject1 = this.sqs;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      localObject1 = ((atf)localObject1).verifyInfo;
      if (localObject1 != null)
      {
        localObject2 = ((aqk)localObject1).GHl;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((Preference)localObject3).setSummary((CharSequence)k.c((Context)localObject4, (CharSequence)getString(2131759285, new Object[] { localObject1 })));
      localObject1 = getPreferenceScreen().aXe("settings_signature");
      ((Preference)localObject1).fDL();
      d.g.b.p.g(localObject1, "prefSignature");
      localObject2 = (Context)this;
      localObject3 = this.sRT;
      if (localObject3 == null) {
        d.g.b.p.gkB();
      }
      ((Preference)localObject1).setSummary((CharSequence)k.c((Context)localObject2, (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject3).field_signature));
      localObject1 = getPreferenceScreen().aXe("settings_sex");
      localObject2 = this.sRT;
      if (localObject2 == null) {
        break label725;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_authInfo;
      if ((localObject2 == null) || (((FinderAuthInfo)localObject2).authIconType != 2)) {
        break label725;
      }
      i = 1;
      label376:
      if (i == 0) {
        break label730;
      }
      d.g.b.p.g(localObject1, "prefSex");
      ((Preference)localObject1).setSummary((CharSequence)getString(2131766496));
      ((Preference)localObject1).ade(8);
      ((Preference)localObject1).setEnabled(false);
      localObject1 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      i = ((e)localObject1).ajA().getInt(am.a.Jbx, 0);
      ae.i(this.TAG, "updateView userExtFlag:".concat(String.valueOf(i)));
      localObject1 = getPreferenceScreen().aXe("settings_district");
      if ((i & 0x4) <= 0) {
        break label983;
      }
      localObject2 = this.sRT;
      if (localObject2 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_extInfo;
        if (localObject4 != null)
        {
          ae.i(this.TAG, "countryCode " + ((amj)localObject4).country + " provinceCode " + ((amj)localObject4).eRf + " cityCode " + ((amj)localObject4).eRg);
          RegionCodeDecoder.fwA();
          localObject2 = RegionCodeDecoder.getCountry(((amj)localObject4).country);
          RegionCodeDecoder.fwA();
          localObject3 = RegionCodeDecoder.mh(((amj)localObject4).country, ((amj)localObject4).eRf);
          RegionCodeDecoder.fwA();
          localObject4 = RegionCodeDecoder.bh(((amj)localObject4).country, ((amj)localObject4).eRf, ((amj)localObject4).eRg);
          if (bu.isNullOrNil((String)localObject4)) {
            break label889;
          }
          d.g.b.p.g(localObject1, "prefDistrict");
          ((Preference)localObject1).setSummary((CharSequence)(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zR((String)localObject3) + " " + (String)localObject4));
        }
      }
    }
    label725:
    label983:
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(167604);
      return;
      d.g.b.p.g(localObject3, "prefNickname");
      localObject1 = (Context)this;
      localObject2 = this.sRT;
      if (localObject2 == null) {
        d.g.b.p.gkB();
      }
      ((Preference)localObject3).setSummary((CharSequence)k.c((Context)localObject1, (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject2).VK()));
      break;
      i = 0;
      break label376;
      label730:
      localObject2 = this.sRT;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_extInfo;
        if (localObject2 != null)
        {
          ae.i(this.TAG, "sex " + ((amj)localObject2).eQV);
          if (((amj)localObject2).eQV == 1)
          {
            d.g.b.p.g(localObject1, "prefSex");
            ((Preference)localObject1).setSummary((CharSequence)getString(2131763533));
          }
        }
      }
      for (;;)
      {
        ((Preference)localObject1).ade(0);
        ((Preference)localObject1).setEnabled(true);
        break;
        if (((amj)localObject2).eQV == 2)
        {
          d.g.b.p.g(localObject1, "prefSex");
          ((Preference)localObject1).setSummary((CharSequence)getString(2131763532));
        }
        else
        {
          d.g.b.p.g(localObject1, "prefSex");
          ((Preference)localObject1).setSummary((CharSequence)"");
          continue;
          d.g.b.p.g(localObject1, "prefSex");
          ((Preference)localObject1).setSummary((CharSequence)"");
        }
      }
      label889:
      if (!bu.isNullOrNil((String)localObject3))
      {
        d.g.b.p.g(localObject1, "prefDistrict");
        ((Preference)localObject1).setSummary((CharSequence)((String)localObject2 + ' ' + (String)localObject3));
      }
      else if (!bu.isNullOrNil((String)localObject2))
      {
        d.g.b.p.g(localObject1, "prefDistrict");
        ((Preference)localObject1).setSummary((CharSequence)localObject2);
      }
      else
      {
        d.g.b.p.g(localObject1, "prefDistrict");
        ((Preference)localObject1).setSummary((CharSequence)"");
        continue;
        d.g.b.p.g(localObject1, "prefDistrict");
        ((Preference)localObject1).setSummary((CharSequence)"");
      }
    }
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
    if (paramInt1 == this.sMD)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.a.j((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.azQ());
        if ((!bu.isNullOrNil(paramIntent)) && (o.fB(paramIntent)))
        {
          getIntent().putExtra("key_source_img_path", paramIntent);
          paramIntent = com.tencent.mm.plugin.finder.utils.a.sVQ;
          com.tencent.mm.plugin.finder.utils.a.b((Activity)this, getIntent(), this.sME);
          AppMethodBeat.o(167608);
          return;
        }
        ae.w(this.TAG, "no img select");
        AppMethodBeat.o(167608);
      }
    }
    else
    {
      if (paramInt1 != this.sME) {
        break label285;
      }
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        paramIntent = paramIntent.getStringExtra("key_result_img_path");
        if ((bu.isNullOrNil(paramIntent)) || (!o.fB(paramIntent))) {
          break label268;
        }
        ae.i(this.TAG, "avatar file length %d KB", new Object[] { Long.valueOf(o.aZR(paramIntent) / 1024L) });
        localObject1 = (com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.n.class);
        d.g.b.p.g(paramIntent, "avatarPath");
        ((com.tencent.mm.plugin.i.a.n)localObject1).a(paramIntent, (s)this);
        paramIntent = this.sMH;
        if (paramIntent != null) {
          paramIntent.dismiss();
        }
        this.sMH = ((ProgressDialog)h.b((Context)this, getString(2131755886), false, null));
      }
    }
    label261:
    label268:
    label285:
    do
    {
      AppMethodBeat.o(167608);
      return;
      ae.w(this.TAG, "no avatar set");
      AppMethodBeat.o(167608);
      return;
      if (paramInt1 != this.sRR) {
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
    ae.i(this.TAG, "countryCode " + (String)localObject1 + " provinceCode" + (String)localObject2 + " cityCode" + paramIntent);
    if (d.g.b.p.i(localObject1, "unshow"))
    {
      localObject1 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      paramInt1 = ((e)localObject1).ajA().getInt(am.a.Jbx, 0);
      localObject1 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      ((e)localObject1).ajA().set(am.a.Jbx, Integer.valueOf(paramInt1 & 0xFFFFFFFB));
      localObject1 = "";
    }
    label570:
    label980:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      localObject3 = this.sRT;
      Object localObject4;
      if (localObject3 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo;
        if (localObject4 == null) {
          break label570;
        }
        ((amj)localObject4).country = ((String)localObject1);
        ((amj)localObject4).eRf = ((String)localObject2);
      }
      for (((amj)localObject4).eRg = paramIntent;; ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo.eRg = paramIntent)
      {
        localObject4 = c.rPy;
        c.a.b((com.tencent.mm.plugin.finder.api.g)localObject3);
        ((com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.n.class)).a((String)localObject1, (String)localObject2, paramIntent, paramInt1, (s)this);
        break;
        ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo = new amj();
        ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo.country = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo.eRf = ((String)localObject2);
      }
      if ((paramInt1 != this.sRS) || (paramIntent == null) || (paramInt2 != -1)) {
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
        localObject1 = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(localObject1, "MMKernel.storage()");
        paramInt1 = ((e)localObject1).ajA().getInt(am.a.Jbx, 0);
        localObject1 = this.sRT;
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
          paramIntent.eQV = 2;
          paramIntent = c.rPy;
          c.a.b((com.tencent.mm.plugin.finder.api.g)localObject1);
          paramIntent = com.tencent.mm.kernel.g.ajR();
          d.g.b.p.g(paramIntent, "MMKernel.storage()");
          paramIntent.ajA().set(am.a.Jbx, Integer.valueOf(paramInt1 | 0x8));
          paramIntent = (com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.n.class);
          localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo;
          if (localObject1 == null) {
            break label1009;
          }
        }
        break;
      }
      label877:
      label1009:
      for (paramInt1 = ((amj)localObject1).eQV;; paramInt1 = 0)
      {
        paramIntent.a(paramInt1, (s)this);
        break;
        if (!paramIntent.equals("male")) {
          break label736;
        }
        paramIntent = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo;
        if (paramIntent != null)
        {
          paramIntent.eQV = 1;
          paramIntent = c.rPy;
          c.a.b((com.tencent.mm.plugin.finder.api.g)localObject1);
          paramIntent = com.tencent.mm.kernel.g.ajR();
          d.g.b.p.g(paramIntent, "MMKernel.storage()");
          paramIntent.ajA().set(am.a.Jbx, Integer.valueOf(paramInt1 | 0x8));
          paramIntent = (com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.n.class);
          localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo;
          if (localObject1 == null) {
            break label980;
          }
        }
        for (paramInt1 = ((amj)localObject1).eQV;; paramInt1 = 0)
        {
          paramIntent.a(paramInt1, (s)this);
          break;
          ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo = new amj();
          ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo.eQV = 1;
          break label877;
        }
        ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo = new amj();
        ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo.eQV = 2;
        break label773;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167601);
    super.onCreate(paramBundle);
    this.sPN = com.tencent.mm.model.v.aAK();
    ae.i(this.TAG, "myFinderUser " + this.sPN);
    setMMTitle(2131759348);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    com.tencent.mm.kernel.g.ajj().a(3761, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(167601);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(167609);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajj().b(3761, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(167609);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int j = 0;
    AppMethodBeat.i(167605);
    if (paramPreference == null) {
      d.g.b.p.gkB();
    }
    paramf = paramPreference.getKey();
    ae.i(this.TAG, "click ".concat(String.valueOf(paramf)));
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
            paramf = com.tencent.mm.plugin.finder.spam.a.sEK;
            if (!com.tencent.mm.plugin.finder.spam.a.ajm("personalInfo")) {
              com.tencent.mm.pluginsdk.ui.tools.q.o((Activity)this, this.sMD);
            }
          }
          break;
        }
      }
    } while (!paramf.equals("settings_district"));
    paramf = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (com.tencent.mm.plugin.finder.storage.b.cIl() == 1)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("GetAddress", true);
      ((Intent)localObject).putExtra("ShowSelectedLocation", true);
      ((Intent)localObject).putExtra("SetSelectLocation", true);
      paramf = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(paramf, "MMKernel.storage()");
      if ((paramf.ajA().getInt(am.a.Jbx, 0) & 0x4) == 0) {
        ((Intent)localObject).putExtra("SelectedCountryCode", "unshow");
      }
      for (;;)
      {
        paramf = this.sRT;
        if (paramf != null)
        {
          paramf = paramf.field_extInfo;
          if (paramf != null)
          {
            paramPreference = paramf.eRf;
            paramf = paramPreference;
            if (paramPreference != null) {
              break label275;
            }
          }
        }
        paramf = "";
        label275:
        ((Intent)localObject).putExtra("SelectedProvinceCode", paramf);
        paramf = this.sRT;
        if (paramf != null)
        {
          paramf = paramf.field_extInfo;
          if (paramf != null)
          {
            paramPreference = paramf.eRg;
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
        com.tencent.mm.br.d.c((Context)getContext(), ".ui.tools.MultiStageCitySelectUI", (Intent)localObject, this.sRR);
        break;
        if (!paramf.equals("settings_sex")) {
          break;
        }
        paramf = new Intent();
        paramPreference = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(paramPreference, "MMKernel.storage()");
        int i;
        if ((paramPreference.ajA().getInt(am.a.Jbx, 0) & 0x8) > 0)
        {
          paramPreference = this.sRT;
          i = j;
          if (paramPreference != null)
          {
            paramPreference = paramPreference.field_extInfo;
            i = j;
            if (paramPreference != null) {
              i = paramPreference.eQV;
            }
          }
          if (i == 1) {
            paramf.putExtra("key_input_sex", "male");
          }
        }
        for (;;)
        {
          paramPreference = com.tencent.mm.plugin.finder.utils.a.sVQ;
          com.tencent.mm.plugin.finder.utils.a.a((MMActivity)this, paramf, this.sRS);
          break;
          if (!paramf.equals("settings_signature")) {
            break;
          }
          paramf = new Intent();
          paramf.putExtra("key_scene", 2);
          paramPreference = com.tencent.mm.plugin.finder.utils.a.sVQ;
          com.tencent.mm.plugin.finder.utils.a.I((Context)this, paramf);
          break;
          if (!paramf.equals("settings_nickname")) {
            break;
          }
          if (this.sqs != null)
          {
            paramf = com.tencent.mm.kernel.g.ajR();
            d.g.b.p.g(paramf, "MMKernel.storage()");
            i = paramf.ajA().getInt(am.a.Jbp, 0);
            ae.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(i) });
            if ((i & 0x2) != 0)
            {
              com.tencent.mm.plugin.appbrand.service.p localp = (com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class);
              Context localContext = (Context)this;
              paramf = this.sqs;
              if (paramf == null) {
                d.g.b.p.gkB();
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
              paramPreference = this.sqs;
              if (paramPreference == null) {
                d.g.b.p.gkB();
              }
              paramPreference = paramPreference.verifyInfo;
              if (paramPreference != null)
              {
                localObject = paramPreference.GHk;
                paramPreference = (Preference)localObject;
                if (localObject != null) {}
              }
              else
              {
                paramPreference = "";
              }
              localp.a(localContext, paramf, null, 0, 0, paramPreference, new AppBrandStatObject());
              break;
            }
            paramf = new Intent();
            paramf.putExtra("key_scene", 1);
            paramPreference = com.tencent.mm.plugin.finder.utils.a.sVQ;
            com.tencent.mm.plugin.finder.utils.a.I((Context)this, paramf);
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
        paramf = this.sRT;
        if (paramf != null)
        {
          paramf = paramf.field_extInfo;
          if (paramf != null)
          {
            paramPreference = paramf.country;
            paramf = paramPreference;
            if (paramPreference != null) {
              break label809;
            }
          }
        }
        paramf = "";
        label809:
        ((Intent)localObject).putExtra("SelectedCountryCode", paramf);
      }
    }
    Object localObject = new Intent();
    paramf = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(paramf, "MMKernel.storage()");
    if ((paramf.ajA().getInt(am.a.Jbx, 0) & 0x4) == 0) {
      ((Intent)localObject).putExtra("SelectedCountryCode", "unshow");
    }
    for (;;)
    {
      paramf = this.sRT;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.eRf;
          paramf = paramPreference;
          if (paramPreference != null) {
            break label902;
          }
        }
      }
      paramf = "";
      label902:
      ((Intent)localObject).putExtra("SelectedProvinceCode", paramf);
      paramf = this.sRT;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.eRg;
          paramf = paramPreference;
          if (paramPreference != null) {
            break label945;
          }
        }
      }
      paramf = "";
      label945:
      ((Intent)localObject).putExtra("SelectedCityCode", paramf);
      paramf = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.b((MMActivity)this, (Intent)localObject, this.sRR);
      break;
      paramf = this.sRT;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.country;
          paramf = paramPreference;
          if (paramPreference != null) {
            break label1008;
          }
        }
      }
      paramf = "";
      label1008:
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    Object localObject = null;
    AppMethodBeat.i(167607);
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
      AppMethodBeat.o(167607);
      return;
    }
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(167607);
        throw paramString;
      }
      this.sqs = ((ay)paramn).cAk();
      if (this.sqs != null) {
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167598);
      this.sRU.finish();
      AppMethodBeat.o(167598);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$1", "Lcom/tencent/mm/ui/base/preference/HeadImgNewPreference$IAvatarLoaderEx;", "loadAvatar", "", "username", "", "icon", "Landroid/widget/ImageView;", "isRound", "", "plugin-finder_release"})
  public static final class b
    implements HeadImgNewPreference.a
  {
    public final void b(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(167599);
      d.g.b.p.h(paramString, "username");
      d.g.b.p.h(paramImageView, "icon");
      if (FinderSettingDetailInfoUI.a(this.sRU) == null)
      {
        ae.e(FinderSettingDetailInfoUI.b(this.sRU), "error self contact is null");
        AppMethodBeat.o(167599);
        return;
      }
      paramString = i.srW;
      paramString = i.cEo();
      Object localObject = FinderSettingDetailInfoUI.a(this.sRU);
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      localObject = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject).field_avatarUrl);
      i locali = i.srW;
      paramString.a(localObject, paramImageView, i.a(i.a.srZ));
      AppMethodBeat.o(167599);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167600);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      if (FinderSettingDetailInfoUI.c(this.sRU) != null)
      {
        paramView = new Intent();
        localObject = FinderSettingDetailInfoUI.a(this.sRU);
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        paramView.putStringArrayListExtra("key_url_list", j.ab(new String[] { ((com.tencent.mm.plugin.finder.api.g)localObject).czm() }));
        paramView.putExtra("key_preview_avatar", true);
        localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.H((Context)this.sRU, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167600);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingDetailInfoUI
 * JD-Core Version:    0.7.0.1
 */