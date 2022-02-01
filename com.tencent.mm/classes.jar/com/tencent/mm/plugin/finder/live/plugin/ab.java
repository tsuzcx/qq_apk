package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.live.core.core.trtc.a.h;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPreviewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "screenShareWidget", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenShareWidget;", "adjustCameraPreviewByScreen", "", "checkAudioMode", "isAudioMode", "", "fromMiniWindow", "checkAudioModeWhenScreenShare", "isScreenShare", "dp2px", "", "dpVal", "", "getPreviewLayout", "micUserWaitingState", "userId", "", "type", "mount", "notifyLinkMicMode", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "notifyNormalMode", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onMicUserChanged", "isPkAnchor", "orientationChanged", "orientation", "streamType", "pause", "recoveryLive", "refreshCameraView", "refreshPreviewView", "restoreFromHalfMode", "restoreScreenShare", "resume", "setPkUserId", "setPreviewMoveListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "xOffset", "yOffset", "setPreviewTouchListener", "x", "y", "setSelfUserId", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopScreenShare", "switchCamera", "unMount", "Companion", "plugin-finder_release"})
public final class ab
  extends d
{
  public static final a ynV;
  private final Context context;
  private final com.tencent.mm.live.c.b kCL;
  public final LivePreviewView knt;
  private final cg ynU;
  
  static
  {
    AppMethodBeat.i(272671);
    ynV = new a((byte)0);
    AppMethodBeat.o(272671);
  }
  
  public ab(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(272670);
    this.kCL = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(b.f.live_preview_view);
    p.j(paramb, "root.findViewById(R.id.live_preview_view)");
    this.knt = ((LivePreviewView)paramb);
    paramb = paramViewGroup.findViewById(b.f.finder_live_doc_cast_ui_root);
    p.j(paramb, "root.findViewById(R.id.f…er_live_doc_cast_ui_root)");
    this.ynU = new cg((ViewGroup)paramb, (d)this);
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(272670);
  }
  
  private void aNs()
  {
    AppMethodBeat.i(272657);
    this.knt.ksW.aNs();
    AppMethodBeat.o(272657);
  }
  
  private void co(boolean paramBoolean)
  {
    AppMethodBeat.i(272653);
    com.tencent.mm.live.core.core.trtc.a locala = getLiveCore();
    Object localObject1;
    if (locala != null)
    {
      localObject1 = ah.yhC;
      locala.sY(ah.aMQ());
    }
    if (paramBoolean)
    {
      locala = getLiveCore();
      if (locala != null) {
        locala.a(this.knt);
      }
    }
    for (;;)
    {
      this.kiF.post((Runnable)new c(this));
      AppMethodBeat.o(272653);
      return;
      locala = getLiveCore();
      if (locala != null)
      {
        localObject1 = this.knt;
        Object localObject2 = ah.yhC;
        localObject2 = ah.aOk();
        ah localah = ah.yhC;
        locala.a((LivePreviewView)localObject1, (com.tencent.mm.live.core.b.a)localObject2, ah.aOl());
      }
    }
  }
  
  private static com.tencent.mm.live.core.core.trtc.a getLiveCore()
  {
    AppMethodBeat.i(272650);
    Object localObject = ah.yhC;
    localObject = (com.tencent.mm.live.core.core.trtc.a)ah.dzB();
    AppMethodBeat.o(272650);
    return localObject;
  }
  
  private final void oZ(boolean paramBoolean)
  {
    AppMethodBeat.i(272662);
    if (paramBoolean)
    {
      localObject = (af)getPlugin(af.class);
      if (localObject != null)
      {
        ((af)localObject).tU(8);
        AppMethodBeat.o(272662);
        return;
      }
      AppMethodBeat.o(272662);
      return;
    }
    Object localObject = getLiveCore();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knA;
      if (localObject != null)
      {
        if (((h)localObject).aLs() != true) {
          break label97;
        }
        localObject = (af)getPlugin(af.class);
        if (localObject == null) {
          break label97;
        }
        ((af)localObject).tU(0);
        AppMethodBeat.o(272662);
        return;
      }
    }
    AppMethodBeat.o(272662);
    return;
    label97:
    AppMethodBeat.o(272662);
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(272668);
    p.k(paramLinkedHashMap, "micUserMap");
    if (paramLinkedHashMap.size() > 1)
    {
      localArrayList = new ArrayList();
      localArrayList.addAll((Collection)paramLinkedHashMap.keySet());
      if (this.kiF.getLayoutParams() == null)
      {
        paramLinkedHashMap = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(272668);
        throw paramLinkedHashMap;
      }
      b.b.a(this.kCL, b.c.kBb);
      this.knt.ad((List)localArrayList);
      Log.i("MicroMsg.LiveCoreAnchor", "notifyLinkMicMode userIdList:".concat(String.valueOf(localArrayList)));
      AppMethodBeat.o(272668);
      return;
    }
    p.k(paramLinkedHashMap, "micUserMap");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)paramLinkedHashMap.keySet());
    paramLinkedHashMap = this.kiF.getLayoutParams();
    if (paramLinkedHashMap == null)
    {
      paramLinkedHashMap = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(272668);
      throw paramLinkedHashMap;
    }
    paramLinkedHashMap = (RelativeLayout.LayoutParams)paramLinkedHashMap;
    paramLinkedHashMap.topMargin = 0;
    paramLinkedHashMap.bottomMargin = 0;
    this.knt.ad((List)localArrayList);
    b.b.a(this.kCL, b.c.kBc);
    Log.i("MicroMsg.LiveCoreAnchor", "notifyNormalMode userIdList:".concat(String.valueOf(localArrayList)));
    AppMethodBeat.o(272668);
  }
  
  public final void aCm(final String paramString)
  {
    AppMethodBeat.i(272663);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramString));
    AppMethodBeat.o(272663);
  }
  
  public final void dAO()
  {
    AppMethodBeat.i(272665);
    float f3 = ax.au(this.context).x;
    float f2 = ax.au(this.context).y;
    int i = ax.getStatusBarHeight(this.context);
    float f1 = aw.fromDPToPix(this.kiF.getContext(), 16);
    int j = aw.fromDPToPix(this.context, 80);
    j = ax.aB(this.context) + j;
    Log.i("MicroMsg.LiveCoreAnchor", "adjustPreviewByScreen screenW:" + f3 + " screenH:" + f2 + " factor:1.7777778 statusBarH:" + i);
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject;
    if ((((f)business(f.class)).zhl == null) && (((f)business(f.class)).zhm.isEmpty())) {
      if (f2 / f3 <= 1.777778F)
      {
        localLayoutParams = this.kiF.getLayoutParams();
        localObject = localLayoutParams;
        if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
          localObject = null;
        }
        localObject = (RelativeLayout.LayoutParams)localObject;
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
        }
        if ((this.kiF instanceof RoundCornerRelativeLayout)) {
          ((RoundCornerRelativeLayout)this.kiF).v(0.0F, 0.0F, 0.0F, 0.0F);
        }
        Log.i("MicroMsg.LiveCoreAnchor", "adjustPreviewByScreen fill screen");
      }
    }
    for (;;)
    {
      this.kiF.requestLayout();
      AppMethodBeat.o(272665);
      return;
      f3 *= 1.777778F;
      f2 -= f3;
      if (f2 <= i)
      {
        localLayoutParams = this.kiF.getLayoutParams();
        localObject = localLayoutParams;
        if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
          localObject = null;
        }
        localObject = (RelativeLayout.LayoutParams)localObject;
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)localObject).topMargin = i;
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
        }
        if ((this.kiF instanceof RoundCornerRelativeLayout)) {
          ((RoundCornerRelativeLayout)this.kiF).v(f1, f1, 0.0F, 0.0F);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.LiveCoreAnchor", "adjustPreviewByScreen fit screen, targetH:" + f3 + " offsetH:" + f2 + " realBottomMargin:" + ((int)f2 - i) + " mostBottomMargin:" + j);
        break;
        localLayoutParams = this.kiF.getLayoutParams();
        localObject = localLayoutParams;
        if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
          localObject = null;
        }
        localObject = (RelativeLayout.LayoutParams)localObject;
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)localObject).topMargin = i;
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = i.ow((int)f2 - i, j);
        }
        if ((this.kiF instanceof RoundCornerRelativeLayout)) {
          ((RoundCornerRelativeLayout)this.kiF).v(f1, f1, f1, f1);
        }
      }
      localLayoutParams = this.kiF.getLayoutParams();
      localObject = localLayoutParams;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        localObject = null;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      }
      if ((this.kiF instanceof RoundCornerRelativeLayout)) {
        ((RoundCornerRelativeLayout)this.kiF).v(0.0F, 0.0F, 0.0F, 0.0F);
      }
    }
  }
  
  public final void dAP()
  {
    AppMethodBeat.i(272666);
    oZ(false);
    cg localcg = this.ynU;
    localcg.kiF.setVisibility(8);
    localcg.ywK.removeAllViews();
    com.tencent.mm.live.core.core.trtc.a locala = cg.getLiveCore();
    if (locala != null) {
      locala.a(false, null, null);
    }
    locala = cg.getLiveCore();
    if (locala != null) {
      locala.ds(0, 0);
    }
    localcg.dCt();
    aNs();
    AppMethodBeat.o(272666);
  }
  
  public final void dAQ()
  {
    AppMethodBeat.i(272667);
    this.ynU.pk(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgO);
    this.ynU.dAQ();
    oZ(true);
    AppMethodBeat.o(272667);
  }
  
  public final void mount() {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(272669);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = com.tencent.mm.plugin.finder.live.model.e.ydF;
    boolean bool;
    if (paramInt1 != com.tencent.mm.plugin.finder.live.model.e.dxZ())
    {
      localObject = com.tencent.mm.plugin.finder.live.model.e.ydF;
      if (paramInt1 != com.tencent.mm.plugin.finder.live.model.e.dyb()) {}
    }
    else if (paramInt2 == -1)
    {
      localObject = com.tencent.mm.plugin.finder.live.model.e.ydF;
      if (paramInt1 == com.tencent.mm.plugin.finder.live.model.e.dyb()) {
        this.ynU.dCt();
      }
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("filePath");
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zgN = paramIntent;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgO = false;
        bool = com.tencent.mm.vfs.u.agG(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgN);
        Log.i("MicroMsg.LiveCoreAnchor", "REQUEST_CODE_SELECT_FILE screenShareFilePath:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgN + " exist:" + bool);
        paramIntent = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgN;
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
        this.ynU.pk(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgO);
        this.ynU.dAQ();
        oZ(true);
        AppMethodBeat.o(272669);
        return;
        paramIntent = null;
        break;
      }
      label259:
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgN = null;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgO = false;
      AppMethodBeat.o(272669);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.live.model.e.ydF;
    if (paramInt1 != com.tencent.mm.plugin.finder.live.model.e.dya())
    {
      localObject = com.tencent.mm.plugin.finder.live.model.e.ydF;
      if (paramInt1 != com.tencent.mm.plugin.finder.live.model.e.dyc()) {}
    }
    else if (paramInt2 == -1)
    {
      localObject = com.tencent.mm.plugin.finder.live.model.e.ydF;
      if (paramInt1 == com.tencent.mm.plugin.finder.live.model.e.dyc()) {
        this.ynU.dCt();
      }
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        if (paramIntent != null)
        {
          paramIntent = (String)j.lp((List)paramIntent);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zgN = paramIntent;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgO = true;
          bool = com.tencent.mm.vfs.u.agG(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgN);
          Log.i("MicroMsg.LiveCoreAnchor", "REQUEST_CODE_SELECT_IMAGE screenShareFilePath:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgN + " exist:" + bool);
          paramIntent = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgN;
          if ((paramIntent != null) && (paramIntent.length() != 0)) {
            break label550;
          }
        }
      }
      label550:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((paramInt1 != 0) || (!bool)) {
          break label555;
        }
        this.ynU.pk(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgO);
        this.ynU.dAQ();
        oZ(true);
        AppMethodBeat.o(272669);
        return;
        paramIntent = null;
        break;
      }
      label555:
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgN = null;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgO = false;
    }
    AppMethodBeat.o(272669);
  }
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(272661);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ac.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(272661);
      return;
      tU(0);
      AppMethodBeat.o(272661);
      return;
      Log.i("MicroMsg.LiveCoreAnchor", "switchCamera");
      paramc = getLiveCore();
      if (paramc != null) {
        paramc.switchCamera();
      }
      paramc = getLiveCore();
      if (paramc == null)
      {
        paramc = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
        AppMethodBeat.o(272661);
        throw paramc;
      }
      paramc = (com.tencent.mm.live.core.core.a.b)paramc;
      paramBundle = ah.yhC;
      paramc.eU(ah.needMirror());
      paramc = com.tencent.mm.live.b.u.kwz;
      paramc = com.tencent.mm.live.b.u.aOm();
      paramBundle = com.tencent.mm.live.b.u.kwz;
      long l = com.tencent.mm.live.b.u.aOr().klE;
      paramBundle = com.tencent.mm.live.b.u.kwz;
      paramBundle = com.tencent.mm.live.b.u.aOt();
      Object localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
      p.j(localObject1, "ConfigHelper.getInstance()");
      if (((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).aLM().kpc == 0) {
        i = 1;
      }
      localObject1 = z.bcZ();
      p.j(localObject1, "ConfigStorageLogic.getUsernameFromUserInfo()");
      Object localObject2 = com.tencent.mm.live.b.u.kwz;
      com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 1, i, (String)localObject1, com.tencent.mm.live.b.u.aOr().SOs);
      com.tencent.mm.live.d.a.aPY();
      AppMethodBeat.o(272661);
      return;
      paramc = getLiveCore();
      if (paramc != null)
      {
        paramc.aJx();
        AppMethodBeat.o(272661);
        return;
      }
      AppMethodBeat.o(272661);
      return;
      boolean bool2;
      boolean bool3;
      if (paramBundle != null)
      {
        bool2 = paramBundle.getBoolean("PARAM_FINDER_LIVE_AUDIO_MODE", false);
        if (paramBundle == null) {
          break label506;
        }
        bool3 = paramBundle.getBoolean("PARAM_FINDER_LIVE_SWITCH_MODE_FROM_MINIWINDOW", false);
        label317:
        Log.i("MicroMsg.LiveCoreAnchor", "checkAudioMode isAudioMode:" + bool2 + ", fromMiniWindow:" + bool3 + ", liveData.audioModeHolderBm:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgo);
        paramc = getLiveCore();
        if (paramc == null) {
          break label525;
        }
        paramc = paramc.knA;
        if ((paramc == null) || (paramc.kmG)) {
          break label525;
        }
        if (!bool2) {
          break label512;
        }
        paramc = getLiveCore();
        if (paramc != null) {
          paramc.knt = this.knt;
        }
      }
      for (;;)
      {
        paramc = this.ynU;
        paramBundle = cg.getLiveCore();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.knA;
          if ((paramBundle != null) && (paramBundle.kmG == true))
          {
            if (!bool2) {
              break label544;
            }
            paramc.dCq();
          }
        }
        Log.i("MicroMsg.LiveCoreAnchor", "FINDER_LIVE_MODE_SWITCH isAudioMode:" + bool2 + ",fromMiniWindow:" + bool3);
        AppMethodBeat.o(272661);
        return;
        bool2 = false;
        break;
        label506:
        bool3 = false;
        break label317;
        label512:
        co(bool3);
        aNs();
        continue;
        label525:
        paramc = getLiveCore();
        if (paramc != null) {
          paramc.knt = this.knt;
        }
      }
      label544:
      paramc.dCp();
      paramBundle = cg.getLiveCore();
      boolean bool4;
      if (paramBundle != null)
      {
        localObject1 = paramBundle.knz;
        if (localObject1 == null) {
          break label845;
        }
        localObject1 = ((g)localObject1).kmp;
        if (localObject1 == null) {
          break label845;
        }
        bool4 = ((com.tencent.mm.live.core.core.model.e)localObject1).kmd;
        label586:
        localObject1 = paramBundle.knz;
        if (localObject1 == null) {
          break label851;
        }
        localObject1 = ((g)localObject1).kmp;
        if (localObject1 == null) {
          break label851;
        }
        bool1 = ((com.tencent.mm.live.core.core.model.e)localObject1).kme;
      }
      for (;;)
      {
        paramBundle.o(bool4, bool1);
        localObject1 = paramBundle.knz;
        if (localObject1 != null)
        {
          localObject1 = ((g)localObject1).kmp;
          if ((localObject1 != null) && (((com.tencent.mm.live.core.core.model.e)localObject1).kmf == true))
          {
            localObject1 = paramBundle.knu;
            if (localObject1 != null) {
              ((com.tencent.mm.media.widget.a.e)localObject1).a(paramBundle.kns.getFrameDataCallback());
            }
          }
        }
        localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        p.j(localObject1, "ConfigHelper.getInstance()");
        localObject1 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).aLK();
        p.j(localObject1, "ConfigHelper.getInstance().audioConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject1).fb(true);
        localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        p.j(localObject1, "ConfigHelper.getInstance()");
        localObject1 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).aLJ();
        p.j(localObject1, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject1).ff(true);
        localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        p.j(localObject1, "ConfigHelper.getInstance()");
        localObject1 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).aLM();
        localObject2 = paramBundle.knu;
        i = j;
        if (localObject2 != null) {
          i = ((com.tencent.mm.media.widget.a.e)localObject2).aYi();
        }
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.b)localObject1).kpc = i;
        paramBundle.kns.a(paramBundle.knC);
        paramBundle.kns.a(paramBundle.knD);
        paramBundle.kns.d((kotlin.g.a.b)new a.h(paramBundle));
        paramc.dCr();
        break;
        label845:
        bool4 = false;
        break label586;
        label851:
        if ((paramBundle.knv == null) || (com.tencent.mm.media.widget.a.b.isFrontCamera())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      paramc = getLiveCore();
      if (paramc != null)
      {
        paramc = paramc.knA;
        if ((paramc == null) || (paramc.aLs() != true)) {}
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.LiveCoreAnchor", "checkAudioMode isAudioMode:" + bool1 + ", fromMiniWindow:false, liveData.audioModeHolderBm:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgo);
        if (!bool1) {
          break label991;
        }
        paramc = getLiveCore();
        if (paramc == null) {
          break;
        }
        paramc.knt = this.knt;
        AppMethodBeat.o(272661);
        return;
      }
      AppMethodBeat.o(272661);
      return;
      label991:
      co(false);
      aNs();
      paramc = getLiveCore();
      if (paramc == null) {
        break;
      }
      paramc = paramc.knA;
      if (paramc == null) {
        break;
      }
      if (paramc.kmG == true) {
        dAQ();
      }
    }
    AppMethodBeat.o(272661);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(272659);
    super.unMount();
    Log.i("MicroMsg.LiveCoreAnchor", "unMount");
    AppMethodBeat.o(272659);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPreviewPlugin$Companion;", "", "()V", "LIVE_UI", "", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(ab paramab, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ab paramab) {}
    
    public final void run()
    {
      AppMethodBeat.i(289749);
      if ((ab.dAR() instanceof com.tencent.mm.live.core.core.a.b))
      {
        Object localObject = ab.dAR();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
          AppMethodBeat.o(289749);
          throw ((Throwable)localObject);
        }
        localObject = (com.tencent.mm.live.core.core.a.b)localObject;
        ah localah = ah.yhC;
        ((com.tencent.mm.live.core.core.a.b)localObject).eU(ah.needMirror());
      }
      AppMethodBeat.o(289749);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ab
 * JD-Core Version:    0.7.0.1
 */