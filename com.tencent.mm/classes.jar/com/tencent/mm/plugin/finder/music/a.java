package com.tencent.mm.plugin.finder.music;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.h.a.f;
import com.google.android.exoplayer2.h.a.m;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "Lcom/google/android/exoplayer2/Player$EventListener;", "context", "Landroid/content/Context;", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "getContext", "()Landroid/content/Context;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "getCurrPosition", "", "initPlayer", "", "isPlaying", "", "onLoadingChanged", "isLoading", "onPlaybackParametersChanged", "p0", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "pause", "play", "release", "seekTo", "timeMS", "setMute", "isMute", "stop", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements q.a
{
  public static final a.a EEI;
  public final Context context;
  bqj musicInfo;
  private v nno;
  
  static
  {
    AppMethodBeat.i(330912);
    EEI = new a.a((byte)0);
    AppMethodBeat.o(330912);
  }
  
  public a(Context paramContext, bqj parambqj)
  {
    AppMethodBeat.i(330883);
    this.context = paramContext;
    this.musicInfo = parambqj;
    eDO();
    AppMethodBeat.o(330883);
  }
  
  private final void eDO()
  {
    AppMethodBeat.i(330895);
    if (this.nno == null)
    {
      Log.i("FinderImgFeedMusicPlayer", "init musicId:" + this.musicInfo.HsD + ",musicName:" + this.musicInfo.name);
      this.nno = com.google.android.exoplayer2.g.a(this.context, (com.google.android.exoplayer2.g.h)new com.google.android.exoplayer2.g.c());
      Object localObject1 = new n(this.context, x.m(this.context, "Finder.Player"), (com.google.android.exoplayer2.h.w)new l());
      Object localObject2 = bm.GlZ;
      localObject2 = new m(new File(q.n(bm.c(this.musicInfo), true)), (f)new com.google.android.exoplayer2.h.a.k(5242880L));
      com.google.android.exoplayer2.c.h localh = (com.google.android.exoplayer2.c.h)new com.google.android.exoplayer2.c.c();
      localObject1 = new i((com.google.android.exoplayer2.source.k)new com.google.android.exoplayer2.source.h(Uri.parse(this.musicInfo.ZYp), (g.a)new com.google.android.exoplayer2.h.a.e((com.google.android.exoplayer2.h.a.a)localObject2, (g.a)localObject1), localh, null, null));
      localObject2 = this.nno;
      if (localObject2 != null) {
        ((v)localObject2).a((q.a)this);
      }
      localObject2 = this.nno;
      if (localObject2 != null) {
        ((v)localObject2).a((com.google.android.exoplayer2.source.k)localObject1);
      }
    }
    AppMethodBeat.o(330895);
  }
  
  public final long eDP()
  {
    AppMethodBeat.i(330925);
    v localv = this.nno;
    if (localv == null)
    {
      AppMethodBeat.o(330925);
      return 0L;
    }
    long l = localv.getCurrentPosition();
    AppMethodBeat.o(330925);
    return l;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(330971);
    Object localObject = this.nno;
    boolean bool;
    if (localObject == null)
    {
      localObject = null;
      Log.i("FinderImgFeedMusicPlayer", s.X("[isPlaying] state:", localObject));
      localObject = this.nno;
      if (localObject != null) {
        break label132;
      }
      bool = false;
      label40:
      if (!bool) {
        break label155;
      }
      localObject = this.nno;
      if ((localObject == null) || (((v)localObject).QC() != 3)) {
        break label140;
      }
      i = 1;
      label63:
      if (i == 0)
      {
        localObject = this.nno;
        if ((localObject == null) || (((v)localObject).QC() != 2)) {
          break label145;
        }
        i = 1;
        label86:
        if (i == 0)
        {
          localObject = this.nno;
          if ((localObject == null) || (((v)localObject).QC() != 1)) {
            break label150;
          }
        }
      }
    }
    label132:
    label140:
    label145:
    label150:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label155;
      }
      AppMethodBeat.o(330971);
      return true;
      localObject = Integer.valueOf(((v)localObject).QC());
      break;
      bool = ((v)localObject).QD();
      break label40;
      i = 0;
      break label63;
      i = 0;
      break label86;
    }
    label155:
    AppMethodBeat.o(330971);
    return false;
  }
  
  public final void onLoadingChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(331001);
    Log.i("FinderImgFeedMusicPlayer", s.X("[onLoadingChanged] isLoading:", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(331001);
  }
  
  public final void onPlaybackParametersChanged(p paramp) {}
  
  public final void onPlayerError(com.google.android.exoplayer2.e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(330991);
    StringBuilder localStringBuilder = new StringBuilder("[onPlayerError] type:");
    Object localObject1;
    if (parame == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" , message:");
      if (parame != null) {
        break label109;
      }
      localObject1 = null;
      label46:
      localObject1 = localStringBuilder.append(localObject1).append(" ,cause:");
      if (parame != null) {
        break label117;
      }
    }
    label109:
    label117:
    for (parame = localObject2;; parame = parame.getCause())
    {
      Log.i("FinderImgFeedMusicPlayer", parame);
      com.tencent.mm.plugin.report.service.h.OAn.p(1530L, 4L, 1L);
      AppMethodBeat.o(330991);
      return;
      localObject1 = Integer.valueOf(parame.type);
      break;
      localObject1 = parame.getMessage();
      break label46;
    }
  }
  
  public final void onPlayerStateChanged(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(330996);
    Log.i("FinderImgFeedMusicPlayer", "[onPlayerStateChanged] playWhenReady:" + paramBoolean + " ,state:" + paramInt);
    AppMethodBeat.o(330996);
  }
  
  public final void onPositionDiscontinuity() {}
  
  public final void onRepeatModeChanged(int paramInt) {}
  
  public final void onTimelineChanged(com.google.android.exoplayer2.w paramw, Object paramObject) {}
  
  public final void onTracksChanged(r paramr, com.google.android.exoplayer2.g.g paramg) {}
  
  public final void pause()
  {
    AppMethodBeat.i(330952);
    if (isPlaying())
    {
      Log.i("FinderImgFeedMusicPlayer", "pause musicId:" + this.musicInfo.HsD + ",musicName:" + this.musicInfo.name + ",musicInfo:" + this.musicInfo);
      v localv = this.nno;
      if (localv != null)
      {
        localv.bv(false);
        AppMethodBeat.o(330952);
      }
    }
    else
    {
      Log.i("FinderImgFeedMusicPlayer", "pause musicInfo:" + this.musicInfo + " failed, cause it is not playing");
    }
    AppMethodBeat.o(330952);
  }
  
  public final void play()
  {
    AppMethodBeat.i(330920);
    eDO();
    boolean bool = com.tencent.mm.n.a.aTj();
    Log.i("FinderImgFeedMusicPlayer", "play musicId:" + this.musicInfo.HsD + ",musicName:" + this.musicInfo.name + ", needMute = " + bool);
    if (!bool)
    {
      v localv = this.nno;
      if (localv != null) {
        localv.bv(true);
      }
    }
    AppMethodBeat.o(330920);
  }
  
  public final void release()
  {
    AppMethodBeat.i(330961);
    d.e("FinderImgFeedMusicPlayer", (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(330961);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(330931);
    v localv = this.nno;
    if (localv != null) {
      localv.seekTo(paramLong);
    }
    AppMethodBeat.o(330931);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(330940);
    v localv = this.nno;
    if (localv != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (float f = 0.0F;; f = 1.0F)
    {
      localv.setVolume(f);
      AppMethodBeat.o(330940);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(330945);
    Log.i("FinderImgFeedMusicPlayer", "stop musicId:" + this.musicInfo.HsD + ",musicName:" + this.musicInfo.name);
    if (isPlaying())
    {
      v localv = this.nno;
      if (localv != null) {
        localv.stop();
      }
    }
    AppMethodBeat.o(330945);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.a
 * JD-Core Version:    0.7.0.1
 */