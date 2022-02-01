package com.bumptech.glide.c.d.e;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.b.a;
import com.bumptech.glide.c.h;
import com.bumptech.glide.c.m;
import com.bumptech.glide.g.b;
import com.bumptech.glide.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class g
{
  private final com.bumptech.glide.c.b.a.e aAt;
  final j aBl;
  private m<Bitmap> aGs;
  final a aKi;
  private boolean aKj;
  private boolean aKk;
  private com.bumptech.glide.i<Bitmap> aKl;
  a aKm;
  boolean aKn;
  a aKo;
  Bitmap aKp;
  a aKq;
  final List<b> callbacks;
  private final Handler handler;
  boolean isRunning;
  
  private g(com.bumptech.glide.c.b.a.e parame, j paramj, a parama, com.bumptech.glide.i<Bitmap> parami, m<Bitmap> paramm, Bitmap paramBitmap)
  {
    AppMethodBeat.i(77514);
    this.callbacks = new ArrayList();
    this.aBl = paramj;
    paramj = new Handler(Looper.getMainLooper(), new c());
    this.aAt = parame;
    this.handler = paramj;
    this.aKl = parami;
    this.aKi = parama;
    a(paramm, paramBitmap);
    AppMethodBeat.o(77514);
  }
  
  g(com.bumptech.glide.c paramc, a parama, int paramInt1, int paramInt2, m<Bitmap> paramm, Bitmap paramBitmap)
  {
    this(paramc.aAt, com.bumptech.glide.c.ae(paramc.aAw.getBaseContext()), parama, com.bumptech.glide.c.ae(paramc.aAw.getBaseContext()).nw().a(com.bumptech.glide.f.e.a(com.bumptech.glide.c.b.i.aFr).pD().pE().aW(paramInt1, paramInt2)), paramm, paramBitmap);
    AppMethodBeat.i(77513);
    AppMethodBeat.o(77513);
  }
  
  private void ps()
  {
    AppMethodBeat.i(77520);
    if ((!this.isRunning) || (this.aKj))
    {
      AppMethodBeat.o(77520);
      return;
    }
    if (this.aKk) {
      if (this.aKq != null) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      com.bumptech.glide.h.i.checkArgument(bool, "Pending target must be null when starting from the first frame");
      this.aKi.nJ();
      this.aKk = false;
      if (this.aKq == null) {
        break;
      }
      a locala = this.aKq;
      this.aKq = null;
      a(locala);
      AppMethodBeat.o(77520);
      return;
    }
    this.aKj = true;
    int i = this.aKi.nH();
    long l1 = SystemClock.uptimeMillis();
    long l2 = i;
    this.aKi.advance();
    this.aKo = new a(this.handler, this.aKi.nI(), l2 + l1);
    this.aKl.a(com.bumptech.glide.f.e.e(pu())).P(this.aKi).b(this.aKo);
    AppMethodBeat.o(77520);
  }
  
  private static h pu()
  {
    AppMethodBeat.i(77523);
    b localb = new b(Double.valueOf(Math.random()));
    AppMethodBeat.o(77523);
    return localb;
  }
  
  private void start()
  {
    AppMethodBeat.i(77519);
    if (this.isRunning)
    {
      AppMethodBeat.o(77519);
      return;
    }
    this.isRunning = true;
    this.aKn = false;
    ps();
    AppMethodBeat.o(77519);
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(77522);
    this.aKj = false;
    if (this.aKn)
    {
      this.handler.obtainMessage(2, parama).sendToTarget();
      AppMethodBeat.o(77522);
      return;
    }
    if (!this.isRunning)
    {
      this.aKq = parama;
      AppMethodBeat.o(77522);
      return;
    }
    if (parama.aKs != null)
    {
      pt();
      a locala = this.aKm;
      this.aKm = parama;
      int i = this.callbacks.size() - 1;
      while (i >= 0)
      {
        ((b)this.callbacks.get(i)).pq();
        i -= 1;
      }
      if (locala != null) {
        this.handler.obtainMessage(2, locala).sendToTarget();
      }
    }
    ps();
    AppMethodBeat.o(77522);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(77516);
    if (this.aKn)
    {
      paramb = new IllegalStateException("Cannot subscribe to a cleared frame loader");
      AppMethodBeat.o(77516);
      throw paramb;
    }
    if (this.callbacks.contains(paramb))
    {
      paramb = new IllegalStateException("Cannot subscribe twice in a row");
      AppMethodBeat.o(77516);
      throw paramb;
    }
    boolean bool = this.callbacks.isEmpty();
    this.callbacks.add(paramb);
    if (bool) {
      start();
    }
    AppMethodBeat.o(77516);
  }
  
  final void a(m<Bitmap> paramm, Bitmap paramBitmap)
  {
    AppMethodBeat.i(77515);
    this.aGs = ((m)com.bumptech.glide.h.i.checkNotNull(paramm, "Argument must not be null"));
    this.aKp = ((Bitmap)com.bumptech.glide.h.i.checkNotNull(paramBitmap, "Argument must not be null"));
    this.aKl = this.aKl.a(new com.bumptech.glide.f.e().a(paramm));
    AppMethodBeat.o(77515);
  }
  
  final void b(b paramb)
  {
    AppMethodBeat.i(77517);
    this.callbacks.remove(paramb);
    if (this.callbacks.isEmpty()) {
      this.isRunning = false;
    }
    AppMethodBeat.o(77517);
  }
  
  final int getFrameCount()
  {
    AppMethodBeat.i(77518);
    int i = this.aKi.getFrameCount();
    AppMethodBeat.o(77518);
    return i;
  }
  
  final Bitmap pr()
  {
    if (this.aKm != null) {
      return this.aKm.aKs;
    }
    return this.aKp;
  }
  
  final void pt()
  {
    AppMethodBeat.i(77521);
    if (this.aKp != null)
    {
      this.aAt.g(this.aKp);
      this.aKp = null;
    }
    AppMethodBeat.o(77521);
  }
  
  static final class a
    extends com.bumptech.glide.f.a.c<Bitmap>
  {
    private final long aKr;
    Bitmap aKs;
    private final Handler handler;
    final int index;
    
    a(Handler paramHandler, int paramInt, long paramLong)
    {
      this.handler = paramHandler;
      this.index = paramInt;
      this.aKr = paramLong;
    }
  }
  
  public static abstract interface b
  {
    public abstract void pq();
  }
  
  final class c
    implements Handler.Callback
  {
    c() {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(77512);
      if (paramMessage.what == 1)
      {
        paramMessage = (g.a)paramMessage.obj;
        g.this.a(paramMessage);
        AppMethodBeat.o(77512);
        return true;
      }
      if (paramMessage.what == 2)
      {
        paramMessage = (g.a)paramMessage.obj;
        g.this.aBl.c(paramMessage);
      }
      AppMethodBeat.o(77512);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.e.g
 * JD-Core Version:    0.7.0.1
 */