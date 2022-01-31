package com.tencent.mm.audio.d;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

@TargetApi(3)
public final class b
  implements a
{
  int ckZ;
  DataInputStream cla;
  private Thread clb;
  a.a clc;
  private int cld;
  Runnable cle;
  private boolean isPlaying;
  volatile AudioTrack mAudioTrack;
  private int mSampleRate;
  
  public b()
  {
    AppMethodBeat.i(140631);
    this.mSampleRate = 44100;
    this.cld = 12;
    this.cle = new b.1(this);
    AppMethodBeat.o(140631);
  }
  
  private AudioTrack EX()
  {
    AppMethodBeat.i(140632);
    if (this.mAudioTrack == null) {}
    try
    {
      if (this.mAudioTrack == null)
      {
        this.ckZ = AudioTrack.getMinBufferSize(this.mSampleRate, this.cld, 2);
        this.mAudioTrack = new AudioTrack(3, this.mSampleRate, this.cld, 2, this.ckZ, 1);
        if (this.mAudioTrack.getState() == 0)
        {
          Ej();
          this.mAudioTrack = new AudioTrack(3, this.mSampleRate, this.cld, 2, this.ckZ, 1);
        }
      }
      AudioTrack localAudioTrack = this.mAudioTrack;
      AppMethodBeat.o(140632);
      return localAudioTrack;
    }
    finally
    {
      AppMethodBeat.o(140632);
    }
  }
  
  /* Error */
  private void EY()
  {
    // Byte code:
    //   0: ldc 79
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 81	com/tencent/mm/audio/d/b:clb	Ljava/lang/Thread;
    //   9: ifnull +33 -> 42
    //   12: getstatic 87	java/lang/Thread$State:RUNNABLE	Ljava/lang/Thread$State;
    //   15: astore_1
    //   16: aload_0
    //   17: getfield 81	com/tencent/mm/audio/d/b:clb	Ljava/lang/Thread;
    //   20: invokevirtual 92	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   23: astore_2
    //   24: aload_1
    //   25: aload_2
    //   26: if_acmpne +16 -> 42
    //   29: ldc2_w 93
    //   32: invokestatic 98	java/lang/Thread:sleep	(J)V
    //   35: aload_0
    //   36: getfield 81	com/tencent/mm/audio/d/b:clb	Ljava/lang/Thread;
    //   39: invokevirtual 101	java/lang/Thread:interrupt	()V
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 81	com/tencent/mm/audio/d/b:clb	Ljava/lang/Thread;
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 81	com/tencent/mm/audio/d/b:clb	Ljava/lang/Thread;
    //   52: ldc 79
    //   54: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: return
    //   58: astore_1
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 81	com/tencent/mm/audio/d/b:clb	Ljava/lang/Thread;
    //   64: goto -22 -> 42
    //   67: astore_1
    //   68: ldc 103
    //   70: aload_1
    //   71: ldc 105
    //   73: invokestatic 111	com/tencent/f/a/b:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 81	com/tencent/mm/audio/d/b:clb	Ljava/lang/Thread;
    //   81: ldc 79
    //   83: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: return
    //   87: astore_1
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 81	com/tencent/mm/audio/d/b:clb	Ljava/lang/Thread;
    //   93: ldc 79
    //   95: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	b
    //   15	10	1	localState1	java.lang.Thread.State
    //   58	1	1	localException1	Exception
    //   67	4	1	localException2	Exception
    //   87	12	1	localObject	Object
    //   23	3	2	localState2	java.lang.Thread.State
    // Exception table:
    //   from	to	target	type
    //   29	42	58	java/lang/Exception
    //   5	24	67	java/lang/Exception
    //   42	47	67	java/lang/Exception
    //   59	64	67	java/lang/Exception
    //   5	24	87	finally
    //   29	42	87	finally
    //   42	47	87	finally
    //   59	64	87	finally
    //   68	76	87	finally
  }
  
  private void EZ()
  {
    AppMethodBeat.i(140640);
    if (this.cla != null) {}
    try
    {
      this.cla.close();
      this.cla = null;
      AppMethodBeat.o(140640);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.tencent.f.a.b.b("MicroMsg.VoicePlayerPcm", localIOException, "");
      }
    }
  }
  
  private void Ej()
  {
    AppMethodBeat.i(140638);
    try
    {
      if (this.mAudioTrack != null)
      {
        this.mAudioTrack.flush();
        this.mAudioTrack.release();
        this.mAudioTrack = null;
      }
      AppMethodBeat.o(140638);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.f.a.b.b("MicroMsg.VoicePlayerPcm", localException, "");
      AppMethodBeat.o(140638);
    }
  }
  
  private boolean eL(String paramString)
  {
    AppMethodBeat.i(140634);
    try
    {
      File localFile = new File(paramString);
      boolean bool = localFile.exists();
      if (!bool)
      {
        AppMethodBeat.o(140634);
        return false;
      }
      this.cla = new DataInputStream(new FileInputStream(localFile));
      AppMethodBeat.o(140634);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.f.a.b.b("MicroMsg.VoicePlayerPcm", localException, String.format(Locale.US, "openFile(%s)", new Object[] { paramString }));
      AppMethodBeat.o(140634);
    }
    return false;
  }
  
  public final boolean Ez()
  {
    AppMethodBeat.i(140636);
    if (this.mAudioTrack != null) {
      this.mAudioTrack.stop();
    }
    this.isPlaying = false;
    release();
    AppMethodBeat.o(140636);
    return true;
  }
  
  public final void a(a.a parama)
  {
    this.clc = parama;
  }
  
  public final boolean eK(String paramString)
  {
    AppMethodBeat.i(140633);
    if (this.isPlaying)
    {
      com.tencent.f.a.b.e("MicroMsg.VoicePlayerPcm", "already play");
      AppMethodBeat.o(140633);
      return false;
    }
    if (!eL(paramString))
    {
      com.tencent.f.a.b.e("MicroMsg.VoicePlayerPcm", "openfile fail");
      AppMethodBeat.o(140633);
      return false;
    }
    EX();
    if (this.mAudioTrack.getState() == 0)
    {
      this.mAudioTrack = null;
      AppMethodBeat.o(140633);
      return false;
    }
    this.isPlaying = true;
    EY();
    if (this.clb == null)
    {
      this.clb = new Thread(this.cle);
      this.clb.start();
    }
    AppMethodBeat.o(140633);
    return true;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(140635);
    if (!this.isPlaying)
    {
      com.tencent.f.a.b.e("MicroMsg.VoicePlayerPcm", "pause() not start play");
      AppMethodBeat.o(140635);
      return false;
    }
    this.isPlaying = false;
    EY();
    AppMethodBeat.o(140635);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(140637);
    Ej();
    EY();
    EZ();
    AppMethodBeat.o(140637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.d.b
 * JD-Core Version:    0.7.0.1
 */