package com.tencent.mm.plugin.ext.d;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;

public final class d
{
  private static SparseArray<byte[]> quC;
  
  static
  {
    AppMethodBeat.i(24494);
    quC = new SparseArray(1);
    AppMethodBeat.o(24494);
  }
  
  private static int bh(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24;
  }
  
  static c cmO()
  {
    AppMethodBeat.i(24492);
    a locala = new a();
    AppMethodBeat.o(24492);
    return locala;
  }
  
  public static final class a
    implements d.c
  {
    public final d.b aV(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(24490);
      if (!i.eA(paramString))
      {
        ac.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: handle not exist");
        AppMethodBeat.o(24490);
        return null;
      }
      paramString = d.c(i.aU(paramString, 0, -1), paramBoolean);
      AppMethodBeat.o(24490);
      return paramString;
    }
  }
  
  public static final class b
  {
    int aNa;
    int aNb;
    byte[] dua;
    int duc;
    public String md5;
    Rect quD;
    
    public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Rect paramRect, String paramString)
    {
      this.dua = paramArrayOfByte;
      this.aNa = paramInt1;
      this.aNb = paramInt2;
      this.duc = paramInt3;
      this.quD = paramRect;
      this.md5 = paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(24491);
      StringBuilder localStringBuilder = new StringBuilder("RetrieveResult{yuvDataLength=");
      if (this.dua != null) {}
      for (Object localObject = Integer.valueOf(this.dua.length);; localObject = "null")
      {
        localObject = localObject + ", previewWidth=" + this.aNa + ", previewHeight=" + this.aNb + ", rotate=" + this.duc + ", scanRect=" + this.quD + ", md5=" + this.md5 + '}';
        AppMethodBeat.o(24491);
        return localObject;
      }
    }
  }
  
  static abstract interface c
  {
    public abstract d.b aV(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.d
 * JD-Core Version:    0.7.0.1
 */