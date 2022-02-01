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
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.v;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "mCameraRenderHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "getMCameraRenderHolder", "()Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "setMCameraRenderHolder", "(Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;)V", "mCurrentDegree", "", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "dpVal", "", "enterRoom", "", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "enterRoomFail", "enterRoomSuccess", "exitRoom", "floatMode", "hideMicLayout", "onBackPress", "onOrientationChange", "degree", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "requestStopMic", "resume", "setPreviewTouchListener", "callback", "Lkotlin/Function2;", "x", "y", "setupSwitchCameraBtn", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class bk
  extends a
  implements d.a
{
  public static final bk.a gEp;
  private Context context;
  public com.tencent.mm.live.core.core.c.b gDV;
  public j gEm;
  private com.tencent.mm.plugin.mmsight.model.d gEn;
  private int gEo;
  public final LivePreviewView goF;
  private final b gzb;
  
  static
  {
    AppMethodBeat.i(190405);
    gEp = new bk.a((byte)0);
    AppMethodBeat.o(190405);
  }
  
  public bk(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190404);
    this.gzb = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307720);
    k.g(paramb, "root.findViewById(R.id.live_preview_view)");
    this.goF = ((LivePreviewView)paramb);
    this.gEo = getCurrentOrientation();
    paramb = com.tencent.mm.live.core.core.c.b.gqt;
    paramViewGroup = paramViewGroup.getContext();
    k.g(paramViewGroup, "root.context");
    this.gDV = com.tencent.mm.live.core.core.c.b.a.cu(paramViewGroup);
    this.gEn = new com.tencent.mm.plugin.mmsight.model.d(this.context, (byte)0);
    paramViewGroup = this.gEn;
    if (paramViewGroup != null) {
      paramViewGroup.a((d.a)this);
    }
    paramViewGroup = this.gEn;
    if (paramViewGroup != null) {
      paramViewGroup.enable();
    }
    paramViewGroup = new ImageView(this.gnb.getContext());
    paramViewGroup.setImageDrawable(am.k(this.gnb.getContext(), 2131690362, -1));
    paramb = new RelativeLayout.LayoutParams(ao.fromDPToPix(this.gnb.getContext(), 28), ao.fromDPToPix(this.gnb.getContext(), 28));
    paramb.addRule(21);
    int i = ao.fromDPToPix(this.gnb.getContext(), 4);
    paramViewGroup.setPadding(i, i, i, i);
    RelativeLayout localRelativeLayout = this.goF.getCameraRootView();
    if (localRelativeLayout != null) {
      localRelativeLayout.addView((View)paramViewGroup, (ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(190404);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(190400);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (bl.cfA[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(190400);
      return;
    case 1: 
    case 2: 
    case 3: 
      paramc = this.gEn;
      if (paramc != null) {
        paramc.disable();
      }
      paramc = this.gEn;
      if (paramc != null) {
        paramc.a(null);
      }
      this.gEn = null;
      exitRoom();
      nj(8);
      AppMethodBeat.o(190400);
      return;
    case 4: 
      if (paramBundle != null) {
        bool1 = paramBundle.getBoolean("PARAM_HANGUP_SELF", false);
      }
      if (bool1)
      {
        paramc = this.gDV;
        if (paramc != null)
        {
          paramc = paramc.goL;
          if ((paramc != null) && (paramc.aiT() == true)) {
            c.amS();
          }
        }
      }
      for (;;)
      {
        paramc = com.tencent.mm.live.core.core.c.b.gqt;
        paramc = this.gnb.getContext();
        k.g(paramc, "root.context");
        com.tencent.mm.live.core.core.c.b.a.cu(paramc).ajv();
        paramc = this.gDV;
        if (paramc != null)
        {
          paramBundle = com.tencent.mm.cc.a.aw(this.context, 2131766707);
          k.g(paramBundle, "ResourceHelper.getString…tring.live_room_mini_mic)");
          paramc.uv(paramBundle);
        }
        paramBundle = this.gDV;
        paramc = (b.c)localObject;
        if (paramBundle != null) {
          paramc = Integer.valueOf(paramBundle.ajs());
        }
        ac.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:".concat(String.valueOf(paramc)));
        this.goF.gso.ajZ();
        AppMethodBeat.o(190400);
        return;
        paramc = this.gDV;
        if (paramc != null)
        {
          paramc = paramc.goL;
          if ((paramc != null) && (paramc.aiS() == true))
          {
            c.amT();
            continue;
            paramc = this.gDV;
            if (paramc != null)
            {
              paramc = paramc.goL;
              if ((paramc != null) && (paramc.aiT() == true))
              {
                c.amU();
                continue;
              }
            }
            paramc = this.gDV;
            if (paramc != null)
            {
              paramc = paramc.goL;
              if ((paramc != null) && (paramc.aiS() == true)) {
                c.amV();
              }
            }
          }
        }
      }
    case 5: 
      paramc = this.gDV;
      if (paramc != null)
      {
        paramBundle = com.tencent.mm.cc.a.aw(this.context, 2131766709);
        k.g(paramBundle, "ResourceHelper.getString….live_room_mini_wait_mic)");
        paramc.uv(paramBundle);
        AppMethodBeat.o(190400);
        return;
      }
      AppMethodBeat.o(190400);
      return;
    case 6: 
    case 7: 
      paramc = this.gDV;
      if (paramc != null)
      {
        paramBundle = com.tencent.mm.cc.a.aw(this.context, 2131766706);
        k.g(paramBundle, "ResourceHelper.getString…ring.live_room_mini_live)");
        paramc.uv(paramBundle);
        AppMethodBeat.o(190400);
        return;
      }
      AppMethodBeat.o(190400);
      return;
    case 8: 
      paramBundle = this.gEm;
      if (paramBundle != null)
      {
        paramc = this.gDV;
        if (paramc != null)
        {
          k.h(paramBundle, "surfaceHolder");
          paramc.goE.ajC();
          paramBundle.gsj = ((m)new a.e(paramc, paramBundle));
          localObject = com.tencent.mm.live.core.debug.a.gqF;
          com.tencent.mm.live.core.debug.a.uG("startPreview " + paramBundle + ' ');
          paramBundle = paramc.goK;
          if (paramBundle == null) {
            break label759;
          }
          paramBundle = paramBundle.gnS;
          if (paramBundle == null) {
            break label759;
          }
          bool1 = paramBundle.gnK;
          paramBundle = paramc.goK;
          if (paramBundle == null) {
            break label765;
          }
          paramBundle = paramBundle.gnS;
          if (paramBundle == null) {
            break label765;
          }
        }
      }
      for (bool2 = paramBundle.gnL;; bool2 = true)
      {
        paramc.k(bool1, bool2);
        paramBundle = paramc.goK;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.gnS;
          if ((paramBundle != null) && (paramBundle.gnM == true))
          {
            paramBundle = paramc.goG;
            if (paramBundle != null) {
              paramBundle.a(paramc.goE.getFrameDataCallback());
            }
          }
        }
        paramc.goE.c((d.g.a.b)new a.f(paramc));
        paramc = g.guG;
        paramc = g.akA();
        paramBundle = g.guG;
        l = g.akF().DMV;
        paramBundle = g.guG;
        paramBundle = g.akH();
        localObject = u.axw();
        k.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
        com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 7, 1, (String)localObject);
        AppMethodBeat.o(190400);
        return;
        bool1 = false;
        break;
      }
    case 9: 
      nj(0);
      amq();
      paramc = this.goF;
      paramBundle = this.gnb.getContext();
      k.g(paramBundle, "root.context");
      paramBundle = paramBundle.getResources();
      k.g(paramBundle, "root.context.resources");
      i = paramBundle.getConfiguration().orientation;
      paramc.gso.mT(i);
      paramc = com.tencent.mm.live.core.core.trtc.a.a.aiX();
      k.g(paramc, "ConfigHelper.getInstance()");
      paramc = paramc.aiY();
      k.g(paramc, "ConfigHelper.getInstance().videoConfig");
      paramBundle = this.context;
      k.g(paramBundle, "context");
      paramBundle = paramBundle.getResources();
      k.g(paramBundle, "context.resources");
      if (paramBundle.getConfiguration().orientation == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramc.dF(bool1);
        paramc = com.tencent.mm.live.core.core.c.b.gqt;
        paramc = this.gnb.getContext();
        k.g(paramc, "root.context");
        com.tencent.mm.live.core.core.c.b.a.cu(paramc).c(this.goF);
        c.amP();
        AppMethodBeat.o(190400);
        return;
      }
    case 10: 
      label759:
      label765:
      this.goF.gso.ajZ();
      paramc = com.tencent.mm.live.core.core.c.b.gqt;
      paramc = this.gnb.getContext();
      k.g(paramc, "root.context");
      com.tencent.mm.live.core.core.c.b.a.cu(paramc).ajv();
      paramc = g.guG;
      paramc = g.akA();
      paramBundle = g.guG;
      l = g.akF().DMV;
      paramBundle = g.guG;
      paramBundle = g.akH();
      localObject = u.axw();
      k.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
      com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 7, 0, (String)localObject);
      AppMethodBeat.o(190400);
      return;
    }
    ac.i("MicroMsg.LiveCoreVisitor", "switchCamera");
    paramc = this.gDV;
    if (paramc != null) {
      paramc.switchCamera();
    }
    paramc = g.guG;
    paramc = g.akA();
    paramBundle = g.guG;
    long l = g.akF().DMV;
    paramBundle = g.guG;
    paramBundle = g.akH();
    localObject = com.tencent.mm.live.core.core.trtc.a.a.aiX();
    k.g(localObject, "ConfigHelper.getInstance()");
    if (((com.tencent.mm.live.core.core.trtc.a.a)localObject).ajb().gpy == 0) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.live.d.e.a(paramc, l, paramBundle, 1, i);
      break;
    }
  }
  
  public final void a(com.tencent.mm.live.core.core.b.d paramd, final d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(190397);
    k.h(paramd, "liveRoomModel");
    k.h(paramb, "action");
    com.tencent.mm.live.core.core.c.b localb = this.gDV;
    if (localb != null) {
      localb.a(paramd);
    }
    paramd = this.gDV;
    if (paramd != null)
    {
      paramd.a(this.goF, (com.tencent.mm.live.core.core.b)new b(this, paramb));
      AppMethodBeat.o(190397);
      return;
    }
    AppMethodBeat.o(190397);
  }
  
  public final void alN()
  {
    AppMethodBeat.i(190402);
    ac.i("MicroMsg.LiveCoreVisitor", "unMount");
    Object localObject = this.gDV;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).goL;
      if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).isFloatMode() == true)) {}
    }
    else
    {
      localObject = g.guG;
      if (g.akM()) {
        break label120;
      }
      localObject = this.gDV;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).goL;
        if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).aiT() == true)) {}
      }
      else
      {
        localObject = this.gDV;
        if (localObject == null) {
          break label120;
        }
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).goL;
        if ((localObject == null) || (((com.tencent.mm.live.core.core.b.e)localObject).aiS() != true)) {
          break label120;
        }
      }
    }
    localObject = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.uG("activity recycler");
    AppMethodBeat.o(190402);
    return;
    label120:
    localObject = this.gDV;
    if (localObject != null)
    {
      ((com.tencent.mm.live.core.core.c.b)localObject).b((com.tencent.mm.live.core.core.b)new f());
      AppMethodBeat.o(190402);
      return;
    }
    AppMethodBeat.o(190402);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void amq()
  {
    AppMethodBeat.i(190398);
    ViewParent localViewParent = this.goF.getParent();
    if (localViewParent != null)
    {
      if ((localViewParent instanceof ViewGroup))
      {
        ((ViewGroup)localViewParent).removeView((View)this.goF);
        ((ViewGroup)localViewParent).addView((View)this.goF);
      }
      AppMethodBeat.o(190398);
      return;
    }
    AppMethodBeat.o(190398);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(190399);
    k.h(paramString, "userId");
    this.goF.c(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(190399);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(190396);
    com.tencent.mm.live.core.core.c.b localb = this.gDV;
    if (localb != null)
    {
      localb.b((com.tencent.mm.live.core.core.b)new bk.c());
      AppMethodBeat.o(190396);
      return;
    }
    AppMethodBeat.o(190396);
  }
  
  public final void nm(int paramInt)
  {
    AppMethodBeat.i(190403);
    Object localObject1 = g.guG;
    paramInt = g.alm();
    localObject1 = this.gnb.getResources();
    k.g(localObject1, "root.resources");
    if (paramInt != ((Resources)localObject1).getConfiguration().orientation)
    {
      localObject1 = this.gnb.getResources();
      k.g(localObject1, "root.resources");
      if (((Resources)localObject1).getConfiguration().orientation != 1)
      {
        localObject1 = this.gnb.getResources();
        k.g(localObject1, "root.resources");
        if (((Resources)localObject1).getConfiguration().orientation != 2) {}
      }
      else
      {
        localObject1 = g.guG;
        localObject1 = this.gnb.getResources();
        k.g(localObject1, "root.resources");
        g.nf(((Resources)localObject1).getConfiguration().orientation);
        localObject1 = g.guG;
        localObject1 = g.akA();
        Object localObject2 = g.guG;
        long l = g.akF().DMV;
        localObject2 = g.guG;
        localObject2 = g.akH();
        g localg = g.guG;
        if (g.alm() == 1) {}
        for (paramInt = 0;; paramInt = 1)
        {
          com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 5, paramInt);
          localObject1 = g.guG;
          if (g.alm() != 1) {
            break;
          }
          f.anx();
          AppMethodBeat.o(190403);
          return;
        }
        f.anw();
        AppMethodBeat.o(190403);
        return;
      }
    }
    if (this.gEo != getCurrentOrientation())
    {
      this.gEo = getCurrentOrientation();
      b.b.a(this.gzb, b.c.gyJ);
    }
    AppMethodBeat.o(190403);
  }
  
  public final void pause() {}
  
  public final void resume()
  {
    AppMethodBeat.i(190401);
    Object localObject = g.guG;
    if (g.akO() != -1)
    {
      localObject = this.context.getSystemService("window");
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(190401);
        throw ((Throwable)localObject);
      }
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      k.g(localObject, "((context.getSystemServi…owManager).defaultDisplay");
      int i = ((Display)localObject).getRotation();
      localObject = g.guG;
      if (i != g.akO())
      {
        localObject = this.gDV;
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject).b(this.goF);
        }
        this.goF.getRenderLayout().post((Runnable)new d(this));
      }
    }
    AppMethodBeat.o(190401);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.live.core.core.b
  {
    b(d.g.a.b paramb) {}
    
    public final void f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(190391);
      if (paramInt >= 0)
      {
        bk.amr();
        paramb.ay(Boolean.TRUE);
        AppMethodBeat.o(190391);
        return;
      }
      bk.ams();
      paramb.ay(Boolean.FALSE);
      AppMethodBeat.o(190391);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(bk parambk) {}
    
    public final void run()
    {
      AppMethodBeat.i(190393);
      LivePreviewView localLivePreviewView = bk.b(this.gEq);
      localLivePreviewView.gso.mS(localLivePreviewView.gso.getRemoteViewIndex());
      AppMethodBeat.o(190393);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(bk parambk) {}
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(190394);
      b.b.a(bk.a(this.gEq), b.c.gxM);
      paramView = g.guG;
      paramView = g.akJ();
      if (paramView != null)
      {
        paramView = paramView.gnS;
        if (paramView != null)
        {
          Object localObject = g.guG;
          localObject = g.akJ();
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gnS;
            if (localObject != null)
            {
              bool1 = ((com.tencent.mm.live.core.core.b.b)localObject).gnL;
              if (bool1) {
                break label96;
              }
            }
          }
          label96:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            paramView.gnL = bool1;
            AppMethodBeat.o(190394);
            return;
            bool1 = true;
            break;
          }
        }
      }
      AppMethodBeat.o(190394);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$unMount$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class f
    implements com.tencent.mm.live.core.core.b
  {
    public final void f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(190395);
      ac.i("MicroMsg.LiveCoreVisitor", "on exitRoom finish");
      paramBundle = com.tencent.mm.live.core.core.a.b.gnC;
      com.tencent.mm.live.core.core.a.b.a.releaseInstance();
      AppMethodBeat.o(190395);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.bk
 * JD-Core Version:    0.7.0.1
 */