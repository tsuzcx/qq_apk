package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends TXCAudioBasePlayController
  implements com.tencent.liteav.audio.c
{
  private static final String a;
  private a b;
  
  static
  {
    AppMethodBeat.i(66634);
    a = "AudioCenter:" + c.class.getSimpleName();
    AppMethodBeat.o(66634);
  }
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(66629);
    TXCTraeJNI.setContext(paramContext);
    TXCTraeJNI.nativeSetAudioMode(paramInt);
    AppMethodBeat.o(66629);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(66628);
    if (this.mJitterBuffer != 0L)
    {
      nativeDestoryJitterBuffer(this.mJitterBuffer);
      this.mJitterBuffer = 0L;
    }
    AppMethodBeat.o(66628);
  }
  
  public int startPlay()
  {
    AppMethodBeat.i(66630);
    TXCLog.i(a, "start play audio!");
    if (!this.mIsPlaying)
    {
      super.startPlay();
      if (!nativeIsTracksEmpty())
      {
        TXCTraeJNI.InitTraeEngineLibrary(this.mContext);
        TXCTraeJNI.traeStartPlay(this.mContext);
      }
      TXCLog.i(a, "finish start play audio!");
      AppMethodBeat.o(66630);
      return 0;
    }
    TXCLog.e(a, "repeat start play audio, ignore it!");
    AppMethodBeat.o(66630);
    return -104;
  }
  
  public int stopPlay()
  {
    AppMethodBeat.i(66631);
    TXCLog.i(a, "stop play audio!");
    if (this.mIsPlaying)
    {
      super.stopPlay();
      if (this.mJitterBuffer != 0L)
      {
        nativeDestoryJitterBuffer(this.mJitterBuffer);
        this.mJitterBuffer = 0L;
      }
      if (nativeIsTracksEmpty()) {
        TXCTraeJNI.traeStopPlay();
      }
      this.b = null;
      TXCLog.i(a, "finish stop play audio!");
      AppMethodBeat.o(66631);
      return 0;
    }
    TXCLog.e(a, "repeat stop play audio, ignore it!");
    AppMethodBeat.o(66631);
    return -104;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.c
 * JD-Core Version:    0.7.0.1
 */