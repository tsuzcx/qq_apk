package com.tencent.mm.booter;

import com.tencent.mm.model.ad;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements ad
{
  private static volatile a dhl;
  private at dhj = new at();
  private at.a dhk = new a.1(this);
  private List<com.tencent.mm.model.ae> dhm = new ArrayList();
  private c dhn;
  
  private a()
  {
    this.dhj.a(this.dhk);
    this.dhj.fN(com.tencent.mm.sdk.platformtools.ae.getContext());
    if (this.dhn == null) {
      this.dhn = new a.2(this);
    }
    com.tencent.mm.sdk.b.a.udP.c(this.dhn);
  }
  
  public static a vR()
  {
    if (dhl == null) {}
    try
    {
      if (dhl == null) {
        dhl = new a();
      }
      return dhl;
    }
    finally {}
  }
  
  public final void a(com.tencent.mm.model.ae paramae)
  {
    if (paramae != null)
    {
      y.d("MicroMsg.BackgroundPlayer", "add callback : %s", new Object[] { paramae.toString() });
      this.dhm.add(paramae);
    }
  }
  
  public final void b(com.tencent.mm.model.ae paramae)
  {
    if (paramae != null) {
      this.dhm.remove(paramae);
    }
  }
  
  public final void vS()
  {
    if (this.dhm == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.dhm.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.model.ae)localIterator.next()).Hf();
      }
    }
  }
  
  public final void vT()
  {
    if (this.dhm == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.dhm.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.model.ae)localIterator.next()).Hg();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.a
 * JD-Core Version:    0.7.0.1
 */