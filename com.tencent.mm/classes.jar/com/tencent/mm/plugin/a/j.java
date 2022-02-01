package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public final class j
  implements f
{
  private long duration;
  private String filePath;
  private long gra;
  public int jQB = 0;
  private long jQs;
  private long[] jQv;
  public int jQw;
  private List<n> jQx;
  private List<Pair> jQy;
  
  private static p a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(133872);
    Log.d("MicroMsg.Mp4Parser", "start to find trak atom.");
    if (!c.a(paramRandomAccessFile, paramLong))
    {
      AppMethodBeat.o(133872);
      return null;
    }
    paramRandomAccessFile = (p)c.a(paramRandomAccessFile, paramArrayOfByte, a.blm);
    AppMethodBeat.o(133872);
    return paramRandomAccessFile;
  }
  
  private void reset()
  {
    AppMethodBeat.i(208734);
    this.filePath = null;
    this.jQv = null;
    this.jQw = 0;
    this.duration = 0L;
    this.jQs = 0L;
    this.gra = 0L;
    if (this.jQx != null) {
      this.jQx.clear();
    }
    if (this.jQy != null) {
      this.jQy.clear();
    }
    this.jQB = 0;
    AppMethodBeat.o(208734);
  }
  
  public final boolean L(String paramString, long paramLong)
  {
    AppMethodBeat.i(133871);
    reset();
    this.filePath = paramString;
    this.gra = paramLong;
    if (!new com.tencent.mm.vfs.o(this.filePath).exists())
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
        localRandomAccessFile = s.dB(this.filePath, false);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        localObject3 = a(localRandomAccessFile, arrayOfByte, this.gra);
        if (localObject3 == null) {
          continue;
        }
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        Log.d("MicroMsg.Mp4Parser", "last trak atom file pos : " + ((a)localObject3).jPV);
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
        if (localg.jQt != g.jQp) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte;
        g localg;
        paramString = (String)localObject1;
        Log.printErrStackTrace("MicroMsg.Mp4Parser", localException, "", new Object[0]);
        paramString = (String)localObject1;
        Log.e("MicroMsg.Mp4Parser", "parser mp4 error. e: " + localException.toString());
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
          Log.printErrStackTrace("MicroMsg.Mp4Parser", paramString, "", new Object[0]);
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
          Log.printErrStackTrace("MicroMsg.Mp4Parser", paramString, "", new Object[0]);
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
        Log.d("MicroMsg.Mp4Parser", "this trak atom is not video trak skip: ".concat(String.valueOf(paramLong)));
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        localObject3 = a(localRandomAccessFile, arrayOfByte, paramLong);
        continue;
      }
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      this.jQs = localg.jQs;
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      this.duration = localg.duration;
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      Log.d("MicroMsg.Mp4Parser", "this trak atom is video trak. timeScale: " + this.jQs + " duration: " + this.duration);
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      localRandomAccessFile.seek(localg.jQu);
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      localObject3 = (o)c.a(localRandomAccessFile, arrayOfByte, a.blp);
      if (localObject3 != null)
      {
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ((o)localObject3).duration = this.duration;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ((o)localObject3).jQs = this.jQs;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ((o)localObject3).f(localRandomAccessFile);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.jQv = ((o)localObject3).jQv;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.jQw = (this.jQv.length - 2);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.jQx = ((o)localObject3).jQx;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.jQy = ((o)localObject3).jQy;
      }
      if (localRandomAccessFile != null) {}
      try
      {
        localRandomAccessFile.close();
        AppMethodBeat.o(133871);
        return true;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        Log.w("MicroMsg.Mp4Parser", "mdia atom parser fail.");
        localObject3 = null;
      }
      catch (IOException paramString)
      {
        Log.printErrStackTrace("MicroMsg.Mp4Parser", paramString, "", new Object[0]);
      }
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2)
  {
    if (this.jQv == null) {
      return false;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = this.jQv.length;
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
    long l1 = this.jQv[i];
    long l2 = this.jQv[paramInt1];
    if (i == 0) {
      paramPInt1.value = 0;
    }
    for (paramPInt2.value = ((int)l2);; paramPInt2.value = ((int)l2 - (int)l1))
    {
      return true;
      paramPInt1.value = ((int)l1);
    }
  }
  
  @TargetApi(5)
  public final boolean b(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(208736);
    for (;;)
    {
      try
      {
        if (this.jQy == null) {
          continue;
        }
        j = this.jQy.size();
        long l = paramInt;
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        i = 0;
        if (i >= j) {
          continue;
        }
        localPair = (Pair)this.jQy.get(i);
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
        Log.printErrStackTrace("MicroMsg.Mp4Parser", localException1, "seekVFrame seekTime[%d]", new Object[] { Integer.valueOf(paramInt) });
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
        paramPInt1.value = ((int)(((Long)((Pair)this.jQy.get(j - 1)).second).longValue() / 1000L / 1000L));
        paramPInt2.value = paramInt;
        bool = true;
        Log.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
        AppMethodBeat.o(208736);
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      paramPInt1.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
      i += 1;
    }
    AppMethodBeat.o(208736);
    return false;
  }
  
  public final int blR()
  {
    AppMethodBeat.i(208735);
    for (;;)
    {
      try
      {
        if (this.jQy == null) {
          continue;
        }
        if (this.jQB == 0) {
          this.jQB = ((int)(((Long)((Pair)this.jQy.get(this.jQy.size() - 1)).second).longValue() / 1000L / 1000L));
        }
        i = this.jQB;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Mp4Parser", localException, "get last key frame error.", new Object[0]);
        int i = 0;
        continue;
      }
      AppMethodBeat.o(208735);
      return i;
      i = 0;
    }
  }
  
  public final int blS()
  {
    return this.jQw;
  }
  
  public final int dG(int paramInt1, int paramInt2)
  {
    if (this.jQv == null) {
      return 0;
    }
    long l = paramInt1 + paramInt2;
    paramInt1 = 0;
    paramInt2 = 0;
    int i = paramInt2;
    if (paramInt1 < this.jQv.length)
    {
      if (this.jQv[paramInt1] == l) {
        i = paramInt1;
      }
    }
    else {
      label44:
      return i;
    }
    if (this.jQv[paramInt1] < l) {
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      paramInt1 += 1;
      break;
      i = paramInt2;
      if (this.jQv[paramInt1] > l) {
        break label44;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(208737);
    reset();
    AppMethodBeat.o(208737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.a.j
 * JD-Core Version:    0.7.0.1
 */