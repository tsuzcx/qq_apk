package com.tencent.mm.danmaku.a;

import android.graphics.Point;
import android.os.Handler;
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
  private d jyM;
  
  public g(View paramView, com.tencent.mm.danmaku.c.a parama)
  {
    AppMethodBeat.i(276429);
    this.jyM = new d(paramView, parama);
    AppMethodBeat.o(276429);
  }
  
  public final void Y(List<com.tencent.mm.danmaku.b.a> paramList)
  {
    AppMethodBeat.i(276446);
    Object localObject = this.jyM;
    h localh = ((d)localObject).jyc;
    localObject = new d.3((d)localObject);
    if (!com.tencent.mm.danmaku.f.d.isEmpty(paramList))
    {
      Handler localHandler = localh.azc();
      if (localHandler != null) {
        localHandler.post(new h.1(localh, paramList, (h.a)localObject));
      }
    }
    AppMethodBeat.o(276446);
  }
  
  public final com.tencent.mm.danmaku.b.a aZ(Object paramObject)
  {
    AppMethodBeat.i(276449);
    Object localObject3 = this.jyM.jyb;
    Object localObject2 = (BlockingQueue)((f)localObject3).jyK.get(0);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new LinkedBlockingQueue();
    }
    localObject2 = (com.tencent.mm.danmaku.b.a)((BlockingQueue)localObject1).poll();
    if (localObject2 == null)
    {
      localObject3 = ((f)localObject3).jxO;
      localObject1 = null;
      if (((com.tencent.mm.danmaku.c.a)localObject3).jzS != null) {
        localObject1 = ((com.tencent.mm.danmaku.c.a)localObject3).jzS.a((com.tencent.mm.danmaku.c.a)localObject3);
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
      if ((!c.jxV) || (paramObject != null)) {
        break;
      }
      paramObject = new RuntimeException("Danmaku data should been null");
      AppMethodBeat.o(276449);
      throw paramObject;
      e.v("DanmakuFactory", new Object[] { localObject2, " is reused " });
    }
    ((com.tencent.mm.danmaku.b.a)localObject2).mData = paramObject;
    ((com.tencent.mm.danmaku.b.a)localObject2).jzy = true;
    AppMethodBeat.o(276449);
    return localObject2;
  }
  
  public final void ayG()
  {
    AppMethodBeat.i(276435);
    this.jyM.ayG();
    AppMethodBeat.o(276435);
  }
  
  public final void ayH()
  {
    AppMethodBeat.i(276444);
    this.jyM.ayH();
    AppMethodBeat.o(276444);
  }
  
  public final void azb()
  {
    AppMethodBeat.i(276432);
    this.jyM.start(0L);
    AppMethodBeat.o(276432);
  }
  
  public final void c(Point paramPoint)
  {
    AppMethodBeat.i(276431);
    this.jyM.c(paramPoint);
    AppMethodBeat.o(276431);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(276439);
    this.jyM.clear();
    AppMethodBeat.o(276439);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(276445);
    boolean bool = this.jyM.isPlaying();
    AppMethodBeat.o(276445);
    return bool;
  }
  
  public final boolean isStarted()
  {
    return !this.jyM.jxW;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(276430);
    boolean bool = this.jyM.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(276430);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(276434);
    this.jyM.pause();
    AppMethodBeat.o(276434);
  }
  
  public final void quit()
  {
    AppMethodBeat.i(276441);
    this.jyM.quit();
    AppMethodBeat.o(276441);
  }
  
  public final void release()
  {
    AppMethodBeat.i(276442);
    this.jyM.release();
    AppMethodBeat.o(276442);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(276433);
    this.jyM.resume();
    AppMethodBeat.o(276433);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(276437);
    this.jyM.seek(paramLong);
    AppMethodBeat.o(276437);
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