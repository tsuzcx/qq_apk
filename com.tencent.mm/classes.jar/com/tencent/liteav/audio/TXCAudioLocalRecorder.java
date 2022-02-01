package com.tencent.liteav.audio;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCAudioLocalRecorder
{
  private static final String b;
  private a a;
  private long c = 0L;
  
  static
  {
    AppMethodBeat.i(16303);
    d.f();
    b = TXCAudioLocalRecorder.class.getSimpleName();
    AppMethodBeat.o(16303);
  }
  
  private native long nativeCreateLocalRecorder();
  
  private native void nativeDestroyLocalRecorder(long paramLong);
  
  private native int nativeStartLocalAudioRecord(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString);
  
  private native void nativeStopLocalAudioRecord(long paramLong);
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(16301);
    TXCLog.i(b, "startLocalAudioRecord:" + this.c);
    paramInt1 = nativeStartLocalAudioRecord(this.c, paramInt1, paramInt2, paramBoolean, paramString);
    AppMethodBeat.o(16301);
    return paramInt1;
  }
  
  public void a()
  {
    AppMethodBeat.i(16300);
    TXCLog.i(b, "uninit:" + this.c);
    if (this.c != 0L) {
      nativeDestroyLocalRecorder(this.c);
    }
    this.c = 0L;
    this.a = null;
    AppMethodBeat.o(16300);
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(16299);
    a();
    this.a = parama;
    this.c = nativeCreateLocalRecorder();
    TXCLog.i(b, "init:" + this.c);
    AppMethodBeat.o(16299);
  }
  
  public void b()
  {
    AppMethodBeat.i(16302);
    TXCLog.i(b, "stopLocalAudioRecord:" + this.c);
    nativeStopLocalAudioRecord(this.c);
    AppMethodBeat.o(16302);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCAudioLocalRecorder
 * JD-Core Version:    0.7.0.1
 */