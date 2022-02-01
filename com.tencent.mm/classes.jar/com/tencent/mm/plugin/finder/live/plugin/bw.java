package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.davemorrissey.labs.subscaleview.view.ImageSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.h;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.report.q.au;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveFloatContainer;
import com.tencent.mm.plugin.finder.live.view.FinderMaxSizeLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.j.a;
import com.tencent.xweb.j.b;
import com.tencent.xweb.j.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenShareWidget;", "", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "anchorPreviewVideoContainer", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer;", "anchorPreviewVideoView", "Landroid/view/TextureView;", "currentViewStatus", "Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "fileExt", "", "filePath", "isAvatarLayoutOn", "", "()Z", "setAvatarLayoutOn", "(Z)V", "isDoodleLayoutOn", "setDoodleLayoutOn", "leftRightBoundary", "", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "readerContainer", "Landroid/widget/RelativeLayout;", "readerLayout", "token", "fillAudioPreview", "", "fillVideoPreview", "inputFileInfo", "strFilePath", "inputPicInfo", "onAudioModeChanged", "isAudioMode", "onSelectShareFile", "isPic", "refreshVideoRenderView", "reportScreenShareFinish", "restoreScreenShare", "startScreenShare", "stopScreenShare", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bw
{
  public static final bw.c DiN;
  private final b CwG;
  RelativeLayout DiO;
  private RelativeLayout DiP;
  private TextureView DiQ;
  private FinderLiveFloatContainer DiR;
  private final int DiS;
  private j.b DiT;
  private String filePath;
  private String lPJ;
  final ViewGroup mJe;
  private String token;
  
  static
  {
    AppMethodBeat.i(354195);
    DiN = new bw.c((byte)0);
    AppMethodBeat.o(354195);
  }
  
  public bw(ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(354100);
    this.mJe = paramViewGroup;
    this.CwG = paramb;
    paramViewGroup = this.mJe.findViewById(p.e.BKp);
    s.s(paramViewGroup, "root.findViewById(R.id.f…ive_doc_cast_reader_root)");
    this.DiO = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BKo);
    s.s(paramViewGroup, "root.findViewById(R.id.f…oc_cast_reader_container)");
    this.DiP = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BKn);
    s.s(paramViewGroup, "root.findViewById(R.id.f…der_live_doc_cast_camera)");
    this.DiQ = ((TextureView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BKr);
    s.s(paramViewGroup, "root.findViewById(R.id.f…_doc_cast_video_cotainer)");
    this.DiR = ((FinderLiveFloatContainer)paramViewGroup);
    this.DiS = bd.fromDPToPix(this.mJe.getContext(), 8);
    this.DiR.setTranslationX(0.0F);
    paramViewGroup = this.DiR;
    paramViewGroup.setOnTouchCallback((kotlin.g.a.b)new a(this));
    paramViewGroup.setOnAnimCallback((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(354100);
  }
  
  private static final void a(bw parambw)
  {
    AppMethodBeat.i(354152);
    s.u(parambw, "this$0");
    Object localObject = getLiveCore();
    int j;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRQ;
      if ((localObject != null) && (((Point)localObject).x == 0) && (((Point)localObject).y == 0))
      {
        localObject = getLiveCore();
        if (localObject != null)
        {
          j = parambw.DiS;
          parambw = parambw.DiR.getLayoutParams();
          if (!(parambw instanceof ViewGroup.MarginLayoutParams)) {
            break label93;
          }
          parambw = (ViewGroup.MarginLayoutParams)parambw;
          if (parambw != null) {
            break label98;
          }
        }
      }
    }
    label93:
    label98:
    for (int i = 0;; i = parambw.topMargin)
    {
      ((com.tencent.mm.live.core.core.trtc.a)localObject).eg(j, i);
      AppMethodBeat.o(354152);
      return;
      parambw = null;
      break;
    }
  }
  
  private void axk(String paramString)
  {
    AppMethodBeat.i(354118);
    s.u(paramString, "strFilePath");
    int i = n.g((CharSequence)paramString, ".") + 1;
    if (i >= paramString.length())
    {
      Log.i("FinderLiveScreenShareWidget", "open file error : file path error");
      AppMethodBeat.o(354118);
      return;
    }
    Object localObject = paramString.substring(i);
    s.s(localObject, "(this as java.lang.String).substring(startIndex)");
    this.lPJ = ((String)localObject);
    this.DiO.removeAllViews();
    localObject = new WxImageView(this.mJe.getContext());
    ((WxImageView)localObject).setOrientation(BackwardSupportUtil.ExifHelper.getExifOrientation(paramString));
    String str = Uri.encode(y.n(paramString, false));
    if (!Util.isNullOrNil(str)) {
      ((WxImageView)localObject).a(y.n(paramString, false), ImageSource.uri(str));
    }
    this.DiO.addView((View)localObject, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    ((WxImageView)localObject).setOnImageLoadEventListener((com.tencent.mm.graphics.a.b)new bw.e((WxImageView)localObject));
    AppMethodBeat.o(354118);
  }
  
  private void axl(String paramString)
  {
    AppMethodBeat.i(354128);
    s.u(paramString, "strFilePath");
    int i = n.g((CharSequence)paramString, ".") + 1;
    if (i >= paramString.length())
    {
      Log.i("FinderLiveScreenShareWidget", "open file error : file path error");
      AppMethodBeat.o(354128);
      return;
    }
    String str1 = paramString.substring(i);
    s.s(str1, "(this as java.lang.String).substring(startIndex)");
    this.lPJ = str1;
    this.filePath = paramString;
    if (this.token == null) {
      this.token = (hashCode() + System.currentTimeMillis());
    }
    if ((this.filePath != null) && (this.lPJ != null))
    {
      paramString = this.filePath;
      s.checkNotNull(paramString);
      paramString = new com.tencent.mm.vfs.u(paramString);
      if ((!paramString.jKS()) || (!paramString.jKV())) {
        AppMethodBeat.o(354128);
      }
    }
    else
    {
      AppMethodBeat.o(354128);
      return;
    }
    paramString = new HashMap();
    ((Map)paramString).put("extra_param_disable_scale", "false");
    ((Map)paramString).put("extra_param_enable_receive_view_status_change", "true");
    ((Map)paramString).put("extra_param_bg_color", String.valueOf(this.mJe.getContext().getResources().getColor(a.b.Dark_2)));
    ((Map)paramString).put("extra_param_disable_finish_activity", "true");
    ((Map)paramString).put("extra_param_set_max_scale", "3");
    this.DiO.removeAllViews();
    str1 = this.filePath;
    String str2 = this.lPJ;
    String str3 = this.token;
    j.c localc = j.c.aieQ;
    Context localContext = this.mJe.getContext();
    if (localContext == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(354128);
      throw paramString;
    }
    com.tencent.xweb.j.a(str1, str2, str3, true, paramString, localc, (Activity)localContext, (ViewGroup)this.DiO, (j.a)new bw.d(this), bw..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(354128);
  }
  
  private void erN()
  {
    int j = 0;
    AppMethodBeat.i(354141);
    this.mJe.setVisibility(0);
    int k = bd.fromDPToPix(this.mJe.getContext(), 120);
    int m = bd.fromDPToPix(this.mJe.getContext(), 90);
    int n = bf.bk(this.mJe.getContext());
    Object localObject1 = (ah)this.CwG.getPlugin(ah.class);
    int i;
    label101:
    label249:
    Object localObject2;
    if (localObject1 == null)
    {
      i = 0;
      localObject1 = this.DiR.getLayoutParams();
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        break label421;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      if (localObject1 != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = k;
        ((ViewGroup.MarginLayoutParams)localObject1).setMarginEnd(this.DiS);
      }
      localObject1 = this.DiR;
      int i1 = this.DiS;
      int i2 = this.DiS;
      ((FinderLiveFloatContainer)localObject1).DML = k;
      ((FinderLiveFloatContainer)localObject1).DMM = (n + m + i);
      ((FinderLiveFloatContainer)localObject1).DMN = i1;
      ((FinderLiveFloatContainer)localObject1).DMO = i2;
      localObject1 = getLiveCore();
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.trtc.a)localObject1).a(true, this.DiQ, (View)this.DiP);
      }
      erM();
      localObject1 = getLiveCore();
      i = j;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
        i = j;
        if (localObject1 != null)
        {
          i = j;
          if (((com.tencent.mm.live.core.core.model.i)localObject1).bex() == true) {
            i = 1;
          }
        }
      }
      if (i == 0) {
        break label427;
      }
      erL();
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      if (com.tencent.mm.plugin.finder.live.report.j.Doc.DqB == 0L)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        com.tencent.mm.plugin.finder.live.report.j.Doc.DqB = System.currentTimeMillis();
        com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
        locali.n("type", Integer.valueOf(q.au.DzM.action));
        localObject2 = this.lPJ;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "other";
        }
        locali.n("result", localObject1);
        com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrG, locali.toString());
      }
      localObject2 = new StringBuilder("startScreenShare isAudioMode:");
      localObject1 = getLiveCore();
      if (localObject1 != null) {
        break label434;
      }
      localObject1 = null;
    }
    for (;;)
    {
      Log.i("FinderLiveScreenShareWidget", localObject1 + " topBoundary:" + k);
      AppMethodBeat.o(354141);
      return;
      i = ((ah)localObject1).CXK.getMaxHeight();
      break;
      label421:
      localObject1 = null;
      break label101;
      label427:
      erK();
      break label249;
      label434:
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = Boolean.valueOf(((com.tencent.mm.live.core.core.model.i)localObject1).bex());
      }
    }
  }
  
  static com.tencent.mm.live.core.core.trtc.a getLiveCore()
  {
    AppMethodBeat.i(354107);
    Object localObject = aj.CGT;
    localObject = (com.tencent.mm.live.core.core.trtc.a)aj.elM();
    AppMethodBeat.o(354107);
    return localObject;
  }
  
  private static final void q(Integer paramInteger)
  {
    AppMethodBeat.i(354160);
    if (paramInteger == null)
    {
      AppMethodBeat.o(354160);
      return;
    }
    paramInteger.intValue();
    AppMethodBeat.o(354160);
  }
  
  public final void epB()
  {
    Object localObject2 = null;
    int j = 0;
    AppMethodBeat.i(354242);
    Object localObject1 = getLiveCore();
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("FinderLiveScreenShareWidget", s.X("restoreScreenShare floatPosition:", localObject1));
      localObject1 = getLiveCore();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRQ;
        if ((localObject1 != null) && ((((Point)localObject1).x != 0) || (((Point)localObject1).y != 0)))
        {
          ViewGroup.LayoutParams localLayoutParams = this.DiR.getLayoutParams();
          localObject1 = localObject2;
          if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
            localObject1 = (ViewGroup.MarginLayoutParams)localLayoutParams;
          }
          if (localObject1 != null)
          {
            localObject2 = getLiveCore();
            if (localObject2 != null) {
              break label144;
            }
            i = 0;
            label107:
            ((ViewGroup.MarginLayoutParams)localObject1).setMarginEnd(i);
            localObject2 = getLiveCore();
            if (localObject2 != null) {
              break label170;
            }
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = i;
      AppMethodBeat.o(354242);
      return;
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRQ;
      break;
      label144:
      localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).mRQ;
      if (localObject2 == null)
      {
        i = 0;
        break label107;
      }
      i = ((Point)localObject2).x;
      break label107;
      label170:
      localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).mRQ;
      i = j;
      if (localObject2 != null) {
        i = ((Point)localObject2).y;
      }
    }
  }
  
  final void erK()
  {
    AppMethodBeat.i(354213);
    this.DiR.setVisibility(0);
    this.DiR.post(new bw..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(354213);
  }
  
  final void erL()
  {
    Object localObject2 = null;
    AppMethodBeat.i(354224);
    Object localObject1 = aj.CGT;
    localObject1 = (e)aj.business(e.class);
    Object localObject3;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label200;
      }
      i = 1;
      label51:
      if (i == 0) {
        break label304;
      }
      localObject1 = aj.CGT;
      localObject1 = (e)aj.business(e.class);
      if (localObject1 != null) {
        break label205;
      }
      localObject1 = "";
    }
    label304:
    for (;;)
    {
      label77:
      this.DiR.setVisibility(8);
      localObject3 = new StringBuilder("liveCoverUrl:").append(localObject1).append(", liveData.audioModeHolderBm:");
      localObject1 = aj.CGT;
      localObject1 = (e)aj.business(e.class);
      if (localObject1 == null) {}
      for (localObject1 = localObject2;; localObject1 = ((e)localObject1).DVR)
      {
        Log.i("FinderLiveScreenShareWidget", localObject1);
        AppMethodBeat.o(354224);
        return;
        localObject1 = ((e)localObject1).Eco;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((FinderObjectDesc)localObject1).liveDesc;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((bgk)localObject1).EcY;
        break;
        label200:
        i = 0;
        break label51;
        label205:
        localObject1 = ((e)localObject1).Eco;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label77;
        }
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label77;
        }
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label77;
        }
        localObject1 = (FinderMedia)p.oL((List)localObject1);
        if (localObject1 == null)
        {
          localObject1 = "";
          break label77;
        }
        localObject3 = ((FinderMedia)localObject1).url;
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label77;
        }
        localObject1 = "";
        break label77;
      }
    }
  }
  
  final void erM()
  {
    AppMethodBeat.i(354229);
    Object localObject = this.DiQ.getParent();
    if ((localObject instanceof ViewGroup)) {}
    for (localObject = (ViewGroup)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewGroup)localObject).removeView((View)this.DiQ);
      }
      if (localObject != null) {
        ((ViewGroup)localObject).addView((View)this.DiQ);
      }
      AppMethodBeat.o(354229);
      return;
    }
  }
  
  public final void erO()
  {
    AppMethodBeat.i(354254);
    Object localObject = new com.tencent.mm.ad.i();
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.finder.live.report.j localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
    l = (l - com.tencent.mm.plugin.finder.live.report.j.Doc.DqB) / 1000L;
    ((com.tencent.mm.ad.i)localObject).n("type", Integer.valueOf(q.au.DzN.action));
    ((com.tencent.mm.ad.i)localObject).n("result", Long.valueOf(l));
    com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrG, ((com.tencent.mm.ad.i)localObject).toString());
    localObject = h.aZn();
    ((c)localObject).l("type", this.lPJ);
    ((c)localObject).l("time", Long.valueOf(l));
    localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
    com.tencent.mm.plugin.finder.live.report.j.Doc.DqC.cP(localObject);
    localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
    com.tencent.mm.plugin.finder.live.report.j.Doc.DqB = 0L;
    AppMethodBeat.o(354254);
  }
  
  public final void ry(boolean paramBoolean)
  {
    CharSequence localCharSequence = null;
    AppMethodBeat.i(354235);
    Object localObject = aj.CGT;
    localObject = (e)aj.business(e.class);
    label63:
    int i;
    if (localObject == null)
    {
      localObject = null;
      Log.i("FinderLiveScreenShareWidget", s.X("selectShareFile:", localObject));
      localObject = aj.CGT;
      localObject = (e)aj.business(e.class);
      if (localObject != null) {
        break label125;
      }
      localObject = localCharSequence;
      localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label133;
      }
      i = 1;
      label86:
      if ((i == 0) && (y.ZC((String)localObject)))
      {
        if (!paramBoolean) {
          break label138;
        }
        axk((String)localObject);
      }
    }
    for (;;)
    {
      erN();
      AppMethodBeat.o(354235);
      return;
      localObject = ((e)localObject).EeJ;
      break;
      label125:
      localObject = ((e)localObject).EeJ;
      break label63;
      label133:
      i = 0;
      break label86;
      label138:
      axl((String)localObject);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/MotionEvent;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.b<MotionEvent, kotlin.ah>
  {
    a(bw parambw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(bw parambw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bw
 * JD-Core Version:    0.7.0.1
 */