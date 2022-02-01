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
  boolean Deu;
  short DlL;
  int DlM;
  short DlN;
  private int DlO;
  private List<ByteBuffer> DlP;
  private ByteBuffer DlQ;
  private FileOutputStream DlR;
  private FileOutputStream DlS;
  private long DlT;
  private boolean DlU;
  private long DlV;
  private FileOutputStream bqA;
  
  public c(short paramShort)
  {
    AppMethodBeat.i(208362);
    this.DlL = 0;
    this.Deu = false;
    this.DlM = 0;
    this.DlN = 0;
    this.DlO = 0;
    this.DlP = new ArrayList();
    this.DlQ = null;
    this.DlR = null;
    this.DlS = null;
    this.bqA = null;
    this.DlT = System.currentTimeMillis();
    this.DlU = true;
    this.DlV = 0L;
    this.DlL = paramShort;
    Log.i("MicroMsg.GameAudioStream", "[hilive] create GameAudioStream sessionId: " + this.DlL);
    if (((PluginGameLive)h.ag(PluginGameLive.class)).getEnableAudioDebug()) {
      try
      {
        this.DlR = new FileOutputStream(new File("/sdcard/pcm/in-" + this.DlL + ".pcm"));
        this.DlS = new FileOutputStream(new File("/sdcard/pcm/sl-" + this.DlL + ".pcm"));
        this.bqA = new FileOutputStream(new File("/sdcard/pcm/ou-" + this.DlL + ".pcm"));
        AppMethodBeat.o(208362);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
    }
    AppMethodBeat.o(208362);
  }
  
  public final void a(short paramShort, int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(208370);
    c(paramShort, paramInt);
    if (((PluginGameLive)h.ag(PluginGameLive.class)).getEnableAudioDebug()) {}
    try
    {
      this.DlR.write(paramArrayOfByte);
      label33:
      if (((PluginGameLive)h.ag(PluginGameLive.class)).getEnableAudioDebug()) {
        Log.v("MicroMsg.GameAudioStream", "[hilive] putData short sessionId: " + this.DlL + " channel: " + this.DlN + " samplerate: " + this.DlM + " data: " + paramArrayOfByte.length + " tmp: " + this.DlQ.capacity() + " buffs: " + this.DlP.size() + " mark: " + paramLong);
      }
      paramInt = 0;
      for (;;)
      {
        int i;
        ByteBuffer localByteBuffer1;
        if (paramInt < paramArrayOfByte.length)
        {
          i = Math.min(paramArrayOfByte.length - paramInt, this.DlQ.capacity() - this.DlQ.position());
          this.DlQ.put(paramArrayOfByte, paramInt, i);
          if (this.DlQ.position() >= this.DlQ.capacity())
          {
            if (this.DlP.size() >= 100)
            {
              this.DlP.remove(0);
              Log.w("MicroMsg.GameAudioStream", "[hilive] buffer full, discard sessionId: " + this.DlL);
            }
            ByteBuffer localByteBuffer2 = this.DlQ;
            localByteBuffer1 = ByteBuffer.allocate(localByteBuffer2.capacity());
            localByteBuffer2.rewind();
            localByteBuffer1.put(localByteBuffer2);
            localByteBuffer2.rewind();
            if (!((PluginGameLive)h.ag(PluginGameLive.class)).getEnableAudioDebug()) {}
          }
        }
        try
        {
          this.DlS.write(localByteBuffer1.array());
          label319:
          this.DlP.add(localByteBuffer1);
          this.DlQ.clear();
          paramInt = i + paramInt;
          continue;
          AppMethodBeat.o(208370);
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
  
  final void c(short paramShort, int paramInt)
  {
    AppMethodBeat.i(208364);
    if ((!this.Deu) || (this.DlN != paramShort) || (this.DlM != paramInt))
    {
      this.Deu = true;
      this.DlM = paramInt;
      this.DlN = paramShort;
      this.DlO = b.a(paramShort, paramInt);
      this.DlQ = ByteBuffer.allocate(this.DlO);
      Log.i("MicroMsg.GameAudioStream", "[hilive] onReady, sessionId: " + this.DlL + " channel: " + paramShort + " samplerate: " + paramInt + " samplesize: " + this.DlO);
    }
    AppMethodBeat.o(208364);
  }
  
  public final byte[] getData()
  {
    AppMethodBeat.i(208372);
    Object localObject1;
    Object localObject3;
    if (!this.DlP.isEmpty())
    {
      this.DlU = false;
      localObject1 = ((ByteBuffer)this.DlP.get(0)).array();
      this.DlP.remove(0);
      localObject3 = localObject1;
      if (((PluginGameLive)h.ag(PluginGameLive.class)).getEnableAudioDebug())
      {
        Log.v("MicroMsg.GameAudioStream", "[hilive] getData sessionId: " + this.DlL + " channel: " + this.DlN + " sampleRate: " + this.DlM + " got data 0: " + localObject1[0] + " 10: " + localObject1[10] + " 100: " + localObject1[100]);
        localObject3 = localObject1;
      }
    }
    for (;;)
    {
      this.DlT = System.currentTimeMillis();
      if (((PluginGameLive)h.ag(PluginGameLive.class)).getEnableAudioDebug()) {}
      try
      {
        this.bqA.write((byte[])localObject3);
        label180:
        AppMethodBeat.o(208372);
        return localObject3;
        if (this.DlQ.position() == 0)
        {
          this.DlU = true;
          localObject1 = new byte[this.DlO];
        }
        for (;;)
        {
          localObject3 = localObject1;
          if (!((PluginGameLive)h.ag(PluginGameLive.class)).getEnableAudioDebug()) {
            break;
          }
          Log.v("MicroMsg.GameAudioStream", "[hilive] getData default data sessionId: " + this.DlL + " channel: " + this.DlN + " sampleRate: " + this.DlM + "remain: " + this.DlQ.position());
          localObject3 = localObject1;
          break;
          this.DlQ.rewind();
          localObject3 = this.DlQ.array();
          this.DlQ.clear();
          localObject1 = localObject3;
          if (((PluginGameLive)h.ag(PluginGameLive.class)).getEnableAudioDebug()) {
            try
            {
              this.DlS.write((byte[])localObject3);
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
    AppMethodBeat.i(208366);
    Log.i("MicroMsg.GameAudioStream", "[hilive] onStop, sessionId: " + this.DlL + " samplesize: " + this.DlO + " remainBuffer: " + this.DlP.size());
    try
    {
      if (this.DlR != null) {
        this.DlR.close();
      }
      if (this.DlS != null) {
        this.DlS.close();
      }
      if (this.bqA != null) {
        this.bqA.close();
      }
      AppMethodBeat.o(208366);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(208366);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.a.c
 * JD-Core Version:    0.7.0.1
 */