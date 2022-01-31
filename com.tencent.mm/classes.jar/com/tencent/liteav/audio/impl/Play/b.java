package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class b
  extends TXCAudioBasePlayController
{
  public static final String a;
  private a b;
  private com.tencent.liteav.basic.structs.a c;
  
  static
  {
    AppMethodBeat.i(66603);
    a = "AudioCenter:" + b.class.getSimpleName();
    AppMethodBeat.o(66603);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(66594);
    d.a().a(paramContext, paramInt);
    AppMethodBeat.o(66594);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(66593);
    if (this.mJitterBuffer != 0L)
    {
      nativeDestoryJitterBuffer(this.mJitterBuffer);
      this.mJitterBuffer = 0L;
    }
    AppMethodBeat.o(66593);
  }
  
  public void onPlayPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146222);
    super.onPlayPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(146222);
  }
  
  public int startPlay()
  {
    AppMethodBeat.i(66596);
    TXCLog.i(a, "start play audio!");
    if (!this.mIsPlaying)
    {
      if (this.mIsHWAcceleration)
      {
        this.b = new a();
        this.b.a(new WeakReference(this));
      }
      if (!nativeIsTracksEmpty()) {
        d.a().b();
      }
      this.mIsPlaying = true;
      TXCLog.i(a, "finish start play audio!");
      AppMethodBeat.o(66596);
      return 0;
    }
    TXCLog.e(a, "repeat start play audio, ignore it!");
    AppMethodBeat.o(66596);
    return -104;
  }
  
  public int stopPlay()
  {
    AppMethodBeat.i(66597);
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
        d.a().c();
      }
      if (this.b != null)
      {
        this.b.a();
        this.b = null;
      }
      this.c = null;
      TXCLog.i(a, "finish stop play audio!");
      AppMethodBeat.o(66597);
      return 0;
    }
    TXCLog.e(a, "repeat stop play audio, ignore it!");
    AppMethodBeat.o(66597);
    return -104;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.b
 * JD-Core Version:    0.7.0.1
 */