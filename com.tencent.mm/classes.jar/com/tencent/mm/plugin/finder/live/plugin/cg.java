package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s;
import com.tencent.mm.plugin.finder.live.report.s.aj;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveFloatContainer;
import com.tencent.mm.plugin.finder.live.view.FinderMaxSizeLayout;
import com.tencent.mm.plugin.finder.live.widget.aj;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.h.a;
import com.tencent.xweb.h.b;
import com.tencent.xweb.h.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenShareWidget;", "", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "anchorPreviewVideoContainer", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer;", "anchorPreviewVideoView", "Landroid/view/TextureView;", "currentViewStatus", "Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "fileExt", "", "filePath", "isAvatarLayoutOn", "", "()Z", "setAvatarLayoutOn", "(Z)V", "isDoodleLayoutOn", "setDoodleLayoutOn", "leftRightBoundary", "", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "readerContainer", "Landroid/widget/RelativeLayout;", "readerLayout", "token", "fillAudioPreview", "", "fillVideoPreview", "inputFileInfo", "strFilePath", "inputPicInfo", "onAudioModeChanged", "isAudioMode", "onSelectShareFile", "isPic", "refreshVideoRenderView", "reportScreenShareFinish", "restoreScreenShare", "startScreenShare", "stopScreenShare", "Companion", "plugin-finder_release"})
public final class cg
{
  public static final c ywQ;
  private String filePath;
  private String jmx;
  final ViewGroup kiF;
  private String token;
  private final d xYq;
  RelativeLayout ywK;
  private RelativeLayout ywL;
  private TextureView ywM;
  private FinderLiveFloatContainer ywN;
  private final int ywO;
  private h.b ywP;
  
  static
  {
    AppMethodBeat.i(276679);
    ywQ = new c((byte)0);
    AppMethodBeat.o(276679);
  }
  
