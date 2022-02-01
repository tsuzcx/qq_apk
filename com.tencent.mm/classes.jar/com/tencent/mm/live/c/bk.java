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
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.core.trtc.a.e;
import com.tencent.mm.live.core.core.trtc.a.f;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.live.d.c;
import com.tencent.mm.live.d.f;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "mCameraRenderHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "getMCameraRenderHolder", "()Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "setMCameraRenderHolder", "(Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;)V", "mCurrentDegree", "", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "dpVal", "", "enterRoom", "", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "enterRoomFail", "enterRoomSuccess", "exitRoom", "floatMode", "hideMicLayout", "onBackPress", "onOrientationChange", "degree", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "requestStopMic", "resume", "setPreviewTouchListener", "callback", "Lkotlin/Function2;", "x", "y", "setupSwitchCameraBtn", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class bk
  extends a
  implements d.a
{
  public static final bk.a gXZ;
  private Context context;
  public final LivePreviewView gIn;
  private final b gSM;
  public com.tencent.mm.live.core.core.c.b gXF;
  public j gXW;
  private com.tencent.mm.plugin.mmsight.model.d gXX;
  private int gXY;
  
  static
  {
    AppMethodBeat.i(212695);
    gXZ = new bk.a((byte)0);
    AppMethodBeat.o(212695);
  }
  
  public bk(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212694);
    this.gSM = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307720);
    p.g(paramb, "root.findViewById(R.id.live_preview_view)");
    this.gIn = ((LivePreviewView)paramb);
    this.gXY = getCurrentOrientation();
    paramb = com.tencent.mm.live.core.core.c.b.gKd;
    paramViewGroup = paramViewGroup.getContext();
    p.g(paramViewGroup, "root.context");
    this.gXF = com.tencent.mm.live.core.core.c.b.a.cr(paramViewGroup);
    this.gXX = new com.tencent.mm.plugin.mmsight.model.d(this.context, (byte)0);
    paramViewGroup = this.gXX;
    if (paramViewGroup != null) {
      paramViewGroup.a((d.a)this);
    }
    paramViewGroup = this.gXX;
    if (paramViewGroup != null) {
      paramViewGroup.enable();
    }
    paramViewGroup = new ImageView(this.gGK.getContext());
    paramViewGroup.setImageDrawable(ao.k(this.gGK.getContext(), 2131690362, -1));
    paramb = new RelativeLayout.LayoutParams(aq.fromDPToPix(this.gGK.getContext(), 28), aq.fromDPToPix(this.gGK.getContext(), 28));
    paramb.addRule(21);
    int i = aq.fromDPToPix(this.gGK.getContext(), 4);
    paramViewGroup.setPadding(i, i, i, i);
    RelativeLayout localRelativeLayout = this.gIn.getCameraRootView();
    if (localRelativeLayout != null) {
      localRelativeLayout.addView((View)paramViewGroup, (ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(212694);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(212690);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (bl.cpQ[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(212690);
      return;
    case 1: 
    case 2: 
    case 3: 
      paramc = this.gXX;
      if (paramc != null) {
        paramc.disable();
      }
      paramc = this.gXX;
      if (paramc != null) {
        paramc.a(null);
      }
      this.gXX = null;
      exitRoom();
      nI(8);
      AppMethodBeat.o(212690);
      return;
    case 4: 
      if (paramBundle != null) {
        bool1 = paramBundle.getBoolean("PARAM_HANGUP_SELF", false);
      }
      if (bool1)
      {
        paramc = this.gXF;
        if (paramc != null)
        {
          paramc = paramc.gIt;
          if ((paramc != null) && (paramc.alF() == true)) {
            c.apF();
          }
        }
      }
      for (;;)
      {
        paramc = com.tencent.mm.live.core.core.c.b.gKd;
        paramc = this.gGK.getContext();
        p.g(paramc, "root.context");
        com.tencent.mm.live.core.core.c.b.a.cr(paramc).amh();
        paramc = this.gXF;
        if (paramc != null)
        {
          paramBundle = com.tencent.mm.cc.a.az(this.context, 2131766707);
          p.g(paramBundle, "ResourceHelper.getString…tring.live_room_mini_mic)");
          paramc.xl(paramBundle);
        }
        paramBundle = this.gXF;
        paramc = (b.c)localObject;
        if (paramBundle != null) {
          paramc = Integer.valueOf(paramBundle.ame());
        }
        ad.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:".concat(String.valueOf(paramc)));
        this.gIn.post((Runnable)new bk.g(this));
        AppMethodBeat.o(212690);
        return;
        paramc = this.gXF;
        if (paramc != null)
        {
          paramc = paramc.gIt;
          if ((paramc != null) && (paramc.alE() == true))
          {
            c.apG();
            continue;
            paramc = this.gXF;
            if (paramc != null)
            {
              paramc = paramc.gIt;
              if ((paramc != null) && (paramc.alF() == true))
              {
                c.apH();
                continue;
              }
            }
            paramc = this.gXF;
            if (paramc != null)
            {
              paramc = paramc.gIt;
              if ((paramc != null) && (paramc.alE() == true)) {
                c.apI();
              }
            }
          }
        }
      }
    case 5: 
      paramc = this.gXF;
      if (paramc != null)
      {
        paramBundle = com.tencent.mm.cc.a.az(this.context, 2131766709);
        p.g(paramBundle, "ResourceHelper.getString….live_room_mini_wait_mic)");
        paramc.xl(paramBundle);
        AppMethodBeat.o(212690);
        return;
      }
      AppMethodBeat.o(212690);
      return;
    case 6: 
    case 7: 
      paramc = this.gXF;
      if (paramc != null)
      {
        paramBundle = com.tencent.mm.cc.a.az(this.context, 2131766706);
        p.g(paramBundle, "ResourceHelper.getString…ring.live_room_mini_live)");
        paramc.xl(paramBundle);
        AppMethodBeat.o(212690);
        return;
      }
      AppMethodBeat.o(212690);
      return;
    case 8: 
      paramBundle = this.gXW;
      if (paramBundle != null)
      {
        paramc = this.gXF;
        if (paramc != null)
        {
          p.h(paramBundle, "surfaceHolder");
          paramc.gIm.amo();
          paramBundle.gLR = ((m)new a.e(paramc, paramBundle));
          localObject = com.tencent.mm.live.core.debug.a.gKp;
          com.tencent.mm.live.core.debug.a.xx("startPreview " + paramBundle + ' ');
          paramBundle = paramc.gIs;
          if (paramBundle == null) {
            break label768;
          }
          paramBundle = paramBundle.gHB;
          if (paramBundle == null) {
            break label768;
          }
          bool1 = paramBundle.gHt;
          paramBundle = paramc.gIs;
          if (paramBundle == null) {
            break label774;
          }
          paramBundle = paramBundle.gHB;
          if (paramBundle == null) {
            break label774;
          }
        }
      }
      for (bool2 = paramBundle.gHu;; bool2 = true)
      {
        paramc.k(bool1, bool2);
        paramBundle = paramc.gIs;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.gHB;
          if ((paramBundle != null) && (paramBundle.gHv == true))
          {
            paramBundle = paramc.gIo;
            if (paramBundle != null) {
              paramBundle.a(paramc.gIm.getFrameDataCallback());
            }
          }
        }
        paramc.gIm.d((d.g.a.b)new a.f(paramc));
        paramc = g.gOr;
        paramc = g.anm();
        paramBundle = g.gOr;
        l = g.ans().Fsa;
        paramBundle = g.gOr;
        paramBundle = g.anu();
        localObject = u.aAm();
        p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
        com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 7, 1, (String)localObject);
        AppMethodBeat.o(212690);
        return;
        bool1 = false;
        break;
      }
    case 9: 
      nI(0);
      apd();
      paramc = this.gIn;
      paramBundle = this.gGK.getContext();
      p.g(paramBundle, "root.context");
      paramBundle = paramBundle.getResources();
      p.g(paramBundle, "root.context.resources");
      i = paramBundle.getConfiguration().orientation;
      paramc.gLW.ns(i);
      paramc = com.tencent.mm.live.core.core.trtc.a.a.alJ();
      p.g(paramc, "ConfigHelper.getInstance()");
      paramc = paramc.alK();
      p.g(paramc, "ConfigHelper.getInstance().videoConfig");
      paramBundle = this.context;
      p.g(paramBundle, "context");
      paramBundle = paramBundle.getResources();
      p.g(paramBundle, "context.resources");
      if (paramBundle.getConfiguration().orientation == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramc.dH(bool1);
        paramc = com.tencent.mm.live.core.core.c.b.gKd;
        paramc = this.gGK.getContext();
        p.g(paramc, "root.context");
        com.tencent.mm.live.core.core.c.b.a.cr(paramc).c(this.gIn);
        c.apC();
        AppMethodBeat.o(212690);
        return;
      }
    case 10: 
      label768:
      label774:
      this.gIn.post((Runnable)new bk.h(this));
      paramc = com.tencent.mm.live.core.core.c.b.gKd;
      paramc = this.gGK.getContext();
      p.g(paramc, "root.context");
      com.tencent.mm.live.core.core.c.b.a.cr(paramc).amh();
      paramc = g.gOr;
      paramc = g.anm();
      paramBundle = g.gOr;
      l = g.ans().Fsa;
      paramBundle = g.gOr;
      paramBundle = g.anu();
      localObject = u.aAm();
      p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
      com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 7, 0, (String)localObject);
      AppMethodBeat.o(212690);
      return;
    }
    ad.i("MicroMsg.LiveCoreVisitor", "switchCamera");
    paramc = this.gXF;
    if (paramc != null) {
      paramc.switchCamera();
    }
    paramc = g.gOr;
    paramc = g.anm();
    paramBundle = g.gOr;
    long l = g.ans().Fsa;
    paramBundle = g.gOr;
    paramBundle = g.anu();
    localObject = com.tencent.mm.live.core.core.trtc.a.a.alJ();
    p.g(localObject, "ConfigHelper.getInstance()");
    if (((com.tencent.mm.live.core.core.trtc.a.a)localObject).alN().gJh == 0) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 1, i);
      break;
    }
  }
  
  public final void a(com.tencent.mm.live.core.core.b.d paramd, final d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(212687);
    p.h(paramd, "liveRoomModel");
    p.h(paramb, "action");
    com.tencent.mm.live.core.core.c.b localb = this.gXF;
    if (localb != null) {
      localb.a(paramd);
    }
    paramd = this.gXF;
    if (paramd != null)
    {
      paramd.a(this.gIn, (com.tencent.mm.live.core.core.b)new b(this, paramb));
      AppMethodBeat.o(212687);
      return;
    }
    AppMethodBeat.o(212687);
  }
  
  public final void aoA()
  {
    AppMethodBeat.i(212692);
    ad.i("MicroMsg.LiveCoreVisitor", "unMount");
    Object localObject = this.gXF;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).gIt;
      if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).isFloatMode() == true)) {}
    }
    else
    {
      localObject = g.gOr;
      if (g.anz()) {
        break label120;
      }
      localObject = this.gXF;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).gIt;
        if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).alF() == true)) {}
      }
      else
      {
        localObject = this.gXF;
        if (localObject == null) {
          break label120;
        }
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).gIt;
        if ((localObject == null) || (((com.tencent.mm.live.core.core.b.e)localObject).alE() != true)) {
          break label120;
        }
      }
    }
    localObject = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.xx("activity recycler");
    AppMethodBeat.o(212692);
    return;
    label120:
    localObject = this.gXF;
    if (localObject != null)
    {
      ((com.tencent.mm.live.core.core.c.b)localObject).b((com.tencent.mm.live.core.core.b)new f());
      AppMethodBeat.o(212692);
      return;
    }
    AppMethodBeat.o(212692);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void apd()
  {
    AppMethodBeat.i(212688);
    ViewParent localViewParent = this.gIn.getParent();
    if (localViewParent != null)
    {
      if ((localViewParent instanceof ViewGroup))
      {
        ((ViewGroup)localViewParent).removeView((View)this.gIn);
        ((ViewGroup)localViewParent).addView((View)this.gIn);
      }
      AppMethodBeat.o(212688);
      return;
    }
    AppMethodBeat.o(212688);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(212689);
    p.h(paramString, "userId");
    this.gIn.c(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(212689);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(212686);
    com.tencent.mm.live.core.core.c.b localb = this.gXF;
    if (localb != null)
    {
      localb.b((com.tencent.mm.live.core.core.b)new c());
      AppMethodBeat.o(212686);
      return;
    }
    AppMethodBeat.o(212686);
  }
  
  public final void nL(int paramInt)
  {
    AppMethodBeat.i(212693);
    Object localObject1 = g.gOr;
    paramInt = g.anZ();
    localObject1 = this.gGK.getResources();
    p.g(localObject1, "root.resources");
    if (paramInt != ((Resources)localObject1).getConfiguration().orientation)
    {
      localObject1 = this.gGK.getResources();
      p.g(localObject1, "root.resources");
      if (((Resources)localObject1).getConfiguration().orientation != 1)
      {
        localObject1 = this.gGK.getResources();
        p.g(localObject1, "root.resources");
        if (((Resources)localObject1).getConfiguration().orientation != 2) {}
      }
      else
      {
        localObject1 = g.gOr;
        localObject1 = this.gGK.getResources();
        p.g(localObject1, "root.resources");
        g.nE(((Resources)localObject1).getConfiguration().orientation);
        localObject1 = g.gOr;
        localObject1 = g.anm();
        Object localObject2 = g.gOr;
        long l = g.ans().Fsa;
        localObject2 = g.gOr;
        localObject2 = g.anu();
        g localg = g.gOr;
        if (g.anZ() == 1) {}
        for (paramInt = 0;; paramInt = 1)
        {
          com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 5, paramInt);
          localObject1 = g.gOr;
          if (g.anZ() != 1) {
            break;
          }
          f.aqj();
          AppMethodBeat.o(212693);
          return;
        }
        f.aqi();
        AppMethodBeat.o(212693);
        return;
      }
    }
    if (this.gXY != getCurrentOrientation())
    {
      this.gXY = getCurrentOrientation();
      b.b.a(this.gSM, b.c.gSu);
    }
    AppMethodBeat.o(212693);
  }
  
  public final void pause() {}
  
  public final void resume()
  {
    AppMethodBeat.i(212691);
    Object localObject = g.gOr;
    if (g.anB() != -1)
    {
      localObject = this.context.getSystemService("window");
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(212691);
        throw ((Throwable)localObject);
      }
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.g(localObject, "((context.getSystemServi…owManager).defaultDisplay");
      int i = ((Display)localObject).getRotation();
      localObject = g.gOr;
      if (i != g.anB())
      {
        localObject = this.gXF;
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject).b(this.gIn);
        }
        this.gIn.getRenderLayout().post((Runnable)new d(this));
      }
    }
    AppMethodBeat.o(212691);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.live.core.core.b
  {
    b(d.g.a.b paramb) {}
    
    public final void f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(212681);
      if (paramInt >= 0)
      {
        bk.ape();
        paramb.invoke(Boolean.TRUE);
        AppMethodBeat.o(212681);
        return;
      }
      bk.apf();
      paramb.invoke(Boolean.FALSE);
      AppMethodBeat.o(212681);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$exitRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class c
    implements com.tencent.mm.live.core.core.b
  {
    public final void f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(212682);
      ad.i("MicroMsg.LiveCoreVisitor", "on exit room finish");
      AppMethodBeat.o(212682);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(bk parambk) {}
    
    public final void run()
    {
      AppMethodBeat.i(212683);
      LivePreviewView localLivePreviewView = bk.b(this.gYa);
      localLivePreviewView.gLW.nr(localLivePreviewView.gLW.getRemoteViewIndex());
      AppMethodBeat.o(212683);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(bk parambk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212684);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$setupSwitchCameraBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      b.b.a(bk.a(this.gYa), b.c.gRx);
      paramView = g.gOr;
      paramView = g.anw();
      if (paramView != null)
      {
        paramView = paramView.gHB;
        if (paramView != null)
        {
          localObject = g.gOr;
          localObject = g.anw();
          if (localObject == null) {
            break label123;
          }
          localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gHB;
          if (localObject == null) {
            break label123;
          }
          bool = ((com.tencent.mm.live.core.core.b.b)localObject).gHu;
          if (bool) {
            break label128;
          }
        }
      }
      label128:
      for (boolean bool = true;; bool = false)
      {
        paramView.gHu = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$setupSwitchCameraBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212684);
        return;
        label123:
        bool = true;
        break;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$unMount$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class f
    implements com.tencent.mm.live.core.core.b
  {
    public final void f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(212685);
      ad.i("MicroMsg.LiveCoreVisitor", "on exitRoom finish");
      paramBundle = com.tencent.mm.live.core.core.a.b.gHl;
      com.tencent.mm.live.core.core.a.b.a.releaseInstance();
      AppMethodBeat.o(212685);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.bk
 * JD-Core Version:    0.7.0.1
 */