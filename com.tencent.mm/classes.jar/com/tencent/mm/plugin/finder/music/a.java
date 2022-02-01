package com.tencent.mm.plugin.finder.music;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.h.a.f;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.h.w;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "Lcom/google/android/exoplayer2/Player$EventListener;", "context", "Landroid/content/Context;", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "getContext", "()Landroid/content/Context;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "initPlayer", "", "isPlaying", "", "onLoadingChanged", "isLoading", "onPlaybackParametersChanged", "p0", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "pause", "play", "release", "stop", "Companion", "plugin-finder_release"})
public final class a
  implements q.a
{
  public static final a.a uPB;
  private final Context context;
  private v hWJ;
  private azk musicInfo;
  
  static
  {
    AppMethodBeat.i(248927);
    uPB = new a.a((byte)0);
    AppMethodBeat.o(248927);
  }
  
  public a(Context paramContext, azk paramazk)
  {
    AppMethodBeat.i(248926);
    this.context = paramContext;
    this.musicInfo = paramazk;
    dlb();
    AppMethodBeat.o(248926);
  }
  
  private final void dlb()
  {
    AppMethodBeat.i(248918);
    if (this.hWJ == null)
    {
      Log.i("FinderImgFeedMusicPlayer", "init musicId:" + this.musicInfo.wWb + ",musicName:" + this.musicInfo.name);
      this.hWJ = g.a(this.context, (com.google.android.exoplayer2.g.h)new com.google.android.exoplayer2.g.c());
      Object localObject1 = new n(this.context, x.h(this.context, "Finder.Player"), (w)new com.google.android.exoplayer2.h.l());
      Object localObject2 = al.waC;
      localObject2 = new com.google.android.exoplayer2.h.a.l(new File(q.k(al.c(this.musicInfo), true)), (f)new com.google.android.exoplayer2.h.a.k(5242880L));
      com.google.android.exoplayer2.c.h localh = (com.google.android.exoplayer2.c.h)new com.google.android.exoplayer2.c.c();
      localObject1 = new i((com.google.android.exoplayer2.source.k)new com.google.android.exoplayer2.source.h(Uri.parse(this.musicInfo.LJi), (g.a)new com.google.android.exoplayer2.h.a.e((com.google.android.exoplayer2.h.a.a)localObject2, (g.a)localObject1), localh, null, null));
      localObject2 = this.hWJ;
      if (localObject2 != null) {
        ((v)localObject2).a((q.a)this);
      }
      localObject2 = this.hWJ;
      if (localObject2 != null)
      {
        ((v)localObject2).a((com.google.android.exoplayer2.source.k)localObject1);
        AppMethodBeat.o(248918);
        return;
      }
    }
    AppMethodBeat.o(248918);
  }
  
  public final void a(com.google.android.exoplayer2.e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(248923);
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
      com.tencent.mm.plugin.report.service.h.CyF.n(1530L, 4L, 1L);
      AppMethodBeat.o(248923);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void aA(int paramInt) {}
  
  public final void aR(boolean paramBoolean)
  {
    AppMethodBeat.i(248925);
    Log.i("FinderImgFeedMusicPlayer", "[onLoadingChanged] isLoading:".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(248925);
  }
  
  public final void b(p paramp) {}
  
  public final void c(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(248924);
    Log.i("FinderImgFeedMusicPlayer", "[onPlayerStateChanged] playWhenReady:" + paramBoolean + " ,state:" + paramInt);
    AppMethodBeat.o(248924);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(248922);
    StringBuilder localStringBuilder = new StringBuilder("[isPlaying] state:");
    Object localObject = this.hWJ;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((v)localObject).ti());
      Log.i("FinderImgFeedMusicPlayer", localObject);
      localObject = this.hWJ;
      if (localObject == null) {
        break label129;
      }
    }
    label129:
    for (boolean bool = ((v)localObject).tj();; bool = false)
    {
      if (!bool) {
        break label134;
      }
      localObject = this.hWJ;
      if ((localObject == null) || (((v)localObject).ti() != 3))
      {
        localObject = this.hWJ;
        if ((localObject == null) || (((v)localObject).ti() != 2))
        {
          localObject = this.hWJ;
          if ((localObject == null) || (((v)localObject).ti() != 1)) {
            break label134;
          }
        }
      }
      AppMethodBeat.o(248922);
      return true;
      localObject = null;
      break;
    }
    label134:
    AppMethodBeat.o(248922);
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(248920);
    if (isPlaying())
    {
      Log.i("FinderImgFeedMusicPlayer", "pause musicId:" + this.musicInfo.wWb + ",musicName:" + this.musicInfo.name + ",musicInfo:" + this.musicInfo);
      v localv = this.hWJ;
      if (localv != null)
      {
        localv.aO(false);
        AppMethodBeat.o(248920);
        return;
      }
      AppMethodBeat.o(248920);
      return;
    }
    Log.i("FinderImgFeedMusicPlayer", "pause musicInfo:" + this.musicInfo + " failed, cause it is not playing");
    AppMethodBeat.o(248920);
  }
  
  public final void play()
  {
    AppMethodBeat.i(248919);
    dlb();
    Log.i("FinderImgFeedMusicPlayer", "play musicId:" + this.musicInfo.wWb + ",musicName:" + this.musicInfo.name);
    v localv = this.hWJ;
    if (localv != null)
    {
      localv.aO(true);
      AppMethodBeat.o(248919);
      return;
    }
    AppMethodBeat.o(248919);
  }
  
  public final void release()
  {
    AppMethodBeat.i(248921);
    Log.i("FinderImgFeedMusicPlayer", "relsese musicId:" + this.musicInfo.wWb + ",musicName:" + this.musicInfo.name);
    Log.i("FinderImgFeedMusicPlayer", "stop musicId:" + this.musicInfo.wWb + ",musicName:" + this.musicInfo.name);
    if (isPlaying())
    {
      localv = this.hWJ;
      if (localv != null) {
        localv.stop();
      }
    }
    v localv = this.hWJ;
    if (localv != null) {
      localv.release();
    }
    this.hWJ = null;
    AppMethodBeat.o(248921);
  }
  
  public final void tA() {}
  
  public final void ty() {}
  
  public final void tz() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.a
 * JD-Core Version:    0.7.0.1
 */