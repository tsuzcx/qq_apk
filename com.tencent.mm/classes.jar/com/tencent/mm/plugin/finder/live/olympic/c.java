package com.tencent.mm.plugin.finder.live.olympic;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.live.olympic.certificate.data.a.b;
import com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e.a;
import com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e.j;
import com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e.q;
import com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e.r;
import com.tencent.mm.plugin.finder.live.olympic.certificate.widget.g;
import com.tencent.mm.plugin.finder.live.olympic.report.a.a;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.f;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.plugin.finder.utils.bk;
import com.tencent.mm.plugin.finder.utils.v;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.f.c;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.p;
import kotlin.r;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicCertificatePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/ICertificateService;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "certificateLayout", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateLayout;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "inviteRelayOlympicTorchRunnable", "com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicCertificatePlugin$inviteRelayOlympicTorchRunnable$1", "Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicCertificatePlugin$inviteRelayOlympicTorchRunnable$1;", "isGenrating", "", "isLocationEnable", "isReceivePortrait", "isRelaying", "isUpdating", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "lockJob", "Lkotlinx/coroutines/Deferred;", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "getMainScope", "()Lkotlinx/coroutines/CoroutineScope;", "olympicsState", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$OlympicState;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "addTorchLive", "", "isLightTorch", "certificateName", "", "loading", "isAutoAdd", "(ZLjava/lang/String;Lkotlinx/coroutines/Deferred;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkInviteRelayOlympicTorch", "checkLocation", "(Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearLiveScreen", "closeCertificateLayout", "doExportImg", "filePath", "generateOlympicCertificate", "name", "getTorchLive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTorchPag", "Lkotlin/Pair;", "Lorg/libpag/PAGFile;", "tag", "handleOlympicError", "result", "Lcom/tencent/mm/plugin/finder/live/olympic/OlympicCgiException;", "errorMsg", "initCertificateView", "initOlympicInfo", "initReportData", "mount", "notifyCertificateDataChange", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData;", "onBackPress", "onCertificateLayoutVisibility", "isShow", "onPortraitAction", "actionInfo", "Landroid/os/Bundle;", "extraData", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "openOlympicCard", "state", "receiveLocationPermission", "isEnable", "relayOlympicTorch", "isAnim", "saveCertificateView", "isSavePic", "path", "savePhoto", "setVisible", "visible", "setWxState", "isFromShare", "shareOlympicCertificate", "certificateData", "showLiveScreen", "showLoading", "showLocationDialog", "isJoinRunWith", "isAccessLocation", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "unMount", "updateOlympicCertificate", "Lkotlinx/coroutines/Job;", "isShowSportStep", "updateTorchLive", "nameText", "(Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.finder.live.plugin.b
  implements com.tencent.mm.plugin.finder.live.olympic.certificate.b
{
  public static final c.a CNk;
  private com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e CNl;
  private n.f CNm;
  private boolean CNn;
  private boolean CNo;
  private boolean CNp;
  private ay<ah> CNq;
  private boolean CNr;
  private final h CNs;
  private final CoroutineExceptionHandler CNt;
  final MMActivity activity;
  private w loadingDialog;
  private aq mainScope;
  private boolean mjj;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(360697);
    CNk = new c.a((byte)0);
    AppMethodBeat.o(360697);
  }
  
  public c(MMActivity paramMMActivity, ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(360495);
    this.activity = paramMMActivity;
    this.nfT = paramb;
    this.CNm = n.f.EhL;
    this.CNs = new h(this);
    this.CNt = ((CoroutineExceptionHandler)new m(CoroutineExceptionHandler.ajvG));
    AppMethodBeat.o(360495);
  }
  
  private final void Q(boolean paramBoolean, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(360548);
    com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e locale;
    if (paramBoolean)
    {
      locale = this.CNl;
      if (locale != null) {}
    }
    for (;;)
    {
      localObject = BitmapUtil.getBitmapFromView((View)localObject);
      Log.i("FinderLiveOlympicCardPl", "saveCertificateView bitmap: " + localObject + " path: " + paramString + " isSavePic: " + paramBoolean);
      if (localObject != null)
      {
        BitmapUtil.saveBitmapToImage((Bitmap)localObject, 80, Bitmap.CompressFormat.JPEG, paramString, true);
        if (paramBoolean) {
          awM(paramString);
        }
      }
      AppMethodBeat.o(360548);
      return;
      localObject = (View)locale.CPW.mJe;
      continue;
      locale = this.CNl;
      if (locale != null) {
        localObject = (View)locale.CPX.mJe;
      }
    }
  }
  
  private final Object a(boolean paramBoolean1, String paramString, ay<ah> paramay, boolean paramBoolean2, kotlin.d.d<Object> paramd)
  {
    AppMethodBeat.i(360535);
    paramString = l.a((kotlin.d.f)bg.kCi(), (kotlin.g.a.m)new c.c(this, paramay, paramString, paramBoolean1, paramBoolean2, null), paramd);
    AppMethodBeat.o(360535);
    return paramString;
  }
  
  private static final void a(c paramc, n.e parame)
  {
    AppMethodBeat.i(360571);
    s.u(paramc, "this$0");
    paramc.ens();
    AppMethodBeat.o(360571);
  }
  
  private void a(n.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(360520);
    s.u(paramf, "state");
    if (this.CNl == null)
    {
      AppMethodBeat.o(360520);
      return;
    }
    this.CNm = paramf;
    com.tencent.mm.ae.d.H((Runnable)this.CNs);
    boolean bool = isLandscape();
    Log.i("FinderLiveOlympicCardPl", s.X("openOlympicCard isLandscape:", Boolean.valueOf(bool)));
    if ((bool) && ((!aw.jkP()) || (aw.ato())))
    {
      ((com.tencent.mm.plugin.finder.live.plugin.b)this).D("PORTRAIT_ACTION_TORCH_BTN_CLICK", null);
      AppMethodBeat.o(360520);
      return;
    }
    paramf = z.bAO();
    s.s(paramf, "getNicknameFromUserInfo()");
    by(paramf, paramBoolean);
    AppMethodBeat.o(360520);
  }
  
  private final void awM(String paramString)
  {
    AppMethodBeat.i(360558);
    ExportFileUtil.a((Context)this.activity, paramString, (ExportFileUtil.a)new e(this));
    AppMethodBeat.o(360558);
  }
  
  private final void ens()
  {
    boolean bool3 = true;
    AppMethodBeat.i(360513);
    Object localObject = (n.e)((n)getBuContext().business(n.class)).Ehd.getValue();
    boolean bool1;
    label72:
    int i;
    label96:
    label102:
    long l;
    if ((localObject != null) && (((n.e)localObject).EhI == true))
    {
      bool1 = true;
      localObject = ((n)business(n.class)).Ehe;
      if (localObject != null) {
        break label195;
      }
      localObject = null;
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label205;
      }
      i = 1;
      if (i != 0) {
        break label210;
      }
      bool2 = true;
      Log.i("FinderLiveOlympicCardPl", "initReportData isTorcher: " + bool1 + " isRelay: " + bool2);
      localObject = com.tencent.mm.plugin.finder.live.olympic.report.a.CRJ;
      l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
      if ((bool1) || (!bool2)) {
        break label215;
      }
    }
    label195:
    label205:
    label210:
    label215:
    for (boolean bool2 = bool3;; bool2 = false)
    {
      com.tencent.mm.plugin.finder.live.olympic.report.a.a(new a.a(l, bool2, bool1));
      AppMethodBeat.o(360513);
      return;
      bool1 = false;
      break;
      localObject = ((brs)localObject).ZVq;
      break label72;
      i = 0;
      break label96;
      bool2 = false;
      break label102;
    }
  }
  
  private final aq getMainScope()
  {
    AppMethodBeat.i(360503);
    aq localaq;
    if (this.mainScope != null)
    {
      localaq = this.mainScope;
      if ((localaq == null) || (ar.a(localaq))) {
        break label55;
      }
    }
    label55:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.mainScope = ar.kBZ();
      }
      localaq = this.mainScope;
      AppMethodBeat.o(360503);
      return localaq;
    }
  }
  
  private final void qN(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(360566);
    Object localObject1 = new Bundle();
    Object localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    boolean bool1;
    if (!paramBoolean)
    {
      bool1 = true;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).EcH = bool1;
      if (paramBoolean) {
        break label104;
      }
      bool1 = bool2;
      label47:
      ((Bundle)localObject1).putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", bool1);
      this.nfT.statusChange(b.c.ndZ, (Bundle)localObject1);
      localObject2 = this.nfT;
      if (!paramBoolean) {
        break label109;
      }
    }
    label104:
    label109:
    for (localObject1 = b.c.nfG;; localObject1 = b.c.nfF)
    {
      b.b.a((com.tencent.mm.live.b.b)localObject2, (b.c)localObject1);
      AppMethodBeat.o(360566);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label47;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.olympic.certificate.data.a parama)
  {
    AppMethodBeat.i(360781);
    s.u(parama, "certificateData");
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject = d.a.auT(z.bAW());
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.finder.api.m)localObject).dUs())
    {
      Log.i("FinderLiveOlympicCardPl", "headUrl: " + localObject + " shareOlympicCertificate: " + parama);
      n localn = (n)business(n.class);
      brs localbrs = new brs();
      localbrs.ZVp = parama.CPk;
      localbrs.ZVq = String.valueOf(parama.CPj.CPl);
      localbrs.ZVr = parama.CPj.name;
      localbrs.ZVs = ((String)localObject);
      parama = ah.aiuX;
      localn.Ehf = localbrs;
      b.b.a(this.nfT, b.c.neb);
      AppMethodBeat.o(360781);
      return;
    }
  }
  
  public final void awL(String paramString)
  {
    AppMethodBeat.i(360749);
    s.u(paramString, "name");
    Log.i("FinderLiveOlympicCardPl", "showLocationDialog lock");
    j.a(ar.d((kotlin.d.f)bg.kCi()), (kotlin.d.f)this.CNt, null, (kotlin.g.a.m)new l(this, null), 2);
    AppMethodBeat.o(360749);
  }
  
  public final r<PAGFile, String> awN(String paramString)
  {
    AppMethodBeat.i(360829);
    s.u(paramString, "tag");
    Object localObject = bk.GlT;
    localObject = this.mJe.getContext();
    s.s(localObject, "root.context");
    paramString = bk.a((Context)localObject, getBuContext(), paramString);
    AppMethodBeat.o(360829);
    return paramString;
  }
  
  public final void by(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(360767);
    s.u(paramString, "name");
    if (this.CNn)
    {
      Log.i("FinderLiveOlympicCardPl", s.X("generateOlympicCertificate isGenrating name = ", paramString));
      AppMethodBeat.o(360767);
      return;
    }
    Log.i("FinderLiveOlympicCardPl", "generateOlympicCertificate name: " + paramString + " olympicsState: " + this.CNm + " isAutoAdd: " + paramBoolean);
    getBuContext().business(n.class);
    final n.b localb = n.b(this.CNm);
    aq localaq = getMainScope();
    if (localaq != null) {
      j.a(localaq, (kotlin.d.f)this.CNt, null, (kotlin.g.a.m)new f(this, localb, paramString, paramBoolean, null), 2);
    }
    AppMethodBeat.o(360767);
  }
  
  public final void c(Bundle paramBundle, Object paramObject)
  {
    AppMethodBeat.i(360744);
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      Log.i("FinderLiveOlympicCardPl", s.X("onPortraitAction action: ", paramBundle));
      if (s.p(paramBundle, "PORTRAIT_ACTION_TORCH_BTN_CLICK")) {
        this.CNp = true;
      }
      AppMethodBeat.o(360744);
      return;
      paramObject = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      paramBundle = paramObject;
      if (paramObject == null) {
        paramBundle = "";
      }
    }
  }
  
  public final void ent()
  {
    AppMethodBeat.i(360728);
    if (this.CNo)
    {
      Log.e("FinderLiveOlympicCardPl", s.X("relayOlympicTorch isRelaying isAnim: ", Boolean.TRUE));
      AppMethodBeat.o(360728);
      return;
    }
    aq localaq = getMainScope();
    if (localaq != null) {
      j.a(localaq, (kotlin.d.f)this.CNt, null, (kotlin.g.a.m)new j(this, true, null), 2);
    }
    AppMethodBeat.o(360728);
  }
  
  public final void enu()
  {
    Object localObject3 = null;
    AppMethodBeat.i(360801);
    Object localObject1 = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    String str = com.tencent.mm.plugin.finder.live.olympic.util.a.eoq();
    Q(false, str);
    localObject1 = this.CNl;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = (n.e)((n)business(n.class)).Ehd.getValue();
        if (localObject1 != null) {
          break label270;
        }
        localObject2 = null;
      }
      label67:
      localObject1 = this.CNl;
      if (localObject1 != null) {
        break label281;
      }
      localObject1 = localObject3;
    }
    for (;;)
    {
      Log.i("FinderLiveOlympicCardPl", "setWxState path: " + str + " , certId: " + localObject2 + " certInfo: " + localObject1);
      localObject2 = this.mJe.getContext().getString(p.h.Cpt, new Object[] { localObject2 });
      s.s(localObject2, "root.context.getString(R…olympic_cert_num, certId)");
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcI = false;
      localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.arw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
      localObject3 = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      Object localObject4 = this.activity.getContext();
      s.s(localObject4, "activity.context");
      ((com.tencent.mm.plugin.f)localObject3).a((AppCompatActivity)localObject4, (String)localObject1, (String)localObject2, str);
      AppMethodBeat.o(360801);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CQk;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.olympic.certificate.data.a)localObject1).CPj;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((a.b)localObject1).CPl);
      break;
      label270:
      localObject2 = Long.valueOf(((n.e)localObject1).CPl);
      break label67;
      label281:
      localObject4 = ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CQk;
      localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = ((com.tencent.mm.plugin.finder.live.olympic.certificate.data.a)localObject4).CPk;
      }
    }
  }
  
  public final void env()
  {
    AppMethodBeat.i(360817);
    qN(true);
    AppMethodBeat.o(360817);
  }
  
  public final cb g(final String paramString, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(360772);
    s.u(paramString, "name");
    if (this.mjj)
    {
      Log.i("FinderLiveOlympicCardPl", "updateOlympicCertificate isUpdating");
      AppMethodBeat.o(360772);
      return null;
    }
    aq localaq = getMainScope();
    if (localaq == null)
    {
      AppMethodBeat.o(360772);
      return null;
    }
    paramString = j.a(localaq, (kotlin.d.f)this.CNt, null, (kotlin.g.a.m)new n(this, paramString, paramBoolean1, paramBoolean2, null), 2);
    AppMethodBeat.o(360772);
    return paramString;
  }
  
  public final void jdo()
  {
    AppMethodBeat.i(371587);
    i(this);
    AppMethodBeat.o(371587);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(360732);
    super.mount();
    Object localObject = this.CNl;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject).mount();
    }
    localObject = bj.GlQ;
    Log.i("FinderLiveOlympicCardPl", s.X("mount : ", Boolean.valueOf(bj.y(getBuContext()))));
    AppMethodBeat.o(360732);
  }
  
  public final boolean onBackPress()
  {
    int i = 0;
    AppMethodBeat.i(360810);
    com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e locale = this.CNl;
    if (locale == null)
    {
      AppMethodBeat.o(360810);
      return false;
    }
    if (locale.mJe.getVisibility() == 0)
    {
      com.tencent.mm.plugin.finder.live.olympic.certificate.widget.b localb = locale.CPV;
      if (((View)localb.CPA).getVisibility() == 0)
      {
        localb.CPB.hide();
        i = 1;
      }
      if (i != 0)
      {
        AppMethodBeat.o(360810);
        return true;
      }
      locale.enR();
      AppMethodBeat.o(360810);
      return true;
    }
    AppMethodBeat.o(360810);
    return false;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(360758);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    Log.i("FinderLiveOlympicCardPl", "onRequestPermissionsResult requestCode: " + paramInt + " resule: " + paramArrayOfInt);
    if (paramInt == 1001)
    {
      paramArrayOfString = kotlin.a.k.ab(paramArrayOfInt);
      if (paramArrayOfString != null) {
        break label236;
      }
    }
    for (boolean bool = false;; bool = true)
    {
      Log.i("FinderLiveOlympicCardPl", "receiveLocationPermission: " + bool + ' ');
      if (!bool)
      {
        paramArrayOfString = getMainScope();
        if (paramArrayOfString != null) {
          j.a(paramArrayOfString, (kotlin.d.f)this.CNt, null, (kotlin.g.a.m)new i(this, null), 2);
        }
      }
      paramArrayOfString = this.CNl;
      if (paramArrayOfString != null)
      {
        paramArrayOfString = paramArrayOfString.CPV;
        Log.i("CertificateActionSheetW", "receiveLocationPermission isEnable: " + bool + " origin: " + paramArrayOfString.CPF.afTT);
        paramArrayOfString.CPF.setCheck(bool);
      }
      this.CNr = bool;
      paramArrayOfString = this.CNq;
      if (paramArrayOfString != null) {
        ((cb)paramArrayOfString).a(null);
      }
      AppMethodBeat.o(360758);
      return;
      label236:
      if (paramArrayOfString.intValue() != 0) {
        break;
      }
    }
  }
  
  public final void qM(boolean paramBoolean)
  {
    AppMethodBeat.i(360823);
    ((n)business(n.class)).Ehh = paramBoolean;
    AppMethodBeat.o(360823);
  }
  
  public final void showLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(360836);
    Log.i("FinderLiveOlympicCardPl", s.X("showLoading: ", Boolean.valueOf(paramBoolean)));
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new k(paramBoolean, this));
    AppMethodBeat.o(360836);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(360720);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(360720);
      return;
      paramc = bj.GlQ;
      if (bj.y(getBuContext()))
      {
        paramc = ((n)business(n.class)).Ehd;
        paramBundle = this.mJe.getContext();
        if (paramBundle == null)
        {
          paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
          AppMethodBeat.o(360720);
          throw paramc;
        }
        paramc.a((q)paramBundle, new c..ExternalSyntheticLambda0(this));
        ens();
        paramc = this.activity.getLayoutInflater().inflate(p.f.CeP, this.mJe, false);
        if (paramc == null)
        {
          paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(360720);
          throw paramc;
        }
        paramc = (ViewGroup)paramc;
        this.CNl = new com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e(paramc, (com.tencent.mm.plugin.finder.live.olympic.certificate.b)this, (q)this.activity);
        paramBundle = this.CNl;
        if (paramBundle != null) {
          paramBundle.mount();
        }
        this.mJe.addView((View)paramc);
        if (((n)getBuContext().business(n.class)).Ehm)
        {
          Log.i("FinderLiveOlympicCardPl", "FINDER_LIVE_INIT_OLYMPICS_INFO auto get cert");
          a(((n)getBuContext().business(n.class)).ezi(), true);
          AppMethodBeat.o(360720);
          return;
        }
        Log.i("FinderLiveOlympicCardPl", "FINDER_LIVE_INIT_OLYMPICS_INFO isReceivePortrait：" + this.CNp + ' ');
        if (this.CNp)
        {
          a(((n)getBuContext().business(n.class)).ezi(), false);
          this.CNp = false;
          AppMethodBeat.o(360720);
          return;
        }
        com.tencent.mm.ae.d.a(1000L, (Runnable)this.CNs);
      }
      AppMethodBeat.o(360720);
      return;
      i(this);
      AppMethodBeat.o(360720);
      return;
      enu();
    }
  }
  
  public final void tO(int paramInt) {}
  
  public final void unMount()
  {
    AppMethodBeat.i(360739);
    super.unMount();
    Object localObject = this.CNl;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject).CPX.unMount();
      ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject).CPW.unMount();
      ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject).CPT.unMount();
      ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject).CPU.unMount();
      ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject).CPV.unMount();
    }
    localObject = getMainScope();
    if (localObject != null) {
      ar.a((aq)localObject, null);
    }
    this.CNn = false;
    this.CNo = false;
    this.mjj = false;
    this.CNp = false;
    com.tencent.mm.ae.d.H((Runnable)this.CNs);
    localObject = bj.GlQ;
    Log.i("FinderLiveOlympicCardPl", s.X("unMount : ", Boolean.valueOf(bj.y(getBuContext()))));
    AppMethodBeat.o(360739);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicCertificatePlugin$doExportImg$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ExportFileUtil.a
  {
    e(c paramc) {}
    
    public final void cg(String paramString1, String paramString2)
    {
      AppMethodBeat.i(360356);
      s.u(paramString1, "srcPath");
      s.u(paramString2, "destPath");
      aa.y((Context)this.CNu.activity, this.CNu.activity.getResources().getString(p.h.Cpc), p.g.icons_filled_done);
      AppMethodBeat.o(360356);
    }
    
    public final void ch(String paramString1, String paramString2)
    {
      AppMethodBeat.i(360364);
      s.u(paramString1, "srcPath");
      s.u(paramString2, "destPath");
      aa.y((Context)this.CNu.activity, this.CNu.activity.getResources().getString(p.h.Cpb), p.g.icons_filled_close);
      AppMethodBeat.o(360364);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object Uf;
    int aai;
    int label;
    
    f(c paramc, n.b paramb, String paramString, boolean paramBoolean, kotlin.d.d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(360384);
      paramd = new f(this.CNu, localb, paramString, paramBoolean, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(360384);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(360375);
      Object localObject2 = kotlin.d.a.a.aiwj;
      int i;
      label188:
      label218:
      label229:
      Object localObject3;
      boolean bool1;
      String str;
      boolean bool2;
      kotlin.d.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(360375);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        for (;;)
        {
          try
          {
            s.s(this.CNu.mJe.getContext().getString(p.h.CpB), "root.context.getString(R…ive_olympic_error_commom)");
            paramObject = j.a(paramObject, (kotlin.d.f)c.a(this.CNu), (kotlin.g.a.m)new b(this.CNu, null), 2);
            c.b(this.CNu, true);
            if (c.f(this.CNu) != n.f.EhN) {
              break label229;
            }
            i = 1;
            localObject1 = localb;
            switch (c.f.a.$EnumSwitchMapping$0[localObject1.ordinal()])
            {
            case 1: 
              paramObject = new p();
              AppMethodBeat.o(360375);
              throw paramObject;
            }
          }
          finally
          {
            Log.e("FinderLiveOlympicCardPl", s.X("generateOlympicCertificate exception  = ", paramObject.getMessage()));
          }
          paramObject = ah.aiuX;
          AppMethodBeat.o(360375);
          return paramObject;
          i = 0;
        }
        localObject1 = this.CNu.mJe.getContext().getString(p.h.Cpj);
        s.s(localObject1, "root.context.getString(R…pic_btn_error_click_step)");
        localObject3 = this.CNu;
        if (i != 0) {}
        for (bool1 = true;; bool1 = false)
        {
          str = paramString;
          bool2 = paramBoolean;
          locald = (kotlin.d.d)this;
          this.L$0 = localObject1;
          this.Uf = paramObject;
          this.aai = i;
          this.label = 1;
          localObject3 = c.a((c)localObject3, bool1, str, paramObject, bool2, locald);
          if (localObject3 != localObject2) {
            break;
          }
          AppMethodBeat.o(360375);
          return localObject2;
        }
      case 1: 
        i = this.aai;
        localObject2 = (ay)this.Uf;
        localObject1 = (String)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        break label1122;
        localObject3 = new StringBuilder("openOlympicCard result= ").append(localObject2).append(" isLighTorch: ");
        if (i == 0) {
          break label1161;
        }
        bool1 = true;
        Log.i("FinderLiveOlympicCardPl", bool1 + " isAutoAdd: " + paramBoolean);
        com.tencent.mm.ae.d.a(200L, (kotlin.g.a.a)new u(this.CNu) {});
        ((cb)paramObject).a(null);
        this.CNu.showLoading(false);
        if (!(localObject2 instanceof o)) {
          break label764;
        }
        if (paramBoolean)
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(360375);
          return paramObject;
          localObject1 = this.CNu.mJe.getContext().getString(p.h.Cpk);
          s.s(localObject1, "root.context.getString(R…ic_btn_error_click_torch)");
          localObject3 = this.CNu;
          if (i != 0) {}
          for (bool1 = true;; bool1 = false)
          {
            str = paramString;
            bool2 = paramBoolean;
            locald = (kotlin.d.d)this;
            this.L$0 = localObject1;
            this.Uf = paramObject;
            this.aai = i;
            this.label = 2;
            localObject3 = c.a((c)localObject3, bool1, str, paramObject, bool2, locald);
            if (localObject3 != localObject2) {
              break;
            }
            AppMethodBeat.o(360375);
            return localObject2;
          }
        }
        break;
      case 2: 
        i = this.aai;
        localObject2 = (ay)this.Uf;
        localObject1 = (String)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        break label1135;
        localObject1 = this.CNu.mJe.getContext().getString(p.h.Cpo);
        s.s(localObject1, "root.context.getString(R…n_error_look_certificate)");
        localObject3 = (kotlin.d.d)this;
        this.L$0 = localObject1;
        this.Uf = paramObject;
        this.aai = i;
        this.label = 3;
        localObject3 = c.ad((kotlin.d.d)localObject3);
        if (localObject3 != localObject2) {
          break label1092;
        }
        AppMethodBeat.o(360375);
        return localObject2;
      case 3: 
        label375:
        i = this.aai;
        label402:
        localObject2 = (ay)this.Uf;
        localObject1 = (String)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        break;
      }
      c.a(this.CNu, (o)localObject2, (String)localObject1);
      paramObject = ah.aiuX;
      AppMethodBeat.o(360375);
      return paramObject;
      label764:
      if (localObject2 == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.olympic.certificate.data.CertificateData");
        AppMethodBeat.o(360375);
        throw paramObject;
      }
      paramObject = (com.tencent.mm.plugin.finder.live.olympic.certificate.data.a)localObject2;
      c.g(this.CNu);
      Object localObject1 = c.b(this.CNu);
      if (localObject1 != null)
      {
        localObject2 = localb;
        s.u(localObject2, "state");
        s.u(paramObject, "certificateData");
        Log.i("OlympicCertificateLayou", "openOlympicCertificateLayer state: " + localObject2 + " data: " + paramObject);
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).tO(0);
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).b(paramObject);
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CPT.CPu.t(null);
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CQe.setText((CharSequence)((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).mJe.getContext().getString(p.h.Cpy));
        com.tencent.mm.ae.d.a(300L, (kotlin.g.a.a)e.q.CQy);
        if (((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CQl != e.a.CQo) {
          break label1006;
        }
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CQl = e.a.CQn;
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).a(((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CQl);
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CQb.setVisibility(8);
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CPU.a(((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CQl);
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CPU.enY();
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).enT();
      }
      label1092:
      label1122:
      for (;;)
      {
        c.a(this.CNu, paramObject);
        break label218;
        label1006:
        switch (com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e.c.$EnumSwitchMapping$0[localObject2.ordinal()])
        {
        case 1: 
          com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e.a((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1);
          break;
        case 2: 
          com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e.b((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1);
          break;
        case 3: 
          ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CPT.setVisibility(4);
          com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e.a((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1, false);
          com.tencent.mm.ae.d.a(600L, (kotlin.g.a.a)new e.j((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1));
          continue;
          localObject2 = paramObject;
          paramObject = localObject3;
          break label1148;
          localObject2 = paramObject;
          paramObject = localObject3;
          break label1135;
          localObject2 = paramObject;
          paramObject = localObject3;
          break label1122;
          break label188;
          localObject3 = paramObject;
          paramObject = localObject2;
          localObject2 = localObject3;
          break label375;
          label1135:
          localObject3 = paramObject;
          paramObject = localObject2;
          localObject2 = localObject3;
          break label375;
          label1148:
          localObject3 = paramObject;
          paramObject = localObject2;
          localObject2 = localObject3;
          break label375;
          bool1 = false;
          break label402;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      b(c paramc, kotlin.d.d<? super b> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(360672);
        paramObject = (kotlin.d.d)new b(this.CNu, paramd);
        AppMethodBeat.o(360672);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(360665);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(360665);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (kotlin.d.d)this;
          this.label = 1;
          if (bb.e(500L, paramObject) == locala)
          {
            AppMethodBeat.o(360665);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        this.CNu.showLoading(true);
        paramObject = ah.aiuX;
        AppMethodBeat.o(360665);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicCertificatePlugin$inviteRelayOlympicTorchRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements Runnable
  {
    h(c paramc) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(360378);
      Object localObject1 = (n.e)((n)this.CNu.getBuContext().business(n.class)).Ehd.getValue();
      if ((localObject1 != null) && (((n.e)localObject1).EhI == true)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("FinderLiveOlympicCardPl", "inviteRelayOlympicTorchRunnable isTorcher = true");
        AppMethodBeat.o(360378);
        return;
      }
      brs localbrs = ((n)this.CNu.business(n.class)).Ehe;
      Object localObject3 = new StringBuilder("checkInviteRelayOlympicTorch shareData: ");
      if (localbrs == null)
      {
        localObject1 = null;
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" nickName: ");
        if (localbrs != null) {
          break label183;
        }
        localObject1 = null;
        label123:
        Log.i("FinderLiveOlympicCardPl", localObject1);
        if (localbrs != null) {
          break label192;
        }
        localObject1 = null;
        label144:
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label201;
        }
      }
      label183:
      label192:
      label201:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label206;
        }
        AppMethodBeat.o(360378);
        return;
        localObject1 = localbrs.ZVq;
        break;
        localObject1 = localbrs.ZVr;
        break label123;
        localObject1 = localbrs.ZVq;
        break label144;
      }
      label206:
      c.g(this.CNu);
      localObject3 = c.b(this.CNu);
      x localx;
      if (localObject3 != null)
      {
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject3).tO(0);
        com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e.a((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject3, true);
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject3).CQe.setText((CharSequence)((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject3).mJe.getResources().getString(p.h.Cpu));
        localObject1 = com.tencent.mm.plugin.finder.live.olympic.report.a.CRJ;
        com.tencent.mm.plugin.finder.live.olympic.report.a.qR(false);
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject3).CQj.setVisibility(4);
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject3).agxk.setVisibility(4);
        localx = ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject3).CPT.CPu;
        localObject1 = com.tencent.mm.plugin.finder.live.olympic.data.a.CRu;
        if (localbrs != null) {
          break label341;
        }
      }
      label341:
      for (localObject1 = localObject2;; localObject1 = new com.tencent.mm.plugin.finder.live.olympic.data.a(localbrs.ZVr, localbrs.ZVs, Util.safeParseLong(localbrs.ZVq), localbrs.finderUsername))
      {
        localx.t(localObject1);
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject3).CPT.setVisibility(0);
        ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject3).CPU.setVisibility(4);
        AppMethodBeat.o(360378);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    i(c paramc, kotlin.d.d<? super i> paramd)
    {
      super(paramd);
    }
    
    private static final void a(Context paramContext, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(360369);
      paramDialogInterface.dismiss();
      com.tencent.mm.pluginsdk.permission.b.lx(paramContext);
      AppMethodBeat.o(360369);
    }
    
    private static final void o(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(360376);
      paramDialogInterface.dismiss();
      AppMethodBeat.o(360376);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(360400);
      paramObject = (kotlin.d.d)new i(this.CNu, paramd);
      AppMethodBeat.o(360400);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(360395);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(360395);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.CNu.mJe.getContext();
      com.tencent.mm.ui.base.k.a(paramObject, paramObject.getString(p.h.permission_location_request_again_msg), "", paramObject.getString(p.h.jump_to_settings), paramObject.getString(p.h.permission_cancel), false, new c.i..ExternalSyntheticLambda0(paramObject), c.i..ExternalSyntheticLambda1.INSTANCE);
      paramObject = ah.aiuX;
      AppMethodBeat.o(360395);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    j(c paramc, boolean paramBoolean, kotlin.d.d<? super j> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(360423);
      paramd = new j(this.CNu, this.CNA, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(360423);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(360412);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(360412);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
      }
      Object localObject1;
      boolean bool;
      try
      {
        Object localObject2 = j.a(paramObject, (kotlin.d.f)c.a(this.CNu), (kotlin.g.a.m)new a(this.CNu, null), 2);
        c.a(this.CNu, true);
        localObject1 = ((n)this.CNu.getBuContext().business(n.class)).ezi();
        paramObject = this.CNu;
        if (localObject1 == n.f.EhN) {}
        for (bool = true;; bool = false)
        {
          localObject1 = (kotlin.d.d)this;
          this.L$0 = localObject2;
          this.label = 1;
          localObject1 = c.a(paramObject, bool, (ay)localObject2, (kotlin.d.d)localObject1);
          paramObject = localObject1;
          if (localObject1 != locala) {
            break;
          }
          AppMethodBeat.o(360412);
          return locala;
        }
        localObject2 = (ay)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        com.tencent.mm.ae.d.a(200L, (kotlin.g.a.a)new u(this.CNu) {});
        ((cb)localObject2).a(null);
        this.CNu.showLoading(false);
        Log.i("FinderLiveOlympicCardPl", s.X("relayOlympicTorch result: ", paramObject));
        if ((paramObject instanceof o))
        {
          localObject1 = this.CNu;
          paramObject = (o)paramObject;
          localObject2 = this.CNu.mJe.getContext().getString(p.h.Cpq);
          s.s(localObject2, "root.context.getString(R…ic_btn_error_relay_torch)");
          c.a((c)localObject1, paramObject, (String)localObject2);
          paramObject = ah.aiuX;
          AppMethodBeat.o(360412);
          return paramObject;
        }
      }
      finally
      {
        Log.e("FinderLiveOlympicCardPl", s.X("relayOlympicTorch exception : ", paramObject.getMessage()));
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(360412);
        return paramObject;
        if (paramObject == null)
        {
          paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.olympic.certificate.data.CertificateData");
          AppMethodBeat.o(360412);
          throw paramObject;
        }
        paramObject = (com.tencent.mm.plugin.finder.live.olympic.certificate.data.a)paramObject;
        c.a(this.CNu, paramObject);
        localObject1 = c.b(this.CNu);
        if (localObject1 != null)
        {
          bool = this.CNA;
          s.u(paramObject, "certificateData");
          Log.i("OlympicCertificateLayou", s.X("inviteRelayOlympicTorch data: ", paramObject));
          ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CQh.setVisibility(8);
          ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).b(paramObject);
          if (!s.p(Boolean.valueOf(bool), Boolean.FALSE))
          {
            ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CQc.setEnabled(false);
            ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).a(((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CPT.getLayoutView(), ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1).CPU.getLayoutView(), (kotlin.g.a.a)new e.r((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject1));
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(c paramc, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(360596);
        paramObject = (kotlin.d.d)new a(this.CNu, paramd);
        AppMethodBeat.o(360596);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(360586);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(360586);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (kotlin.d.d)this;
          this.label = 1;
          if (bb.e(500L, paramObject) == locala)
          {
            AppMethodBeat.o(360586);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        this.CNu.showLoading(true);
        paramObject = ah.aiuX;
        AppMethodBeat.o(360586);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    k(boolean paramBoolean, c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    l(c paramc, kotlin.d.d<? super l> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(360399);
      paramd = new l(this.CNu, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(360399);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(360393);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      label205:
      boolean bool;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(360393);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        localObject = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
        if (!com.tencent.mm.plugin.finder.live.olympic.util.a.eot())
        {
          localObject = this.CNu.mJe.getContext();
          if (localObject == null)
          {
            paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(360393);
            throw paramObject;
          }
          com.tencent.mm.pluginsdk.permission.b.b((Activity)localObject, "android.permission.ACCESS_FINE_LOCATION", 1001);
          c.a(this.CNu, j.a(paramObject, null, (kotlin.g.a.m)new c.l.1(null), 3));
          Log.i("FinderLiveOlympicCardPl", "showLocationDialog wait cancel");
        }
        break;
      case 1: 
        try
        {
          paramObject = c.c(this.CNu);
          if (paramObject == null) {
            break label205;
          }
          localObject = (kotlin.d.d)this;
          this.label = 1;
          paramObject = paramObject.e((kotlin.d.d)localObject);
          if (paramObject != locala) {
            break label205;
          }
          AppMethodBeat.o(360393);
          return locala;
        }
        finally
        {
          for (;;)
          {
            label262:
            Log.e("FinderLiveOlympicCardPl", s.X("showLocationDialog cancel exception: ", paramObject.getMessage()));
          }
        }
        ResultKt.throwOnFailure(paramObject);
        Log.i("FinderLiveOlympicCardPl", s.X("showLocationDialog notify unlock isLocationEnable: ", Boolean.valueOf(c.e(this.CNu))));
        if (!c.e(this.CNu)) {
          break label428;
        }
        this.CNu.showLoading(true);
        Log.i("FinderLiveOlympicCardPl", "showLocationDialog syncWaitLbs");
        paramObject = v.GgU;
        if (v.feW())
        {
          bool = true;
          Log.i("FinderLiveOlympicCardPl", s.X("showLocationDialog syncWaitLbs result: ", Boolean.valueOf(bool)));
          paramObject = c.b(this.CNu);
          if (paramObject != null) {
            break label357;
          }
          paramObject = null;
        }
        break;
      }
      for (;;)
      {
        if (paramObject != null)
        {
          localObject = (kotlin.d.d)this;
          this.label = 2;
          if (paramObject.ay((kotlin.d.d)localObject) == locala)
          {
            AppMethodBeat.o(360393);
            return locala;
            c.d(this.CNu);
            break;
            bool = false;
            break label262;
            label357:
            com.tencent.mm.plugin.finder.live.olympic.certificate.data.a locala1 = paramObject.CQk;
            if (locala1 == null)
            {
              paramObject = null;
            }
            else
            {
              c localc = this.CNu;
              localObject = locala1.CPj.name;
              paramObject = localObject;
              if (localObject == null) {
                paramObject = "";
              }
              paramObject = localc.g(paramObject, locala1.CPj.CPr, true);
              continue;
              ResultKt.throwOnFailure(paramObject);
            }
          }
        }
      }
      this.CNu.showLoading(false);
      label428:
      Log.i("FinderLiveOlympicCardPl", s.X("showLocationDialog final ", Boolean.valueOf(c.e(this.CNu))));
      paramObject = ah.aiuX;
      AppMethodBeat.o(360393);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    extends kotlin.d.a
    implements CoroutineExceptionHandler
  {
    public m(CoroutineExceptionHandler.a parama)
    {
      super();
      AppMethodBeat.i(360379);
      AppMethodBeat.o(360379);
    }
    
    public final void handleException(kotlin.d.f paramf, Throwable paramThrowable)
    {
      AppMethodBeat.i(360386);
      Log.e("FinderLiveOlympicCardPl", s.X("exceptionHandler:", paramThrowable));
      AppMethodBeat.o(360386);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    n(c paramc, String paramString, boolean paramBoolean1, boolean paramBoolean2, kotlin.d.d<? super n> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(360388);
      paramObject = (kotlin.d.d)new n(this.CNu, paramString, paramBoolean1, paramBoolean2, paramd);
      AppMethodBeat.o(360388);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(360382);
      localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(360382);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        c.c(this.CNu, true);
        paramObject = paramString;
        boolean bool1 = paramBoolean1;
        boolean bool2 = paramBoolean2;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        paramObject = c.a(paramObject, bool1, bool2, locald);
        if (paramObject != localObject) {
          break label317;
        }
        AppMethodBeat.o(360382);
        return localObject;
      }
      finally
      {
        for (;;)
        {
          Log.e("FinderLiveOlympicCardPl", s.X("updateOlympicCertificate exception: ", paramObject.getMessage()));
          continue;
          paramObject = (com.tencent.mm.plugin.finder.live.olympic.certificate.data.a)paramObject;
          s.u(paramObject, "certificateData");
          Log.i("OlympicCertificateLayou", s.X("updateOlympicCertificate data: ", paramObject));
          ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject).b(paramObject);
        }
      }
      ResultKt.throwOnFailure(paramObject);
      com.tencent.mm.ae.d.a(200L, (kotlin.g.a.a)new u(this.CNu) {});
      Log.i("FinderLiveOlympicCardPl", s.X("updateOlympicCertificate result: ", paramObject));
      if ((paramObject instanceof o))
      {
        localObject = c.b(this.CNu);
        if (localObject != null)
        {
          s.u((o)paramObject, "error");
          Log.i("OlympicCertificateLayou", s.X("updateOlympicCertificate data: ", ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject).CQk));
          ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject).CPU.CRa.t(null);
          ((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject).CPV.CPu.t(((com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e)localObject).CQk);
        }
      }
      do
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(360382);
        return paramObject;
        localObject = c.b(this.CNu);
      } while (localObject == null);
      if (paramObject == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.olympic.certificate.data.CertificateData");
        AppMethodBeat.o(360382);
        throw paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.c
 * JD-Core Version:    0.7.0.1
 */