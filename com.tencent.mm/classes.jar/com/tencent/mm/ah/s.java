package com.tencent.mm.ah;

import android.os.Looper;
import com.tencent.mm.network.k;
import com.tencent.mm.network.l.a;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class s
  extends l.a
{
  private final m bJk;
  private final long edQ = 330000L;
  private q edR;
  private k edS;
  private boolean edT = false;
  private boolean edU = false;
  Runnable edV = new Runnable()
  {
    public final void run()
    {
      int k = 0;
      int j = 0;
      int i;
      if ((s.a(s.this)) || (s.b(s.this)))
      {
        if (s.c(s.this) == null)
        {
          i = 0;
          if (s.c(s.this) != null) {
            break label86;
          }
        }
        for (;;)
        {
          y.e("MicroMsg.RemoteOnGYNetEnd", "time exceed But removeCallbacks failed hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          return;
          i = s.c(s.this).hashCode();
          break;
          label86:
          j = s.c(s.this).getType();
        }
      }
      final boolean bool1 = s.a(s.this);
      final boolean bool2 = s.b(s.this);
      if (s.c(s.this) == null)
      {
        i = 0;
        if (s.c(s.this) != null) {
          break label232;
        }
      }
      label232:
      for (j = k;; j = s.c(s.this).getType())
      {
        y.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        s.d(s.this);
        com.tencent.mm.sdk.f.e.post(new Runnable()
        {
          public final void run()
          {
            int j = 0;
            s.e(s.this).ku("push process's network haven't callback in 5.5min!!!! cancelStatus:" + bool1 + " hasCallbackStatus:" + bool2);
            int i;
            if (s.c(s.this) == null)
            {
              i = 0;
              if (s.c(s.this) != null) {
                break label119;
              }
            }
            for (;;)
            {
              y.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback . kill push fin. hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
              return;
              i = s.c(s.this).hashCode();
              break;
              label119:
              j = s.c(s.this).getType();
            }
          }
        }, "RemoteOnGYNetEnd_killPush");
        s.g(s.this).a(-1, 3, -1, "time exceed, force to callback", s.f(s.this), null);
        return;
        i = s.c(s.this).hashCode();
        break;
      }
    }
  };
  private final com.tencent.mm.network.e edc;
  private final f edg;
  final ah handler;
  
  public s(q paramq, k paramk, m paramm, f paramf, com.tencent.mm.network.e parame)
  {
    this.edR = paramq;
    this.edS = paramk;
    this.bJk = paramm;
    this.edg = paramf;
    if (Looper.myLooper() == null) {}
    for (paramq = new ah(Looper.getMainLooper());; paramq = new ah())
    {
      this.handler = paramq;
      this.edc = parame;
      return;
    }
  }
  
  public final void a(final int paramInt1, final int paramInt2, final int paramInt3, final String paramString, r paramr, final byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.edT), Integer.valueOf(this.bJk.hashCode()), Integer.valueOf(this.edR.hashCode()) });
    this.bJk.ede = -1;
    if (this.edT) {}
    while (this.edU) {
      return;
    }
    this.edU = true;
    this.handler.removeCallbacks(this.edV);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        if (s.a(s.this)) {
          y.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", new Object[] { Integer.valueOf(paramInt1) });
        }
        do
        {
          return;
          int k = paramInt2;
          int m = paramInt3;
          int i = k;
          int j = m;
          if (10016 == ae.eSP)
          {
            i = k;
            j = m;
            if (!bk.bl(ae.eSR))
            {
              y.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", new Object[] { ae.eSR });
              String[] arrayOfString = ae.eSR.split(",");
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
                  if (bk.getInt(arrayOfString[0], -1) == s.c(s.this).getType())
                  {
                    k = bk.getInt(arrayOfString[1], 0);
                    j = bk.getInt(arrayOfString[2], 0);
                    i = k;
                    if (k == 999)
                    {
                      y.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", new Object[] { ae.eSR });
                      return;
                    }
                  }
                }
              }
            }
          }
          y.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(s.a(s.this)), Integer.valueOf(s.c(s.this).hashCode()) });
          s.g(s.this).a(paramInt1, i, j, paramString, s.f(s.this), paramArrayOfByte);
        } while ((!s.c(s.this).KA()) || (s.c(s.this).edh));
        y.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", new Object[] { Integer.valueOf(s.c(s.this).getType()) });
        y.cqL();
      }
    });
  }
  
  public final void cancel()
  {
    this.edT = true;
    this.handler.removeCallbacks(this.edV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.s
 * JD-Core Version:    0.7.0.1
 */