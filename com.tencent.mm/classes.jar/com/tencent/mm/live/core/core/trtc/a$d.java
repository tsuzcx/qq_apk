package com.tencent.mm.live.core.core.trtc;

import com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$playLocalSoundEffect$2$1", "Lcom/tencent/liteav/audio/TXAudioEffectManager$TXMusicPlayObserver;", "onComplete", "", "id", "", "errCode", "onPlayProgress", "curPtsMS", "", "durationMS", "onStart", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$d
  implements TXAudioEffectManager.TXMusicPlayObserver
{
  public final void onComplete(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248213);
    Log.i("MicroMsg.LiveCore", "playBgMusic onComplete " + paramInt1 + ", " + paramInt2);
    TXAudioEffectManager.TXMusicPlayObserver localTXMusicPlayObserver = this.mSg;
    if (localTXMusicPlayObserver != null) {
      localTXMusicPlayObserver.onComplete(paramInt1, paramInt2);
    }
    AppMethodBeat.o(248213);
  }
  
  public final void onPlayProgress(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(248218);
    TXAudioEffectManager.TXMusicPlayObserver localTXMusicPlayObserver = this.mSg;
    if (localTXMusicPlayObserver != null) {
      localTXMusicPlayObserver.onPlayProgress(paramInt, paramLong1, paramLong2);
    }
    AppMethodBeat.o(248218);
  }
  
  public final void onStart(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248223);
    Log.i("MicroMsg.LiveCore", "playBgMusic onStart " + paramInt1 + ", " + paramInt2);
    TXAudioEffectManager.TXMusicPlayObserver localTXMusicPlayObserver = this.mSg;
    if (localTXMusicPlayObserver != null) {
      localTXMusicPlayObserver.onStart(paramInt1, paramInt2);
    }
    AppMethodBeat.o(248223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.d
 * JD-Core Version:    0.7.0.1
 */