package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashMap<Ljava.lang.String;Landroid.graphics.Rect;>;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAudioModePreviewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "audioModePreview", "Landroid/widget/ImageView;", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "checkAudioMode", "", "isAudioMode", "", "fillAudioModeView", "coverUrl", "avatarUrl", "choosePath", "notifyAudioModePreviewReLayout", "userIdList", "", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class af
  extends d
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private final ImageView ynX;
  
  public af(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(256084);
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveAudioModePreviewPlugin";
    paramViewGroup = paramViewGroup.findViewById(b.f.finder_live_audio_mode_preview);
    p.j(paramViewGroup, "root.findViewById(R.id.f…_live_audio_mode_preview)");
    this.ynX = ((ImageView)paramViewGroup);
    AppMethodBeat.o(256084);
  }
  
  private final void ad(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(256079);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramString1, paramString2, paramString3));
    AppMethodBeat.o(256079);
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(256083);
    p.k(paramLinkedHashMap, "micUserMap");
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)paramLinkedHashMap.keySet());
    switch (((List)localObject).size())
    {
    }
    do
    {
      AppMethodBeat.o(256083);
      return;
      localObject = this.kiF.getLayoutParams();
      paramLinkedHashMap = (LinkedHashMap<String, Rect>)localObject;
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        paramLinkedHashMap = null;
      }
      paramLinkedHashMap = (ViewGroup.MarginLayoutParams)paramLinkedHashMap;
      if (paramLinkedHashMap != null)
      {
        paramLinkedHashMap.width = -1;
        paramLinkedHashMap.height = -1;
        this.kiF.requestLayout();
        AppMethodBeat.o(256083);
        return;
      }
      AppMethodBeat.o(256083);
      return;
      localObject = this.kiF.getLayoutParams();
      paramLinkedHashMap = (LinkedHashMap<String, Rect>)localObject;
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        paramLinkedHashMap = null;
      }
      paramLinkedHashMap = (ViewGroup.MarginLayoutParams)paramLinkedHashMap;
      if (paramLinkedHashMap != null)
      {
        paramLinkedHashMap.width = (ax.au(this.kiF.getContext()).x / 2);
        paramLinkedHashMap.height = -1;
        this.kiF.requestLayout();
        AppMethodBeat.o(256083);
        return;
      }
      AppMethodBeat.o(256083);
      return;
      localObject = this.kiF.getLayoutParams();
      paramLinkedHashMap = (LinkedHashMap<String, Rect>)localObject;
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        paramLinkedHashMap = null;
      }
      paramLinkedHashMap = (ViewGroup.MarginLayoutParams)paramLinkedHashMap;
      if (paramLinkedHashMap != null)
      {
        paramLinkedHashMap.width = (ax.au(this.kiF.getContext()).x / 2);
        paramLinkedHashMap.height = -1;
        this.kiF.requestLayout();
        AppMethodBeat.o(256083);
        return;
      }
      AppMethodBeat.o(256083);
      return;
      localObject = this.kiF.getLayoutParams();
      paramLinkedHashMap = (LinkedHashMap<String, Rect>)localObject;
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        paramLinkedHashMap = null;
      }
      paramLinkedHashMap = (ViewGroup.MarginLayoutParams)paramLinkedHashMap;
    } while (paramLinkedHashMap == null);
    paramLinkedHashMap.width = (ax.au(this.kiF.getContext()).x / 2);
    paramLinkedHashMap.height = ((int)(1.777778F * paramLinkedHashMap.width) / 2);
    this.kiF.requestLayout();
    AppMethodBeat.o(256083);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    int i = 0;
    AppMethodBeat.i(256082);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ag.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(256082);
      return;
    }
    boolean bool;
    if (paramBundle != null)
    {
      bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_AUDIO_MODE", false);
      label67:
      paramBundle = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("checkAudioMode isAudioMode:").append(bool).append(" business(LiveCommonSlice::class.java).audioModeHolderBm:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgo).append(" liveDesc.cover:");
      paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
      if (paramc == null) {
        break label374;
      }
      paramc = paramc.objectDesc;
      if (paramc == null) {
        break label374;
      }
      paramc = paramc.liveDesc;
      if (paramc == null) {
        break label374;
      }
      paramc = paramc.zfA;
      label153:
      localStringBuilder = localStringBuilder.append(paramc).append(" media.url:");
      paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
      if (paramc == null) {
        break label379;
      }
      paramc = paramc.objectDesc;
      if (paramc == null) {
        break label379;
      }
      paramc = paramc.media;
      if (paramc == null) {
        break label379;
      }
      paramc = (FinderMedia)j.lp((List)paramc);
      if (paramc == null) {
        break label379;
      }
      paramc = paramc.url;
      label222:
      Log.i(paramBundle, paramc);
      paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.dEA()) {
        break label393;
      }
      if (!bool) {
        break label384;
      }
      ad(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgn.coverUrl, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgn.nfY, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgn.zex);
    }
    for (;;)
    {
      paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.dEA()) {
        break label559;
      }
      paramc = ah.yhC;
      paramc = (com.tencent.mm.live.core.core.trtc.a)ah.dzB();
      label320:
      if (paramc != null)
      {
        paramc = paramc.knA;
        if ((paramc != null) && (paramc.kmG == true)) {
          tU(8);
        }
      }
      Log.i(this.TAG, "FINDER_LIVE_MODE_SWITCH isAudioMode:".concat(String.valueOf(bool)));
      break;
      bool = false;
      break label67;
      label374:
      paramc = null;
      break label153;
      label379:
      paramc = null;
      break label222;
      label384:
      tU(8);
    }
    label393:
    if (bool)
    {
      paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
      paramc = localObject;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.objectDesc;
        paramc = localObject;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.liveDesc;
          paramc = localObject;
          if (paramBundle != null) {
            paramc = paramBundle.zfA;
          }
        }
      }
      paramBundle = (CharSequence)paramc;
      if ((paramBundle == null) || (paramBundle.length() == 0)) {
        i = 1;
      }
      if (i == 0) {
        break label573;
      }
      paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
      if (paramc != null)
      {
        paramc = paramc.objectDesc;
        if (paramc != null)
        {
          paramc = paramc.media;
          if (paramc != null)
          {
            paramc = (FinderMedia)j.lp((List)paramc);
            if (paramc != null)
            {
              paramBundle = paramc.url;
              paramc = paramBundle;
              if (paramBundle != null) {
                break label536;
              }
            }
          }
        }
      }
      paramc = "";
    }
    label536:
    label559:
    label573:
    for (;;)
    {
      ad(paramc, "", "");
      break;
      tU(8);
      break;
      paramc = ah.yhC;
      paramc = (com.tencent.mm.live.core.core.trtc.a)ah.dzA();
      break label320;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(af paramaf, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.af
 * JD-Core Version:    0.7.0.1
 */