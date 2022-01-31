package com.tencent.magicbrush;

import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

final class MBRuntime$b
  implements MBRuntime.IMBEventListener
{
  private MBRuntime$b(MBRuntime paramMBRuntime) {}
  
  public final void onConsoleOutput(String paramString)
  {
    AppMethodBeat.i(115803);
    Iterator localIterator = MBRuntime.access$1400(this.bJl).iterator();
    while (localIterator.hasNext()) {
      ((MBRuntime.IMBEventListener)localIterator.next()).onConsoleOutput(paramString);
    }
    AppMethodBeat.o(115803);
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(115801);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "ClientEventListener.onError ", new Object[0]);
    Iterator localIterator = MBRuntime.access$1400(this.bJl).iterator();
    while (localIterator.hasNext()) {
      ((MBRuntime.IMBEventListener)localIterator.next()).onError(paramInt);
    }
    AppMethodBeat.o(115801);
  }
  
  public final void onFirstFrameRendered()
  {
    AppMethodBeat.i(115798);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "ClientEventListener.onFirstFrameRendered ", new Object[0]);
    Iterator localIterator = MBRuntime.access$1400(this.bJl).iterator();
    while (localIterator.hasNext()) {
      ((MBRuntime.IMBEventListener)localIterator.next()).onFirstFrameRendered();
    }
    AppMethodBeat.o(115798);
  }
  
  public final void onJsExceptionOccurred(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(115802);
    Iterator localIterator = MBRuntime.access$1400(this.bJl).iterator();
    while (localIterator.hasNext()) {
      ((MBRuntime.IMBEventListener)localIterator.next()).onJsExceptionOccurred(paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(115802);
  }
  
  public final void onMainCanvasCreated(int paramInt)
  {
    AppMethodBeat.i(115799);
    MBRuntime.access$1502(this.bJl, paramInt);
    AppMethodBeat.o(115799);
  }
  
  public final void onMainCanvasTypeDefined(int paramInt)
  {
    AppMethodBeat.i(115800);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "ClientEventListener.onMainCanvasTypeDefined ", new Object[0]);
    Iterator localIterator = MBRuntime.access$1400(this.bJl).iterator();
    while (localIterator.hasNext()) {
      ((MBRuntime.IMBEventListener)localIterator.next()).onMainCanvasTypeDefined(paramInt);
    }
    AppMethodBeat.o(115800);
  }
  
  public final void onRendererReady(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115797);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "ClientEventListener.onRendererReady [%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    MBRuntime.access$1202(this.bJl, paramInt1);
    MBRuntime.access$1302(this.bJl, paramInt2);
    Iterator localIterator = MBRuntime.access$1400(this.bJl).iterator();
    while (localIterator.hasNext()) {
      ((MBRuntime.IMBEventListener)localIterator.next()).onRendererReady(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115797);
  }
  
  public final void onSystemSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115796);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "ClientEventListener.onSystemSizeChanged [%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    MBRuntime.access$1202(this.bJl, paramInt1);
    MBRuntime.access$1302(this.bJl, paramInt2);
    Iterator localIterator = MBRuntime.access$1400(this.bJl).iterator();
    while (localIterator.hasNext()) {
      ((MBRuntime.IMBEventListener)localIterator.next()).onSystemSizeChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.b
 * JD-Core Version:    0.7.0.1
 */