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
  private final com.bumptech.glide.c.b.a.e aCk;
  final j aDc;
  private m<Bitmap> aIj;
  final a aLZ;
  private boolean aMa;
  private boolean aMb;
  private com.bumptech.glide.i<Bitmap> aMc;
  a aMd;
  boolean aMe;
  a aMf;
  Bitmap aMg;
  a aMh;
  final List<b> callbacks;
  private final Handler handler;
  boolean isRunning;
  
  private g(com.bumptech.glide.c.b.a.e parame, j paramj, a parama, com.bumptech.glide.i<Bitmap> parami, m<Bitmap> paramm, Bitmap paramBitmap)
  {
    AppMethodBeat.i(77514);
    this.callbacks = new ArrayList();
    this.aDc = paramj;
    paramj = new Handler(Looper.getMainLooper(), new c());
    this.aCk = parame;
    this.handler = paramj;
    this.aMc = parami;
    this.aLZ = parama;
    a(paramm, paramBitmap);
    AppMethodBeat.o(77514);
  }
  
  g(com.bumptech.glide.c paramc, a parama, int paramInt1, int paramInt2, m<Bitmap> paramm, Bitmap paramBitmap)
  {
    this(paramc.aCk, com.bumptech.glide.c.af(paramc.aCn.getBaseContext()), parama, com.bumptech.glide.c.af(paramc.aCn.getBaseContext()).nO().a(com.bumptech.glide.f.e.a(com.bumptech.glide.c.b.i.aHi).pV().pW().aX(paramInt1, paramInt2)), paramm, paramBitmap);
    AppMethodBeat.i(77513);
    AppMethodBeat.o(77513);
  }
  
  private void pK()
  {
    AppMethodBeat.i(77520);
    if ((!this.isRunning) || (this.aMa))
    {
      AppMethodBeat.o(77520);
      return;
    }
    if (this.aMb) {
      if (this.aMh != null) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      com.bumptech.glide.h.i.checkArgument(bool, "Pending target must be null when starting from the first frame");
      this.aLZ.ob();
      this.aMb = false;
      if (this.aMh == null) {
        break;
      }
      a locala = this.aMh;
      this.aMh = null;
      a(locala);
      AppMethodBeat.o(77520);
      return;
    }
    this.aMa = true;
    int i = this.aLZ.nZ();
    long l1 = SystemClock.uptimeMillis();
    long l2 = i;
    this.aLZ.advance();
    this.aMf = new a(this.handler, this.aLZ.oa(), l2 + l1);
    this.aMc.a(com.bumptech.glide.f.e.e(pM())).Q(this.aLZ).b(this.aMf);
    AppMethodBeat.o(77520);
  }
  
  private static h pM()
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
    this.aMe = false;
    pK();
    AppMethodBeat.o(77519);
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(77522);
    this.aMa = false;
    if (this.aMe)
    {
      this.handler.obtainMessage(2, parama).sendToTarget();
      AppMethodBeat.o(77522);
      return;
    }
    if (!this.isRunning)
    {
      this.aMh = parama;
      AppMethodBeat.o(77522);
      return;
    }
    if (parama.aMj != null)
    {
      pL();
      a locala = this.aMd;
      this.aMd = parama;
      int i = this.callbacks.size() - 1;
      while (i >= 0)
      {
        ((b)this.callbacks.get(i)).pI();
        i -= 1;
      }
      if (locala != null) {
        this.handler.obtainMessage(2, locala).sendToTarget();
      }
    }
    pK();
    AppMethodBeat.o(77522);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(77516);
    if (this.aMe)
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
    this.aIj = ((m)com.bumptech.glide.h.i.checkNotNull(paramm, "Argument must not be null"));
    this.aMg = ((Bitmap)com.bumptech.glide.h.i.checkNotNull(paramBitmap, "Argument must not be null"));
    this.aMc = this.aMc.a(new com.bumptech.glide.f.e().a(paramm));
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
    int i = this.aLZ.getFrameCount();
    AppMethodBeat.o(77518);
    return i;
  }
  
  final Bitmap pJ()
  {
    if (this.aMd != null) {
      return this.aMd.aMj;
    }
    return this.aMg;
  }
  
  final void pL()
  {
    AppMethodBeat.i(77521);
    if (this.aMg != null)
    {
      this.aCk.g(this.aMg);
      this.aMg = null;
    }
    AppMethodBeat.o(77521);
  }
  
  static final class a
    extends com.bumptech.glide.f.a.c<Bitmap>
  {
    private final long aMi;
    Bitmap aMj;
    private final Handler handler;
    final int index;
    
    a(Handler paramHandler, int paramInt, long paramLong)
    {
      this.handler = paramHandler;
      this.index = paramInt;
      this.aMi = paramLong;
    }
  }
  
  public static abstract interface b
  {
    public abstract void pI();
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
        g.this.aDc.c(paramMessage);
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