package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public final class j
  implements f
{
  private long duration;
  private long fLO;
  private String filePath;
  private long[] iTB;
  public int iTC;
  private List<n> iTD;
  private List<Pair> iTE;
  public int iTH = 0;
  private long iTy;
  
  private static p a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(133872);
    ae.d("MicroMsg.Mp4Parser", "start to find trak atom.");
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
    AppMethodBeat.i(220253);
    this.filePath = null;
    this.iTB = null;
    this.iTC = 0;
    this.duration = 0L;
    this.iTy = 0L;
    this.fLO = 0L;
    if (this.iTD != null) {
      this.iTD.clear();
    }
    if (this.iTE != null) {
      this.iTE.clear();
    }
    this.iTH = 0;
    AppMethodBeat.o(220253);
  }
  
  public final boolean L(String paramString, long paramLong)
  {
    AppMethodBeat.i(133871);
    reset();
    this.filePath = paramString;
    this.fLO = paramLong;
    if (!new k(this.filePath).exists())
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
        localRandomAccessFile = com.tencent.mm.vfs.o.dg(this.filePath, false);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        localObject3 = a(localRandomAccessFile, arrayOfByte, this.fLO);
        if (localObject3 == null) {
          continue;
        }
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ae.d("MicroMsg.Mp4Parser", "last trak atom file pos : " + ((a)localObject3).iTb);
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
        if (localg.iTz != g.iTv) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte;
        g localg;
        paramString = (String)localObject1;
        ae.printErrStackTrace("MicroMsg.Mp4Parser", localException, "", new Object[0]);
        paramString = (String)localObject1;
        ae.e("MicroMsg.Mp4Parser", "parser mp4 error. e: " + localException.toString());
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
          ae.printErrStackTrace("MicroMsg.Mp4Parser", paramString, "", new Object[0]);
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
          ae.printErrStackTrace("MicroMsg.Mp4Parser", paramString, "", new Object[0]);
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
        ae.d("MicroMsg.Mp4Parser", "this trak atom is not video trak skip: ".concat(String.valueOf(paramLong)));
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        localObject3 = a(localRandomAccessFile, arrayOfByte, paramLong);
        continue;
      }
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      this.iTy = localg.iTy;
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      this.duration = localg.duration;
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      ae.d("MicroMsg.Mp4Parser", "this trak atom is video trak. timeScale: " + this.iTy + " duration: " + this.duration);
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      localRandomAccessFile.seek(localg.iTA);
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
        ((o)localObject3).iTy = this.iTy;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ((o)localObject3).f(localRandomAccessFile);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.iTB = ((o)localObject3).iTB;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.iTC = (this.iTB.length - 2);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.iTD = ((o)localObject3).iTD;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.iTE = ((o)localObject3).iTE;
      }
      if (localRandomAccessFile != null) {}
      try
      {
        localRandomAccessFile.close();
        AppMethodBeat.o(133871);
        return true;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ae.w("MicroMsg.Mp4Parser", "mdia atom parser fail.");
        localObject3 = null;
      }
      catch (IOException paramString)
      {
        ae.printErrStackTrace("MicroMsg.Mp4Parser", paramString, "", new Object[0]);
      }
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2)
  {
    if (this.iTB == null) {
      return false;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = this.iTB.length;
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
    long l1 = this.iTB[i];
    long l2 = this.iTB[paramInt1];
    if (i == 0) {
      paramPInt1.value = 0;
    }
    for (paramPInt2.value = ((int)l2);; paramPInt2.value = ((int)l2 - (int)l1))
    {
      return true;
      paramPInt1.value = ((int)l1);
    }
  }
  
  public final int aRn()
  {
    AppMethodBeat.i(220254);
    for (;;)
    {
      try
      {
        if (this.iTE == null) {
          continue;
        }
        if (this.iTH == 0) {
          this.iTH = ((int)(((Long)((Pair)this.iTE.get(this.iTE.size() - 1)).second).longValue() / 1000L / 1000L));
        }
        i = this.iTH;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.Mp4Parser", localException, "get last key frame error.", new Object[0]);
        int i = 0;
        continue;
      }
      AppMethodBeat.o(220254);
      return i;
      i = 0;
    }
  }
  
  public final int aRo()
  {
    return this.iTC;
  }
  
  @TargetApi(5)
  public final boolean b(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(220255);
    for (;;)
    {
      try
      {
        if (this.iTE == null) {
          continue;
        }
        j = this.iTE.size();
        long l = paramInt;
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        i = 0;
        if (i >= j) {
          continue;
        }
        localPair = (Pair)this.iTE.get(i);
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
        ae.printErrStackTrace("MicroMsg.Mp4Parser", localException1, "seekVFrame seekTime[%d]", new Object[] { Integer.valueOf(paramInt) });
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
        paramPInt1.value = ((int)(((Long)((Pair)this.iTE.get(j - 1)).second).longValue() / 1000L / 1000L));
        paramPInt2.value = paramInt;
        bool = true;
        ae.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
        AppMethodBeat.o(220255);
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      paramPInt1.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
      i += 1;
    }
    AppMethodBeat.o(220255);
    return false;
  }
  
  public final int dy(int paramInt1, int paramInt2)
  {
    if (this.iTB == null) {
      return 0;
    }
    long l = paramInt1 + paramInt2;
    paramInt1 = 0;
    paramInt2 = 0;
    int i = paramInt2;
    if (paramInt1 < this.iTB.length)
    {
      if (this.iTB[paramInt1] == l) {
        i = paramInt1;
      }
    }
    else {
      label44:
      return i;
    }
    if (this.iTB[paramInt1] < l) {
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      paramInt1 += 1;
      break;
      i = paramInt2;
      if (this.iTB[paramInt1] > l) {
        break label44;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(220256);
    reset();
    AppMethodBeat.o(220256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.j
 * JD-Core Version:    0.7.0.1
 */