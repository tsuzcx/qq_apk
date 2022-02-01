package com.tencent.mm.openglapihook;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b
{
  private static b mxK;
  private Handler mH;
  private HandlerThread mHandlerThread;
  List<OpenGLInfo> mxJ;
  a.a mxL;
  
  private b()
  {
    AppMethodBeat.i(204101);
    this.mxJ = new ArrayList();
    this.mHandlerThread = new HandlerThread("GpuResLeakMonitor");
    this.mHandlerThread.start();
    this.mH = new Handler(this.mHandlerThread.getLooper());
    AppMethodBeat.o(204101);
  }
  
  public static b bun()
  {
    AppMethodBeat.i(204102);
    if (mxK == null) {
      mxK = new b();
    }
    b localb = mxK;
    AppMethodBeat.o(204102);
    return localb;
  }
  
  public final List<OpenGLInfo> buo()
  {
    AppMethodBeat.i(204105);
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mxJ)
    {
      Iterator localIterator = this.mxJ.iterator();
      if (localIterator.hasNext())
      {
        OpenGLInfo localOpenGLInfo = (OpenGLInfo)localIterator.next();
        if (localOpenGLInfo != null) {
          localArrayList.add(new OpenGLInfo(localOpenGLInfo));
        }
      }
    }
    AppMethodBeat.o(204105);
    return localList1;
  }
  
  public final void k(final OpenGLInfo paramOpenGLInfo)
  {
    AppMethodBeat.i(204103);
    this.mH.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204097);
        if (paramOpenGLInfo == null)
        {
          AppMethodBeat.o(204097);
          return;
        }
        synchronized (b.this.mxJ)
        {
          b.this.mxJ.add(paramOpenGLInfo);
          AppMethodBeat.o(204097);
          return;
        }
      }
    });
    AppMethodBeat.o(204103);
  }
  
  public final void l(final OpenGLInfo paramOpenGLInfo)
  {
    AppMethodBeat.i(204104);
    this.mH.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204100);
        if (paramOpenGLInfo == null)
        {
          AppMethodBeat.o(204100);
          return;
        }
        synchronized (b.this.mxJ)
        {
          Iterator localIterator = b.this.mxJ.iterator();
          while (localIterator.hasNext())
          {
            OpenGLInfo localOpenGLInfo = (OpenGLInfo)localIterator.next();
            if ((localOpenGLInfo != null) && (localOpenGLInfo.mxB == paramOpenGLInfo.mxB) && (localOpenGLInfo.mxw.equals(paramOpenGLInfo.mxw)) && (localOpenGLInfo.id == paramOpenGLInfo.id))
            {
              localOpenGLInfo.release();
              localIterator.remove();
            }
          }
          AppMethodBeat.o(204100);
          return;
        }
      }
    });
    AppMethodBeat.o(204104);
  }
  
  public final void m(OpenGLInfo paramOpenGLInfo)
  {
    AppMethodBeat.i(204106);
    synchronized (this.mxJ)
    {
      Iterator localIterator = this.mxJ.iterator();
      while (localIterator.hasNext())
      {
        OpenGLInfo localOpenGLInfo = (OpenGLInfo)localIterator.next();
        if (localOpenGLInfo != null) {
          if ((localOpenGLInfo.mxB == paramOpenGLInfo.mxB) && (localOpenGLInfo.mxw.equals(paramOpenGLInfo.mxw)) && (localOpenGLInfo.id == paramOpenGLInfo.id))
          {
            if (this.mxL != null) {
              this.mxL.b(localOpenGLInfo);
            }
            localOpenGLInfo.release();
            localIterator.remove();
            AppMethodBeat.o(204106);
            return;
          }
        }
      }
      AppMethodBeat.o(204106);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.openglapihook.b
 * JD-Core Version:    0.7.0.1
 */