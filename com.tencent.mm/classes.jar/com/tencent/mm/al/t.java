package com.tencent.mm.al;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.l.a;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class t
  extends l.a
{
  private final e dispatcher;
  private final n dor;
  private final long hOM;
  private q hON;
  private k hOO;
  private boolean hOP;
  Runnable hOQ;
  final ap handler;
  private boolean hjP;
  private final f queueCallback;
  
  public t(q paramq, k paramk, n paramn, f paramf, e parame)
  {
    AppMethodBeat.i(132421);
    this.hOM = 330000L;
    this.hjP = false;
    this.hOP = false;
    this.hOQ = new Runnable()
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
              t.e(t.this).Ds("push process's network haven't callback in 5.5min!!!! cancelStatus:" + bool1 + " hasCallbackStatus:" + bool2);
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
    this.hON = paramq;
    this.hOO = paramk;
    this.dor = paramn;
    this.queueCallback = paramf;
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
    ad.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.hjP), Integer.valueOf(this.dor.hashCode()), Integer.valueOf(this.hON.hashCode()) });
    this.dor.updateDispatchIdNew(-1);
    if (this.hjP)
    {
      AppMethodBeat.o(132423);
      return;
    }
    if (!this.hOP)
    {
      this.hOP = true;
      this.handler.removeCallbacks(this.hOQ);
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
          if (10016 == ac.iON)
          {
            i = k;
            j = m;
            if (!bt.isNullOrNil(ac.iOP))
            {
              ad.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", new Object[] { ac.iOP });
              String[] arrayOfString = ac.iOP.split(",");
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
                      ad.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", new Object[] { ac.iOP });
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
            ad.fku();
            if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE)) {
              h.LTJ.aP(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(189836);
                  Toast.makeText(aj.getContext(), "the netscene hasn't call callback to onSceneEnd, type:" + t.c(t.this).getType(), 1).show();
                  AppMethodBeat.o(189836);
                }
              });
            }
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
    this.hjP = true;
    this.handler.removeCallbacks(this.hOQ);
    AppMethodBeat.o(132422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.t
 * JD-Core Version:    0.7.0.1
 */