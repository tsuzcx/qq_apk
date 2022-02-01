package com.tencent.mm.plugin.gamelive.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelive.PluginGameLive;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  boolean IYL;
  short JeU;
  int JeV;
  short JeW;
  private int JeX;
  private List<ByteBuffer> JeY;
  private ByteBuffer JeZ;
  private FileOutputStream Jfa;
  private FileOutputStream Jfb;
  private long Jfc;
  private boolean Jfd;
  private long Jfe;
  private FileOutputStream dke;
  
  public c(short paramShort)
  {
    AppMethodBeat.i(277509);
    this.JeU = 0;
    this.IYL = false;
    this.JeV = 0;
    this.JeW = 0;
    this.JeX = 0;
    this.JeY = new ArrayList();
    this.JeZ = null;
    this.Jfa = null;
    this.Jfb = null;
    this.dke = null;
    this.Jfc = System.currentTimeMillis();
    this.Jfd = true;
    this.Jfe = 0L;
    this.JeU = paramShort;
    Log.i("MicroMsg.GameAudioStream", "[hilive] create GameAudioStream sessionId: " + this.JeU);
    if (((PluginGameLive)h.az(PluginGameLive.class)).getEnableAudioDebug()) {
      try
      {
        this.Jfa = new FileOutputStream(new File("/sdcard/pcm/in-" + this.JeU + ".pcm"));
        this.Jfb = new FileOutputStream(new File("/sdcard/pcm/sl-" + this.JeU + ".pcm"));
        this.dke = new FileOutputStream(new File("/sdcard/pcm/ou-" + this.JeU + ".pcm"));
        AppMethodBeat.o(277509);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
    }
    AppMethodBeat.o(277509);
  }
  
  public final void a(short paramShort, int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(277533);
    d(paramShort, paramInt);
    if (((PluginGameLive)h.az(PluginGameLive.class)).getEnableAudioDebug()) {}
    try
    {
      this.Jfa.write(paramArrayOfByte);
      label33:
      if (((PluginGameLive)h.az(PluginGameLive.class)).getEnableAudioDebug()) {
        Log.v("MicroMsg.GameAudioStream", "[hilive] putData short sessionId: " + this.JeU + " channel: " + this.JeW + " samplerate: " + this.JeV + " data: " + paramArrayOfByte.length + " tmp: " + this.JeZ.capacity() + " buffs: " + this.JeY.size() + " mark: " + paramLong);
      }
      paramInt = 0;
      for (;;)
      {
        int i;
        ByteBuffer localByteBuffer1;
        if (paramInt < paramArrayOfByte.length)
        {
          i = Math.min(paramArrayOfByte.length - paramInt, this.JeZ.capacity() - this.JeZ.position());
          this.JeZ.put(paramArrayOfByte, paramInt, i);
          if (this.JeZ.position() >= this.JeZ.capacity())
          {
            if (this.JeY.size() >= 100)
            {
              this.JeY.remove(0);
              Log.w("MicroMsg.GameAudioStream", "[hilive] buffer full, discard sessionId: " + this.JeU);
            }
            ByteBuffer localByteBuffer2 = this.JeZ;
            localByteBuffer1 = ByteBuffer.allocate(localByteBuffer2.capacity());
            localByteBuffer2.rewind();
            localByteBuffer1.put(localByteBuffer2);
            localByteBuffer2.rewind();
            if (!((PluginGameLive)h.az(PluginGameLive.class)).getEnableAudioDebug()) {}
          }
        }
        try
        {
          this.Jfb.write(localByteBuffer1.array());
          label319:
          this.JeY.add(localByteBuffer1);
          this.JeZ.clear();
          paramInt = i + paramInt;
          continue;
          AppMethodBeat.o(277533);
          return;
        }
        catch (IOException localIOException2)
        {
          break label319;
        }
      }
    }
    catch (IOException localIOException1)
    {
      break label33;
    }
  }
  
  final void d(short paramShort, int paramInt)
  {
    AppMethodBeat.i(277516);
    if ((!this.IYL) || (this.JeW != paramShort) || (this.JeV != paramInt))
    {
      this.IYL = true;
      this.JeV = paramInt;
      this.JeW = paramShort;
      this.JeX = b.b(paramShort, paramInt);
      this.JeZ = ByteBuffer.allocate(this.JeX);
      Log.i("MicroMsg.GameAudioStream", "[hilive] onReady, sessionId: " + this.JeU + " channel: " + paramShort + " samplerate: " + paramInt + " samplesize: " + this.JeX);
    }
    AppMethodBeat.o(277516);
  }
  
  public final byte[] getData()
  {
    AppMethodBeat.i(277545);
    Object localObject1;
    Object localObject3;
    if (!this.JeY.isEmpty())
    {
      this.Jfd = false;
      localObject1 = ((ByteBuffer)this.JeY.get(0)).array();
      this.JeY.remove(0);
      localObject3 = localObject1;
      if (((PluginGameLive)h.az(PluginGameLive.class)).getEnableAudioDebug())
      {
        Log.v("MicroMsg.GameAudioStream", "[hilive] getData sessionId: " + this.JeU + " channel: " + this.JeW + " sampleRate: " + this.JeV + " got data 0: " + localObject1[0] + " 10: " + localObject1[10] + " 100: " + localObject1[100]);
        localObject3 = localObject1;
      }
    }
    for (;;)
    {
      this.Jfc = System.currentTimeMillis();
      if (((PluginGameLive)h.az(PluginGameLive.class)).getEnableAudioDebug()) {}
      try
      {
        this.dke.write((byte[])localObject3);
        label180:
        AppMethodBeat.o(277545);
        return localObject3;
        if (this.JeZ.position() == 0)
        {
          this.Jfd = true;
          localObject1 = new byte[this.JeX];
        }
        for (;;)
        {
          localObject3 = localObject1;
          if (!((PluginGameLive)h.az(PluginGameLive.class)).getEnableAudioDebug()) {
            break;
          }
          Log.v("MicroMsg.GameAudioStream", "[hilive] getData default data sessionId: " + this.JeU + " channel: " + this.JeW + " sampleRate: " + this.JeV + "remain: " + this.JeZ.position());
          localObject3 = localObject1;
          break;
          this.JeZ.rewind();
          localObject3 = this.JeZ.array();
          this.JeZ.clear();
          localObject1 = localObject3;
          if (((PluginGameLive)h.az(PluginGameLive.class)).getEnableAudioDebug()) {
            try
            {
              this.Jfb.write((byte[])localObject3);
              localObject1 = localObject3;
            }
            catch (IOException localIOException1)
            {
              Object localObject2 = localObject3;
            }
          }
        }
      }
      catch (IOException localIOException2)
      {
        break label180;
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(277521);
    Log.i("MicroMsg.GameAudioStream", "[hilive] onStop, sessionId: " + this.JeU + " samplesize: " + this.JeX + " remainBuffer: " + this.JeY.size());
    try
    {
      if (this.Jfa != null) {
        this.Jfa.close();
      }
      if (this.Jfb != null) {
        this.Jfb.close();
      }
      if (this.dke != null) {
        this.dke.close();
      }
      AppMethodBeat.o(277521);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(277521);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.a.c
 * JD-Core Version:    0.7.0.1
 */