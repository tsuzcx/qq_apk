package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;

public final class c
{
  private static long cev = 0L;
  private static long cew = 0L;
  private String appId;
  private long bufferSize;
  public int cel;
  private ArrayList<d> ceo;
  public boolean cep;
  public String ceq;
  public boolean cer;
  public boolean ces;
  private a cet;
  public String ceu;
  public int channels;
  private int count;
  public long duration;
  private int index;
  public int sampleRate;
  
  public c(String paramString)
  {
    AppMethodBeat.i(136961);
    this.index = 0;
    this.count = 0;
    this.bufferSize = 0L;
    this.ces = false;
    this.sampleRate = 44100;
    this.channels = 2;
    this.cel = 2;
    this.ceo = new ArrayList();
    this.ceq = paramString;
    AppMethodBeat.o(136961);
  }
  
  private void CT()
  {
    AppMethodBeat.i(136971);
    this.ces = false;
    CX();
    AppMethodBeat.o(136971);
  }
  
  private void CV()
  {
    try
    {
      AppMethodBeat.i(136973);
      CW();
      AppMethodBeat.o(136973);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void CW()
  {
    AppMethodBeat.i(136974);
    if (this.cet == null)
    {
      this.cet = new a(this.appId, this.ceq);
      if (this.cet.open())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile success");
        this.cet.setLength(getBufferSize());
        AppMethodBeat.o(136974);
        return;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile fail");
      this.ces = false;
      CX();
    }
    AppMethodBeat.o(136974);
  }
  
  private void CX()
  {
    AppMethodBeat.i(136975);
    if (this.cet != null)
    {
      this.cet.close();
      this.cet.CS();
      this.cet = null;
    }
    AppMethodBeat.o(136975);
  }
  
  private int a(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    AppMethodBeat.i(136976);
    if (this.cet != null)
    {
      paramInt = this.cet.a(paramArrayOfByte, paramLong, paramInt);
      AppMethodBeat.o(136976);
      return paramInt;
    }
    AppMethodBeat.o(136976);
    return 0;
  }
  
  private void go(int paramInt)
  {
    AppMethodBeat.i(136965);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.PcmBufferProvider", "resetProvider src:%s, size:%d, complete:%b, duration:%d, supportMixPlay:%b, bufferSize:%d", new Object[] { this.ceq, Integer.valueOf(paramInt), Boolean.valueOf(this.cep), Long.valueOf(this.duration), Boolean.valueOf(this.cer), Long.valueOf(this.bufferSize) });
    this.ceo.clear();
    this.cep = false;
    this.duration = 0L;
    this.cer = false;
    this.index = 0;
    this.bufferSize = 0L;
    CT();
    AppMethodBeat.o(136965);
  }
  
  private d gq(int paramInt)
  {
    AppMethodBeat.i(136977);
    if (paramInt >= this.count)
    {
      AppMethodBeat.o(136977);
      return null;
    }
    if (this.cet == null)
    {
      AppMethodBeat.o(136977);
      return null;
    }
    int i = paramInt * 3536;
    if (i > this.cet.getLength())
    {
      AppMethodBeat.o(136977);
      return null;
    }
    d locald = com.tencent.mm.audio.mix.b.b.Da().Db();
    if (locald == null)
    {
      AppMethodBeat.o(136977);
      return null;
    }
    if (locald.cem == null) {
      locald.cem = new byte[3536];
    }
    for (;;)
    {
      System.nanoTime();
      if (a(locald.cem, i, locald.cem.length) > 0) {
        break;
      }
      com.tencent.mm.audio.mix.b.b.Da().b(locald);
      AppMethodBeat.o(136977);
      return null;
      Arrays.fill(locald.cem, 0, locald.cem.length, (byte)0);
    }
    locald.ceu = this.ceu;
    locald.sampleRate = this.sampleRate;
    locald.channels = this.channels;
    locald.cel = this.cel;
    locald.cex = (paramInt * 20);
    AppMethodBeat.o(136977);
    return locald;
  }
  
  public final void CU()
  {
    try
    {
      AppMethodBeat.i(136972);
      if (this.cet != null)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.PcmBufferProvider", "closeCacheFileWithNoDiscard success");
        this.cet.close();
        this.cet = null;
      }
      AppMethodBeat.o(136972);
      return;
    }
    finally {}
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(136967);
    this.index += 1;
    paramd.cex = (this.index * 20);
    if (this.ceo != null) {
      this.ceo.add(paramd);
    }
    AppMethodBeat.o(136967);
  }
  
  public final void complete()
  {
    AppMethodBeat.i(136969);
    this.cep = true;
    this.count = size();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.PcmBufferProvider", "src:%s is complete cache", new Object[] { this.ceq });
    AppMethodBeat.o(136969);
  }
  
  public final boolean dQ(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(136964);
        if (this.ces)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.PcmBufferProvider", "cache to file has finish, file:%s", new Object[] { this.ceq });
          AppMethodBeat.o(136964);
          bool = true;
          return bool;
        }
        this.appId = paramString;
        int j = this.ceo.size();
        if (j > 0) {
          CW();
        }
        if (this.cet == null)
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.PcmBufferProvider", "cacheFile is null");
          this.ces = false;
          AppMethodBeat.o(136964);
          bool = false;
          continue;
          if (i < j)
          {
            paramString = (d)this.ceo.get(i);
            if (i == 0)
            {
              this.ceu = paramString.ceu;
              this.sampleRate = paramString.sampleRate;
              this.cel = paramString.cel;
              this.channels = paramString.channels;
            }
            if (paramString == null) {
              break label301;
            }
            byte[] arrayOfByte = paramString.cem;
            long l = i * 3536;
            int k = paramString.cem.length;
            if (this.cet == null) {
              break label295;
            }
            bool = this.cet.b(arrayOfByte, l, k);
            if (bool) {
              break label301;
            }
            CX();
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile fail");
            this.ces = false;
            AppMethodBeat.o(136964);
            bool = false;
            continue;
          }
          this.ces = true;
          i = j - 1;
          if (i >= 0)
          {
            paramString = (d)this.ceo.remove(i);
            if (paramString == null) {
              break label308;
            }
            com.tencent.mm.audio.mix.b.c.Dc().b(paramString);
            break label308;
          }
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile finish");
          AppMethodBeat.o(136964);
          bool = true;
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label295:
      boolean bool = false;
      continue;
      label301:
      i += 1;
      continue;
      label308:
      i -= 1;
    }
  }
  
  public final long getBufferSize()
  {
    AppMethodBeat.i(136970);
    if (this.bufferSize > 0L)
    {
      l = this.bufferSize;
      AppMethodBeat.o(136970);
      return l;
    }
    this.bufferSize = (size() * 3536);
    long l = this.bufferSize;
    AppMethodBeat.o(136970);
    return l;
  }
  
  public final d gp(int paramInt)
  {
    AppMethodBeat.i(136966);
    if ((this.ces) && (this.cet != null))
    {
      locald = gq(paramInt);
      AppMethodBeat.o(136966);
      return locald;
    }
    if ((this.ces) && (this.cet == null))
    {
      CV();
      locald = gq(paramInt);
      AppMethodBeat.o(136966);
      return locald;
    }
    if ((this.ceo == null) || (this.ceo.size() == 0))
    {
      AppMethodBeat.o(136966);
      return null;
    }
    if (paramInt >= this.ceo.size())
    {
      AppMethodBeat.o(136966);
      return null;
    }
    d locald = (d)this.ceo.get(paramInt);
    AppMethodBeat.o(136966);
    return locald;
  }
  
  public final void recycle()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(136963);
        int j = this.ceo.size();
        i = j - 1;
        if (i >= 0)
        {
          d locald = (d)this.ceo.remove(i);
          if (locald != null) {
            com.tencent.mm.audio.mix.b.c.Dc().b(locald);
          }
        }
        else
        {
          go(j);
          AppMethodBeat.o(136963);
          return;
        }
      }
      finally {}
      i -= 1;
    }
  }
  
  public final void reset()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(136962);
        int j = this.ceo.size();
        i = j - 1;
        if (i >= 0)
        {
          d locald = (d)this.ceo.remove(i);
          if (locald != null)
          {
            locald.ceu = null;
            locald.cem = null;
          }
        }
        else
        {
          go(j);
          AppMethodBeat.o(136962);
          return;
        }
      }
      finally {}
      i -= 1;
    }
  }
  
  public final int size()
  {
    AppMethodBeat.i(136968);
    if ((this.count > 0) && (this.cep))
    {
      i = this.count;
      AppMethodBeat.o(136968);
      return i;
    }
    int i = this.ceo.size();
    AppMethodBeat.o(136968);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.c
 * JD-Core Version:    0.7.0.1
 */