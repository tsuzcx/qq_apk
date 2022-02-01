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
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "mCameraRenderHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "getMCameraRenderHolder", "()Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "setMCameraRenderHolder", "(Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;)V", "mCurrentDegree", "", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "dpVal", "", "enterRoom", "", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "enterRoomFail", "enterRoomSuccess", "exitRoom", "floatMode", "hideMicLayout", "onBackPress", "onOrientationChange", "degree", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "requestStopMic", "resume", "setPreviewTouchListener", "callback", "Lkotlin/Function2;", "x", "y", "setupSwitchCameraBtn", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class bk
  extends a
  implements d.a
{
  public static final bk.a haL;
  private Context context;
  public final LivePreviewView gKW;
  private final b gVv;
  public j haI;
  private com.tencent.mm.plugin.mmsight.model.d haJ;
  private int haK;
  public com.tencent.mm.live.core.core.c.b har;
  
  static
  {
    AppMethodBeat.i(216323);
    haL = new bk.a((byte)0);
    AppMethodBeat.o(216323);
  }
  
  public bk(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216322);
    this.gVv = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307720);
    p.g(paramb, "root.findViewById(R.id.live_preview_view)");
    this.gKW = ((LivePreviewView)paramb);
    this.haK = getCurrentOrientation();
    paramb = com.tencent.mm.live.core.core.c.b.gMM;
    paramViewGroup = paramViewGroup.getContext();
    p.g(paramViewGroup, "root.context");
    this.har = com.tencent.mm.live.core.core.c.b.a.ct(paramViewGroup);
    this.haJ = new com.tencent.mm.plugin.mmsight.model.d(this.context, (byte)0);
    paramViewGroup = this.haJ;
    if (paramViewGroup != null) {
      paramViewGroup.a((d.a)this);
    }
    paramViewGroup = this.haJ;
    if (paramViewGroup != null) {
      paramViewGroup.enable();
    }
    paramViewGroup = new ImageView(this.gJt.getContext());
    paramViewGroup.setImageDrawable(ao.k(this.gJt.getContext(), 2131690362, -1));
    paramb = new RelativeLayout.LayoutParams(aq.fromDPToPix(this.gJt.getContext(), 28), aq.fromDPToPix(this.gJt.getContext(), 28));
    paramb.addRule(21);
    int i = aq.fromDPToPix(this.gJt.getContext(), 4);
    paramViewGroup.setPadding(i, i, i, i);
    RelativeLayout localRelativeLayout = this.gKW.getCameraRootView();
    if (localRelativeLayout != null) {
      localRelativeLayout.addView((View)paramViewGroup, (ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(216322);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(216318);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    g localg;
    switch (bl.cqt[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(216318);
      return;
    case 1: 
    case 2: 
    case 3: 
      paramc = this.haJ;
      if (paramc != null) {
        paramc.disable();
      }
      paramc = this.haJ;
      if (paramc != null) {
        paramc.a(null);
      }
      this.haJ = null;
      exitRoom();
      nL(8);
      AppMethodBeat.o(216318);
      return;
    case 4: 
      if (paramBundle != null) {
        bool1 = paramBundle.getBoolean("PARAM_HANGUP_SELF", false);
      }
      if (bool1)
      {
        paramc = this.har;
        if (paramc != null)
        {
          paramc = paramc.gLc;
          if ((paramc != null) && (paramc.alU() == true)) {
            c.apT();
          }
        }
      }
      for (;;)
      {
        paramc = com.tencent.mm.live.core.core.c.b.gMM;
        paramc = this.gJt.getContext();
        p.g(paramc, "root.context");
        com.tencent.mm.live.core.core.c.b.a.ct(paramc).amw();
        paramc = this.har;
        if (paramc != null)
        {
          paramBundle = com.tencent.mm.cb.a.az(this.context, 2131766707);
          p.g(paramBundle, "ResourceHelper.getString…tring.live_room_mini_mic)");
          paramc.xU(paramBundle);
        }
        paramBundle = this.har;
        paramc = (b.c)localObject;
        if (paramBundle != null) {
          paramc = Integer.valueOf(paramBundle.amt());
        }
        ae.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:".concat(String.valueOf(paramc)));
        this.gKW.post((Runnable)new f(this));
        AppMethodBeat.o(216318);
        return;
        paramc = this.har;
        if (paramc != null)
        {
          paramc = paramc.gLc;
          if ((paramc != null) && (paramc.alT() == true))
          {
            c.apU();
            continue;
            paramc = this.har;
            if (paramc != null)
            {
              paramc = paramc.gLc;
              if ((paramc != null) && (paramc.alU() == true))
              {
                c.apV();
                continue;
              }
            }
            paramc = this.har;
            if (paramc != null)
            {
              paramc = paramc.gLc;
              if ((paramc != null) && (paramc.alT() == true)) {
                c.apW();
              }
            }
          }
        }
      }
    case 5: 
      paramc = this.har;
      if (paramc != null)
      {
        paramBundle = com.tencent.mm.cb.a.az(this.context, 2131766709);
        p.g(paramBundle, "ResourceHelper.getString….live_room_mini_wait_mic)");
        paramc.xU(paramBundle);
        AppMethodBeat.o(216318);
        return;
      }
      AppMethodBeat.o(216318);
      return;
    case 6: 
    case 7: 
      paramc = this.har;
      if (paramc != null)
      {
        paramBundle = com.tencent.mm.cb.a.az(this.context, 2131766706);
        p.g(paramBundle, "ResourceHelper.getString…ring.live_room_mini_live)");
        paramc.xU(paramBundle);
        AppMethodBeat.o(216318);
        return;
      }
      AppMethodBeat.o(216318);
      return;
    case 8: 
      paramBundle = this.haI;
      if (paramBundle != null)
      {
        paramc = this.har;
        if (paramc != null)
        {
          p.h(paramBundle, "surfaceHolder");
          paramc.gKV.amD();
          paramBundle.gOA = ((m)new a.e(paramc, paramBundle));
          localObject = com.tencent.mm.live.core.debug.a.gMY;
          com.tencent.mm.live.core.debug.a.yg("startPreview " + paramBundle + ' ');
          paramBundle = paramc.gLb;
          if (paramBundle == null) {
            break label779;
          }
          paramBundle = paramBundle.gKk;
          if (paramBundle == null) {
            break label779;
          }
          bool1 = paramBundle.gKc;
          paramBundle = paramc.gLb;
          if (paramBundle == null) {
            break label785;
          }
          paramBundle = paramBundle.gKk;
          if (paramBundle == null) {
            break label785;
          }
        }
      }
      for (bool2 = paramBundle.gKd;; bool2 = true)
      {
        paramc.k(bool1, bool2);
        paramBundle = paramc.gLb;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.gKk;
          if ((paramBundle != null) && (paramBundle.gKe == true))
          {
            paramBundle = paramc.gKX;
            if (paramBundle != null) {
              paramBundle.a(paramc.gKV.getFrameDataCallback());
            }
          }
        }
        paramc.gKV.d((d.g.a.b)new a.f(paramc));
        paramc = g.gQZ;
        paramc = g.anC();
        paramBundle = g.gQZ;
        l = g.anH().FKy;
        paramBundle = g.gQZ;
        paramBundle = g.anJ();
        localObject = com.tencent.mm.model.v.aAC();
        p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
        localg = g.gQZ;
        com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 7, 1, (String)localObject, g.anH().GTv);
        AppMethodBeat.o(216318);
        return;
        bool1 = false;
        break;
      }
    case 9: 
      nL(0);
      apr();
      paramc = this.gKW;
      paramBundle = this.gJt.getContext();
      p.g(paramBundle, "root.context");
      paramBundle = paramBundle.getResources();
      p.g(paramBundle, "root.context.resources");
      i = paramBundle.getConfiguration().orientation;
      paramc.gOF.nv(i);
      paramc = com.tencent.mm.live.core.core.trtc.a.a.alY();
      p.g(paramc, "ConfigHelper.getInstance()");
      paramc = paramc.alZ();
      p.g(paramc, "ConfigHelper.getInstance().videoConfig");
      paramBundle = this.context;
      p.g(paramBundle, "context");
      paramBundle = paramBundle.getResources();
      p.g(paramBundle, "context.resources");
      if (paramBundle.getConfiguration().orientation == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramc.dI(bool1);
        paramc = com.tencent.mm.live.core.core.c.b.gMM;
        paramc = this.gJt.getContext();
        p.g(paramc, "root.context");
        com.tencent.mm.live.core.core.c.b.a.ct(paramc).c(this.gKW);
        c.apQ();
        AppMethodBeat.o(216318);
        return;
      }
    case 10: 
      label779:
      label785:
      this.gKW.post((Runnable)new g(this));
      paramc = com.tencent.mm.live.core.core.c.b.gMM;
      paramc = this.gJt.getContext();
      p.g(paramc, "root.context");
      com.tencent.mm.live.core.core.c.b.a.ct(paramc).amw();
      paramc = g.gQZ;
      paramc = g.anC();
      paramBundle = g.gQZ;
      l = g.anH().FKy;
      paramBundle = g.gQZ;
      paramBundle = g.anJ();
      localObject = com.tencent.mm.model.v.aAC();
      p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
      localg = g.gQZ;
      com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 7, 0, (String)localObject, g.anH().GTv);
      AppMethodBeat.o(216318);
      return;
    }
    ae.i("MicroMsg.LiveCoreVisitor", "switchCamera");
    paramc = this.har;
    if (paramc != null) {
      paramc.switchCamera();
    }
    paramc = g.gQZ;
    paramc = g.anC();
    paramBundle = g.gQZ;
    long l = g.anH().FKy;
    paramBundle = g.gQZ;
    paramBundle = g.anJ();
    localObject = com.tencent.mm.live.core.core.trtc.a.a.alY();
    p.g(localObject, "ConfigHelper.getInstance()");
    if (((com.tencent.mm.live.core.core.trtc.a.a)localObject).amc().gLQ == 0) {}
    for (int i = 1;; i = 0)
    {
      localObject = g.gQZ;
      com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 1, i, g.anH().GTv);
      break;
    }
  }
  
  public final void a(com.tencent.mm.live.core.core.b.d paramd, final d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(216315);
    p.h(paramd, "liveRoomModel");
    p.h(paramb, "action");
    com.tencent.mm.live.core.core.c.b localb = this.har;
    if (localb != null) {
      localb.a(paramd);
    }
    paramd = this.har;
    if (paramd != null)
    {
      paramd.a(this.gKW, (com.tencent.mm.live.core.core.b)new b(this, paramb));
      AppMethodBeat.o(216315);
      return;
    }
    AppMethodBeat.o(216315);
  }
  
  public final void aoP()
  {
    AppMethodBeat.i(216320);
    ae.i("MicroMsg.LiveCoreVisitor", "unMount");
    Object localObject = this.har;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).gLc;
      if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).isFloatMode() == true)) {}
    }
    else
    {
      localObject = g.gQZ;
      if (g.anO()) {
        break label120;
      }
      localObject = this.har;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).gLc;
        if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).alU() == true)) {}
      }
      else
      {
        localObject = this.har;
        if (localObject == null) {
          break label120;
        }
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).gLc;
        if ((localObject == null) || (((com.tencent.mm.live.core.core.b.e)localObject).alT() != true)) {
          break label120;
        }
      }
    }
    localObject = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.yg("activity recycler");
    AppMethodBeat.o(216320);
    return;
    label120:
    localObject = this.har;
    if (localObject != null)
    {
      ((com.tencent.mm.live.core.core.c.b)localObject).b((com.tencent.mm.live.core.core.b)new h());
      AppMethodBeat.o(216320);
      return;
    }
    AppMethodBeat.o(216320);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void apr()
  {
    AppMethodBeat.i(216316);
    ViewParent localViewParent = this.gKW.getParent();
    if (localViewParent != null)
    {
      if ((localViewParent instanceof ViewGroup))
      {
        ((ViewGroup)localViewParent).removeView((View)this.gKW);
        ((ViewGroup)localViewParent).addView((View)this.gKW);
      }
      AppMethodBeat.o(216316);
      return;
    }
    AppMethodBeat.o(216316);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(216317);
    p.h(paramString, "userId");
    this.gKW.c(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(216317);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(216314);
    com.tencent.mm.live.core.core.c.b localb = this.har;
    if (localb != null)
    {
      localb.b((com.tencent.mm.live.core.core.b)new c());
      AppMethodBeat.o(216314);
      return;
    }
    AppMethodBeat.o(216314);
  }
  
  public final void nO(int paramInt)
  {
    AppMethodBeat.i(216321);
    Object localObject1 = g.gQZ;
    paramInt = g.aoo();
    localObject1 = this.gJt.getResources();
    p.g(localObject1, "root.resources");
    if (paramInt != ((Resources)localObject1).getConfiguration().orientation)
    {
      localObject1 = this.gJt.getResources();
      p.g(localObject1, "root.resources");
      if (((Resources)localObject1).getConfiguration().orientation != 1)
      {
        localObject1 = this.gJt.getResources();
        p.g(localObject1, "root.resources");
        if (((Resources)localObject1).getConfiguration().orientation != 2) {}
      }
      else
      {
        localObject1 = g.gQZ;
        localObject1 = this.gJt.getResources();
        p.g(localObject1, "root.resources");
        g.nH(((Resources)localObject1).getConfiguration().orientation);
        localObject1 = g.gQZ;
        localObject1 = g.anC();
        Object localObject2 = g.gQZ;
        long l = g.anH().FKy;
        localObject2 = g.gQZ;
        localObject2 = g.anJ();
        g localg = g.gQZ;
        if (g.aoo() == 1) {}
        for (paramInt = 0;; paramInt = 1)
        {
          localg = g.gQZ;
          com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 5, paramInt, g.anH().GTv);
          localObject1 = g.gQZ;
          if (g.aoo() != 1) {
            break;
          }
          f.aqy();
          AppMethodBeat.o(216321);
          return;
        }
        f.aqx();
        AppMethodBeat.o(216321);
        return;
      }
    }
    if (this.haK != getCurrentOrientation())
    {
      this.haK = getCurrentOrientation();
      b.b.a(this.gVv, b.c.gVc);
    }
    AppMethodBeat.o(216321);
  }
  
  public final void pause() {}
  
  public final void resume()
  {
    AppMethodBeat.i(216319);
    Object localObject = g.gQZ;
    if (g.anQ() != -1)
    {
      localObject = this.context.getSystemService("window");
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(216319);
        throw ((Throwable)localObject);
      }
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.g(localObject, "((context.getSystemServi…owManager).defaultDisplay");
      int i = ((Display)localObject).getRotation();
      localObject = g.gQZ;
      if (i != g.anQ())
      {
        localObject = this.har;
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject).b(this.gKW);
        }
        this.gKW.getRenderLayout().post((Runnable)new d(this));
      }
    }
    AppMethodBeat.o(216319);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.live.core.core.b
  {
    b(d.g.a.b paramb) {}
    
    public final void f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(216307);
      if (paramInt >= 0)
      {
        bk.aps();
        paramb.invoke(Boolean.TRUE);
        AppMethodBeat.o(216307);
        return;
      }
      bk.apt();
      paramb.invoke(Boolean.FALSE);
      AppMethodBeat.o(216307);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$exitRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class c
    implements com.tencent.mm.live.core.core.b
  {
    public final void f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(216308);
      ae.i("MicroMsg.LiveCoreVisitor", "on exit room finish");
      AppMethodBeat.o(216308);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(bk parambk) {}
    
    public final void run()
    {
      AppMethodBeat.i(216309);
      LivePreviewView localLivePreviewView = bk.b(this.haM);
      localLivePreviewView.gOF.nu(localLivePreviewView.gOF.getRemoteViewIndex());
      AppMethodBeat.o(216309);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(bk parambk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216310);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$setupSwitchCameraBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      b.b.a(bk.a(this.haM), b.c.gUf);
      paramView = g.gQZ;
      paramView = g.anL();
      if (paramView != null)
      {
        paramView = paramView.gKk;
        if (paramView != null)
        {
          localObject = g.gQZ;
          localObject = g.anL();
          if (localObject == null) {
            break label123;
          }
          localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gKk;
          if (localObject == null) {
            break label123;
          }
          bool = ((com.tencent.mm.live.core.core.b.b)localObject).gKd;
          if (bool) {
            break label128;
          }
        }
      }
      label128:
      for (boolean bool = true;; bool = false)
      {
        paramView.gKd = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$setupSwitchCameraBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216310);
        return;
        label123:
        bool = true;
        break;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(bk parambk) {}
    
    public final void run()
    {
      AppMethodBeat.i(216311);
      bk.b(this.haM).gOF.ana();
      AppMethodBeat.o(216311);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(bk parambk) {}
    
    public final void run()
    {
      AppMethodBeat.i(216312);
      bk.b(this.haM).gOF.ana();
      AppMethodBeat.o(216312);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$unMount$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class h
    implements com.tencent.mm.live.core.core.b
  {
    public final void f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(216313);
      ae.i("MicroMsg.LiveCoreVisitor", "on exitRoom finish");
      paramBundle = com.tencent.mm.live.core.core.a.b.gJU;
      com.tencent.mm.live.core.core.a.b.a.releaseInstance();
      AppMethodBeat.o(216313);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.bk
 * JD-Core Version:    0.7.0.1
 */