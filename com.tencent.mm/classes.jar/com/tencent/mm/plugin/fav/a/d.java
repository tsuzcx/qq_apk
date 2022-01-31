package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
{
  private static d jYy = null;
  private long endTime = -1L;
  private boolean gDQ = false;
  private Runnable jYA = new d.1(this);
  public ArrayList<d.a> jYx = new ArrayList();
  private Object jYz = new Object();
  ah mHandler = new ah(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      paramAnonymousMessage = d.this.jYx.iterator();
      while (paramAnonymousMessage.hasNext())
      {
        d.a locala = (d.a)paramAnonymousMessage.next();
        if (locala != null) {
          locala.onFinish();
        }
      }
      d.this.jYx.clear();
    }
  };
  private long startTime = -1L;
  
  public static d aPV()
  {
    try
    {
      if (jYy == null) {
        jYy = new d();
      }
      d locald = jYy;
      return locald;
    }
    finally {}
  }
  
  public final void a(d.a parama)
  {
    synchronized (this.jYz)
    {
      if (((Boolean)g.DP().Dz().get(ac.a.uqz, Boolean.valueOf(false))).booleanValue())
      {
        if (parama != null) {
          parama.onFinish();
        }
        return;
      }
      if (parama != null) {
        this.jYx.add(parama);
      }
      if (this.gDQ)
      {
        y.i("MicroMsg.FavCleanFirstLoader", "isLoading is true, ignore");
        return;
      }
    }
    this.gDQ = true;
    this.startTime = System.currentTimeMillis();
    com.tencent.mm.sdk.f.e.post(this.jYA, "FavCleanFirstLoader_CalFavDataLength");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.d
 * JD-Core Version:    0.7.0.1
 */