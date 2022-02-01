package com.tencent.matrix.trace.tracer;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.b.a.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends g
{
  static com.tencent.matrix.trace.a.b fdo;
  private static HandlerThread fgj;
  static Handler fgk;
  static Runnable fgl;
  
  public d(com.tencent.matrix.trace.a.b paramb)
  {
    fdo = paramb;
  }
  
  public final void onAlive()
  {
    super.onAlive();
    if (fdo.fdG)
    {
      fgj = new HandlerThread("IdleHandlerLagThread");
      fgl = new a();
      try
      {
        if (Build.VERSION.SDK_INT < 23) {
          return;
        }
        MessageQueue localMessageQueue = Looper.getMainLooper().getQueue();
        Field localField = MessageQueue.class.getDeclaredField("mIdleHandlers");
        localField.setAccessible(true);
        localField.set(localMessageQueue, new b());
        fgj.start();
        fgk = new Handler(fgj.getLooper());
        return;
      }
      finally
      {
        com.tencent.matrix.e.c.e("Matrix.IdleHandlerLagTracer", "reflect idle handler error = " + localObject.getMessage(), new Object[0]);
      }
    }
  }
  
  public final void onDead()
  {
    super.onDead();
    if (fdo.fdG) {
      fgk.removeCallbacksAndMessages(null);
    }
  }
  
  static final class a
    implements Runnable
  {
    public final void run()
    {
      try
      {
        com.tencent.matrix.trace.b localb = (com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class);
        if (localb == null) {
          return;
        }
        Object localObject2 = com.tencent.matrix.trace.f.c.aAf();
        boolean bool = com.tencent.matrix.trace.f.a.aAc();
        String str = com.tencent.matrix.a.eLw.eLy;
        JSONObject localJSONObject = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.c.avW().application);
        localJSONObject.put("detail", a.a.feb);
        localJSONObject.put("scene", str);
        localJSONObject.put("threadStack", localObject2);
        localJSONObject.put("isProcessForeground", bool);
        localObject2 = new com.tencent.matrix.report.g();
        ((com.tencent.matrix.report.g)localObject2).tag = "Trace_EvilMethod";
        ((com.tencent.matrix.report.g)localObject2).eYz = localJSONObject;
        localb.onDetectIssue((com.tencent.matrix.report.g)localObject2);
        com.tencent.matrix.e.c.e("Matrix.IdleHandlerLagTracer", "happens idle handler Lag : %s ", new Object[] { localJSONObject.toString() });
        return;
      }
      finally
      {
        com.tencent.matrix.e.c.e("Matrix.IdleHandlerLagTracer", "Matrix error, error = " + localObject1.getMessage(), new Object[0]);
      }
    }
  }
  
  static final class b<T>
    extends ArrayList
  {
    Map<MessageQueue.IdleHandler, d.c> map = new HashMap();
    
    public final boolean add(Object paramObject)
    {
      if ((paramObject instanceof MessageQueue.IdleHandler))
      {
        d.c localc = new d.c((MessageQueue.IdleHandler)paramObject);
        this.map.put((MessageQueue.IdleHandler)paramObject, localc);
        return super.add(localc);
      }
      return super.add(paramObject);
    }
    
    public final boolean remove(Object paramObject)
    {
      if ((paramObject instanceof d.c))
      {
        localObject = d.c.a((d.c)paramObject);
        this.map.remove(localObject);
        return super.remove(paramObject);
      }
      Object localObject = (d.c)this.map.remove(paramObject);
      if (localObject != null) {
        return super.remove(localObject);
      }
      return super.remove(paramObject);
    }
  }
  
  static final class c
    implements MessageQueue.IdleHandler
  {
    private final MessageQueue.IdleHandler fgm;
    
    c(MessageQueue.IdleHandler paramIdleHandler)
    {
      this.fgm = paramIdleHandler;
    }
    
    public final boolean queueIdle()
    {
      d.fgk.postDelayed(d.fgl, d.fdo.fdH);
      boolean bool = this.fgm.queueIdle();
      d.fgk.removeCallbacks(d.fgl);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.tracer.d
 * JD-Core Version:    0.7.0.1
 */