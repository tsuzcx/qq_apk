package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
{
  boolean dirty;
  private File ndb;
  List<RandomAccessFile> ndc;
  SparseArray<awk> ndd;
  int nde;
  
  f(File paramFile)
  {
    AppMethodBeat.i(21262);
    this.dirty = true;
    if (!paramFile.isDirectory())
    {
      boolean bool = paramFile.mkdirs();
      ab.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", new Object[] { paramFile.getAbsolutePath(), Boolean.valueOf(bool) });
    }
    this.ndb = paramFile;
    this.ndd = new SparseArray();
    AppMethodBeat.o(21262);
  }
  
  static void d(Closeable paramCloseable)
  {
    AppMethodBeat.i(21266);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(21266);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.DiskCache", "want close %s fail: %s", new Object[] { paramCloseable.getClass().getName(), localException.getMessage() });
        ab.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(21266);
  }
  
  private static String wK(int paramInt)
  {
    AppMethodBeat.i(21270);
    StringBuilder localStringBuilder = new StringBuilder("cache.data");
    if (paramInt == 0) {}
    for (String str = "";; str = String.valueOf(paramInt))
    {
      str = str;
      AppMethodBeat.o(21270);
      return str;
    }
  }
  
  final void bDY()
  {
    AppMethodBeat.i(21263);
    File localFile = new File(this.ndb, "cache.idx");
    Object localObject2 = new awj();
    String str = localFile.getAbsolutePath();
    Object localObject1 = localObject2;
    if (!bo.isNullOrNil(str)) {}
    try
    {
      ((awj)localObject2).parseFrom(bo.readFromFile(str));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.DiskCache", "load index file error");
        ab.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        wI(-1);
        awj localawj1 = new awj();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ab.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", new Object[] { Long.valueOf(localFile.length()) });
        ab.printErrStackTrace("MicroMsg.DiskCache", localOutOfMemoryError, "", new Object[0]);
        wI(-1);
        awj localawj2 = new awj();
      }
      AppMethodBeat.o(21263);
    }
    this.ndd.clear();
    localObject1 = ((awj)localObject1).xlT.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (awk)((Iterator)localObject1).next();
      this.ndd.put(((awk)localObject2).key, localObject2);
    }
  }
  
  final void bDZ()
  {
    AppMethodBeat.i(21267);
    awj localawj = new awj();
    int i = 0;
    while (i < this.ndd.size())
    {
      localObject = (awk)this.ndd.valueAt(i);
      localawj.xlT.add(0, localObject);
      ab.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", new Object[] { Integer.valueOf(((awk)localObject).key), Long.valueOf(((awk)localObject).xlU), Integer.valueOf(((awk)localObject).length), Integer.valueOf(((awk)localObject).xlV) });
      i += 1;
    }
    Object localObject = new File(this.ndb, "cache.idx");
    try
    {
      bo.z(((File)localObject).getAbsolutePath(), localawj.toByteArray());
      AppMethodBeat.o(21267);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.DiskCache", "save index data error: %s", new Object[] { localException.getMessage() });
      ab.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
      AppMethodBeat.o(21267);
    }
  }
  
  final void bEa()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(21268);
        if ((this.ndc == null) || (this.ndc.size() <= 0))
        {
          AppMethodBeat.o(21268);
          return;
        }
        Iterator localIterator = this.ndc.iterator();
        if (localIterator.hasNext()) {
          d((RandomAccessFile)localIterator.next());
        } else {
          AppMethodBeat.o(21268);
        }
      }
      finally {}
    }
  }
  
  final int bEb()
  {
    i = 0;
    for (;;)
    {
      Iterator localIterator;
      RandomAccessFile localRandomAccessFile;
      int j;
      long l;
      try
      {
        AppMethodBeat.i(21271);
        if ((this.ndc == null) || (this.ndc.size() <= 0))
        {
          AppMethodBeat.o(21271);
          return i;
        }
      }
      finally {}
      try
      {
        localIterator = this.ndc.iterator();
        i = -1;
        if (!localIterator.hasNext()) {
          break label112;
        }
        localRandomAccessFile = (RandomAccessFile)localIterator.next();
        j = i + 1;
        l = localRandomAccessFile.length();
        i = j;
        if (l >= 2097152L) {
          continue;
        }
        i = j;
      }
      catch (IOException localIOException)
      {
        ab.printErrStackTrace("MicroMsg.DiskCache", localIOException, "", new Object[0]);
        i = -1;
        continue;
      }
      AppMethodBeat.o(21271);
      continue;
      label112:
      i = -1;
    }
  }
  
  public final void bEc()
  {
    AppMethodBeat.i(21272);
    ah.getContext().getSharedPreferences(ah.dsP(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", this.nde).commit();
    AppMethodBeat.o(21272);
  }
  
  final void wH(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(21264);
        if (paramInt < 0) {}
      }
      finally {}
      try
      {
        if (this.ndc != null) {
          continue;
        }
        this.ndc = new ArrayList();
        paramInt = i;
        if (paramInt < 25)
        {
          localRandomAccessFile = new RandomAccessFile(new File(this.ndb, wK(paramInt)), "rw");
          this.ndc.add(localRandomAccessFile);
          paramInt += 1;
          continue;
        }
        AppMethodBeat.o(21264);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.DiskCache", "create data file error: %s", new Object[] { localException.getMessage() });
        ab.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        this.ndc = null;
        AppMethodBeat.o(21264);
        continue;
      }
      return;
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(new File(this.ndb, wK(paramInt)), "rw");
      this.ndc.remove(paramInt);
      this.ndc.add(paramInt, localRandomAccessFile);
      AppMethodBeat.o(21264);
    }
  }
  
  final void wI(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(21265);
    if ((this.ndc == null) || (this.ndc.size() <= 0))
    {
      AppMethodBeat.o(21265);
      return;
    }
    if (paramInt < 0)
    {
      new File(this.ndb, "cache.idx").delete();
      this.ndd.clear();
    }
    while (paramInt < 0)
    {
      bEa();
      paramInt = j;
      for (;;)
      {
        if (paramInt < 25)
        {
          new File(this.ndb, wK(25)).delete();
          paramInt += 1;
          continue;
          SparseArray localSparseArray = new SparseArray();
          int i = 0;
          while (i < this.ndd.size())
          {
            awk localawk = (awk)this.ndd.valueAt(i);
            if (localawk.xlV != paramInt) {
              localSparseArray.put(this.ndd.keyAt(i), localawk);
            }
            ab.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", new Object[] { Integer.valueOf(localawk.key), Long.valueOf(localawk.xlU), Integer.valueOf(localawk.length) });
            i += 1;
          }
          this.ndd = localSparseArray;
          bDZ();
          break;
        }
      }
      AppMethodBeat.o(21265);
      return;
    }
    d((Closeable)this.ndc.get(paramInt));
    new File(this.ndb, wK(paramInt)).delete();
    AppMethodBeat.o(21265);
  }
  
  public final Bitmap wJ(int paramInt)
  {
    AppMethodBeat.i(21269);
    if ((this.ndc == null) || (this.ndc.size() <= 0))
    {
      ab.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
      AppMethodBeat.o(21269);
      return null;
    }
    Object localObject = (awk)this.ndd.get(paramInt);
    if (localObject != null)
    {
      byte[] arrayOfByte = new byte[((awk)localObject).length];
      for (;;)
      {
        try
        {
          ab.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", new Object[] { Long.valueOf(((awk)localObject).xlU), Integer.valueOf(((awk)localObject).length) });
          RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.ndc.get(((awk)localObject).xlV);
          localRandomAccessFile.seek(((awk)localObject).xlU);
          localRandomAccessFile.read(arrayOfByte, 0, ((awk)localObject).length);
          localObject = d.bT(arrayOfByte);
          if (localObject != null)
          {
            ab.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", new Object[] { Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
            AppMethodBeat.o(21269);
            return localObject;
          }
        }
        catch (Exception localException)
        {
          ab.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", new Object[] { Integer.valueOf(paramInt), localException.getMessage() });
          ab.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
          this.ndd.remove(paramInt);
          AppMethodBeat.o(21269);
          return null;
        }
        this.ndd.remove(paramInt);
      }
    }
    AppMethodBeat.o(21269);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.f
 * JD-Core Version:    0.7.0.1
 */