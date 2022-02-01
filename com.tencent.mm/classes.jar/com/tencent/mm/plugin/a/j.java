package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public final class j
  implements f
{
  private long duration;
  private String filePath;
  private long frC;
  public int ixA;
  private List<n> ixB;
  private List<Pair> ixC;
  public int ixF = 0;
  private long ixw;
  private long[] ixz;
  
  private static p a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(133872);
    ac.d("MicroMsg.Mp4Parser", "start to find trak atom.");
    if (!c.a(paramRandomAccessFile, paramLong))
    {
      AppMethodBeat.o(133872);
      return null;
    }
    paramRandomAccessFile = (p)c.a(paramRandomAccessFile, paramArrayOfByte, a.baW);
    AppMethodBeat.o(133872);
    return paramRandomAccessFile;
  }
  
  private void reset()
  {
    AppMethodBeat.i(191666);
    this.filePath = null;
    this.ixz = null;
    this.ixA = 0;
    this.duration = 0L;
    this.ixw = 0L;
    this.frC = 0L;
    if (this.ixB != null) {
      this.ixB.clear();
    }
    if (this.ixC != null) {
      this.ixC.clear();
    }
    this.ixF = 0;
    AppMethodBeat.o(191666);
  }
  
  public final boolean F(String paramString, long paramLong)
  {
    AppMethodBeat.i(133871);
    reset();
    this.filePath = paramString;
    this.frC = paramLong;
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
        localRandomAccessFile = i.cY(this.filePath, false);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        localObject3 = a(localRandomAccessFile, arrayOfByte, this.frC);
        if (localObject3 == null) {
          continue;
        }
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ac.d("MicroMsg.Mp4Parser", "last trak atom file pos : " + ((a)localObject3).iwZ);
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
        if (localg.ixx != g.ixt) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte;
        g localg;
        paramString = (String)localObject1;
        ac.printErrStackTrace("MicroMsg.Mp4Parser", localException, "", new Object[0]);
        paramString = (String)localObject1;
        ac.e("MicroMsg.Mp4Parser", "parser mp4 error. e: " + localException.toString());
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
          ac.printErrStackTrace("MicroMsg.Mp4Parser", paramString, "", new Object[0]);
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
          ac.printErrStackTrace("MicroMsg.Mp4Parser", paramString, "", new Object[0]);
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
        ac.d("MicroMsg.Mp4Parser", "this trak atom is not video trak skip: ".concat(String.valueOf(paramLong)));
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        localObject3 = a(localRandomAccessFile, arrayOfByte, paramLong);
        continue;
      }
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      this.ixw = localg.ixw;
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      this.duration = localg.duration;
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      ac.d("MicroMsg.Mp4Parser", "this trak atom is video trak. timeScale: " + this.ixw + " duration: " + this.duration);
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      localRandomAccessFile.seek(localg.ixy);
      localObject1 = localRandomAccessFile;
      paramString = localRandomAccessFile;
      localObject3 = (o)c.a(localRandomAccessFile, arrayOfByte, a.baZ);
      if (localObject3 != null)
      {
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ((o)localObject3).duration = this.duration;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ((o)localObject3).ixw = this.ixw;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ((o)localObject3).f(localRandomAccessFile);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.ixz = ((o)localObject3).ixz;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.ixA = (this.ixz.length - 2);
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.ixB = ((o)localObject3).ixB;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        this.ixC = ((o)localObject3).ixC;
      }
      if (localRandomAccessFile != null) {}
      try
      {
        localRandomAccessFile.close();
        AppMethodBeat.o(133871);
        return true;
        localObject1 = localRandomAccessFile;
        paramString = localRandomAccessFile;
        ac.w("MicroMsg.Mp4Parser", "mdia atom parser fail.");
        localObject3 = null;
      }
      catch (IOException paramString)
      {
        ac.printErrStackTrace("MicroMsg.Mp4Parser", paramString, "", new Object[0]);
      }
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2)
  {
    if (this.ixz == null) {
      return false;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = this.ixz.length;
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
    long l1 = this.ixz[i];
    long l2 = this.ixz[paramInt1];
    if (i == 0) {
      paramPInt1.value = 0;
    }
    for (paramPInt2.value = ((int)l2);; paramPInt2.value = ((int)l2 - (int)l1))
    {
      return true;
      paramPInt1.value = ((int)l1);
    }
  }
  
  public final int aNC()
  {
    AppMethodBeat.i(191667);
    for (;;)
    {
      try
      {
        if (this.ixC == null) {
          continue;
        }
        if (this.ixF == 0) {
          this.ixF = ((int)(((Long)((Pair)this.ixC.get(this.ixC.size() - 1)).second).longValue() / 1000L / 1000L));
        }
        i = this.ixF;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.Mp4Parser", localException, "get last key frame error.", new Object[0]);
        int i = 0;
        continue;
      }
      AppMethodBeat.o(191667);
      return i;
      i = 0;
    }
  }
  
  public final int aND()
  {
    return this.ixA;
  }
  
  @TargetApi(5)
  public final boolean b(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(191668);
    for (;;)
    {
      try
      {
        if (this.ixC == null) {
          continue;
        }
        j = this.ixC.size();
        long l = paramInt;
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        i = 0;
        if (i >= j) {
          continue;
        }
        localPair = (Pair)this.ixC.get(i);
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
        ac.printErrStackTrace("MicroMsg.Mp4Parser", localException1, "seekVFrame seekTime[%d]", new Object[] { Integer.valueOf(paramInt) });
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
        paramPInt1.value = ((int)(((Long)((Pair)this.ixC.get(j - 1)).second).longValue() / 1000L / 1000L));
        paramPInt2.value = paramInt;
        bool = true;
        ac.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
        AppMethodBeat.o(191668);
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      paramPInt1.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
      i += 1;
    }
    AppMethodBeat.o(191668);
    return false;
  }
  
  public final int dw(int paramInt1, int paramInt2)
  {
    if (this.ixz == null) {
      return 0;
    }
    long l = paramInt1 + paramInt2;
    paramInt1 = 0;
    paramInt2 = 0;
    int i = paramInt2;
    if (paramInt1 < this.ixz.length)
    {
      if (this.ixz[paramInt1] == l) {
        i = paramInt1;
      }
    }
    else {
      label44:
      return i;
    }
    if (this.ixz[paramInt1] < l) {
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      paramInt1 += 1;
      break;
      i = paramInt2;
      if (this.ixz[paramInt1] > l) {
        break label44;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(191669);
    reset();
    AppMethodBeat.o(191669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.j
 * JD-Core Version:    0.7.0.1
 */