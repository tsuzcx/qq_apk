package com.tencent.matrix.dice;

import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class a
  implements Runnable
{
  public static final a eUy = new a();
  private IListener<se> eUA;
  private final Map<String, a> eUz = new ConcurrentHashMap();
  
  private void b(a parama)
  {
    try
    {
      if (this.eUz.containsKey(parama.key())) {
        throw new IllegalArgumentException(parama.key() + " dice already exists");
      }
    }
    finally {}
    this.eUz.put(parama.key(), parama);
    c(parama);
    if (this.eUA == null)
    {
      this.eUA = new DiceCup.1(this, f.hfK);
      this.eUA.alive();
    }
  }
  
  private static void c(a parama)
  {
    Log.i("MicroMsg.DiceCup", "dice [%s]", new Object[] { parama.key() });
    b.e(parama);
    long l1 = b.axG();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < TimeUnit.MINUTES.toMillis(parama.cycleMinutes())) {
      Log.i("MicroMsg.DiceCup", "dice [%s] pass cycle", new Object[] { parama.key() });
    }
    do
    {
      return;
      b.dI(l2);
    } while ((Math.random() > parama.rate()) || (parama.rate() < 0.0D));
    parama.awg();
  }
  
  private void d(a parama)
  {
    try
    {
      this.eUz.remove(parama.key());
      if ((this.eUz.isEmpty()) && (this.eUA != null))
      {
        this.eUA.dead();
        this.eUA = null;
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void a(a parama)
  {
    try
    {
      b(parama);
      d(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void run()
  {
    try
    {
      Iterator localIterator = this.eUz.entrySet().iterator();
      while (localIterator.hasNext()) {
        c((a)((Map.Entry)localIterator.next()).getValue());
      }
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void awg();
    
    public abstract long cycleMinutes();
    
    public abstract String key();
    
    public abstract double rate();
  }
  
  static final class b
  {
    private static String eUC;
    private static final b eUD = new b();
    private static final MultiProcessMMKV evW = MultiProcessMMKV.getMMKV("DIAG_MMKV_STORAGE");
    
    public static long axG()
    {
      return evW.decodeLong(eUC, 0L);
    }
    
    public static void dI(long paramLong)
    {
      evW.encode(eUC, paramLong);
    }
    
    public static b e(a.a parama)
    {
      eUC = MMApplicationContext.getProcessName() + "_" + parama.key();
      return eUD;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.dice.a
 * JD-Core Version:    0.7.0.1
 */