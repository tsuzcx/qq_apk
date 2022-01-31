package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h$a
{
  public int cpt;
  public int index;
  public int kbN;
  public long msZ;
  public String mta;
  public long mtb;
  public long mtc;
  public boolean mtd;
  public int mte;
  public int mtf;
  public int mtg;
  public int mth;
  public int mti;
  public boolean mtj;
  public boolean mtk;
  public int mtl;
  public String mtm;
  public String query;
  public int scene;
  public String sid;
  public long timestamp;
  public int type;
  
  public final String toString()
  {
    int k = 1;
    AppMethodBeat.i(102648);
    int m = this.scene;
    int n = this.index;
    long l1 = this.msZ;
    int i1 = this.type;
    String str = this.mta;
    int i2 = this.cpt;
    long l2 = this.timestamp;
    long l3 = this.mtb;
    long l4 = this.mtc;
    int i;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int j;
    if (this.mtd)
    {
      i = 1;
      i3 = this.mte;
      i4 = this.mtf;
      i5 = this.mtg;
      i6 = this.mth;
      i7 = this.mti;
      if (!this.mtj) {
        break label328;
      }
      j = 1;
      label109:
      if (!this.mtk) {
        break label333;
      }
    }
    for (;;)
    {
      str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.kbN), this.sid, Integer.valueOf(this.mtl), this.query, this.mtm });
      AppMethodBeat.o(102648);
      return str;
      i = 0;
      break;
      label328:
      j = 0;
      break label109;
      label333:
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.h.a
 * JD-Core Version:    0.7.0.1
 */