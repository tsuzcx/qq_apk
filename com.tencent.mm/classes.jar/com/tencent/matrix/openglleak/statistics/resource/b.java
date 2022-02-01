package com.tencent.matrix.openglleak.statistics.resource;

import com.tencent.matrix.e.c;
import java.util.Arrays;

public final class b
{
  public int cIi;
  public int eXA;
  public long eXC;
  public String eXD = "";
  public long eXE;
  private final c.a eXF;
  private a[] eXG;
  public int eXy;
  public int height;
  public int id;
  public long size;
  public int width;
  
  public b(c.a parama)
  {
    this.eXF = parama;
    if (this.eXF == c.a.eXN) {
      this.eXG = new a[6];
    }
  }
  
  private static int nq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 3553: 
    case 32879: 
    case 34069: 
    case 35866: 
      return 0;
    case 34070: 
      return 1;
    case 34071: 
      return 2;
    case 34072: 
      return 3;
    case 34073: 
      return 4;
    }
    return 5;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    int i = nq(paramInt1);
    if (i == -1)
    {
      c.e("MicroMsg.OpenGLHook", "setTexturesInfo faceId = -1, target = ".concat(String.valueOf(paramInt1)), new Object[0]);
      return;
    }
    if (this.eXE != 0L) {
      ResRecordManager.releaseNative(this.eXE);
    }
    this.eXD = paramString;
    this.eXE = paramLong3;
    a locala = this.eXG[i];
    paramString = locala;
    if (locala == null) {
      paramString = new a();
    }
    paramString.eXy = paramInt1;
    paramString.id = paramInt10;
    paramString.eXz = paramLong1;
    paramString.level = paramInt2;
    paramString.eXA = paramInt3;
    paramString.width = paramInt4;
    paramString.height = paramInt5;
    paramString.aOm = paramInt6;
    paramString.eXB = paramInt7;
    paramString.format = paramInt8;
    paramString.type = paramInt9;
    paramString.size = paramLong2;
    this.eXG[i] = paramString;
  }
  
  public final String ayP()
  {
    if (this.eXE != 0L) {
      return ResRecordManager.dumpNativeStack(this.eXE);
    }
    return "";
  }
  
  public final long getSize()
  {
    long l1 = 0L;
    if (this.eXF == c.a.eXN)
    {
      a[] arrayOfa = this.eXG;
      int j = arrayOfa.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        a locala = arrayOfa[i];
        l2 = l1;
        if (locala != null) {
          l2 = l1 + locala.size;
        }
        i += 1;
        l1 = l2;
      }
    }
    long l2 = this.size;
    return l2;
  }
  
  public final String toString()
  {
    return "MemoryInfo{target=" + this.eXy + ", internalFormat=" + this.eXA + ", width=" + this.width + ", height=" + this.height + ", id=" + this.id + ", eglContextId=" + this.eXC + ", usage=" + this.cIi + ", javaStack='" + this.eXD + '\'' + ", nativeStack='" + ayP() + '\'' + ", resType=" + this.eXF + ", size=" + getSize() + ", faces=" + Arrays.toString(this.eXG) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.matrix.openglleak.statistics.resource.b
 * JD-Core Version:    0.7.0.1
 */