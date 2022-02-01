package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bg.b;
import com.tencent.mm.sdk.platformtools.bg.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import java.util.HashSet;
import junit.framework.Assert;

public final class m
  extends com.tencent.mm.sdk.e.k
  implements bg.c<Integer, k>
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) " };
  private static final String[] iqN = { "realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut" };
  public h hHS;
  private long iqK;
  public bg<Integer, k> iqL;
  private long iqM;
  
  public m(h paramh)
  {
    AppMethodBeat.i(151097);
    this.hHS = paramh;
    this.iqL = new bg(this, g.ajF().IdO.getLooper(), 30, 2);
    paramh = new HashSet();
    Object localObject1 = iqN;
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      paramh.add(localObject1[i]);
      i += 1;
    }
    localObject1 = this.hHS.a("PRAGMA table_info(netstat);", null, 2);
    i = ((Cursor)localObject1).getColumnIndex("name");
    while (((Cursor)localObject1).moveToNext()) {
      paramh.remove(((Cursor)localObject1).getString(i));
    }
    ((Cursor)localObject1).close();
    localObject1 = iqN;
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      Object localObject2 = localObject1[i];
      if (paramh.contains(localObject2))
      {
        localObject2 = "ALTER TABLE netstat ADD COLUMN " + (String)localObject2 + " INT;";
        this.hHS.execSQL("netstat", (String)localObject2);
      }
      i += 1;
    }
    this.iqM = System.currentTimeMillis();
    AppMethodBeat.o(151097);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(151099);
    Assert.assertNotNull(paramk);
    long l = System.currentTimeMillis();
    if (paramk.ipY <= 0) {
      paramk.ipY = ((int)(l / 86400000L));
    }
    if (paramk.ipY <= 0)
    {
      AppMethodBeat.o(151099);
      return;
    }
    k localk = qb(paramk.ipY);
    if ((localk != null) && (paramk.ipY == localk.ipY))
    {
      localk.dDp |= 0x1;
      paramk.ipZ = ((int)(paramk.ipZ + localk.iqa));
      paramk.iqa += localk.iqa;
      paramk.iqb = ((int)(paramk.iqb + localk.iqc));
      paramk.iqc += localk.iqc;
      paramk.iqd += localk.iqd;
      paramk.iqe += localk.iqe;
      paramk.iqf += localk.iqf;
      paramk.iqg += localk.iqg;
      paramk.iqh += localk.iqh;
      paramk.iqi += localk.iqi;
      paramk.iqj += localk.iqj;
      paramk.iqk += localk.iqk;
      paramk.iql = ((int)(paramk.iql + localk.iqm));
      paramk.iqm += localk.iqm;
      paramk.iqn = ((int)(paramk.iqn + localk.iqo));
      paramk.iqo += localk.iqo;
      paramk.iqp += localk.iqp;
      paramk.iqq += localk.iqq;
      paramk.iqr += localk.iqr;
      paramk.iqs += localk.iqs;
      paramk.iqt += localk.iqt;
      paramk.iqu += localk.iqu;
      paramk.iqv += localk.iqv;
      paramk.iqw += localk.iqw;
      paramk.iqx += localk.iqx;
      paramk.iqy += localk.iqy;
      paramk.iqz += localk.iqz;
      paramk.iqA += localk.iqA;
      paramk.id = localk.id;
      paramk.dDp |= 0x2;
      if (l - this.iqM > 300000L) {
        ad.i("MicroMsg.NetStat", paramk.toString());
      }
    }
    for (;;)
    {
      this.iqM = l;
      b(paramk);
      AppMethodBeat.o(151099);
      return;
      paramk.dDp |= 0x2;
      paramk.id = -1;
      if (localk != null) {
        ad.i("MicroMsg.NetStat", localk.toString());
      } else {
        ad.i("MicroMsg.NetStat", "NetStat started.");
      }
    }
  }
  
  public final void a(bg.b<Integer, k> paramb)
  {
    AppMethodBeat.i(151104);
    int i = paramb.IfE;
    paramb = (k)paramb.values;
    if ((paramb != null) && (i == 1))
    {
      i = paramb.ipY;
      int j = paramb.id;
      if (i > 0)
      {
        ContentValues localContentValues = new ContentValues();
        if ((paramb.dDp & 0x2) != 0) {
          localContentValues.put("peroid", Integer.valueOf(paramb.ipY));
        }
        if ((paramb.dDp & 0x4) != 0) {
          localContentValues.put("textCountIn", Integer.valueOf(paramb.ipZ));
        }
        if ((paramb.dDp & 0x8) != 0) {
          localContentValues.put("textBytesIn", Long.valueOf(paramb.iqa));
        }
        if ((paramb.dDp & 0x10) != 0) {
          localContentValues.put("imageCountIn", Integer.valueOf(paramb.iqb));
        }
        if ((paramb.dDp & 0x20) != 0) {
          localContentValues.put("imageBytesIn", Long.valueOf(paramb.iqc));
        }
        if ((paramb.dDp & 0x40) != 0) {
          localContentValues.put("voiceCountIn", Integer.valueOf(paramb.iqd));
        }
        if ((paramb.dDp & 0x80) != 0) {
          localContentValues.put("voiceBytesIn", Long.valueOf(paramb.iqe));
        }
        if ((paramb.dDp & 0x100) != 0) {
          localContentValues.put("videoCountIn", Integer.valueOf(paramb.iqf));
        }
        if ((paramb.dDp & 0x200) != 0) {
          localContentValues.put("videoBytesIn", Long.valueOf(paramb.iqg));
        }
        if ((paramb.dDp & 0x400) != 0) {
          localContentValues.put("mobileBytesIn", Long.valueOf(paramb.iqh));
        }
        if ((paramb.dDp & 0x800) != 0) {
          localContentValues.put("wifiBytesIn", Long.valueOf(paramb.iqi));
        }
        if ((paramb.dDp & 0x1000) != 0) {
          localContentValues.put("sysMobileBytesIn", Long.valueOf(paramb.iqj));
        }
        if ((paramb.dDp & 0x2000) != 0) {
          localContentValues.put("sysWifiBytesIn", Long.valueOf(paramb.iqk));
        }
        if ((paramb.dDp & 0x4000) != 0) {
          localContentValues.put("textCountOut", Integer.valueOf(paramb.iql));
        }
        if ((paramb.dDp & 0x8000) != 0) {
          localContentValues.put("textBytesOut", Long.valueOf(paramb.iqm));
        }
        if ((paramb.dDp & 0x10000) != 0) {
          localContentValues.put("imageCountOut", Integer.valueOf(paramb.iqn));
        }
        if ((paramb.dDp & 0x20000) != 0) {
          localContentValues.put("imageBytesOut", Long.valueOf(paramb.iqo));
        }
        if ((paramb.dDp & 0x40000) != 0) {
          localContentValues.put("voiceCountOut", Integer.valueOf(paramb.iqp));
        }
        if ((paramb.dDp & 0x80000) != 0) {
          localContentValues.put("voiceBytesOut", Long.valueOf(paramb.iqq));
        }
        if ((paramb.dDp & 0x100000) != 0) {
          localContentValues.put("videoCountOut", Integer.valueOf(paramb.iqr));
        }
        if ((paramb.dDp & 0x200000) != 0) {
          localContentValues.put("videoBytesOut", Long.valueOf(paramb.iqs));
        }
        if ((paramb.dDp & 0x400000) != 0) {
          localContentValues.put("mobileBytesOut", Long.valueOf(paramb.iqt));
        }
        if ((paramb.dDp & 0x800000) != 0) {
          localContentValues.put("wifiBytesOut", Long.valueOf(paramb.iqu));
        }
        if ((paramb.dDp & 0x1000000) != 0) {
          localContentValues.put("sysMobileBytesOut", Long.valueOf(paramb.iqv));
        }
        if ((paramb.dDp & 0x2000000) != 0) {
          localContentValues.put("sysWifiBytesOut", Long.valueOf(paramb.iqw));
        }
        if ((paramb.dDp & 0x4000000) != 0) {
          localContentValues.put("realMobileBytesIn", Long.valueOf(paramb.iqx));
        }
        if ((paramb.dDp & 0x8000000) != 0) {
          localContentValues.put("realWifiBytesIn", Long.valueOf(paramb.iqy));
        }
        if ((paramb.dDp & 0x10000000) != 0) {
          localContentValues.put("realMobileBytesOut", Long.valueOf(paramb.iqz));
        }
        if ((paramb.dDp & 0x20000000) != 0) {
          localContentValues.put("realWifiBytesOut", Long.valueOf(paramb.iqA));
        }
        if (j < 0)
        {
          paramb.id = ((int)this.hHS.a("netstat", "id", localContentValues));
          AppMethodBeat.o(151104);
          return;
        }
        this.hHS.update("netstat", localContentValues, "peroid=".concat(String.valueOf(i)), null);
      }
    }
    AppMethodBeat.o(151104);
  }
  
  public final long aLJ()
  {
    AppMethodBeat.i(151101);
    this.iqL.wJ(true);
    int j = (int)((bt.flT() - 1296000000L) / 86400000L);
    int i = (int)(bt.flN() / 86400000L);
    Object localObject = "SELECT peroid FROM netstat  WHERE peroid > " + j + " order by peroid limit 1";
    localObject = this.hHS.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("peroid"));
    }
    ((Cursor)localObject).close();
    long l = i;
    AppMethodBeat.o(151101);
    return l * 86400000L;
  }
  
  public final boolean aLK()
  {
    AppMethodBeat.i(151103);
    if (this.hHS.inTransaction())
    {
      ad.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
      AppMethodBeat.o(151103);
      return false;
    }
    this.iqK = this.hHS.xO(Thread.currentThread().getId());
    if (this.iqK <= 0L)
    {
      ad.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.iqK + " return false");
      AppMethodBeat.o(151103);
      return false;
    }
    AppMethodBeat.o(151103);
    return true;
  }
  
  public final void aLL()
  {
    AppMethodBeat.i(151105);
    if (this.iqK > 0L) {
      this.hHS.sJ(this.iqK);
    }
    AppMethodBeat.o(151105);
  }
  
  public final boolean b(k paramk)
  {
    AppMethodBeat.i(151100);
    Assert.assertNotNull(paramk);
    if (paramk.ipY > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      bool = this.iqL.I(Integer.valueOf(paramk.ipY), paramk);
      AppMethodBeat.o(151100);
      return bool;
    }
  }
  
  public final k qb(int paramInt)
  {
    AppMethodBeat.i(151098);
    Object localObject2 = (k)this.iqL.get(Integer.valueOf(paramInt));
    Object localObject3;
    Object localObject1;
    if (localObject2 == null)
    {
      localObject3 = this.hHS.a("netstat", null, "peroid = ".concat(String.valueOf(paramInt)), null, null, null, null, 2);
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new k();
        ((k)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
      if (localObject1 != null) {
        this.iqL.I(Integer.valueOf(paramInt), localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(151098);
      return localObject1;
      localObject2 = this.iqL;
      localObject3 = new k();
      ((k)localObject3).dDp = 0;
      ((k)localObject3).id = 0;
      ((k)localObject3).ipY = 0;
      ((k)localObject3).ipZ = 0;
      ((k)localObject3).iqa = 0L;
      ((k)localObject3).iqb = 0;
      ((k)localObject3).iqc = 0L;
      ((k)localObject3).iqd = 0;
      ((k)localObject3).iqe = 0L;
      ((k)localObject3).iqf = 0;
      ((k)localObject3).iqg = 0L;
      ((k)localObject3).iqh = 0L;
      ((k)localObject3).iqi = 0L;
      ((k)localObject3).iqj = 0L;
      ((k)localObject3).iqk = 0L;
      ((k)localObject3).iql = 0;
      ((k)localObject3).iqm = 0L;
      ((k)localObject3).iqn = 0;
      ((k)localObject3).iqo = 0L;
      ((k)localObject3).iqp = 0;
      ((k)localObject3).iqq = 0L;
      ((k)localObject3).iqr = 0;
      ((k)localObject3).iqs = 0L;
      ((k)localObject3).iqt = 0L;
      ((k)localObject3).iqu = 0L;
      ((k)localObject3).iqv = 0L;
      ((k)localObject3).iqw = 0L;
      ((k)localObject3).iqx = 0L;
      ((k)localObject3).iqy = 0L;
      ((k)localObject3).iqz = 0L;
      ((k)localObject3).iqA = 0L;
      ((bg)localObject2).I(Integer.valueOf(paramInt), localObject3);
      continue;
      localObject1 = localObject2;
      if (((k)localObject2).ipY != paramInt) {
        localObject1 = null;
      }
    }
  }
  
  public final k qc(int paramInt)
  {
    k localk = null;
    AppMethodBeat.i(151102);
    this.iqL.wJ(true);
    Object localObject = "SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= ".concat(String.valueOf(paramInt));
    localObject = this.hHS.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localk = new k();
      localk.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(151102);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.m
 * JD-Core Version:    0.7.0.1
 */