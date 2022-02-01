package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.b.k;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.model.i;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager.b;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "VideoLinkBottomBar", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "mCameraRenderHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "getMCameraRenderHolder", "()Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "setMCameraRenderHolder", "(Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;)V", "mCurrentDegree", "", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "bringToFront", "", "userId", "", "streamType", "canClearScreenWhenSideBarShow", "", "dp2px", "dpVal", "", "enterRoom", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "enterRoomFail", "enterRoomSuccess", "exitRoom", "getPreview", "Landroid/view/View;", "getPreviewLayout", "micUserWaitingState", "type", "notifyLinkMicMode", "micUserMap", "Ljava/util/HashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/HashMap;", "notifyNormalMode", "onBackPress", "onMicUserChanged", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "orientationChanged", "orientation", "pause", "refreshCameraView", "refreshPreviewView", "resume", "setVisible", "visible", "setupSwitchCameraBtn", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "updateOutputSurface", "updatePreview", "visibleInCurrentLiveMode", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ct
  extends b
{
  public static final ct.a DmF;
  private Context context;
  public final LivePreviewView mRt;
  private final com.tencent.mm.live.b.b nfT;
  private k nkE;
  private int nkF;
  
  static
  {
    AppMethodBeat.i(354736);
    DmF = new ct.a((byte)0);
    AppMethodBeat.o(354736);
  }
  
  public ct(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354712);
    this.nfT = paramb;
    this.context = paramViewGroup.getContext();
    paramViewGroup = paramViewGroup.findViewById(p.e.live_preview_view);
    s.s(paramViewGroup, "root.findViewById(R.id.live_preview_view)");
    this.mRt = ((LivePreviewView)paramViewGroup);
    this.nkF = getCurrentOrientation();
    AppMethodBeat.o(354712);
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(354868);
    s.u(paramLinkedHashMap, "micUserMap");
    int i = ((e)business(e.class)).eyu();
    Object localObject1 = e.b.mKf;
    Object localObject3;
    if (i != e.b.bct())
    {
      i = ((e)business(e.class)).eyu();
      localObject1 = e.b.mKf;
      if (i == e.b.bcu())
      {
        localObject1 = ((j)business(j.class)).Efw;
        s.s(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      }
    }
    else
    {
      Object localObject4;
      synchronized ((Iterable)localObject1)
      {
        localObject3 = ((Iterable)???).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          paramBoolean = Util.isEqual(((h)localObject1).mXL, ((e)business(e.class)).eyF());
          if (paramBoolean)
          {
            if (localObject1 == null) {
              break label778;
            }
            if (paramLinkedHashMap.size() <= 1) {
              break label635;
            }
            localObject3 = (HashMap)paramLinkedHashMap;
            localObject4 = new ArrayList();
            ((ArrayList)localObject4).addAll((Collection)((HashMap)localObject3).keySet());
            paramBoolean = p.a((Iterable)localObject4, ((e)business(e.class)).eyF());
            Log.i("Finder.FinderLiveVisitorPreviewPlugin", "notifyLinkMicMode: userIdList:" + localObject4 + ", isRoomPk:" + ((j)business(j.class)).EfM + ", selfId:" + ((e)business(e.class)).eyF() + ", containsSelf:" + paramBoolean);
            if (this.mJe.getLayoutParams() != null) {
              break label335;
            }
            paramLinkedHashMap = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(354868);
            throw paramLinkedHashMap;
          }
        }
        localObject1 = null;
      }
      label335:
      if (((j)business(j.class)).EfM)
      {
        paramLinkedHashMap = this.mJe.getParent();
        if ((paramLinkedHashMap instanceof View))
        {
          paramLinkedHashMap = (View)paramLinkedHashMap;
          if (paramLinkedHashMap != null) {
            break label481;
          }
          paramLinkedHashMap = null;
          label376:
          if (!(paramLinkedHashMap instanceof ViewGroup.MarginLayoutParams)) {
            break label489;
          }
          paramLinkedHashMap = (ViewGroup.MarginLayoutParams)paramLinkedHashMap;
          if (paramLinkedHashMap != null) {
            break label494;
          }
          i = 0;
          localObject4 = this.mRt;
          paramLinkedHashMap = getLiveCore();
          if (paramLinkedHashMap != null) {
            break label502;
          }
          paramLinkedHashMap = "";
        }
        for (;;)
        {
          ??? = ((e)business(e.class)).eyF();
          localObject1 = ???;
          if (??? == null) {
            localObject1 = "";
          }
          ((LivePreviewView)localObject4).a(paramLinkedHashMap, (String)localObject1, (HashMap)localObject3, i);
          b.b.a(this.nfT, b.c.neC);
          this.mJe.requestDisallowInterceptTouchEvent(paramBoolean);
          AppMethodBeat.o(354868);
          return;
          paramLinkedHashMap = null;
          break;
          label481:
          paramLinkedHashMap = paramLinkedHashMap.getLayoutParams();
          break label376;
          label489:
          paramLinkedHashMap = null;
          break label388;
          label494:
          i = paramLinkedHashMap.topMargin;
          break label394;
          label502:
          paramLinkedHashMap = paramLinkedHashMap.mRB;
          if (paramLinkedHashMap == null)
          {
            paramLinkedHashMap = "";
          }
          else
          {
            paramLinkedHashMap = paramLinkedHashMap.mNM;
            if (paramLinkedHashMap == null) {
              paramLinkedHashMap = "";
            }
          }
        }
      }
      label388:
      label394:
      localObject3 = this.mRt;
      paramLinkedHashMap = getLiveCore();
      if (paramLinkedHashMap == null) {
        paramLinkedHashMap = "";
      }
      for (;;)
      {
        ??? = ((e)business(e.class)).eyF();
        localObject1 = ???;
        if (??? == null) {
          localObject1 = "";
        }
        ((LivePreviewView)localObject3).c(paramLinkedHashMap, (String)localObject1, (List)localObject4);
        break;
        paramLinkedHashMap = paramLinkedHashMap.mRB;
        if (paramLinkedHashMap == null)
        {
          paramLinkedHashMap = "";
        }
        else
        {
          paramLinkedHashMap = paramLinkedHashMap.mNM;
          if (paramLinkedHashMap == null) {
            paramLinkedHashMap = "";
          }
        }
      }
      label635:
      paramLinkedHashMap = (HashMap)paramLinkedHashMap;
      ??? = new ArrayList();
      ((ArrayList)???).addAll((Collection)paramLinkedHashMap.keySet());
      if (this.mJe.getLayoutParams() == null)
      {
        paramLinkedHashMap = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(354868);
        throw paramLinkedHashMap;
      }
      localObject3 = this.mRt;
      paramLinkedHashMap = getLiveCore();
      if (paramLinkedHashMap != null) {
        break label784;
      }
      paramLinkedHashMap = "";
      localObject1 = ((e)business(e.class)).eyF();
      if (localObject1 != null) {
        break label819;
      }
      localObject1 = "";
    }
    label778:
    label784:
    label819:
    for (;;)
    {
      ((LivePreviewView)localObject3).c(paramLinkedHashMap, (String)localObject1, (List)???);
      b.b.a(this.nfT, b.c.neD);
      this.mJe.requestDisallowInterceptTouchEvent(false);
      Log.i("Finder.FinderLiveVisitorPreviewPlugin", s.X("notifyNormalMode userIdList:", ???));
      AppMethodBeat.o(354868);
      return;
      paramLinkedHashMap = paramLinkedHashMap.mRB;
      if (paramLinkedHashMap == null)
      {
        paramLinkedHashMap = "";
        break;
      }
      paramLinkedHashMap = paramLinkedHashMap.mNM;
      if (paramLinkedHashMap == null)
      {
        paramLinkedHashMap = "";
        break;
      }
      break;
    }
  }
  
  public final void aPz()
  {
    AppMethodBeat.i(354774);
    com.tencent.mm.live.core.core.f.d locald = getLiveCore();
    Object localObject1;
    if (locald != null)
    {
      localObject1 = aj.CGT;
      locald.tc(aj.bgA());
    }
    locald = getLiveCore();
    if (locald != null)
    {
      localObject1 = this.mRt;
      Object localObject2 = aj.CGT;
      localObject2 = aj.bhX();
      aj localaj = aj.CGT;
      locald.a((LivePreviewView)localObject1, (com.tencent.mm.live.core.b.a)localObject2, aj.bhY());
    }
    AppMethodBeat.o(354774);
  }
  
  public final void awR(final String paramString)
  {
    AppMethodBeat.i(354811);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, paramString));
    AppMethodBeat.o(354811);
  }
  
  public final void axo(String paramString)
  {
    AppMethodBeat.i(354798);
    Object localObject = this.mRt.mWP;
    TRTCVideoLayoutManager.b localb;
    if (paramString != null)
    {
      localObject = ((TRTCVideoLayoutManager)localObject).mXo.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localb = (TRTCVideoLayoutManager.b)((Iterator)localObject).next();
      } while ((localb.streamType != 0) || (!localb.userId.equals(paramString)));
    }
    for (paramString = localb.mXw;; paramString = null)
    {
      if (paramString != null) {
        paramString.bringToFront();
      }
      AppMethodBeat.o(354798);
      return;
    }
  }
  
  public final void bha()
  {
    AppMethodBeat.i(354804);
    this.mRt.bha();
    AppMethodBeat.o(354804);
  }
  
  public final boolean enH()
  {
    return false;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void esR()
  {
    AppMethodBeat.i(354765);
    com.tencent.mm.live.core.core.f.d locald = getLiveCore();
    if (locald != null) {
      locald.mRt = this.mRt;
    }
    AppMethodBeat.o(354765);
  }
  
  public final void esS()
  {
    String str = null;
    AppMethodBeat.i(354787);
    com.tencent.mm.live.core.core.f.d locald = getLiveCore();
    if (locald != null) {
      locald.mRt = this.mRt;
    }
    locald = getLiveCore();
    Object localObject;
    if (locald != null)
    {
      localObject = getLiveCore();
      if (localObject != null) {
        break label55;
      }
    }
    for (;;)
    {
      locald.FQ(str);
      AppMethodBeat.o(354787);
      return;
      label55:
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
      if (localObject != null) {
        str = ((i)localObject).mNM;
      }
    }
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(354756);
    com.tencent.mm.live.core.core.f.d locald = getLiveCore();
    if (locald != null) {
      locald.b((c)new ct.d());
    }
    AppMethodBeat.o(354756);
  }
  
  public final com.tencent.mm.live.core.core.f.d getLiveCore()
  {
    AppMethodBeat.i(354747);
    Object localObject = com.tencent.mm.live.core.core.f.a.mUf;
    localObject = (com.tencent.mm.live.core.core.f.d)com.tencent.mm.live.core.core.f.a.a.hH(getData().Ebr.liveId);
    AppMethodBeat.o(354747);
    return localObject;
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void pause() {}
  
  public final void resume() {}
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354837);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(354837);
      return;
      exitRoom();
      tO(8);
      AppMethodBeat.o(354837);
      return;
      if (paramBundle != null) {
        paramBundle.getBoolean("PARAM_HANGUP_SELF", false);
      }
      paramc = getLiveCore();
      if (paramc != null) {
        paramc.bfJ();
      }
      paramc = aj.CGT;
      aj.bUK();
      this.mRt.bgZ();
      AppMethodBeat.o(354837);
      return;
      paramc = this.nkE;
      if (paramc != null)
      {
        paramBundle = getLiveCore();
        if (paramBundle != null) {
          paramBundle.a(paramc);
        }
        AppMethodBeat.o(354837);
        return;
        tO(0);
        paramc = this.mRt.getParent();
        if ((paramc != null) && ((paramc instanceof ViewGroup)))
        {
          ((ViewGroup)paramc).removeView((View)this.mRt);
          ((ViewGroup)paramc).addView((View)this.mRt);
        }
        this.mRt.ty(this.mJe.getContext().getResources().getConfiguration().orientation);
        paramc = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn();
        if (this.context.getResources().getConfiguration().orientation == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramc.mTf = bool;
          paramc = getLiveCore();
          if (paramc == null) {
            break;
          }
          paramc.b(this.mRt);
          AppMethodBeat.o(354837);
          return;
        }
        this.mRt.bgZ();
        paramc = getLiveCore();
        if (paramc != null)
        {
          paramc.bfJ();
          AppMethodBeat.o(354837);
          return;
          Log.i("Finder.FinderLiveVisitorPreviewPlugin", "switchCamera");
          paramc = getLiveCore();
          if (paramc != null) {
            paramc.switchCamera();
          }
        }
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(354819);
    super.tO(paramInt);
    Log.printInfoStack("Finder.FinderLiveVisitorPreviewPlugin", s.X("setVisible ", Integer.valueOf(paramInt)), new Object[0]);
    AppMethodBeat.o(354819);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements c
  {
    public c(ct paramct, kotlin.g.a.b<? super Boolean, ah> paramb) {}
    
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(354827);
      if (paramInt >= 0)
      {
        ct.esT();
        this.mUv.invoke(Boolean.TRUE);
        AppMethodBeat.o(354827);
        return;
      }
      ct.esU();
      this.mUv.invoke(Boolean.FALSE);
      AppMethodBeat.o(354827);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(ct paramct, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ct
 * JD-Core Version:    0.7.0.1
 */