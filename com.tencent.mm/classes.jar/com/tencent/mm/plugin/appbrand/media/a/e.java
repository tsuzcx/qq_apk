package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class e
  implements com.tencent.mm.al.e
{
  private static LruCache<String, Integer> thT;
  private static LruCache<String, Integer> thU;
  private static LruCache<String, Integer> thV;
  private long currentPosition;
  private String filePath;
  private String pkgPath;
  private int qEv;
  public RandomAccessFile randomAccessFile;
  private int thW;
  
  static
  {
    AppMethodBeat.i(145799);
    thT = new LruCache(50);
    thU = new LruCache(50);
    thV = new LruCache(50);
    AppMethodBeat.o(145799);
  }
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145792);
    this.thW = -1;
    this.qEv = -1;
    this.filePath = paramString1;
    this.pkgPath = paramString2;
    this.randomAccessFile = eW(paramString1, paramString2);
    if ((thT.check(paramString1)) && (thU.check(paramString1)))
    {
      this.thW = ((Integer)thT.get(paramString1)).intValue();
      this.qEv = ((Integer)thU.get(paramString1)).intValue();
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
    if (!paramString2.qDW)
    {
      paramString2.close();
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg invalid");
      AppMethodBeat.o(145792);
      return;
    }
    if (!paramString2.cfK())
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
    if ((localInfo.qEw <= 0) || (localInfo.qEv <= 0))
    {
      paramString2.close();
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "info.resLength or info.fileOffset, err");
      AppMethodBeat.o(145792);
      return;
    }
    this.thW = localInfo.qEw;
    this.qEv = localInfo.qEv;
    thT.put(paramString1, Integer.valueOf(this.thW));
    thU.put(paramString1, Integer.valueOf(this.qEv));
    paramString2.close();
    AppMethodBeat.o(145792);
  }
  
  private RandomAccessFile eW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145794);
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
      AppMethodBeat.o(145794);
      return null;
    }
    Log.i("MicroMsg.WxaAudioDataSourceBelow19", "filePath:%s, resLength:%d, fileOffset:%d", new Object[] { paramString1, Integer.valueOf(this.thW), Integer.valueOf(this.qEv) });
    try
    {
      if (!new u(paramString2).jKS())
      {
        Log.e("MicroMsg.WxaAudioDataSourceBelow19", "file pkgPath:%s isn't exist ", new Object[] { paramString2 });
        AppMethodBeat.o(145794);
        return null;
      }
      paramString2 = y.eA(paramString2, false);
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
  
  public final int bFo()
  {
    AppMethodBeat.i(145797);
    if (this.randomAccessFile == null) {
      this.randomAccessFile = eW(this.filePath, this.pkgPath);
    }
    if (thV.check(this.filePath))
    {
      int i = ((Integer)thV.get(this.filePath)).intValue();
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
      this.randomAccessFile.seek(this.qEv);
      this.randomAccessFile.read((byte[])localObject1);
      localObject1 = new String((byte[])localObject1);
      this.randomAccessFile.seek(this.qEv);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Log.e("MicroMsg.WxaAudioDataSourceBelow19", "getAudioType", new Object[] { localException });
        this.randomAccessFile.seek(this.qEv);
        Object localObject2 = null;
      }
    }
    finally
    {
      this.randomAccessFile.seek(this.qEv);
      AppMethodBeat.o(145797);
    }
    if ((localObject1 != null) && (((String)localObject1).contains("ftyp")))
    {
      Log.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] aac");
      thV.put(this.filePath, Integer.valueOf(1));
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
    long l = this.thW;
    AppMethodBeat.o(145796);
    return l;
  }
  
  public final boolean isOpen()
  {
    return (this.randomAccessFile != null) || (this.thW == -1) || (this.qEv == -1);
  }
  
  public final void open()
  {
    AppMethodBeat.i(145793);
    Log.i("MicroMsg.WxaAudioDataSourceBelow19", "open %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.randomAccessFile == null) {
      this.randomAccessFile = eW(this.filePath, this.pkgPath);
    }
    this.currentPosition = 0L;
    if (this.randomAccessFile != null) {
      this.randomAccessFile.seek(this.qEv);
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
      this.randomAccessFile.seek(this.qEv + paramLong);
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
    if (paramLong >= this.thW)
    {
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d resLength:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.thW) });
      AppMethodBeat.o(145795);
      return -1;
    }
    int i = paramInt2;
    if (paramInt2 + paramLong >= this.thW)
    {
      Log.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, size:%d, resLength:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(this.thW) });
      i = (int)(this.thW - paramLong);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.e
 * JD-Core Version:    0.7.0.1
 */