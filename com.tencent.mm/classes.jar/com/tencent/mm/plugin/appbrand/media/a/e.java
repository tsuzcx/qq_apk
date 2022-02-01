package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class e
  implements com.tencent.mm.ai.e
{
  private static LruCache<String, Integer> ncQ;
  private static LruCache<String, Integer> ncR;
  private static LruCache<String, Integer> ncS;
  private long currentPosition;
  private String filePath;
  private int kKJ;
  private int ncT;
  private String pkgPath;
  public RandomAccessFile randomAccessFile;
  
  static
  {
    AppMethodBeat.i(145799);
    ncQ = new LruCache(50);
    ncR = new LruCache(50);
    ncS = new LruCache(50);
    AppMethodBeat.o(145799);
  }
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145792);
    this.ncT = -1;
    this.kKJ = -1;
    this.filePath = paramString1;
    this.pkgPath = paramString2;
    this.randomAccessFile = er(paramString1, paramString2);
    if ((ncQ.check(paramString1)) && (ncR.check(paramString1)))
    {
      this.ncT = ((Integer)ncQ.get(paramString1)).intValue();
      this.kKJ = ((Integer)ncR.get(paramString1)).intValue();
      AppMethodBeat.o(145792);
      return;
    }
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
      AppMethodBeat.o(145792);
      return;
    }
    paramString2 = new WxaPkg(paramString2);
    if (!paramString2.kKk)
    {
      paramString2.close();
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg invalid");
      AppMethodBeat.o(145792);
      return;
    }
    if (!paramString2.bvf())
    {
      paramString2.close();
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg readInfo failed");
      AppMethodBeat.o(145792);
      return;
    }
    WxaPkg.Info localInfo = paramString2.openReadPartialInfo(paramString1);
    if (localInfo == null)
    {
      paramString2.close();
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "info is null, err");
      AppMethodBeat.o(145792);
      return;
    }
    if ((localInfo.kKK <= 0) || (localInfo.kKJ <= 0))
    {
      paramString2.close();
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "info.resLength or info.fileOffset, err");
      AppMethodBeat.o(145792);
      return;
    }
    this.ncT = localInfo.kKK;
    this.kKJ = localInfo.kKJ;
    ncQ.put(paramString1, Integer.valueOf(this.ncT));
    ncR.put(paramString1, Integer.valueOf(this.kKJ));
    paramString2.close();
    AppMethodBeat.o(145792);
  }
  
  private RandomAccessFile er(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145794);
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
      AppMethodBeat.o(145794);
      return null;
    }
    Log.i("MicroMsg.WxaAudioDataSourceBelow19", "filePath:%s, resLength:%d, fileOffset:%d", new Object[] { paramString1, Integer.valueOf(this.ncT), Integer.valueOf(this.kKJ) });
    try
    {
      if (!new o(paramString2).exists())
      {
        Log.e("MicroMsg.WxaAudioDataSourceBelow19", "file pkgPath:%s isn't exist ", new Object[] { paramString2 });
        AppMethodBeat.o(145794);
        return null;
      }
      paramString2 = s.dB(paramString2, false);
      Log.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", paramString1, "", new Object[0]);
    }
    catch (FileNotFoundException paramString1)
    {
      try
      {
        Log.d("MicroMsg.WxaAudioDataSourceBelow19", "randomAccessFile.length:%d", new Object[] { Long.valueOf(paramString2.length()) });
        AppMethodBeat.o(145794);
        return paramString2;
      }
      catch (IOException paramString1)
      {
        break label154;
      }
      paramString1 = paramString1;
      Log.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", paramString1, "", new Object[0]);
      AppMethodBeat.o(145794);
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
      AppMethodBeat.o(145794);
      return null;
    }
    catch (IOException paramString1)
    {
      break label174;
    }
  }
  
  public final int aYm()
  {
    AppMethodBeat.i(145797);
    if (this.randomAccessFile == null) {
      this.randomAccessFile = er(this.filePath, this.pkgPath);
    }
    if (ncS.check(this.filePath))
    {
      int i = ((Integer)ncS.get(this.filePath)).intValue();
      AppMethodBeat.o(145797);
      return i;
    }
    if (this.randomAccessFile == null)
    {
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] inputStream is null");
      AppMethodBeat.o(145797);
      return 0;
    }
    if (this.filePath.toLowerCase().endsWith(".mp3"))
    {
      Log.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] mp3");
      AppMethodBeat.o(145797);
      return 2;
    }
    if (this.filePath.toLowerCase().contains(".wav"))
    {
      Log.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] wav");
      AppMethodBeat.o(145797);
      return 3;
    }
    if (this.filePath.toLowerCase().contains(".ogg"))
    {
      Log.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] ogg");
      AppMethodBeat.o(145797);
      return 4;
    }
    try
    {
      localObject1 = new byte[64];
      this.randomAccessFile.seek(this.kKJ);
      this.randomAccessFile.read((byte[])localObject1);
      localObject1 = new String((byte[])localObject1);
      this.randomAccessFile.seek(this.kKJ);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Log.e("MicroMsg.WxaAudioDataSourceBelow19", "getAudioType", new Object[] { localException });
        this.randomAccessFile.seek(this.kKJ);
        Object localObject2 = null;
      }
    }
    finally
    {
      this.randomAccessFile.seek(this.kKJ);
      AppMethodBeat.o(145797);
    }
    if ((localObject1 != null) && (((String)localObject1).contains("ftyp")))
    {
      Log.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] aac");
      ncS.put(this.filePath, Integer.valueOf(1));
      AppMethodBeat.o(145797);
      return 1;
    }
    AppMethodBeat.o(145797);
    return 0;
  }
  
  public final void close()
  {
    AppMethodBeat.i(145798);
    if (this.randomAccessFile != null)
    {
      Log.i("MicroMsg.WxaAudioDataSourceBelow19", "close %d", new Object[] { Integer.valueOf(hashCode()) });
      this.randomAccessFile.close();
      this.randomAccessFile = null;
    }
    AppMethodBeat.o(145798);
  }
  
  public final long getSize()
  {
    AppMethodBeat.i(145796);
    if (this.randomAccessFile == null)
    {
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "[getSize] randomAccessFile is null");
      AppMethodBeat.o(145796);
      return 0L;
    }
    long l = this.ncT;
    AppMethodBeat.o(145796);
    return l;
  }
  
  public final boolean isOpen()
  {
    return (this.randomAccessFile != null) || (this.ncT == -1) || (this.kKJ == -1);
  }
  
  public final void open()
  {
    AppMethodBeat.i(145793);
    Log.i("MicroMsg.WxaAudioDataSourceBelow19", "open %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.randomAccessFile == null) {
      this.randomAccessFile = er(this.filePath, this.pkgPath);
    }
    this.currentPosition = 0L;
    if (this.randomAccessFile != null) {
      this.randomAccessFile.seek(this.kKJ);
    }
    AppMethodBeat.o(145793);
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145795);
    if (this.randomAccessFile == null)
    {
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]randomAccessFile is null");
      AppMethodBeat.o(145795);
      return -1;
    }
    if (this.currentPosition != paramLong)
    {
      this.randomAccessFile.seek(this.kKJ + paramLong);
      this.currentPosition = paramLong;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]bytes is null");
      AppMethodBeat.o(145795);
      return -1;
    }
    if ((paramLong < 0L) || (paramInt1 < 0) || (paramInt2 <= 0))
    {
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, offset:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(145795);
      return -1;
    }
    if ((paramArrayOfByte != null) && (paramInt1 + paramInt2 > paramArrayOfByte.length))
    {
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "offset:%d, size:%d, bytes.length:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(145795);
      return -1;
    }
    if (paramLong >= this.ncT)
    {
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d resLength:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.ncT) });
      AppMethodBeat.o(145795);
      return -1;
    }
    int i = paramInt2;
    if (paramInt2 + paramLong >= this.ncT)
    {
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, size:%d, resLength:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(this.ncT) });
      i = (int)(this.ncT - paramLong);
    }
    paramInt1 = this.randomAccessFile.read(paramArrayOfByte, paramInt1, i);
    if (paramInt1 >= 0) {
      this.currentPosition += paramInt1;
    }
    for (;;)
    {
      AppMethodBeat.o(145795);
      return paramInt1;
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "read:%d err", new Object[] { Integer.valueOf(paramInt1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.e
 * JD-Core Version:    0.7.0.1
 */