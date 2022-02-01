package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.c;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.Arrays;

public final class d
{
  private static long ddh = 0L;
  private static long ddi = 0L;
  public boolean aBS;
  private String appId;
  private long bufferSize;
  public int channels;
  private int count;
  public int dcY;
  private ArrayList<e> ddb;
  public String ddc;
  public boolean ddd;
  public boolean dde;
  private a ddf;
  public String ddg;
  public long duration;
  private int index;
  public int sampleRate;
  
  public d(String paramString)
  {
    AppMethodBeat.i(136709);
    this.index = 0;
    this.count = 0;
    this.bufferSize = 0L;
    this.dde = false;
    this.sampleRate = 44100;
    this.channels = 2;
    this.dcY = 2;
    this.ddb = new ArrayList();
    this.ddc = paramString;
    AppMethodBeat.o(136709);
  }
  
  private void Of()
  {
    AppMethodBeat.i(136719);
    this.dde = false;
    Oj();
    AppMethodBeat.o(136719);
  }
  
  private void Oh()
  {
    try
    {
      AppMethodBeat.i(136721);
      Oi();
      AppMethodBeat.o(136721);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void Oi()
  {
    AppMethodBeat.i(136722);
    if (this.ddf == null)
    {
      this.ddf = new a(this.appId, this.ddc);
      if (this.ddf.open())
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile success");
        this.ddf.setLength(getBufferSize());
        AppMethodBeat.o(136722);
        return;
      }
      b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile fail");
      this.dde = false;
      Oj();
    }
    AppMethodBeat.o(136722);
  }
  
  private void Oj()
  {
    AppMethodBeat.i(136723);
    if (this.ddf != null)
    {
      this.ddf.close();
      this.ddf.Oe();
      this.ddf = null;
    }
    AppMethodBeat.o(136723);
  }
  
  private void hG(int paramInt)
  {
    AppMethodBeat.i(136713);
    b.i("MicroMsg.Mix.PcmBufferProvider", "resetProvider src:%s, size:%d, complete:%b, duration:%d, supportMixPlay:%b, bufferSize:%d", new Object[] { this.ddc, Integer.valueOf(paramInt), Boolean.valueOf(this.aBS), Long.valueOf(this.duration), Boolean.valueOf(this.ddd), Long.valueOf(this.bufferSize) });
    this.ddb.clear();
    this.aBS = false;
    this.duration = 0L;
    this.ddd = false;
    this.index = 0;
    this.bufferSize = 0L;
    Of();
    AppMethodBeat.o(136713);
  }
  
  private e hI(int paramInt)
  {
    AppMethodBeat.i(136725);
    if (paramInt >= this.count)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (this.ddf == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    int i = paramInt * 3536;
    if (i > this.ddf.getLength())
    {
      AppMethodBeat.o(136725);
      return null;
    }
    e locale = c.Oo().Op();
    if (locale == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (locale.dcZ == null) {
      locale.dcZ = new byte[3536];
    }
    for (;;)
    {
      System.nanoTime();
      if (read(locale.dcZ, i, locale.dcZ.length) > 0) {
        break;
      }
      c.Oo().b(locale);
      AppMethodBeat.o(136725);
      return null;
      Arrays.fill(locale.dcZ, 0, locale.dcZ.length, (byte)0);
    }
    locale.ddg = this.ddg;
    locale.sampleRate = this.sampleRate;
    locale.channels = this.channels;
    locale.dcY = this.dcY;
    locale.ddj = (paramInt * 20);
    AppMethodBeat.o(136725);
    return locale;
  }
  
  private int read(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    AppMethodBeat.i(136724);
    if (this.ddf != null)
    {
      paramInt = this.ddf.read(paramArrayOfByte, paramLong, paramInt);
      AppMethodBeat.o(136724);
      return paramInt;
    }
    AppMethodBeat.o(136724);
    return 0;
  }
  
  public final void Og()
  {
    try
    {
      AppMethodBeat.i(136720);
      if (this.ddf != null)
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "closeCacheFileWithNoDiscard success");
        this.ddf.close();
        this.ddf = null;
      }
      AppMethodBeat.o(136720);
      return;
    }
    finally {}
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(136715);
    this.index += 1;
    parame.ddj = (this.index * 20);
    if (this.ddb != null) {
      this.ddb.add(parame);
    }
    AppMethodBeat.o(136715);
  }
  
  public final void complete()
  {
    AppMethodBeat.i(136717);
    this.aBS = true;
    this.count = size();
    b.i("MicroMsg.Mix.PcmBufferProvider", "src:%s is complete cache", new Object[] { this.ddc });
    AppMethodBeat.o(136717);
  }
  
  public final boolean fO(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(136712);
        if (this.dde)
        {
          b.i("MicroMsg.Mix.PcmBufferProvider", "cache to file has finish, file:%s", new Object[] { this.ddc });
          AppMethodBeat.o(136712);
          bool = true;
          return bool;
        }
        this.appId = paramString;
        int j = this.ddb.size();
        if (j > 0) {
          Oi();
        }
        if (this.ddf == null)
        {
          b.e("MicroMsg.Mix.PcmBufferProvider", "cacheFile is null");
          this.dde = false;
          AppMethodBeat.o(136712);
          bool = false;
          continue;
          if (i < j)
          {
            paramString = (e)this.ddb.get(i);
            if (i == 0)
            {
              this.ddg = paramString.ddg;
              this.sampleRate = paramString.sampleRate;
              this.dcY = paramString.dcY;
              this.channels = paramString.channels;
            }
            if (paramString == null) {
              break label302;
            }
            byte[] arrayOfByte = paramString.dcZ;
            long l = i * 3536;
            int k = paramString.dcZ.length;
            if (this.ddf == null) {
              break label296;
            }
            bool = this.ddf.a(arrayOfByte, l, k);
            if (bool) {
              break label302;
            }
            Oj();
            b.e("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile fail");
            this.dde = false;
            AppMethodBeat.o(136712);
            bool = false;
            continue;
          }
          this.dde = true;
          i = j - 1;
          if (i >= 0)
          {
            paramString = (e)this.ddb.remove(i);
            if (paramString == null) {
              break label309;
            }
            com.tencent.mm.audio.mix.b.d.Oq().b(paramString);
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
  
  public final e hH(int paramInt)
  {
    AppMethodBeat.i(136714);
    if ((this.dde) && (this.ddf != null))
    {
      locale = hI(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.dde) && (this.ddf == null))
    {
      Oh();
      locale = hI(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.ddb == null) || (this.ddb.size() == 0))
    {
      AppMethodBeat.o(136714);
      return null;
    }
    if (paramInt >= this.ddb.size())
    {
      AppMethodBeat.o(136714);
      return null;
    }
    e locale = (e)this.ddb.get(paramInt);
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
        int j = this.ddb.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.ddb.remove(i);
          if (locale != null) {
            com.tencent.mm.audio.mix.b.d.Oq().b(locale);
          }
        }
        else
        {
          hG(j);
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
        int j = this.ddb.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.ddb.remove(i);
          if (locale != null)
          {
            locale.ddg = null;
            locale.dcZ = null;
          }
        }
        else
        {
          hG(j);
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
    if ((this.count > 0) && (this.aBS))
    {
      i = this.count;
      AppMethodBeat.o(136716);
      return i;
    }
    int i = this.ddb.size();
    AppMethodBeat.o(136716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.d
 * JD-Core Version:    0.7.0.1
 */