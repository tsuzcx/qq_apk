package com.tencent.mm.audio.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.a.d;
import com.tencent.mm.plugin.appbrand.media.record.a.d.a;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public b clg;
  d clh;
  private d.a cli;
  public b.a clj;
  Object clk;
  private final int cll;
  private final int clm;
  private final double cln;
  private String clo;
  public a.a clp;
  private String mFilePath;
  private final int mSampleRate;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, String paramString1, String paramString2)
  {
    AppMethodBeat.i(140643);
    this.cli = new d.a()
    {
      public final void d(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(140641);
        if (a.this.clp != null) {
          a.this.clp.e(paramAnonymousArrayOfByte, paramAnonymousInt, paramAnonymousBoolean);
        }
        AppMethodBeat.o(140641);
      }
    };
    this.clj = new a.2(this);
    this.clk = new Object();
    this.mSampleRate = paramInt2;
    this.cll = paramInt3;
    this.clm = paramInt4;
    this.cln = paramDouble;
    this.clg = new b(paramInt1, paramInt2, paramInt3);
    this.mFilePath = paramString1;
    this.clo = paramString2;
    AppMethodBeat.o(140643);
  }
  
  public final boolean Et()
  {
    AppMethodBeat.i(140644);
    if (eM("stopRecord fail, recorder is null, return"))
    {
      AppMethodBeat.o(140644);
      return false;
    }
    boolean bool = this.clg.Et();
    synchronized (this.clk)
    {
      if (this.clh != null)
      {
        this.clh.flush();
        this.clh.close();
        this.clh = null;
      }
      release();
      ab.i("MicroMsg.RecorderPcm", "stopRecord:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(140644);
      return bool;
    }
  }
  
  public final boolean Fa()
  {
    boolean bool1 = false;
    AppMethodBeat.i(140646);
    ab.i("MicroMsg.RecorderPcm", "initEncoder mFilePath:%s", new Object[] { this.mFilePath });
    if (this.clh != null)
    {
      this.clh.close();
      this.clh = null;
    }
    this.clh = com.tencent.mm.plugin.appbrand.media.record.a.b.DH(this.clo);
    if (this.clh == null)
    {
      ab.e("MicroMsg.RecorderPcm", "mAudioEncoder init fail, return false");
      AppMethodBeat.o(140646);
      return false;
    }
    if (!h.DE(this.mFilePath))
    {
      ab.e("MicroMsg.RecorderPcm", "prepare cache file fail");
      AppMethodBeat.o(140646);
      return false;
    }
    try
    {
      boolean bool2 = this.clh.h(this.mFilePath, this.mSampleRate, this.cll, this.clm);
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.RecorderPcm", localException, "init encoder fail", new Object[0]);
      }
    }
    this.clh.a(this.cli);
    this.clh.oT(this.clg.cls);
    this.clh.s(this.cln);
    AppMethodBeat.o(140646);
    return bool1;
  }
  
  public final boolean eM(String paramString)
  {
    AppMethodBeat.i(140645);
    if (this.clg == null)
    {
      ab.e("MicroMsg.RecorderPcm", paramString);
      AppMethodBeat.o(140645);
      return true;
    }
    AppMethodBeat.o(140645);
    return false;
  }
  
  public final void release()
  {
    try
    {
      AppMethodBeat.i(140647);
      this.clg.release();
      AppMethodBeat.o(140647);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.d.a.a
 * JD-Core Version:    0.7.0.1
 */