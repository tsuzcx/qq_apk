package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public final class j
  implements f
{
  private long duration;
  private long fJL;
  private String filePath;
  private long iQF;
  private long[] iQI;
  public int iQJ;
  private List<n> iQK;
  private List<Pair> iQL;
  public int iQO = 0;
  
  private static p a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(133872);
    ad.d("MicroMsg.Mp4Parser", "start to find trak atom.");
    if (!c.a(paramRandomAccessFile, paramLong))
    {
      AppMethodBeat.o(133872);
      return null;
    }
    paramRandomAccessFile = (p)c.a(paramRandomAccessFile, paramArrayOfByte, a.blr);
    AppMethodBeat.o(133872);
    return paramRandomAccessFile;
  }
  
  private void reset()
  {
    AppMethodBeat.i(197019);
    this.filePath = null;
    this.iQI = null;
    this.iQJ = 0;
    this.duration = 0L;
    this.iQF = 0L;
    this.fJL = 0L;
    if (this.iQK != null) {
      this.iQK.clear();
    }
    if (this.iQL != null) {
      this.iQL.clear();
    }
    this.iQO = 0;
    AppMethodBeat.o(197019);
  }
  
  public final boolean L(String paramString, long paramLong)
  {
    AppMethodBeat.i(133871);
    reset();
    this.filePath = paramString;
    this.fJL = paramLong;
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
        localRandomAccessFile = i.dd(this.filePath, false);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        localObject3 = a(localRandomAccessFile, arrayOfByte, this.fJL);
        if (localObject3 == null) {
          continue;
        }
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ad.d("MicroMsg.Mp4Parser", "last trak atom file pos : " + ((a)localObject3).iQi);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        localg = p.b(localRandomAccessFile, arrayOfByte);
        if (localg == null) {
          continue;
        }
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        if (!localg.a(localRandomAccessFile, arrayOfByte)) {
          continue;
        }
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        if (localg.iQG != g.iQC) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte;
        g localg;
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
        paramLong = ((p)localObject3).getEndPos() - localRandomAccessFile.getFilePointer();
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
      this.iQF = localg.iQF;
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      this.duration = localg.duration;
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      ad.d("MicroMsg.Mp4Parser", "this trak atom is video trak. timeScale: " + this.iQF + " duration: " + this.duration);
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      localRandomAccessFile.seek(localg.iQH);
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      localObject3 = (o)c.a(localRandomAccessFile, arrayOfByte, a.blu);
      if (localObject3 != null)
      {
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ((o)localObject3).duration = this.duration;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ((o)localObject3).iQF = this.iQF;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ((o)localObject3).f(localRandomAccessFile);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.iQI = ((o)localObject3).iQI;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.iQJ = (this.iQI.length - 2);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.iQK = ((o)localObject3).iQK;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.iQL = ((o)localObject3).iQL;
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
    if (this.iQI == null) {
      return false;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = this.iQI.length;
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
    long l1 = this.iQI[i];
    long l2 = this.iQI[paramInt1];
    if (i == 0) {
      paramPInt1.value = 0;
    }
    for (paramPInt2.value = ((int)l2);; paramPInt2.value = ((int)l2 - (int)l1))
    {
      return true;
      paramPInt1.value = ((int)l1);
    }
  }
  
  public final int aQO()
  {
    AppMethodBeat.i(197020);
    for (;;)
    {
      try
      {
        if (this.iQL == null) {
          continue;
        }
        if (this.iQO == 0) {
          this.iQO = ((int)(((Long)((Pair)this.iQL.get(this.iQL.size() - 1)).second).longValue() / 1000L / 1000L));
        }
        i = this.iQO;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Mp4Parser", localException, "get last key frame error.", new Object[0]);
        int i = 0;
        continue;
      }
      AppMethodBeat.o(197020);
      return i;
      i = 0;
    }
  }
  
  public final int aQP()
  {
    return this.iQJ;
  }
  
  @TargetApi(5)
  public final boolean b(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(197021);
    for (;;)
    {
      try
      {
        if (this.iQL == null) {
          continue;
        }
        j = this.iQL.size();
        long l = paramInt;
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        i = 0;
        if (i >= j) {
          continue;
        }
        localPair = (Pair)this.iQL.get(i);
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
        paramPInt1.value = ((int)(((Long)((Pair)this.iQL.get(j - 1)).second).longValue() / 1000L / 1000L));
        paramPInt2.value = paramInt;
        bool = true;
        ad.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
        AppMethodBeat.o(197021);
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      paramPInt1.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
      i += 1;
    }
    AppMethodBeat.o(197021);
    return false;
  }
  
  public final int dy(int paramInt1, int paramInt2)
  {
    if (this.iQI == null) {
      return 0;
    }
    long l = paramInt1 + paramInt2;
    paramInt1 = 0;
    paramInt2 = 0;
    int i = paramInt2;
    if (paramInt1 < this.iQI.length)
    {
      if (this.iQI[paramInt1] == l) {
        i = paramInt1;
      }
    }
    else {
      label44:
      return i;
    }
    if (this.iQI[paramInt1] < l) {
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      paramInt1 += 1;
      break;
      i = paramInt2;
      if (this.iQI[paramInt1] > l) {
        break label44;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(197022);
    reset();
    AppMethodBeat.o(197022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.a.j
 * JD-Core Version:    0.7.0.1
 */