  public cg(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(276677);
    this.kiF = paramViewGroup;
    this.xYq = paramd;
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_doc_cast_reader_root);
    p.j(paramViewGroup, "root.findViewById(R.id.f…ive_doc_cast_reader_root)");
    this.ywK = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_doc_cast_reader_container);
    p.j(paramViewGroup, "root.findViewById(R.id.f…oc_cast_reader_container)");
    this.ywL = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_doc_cast_camera);
    p.j(paramViewGroup, "root.findViewById(R.id.f…der_live_doc_cast_camera)");
    this.ywM = ((TextureView)paramViewGroup);
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_doc_cast_video_cotainer);
    p.j(paramViewGroup, "root.findViewById(R.id.f…_doc_cast_video_cotainer)");
    this.ywN = ((FinderLiveFloatContainer)paramViewGroup);
    this.ywO = aw.fromDPToPix(this.kiF.getContext(), 8);
    this.ywN.setTranslationX(0.0F);
    paramViewGroup = this.ywN;
    paramViewGroup.setOnTouchCallback((kotlin.g.a.b)new a(this));
    paramViewGroup.setOnAnimCallback((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(276677);
  }
  
  private void aCu(String paramString)
  {
    AppMethodBeat.i(276671);
    p.k(paramString, "strFilePath");
    int i = n.g((CharSequence)paramString, ".") + 1;
    if (i >= paramString.length())
    {
      Log.i("FinderLiveScreenShareWidget", "open file error : file path error");
      AppMethodBeat.o(276671);
      return;
    }
    Object localObject = paramString.substring(i);
    p.j(localObject, "(this as java.lang.String).substring(startIndex)");
    this.jmx = ((String)localObject);
    this.ywK.removeAllViews();
    localObject = new WxImageView(this.kiF.getContext());
    ((WxImageView)localObject).setOrientation(BackwardSupportUtil.ExifHelper.getExifOrientation(paramString));
    String str = Uri.encode(u.n(paramString, false));
    if (!Util.isNullOrNil(str)) {
      ((WxImageView)localObject).a(u.n(paramString, false), com.davemorrissey.labs.subscaleview.view.a.aZ(str));
    }
    this.ywK.addView((View)localObject, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    ((WxImageView)localObject).setOnImageLoadEventListener((com.tencent.mm.graphics.a.b)new g((WxImageView)localObject));
    AppMethodBeat.o(276671);
  }
  
  private void aCv(String paramString)
  {
    AppMethodBeat.i(276672);
    p.k(paramString, "strFilePath");
    int i = n.g((CharSequence)paramString, ".") + 1;
    if (i >= paramString.length())
    {
      Log.i("FinderLiveScreenShareWidget", "open file error : file path error");
      AppMethodBeat.o(276672);
      return;
    }
    Object localObject1 = paramString.substring(i);
    p.j(localObject1, "(this as java.lang.String).substring(startIndex)");
    this.jmx = ((String)localObject1);
    this.filePath = paramString;
    if (this.token == null) {
      this.token = (String.valueOf(hashCode()) + String.valueOf(System.currentTimeMillis()));
    }
    if ((this.filePath != null) && (this.jmx != null))
    {
      paramString = this.filePath;
      if (paramString == null) {
        p.iCn();
      }
      paramString = new com.tencent.mm.vfs.q(paramString);
      if ((!paramString.ifE()) || (!paramString.ifH())) {
        AppMethodBeat.o(276672);
      }
    }
    else
    {
      AppMethodBeat.o(276672);
      return;
    }
    paramString = new HashMap();
    ((Map)paramString).put("extra_param_disable_scale", "false");
    ((Map)paramString).put("extra_param_enable_receive_view_status_change", "true");
    localObject1 = (Map)paramString;
    Object localObject2 = this.kiF.getContext();
    p.j(localObject2, "root.context");
    ((Map)localObject1).put("extra_param_bg_color", String.valueOf(((Context)localObject2).getResources().getColor(a.b.Dark_2)));
    ((Map)paramString).put("extra_param_disable_finish_activity", "true");
    ((Map)paramString).put("extra_param_set_max_scale", "3");
    this.ywK.removeAllViews();
    localObject1 = this.filePath;
    localObject2 = this.jmx;
    String str = this.token;
    h.c localc = h.c.aaah;
    Context localContext = this.kiF.getContext();
    if (localContext == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(276672);
      throw paramString;
    }
    com.tencent.xweb.h.a((String)localObject1, (String)localObject2, str, true, paramString, localc, (Activity)localContext, (ViewGroup)this.ywK, (h.a)new e(this), (ValueCallback)f.ywS);
    AppMethodBeat.o(276672);
  }
  
  private void dCs()
  {
    Object localObject2 = null;
    AppMethodBeat.i(276673);
    this.kiF.setVisibility(0);
    int j = aw.fromDPToPix(this.kiF.getContext(), 120);
    int k = aw.fromDPToPix(this.kiF.getContext(), 90);
    int m = ax.aB(this.kiF.getContext());
    Object localObject1 = (aq)this.xYq.getPlugin(aq.class);
    int i;
    Object localObject3;
    if (localObject1 != null)
    {
      i = ((aq)localObject1).yoB.getMaxHeight();
      localObject3 = this.ywN.getLayoutParams();
      localObject1 = localObject3;
      if (!(localObject3 instanceof ViewGroup.MarginLayoutParams)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      if (localObject1 != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = j;
        ((ViewGroup.MarginLayoutParams)localObject1).setMarginEnd(this.ywO);
      }
      localObject1 = this.ywN;
      int n = this.ywO;
      int i1 = this.ywO;
      ((FinderLiveFloatContainer)localObject1).yTU = j;
      ((FinderLiveFloatContainer)localObject1).yTV = (m + k + i);
      ((FinderLiveFloatContainer)localObject1).yTW = n;
      ((FinderLiveFloatContainer)localObject1).yTX = i1;
      localObject1 = getLiveCore();
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.trtc.a)localObject1).a(true, this.ywM, (View)this.ywL);
      }
      dCr();
      localObject1 = getLiveCore();
      if (localObject1 == null) {
        break label471;
      }
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
      if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.h)localObject1).aLs() != true)) {
        break label471;
      }
      dCq();
    }
    for (;;)
    {
      localObject1 = k.yBj;
      if (k.dDm().yDH == 0L)
      {
        localObject1 = k.yBj;
        k.dDm().yDH = System.currentTimeMillis();
        localObject4 = new i();
        ((i)localObject4).h("type", Integer.valueOf(s.aj.yIU.action));
        localObject3 = this.jmx;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "other";
        }
        ((i)localObject4).h("result", localObject1);
        localObject1 = k.yBj;
        k.a(s.c.yEI, ((i)localObject4).toString());
      }
      localObject1 = (h)this.xYq.getPlugin(h.class);
      if (localObject1 != null) {
        ((h)localObject1).ylA.dIE();
      }
      localObject3 = new StringBuilder("startScreenShare isAudioMode:");
      Object localObject4 = getLiveCore();
      localObject1 = localObject2;
      if (localObject4 != null)
      {
        localObject4 = ((com.tencent.mm.live.core.core.trtc.a)localObject4).knA;
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = Boolean.valueOf(((com.tencent.mm.live.core.core.model.h)localObject4).aLs());
        }
      }
      Log.i("FinderLiveScreenShareWidget", localObject1 + " topBoundary:" + j);
      AppMethodBeat.o(276673);
      return;
      i = 0;
      break;
      label471:
      dCp();
    }
  }
  
  static com.tencent.mm.live.core.core.trtc.a getLiveCore()
  {
    AppMethodBeat.i(276667);
    Object localObject = ah.yhC;
    localObject = (com.tencent.mm.live.core.core.trtc.a)ah.dzB();
    AppMethodBeat.o(276667);
    return localObject;
  }
  
  public final void dAQ()
  {
    int j = 0;
    AppMethodBeat.i(276675);
    Object localObject2 = new StringBuilder("restoreScreenShare floatPosition:");
    Object localObject1 = getLiveCore();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knP;
      Log.i("FinderLiveScreenShareWidget", localObject1);
      localObject1 = getLiveCore();
      if (localObject1 == null) {
        break label203;
      }
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knP;
      if (localObject1 == null) {
        break label203;
      }
      if ((((Point)localObject1).x == 0) && (((Point)localObject1).y == 0)) {
        break label196;
      }
      localObject2 = this.ywN.getLayoutParams();
      localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      if (localObject1 == null) {
        break label196;
      }
      localObject2 = getLiveCore();
      if (localObject2 == null) {
        break label191;
      }
      localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).knP;
      if (localObject2 == null) {
        break label191;
      }
    }
    label191:
    for (int i = ((Point)localObject2).x;; i = 0)
    {
      ((ViewGroup.MarginLayoutParams)localObject1).setMarginEnd(i);
      localObject2 = getLiveCore();
      i = j;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).knP;
        i = j;
        if (localObject2 != null) {
          i = ((Point)localObject2).y;
        }
      }
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = i;
      AppMethodBeat.o(276675);
      return;
      localObject1 = null;
      break;
    }
    label196:
    AppMethodBeat.o(276675);
    return;
    label203:
    AppMethodBeat.o(276675);
  }
  
  final void dCp()
  {
    AppMethodBeat.i(276668);
    this.ywN.setVisibility(0);
    this.ywN.post((Runnable)new d(this));
    AppMethodBeat.o(276668);
  }
  
  final void dCq()
  {
    Object localObject2 = null;
    AppMethodBeat.i(276669);
    Object localObject1 = ah.yhC;
    localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    Object localObject3;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zeZ;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).liveDesc;
          if (localObject1 != null)
          {
            localObject1 = ((azd)localObject1).zfA;
            localObject3 = (CharSequence)localObject1;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label248;
            }
            i = 1;
            label81:
            if (i == 0) {
              break label253;
            }
            localObject1 = ah.yhC;
            localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
            if (localObject1 != null)
            {
              localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zeZ;
              if (localObject1 != null)
              {
                localObject1 = ((FinderObject)localObject1).objectDesc;
                if (localObject1 != null)
                {
                  localObject1 = ((FinderObjectDesc)localObject1).media;
                  if (localObject1 != null)
                  {
                    localObject1 = (FinderMedia)j.lp((List)localObject1);
                    if (localObject1 != null)
                    {
                      localObject3 = ((FinderMedia)localObject1).url;
                      localObject1 = localObject3;
                      if (localObject3 != null) {
                        break label163;
                      }
                    }
                  }
                }
              }
            }
            localObject1 = "";
          }
        }
      }
    }
    label163:
    label248:
    label253:
    for (;;)
    {
      this.ywN.setVisibility(8);
      localObject3 = new StringBuilder("liveCoverUrl:").append((String)localObject1).append(", liveData.audioModeHolderBm:");
      localObject1 = ah.yhC;
      com.tencent.mm.plugin.finder.live.viewmodel.data.business.b localb = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = localb.zgo;
      }
      Log.i("FinderLiveScreenShareWidget", localObject1);
      AppMethodBeat.o(276669);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label81;
    }
  }
  
  final void dCr()
  {
    AppMethodBeat.i(276670);
    ViewParent localViewParent = this.ywM.getParent();
    Object localObject = localViewParent;
    if (!(localViewParent instanceof ViewGroup)) {
      localObject = null;
    }
    localObject = (ViewGroup)localObject;
    if (localObject != null) {
      ((ViewGroup)localObject).removeView((View)this.ywM);
    }
    if (localObject != null)
    {
      ((ViewGroup)localObject).addView((View)this.ywM);
      AppMethodBeat.o(276670);
      return;
    }
    AppMethodBeat.o(276670);
  }
  
  public final void dCt()
  {
    AppMethodBeat.i(276676);
    Object localObject = new i();
    long l = System.currentTimeMillis();
    k localk = k.yBj;
    l = (l - k.dDm().yDH) / 1000L;
    ((i)localObject).h("type", Integer.valueOf(s.aj.yIV.action));
    ((i)localObject).h("result", Long.valueOf(l));
    localk = k.yBj;
    k.a(s.c.yEI, ((i)localObject).toString());
    localObject = com.tencent.mm.ad.h.aGm();
    ((com.tencent.mm.ad.c)localObject).f("type", this.jmx);
    ((com.tencent.mm.ad.c)localObject).f("time", Long.valueOf(l));
    localk = k.yBj;
    k.dDm().yDI.bv(localObject);
    localObject = k.yBj;
    k.dDm().yDH = 0L;
    AppMethodBeat.o(276676);
  }
  
  public final void pk(boolean paramBoolean)
  {
    CharSequence localCharSequence = null;
    AppMethodBeat.i(276674);
    Object localObject2 = new StringBuilder("selectShareFile:");
    Object localObject1 = ah.yhC;
    localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zgN;
      Log.i("FinderLiveScreenShareWidget", (String)localObject1);
      localObject1 = ah.yhC;
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      localObject1 = localCharSequence;
      if (localObject2 != null) {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject2).zgN;
      }
      localCharSequence = (CharSequence)localObject1;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label146;
      }
      i = 1;
      label110:
      if ((i == 0) && (u.agG((String)localObject1)))
      {
        if (!paramBoolean) {
          break label151;
        }
        aCu((String)localObject1);
      }
    }
    for (;;)
    {
      dCs();
      AppMethodBeat.o(276674);
      return;
      localObject1 = null;
      break;
      label146:
      i = 0;
      break label110;
      label151:
      aCv((String)localObject1);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenShareWidget$1$1"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<MotionEvent, x>
  {
    a(cg paramcg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenShareWidget$1$2"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(cg paramcg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenShareWidget$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class c {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(cg paramcg) {}
    
    public final void run()
    {
      AppMethodBeat.i(278302);
      Object localObject = cg.dCu();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knP;
        if (localObject != null)
        {
          if ((((Point)localObject).x == 0) && (((Point)localObject).y == 0))
          {
            com.tencent.mm.live.core.core.trtc.a locala = cg.dCu();
            if (locala != null)
            {
              int j = cg.a(this.ywR);
              ViewGroup.LayoutParams localLayoutParams = cg.b(this.ywR).getLayoutParams();
              localObject = localLayoutParams;
              if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
                localObject = null;
              }
              localObject = (ViewGroup.MarginLayoutParams)localObject;
              if (localObject != null) {}
              for (int i = ((ViewGroup.MarginLayoutParams)localObject).topMargin;; i = 0)
              {
                locala.ds(j, i);
                AppMethodBeat.o(278302);
                return;
              }
            }
          }
          AppMethodBeat.o(278302);
          return;
        }
      }
      AppMethodBeat.o(278302);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenShareWidget$inputFileInfo$1", "Lcom/tencent/xweb/FileReaderXWeb$ActionCallback;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onPageChange", "pageIndex", "", "pageWidth", "pageHeight", "onPageCountUpdate", "totalCount", "onReachEnd", "onSingleTap", "onThumbnailLoad", "thumbnail", "Landroid/graphics/Bitmap;", "onUserCancel", "onUserOperated", "onViewStatusChange", "index", "zoom", "", "curWidth", "curHeight", "transX", "transY", "plugin-finder_release"})
  public static final class e
    implements h.a
  {
    public final void NB(int paramInt)
    {
      AppMethodBeat.i(286393);
      Log.i("FinderLiveScreenShareWidget", "xfile onPageCountUpdate ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(286393);
    }
    
    public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AppMethodBeat.i(286396);
      Log.i("FinderLiveScreenShareWidget", "xfile onViewStatusChange " + paramInt1 + " and pageWidth " + paramInt2 + " and pageHeight " + paramInt3 + " and scale " + paramFloat + " and transX " + paramInt4 + " and " + paramInt5);
      AppMethodBeat.o(286396);
    }
    
    public final void a(int paramInt, Bitmap paramBitmap)
    {
      AppMethodBeat.i(286397);
      p.k(paramBitmap, "thumbnail");
      Log.i("FinderLiveScreenShareWidget", "xfile onThumbnailLoad ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(286397);
    }
    
    public final void ag(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(286395);
      Log.i("FinderLiveScreenShareWidget", "xfile onPageChange " + paramInt1 + " and pageWidth " + paramInt2 + " and pageHeight " + paramInt3);
      cg.a(this.ywR, com.tencent.xweb.h.oW(cg.c(this.ywR), cg.d(this.ywR)));
      AppMethodBeat.o(286395);
    }
    
    public final void bQm()
    {
      AppMethodBeat.i(286394);
      Log.i("FinderLiveScreenShareWidget", "xfile on user cancel finish");
      AppMethodBeat.o(286394);
    }
    
    public final void dCv() {}
    
    public final void dCw() {}
    
    public final void dCx() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue", "(Ljava/lang/Integer;)V"})
  static final class f<T>
    implements ValueCallback<Integer>
  {
    public static final f ywS;
    
    static
    {
      AppMethodBeat.i(278245);
      ywS = new f();
      AppMethodBeat.o(278245);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenShareWidget$inputPicInfo$1", "Lcom/tencent/mm/graphics/model/OnImageLoadEventListenerAdapter;", "onImageLoadError", "", "result", "Lcom/davemorrissey/labs/subscaleview/decoder/ImageDecodeResult;", "onImageLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onPreviewLoadError", "onTileLoadError", "plugin-finder_release"})
  public static final class g
    extends com.tencent.mm.graphics.a.c
  {
    g(WxImageView paramWxImageView) {}
    
    public final void a(com.davemorrissey.labs.subscaleview.a.c paramc)
    {
      AppMethodBeat.i(290967);
      p.k(paramc, "result");
      Log.d("FinderLiveScreenShareWidget", "wxImageView, onPreviewLoadError. result:".concat(String.valueOf(paramc)));
      AppMethodBeat.o(290967);
    }
    
    public final void b(com.davemorrissey.labs.subscaleview.a.c paramc)
    {
      AppMethodBeat.i(290968);
      p.k(paramc, "result");
      Log.w("FinderLiveScreenShareWidget", "onImageLoadError, result:".concat(String.valueOf(paramc)));
      AppMethodBeat.o(290968);
    }
    
    public final void c(com.davemorrissey.labs.subscaleview.a.c paramc)
    {
      AppMethodBeat.i(290969);
      p.k(paramc, "result");
      Log.w("FinderLiveScreenShareWidget", "onTileLoadError, result:".concat(String.valueOf(paramc)));
      AppMethodBeat.o(290969);
    }
    
    public final void i(Bitmap paramBitmap)
    {
      AppMethodBeat.i(290965);
      p.k(paramBitmap, "bitmap");
      Log.d("FinderLiveScreenShareWidget", "wxImageView, onImageLoaded.");
      this.ywT.di(paramBitmap.getWidth(), paramBitmap.getHeight());
      this.ywT.hJx();
      AppMethodBeat.o(290965);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cg
 * JD-Core Version:    0.7.0.1
 */