package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.core.b.n;
import com.tencent.mm.live.core.core.c.c.a;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.live.d.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "mCameraRenderHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "getMCameraRenderHolder", "()Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "setMCameraRenderHolder", "(Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;)V", "mCurrentDegree", "", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "dpVal", "", "enterRoom", "", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "enterRoomFail", "enterRoomSuccess", "exitRoom", "hideMicLayout", "onBackPress", "onOrientationChange", "degree", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "requestStopMic", "resume", "setPreviewTouchListener", "callback", "Lkotlin/Function2;", "x", "y", "setupSwitchCameraBtn", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class bk
  extends a
  implements d.a
{
  public static final a kIb;
  private Context context;
  private final b kCL;
  public n kHZ;
  private int kIa;
  public final LivePreviewView knt;
  public com.tencent.mm.live.core.core.c.c liveCore;
  private d orientationEventListener;
  
  static
  {
    AppMethodBeat.i(193865);
    kIb = new a((byte)0);
    AppMethodBeat.o(193865);
  }
  
  public bk(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(193864);
    this.kCL = paramb;
    this.context = paramViewGroup.getContext();
    paramViewGroup = paramViewGroup.findViewById(b.e.live_preview_view);
    p.j(paramViewGroup, "root.findViewById(R.id.live_preview_view)");
    this.knt = ((LivePreviewView)paramViewGroup);
    this.kIa = getCurrentOrientation();
    paramViewGroup = com.tencent.mm.live.core.core.c.c.kqq;
    this.liveCore = c.a.aMm();
    this.orientationEventListener = new d(this.context, (byte)0);
    paramViewGroup = this.orientationEventListener;
    if (paramViewGroup != null) {
      paramViewGroup.a((d.a)this);
    }
    paramViewGroup = this.orientationEventListener;
    if (paramViewGroup != null) {
      paramViewGroup.enable();
    }
    paramViewGroup = new ImageView(this.kiF.getContext());
    paramViewGroup.setImageDrawable(au.o(this.kiF.getContext(), b.g.icons_filled_camera_switch, -1));
    paramb = new RelativeLayout.LayoutParams(aw.fromDPToPix(this.kiF.getContext(), 28), aw.fromDPToPix(this.kiF.getContext(), 28));
    paramb.addRule(21);
    int i = aw.fromDPToPix(this.kiF.getContext(), 4);
    paramViewGroup.setPadding(i, i, i, i);
    RelativeLayout localRelativeLayout = this.knt.getCameraRootView();
    if (localRelativeLayout != null) {
      localRelativeLayout.addView((View)paramViewGroup, (ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(193864);
  }
  
  public final void a(g paramg, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(193852);
    p.k(paramg, "liveRoomModel");
    p.k(paramb, "action");
    com.tencent.mm.live.core.core.c.c localc = this.liveCore;
    if (localc != null) {
      localc.a(paramg);
    }
    paramg = this.liveCore;
    if (paramg != null)
    {
      paramg.a(this.knt, (com.tencent.mm.live.core.core.c)new b(this, paramb));
      AppMethodBeat.o(193852);
      return;
    }
    AppMethodBeat.o(193852);
  }
  
  public final void aPO()
  {
    AppMethodBeat.i(193853);
    ViewParent localViewParent = this.knt.getParent();
    if (localViewParent != null)
    {
      if ((localViewParent instanceof ViewGroup))
      {
        ((ViewGroup)localViewParent).removeView((View)this.knt);
        ((ViewGroup)localViewParent).addView((View)this.knt);
      }
      AppMethodBeat.o(193853);
      return;
    }
    AppMethodBeat.o(193853);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(193854);
    p.k(paramString, "userId");
    this.knt.c(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(193854);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(193848);
    com.tencent.mm.live.core.core.c.c localc = this.liveCore;
    if (localc != null)
    {
      localc.b((com.tencent.mm.live.core.core.c)new c());
      AppMethodBeat.o(193848);
      return;
    }
    AppMethodBeat.o(193848);
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(193859);
    Object localObject1 = u.kwz;
    paramInt = u.aOW();
    localObject1 = this.kiF.getResources();
    p.j(localObject1, "root.resources");
    if (paramInt != ((Resources)localObject1).getConfiguration().orientation)
    {
      localObject1 = this.kiF.getResources();
      p.j(localObject1, "root.resources");
      if (((Resources)localObject1).getConfiguration().orientation != 1)
      {
        localObject1 = this.kiF.getResources();
        p.j(localObject1, "root.resources");
        if (((Resources)localObject1).getConfiguration().orientation != 2) {}
      }
      else
      {
        localObject1 = u.kwz;
        localObject1 = this.kiF.getResources();
        p.j(localObject1, "root.resources");
        u.tS(((Resources)localObject1).getConfiguration().orientation);
        localObject1 = u.kwz;
        localObject1 = u.aOm();
        Object localObject2 = u.kwz;
        long l = u.aOr().klE;
        localObject2 = u.kwz;
        localObject2 = u.aOt();
        u localu = u.kwz;
        if (u.aOW() == 1) {}
        for (paramInt = 0;; paramInt = 1)
        {
          localu = u.kwz;
          com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 5, paramInt, u.aOr().SOs);
          localObject1 = u.kwz;
          if (u.aOW() != 1) {
            break;
          }
          f.aQU();
          AppMethodBeat.o(193859);
          return;
        }
        f.aQT();
        AppMethodBeat.o(193859);
        return;
      }
    }
    if (this.kIa != getCurrentOrientation())
    {
      this.kIa = getCurrentOrientation();
      b.b.a(this.kCL, b.c.kzW);
    }
    AppMethodBeat.o(193859);
  }
  
  public final void pause() {}
  
  public final void resume()
  {
    AppMethodBeat.i(193857);
    Object localObject = u.kwz;
    if (u.getLastOrientation() != -1)
    {
      localObject = this.context.getSystemService("window");
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(193857);
        throw ((Throwable)localObject);
      }
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.j(localObject, "((context.getSystemServi…owManager).defaultDisplay");
      int i = ((Display)localObject).getRotation();
      localObject = u.kwz;
      if (i != u.getLastOrientation())
      {
        localObject = this.liveCore;
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject).knt = this.knt;
        }
        this.knt.getRenderLayout().post((Runnable)new d(this));
      }
    }
    AppMethodBeat.o(193857);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(193855);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    u localu;
    switch (bl.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(193855);
      return;
    case 1: 
    case 2: 
    case 3: 
      paramc = this.orientationEventListener;
      if (paramc != null) {
        paramc.disable();
      }
      paramc = this.orientationEventListener;
      if (paramc != null) {
        paramc.a(null);
      }
      this.orientationEventListener = null;
      exitRoom();
      tU(8);
      AppMethodBeat.o(193855);
      return;
    case 4: 
      if (paramBundle != null) {
        bool1 = paramBundle.getBoolean("PARAM_HANGUP_SELF", false);
      }
      if (bool1)
      {
        paramc = this.liveCore;
        if (paramc != null)
        {
          paramc = paramc.knA;
          if ((paramc != null) && (paramc.aLp() == true)) {
            com.tencent.mm.live.d.c.aQq();
          }
        }
      }
      for (;;)
      {
        paramc = com.tencent.mm.live.core.core.c.c.kqq;
        c.a.aMm().aMk();
        paramBundle = this.liveCore;
        paramc = (b.c)localObject;
        if (paramBundle != null) {
          paramc = Integer.valueOf(paramBundle.aMh());
        }
        Log.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:".concat(String.valueOf(paramc)));
        this.knt.post((Runnable)new f(this));
        AppMethodBeat.o(193855);
        return;
        paramc = this.liveCore;
        if (paramc != null)
        {
          paramc = paramc.knA;
          if ((paramc != null) && (paramc.aLo() == true))
          {
            com.tencent.mm.live.d.c.aQr();
            continue;
            paramc = this.liveCore;
            if (paramc != null)
            {
              paramc = paramc.knA;
              if ((paramc != null) && (paramc.aLp() == true))
              {
                com.tencent.mm.live.d.c.aQs();
                continue;
              }
            }
            paramc = this.liveCore;
            if (paramc != null)
            {
              paramc = paramc.knA;
              if ((paramc != null) && (paramc.aLo() == true)) {
                com.tencent.mm.live.d.c.aQt();
              }
            }
          }
        }
      }
    case 5: 
      AppMethodBeat.o(193855);
      return;
    case 6: 
    case 7: 
      AppMethodBeat.o(193855);
      return;
    case 8: 
      paramc = this.kHZ;
      if (paramc != null)
      {
        paramBundle = this.liveCore;
        if (paramBundle != null) {
          paramBundle.a(paramc);
        }
      }
      paramc = u.kwz;
      paramc = u.aOm();
      paramBundle = u.kwz;
      l = u.aOr().klE;
      paramBundle = u.kwz;
      paramBundle = u.aOt();
      localObject = z.bcZ();
      p.j(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
      localu = u.kwz;
      com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 7, 1, (String)localObject, u.aOr().SOs);
      AppMethodBeat.o(193855);
      return;
    case 9: 
      tU(0);
      aPO();
      paramc = this.knt;
      paramBundle = this.kiF.getContext();
      p.j(paramBundle, "root.context");
      paramBundle = paramBundle.getResources();
      p.j(paramBundle, "root.context.resources");
      paramc.tD(paramBundle.getConfiguration().orientation);
      paramc = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
      p.j(paramc, "ConfigHelper.getInstance()");
      paramc = paramc.aLJ();
      p.j(paramc, "ConfigHelper.getInstance().videoConfig");
      paramBundle = this.context;
      p.j(paramBundle, "context");
      paramBundle = paramBundle.getResources();
      p.j(paramBundle, "context.resources");
      if (paramBundle.getConfiguration().orientation == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramc.fd(bool1);
        paramc = com.tencent.mm.live.core.core.c.c.kqq;
        c.a.aMm().b(this.knt);
        com.tencent.mm.live.d.c.aQn();
        AppMethodBeat.o(193855);
        return;
      }
    case 10: 
      this.knt.post((Runnable)new g(this));
      paramc = com.tencent.mm.live.core.core.c.c.kqq;
      c.a.aMm().aMk();
      paramc = u.kwz;
      paramc = u.aOm();
      paramBundle = u.kwz;
      l = u.aOr().klE;
      paramBundle = u.kwz;
      paramBundle = u.aOt();
      localObject = z.bcZ();
      p.j(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
      localu = u.kwz;
      com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 7, 0, (String)localObject, u.aOr().SOs);
      AppMethodBeat.o(193855);
      return;
    }
    Log.i("MicroMsg.LiveCoreVisitor", "switchCamera");
    paramc = this.liveCore;
    if (paramc != null) {
      paramc.switchCamera();
    }
    paramc = u.kwz;
    paramc = u.aOm();
    paramBundle = u.kwz;
    long l = u.aOr().klE;
    paramBundle = u.kwz;
    paramBundle = u.aOt();
    localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
    p.j(localObject, "ConfigHelper.getInstance()");
    if (((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLM().kpc == 0) {}
    for (int i = 1;; i = 0)
    {
      localObject = u.kwz;
      com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 1, i, u.aOr().SOs);
      break;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(193858);
    Log.i("MicroMsg.LiveCoreVisitor", "unMount");
    Object localObject = this.liveCore;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knA;
      if ((localObject != null) && (((h)localObject).isFloatMode() == true)) {}
    }
    else
    {
      localObject = u.kwz;
      if (u.isManualClosed()) {
        break label120;
      }
      localObject = this.liveCore;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knA;
        if ((localObject != null) && (((h)localObject).aLp() == true)) {}
      }
      else
      {
        localObject = this.liveCore;
        if (localObject == null) {
          break label120;
        }
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knA;
        if ((localObject == null) || (((h)localObject).aLo() != true)) {
          break label120;
        }
      }
    }
    localObject = com.tencent.mm.live.core.debug.a.kqB;
    com.tencent.mm.live.core.debug.a.NN("activity recycler");
    AppMethodBeat.o(193858);
    return;
    label120:
    localObject = this.liveCore;
    if (localObject != null)
    {
      ((com.tencent.mm.live.core.core.c.c)localObject).b((com.tencent.mm.live.core.core.c)new h());
      AppMethodBeat.o(193858);
      return;
    }
    AppMethodBeat.o(193858);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$Companion;", "", "()V", "ENTER_ROOM_SCENE_LINK_MIC", "", "ENTER_ROOM_SCENE_VISITOR", "LIVE_UI", "", "TAG", "plugin-logic_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.live.core.core.c
  {
    b(kotlin.g.a.b paramb) {}
    
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(190139);
      if (paramInt >= 0)
      {
        bk.aPP();
        paramb.invoke(Boolean.TRUE);
        AppMethodBeat.o(190139);
        return;
      }
      bk.aPQ();
      paramb.invoke(Boolean.FALSE);
      AppMethodBeat.o(190139);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$exitRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class c
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(194148);
      Log.i("MicroMsg.LiveCoreVisitor", "on exit room finish");
      AppMethodBeat.o(194148);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(bk parambk) {}
    
    public final void run()
    {
      AppMethodBeat.i(194741);
      LivePreviewView localLivePreviewView = bk.b(this.kIc);
      localLivePreviewView.ksW.tE(localLivePreviewView.ksW.getRemoteViewIndex());
      AppMethodBeat.o(194741);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(bk parambk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200561);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$setupSwitchCameraBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      b.b.a(bk.a(this.kIc), b.c.kyX);
      paramView = u.kwz;
      paramView = u.aOv();
      if (paramView != null)
      {
        paramView = paramView.kmp;
        if (paramView != null)
        {
          localObject = u.kwz;
          localObject = u.aOv();
          if (localObject == null) {
            break label123;
          }
          localObject = ((g)localObject).kmp;
          if (localObject == null) {
            break label123;
          }
          bool = ((com.tencent.mm.live.core.core.model.e)localObject).kme;
          if (bool) {
            break label128;
          }
        }
      }
      label128:
      for (boolean bool = true;; bool = false)
      {
        paramView.kme = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$setupSwitchCameraBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(200561);
        return;
        label123:
        bool = true;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(bk parambk) {}
    
    public final void run()
    {
      AppMethodBeat.i(193324);
      bk.b(this.kIc).ksW.aNq();
      AppMethodBeat.o(193324);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(bk parambk) {}
    
    public final void run()
    {
      AppMethodBeat.i(188295);
      bk.b(this.kIc).ksW.aNq();
      AppMethodBeat.o(188295);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$unMount$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class h
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(193482);
      Log.i("MicroMsg.LiveCoreVisitor", "on exitRoom finish");
      paramBundle = com.tencent.mm.live.core.core.a.b.klq;
      com.tencent.mm.live.core.core.a.b.b.eV(false);
      AppMethodBeat.o(193482);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.bk
 * JD-Core Version:    0.7.0.1
 */