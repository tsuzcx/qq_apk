package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.log.TXCLog;

public class d
{
  static d a = new d();
  private static final String b = "AudioCenter:" + d.class.getSimpleName();
  private d.a c;
  private boolean d = false;
  private volatile boolean e = false;
  private Context f = null;
  private int g = TXEAudioDef.TXE_AUDIO_MODE_SPEAKER;
  private volatile boolean h = false;
  private int i = com.tencent.liteav.basic.a.a.e;
  private int j = com.tencent.liteav.basic.a.a.g;
  private int k = com.tencent.liteav.basic.a.a.h;
  
  public static d a()
  {
    return a;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    try
    {
      this.f = paramContext;
      this.g = paramInt;
      if (this.h) {
        com.tencent.liteav.audio.a.a(paramContext, paramInt);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void b()
  {
    TXCLog.w(b, "mult-track-player start!");
    if (this.e)
    {
      TXCLog.e(b, "mult-track-player can not start because of has started!");
      return;
    }
    if ((this.i == 0) || (this.j == 0))
    {
      TXCLog.e(b, "strat mult-track-player failed with invalid audio info , samplerate:" + this.i + ", channels:" + this.j);
      return;
    }
    this.e = true;
    if (this.c == null)
    {
      this.c = new d.1(this, "AUDIO_TRACK");
      this.c.start();
    }
    TXCLog.w(b, "mult-track-player thread start finish!");
  }
  
  public void c()
  {
    TXCLog.w(b, "mult-track-player stop!");
    if (!this.e)
    {
      TXCLog.w(b, "mult-track-player can not stop because of not started yet!");
      return;
    }
    if (this.c != null)
    {
      this.c.b();
      this.c = null;
    }
    this.g = TXEAudioDef.TXE_AUDIO_MODE_SPEAKER;
    this.f = null;
    this.h = false;
    this.e = false;
    TXCLog.w(b, "mult-track-player stop finish!");
  }
  
  public boolean d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.d
 * JD-Core Version:    0.7.0.1
 */