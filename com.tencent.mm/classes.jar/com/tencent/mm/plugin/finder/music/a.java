package com.tencent.mm.plugin.finder.music;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.h.a.f;
import com.google.android.exoplayer2.h.a.m;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "Lcom/google/android/exoplayer2/Player$EventListener;", "context", "Landroid/content/Context;", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "getContext", "()Landroid/content/Context;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "initPlayer", "", "isPlaying", "", "onLoadingChanged", "isLoading", "onPlaybackParametersChanged", "p0", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "pause", "play", "release", "stop", "Companion", "plugin-finder_release"})
public final class a
  implements q.a
{
  public static final a zBW;
  private final Context context;
  private v kLl;
  private bfg musicInfo;
  
  static
  {
    AppMethodBeat.i(265390);
    zBW = new a((byte)0);
    AppMethodBeat.o(265390);
  }
  
  public a(Context paramContext, bfg parambfg)
  {
    AppMethodBeat.i(265389);
    this.context = paramContext;
    this.musicInfo = parambfg;
    dLb();
    AppMethodBeat.o(265389);
  }
  
  private final void dLb()
  {
    AppMethodBeat.i(265381);
    if (this.kLl == null)
    {
      Log.i("FinderImgFeedMusicPlayer", "init musicId:" + this.musicInfo.BHW + ",musicName:" + this.musicInfo.name);
      this.kLl = com.google.android.exoplayer2.g.a(this.context, (com.google.android.exoplayer2.g.h)new com.google.android.exoplayer2.g.c());
      Object localObject1 = new n(this.context, x.i(this.context, "Finder.Player"), (com.google.android.exoplayer2.h.w)new com.google.android.exoplayer2.h.l());
      Object localObject2 = av.AJz;
      localObject2 = new m(new File(q.n(av.c(this.musicInfo), true)), (f)new com.google.android.exoplayer2.h.a.k(5242880L));
      com.google.android.exoplayer2.c.h localh = (com.google.android.exoplayer2.c.h)new com.google.android.exoplayer2.c.c();
      localObject1 = new i((com.google.android.exoplayer2.source.k)new com.google.android.exoplayer2.source.h(Uri.parse(this.musicInfo.SPV), (g.a)new com.google.android.exoplayer2.h.a.e((com.google.android.exoplayer2.h.a.a)localObject2, (g.a)localObject1), localh, null, null));
      localObject2 = this.kLl;
      if (localObject2 != null) {
        ((v)localObject2).a((q.a)this);
      }
      localObject2 = this.kLl;
      if (localObject2 != null)
      {
        ((v)localObject2).a((com.google.android.exoplayer2.source.k)localObject1);
        AppMethodBeat.o(265381);
        return;
      }
    }
    AppMethodBeat.o(265381);
  }
  
  public final void I(int paramInt) {}
  
  public final void a(com.google.android.exoplayer2.e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(265386);
    StringBuilder localStringBuilder = new StringBuilder("[onPlayerError] type:");
    if (parame != null)
    {
      localObject1 = Integer.valueOf(parame.type);
      localStringBuilder = localStringBuilder.append(localObject1).append(" , message:");
      if (parame == null) {
        break label116;
      }
    }
    label116:
    for (Object localObject1 = parame.getMessage();; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" ,cause:");
      localObject1 = localObject2;
      if (parame != null) {
        localObject1 = parame.getCause();
      }
      Log.i("FinderImgFeedMusicPlayer", localObject1);
      com.tencent.mm.plugin.report.service.h.IzE.p(1530L, 4L, 1L);
      AppMethodBeat.o(265386);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void a(r paramr, com.google.android.exoplayer2.g.g paramg) {}
  
  public final void aP(boolean paramBoolean)
  {
    AppMethodBeat.i(265388);
    Log.i("FinderImgFeedMusicPlayer", "[onLoadingChanged] isLoading:".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(265388);
  }
  
  public final void b(p paramp) {}
  
  public final void b(com.google.android.exoplayer2.w paramw, Object paramObject) {}
  
  public final void e(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(265387);
    Log.i("FinderImgFeedMusicPlayer", "[onPlayerStateChanged] playWhenReady:" + paramBoolean + " ,state:" + paramInt);
    AppMethodBeat.o(265387);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(265385);
    StringBuilder localStringBuilder = new StringBuilder("[isPlaying] state:");
    Object localObject = this.kLl;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((v)localObject).ra());
      Log.i("FinderImgFeedMusicPlayer", localObject);
      localObject = this.kLl;
      if (localObject == null) {
        break label129;
      }
    }
    label129:
    for (boolean bool = ((v)localObject).rb();; bool = false)
    {
      if (!bool) {
        break label134;
      }
      localObject = this.kLl;
      if ((localObject == null) || (((v)localObject).ra() != 3))
      {
        localObject = this.kLl;
        if ((localObject == null) || (((v)localObject).ra() != 2))
        {
          localObject = this.kLl;
          if ((localObject == null) || (((v)localObject).ra() != 1)) {
            break label134;
          }
        }
      }
      AppMethodBeat.o(265385);
      return true;
      localObject = null;
      break;
    }
    label134:
    AppMethodBeat.o(265385);
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(265383);
    if (isPlaying())
    {
      Log.i("FinderImgFeedMusicPlayer", "pause musicId:" + this.musicInfo.BHW + ",musicName:" + this.musicInfo.name + ",musicInfo:" + this.musicInfo);
      v localv = this.kLl;
      if (localv != null)
      {
        localv.aM(false);
        AppMethodBeat.o(265383);
        return;
      }
      AppMethodBeat.o(265383);
      return;
    }
    Log.i("FinderImgFeedMusicPlayer", "pause musicInfo:" + this.musicInfo + " failed, cause it is not playing");
    AppMethodBeat.o(265383);
  }
  
  public final void play()
  {
    AppMethodBeat.i(265382);
    dLb();
    boolean bool = com.tencent.mm.q.a.aAo();
    Log.i("FinderImgFeedMusicPlayer", "play musicId:" + this.musicInfo.BHW + ",musicName:" + this.musicInfo.name + ", needMute = " + bool);
    if (!bool)
    {
      v localv = this.kLl;
      if (localv != null)
      {
        localv.aM(true);
        AppMethodBeat.o(265382);
        return;
      }
    }
    AppMethodBeat.o(265382);
  }
  
  public final void release()
  {
    AppMethodBeat.i(265384);
    Log.i("FinderImgFeedMusicPlayer", "relsese musicId:" + this.musicInfo.BHW + ",musicName:" + this.musicInfo.name);
    Log.i("FinderImgFeedMusicPlayer", "stop musicId:" + this.musicInfo.BHW + ",musicName:" + this.musicInfo.name);
    if (isPlaying())
    {
      localv = this.kLl;
      if (localv != null) {
        localv.stop();
      }
    }
    v localv = this.kLl;
    if (localv != null) {
      localv.release();
    }
    this.kLl = null;
    AppMethodBeat.o(265384);
  }
  
  public final void rs() {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.a
 * JD-Core Version:    0.7.0.1
 */