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
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.live.d.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "mCameraRenderHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "getMCameraRenderHolder", "()Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "setMCameraRenderHolder", "(Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;)V", "mCurrentDegree", "", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "dpVal", "", "enterRoom", "", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "enterRoomFail", "enterRoomSuccess", "exitRoom", "hideMicLayout", "onBackPress", "onOrientationChange", "degree", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "requestStopMic", "resume", "setPreviewTouchListener", "callback", "Lkotlin/Function2;", "x", "y", "setupSwitchCameraBtn", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class bk
  extends a
  implements d.a
{
  public static final a hTE;
  private Context context;
  public final LivePreviewView hAs;
  private final b hOp;
  public com.tencent.mm.live.core.b.l hTC;
  private int hTD;
  public com.tencent.mm.live.core.core.d.b liveCore;
  private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  
  static
  {
    AppMethodBeat.i(208284);
    hTE = new a((byte)0);
    AppMethodBeat.o(208284);
  }
  
  public bk(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208283);
    this.hOp = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131303506);
    p.g(paramb, "root.findViewById(R.id.live_preview_view)");
    this.hAs = ((LivePreviewView)paramb);
    this.hTD = getCurrentOrientation();
    paramb = com.tencent.mm.live.core.core.d.b.hCo;
    paramViewGroup.getContext();
    this.liveCore = com.tencent.mm.live.core.core.d.b.a.aEf();
    this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(this.context, (byte)0);
    paramViewGroup = this.orientationEventListener;
    if (paramViewGroup != null) {
      paramViewGroup.a((d.a)this);
    }
    paramViewGroup = this.orientationEventListener;
    if (paramViewGroup != null) {
      paramViewGroup.enable();
    }
    paramViewGroup = new ImageView(this.hwr.getContext());
    paramViewGroup.setImageDrawable(ar.m(this.hwr.getContext(), 2131690502, -1));
    paramb = new RelativeLayout.LayoutParams(at.fromDPToPix(this.hwr.getContext(), 28), at.fromDPToPix(this.hwr.getContext(), 28));
    paramb.addRule(21);
    int i = at.fromDPToPix(this.hwr.getContext(), 4);
    paramViewGroup.setPadding(i, i, i, i);
    RelativeLayout localRelativeLayout = this.hAs.getCameraRootView();
    if (localRelativeLayout != null) {
      localRelativeLayout.addView((View)paramViewGroup, (ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(208283);
  }
  
  public final void a(com.tencent.mm.live.core.core.b.f paramf, final kotlin.g.a.b<? super Boolean, kotlin.x> paramb)
  {
    AppMethodBeat.i(208276);
    p.h(paramf, "liveRoomModel");
    p.h(paramb, "action");
    com.tencent.mm.live.core.core.d.b localb = this.liveCore;
    if (localb != null) {
      localb.a(paramf);
    }
    paramf = this.liveCore;
    if (paramf != null)
    {
      paramf.a(this.hAs, (com.tencent.mm.live.core.core.c)new b(this, paramb));
      AppMethodBeat.o(208276);
      return;
    }
    AppMethodBeat.o(208276);
  }
  
  public final void aHQ()
  {
    AppMethodBeat.i(208277);
    ViewParent localViewParent = this.hAs.getParent();
    if (localViewParent != null)
    {
      if ((localViewParent instanceof ViewGroup))
      {
        ((ViewGroup)localViewParent).removeView((View)this.hAs);
        ((ViewGroup)localViewParent).addView((View)this.hAs);
      }
      AppMethodBeat.o(208277);
      return;
    }
    AppMethodBeat.o(208277);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(208278);
    p.h(paramString, "userId");
    this.hAs.c(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(208278);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(208275);
    com.tencent.mm.live.core.core.d.b localb = this.liveCore;
    if (localb != null)
    {
      localb.b((com.tencent.mm.live.core.core.c)new c());
      AppMethodBeat.o(208275);
      return;
    }
    AppMethodBeat.o(208275);
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(208282);
    Object localObject1 = com.tencent.mm.live.b.x.hJf;
    paramInt = com.tencent.mm.live.b.x.aGW();
    localObject1 = this.hwr.getResources();
    p.g(localObject1, "root.resources");
    if (paramInt != ((Resources)localObject1).getConfiguration().orientation)
    {
      localObject1 = this.hwr.getResources();
      p.g(localObject1, "root.resources");
      if (((Resources)localObject1).getConfiguration().orientation != 1)
      {
        localObject1 = this.hwr.getResources();
        p.g(localObject1, "root.resources");
        if (((Resources)localObject1).getConfiguration().orientation != 2) {}
      }
      else
      {
        localObject1 = com.tencent.mm.live.b.x.hJf;
        localObject1 = this.hwr.getResources();
        p.g(localObject1, "root.resources");
        com.tencent.mm.live.b.x.rd(((Resources)localObject1).getConfiguration().orientation);
        localObject1 = com.tencent.mm.live.b.x.hJf;
        localObject1 = com.tencent.mm.live.b.x.aGm();
        Object localObject2 = com.tencent.mm.live.b.x.hJf;
        long l = com.tencent.mm.live.b.x.aGr().hyH;
        localObject2 = com.tencent.mm.live.b.x.hJf;
        localObject2 = com.tencent.mm.live.b.x.aGt();
        com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.aGW() == 1) {}
        for (paramInt = 0;; paramInt = 1)
        {
          localx = com.tencent.mm.live.b.x.hJf;
          e.a((String)localObject1, l, (String)localObject2, 5, paramInt, com.tencent.mm.live.b.x.aGr().LIa);
          localObject1 = com.tencent.mm.live.b.x.hJf;
          if (com.tencent.mm.live.b.x.aGW() != 1) {
            break;
          }
          com.tencent.mm.live.d.f.aIW();
          AppMethodBeat.o(208282);
          return;
        }
        com.tencent.mm.live.d.f.aIV();
        AppMethodBeat.o(208282);
        return;
      }
    }
    if (this.hTD != getCurrentOrientation())
    {
      this.hTD = getCurrentOrientation();
      b.b.a(this.hOp, b.c.hMC);
    }
    AppMethodBeat.o(208282);
  }
  
  public final void pause() {}
  
  public final void resume()
  {
    AppMethodBeat.i(208280);
    Object localObject = com.tencent.mm.live.b.x.hJf;
    if (com.tencent.mm.live.b.x.getLastOrientation() != -1)
    {
      localObject = this.context.getSystemService("window");
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(208280);
        throw ((Throwable)localObject);
      }
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.g(localObject, "((context.getSystemServi…owManager).defaultDisplay");
      int i = ((Display)localObject).getRotation();
      localObject = com.tencent.mm.live.b.x.hJf;
      if (i != com.tencent.mm.live.b.x.getLastOrientation())
      {
        localObject = this.liveCore;
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.d.b)localObject).a(this.hAs);
        }
        this.hAs.getRenderLayout().post((Runnable)new d(this));
      }
    }
    AppMethodBeat.o(208280);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(208279);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    com.tencent.mm.live.b.x localx;
    switch (bl.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(208279);
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
      rg(8);
      AppMethodBeat.o(208279);
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
          paramc = paramc.hAz;
          if ((paramc != null) && (paramc.aDu() == true)) {
            com.tencent.mm.live.d.c.aIs();
          }
        }
      }
      for (;;)
      {
        paramc = com.tencent.mm.live.core.core.d.b.hCo;
        this.hwr.getContext();
        com.tencent.mm.live.core.core.d.b.a.aEf().aEd();
        paramBundle = this.liveCore;
        paramc = (b.c)localObject;
        if (paramBundle != null) {
          paramc = Integer.valueOf(paramBundle.aDZ());
        }
        Log.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:".concat(String.valueOf(paramc)));
        this.hAs.post((Runnable)new f(this));
        AppMethodBeat.o(208279);
        return;
        paramc = this.liveCore;
        if (paramc != null)
        {
          paramc = paramc.hAz;
          if ((paramc != null) && (paramc.aDt() == true))
          {
            com.tencent.mm.live.d.c.aIt();
            continue;
            paramc = this.liveCore;
            if (paramc != null)
            {
              paramc = paramc.hAz;
              if ((paramc != null) && (paramc.aDu() == true))
              {
                com.tencent.mm.live.d.c.aIu();
                continue;
              }
            }
            paramc = this.liveCore;
            if (paramc != null)
            {
              paramc = paramc.hAz;
              if ((paramc != null) && (paramc.aDt() == true)) {
                com.tencent.mm.live.d.c.aIv();
              }
            }
          }
        }
      }
    case 5: 
      AppMethodBeat.o(208279);
      return;
    case 6: 
    case 7: 
      AppMethodBeat.o(208279);
      return;
    case 8: 
      paramc = this.hTC;
      if (paramc != null)
      {
        paramBundle = this.liveCore;
        if (paramBundle != null) {
          paramBundle.a(paramc);
        }
      }
      paramc = com.tencent.mm.live.b.x.hJf;
      paramc = com.tencent.mm.live.b.x.aGm();
      paramBundle = com.tencent.mm.live.b.x.hJf;
      l = com.tencent.mm.live.b.x.aGr().hyH;
      paramBundle = com.tencent.mm.live.b.x.hJf;
      paramBundle = com.tencent.mm.live.b.x.aGt();
      localObject = z.aTY();
      p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
      localx = com.tencent.mm.live.b.x.hJf;
      e.a(paramc, l, paramBundle, 7, 1, (String)localObject, com.tencent.mm.live.b.x.aGr().LIa);
      AppMethodBeat.o(208279);
      return;
    case 9: 
      rg(0);
      aHQ();
      paramc = this.hAs;
      paramBundle = this.hwr.getContext();
      p.g(paramBundle, "root.context");
      paramBundle = paramBundle.getResources();
      p.g(paramBundle, "root.context.resources");
      paramc.qO(paramBundle.getConfiguration().orientation);
      paramc = com.tencent.mm.live.core.core.trtc.a.a.aDC();
      p.g(paramc, "ConfigHelper.getInstance()");
      paramc = paramc.aDD();
      p.g(paramc, "ConfigHelper.getInstance().videoConfig");
      paramBundle = this.context;
      p.g(paramBundle, "context");
      paramBundle = paramBundle.getResources();
      p.g(paramBundle, "context.resources");
      if (paramBundle.getConfiguration().orientation == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramc.eA(bool1);
        paramc = com.tencent.mm.live.core.core.d.b.hCo;
        this.hwr.getContext();
        com.tencent.mm.live.core.core.d.b.a.aEf().b(this.hAs);
        com.tencent.mm.live.d.c.aIp();
        AppMethodBeat.o(208279);
        return;
      }
    case 10: 
      this.hAs.post((Runnable)new g(this));
      paramc = com.tencent.mm.live.core.core.d.b.hCo;
      this.hwr.getContext();
      com.tencent.mm.live.core.core.d.b.a.aEf().aEd();
      paramc = com.tencent.mm.live.b.x.hJf;
      paramc = com.tencent.mm.live.b.x.aGm();
      paramBundle = com.tencent.mm.live.b.x.hJf;
      l = com.tencent.mm.live.b.x.aGr().hyH;
      paramBundle = com.tencent.mm.live.b.x.hJf;
      paramBundle = com.tencent.mm.live.b.x.aGt();
      localObject = z.aTY();
      p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
      localx = com.tencent.mm.live.b.x.hJf;
      e.a(paramc, l, paramBundle, 7, 0, (String)localObject, com.tencent.mm.live.b.x.aGr().LIa);
      AppMethodBeat.o(208279);
      return;
    }
    Log.i("MicroMsg.LiveCoreVisitor", "switchCamera");
    paramc = this.liveCore;
    if (paramc != null) {
      paramc.switchCamera();
    }
    paramc = com.tencent.mm.live.b.x.hJf;
    paramc = com.tencent.mm.live.b.x.aGm();
    paramBundle = com.tencent.mm.live.b.x.hJf;
    long l = com.tencent.mm.live.b.x.aGr().hyH;
    paramBundle = com.tencent.mm.live.b.x.hJf;
    paramBundle = com.tencent.mm.live.b.x.aGt();
    localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
    p.g(localObject, "ConfigHelper.getInstance()");
    if (((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDG().hBp == 0) {}
    for (int i = 1;; i = 0)
    {
      localObject = com.tencent.mm.live.b.x.hJf;
      e.a(paramc, l, paramBundle, 1, i, com.tencent.mm.live.b.x.aGr().LIa);
      break;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(208281);
    Log.i("MicroMsg.LiveCoreVisitor", "unMount");
    Object localObject = this.liveCore;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).hAz;
      if ((localObject != null) && (((g)localObject).isFloatMode() == true)) {}
    }
    else
    {
      localObject = com.tencent.mm.live.b.x.hJf;
      if (com.tencent.mm.live.b.x.isManualClosed()) {
        break label120;
      }
      localObject = this.liveCore;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).hAz;
        if ((localObject != null) && (((g)localObject).aDu() == true)) {}
      }
      else
      {
        localObject = this.liveCore;
        if (localObject == null) {
          break label120;
        }
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).hAz;
        if ((localObject == null) || (((g)localObject).aDt() != true)) {
          break label120;
        }
      }
    }
    localObject = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.GA("activity recycler");
    AppMethodBeat.o(208281);
    return;
    label120:
    localObject = this.liveCore;
    if (localObject != null)
    {
      ((com.tencent.mm.live.core.core.d.b)localObject).b((com.tencent.mm.live.core.core.c)new h());
      AppMethodBeat.o(208281);
      return;
    }
    AppMethodBeat.o(208281);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$Companion;", "", "()V", "ENTER_ROOM_SCENE_LINK_MIC", "", "ENTER_ROOM_SCENE_VISITOR", "LIVE_UI", "", "TAG", "plugin-logic_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.live.core.core.c
  {
    b(kotlin.g.a.b paramb) {}
    
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(208268);
      if (paramInt >= 0)
      {
        bk.aHR();
        paramb.invoke(Boolean.TRUE);
        AppMethodBeat.o(208268);
        return;
      }
      bk.aHS();
      paramb.invoke(Boolean.FALSE);
      AppMethodBeat.o(208268);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$exitRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class c
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(208269);
      Log.i("MicroMsg.LiveCoreVisitor", "on exit room finish");
      AppMethodBeat.o(208269);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(bk parambk) {}
    
    public final void run()
    {
      AppMethodBeat.i(208270);
      LivePreviewView localLivePreviewView = bk.b(this.hTF);
      localLivePreviewView.hER.qP(localLivePreviewView.hER.getRemoteViewIndex());
      AppMethodBeat.o(208270);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(bk parambk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208271);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$setupSwitchCameraBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      b.b.a(bk.a(this.hTF), b.c.hLE);
      paramView = com.tencent.mm.live.b.x.hJf;
      paramView = com.tencent.mm.live.b.x.aGv();
      if (paramView != null)
      {
        paramView = paramView.hzt;
        if (paramView != null)
        {
          localObject = com.tencent.mm.live.b.x.hJf;
          localObject = com.tencent.mm.live.b.x.aGv();
          if (localObject == null) {
            break label123;
          }
          localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hzt;
          if (localObject == null) {
            break label123;
          }
          bool = ((com.tencent.mm.live.core.core.b.d)localObject).hzh;
          if (bool) {
            break label128;
          }
        }
      }
      label128:
      for (boolean bool = true;; bool = false)
      {
        paramView.hzh = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$setupSwitchCameraBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208271);
        return;
        label123:
        bool = true;
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(bk parambk) {}
    
    public final void run()
    {
      AppMethodBeat.i(208272);
      bk.b(this.hTF).hER.aEY();
      AppMethodBeat.o(208272);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(bk parambk) {}
    
    public final void run()
    {
      AppMethodBeat.i(208273);
      bk.b(this.hTF).hER.aEY();
      AppMethodBeat.o(208273);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$unMount$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class h
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(208274);
      Log.i("MicroMsg.LiveCoreVisitor", "on exitRoom finish");
      paramBundle = com.tencent.mm.live.core.core.a.b.hyv;
      com.tencent.mm.live.core.core.a.b.a.releaseInstance();
      AppMethodBeat.o(208274);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.bk
 * JD-Core Version:    0.7.0.1
 */