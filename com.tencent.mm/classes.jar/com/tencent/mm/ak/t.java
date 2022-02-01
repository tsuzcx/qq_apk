package com.tencent.mm.ak;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.l.a;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;

public final class t
  extends l.a
{
  private final e dispatcher;
  private final n dpw;
  private final long hRF;
  private q hRG;
  private k hRH;
  private boolean hRI;
  Runnable hRJ;
  final aq handler;
  private boolean hmD;
  private final f queueCallback;
  
  public t(q paramq, k paramk, n paramn, f paramf, e parame)
  {
    AppMethodBeat.i(132421);
    this.hRF = 330000L;
    this.hmD = false;
    this.hRI = false;
    this.hRJ = new Runnable()
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
            ae.e("MicroMsg.RemoteOnGYNetEnd", "time exceed But removeCallbacks failed hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
          ae.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          t.d(t.this);
          b.c(new Runnable()
          {
            public final void run()
            {
              int j = 0;
              AppMethodBeat.i(132418);
              t.e(t.this).DU("push process's network haven't callback in 5.5min!!!! cancelStatus:" + bool1 + " hasCallbackStatus:" + bool2);
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
                ae.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback . kill push fin. hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
    this.hRG = paramq;
    this.hRH = paramk;
    this.dpw = paramn;
    this.queueCallback = paramf;
    if (Looper.myLooper() == null) {}
    for (paramq = new aq(Looper.getMainLooper());; paramq = new aq())
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
    ae.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.hmD), Integer.valueOf(this.dpw.hashCode()), Integer.valueOf(this.hRG.hashCode()) });
    this.dpw.updateDispatchIdNew(-1);
    if (this.hmD)
    {
      AppMethodBeat.o(132423);
      return;
    }
    if (!this.hRI)
    {
      this.hRI = true;
      this.handler.removeCallbacks(this.hRJ);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132420);
          if (t.a(t.this))
          {
            ae.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", new Object[] { Integer.valueOf(paramInt1) });
            AppMethodBeat.o(132420);
            return;
          }
          int k = paramInt2;
          int m = paramInt3;
          int i = k;
          int j = m;
          if (10016 == ac.iRH)
          {
            i = k;
            j = m;
            if (!bu.isNullOrNil(ac.iRJ))
            {
              ae.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", new Object[] { ac.iRJ });
              String[] arrayOfString = ac.iRJ.split(",");
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
                  if (bu.getInt(arrayOfString[0], -1) == t.c(t.this).getType())
                  {
                    k = bu.getInt(arrayOfString[1], 0);
                    j = bu.getInt(arrayOfString[2], 0);
                    i = k;
                    if (k == 999)
                    {
                      ae.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", new Object[] { ac.iRJ });
                      AppMethodBeat.o(132420);
                      return;
                    }
                  }
                }
              }
            }
          }
          ae.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(t.a(t.this)), Integer.valueOf(t.c(t.this).hashCode()) });
          t.g(t.this).onGYNetEnd(paramInt1, i, j, paramString, t.f(t.this), paramArrayOfByte);
          if ((t.c(t.this).needCheckCallback()) && (!t.c(t.this).hasCallBackToQueue()))
          {
            ae.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", new Object[] { Integer.valueOf(t.c(t.this).getType()) });
            ae.foo();
            if ((j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE)) {
              h.MqF.aM(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(193554);
                  Toast.makeText(ak.getContext(), "the netscene hasn't call callback to onSceneEnd, type:" + t.c(t.this).getType(), 1).show();
                  AppMethodBeat.o(193554);
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
    this.hmD = true;
    this.handler.removeCallbacks(this.hRJ);
    AppMethodBeat.o(132422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.t
 * JD-Core Version:    0.7.0.1
 */