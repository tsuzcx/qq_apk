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
  final j aAr;
  private m<Bitmap> aFC;
  a aJA;
  final a aJs;
  private boolean aJt;
  private boolean aJu;
  private com.bumptech.glide.i<Bitmap> aJv;
  a aJw;
  boolean aJx;
  a aJy;
  Bitmap aJz;
  private final com.bumptech.glide.c.b.a.e azz;
  final List<b> callbacks;
  private final Handler handler;
  boolean isRunning;
  
  private g(com.bumptech.glide.c.b.a.e parame, j paramj, a parama, com.bumptech.glide.i<Bitmap> parami, m<Bitmap> paramm, Bitmap paramBitmap)
  {
    AppMethodBeat.i(77514);
    this.callbacks = new ArrayList();
    this.aAr = paramj;
    paramj = new Handler(Looper.getMainLooper(), new c());
    this.azz = parame;
    this.handler = paramj;
    this.aJv = parami;
    this.aJs = parama;
    a(paramm, paramBitmap);
    AppMethodBeat.o(77514);
  }
  
  g(com.bumptech.glide.c paramc, a parama, int paramInt1, int paramInt2, m<Bitmap> paramm, Bitmap paramBitmap)
  {
    this(paramc.azz, com.bumptech.glide.c.ad(paramc.azC.getBaseContext()), parama, com.bumptech.glide.c.ad(paramc.azC.getBaseContext()).nm().a(com.bumptech.glide.f.e.a(com.bumptech.glide.c.b.i.aEB).pt().pu().aW(paramInt1, paramInt2)), paramm, paramBitmap);
    AppMethodBeat.i(77513);
    AppMethodBeat.o(77513);
  }
  
  private void pi()
  {
    AppMethodBeat.i(77520);
    if ((!this.isRunning) || (this.aJt))
    {
      AppMethodBeat.o(77520);
      return;
    }
    if (this.aJu) {
      if (this.aJA != null) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      com.bumptech.glide.h.i.checkArgument(bool, "Pending target must be null when starting from the first frame");
      this.aJs.nz();
      this.aJu = false;
      if (this.aJA == null) {
        break;
      }
      a locala = this.aJA;
      this.aJA = null;
      a(locala);
      AppMethodBeat.o(77520);
      return;
    }
    this.aJt = true;
    int i = this.aJs.nx();
    long l1 = SystemClock.uptimeMillis();
    long l2 = i;
    this.aJs.advance();
    this.aJy = new a(this.handler, this.aJs.ny(), l2 + l1);
    this.aJv.a(com.bumptech.glide.f.e.e(pk())).N(this.aJs).b(this.aJy);
    AppMethodBeat.o(77520);
  }
  
  private static h pk()
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
    this.aJx = false;
    pi();
    AppMethodBeat.o(77519);
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(77522);
    this.aJt = false;
    if (this.aJx)
    {
      this.handler.obtainMessage(2, parama).sendToTarget();
      AppMethodBeat.o(77522);
      return;
    }
    if (!this.isRunning)
    {
      this.aJA = parama;
      AppMethodBeat.o(77522);
      return;
    }
    if (parama.aJC != null)
    {
      pj();
      a locala = this.aJw;
      this.aJw = parama;
      int i = this.callbacks.size() - 1;
      while (i >= 0)
      {
        ((b)this.callbacks.get(i)).pg();
        i -= 1;
      }
      if (locala != null) {
        this.handler.obtainMessage(2, locala).sendToTarget();
      }
    }
    pi();
    AppMethodBeat.o(77522);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(77516);
    if (this.aJx)
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
    this.aFC = ((m)com.bumptech.glide.h.i.checkNotNull(paramm, "Argument must not be null"));
    this.aJz = ((Bitmap)com.bumptech.glide.h.i.checkNotNull(paramBitmap, "Argument must not be null"));
    this.aJv = this.aJv.a(new com.bumptech.glide.f.e().a(paramm));
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
    int i = this.aJs.getFrameCount();
    AppMethodBeat.o(77518);
    return i;
  }
  
  final Bitmap ph()
  {
    if (this.aJw != null) {
      return this.aJw.aJC;
    }
    return this.aJz;
  }
  
  final void pj()
  {
    AppMethodBeat.i(77521);
    if (this.aJz != null)
    {
      this.azz.g(this.aJz);
      this.aJz = null;
    }
    AppMethodBeat.o(77521);
  }
  
  static final class a
    extends com.bumptech.glide.f.a.c<Bitmap>
  {
    private final long aJB;
    Bitmap aJC;
    private final Handler handler;
    final int index;
    
    a(Handler paramHandler, int paramInt, long paramLong)
    {
      this.handler = paramHandler;
      this.index = paramInt;
      this.aJB = paramLong;
    }
  }
  
  public static abstract interface b
  {
    public abstract void pg();
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
        g.this.aAr.c(paramMessage);
      }
      AppMethodBeat.o(77512);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.d.e.g
 * JD-Core Version:    0.7.0.1
 */