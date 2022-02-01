package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.sdk.platformtools.RWCache.Holder;
import com.tencent.mm.sdk.platformtools.RWCache.IRWCacheAppender;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import java.util.HashSet;
import junit.framework.Assert;

public final class l
  extends MStorage
  implements RWCache.IRWCacheAppender<Integer, j>
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) " };
  private static final String[] oXd = { "realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut" };
  private long oXa;
  public RWCache<Integer, j> oXb;
  private long oXc;
  public com.tencent.mm.storagebase.h omV;
  
  public l(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(151097);
    this.omV = paramh;
    this.oXb = new RWCache(this, com.tencent.mm.kernel.h.baH().getLooper(), 30, 2, 300000L, 1000L);
    paramh = new HashSet();
    Object localObject1 = oXd;
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      paramh.add(localObject1[i]);
      i += 1;
    }
    localObject1 = this.omV.rawQuery("PRAGMA table_info(netstat);", null, 2);
    i = ((Cursor)localObject1).getColumnIndex("name");
    while (((Cursor)localObject1).moveToNext()) {
      paramh.remove(((Cursor)localObject1).getString(i));
    }
    ((Cursor)localObject1).close();
    localObject1 = oXd;
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      Object localObject2 = localObject1[i];
      if (paramh.contains(localObject2))
      {
        localObject2 = "ALTER TABLE netstat ADD COLUMN " + (String)localObject2 + " INT;";
        this.omV.execSQL("netstat", (String)localObject2);
      }
      i += 1;
    }
    this.oXc = System.currentTimeMillis();
    AppMethodBeat.o(151097);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(151099);
    Assert.assertNotNull(paramj);
    long l = System.currentTimeMillis();
    if (paramj.oWo <= 0) {
      paramj.oWo = ((int)(l / 86400000L));
    }
    if (paramj.oWo <= 0)
    {
      AppMethodBeat.o(151099);
      return;
    }
    j localj = wT(paramj.oWo);
    if ((localj != null) && (paramj.oWo == localj.oWo))
    {
      localj.eQp |= 0x1;
      paramj.oWp = ((int)(paramj.oWp + localj.oWq));
      paramj.oWq += localj.oWq;
      paramj.oWr = ((int)(paramj.oWr + localj.oWs));
      paramj.oWs += localj.oWs;
      paramj.oWt += localj.oWt;
      paramj.oWu += localj.oWu;
      paramj.oWv += localj.oWv;
      paramj.oWw += localj.oWw;
      paramj.oWx += localj.oWx;
      paramj.oWy += localj.oWy;
      paramj.oWz += localj.oWz;
      paramj.oWA += localj.oWA;
      paramj.oWB = ((int)(paramj.oWB + localj.oWC));
      paramj.oWC += localj.oWC;
      paramj.oWD = ((int)(paramj.oWD + localj.oWE));
      paramj.oWE += localj.oWE;
      paramj.oWF += localj.oWF;
      paramj.oWG += localj.oWG;
      paramj.oWH += localj.oWH;
      paramj.oWI += localj.oWI;
      paramj.oWJ += localj.oWJ;
      paramj.oWK += localj.oWK;
      paramj.oWL += localj.oWL;
      paramj.oWM += localj.oWM;
      paramj.oWN += localj.oWN;
      paramj.oWO += localj.oWO;
      paramj.oWP += localj.oWP;
      paramj.oWQ += localj.oWQ;
      paramj.id = localj.id;
      paramj.eQp |= 0x2;
      if (l - this.oXc > 300000L) {
        Log.i("MicroMsg.NetStat", paramj.toString());
      }
    }
    for (;;)
    {
      this.oXc = l;
      b(paramj);
      AppMethodBeat.o(151099);
      return;
      paramj.eQp |= 0x2;
      paramj.id = -1;
      if (localj != null) {
        Log.i("MicroMsg.NetStat", localj.toString());
      } else {
        Log.i("MicroMsg.NetStat", "NetStat started.");
      }
    }
  }
  
  public final void append(RWCache<Integer, j> paramRWCache, RWCache.Holder<Integer, j> paramHolder)
  {
    AppMethodBeat.i(242915);
    int i = paramHolder.funcType;
    paramRWCache = (j)paramHolder.values;
    if ((paramRWCache != null) && (i == 1))
    {
      i = paramRWCache.oWo;
      int j = paramRWCache.id;
      if (i > 0)
      {
        paramHolder = new ContentValues();
        if ((paramRWCache.eQp & 0x2) != 0) {
          paramHolder.put("peroid", Integer.valueOf(paramRWCache.oWo));
        }
        if ((paramRWCache.eQp & 0x4) != 0) {
          paramHolder.put("textCountIn", Integer.valueOf(paramRWCache.oWp));
        }
        if ((paramRWCache.eQp & 0x8) != 0) {
          paramHolder.put("textBytesIn", Long.valueOf(paramRWCache.oWq));
        }
        if ((paramRWCache.eQp & 0x10) != 0) {
          paramHolder.put("imageCountIn", Integer.valueOf(paramRWCache.oWr));
        }
        if ((paramRWCache.eQp & 0x20) != 0) {
          paramHolder.put("imageBytesIn", Long.valueOf(paramRWCache.oWs));
        }
        if ((paramRWCache.eQp & 0x40) != 0) {
          paramHolder.put("voiceCountIn", Integer.valueOf(paramRWCache.oWt));
        }
        if ((paramRWCache.eQp & 0x80) != 0) {
          paramHolder.put("voiceBytesIn", Long.valueOf(paramRWCache.oWu));
        }
        if ((paramRWCache.eQp & 0x100) != 0) {
          paramHolder.put("videoCountIn", Integer.valueOf(paramRWCache.oWv));
        }
        if ((paramRWCache.eQp & 0x200) != 0) {
          paramHolder.put("videoBytesIn", Long.valueOf(paramRWCache.oWw));
        }
        if ((paramRWCache.eQp & 0x400) != 0) {
          paramHolder.put("mobileBytesIn", Long.valueOf(paramRWCache.oWx));
        }
        if ((paramRWCache.eQp & 0x800) != 0) {
          paramHolder.put("wifiBytesIn", Long.valueOf(paramRWCache.oWy));
        }
        if ((paramRWCache.eQp & 0x1000) != 0) {
          paramHolder.put("sysMobileBytesIn", Long.valueOf(paramRWCache.oWz));
        }
        if ((paramRWCache.eQp & 0x2000) != 0) {
          paramHolder.put("sysWifiBytesIn", Long.valueOf(paramRWCache.oWA));
        }
        if ((paramRWCache.eQp & 0x4000) != 0) {
          paramHolder.put("textCountOut", Integer.valueOf(paramRWCache.oWB));
        }
        if ((paramRWCache.eQp & 0x8000) != 0) {
          paramHolder.put("textBytesOut", Long.valueOf(paramRWCache.oWC));
        }
        if ((paramRWCache.eQp & 0x10000) != 0) {
          paramHolder.put("imageCountOut", Integer.valueOf(paramRWCache.oWD));
        }
        if ((paramRWCache.eQp & 0x20000) != 0) {
          paramHolder.put("imageBytesOut", Long.valueOf(paramRWCache.oWE));
        }
        if ((paramRWCache.eQp & 0x40000) != 0) {
          paramHolder.put("voiceCountOut", Integer.valueOf(paramRWCache.oWF));
        }
        if ((paramRWCache.eQp & 0x80000) != 0) {
          paramHolder.put("voiceBytesOut", Long.valueOf(paramRWCache.oWG));
        }
        if ((paramRWCache.eQp & 0x100000) != 0) {
          paramHolder.put("videoCountOut", Integer.valueOf(paramRWCache.oWH));
        }
        if ((paramRWCache.eQp & 0x200000) != 0) {
          paramHolder.put("videoBytesOut", Long.valueOf(paramRWCache.oWI));
        }
        if ((paramRWCache.eQp & 0x400000) != 0) {
          paramHolder.put("mobileBytesOut", Long.valueOf(paramRWCache.oWJ));
        }
        if ((paramRWCache.eQp & 0x800000) != 0) {
          paramHolder.put("wifiBytesOut", Long.valueOf(paramRWCache.oWK));
        }
        if ((paramRWCache.eQp & 0x1000000) != 0) {
          paramHolder.put("sysMobileBytesOut", Long.valueOf(paramRWCache.oWL));
        }
        if ((paramRWCache.eQp & 0x2000000) != 0) {
          paramHolder.put("sysWifiBytesOut", Long.valueOf(paramRWCache.oWM));
        }
        if ((paramRWCache.eQp & 0x4000000) != 0) {
          paramHolder.put("realMobileBytesIn", Long.valueOf(paramRWCache.oWN));
        }
        if ((paramRWCache.eQp & 0x8000000) != 0) {
          paramHolder.put("realWifiBytesIn", Long.valueOf(paramRWCache.oWO));
        }
        if ((paramRWCache.eQp & 0x10000000) != 0) {
          paramHolder.put("realMobileBytesOut", Long.valueOf(paramRWCache.oWP));
        }
        if ((paramRWCache.eQp & 0x20000000) != 0) {
          paramHolder.put("realWifiBytesOut", Long.valueOf(paramRWCache.oWQ));
        }
        if (j < 0)
        {
          paramRWCache.id = ((int)this.omV.insert("netstat", "id", paramHolder));
          AppMethodBeat.o(242915);
          return;
        }
        this.omV.update("netstat", paramHolder, "peroid=".concat(String.valueOf(i)), null);
      }
    }
    AppMethodBeat.o(242915);
  }
  
  public final boolean b(j paramj)
  {
    AppMethodBeat.i(151100);
    Assert.assertNotNull(paramj);
    if (paramj.oWo > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      bool = this.oXb.set(Integer.valueOf(paramj.oWo), paramj);
      AppMethodBeat.o(151100);
      return bool;
    }
  }
  
  public final long bNe()
  {
    AppMethodBeat.i(151101);
    this.oXb.appendAll(true);
    int j = (int)((Util.nowMilliSecond() - 1296000000L) / 86400000L);
    int i = (int)(Util.currentDayInMills() / 86400000L);
    Object localObject = "SELECT peroid FROM netstat  WHERE peroid > " + j + " order by peroid limit 1";
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("peroid"));
    }
    ((Cursor)localObject).close();
    long l = i;
    AppMethodBeat.o(151101);
    return l * 86400000L;
  }
  
  public final void postAppend()
  {
    AppMethodBeat.i(151105);
    if (this.oXa > 0L) {
      this.omV.endTransaction(this.oXa);
    }
    AppMethodBeat.o(151105);
  }
  
  public final boolean preAppend()
  {
    AppMethodBeat.i(151103);
    if (this.omV.inTransaction())
    {
      Log.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
      AppMethodBeat.o(151103);
      return false;
    }
    this.oXa = this.omV.beginTransaction(Thread.currentThread().getId());
    if (this.oXa <= 0L)
    {
      Log.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.oXa + " return false");
      AppMethodBeat.o(151103);
      return false;
    }
    AppMethodBeat.o(151103);
    return true;
  }
  
  public final j wT(int paramInt)
  {
    AppMethodBeat.i(151098);
    Object localObject2 = (j)this.oXb.get(Integer.valueOf(paramInt));
    Object localObject3;
    Object localObject1;
    if (localObject2 == null)
    {
      localObject3 = this.omV.query("netstat", null, "peroid = ".concat(String.valueOf(paramInt)), null, null, null, null, 2);
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new j();
        ((j)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
      if (localObject1 != null) {
        this.oXb.set(Integer.valueOf(paramInt), localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(151098);
      return localObject1;
      localObject2 = this.oXb;
      localObject3 = new j();
      ((j)localObject3).eQp = 0;
      ((j)localObject3).id = 0;
      ((j)localObject3).oWo = 0;
      ((j)localObject3).oWp = 0;
      ((j)localObject3).oWq = 0L;
      ((j)localObject3).oWr = 0;
      ((j)localObject3).oWs = 0L;
      ((j)localObject3).oWt = 0;
      ((j)localObject3).oWu = 0L;
      ((j)localObject3).oWv = 0;
      ((j)localObject3).oWw = 0L;
      ((j)localObject3).oWx = 0L;
      ((j)localObject3).oWy = 0L;
      ((j)localObject3).oWz = 0L;
      ((j)localObject3).oWA = 0L;
      ((j)localObject3).oWB = 0;
      ((j)localObject3).oWC = 0L;
      ((j)localObject3).oWD = 0;
      ((j)localObject3).oWE = 0L;
      ((j)localObject3).oWF = 0;
      ((j)localObject3).oWG = 0L;
      ((j)localObject3).oWH = 0;
      ((j)localObject3).oWI = 0L;
      ((j)localObject3).oWJ = 0L;
      ((j)localObject3).oWK = 0L;
      ((j)localObject3).oWL = 0L;
      ((j)localObject3).oWM = 0L;
      ((j)localObject3).oWN = 0L;
      ((j)localObject3).oWO = 0L;
      ((j)localObject3).oWP = 0L;
      ((j)localObject3).oWQ = 0L;
      ((RWCache)localObject2).set(Integer.valueOf(paramInt), localObject3);
      continue;
      localObject1 = localObject2;
      if (((j)localObject2).oWo != paramInt) {
        localObject1 = null;
      }
    }
  }
  
  public final j wU(int paramInt)
  {
    j localj = null;
    AppMethodBeat.i(151102);
    this.oXb.appendAll(true);
    Object localObject = "SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= ".concat(String.valueOf(paramInt));
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localj = new j();
      localj.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(151102);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.l
 * JD-Core Version:    0.7.0.1
 */