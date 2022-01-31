package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.ao.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class e
  implements com.tencent.mm.ag.e
{
  private static ae<String, Integer> ioT;
  private static ae<String, Integer> ioU;
  private static ae<String, Integer> ioV;
  private long currentPosition;
  private String filePath;
  private String gUy;
  private int gVV;
  private int ioW;
  public RandomAccessFile randomAccessFile;
  
  static
  {
    AppMethodBeat.i(137819);
    ioT = new ae(50);
    ioU = new ae(50);
    ioV = new ae(50);
    AppMethodBeat.o(137819);
  }
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137812);
    this.ioW = -1;
    this.gVV = -1;
    this.filePath = paramString1;
    this.gUy = paramString2;
    this.randomAccessFile = cF(paramString1, paramString2);
    if ((ioT.Z(paramString1)) && (ioU.Z(paramString1)))
    {
      this.ioW = ((Integer)ioT.get(paramString1)).intValue();
      this.gVV = ((Integer)ioU.get(paramString1)).intValue();
      AppMethodBeat.o(137812);
      return;
    }
    if (bo.isNullOrNil(paramString2))
    {
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
      AppMethodBeat.o(137812);
      return;
    }
    paramString2 = new ao(paramString2);
    if (!paramString2.gVO)
    {
      paramString2.close();
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg invalid");
      AppMethodBeat.o(137812);
      return;
    }
    if (!paramString2.avO())
    {
      paramString2.close();
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg readInfo failed");
      AppMethodBeat.o(137812);
      return;
    }
    ao.a locala = paramString2.yv(paramString1);
    if (locala == null)
    {
      paramString2.close();
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "info is null, err");
      AppMethodBeat.o(137812);
      return;
    }
    if ((locala.gVW <= 0) || (locala.gVV <= 0))
    {
      paramString2.close();
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "info.resLength or info.fileOffset, err");
      AppMethodBeat.o(137812);
      return;
    }
    this.ioW = locala.gVW;
    this.gVV = locala.gVV;
    ioT.put(paramString1, Integer.valueOf(this.ioW));
    ioU.put(paramString1, Integer.valueOf(this.gVV));
    paramString2.close();
    AppMethodBeat.o(137812);
  }
  
  private RandomAccessFile cF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137814);
    if (bo.isNullOrNil(paramString2))
    {
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
      AppMethodBeat.o(137814);
      return null;
    }
    ab.i("MicroMsg.WxaAudioDataSourceBelow19", "filePath:%s, resLength:%d, fileOffset:%d", new Object[] { paramString1, Integer.valueOf(this.ioW), Integer.valueOf(this.gVV) });
    try
    {
      if (!new b(paramString2).exists())
      {
        ab.e("MicroMsg.WxaAudioDataSourceBelow19", "file pkgPath:%s isn't exist ", new Object[] { paramString2 });
        AppMethodBeat.o(137814);
        return null;
      }
      paramString2 = com.tencent.mm.vfs.e.cr(paramString2, false);
      ab.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", paramString1, "", new Object[0]);
    }
    catch (FileNotFoundException paramString1)
    {
      try
      {
        ab.d("MicroMsg.WxaAudioDataSourceBelow19", "randomAccessFile.length:%d", new Object[] { Long.valueOf(paramString2.length()) });
        AppMethodBeat.o(137814);
        return paramString2;
      }
      catch (IOException paramString1)
      {
        break label154;
      }
      paramString1 = paramString1;
      ab.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", paramString1, "", new Object[0]);
      AppMethodBeat.o(137814);
      return null;
    }
    catch (IOException paramString1)
    {
      paramString2 = null;
    }
    label154:
    if (paramString2 != null) {}
    try
    {
      paramString2.close();
      label174:
      AppMethodBeat.o(137814);
      return null;
    }
    catch (IOException paramString1)
    {
      break label174;
    }
  }
  
  public final int acP()
  {
    AppMethodBeat.i(137817);
    if (this.randomAccessFile == null) {
      this.randomAccessFile = cF(this.filePath, this.gUy);
    }
    if (ioV.Z(this.filePath))
    {
      int i = ((Integer)ioV.get(this.filePath)).intValue();
      AppMethodBeat.o(137817);
      return i;
    }
    if (this.randomAccessFile == null)
    {
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] inputStream is null");
      AppMethodBeat.o(137817);
      return 0;
    }
    if (this.filePath.toLowerCase().endsWith(".mp3"))
    {
      ab.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] mp3");
      AppMethodBeat.o(137817);
      return 2;
    }
    if (this.filePath.toLowerCase().contains(".wav"))
    {
      ab.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] wav");
      AppMethodBeat.o(137817);
      return 3;
    }
    if (this.filePath.toLowerCase().contains(".ogg"))
    {
      ab.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] ogg");
      AppMethodBeat.o(137817);
      return 4;
    }
    try
    {
      localObject1 = new byte[64];
      this.randomAccessFile.seek(this.gVV);
      this.randomAccessFile.read((byte[])localObject1);
      localObject1 = new String((byte[])localObject1);
      this.randomAccessFile.seek(this.gVV);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        ab.e("MicroMsg.WxaAudioDataSourceBelow19", "getAudioType", new Object[] { localException });
        this.randomAccessFile.seek(this.gVV);
        Object localObject2 = null;
      }
    }
    finally
    {
      this.randomAccessFile.seek(this.gVV);
      AppMethodBeat.o(137817);
    }
    if ((localObject1 != null) && (((String)localObject1).contains("ftyp")))
    {
      ab.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] aac");
      ioV.put(this.filePath, Integer.valueOf(1));
      AppMethodBeat.o(137817);
      return 1;
    }
    AppMethodBeat.o(137817);
    return 0;
  }
  
  public final void close()
  {
    AppMethodBeat.i(137818);
    if (this.randomAccessFile != null)
    {
      ab.i("MicroMsg.WxaAudioDataSourceBelow19", "close %d", new Object[] { Integer.valueOf(hashCode()) });
      this.randomAccessFile.close();
      this.randomAccessFile = null;
    }
    AppMethodBeat.o(137818);
  }
  
  public final long getSize()
  {
    AppMethodBeat.i(137816);
    if (this.randomAccessFile == null)
    {
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "[getSize] randomAccessFile is null");
      AppMethodBeat.o(137816);
      return 0L;
    }
    long l = this.ioW;
    AppMethodBeat.o(137816);
    return l;
  }
  
  public final boolean isOpen()
  {
    return (this.randomAccessFile != null) || (this.ioW == -1) || (this.gVV == -1);
  }
  
  public final void open()
  {
    AppMethodBeat.i(137813);
    ab.i("MicroMsg.WxaAudioDataSourceBelow19", "open %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.randomAccessFile == null) {
      this.randomAccessFile = cF(this.filePath, this.gUy);
    }
    this.currentPosition = 0L;
    if (this.randomAccessFile != null) {
      this.randomAccessFile.seek(this.gVV);
    }
    AppMethodBeat.o(137813);
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137815);
    if (this.randomAccessFile == null)
    {
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]randomAccessFile is null");
      AppMethodBeat.o(137815);
      return -1;
    }
    if (this.currentPosition != paramLong)
    {
      this.randomAccessFile.seek(this.gVV + paramLong);
      this.currentPosition = paramLong;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]bytes is null");
      AppMethodBeat.o(137815);
      return -1;
    }
    if ((paramLong < 0L) || (paramInt1 < 0) || (paramInt2 <= 0))
    {
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, offset:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(137815);
      return -1;
    }
    if ((paramArrayOfByte != null) && (paramInt1 + paramInt2 > paramArrayOfByte.length))
    {
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "offset:%d, size:%d, bytes.length:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(137815);
      return -1;
    }
    if (paramLong >= this.ioW)
    {
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d resLength:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.ioW) });
      AppMethodBeat.o(137815);
      return -1;
    }
    int i = paramInt2;
    if (paramInt2 + paramLong >= this.ioW)
    {
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, size:%d, resLength:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(this.ioW) });
      i = (int)(this.ioW - paramLong);
    }
    paramInt1 = this.randomAccessFile.read(paramArrayOfByte, paramInt1, i);
    if (paramInt1 >= 0) {
      this.currentPosition += paramInt1;
    }
    for (;;)
    {
      AppMethodBeat.o(137815);
      return paramInt1;
      ab.e("MicroMsg.WxaAudioDataSourceBelow19", "read:%d err", new Object[] { Integer.valueOf(paramInt1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.e
 * JD-Core Version:    0.7.0.1
 */