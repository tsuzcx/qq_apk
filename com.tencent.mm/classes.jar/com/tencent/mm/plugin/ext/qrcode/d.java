package com.tencent.mm.plugin.ext.qrcode;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

public final class d
{
  private static SparseArray<byte[]> zQb;
  
  static
  {
    AppMethodBeat.i(24494);
    zQb = new SparseArray(1);
    AppMethodBeat.o(24494);
  }
  
  private static int bO(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24;
  }
  
  static c dOo()
  {
    AppMethodBeat.i(24492);
    a locala = new a();
    AppMethodBeat.o(24492);
    return locala;
  }
  
  public static final class a
    implements d.c
  {
    public final d.b bq(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(24490);
      if (!y.ZC(paramString))
      {
        Log.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: handle not exist");
        AppMethodBeat.o(24490);
        return null;
      }
      paramString = d.c(y.bi(paramString, 0, -1), paramBoolean);
      AppMethodBeat.o(24490);
      return paramString;
    }
  }
  
  public static final class b
  {
    int hYK;
    public String md5;
    int previewHeight;
    int previewWidth;
    byte[] yuvData;
    Rect zQc;
    
    public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Rect paramRect, String paramString)
    {
      this.yuvData = paramArrayOfByte;
      this.previewWidth = paramInt1;
      this.previewHeight = paramInt2;
      this.hYK = paramInt3;
      this.zQc = paramRect;
      this.md5 = paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(24491);
      StringBuilder localStringBuilder = new StringBuilder("RetrieveResult{yuvDataLength=");
      if (this.yuvData != null) {}
      for (Object localObject = Integer.valueOf(this.yuvData.length);; localObject = "null")
      {
        localObject = localObject + ", previewWidth=" + this.previewWidth + ", previewHeight=" + this.previewHeight + ", rotate=" + this.hYK + ", scanRect=" + this.zQc + ", md5=" + this.md5 + '}';
        AppMethodBeat.o(24491);
        return localObject;
      }
    }
  }
  
  static abstract interface c
  {
    public abstract d.b bq(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.qrcode.d
 * JD-Core Version:    0.7.0.1
 */