package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAudioModePreviewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "audioModePreview", "Landroid/widget/ImageView;", "canClearScreenWhenSideBarShow", "", "checkAudioMode", "", "isAudioMode", "fillAudioModeView", "coverUrl", "avatarUrl", "choosePath", "notifyAudioModePreviewReLayout", "micUserMap", "", "Landroid/graphics/Rect;", "onMicUserChanged", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "visibleInCurrentLiveMode", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends b
{
  private final ImageView CWZ;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  public ab(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355643);
    this.nfT = paramb;
    this.TAG = "Finder.FinderLiveAudioModePreviewPlugin";
    paramViewGroup = paramViewGroup.findViewById(p.e.BGJ);
    s.s(paramViewGroup, "root.findViewById(R.id.f…_live_audio_mode_preview)");
    this.CWZ = ((ImageView)paramViewGroup);
    AppMethodBeat.o(355643);
  }
  
  private final void ag(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(355646);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramString1, paramString2, paramString3));
    AppMethodBeat.o(355646);
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(355684);
    s.u(paramLinkedHashMap, "micUserMap");
    paramLinkedHashMap = (Rect)((Map)paramLinkedHashMap).get(((f)business(f.class)).mZr.aaOw);
    if (paramLinkedHashMap == null)
    {
      paramLinkedHashMap = new Rect();
      localObject = this.mJe.getLayoutParams();
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        break label107;
      }
    }
    label107:
    for (Object localObject = (ViewGroup.MarginLayoutParams)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject).width = paramLinkedHashMap.width();
        ((ViewGroup.MarginLayoutParams)localObject).height = paramLinkedHashMap.height();
        this.mJe.requestLayout();
      }
      AppMethodBeat.o(355684);
      return;
      break;
    }
  }
  
  public final boolean enH()
  {
    return false;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 0;
    Object localObject = null;
    AppMethodBeat.i(355673);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    boolean bool1;
    boolean bool2;
    if (a.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      if (paramBundle != null) {
        break label256;
      }
      bool1 = false;
      if (paramBundle != null) {
        break label269;
      }
      bool2 = false;
      label48:
      paramBundle = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("checkAudioMode isAudioMode:").append(bool1).append(" business(LiveCommonSlice::class.java).audioModeHolderBm:").append(((e)business(e.class)).DVR).append(" liveDesc.cover:");
      paramc = ((e)business(e.class)).Eco;
      if (paramc != null) {
        break label282;
      }
      paramc = null;
      label113:
      localStringBuilder = localStringBuilder.append(paramc).append(" media.url:");
      paramc = ((e)business(e.class)).Eco;
      if (paramc != null) {
        break label318;
      }
      paramc = null;
      label145:
      Log.i(paramBundle, paramc);
      paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUC()) {
        break label382;
      }
      if (!bool1) {
        break label374;
      }
      ag(((e)business(e.class)).Eei.coverUrl, ((e)business(e.class)).Eei.nVM, ((e)business(e.class)).Eei.Ebq);
    }
    for (;;)
    {
      if (bool2) {
        tO(4);
      }
      Log.i(this.TAG, s.X("FINDER_LIVE_MODE_SWITCH isAudioMode:", Boolean.valueOf(bool1)));
      AppMethodBeat.o(355673);
      return;
      label256:
      bool1 = paramBundle.getBoolean("PARAM_FINDER_LIVE_AUDIO_MODE", false);
      break;
      label269:
      bool2 = paramBundle.getBoolean("PARAM_FINDER_LIVE_IS_SHARE_MODE", false);
      break label48;
      label282:
      paramc = paramc.objectDesc;
      if (paramc == null)
      {
        paramc = null;
        break label113;
      }
      paramc = paramc.liveDesc;
      if (paramc == null)
      {
        paramc = null;
        break label113;
      }
      paramc = paramc.EcY;
      break label113;
      label318:
      paramc = paramc.objectDesc;
      if (paramc == null)
      {
        paramc = null;
        break label145;
      }
      paramc = paramc.media;
      if (paramc == null)
      {
        paramc = null;
        break label145;
      }
      paramc = (FinderMedia)p.oL((List)paramc);
      if (paramc == null)
      {
        paramc = null;
        break label145;
      }
      paramc = paramc.url;
      break label145;
      label374:
      tO(4);
    }
    label382:
    if (bool1)
    {
      paramc = ((e)business(e.class)).Eco;
      if (paramc == null)
      {
        paramc = localObject;
        paramBundle = (CharSequence)paramc;
        if ((paramBundle == null) || (paramBundle.length() == 0)) {
          i = 1;
        }
        if (i == 0) {
          break label578;
        }
        paramc = ((e)business(e.class)).Eco;
        if (paramc != null) {
          break label498;
        }
        paramc = "";
      }
    }
    label407:
    label578:
    for (;;)
    {
      ag(paramc, "", "");
      break;
      paramBundle = paramc.objectDesc;
      paramc = localObject;
      if (paramBundle == null) {
        break label407;
      }
      paramBundle = paramBundle.liveDesc;
      paramc = localObject;
      if (paramBundle == null) {
        break label407;
      }
      paramc = paramBundle.EcY;
      break label407;
      label498:
      paramc = paramc.objectDesc;
      if (paramc == null)
      {
        paramc = "";
      }
      else
      {
        paramc = paramc.media;
        if (paramc == null)
        {
          paramc = "";
        }
        else
        {
          paramc = (FinderMedia)p.oL((List)paramc);
          if (paramc == null)
          {
            paramc = "";
          }
          else
          {
            paramBundle = paramc.url;
            paramc = paramBundle;
            if (paramBundle == null)
            {
              paramc = "";
              continue;
              tO(4);
              break;
            }
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(ab paramab, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
    
    private static final void a(final ab paramab, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
    {
      AppMethodBeat.i(353690);
      s.u(paramab, "this$0");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramBitmap, paramab));
      AppMethodBeat.o(353690);
    }
    
    private static final void b(final ab paramab, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
    {
      AppMethodBeat.i(353692);
      s.u(paramab, "this$0");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramBitmap, paramab));
      AppMethodBeat.o(353692);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(Bitmap paramBitmap, ab paramab)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(Bitmap paramBitmap, ab paramab)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ab
 * JD-Core Version:    0.7.0.1
 */