package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.Arrays;

public final class d
{
  private static long fmG = 0L;
  private static long fmH = 0L;
  private String appId;
  public boolean awf;
  private long bufferSize;
  public int channels;
  private int count;
  public long duration;
  private ArrayList<e> fmA;
  public String fmB;
  public boolean fmC;
  public boolean fmD;
  private a fmE;
  public String fmF;
  public int fmx;
  private int index;
  public int sampleRate;
  
  public d(String paramString)
  {
    AppMethodBeat.i(136709);
    this.index = 0;
    this.count = 0;
    this.bufferSize = 0L;
    this.fmD = false;
    this.sampleRate = 44100;
    this.channels = 2;
    this.fmx = 2;
    this.fmA = new ArrayList();
    this.fmB = paramString;
    AppMethodBeat.o(136709);
  }
  
  private void acX()
  {
    AppMethodBeat.i(136719);
    this.fmD = false;
    adb();
    AppMethodBeat.o(136719);
  }
  
  private void acZ()
  {
    try
    {
      AppMethodBeat.i(136721);
      ada();
      AppMethodBeat.o(136721);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void ada()
  {
    AppMethodBeat.i(136722);
    if (this.fmE == null)
    {
      this.fmE = new a(this.appId, this.fmB);
      if (this.fmE.open())
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile success");
        this.fmE.bI(getBufferSize());
        AppMethodBeat.o(136722);
        return;
      }
      b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile fail");
      this.fmD = false;
      adb();
    }
    AppMethodBeat.o(136722);
  }
  
  private void adb()
  {
    AppMethodBeat.i(136723);
    if (this.fmE != null)
    {
      this.fmE.close();
      this.fmE.acW();
      this.fmE = null;
    }
    AppMethodBeat.o(136723);
  }
  
  private int b(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    AppMethodBeat.i(136724);
    if (this.fmE != null)
    {
      paramInt = this.fmE.b(paramArrayOfByte, paramLong, paramInt);
      AppMethodBeat.o(136724);
      return paramInt;
    }
    AppMethodBeat.o(136724);
    return 0;
  }
  
  private void kq(int paramInt)
  {
    AppMethodBeat.i(136713);
    b.i("MicroMsg.Mix.PcmBufferProvider", "resetProvider src:%s, size:%d, complete:%b, duration:%d, supportMixPlay:%b, bufferSize:%d", new Object[] { this.fmB, Integer.valueOf(paramInt), Boolean.valueOf(this.awf), Long.valueOf(this.duration), Boolean.valueOf(this.fmC), Long.valueOf(this.bufferSize) });
    this.fmA.clear();
    this.awf = false;
    this.duration = 0L;
    this.fmC = false;
    this.index = 0;
    this.bufferSize = 0L;
    acX();
    AppMethodBeat.o(136713);
  }
  
  private e ks(int paramInt)
  {
    AppMethodBeat.i(136725);
    if (paramInt >= this.count)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (this.fmE == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    int i = paramInt * 3536;
    if (i > this.fmE.getLength())
    {
      AppMethodBeat.o(136725);
      return null;
    }
    e locale = com.tencent.mm.audio.mix.b.d.ado().adp();
    if (locale == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (locale.fmy == null) {
      locale.fmy = new byte[3536];
    }
    for (;;)
    {
      System.nanoTime();
      if (b(locale.fmy, i, locale.fmy.length) > 0) {
        break;
      }
      com.tencent.mm.audio.mix.b.d.ado().b(locale);
      AppMethodBeat.o(136725);
      return null;
      Arrays.fill(locale.fmy, 0, locale.fmy.length, (byte)0);
    }
    locale.fmF = this.fmF;
    locale.sampleRate = this.sampleRate;
    locale.channels = this.channels;
    locale.fmx = this.fmx;
    locale.fmI = (paramInt * 20);
    AppMethodBeat.o(136725);
    return locale;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(136715);
    this.index += 1;
    parame.fmI = (this.index * 20);
    if (this.fmA != null) {
      this.fmA.add(parame);
    }
    AppMethodBeat.o(136715);
  }
  
  public final void acY()
  {
    try
    {
      AppMethodBeat.i(136720);
      if (this.fmE != null)
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "closeCacheFileWithNoDiscard success");
        this.fmE.close();
        this.fmE = null;
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
  
  public final boolean hm(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(136712);
        if (this.fmD)
        {
          b.i("MicroMsg.Mix.PcmBufferProvider", "cache to file has finish, file:%s", new Object[] { this.fmB });
          AppMethodBeat.o(136712);
          bool = true;
          return bool;
        }
        this.appId = paramString;
        int j = this.fmA.size();
        if (j > 0) {
          ada();
        }
        if (this.fmE == null)
        {
          b.e("MicroMsg.Mix.PcmBufferProvider", "cacheFile is null");
          this.fmD = false;
          AppMethodBeat.o(136712);
          bool = false;
          continue;
          if (i < j)
          {
            paramString = (e)this.fmA.get(i);
            if (i == 0)
            {
              this.fmF = paramString.fmF;
              this.sampleRate = paramString.sampleRate;
              this.fmx = paramString.fmx;
              this.channels = paramString.channels;
            }
            if (paramString == null) {
              break label301;
            }
            byte[] arrayOfByte = paramString.fmy;
            long l = i * 3536;
            int k = paramString.fmy.length;
            if (this.fmE == null) {
              break label295;
            }
            bool = this.fmE.c(arrayOfByte, l, k);
            if (bool) {
              break label301;
            }
            adb();
            b.e("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile fail");
            this.fmD = false;
            AppMethodBeat.o(136712);
            bool = false;
            continue;
          }
          this.fmD = true;
          i = j - 1;
          if (i >= 0)
          {
            paramString = (e)this.fmA.remove(i);
            if (paramString == null) {
              break label308;
            }
            com.tencent.mm.audio.mix.b.e.adq().b(paramString);
            break label308;
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
  
  public final e kr(int paramInt)
  {
    AppMethodBeat.i(136714);
    if ((this.fmD) && (this.fmE != null))
    {
      locale = ks(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.fmD) && (this.fmE == null))
    {
      acZ();
      locale = ks(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.fmA == null) || (this.fmA.size() == 0))
    {
      AppMethodBeat.o(136714);
      return null;
    }
    if (paramInt >= this.fmA.size())
    {
      AppMethodBeat.o(136714);
      return null;
    }
    e locale = (e)this.fmA.get(paramInt);
    AppMethodBeat.o(136714);
    return locale;
  }
  
  public final void ph()
  {
    AppMethodBeat.i(136717);
    this.awf = true;
    this.count = size();
    b.i("MicroMsg.Mix.PcmBufferProvider", "src:%s is complete cache", new Object[] { this.fmB });
    AppMethodBeat.o(136717);
  }
  
  public final void recycle()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(136711);
        int j = this.fmA.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.fmA.remove(i);
          if (locale != null) {
            com.tencent.mm.audio.mix.b.e.adq().b(locale);
          }
        }
        else
        {
          kq(j);
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
        int j = this.fmA.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.fmA.remove(i);
          if (locale != null)
          {
            locale.fmF = null;
            locale.fmy = null;
          }
        }
        else
        {
          kq(j);
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
    if ((this.count > 0) && (this.awf))
    {
      i = this.count;
      AppMethodBeat.o(136716);
      return i;
    }
    int i = this.fmA.size();
    AppMethodBeat.o(136716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.d
 * JD-Core Version:    0.7.0.1
 */