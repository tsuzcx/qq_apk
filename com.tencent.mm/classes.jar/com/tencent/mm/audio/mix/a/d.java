package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.c;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.Arrays;

public final class d
{
  private static long cQP = 0L;
  private static long cQQ = 0L;
  public boolean aAb;
  private String appId;
  private long bufferSize;
  public int cQG;
  private ArrayList<e> cQJ;
  public String cQK;
  public boolean cQL;
  public boolean cQM;
  private a cQN;
  public String cQO;
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
    this.cQM = false;
    this.sampleRate = 44100;
    this.channels = 2;
    this.cQG = 2;
    this.cQJ = new ArrayList();
    this.cQK = paramString;
    AppMethodBeat.o(136709);
  }
  
  private void MA()
  {
    try
    {
      AppMethodBeat.i(136721);
      MB();
      AppMethodBeat.o(136721);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void MB()
  {
    AppMethodBeat.i(136722);
    if (this.cQN == null)
    {
      this.cQN = new a(this.appId, this.cQK);
      if (this.cQN.open())
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile success");
        this.cQN.setLength(getBufferSize());
        AppMethodBeat.o(136722);
        return;
      }
      b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile fail");
      this.cQM = false;
      MC();
    }
    AppMethodBeat.o(136722);
  }
  
  private void MC()
  {
    AppMethodBeat.i(136723);
    if (this.cQN != null)
    {
      this.cQN.close();
      this.cQN.Mx();
      this.cQN = null;
    }
    AppMethodBeat.o(136723);
  }
  
  private void My()
  {
    AppMethodBeat.i(136719);
    this.cQM = false;
    MC();
    AppMethodBeat.o(136719);
  }
  
  private void hx(int paramInt)
  {
    AppMethodBeat.i(136713);
    b.i("MicroMsg.Mix.PcmBufferProvider", "resetProvider src:%s, size:%d, complete:%b, duration:%d, supportMixPlay:%b, bufferSize:%d", new Object[] { this.cQK, Integer.valueOf(paramInt), Boolean.valueOf(this.aAb), Long.valueOf(this.duration), Boolean.valueOf(this.cQL), Long.valueOf(this.bufferSize) });
    this.cQJ.clear();
    this.aAb = false;
    this.duration = 0L;
    this.cQL = false;
    this.index = 0;
    this.bufferSize = 0L;
    My();
    AppMethodBeat.o(136713);
  }
  
  private e hz(int paramInt)
  {
    AppMethodBeat.i(136725);
    if (paramInt >= this.count)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (this.cQN == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    int i = paramInt * 3536;
    if (i > this.cQN.getLength())
    {
      AppMethodBeat.o(136725);
      return null;
    }
    e locale = c.MH().MI();
    if (locale == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (locale.cQH == null) {
      locale.cQH = new byte[3536];
    }
    for (;;)
    {
      System.nanoTime();
      if (read(locale.cQH, i, locale.cQH.length) > 0) {
        break;
      }
      c.MH().b(locale);
      AppMethodBeat.o(136725);
      return null;
      Arrays.fill(locale.cQH, 0, locale.cQH.length, (byte)0);
    }
    locale.cQO = this.cQO;
    locale.sampleRate = this.sampleRate;
    locale.channels = this.channels;
    locale.cQG = this.cQG;
    locale.cQR = (paramInt * 20);
    AppMethodBeat.o(136725);
    return locale;
  }
  
  private int read(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    AppMethodBeat.i(136724);
    if (this.cQN != null)
    {
      paramInt = this.cQN.read(paramArrayOfByte, paramLong, paramInt);
      AppMethodBeat.o(136724);
      return paramInt;
    }
    AppMethodBeat.o(136724);
    return 0;
  }
  
  public final void Mz()
  {
    try
    {
      AppMethodBeat.i(136720);
      if (this.cQN != null)
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "closeCacheFileWithNoDiscard success");
        this.cQN.close();
        this.cQN = null;
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
    parame.cQR = (this.index * 20);
    if (this.cQJ != null) {
      this.cQJ.add(parame);
    }
    AppMethodBeat.o(136715);
  }
  
  public final void complete()
  {
    AppMethodBeat.i(136717);
    this.aAb = true;
    this.count = size();
    b.i("MicroMsg.Mix.PcmBufferProvider", "src:%s is complete cache", new Object[] { this.cQK });
    AppMethodBeat.o(136717);
  }
  
  public final boolean eN(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(136712);
        if (this.cQM)
        {
          b.i("MicroMsg.Mix.PcmBufferProvider", "cache to file has finish, file:%s", new Object[] { this.cQK });
          AppMethodBeat.o(136712);
          bool = true;
          return bool;
        }
        this.appId = paramString;
        int j = this.cQJ.size();
        if (j > 0) {
          MB();
        }
        if (this.cQN == null)
        {
          b.e("MicroMsg.Mix.PcmBufferProvider", "cacheFile is null");
          this.cQM = false;
          AppMethodBeat.o(136712);
          bool = false;
          continue;
          if (i < j)
          {
            paramString = (e)this.cQJ.get(i);
            if (i == 0)
            {
              this.cQO = paramString.cQO;
              this.sampleRate = paramString.sampleRate;
              this.cQG = paramString.cQG;
              this.channels = paramString.channels;
            }
            if (paramString == null) {
              break label302;
            }
            byte[] arrayOfByte = paramString.cQH;
            long l = i * 3536;
            int k = paramString.cQH.length;
            if (this.cQN == null) {
              break label296;
            }
            bool = this.cQN.a(arrayOfByte, l, k);
            if (bool) {
              break label302;
            }
            MC();
            b.e("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile fail");
            this.cQM = false;
            AppMethodBeat.o(136712);
            bool = false;
            continue;
          }
          this.cQM = true;
          i = j - 1;
          if (i >= 0)
          {
            paramString = (e)this.cQJ.remove(i);
            if (paramString == null) {
              break label309;
            }
            com.tencent.mm.audio.mix.b.d.MJ().b(paramString);
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
  
  public final e hy(int paramInt)
  {
    AppMethodBeat.i(136714);
    if ((this.cQM) && (this.cQN != null))
    {
      locale = hz(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.cQM) && (this.cQN == null))
    {
      MA();
      locale = hz(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.cQJ == null) || (this.cQJ.size() == 0))
    {
      AppMethodBeat.o(136714);
      return null;
    }
    if (paramInt >= this.cQJ.size())
    {
      AppMethodBeat.o(136714);
      return null;
    }
    e locale = (e)this.cQJ.get(paramInt);
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
        int j = this.cQJ.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.cQJ.remove(i);
          if (locale != null) {
            com.tencent.mm.audio.mix.b.d.MJ().b(locale);
          }
        }
        else
        {
          hx(j);
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
        int j = this.cQJ.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.cQJ.remove(i);
          if (locale != null)
          {
            locale.cQO = null;
            locale.cQH = null;
          }
        }
        else
        {
          hx(j);
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
    if ((this.count > 0) && (this.aAb))
    {
      i = this.count;
      AppMethodBeat.o(136716);
      return i;
    }
    int i = this.cQJ.size();
    AppMethodBeat.o(136716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.d
 * JD-Core Version:    0.7.0.1
 */