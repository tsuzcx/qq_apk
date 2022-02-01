package com.bumptech.glide.load.d.e;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.e.f;
import com.bumptech.glide.f.b;
import com.bumptech.glide.i;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class g
{
  private final com.bumptech.glide.load.b.a.e aCj;
  final com.bumptech.glide.j aDc;
  private l<Bitmap> aId;
  final com.bumptech.glide.b.a aLR;
  private boolean aLS;
  private boolean aLT;
  private i<Bitmap> aLU;
  a aLV;
  boolean aLW;
  a aLX;
  Bitmap aLY;
  a aLZ;
  final List<b> callbacks;
  private final Handler handler;
  boolean isRunning;
  
  g(com.bumptech.glide.c paramc, com.bumptech.glide.b.a parama, int paramInt1, int paramInt2, l<Bitmap> paraml, Bitmap paramBitmap)
  {
    this(paramc.aCj, com.bumptech.glide.c.ag(paramc.aCm.getBaseContext()), parama, com.bumptech.glide.c.ag(paramc.aCm.getBaseContext()).nT().a(((f)((f)f.b(com.bumptech.glide.load.b.j.aHa).pW()).pX()).aR(paramInt1, paramInt2)), paraml, paramBitmap);
    AppMethodBeat.i(77513);
    AppMethodBeat.o(77513);
  }
  
  private g(com.bumptech.glide.load.b.a.e parame, com.bumptech.glide.j paramj, com.bumptech.glide.b.a parama, i<Bitmap> parami, l<Bitmap> paraml, Bitmap paramBitmap)
  {
    AppMethodBeat.i(77514);
    this.callbacks = new ArrayList();
    this.aDc = paramj;
    paramj = new Handler(Looper.getMainLooper(), new c());
    this.aCj = parame;
    this.handler = paramj;
    this.aLU = parami;
    this.aLR = parama;
    a(paraml, paramBitmap);
    AppMethodBeat.o(77514);
  }
  
  private void pP()
  {
    AppMethodBeat.i(77520);
    if ((!this.isRunning) || (this.aLS))
    {
      AppMethodBeat.o(77520);
      return;
    }
    if (this.aLT) {
      if (this.aLZ != null) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      com.bumptech.glide.g.j.checkArgument(bool, "Pending target must be null when starting from the first frame");
      this.aLR.oh();
      this.aLT = false;
      if (this.aLZ == null) {
        break;
      }
      a locala = this.aLZ;
      this.aLZ = null;
      a(locala);
      AppMethodBeat.o(77520);
      return;
    }
    this.aLS = true;
    int i = this.aLR.of();
    long l1 = SystemClock.uptimeMillis();
    long l2 = i;
    this.aLR.advance();
    this.aLX = new a(this.handler, this.aLR.og(), l2 + l1);
    this.aLU.a(f.g(pR())).Q(this.aLR).b(this.aLX);
    AppMethodBeat.o(77520);
  }
  
  private static com.bumptech.glide.load.g pR()
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
    this.aLW = false;
    pP();
    AppMethodBeat.o(77519);
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(77522);
    this.aLS = false;
    if (this.aLW)
    {
      this.handler.obtainMessage(2, parama).sendToTarget();
      AppMethodBeat.o(77522);
      return;
    }
    if (!this.isRunning)
    {
      this.aLZ = parama;
      AppMethodBeat.o(77522);
      return;
    }
    if (parama.aMb != null)
    {
      pQ();
      a locala = this.aLV;
      this.aLV = parama;
      int i = this.callbacks.size() - 1;
      while (i >= 0)
      {
        ((b)this.callbacks.get(i)).pN();
        i -= 1;
      }
      if (locala != null) {
        this.handler.obtainMessage(2, locala).sendToTarget();
      }
    }
    pP();
    AppMethodBeat.o(77522);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(77516);
    if (this.aLW)
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
  
  final void a(l<Bitmap> paraml, Bitmap paramBitmap)
  {
    AppMethodBeat.i(77515);
    this.aId = ((l)com.bumptech.glide.g.j.checkNotNull(paraml, "Argument must not be null"));
    this.aLY = ((Bitmap)com.bumptech.glide.g.j.checkNotNull(paramBitmap, "Argument must not be null"));
    this.aLU = this.aLU.a(new f().a(paraml));
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
    int i = this.aLR.getFrameCount();
    AppMethodBeat.o(77518);
    return i;
  }
  
  final Bitmap pO()
  {
    if (this.aLV != null) {
      return this.aLV.aMb;
    }
    return this.aLY;
  }
  
  final void pQ()
  {
    AppMethodBeat.i(77521);
    if (this.aLY != null)
    {
      this.aCj.g(this.aLY);
      this.aLY = null;
    }
    AppMethodBeat.o(77521);
  }
  
  static final class a
    extends com.bumptech.glide.e.a.c<Bitmap>
  {
    private final long aMa;
    Bitmap aMb;
    private final Handler handler;
    final int index;
    
    a(Handler paramHandler, int paramInt, long paramLong)
    {
      this.handler = paramHandler;
      this.index = paramInt;
      this.aMa = paramLong;
    }
  }
  
  public static abstract interface b
  {
    public abstract void pN();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.e.g
 * JD-Core Version:    0.7.0.1
 */