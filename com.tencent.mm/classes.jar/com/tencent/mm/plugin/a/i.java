package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public final class i
  implements p
{
  private long duration;
  private String filePath;
  private long foi;
  public int hXB = 0;
  private long hXs;
  private long[] hXv;
  public int hXw;
  private List<m> hXx;
  private List<Pair> hXy;
  
  private static o a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(133872);
    ad.d("MicroMsg.Mp4Parser", "start to find trak atom.");
    if (!c.a(paramRandomAccessFile, paramLong))
    {
      AppMethodBeat.o(133872);
      return null;
    }
    paramRandomAccessFile = (o)c.a(paramRandomAccessFile, paramArrayOfByte, a.bak);
    AppMethodBeat.o(133872);
    return paramRandomAccessFile;
  }
  
  private void reset()
  {
    AppMethodBeat.i(204031);
    this.filePath = null;
    this.hXv = null;
    this.hXw = 0;
    this.duration = 0L;
    this.hXs = 0L;
    this.foi = 0L;
    if (this.hXx != null) {
      this.hXx.clear();
    }
    if (this.hXy != null) {
      this.hXy.clear();
    }
    this.hXB = 0;
    AppMethodBeat.o(204031);
  }
  
  public final boolean E(String paramString, long paramLong)
  {
    AppMethodBeat.i(133871);
    reset();
    this.filePath = paramString;
    this.foi = paramLong;
    if (!new e(this.filePath).exists())
    {
      AppMethodBeat.o(133871);
      return false;
    }
    RandomAccessFile localRandomAccessFile = null;
    Object localObject3 = null;
    localObject1 = localObject3;
    paramString = localRandomAccessFile;
    for (;;)
    {
      try
      {
        arrayOfByte = new byte[8];
        localObject1 = localObject3;
        paramString = localRandomAccessFile;
        localRandomAccessFile = com.tencent.mm.vfs.i.cS(this.filePath, false);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        localObject3 = a(localRandomAccessFile, arrayOfByte, this.foi);
        if (localObject3 == null) {
          continue;
        }
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ad.d("MicroMsg.Mp4Parser", "last trak atom file pos : " + ((a)localObject3).hWV);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        localf = o.b(localRandomAccessFile, arrayOfByte);
        if (localf == null) {
          continue;
        }
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        if (!localf.a(localRandomAccessFile, arrayOfByte)) {
          continue;
        }
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        if (localf.hXt != f.hXp) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte;
        f localf;
        paramString = (String)localObject1;
        ad.printErrStackTrace("MicroMsg.Mp4Parser", localException, "", new Object[0]);
        paramString = (String)localObject1;
        ad.e("MicroMsg.Mp4Parser", "parser mp4 error. e: " + localException.toString());
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((RandomAccessFile)localObject1).close();
          AppMethodBeat.o(133871);
          return false;
        }
        catch (IOException paramString)
        {
          ad.printErrStackTrace("MicroMsg.Mp4Parser", paramString, "", new Object[0]);
          continue;
        }
      }
      finally
      {
        if (paramString == null) {
          continue;
        }
        try
        {
          paramString.close();
          AppMethodBeat.o(133871);
          throw localObject2;
        }
        catch (IOException paramString)
        {
          ad.printErrStackTrace("MicroMsg.Mp4Parser", paramString, "", new Object[0]);
          continue;
        }
        int i = 0;
        continue;
      }
      if (i == 0)
      {
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        paramLong = ((o)localObject3).getEndPos() - localRandomAccessFile.getFilePointer();
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ad.d("MicroMsg.Mp4Parser", "this trak atom is not video trak skip: ".concat(String.valueOf(paramLong)));
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        localObject3 = a(localRandomAccessFile, arrayOfByte, paramLong);
        continue;
      }
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      this.hXs = localf.hXs;
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      this.duration = localf.duration;
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      ad.d("MicroMsg.Mp4Parser", "this trak atom is video trak. timeScale: " + this.hXs + " duration: " + this.duration);
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      localRandomAccessFile.seek(localf.hXu);
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      localObject3 = (n)c.a(localRandomAccessFile, arrayOfByte, a.ban);
      if (localObject3 != null)
      {
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ((n)localObject3).duration = this.duration;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ((n)localObject3).hXs = this.hXs;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ((n)localObject3).f(localRandomAccessFile);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.hXv = ((n)localObject3).hXv;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.hXw = (this.hXv.length - 2);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.hXx = ((n)localObject3).hXx;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.hXy = ((n)localObject3).hXy;
      }
      if (localRandomAccessFile != null) {}
      try
      {
        localRandomAccessFile.close();
        AppMethodBeat.o(133871);
        return true;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ad.w("MicroMsg.Mp4Parser", "mdia atom parser fail.");
        localObject3 = null;
      }
      catch (IOException paramString)
      {
        ad.printErrStackTrace("MicroMsg.Mp4Parser", paramString, "", new Object[0]);
      }
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2)
  {
    if (this.hXv == null) {
      return false;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = this.hXv.length;
    if (i < j)
    {
      paramInt1 = paramInt2;
      if (paramInt2 < j) {}
    }
    else
    {
      i = j - 2;
      paramInt1 = j - 1;
    }
    long l1 = this.hXv[i];
    long l2 = this.hXv[paramInt1];
    if (i == 0) {
      paramPInt1.value = 0;
    }
    for (paramPInt2.value = ((int)l2);; paramPInt2.value = ((int)l2 - (int)l1))
    {
      return true;
      paramPInt1.value = ((int)l1);
    }
  }
  
  public final int aGP()
  {
    AppMethodBeat.i(204032);
    for (;;)
    {
      try
      {
        if (this.hXy == null) {
          continue;
        }
        if (this.hXB == 0) {
          this.hXB = ((int)(((Long)((Pair)this.hXy.get(this.hXy.size() - 1)).second).longValue() / 1000L / 1000L));
        }
        i = this.hXB;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Mp4Parser", localException, "get last key frame error.", new Object[0]);
        int i = 0;
        continue;
      }
      AppMethodBeat.o(204032);
      return i;
      i = 0;
    }
  }
  
  public final int aGR()
  {
    return this.hXw;
  }
  
  @TargetApi(5)
  public final boolean b(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(204033);
    for (;;)
    {
      try
      {
        if (this.hXy == null) {
          continue;
        }
        j = this.hXy.size();
        long l = paramInt;
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        i = 0;
        if (i >= j) {
          continue;
        }
        localPair = (Pair)this.hXy.get(i);
        if (((Long)localPair.second).longValue() <= 1000L * (l * 1000L)) {
          continue;
        }
        paramPInt2.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
        bool = true;
      }
      catch (Exception localException1)
      {
        int j;
        int i;
        Pair localPair;
        boolean bool = false;
        ad.printErrStackTrace("MicroMsg.Mp4Parser", localException1, "seekVFrame seekTime[%d]", new Object[] { Integer.valueOf(paramInt) });
        continue;
        continue;
        bool = false;
        continue;
      }
      if (bool) {
        continue;
      }
      try
      {
        paramPInt1.value = ((int)(((Long)((Pair)this.hXy.get(j - 1)).second).longValue() / 1000L / 1000L));
        paramPInt2.value = paramInt;
        bool = true;
        ad.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
        AppMethodBeat.o(204033);
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      paramPInt1.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
      i += 1;
    }
    AppMethodBeat.o(204033);
    return false;
  }
  
  public final int dw(int paramInt1, int paramInt2)
  {
    if (this.hXv == null) {
      return 0;
    }
    long l = paramInt1 + paramInt2;
    paramInt1 = 0;
    paramInt2 = 0;
    int i = paramInt2;
    if (paramInt1 < this.hXv.length)
    {
      if (this.hXv[paramInt1] == l) {
        i = paramInt1;
      }
    }
    else {
      label44:
      return i;
    }
    if (this.hXv[paramInt1] < l) {
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      paramInt1 += 1;
      break;
      i = paramInt2;
      if (this.hXv[paramInt1] > l) {
        break label44;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(204034);
    reset();
    AppMethodBeat.o(204034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.i
 * JD-Core Version:    0.7.0.1
 */