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
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_DISTRICT", "REQUEST_SEX", "TAG", "", "myFinderUser", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showProgress", "updateView", "plugin-finder_release"})
public class FinderSettingDetailInfoUI
  extends MMPreference
  implements com.tencent.mm.al.f, s<aps>
{
  private final String TAG = "Finder.FinderSettingDetailInfoUI";
  private final int sBE = 1000;
  private final int sBF = 1001;
  private ProgressDialog sBI;
  private String sEO;
  private final int sGU = 1002;
  private final int sGV = 1003;
  private com.tencent.mm.plugin.finder.api.g sGW;
  private asp shx;
  
  private static void doPrepareUser()
  {
    AppMethodBeat.i(167603);
    ax localax = new ax(2);
    com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)localax);
    AppMethodBeat.o(167603);
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(167604);
    Object localObject1 = c.rHn;
    localObject1 = bt.nullAsNil(this.sEO);
    p.g(localObject1, "Util.nullAsNil(myFinderUser)");
    this.sGW = c.a.agW((String)localObject1);
    if (this.sGW == null)
    {
      finish();
      AppMethodBeat.o(167604);
      return;
    }
    localObject1 = getPreferenceScreen().aVD("settings_avatar");
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.HeadImgNewPreference");
      AppMethodBeat.o(167604);
      throw ((Throwable)localObject1);
    }
    localObject1 = (HeadImgNewPreference)localObject1;
    ((HeadImgNewPreference)localObject1).a((HeadImgNewPreference.a)new b(this));
    ((HeadImgNewPreference)localObject1).fzz();
    ((HeadImgNewPreference)localObject1).aVC(this.sEO);
    ((HeadImgNewPreference)localObject1).d((View.OnClickListener)new c(this));
    localObject1 = getPreferenceScreen().aVD("settings_nickname");
    ((Preference)localObject1).fzJ();
    Object localObject2 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject2, "MMKernel.storage()");
    int i = ((e)localObject2).ajl().getInt(al.a.IGO, 0);
    ad.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(i) });
    Object localObject3;
    if (((i & 0x2) != 0) && (this.shx != null))
    {
      p.g(localObject1, "prefNickname");
      localObject2 = (Context)this;
      localObject3 = this.shx;
      if (localObject3 == null) {
        p.gfZ();
      }
      ((Preference)localObject1).setSummary((CharSequence)k.c((Context)localObject2, (CharSequence)getString(2131759285, new Object[] { ((asp)localObject3).verifyInfo.Gof })));
      localObject1 = getPreferenceScreen().aVD("settings_signature");
      ((Preference)localObject1).fzJ();
      p.g(localObject1, "prefSignature");
      localObject2 = (Context)this;
      localObject3 = this.sGW;
      if (localObject3 == null) {
        p.gfZ();
      }
      ((Preference)localObject1).setSummary((CharSequence)k.c((Context)localObject2, (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject3).field_signature));
      localObject1 = getPreferenceScreen().aVD("settings_sex");
      localObject2 = this.sGW;
      if (localObject2 == null) {
        break label715;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_authInfo;
      if ((localObject2 == null) || (((FinderAuthInfo)localObject2).authIconType != 2)) {
        break label715;
      }
      i = 1;
      label364:
      if (i == 0) {
        break label720;
      }
      p.g(localObject1, "prefSex");
      ((Preference)localObject1).setSummary((CharSequence)getString(2131766496));
      ((Preference)localObject1).acw(8);
      ((Preference)localObject1).setEnabled(false);
      localObject1 = com.tencent.mm.kernel.g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      i = ((e)localObject1).ajl().getInt(al.a.IGW, 0);
      ad.i(this.TAG, "updateView userExtFlag:".concat(String.valueOf(i)));
      localObject1 = getPreferenceScreen().aVD("settings_district");
      if ((i & 0x4) <= 0) {
        break label973;
      }
      localObject2 = this.sGW;
      if (localObject2 != null)
      {
        Object localObject4 = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_extInfo;
        if (localObject4 != null)
        {
          ad.i(this.TAG, "countryCode " + ((alx)localObject4).country + " provinceCode " + ((alx)localObject4).ePu + " cityCode " + ((alx)localObject4).ePv);
          RegionCodeDecoder.fsz();
          localObject2 = RegionCodeDecoder.getCountry(((alx)localObject4).country);
          RegionCodeDecoder.fsz();
          localObject3 = RegionCodeDecoder.ma(((alx)localObject4).country, ((alx)localObject4).ePu);
          RegionCodeDecoder.fsz();
          localObject4 = RegionCodeDecoder.bg(((alx)localObject4).country, ((alx)localObject4).ePu, ((alx)localObject4).ePv);
          if (bt.isNullOrNil((String)localObject4)) {
            break label879;
          }
          p.g(localObject1, "prefDistrict");
          ((Preference)localObject1).setSummary((CharSequence)(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zh((String)localObject3) + " " + (String)localObject4));
        }
      }
    }
    label715:
    label973:
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(167604);
      return;
      p.g(localObject1, "prefNickname");
      localObject2 = (Context)this;
      localObject3 = this.sGW;
      if (localObject3 == null) {
        p.gfZ();
      }
      ((Preference)localObject1).setSummary((CharSequence)k.c((Context)localObject2, (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject3).VC()));
      break;
      i = 0;
      break label364;
      label720:
      localObject2 = this.sGW;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_extInfo;
        if (localObject2 != null)
        {
          ad.i(this.TAG, "sex " + ((alx)localObject2).ePk);
          if (((alx)localObject2).ePk == 1)
          {
            p.g(localObject1, "prefSex");
            ((Preference)localObject1).setSummary((CharSequence)getString(2131763533));
          }
        }
      }
      for (;;)
      {
        ((Preference)localObject1).acw(0);
        ((Preference)localObject1).setEnabled(true);
        break;
        if (((alx)localObject2).ePk == 2)
        {
          p.g(localObject1, "prefSex");
          ((Preference)localObject1).setSummary((CharSequence)getString(2131763532));
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
      label879:
      if (!bt.isNullOrNil((String)localObject3))
      {
        p.g(localObject1, "prefDistrict");
        ((Preference)localObject1).setSummary((CharSequence)((String)localObject2 + ' ' + (String)localObject3));
      }
      else if (!bt.isNullOrNil((String)localObject2))
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
  
  public int getResourceId()
  {
    return 2131951679;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(167608);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.sBE)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.a.j((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.azA());
        if ((!bt.isNullOrNil(paramIntent)) && (com.tencent.mm.vfs.i.fv(paramIntent)))
        {
          getIntent().putExtra("key_source_img_path", paramIntent);
          paramIntent = com.tencent.mm.plugin.finder.utils.a.sKD;
          com.tencent.mm.plugin.finder.utils.a.b((Activity)this, getIntent(), this.sBF);
          AppMethodBeat.o(167608);
          return;
        }
        ad.w(this.TAG, "no img select");
        AppMethodBeat.o(167608);
      }
    }
    else
    {
      if (paramInt1 != this.sBF) {
        break label285;
      }
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        paramIntent = paramIntent.getStringExtra("key_result_img_path");
        if ((bt.isNullOrNil(paramIntent)) || (!com.tencent.mm.vfs.i.fv(paramIntent))) {
          break label268;
        }
        ad.i(this.TAG, "avatar file length %d KB", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aYo(paramIntent) / 1024L) });
        localObject1 = (com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.n.class);
        p.g(paramIntent, "avatarPath");
        ((com.tencent.mm.plugin.i.a.n)localObject1).a(paramIntent, (s)this);
        paramIntent = this.sBI;
        if (paramIntent != null) {
          paramIntent.dismiss();
        }
        this.sBI = ((ProgressDialog)h.b((Context)this, getString(2131755886), false, null));
      }
    }
    label261:
    label268:
    label285:
    do
    {
      AppMethodBeat.o(167608);
      return;
      ad.w(this.TAG, "no avatar set");
      AppMethodBeat.o(167608);
      return;
      if (paramInt1 != this.sGU) {
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
    ad.i(this.TAG, "countryCode " + (String)localObject1 + " provinceCode" + (String)localObject2 + " cityCode" + paramIntent);
    if (p.i(localObject1, "unshow"))
    {
      localObject1 = com.tencent.mm.kernel.g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      paramInt1 = ((e)localObject1).ajl().getInt(al.a.IGW, 0);
      localObject1 = com.tencent.mm.kernel.g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      ((e)localObject1).ajl().set(al.a.IGW, Integer.valueOf(paramInt1 & 0xFFFFFFFB));
      localObject1 = "";
    }
    label570:
    label980:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      localObject3 = this.sGW;
      Object localObject4;
      if (localObject3 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo;
        if (localObject4 == null) {
          break label570;
        }
        ((alx)localObject4).country = ((String)localObject1);
        ((alx)localObject4).ePu = ((String)localObject2);
      }
      for (((alx)localObject4).ePv = paramIntent;; ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo.ePv = paramIntent)
      {
        localObject4 = c.rHn;
        c.a.b((com.tencent.mm.plugin.finder.api.g)localObject3);
        ((com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.n.class)).a((String)localObject1, (String)localObject2, paramIntent, paramInt1, (s)this);
        break;
        ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo = new alx();
        ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo.country = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.api.g)localObject3).field_extInfo.ePu = ((String)localObject2);
      }
      if ((paramInt1 != this.sGV) || (paramIntent == null) || (paramInt2 != -1)) {
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
        localObject1 = com.tencent.mm.kernel.g.ajC();
        p.g(localObject1, "MMKernel.storage()");
        paramInt1 = ((e)localObject1).ajl().getInt(al.a.IGW, 0);
        localObject1 = this.sGW;
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
          paramIntent.ePk = 2;
          paramIntent = c.rHn;
          c.a.b((com.tencent.mm.plugin.finder.api.g)localObject1);
          paramIntent = com.tencent.mm.kernel.g.ajC();
          p.g(paramIntent, "MMKernel.storage()");
          paramIntent.ajl().set(al.a.IGW, Integer.valueOf(paramInt1 | 0x8));
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
      for (paramInt1 = ((alx)localObject1).ePk;; paramInt1 = 0)
      {
        paramIntent.a(paramInt1, (s)this);
        break;
        if (!paramIntent.equals("male")) {
          break label736;
        }
        paramIntent = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo;
        if (paramIntent != null)
        {
          paramIntent.ePk = 1;
          paramIntent = c.rHn;
          c.a.b((com.tencent.mm.plugin.finder.api.g)localObject1);
          paramIntent = com.tencent.mm.kernel.g.ajC();
          p.g(paramIntent, "MMKernel.storage()");
          paramIntent.ajl().set(al.a.IGW, Integer.valueOf(paramInt1 | 0x8));
          paramIntent = (com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.n.class);
          localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo;
          if (localObject1 == null) {
            break label980;
          }
        }
        for (paramInt1 = ((alx)localObject1).ePk;; paramInt1 = 0)
        {
          paramIntent.a(paramInt1, (s)this);
          break;
          ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo = new alx();
          ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo.ePk = 1;
          break label877;
        }
        ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo = new alx();
        ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo.ePk = 2;
        break label773;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167601);
    super.onCreate(paramBundle);
    this.sEO = u.aAu();
    ad.i(this.TAG, "myFinderUser " + this.sEO);
    setMMTitle(2131759348);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    com.tencent.mm.kernel.g.aiU().a(3761, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(167601);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(167609);
    super.onDestroy();
    com.tencent.mm.kernel.g.aiU().b(3761, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(167609);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int j = 0;
    AppMethodBeat.i(167605);
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
        AppMethodBeat.o(167605);
        return true;
        switch (paramf.hashCode())
        {
        default: 
          break;
        case -1298291467: 
          if (paramf.equals("settings_avatar"))
          {
            paramf = com.tencent.mm.plugin.finder.spam.a.suA;
            if (!com.tencent.mm.plugin.finder.spam.a.aip("personalInfo")) {
              com.tencent.mm.pluginsdk.ui.tools.q.o((Activity)this, this.sBE);
            }
          }
          break;
        }
      }
    } while (!paramf.equals("settings_district"));
    paramf = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cGo() == 1)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("GetAddress", true);
      ((Intent)localObject).putExtra("ShowSelectedLocation", true);
      ((Intent)localObject).putExtra("SetSelectLocation", true);
      paramf = com.tencent.mm.kernel.g.ajC();
      p.g(paramf, "MMKernel.storage()");
      if ((paramf.ajl().getInt(al.a.IGW, 0) & 0x4) == 0) {
        ((Intent)localObject).putExtra("SelectedCountryCode", "unshow");
      }
      for (;;)
      {
        paramf = this.sGW;
        if (paramf != null)
        {
          paramf = paramf.field_extInfo;
          if (paramf != null)
          {
            paramPreference = paramf.ePu;
            paramf = paramPreference;
            if (paramPreference != null) {
              break label275;
            }
          }
        }
        paramf = "";
        label275:
        ((Intent)localObject).putExtra("SelectedProvinceCode", paramf);
        paramf = this.sGW;
        if (paramf != null)
        {
          paramf = paramf.field_extInfo;
          if (paramf != null)
          {
            paramPreference = paramf.ePv;
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
        com.tencent.mm.bs.d.c((Context)getContext(), ".ui.tools.MultiStageCitySelectUI", (Intent)localObject, this.sGU);
        break;
        if (!paramf.equals("settings_sex")) {
          break;
        }
        paramf = new Intent();
        paramPreference = com.tencent.mm.kernel.g.ajC();
        p.g(paramPreference, "MMKernel.storage()");
        int i;
        if ((paramPreference.ajl().getInt(al.a.IGW, 0) & 0x8) > 0)
        {
          paramPreference = this.sGW;
          i = j;
          if (paramPreference != null)
          {
            paramPreference = paramPreference.field_extInfo;
            i = j;
            if (paramPreference != null) {
              i = paramPreference.ePk;
            }
          }
          if (i == 1) {
            paramf.putExtra("key_input_sex", "male");
          }
        }
        for (;;)
        {
          paramPreference = com.tencent.mm.plugin.finder.utils.a.sKD;
          com.tencent.mm.plugin.finder.utils.a.a((MMActivity)this, paramf, this.sGV);
          break;
          if (!paramf.equals("settings_signature")) {
            break;
          }
          paramf = new Intent();
          paramf.putExtra("key_scene", 2);
          paramPreference = com.tencent.mm.plugin.finder.utils.a.sKD;
          com.tencent.mm.plugin.finder.utils.a.I((Context)this, paramf);
          break;
          if (!paramf.equals("settings_nickname")) {
            break;
          }
          if (this.shx != null)
          {
            paramf = com.tencent.mm.kernel.g.ajC();
            p.g(paramf, "MMKernel.storage()");
            i = paramf.ajl().getInt(al.a.IGO, 0);
            ad.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(i) });
            if ((i & 0x2) != 0)
            {
              paramf = (o)com.tencent.mm.kernel.g.ab(o.class);
              paramPreference = (Context)this;
              localObject = this.shx;
              if (localObject == null) {
                p.gfZ();
              }
              localObject = ((asp)localObject).verifyInfo.appName;
              asp localasp = this.shx;
              if (localasp == null) {
                p.gfZ();
              }
              paramf.a(paramPreference, (String)localObject, null, 0, 0, localasp.verifyInfo.Goe, new AppBrandStatObject());
              break;
            }
            paramf = new Intent();
            paramf.putExtra("key_scene", 1);
            paramPreference = com.tencent.mm.plugin.finder.utils.a.sKD;
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
        paramf = this.sGW;
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
    paramf = com.tencent.mm.kernel.g.ajC();
    p.g(paramf, "MMKernel.storage()");
    if ((paramf.ajl().getInt(al.a.IGW, 0) & 0x4) == 0) {
      ((Intent)localObject).putExtra("SelectedCountryCode", "unshow");
    }
    for (;;)
    {
      paramf = this.sGW;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.ePu;
          paramf = paramPreference;
          if (paramPreference != null) {
            break label869;
          }
        }
      }
      paramf = "";
      label869:
      ((Intent)localObject).putExtra("SelectedProvinceCode", paramf);
      paramf = this.sGW;
      if (paramf != null)
      {
        paramf = paramf.field_extInfo;
        if (paramf != null)
        {
          paramPreference = paramf.ePv;
          paramf = paramPreference;
          if (paramPreference != null) {
            break label912;
          }
        }
      }
      paramf = "";
      label912:
      ((Intent)localObject).putExtra("SelectedCityCode", paramf);
      paramf = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.b((MMActivity)this, (Intent)localObject, this.sGU);
      break;
      paramf = this.sGW;
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
    updateView();
    AppMethodBeat.o(167602);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    Object localObject = null;
    AppMethodBeat.i(167607);
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
      this.shx = ((ax)paramn).cyJ();
      if (this.shx != null) {
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167598);
      this.sGX.finish();
      AppMethodBeat.o(167598);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$1", "Lcom/tencent/mm/ui/base/preference/HeadImgNewPreference$IAvatarLoaderEx;", "loadAvatar", "", "username", "", "icon", "Landroid/widget/ImageView;", "isRound", "", "plugin-finder_release"})
  public static final class b
    implements HeadImgNewPreference.a
  {
    public final void b(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(167599);
      p.h(paramString, "username");
      p.h(paramImageView, "icon");
      if (FinderSettingDetailInfoUI.a(this.sGX) == null)
      {
        ad.e(FinderSettingDetailInfoUI.b(this.sGX), "error self contact is null");
        AppMethodBeat.o(167599);
        return;
      }
      paramString = com.tencent.mm.plugin.finder.loader.i.sja;
      paramString = com.tencent.mm.plugin.finder.loader.i.cCC();
      Object localObject = FinderSettingDetailInfoUI.a(this.sGX);
      if (localObject == null) {
        p.gfZ();
      }
      localObject = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject).field_avatarUrl);
      com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.sja;
      paramString.a(localObject, paramImageView, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjd));
      AppMethodBeat.o(167599);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167600);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      if (FinderSettingDetailInfoUI.c(this.sGX) != null)
      {
        paramView = new Intent();
        localObject = FinderSettingDetailInfoUI.a(this.sGX);
        if (localObject == null) {
          p.gfZ();
        }
        paramView.putStringArrayListExtra("key_url_list", j.ac(new String[] { ((com.tencent.mm.plugin.finder.api.g)localObject).cxL() }));
        paramView.putExtra("key_preview_avatar", true);
        localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.H((Context)this.sGX, paramView);
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