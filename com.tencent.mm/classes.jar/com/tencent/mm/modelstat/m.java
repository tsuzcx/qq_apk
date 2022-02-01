package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.sdk.platformtools.RWCache.Holder;
import com.tencent.mm.sdk.platformtools.RWCache.IRWCacheAppender;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashSet;
import junit.framework.Assert;

public final class m
  extends MStorage
  implements RWCache.IRWCacheAppender<Integer, k>
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) " };
  private static final String[] joU = { "realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut" };
  public h iFy;
  private long joR;
  public RWCache<Integer, k> joS;
  private long joT;
  
  public m(h paramh)
  {
    AppMethodBeat.i(151097);
    this.iFy = paramh;
    this.joS = new RWCache(this, g.aAk().getLooper(), 30, 2, 300000L, 1000L);
    paramh = new HashSet();
    Object localObject1 = joU;
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      paramh.add(localObject1[i]);
      i += 1;
    }
    localObject1 = this.iFy.rawQuery("PRAGMA table_info(netstat);", null, 2);
    i = ((Cursor)localObject1).getColumnIndex("name");
    while (((Cursor)localObject1).moveToNext()) {
      paramh.remove(((Cursor)localObject1).getString(i));
    }
    ((Cursor)localObject1).close();
    localObject1 = joU;
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      Object localObject2 = localObject1[i];
      if (paramh.contains(localObject2))
      {
        localObject2 = "ALTER TABLE netstat ADD COLUMN " + (String)localObject2 + " INT;";
        this.iFy.execSQL("netstat", (String)localObject2);
      }
      i += 1;
    }
    this.joT = System.currentTimeMillis();
    AppMethodBeat.o(151097);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(151099);
    Assert.assertNotNull(paramk);
    long l = System.currentTimeMillis();
    if (paramk.jog <= 0) {
      paramk.jog = ((int)(l / 86400000L));
    }
    if (paramk.jog <= 0)
    {
      AppMethodBeat.o(151099);
      return;
    }
    k localk = tU(paramk.jog);
    if ((localk != null) && (paramk.jog == localk.jog))
    {
      localk.cSx |= 0x1;
      paramk.joh = ((int)(paramk.joh + localk.joi));
      paramk.joi += localk.joi;
      paramk.joj = ((int)(paramk.joj + localk.jok));
      paramk.jok += localk.jok;
      paramk.jol += localk.jol;
      paramk.jom += localk.jom;
      paramk.jon += localk.jon;
      paramk.joo += localk.joo;
      paramk.jop += localk.jop;
      paramk.joq += localk.joq;
      paramk.jor += localk.jor;
      paramk.jos += localk.jos;
      paramk.jot = ((int)(paramk.jot + localk.jou));
      paramk.jou += localk.jou;
      paramk.jov = ((int)(paramk.jov + localk.jow));
      paramk.jow += localk.jow;
      paramk.jox += localk.jox;
      paramk.joy += localk.joy;
      paramk.joz += localk.joz;
      paramk.joA += localk.joA;
      paramk.joB += localk.joB;
      paramk.joC += localk.joC;
      paramk.joD += localk.joD;
      paramk.joE += localk.joE;
      paramk.joF += localk.joF;
      paramk.joG += localk.joG;
      paramk.joH += localk.joH;
      paramk.joI += localk.joI;
      paramk.id = localk.id;
      paramk.cSx |= 0x2;
      if (l - this.joT > 300000L) {
        Log.i("MicroMsg.NetStat", paramk.toString());
      }
    }
    for (;;)
    {
      this.joT = l;
      b(paramk);
      AppMethodBeat.o(151099);
      return;
      paramk.cSx |= 0x2;
      paramk.id = -1;
      if (localk != null) {
        Log.i("MicroMsg.NetStat", localk.toString());
      } else {
        Log.i("MicroMsg.NetStat", "NetStat started.");
      }
    }
  }
  
  public final void append(RWCache<Integer, k> paramRWCache, RWCache.Holder<Integer, k> paramHolder)
  {
    AppMethodBeat.i(223642);
    int i = paramHolder.funcType;
    paramRWCache = (k)paramHolder.values;
    if ((paramRWCache != null) && (i == 1))
    {
      i = paramRWCache.jog;
      int j = paramRWCache.id;
      if (i > 0)
      {
        paramHolder = new ContentValues();
        if ((paramRWCache.cSx & 0x2) != 0) {
          paramHolder.put("peroid", Integer.valueOf(paramRWCache.jog));
        }
        if ((paramRWCache.cSx & 0x4) != 0) {
          paramHolder.put("textCountIn", Integer.valueOf(paramRWCache.joh));
        }
        if ((paramRWCache.cSx & 0x8) != 0) {
          paramHolder.put("textBytesIn", Long.valueOf(paramRWCache.joi));
        }
        if ((paramRWCache.cSx & 0x10) != 0) {
          paramHolder.put("imageCountIn", Integer.valueOf(paramRWCache.joj));
        }
        if ((paramRWCache.cSx & 0x20) != 0) {
          paramHolder.put("imageBytesIn", Long.valueOf(paramRWCache.jok));
        }
        if ((paramRWCache.cSx & 0x40) != 0) {
          paramHolder.put("voiceCountIn", Integer.valueOf(paramRWCache.jol));
        }
        if ((paramRWCache.cSx & 0x80) != 0) {
          paramHolder.put("voiceBytesIn", Long.valueOf(paramRWCache.jom));
        }
        if ((paramRWCache.cSx & 0x100) != 0) {
          paramHolder.put("videoCountIn", Integer.valueOf(paramRWCache.jon));
        }
        if ((paramRWCache.cSx & 0x200) != 0) {
          paramHolder.put("videoBytesIn", Long.valueOf(paramRWCache.joo));
        }
        if ((paramRWCache.cSx & 0x400) != 0) {
          paramHolder.put("mobileBytesIn", Long.valueOf(paramRWCache.jop));
        }
        if ((paramRWCache.cSx & 0x800) != 0) {
          paramHolder.put("wifiBytesIn", Long.valueOf(paramRWCache.joq));
        }
        if ((paramRWCache.cSx & 0x1000) != 0) {
          paramHolder.put("sysMobileBytesIn", Long.valueOf(paramRWCache.jor));
        }
        if ((paramRWCache.cSx & 0x2000) != 0) {
          paramHolder.put("sysWifiBytesIn", Long.valueOf(paramRWCache.jos));
        }
        if ((paramRWCache.cSx & 0x4000) != 0) {
          paramHolder.put("textCountOut", Integer.valueOf(paramRWCache.jot));
        }
        if ((paramRWCache.cSx & 0x8000) != 0) {
          paramHolder.put("textBytesOut", Long.valueOf(paramRWCache.jou));
        }
        if ((paramRWCache.cSx & 0x10000) != 0) {
          paramHolder.put("imageCountOut", Integer.valueOf(paramRWCache.jov));
        }
        if ((paramRWCache.cSx & 0x20000) != 0) {
          paramHolder.put("imageBytesOut", Long.valueOf(paramRWCache.jow));
        }
        if ((paramRWCache.cSx & 0x40000) != 0) {
          paramHolder.put("voiceCountOut", Integer.valueOf(paramRWCache.jox));
        }
        if ((paramRWCache.cSx & 0x80000) != 0) {
          paramHolder.put("voiceBytesOut", Long.valueOf(paramRWCache.joy));
        }
        if ((paramRWCache.cSx & 0x100000) != 0) {
          paramHolder.put("videoCountOut", Integer.valueOf(paramRWCache.joz));
        }
        if ((paramRWCache.cSx & 0x200000) != 0) {
          paramHolder.put("videoBytesOut", Long.valueOf(paramRWCache.joA));
        }
        if ((paramRWCache.cSx & 0x400000) != 0) {
          paramHolder.put("mobileBytesOut", Long.valueOf(paramRWCache.joB));
        }
        if ((paramRWCache.cSx & 0x800000) != 0) {
          paramHolder.put("wifiBytesOut", Long.valueOf(paramRWCache.joC));
        }
        if ((paramRWCache.cSx & 0x1000000) != 0) {
          paramHolder.put("sysMobileBytesOut", Long.valueOf(paramRWCache.joD));
        }
        if ((paramRWCache.cSx & 0x2000000) != 0) {
          paramHolder.put("sysWifiBytesOut", Long.valueOf(paramRWCache.joE));
        }
        if ((paramRWCache.cSx & 0x4000000) != 0) {
          paramHolder.put("realMobileBytesIn", Long.valueOf(paramRWCache.joF));
        }
        if ((paramRWCache.cSx & 0x8000000) != 0) {
          paramHolder.put("realWifiBytesIn", Long.valueOf(paramRWCache.joG));
        }
        if ((paramRWCache.cSx & 0x10000000) != 0) {
          paramHolder.put("realMobileBytesOut", Long.valueOf(paramRWCache.joH));
        }
        if ((paramRWCache.cSx & 0x20000000) != 0) {
          paramHolder.put("realWifiBytesOut", Long.valueOf(paramRWCache.joI));
        }
        if (j < 0)
        {
          paramRWCache.id = ((int)this.iFy.insert("netstat", "id", paramHolder));
          AppMethodBeat.o(223642);
          return;
        }
        this.iFy.update("netstat", paramHolder, "peroid=".concat(String.valueOf(i)), null);
      }
    }
    AppMethodBeat.o(223642);
  }
  
  public final boolean b(k paramk)
  {
    AppMethodBeat.i(151100);
    Assert.assertNotNull(paramk);
    if (paramk.jog > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      bool = this.joS.set(Integer.valueOf(paramk.jog), paramk);
      AppMethodBeat.o(151100);
      return bool;
    }
  }
  
  public final long bgj()
  {
    AppMethodBeat.i(151101);
    this.joS.appendAll(true);
    int j = (int)((Util.nowMilliSecond() - 1296000000L) / 86400000L);
    int i = (int)(Util.currentDayInMills() / 86400000L);
    Object localObject = "SELECT peroid FROM netstat  WHERE peroid > " + j + " order by peroid limit 1";
    localObject = this.iFy.rawQuery((String)localObject, null, 2);
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
    if (this.joR > 0L) {
      this.iFy.endTransaction(this.joR);
    }
    AppMethodBeat.o(151105);
  }
  
  public final boolean preAppend()
  {
    AppMethodBeat.i(151103);
    if (this.iFy.inTransaction())
    {
      Log.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
      AppMethodBeat.o(151103);
      return false;
    }
    this.joR = this.iFy.beginTransaction(Thread.currentThread().getId());
    if (this.joR <= 0L)
    {
      Log.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.joR + " return false");
      AppMethodBeat.o(151103);
      return false;
    }
    AppMethodBeat.o(151103);
    return true;
  }
  
  public final k tU(int paramInt)
  {
    AppMethodBeat.i(151098);
    Object localObject2 = (k)this.joS.get(Integer.valueOf(paramInt));
    Object localObject3;
    Object localObject1;
    if (localObject2 == null)
    {
      localObject3 = this.iFy.query("netstat", null, "peroid = ".concat(String.valueOf(paramInt)), null, null, null, null, 2);
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new k();
        ((k)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
      if (localObject1 != null) {
        this.joS.set(Integer.valueOf(paramInt), localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(151098);
      return localObject1;
      localObject2 = this.joS;
      localObject3 = new k();
      ((k)localObject3).cSx = 0;
      ((k)localObject3).id = 0;
      ((k)localObject3).jog = 0;
      ((k)localObject3).joh = 0;
      ((k)localObject3).joi = 0L;
      ((k)localObject3).joj = 0;
      ((k)localObject3).jok = 0L;
      ((k)localObject3).jol = 0;
      ((k)localObject3).jom = 0L;
      ((k)localObject3).jon = 0;
      ((k)localObject3).joo = 0L;
      ((k)localObject3).jop = 0L;
      ((k)localObject3).joq = 0L;
      ((k)localObject3).jor = 0L;
      ((k)localObject3).jos = 0L;
      ((k)localObject3).jot = 0;
      ((k)localObject3).jou = 0L;
      ((k)localObject3).jov = 0;
      ((k)localObject3).jow = 0L;
      ((k)localObject3).jox = 0;
      ((k)localObject3).joy = 0L;
      ((k)localObject3).joz = 0;
      ((k)localObject3).joA = 0L;
      ((k)localObject3).joB = 0L;
      ((k)localObject3).joC = 0L;
      ((k)localObject3).joD = 0L;
      ((k)localObject3).joE = 0L;
      ((k)localObject3).joF = 0L;
      ((k)localObject3).joG = 0L;
      ((k)localObject3).joH = 0L;
      ((k)localObject3).joI = 0L;
      ((RWCache)localObject2).set(Integer.valueOf(paramInt), localObject3);
      continue;
      localObject1 = localObject2;
      if (((k)localObject2).jog != paramInt) {
        localObject1 = null;
      }
    }
  }
  
  public final k tV(int paramInt)
  {
    k localk = null;
    AppMethodBeat.i(151102);
    this.joS.appendAll(true);
    Object localObject = "SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= ".concat(String.valueOf(paramInt));
    localObject = this.iFy.rawQuery((String)localObject, null, 2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.m
 * JD-Core Version:    0.7.0.1
 */