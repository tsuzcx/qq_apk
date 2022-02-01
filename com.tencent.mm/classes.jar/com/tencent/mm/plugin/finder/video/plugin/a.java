package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.c.d;
import com.tencent.mm.plugin.recordvideo.c.k;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a;
import com.tencent.mm.plugin.vlog.a.e;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.protocal.protobuf.dki;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/plugin/AudioPanelPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioCacheInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioCacheInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;", "audioStateListeners", "", "Lcom/tencent/mm/plugin/finder/video/plugin/AudioPanelPlugin$AudioStateListener;", "getAudioStateListeners", "()Ljava/util/List;", "setAudioStateListeners", "(Ljava/util/List;)V", "autoPlay", "", "getAutoPlay", "()Z", "setAutoPlay", "(Z)V", "disableRecommendMusic", "editorConfig", "Lcom/tencent/mm/plugin/recordvideo/config/EditorConfig;", "firstPlay", "getFirstPlay", "setFirstPlay", "firstPlayDelay", "", "getFirstPlayDelay", "()J", "setFirstPlayDelay", "(J)V", "localAudioList", "", "musicController", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "getParent", "()Landroid/view/ViewGroup;", "playRunnable", "Ljava/lang/Runnable;", "getPlayRunnable", "()Ljava/lang/Runnable;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "checkInitAudio", "", "isClickFinderAudioWhenShowRedDot", "isShowFinderRedDot", "isShowFinderSelectPanel", "onBackPress", "onPause", "onResume", "pause", "release", "reset", "resume", "seekTo", "time", "setLocalAudioList", "audioList", "setShow", "show", "setup", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "showMuteOrigin", "AudioStateListener", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements v
{
  final com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private com.tencent.mm.plugin.recordvideo.plugin.a.b Gsn;
  public EditorAudioView Gso;
  public List<AudioCacheInfo> Gsp;
  private final d Gsq;
  private boolean Gsr;
  public AudioCacheInfo Gss;
  boolean Gst;
  long Gsu;
  public List<Object> Gsv;
  final Runnable Gsw;
  public boolean autoPlay;
  private final ViewGroup parent;
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(335450);
    this.parent = paramViewGroup;
    this.GrC = parama;
    this.Gsp = ((List)ab.aivy);
    this.Gsq = new d();
    this.Gst = true;
    this.Gsu = 500L;
    this.Gsv = ((List)new ArrayList());
    this.Gsw = new a..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(335450);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(335459);
    s.u(parama, "this$0");
    com.tencent.mm.plugin.recordvideo.plugin.a.b localb;
    if (parama.autoPlay)
    {
      localb = parama.Gsn;
      if (localb != null)
      {
        localb.e(parama.Gss);
        AppMethodBeat.o(335459);
      }
    }
    else
    {
      localb = parama.Gsn;
      if (localb != null) {
        localb.d(parama.Gss);
      }
    }
    AppMethodBeat.o(335459);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(335606);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(335606);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(335628);
    s.u(this, "this");
    AppMethodBeat.o(335628);
  }
  
  public final void d(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(335520);
    if (paramRecordConfigProvider == null)
    {
      paramRecordConfigProvider = null;
      if (paramRecordConfigProvider != null) {
        break label61;
      }
      label15:
      if (paramRecordConfigProvider != null) {
        break label121;
      }
      label19:
      if (paramRecordConfigProvider != null) {
        break label143;
      }
      label23:
      if (paramRecordConfigProvider != null) {
        break label197;
      }
      label27:
      if (paramRecordConfigProvider != null) {
        break label219;
      }
    }
    for (;;)
    {
      this.Gsq.NGH = false;
      this.Gsr = false;
      AppMethodBeat.o(335520);
      return;
      paramRecordConfigProvider = Integer.valueOf(paramRecordConfigProvider.scene);
      break;
      label61:
      if (paramRecordConfigProvider.intValue() != 2) {
        break label15;
      }
      this.Gsq.a(k.NHg);
      paramRecordConfigProvider = this.Gsq;
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zlo, 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramRecordConfigProvider.NGF = bool;
        break;
      }
      label121:
      if (paramRecordConfigProvider.intValue() != 1) {
        break label19;
      }
      this.Gsq.a(k.NHl);
      continue;
      label143:
      if (paramRecordConfigProvider.intValue() != 3) {
        break label23;
      }
      this.Gsq.a(k.NHf);
      this.Gsq.NGF = true;
      this.Gsq.NGI = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znB, false);
      continue;
      label197:
      if (paramRecordConfigProvider.intValue() != 5) {
        break label27;
      }
      this.Gsq.a(k.NHh);
      continue;
      label219:
      if (paramRecordConfigProvider.intValue() == 11)
      {
        this.Gsq.a(k.NHp);
        this.Gsq.NGF = false;
      }
    }
  }
  
  public final void fjH()
  {
    AppMethodBeat.i(335502);
    if (this.Gso != null)
    {
      AppMethodBeat.o(335502);
      return;
    }
    Object localObject = this.parent.getContext();
    s.s(localObject, "parent.context");
    this.Gso = new EditorAudioView((Context)localObject);
    localObject = this.Gso;
    if (localObject != null) {
      ((EditorAudioView)localObject).setVisibility(8);
    }
    this.parent.addView((View)this.Gso);
    localObject = this.parent.getContext();
    s.s(localObject, "parent.context");
    this.Gsn = new com.tencent.mm.plugin.recordvideo.plugin.a.b((Context)localObject);
    localObject = this.Gso;
    if (localObject != null) {
      ((EditorAudioView)localObject).setBackground(a.e.video_edit_panel_bg);
    }
    localObject = this.Gso;
    if (localObject != null) {
      ((EditorAudioView)localObject).setOnVisibleChangeCallback((kotlin.g.a.b)new a(this));
    }
    localObject = this.Gso;
    if (localObject != null) {
      ((EditorAudioView)localObject).Bt(w.hQS());
    }
    localObject = this.Gso;
    if (localObject != null) {
      EditorAudioView.a((EditorAudioView)localObject, Integer.valueOf(a.e.bg_story_audio_finish_btn), null, null, Integer.valueOf(a.e.story_cursor_orange), null, Integer.valueOf(a.h.popvideo_post_selected_origin), null, null, null, null, null, null, null, true, 8144);
    }
    localObject = this.Gso;
    if (localObject != null) {
      ((EditorAudioView)localObject).setCallback((EditorAudioView.a)new b(this));
    }
    localObject = this.Gso;
    if (localObject != null) {
      ((EditorAudioView)localObject).setLocalAudioList(this.Gsp);
    }
    localObject = this.Gso;
    if (localObject != null) {
      EditorAudioView.a((EditorAudioView)localObject, "", new ArrayList(), -1L, -1L, false, this.Gsq, this.Gsr, 16);
    }
    AppMethodBeat.o(335502);
  }
  
  public final String name()
  {
    AppMethodBeat.i(335613);
    String str = v.a.b(this);
    AppMethodBeat.o(335613);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(335620);
    s.u(this, "this");
    AppMethodBeat.o(335620);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(335551);
    EditorAudioView localEditorAudioView = this.Gso;
    if ((localEditorAudioView != null) && (localEditorAudioView.onBackPress() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(335551);
      return true;
    }
    s.u((v)this, "this");
    AppMethodBeat.o(335551);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(335636);
    s.u(this, "this");
    AppMethodBeat.o(335636);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(335559);
    s.u((v)this, "this");
    pause();
    AppMethodBeat.o(335559);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(335643);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(335643);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(335565);
    s.u((v)this, "this");
    if ((this.autoPlay) && (this.Gss != null)) {
      resume();
    }
    AppMethodBeat.o(335565);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(335534);
    Object localObject = this.Gsn;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).pauseAudio();
    }
    localObject = ((Iterable)this.Gsv).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(335534);
  }
  
  public final void release()
  {
    AppMethodBeat.i(335597);
    s.u((v)this, "this");
    this.Gss = null;
    Object localObject = this.Gsn;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).release();
    }
    localObject = this.Gso;
    if (localObject != null) {
      ((EditorAudioView)localObject).destroy();
    }
    AppMethodBeat.o(335597);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(335575);
    s.u((v)this, "this");
    if (this.Gss != null) {
      seekTo(0L);
    }
    AppMethodBeat.o(335575);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(335540);
    Object localObject = this.Gsn;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).gIX();
    }
    localObject = ((Iterable)this.Gsv).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(335540);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(335526);
    com.tencent.mm.plugin.recordvideo.plugin.a.b localb = this.Gsn;
    if (localb != null) {
      localb.seekTo(paramLong);
    }
    AppMethodBeat.o(335526);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(335652);
    s.u(this, "this");
    AppMethodBeat.o(335652);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    a(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/plugin/AudioPanelPlugin$checkInitAudio$2", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$AudioCallback;", "cancel", "", "confirm", "onAudioSelected", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "onLyricsSelected", "visible", "", "lyricsInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "onSearchAudioCancel", "onSearchAudioFinish", "pauseAudio", "toggleOrigin", "remove", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements EditorAudioView.a
  {
    b(a parama) {}
    
    public final void a(AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(335401);
      if (s.p(this.Gsx.Gss, paramAudioCacheInfo))
      {
        if (this.Gsx.Gss != null) {
          this.Gsx.resume();
        }
        AppMethodBeat.o(335401);
        return;
      }
      if (paramAudioCacheInfo == null)
      {
        this.Gsx.Gss = paramAudioCacheInfo;
        paramAudioCacheInfo = a.b(this.Gsx);
        if (paramAudioCacheInfo != null) {
          paramAudioCacheInfo.gIW();
        }
        com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.Gsx.GrC, a.c.NOF);
        paramAudioCacheInfo = new Bundle();
        paramAudioCacheInfo.putBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN", false);
        this.Gsx.GrC.a(a.c.NOG, paramAudioCacheInfo);
        this.Gsx.GrC.a(a.c.NOb, null);
        AppMethodBeat.o(335401);
        return;
      }
      int i = paramAudioCacheInfo.type;
      Object localObject = AudioCacheInfo.NIB;
      if (i == AudioCacheInfo.gHQ())
      {
        this.Gsx.pause();
        com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.Gsx.GrC, a.c.NOB);
        AppMethodBeat.o(335401);
        return;
      }
      this.Gsx.Gss = paramAudioCacheInfo;
      com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.Gsx.GrC, a.c.NOF);
      if (this.Gsx.Gst)
      {
        this.Gsx.Gst = false;
        localObject = a.c(this.Gsx);
        if (localObject != null) {
          ((EditorAudioView)localObject).postDelayed(this.Gsx.Gsw, this.Gsx.Gsu);
        }
      }
      for (;;)
      {
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.gIh();
        if (localObject != null) {
          ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject).kG(paramAudioCacheInfo.NID, paramAudioCacheInfo.source);
        }
        AppMethodBeat.o(335401);
        return;
        if (this.Gsx.autoPlay)
        {
          localObject = a.b(this.Gsx);
          if (localObject != null) {
            ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).e(this.Gsx.Gss);
          }
        }
        else
        {
          localObject = a.b(this.Gsx);
          if (localObject != null) {
            ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).d(this.Gsx.Gss);
          }
        }
      }
    }
    
    public final void b(AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(335413);
      s.u(paramAudioCacheInfo, "info");
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("EDIT_VLOG_SEARCH_MUSIC_FINISH_PARCELABLE", (Parcelable)paramAudioCacheInfo);
      this.Gsx.GrC.a(a.c.NPr, localBundle);
      AppMethodBeat.o(335413);
    }
    
    public final void fjI()
    {
      AppMethodBeat.i(335420);
      com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.Gsx.GrC, a.c.NPs);
      AppMethodBeat.o(335420);
    }
    
    public final void g(boolean paramBoolean, List<? extends dki> paramList)
    {
      AppMethodBeat.i(335441);
      s.u(paramList, "lyricsInfos");
      AppMethodBeat.o(335441);
    }
    
    public final void pauseAudio()
    {
      AppMethodBeat.i(335433);
      this.Gsx.pause();
      AppMethodBeat.o(335433);
    }
    
    public final void uJ(boolean paramBoolean)
    {
      AppMethodBeat.i(335429);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN", paramBoolean);
      this.Gsx.GrC.a(a.c.NOE, localBundle);
      AppMethodBeat.o(335429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.a
 * JD-Core Version:    0.7.0.1
 */