package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.c;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.Arrays;

public final class d
{
  private static long dcf = 0L;
  private static long dcg = 0L;
  public boolean aBS;
  private String appId;
  private long bufferSize;
  public int channels;
  private int count;
  public int dbW;
  private ArrayList<e> dbZ;
  public String dca;
  public boolean dcb;
  public boolean dcc;
  private a dcd;
  public String dce;
  public long duration;
  private int index;
  public int sampleRate;
  
  public d(String paramString)
  {
    AppMethodBeat.i(136709);
    this.index = 0;
    this.count = 0;
    this.bufferSize = 0L;
    this.dcc = false;
    this.sampleRate = 44100;
    this.channels = 2;
    this.dbW = 2;
    this.dbZ = new ArrayList();
    this.dca = paramString;
    AppMethodBeat.o(136709);
  }
  
  private void Oh()
  {
    AppMethodBeat.i(136719);
    this.dcc = false;
    Ol();
    AppMethodBeat.o(136719);
  }
  
  private void Oj()
  {
    try
    {
      AppMethodBeat.i(136721);
      Ok();
      AppMethodBeat.o(136721);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void Ok()
  {
    AppMethodBeat.i(136722);
    if (this.dcd == null)
    {
      this.dcd = new a(this.appId, this.dca);
      if (this.dcd.open())
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile success");
        this.dcd.setLength(getBufferSize());
        AppMethodBeat.o(136722);
        return;
      }
      b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile fail");
      this.dcc = false;
      Ol();
    }
    AppMethodBeat.o(136722);
  }
  
  private void Ol()
  {
    AppMethodBeat.i(136723);
    if (this.dcd != null)
    {
      this.dcd.close();
      this.dcd.Og();
      this.dcd = null;
    }
    AppMethodBeat.o(136723);
  }
  
  private void hE(int paramInt)
  {
    AppMethodBeat.i(136713);
    b.i("MicroMsg.Mix.PcmBufferProvider", "resetProvider src:%s, size:%d, complete:%b, duration:%d, supportMixPlay:%b, bufferSize:%d", new Object[] { this.dca, Integer.valueOf(paramInt), Boolean.valueOf(this.aBS), Long.valueOf(this.duration), Boolean.valueOf(this.dcb), Long.valueOf(this.bufferSize) });
    this.dbZ.clear();
    this.aBS = false;
    this.duration = 0L;
    this.dcb = false;
    this.index = 0;
    this.bufferSize = 0L;
    Oh();
    AppMethodBeat.o(136713);
  }
  
  private e hG(int paramInt)
  {
    AppMethodBeat.i(136725);
    if (paramInt >= this.count)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (this.dcd == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    int i = paramInt * 3536;
    if (i > this.dcd.getLength())
    {
      AppMethodBeat.o(136725);
      return null;
    }
    e locale = c.Oq().Or();
    if (locale == null)
    {
      AppMethodBeat.o(136725);
      return null;
    }
    if (locale.dbX == null) {
      locale.dbX = new byte[3536];
    }
    for (;;)
    {
      System.nanoTime();
      if (read(locale.dbX, i, locale.dbX.length) > 0) {
        break;
      }
      c.Oq().b(locale);
      AppMethodBeat.o(136725);
      return null;
      Arrays.fill(locale.dbX, 0, locale.dbX.length, (byte)0);
    }
    locale.dce = this.dce;
    locale.sampleRate = this.sampleRate;
    locale.channels = this.channels;
    locale.dbW = this.dbW;
    locale.dch = (paramInt * 20);
    AppMethodBeat.o(136725);
    return locale;
  }
  
  private int read(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    AppMethodBeat.i(136724);
    if (this.dcd != null)
    {
      paramInt = this.dcd.read(paramArrayOfByte, paramLong, paramInt);
      AppMethodBeat.o(136724);
      return paramInt;
    }
    AppMethodBeat.o(136724);
    return 0;
  }
  
  public final void Oi()
  {
    try
    {
      AppMethodBeat.i(136720);
      if (this.dcd != null)
      {
        b.i("MicroMsg.Mix.PcmBufferProvider", "closeCacheFileWithNoDiscard success");
        this.dcd.close();
        this.dcd = null;
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
    parame.dch = (this.index * 20);
    if (this.dbZ != null) {
      this.dbZ.add(parame);
    }
    AppMethodBeat.o(136715);
  }
  
  public final void complete()
  {
    AppMethodBeat.i(136717);
    this.aBS = true;
    this.count = size();
    b.i("MicroMsg.Mix.PcmBufferProvider", "src:%s is complete cache", new Object[] { this.dca });
    AppMethodBeat.o(136717);
  }
  
  public final boolean fI(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(136712);
        if (this.dcc)
        {
          b.i("MicroMsg.Mix.PcmBufferProvider", "cache to file has finish, file:%s", new Object[] { this.dca });
          AppMethodBeat.o(136712);
          bool = true;
          return bool;
        }
        this.appId = paramString;
        int j = this.dbZ.size();
        if (j > 0) {
          Ok();
        }
        if (this.dcd == null)
        {
          b.e("MicroMsg.Mix.PcmBufferProvider", "cacheFile is null");
          this.dcc = false;
          AppMethodBeat.o(136712);
          bool = false;
          continue;
          if (i < j)
          {
            paramString = (e)this.dbZ.get(i);
            if (i == 0)
            {
              this.dce = paramString.dce;
              this.sampleRate = paramString.sampleRate;
              this.dbW = paramString.dbW;
              this.channels = paramString.channels;
            }
            if (paramString == null) {
              break label302;
            }
            byte[] arrayOfByte = paramString.dbX;
            long l = i * 3536;
            int k = paramString.dbX.length;
            if (this.dcd == null) {
              break label296;
            }
            bool = this.dcd.a(arrayOfByte, l, k);
            if (bool) {
              break label302;
            }
            Ol();
            b.e("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile fail");
            this.dcc = false;
            AppMethodBeat.o(136712);
            bool = false;
            continue;
          }
          this.dcc = true;
          i = j - 1;
          if (i >= 0)
          {
            paramString = (e)this.dbZ.remove(i);
            if (paramString == null) {
              break label309;
            }
            com.tencent.mm.audio.mix.b.d.Os().b(paramString);
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
  
  public final e hF(int paramInt)
  {
    AppMethodBeat.i(136714);
    if ((this.dcc) && (this.dcd != null))
    {
      locale = hG(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.dcc) && (this.dcd == null))
    {
      Oj();
      locale = hG(paramInt);
      AppMethodBeat.o(136714);
      return locale;
    }
    if ((this.dbZ == null) || (this.dbZ.size() == 0))
    {
      AppMethodBeat.o(136714);
      return null;
    }
    if (paramInt >= this.dbZ.size())
    {
      AppMethodBeat.o(136714);
      return null;
    }
    e locale = (e)this.dbZ.get(paramInt);
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
        int j = this.dbZ.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.dbZ.remove(i);
          if (locale != null) {
            com.tencent.mm.audio.mix.b.d.Os().b(locale);
          }
        }
        else
        {
          hE(j);
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
        int j = this.dbZ.size();
        i = j - 1;
        if (i >= 0)
        {
          e locale = (e)this.dbZ.remove(i);
          if (locale != null)
          {
            locale.dce = null;
            locale.dbX = null;
          }
        }
        else
        {
          hE(j);
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
    int i = this.dbZ.size();
    AppMethodBeat.o(136716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.a.d
 * JD-Core Version:    0.7.0.1
 */