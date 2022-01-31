package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
{
  private static volatile d jNC = null;
  public static final Object mLock = new Object();
  public List<d.a> jND = null;
  
  public static final d aOf()
  {
    if (jNC == null) {
      synchronized (mLock)
      {
        if (jNC == null) {
          jNC = new d();
        }
        d locald = jNC;
        return locald;
      }
    }
    return jNC;
  }
  
  public final void a(d.b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      try
      {
        y.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: invalid callbacker");
        return;
      }
      finally {}
      synchronized (mLock)
      {
        if (this.jND == null) {
          this.jND = Collections.synchronizedList(new ArrayList(5));
        }
        this.jND.add(new d.a(this, paramb));
      }
    }
  }
  
  public final void av(byte[] paramArrayOfByte)
  {
    synchronized (mLock)
    {
      y.v("MicroMsg.FaceCameraDataCallbackHolder", "hy: publish data:" + paramArrayOfByte);
      if ((this.jND == null) || (this.jND.size() == 0))
      {
        y.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: nothing's listening to preview data");
        return;
      }
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        y.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: null camera data got");
        return;
      }
    }
    Iterator localIterator = this.jND.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      int i = paramArrayOfByte.length;
      locala.data = ((byte[])locala.jNE.aOg().c(Integer.valueOf(i)));
      System.arraycopy(paramArrayOfByte, 0, locala.data, 0, i);
      locala.jNE.aw(locala.data);
    }
  }
  
  public final void b(d.b paramb)
  {
    synchronized (mLock)
    {
      if (this.jND != null) {
        this.jND.remove(paramb);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.d
 * JD-Core Version:    0.7.0.1
 */