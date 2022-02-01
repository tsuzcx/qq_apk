package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.autogen.a.ax;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.protocal.protobuf.cts;
import com.tencent.mm.protocal.protobuf.fal;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.w;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineSettingUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "bizTimeLineSettingLoadingPref", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimelineSettingLoadingPreference;", "getBizTimeLineSettingLoadingPref", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimelineSettingLoadingPreference;", "bizTimeLineSettingLoadingPref$delegate", "Lkotlin/Lazy;", "isDoingSetting", "", "()Z", "setDoingSetting", "(Z)V", "personalizedRecommendCb", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "getPersonalizedRecommendCb", "()Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "personalizedRecommendCb$delegate", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "setTimelineSettingReq", "Lcom/tencent/mm/protocal/protobuf/SetTimelineSettingReq;", "getSetTimelineSettingReq", "()Lcom/tencent/mm/protocal/protobuf/SetTimelineSettingReq;", "delayShowProgressDlg", "", "dismissProgressDlg", "getResourceId", "", "getTimelineSetting", "initActionBar", "initData", "resp", "Lcom/tencent/mm/protocal/protobuf/GetTimelineSettingResp;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "setTimelineSetting", "req", "showGetTimelineSettingErrorDialog", "errMsg", "", "showProgressDlg", "showSetTimelineSettingErrorDialog", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizTimeLineSettingUI
  extends MMPreference
{
  public static final BizTimeLineSettingUI.a vHL;
  private w psR;
  private final j vHM;
  private final j vHN;
  private final fal vHO;
  private boolean vHP;
  
  static
  {
    AppMethodBeat.i(302045);
    vHL = new BizTimeLineSettingUI.a((byte)0);
    AppMethodBeat.o(302045);
  }
  
  public BizTimeLineSettingUI()
  {
    AppMethodBeat.i(301935);
    this.vHM = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.vHN = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.vHO = new fal();
    AppMethodBeat.o(301935);
  }
  
  private static final int a(ah.a parama, BizTimeLineSettingUI paramBizTimeLineSettingUI, WeakReference paramWeakReference, fal paramfal, int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
  {
    AppMethodBeat.i(302016);
    s.u(parama, "$callbackCalled");
    s.u(paramBizTimeLineSettingUI, "this$0");
    s.u(paramWeakReference, "$weakThis");
    s.u(paramfal, "$req");
    s.u(paramc, "rr");
    s.u(paramp, "$noName_4");
    Log.i("MicroMsg.BizTimeLineSettingUI", "setTimelineSetting callback " + paramInt1 + ", " + paramInt2 + ", " + paramString);
    if (parama.aiwY)
    {
      AppMethodBeat.o(302016);
      return 0;
    }
    paramBizTimeLineSettingUI.vHP = false;
    paramBizTimeLineSettingUI = (BizTimeLineSettingUI)paramWeakReference.get();
    if (paramBizTimeLineSettingUI != null) {
      paramBizTimeLineSettingUI.ddd();
    }
    parama.aiwY = true;
    if (!(c.c.b(paramc.otC) instanceof fam))
    {
      Log.w("MicroMsg.BizTimeLineSettingUI", "not my resp");
      AppMethodBeat.o(302016);
      return 0;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      parama = (BizTimeLineSettingUI)paramWeakReference.get();
      if (parama != null) {
        parama.aiY(paramString);
      }
      AppMethodBeat.o(302016);
      return 0;
    }
    parama = new ax();
    parama.hAI.hAJ = paramfal.aazw;
    parama.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(302016);
    return 0;
  }
  
  private static final int a(ah.a parama, WeakReference paramWeakReference, int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
  {
    AppMethodBeat.i(301989);
    s.u(parama, "$callbackCalled");
    s.u(paramWeakReference, "$weakThis");
    s.u(paramc, "rr");
    s.u(paramp, "$noName_4");
    Log.i("MicroMsg.BizTimeLineSettingUI", "getTimelineSetting callback " + paramInt1 + ", " + paramInt2);
    if (parama.aiwY)
    {
      AppMethodBeat.o(301989);
      return 0;
    }
    parama.aiwY = true;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      parama = (BizTimeLineSettingUI)paramWeakReference.get();
      if (parama != null) {
        parama.aiX(paramString);
      }
      AppMethodBeat.o(301989);
      return 0;
    }
    if (!(c.c.b(paramc.otC) instanceof cts))
    {
      Log.w("MicroMsg.BizTimeLineSettingUI", "not my resp");
      AppMethodBeat.o(301989);
      return 0;
    }
    parama = c.c.b(paramc.otC);
    if (parama == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetTimelineSettingResp");
      AppMethodBeat.o(301989);
      throw parama;
    }
    parama = (cts)parama;
    paramWeakReference = (BizTimeLineSettingUI)paramWeakReference.get();
    if (paramWeakReference != null)
    {
      Log.i("MicroMsg.BizTimeLineSettingUI", s.X("initData personalized_recommend_setting=", Boolean.valueOf(parama.aazw)));
      paramWeakReference.ddb().setChecked(parama.aazw);
      parama = paramWeakReference.getPreferenceScreen();
      s.checkNotNull(parama);
      parama.eh("biz_msg_rec_pref", false);
      parama = paramWeakReference.getPreferenceScreen();
      s.checkNotNull(parama);
      parama.eh("biz_msg_rec_loading_pref", true);
    }
    AppMethodBeat.o(301989);
    return 0;
  }
  
  private static final void a(BizTimeLineSettingUI paramBizTimeLineSettingUI)
  {
    AppMethodBeat.i(302032);
    s.u(paramBizTimeLineSettingUI, "this$0");
    if ((paramBizTimeLineSettingUI.vHP) && (!paramBizTimeLineSettingUI.isFinishing())) {
      paramBizTimeLineSettingUI.cKs();
    }
    AppMethodBeat.o(302032);
  }
  
  private static final void a(BizTimeLineSettingUI paramBizTimeLineSettingUI, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(302040);
    s.u(paramBizTimeLineSettingUI, "this$0");
    paramBizTimeLineSettingUI.finish();
    AppMethodBeat.o(302040);
  }
  
  private static final void a(BizTimeLineSettingUI paramBizTimeLineSettingUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(301999);
    s.u(paramBizTimeLineSettingUI, "this$0");
    paramDialogInterface.dismiss();
    paramBizTimeLineSettingUI.ddc();
    AppMethodBeat.o(301999);
  }
  
  private void a(fal paramfal)
  {
    AppMethodBeat.i(301964);
    s.u(paramfal, "req");
    Log.i("MicroMsg.BizTimeLineSettingUI", s.X("setTimelineSetting personalized_recommend_setting = ", Boolean.valueOf(paramfal.aazw)));
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((com.tencent.mm.bx.a)paramfal);
    ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new fam());
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/timeline/settimelinesetting";
    ((c.a)localObject).funcId = 1460;
    localObject = ((c.a)localObject).bEF();
    ah.a locala = new ah.a();
    WeakReference localWeakReference = new WeakReference(this);
    this.vHP = true;
    z.a((c)localObject, new BizTimeLineSettingUI..ExternalSyntheticLambda7(locala, this, localWeakReference, paramfal));
    AppMethodBeat.o(301964);
  }
  
  private static final boolean a(BizTimeLineSettingUI paramBizTimeLineSettingUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(301980);
    s.u(paramBizTimeLineSettingUI, "this$0");
    paramBizTimeLineSettingUI.finish();
    AppMethodBeat.o(301980);
    return true;
  }
  
  private final void aiX(String paramString)
  {
    AppMethodBeat.i(301957);
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence == null) || (n.bp(localCharSequence)))
    {
      i = 1;
      if (i == 0) {
        break label97;
      }
      paramString = getString(d.i.biz_timeline_get_setting_failed);
    }
    label97:
    for (;;)
    {
      s.s(paramString, "if (errMsg.isNullOrBlank…tting_failed) else errMsg");
      com.tencent.mm.ui.base.k.b((Context)this, "", paramString, getString(d.i.app_retry), getString(d.i.app_cancel), new BizTimeLineSettingUI..ExternalSyntheticLambda3(this), new BizTimeLineSettingUI..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(301957);
      return;
      i = 0;
      break;
    }
  }
  
  private final void aiY(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(301969);
    Object localObject = ddb();
    boolean bool;
    if (!this.vHO.aazw)
    {
      bool = true;
      ((CheckBoxPreference)localObject).Hy(bool);
      localObject = (CharSequence)paramString;
      if ((localObject == null) || (n.bp((CharSequence)localObject))) {
        i = 1;
      }
      if (i == 0) {
        break label121;
      }
      paramString = getString(d.i.biz_timeline_set_setting_failed);
    }
    label121:
    for (;;)
    {
      s.s(paramString, "if (errMsg.isNullOrBlank…tting_failed) else errMsg");
      com.tencent.mm.ui.base.k.b((Context)this, "", paramString, getString(d.i.app_retry), getString(d.i.app_cancel), new BizTimeLineSettingUI..ExternalSyntheticLambda4(this), BizTimeLineSettingUI..ExternalSyntheticLambda5.INSTANCE);
      AppMethodBeat.o(301969);
      return;
      bool = false;
      break;
    }
  }
  
  private static final void b(BizTimeLineSettingUI paramBizTimeLineSettingUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(302007);
    s.u(paramBizTimeLineSettingUI, "this$0");
    paramBizTimeLineSettingUI.finish();
    AppMethodBeat.o(302007);
  }
  
  private static final void c(BizTimeLineSettingUI paramBizTimeLineSettingUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(302022);
    s.u(paramBizTimeLineSettingUI, "this$0");
    paramDialogInterface.dismiss();
    paramBizTimeLineSettingUI.ddb().Hy(paramBizTimeLineSettingUI.vHO.aazw);
    paramBizTimeLineSettingUI.a(paramBizTimeLineSettingUI.vHO);
    paramBizTimeLineSettingUI.cKs();
    AppMethodBeat.o(302022);
  }
  
  private final void cKs()
  {
    AppMethodBeat.i(301973);
    ddd();
    this.psR = com.tencent.mm.ui.base.k.a((Context)this, getString(d.i.app_waiting), false, BizTimeLineSettingUI..ExternalSyntheticLambda1.INSTANCE);
    w localw = this.psR;
    if (localw != null) {
      localw.setOnCancelListener(new BizTimeLineSettingUI..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(301973);
  }
  
  private static final void d(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(302035);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(302035);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      Log.e("MicroMsg.BizTimeLineSettingUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(302035);
    }
  }
  
  private CheckBoxPreference ddb()
  {
    AppMethodBeat.i(301940);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.vHM.getValue();
    AppMethodBeat.o(301940);
    return localCheckBoxPreference;
  }
  
  private void ddc()
  {
    AppMethodBeat.i(301948);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((com.tencent.mm.bx.a)new ctr());
    ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new cts());
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/timeline/gettimelinesetting";
    ((c.a)localObject).funcId = 4758;
    localObject = ((c.a)localObject).bEF();
    WeakReference localWeakReference = new WeakReference(this);
    z.a((c)localObject, new BizTimeLineSettingUI..ExternalSyntheticLambda8(new ah.a(), localWeakReference));
    AppMethodBeat.o(301948);
  }
  
  private final void ddd()
  {
    AppMethodBeat.i(301977);
    if (this.psR == null)
    {
      AppMethodBeat.o(301977);
      return;
    }
    w localw = this.psR;
    if (localw != null) {
      localw.dismiss();
    }
    this.psR = null;
    AppMethodBeat.o(301977);
  }
  
  private static final void j(DialogInterface paramDialogInterface, int paramInt) {}
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getResourceId()
  {
    return d.f.biz_timeline_setting_pref;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(302119);
    super.onCreate(paramBundle);
    setMMTitle(d.i.app_set);
    setTitleDividerVis(false);
    hideActionbarLine();
    setBackBtn(new BizTimeLineSettingUI..ExternalSyntheticLambda6(this));
    paramBundle = getPreferenceScreen();
    s.checkNotNull(paramBundle);
    paramBundle.eh("biz_msg_rec_pref", true);
    paramBundle = getPreferenceScreen();
    s.checkNotNull(paramBundle);
    paramBundle.eh("biz_msg_rec_loading_pref", false);
    ddc();
    AppMethodBeat.o(302119);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(302130);
    if (paramf == null)
    {
      AppMethodBeat.o(302130);
      return false;
    }
    s.checkNotNull(paramPreference);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.BizTimeLineSettingUI", s.X(paramf, " item has been clicked!"));
    s.s(paramf, "key");
    if (n.rs("biz_msg_rec_pref", paramf))
    {
      this.vHO.aazw = ddb().isChecked();
      h.ahAA.o(new BizTimeLineSettingUI..ExternalSyntheticLambda9(this), 800L);
      a(this.vHO);
    }
    AppMethodBeat.o(302130);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimelineSettingLoadingPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<BizTimelineSettingLoadingPreference>
  {
    b(BizTimeLineSettingUI paramBizTimeLineSettingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<CheckBoxPreference>
  {
    c(BizTimeLineSettingUI paramBizTimeLineSettingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineSettingUI
 * JD-Core Version:    0.7.0.1
 */