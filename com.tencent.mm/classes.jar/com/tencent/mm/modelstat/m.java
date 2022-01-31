package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bb.b;
import com.tencent.mm.sdk.platformtools.bb.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import junit.framework.Assert;

public final class m
  extends com.tencent.mm.sdk.e.k
  implements bb.c<Integer, k>
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) " };
  private static final String[] fUi = { "realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut" };
  private long fUf;
  public bb<Integer, k> fUg;
  private long fUh;
  public h fnw;
  
  public m(h paramh)
  {
    AppMethodBeat.i(78753);
    this.fnw = paramh;
    this.fUg = new bb(this, g.RO().oNc.getLooper(), 30, 2);
    paramh = new HashSet();
    Object localObject1 = fUi;
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      paramh.add(localObject1[i]);
      i += 1;
    }
    localObject1 = this.fnw.a("PRAGMA table_info(netstat);", null, 2);
    i = ((Cursor)localObject1).getColumnIndex("name");
    while (((Cursor)localObject1).moveToNext()) {
      paramh.remove(((Cursor)localObject1).getString(i));
    }
    ((Cursor)localObject1).close();
    localObject1 = fUi;
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      Object localObject2 = localObject1[i];
      if (paramh.contains(localObject2))
      {
        localObject2 = "ALTER TABLE netstat ADD COLUMN " + (String)localObject2 + " INT;";
        this.fnw.execSQL("netstat", (String)localObject2);
      }
      i += 1;
    }
    this.fUh = System.currentTimeMillis();
    AppMethodBeat.o(78753);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(78755);
    Assert.assertNotNull(paramk);
    long l = System.currentTimeMillis();
    if (paramk.fTt <= 0) {
      paramk.fTt = ((int)(l / 86400000L));
    }
    if (paramk.fTt <= 0)
    {
      AppMethodBeat.o(78755);
      return;
    }
    k localk = mb(paramk.fTt);
    if ((localk != null) && (paramk.fTt == localk.fTt))
    {
      localk.bsY |= 0x1;
      paramk.fTu += localk.fTv;
      paramk.fTv += localk.fTv;
      paramk.fTw += localk.fTx;
      paramk.fTx += localk.fTx;
      paramk.fTy += localk.fTy;
      paramk.fTz += localk.fTz;
      paramk.fTA += localk.fTA;
      paramk.fTB += localk.fTB;
      paramk.fTC += localk.fTC;
      paramk.fTD += localk.fTD;
      paramk.fTE += localk.fTE;
      paramk.fTF += localk.fTF;
      paramk.fTG += localk.fTH;
      paramk.fTH += localk.fTH;
      paramk.fTI += localk.fTJ;
      paramk.fTJ += localk.fTJ;
      paramk.fTK += localk.fTK;
      paramk.fTL += localk.fTL;
      paramk.fTM += localk.fTM;
      paramk.fTN += localk.fTN;
      paramk.fTO += localk.fTO;
      paramk.fTP += localk.fTP;
      paramk.fTQ += localk.fTQ;
      paramk.fTR += localk.fTR;
      paramk.fTS += localk.fTS;
      paramk.fTT += localk.fTT;
      paramk.fTU += localk.fTU;
      paramk.fTV += localk.fTV;
      paramk.id = localk.id;
      if (l - this.fUh > 300000L) {
        ab.i("MicroMsg.NetStat", paramk.toString());
      }
    }
    for (;;)
    {
      this.fUh = l;
      b(paramk);
      AppMethodBeat.o(78755);
      return;
      paramk.bsY |= 0x2;
      paramk.id = -1;
      if (localk != null) {
        ab.i("MicroMsg.NetStat", localk.toString());
      } else {
        ab.i("MicroMsg.NetStat", "NetStat started.");
      }
    }
  }
  
  public final void a(bb.b<Integer, k> paramb)
  {
    AppMethodBeat.i(78761);
    int i = paramb.ypQ;
    paramb = (k)paramb.values;
    if ((paramb != null) && (i == 1))
    {
      i = paramb.fTt;
      int j = paramb.id;
      if (i > 0)
      {
        ContentValues localContentValues = new ContentValues();
        if ((paramb.bsY & 0x2) != 0) {
          localContentValues.put("peroid", Integer.valueOf(paramb.fTt));
        }
        if ((paramb.bsY & 0x4) != 0) {
          localContentValues.put("textCountIn", Integer.valueOf(paramb.fTu));
        }
        if ((paramb.bsY & 0x8) != 0) {
          localContentValues.put("textBytesIn", Integer.valueOf(paramb.fTv));
        }
        if ((paramb.bsY & 0x10) != 0) {
          localContentValues.put("imageCountIn", Integer.valueOf(paramb.fTw));
        }
        if ((paramb.bsY & 0x20) != 0) {
          localContentValues.put("imageBytesIn", Integer.valueOf(paramb.fTx));
        }
        if ((paramb.bsY & 0x40) != 0) {
          localContentValues.put("voiceCountIn", Integer.valueOf(paramb.fTy));
        }
        if ((paramb.bsY & 0x80) != 0) {
          localContentValues.put("voiceBytesIn", Integer.valueOf(paramb.fTz));
        }
        if ((paramb.bsY & 0x100) != 0) {
          localContentValues.put("videoCountIn", Integer.valueOf(paramb.fTA));
        }
        if ((paramb.bsY & 0x200) != 0) {
          localContentValues.put("videoBytesIn", Integer.valueOf(paramb.fTB));
        }
        if ((paramb.bsY & 0x400) != 0) {
          localContentValues.put("mobileBytesIn", Integer.valueOf(paramb.fTC));
        }
        if ((paramb.bsY & 0x800) != 0) {
          localContentValues.put("wifiBytesIn", Integer.valueOf(paramb.fTD));
        }
        if ((paramb.bsY & 0x1000) != 0) {
          localContentValues.put("sysMobileBytesIn", Integer.valueOf(paramb.fTE));
        }
        if ((paramb.bsY & 0x2000) != 0) {
          localContentValues.put("sysWifiBytesIn", Integer.valueOf(paramb.fTF));
        }
        if ((paramb.bsY & 0x4000) != 0) {
          localContentValues.put("textCountOut", Integer.valueOf(paramb.fTG));
        }
        if ((paramb.bsY & 0x8000) != 0) {
          localContentValues.put("textBytesOut", Integer.valueOf(paramb.fTH));
        }
        if ((paramb.bsY & 0x10000) != 0) {
          localContentValues.put("imageCountOut", Integer.valueOf(paramb.fTI));
        }
        if ((paramb.bsY & 0x20000) != 0) {
          localContentValues.put("imageBytesOut", Integer.valueOf(paramb.fTJ));
        }
        if ((paramb.bsY & 0x40000) != 0) {
          localContentValues.put("voiceCountOut", Integer.valueOf(paramb.fTK));
        }
        if ((paramb.bsY & 0x80000) != 0) {
          localContentValues.put("voiceBytesOut", Integer.valueOf(paramb.fTL));
        }
        if ((paramb.bsY & 0x100000) != 0) {
          localContentValues.put("videoCountOut", Integer.valueOf(paramb.fTM));
        }
        if ((paramb.bsY & 0x200000) != 0) {
          localContentValues.put("videoBytesOut", Integer.valueOf(paramb.fTN));
        }
        if ((paramb.bsY & 0x400000) != 0) {
          localContentValues.put("mobileBytesOut", Integer.valueOf(paramb.fTO));
        }
        if ((paramb.bsY & 0x800000) != 0) {
          localContentValues.put("wifiBytesOut", Integer.valueOf(paramb.fTP));
        }
        if ((paramb.bsY & 0x1000000) != 0) {
          localContentValues.put("sysMobileBytesOut", Integer.valueOf(paramb.fTQ));
        }
        if ((paramb.bsY & 0x2000000) != 0) {
          localContentValues.put("sysWifiBytesOut", Integer.valueOf(paramb.fTR));
        }
        if ((paramb.bsY & 0x4000000) != 0) {
          localContentValues.put("realMobileBytesIn", Integer.valueOf(paramb.fTS));
        }
        if ((paramb.bsY & 0x8000000) != 0) {
          localContentValues.put("realWifiBytesIn", Integer.valueOf(paramb.fTT));
        }
        if ((paramb.bsY & 0x10000000) != 0) {
          localContentValues.put("realMobileBytesOut", Integer.valueOf(paramb.fTU));
        }
        if ((paramb.bsY & 0x20000000) != 0) {
          localContentValues.put("realWifiBytesOut", Integer.valueOf(paramb.fTV));
        }
        if (j < 0)
        {
          paramb.id = ((int)this.fnw.a("netstat", "id", localContentValues));
          AppMethodBeat.o(78761);
          return;
        }
        this.fnw.update("netstat", localContentValues, "peroid=".concat(String.valueOf(i)), null);
      }
    }
    AppMethodBeat.o(78761);
  }
  
  public final long akE()
  {
    AppMethodBeat.i(78758);
    this.fUg.pM(true);
    int j = (int)((bo.aoy() - 1296000000L) / 86400000L);
    int i = (int)(bo.dtT() / 86400000L);
    Object localObject = "SELECT peroid FROM netstat  WHERE peroid > " + j + " order by peroid limit 1";
    localObject = this.fnw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("peroid"));
    }
    ((Cursor)localObject).close();
    long l = i;
    AppMethodBeat.o(78758);
    return l * 86400000L;
  }
  
  public final boolean akF()
  {
    AppMethodBeat.i(78760);
    if (this.fnw.inTransaction())
    {
      ab.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
      AppMethodBeat.o(78760);
      return false;
    }
    this.fUf = this.fnw.kr(Thread.currentThread().getId());
    if (this.fUf <= 0L)
    {
      ab.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.fUf + " return false");
      AppMethodBeat.o(78760);
      return false;
    }
    AppMethodBeat.o(78760);
    return true;
  }
  
  public final void akG()
  {
    AppMethodBeat.i(78762);
    if (this.fUf > 0L) {
      this.fnw.nY(this.fUf);
    }
    AppMethodBeat.o(78762);
  }
  
  public final boolean b(k paramk)
  {
    AppMethodBeat.i(78756);
    Assert.assertNotNull(paramk);
    if (paramk.fTt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      bool = this.fUg.x(Integer.valueOf(paramk.fTt), paramk);
      AppMethodBeat.o(78756);
      return bool;
    }
  }
  
  public final k mb(int paramInt)
  {
    AppMethodBeat.i(78754);
    Object localObject2 = (k)this.fUg.get(Integer.valueOf(paramInt));
    Object localObject3;
    Object localObject1;
    if (localObject2 == null)
    {
      localObject3 = this.fnw.a("netstat", null, "peroid = ".concat(String.valueOf(paramInt)), null, null, null, null, 2);
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new k();
        ((k)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
      if (localObject1 != null) {
        this.fUg.x(Integer.valueOf(paramInt), localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(78754);
      return localObject1;
      localObject2 = this.fUg;
      localObject3 = new k();
      ((k)localObject3).bsY = 0;
      ((k)localObject3).id = 0;
      ((k)localObject3).fTt = 0;
      ((k)localObject3).fTu = 0;
      ((k)localObject3).fTv = 0;
      ((k)localObject3).fTw = 0;
      ((k)localObject3).fTx = 0;
      ((k)localObject3).fTy = 0;
      ((k)localObject3).fTz = 0;
      ((k)localObject3).fTA = 0;
      ((k)localObject3).fTB = 0;
      ((k)localObject3).fTC = 0;
      ((k)localObject3).fTD = 0;
      ((k)localObject3).fTE = 0;
      ((k)localObject3).fTF = 0;
      ((k)localObject3).fTG = 0;
      ((k)localObject3).fTH = 0;
      ((k)localObject3).fTI = 0;
      ((k)localObject3).fTJ = 0;
      ((k)localObject3).fTK = 0;
      ((k)localObject3).fTL = 0;
      ((k)localObject3).fTM = 0;
      ((k)localObject3).fTN = 0;
      ((k)localObject3).fTO = 0;
      ((k)localObject3).fTP = 0;
      ((k)localObject3).fTQ = 0;
      ((k)localObject3).fTR = 0;
      ((k)localObject3).fTS = 0;
      ((k)localObject3).fTT = 0;
      ((k)localObject3).fTU = 0;
      ((k)localObject3).fTV = 0;
      ((bb)localObject2).x(Integer.valueOf(paramInt), localObject3);
      continue;
      localObject1 = localObject2;
      if (((k)localObject2).fTt != paramInt) {
        localObject1 = null;
      }
    }
  }
  
  public final k mc(int paramInt)
  {
    k localk = null;
    AppMethodBeat.i(78759);
    this.fUg.pM(true);
    Object localObject = "SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= ".concat(String.valueOf(paramInt));
    localObject = this.fnw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localk = new k();
      localk.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(78759);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.m
 * JD-Core Version:    0.7.0.1
 */