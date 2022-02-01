package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.core.trtc.a.e;
import com.tencent.mm.live.core.core.trtc.a.f;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.live.d.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "mCameraRenderHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "getMCameraRenderHolder", "()Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "setMCameraRenderHolder", "(Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;)V", "mLastOrientation", "", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "dpVal", "", "enterRoom", "", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "enterRoomFail", "enterRoomSuccess", "exitRoom", "floatMode", "hideMicLayout", "onBackPress", "onOrientationChange", "orientation", "orientationChanged", "userId", "", "streamType", "pause", "refreshPreviewView", "requestStopMic", "resume", "setPreviewTouchListener", "callback", "Lkotlin/Function0;", "setupSwitchCameraBtn", "showMicLayout", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class bl
  extends a
  implements d.a
{
  public static final a KxQ;
  private final b IIs;
  public j KxP;
  private com.tencent.mm.live.core.core.c.b Kxx;
  private Context context;
  private int lgU;
  public final LivePreviewView qDY;
  private com.tencent.mm.plugin.mmsight.model.d tKW;
  
  static
  {
    AppMethodBeat.i(203163);
    KxQ = new a((byte)0);
    AppMethodBeat.o(203163);
  }
  
  public bl(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(203162);
    this.IIs = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307637);
    k.g(paramb, "root.findViewById(R.id.live_preview_view)");
    this.qDY = ((LivePreviewView)paramb);
    paramb = com.tencent.mm.live.core.core.c.b.qOk;
    paramViewGroup = paramViewGroup.getContext();
    k.g(paramViewGroup, "root.context");
    this.Kxx = com.tencent.mm.live.core.core.c.b.a.eH(paramViewGroup);
    this.tKW = new com.tencent.mm.plugin.mmsight.model.d(this.context, (byte)0);
    paramViewGroup = this.tKW;
    if (paramViewGroup != null) {
      paramViewGroup.a((d.a)this);
    }
    paramViewGroup = this.tKW;
    if (paramViewGroup != null) {
      paramViewGroup.enable();
    }
    paramViewGroup = new WeImageView(this.pTc.getContext());
    paramViewGroup.setImageDrawable(am.i(this.pTc.getContext(), 2131690362, -1));
    paramb = new RelativeLayout.LayoutParams(ao.fromDPToPix(this.pTc.getContext(), 20), ao.fromDPToPix(this.pTc.getContext(), 20));
    paramb.addRule(21);
    paramb.setMarginEnd(ao.fromDPToPix(this.pTc.getContext(), 4));
    paramb.topMargin = ao.fromDPToPix(this.pTc.getContext(), 4);
    RelativeLayout localRelativeLayout = this.qDY.getCameraRootView();
    if (localRelativeLayout != null) {
      localRelativeLayout.addView((View)paramViewGroup, (ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(203162);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(203158);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (bm.ciE[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(203158);
      return;
    case 1: 
    case 2: 
    case 3: 
      paramc = this.tKW;
      if (paramc != null) {
        paramc.disable();
      }
      paramc = this.tKW;
      if (paramc != null) {
        paramc.a(null);
      }
      this.tKW = null;
      exitRoom();
      agK(8);
      AppMethodBeat.o(203158);
      return;
    case 4: 
      if (paramBundle != null) {
        bool1 = paramBundle.getBoolean("PARAM_HANGUP_SELF", false);
      }
      if (bool1)
      {
        paramc = this.Kxx;
        if (paramc != null)
        {
          paramc = paramc.qEd;
          if ((paramc != null) && (paramc.cnx() == true)) {
            c.fPG();
          }
        }
      }
      for (;;)
      {
        paramc = com.tencent.mm.live.core.core.c.b.qOk;
        paramc = this.pTc.getContext();
        k.g(paramc, "root.context");
        com.tencent.mm.live.core.core.c.b.a.eH(paramc).csq();
        paramc = this.Kxx;
        if (paramc != null)
        {
          paramBundle = com.tencent.mm.cd.a.aq(this.context, 2131766672);
          k.g(paramBundle, "ResourceHelper.getString…tring.live_room_mini_mic)");
          paramc.aTU(paramBundle);
        }
        paramBundle = this.Kxx;
        paramc = (b.c)localObject;
        if (paramBundle != null) {
          paramc = Integer.valueOf(paramBundle.csn());
        }
        ad.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:".concat(String.valueOf(paramc)));
        this.qDY.qUv.dRf();
        AppMethodBeat.o(203158);
        return;
        paramc = this.Kxx;
        if (paramc != null)
        {
          paramc = paramc.qEd;
          if ((paramc != null) && (paramc.cnw() == true))
          {
            c.fPH();
            continue;
            paramc = this.Kxx;
            if (paramc != null)
            {
              paramc = paramc.qEd;
              if ((paramc != null) && (paramc.cnx() == true))
              {
                c.fPI();
                continue;
              }
            }
            paramc = this.Kxx;
            if (paramc != null)
            {
              paramc = paramc.qEd;
              if ((paramc != null) && (paramc.cnw() == true)) {
                c.fPJ();
              }
            }
          }
        }
      }
    case 5: 
      paramc = this.Kxx;
      if (paramc != null)
      {
        paramBundle = com.tencent.mm.cd.a.aq(this.context, 2131766674);
        k.g(paramBundle, "ResourceHelper.getString….live_room_mini_wait_mic)");
        paramc.aTU(paramBundle);
        AppMethodBeat.o(203158);
        return;
      }
      AppMethodBeat.o(203158);
      return;
    case 6: 
    case 7: 
      paramc = this.Kxx;
      if (paramc != null)
      {
        paramBundle = com.tencent.mm.cd.a.aq(this.context, 2131766671);
        k.g(paramBundle, "ResourceHelper.getString…ring.live_room_mini_live)");
        paramc.aTU(paramBundle);
        AppMethodBeat.o(203158);
        return;
      }
      AppMethodBeat.o(203158);
      return;
    case 8: 
      paramBundle = this.KxP;
      if (paramBundle != null)
      {
        paramc = this.Kxx;
        if (paramc != null)
        {
          k.h(paramBundle, "surfaceHolder");
          paramc.qDX.czD();
          paramBundle.qUp = ((m)new a.e(paramc, paramBundle));
          localObject = com.tencent.mm.live.core.debug.a.qOL;
          com.tencent.mm.live.core.debug.a.aUc("startPreview " + paramBundle + ' ');
          paramBundle = com.tencent.mm.live.core.core.b.d.qzw;
          bool1 = com.tencent.mm.live.core.core.b.d.cnu().qyF;
          paramBundle = com.tencent.mm.live.core.core.b.d.qzw;
          paramc.aO(bool1, com.tencent.mm.live.core.core.b.d.cnu().qyV);
          paramBundle = com.tencent.mm.live.core.core.b.d.qzw;
          if (com.tencent.mm.live.core.core.b.d.cnu().qyW)
          {
            paramBundle = paramc.gAz;
            if (paramBundle != null) {
              paramBundle.a(paramc.qDX.getFrameDataCallback());
            }
          }
          paramc.qDX.m((d.g.a.b)new a.f(paramc));
        }
      }
      paramc = com.tencent.mm.live.b.f.rGw;
      paramc = com.tencent.mm.live.b.f.eNB();
      paramBundle = com.tencent.mm.live.b.f.rGw;
      l = com.tencent.mm.live.b.f.eNG().LwA;
      paramBundle = com.tencent.mm.live.b.f.rGw;
      paramBundle = com.tencent.mm.live.b.f.eNI();
      localObject = u.aqG();
      k.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
      com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 7, 1, (String)localObject);
      AppMethodBeat.o(203158);
      return;
    case 9: 
      agK(0);
      fPf();
      paramc = this.qDY;
      paramBundle = this.pTc.getContext();
      k.g(paramBundle, "root.context");
      paramBundle = paramBundle.getResources();
      k.g(paramBundle, "root.context.resources");
      i = paramBundle.getConfiguration().orientation;
      paramc.qUv.abp(i);
      paramc = com.tencent.mm.live.core.core.trtc.a.a.cpE();
      k.g(paramc, "ConfigHelper.getInstance()");
      paramc = paramc.cpF();
      k.g(paramc, "ConfigHelper.getInstance().videoConfig");
      paramBundle = this.context;
      k.g(paramBundle, "context");
      paramBundle = paramBundle.getResources();
      k.g(paramBundle, "context.resources");
      if (paramBundle.getConfiguration().orientation == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramc.kN(bool1);
        paramc = com.tencent.mm.live.core.core.c.b.qOk;
        paramc = this.pTc.getContext();
        k.g(paramc, "root.context");
        com.tencent.mm.live.core.core.c.b.a.eH(paramc).c(this.qDY);
        c.fPD();
        AppMethodBeat.o(203158);
        return;
      }
    case 10: 
      this.qDY.qUv.dRf();
      paramc = com.tencent.mm.live.core.core.c.b.qOk;
      paramc = this.pTc.getContext();
      k.g(paramc, "root.context");
      com.tencent.mm.live.core.core.c.b.a.eH(paramc).csq();
      paramc = com.tencent.mm.live.b.f.rGw;
      paramc = com.tencent.mm.live.b.f.eNB();
      paramBundle = com.tencent.mm.live.b.f.rGw;
      l = com.tencent.mm.live.b.f.eNG().LwA;
      paramBundle = com.tencent.mm.live.b.f.rGw;
      paramBundle = com.tencent.mm.live.b.f.eNI();
      localObject = u.aqG();
      k.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
      com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 7, 0, (String)localObject);
      AppMethodBeat.o(203158);
      return;
    }
    ad.i("MicroMsg.LiveCoreVisitor", "switchCamera");
    paramc = this.Kxx;
    if (paramc != null) {
      paramc.switchCamera();
    }
    paramc = com.tencent.mm.live.b.f.rGw;
    paramc = com.tencent.mm.live.b.f.eNB();
    paramBundle = com.tencent.mm.live.b.f.rGw;
    long l = com.tencent.mm.live.b.f.eNG().LwA;
    paramBundle = com.tencent.mm.live.b.f.rGw;
    paramBundle = com.tencent.mm.live.b.f.eNI();
    localObject = com.tencent.mm.live.core.core.trtc.a.a.cpE();
    k.g(localObject, "ConfigHelper.getInstance()");
    if (((com.tencent.mm.live.core.core.trtc.a.a)localObject).cpV().qGm == 0) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 1, i);
      break;
    }
  }
  
  public final void a(com.tencent.mm.live.core.core.b.d paramd, final d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(203155);
    k.h(paramd, "liveRoomModel");
    k.h(paramb, "action");
    com.tencent.mm.live.core.core.c.b localb = this.Kxx;
    if (localb != null) {
      localb.a(paramd);
    }
    paramd = this.Kxx;
    if (paramd != null)
    {
      paramd.a(this.qDY, (com.tencent.mm.live.core.core.b)new b(this, paramb));
      AppMethodBeat.o(203155);
      return;
    }
    AppMethodBeat.o(203155);
  }
  
  public final boolean dia()
  {
    return false;
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(203154);
    com.tencent.mm.live.core.core.c.b localb = this.Kxx;
    if (localb != null)
    {
      localb.b((com.tencent.mm.live.core.core.b)new c());
      AppMethodBeat.o(203154);
      return;
    }
    AppMethodBeat.o(203154);
  }
  
  public final void fON()
  {
    AppMethodBeat.i(203160);
    ad.i("MicroMsg.LiveCoreVisitor", "unMount");
    Object localObject = this.Kxx;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).qEd;
      if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).qzP == true)) {}
    }
    else
    {
      localObject = com.tencent.mm.live.b.f.rGw;
      if (com.tencent.mm.live.b.f.fhE()) {
        break label120;
      }
      localObject = this.Kxx;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).qEd;
        if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).cnx() == true)) {}
      }
      else
      {
        localObject = this.Kxx;
        if (localObject == null) {
          break label120;
        }
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).qEd;
        if ((localObject == null) || (((com.tencent.mm.live.core.core.b.e)localObject).cnw() != true)) {
          break label120;
        }
      }
    }
    localObject = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.aUc("activity recycler");
    AppMethodBeat.o(203160);
    return;
    label120:
    localObject = this.Kxx;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject).b((com.tencent.mm.live.core.core.b)new f());
    }
    localObject = com.tencent.mm.live.b.f.rGw;
    com.tencent.mm.live.b.f.VP();
    localObject = com.tencent.mm.live.core.core.c.b.qOk;
    localObject = com.tencent.mm.live.core.core.c.b.css();
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject).release();
    }
    com.tencent.mm.live.core.core.c.b.e(null);
    AppMethodBeat.o(203160);
  }
  
  public final void fPf()
  {
    AppMethodBeat.i(203156);
    ViewParent localViewParent = this.qDY.getParent();
    if (localViewParent != null)
    {
      if ((localViewParent instanceof ViewGroup))
      {
        ((ViewGroup)localViewParent).removeView((View)this.qDY);
        ((ViewGroup)localViewParent).addView((View)this.qDY);
      }
      AppMethodBeat.o(203156);
      return;
    }
    AppMethodBeat.o(203156);
  }
  
  public final void pause() {}
  
  public final void resume()
  {
    AppMethodBeat.i(203159);
    Object localObject = com.tencent.mm.live.b.f.rGw;
    if (com.tencent.mm.live.b.f.fhG() != 0)
    {
      localObject = this.context;
      k.g(localObject, "context");
      localObject = ((Context)localObject).getResources();
      k.g(localObject, "context.resources");
      int i = ((Resources)localObject).getConfiguration().orientation;
      localObject = com.tencent.mm.live.b.f.rGw;
      if (i != com.tencent.mm.live.b.f.fhG())
      {
        localObject = this.Kxx;
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject).b(this.qDY);
        }
        this.qDY.getRenderLayout().post((Runnable)new d(this));
      }
    }
    AppMethodBeat.o(203159);
  }
  
  public final void w(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(203157);
    k.h(paramString, "userId");
    this.qDY.w(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(203157);
  }
  
  public final void wy(int paramInt)
  {
    AppMethodBeat.i(203161);
    paramInt = this.lgU;
    Object localObject1 = this.pTc.getResources();
    k.g(localObject1, "root.resources");
    if (paramInt != ((Resources)localObject1).getConfiguration().orientation)
    {
      localObject1 = this.pTc.getResources();
      k.g(localObject1, "root.resources");
      this.lgU = ((Resources)localObject1).getConfiguration().orientation;
      localObject1 = com.tencent.mm.live.b.f.rGw;
      localObject1 = com.tencent.mm.live.b.f.eNB();
      Object localObject2 = com.tencent.mm.live.b.f.rGw;
      long l = com.tencent.mm.live.b.f.eNG().LwA;
      localObject2 = com.tencent.mm.live.b.f.rGw;
      localObject2 = com.tencent.mm.live.b.f.eNI();
      if (this.lgU == 1) {}
      for (paramInt = 0;; paramInt = 1)
      {
        com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 5, paramInt);
        if (this.lgU != 1) {
          break;
        }
        com.tencent.mm.live.d.f.fQk();
        AppMethodBeat.o(203161);
        return;
      }
      com.tencent.mm.live.d.f.fQj();
    }
    AppMethodBeat.o(203161);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$Companion;", "", "()V", "ENTER_ROOM_SCENE_LINK_MIC", "", "ENTER_ROOM_SCENE_VISITOR", "LIVE_UI", "", "TAG", "plugin-logic_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.live.core.core.b
  {
    b(d.g.a.b paramb) {}
    
    public final void B(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(203149);
      if (paramInt >= 0)
      {
        bl.b(this.KxR);
        paramb.aA(Boolean.TRUE);
        AppMethodBeat.o(203149);
        return;
      }
      bl.fPg();
      paramb.aA(Boolean.FALSE);
      AppMethodBeat.o(203149);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$exitRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class c
    implements com.tencent.mm.live.core.core.b
  {
    public final void B(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(203150);
      ad.i("MicroMsg.LiveCoreVisitor", "on exit room finish");
      AppMethodBeat.o(203150);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(bl parambl) {}
    
    public final void run()
    {
      AppMethodBeat.i(203151);
      LivePreviewView localLivePreviewView = bl.c(this.KxR);
      localLivePreviewView.qUv.aaq(localLivePreviewView.qUv.getRemoteViewIndex());
      AppMethodBeat.o(203151);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(bl parambl) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203152);
      b.b.a(bl.a(this.KxR), b.c.FAY);
      AppMethodBeat.o(203152);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$unMount$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class f
    implements com.tencent.mm.live.core.core.b
  {
    public final void B(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(203153);
      ad.i("MicroMsg.LiveCoreVisitor", "on exitRoom finish");
      paramBundle = com.tencent.mm.live.core.core.a.b.qym;
      com.tencent.mm.live.core.core.a.b.a.releaseInstance();
      AppMethodBeat.o(203153);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.bl
 * JD-Core Version:    0.7.0.1
 */