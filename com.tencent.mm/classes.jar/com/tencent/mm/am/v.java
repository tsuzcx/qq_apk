package com.tencent.mm.am;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.n.a;
import com.tencent.mm.network.s;
import com.tencent.mm.network.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.threadpool.i;

public class v
  extends n.a
{
  private final g dispatcher;
  private final p hEi;
  final MMHandler handler;
  private boolean nzW;
  private final long ouG;
  private s ouH;
  private m ouI;
  private boolean ouJ;
  Runnable ouK;
  private final h queueCallback;
  
  public v(s params, m paramm, p paramp, h paramh, g paramg)
  {
    AppMethodBeat.i(132421);
    this.ouG = 330000L;
    this.nzW = false;
    this.ouJ = false;
    this.ouK = new Runnable()
    {
      public final void run()
      {
        int k = 0;
        int j = 0;
        AppMethodBeat.i(132419);
        int i;
        if ((v.a(v.this)) || (v.b(v.this)))
        {
          if (v.c(v.this) == null)
          {
            i = 0;
            if (v.c(v.this) != null) {
              break label96;
            }
          }
          for (;;)
          {
            Log.e("MicroMsg.RemoteOnGYNetEnd", "time exceed But removeCallbacks failed hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            AppMethodBeat.o(132419);
            return;
            i = v.c(v.this).hashCode();
            break;
            label96:
            j = v.c(v.this).getType();
          }
        }
        final boolean bool1 = v.a(v.this);
        final boolean bool2 = v.b(v.this);
        if (v.c(v.this) == null)
        {
          i = 0;
          if (v.c(v.this) != null) {
            break label247;
          }
        }
        label247:
        for (j = k;; j = v.c(v.this).getType())
        {
          Log.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          v.d(v.this);
          ThreadPool.post(new Runnable()
          {
            public final void run()
            {
              int j = 0;
              AppMethodBeat.i(132418);
              v.e(v.this).Mc("push process's network haven't callback in 5.5min!!!! cancelStatus:" + bool1 + " hasCallbackStatus:" + bool2);
              int i;
              if (v.c(v.this) == null)
              {
                i = 0;
                if (v.c(v.this) != null) {
                  break label129;
                }
              }
              for (;;)
              {
                Log.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback . kill push fin. hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                AppMethodBeat.o(132418);
                return;
                i = v.c(v.this).hashCode();
                break;
                label129:
                j = v.c(v.this).getType();
              }
            }
          }, "RemoteOnGYNetEnd_killPush");
          v.g(v.this).onGYNetEnd(-1, 3, -1, "time exceed, force to callback", v.f(v.this), null);
          AppMethodBeat.o(132419);
          return;
          i = v.c(v.this).hashCode();
          break;
        }
      }
    };
    this.ouH = params;
    this.ouI = paramm;
    this.hEi = paramp;
    this.queueCallback = paramh;
    if (Looper.myLooper() == null) {}
    for (params = new MMHandler(Looper.getMainLooper());; params = new MMHandler())
    {
      this.handler = params;
      this.dispatcher = paramg;
      AppMethodBeat.o(132421);
      return;
    }
  }
  
  public final void a(final int paramInt1, final int paramInt2, final int paramInt3, final String paramString, t paramt, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132423);
    Log.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.nzW), Integer.valueOf(this.hEi.hashCode()), Integer.valueOf(this.ouH.hashCode()) });
    this.hEi.updateDispatchIdNew(-1);
    if (this.nzW)
    {
      AppMethodBeat.o(132423);
      return;
    }
    if (!this.ouJ)
    {
      this.ouJ = true;
      this.handler.removeCallbacks(this.ouK);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132420);
          if (v.a(v.this))
          {
            Log.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", new Object[] { Integer.valueOf(paramInt1) });
            AppMethodBeat.o(132420);
            return;
          }
          int k = paramInt2;
          int m = paramInt3;
          int i = k;
          int j = m;
          if (10016 == z.pCm)
          {
            i = k;
            j = m;
            if (!Util.isNullOrNil(z.pCo))
            {
              Log.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", new Object[] { z.pCo });
              String[] arrayOfString = z.pCo.split(",");
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
                  if (Util.getInt(arrayOfString[0], -1) == v.c(v.this).getType())
                  {
                    k = Util.getInt(arrayOfString[1], 0);
                    j = Util.getInt(arrayOfString[2], 0);
                    i = k;
                    if (k == 999)
                    {
                      Log.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", new Object[] { z.pCo });
                      AppMethodBeat.o(132420);
                      return;
                    }
                  }
                }
              }
            }
          }
          Log.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(v.a(v.this)), Integer.valueOf(v.c(v.this).hashCode()) });
          v.g(v.this).onGYNetEnd(paramInt1, i, j, paramString, v.f(v.this), paramArrayOfByte);
          if ((v.c(v.this).needCheckCallback()) && (!v.c(v.this).hasCallBackToQueue()))
          {
            Log.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", new Object[] { Integer.valueOf(v.c(v.this).getType()) });
            Log.appenderFlush();
            if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
              com.tencent.threadpool.h.ahAA.bk(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(236765);
                  Toast.makeText(MMApplicationContext.getContext(), "the netscene hasn't call callback to onSceneEnd, type:" + v.c(v.this).getType(), 1).show();
                  AppMethodBeat.o(236765);
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
    this.nzW = true;
    this.handler.removeCallbacks(this.ouK);
    AppMethodBeat.o(132422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.am.v
 * JD-Core Version:    0.7.0.1
 */