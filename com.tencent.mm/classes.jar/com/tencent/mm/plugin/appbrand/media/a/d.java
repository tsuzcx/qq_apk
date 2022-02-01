package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.luggage.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.io.InputStream;

public final class d
  implements e
{
  private long currentPosition;
  private String filePath;
  private String pkgPath;
  public a qde;
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145785);
    this.qde = null;
    this.filePath = paramString1;
    this.pkgPath = paramString2;
    this.qde = eE(paramString1, paramString2);
    AppMethodBeat.o(145785);
  }
  
  private static a eE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145787);
    long l = System.nanoTime();
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.WxaAudioDataSource", "pkgpath is null, return");
      AppMethodBeat.o(145787);
      return null;
    }
    paramString2 = new WxaPkg(new q(paramString2));
    if (!paramString2.nEb)
    {
      paramString2.close();
      Log.e("MicroMsg.WxaAudioDataSource", "pkg invalid");
      AppMethodBeat.o(145787);
      return null;
    }
    if (!paramString2.bGl())
    {
      paramString2.close();
      Log.e("MicroMsg.WxaAudioDataSource", "pkg readInfo failed");
      AppMethodBeat.o(145787);
      return null;
    }
    InputStream localInputStream = paramString2.acB(paramString1);
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
  
  public final int bhy()
  {
    AppMethodBeat.i(145790);
    if (this.qde == null) {
      this.qde = eE(this.filePath, this.pkgPath);
    }
    if (this.qde == null)
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
      this.qde.seek(0);
      this.qde.read((byte[])localObject1);
      localObject1 = new String((byte[])localObject1);
      this.qde.seek(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Log.e("MicroMsg.WxaAudioDataSource", "getAudioType", new Object[] { localException });
        this.qde.seek(0);
        Object localObject2 = null;
      }
    }
    finally
    {
      this.qde.seek(0);
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
    a locala = this.qde;
    if (locala != null)
    {
      Log.i("MicroMsg.WxaAudioDataSource", "close");
      locala.close();
      this.qde = null;
    }
    AppMethodBeat.o(145791);
  }
  
  public final long getSize()
  {
    AppMethodBeat.i(145789);
    if (this.qde == null)
    {
      Log.e("MicroMsg.WxaAudioDataSource", "[getSize] inputStream is null");
      AppMethodBeat.o(145789);
      return 0L;
    }
    long l = this.qde.sr();
    AppMethodBeat.o(145789);
    return l;
  }
  
  public final boolean isOpen()
  {
    return this.qde != null;
  }
  
  public final void open()
  {
    AppMethodBeat.i(145786);
    Log.i("MicroMsg.WxaAudioDataSource", "open");
    if (this.qde == null) {
      this.qde = eE(this.filePath, this.pkgPath);
    }
    this.currentPosition = 0L;
    if (this.qde != null) {
      this.qde.seek(0);
    }
    AppMethodBeat.o(145786);
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145788);
    if (this.qde == null)
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
      this.qde.seek((int)paramLong);
      this.currentPosition = paramLong;
    }
    paramInt1 = this.qde.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      this.currentPosition += paramInt1;
    }
    AppMethodBeat.o(145788);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.d
 * JD-Core Version:    0.7.0.1
 */