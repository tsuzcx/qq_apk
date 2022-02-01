package com.tencent.mm.live.b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
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
import com.tencent.mm.live.c.e;
import com.tencent.mm.live.core.b.k;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.live.core.core.model.i;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a.a;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.live.model.u;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "mCameraRenderHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "getMCameraRenderHolder", "()Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "setMCameraRenderHolder", "(Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;)V", "mCurrentDegree", "", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "dpVal", "", "enterRoom", "", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "enterRoomFail", "enterRoomSuccess", "exitRoom", "hideMicLayout", "onBackPress", "onOrientationChange", "degree", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "requestStopMic", "resume", "setPreviewTouchListener", "callback", "Lkotlin/Function2;", "x", "y", "setupSwitchCameraBtn", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
  extends a
  implements com.tencent.mm.plugin.mmsight.model.d.a
{
  public static final ah.a nkD;
  private Context context;
  public com.tencent.mm.live.core.core.f.d liveCore;
  public final LivePreviewView mRt;
  private final b nfT;
  public k nkE;
  private int nkF;
  private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  
  static
  {
    AppMethodBeat.i(247481);
    nkD = new ah.a((byte)0);
    AppMethodBeat.o(247481);
  }
  
  public ah(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247433);
    this.nfT = paramb;
    this.context = paramViewGroup.getContext();
    paramViewGroup = paramViewGroup.findViewById(b.e.live_preview_view);
    s.s(paramViewGroup, "root.findViewById(R.id.live_preview_view)");
    this.mRt = ((LivePreviewView)paramViewGroup);
    this.nkF = getCurrentOrientation();
    paramViewGroup = com.tencent.mm.live.core.core.f.d.mUj;
    this.liveCore = com.tencent.mm.live.core.core.f.d.a.bfM();
    this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(this.context, (byte)0);
    paramViewGroup = this.orientationEventListener;
    if (paramViewGroup != null) {
      paramViewGroup.KUU = ((com.tencent.mm.plugin.mmsight.model.d.a)this);
    }
    paramViewGroup = this.orientationEventListener;
    if (paramViewGroup != null) {
      paramViewGroup.enable();
    }
    paramViewGroup = new ImageView(this.mJe.getContext());
    paramViewGroup.setImageDrawable(bb.m(this.mJe.getContext(), b.g.icons_filled_camera_switch, -1));
    paramb = new RelativeLayout.LayoutParams(bd.fromDPToPix(this.mJe.getContext(), 28), bd.fromDPToPix(this.mJe.getContext(), 28));
    paramb.addRule(21);
    int i = bd.fromDPToPix(this.mJe.getContext(), 4);
    paramViewGroup.setPadding(i, i, i, i);
    RelativeLayout localRelativeLayout = this.mRt.getCameraRootView();
    if (localRelativeLayout != null) {
      localRelativeLayout.addView((View)paramViewGroup, (ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup.setOnClickListener(new ah..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(247433);
  }
  
  private static final void a(ah paramah)
  {
    AppMethodBeat.i(247455);
    s.u(paramah, "this$0");
    paramah.mRt.bgZ();
    AppMethodBeat.o(247455);
  }
  
  private static final void a(ah paramah, View paramView)
  {
    AppMethodBeat.i(247448);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramah);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramah, "this$0");
    b.b.a(paramah.nfT, b.c.ncm);
    paramah = u.mZl;
    paramah = u.bii();
    if (paramah == null)
    {
      paramah = null;
      if (paramah != null)
      {
        paramView = u.mZl;
        paramView = u.bii();
        if (paramView != null) {
          break label153;
        }
        bool = true;
        label105:
        if (bool) {
          break label175;
        }
      }
    }
    label153:
    label175:
    for (boolean bool = true;; bool = false)
    {
      paramah.mNj = bool;
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247448);
      return;
      paramah = paramah.mNB;
      break;
      paramView = paramView.mNB;
      if (paramView == null)
      {
        bool = true;
        break label105;
      }
      bool = paramView.mNj;
      break label105;
    }
  }
  
  private static final void b(ah paramah)
  {
    AppMethodBeat.i(247458);
    s.u(paramah, "this$0");
    paramah.mRt.bgZ();
    AppMethodBeat.o(247458);
  }
  
  private static final void c(ah paramah)
  {
    AppMethodBeat.i(247462);
    s.u(paramah, "this$0");
    paramah = paramah.mRt;
    paramah.mWP.tz(paramah.mWP.getRemoteViewIndex());
    AppMethodBeat.o(247462);
  }
  
  public final void a(h paramh, final kotlin.g.a.b<? super Boolean, kotlin.ah> paramb)
  {
    AppMethodBeat.i(247502);
    s.u(paramh, "liveRoomModel");
    s.u(paramb, "action");
    com.tencent.mm.live.core.core.f.d locald = this.liveCore;
    if (locald != null) {
      locald.a(paramh);
    }
    paramh = this.liveCore;
    if (paramh != null) {
      paramh.a(this.mRt, (com.tencent.mm.live.core.core.c)new c(this, paramb));
    }
    AppMethodBeat.o(247502);
  }
  
  public final void bjr()
  {
    AppMethodBeat.i(247503);
    ViewParent localViewParent = this.mRt.getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
    {
      ((ViewGroup)localViewParent).removeView((View)this.mRt);
      ((ViewGroup)localViewParent).addView((View)this.mRt);
    }
    AppMethodBeat.o(247503);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(247506);
    s.u(paramString, "userId");
    this.mRt.c(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(247506);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(247500);
    com.tencent.mm.live.core.core.f.d locald = this.liveCore;
    if (locald != null) {
      locald.b((com.tencent.mm.live.core.core.c)new ah.d());
    }
    AppMethodBeat.o(247500);
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(247576);
    Object localObject1 = u.mZl;
    if ((u.biJ() != this.mJe.getResources().getConfiguration().orientation) && ((this.mJe.getResources().getConfiguration().orientation == 1) || (this.mJe.getResources().getConfiguration().orientation == 2)))
    {
      localObject1 = u.mZl;
      u.tM(this.mJe.getResources().getConfiguration().orientation);
      localObject1 = u.mZl;
      localObject1 = u.bhZ();
      Object localObject2 = u.mZl;
      long l = u.bie().mMJ;
      localObject2 = u.mZl;
      localObject2 = u.big();
      u localu = u.mZl;
      if (u.biJ() == 1) {}
      for (paramInt = 0;; paramInt = 1)
      {
        localu = u.mZl;
        e.a((String)localObject1, l, (String)localObject2, 5, paramInt, u.bie().ZWw);
        localObject1 = u.mZl;
        if (u.biJ() != 1) {
          break;
        }
        com.tencent.mm.live.c.f.bkH();
        AppMethodBeat.o(247576);
        return;
      }
      com.tencent.mm.live.c.f.bkG();
      AppMethodBeat.o(247576);
      return;
    }
    if (this.nkF != getCurrentOrientation())
    {
      this.nkF = getCurrentOrientation();
      b.b.a(this.nfT, b.c.ndm);
    }
    AppMethodBeat.o(247576);
  }
  
  public final void pause() {}
  
  public final void resume()
  {
    AppMethodBeat.i(247537);
    Object localObject = u.mZl;
    if (u.getLastOrientation() != -1)
    {
      localObject = this.context.getSystemService("window");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(247537);
        throw ((Throwable)localObject);
      }
      int i = ((WindowManager)localObject).getDefaultDisplay().getRotation();
      localObject = u.mZl;
      if (i != u.getLastOrientation())
      {
        localObject = this.liveCore;
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject).mRt = this.mRt;
        }
        this.mRt.getRenderLayout().post(new ah..ExternalSyntheticLambda3(this));
      }
    }
    AppMethodBeat.o(247537);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    int k = 1;
    boolean bool = true;
    int j = 1;
    AppMethodBeat.i(247526);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    label192:
    label362:
    u localu;
    switch (ah.b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(247526);
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
        paramc.KUU = null;
      }
      this.orientationEventListener = null;
      exitRoom();
      tO(8);
      AppMethodBeat.o(247526);
      return;
    case 4: 
      if (paramBundle == null)
      {
        bool = false;
        if (!bool) {
          break label319;
        }
        paramc = this.liveCore;
        if (paramc == null) {
          break label270;
        }
        paramc = paramc.mRB;
        if ((paramc == null) || (paramc.beu() != true)) {
          break label270;
        }
        i = 1;
        if (i == 0) {
          break label275;
        }
        com.tencent.mm.live.c.c.bkd();
        paramc = com.tencent.mm.live.core.core.f.d.mUj;
        com.tencent.mm.live.core.core.f.d.a.bfM().bfJ();
        paramc = this.liveCore;
        if (paramc != null) {
          break label406;
        }
      }
      for (paramc = (b.c)localObject;; paramc = Integer.valueOf(paramc.bfG()))
      {
        Log.i("MicroMsg.LiveCoreVisitor", s.X("requestLinkMic ret:", paramc));
        this.mRt.post(new ah..ExternalSyntheticLambda2(this));
        AppMethodBeat.o(247526);
        return;
        bool = paramBundle.getBoolean("PARAM_HANGUP_SELF", false);
        break;
        i = 0;
        break label192;
        paramc = this.liveCore;
        if (paramc != null)
        {
          paramc = paramc.mRB;
          if ((paramc == null) || (paramc.bet() != true)) {}
        }
        for (i = j; i != 0; i = 0)
        {
          com.tencent.mm.live.c.c.bke();
          break;
        }
        paramc = this.liveCore;
        if (paramc != null)
        {
          paramc = paramc.mRB;
          if ((paramc == null) || (paramc.beu() != true)) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label362;
          }
          com.tencent.mm.live.c.c.bkf();
          break;
        }
        paramc = this.liveCore;
        if (paramc != null)
        {
          paramc = paramc.mRB;
          if ((paramc == null) || (paramc.bet() != true)) {}
        }
        for (i = k; i != 0; i = 0)
        {
          com.tencent.mm.live.c.c.bkg();
          break;
        }
      }
    case 5: 
      AppMethodBeat.o(247526);
      return;
    case 6: 
    case 7: 
      AppMethodBeat.o(247526);
      return;
    case 8: 
      paramc = this.nkE;
      if (paramc != null)
      {
        paramBundle = this.liveCore;
        if (paramBundle != null) {
          paramBundle.a(paramc);
        }
      }
      paramc = u.mZl;
      paramc = u.bhZ();
      paramBundle = u.mZl;
      l = u.bie().mMJ;
      paramBundle = u.mZl;
      paramBundle = u.big();
      localObject = z.bAM();
      s.s(localObject, "getUsernameFromUserInfo()");
      localu = u.mZl;
      e.a(paramc, l, paramBundle, 7, 1, (String)localObject, u.bie().ZWw);
      AppMethodBeat.o(247526);
      return;
    case 9: 
      tO(0);
      bjr();
      this.mRt.ty(this.mJe.getContext().getResources().getConfiguration().orientation);
      paramc = a.a.bfr().bfn();
      if (this.context.getResources().getConfiguration().orientation == 1) {}
      for (;;)
      {
        paramc.mTf = bool;
        paramc = com.tencent.mm.live.core.core.f.d.mUj;
        com.tencent.mm.live.core.core.f.d.a.bfM().b(this.mRt);
        com.tencent.mm.live.c.c.bka();
        AppMethodBeat.o(247526);
        return;
        bool = false;
      }
    case 10: 
      label270:
      label275:
      label319:
      this.mRt.post(new ah..ExternalSyntheticLambda1(this));
      label406:
      paramc = com.tencent.mm.live.core.core.f.d.mUj;
      com.tencent.mm.live.core.core.f.d.a.bfM().bfJ();
      paramc = u.mZl;
      paramc = u.bhZ();
      paramBundle = u.mZl;
      l = u.bie().mMJ;
      paramBundle = u.mZl;
      paramBundle = u.big();
      localObject = z.bAM();
      s.s(localObject, "getUsernameFromUserInfo()");
      localu = u.mZl;
      e.a(paramc, l, paramBundle, 7, 0, (String)localObject, u.bie().ZWw);
      AppMethodBeat.o(247526);
      return;
    }
    Log.i("MicroMsg.LiveCoreVisitor", "switchCamera");
    paramc = this.liveCore;
    if (paramc != null) {
      paramc.switchCamera();
    }
    paramc = u.mZl;
    paramc = u.bhZ();
    paramBundle = u.mZl;
    long l = u.bie().mMJ;
    paramBundle = u.mZl;
    paramBundle = u.big();
    if (a.a.bfr().bfq().cameraId == 0) {}
    for (int i = 1;; i = 0)
    {
      localObject = u.mZl;
      e.a(paramc, l, paramBundle, 1, i, u.bie().ZWw);
      break;
    }
  }
  
  public final void unMount()
  {
    int j = 1;
    AppMethodBeat.i(247557);
    Log.i("MicroMsg.LiveCoreVisitor", "unMount");
    Object localObject = this.liveCore;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
      if ((localObject != null) && (((i)localObject).isFloatMode() == true))
      {
        i = 1;
        if (i == 0)
        {
          localObject = u.mZl;
          if (u.isManualClosed()) {
            break label155;
          }
          localObject = this.liveCore;
          if (localObject == null) {
            break label145;
          }
          localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
          if ((localObject == null) || (((i)localObject).beu() != true)) {
            break label145;
          }
          i = 1;
          label87:
          if (i == 0)
          {
            localObject = this.liveCore;
            if (localObject == null) {
              break label150;
            }
            localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
            if ((localObject == null) || (((i)localObject).bet() != true)) {
              break label150;
            }
          }
        }
      }
    }
    label145:
    label150:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label155;
      }
      localObject = com.tencent.mm.live.core.debug.a.mUy;
      com.tencent.mm.live.core.debug.a.Ga("activity recycler");
      AppMethodBeat.o(247557);
      return;
      i = 0;
      break;
      i = 0;
      break label87;
    }
    label155:
    localObject = this.liveCore;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.f.d)localObject).b((com.tencent.mm.live.core.core.c)new e());
    }
    AppMethodBeat.o(247557);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.live.core.core.c
  {
    c(ah paramah, kotlin.g.a.b<? super Boolean, kotlin.ah> paramb) {}
    
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(247358);
      if (paramInt >= 0)
      {
        ah.bjC();
        paramb.invoke(Boolean.TRUE);
        AppMethodBeat.o(247358);
        return;
      }
      ah.bjD();
      paramb.invoke(Boolean.FALSE);
      AppMethodBeat.o(247358);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$unMount$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(247351);
      Log.i("MicroMsg.LiveCoreVisitor", "on exitRoom finish");
      paramBundle = com.tencent.mm.live.core.core.a.b.mMo;
      b.a.fF(false);
      AppMethodBeat.o(247351);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.ah
 * JD-Core Version:    0.7.0.1
 */