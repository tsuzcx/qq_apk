package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.k;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.ce;
import com.tencent.mm.plugin.finder.model.ce.b;
import com.tencent.mm.plugin.finder.model.ce.f;
import com.tencent.mm.plugin.finder.service.r;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.component.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_DISTRICT", "REQUEST_SEX", "TAG", "", "isHasCover", "", "myFinderUser", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "selectProfileCoverHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderSelectCoverHelper;", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onPreferenceTreeClick", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshCoverEntry", "showProgress", "updateView", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderSettingDetailInfoUI
  extends MMPreference
  implements com.tencent.mm.am.h, ck<bqe>
{
  private bys AwM;
  private final int BoG = 1000;
  private final int BoH = 1001;
  private String Bre;
  private com.tencent.mm.plugin.finder.api.m Brf;
  private ProgressDialog FPA;
  private final int FUa = 1002;
  private final int FUb = 1003;
  private f FUc;
  private boolean FUd;
  private final String TAG = "Finder.FinderSettingDetailInfoUI";
  
  private static final void a(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI)
  {
    AppMethodBeat.i(347345);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_scene", 1);
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.ag((Context)paramFinderSettingDetailInfoUI, localIntent);
    AppMethodBeat.o(347345);
  }
  
  private static final void a(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI, int paramInt)
  {
    AppMethodBeat.i(347355);
    g.a locala = new g.a((Context)paramFinderSettingDetailInfoUI);
    locala.bDE(paramFinderSettingDetailInfoUI.getString(paramInt)).NF(true);
    locala.bDI(paramFinderSettingDetailInfoUI.getString(e.h.finder_account_review_confirm));
    locala.Xdm = true;
    locala.show();
    AppMethodBeat.o(347355);
  }
  
  private static final void a(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI, View paramView)
  {
    AppMethodBeat.i(347340);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderSettingDetailInfoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderSettingDetailInfoUI, "this$0");
    if (paramFinderSettingDetailInfoUI.Bre != null)
    {
      paramView = new Intent();
      localObject = paramFinderSettingDetailInfoUI.Brf;
      kotlin.g.b.s.checkNotNull(localObject);
      paramView.putStringArrayListExtra("key_url_list", kotlin.a.p.al(new String[] { ((com.tencent.mm.plugin.finder.api.m)localObject).amx() }));
      paramView.putExtra("key_preview_avatar", true);
      com.tencent.mm.plugin.finder.utils.a.GfO.v((Context)paramFinderSettingDetailInfoUI, paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347340);
  }
  
  private static final boolean a(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347333);
    kotlin.g.b.s.u(paramFinderSettingDetailInfoUI, "this$0");
    paramFinderSettingDetailInfoUI.finish();
    AppMethodBeat.o(347333);
    return true;
  }
  
  private static void doPrepareUser()
  {
    AppMethodBeat.i(167603);
    di localdi = new di(2);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localdi, 0);
    AppMethodBeat.o(167603);
  }
  
  private final void fbN()
  {
    boolean bool2 = true;
    AppMethodBeat.i(347316);
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    com.tencent.mm.plugin.finder.api.m localm = d.a.auT(this.Bre);
    if (localm == null)
    {
      localObject = null;
      if (localObject != null) {
        break label82;
      }
      localObject = ((FinderSettingDetailInfoUI)this).TAG;
      if (localm == null) {
        break label77;
      }
    }
    label77:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.w((String)localObject, kotlin.g.b.s.X("refresh  profileContact=", Boolean.valueOf(bool1)));
      AppMethodBeat.o(347316);
      return;
      localObject = localm.field_authInfo;
      break;
    }
    label82:
    bool1 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgD();
    if (localm != null)
    {
      if ((bool1) && (((FinderAuthInfo)localObject).authIconType == 2) && (localm.field_coverEntranceFlag == 1)) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.i(this.TAG, kotlin.g.b.s.X("isOpen:", Boolean.valueOf(bool1)));
        if (bool1) {
          break;
        }
        getPreferenceScreen().bAk("settings_profile_cover");
        AppMethodBeat.o(347316);
        return;
      }
      if (Util.isNullOrNil(localm.dUD())) {
        break label201;
      }
    }
    label201:
    for (bool1 = bool2;; bool1 = false)
    {
      this.FUd = bool1;
      AppMethodBeat.o(347316);
      return;
    }
  }
  
  private final void showProgress()
  {
    AppMethodBeat.i(347327);
    ProgressDialog localProgressDialog = this.FPA;
    if (localProgressDialog != null) {
      localProgressDialog.dismiss();
    }
    this.FPA = ((ProgressDialog)k.a((Context)this, getString(e.h.app_sending), false, null));
    AppMethodBeat.o(347327);
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(167604);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    this.Brf = d.a.auT(Util.nullAsNil(this.Bre));
    if (this.Brf == null)
    {
      finish();
      AppMethodBeat.o(167604);
      return;
    }
    localObject1 = getPreferenceScreen().bAi("settings_avatar");
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.HeadImgNewPreference");
      AppMethodBeat.o(167604);
      throw ((Throwable)localObject1);
    }
    localObject1 = (HeadImgNewPreference)localObject1;
    ((HeadImgNewPreference)localObject1).adYm = ((HeadImgNewPreference.a)new c(this));
    ((HeadImgNewPreference)localObject1).adYi = true;
    ((HeadImgNewPreference)localObject1).bAh(this.Bre);
    ((HeadImgNewPreference)localObject1).tyA = new FinderSettingDetailInfoUI..ExternalSyntheticLambda1(this);
    Object localObject3 = getPreferenceScreen().bAi("settings_nickname");
    ((Preference)localObject3).aeac = true;
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaB, 0);
    Log.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(i) });
    label252:
    Object localObject2;
    if (((i & 0x2) != 0) && (this.AwM != null))
    {
      Object localObject4 = (Context)this;
      i = e.h.finder_nickname_verfiy_tip;
      localObject1 = this.AwM;
      kotlin.g.b.s.checkNotNull(localObject1);
      localObject1 = ((bys)localObject1).verifyInfo;
      if (localObject1 == null)
      {
        localObject1 = "";
        ((Preference)localObject3).aS((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject4, (CharSequence)getString(i, new Object[] { localObject1 })));
        localObject1 = getPreferenceScreen().bAi("settings_signature");
        ((Preference)localObject1).aeac = true;
        localObject2 = (Context)this;
        localObject3 = this.Brf;
        kotlin.g.b.s.checkNotNull(localObject3);
        ((Preference)localObject1).aS((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject2, (CharSequence)((com.tencent.mm.plugin.finder.api.m)localObject3).field_signature));
        localObject2 = getPreferenceScreen().bAi("settings_sex");
        localObject1 = this.Brf;
        if (localObject1 == null) {
          break label685;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.api.m)localObject1).field_authInfo;
        if ((localObject1 == null) || (((FinderAuthInfo)localObject1).authIconType != 2)) {
          break label685;
        }
        i = 1;
        label346:
        if (i == 0) {
          break label690;
        }
        ((Preference)localObject2).aS((CharSequence)getString(e.h.finder_sex_enterprise_tip));
        ((Preference)localObject2).aBq(8);
        ((Preference)localObject2).setEnabled(false);
        i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0);
        Log.i(this.TAG, kotlin.g.b.s.X("updateView userExtFlag:", Integer.valueOf(i)));
        localObject1 = getPreferenceScreen().bAi("settings_district");
        if ((i & 0x4) <= 0) {
          break label902;
        }
        localObject2 = this.Brf;
        if (localObject2 != null)
        {
          localObject4 = ((com.tencent.mm.plugin.finder.api.m)localObject2).field_extInfo;
          if (localObject4 != null)
          {
            Log.i(this.TAG, "countryCode " + ((avl)localObject4).country + " provinceCode " + ((avl)localObject4).province + " cityCode " + ((avl)localObject4).city);
            RegionCodeDecoder.jcF();
            localObject2 = RegionCodeDecoder.getLocName(((avl)localObject4).country);
            RegionCodeDecoder.jcF();
            localObject3 = RegionCodeDecoder.pL(((avl)localObject4).country, ((avl)localObject4).province);
            RegionCodeDecoder.jcF();
            localObject4 = RegionCodeDecoder.bJ(((avl)localObject4).country, ((avl)localObject4).province, ((avl)localObject4).city);
            if (Util.isNullOrNil((String)localObject4)) {
              break label829;
            }
            ((Preference)localObject1).aS((CharSequence)(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).IF((String)localObject3) + ' ' + localObject4));
          }
        }
      }
    }
    label902:
    for (;;)
    {
      fbN();
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(167604);
      return;
      localObject2 = ((bqt)localObject1).ZYH;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      localObject1 = (Context)this;
      localObject2 = this.Brf;
      kotlin.g.b.s.checkNotNull(localObject2);
      ((Preference)localObject3).aS((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject1, (CharSequence)((com.tencent.mm.plugin.finder.api.m)localObject2).getNickname()));
      break label252;
      label685:
      i = 0;
      break label346;
      label690:
      localObject1 = this.Brf;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = null)
      {
        if (localObject1 == null) {
          ((Preference)localObject2).aS((CharSequence)"");
        }
        ((Preference)localObject2).aBq(0);
        ((Preference)localObject2).setEnabled(true);
        break;
        localObject1 = ((com.tencent.mm.plugin.finder.api.m)localObject1).field_extInfo;
        if (localObject1 != null) {
          break label742;
        }
      }
      label742:
      Log.i(this.TAG, kotlin.g.b.s.X("sex ", Integer.valueOf(((avl)localObject1).sex)));
      if (((avl)localObject1).sex == 1) {
        ((Preference)localObject2).aS((CharSequence)getString(e.h.sex_male));
      }
      for (;;)
      {
        localObject1 = ah.aiuX;
        break;
        if (((avl)localObject1).sex == 2) {
          ((Preference)localObject2).aS((CharSequence)getString(e.h.sex_female));
        } else {
          ((Preference)localObject2).aS((CharSequence)"");
        }
      }
      label829:
      if (!Util.isNullOrNil((String)localObject3))
      {
        ((Preference)localObject1).aS((CharSequence)(localObject2 + ' ' + localObject3));
      }
      else if (!Util.isNullOrNil((String)localObject2))
      {
        ((Preference)localObject1).aS((CharSequence)localObject2);
      }
      else
      {
        ((Preference)localObject1).aS((CharSequence)"");
        continue;
        ((Preference)localObject1).aS((CharSequence)"");
      }
    }
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public int getResourceId()
  {
    return e.k.finder_setting_detail_info_pref;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int k = 1;
    Object localObject1 = null;
    Object localObject3 = null;
    int j = 0;
    int i = 0;
    AppMethodBeat.i(167608);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject2;
    Object localObject4;
    if (paramInt1 == this.BoG)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.b.i((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.bzL());
        if ((!Util.isNullOrNil(paramIntent)) && (y.ZC(paramIntent)))
        {
          getIntent().putExtra("key_source_img_path", paramIntent);
          paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
          com.tencent.mm.plugin.finder.utils.a.d((Activity)this, getIntent(), this.BoH);
          AppMethodBeat.o(167608);
          return;
        }
        Log.w(this.TAG, "no img select");
        AppMethodBeat.o(167608);
      }
    }
    else if (paramInt1 == this.BoH)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        paramIntent = paramIntent.getStringExtra("key_result_img_path");
        if ((!Util.isNullOrNil(paramIntent)) && (y.ZC(paramIntent)))
        {
          Log.i(this.TAG, "avatar file length %d KB", new Object[] { Long.valueOf(y.bEl(paramIntent) / 1024L) });
          localObject1 = (r)com.tencent.mm.kernel.h.ax(r.class);
          kotlin.g.b.s.checkNotNull(paramIntent);
          ((r)localObject1).c(paramIntent, (ck)this);
          showProgress();
          AppMethodBeat.o(167608);
          return;
        }
        Log.w(this.TAG, "no avatar set");
        AppMethodBeat.o(167608);
      }
    }
    else if (paramInt1 == this.FUa)
    {
      if ((paramIntent == null) || (paramInt2 != -1)) {
        break label1056;
      }
      localObject2 = paramIntent.getStringExtra("Country");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject4 = paramIntent.getStringExtra("Contact_Province");
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = "";
      }
      localObject4 = paramIntent.getStringExtra("Contact_City");
      paramIntent = (Intent)localObject4;
      if (localObject4 == null) {
        paramIntent = "";
      }
      Log.i(this.TAG, "countryCode " + (String)localObject1 + " provinceCode" + (String)localObject2 + " cityCode" + paramIntent);
      if (!kotlin.g.b.s.p(localObject1, "unshow")) {
        break label1343;
      }
      paramInt1 = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adbs, Integer.valueOf(paramInt1 & 0xFFFFFFFB));
      localObject1 = "";
    }
    label568:
    label700:
    label1343:
    for (paramInt1 = k;; paramInt1 = 0)
    {
      localObject4 = this.Brf;
      avl localavl;
      if (localObject4 != null)
      {
        localavl = ((com.tencent.mm.plugin.finder.api.m)localObject4).field_extInfo;
        if (localavl != null) {
          break label568;
        }
      }
      for (;;)
      {
        if (localObject3 == null)
        {
          ((com.tencent.mm.plugin.finder.api.m)localObject4).field_extInfo = new avl();
          ((com.tencent.mm.plugin.finder.api.m)localObject4).field_extInfo.country = ((String)localObject1);
          ((com.tencent.mm.plugin.finder.api.m)localObject4).field_extInfo.province = ((String)localObject2);
          ((com.tencent.mm.plugin.finder.api.m)localObject4).field_extInfo.city = paramIntent;
        }
        localObject3 = com.tencent.mm.plugin.finder.api.d.AwY;
        d.a.d((com.tencent.mm.plugin.finder.api.m)localObject4);
        ((r)com.tencent.mm.kernel.h.ax(r.class)).a((String)localObject1, (String)localObject2, paramIntent, paramInt1, (ck)this);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)FinderSettingDetailInfoUI.a.FUe);
        showProgress();
        AppMethodBeat.o(167608);
        return;
        localavl.country = ((String)localObject1);
        localavl.province = ((String)localObject2);
        localavl.city = paramIntent;
        localObject3 = ah.aiuX;
      }
      if (paramInt1 == this.FUb)
      {
        if ((paramIntent != null) && (paramInt2 == -1))
        {
          localObject2 = paramIntent.getStringExtra("key_output_sex");
          paramIntent = (Intent)localObject2;
          if (localObject2 == null) {
            paramIntent = "";
          }
          if (((CharSequence)paramIntent).length() > 0)
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label1056;
            }
            paramInt1 = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0);
            localObject2 = this.Brf;
            if (localObject2 != null)
            {
              if (!kotlin.g.b.s.p(paramIntent, "male")) {
                break label836;
              }
              paramIntent = ((com.tencent.mm.plugin.finder.api.m)localObject2).field_extInfo;
              if (paramIntent != null) {
                break label815;
              }
              paramIntent = (Intent)localObject1;
              if (paramIntent == null)
              {
                ((com.tencent.mm.plugin.finder.api.m)localObject2).field_extInfo = new avl();
                ((com.tencent.mm.plugin.finder.api.m)localObject2).field_extInfo.sex = 1;
              }
              paramIntent = com.tencent.mm.plugin.finder.api.d.AwY;
              d.a.d((com.tencent.mm.plugin.finder.api.m)localObject2);
              com.tencent.mm.kernel.h.baE().ban().set(at.a.adbs, Integer.valueOf(paramInt1 | 0x8));
              paramIntent = (r)com.tencent.mm.kernel.h.ax(r.class);
              localObject1 = ((com.tencent.mm.plugin.finder.api.m)localObject2).field_extInfo;
              if (localObject1 != null) {
                break label827;
              }
            }
          }
          for (paramInt1 = i;; paramInt1 = ((avl)localObject1).sex)
          {
            paramIntent.a(paramInt1, (ck)this);
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)FinderSettingDetailInfoUI.b.FUf);
            showProgress();
            AppMethodBeat.o(167608);
            return;
            paramInt1 = 0;
            break;
            paramIntent.sex = 1;
            paramIntent = ah.aiuX;
            break label700;
          }
          label836:
          if (kotlin.g.b.s.p(paramIntent, "female"))
          {
            paramIntent = ((com.tencent.mm.plugin.finder.api.m)localObject2).field_extInfo;
            if (paramIntent == null)
            {
              paramIntent = null;
              label858:
              if (paramIntent == null)
              {
                ((com.tencent.mm.plugin.finder.api.m)localObject2).field_extInfo = new avl();
                ((com.tencent.mm.plugin.finder.api.m)localObject2).field_extInfo.sex = 2;
              }
              paramIntent = com.tencent.mm.plugin.finder.api.d.AwY;
              d.a.d((com.tencent.mm.plugin.finder.api.m)localObject2);
              com.tencent.mm.kernel.h.baE().ban().set(at.a.adbs, Integer.valueOf(paramInt1 | 0x8));
              paramIntent = (r)com.tencent.mm.kernel.h.ax(r.class);
              localObject1 = ((com.tencent.mm.plugin.finder.api.m)localObject2).field_extInfo;
              if (localObject1 != null) {
                break label963;
              }
            }
            for (paramInt1 = j;; paramInt1 = ((avl)localObject1).sex)
            {
              paramIntent.a(paramInt1, (ck)this);
              break;
              paramIntent.sex = 2;
              paramIntent = ah.aiuX;
              break label858;
            }
          }
          label963:
          AppMethodBeat.o(167608);
        }
      }
      else
      {
        Log.i(this.TAG, "handleActivityResult by selectProfileCoverHelper: " + paramInt1 + ' ' + paramInt2);
        localObject2 = this.FUc;
        if (localObject2 != null) {
          switch (paramInt1)
          {
          }
        }
      }
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(167608);
            return;
            Log.i("Finder.SelectCoverHelper", "REQUEST_CODE_CAPTURE_PROFILE_COVER return");
            AppMethodBeat.o(167608);
            return;
            paramIntent = com.tencent.mm.pluginsdk.ui.tools.t.g(((f)localObject2).lzt.getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.bzL());
          } while (paramIntent == null);
          Log.i("Finder.SelectCoverHelper", kotlin.g.b.s.X("REQUEST_CODE_CAPTURE_PROFILE_COVER_OLD: path:", paramIntent));
          ((f)localObject2).aBc(paramIntent);
          AppMethodBeat.o(167608);
          return;
        } while ((paramIntent == null) || (paramInt2 != -1));
        paramIntent = com.tencent.mm.ui.tools.b.i((Context)((f)localObject2).lzt, paramIntent, com.tencent.mm.plugin.image.d.bzL());
        kotlin.g.b.s.s(paramIntent, "imgPath");
        ((f)localObject2).aBc(paramIntent);
        AppMethodBeat.o(167608);
        return;
      } while ((paramIntent == null) || (paramInt2 != -1));
      localObject1 = paramIntent.getStringExtra("key_result_img_path");
      ((f)localObject2).fbF();
      if ((Util.isNullOrNil((String)localObject1)) || (!y.ZC((String)localObject1)))
      {
        Log.w("Finder.SelectCoverHelper", "no profile cover set");
        paramIntent = ((f)localObject2).DiB;
        if (paramIntent != null) {
          paramIntent.end();
        }
        aa.dc((Context)((f)localObject2).lzt, ((f)localObject2).getString(e.h.finder_update_profile_cover_failed));
        AppMethodBeat.o(167608);
        return;
      }
      localObject3 = ((f)localObject2).FTg;
      if (localObject1 == null) {}
      for (paramIntent = "";; paramIntent = (Intent)localObject1)
      {
        localObject1 = (ce.b)new f.b((f)localObject2, (String)localObject1);
        kotlin.g.b.s.u(paramIntent, "coverPath");
        kotlin.g.b.s.u(localObject1, "action");
        e.launch$default((e)localObject3, null, null, (kotlin.g.a.m)new ce.f(paramIntent, (ce)localObject3, (ce.b)localObject1, null), 3, null);
        break;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167601);
    super.onCreate(paramBundle);
    this.Bre = z.bAW();
    Log.i(this.TAG, kotlin.g.b.s.X("myFinderUser ", this.Bre));
    setMMTitle(e.h.finder_setting_detail_info);
    this.FUc = new f((MMActivity)this);
    setBackBtn(new FinderSettingDetailInfoUI..ExternalSyntheticLambda0(this));
    com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(167601);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(167609);
    super.onDestroy();
    f localf = this.FUc;
    if (localf != null) {
      localf.FTg.onCleared();
    }
    this.FUc = null;
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(167609);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = null;
    int i = 0;
    AppMethodBeat.i(167605);
    kotlin.g.b.s.checkNotNull(paramPreference);
    paramPreference = paramPreference.mKey;
    Log.i(this.TAG, kotlin.g.b.s.X("click ", paramPreference));
    if (paramPreference != null) {}
    Object localObject;
    switch (paramPreference.hashCode())
    {
    default: 
    case 679059498: 
      do
      {
        AppMethodBeat.o(167605);
        return true;
      } while (!paramPreference.equals("settings_district"));
      localObject = new Intent();
      ((Intent)localObject).putExtra("GetAddress", true);
      ((Intent)localObject).putExtra("ShowSelectedLocation", true);
      ((Intent)localObject).putExtra("SetSelectLocation", true);
      if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0) & 0x4) == 0)
      {
        ((Intent)localObject).putExtra("SelectedCountryCode", "unshow");
        paramf = this.Brf;
        if (paramf != null) {
          break label935;
        }
        paramf = "";
        label200:
        ((Intent)localObject).putExtra("SelectedProvinceCode", paramf);
        paramf = this.Brf;
        if (paramf != null) {
          break label969;
        }
        paramf = "";
      }
      break;
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("SelectedCityCode", paramf);
      ((Intent)localObject).putExtra("NeedUnshowItem", false);
      c.d((Context)getContext(), ".ui.tools.MultiStageCitySelectUI", (Intent)localObject, this.FUa);
      break;
      if (!paramPreference.equals("settings_sex")) {
        break;
      }
      paramf = new Intent();
      if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0) & 0x8) > 0)
      {
        paramPreference = this.Brf;
        if (paramPreference == null) {
          switch (i)
          {
          default: 
            label311:
            paramf.putExtra("key_input_sex", "");
          }
        }
      }
      for (;;)
      {
        paramPreference = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.a((MMActivity)this, paramf, this.FUb);
        break;
        if (!paramPreference.equals("settings_signature")) {
          break;
        }
        paramf = new Intent();
        paramf.putExtra("key_scene", 2);
        paramPreference = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.ag((Context)this, paramf);
        break;
        if (!paramPreference.equals("settings_avatar")) {
          break;
        }
        paramf = com.tencent.mm.plugin.findersdk.d.a.Hdr;
        if (com.tencent.mm.plugin.findersdk.d.a.aDj("personalInfo")) {
          break;
        }
        com.tencent.mm.pluginsdk.ui.tools.t.r((Activity)this, this.BoG);
        break;
        if (!paramPreference.equals("settings_nickname")) {
          break;
        }
        if (this.AwM != null)
        {
          i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaB, 0);
          Log.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(i) });
          paramPreference = com.tencent.mm.kernel.h.baE().ban().get(at.a.adfg, Integer.valueOf(0));
          Log.i(this.TAG, "auth_verify_identity %d", new Object[] { paramPreference });
          if ((i & 0x2) != 0)
          {
            com.tencent.mm.plugin.appbrand.service.t localt = (com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class);
            Context localContext = (Context)this;
            paramf = this.AwM;
            kotlin.g.b.s.checkNotNull(paramf);
            paramf = paramf.verifyInfo;
            if (paramf == null)
            {
              paramf = "";
              label577:
              paramPreference = this.AwM;
              kotlin.g.b.s.checkNotNull(paramPreference);
              paramPreference = paramPreference.verifyInfo;
              if (paramPreference != null) {
                break label671;
              }
              paramPreference = "";
            }
            for (;;)
            {
              localt.a(localContext, paramf, null, 0, 0, paramPreference, new AppBrandStatObject());
              break;
              if (!paramPreference.equals("settings_profile_cover")) {
                break;
              }
              paramf = this.FUc;
              if (paramf == null) {
                break;
              }
              paramf.uh(this.FUd);
              break;
              paramPreference = paramf.appName;
              paramf = paramPreference;
              if (paramPreference != null) {
                break label577;
              }
              paramf = "";
              break label577;
              label671:
              localObject = paramPreference.ZYG;
              paramPreference = (Preference)localObject;
              if (localObject == null) {
                paramPreference = "";
              }
            }
          }
          if (kotlin.g.b.s.p(paramPreference, Integer.valueOf(1)))
          {
            a(this);
            break;
          }
          if (kotlin.g.b.s.p(paramPreference, Integer.valueOf(2)))
          {
            a(this, e.h.finder_account_reviewing_content);
            break;
          }
          if (kotlin.g.b.s.p(paramPreference, Integer.valueOf(3)))
          {
            paramPreference = com.tencent.mm.plugin.finder.api.d.AwY;
            paramPreference = d.a.auT(z.bAW());
            if (paramPreference == null)
            {
              if (paramf != null) {
                break;
              }
              a(this, e.h.finder_account_auth_content);
              break;
            }
            if (paramPreference.field_authInfo.authIconType == 2) {
              a(this, e.h.finder_account_auth_content);
            }
            for (;;)
            {
              paramf = ah.aiuX;
              break;
              a(this);
            }
          }
          a(this);
          break;
        }
        doPrepareUser();
        break;
        paramPreference = paramPreference.field_extInfo;
        if (paramPreference == null) {
          break label311;
        }
        i = paramPreference.sex;
        break label311;
        paramf.putExtra("key_input_sex", "male");
        continue;
        paramf.putExtra("key_input_sex", "female");
        continue;
        paramf.putExtra("key_input_sex", "");
      }
      paramf = this.Brf;
      if (paramf == null) {
        paramf = "";
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("SelectedCountryCode", paramf);
        break;
        paramf = paramf.field_extInfo;
        if (paramf == null)
        {
          paramf = "";
        }
        else
        {
          paramPreference = paramf.country;
          paramf = paramPreference;
          if (paramPreference == null) {
            paramf = "";
          }
        }
      }
      label935:
      paramf = paramf.field_extInfo;
      if (paramf == null)
      {
        paramf = "";
        break label200;
      }
      paramPreference = paramf.province;
      paramf = paramPreference;
      if (paramPreference != null) {
        break label200;
      }
      paramf = "";
      break label200;
      label969:
      paramf = paramf.field_extInfo;
      if (paramf == null)
      {
        paramf = "";
      }
      else
      {
        paramPreference = paramf.city;
        paramf = paramPreference;
        if (paramPreference == null) {
          paramf = "";
        }
      }
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(167607);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene ");
    if (paramp == null)
    {
      paramString = null;
      Log.i(str, paramString + " scene:" + paramp);
      if (paramp != null) {
        break label120;
      }
    }
    label120:
    for (paramString = localObject;; paramString = Integer.valueOf(paramp.getType()))
    {
      if (paramString != null) {
        break label132;
      }
      AppMethodBeat.o(167607);
      return;
      paramString = Integer.valueOf(paramp.getType());
      break;
    }
    label132:
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(167607);
        throw paramString;
      }
      this.AwM = ((di)paramp).dVy();
      if (this.AwM != null) {
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
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$1", "Lcom/tencent/mm/ui/base/preference/HeadImgNewPreference$IAvatarLoaderEx;", "loadAvatar", "", "username", "", "icon", "Landroid/widget/ImageView;", "isRound", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements HeadImgNewPreference.a
  {
    c(FinderSettingDetailInfoUI paramFinderSettingDetailInfoUI) {}
    
    public final void c(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(167599);
      kotlin.g.b.s.u(paramString, "username");
      kotlin.g.b.s.u(paramImageView, "icon");
      if (FinderSettingDetailInfoUI.b(this.FUg) == null)
      {
        Log.e(FinderSettingDetailInfoUI.c(this.FUg), "error self contact is null");
        AppMethodBeat.o(167599);
        return;
      }
      paramString = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramString = com.tencent.mm.plugin.finder.loader.p.eCp();
      Object localObject = FinderSettingDetailInfoUI.b(this.FUg);
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = new com.tencent.mm.plugin.finder.loader.b(((com.tencent.mm.plugin.finder.api.m)localObject).field_avatarUrl);
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramString.a(localObject, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      AppMethodBeat.o(167599);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingDetailInfoUI
 * JD-Core Version:    0.7.0.1
 */