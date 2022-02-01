package com.tencent.mm.performance.jni.egl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.performance.jni.AbsHook;
import com.tencent.mm.performance.jni.LibWxPerfManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EglHook
  extends AbsHook
{
  public static final EglHook INSTANCE;
  private static final String TAG = "Cc1over-debug";
  private static final List<OnChangeListener> listeners;
  
  static
  {
    AppMethodBeat.i(195654);
    LibWxPerfManager.INSTANCE.init();
    INSTANCE = new EglHook();
    listeners = new ArrayList();
    AppMethodBeat.o(195654);
  }
  
  public static void onCreateEglContext(long paramLong1, long paramLong2, String arg4)
  {
    AppMethodBeat.i(195649);
    EglResourceMonitor localEglResourceMonitor = new EglResourceMonitor(paramLong1, ???, paramLong2);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(195649);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onCreateEglContext(localEglResourceMonitor);
      }
    }
    AppMethodBeat.o(195649);
  }
  
  public static void onCreateEglWindowSurface(long paramLong1, long paramLong2, String arg4)
  {
    AppMethodBeat.i(195652);
    EglResourceMonitor localEglResourceMonitor = new EglResourceMonitor(paramLong1, ???, paramLong2);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(195652);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onCreateEglWindowSurface(localEglResourceMonitor);
      }
    }
    AppMethodBeat.o(195652);
  }
  
  public static void onCreatePbufferSurface(long paramLong1, long paramLong2, String arg4)
  {
    AppMethodBeat.i(195653);
    EglResourceMonitor localEglResourceMonitor = new EglResourceMonitor(paramLong1, ???, paramLong2);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(195653);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onCreatePbufferSurface(localEglResourceMonitor);
      }
    }
    AppMethodBeat.o(195653);
  }
  
  public static void onDeleteEglContext(long paramLong)
  {
    AppMethodBeat.i(195651);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(195651);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onDeleteEglContext(paramLong);
      }
    }
    AppMethodBeat.o(195651);
  }
  
  public static void onDeleteEglSurface(long paramLong)
  {
    AppMethodBeat.i(195650);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(195650);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onDeleteEglSurface(paramLong);
      }
    }
    AppMethodBeat.o(195650);
  }
  
  private native void startHook();
  
  public void addListener(OnChangeListener paramOnChangeListener)
  {
    AppMethodBeat.i(195647);
    if (paramOnChangeListener == null)
    {
      AppMethodBeat.o(195647);
      return;
    }
    synchronized (listeners)
    {
      listeners.add(paramOnChangeListener);
      AppMethodBeat.o(195647);
      return;
    }
  }
  
  public void onConfigure() {}
  
  public void onHook()
  {
    AppMethodBeat.i(195646);
    startHook();
    AppMethodBeat.o(195646);
  }
  
  public void removeListener(OnChangeListener paramOnChangeListener)
  {
    AppMethodBeat.i(195648);
    if (paramOnChangeListener == null)
    {
      AppMethodBeat.o(195648);
      return;
    }
    synchronized (listeners)
    {
      listeners.remove(paramOnChangeListener);
      AppMethodBeat.o(195648);
      return;
    }
  }
  
  public static abstract interface OnChangeListener
  {
    public abstract void onCreateEglContext(EglResourceMonitor paramEglResourceMonitor);
    
    public abstract void onCreateEglWindowSurface(EglResourceMonitor paramEglResourceMonitor);
    
    public abstract void onCreatePbufferSurface(EglResourceMonitor paramEglResourceMonitor);
    
    public abstract void onDeleteEglContext(long paramLong);
    
    public abstract void onDeleteEglSurface(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.performance.jni.egl.EglHook
 * JD-Core Version:    0.7.0.1
 */