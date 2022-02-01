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
  private static final String[] hwR = { "realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut" };
  public h gPa;
  private long hwO;
  public bg<Integer, k> hwP;
  private long hwQ;
  
  public m(h paramh)
  {
    AppMethodBeat.i(151097);
    this.gPa = paramh;
    this.hwP = new bg(this, g.afE().EUN.getLooper(), 30, 2);
    paramh = new HashSet();
    Object localObject1 = hwR;
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      paramh.add(localObject1[i]);
      i += 1;
    }
    localObject1 = this.gPa.a("PRAGMA table_info(netstat);", null, 2);
    i = ((Cursor)localObject1).getColumnIndex("name");
    while (((Cursor)localObject1).moveToNext()) {
      paramh.remove(((Cursor)localObject1).getString(i));
    }
    ((Cursor)localObject1).close();
    localObject1 = hwR;
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      Object localObject2 = localObject1[i];
      if (paramh.contains(localObject2))
      {
        localObject2 = "ALTER TABLE netstat ADD COLUMN " + (String)localObject2 + " INT;";
        this.gPa.execSQL("netstat", (String)localObject2);
      }
      i += 1;
    }
    this.hwQ = System.currentTimeMillis();
    AppMethodBeat.o(151097);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(151099);
    Assert.assertNotNull(paramk);
    long l = System.currentTimeMillis();
    if (paramk.hwc <= 0) {
      paramk.hwc = ((int)(l / 86400000L));
    }
    if (paramk.hwc <= 0)
    {
      AppMethodBeat.o(151099);
      return;
    }
    k localk = oK(paramk.hwc);
    if ((localk != null) && (paramk.hwc == localk.hwc))
    {
      localk.dtM |= 0x1;
      paramk.hwd = ((int)(paramk.hwd + localk.hwe));
      paramk.hwe += localk.hwe;
      paramk.hwf = ((int)(paramk.hwf + localk.hwg));
      paramk.hwg += localk.hwg;
      paramk.hwh += localk.hwh;
      paramk.hwi += localk.hwi;
      paramk.hwj += localk.hwj;
      paramk.hwk += localk.hwk;
      paramk.hwl += localk.hwl;
      paramk.hwm += localk.hwm;
      paramk.hwn += localk.hwn;
      paramk.hwo += localk.hwo;
      paramk.hwp = ((int)(paramk.hwp + localk.hwq));
      paramk.hwq += localk.hwq;
      paramk.hwr = ((int)(paramk.hwr + localk.hws));
      paramk.hws += localk.hws;
      paramk.hwt += localk.hwt;
      paramk.hwu += localk.hwu;
      paramk.hwv += localk.hwv;
      paramk.hww += localk.hww;
      paramk.hwx += localk.hwx;
      paramk.hwy += localk.hwy;
      paramk.hwz += localk.hwz;
      paramk.hwA += localk.hwA;
      paramk.hwB += localk.hwB;
      paramk.hwC += localk.hwC;
      paramk.hwD += localk.hwD;
      paramk.hwE += localk.hwE;
      paramk.id = localk.id;
      paramk.dtM |= 0x2;
      if (l - this.hwQ > 300000L) {
        ad.i("MicroMsg.NetStat", paramk.toString());
      }
    }
    for (;;)
    {
      this.hwQ = l;
      b(paramk);
      AppMethodBeat.o(151099);
      return;
      paramk.dtM |= 0x2;
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
    int i = paramb.EWD;
    paramb = (k)paramb.values;
    if ((paramb != null) && (i == 1))
    {
      i = paramb.hwc;
      int j = paramb.id;
      if (i > 0)
      {
        ContentValues localContentValues = new ContentValues();
        if ((paramb.dtM & 0x2) != 0) {
          localContentValues.put("peroid", Integer.valueOf(paramb.hwc));
        }
        if ((paramb.dtM & 0x4) != 0) {
          localContentValues.put("textCountIn", Integer.valueOf(paramb.hwd));
        }
        if ((paramb.dtM & 0x8) != 0) {
          localContentValues.put("textBytesIn", Long.valueOf(paramb.hwe));
        }
        if ((paramb.dtM & 0x10) != 0) {
          localContentValues.put("imageCountIn", Integer.valueOf(paramb.hwf));
        }
        if ((paramb.dtM & 0x20) != 0) {
          localContentValues.put("imageBytesIn", Long.valueOf(paramb.hwg));
        }
        if ((paramb.dtM & 0x40) != 0) {
          localContentValues.put("voiceCountIn", Integer.valueOf(paramb.hwh));
        }
        if ((paramb.dtM & 0x80) != 0) {
          localContentValues.put("voiceBytesIn", Long.valueOf(paramb.hwi));
        }
        if ((paramb.dtM & 0x100) != 0) {
          localContentValues.put("videoCountIn", Integer.valueOf(paramb.hwj));
        }
        if ((paramb.dtM & 0x200) != 0) {
          localContentValues.put("videoBytesIn", Long.valueOf(paramb.hwk));
        }
        if ((paramb.dtM & 0x400) != 0) {
          localContentValues.put("mobileBytesIn", Long.valueOf(paramb.hwl));
        }
        if ((paramb.dtM & 0x800) != 0) {
          localContentValues.put("wifiBytesIn", Long.valueOf(paramb.hwm));
        }
        if ((paramb.dtM & 0x1000) != 0) {
          localContentValues.put("sysMobileBytesIn", Long.valueOf(paramb.hwn));
        }
        if ((paramb.dtM & 0x2000) != 0) {
          localContentValues.put("sysWifiBytesIn", Long.valueOf(paramb.hwo));
        }
        if ((paramb.dtM & 0x4000) != 0) {
          localContentValues.put("textCountOut", Integer.valueOf(paramb.hwp));
        }
        if ((paramb.dtM & 0x8000) != 0) {
          localContentValues.put("textBytesOut", Long.valueOf(paramb.hwq));
        }
        if ((paramb.dtM & 0x10000) != 0) {
          localContentValues.put("imageCountOut", Integer.valueOf(paramb.hwr));
        }
        if ((paramb.dtM & 0x20000) != 0) {
          localContentValues.put("imageBytesOut", Long.valueOf(paramb.hws));
        }
        if ((paramb.dtM & 0x40000) != 0) {
          localContentValues.put("voiceCountOut", Integer.valueOf(paramb.hwt));
        }
        if ((paramb.dtM & 0x80000) != 0) {
          localContentValues.put("voiceBytesOut", Long.valueOf(paramb.hwu));
        }
        if ((paramb.dtM & 0x100000) != 0) {
          localContentValues.put("videoCountOut", Integer.valueOf(paramb.hwv));
        }
        if ((paramb.dtM & 0x200000) != 0) {
          localContentValues.put("videoBytesOut", Long.valueOf(paramb.hww));
        }
        if ((paramb.dtM & 0x400000) != 0) {
          localContentValues.put("mobileBytesOut", Long.valueOf(paramb.hwx));
        }
        if ((paramb.dtM & 0x800000) != 0) {
          localContentValues.put("wifiBytesOut", Long.valueOf(paramb.hwy));
        }
        if ((paramb.dtM & 0x1000000) != 0) {
          localContentValues.put("sysMobileBytesOut", Long.valueOf(paramb.hwz));
        }
        if ((paramb.dtM & 0x2000000) != 0) {
          localContentValues.put("sysWifiBytesOut", Long.valueOf(paramb.hwA));
        }
        if ((paramb.dtM & 0x4000000) != 0) {
          localContentValues.put("realMobileBytesIn", Long.valueOf(paramb.hwB));
        }
        if ((paramb.dtM & 0x8000000) != 0) {
          localContentValues.put("realWifiBytesIn", Long.valueOf(paramb.hwC));
        }
        if ((paramb.dtM & 0x10000000) != 0) {
          localContentValues.put("realMobileBytesOut", Long.valueOf(paramb.hwD));
        }
        if ((paramb.dtM & 0x20000000) != 0) {
          localContentValues.put("realWifiBytesOut", Long.valueOf(paramb.hwE));
        }
        if (j < 0)
        {
          paramb.id = ((int)this.gPa.a("netstat", "id", localContentValues));
          AppMethodBeat.o(151104);
          return;
        }
        this.gPa.update("netstat", localContentValues, "peroid=".concat(String.valueOf(i)), null);
      }
    }
    AppMethodBeat.o(151104);
  }
  
  public final long aBJ()
  {
    AppMethodBeat.i(151101);
    this.hwP.uV(true);
    int j = (int)((bt.eGO() - 1296000000L) / 86400000L);
    int i = (int)(bt.eGI() / 86400000L);
    Object localObject = "SELECT peroid FROM netstat  WHERE peroid > " + j + " order by peroid limit 1";
    localObject = this.gPa.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("peroid"));
    }
    ((Cursor)localObject).close();
    long l = i;
    AppMethodBeat.o(151101);
    return l * 86400000L;
  }
  
  public final boolean aBK()
  {
    AppMethodBeat.i(151103);
    if (this.gPa.inTransaction())
    {
      ad.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
      AppMethodBeat.o(151103);
      return false;
    }
    this.hwO = this.gPa.rb(Thread.currentThread().getId());
    if (this.hwO <= 0L)
    {
      ad.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.hwO + " return false");
      AppMethodBeat.o(151103);
      return false;
    }
    AppMethodBeat.o(151103);
    return true;
  }
  
  public final void aBL()
  {
    AppMethodBeat.i(151105);
    if (this.hwO > 0L) {
      this.gPa.mX(this.hwO);
    }
    AppMethodBeat.o(151105);
  }
  
  public final boolean b(k paramk)
  {
    AppMethodBeat.i(151100);
    Assert.assertNotNull(paramk);
    if (paramk.hwc > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      bool = this.hwP.G(Integer.valueOf(paramk.hwc), paramk);
      AppMethodBeat.o(151100);
      return bool;
    }
  }
  
  public final k oK(int paramInt)
  {
    AppMethodBeat.i(151098);
    Object localObject2 = (k)this.hwP.get(Integer.valueOf(paramInt));
    Object localObject3;
    Object localObject1;
    if (localObject2 == null)
    {
      localObject3 = this.gPa.a("netstat", null, "peroid = ".concat(String.valueOf(paramInt)), null, null, null, null, 2);
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new k();
        ((k)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
      if (localObject1 != null) {
        this.hwP.G(Integer.valueOf(paramInt), localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(151098);
      return localObject1;
      localObject2 = this.hwP;
      localObject3 = new k();
      ((k)localObject3).dtM = 0;
      ((k)localObject3).id = 0;
      ((k)localObject3).hwc = 0;
      ((k)localObject3).hwd = 0;
      ((k)localObject3).hwe = 0L;
      ((k)localObject3).hwf = 0;
      ((k)localObject3).hwg = 0L;
      ((k)localObject3).hwh = 0;
      ((k)localObject3).hwi = 0L;
      ((k)localObject3).hwj = 0;
      ((k)localObject3).hwk = 0L;
      ((k)localObject3).hwl = 0L;
      ((k)localObject3).hwm = 0L;
      ((k)localObject3).hwn = 0L;
      ((k)localObject3).hwo = 0L;
      ((k)localObject3).hwp = 0;
      ((k)localObject3).hwq = 0L;
      ((k)localObject3).hwr = 0;
      ((k)localObject3).hws = 0L;
      ((k)localObject3).hwt = 0;
      ((k)localObject3).hwu = 0L;
      ((k)localObject3).hwv = 0;
      ((k)localObject3).hww = 0L;
      ((k)localObject3).hwx = 0L;
      ((k)localObject3).hwy = 0L;
      ((k)localObject3).hwz = 0L;
      ((k)localObject3).hwA = 0L;
      ((k)localObject3).hwB = 0L;
      ((k)localObject3).hwC = 0L;
      ((k)localObject3).hwD = 0L;
      ((k)localObject3).hwE = 0L;
      ((bg)localObject2).G(Integer.valueOf(paramInt), localObject3);
      continue;
      localObject1 = localObject2;
      if (((k)localObject2).hwc != paramInt) {
        localObject1 = null;
      }
    }
  }
  
  public final k oL(int paramInt)
  {
    k localk = null;
    AppMethodBeat.i(151102);
    this.hwP.uV(true);
    Object localObject = "SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= ".concat(String.valueOf(paramInt));
    localObject = this.gPa.a((String)localObject, null, 2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.m
 * JD-Core Version:    0.7.0.1
 */