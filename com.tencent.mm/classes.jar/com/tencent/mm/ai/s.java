package com.tencent.mm.ai;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.l.a;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class s
  extends l.a
{
  private final m cqE;
  private final e dispatcher;
  private boolean eUJ;
  private final long ftT;
  private q ftU;
  private k ftV;
  private boolean ftW;
  Runnable ftX;
  final ak handler;
  private final f queueCallback;
  
  public s(q paramq, k paramk, m paramm, f paramf, e parame)
  {
    AppMethodBeat.i(58261);
    this.ftT = 330000L;
    this.eUJ = false;
    this.ftW = false;
    this.ftX = new Runnable()
    {
      public final void run()
      {
        int k = 0;
        int j = 0;
        AppMethodBeat.i(58259);
        int i;
        if ((s.a(s.this)) || (s.b(s.this)))
        {
          if (s.c(s.this) == null)
          {
            i = 0;
            if (s.c(s.this) != null) {
              break label96;
            }
          }
          for (;;)
          {
            ab.e("MicroMsg.RemoteOnGYNetEnd", "time exceed But removeCallbacks failed hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            AppMethodBeat.o(58259);
            return;
            i = s.c(s.this).hashCode();
            break;
            label96:
            j = s.c(s.this).getType();
          }
        }
        final boolean bool1 = s.a(s.this);
        final boolean bool2 = s.b(s.this);
        if (s.c(s.this) == null)
        {
          i = 0;
          if (s.c(s.this) != null) {
            break label247;
          }
        }
        label247:
        for (j = k;; j = s.c(s.this).getType())
        {
          ab.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          s.d(s.this);
          d.post(new Runnable()
          {
            public final void run()
            {
              int j = 0;
              AppMethodBeat.i(58258);
              s.e(s.this).rs("push process's network haven't callback in 5.5min!!!! cancelStatus:" + bool1 + " hasCallbackStatus:" + bool2);
              int i;
              if (s.c(s.this) == null)
              {
                i = 0;
                if (s.c(s.this) != null) {
                  break label129;
                }
              }
              for (;;)
              {
                ab.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback . kill push fin. hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                AppMethodBeat.o(58258);
                return;
                i = s.c(s.this).hashCode();
                break;
                label129:
                j = s.c(s.this).getType();
              }
            }
          }, "RemoteOnGYNetEnd_killPush");
          s.g(s.this).onGYNetEnd(-1, 3, -1, "time exceed, force to callback", s.f(s.this), null);
          AppMethodBeat.o(58259);
          return;
          i = s.c(s.this).hashCode();
          break;
        }
      }
    };
    this.ftU = paramq;
    this.ftV = paramk;
    this.cqE = paramm;
    this.queueCallback = paramf;
    if (Looper.myLooper() == null) {}
    for (paramq = new ak(Looper.getMainLooper());; paramq = new ak())
    {
      this.handler = paramq;
      this.dispatcher = parame;
      AppMethodBeat.o(58261);
      return;
    }
  }
  
  public final void a(final int paramInt1, final int paramInt2, final int paramInt3, final String paramString, r paramr, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58263);
    ab.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.eUJ), Integer.valueOf(this.cqE.hashCode()), Integer.valueOf(this.ftU.hashCode()) });
    this.cqE.updateDispatchIdNew(-1);
    if (this.eUJ)
    {
      AppMethodBeat.o(58263);
      return;
    }
    if (!this.ftW)
    {
      this.ftW = true;
      this.handler.removeCallbacks(this.ftX);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(58260);
          if (s.a(s.this))
          {
            ab.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", new Object[] { Integer.valueOf(paramInt1) });
            AppMethodBeat.o(58260);
            return;
          }
          int k = paramInt2;
          int m = paramInt3;
          int i = k;
          int j = m;
          if (10016 == ae.gkK)
          {
            i = k;
            j = m;
            if (!bo.isNullOrNil(ae.gkM))
            {
              ab.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", new Object[] { ae.gkM });
              String[] arrayOfString = ae.gkM.split(",");
              i = k;
              j = m;
              if (arrayOfString != null)
              {
                i = k;
                j = m;
                if (arrayOfString.length == 3)
                {
                  i = k;
                  j = m;
                  if (bo.getInt(arrayOfString[0], -1) == s.c(s.this).getType())
                  {
                    k = bo.getInt(arrayOfString[1], 0);
                    j = bo.getInt(arrayOfString[2], 0);
                    i = k;
                    if (k == 999)
                    {
                      ab.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", new Object[] { ae.gkM });
                      AppMethodBeat.o(58260);
                      return;
                    }
                  }
                }
              }
            }
          }
          ab.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(s.a(s.this)), Integer.valueOf(s.c(s.this).hashCode()) });
          s.g(s.this).onGYNetEnd(paramInt1, i, j, paramString, s.f(s.this), paramArrayOfByte);
          if ((s.c(s.this).needCheckCallback()) && (!s.c(s.this).hasCallBackToQueue()))
          {
            ab.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", new Object[] { Integer.valueOf(s.c(s.this).getType()) });
            ab.dsI();
          }
          AppMethodBeat.o(58260);
        }
      });
      AppMethodBeat.o(58263);
      return;
    }
    AppMethodBeat.o(58263);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(58262);
    this.eUJ = true;
    this.handler.removeCallbacks(this.ftX);
    AppMethodBeat.o(58262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ai.s
 * JD-Core Version:    0.7.0.1
 */