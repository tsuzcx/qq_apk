package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.b.k;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a;
import com.tencent.mm.protocal.protobuf.ctg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/plugin/AudioPanelPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioCacheInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioCacheInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;", "audioStateListeners", "", "Lcom/tencent/mm/plugin/finder/video/plugin/AudioPanelPlugin$AudioStateListener;", "getAudioStateListeners", "()Ljava/util/List;", "setAudioStateListeners", "(Ljava/util/List;)V", "autoPlay", "", "getAutoPlay", "()Z", "setAutoPlay", "(Z)V", "disableRecommendMusic", "editorConfig", "Lcom/tencent/mm/plugin/recordvideo/config/EditorConfig;", "firstPlay", "getFirstPlay", "setFirstPlay", "firstPlayDelay", "", "getFirstPlayDelay", "()J", "setFirstPlayDelay", "(J)V", "localAudioList", "", "musicController", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "getParent", "()Landroid/view/ViewGroup;", "playRunnable", "Ljava/lang/Runnable;", "getPlayRunnable", "()Ljava/lang/Runnable;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "checkInitAudio", "", "isClickFinderAudioWhenShowRedDot", "isShowFinderRedDot", "isShowFinderSelectPanel", "onBackPress", "onPause", "onResume", "pause", "release", "reset", "resume", "seekTo", "time", "setLocalAudioList", "audioList", "setShow", "show", "setup", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "showMuteOrigin", "AudioStateListener", "plugin-finder_release"})
public final class a
  implements u
{
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  public com.tencent.mm.plugin.recordvideo.plugin.a.b AQa;
  public EditorAudioView AQb;
  public List<AudioCacheInfo> AQc;
  public final com.tencent.mm.plugin.recordvideo.b.d AQd;
  public boolean AQe;
  public AudioCacheInfo AQf;
  boolean AQg;
  long AQh;
  public List<Object> AQi;
  final Runnable AQj;
  public boolean autoPlay;
  public final ViewGroup parent;
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(275769);
    this.parent = paramViewGroup;
    this.APl = paramd;
    this.AQc = ((List)v.aaAd);
    this.AQd = new com.tencent.mm.plugin.recordvideo.b.d();
    this.AQg = true;
    this.AQh = 500L;
    this.AQi = ((List)new ArrayList());
    this.AQj = ((Runnable)new c(this));
    AppMethodBeat.o(275769);
  }
  
  public final void b(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(275759);
    if (paramRecordConfigProvider != null)
    {
      paramRecordConfigProvider = Integer.valueOf(paramRecordConfigProvider.scene);
      if (paramRecordConfigProvider != null) {
        break label61;
      }
      label21:
      if (paramRecordConfigProvider != null) {
        break label121;
      }
      label25:
      if (paramRecordConfigProvider != null) {
        break label143;
      }
      label29:
      if (paramRecordConfigProvider != null) {
        break label197;
      }
      label33:
      if (paramRecordConfigProvider != null) {
        break label219;
      }
    }
    for (;;)
    {
      this.AQd.HJI = false;
      this.AQe = false;
      AppMethodBeat.o(275759);
      return;
      paramRecordConfigProvider = null;
      break;
      label61:
      if (paramRecordConfigProvider.intValue() != 2) {
        break label21;
      }
      this.AQd.a(k.HKi);
      paramRecordConfigProvider = this.AQd;
      if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSK, 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramRecordConfigProvider.HJG = bool;
        break;
      }
      label121:
      if (paramRecordConfigProvider.intValue() != 1) {
        break label25;
      }
      this.AQd.a(k.HKn);
      continue;
      label143:
      if (paramRecordConfigProvider.intValue() != 3) {
        break label29;
      }
      this.AQd.a(k.HKh);
      this.AQd.HJG = true;
      this.AQd.HJJ = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUX, false);
      continue;
      label197:
      if (paramRecordConfigProvider.intValue() != 5) {
        break label33;
      }
      this.AQd.a(k.HKj);
      continue;
      label219:
      if (paramRecordConfigProvider.intValue() == 11)
      {
        this.AQd.a(k.HKr);
        this.AQd.HJG = false;
      }
    }
  }
  
  public final void bbp() {}
  
  public final String name()
  {
    AppMethodBeat.i(275770);
    String str = getClass().getName();
    AppMethodBeat.o(275770);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(275763);
    EditorAudioView localEditorAudioView = this.AQb;
    if ((localEditorAudioView != null) && (localEditorAudioView.onBackPress() == true))
    {
      AppMethodBeat.o(275763);
      return true;
    }
    AppMethodBeat.o(275763);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(275764);
    pause();
    AppMethodBeat.o(275764);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(275775);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(275775);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(275765);
    if ((this.autoPlay) && (this.AQf != null)) {
      resume();
    }
    AppMethodBeat.o(275765);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(275761);
    Object localObject = this.AQa;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).pauseAudio();
    }
    localObject = ((Iterable)this.AQi).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(275761);
  }
  
  public final void release()
  {
    AppMethodBeat.i(275768);
    this.AQf = null;
    Object localObject = this.AQa;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).release();
    }
    localObject = this.AQb;
    if (localObject != null)
    {
      ((EditorAudioView)localObject).destroy();
      AppMethodBeat.o(275768);
      return;
    }
    AppMethodBeat.o(275768);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(275767);
    if (this.AQf != null) {
      seekTo(0L);
    }
    AppMethodBeat.o(275767);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(275762);
    Object localObject = this.AQa;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).fxl();
    }
    localObject = ((Iterable)this.AQi).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(275762);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(275760);
    com.tencent.mm.plugin.recordvideo.plugin.a.b localb = this.AQa;
    if (localb != null)
    {
      localb.seekTo(paramLong);
      AppMethodBeat.o(275760);
      return;
    }
    AppMethodBeat.o(275760);
  }
  
  public final void setVisibility(int paramInt) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  public static final class a
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    public a(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/plugin/AudioPanelPlugin$checkInitAudio$2", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$AudioCallback;", "cancel", "", "confirm", "onAudioSelected", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "onLyricsSelected", "visible", "", "lyricsInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "onSearchAudioCancel", "onSearchAudioFinish", "pauseAudio", "toggleOrigin", "remove", "plugin-finder_release"})
  public static final class b
    implements EditorAudioView.a
  {
    public final void a(AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(283828);
      if (p.h(this.AQk.AQf, paramAudioCacheInfo))
      {
        if (this.AQk.AQf != null) {
          this.AQk.resume();
        }
        AppMethodBeat.o(283828);
        return;
      }
      if (paramAudioCacheInfo == null)
      {
        this.AQk.AQf = paramAudioCacheInfo;
        paramAudioCacheInfo = a.a(this.AQk);
        if (paramAudioCacheInfo != null) {
          paramAudioCacheInfo.fxk();
        }
        d.b.a(this.AQk.APl, d.c.HRZ);
        paramAudioCacheInfo = new Bundle();
        paramAudioCacheInfo.putBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN", false);
        this.AQk.APl.a(d.c.HSa, paramAudioCacheInfo);
        this.AQk.APl.a(d.c.HRv, null);
        AppMethodBeat.o(283828);
        return;
      }
      int i = paramAudioCacheInfo.type;
      AudioCacheInfo.a locala = AudioCacheInfo.HMa;
      if (i == AudioCacheInfo.fwh())
      {
        this.AQk.pause();
        d.b.a(this.AQk.APl, d.c.HRV);
        AppMethodBeat.o(283828);
        return;
      }
      this.AQk.AQf = paramAudioCacheInfo;
      d.b.a(this.AQk.APl, d.c.HRZ);
      if (this.AQk.AQg)
      {
        this.AQk.AQg = false;
        paramAudioCacheInfo = a.b(this.AQk);
        if (paramAudioCacheInfo != null)
        {
          paramAudioCacheInfo.postDelayed(this.AQk.AQj, this.AQk.AQh);
          AppMethodBeat.o(283828);
          return;
        }
        AppMethodBeat.o(283828);
        return;
      }
      if (this.AQk.autoPlay)
      {
        paramAudioCacheInfo = a.a(this.AQk);
        if (paramAudioCacheInfo != null)
        {
          paramAudioCacheInfo.e(this.AQk.AQf);
          AppMethodBeat.o(283828);
          return;
        }
        AppMethodBeat.o(283828);
        return;
      }
      paramAudioCacheInfo = a.a(this.AQk);
      if (paramAudioCacheInfo != null)
      {
        paramAudioCacheInfo.d(this.AQk.AQf);
        AppMethodBeat.o(283828);
        return;
      }
      AppMethodBeat.o(283828);
    }
    
    public final void b(AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(283829);
      p.k(paramAudioCacheInfo, "info");
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("EDIT_VLOG_SEARCH_MUSIC_FINISH_PARCELABLE", (Parcelable)paramAudioCacheInfo);
      this.AQk.APl.a(d.c.HSL, localBundle);
      AppMethodBeat.o(283829);
    }
    
    public final void e(boolean paramBoolean, List<? extends ctg> paramList)
    {
      AppMethodBeat.i(283833);
      p.k(paramList, "lyricsInfos");
      AppMethodBeat.o(283833);
    }
    
    public final void ehD()
    {
      AppMethodBeat.i(283830);
      d.b.a(this.AQk.APl, d.c.HSM);
      AppMethodBeat.o(283830);
    }
    
    public final void pauseAudio()
    {
      AppMethodBeat.i(283832);
      this.AQk.pause();
      AppMethodBeat.o(283832);
    }
    
    public final void ri(boolean paramBoolean)
    {
      AppMethodBeat.i(283831);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN", paramBoolean);
      this.AQk.APl.a(d.c.HRY, localBundle);
      AppMethodBeat.o(283831);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(275030);
      if (this.AQk.autoPlay)
      {
        localb = a.a(this.AQk);
        if (localb != null)
        {
          localb.e(this.AQk.AQf);
          AppMethodBeat.o(275030);
          return;
        }
        AppMethodBeat.o(275030);
        return;
      }
      com.tencent.mm.plugin.recordvideo.plugin.a.b localb = a.a(this.AQk);
      if (localb != null)
      {
        localb.d(this.AQk.AQf);
        AppMethodBeat.o(275030);
        return;
      }
      AppMethodBeat.o(275030);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.a
 * JD-Core Version:    0.7.0.1
 */