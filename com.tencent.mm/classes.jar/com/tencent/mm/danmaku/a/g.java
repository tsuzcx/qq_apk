package com.tencent.mm.danmaku.a;

import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.b.b;
import com.tencent.mm.danmaku.e.e;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class g
  implements View.OnTouchListener
{
  private d gOr;
  
  public g(View paramView, com.tencent.mm.danmaku.c.a parama)
  {
    AppMethodBeat.i(241645);
    this.gOr = new d(paramView, parama);
    AppMethodBeat.o(241645);
  }
  
  public final com.tencent.mm.danmaku.b.a aW(Object paramObject)
  {
    AppMethodBeat.i(241656);
    Object localObject3 = this.gOr.gNG;
    Object localObject2 = (BlockingQueue)((f)localObject3).gOp.get(0);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new LinkedBlockingQueue();
    }
    localObject2 = (com.tencent.mm.danmaku.b.a)((BlockingQueue)localObject1).poll();
    if (localObject2 == null)
    {
      localObject3 = ((f)localObject3).gNt;
      localObject1 = null;
      if (((com.tencent.mm.danmaku.c.a)localObject3).gPz != null) {
        localObject1 = ((com.tencent.mm.danmaku.c.a)localObject3).gPz.a((com.tencent.mm.danmaku.c.a)localObject3);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new b((com.tencent.mm.danmaku.c.a)localObject3);
      }
      e.v("DanmakuFactory", new Object[] { localObject2, " is created " });
    }
    for (;;)
    {
      ((com.tencent.mm.danmaku.b.a)localObject2).reset();
      if ((!c.gNA) || (paramObject != null)) {
        break;
      }
      paramObject = new RuntimeException("Danmaku data should been null");
      AppMethodBeat.o(241656);
      throw paramObject;
      e.v("DanmakuFactory", new Object[] { localObject2, " is reused " });
    }
    ((com.tencent.mm.danmaku.b.a)localObject2).mData = paramObject;
    ((com.tencent.mm.danmaku.b.a)localObject2).gPe = true;
    AppMethodBeat.o(241656);
    return localObject2;
  }
  
  public final void ab(List<com.tencent.mm.danmaku.b.a> paramList)
  {
    AppMethodBeat.i(241655);
    Object localObject = this.gOr;
    h localh = ((d)localObject).gNH;
    localObject = new d.4((d)localObject);
    if (!com.tencent.mm.danmaku.f.d.isEmpty(paramList))
    {
      Handler localHandler = localh.aso();
      if (localHandler != null) {
        localHandler.post(new h.2(localh, paramList, (h.a)localObject));
      }
    }
    AppMethodBeat.o(241655);
  }
  
  public final void c(Point paramPoint)
  {
    AppMethodBeat.i(241647);
    this.gOr.c(paramPoint);
    AppMethodBeat.o(241647);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(241651);
    this.gOr.clear();
    AppMethodBeat.o(241651);
  }
  
  public final void d(com.tencent.mm.danmaku.b.a parama)
  {
    AppMethodBeat.i(241654);
    Object localObject = this.gOr;
    parama.setTime(((d)localObject).gNv.gQA);
    h localh = ((d)localObject).gNH;
    localObject = new d.3((d)localObject);
    Handler localHandler = localh.aso();
    if (localHandler != null) {
      localHandler.post(new h.1(localh, parama, (h.a)localObject));
    }
    AppMethodBeat.o(241654);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(241653);
    boolean bool = this.gOr.isPlaying();
    AppMethodBeat.o(241653);
    return bool;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(241646);
    boolean bool = this.gOr.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(241646);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(241649);
    this.gOr.pause();
    AppMethodBeat.o(241649);
  }
  
  public final void release()
  {
    AppMethodBeat.i(241652);
    this.gOr.release();
    AppMethodBeat.o(241652);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(241648);
    this.gOr.resume();
    AppMethodBeat.o(241648);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(241650);
    Object localObject = this.gOr;
    e.v("DanmakuManager", "seek(): postime = ".concat(String.valueOf(paramLong)));
    localObject = ((d)localObject).gOc;
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    localMessage.obj = Long.valueOf(paramLong);
    ((i)localObject).sendMessage(localMessage);
    AppMethodBeat.o(241650);
  }
  
  public static final class a
    implements Serializable, Comparator<com.tencent.mm.danmaku.b.a>
  {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.g
 * JD-Core Version:    0.7.0.1
 */