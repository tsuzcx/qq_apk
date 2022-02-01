package com.tencent.mm.plugin.ext.d;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;

public final class d
{
  private static SparseArray<byte[]> rer;
  
  static
  {
    AppMethodBeat.i(24494);
    rer = new SparseArray(1);
    AppMethodBeat.o(24494);
  }
  
  private static int bk(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24;
  }
  
  static c cst()
  {
    AppMethodBeat.i(24492);
    a locala = new a();
    AppMethodBeat.o(24492);
    return locala;
  }
  
  public static final class a
    implements d.c
  {
    public final d.b aX(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(24490);
      if (!i.fv(paramString))
      {
        ad.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: handle not exist");
        AppMethodBeat.o(24490);
        return null;
      }
      paramString = d.c(i.aY(paramString, 0, -1), paramBoolean);
      AppMethodBeat.o(24490);
      return paramString;
    }
  }
  
  public static final class b
  {
    int aXs;
    int aXt;
    byte[] dGa;
    int dGc;
    public String md5;
    Rect res;
    
    public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Rect paramRect, String paramString)
    {
      this.dGa = paramArrayOfByte;
      this.aXs = paramInt1;
      this.aXt = paramInt2;
      this.dGc = paramInt3;
      this.res = paramRect;
      this.md5 = paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(24491);
      StringBuilder localStringBuilder = new StringBuilder("RetrieveResult{yuvDataLength=");
      if (this.dGa != null) {}
      for (Object localObject = Integer.valueOf(this.dGa.length);; localObject = "null")
      {
        localObject = localObject + ", previewWidth=" + this.aXs + ", previewHeight=" + this.aXt + ", rotate=" + this.dGc + ", scanRect=" + this.res + ", md5=" + this.md5 + '}';
        AppMethodBeat.o(24491);
        return localObject;
      }
    }
  }
  
  static abstract interface c
  {
    public abstract d.b aX(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.d
 * JD-Core Version:    0.7.0.1
 */