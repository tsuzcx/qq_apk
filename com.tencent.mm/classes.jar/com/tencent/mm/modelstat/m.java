package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.b;
import com.tencent.mm.sdk.platformtools.bf.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h;
import java.util.HashSet;
import junit.framework.Assert;

public final class m
  extends com.tencent.mm.sdk.e.k
  implements bf.c<Integer, k>
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) " };
  private static final String[] hXs = { "realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut" };
  private long hXp;
  public bf<Integer, k> hXq;
  private long hXr;
  public h hpA;
  
  public m(h paramh)
  {
    AppMethodBeat.i(151097);
    this.hpA = paramh;
    this.hXq = new bf(this, g.agU().GrZ.getLooper(), 30, 2);
    paramh = new HashSet();
    Object localObject1 = hXs;
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      paramh.add(localObject1[i]);
      i += 1;
    }
    localObject1 = this.hpA.a("PRAGMA table_info(netstat);", null, 2);
    i = ((Cursor)localObject1).getColumnIndex("name");
    while (((Cursor)localObject1).moveToNext()) {
      paramh.remove(((Cursor)localObject1).getString(i));
    }
    ((Cursor)localObject1).close();
    localObject1 = hXs;
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      Object localObject2 = localObject1[i];
      if (paramh.contains(localObject2))
      {
        localObject2 = "ALTER TABLE netstat ADD COLUMN " + (String)localObject2 + " INT;";
        this.hpA.execSQL("netstat", (String)localObject2);
      }
      i += 1;
    }
    this.hXr = System.currentTimeMillis();
    AppMethodBeat.o(151097);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(151099);
    Assert.assertNotNull(paramk);
    long l = System.currentTimeMillis();
    if (paramk.hWD <= 0) {
      paramk.hWD = ((int)(l / 86400000L));
    }
    if (paramk.hWD <= 0)
    {
      AppMethodBeat.o(151099);
      return;
    }
    k localk = pz(paramk.hWD);
    if ((localk != null) && (paramk.hWD == localk.hWD))
    {
      localk.drx |= 0x1;
      paramk.hWE = ((int)(paramk.hWE + localk.hWF));
      paramk.hWF += localk.hWF;
      paramk.hWG = ((int)(paramk.hWG + localk.hWH));
      paramk.hWH += localk.hWH;
      paramk.hWI += localk.hWI;
      paramk.hWJ += localk.hWJ;
      paramk.hWK += localk.hWK;
      paramk.hWL += localk.hWL;
      paramk.hWM += localk.hWM;
      paramk.hWN += localk.hWN;
      paramk.hWO += localk.hWO;
      paramk.hWP += localk.hWP;
      paramk.hWQ = ((int)(paramk.hWQ + localk.hWR));
      paramk.hWR += localk.hWR;
      paramk.hWS = ((int)(paramk.hWS + localk.hWT));
      paramk.hWT += localk.hWT;
      paramk.hWU += localk.hWU;
      paramk.hWV += localk.hWV;
      paramk.hWW += localk.hWW;
      paramk.hWX += localk.hWX;
      paramk.hWY += localk.hWY;
      paramk.hWZ += localk.hWZ;
      paramk.hXa += localk.hXa;
      paramk.hXb += localk.hXb;
      paramk.hXc += localk.hXc;
      paramk.hXd += localk.hXd;
      paramk.hXe += localk.hXe;
      paramk.hXf += localk.hXf;
      paramk.id = localk.id;
      paramk.drx |= 0x2;
      if (l - this.hXr > 300000L) {
        ac.i("MicroMsg.NetStat", paramk.toString());
      }
    }
    for (;;)
    {
      this.hXr = l;
      b(paramk);
      AppMethodBeat.o(151099);
      return;
      paramk.drx |= 0x2;
      paramk.id = -1;
      if (localk != null) {
        ac.i("MicroMsg.NetStat", localk.toString());
      } else {
        ac.i("MicroMsg.NetStat", "NetStat started.");
      }
    }
  }
  
  public final void a(bf.b<Integer, k> paramb)
  {
    AppMethodBeat.i(151104);
    int i = paramb.GtP;
    paramb = (k)paramb.values;
    if ((paramb != null) && (i == 1))
    {
      i = paramb.hWD;
      int j = paramb.id;
      if (i > 0)
      {
        ContentValues localContentValues = new ContentValues();
        if ((paramb.drx & 0x2) != 0) {
          localContentValues.put("peroid", Integer.valueOf(paramb.hWD));
        }
        if ((paramb.drx & 0x4) != 0) {
          localContentValues.put("textCountIn", Integer.valueOf(paramb.hWE));
        }
        if ((paramb.drx & 0x8) != 0) {
          localContentValues.put("textBytesIn", Long.valueOf(paramb.hWF));
        }
        if ((paramb.drx & 0x10) != 0) {
          localContentValues.put("imageCountIn", Integer.valueOf(paramb.hWG));
        }
        if ((paramb.drx & 0x20) != 0) {
          localContentValues.put("imageBytesIn", Long.valueOf(paramb.hWH));
        }
        if ((paramb.drx & 0x40) != 0) {
          localContentValues.put("voiceCountIn", Integer.valueOf(paramb.hWI));
        }
        if ((paramb.drx & 0x80) != 0) {
          localContentValues.put("voiceBytesIn", Long.valueOf(paramb.hWJ));
        }
        if ((paramb.drx & 0x100) != 0) {
          localContentValues.put("videoCountIn", Integer.valueOf(paramb.hWK));
        }
        if ((paramb.drx & 0x200) != 0) {
          localContentValues.put("videoBytesIn", Long.valueOf(paramb.hWL));
        }
        if ((paramb.drx & 0x400) != 0) {
          localContentValues.put("mobileBytesIn", Long.valueOf(paramb.hWM));
        }
        if ((paramb.drx & 0x800) != 0) {
          localContentValues.put("wifiBytesIn", Long.valueOf(paramb.hWN));
        }
        if ((paramb.drx & 0x1000) != 0) {
          localContentValues.put("sysMobileBytesIn", Long.valueOf(paramb.hWO));
        }
        if ((paramb.drx & 0x2000) != 0) {
          localContentValues.put("sysWifiBytesIn", Long.valueOf(paramb.hWP));
        }
        if ((paramb.drx & 0x4000) != 0) {
          localContentValues.put("textCountOut", Integer.valueOf(paramb.hWQ));
        }
        if ((paramb.drx & 0x8000) != 0) {
          localContentValues.put("textBytesOut", Long.valueOf(paramb.hWR));
        }
        if ((paramb.drx & 0x10000) != 0) {
          localContentValues.put("imageCountOut", Integer.valueOf(paramb.hWS));
        }
        if ((paramb.drx & 0x20000) != 0) {
          localContentValues.put("imageBytesOut", Long.valueOf(paramb.hWT));
        }
        if ((paramb.drx & 0x40000) != 0) {
          localContentValues.put("voiceCountOut", Integer.valueOf(paramb.hWU));
        }
        if ((paramb.drx & 0x80000) != 0) {
          localContentValues.put("voiceBytesOut", Long.valueOf(paramb.hWV));
        }
        if ((paramb.drx & 0x100000) != 0) {
          localContentValues.put("videoCountOut", Integer.valueOf(paramb.hWW));
        }
        if ((paramb.drx & 0x200000) != 0) {
          localContentValues.put("videoBytesOut", Long.valueOf(paramb.hWX));
        }
        if ((paramb.drx & 0x400000) != 0) {
          localContentValues.put("mobileBytesOut", Long.valueOf(paramb.hWY));
        }
        if ((paramb.drx & 0x800000) != 0) {
          localContentValues.put("wifiBytesOut", Long.valueOf(paramb.hWZ));
        }
        if ((paramb.drx & 0x1000000) != 0) {
          localContentValues.put("sysMobileBytesOut", Long.valueOf(paramb.hXa));
        }
        if ((paramb.drx & 0x2000000) != 0) {
          localContentValues.put("sysWifiBytesOut", Long.valueOf(paramb.hXb));
        }
        if ((paramb.drx & 0x4000000) != 0) {
          localContentValues.put("realMobileBytesIn", Long.valueOf(paramb.hXc));
        }
        if ((paramb.drx & 0x8000000) != 0) {
          localContentValues.put("realWifiBytesIn", Long.valueOf(paramb.hXd));
        }
        if ((paramb.drx & 0x10000000) != 0) {
          localContentValues.put("realMobileBytesOut", Long.valueOf(paramb.hXe));
        }
        if ((paramb.drx & 0x20000000) != 0) {
          localContentValues.put("realWifiBytesOut", Long.valueOf(paramb.hXf));
        }
        if (j < 0)
        {
          paramb.id = ((int)this.hpA.a("netstat", "id", localContentValues));
          AppMethodBeat.o(151104);
          return;
        }
        this.hpA.update("netstat", localContentValues, "peroid=".concat(String.valueOf(i)), null);
      }
    }
    AppMethodBeat.o(151104);
  }
  
  public final boolean aIA()
  {
    AppMethodBeat.i(151103);
    if (this.hpA.inTransaction())
    {
      ac.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
      AppMethodBeat.o(151103);
      return false;
    }
    this.hXp = this.hpA.vE(Thread.currentThread().getId());
    if (this.hXp <= 0L)
    {
      ac.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.hXp + " return false");
      AppMethodBeat.o(151103);
      return false;
    }
    AppMethodBeat.o(151103);
    return true;
  }
  
  public final void aIB()
  {
    AppMethodBeat.i(151105);
    if (this.hXp > 0L) {
      this.hpA.qL(this.hXp);
    }
    AppMethodBeat.o(151105);
  }
  
  public final long aIz()
  {
    AppMethodBeat.i(151101);
    this.hXq.vX(true);
    int j = (int)((bs.eWj() - 1296000000L) / 86400000L);
    int i = (int)(bs.eWd() / 86400000L);
    Object localObject = "SELECT peroid FROM netstat  WHERE peroid > " + j + " order by peroid limit 1";
    localObject = this.hpA.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("peroid"));
    }
    ((Cursor)localObject).close();
    long l = i;
    AppMethodBeat.o(151101);
    return l * 86400000L;
  }
  
  public final boolean b(k paramk)
  {
    AppMethodBeat.i(151100);
    Assert.assertNotNull(paramk);
    if (paramk.hWD > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      bool = this.hXq.G(Integer.valueOf(paramk.hWD), paramk);
      AppMethodBeat.o(151100);
      return bool;
    }
  }
  
  public final k pA(int paramInt)
  {
    k localk = null;
    AppMethodBeat.i(151102);
    this.hXq.vX(true);
    Object localObject = "SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= ".concat(String.valueOf(paramInt));
    localObject = this.hpA.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localk = new k();
      localk.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(151102);
    return localk;
  }
  
  public final k pz(int paramInt)
  {
    AppMethodBeat.i(151098);
    Object localObject2 = (k)this.hXq.get(Integer.valueOf(paramInt));
    Object localObject3;
    Object localObject1;
    if (localObject2 == null)
    {
      localObject3 = this.hpA.a("netstat", null, "peroid = ".concat(String.valueOf(paramInt)), null, null, null, null, 2);
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new k();
        ((k)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
      if (localObject1 != null) {
        this.hXq.G(Integer.valueOf(paramInt), localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(151098);
      return localObject1;
      localObject2 = this.hXq;
      localObject3 = new k();
      ((k)localObject3).drx = 0;
      ((k)localObject3).id = 0;
      ((k)localObject3).hWD = 0;
      ((k)localObject3).hWE = 0;
      ((k)localObject3).hWF = 0L;
      ((k)localObject3).hWG = 0;
      ((k)localObject3).hWH = 0L;
      ((k)localObject3).hWI = 0;
      ((k)localObject3).hWJ = 0L;
      ((k)localObject3).hWK = 0;
      ((k)localObject3).hWL = 0L;
      ((k)localObject3).hWM = 0L;
      ((k)localObject3).hWN = 0L;
      ((k)localObject3).hWO = 0L;
      ((k)localObject3).hWP = 0L;
      ((k)localObject3).hWQ = 0;
      ((k)localObject3).hWR = 0L;
      ((k)localObject3).hWS = 0;
      ((k)localObject3).hWT = 0L;
      ((k)localObject3).hWU = 0;
      ((k)localObject3).hWV = 0L;
      ((k)localObject3).hWW = 0;
      ((k)localObject3).hWX = 0L;
      ((k)localObject3).hWY = 0L;
      ((k)localObject3).hWZ = 0L;
      ((k)localObject3).hXa = 0L;
      ((k)localObject3).hXb = 0L;
      ((k)localObject3).hXc = 0L;
      ((k)localObject3).hXd = 0L;
      ((k)localObject3).hXe = 0L;
      ((k)localObject3).hXf = 0L;
      ((bf)localObject2).G(Integer.valueOf(paramInt), localObject3);
      continue;
      localObject1 = localObject2;
      if (((k)localObject2).hWD != paramInt) {
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.m
 * JD-Core Version:    0.7.0.1
 */