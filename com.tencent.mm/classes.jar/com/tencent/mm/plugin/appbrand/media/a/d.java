package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.luggage.j.a;
import com.tencent.mm.af.e;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class d
  implements e
{
  private long currentPosition;
  private String fCl;
  private String filePath;
  public a gMY = null;
  
  public d(String paramString1, String paramString2)
  {
    this.filePath = paramString1;
    this.fCl = paramString2;
    this.gMY = bP(paramString1, paramString2);
  }
  
  private static a bP(String paramString1, String paramString2)
  {
    long l = System.nanoTime();
    if (bk.bl(paramString2))
    {
      y.e("MicroMsg.WxaAudioDataSource", "pkgpath is null, return");
      return null;
    }
    paramString2 = new ai(new File(paramString2));
    if (!paramString2.fDy)
    {
      paramString2.close();
      y.e("MicroMsg.WxaAudioDataSource", "pkg invalid");
      return null;
    }
    if (!paramString2.abX())
    {
      paramString2.close();
      y.e("MicroMsg.WxaAudioDataSource", "pkg readInfo failed");
      return null;
    }
    InputStream localInputStream = paramString2.rb(paramString1);
    if (localInputStream == null)
    {
      paramString2.close();
      y.e("MicroMsg.WxaAudioDataSource", "inputstream for %s is null", new Object[] { paramString1 });
      return null;
    }
    paramString2.close();
    y.d("MicroMsg.WxaAudioDataSource", "time:%d", new Object[] { Long.valueOf(System.nanoTime() - l) });
    return (a)localInputStream;
  }
  
  public final int JP()
  {
    if (this.gMY == null) {
      this.gMY = bP(this.filePath, this.fCl);
    }
    if (this.gMY == null) {
      y.e("MicroMsg.WxaAudioDataSource", "[getAudioType] inputStream is null");
    }
    do
    {
      return 0;
      if (this.filePath.toLowerCase().endsWith(".mp3"))
      {
        y.d("MicroMsg.WxaAudioDataSource", "[getAudioType] mp3");
        return 2;
      }
      if (this.filePath.toLowerCase().contains(".wav"))
      {
        y.d("MicroMsg.WxaAudioDataSource", "[getAudioType] wav");
        return 3;
      }
      if (this.filePath.toLowerCase().contains(".ogg"))
      {
        y.d("MicroMsg.WxaAudioDataSource", "[getAudioType] ogg");
        return 4;
      }
      try
      {
        localObject1 = new byte[64];
        this.gMY.seek(0);
        this.gMY.read((byte[])localObject1);
        localObject1 = new String((byte[])localObject1);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          y.e("MicroMsg.WxaAudioDataSource", "getAudioType", new Object[] { localException });
          this.gMY.seek(0);
          Object localObject2 = null;
        }
      }
      finally
      {
        this.gMY.seek(0);
      }
    } while ((localObject1 == null) || (!((String)localObject1).contains("ftyp")));
    y.d("MicroMsg.WxaAudioDataSource", "[getAudioType] aac");
    return 1;
  }
  
  public final void close()
  {
    if (this.gMY != null)
    {
      y.i("MicroMsg.WxaAudioDataSource", "close");
      this.gMY.close();
      this.gMY = null;
    }
  }
  
  public final long getSize()
  {
    if (this.gMY == null)
    {
      y.e("MicroMsg.WxaAudioDataSource", "[getSize] inputStream is null");
      return 0L;
    }
    return this.gMY.bjB.limit();
  }
  
  public final boolean isOpen()
  {
    return this.gMY != null;
  }
  
  public final void open()
  {
    y.i("MicroMsg.WxaAudioDataSource", "open");
    if (this.gMY == null) {
      this.gMY = bP(this.filePath, this.fCl);
    }
    this.currentPosition = 0L;
    if (this.gMY != null) {
      this.gMY.seek(0);
    }
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = -1;
    if (this.gMY == null)
    {
      y.e("MicroMsg.WxaAudioDataSource", "[readAt]inputstream is null");
      paramInt1 = i;
    }
    do
    {
      return paramInt1;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      {
        y.e("MicroMsg.WxaAudioDataSource", "[readAt]bytes is null");
        return -1;
      }
      if ((paramLong < 0L) || (paramInt1 < 0) || (paramInt2 <= 0))
      {
        y.e("MicroMsg.WxaAudioDataSource", "position:%d, offset:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        return -1;
      }
      if ((paramArrayOfByte != null) && (paramInt1 + paramInt2 > paramArrayOfByte.length))
      {
        y.e("MicroMsg.WxaAudioDataSource", "offset:%d, size:%d, bytes.length:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
        return -1;
      }
      if (paramInt2 + paramLong > getSize()) {
        y.e("MicroMsg.WxaAudioDataSource", "position:%d, size:%d, getSize():%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Long.valueOf(getSize()) });
      }
      if (this.currentPosition != paramLong)
      {
        this.gMY.seek((int)paramLong);
        this.currentPosition = paramLong;
      }
      paramInt2 = this.gMY.read(paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = paramInt2;
    } while (paramInt2 < 0);
    this.currentPosition += paramInt2;
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.d
 * JD-Core Version:    0.7.0.1
 */