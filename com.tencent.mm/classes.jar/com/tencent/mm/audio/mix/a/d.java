package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.Arrays;

public final class d
{
  private static long hqR = 0L;
  private static long hqS = 0L;
  private String appId;
  private long bufferSize;
  public int channels;
  public boolean ckB;
  private int count;
  public long duration;
  public int hqI;
  private ArrayList<e> hqL;
  public String hqM;
  public boolean hqN;
  public boolean hqO;
  private a hqP;
  public String hqQ;
  private int index;
  public int sampleRate;
  
  public d(String paramString)
  {
    AppMethodBeat.i(136709);
    this.index = 0;
    this.count = 0;
    this.bufferSize = 0L;
    this.hqO = false;
    this.sampleRate = 44100;
    this.channels = 2;
    this.hqI = 2;
    this.hqL = new ArrayList();
    this.hqM = paramString;
    AppMethodBeat.o(136709);
  }
  
  private void aEX()
  {
    AppMethodBeat.i(136719);
    this.hqO = false;
    aFb();
    AppMethodBeat.o(136719);
  }
  
  private void aEZ()
  {
    try
    {
      AppMethodBeat.i(136721);
      aFa();
      AppMethodBeat.o(136721);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void aFa()
  {
    AppMethodBeat.i(136722);
    if (this.hqP == null)
    {
      this.hqP = new a(this.appId, this.hqM);
      if (this.hqP.open())
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile success");
        this.hqP.dY(getBufferSize());
        AppMethodBeat.o(136722);
        return;
      }
      b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile fail");
      this.hqO = false;
      aFb();
    }
    AppMethodBeat.o(136722);
  }
  
  private void aFb()
  {
    AppMethodBeat.i(136723);
    if (this.hqP != null)
    {
      this.hqP.close();
      this.hqP.aEW();
      this.hqP = null;
    }
    AppMethodBeat.o(136723);
  }
  
  private int b(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    AppMethodBeat.i(136724);
    if (this.hqP != null)
    {
      paramInt = this.hqP.b(paramArrayOfByte, paramLong, paramInt);
      AppMethodBeat.o(136724);
      return paramInt;
    }
    AppMethodBeat.o(136724);
    return 0;
  }
  
  private void nX(int paramInt)
  {
    AppMethodBeat.i(136713);
    b.i("MicroMsg.Mix.PcmBufferProvider", "resetProvider src:%s, size:%d, complete:%b, duration:%d, supportMixPlay:%b, bufferSize:%d", new Object[] { this.hqM, Integer.valueOf(paramInt), Boolean.valueOf(this.ckB), Long.valueOf(this.duration), Boolean.valueOf(this.hqN), Long.valueOf(this.bufferSize) });
    this.hqL.clear();
    this.ckB = false;
    this.duration = 0L;
    this.hqN = false;
    this.index = 0;
    this.bufferSize = 0L;
    aEX();
    AppMethodBeat.o(136713);
  }
  
  private e nZ(int paramInt)
  {
    AppMethodBeat.i(136725);
    if (paramInt >= this.count)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (this.hqP == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    int i = paramInt * 3536;
    if (i > this.hqP.getLength())
    {
      AppMethodBeat.o(136725);
      return null;
    }
    e locale = com.tencent.mm.audio.mix.b.d.aFn().aFo();
    if (locale == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (locale.hqJ == null) {
      locale.hqJ = new byte[3536];
    }
    for (;;)
    {
      System.nanoTime();
      if (b(locale.hqJ, i, locale.hqJ.length) > 0) {
        break;
      }
      com.tencent.mm.audio.mix.b.d.aFn().b(locale);
      AppMethodBeat.o(136725);
      return null;
      Arrays.fill(locale.hqJ, 0, locale.hqJ.length, (byte)0);
    }
    locale.hqQ = this.hqQ;
    locale.sampleRate = this.sampleRate;
    locale.channels = this.channels;
    locale.hqI = this.hqI;
    locale.hqT = (paramInt * 20);
    AppMethodBeat.o(136725);
    return locale;
  }
  
  public final void GK()
  {
    AppMethodBeat.i(136717);
    this.ckB = true;
    this.count = size();
    b.i("MicroMsg.Mix.PcmBufferProvider", "src:%s is complete cache", new Object[] { this.hqM });
    AppMethodBeat.o(136717);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(136715);
    this.index += 1;
    parame.hqT = (this.index * 20);
    if (this.hqL != null) {
      this.hqL.add(parame);
    }
    AppMethodBeat.o(136715);
  }
  
  public final void aEY()
  {
    try
    {
      AppMethodBeat.i(136720);
      if (this.hqP != null)
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "closeCacheFileWithNoDiscard success");
        this.hqP.close();
        this.hqP = null;
      }
      AppMethodBeat.o(136720);
      return;
    }
    finally {}
  }
  
  public final long getBufferSize()
  {
    AppMethodBeat.i(136718);
    if (this.bufferSize > 0L)
    {
      l = this.bufferSize;
      AppMethodBeat.o(136718);
      return l;
    }
    this.bufferSize = (size() * 3536);
    long l = this.bufferSize;
    AppMethodBeat.o(136718);
    return l;
  }
  
  public final boolean iN(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(136712);
        if (this.hqO)
        {
          b.i("MicroMsg.Mix.PcmBufferProvider", "cache to file has finish, file:%s", new Object[] { this.hqM });
          AppMethodBeat.o(136712);
          bool = true;
          return bool;
        }
        this.appId = paramString;
        int j = this.hqL.size();
        if (j > 0) {
          aFa();
        }
        if (this.hqP == null)
        {
          b.e("MicroMsg.Mix.PcmBufferProvider", "cacheFile is null");
          this.hqO = false;
          AppMethodBeat.o(136712);
          bool = false;
          continue;
          if (i < j)
          {
            paramString = (e)this.hqL.get(i);
            if (i == 0)
            {
              this.hqQ = paramString.hqQ;
              this.sampleRate = paramString.sampleRate;
              this.hqI = paramString.hqI;
              this.channels = paramString.channels;
            }
            if (paramString == null) {
              break label302;
            }
            byte[] arrayOfByte = paramString.hqJ;
            long l = i * 3536;
            int k = paramString.hqJ.length;
            if (this.hqP == null) {
              break label296;
            }
            bool = this.hqP.c(arrayOfByte, l, k);
            if (bool) {
              break label302;
            }
            aFb();
            b.e("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile fail");
            this.hqO = false;
            AppMethodBeat.o(136712);
            bool = false;
            continue;
          }
          this.hqO = true;
          i = j - 1;
          if (i >= 0)
          {
            paramString = (e)this.hqL.remove(i);
            if (paramString == null) {
              break label309;
            }
            com.tencent.mm.audio.mix.b.e.aFp().b(paramString);
            break label309;
          }
          b.i("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile finish");
          AppMethodBeat.o(136712);
          bool = true;
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label296:
      boolean bool = false;
      continue;
      label302:
      i += 1;
      continue;
      label309:
      i -= 1;
    }
  }
  
  public final e nY(int paramInt)
  {
    AppMethodBeat.i(136714);
    if ((this.hqO) && (this.hqP != null))
    {
      locale = nZ(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.hqO) && (this.hqP == null))
    {
      aEZ();
      locale = nZ(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.hqL == null) || (this.hqL.size() == 0))
    {
      AppMethodBeat.o(136714);
      return null;
    }
    if (paramInt >= this.hqL.size())
    {
      AppMethodBeat.o(136714);
      return null;
    }
    e locale = (e)this.hqL.get(paramInt);
    AppMethodBeat.o(136714);
    return locale;
  }
  
  public final void recycle()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(136711);
        int j = this.hqL.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.hqL.remove(i);
          if (locale != null) {
            com.tencent.mm.audio.mix.b.e.aFp().b(locale);
          }
        }
        else
        {
          nX(j);
          AppMethodBeat.o(136711);
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
        AppMethodBeat.i(136710);
        int j = this.hqL.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.hqL.remove(i);
          if (locale != null)
          {
            locale.hqQ = null;
            locale.hqJ = null;
          }
        }
        else
        {
          nX(j);
          AppMethodBeat.o(136710);
          return;
        }
      }
      finally {}
      i -= 1;
    }
  }
  
  public final int size()
  {
    AppMethodBeat.i(136716);
    if ((this.count > 0) && (this.ckB))
    {
      i = this.count;
      AppMethodBeat.o(136716);
      return i;
    }
    int i = this.hqL.size();
    AppMethodBeat.o(136716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.d
 * JD-Core Version:    0.7.0.1
 */