package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.ai.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class e
  implements com.tencent.mm.af.e
{
  private static ab<String, Integer> gMZ = new ab(50);
  private static ab<String, Integer> gNa = new ab(50);
  private static ab<String, Integer> gNb = new ab(50);
  private long currentPosition;
  private String fCl;
  private int fDF = -1;
  private String filePath;
  private int gNc = -1;
  public RandomAccessFile randomAccessFile;
  
  public e(String paramString1, String paramString2)
  {
    this.filePath = paramString1;
    this.fCl = paramString2;
    this.randomAccessFile = bQ(paramString1, paramString2);
    if ((gMZ.aC(paramString1)) && (gNa.aC(paramString1)))
    {
      this.gNc = ((Integer)gMZ.get(paramString1)).intValue();
      this.fDF = ((Integer)gNa.get(paramString1)).intValue();
      return;
    }
    if (bk.bl(paramString2))
    {
      y.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
      return;
    }
    paramString2 = new ai(paramString2);
    if (!paramString2.fDy)
    {
      paramString2.close();
      y.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg invalid");
      return;
    }
    if (!paramString2.abX())
    {
      paramString2.close();
      y.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg readInfo failed");
      return;
    }
    ai.a locala = paramString2.ra(paramString1);
    if (locala == null)
    {
      paramString2.close();
      y.e("MicroMsg.WxaAudioDataSourceBelow19", "info is null, err");
      return;
    }
    if ((locala.fDG <= 0) || (locala.fDF <= 0))
    {
      paramString2.close();
      y.e("MicroMsg.WxaAudioDataSourceBelow19", "info.resLength or info.fileOffset, err");
      return;
    }
    this.gNc = locala.fDG;
    this.fDF = locala.fDF;
    gMZ.put(paramString1, Integer.valueOf(this.gNc));
    gNa.put(paramString1, Integer.valueOf(this.fDF));
    paramString2.close();
  }
  
  private RandomAccessFile bQ(String paramString1, String paramString2)
  {
    if (bk.bl(paramString2)) {
      y.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
    }
    label129:
    do
    {
      return null;
      y.i("MicroMsg.WxaAudioDataSourceBelow19", "filePath:%s, resLength:%d, fileOffset:%d", new Object[] { paramString1, Integer.valueOf(this.gNc), Integer.valueOf(this.fDF) });
      try
      {
        if (!new b(paramString2).exists())
        {
          y.e("MicroMsg.WxaAudioDataSourceBelow19", "file pkgPath:%s isn't exist ", new Object[] { paramString2 });
          return null;
        }
      }
      catch (FileNotFoundException paramString1)
      {
        y.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", paramString1, "", new Object[0]);
        return null;
        paramString2 = com.tencent.mm.vfs.e.bP(paramString2, false);
      }
      catch (IOException paramString1)
      {
        try
        {
          y.d("MicroMsg.WxaAudioDataSourceBelow19", "randomAccessFile.length:%d", new Object[] { Long.valueOf(paramString2.length()) });
          return paramString2;
        }
        catch (IOException paramString1)
        {
          break label129;
        }
        paramString1 = paramString1;
        paramString2 = null;
      }
      y.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", paramString1, "", new Object[0]);
    } while (paramString2 == null);
    try
    {
      paramString2.close();
      return null;
    }
    catch (IOException paramString1)
    {
      return null;
    }
  }
  
  public final int JP()
  {
    int j = 0;
    if (this.randomAccessFile == null) {
      this.randomAccessFile = bQ(this.filePath, this.fCl);
    }
    int i;
    if (gNb.aC(this.filePath)) {
      i = ((Integer)gNb.get(this.filePath)).intValue();
    }
    do
    {
      do
      {
        return i;
        if (this.randomAccessFile == null)
        {
          y.e("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] inputStream is null");
          return 0;
        }
        if (this.filePath.toLowerCase().endsWith(".mp3"))
        {
          y.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] mp3");
          return 2;
        }
        if (this.filePath.toLowerCase().contains(".wav"))
        {
          y.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] wav");
          return 3;
        }
        if (this.filePath.toLowerCase().contains(".ogg"))
        {
          y.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] ogg");
          return 4;
        }
        try
        {
          localObject1 = new byte[64];
          this.randomAccessFile.seek(this.fDF);
          this.randomAccessFile.read((byte[])localObject1);
          localObject1 = new String((byte[])localObject1);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject1;
            y.e("MicroMsg.WxaAudioDataSourceBelow19", "getAudioType", new Object[] { localException });
            this.randomAccessFile.seek(this.fDF);
            Object localObject2 = null;
          }
        }
        finally
        {
          this.randomAccessFile.seek(this.fDF);
        }
        i = j;
      } while (localObject1 == null);
      i = j;
    } while (!((String)localObject1).contains("ftyp"));
    y.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] aac");
    gNb.put(this.filePath, Integer.valueOf(1));
    return 1;
  }
  
  public final void close()
  {
    if (this.randomAccessFile != null)
    {
      y.i("MicroMsg.WxaAudioDataSourceBelow19", "close %d", new Object[] { Integer.valueOf(hashCode()) });
      this.randomAccessFile.close();
      this.randomAccessFile = null;
    }
  }
  
  public final long getSize()
  {
    if (this.randomAccessFile == null)
    {
      y.e("MicroMsg.WxaAudioDataSourceBelow19", "[getSize] randomAccessFile is null");
      return 0L;
    }
    return this.gNc;
  }
  
  public final boolean isOpen()
  {
    return (this.randomAccessFile != null) || (this.gNc == -1) || (this.fDF == -1);
  }
  
  public final void open()
  {
    y.i("MicroMsg.WxaAudioDataSourceBelow19", "open %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.randomAccessFile == null) {
      this.randomAccessFile = bQ(this.filePath, this.fCl);
    }
    this.currentPosition = 0L;
    if (this.randomAccessFile != null) {
      this.randomAccessFile.seek(this.fDF);
    }
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.randomAccessFile == null)
    {
      y.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]randomAccessFile is null");
      return -1;
    }
    if (this.currentPosition != paramLong)
    {
      this.randomAccessFile.seek(this.fDF + paramLong);
      this.currentPosition = paramLong;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      y.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]bytes is null");
      return -1;
    }
    if ((paramLong < 0L) || (paramInt1 < 0) || (paramInt2 <= 0))
    {
      y.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, offset:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return -1;
    }
    if ((paramArrayOfByte != null) && (paramInt1 + paramInt2 > paramArrayOfByte.length))
    {
      y.e("MicroMsg.WxaAudioDataSourceBelow19", "offset:%d, size:%d, bytes.length:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
      return -1;
    }
    if (paramLong >= this.gNc)
    {
      y.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d resLength:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.gNc) });
      return -1;
    }
    int i = paramInt2;
    if (paramInt2 + paramLong >= this.gNc)
    {
      y.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, size:%d, resLength:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(this.gNc) });
      i = (int)(this.gNc - paramLong);
    }
    paramInt1 = this.randomAccessFile.read(paramArrayOfByte, paramInt1, i);
    if (paramInt1 >= 0)
    {
      this.currentPosition += paramInt1;
      return paramInt1;
    }
    y.e("MicroMsg.WxaAudioDataSourceBelow19", "read:%d err", new Object[] { Integer.valueOf(paramInt1) });
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.e
 * JD-Core Version:    0.7.0.1
 */