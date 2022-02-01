package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.c;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.Arrays;

public final class d
{
  private static long cTs = 0L;
  private static long cTt = 0L;
  private String appId;
  public boolean azh;
  private long bufferSize;
  public int cTj;
  private ArrayList<e> cTm;
  public String cTn;
  public boolean cTo;
  public boolean cTp;
  private a cTq;
  public String cTr;
  public int channels;
  private int count;
  public long duration;
  private int index;
  public int sampleRate;
  
  public d(String paramString)
  {
    AppMethodBeat.i(136709);
    this.index = 0;
    this.count = 0;
    this.bufferSize = 0L;
    this.cTp = false;
    this.sampleRate = 44100;
    this.channels = 2;
    this.cTj = 2;
    this.cTm = new ArrayList();
    this.cTn = paramString;
    AppMethodBeat.o(136709);
  }
  
  private void MA()
  {
    AppMethodBeat.i(136719);
    this.cTp = false;
    ME();
    AppMethodBeat.o(136719);
  }
  
  private void MC()
  {
    try
    {
      AppMethodBeat.i(136721);
      MD();
      AppMethodBeat.o(136721);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void MD()
  {
    AppMethodBeat.i(136722);
    if (this.cTq == null)
    {
      this.cTq = new a(this.appId, this.cTn);
      if (this.cTq.vD())
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile success");
        this.cTq.setLength(getBufferSize());
        AppMethodBeat.o(136722);
        return;
      }
      b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile fail");
      this.cTp = false;
      ME();
    }
    AppMethodBeat.o(136722);
  }
  
  private void ME()
  {
    AppMethodBeat.i(136723);
    if (this.cTq != null)
    {
      this.cTq.close();
      this.cTq.Mz();
      this.cTq = null;
    }
    AppMethodBeat.o(136723);
  }
  
  private void hN(int paramInt)
  {
    AppMethodBeat.i(136713);
    b.i("MicroMsg.Mix.PcmBufferProvider", "resetProvider src:%s, size:%d, complete:%b, duration:%d, supportMixPlay:%b, bufferSize:%d", new Object[] { this.cTn, Integer.valueOf(paramInt), Boolean.valueOf(this.azh), Long.valueOf(this.duration), Boolean.valueOf(this.cTo), Long.valueOf(this.bufferSize) });
    this.cTm.clear();
    this.azh = false;
    this.duration = 0L;
    this.cTo = false;
    this.index = 0;
    this.bufferSize = 0L;
    MA();
    AppMethodBeat.o(136713);
  }
  
  private e hP(int paramInt)
  {
    AppMethodBeat.i(136725);
    if (paramInt >= this.count)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (this.cTq == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    int i = paramInt * 3536;
    if (i > this.cTq.getLength())
    {
      AppMethodBeat.o(136725);
      return null;
    }
    e locale = c.MJ().MK();
    if (locale == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (locale.cTk == null) {
      locale.cTk = new byte[3536];
    }
    for (;;)
    {
      System.nanoTime();
      if (read(locale.cTk, i, locale.cTk.length) > 0) {
        break;
      }
      c.MJ().b(locale);
      AppMethodBeat.o(136725);
      return null;
      Arrays.fill(locale.cTk, 0, locale.cTk.length, (byte)0);
    }
    locale.cTr = this.cTr;
    locale.sampleRate = this.sampleRate;
    locale.channels = this.channels;
    locale.cTj = this.cTj;
    locale.cTu = (paramInt * 20);
    AppMethodBeat.o(136725);
    return locale;
  }
  
  private int read(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    AppMethodBeat.i(136724);
    if (this.cTq != null)
    {
      paramInt = this.cTq.read(paramArrayOfByte, paramLong, paramInt);
      AppMethodBeat.o(136724);
      return paramInt;
    }
    AppMethodBeat.o(136724);
    return 0;
  }
  
  public final void MB()
  {
    try
    {
      AppMethodBeat.i(136720);
      if (this.cTq != null)
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "closeCacheFileWithNoDiscard success");
        this.cTq.close();
        this.cTq = null;
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
    parame.cTu = (this.index * 20);
    if (this.cTm != null) {
      this.cTm.add(parame);
    }
    AppMethodBeat.o(136715);
  }
  
  public final void complete()
  {
    AppMethodBeat.i(136717);
    this.azh = true;
    this.count = size();
    b.i("MicroMsg.Mix.PcmBufferProvider", "src:%s is complete cache", new Object[] { this.cTn });
    AppMethodBeat.o(136717);
  }
  
  public final boolean eX(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(136712);
        if (this.cTp)
        {
          b.i("MicroMsg.Mix.PcmBufferProvider", "cache to file has finish, file:%s", new Object[] { this.cTn });
          AppMethodBeat.o(136712);
          bool = true;
          return bool;
        }
        this.appId = paramString;
        int j = this.cTm.size();
        if (j > 0) {
          MD();
        }
        if (this.cTq == null)
        {
          b.e("MicroMsg.Mix.PcmBufferProvider", "cacheFile is null");
          this.cTp = false;
          AppMethodBeat.o(136712);
          bool = false;
          continue;
          if (i < j)
          {
            paramString = (e)this.cTm.get(i);
            if (i == 0)
            {
              this.cTr = paramString.cTr;
              this.sampleRate = paramString.sampleRate;
              this.cTj = paramString.cTj;
              this.channels = paramString.channels;
            }
            if (paramString == null) {
              break label302;
            }
            byte[] arrayOfByte = paramString.cTk;
            long l = i * 3536;
            int k = paramString.cTk.length;
            if (this.cTq == null) {
              break label296;
            }
            bool = this.cTq.a(arrayOfByte, l, k);
            if (bool) {
              break label302;
            }
            ME();
            b.e("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile fail");
            this.cTp = false;
            AppMethodBeat.o(136712);
            bool = false;
            continue;
          }
          this.cTp = true;
          i = j - 1;
          if (i >= 0)
          {
            paramString = (e)this.cTm.remove(i);
            if (paramString == null) {
              break label309;
            }
            com.tencent.mm.audio.mix.b.d.ML().b(paramString);
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
  
  public final e hO(int paramInt)
  {
    AppMethodBeat.i(136714);
    if ((this.cTp) && (this.cTq != null))
    {
      locale = hP(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.cTp) && (this.cTq == null))
    {
      MC();
      locale = hP(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.cTm == null) || (this.cTm.size() == 0))
    {
      AppMethodBeat.o(136714);
      return null;
    }
    if (paramInt >= this.cTm.size())
    {
      AppMethodBeat.o(136714);
      return null;
    }
    e locale = (e)this.cTm.get(paramInt);
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
        int j = this.cTm.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.cTm.remove(i);
          if (locale != null) {
            com.tencent.mm.audio.mix.b.d.ML().b(locale);
          }
        }
        else
        {
          hN(j);
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
        int j = this.cTm.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.cTm.remove(i);
          if (locale != null)
          {
            locale.cTr = null;
            locale.cTk = null;
          }
        }
        else
        {
          hN(j);
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
    if ((this.count > 0) && (this.azh))
    {
      i = this.count;
      AppMethodBeat.o(136716);
      return i;
    }
    int i = this.cTm.size();
    AppMethodBeat.o(136716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.d
 * JD-Core Version:    0.7.0.1
 */