package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.luggage.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.InputStream;

public final class d
  implements e
{
  private long currentPosition;
  private String filePath;
  private String gUy;
  public a ioS;
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137805);
    this.ioS = null;
    this.filePath = paramString1;
    this.gUy = paramString2;
    this.ioS = cE(paramString1, paramString2);
    AppMethodBeat.o(137805);
  }
  
  private static a cE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137807);
    long l = System.nanoTime();
    if (bo.isNullOrNil(paramString2))
    {
      ab.e("MicroMsg.WxaAudioDataSource", "pkgpath is null, return");
      AppMethodBeat.o(137807);
      return null;
    }
    paramString2 = new ao(new File(paramString2));
    if (!paramString2.gVO)
    {
      paramString2.close();
      ab.e("MicroMsg.WxaAudioDataSource", "pkg invalid");
      AppMethodBeat.o(137807);
      return null;
    }
    if (!paramString2.avO())
    {
      paramString2.close();
      ab.e("MicroMsg.WxaAudioDataSource", "pkg readInfo failed");
      AppMethodBeat.o(137807);
      return null;
    }
    InputStream localInputStream = paramString2.yw(paramString1);
    if (localInputStream == null)
    {
      paramString2.close();
      ab.e("MicroMsg.WxaAudioDataSource", "inputstream for %s is null", new Object[] { paramString1 });
      AppMethodBeat.o(137807);
      return null;
    }
    paramString2.close();
    ab.d("MicroMsg.WxaAudioDataSource", "time:%d", new Object[] { Long.valueOf(System.nanoTime() - l) });
    paramString1 = (a)localInputStream;
    AppMethodBeat.o(137807);
    return paramString1;
  }
  
  public final int acP()
  {
    AppMethodBeat.i(137810);
    if (this.ioS == null) {
      this.ioS = cE(this.filePath, this.gUy);
    }
    if (this.ioS == null)
    {
      ab.e("MicroMsg.WxaAudioDataSource", "[getAudioType] inputStream is null");
      AppMethodBeat.o(137810);
      return 0;
    }
    if (this.filePath.toLowerCase().endsWith(".mp3"))
    {
      ab.d("MicroMsg.WxaAudioDataSource", "[getAudioType] mp3");
      AppMethodBeat.o(137810);
      return 2;
    }
    if (this.filePath.toLowerCase().contains(".wav"))
    {
      ab.d("MicroMsg.WxaAudioDataSource", "[getAudioType] wav");
      AppMethodBeat.o(137810);
      return 3;
    }
    if (this.filePath.toLowerCase().contains(".ogg"))
    {
      ab.d("MicroMsg.WxaAudioDataSource", "[getAudioType] ogg");
      AppMethodBeat.o(137810);
      return 4;
    }
    try
    {
      localObject1 = new byte[64];
      this.ioS.seek(0);
      this.ioS.read((byte[])localObject1);
      localObject1 = new String((byte[])localObject1);
      this.ioS.seek(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        ab.e("MicroMsg.WxaAudioDataSource", "getAudioType", new Object[] { localException });
        this.ioS.seek(0);
        Object localObject2 = null;
      }
    }
    finally
    {
      this.ioS.seek(0);
      AppMethodBeat.o(137810);
    }
    if ((localObject1 != null) && (((String)localObject1).contains("ftyp")))
    {
      ab.d("MicroMsg.WxaAudioDataSource", "[getAudioType] aac");
      AppMethodBeat.o(137810);
      return 1;
    }
    AppMethodBeat.o(137810);
    return 0;
  }
  
  public final void close()
  {
    AppMethodBeat.i(137811);
    a locala = this.ioS;
    if (locala != null)
    {
      ab.i("MicroMsg.WxaAudioDataSource", "close");
      locala.close();
      this.ioS = null;
    }
    AppMethodBeat.o(137811);
  }
  
  public final long getSize()
  {
    AppMethodBeat.i(137809);
    if (this.ioS == null)
    {
      ab.e("MicroMsg.WxaAudioDataSource", "[getSize] inputStream is null");
      AppMethodBeat.o(137809);
      return 0L;
    }
    long l = this.ioS.getLength();
    AppMethodBeat.o(137809);
    return l;
  }
  
  public final boolean isOpen()
  {
    return this.ioS != null;
  }
  
  public final void open()
  {
    AppMethodBeat.i(137806);
    ab.i("MicroMsg.WxaAudioDataSource", "open");
    if (this.ioS == null) {
      this.ioS = cE(this.filePath, this.gUy);
    }
    this.currentPosition = 0L;
    if (this.ioS != null) {
      this.ioS.seek(0);
    }
    AppMethodBeat.o(137806);
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137808);
    if (this.ioS == null)
    {
      ab.e("MicroMsg.WxaAudioDataSource", "[readAt]inputstream is null");
      AppMethodBeat.o(137808);
      return -1;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ab.e("MicroMsg.WxaAudioDataSource", "[readAt]bytes is null");
      AppMethodBeat.o(137808);
      return -1;
    }
    if ((paramLong < 0L) || (paramInt1 < 0) || (paramInt2 <= 0))
    {
      ab.e("MicroMsg.WxaAudioDataSource", "position:%d, offset:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(137808);
      return -1;
    }
    if ((paramArrayOfByte != null) && (paramInt1 + paramInt2 > paramArrayOfByte.length))
    {
      ab.e("MicroMsg.WxaAudioDataSource", "offset:%d, size:%d, bytes.length:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(137808);
      return -1;
    }
    if (paramInt2 + paramLong > getSize()) {
      ab.e("MicroMsg.WxaAudioDataSource", "position:%d, size:%d, getSize():%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Long.valueOf(getSize()) });
    }
    if (this.currentPosition != paramLong)
    {
      this.ioS.seek((int)paramLong);
      this.currentPosition = paramLong;
    }
    paramInt1 = this.ioS.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      this.currentPosition += paramInt1;
    }
    AppMethodBeat.o(137808);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.d
 * JD-Core Version:    0.7.0.1
 */