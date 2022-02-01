package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import java.util.ArrayList;
import java.util.Arrays;

public final class d
{
  private static long dtY = 0L;
  private static long dtZ = 0L;
  public boolean aBQ;
  private String appId;
  private long bufferSize;
  public int channels;
  private int count;
  public int dtP;
  private ArrayList<e> dtS;
  public String dtT;
  public boolean dtU;
  public boolean dtV;
  private a dtW;
  public String dtX;
  public long duration;
  private int index;
  public int sampleRate;
  
  public d(String paramString)
  {
    AppMethodBeat.i(136709);
    this.index = 0;
    this.count = 0;
    this.bufferSize = 0L;
    this.dtV = false;
    this.sampleRate = 44100;
    this.channels = 2;
    this.dtP = 2;
    this.dtS = new ArrayList();
    this.dtT = paramString;
    AppMethodBeat.o(136709);
  }
  
  private void Yr()
  {
    AppMethodBeat.i(136719);
    this.dtV = false;
    Yv();
    AppMethodBeat.o(136719);
  }
  
  private void Yt()
  {
    try
    {
      AppMethodBeat.i(136721);
      Yu();
      AppMethodBeat.o(136721);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void Yu()
  {
    AppMethodBeat.i(136722);
    if (this.dtW == null)
    {
      this.dtW = new a(this.appId, this.dtT);
      if (this.dtW.open())
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile success");
        this.dtW.setLength(getBufferSize());
        AppMethodBeat.o(136722);
        return;
      }
      b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile fail");
      this.dtV = false;
      Yv();
    }
    AppMethodBeat.o(136722);
  }
  
  private void Yv()
  {
    AppMethodBeat.i(136723);
    if (this.dtW != null)
    {
      this.dtW.close();
      this.dtW.Yq();
      this.dtW = null;
    }
    AppMethodBeat.o(136723);
  }
  
  private void ja(int paramInt)
  {
    AppMethodBeat.i(136713);
    b.i("MicroMsg.Mix.PcmBufferProvider", "resetProvider src:%s, size:%d, complete:%b, duration:%d, supportMixPlay:%b, bufferSize:%d", new Object[] { this.dtT, Integer.valueOf(paramInt), Boolean.valueOf(this.aBQ), Long.valueOf(this.duration), Boolean.valueOf(this.dtU), Long.valueOf(this.bufferSize) });
    this.dtS.clear();
    this.aBQ = false;
    this.duration = 0L;
    this.dtU = false;
    this.index = 0;
    this.bufferSize = 0L;
    Yr();
    AppMethodBeat.o(136713);
  }
  
  private e jc(int paramInt)
  {
    AppMethodBeat.i(136725);
    if (paramInt >= this.count)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (this.dtW == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    int i = paramInt * 3536;
    if (i > this.dtW.getLength())
    {
      AppMethodBeat.o(136725);
      return null;
    }
    e locale = com.tencent.mm.audio.mix.b.d.YH().YI();
    if (locale == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (locale.dtQ == null) {
      locale.dtQ = new byte[3536];
    }
    for (;;)
    {
      System.nanoTime();
      if (read(locale.dtQ, i, locale.dtQ.length) > 0) {
        break;
      }
      com.tencent.mm.audio.mix.b.d.YH().b(locale);
      AppMethodBeat.o(136725);
      return null;
      Arrays.fill(locale.dtQ, 0, locale.dtQ.length, (byte)0);
    }
    locale.dtX = this.dtX;
    locale.sampleRate = this.sampleRate;
    locale.channels = this.channels;
    locale.dtP = this.dtP;
    locale.dua = (paramInt * 20);
    AppMethodBeat.o(136725);
    return locale;
  }
  
  private int read(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    AppMethodBeat.i(136724);
    if (this.dtW != null)
    {
      paramInt = this.dtW.read(paramArrayOfByte, paramLong, paramInt);
      AppMethodBeat.o(136724);
      return paramInt;
    }
    AppMethodBeat.o(136724);
    return 0;
  }
  
  public final void Ys()
  {
    try
    {
      AppMethodBeat.i(136720);
      if (this.dtW != null)
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "closeCacheFileWithNoDiscard success");
        this.dtW.close();
        this.dtW = null;
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
    parame.dua = (this.index * 20);
    if (this.dtS != null) {
      this.dtS.add(parame);
    }
    AppMethodBeat.o(136715);
  }
  
  public final void complete()
  {
    AppMethodBeat.i(136717);
    this.aBQ = true;
    this.count = size();
    b.i("MicroMsg.Mix.PcmBufferProvider", "src:%s is complete cache", new Object[] { this.dtT });
    AppMethodBeat.o(136717);
  }
  
  public final boolean gA(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(136712);
        if (this.dtV)
        {
          b.i("MicroMsg.Mix.PcmBufferProvider", "cache to file has finish, file:%s", new Object[] { this.dtT });
          AppMethodBeat.o(136712);
          bool = true;
          return bool;
        }
        this.appId = paramString;
        int j = this.dtS.size();
        if (j > 0) {
          Yu();
        }
        if (this.dtW == null)
        {
          b.e("MicroMsg.Mix.PcmBufferProvider", "cacheFile is null");
          this.dtV = false;
          AppMethodBeat.o(136712);
          bool = false;
          continue;
          if (i < j)
          {
            paramString = (e)this.dtS.get(i);
            if (i == 0)
            {
              this.dtX = paramString.dtX;
              this.sampleRate = paramString.sampleRate;
              this.dtP = paramString.dtP;
              this.channels = paramString.channels;
            }
            if (paramString == null) {
              break label302;
            }
            byte[] arrayOfByte = paramString.dtQ;
            long l = i * 3536;
            int k = paramString.dtQ.length;
            if (this.dtW == null) {
              break label296;
            }
            bool = this.dtW.b(arrayOfByte, l, k);
            if (bool) {
              break label302;
            }
            Yv();
            b.e("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile fail");
            this.dtV = false;
            AppMethodBeat.o(136712);
            bool = false;
            continue;
          }
          this.dtV = true;
          i = j - 1;
          if (i >= 0)
          {
            paramString = (e)this.dtS.remove(i);
            if (paramString == null) {
              break label309;
            }
            com.tencent.mm.audio.mix.b.e.YJ().b(paramString);
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
  
  public final e jb(int paramInt)
  {
    AppMethodBeat.i(136714);
    if ((this.dtV) && (this.dtW != null))
    {
      locale = jc(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.dtV) && (this.dtW == null))
    {
      Yt();
      locale = jc(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.dtS == null) || (this.dtS.size() == 0))
    {
      AppMethodBeat.o(136714);
      return null;
    }
    if (paramInt >= this.dtS.size())
    {
      AppMethodBeat.o(136714);
      return null;
    }
    e locale = (e)this.dtS.get(paramInt);
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
        int j = this.dtS.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.dtS.remove(i);
          if (locale != null) {
            com.tencent.mm.audio.mix.b.e.YJ().b(locale);
          }
        }
        else
        {
          ja(j);
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
        int j = this.dtS.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.dtS.remove(i);
          if (locale != null)
          {
            locale.dtX = null;
            locale.dtQ = null;
          }
        }
        else
        {
          ja(j);
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
    if ((this.count > 0) && (this.aBQ))
    {
      i = this.count;
      AppMethodBeat.o(136716);
      return i;
    }
    int i = this.dtS.size();
    AppMethodBeat.o(136716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.d
 * JD-Core Version:    0.7.0.1
 */