package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public long mWI;
  public List<Integer> naA;
  public List<b.a> naB;
  public long nae;
  public long nag;
  public int nah;
  public int nai;
  public int naj;
  public int nak;
  public int nal;
  public int nam;
  public int nan;
  public int nao;
  public int nap;
  public int naq;
  public int nar;
  public int nas;
  public int nat;
  public int nau;
  public int nav;
  public int naw;
  public String nax;
  public boolean nay;
  public int naz;
  public String query;
  
  public b()
  {
    AppMethodBeat.i(152166);
    this.nax = "";
    this.nag = 0L;
    this.nay = false;
    this.naz = 0;
    this.naA = new ArrayList();
    this.naB = new ArrayList();
    AppMethodBeat.o(152166);
  }
  
  public final int bCX()
  {
    int i = this.nau;
    this.nau = 2;
    return i;
  }
  
  public final String bCY()
  {
    AppMethodBeat.i(152170);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.naA.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((Integer)localIterator.next()).intValue());
      ((StringBuffer)localObject).append("#");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(152170);
    return localObject;
  }
  
  public final String bCZ()
  {
    AppMethodBeat.i(152171);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.naB.iterator();
    while (localIterator.hasNext())
    {
      b.a locala = (b.a)localIterator.next();
      if (locala.itemType != 0)
      {
        ((StringBuffer)localObject).append(locala.position);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(locala.itemType);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(locala.mZT);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(locala.naC);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(152171);
    return localObject;
  }
  
  public final String bDa()
  {
    AppMethodBeat.i(152172);
    Object localObject = new StringBuffer();
    if (this.nah > 0)
    {
      ((StringBuffer)localObject).append(2);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.nah);
      ((StringBuffer)localObject).append("|");
    }
    if (this.nai > 0)
    {
      ((StringBuffer)localObject).append(3);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.nai);
      ((StringBuffer)localObject).append("|");
    }
    if (this.naj > 0)
    {
      ((StringBuffer)localObject).append(4);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.naj);
      ((StringBuffer)localObject).append("|");
    }
    if (this.nak > 0)
    {
      ((StringBuffer)localObject).append(5);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.nak);
      ((StringBuffer)localObject).append("|");
    }
    if (this.nal > 0)
    {
      ((StringBuffer)localObject).append(11);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.nal);
      ((StringBuffer)localObject).append("|");
    }
    if (this.nam > 0)
    {
      ((StringBuffer)localObject).append(10);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.nam);
      ((StringBuffer)localObject).append("|");
    }
    if (this.nan > 0)
    {
      ((StringBuffer)localObject).append(12);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.nan);
      ((StringBuffer)localObject).append("|");
    }
    if (this.nao > 0)
    {
      ((StringBuffer)localObject).append(16);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.nao);
      ((StringBuffer)localObject).append("|");
    }
    if (this.nap > 0)
    {
      ((StringBuffer)localObject).append(21);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.nap);
      ((StringBuffer)localObject).append("|");
    }
    if (this.nas > 0)
    {
      ((StringBuffer)localObject).append(25);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.nas);
      ((StringBuffer)localObject).append("|");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(152172);
    return localObject;
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(152168);
    this.naA.add(Integer.valueOf(k.b(parama)));
    AppMethodBeat.o(152168);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(152167);
    this.query = "";
    this.naw = 0;
    this.nav = 0;
    this.nae = 0L;
    this.nah = 0;
    this.nai = 0;
    this.naj = 0;
    this.nak = 0;
    this.nal = 0;
    this.nam = 0;
    this.nan = 0;
    this.nao = 0;
    this.nap = 0;
    this.naq = 0;
    this.nar = 0;
    this.nat = 0;
    this.nag = 0L;
    this.naB.clear();
    this.naA.clear();
    AppMethodBeat.o(152167);
  }
  
  public final void wB(int paramInt)
  {
    AppMethodBeat.i(152169);
    this.naA.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(152169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.b
 * JD-Core Version:    0.7.0.1
 */