package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class e
  implements com.tencent.mm.ai.e
{
  private static af<String, Integer> lrD;
  private static af<String, Integer> lrE;
  private static af<String, Integer> lrF;
  private long currentPosition;
  private String filePath;
  private int jlY;
  private int lrG;
  private String pkgPath;
  public RandomAccessFile randomAccessFile;
  
  static
  {
    AppMethodBeat.i(145799);
    lrD = new af(50);
    lrE = new af(50);
    lrF = new af(50);
    AppMethodBeat.o(145799);
  }
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145792);
    this.lrG = -1;
    this.jlY = -1;
    this.filePath = paramString1;
    this.pkgPath = paramString2;
    this.randomAccessFile = dP(paramString1, paramString2);
    if ((lrD.aK(paramString1)) && (lrE.aK(paramString1)))
    {
      this.lrG = ((Integer)lrD.get(paramString1)).intValue();
      this.jlY = ((Integer)lrE.get(paramString1)).intValue();
      AppMethodBeat.o(145792);
      return;
    }
    if (bs.isNullOrNil(paramString2))
    {
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
      AppMethodBeat.o(145792);
      return;
    }
    paramString2 = new WxaPkg(paramString2);
    if (!paramString2.jlz)
    {
      paramString2.close();
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg invalid");
      AppMethodBeat.o(145792);
      return;
    }
    if (!paramString2.aVW())
    {
      paramString2.close();
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg readInfo failed");
      AppMethodBeat.o(145792);
      return;
    }
    WxaPkg.Info localInfo = paramString2.openReadPartialInfo(paramString1);
    if (localInfo == null)
    {
      paramString2.close();
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "info is null, err");
      AppMethodBeat.o(145792);
      return;
    }
    if ((localInfo.jlZ <= 0) || (localInfo.jlY <= 0))
    {
      paramString2.close();
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "info.resLength or info.fileOffset, err");
      AppMethodBeat.o(145792);
      return;
    }
    this.lrG = localInfo.jlZ;
    this.jlY = localInfo.jlY;
    lrD.put(paramString1, Integer.valueOf(this.lrG));
    lrE.put(paramString1, Integer.valueOf(this.jlY));
    paramString2.close();
    AppMethodBeat.o(145792);
  }
  
  private RandomAccessFile dP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145794);
    if (bs.isNullOrNil(paramString2))
    {
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
      AppMethodBeat.o(145794);
      return null;
    }
    ac.i("MicroMsg.WxaAudioDataSourceBelow19", "filePath:%s, resLength:%d, fileOffset:%d", new Object[] { paramString1, Integer.valueOf(this.lrG), Integer.valueOf(this.jlY) });
    try
    {
      if (!new com.tencent.mm.vfs.e(paramString2).exists())
      {
        ac.e("MicroMsg.WxaAudioDataSourceBelow19", "file pkgPath:%s isn't exist ", new Object[] { paramString2 });
        AppMethodBeat.o(145794);
        return null;
      }
      paramString2 = i.cY(paramString2, false);
      ac.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", paramString1, "", new Object[0]);
    }
    catch (FileNotFoundException paramString1)
    {
      try
      {
        ac.d("MicroMsg.WxaAudioDataSourceBelow19", "randomAccessFile.length:%d", new Object[] { Long.valueOf(paramString2.length()) });
        AppMethodBeat.o(145794);
        return paramString2;
      }
      catch (IOException paramString1)
      {
        break label154;
      }
      paramString1 = paramString1;
      ac.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", paramString1, "", new Object[0]);
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
  
  public final int aBg()
  {
    AppMethodBeat.i(145797);
    if (this.randomAccessFile == null) {
      this.randomAccessFile = dP(this.filePath, this.pkgPath);
    }
    if (lrF.aK(this.filePath))
    {
      int i = ((Integer)lrF.get(this.filePath)).intValue();
      AppMethodBeat.o(145797);
      return i;
    }
    if (this.randomAccessFile == null)
    {
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] inputStream is null");
      AppMethodBeat.o(145797);
      return 0;
    }
    if (this.filePath.toLowerCase().endsWith(".mp3"))
    {
      ac.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] mp3");
      AppMethodBeat.o(145797);
      return 2;
    }
    if (this.filePath.toLowerCase().contains(".wav"))
    {
      ac.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] wav");
      AppMethodBeat.o(145797);
      return 3;
    }
    if (this.filePath.toLowerCase().contains(".ogg"))
    {
      ac.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] ogg");
      AppMethodBeat.o(145797);
      return 4;
    }
    try
    {
      localObject1 = new byte[64];
      this.randomAccessFile.seek(this.jlY);
      this.randomAccessFile.read((byte[])localObject1);
      localObject1 = new String((byte[])localObject1);
      this.randomAccessFile.seek(this.jlY);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        ac.e("MicroMsg.WxaAudioDataSourceBelow19", "getAudioType", new Object[] { localException });
        this.randomAccessFile.seek(this.jlY);
        Object localObject2 = null;
      }
    }
    finally
    {
      this.randomAccessFile.seek(this.jlY);
      AppMethodBeat.o(145797);
    }
    if ((localObject1 != null) && (((String)localObject1).contains("ftyp")))
    {
      ac.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] aac");
      lrF.put(this.filePath, Integer.valueOf(1));
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
      ac.i("MicroMsg.WxaAudioDataSourceBelow19", "close %d", new Object[] { Integer.valueOf(hashCode()) });
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
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "[getSize] randomAccessFile is null");
      AppMethodBeat.o(145796);
      return 0L;
    }
    long l = this.lrG;
    AppMethodBeat.o(145796);
    return l;
  }
  
  public final boolean isOpen()
  {
    return (this.randomAccessFile != null) || (this.lrG == -1) || (this.jlY == -1);
  }
  
  public final void open()
  {
    AppMethodBeat.i(145793);
    ac.i("MicroMsg.WxaAudioDataSourceBelow19", "open %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.randomAccessFile == null) {
      this.randomAccessFile = dP(this.filePath, this.pkgPath);
    }
    this.currentPosition = 0L;
    if (this.randomAccessFile != null) {
      this.randomAccessFile.seek(this.jlY);
    }
    AppMethodBeat.o(145793);
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145795);
    if (this.randomAccessFile == null)
    {
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]randomAccessFile is null");
      AppMethodBeat.o(145795);
      return -1;
    }
    if (this.currentPosition != paramLong)
    {
      this.randomAccessFile.seek(this.jlY + paramLong);
      this.currentPosition = paramLong;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]bytes is null");
      AppMethodBeat.o(145795);
      return -1;
    }
    if ((paramLong < 0L) || (paramInt1 < 0) || (paramInt2 <= 0))
    {
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, offset:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(145795);
      return -1;
    }
    if ((paramArrayOfByte != null) && (paramInt1 + paramInt2 > paramArrayOfByte.length))
    {
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "offset:%d, size:%d, bytes.length:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(145795);
      return -1;
    }
    if (paramLong >= this.lrG)
    {
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d resLength:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.lrG) });
      AppMethodBeat.o(145795);
      return -1;
    }
    int i = paramInt2;
    if (paramInt2 + paramLong >= this.lrG)
    {
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, size:%d, resLength:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(this.lrG) });
      i = (int)(this.lrG - paramLong);
    }
    paramInt1 = this.randomAccessFile.read(paramArrayOfByte, paramInt1, i);
    if (paramInt1 >= 0) {
      this.currentPosition += paramInt1;
    }
    for (;;)
    {
      AppMethodBeat.o(145795);
      return paramInt1;
      ac.e("MicroMsg.WxaAudioDataSourceBelow19", "read:%d err", new Object[] { Integer.valueOf(paramInt1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.e
 * JD-Core Version:    0.7.0.1
 */