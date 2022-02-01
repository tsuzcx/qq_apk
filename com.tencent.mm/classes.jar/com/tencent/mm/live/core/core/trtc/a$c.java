package com.tencent.mm.live.core.core.trtc;

import com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$playBgMusic$2$1", "Lcom/tencent/liteav/audio/TXAudioEffectManager$TXMusicPlayObserver;", "onComplete", "", "id", "", "errCode", "onPlayProgress", "curPtsMS", "", "durationMS", "onStart", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$c
  implements TXAudioEffectManager.TXMusicPlayObserver
{
  a$c(TXAudioEffectManager.TXMusicPlayObserver paramTXMusicPlayObserver, a parama) {}
  
  public final void onComplete(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248204);
    Log.i("MicroMsg.LiveCore", "playBgMusic onComplete " + paramInt1 + ", " + paramInt2);
    TXAudioEffectManager.TXMusicPlayObserver localTXMusicPlayObserver = this.mSg;
    if (localTXMusicPlayObserver != null) {
      localTXMusicPlayObserver.onComplete(paramInt1, paramInt2);
    }
    AppMethodBeat.o(248204);
  }
  
  public final void onPlayProgress(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(248210);
    TXAudioEffectManager.TXMusicPlayObserver localTXMusicPlayObserver = this.mSg;
    if (localTXMusicPlayObserver != null) {
      localTXMusicPlayObserver.onPlayProgress(paramInt, paramLong1, paramLong2);
    }
    AppMethodBeat.o(248210);
  }
  
  public final void onStart(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248215);
    Log.i("MicroMsg.LiveCore", "playBgMusic onStart " + paramInt1 + ", " + paramInt2);
    Object localObject = this.mSf;
    if (paramInt2 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((a)localObject).mRI = bool;
      localObject = this.mSg;
      if (localObject != null) {
        ((TXAudioEffectManager.TXMusicPlayObserver)localObject).onStart(paramInt1, paramInt2);
      }
      AppMethodBeat.o(248215);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.c
 * JD-Core Version:    0.7.0.1
 */