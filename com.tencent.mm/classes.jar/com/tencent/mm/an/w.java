package com.tencent.mm.an;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.n.a;
import com.tencent.mm.network.s;
import com.tencent.mm.network.t;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;

public class w
  extends n.a
{
  private final g dispatcher;
  private final q fzz;
  final MMHandler handler;
  private boolean kUn;
  private final long lCV;
  private s lCW;
  private m lCX;
  private boolean lCY;
  Runnable lCZ;
  private final i queueCallback;
  
  public w(s params, m paramm, q paramq, i parami, g paramg)
  {
    AppMethodBeat.i(132421);
    this.lCV = 330000L;
    this.kUn = false;
    this.lCY = false;
    this.lCZ = new Runnable()
    {
      public final void run()
      {
        int k = 0;
        int j = 0;
        AppMethodBeat.i(132419);
        int i;
        if ((w.a(w.this)) || (w.b(w.this)))
        {
          if (w.c(w.this) == null)
          {
            i = 0;
            if (w.c(w.this) != null) {
              break label96;
            }
          }
          for (;;)
          {
            Log.e("MicroMsg.RemoteOnGYNetEnd", "time exceed But removeCallbacks failed hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            AppMethodBeat.o(132419);
            return;
            i = w.c(w.this).hashCode();
            break;
            label96:
            j = w.c(w.this).getType();
          }
        }
        final boolean bool1 = w.a(w.this);
        final boolean bool2 = w.b(w.this);
        if (w.c(w.this) == null)
        {
          i = 0;
          if (w.c(w.this) != null) {
            break label247;
          }
        }
        label247:
        for (j = k;; j = w.c(w.this).getType())
        {
          Log.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          w.d(w.this);
          ThreadPool.post(new Runnable()
          {
            public final void run()
            {
              int j = 0;
              AppMethodBeat.i(132418);
              w.e(w.this).Ud("push process's network haven't callback in 5.5min!!!! cancelStatus:" + bool1 + " hasCallbackStatus:" + bool2);
              int i;
              if (w.c(w.this) == null)
              {
                i = 0;
                if (w.c(w.this) != null) {
                  break label129;
                }
              }
              for (;;)
              {
                Log.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback . kill push fin. hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                AppMethodBeat.o(132418);
                return;
                i = w.c(w.this).hashCode();
                break;
                label129:
                j = w.c(w.this).getType();
              }
            }
          }, "RemoteOnGYNetEnd_killPush");
          w.g(w.this).onGYNetEnd(-1, 3, -1, "time exceed, force to callback", w.f(w.this), null);
          AppMethodBeat.o(132419);
          return;
          i = w.c(w.this).hashCode();
          break;
        }
      }
    };
    this.lCW = params;
    this.lCX = paramm;
    this.fzz = paramq;
    this.queueCallback = parami;
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
    Log.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.kUn), Integer.valueOf(this.fzz.hashCode()), Integer.valueOf(this.lCW.hashCode()) });
    this.fzz.updateDispatchIdNew(-1);
    if (this.kUn)
    {
      AppMethodBeat.o(132423);
      return;
    }
    if (!this.lCY)
    {
      this.lCY = true;
      this.handler.removeCallbacks(this.lCZ);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132420);
          if (w.a(w.this))
          {
            Log.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", new Object[] { Integer.valueOf(paramInt1) });
            AppMethodBeat.o(132420);
            return;
          }
          int k = paramInt2;
          int m = paramInt3;
          int i = k;
          int j = m;
          if (10016 == ac.mFM)
          {
            i = k;
            j = m;
            if (!Util.isNullOrNil(ac.mFO))
            {
              Log.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", new Object[] { ac.mFO });
              String[] arrayOfString = ac.mFO.split(",");
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
                  if (Util.getInt(arrayOfString[0], -1) == w.c(w.this).getType())
                  {
                    k = Util.getInt(arrayOfString[1], 0);
                    j = Util.getInt(arrayOfString[2], 0);
                    i = k;
                    if (k == 999)
                    {
                      Log.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", new Object[] { ac.mFO });
                      AppMethodBeat.o(132420);
                      return;
                    }
                  }
                }
              }
            }
          }
          Log.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(w.a(w.this)), Integer.valueOf(w.c(w.this).hashCode()) });
          w.g(w.this).onGYNetEnd(paramInt1, i, j, paramString, w.f(w.this), paramArrayOfByte);
          if ((w.c(w.this).needCheckCallback()) && (!w.c(w.this).hasCallBackToQueue()))
          {
            Log.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", new Object[] { Integer.valueOf(w.c(w.this).getType()) });
            Log.appenderFlush();
            if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
              h.ZvG.bc(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(196647);
                  Toast.makeText(MMApplicationContext.getContext(), "the netscene hasn't call callback to onSceneEnd, type:" + w.c(w.this).getType(), 1).show();
                  AppMethodBeat.o(196647);
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
    this.kUn = true;
    this.handler.removeCallbacks(this.lCZ);
    AppMethodBeat.o(132422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.an.w
 * JD-Core Version:    0.7.0.1
 */