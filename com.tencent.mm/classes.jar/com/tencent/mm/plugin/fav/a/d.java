package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
{
  private static d rAv = null;
  private long endTime;
  private boolean lpM;
  aq mHandler;
  public ArrayList<a> rAu;
  private Object rAw;
  private Runnable rAx;
  private long startTime;
  
  private d()
  {
    AppMethodBeat.i(103365);
    this.lpM = false;
    this.rAu = new ArrayList();
    this.startTime = -1L;
    this.endTime = -1L;
    this.rAw = new Object();
    this.rAx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103363);
        ((af)g.ad(af.class)).getFavItemInfoStorage().cwU();
        d.a(d.this, System.currentTimeMillis());
        ae.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", new Object[] { Long.valueOf(d.a(d.this) - d.b(d.this)) });
        d.a(d.this, -1L);
        d.c(d.this);
        synchronized (d.d(d.this))
        {
          g.ajR().ajA().set(am.a.INy, Boolean.TRUE);
          d.e(d.this);
          d.this.mHandler.sendEmptyMessage(0);
          AppMethodBeat.o(103363);
          return;
        }
      }
    };
    this.mHandler = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(103364);
        paramAnonymousMessage = d.this.rAu.iterator();
        while (paramAnonymousMessage.hasNext())
        {
          d.a locala = (d.a)paramAnonymousMessage.next();
          if (locala != null) {
            locala.onFinish();
          }
        }
        d.this.rAu.clear();
        AppMethodBeat.o(103364);
      }
    };
    AppMethodBeat.o(103365);
  }
  
  public static d cwp()
  {
    try
    {
      AppMethodBeat.i(103366);
      if (rAv == null) {
        rAv = new d();
      }
      d locald = rAv;
      AppMethodBeat.o(103366);
      return locald;
    }
    finally {}
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(103367);
    synchronized (this.rAw)
    {
      if (((Boolean)g.ajR().ajA().get(am.a.INy, Boolean.FALSE)).booleanValue())
      {
        if (parama != null) {
          parama.onFinish();
        }
        AppMethodBeat.o(103367);
        return;
      }
      if (parama != null) {
        this.rAu.add(parama);
      }
      if (this.lpM)
      {
        ae.i("MicroMsg.FavCleanFirstLoader", "isLoading is true, ignore");
        AppMethodBeat.o(103367);
        return;
      }
      this.lpM = true;
      this.startTime = System.currentTimeMillis();
      b.c(this.rAx, "FavCleanFirstLoader_CalFavDataLength");
      AppMethodBeat.o(103367);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.d
 * JD-Core Version:    0.7.0.1
 */