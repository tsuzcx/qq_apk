package com.tencent.mm.al;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.l.a;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class t
  extends l.a
{
  private final n dfA;
  private final e dispatcher;
  private final long gVY;
  private q gVZ;
  private k gWa;
  private boolean gWb;
  Runnable gWc;
  private boolean gqP;
  final ap handler;
  private final g queueCallback;
  
  public t(q paramq, k paramk, n paramn, g paramg, e parame)
  {
    AppMethodBeat.i(132421);
    this.gVY = 330000L;
    this.gqP = false;
    this.gWb = false;
    this.gWc = new Runnable()
    {
      public final void run()
      {
        int k = 0;
        int j = 0;
        AppMethodBeat.i(132419);
        int i;
        if ((t.a(t.this)) || (t.b(t.this)))
        {
          if (t.c(t.this) == null)
          {
            i = 0;
            if (t.c(t.this) != null) {
              break label96;
            }
          }
          for (;;)
          {
            ad.e("MicroMsg.RemoteOnGYNetEnd", "time exceed But removeCallbacks failed hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            AppMethodBeat.o(132419);
            return;
            i = t.c(t.this).hashCode();
            break;
            label96:
            j = t.c(t.this).getType();
          }
        }
        final boolean bool1 = t.a(t.this);
        final boolean bool2 = t.b(t.this);
        if (t.c(t.this) == null)
        {
          i = 0;
          if (t.c(t.this) != null) {
            break label247;
          }
        }
        label247:
        for (j = k;; j = t.c(t.this).getType())
        {
          ad.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          t.d(t.this);
          b.c(new Runnable()
          {
            public final void run()
            {
              int j = 0;
              AppMethodBeat.i(132418);
              t.e(t.this).wn("push process's network haven't callback in 5.5min!!!! cancelStatus:" + bool1 + " hasCallbackStatus:" + bool2);
              int i;
              if (t.c(t.this) == null)
              {
                i = 0;
                if (t.c(t.this) != null) {
                  break label129;
                }
              }
              for (;;)
              {
                ad.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback . kill push fin. hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                AppMethodBeat.o(132418);
                return;
                i = t.c(t.this).hashCode();
                break;
                label129:
                j = t.c(t.this).getType();
              }
            }
          }, "RemoteOnGYNetEnd_killPush");
          t.g(t.this).onGYNetEnd(-1, 3, -1, "time exceed, force to callback", t.f(t.this), null);
          AppMethodBeat.o(132419);
          return;
          i = t.c(t.this).hashCode();
          break;
        }
      }
    };
    this.gVZ = paramq;
    this.gWa = paramk;
    this.dfA = paramn;
    this.queueCallback = paramg;
    if (Looper.myLooper() == null) {}
    for (paramq = new ap(Looper.getMainLooper());; paramq = new ap())
    {
      this.handler = paramq;
      this.dispatcher = parame;
      AppMethodBeat.o(132421);
      return;
    }
  }
  
  public final void a(final int paramInt1, final int paramInt2, final int paramInt3, final String paramString, r paramr, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132423);
    ad.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.gqP), Integer.valueOf(this.dfA.hashCode()), Integer.valueOf(this.gVZ.hashCode()) });
    this.dfA.updateDispatchIdNew(-1);
    if (this.gqP)
    {
      AppMethodBeat.o(132423);
      return;
    }
    if (!this.gWb)
    {
      this.gWb = true;
      this.handler.removeCallbacks(this.gWc);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132420);
          if (t.a(t.this))
          {
            ad.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", new Object[] { Integer.valueOf(paramInt1) });
            AppMethodBeat.o(132420);
            return;
          }
          int k = paramInt2;
          int m = paramInt3;
          int i = k;
          int j = m;
          if (10016 == ab.hVC)
          {
            i = k;
            j = m;
            if (!bt.isNullOrNil(ab.hVE))
            {
              ad.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", new Object[] { ab.hVE });
              String[] arrayOfString = ab.hVE.split(",");
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
                  if (bt.getInt(arrayOfString[0], -1) == t.c(t.this).getType())
                  {
                    k = bt.getInt(arrayOfString[1], 0);
                    j = bt.getInt(arrayOfString[2], 0);
                    i = k;
                    if (k == 999)
                    {
                      ad.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", new Object[] { ab.hVE });
                      AppMethodBeat.o(132420);
                      return;
                    }
                  }
                }
              }
            }
          }
          ad.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(t.a(t.this)), Integer.valueOf(t.c(t.this).hashCode()) });
          t.g(t.this).onGYNetEnd(paramInt1, i, j, paramString, t.f(t.this), paramArrayOfByte);
          if ((t.c(t.this).needCheckCallback()) && (!t.c(t.this).hasCallBackToQueue()))
          {
            ad.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", new Object[] { Integer.valueOf(t.c(t.this).getType()) });
            ad.eFw();
          }
          AppMethodBeat.o(132420);
        }
      });
      AppMethodBeat.o(132423);
      return;
    }
    AppMethodBeat.o(132423);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(132422);
    this.gqP = true;
    this.handler.removeCallbacks(this.gWc);
    AppMethodBeat.o(132422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.t
 * JD-Core Version:    0.7.0.1
 */