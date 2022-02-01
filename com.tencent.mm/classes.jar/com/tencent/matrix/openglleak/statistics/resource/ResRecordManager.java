package com.tencent.matrix.openglleak.statistics.resource;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ResRecordManager
{
  private static final ResRecordManager eXS = new ResRecordManager();
  public final List<a> eXT = new LinkedList();
  public final List<c> eXU = new LinkedList();
  public final List<Long> eXV = new LinkedList();
  
  public static ResRecordManager ayR()
  {
    return eXS;
  }
  
  public static native String dumpNativeStack(long paramLong);
  
  public static native void releaseNative(long paramLong);
  
  public final c b(c.a parama, long paramLong, int paramInt)
  {
    synchronized (this.eXU)
    {
      Iterator localIterator = this.eXU.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc != null) {
          if ((parama == localc.eXJ) && (localc.ayQ() == paramLong) && (localc.id == paramInt)) {
            return localc;
          }
        }
      }
      return null;
    }
  }
  
  public final void b(c paramc)
  {
    if (paramc == null) {
      return;
    }
    synchronized (this.eXU)
    {
      this.eXU.add(paramc);
      synchronized (this.eXT)
      {
        Iterator localIterator = this.eXT.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala != null) {
            locala.b(paramc);
          }
        }
      }
    }
  }
  
  public final void c(c paramc)
  {
    if (paramc == null) {
      return;
    }
    int i;
    synchronized (this.eXU)
    {
      i = this.eXU.indexOf(paramc);
      if (-1 == i) {
        return;
      }
    }
    Object localObject1 = (c)this.eXU.get(i);
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((c)localObject1).evJ;
    ((AtomicInteger)localObject2).set(((AtomicInteger)localObject2).get() - 1);
    if (((AtomicInteger)localObject2).get() == 0) {
      releaseNative(((c)localObject1).eXE);
    }
    localObject1 = ((c)localObject1).eXK;
    if (localObject1 != null)
    {
      long l = ((b)localObject1).eXE;
      if (l != 0L)
      {
        releaseNative(l);
        ((b)localObject1).eXE = 0L;
      }
    }
    this.eXU.remove(paramc);
    synchronized (this.eXT)
    {
      localObject1 = this.eXT.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((a)localObject2).c(paramc);
        }
      }
    }
  }
  
  public final String d(c paramc)
  {
    for (;;)
    {
      synchronized (this.eXU)
      {
        int i = this.eXU.indexOf(paramc);
        if (-1 == i) {
          return "res already released, can not get native stack";
        }
        paramc = (c)this.eXU.get(i);
        if (paramc == null) {
          return "";
        }
        long l = paramc.eXE;
        if (l != 0L)
        {
          paramc = dumpNativeStack(l);
          return paramc;
        }
      }
      paramc = "";
    }
  }
  
  public final boolean e(c paramc)
  {
    synchronized (this.eXU)
    {
      if (!this.eXU.contains(paramc))
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final boolean f(c paramc)
  {
    for (;;)
    {
      Object localObject;
      synchronized (this.eXV)
      {
        long l = paramc.ayQ();
        if (0L == l) {
          return true;
        }
        localObject = this.eXV.iterator();
        if (((Iterator)localObject).hasNext())
        {
          if (((Long)((Iterator)localObject).next()).longValue() != l) {
            continue;
          }
          return true;
        }
        localObject = paramc.eXL;
        localObject = EGL14.eglCreateContext(com.tencent.matrix.openglleak.a.b.mEGLDisplay, com.tencent.matrix.openglleak.a.b.eYa, (EGLContext)localObject, new int[] { 12440, 2, 12344 }, 0);
        if (localObject == EGL14.EGL_NO_CONTEXT)
        {
          i = 0;
          if (i != 0) {
            break label174;
          }
          this.eXV.add(Long.valueOf(paramc.ayQ()));
          break label174;
          return bool;
        }
      }
      EGL14.eglDestroyContext(com.tencent.matrix.openglleak.a.b.mEGLDisplay, (EGLContext)localObject);
      int i = 1;
      continue;
      label174:
      while (i != 0)
      {
        bool = false;
        break;
      }
      boolean bool = true;
    }
  }
  
  static abstract interface a
  {
    public abstract void b(c paramc);
    
    public abstract void c(c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.openglleak.statistics.resource.ResRecordManager
 * JD-Core Version:    0.7.0.1
 */