package com.tencent.mm.ah;

import android.os.HandlerThread;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.e.a;

public final class w
{
  public static b een = null;
  
  public static boolean Lo()
  {
    if (een == null)
    {
      y.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      return false;
    }
    if (een.Dl() == null)
    {
      y.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      return false;
    }
    return true;
  }
  
  public static b a(b paramb, a parama)
  {
    a(paramb, parama, false, null);
    return paramb;
  }
  
  public static m a(b paramb, a parama, boolean paramBoolean)
  {
    return a(paramb, parama, paramBoolean, null);
  }
  
  public static m a(b paramb, final a parama, final boolean paramBoolean, com.tencent.mm.vending.e.b paramb1)
  {
    c localc = new c(parama);
    if (parama == null) {}
    for (parama = null;; parama = localc)
    {
      if ((paramb1 != null) && (parama != null)) {
        paramb1.keep(parama);
      }
      if (een == null) {
        y.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      }
      do
      {
        for (;;)
        {
          return null;
          if (een.Dl() == null)
          {
            y.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
          }
          else
          {
            if (paramb != null) {
              break;
            }
            y.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
          }
        }
        paramb = new m()
        {
          private k ecC = new k()
          {
            public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String, q paramAnonymous2q, byte[] paramAnonymous2ArrayOfByte)
            {
              if (w.1.this.eeq != 2)
              {
                w.1.this.eer.stopTimer();
                w.1.this.eeq = 1;
                w.a(w.1.this.eet, w.1.this.eeu, paramAnonymous2Int2, paramAnonymous2Int3, paramAnonymous2String, w.1.this.ees, w.1.this.eep);
              }
              for (;;)
              {
                w.1.this.eeo.onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, paramAnonymous2String, w.1.this.eep);
                y.i("MicroMsg.RunCgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[] { Integer.valueOf(w.1.this.eep.hashCode()), Integer.valueOf(w.1.this.getType()), Long.valueOf(bk.UY() - w.1.this.startTime), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3), paramAnonymous2String });
                return;
                y.w("MicroMsg.RunCgi", "Has been callback by protect:%d func:%d time:%d [%d,%d,%s]", new Object[] { Integer.valueOf(w.1.this.eep.hashCode()), Integer.valueOf(w.1.this.getType()), Long.valueOf(bk.UY() - w.1.this.startTime), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3), paramAnonymous2String });
              }
            }
          };
          f eeo = null;
          final m eep = this;
          int eeq = 0;
          am eer = new am(w.een.Dl().edy.mnU.getLooper(), new am.a()
          {
            public final boolean tC()
            {
              y.w("MicroMsg.RunCgi", "Warning: Never should go here. usr canceled:%b Or NetsceneQueue Not call onGYNetEnd! %d func:%d time:%d", new Object[] { Boolean.valueOf(w.1.this.eep.aSd), Integer.valueOf(w.1.this.eep.hashCode()), Integer.valueOf(w.1.this.getType()), Long.valueOf(bk.UY() - w.1.this.startTime) });
              if (w.1.this.eep.aSd) {}
              while (w.1.this.eeq == 1) {
                return false;
              }
              w.1.this.eeq = 2;
              w.a(w.1.this.eet, w.1.this.eeu, 3, -1, "", w.1.this.ees, w.1.this.eep);
              return false;
            }
            
            public final String toString()
            {
              return super.toString() + "|protectNotCallback";
            }
          }, false);
          final long startTime = bk.UY();
          
          public final int a(e paramAnonymouse, f paramAnonymousf)
          {
            this.eeo = paramAnonymousf;
            int i = a(paramAnonymouse, this.ees, this.ecC);
            y.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.eep.hashCode()), Integer.valueOf(this.ees.ecG), Integer.valueOf(i), Long.valueOf(bk.UY() - this.startTime) });
            if (parama != null)
            {
              if (i < 0) {
                w.a(paramBoolean, parama, 3, -1, "", this.ees, this.eep);
              }
            }
            else {
              return i;
            }
            this.eer.S(60000L, 60000L);
            return i;
          }
          
          public final int getType()
          {
            return this.ees.ecG;
          }
        };
      } while (!een.Dl().a(paramb, 0));
      return paramb;
    }
  }
  
  public static b b(b paramb)
  {
    a(paramb, null, false, null);
    return paramb;
  }
  
  public static abstract interface a
  {
    public abstract int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm);
  }
  
  public static abstract interface b
  {
    public abstract p Dl();
  }
  
  private static final class c
    implements w.a, a
  {
    private w.a eex;
    
    public c(w.a parama)
    {
      this.eex = parama;
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
    {
      if (this.eex != null) {
        return this.eex.a(paramInt1, paramInt2, paramString, paramb, paramm);
      }
      return -100000;
    }
    
    public final void dead()
    {
      this.eex = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.w
 * JD-Core Version:    0.7.0.1
 */