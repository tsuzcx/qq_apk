package com.tencent.mm.plugin.ext.d;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;

public final class d
{
  private static SparseArray<byte[]> pLU;
  
  static
  {
    AppMethodBeat.i(24494);
    pLU = new SparseArray(1);
    AppMethodBeat.o(24494);
  }
  
  private static int bi(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24;
  }
  
  static c cfh()
  {
    AppMethodBeat.i(24492);
    a locala = new a();
    AppMethodBeat.o(24492);
    return locala;
  }
  
  public static final class a
    implements d.c
  {
    public final d.b aU(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(24490);
      if (!i.eK(paramString))
      {
        ad.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: handle not exist");
        AppMethodBeat.o(24490);
        return null;
      }
      paramString = d.c(i.aR(paramString, 0, -1), paramBoolean);
      AppMethodBeat.o(24490);
      return paramString;
    }
  }
  
  public static final class b
  {
    int aMk;
    int aMl;
    byte[] dwn;
    int dwp;
    public String md5;
    Rect pLV;
    
    public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Rect paramRect, String paramString)
    {
      this.dwn = paramArrayOfByte;
      this.aMk = paramInt1;
      this.aMl = paramInt2;
      this.dwp = paramInt3;
      this.pLV = paramRect;
      this.md5 = paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(24491);
      StringBuilder localStringBuilder = new StringBuilder("RetrieveResult{yuvDataLength=");
      if (this.dwn != null) {}
      for (Object localObject = Integer.valueOf(this.dwn.length);; localObject = "null")
      {
        localObject = localObject + ", previewWidth=" + this.aMk + ", previewHeight=" + this.aMl + ", rotate=" + this.dwp + ", scanRect=" + this.pLV + ", md5=" + this.md5 + '}';
        AppMethodBeat.o(24491);
        return localObject;
      }
    }
  }
  
  static abstract interface c
  {
    public abstract d.b aU(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.d
 * JD-Core Version:    0.7.0.1
 */