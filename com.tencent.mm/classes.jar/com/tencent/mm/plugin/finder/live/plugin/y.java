package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.model.i;
import com.tencent.mm.live.core.core.trtc.a.g;
import com.tencent.mm.live.core.core.trtc.a.r;
import com.tencent.mm.live.core.core.trtc.a.s;
import com.tencent.mm.live.core.core.trtc.a.t;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a.a;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPreviewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "screenShareWidget", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenShareWidget;", "adjustCameraPreviewByScreen", "", "checkAudioMode", "isAudioMode", "", "fromMiniWindow", "checkAudioModeWhenScreenShare", "isScreenShare", "dp2px", "", "dpVal", "", "getPreviewLayout", "isRenderLayoutMakeLayoutReady", "localDebugStreamEnable", "micUserWaitingState", "userId", "", "type", "mount", "notifyLinkMicMode", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "notifyNormalMode", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onMicUserChanged", "isPkAnchor", "orientationChanged", "orientation", "streamType", "pause", "recoveryLive", "refreshCameraView", "refreshPreviewView", "restoreFromHalfMode", "restoreScreenShare", "resume", "setPkUserId", "setPreviewMoveListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "xOffset", "yOffset", "setPreviewTouchListener", "x", "y", "setSelfUserId", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopScreenShare", "switchCamera", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  extends b
{
  public static final y.a CWF;
  private final bw CWG;
  private final Context context;
  public final LivePreviewView mRt;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(353937);
    CWF = new y.a((byte)0);
    AppMethodBeat.o(353937);
  }
  
  public y(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(353862);
    this.nfT = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(p.e.live_preview_view);
    s.s(paramb, "root.findViewById(R.id.live_preview_view)");
    this.mRt = ((LivePreviewView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BKq);
    s.s(paramb, "root.findViewById(R.id.f…er_live_doc_cast_ui_root)");
    this.CWG = new bw((ViewGroup)paramb, (b)this);
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(353862);
  }
  
  private static final void b(y paramy)
  {
    AppMethodBeat.i(353924);
    s.u(paramy, "this$0");
    if ((getLiveCore() instanceof com.tencent.mm.live.core.core.a.b))
    {
      paramy = getLiveCore();
      if (paramy == null)
      {
        paramy = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
        AppMethodBeat.o(353924);
        throw paramy;
      }
      paramy = (com.tencent.mm.live.core.core.a.b)paramy;
      aj localaj = aj.CGT;
      paramy.fE(aj.needMirror());
    }
    AppMethodBeat.o(353924);
  }
  
  private void bha()
  {
    AppMethodBeat.i(353905);
    this.mRt.bha();
    AppMethodBeat.o(353905);
  }
  
  private void cU(boolean paramBoolean)
  {
    AppMethodBeat.i(353893);
    com.tencent.mm.live.core.core.trtc.a locala;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (epx())
    {
      locala = getLiveCore();
      if (locala != null)
      {
        localObject1 = this.mRt;
        localObject2 = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getLocalPushStreamPath();
        if (localObject1 != null)
        {
          localObject3 = (CharSequence)localObject2;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label87;
          }
        }
        label87:
        for (int i = 1; i != 0; i = 0)
        {
          Log.e("MicroMsg.LiveCore", "startPushLocalVideo preiewView is null or path is nullOrEmpty");
          AppMethodBeat.o(353893);
          return;
        }
        localObject3 = locala.mSc;
        if (localObject3 != null) {
          ((com.tencent.thumbplayer.g.b)localObject3).stop();
        }
        localObject3 = locala.mSc;
        if (localObject3 != null) {
          ((com.tencent.thumbplayer.g.b)localObject3).release();
        }
        localObject3 = new com.tencent.thumbplayer.g.b(MMApplicationContext.getContext());
        Log.i("MicroMsg.LiveCore", s.X("startPushLocalVideo path:", localObject2));
        ((com.tencent.thumbplayer.g.b)localObject3).setDataSource((String)localObject2);
        ((com.tencent.thumbplayer.g.b)localObject3).setLoopback(true);
        ah localah = ah.aiuX;
        locala.mSc = ((com.tencent.thumbplayer.g.b)localObject3);
        locala.mRt = ((LivePreviewView)localObject1);
        a.a.bfr().bfo().mSJ = true;
        a.a.bfr().bfn().mTi = true;
        ((LivePreviewView)localObject1).a((kotlin.g.a.b)new a.r(locala), (m)new a.s(locala));
        locala.mRs.a(locala.mRD);
        locala.mRs.a(locala.mRE);
        locala.mRs.t((kotlin.g.a.b)new a.t(locala, (String)localObject2));
        AppMethodBeat.o(353893);
      }
    }
    else
    {
      locala = getLiveCore();
      if (locala != null)
      {
        localObject1 = aj.CGT;
        locala.tc(aj.bgA());
      }
      if (!paramBoolean) {
        break label336;
      }
      locala = getLiveCore();
      if (locala != null) {
        locala.a(this.mRt);
      }
    }
    for (;;)
    {
      this.mJe.post(new y..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(353893);
      return;
      label336:
      locala = getLiveCore();
      if (locala != null)
      {
        localObject1 = this.mRt;
        localObject2 = aj.CGT;
        localObject2 = aj.bhX();
        localObject3 = aj.CGT;
        locala.a((LivePreviewView)localObject1, (com.tencent.mm.live.core.b.a)localObject2, aj.bhY());
      }
    }
  }
  
  private static boolean epx()
  {
    AppMethodBeat.i(353875);
    CharSequence localCharSequence = (CharSequence)((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getLocalPushStreamPath();
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(353875);
      return true;
    }
    AppMethodBeat.o(353875);
    return false;
  }
  
  private static com.tencent.mm.live.core.core.trtc.a getLiveCore()
  {
    AppMethodBeat.i(353870);
    Object localObject = aj.CGT;
    localObject = (com.tencent.mm.live.core.core.trtc.a)aj.elM();
    AppMethodBeat.o(353870);
    return localObject;
  }
  
  private final void rg(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(353916);
    Object localObject;
    if (paramBoolean)
    {
      localObject = (ab)getPlugin(ab.class);
      if (localObject != null)
      {
        ((ab)localObject).tO(8);
        AppMethodBeat.o(353916);
      }
    }
    else
    {
      localObject = getLiveCore();
      if (localObject == null) {
        break label96;
      }
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
      if ((localObject == null) || (((i)localObject).bex() != true)) {
        break label96;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = (ab)getPlugin(ab.class);
        if (localObject != null) {
          ((ab)localObject).tO(0);
        }
      }
      AppMethodBeat.o(353916);
      return;
      label96:
      i = 0;
    }
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(354052);
    s.u(paramLinkedHashMap, "micUserMap");
    if (paramLinkedHashMap.size() > 1)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((Collection)paramLinkedHashMap.keySet());
      if (this.mJe.getLayoutParams() == null)
      {
        paramLinkedHashMap = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(354052);
        throw paramLinkedHashMap;
      }
      b.b.a(this.nfT, b.c.neC);
      label130:
      label145:
      int i;
      if (((j)business(j.class)).EfM)
      {
        localObject = this.mJe.getParent();
        if ((localObject instanceof View))
        {
          localObject = (View)localObject;
          if (localObject != null) {
            break label212;
          }
          localObject = null;
          if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
            break label222;
          }
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          if (localObject != null) {
            break label228;
          }
          i = 0;
          label152:
          LivePreviewView localLivePreviewView = this.mRt;
          localObject = getLiveCore();
          if (localObject != null) {
            break label237;
          }
          localObject = "";
          label173:
          localLivePreviewView.a((String)localObject, (HashMap)paramLinkedHashMap, i);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.LiveCoreAnchor", s.X("notifyLinkMicMode userIdList:", localArrayList));
        AppMethodBeat.o(354052);
        return;
        localObject = null;
        break;
        label212:
        localObject = ((View)localObject).getLayoutParams();
        break label130;
        label222:
        localObject = null;
        break label145;
        label228:
        i = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
        break label152;
        label237:
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
        if (localObject == null)
        {
          localObject = "";
          break label173;
        }
        String str = ((i)localObject).mNM;
        localObject = str;
        if (str != null) {
          break label173;
        }
        localObject = "";
        break label173;
        this.mRt.bD((List)localArrayList);
      }
    }
    s.u(paramLinkedHashMap, "micUserMap");
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)paramLinkedHashMap.keySet());
    paramLinkedHashMap = this.mJe.getLayoutParams();
    if (paramLinkedHashMap == null)
    {
      paramLinkedHashMap = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(354052);
      throw paramLinkedHashMap;
    }
    paramLinkedHashMap = (RelativeLayout.LayoutParams)paramLinkedHashMap;
    paramLinkedHashMap.topMargin = 0;
    paramLinkedHashMap.bottomMargin = 0;
    this.mRt.bD((List)localObject);
    b.b.a(this.nfT, b.c.neD);
    Log.i("MicroMsg.LiveCoreAnchor", s.X("notifyNormalMode userIdList:", localObject));
    AppMethodBeat.o(354052);
  }
  
  public final void awR(final String paramString)
  {
    AppMethodBeat.i(354005);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramString));
    AppMethodBeat.o(354005);
  }
  
  public final void epA()
  {
    AppMethodBeat.i(354029);
    rg(false);
    bw localbw = this.CWG;
    localbw.mJe.setVisibility(8);
    localbw.DiO.removeAllViews();
    com.tencent.mm.live.core.core.trtc.a locala = bw.getLiveCore();
    if (locala != null) {
      ((com.tencent.mm.live.core.core.b)locala).a(false, null, null);
    }
    locala = bw.getLiveCore();
    if (locala != null) {
      locala.eg(0, 0);
    }
    localbw.erO();
    this.mRt.bha();
    AppMethodBeat.o(354029);
  }
  
  public final void epB()
  {
    AppMethodBeat.i(354040);
    this.CWG.ry(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeK);
    this.CWG.epB();
    rg(true);
    AppMethodBeat.o(354040);
  }
  
  public final boolean epy()
  {
    return this.mRt.mWP.mXu;
  }
  
  public final void epz()
  {
    AppMethodBeat.i(354020);
    float f3 = bf.bf(this.context).x;
    float f2 = bf.bf(this.context).y;
    int i = bf.getStatusBarHeight(this.context);
    float f1 = bd.fromDPToPix(this.mJe.getContext(), 16);
    int j = bd.fromDPToPix(this.context, 80);
    j = bf.bk(this.context) + j;
    Log.i("MicroMsg.LiveCoreAnchor", "adjustPreviewByScreen screenW:" + f3 + " screenH:" + f2 + " factor:1.7777778 statusBarH:" + i);
    if ((((j)business(j.class)).Efv == null) && (((j)business(j.class)).Efw.isEmpty()))
    {
      if (f2 / f3 <= 1.777778F)
      {
        localObject = this.mJe.getLayoutParams();
        if ((localObject instanceof RelativeLayout.LayoutParams)) {}
        for (localObject = (RelativeLayout.LayoutParams)localObject;; localObject = null)
        {
          if (localObject != null)
          {
            ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
          }
          if ((this.mJe instanceof RoundCornerRelativeLayout)) {
            ((RoundCornerRelativeLayout)this.mJe).A(0.0F, 0.0F, 0.0F, 0.0F);
          }
          Log.i("MicroMsg.LiveCoreAnchor", "adjustPreviewByScreen fill screen");
          this.mJe.requestLayout();
          AppMethodBeat.o(354020);
          return;
        }
      }
      f3 *= 1.777778F;
      f2 -= f3;
      if (f2 <= i)
      {
        localObject = this.mJe.getLayoutParams();
        if ((localObject instanceof RelativeLayout.LayoutParams)) {}
        for (localObject = (RelativeLayout.LayoutParams)localObject;; localObject = null)
        {
          if (localObject != null)
          {
            ((RelativeLayout.LayoutParams)localObject).topMargin = i;
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
          }
          if ((this.mJe instanceof RoundCornerRelativeLayout)) {
            ((RoundCornerRelativeLayout)this.mJe).A(f1, f1, 0.0F, 0.0F);
          }
          Log.i("MicroMsg.LiveCoreAnchor", "adjustPreviewByScreen fit screen, targetH:" + f3 + " offsetH:" + f2 + " realBottomMargin:" + ((int)f2 - i) + " mostBottomMargin:" + j);
          break;
        }
      }
      localObject = this.mJe.getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams)) {}
      for (localObject = (RelativeLayout.LayoutParams)localObject;; localObject = null)
      {
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)localObject).topMargin = i;
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = k.qv((int)f2 - i, j);
        }
        if (!(this.mJe instanceof RoundCornerRelativeLayout)) {
          break;
        }
        ((RoundCornerRelativeLayout)this.mJe).A(f1, f1, f1, f1);
        break;
      }
    }
    Object localObject = this.mJe.getLayoutParams();
    if ((localObject instanceof RelativeLayout.LayoutParams)) {}
    for (localObject = (RelativeLayout.LayoutParams)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      }
      if (!(this.mJe instanceof RoundCornerRelativeLayout)) {
        break;
      }
      ((RoundCornerRelativeLayout)this.mJe).A(0.0F, 0.0F, 0.0F, 0.0F);
      break;
    }
  }
  
  public final void mount() {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(354063);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = com.tencent.mm.plugin.finder.live.model.f.CEf;
    boolean bool;
    if (paramInt1 != com.tencent.mm.plugin.finder.live.model.f.ekp())
    {
      localObject = com.tencent.mm.plugin.finder.live.model.f.CEf;
      if (paramInt1 != com.tencent.mm.plugin.finder.live.model.f.ekr()) {}
    }
    else if (paramInt2 == -1)
    {
      localObject = com.tencent.mm.plugin.finder.live.model.f.CEf;
      if (paramInt1 == com.tencent.mm.plugin.finder.live.model.f.ekr()) {
        this.CWG.erO();
      }
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (paramIntent == null)
      {
        paramIntent = null;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).EeJ = paramIntent;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeK = false;
        bool = com.tencent.mm.vfs.y.ZC(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeJ);
        Log.i("MicroMsg.LiveCoreAnchor", "REQUEST_CODE_SELECT_FILE screenShareFilePath:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeJ + " exist:" + bool);
        paramIntent = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeJ;
        if ((paramIntent != null) && (paramIntent.length() != 0)) {
          break label254;
        }
      }
      label254:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((paramInt1 != 0) || (!bool)) {
          break label259;
        }
        this.CWG.ry(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeK);
        this.CWG.epB();
        rg(true);
        AppMethodBeat.o(354063);
        return;
        paramIntent = paramIntent.getStringExtra("filePath");
        break;
      }
      label259:
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeJ = null;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeK = false;
      AppMethodBeat.o(354063);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.live.model.f.CEf;
    if (paramInt1 != com.tencent.mm.plugin.finder.live.model.f.ekq())
    {
      localObject = com.tencent.mm.plugin.finder.live.model.f.CEf;
      if (paramInt1 != com.tencent.mm.plugin.finder.live.model.f.eks()) {}
    }
    else if (paramInt2 == -1)
    {
      localObject = com.tencent.mm.plugin.finder.live.model.f.CEf;
      if (paramInt1 == com.tencent.mm.plugin.finder.live.model.f.eks()) {
        this.CWG.erO();
      }
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (paramIntent == null)
      {
        paramIntent = null;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).EeJ = paramIntent;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeK = true;
        bool = com.tencent.mm.vfs.y.ZC(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeJ);
        Log.i("MicroMsg.LiveCoreAnchor", "REQUEST_CODE_SELECT_IMAGE screenShareFilePath:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeJ + " exist:" + bool);
        paramIntent = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeJ;
        if ((paramIntent != null) && (paramIntent.length() != 0)) {
          break label555;
        }
      }
      label555:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((paramInt1 != 0) || (!bool)) {
          break label560;
        }
        this.CWG.ry(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeK);
        this.CWG.epB();
        rg(true);
        AppMethodBeat.o(354063);
        return;
        paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        if (paramIntent == null)
        {
          paramIntent = null;
          break;
        }
        paramIntent = (String)p.oL((List)paramIntent);
        break;
      }
      label560:
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeJ = null;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeK = false;
    }
    AppMethodBeat.o(354063);
  }
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 1;
    int j = 0;
    int k = 0;
    AppMethodBeat.i(353992);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    label311:
    label484:
    label497:
    label502:
    label1017:
    for (;;)
    {
      AppMethodBeat.o(353992);
      return;
      tO(0);
      AppMethodBeat.o(353992);
      return;
      Log.i("MicroMsg.LiveCoreAnchor", "switchCamera");
      paramc = getLiveCore();
      if (paramc != null) {
        paramc.switchCamera();
      }
      paramc = getLiveCore();
      if (paramc == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
        AppMethodBeat.o(353992);
        throw paramc;
      }
      paramc = (com.tencent.mm.live.core.core.a.b)paramc;
      paramBundle = aj.CGT;
      paramc.fE(aj.needMirror());
      paramc = com.tencent.mm.live.model.u.mZl;
      paramc = com.tencent.mm.live.model.u.bhZ();
      paramBundle = com.tencent.mm.live.model.u.mZl;
      long l = com.tencent.mm.live.model.u.bie().mMJ;
      paramBundle = com.tencent.mm.live.model.u.mZl;
      paramBundle = com.tencent.mm.live.model.u.big();
      i = k;
      if (a.a.bfr().bfq().cameraId == 0) {
        i = 1;
      }
      Object localObject1 = z.bAM();
      s.s(localObject1, "getUsernameFromUserInfo()");
      Object localObject2 = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.c.e.a(paramc, l, paramBundle, 1, i, (String)localObject1, com.tencent.mm.live.model.u.bie().ZWw);
      com.tencent.mm.live.c.a.bjL();
      AppMethodBeat.o(353992);
      return;
      if (epx())
      {
        paramc = getLiveCore();
        if (paramc != null)
        {
          paramc.bfg();
          AppMethodBeat.o(353992);
        }
      }
      else
      {
        paramc = getLiveCore();
        if (paramc != null)
        {
          paramc.bce();
          AppMethodBeat.o(353992);
          return;
          boolean bool2;
          if (paramBundle == null)
          {
            bool1 = false;
            if (paramBundle != null) {
              break label484;
            }
            bool2 = false;
            Log.i("MicroMsg.LiveCoreAnchor", "checkAudioMode isAudioMode:" + bool1 + ", fromMiniWindow:" + bool2 + ", liveData.audioModeHolderBm:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DVR);
            paramc = getLiveCore();
            if (paramc == null) {
              break label497;
            }
            paramc = paramc.mRB;
            if ((paramc == null) || (paramc.mNQ)) {
              break label497;
            }
            i = 1;
            if (i == 0) {
              break label515;
            }
            if (!bool1) {
              break label502;
            }
            paramc = getLiveCore();
            if (paramc != null) {
              paramc.mRt = this.mRt;
            }
            paramBundle = this.CWG;
            paramc = bw.getLiveCore();
            if (paramc == null) {
              break label534;
            }
            paramc = paramc.mRB;
            if ((paramc == null) || (paramc.mNQ != true)) {
              break label534;
            }
            i = 1;
          }
          for (;;)
          {
            if (i != 0)
            {
              if (bool1)
              {
                paramBundle.erL();
                AppMethodBeat.o(353992);
                return;
                bool1 = paramBundle.getBoolean("PARAM_FINDER_LIVE_AUDIO_MODE", false);
                break;
                bool2 = paramBundle.getBoolean("PARAM_FINDER_LIVE_SWITCH_MODE_FROM_MINIWINDOW", false);
                break label311;
                i = 0;
                break label394;
                cU(bool2);
                bha();
                break label419;
                paramc = getLiveCore();
                if (paramc == null) {
                  break label419;
                }
                paramc.mRt = this.mRt;
                break label419;
                i = 0;
                continue;
              }
              paramBundle.erK();
              localObject1 = bw.getLiveCore();
              if (localObject1 != null)
              {
                paramc = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRA;
                if (paramc != null) {
                  break label776;
                }
                bool1 = false;
                paramc = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRA;
                if (paramc != null) {
                  break label800;
                }
                paramc = null;
                if (paramc != null) {
                  break label836;
                }
                if ((((com.tencent.mm.live.core.core.trtc.a)localObject1).mRv == null) || (com.tencent.mm.media.widget.a.b.isFrontCamera())) {
                  break label825;
                }
                i = 1;
                if (i != 0) {
                  break label830;
                }
                bool2 = true;
                ((com.tencent.mm.live.core.core.trtc.a)localObject1).r(bool1, bool2);
                paramc = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRA;
                if (paramc == null) {
                  break label845;
                }
                paramc = paramc.mNB;
                if ((paramc == null) || (paramc.mNk != true)) {
                  break label845;
                }
                i = 1;
                if (i != 0)
                {
                  paramc = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRu;
                  if (paramc != null) {
                    paramc.a(((com.tencent.mm.live.core.core.trtc.a)localObject1).mRs.getFrameDataCallback());
                  }
                }
                a.a.bfr().bfo().mSJ = true;
                a.a.bfr().bfn().mTi = true;
                paramc = a.a.bfr().bfq();
                localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRu;
                if (localObject2 != null) {
                  break label850;
                }
              }
            }
          }
          for (i = j;; i = ((com.tencent.mm.media.widget.a.f)localObject2).btf())
          {
            paramc.cameraId = i;
            ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRs.a(((com.tencent.mm.live.core.core.trtc.a)localObject1).mRD);
            ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRs.a(((com.tencent.mm.live.core.core.trtc.a)localObject1).mRE);
            ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRs.t((kotlin.g.a.b)new a.g((com.tencent.mm.live.core.core.trtc.a)localObject1));
            paramBundle.erM();
            AppMethodBeat.o(353992);
            return;
            paramc = paramc.mNB;
            if (paramc == null)
            {
              bool1 = false;
              break;
            }
            bool1 = paramc.mNi;
            break;
            paramc = paramc.mNB;
            if (paramc == null)
            {
              paramc = null;
              break label578;
            }
            paramc = Boolean.valueOf(paramc.mNj);
            break label578;
            i = 0;
            break label598;
            bool2 = false;
            break label605;
            bool2 = paramc.booleanValue();
            break label605;
            i = 0;
            break label644;
          }
          paramc = getLiveCore();
          if (paramc != null)
          {
            paramc = paramc.mRB;
            if ((paramc == null) || (paramc.bex() != true)) {}
          }
          for (boolean bool1 = true;; bool1 = false)
          {
            Log.i("MicroMsg.LiveCoreAnchor", "checkAudioMode isAudioMode:" + bool1 + ", fromMiniWindow:false, liveData.audioModeHolderBm:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DVR);
            if (!bool1) {
              break label969;
            }
            paramc = getLiveCore();
            if (paramc == null) {
              break;
            }
            paramc.mRt = this.mRt;
            AppMethodBeat.o(353992);
            return;
          }
          cU(false);
          bha();
          paramc = getLiveCore();
          if (paramc != null)
          {
            paramc = paramc.mRB;
            if ((paramc == null) || (paramc.mNQ != true)) {}
          }
          for (;;)
          {
            if (i == 0) {
              break label1017;
            }
            epB();
            break;
            i = 0;
          }
        }
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(353966);
    super.unMount();
    Log.i("MicroMsg.LiveCoreAnchor", "unMount");
    AppMethodBeat.o(353966);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    c(y paramy, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.y
 * JD-Core Version:    0.7.0.1
 */