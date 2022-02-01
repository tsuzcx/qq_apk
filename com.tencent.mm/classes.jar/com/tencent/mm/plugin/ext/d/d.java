package com.tencent.mm.plugin.ext.d;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;

public final class d
{
  private static SparseArray<byte[]> rmv;
  
  static
  {
    AppMethodBeat.i(24494);
    rmv = new SparseArray(1);
    AppMethodBeat.o(24494);
  }
  
  private static int bj(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24;
  }
  
  static c ctV()
  {
    AppMethodBeat.i(24492);
    a locala = new a();
    AppMethodBeat.o(24492);
    return locala;
  }
  
  public static final class a
    implements d.c
  {
    public final d.b aZ(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(24490);
      if (!o.fB(paramString))
      {
        ae.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: handle not exist");
        AppMethodBeat.o(24490);
        return null;
      }
      paramString = d.c(o.bb(paramString, 0, -1), paramBoolean);
      AppMethodBeat.o(24490);
      return paramString;
    }
  }
  
  public static final class b
  {
    int aXs;
    int aXt;
    byte[] dHg;
    int dHi;
    public String md5;
    Rect rmw;
    
    public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Rect paramRect, String paramString)
    {
      this.dHg = paramArrayOfByte;
      this.aXs = paramInt1;
      this.aXt = paramInt2;
      this.dHi = paramInt3;
      this.rmw = paramRect;
      this.md5 = paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(24491);
      StringBuilder localStringBuilder = new StringBuilder("RetrieveResult{yuvDataLength=");
      if (this.dHg != null) {}
      for (Object localObject = Integer.valueOf(this.dHg.length);; localObject = "null")
      {
        localObject = localObject + ", previewWidth=" + this.aXs + ", previewHeight=" + this.aXt + ", rotate=" + this.dHi + ", scanRect=" + this.rmw + ", md5=" + this.md5 + '}';
        AppMethodBeat.o(24491);
        return localObject;
      }
    }
  }
  
  static abstract interface c
  {
    public abstract d.b aZ(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.d
 * JD-Core Version:    0.7.0.1
 */