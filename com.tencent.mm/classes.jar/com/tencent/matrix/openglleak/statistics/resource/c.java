package com.tencent.matrix.openglleak.statistics.resource;

import android.opengl.EGLContext;
import android.os.Build.VERSION;
import com.tencent.matrix.openglleak.a.a.a;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  public String eXD = "";
  long eXE = 0L;
  private String eXH = "";
  private String eXI = "";
  public final c.a eXJ;
  public b eXK;
  EGLContext eXL;
  public a.a eXM;
  AtomicInteger evJ;
  public final int id;
  
  public c(c.a parama, int paramInt, String paramString, EGLContext paramEGLContext)
  {
    this.eXH = paramString;
    this.id = paramInt;
    this.eXL = paramEGLContext;
    this.eXJ = parama;
  }
  
  public c(c.a parama, int paramInt, String paramString1, EGLContext paramEGLContext, String paramString2, long paramLong, a.a parama1, AtomicInteger paramAtomicInteger)
  {
    this.eXH = paramString1;
    this.eXD = paramString2;
    this.eXE = paramLong;
    this.eXJ = parama;
    this.eXM = parama1;
    this.evJ = paramAtomicInteger;
    this.id = paramInt;
    this.eXL = paramEGLContext;
  }
  
  public final void a(b paramb)
  {
    if (this.eXK == paramb) {
      return;
    }
    this.eXK = paramb;
  }
  
  public final long ayQ()
  {
    long l2 = 0L;
    long l1 = l2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      l1 = l2;
      if (this.eXL != null) {
        l1 = this.eXL.getNativeHandle();
      }
    }
    return l1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof c))) {
        return false;
      }
      paramObject = (c)paramObject;
    } while ((this.id == paramObject.id) && (ayQ() == paramObject.ayQ()) && (this.eXH.equals(paramObject.eXH)) && (this.eXJ == paramObject.eXJ));
    return false;
  }
  
  public final int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(this.id), Long.valueOf(ayQ()), this.eXH, this.eXJ });
  }
  
  public final String toString()
  {
    return "OpenGLInfo{id=" + this.id + ", activityName=" + this.eXM + ", type='" + this.eXJ.toString() + '\'' + ", threadId='" + this.eXH + '\'' + ", eglContextNativeHandle='" + ayQ() + '\'' + ", eglContextReleased='" + ResRecordManager.ayR().f(this) + '\'' + ", javaStack='" + this.eXD + '\'' + ", nativeStack='" + ResRecordManager.ayR().d(this) + '\'' + ", nativeStackPtr=" + this.eXE + ", memoryInfo=" + this.eXK + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.openglleak.statistics.resource.c
 * JD-Core Version:    0.7.0.1
 */