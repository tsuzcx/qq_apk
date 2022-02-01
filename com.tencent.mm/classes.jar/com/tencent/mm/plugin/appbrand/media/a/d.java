package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.InputStream;

public final class d
  implements e
{
  private long currentPosition;
  private String filePath;
  public a ncP;
  private String pkgPath;
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145785);
    this.ncP = null;
    this.filePath = paramString1;
    this.pkgPath = paramString2;
    this.ncP = eq(paramString1, paramString2);
    AppMethodBeat.o(145785);
  }
  
  private static a eq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145787);
    long l = System.nanoTime();
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.WxaAudioDataSource", "pkgpath is null, return");
      AppMethodBeat.o(145787);
      return null;
    }
    paramString2 = new WxaPkg(new o(paramString2));
    if (!paramString2.kKk)
    {
      paramString2.close();
      Log.e("MicroMsg.WxaAudioDataSource", "pkg invalid");
      AppMethodBeat.o(145787);
      return null;
    }
    if (!paramString2.bvf())
    {
      paramString2.close();
      Log.e("MicroMsg.WxaAudioDataSource", "pkg readInfo failed");
      AppMethodBeat.o(145787);
      return null;
    }
    InputStream localInputStream = paramString2.UR(paramString1);
    if (localInputStream == null)
    {
      paramString2.close();
      Log.e("MicroMsg.WxaAudioDataSource", "inputstream for %s is null", new Object[] { paramString1 });
      AppMethodBeat.o(145787);
      return null;
    }
    paramString2.close();
    Log.d("MicroMsg.WxaAudioDataSource", "time:%d", new Object[] { Long.valueOf(System.nanoTime() - l) });
    paramString1 = (a)localInputStream;
    AppMethodBeat.o(145787);
    return paramString1;
  }
  
  public final int aYm()
  {
    AppMethodBeat.i(145790);
    if (this.ncP == null) {
      this.ncP = eq(this.filePath, this.pkgPath);
    }
    if (this.ncP == null)
    {
      Log.e("MicroMsg.WxaAudioDataSource", "[getAudioType] inputStream is null");
      AppMethodBeat.o(145790);
      return 0;
    }
    if (this.filePath.toLowerCase().endsWith(".mp3"))
    {
      Log.d("MicroMsg.WxaAudioDataSource", "[getAudioType] mp3");
      AppMethodBeat.o(145790);
      return 2;
    }
    if (this.filePath.toLowerCase().contains(".wav"))
    {
      Log.d("MicroMsg.WxaAudioDataSource", "[getAudioType] wav");
      AppMethodBeat.o(145790);
      return 3;
    }
    if (this.filePath.toLowerCase().contains(".ogg"))
    {
      Log.d("MicroMsg.WxaAudioDataSource", "[getAudioType] ogg");
      AppMethodBeat.o(145790);
      return 4;
    }
    try
    {
      localObject1 = new byte[64];
      this.ncP.seek(0);
      this.ncP.read((byte[])localObject1);
      localObject1 = new String((byte[])localObject1);
      this.ncP.seek(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Log.e("MicroMsg.WxaAudioDataSource", "getAudioType", new Object[] { localException });
        this.ncP.seek(0);
        Object localObject2 = null;
      }
    }
    finally
    {
      this.ncP.seek(0);
      AppMethodBeat.o(145790);
    }
    if ((localObject1 != null) && (((String)localObject1).contains("ftyp")))
    {
      Log.d("MicroMsg.WxaAudioDataSource", "[getAudioType] aac");
      AppMethodBeat.o(145790);
      return 1;
    }
    AppMethodBeat.o(145790);
    return 0;
  }
  
  public final void close()
  {
    AppMethodBeat.i(145791);
    a locala = this.ncP;
    if (locala != null)
    {
      Log.i("MicroMsg.WxaAudioDataSource", "close");
      locala.close();
      this.ncP = null;
    }
    AppMethodBeat.o(145791);
  }
  
  public final long getSize()
  {
    AppMethodBeat.i(145789);
    if (this.ncP == null)
    {
      Log.e("MicroMsg.WxaAudioDataSource", "[getSize] inputStream is null");
      AppMethodBeat.o(145789);
      return 0L;
    }
    long l = this.ncP.getLength();
    AppMethodBeat.o(145789);
    return l;
  }
  
  public final boolean isOpen()
  {
    return this.ncP != null;
  }
  
  public final void open()
  {
    AppMethodBeat.i(145786);
    Log.i("MicroMsg.WxaAudioDataSource", "open");
    if (this.ncP == null) {
      this.ncP = eq(this.filePath, this.pkgPath);
    }
    this.currentPosition = 0L;
    if (this.ncP != null) {
      this.ncP.seek(0);
    }
    AppMethodBeat.o(145786);
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145788);
    if (this.ncP == null)
    {
      Log.e("MicroMsg.WxaAudioDataSource", "[readAt]inputstream is null");
      AppMethodBeat.o(145788);
      return -1;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      Log.e("MicroMsg.WxaAudioDataSource", "[readAt]bytes is null");
      AppMethodBeat.o(145788);
      return -1;
    }
    if ((paramLong < 0L) || (paramInt1 < 0) || (paramInt2 <= 0))
    {
      Log.e("MicroMsg.WxaAudioDataSource", "position:%d, offset:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(145788);
      return -1;
    }
    if ((paramArrayOfByte != null) && (paramInt1 + paramInt2 > paramArrayOfByte.length))
    {
      Log.e("MicroMsg.WxaAudioDataSource", "offset:%d, size:%d, bytes.length:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(145788);
      return -1;
    }
    if (paramInt2 + paramLong > getSize()) {
      Log.e("MicroMsg.WxaAudioDataSource", "position:%d, size:%d, getSize():%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Long.valueOf(getSize()) });
    }
    if (this.currentPosition != paramLong)
    {
      this.ncP.seek((int)paramLong);
      this.currentPosition = paramLong;
    }
    paramInt1 = this.ncP.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      this.currentPosition += paramInt1;
    }
    AppMethodBeat.o(145788);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.d
 * JD-Core Version:    0.7.0.1
 */