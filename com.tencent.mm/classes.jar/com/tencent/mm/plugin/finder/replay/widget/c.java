package com.tencent.mm.plugin.finder.replay.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.live.core.core.e.q;
import com.tencent.mm.plugin.finder.live.model.as.c;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.replay.FinderLiveThumbPlayerProxy;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPVideoSeiInfo;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayerWidget;", "", "context", "Landroid/content/Context;", "liveId", "", "(Landroid/content/Context;J)V", "innerReplayCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "seiType", "Lcom/tencent/thumbplayer/api/TPPlayerMsg$TPVideoSeiInfo;", "sei", "", "getLiveId", "()J", "playerView", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveThumbPlayerProxy;", "value", "Lcom/tencent/mm/plugin/finder/live/model/LiveSeiCallback$ReplayCallback;", "seiCallback", "getSeiCallback", "()Lcom/tencent/mm/plugin/finder/live/model/LiveSeiCallback$ReplayCallback;", "setSeiCallback", "(Lcom/tencent/mm/plugin/finder/live/model/LiveSeiCallback$ReplayCallback;)V", "adjustLayout", "", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "isLandscapeVideo", "isLandscapeLayout", "container", "Landroid/view/ViewGroup;", "screenSize", "Lkotlin/Pair;", "attachToParent", "parent", "index", "attachToParentAsFirst", "bindMediaInfo", "data", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getBindUrl", "", "getPlayer", "isFillScaleType", "isFitScaleType", "isPlaying", "moveToNewContainer", "newContainer", "mediaSize", "Landroid/util/Size;", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "clipOutline", "(Landroid/view/ViewGroup;Ljava/lang/Integer;Landroid/util/Size;Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;Z)V", "moveToNewContainerAtFirst", "pauseVideo", "playVideo", "offset", "(Ljava/lang/Integer;)V", "prepareToFirstFrame", "release", "resetPlayerViewSize", "seekVideo", "to", "", "afterSeekPlay", "setFillScaleType", "setFitScaleType", "stopVideo", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a Fnh;
  public final FinderLiveThumbPlayerProxy Fni;
  as.c Fnj;
  private final m<Integer, TPPlayerMsg.TPVideoSeiInfo, ah> Fnk;
  private final long liveId;
  
  static
  {
    AppMethodBeat.i(332875);
    Fnh = new a((byte)0);
    AppMethodBeat.o(332875);
  }
  
  public c(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(332852);
    this.liveId = paramLong;
    this.Fni = new FinderLiveThumbPlayerProxy(paramContext);
    this.Fni.setFullScreenEnjoy(true);
    this.Fni.setLoop(false);
    this.Fni.setMute(false);
    Log.i("FinderLiveReplayerWidget", "init " + hashCode() + " playerView:" + this.Fni.hashCode());
    this.Fnk = ((m)new b(this));
    AppMethodBeat.o(332852);
  }
  
  private static final void a(c paramc, ViewGroup paramViewGroup, Size paramSize, i.e parame, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(332867);
    s.u(paramc, "this$0");
    s.u(paramViewGroup, "$newContainer");
    s.u(paramSize, "$mediaSize");
    s.u(parame, "$scaleType");
    ah localah;
    if (parame == i.e.XYM)
    {
      parame = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      parame = com.tencent.mm.plugin.finder.utils.aw.b(ImageView.ScaleType.FIT_CENTER.ordinal(), paramViewGroup.getWidth(), paramViewGroup.getHeight(), paramSize.getWidth(), paramSize.getHeight());
      if (parame != null) {
        break label309;
      }
      localah = null;
      label80:
      if ((localah == null) && (paramViewGroup.getWidth() > 0) && (paramViewGroup.getHeight() > 0)) {
        paramc.Fni.ib(paramViewGroup.getWidth(), paramViewGroup.getHeight());
      }
      paramSize = new StringBuilder("resetViewSize:container:").append(paramViewGroup.hashCode()).append(" mediaSize width = ").append(paramSize.getWidth()).append(", height = ").append(paramSize.getHeight()).append(", container width = ").append(paramViewGroup.getWidth()).append(", height = ").append(paramViewGroup.getHeight()).append(", params width = ");
      if (parame != null) {
        break label344;
      }
      paramViewGroup = null;
      label190:
      paramSize = paramSize.append(paramViewGroup).append(", height = ");
      if (parame != null) {
        break label355;
      }
    }
    label309:
    label344:
    label355:
    for (paramViewGroup = localObject;; paramViewGroup = (Integer)parame.bsD)
    {
      Log.i("FinderLiveReplayerWidget", paramViewGroup);
      paramc.Fni.setVideoViewFocused(true);
      paramc.Fni.setMute(false);
      paramc.Fni.setAlpha(1.0F);
      paramc.Fni.setVisibility(0);
      if (paramBoolean) {
        paramc.Fni.bNU();
      }
      AppMethodBeat.o(332867);
      return;
      parame = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      parame = com.tencent.mm.plugin.finder.utils.aw.b(ImageView.ScaleType.CENTER_CROP.ordinal(), paramViewGroup.getWidth(), paramViewGroup.getHeight(), paramSize.getWidth(), paramSize.getHeight());
      break;
      paramc.Fni.ib(((Number)parame.bsC).intValue(), ((Number)parame.bsD).intValue());
      localah = ah.aiuX;
      break label80;
      paramViewGroup = (Integer)parame.bsC;
      break label190;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, Integer paramInteger, Size paramSize, i.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(332902);
    s.u(paramViewGroup, "newContainer");
    s.u(paramSize, "mediaSize");
    s.u(parame, "scaleType");
    boolean bool = this.Fni.isPlaying();
    Log.i("FinderLiveReplayerWidget", "moveToNewContainer " + hashCode() + " playerView:" + this.Fni.hashCode() + ",newContainer:" + paramViewGroup.hashCode() + ",isPlaying:" + bool + ",index:" + paramInteger + ",scaleType:" + parame);
    Object localObject = this.Fni;
    ((FinderLiveThumbPlayerProxy)localObject).Fln = true;
    ((FinderLiveThumbPlayerProxy)localObject).animate().cancel();
    ((FinderLiveThumbPlayerProxy)localObject).animate().setListener(null);
    localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.gg((View)this.Fni);
    this.Fni.setLoop(false);
    if (paramBoolean)
    {
      this.Fni.setClipToOutline(true);
      this.Fni.setOutlineProvider((ViewOutlineProvider)new com.tencent.mm.live.core.mini.d(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
      if (paramViewGroup.indexOfChild((View)this.Fni) == -1)
      {
        if (paramInteger == null) {
          break label295;
        }
        paramViewGroup.addView((View)this.Fni, paramInteger.intValue(), new ViewGroup.LayoutParams(-1, -1));
      }
    }
    for (;;)
    {
      paramViewGroup.post(new c..ExternalSyntheticLambda0(this, paramViewGroup, paramSize, parame, bool));
      AppMethodBeat.o(332902);
      return;
      this.Fni.setClipToOutline(false);
      break;
      label295:
      paramViewGroup.addView((View)this.Fni, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public final void a(as.c paramc)
  {
    AppMethodBeat.i(332890);
    this.Fni.setSeiInfoCallback(this.Fnk);
    this.Fnj = paramc;
    AppMethodBeat.o(332890);
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, boolean paramBoolean1, boolean paramBoolean2, ViewGroup paramViewGroup, r<Integer, Integer> paramr)
  {
    AppMethodBeat.i(332915);
    s.u(paramContext, "context");
    s.u(parama, "buContext");
    s.u(paramViewGroup, "container");
    if (this.Fni.getParent() == null)
    {
      Log.i("FinderLiveReplayerWidget", "adjustLayout playerView's parent is null!");
      AppMethodBeat.o(332915);
      return false;
    }
    Object localObject1 = this.Fni.getLayoutParams();
    Object localObject2;
    label99:
    int k;
    int j;
    int m;
    float f2;
    float f1;
    int i2;
    int i3;
    int i;
    if ((localObject1 instanceof RelativeLayout.LayoutParams))
    {
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      localObject2 = paramViewGroup.getLayoutParams();
      if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
        break label463;
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      k = 0;
      j = -1;
      m = 0;
      f2 = 0.0F;
      f1 = 0.0F;
      Object localObject3 = paramr;
      if (paramr == null)
      {
        paramr = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject3 = com.tencent.mm.plugin.finder.live.utils.a.gG(paramContext);
      }
      i2 = ((Number)((r)localObject3).bsC).intValue();
      i3 = ((Number)((r)localObject3).bsD).intValue();
      if ((!paramBoolean1) || (((e)parama.business(e.class)).eyM())) {
        break label782;
      }
      if (paramBoolean2) {
        break label672;
      }
      if (!((e)parama.business(e.class)).eyE()) {
        break label469;
      }
      paramContext = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      k = com.tencent.mm.plugin.finder.live.utils.a.euM();
      j = i2 / 2;
      i = (int)(1.777778F * j);
      j = (int)(j * 1.777778F);
    }
    for (;;)
    {
      label236:
      if (localObject2 != null) {
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = k;
      }
      if (localObject2 != null) {
        ((ViewGroup.MarginLayoutParams)localObject2).height = j;
      }
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).height = i;
      }
      for (;;)
      {
        try
        {
          paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.Fni.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          parama = new StringBuilder("adjustLayout container size:(").append(i2).append(" - ").append(i3).append("), isLandscapeVideo:").append(paramBoolean1).append(",videoScaleHeight:").append(m).append(",limitHeight:").append(f2).append(",landscapePlayerMiniHeight:").append(f1).append(",parentLp height:");
          if (localObject2 != null) {
            continue;
          }
          paramContext = null;
          parama = parama.append(paramContext).append(",top:");
          if (localObject2 != null) {
            continue;
          }
          paramContext = null;
          parama = parama.append(paramContext).append(", previewLp height:");
          if (localObject1 != null) {
            continue;
          }
          paramContext = null;
          parama = parama.append(paramContext).append(",top:");
          if (localObject1 != null) {
            continue;
          }
          paramContext = null;
          Log.i("FinderLiveReplayerWidget", paramContext);
          paramBoolean1 = true;
        }
        catch (Exception paramContext)
        {
          label463:
          label469:
          int n;
          int i1;
          label672:
          float f3;
          label782:
          parama = com.tencent.mm.plugin.finder.utils.aw.Gjk;
          com.tencent.mm.plugin.finder.utils.aw.a(paramContext, "FinderLiveReplayerWidget-adjustLayout");
          paramBoolean1 = false;
          continue;
          i = -1;
        }
        AppMethodBeat.o(332915);
        return paramBoolean1;
        localObject1 = null;
        break;
        localObject2 = null;
        break label99;
        f1 = i2;
        i = (int)(((e)parama.business(e.class)).videoHeight / ((e)parama.business(e.class)).videoWidth * f1);
        f2 = i3 * 0.688F;
        f1 = MMApplicationContext.getContext().getResources().getDimension(p.c.finder_32A);
        if (i <= f2)
        {
          n = (int)(0.156F * i3) + bf.getStatusBarHeight(paramContext);
          if (i < f1)
          {
            i1 = (int)f1;
            j = i1;
            k = n;
            if (localObject1 == null) {
              break label967;
            }
            ((RelativeLayout.LayoutParams)localObject1).addRule(16);
            m = i;
            j = i1;
            k = n;
            break label236;
          }
          m = i;
          j = i;
          k = i;
          i = j;
          j = k;
          k = n;
          break label236;
        }
        k = 0;
        i1 = 0;
        n = -1;
        j = n;
        if (localObject1 == null) {
          break label967;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(16);
        m = i;
        j = n;
        k = i1;
        break label236;
        if (!com.tencent.mm.ui.aw.jkS()) {
          continue;
        }
        if (((j)parama.business(j.class)).Efv == null)
        {
          paramContext = ((j)parama.business(j.class)).Efw;
          s.s(paramContext, "buContext.business(\n    …).audienceLinkMicUserList");
          if (!((Collection)paramContext).isEmpty())
          {
            i = 1;
            if (i == 0) {
              continue;
            }
          }
        }
        else
        {
          j = i2 / 2;
          f3 = com.tencent.mm.live.core.view.c.bhe();
          paramContext = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          k = com.tencent.mm.plugin.finder.live.utils.a.euM();
          i = (int)(j * f3);
          j = (int)(j * f3);
          break label236;
        }
        i = 0;
        continue;
        if (!com.tencent.mm.ui.aw.jkS()) {
          continue;
        }
        if (((j)parama.business(j.class)).Efv == null)
        {
          paramContext = ((j)parama.business(j.class)).Efw;
          s.s(paramContext, "buContext.business(\n    …).audienceLinkMicUserList");
          if (!((Collection)paramContext).isEmpty())
          {
            i = 1;
            if (i == 0) {
              continue;
            }
          }
        }
        else
        {
          j = i2 / 2;
          f3 = com.tencent.mm.live.core.view.c.bhe();
          paramContext = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          k = com.tencent.mm.plugin.finder.live.utils.a.euM();
          i = (int)(j * f3);
          j = (int)(j * f3);
          break label236;
        }
        i = 0;
        continue;
        paramContext = Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject2).height);
        continue;
        paramContext = Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject2).topMargin);
        continue;
        paramContext = Integer.valueOf(((RelativeLayout.LayoutParams)localObject1).height);
        continue;
        i = ((RelativeLayout.LayoutParams)localObject1).topMargin;
        paramContext = Integer.valueOf(i);
      }
      continue;
      label967:
      m = i;
    }
  }
  
  public final void eLS()
  {
    AppMethodBeat.i(332919);
    this.Fni.eLJ();
    AppMethodBeat.o(332919);
  }
  
  public final void eMd()
  {
    AppMethodBeat.i(332939);
    Log.i("FinderLiveReplayerWidget", "setFitScaleType " + hashCode() + " playerView:" + this.Fni.hashCode());
    this.Fni.setScaleType(i.e.XYM);
    AppMethodBeat.o(332939);
  }
  
  public final void eMe()
  {
    AppMethodBeat.i(332945);
    Log.i("FinderLiveReplayerWidget", "setFillScaleType " + hashCode() + " playerView:" + this.Fni.hashCode());
    this.Fni.setScaleType(i.e.XYN);
    AppMethodBeat.o(332945);
  }
  
  public final void release()
  {
    AppMethodBeat.i(332930);
    Log.i("FinderLiveReplayerWidget", "release " + hashCode() + " playerView:" + this.Fni.hashCode());
    this.Fni.onUIDestroy();
    this.Fni.setVideoViewCallback(null);
    AppMethodBeat.o(332930);
  }
  
  public final void stopVideo()
  {
    AppMethodBeat.i(332924);
    Log.i("FinderLiveReplayerWidget", "stopVideo " + hashCode() + " playerView:" + this.Fni.hashCode());
    this.Fni.stop();
    AppMethodBeat.o(332924);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayerWidget$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "seiType", "", "seiInfo", "Lcom/tencent/thumbplayer/api/TPPlayerMsg$TPVideoSeiInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Integer, TPPlayerMsg.TPVideoSeiInfo, ah>
  {
    b(c paramc)
    {
      super();
    }
    
    private static final void a(int paramInt, byte[] paramArrayOfByte, c paramc)
    {
      AppMethodBeat.i(332868);
      s.u(paramc, "this$0");
      if ((paramInt != 242) && (paramInt != 243) && (paramInt != 100))
      {
        paramArrayOfByte = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveReplayerWidget", s.X("handleSeiMessage seiType:", Integer.valueOf(paramInt)));
        AppMethodBeat.o(332868);
        return;
      }
      if (paramArrayOfByte != null) {
        if (paramArrayOfByte.length != 0) {
          break label87;
        }
      }
      label87:
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        Log.i("FinderLiveReplayerWidget", s.X("handleSeiMessage seiData:", paramArrayOfByte));
        AppMethodBeat.o(332868);
        return;
      }
      Object localObject = new String(paramArrayOfByte, kotlin.n.d.UTF_8);
      paramInt = n.g((CharSequence)localObject, "\\0");
      paramArrayOfByte = (byte[])localObject;
      if (paramInt != -1)
      {
        paramArrayOfByte = (byte[])localObject;
        if (paramInt == ((String)localObject).length() - 2)
        {
          paramArrayOfByte = ((String)localObject).substring(0, paramInt);
          s.s(paramArrayOfByte, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
      }
      if (n.i((CharSequence)paramArrayOfByte, (CharSequence)"TencentStreamSEI"))
      {
        AppMethodBeat.o(332868);
        return;
      }
      Log.i("FinderLiveReplayerWidget", s.X("handleSeiMessage final seiMessage:", paramArrayOfByte));
      do
      {
        try
        {
          localObject = new i(paramArrayOfByte);
          paramInt = ((i)localObject).optInt("wxT");
          if ((paramInt != 0) && (!Util.isNullOrNil(((i)localObject).optString("d"))))
          {
            if (!com.tencent.mm.ae.d.ee(paramInt, e.q.mLK.value)) {
              continue;
            }
            localBundle = new Bundle();
            localBundle.putString("live_cdn_sei_msg", ((i)localObject).optString("d"));
            paramc = paramc.Fnj;
            if (paramc != null) {
              paramc.ap(localBundle);
            }
            AppMethodBeat.o(332868);
          }
        }
        catch (Exception paramc)
        {
          Log.w("FinderLiveReplayerWidget", "handleSeiMessage Exception:" + paramc.getMessage() + " seiMessage:" + paramArrayOfByte);
          AppMethodBeat.o(332868);
          return;
        }
      } while (!com.tencent.mm.ae.d.ee(paramInt, e.q.mLM.value));
      Bundle localBundle = new Bundle();
      localBundle.putString("live_cdn_sei_msg", ((i)localObject).optString("d"));
      localBundle.putString("live_link_mic_info_in_anchor_sei_msg", ((i)localObject).optString("m"));
      paramc = paramc.Fnj;
      if (paramc != null) {
        paramc.ao(localBundle);
      }
      AppMethodBeat.o(332868);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.widget.c
 * JD-Core Version:    0.7.0.1
 */