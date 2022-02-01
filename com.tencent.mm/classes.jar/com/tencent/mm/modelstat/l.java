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
  private static final String[] mek = { "realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut" };
  public com.tencent.mm.storagebase.h lvy;
  private long meh;
  public RWCache<Integer, j> mei;
  private long mej;
  
  public l(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(151097);
    this.lvy = paramh;
    this.mei = new RWCache(this, com.tencent.mm.kernel.h.aHJ().getLooper(), 30, 2, 300000L, 1000L);
    paramh = new HashSet();
    Object localObject1 = mek;
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      paramh.add(localObject1[i]);
      i += 1;
    }
    localObject1 = this.lvy.rawQuery("PRAGMA table_info(netstat);", null, 2);
    i = ((Cursor)localObject1).getColumnIndex("name");
    while (((Cursor)localObject1).moveToNext()) {
      paramh.remove(((Cursor)localObject1).getString(i));
    }
    ((Cursor)localObject1).close();
    localObject1 = mek;
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      Object localObject2 = localObject1[i];
      if (paramh.contains(localObject2))
      {
        localObject2 = "ALTER TABLE netstat ADD COLUMN " + (String)localObject2 + " INT;";
        this.lvy.execSQL("netstat", (String)localObject2);
      }
      i += 1;
    }
    this.mej = System.currentTimeMillis();
    AppMethodBeat.o(151097);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(151099);
    Assert.assertNotNull(paramj);
    long l = System.currentTimeMillis();
    if (paramj.mdv <= 0) {
      paramj.mdv = ((int)(l / 86400000L));
    }
    if (paramj.mdv <= 0)
    {
      AppMethodBeat.o(151099);
      return;
    }
    j localj = wT(paramj.mdv);
    if ((localj != null) && (paramj.mdv == localj.mdv))
    {
      localj.cUP |= 0x1;
      paramj.mdw = ((int)(paramj.mdw + localj.mdx));
      paramj.mdx += localj.mdx;
      paramj.mdy = ((int)(paramj.mdy + localj.mdz));
      paramj.mdz += localj.mdz;
      paramj.mdA += localj.mdA;
      paramj.mdB += localj.mdB;
      paramj.mdC += localj.mdC;
      paramj.mdD += localj.mdD;
      paramj.mdE += localj.mdE;
      paramj.mdF += localj.mdF;
      paramj.mdG += localj.mdG;
      paramj.mdH += localj.mdH;
      paramj.mdI = ((int)(paramj.mdI + localj.mdJ));
      paramj.mdJ += localj.mdJ;
      paramj.mdK = ((int)(paramj.mdK + localj.mdL));
      paramj.mdL += localj.mdL;
      paramj.mdM += localj.mdM;
      paramj.mdN += localj.mdN;
      paramj.mdO += localj.mdO;
      paramj.mdP += localj.mdP;
      paramj.mdQ += localj.mdQ;
      paramj.mdR += localj.mdR;
      paramj.mdS += localj.mdS;
      paramj.mdT += localj.mdT;
      paramj.mdU += localj.mdU;
      paramj.mdV += localj.mdV;
      paramj.mdW += localj.mdW;
      paramj.mdX += localj.mdX;
      paramj.id = localj.id;
      paramj.cUP |= 0x2;
      if (l - this.mej > 300000L) {
        Log.i("MicroMsg.NetStat", paramj.toString());
      }
    }
    for (;;)
    {
      this.mej = l;
      b(paramj);
      AppMethodBeat.o(151099);
      return;
      paramj.cUP |= 0x2;
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
    AppMethodBeat.i(187587);
    int i = paramHolder.funcType;
    paramRWCache = (j)paramHolder.values;
    if ((paramRWCache != null) && (i == 1))
    {
      i = paramRWCache.mdv;
      int j = paramRWCache.id;
      if (i > 0)
      {
        paramHolder = new ContentValues();
        if ((paramRWCache.cUP & 0x2) != 0) {
          paramHolder.put("peroid", Integer.valueOf(paramRWCache.mdv));
        }
        if ((paramRWCache.cUP & 0x4) != 0) {
          paramHolder.put("textCountIn", Integer.valueOf(paramRWCache.mdw));
        }
        if ((paramRWCache.cUP & 0x8) != 0) {
          paramHolder.put("textBytesIn", Long.valueOf(paramRWCache.mdx));
        }
        if ((paramRWCache.cUP & 0x10) != 0) {
          paramHolder.put("imageCountIn", Integer.valueOf(paramRWCache.mdy));
        }
        if ((paramRWCache.cUP & 0x20) != 0) {
          paramHolder.put("imageBytesIn", Long.valueOf(paramRWCache.mdz));
        }
        if ((paramRWCache.cUP & 0x40) != 0) {
          paramHolder.put("voiceCountIn", Integer.valueOf(paramRWCache.mdA));
        }
        if ((paramRWCache.cUP & 0x80) != 0) {
          paramHolder.put("voiceBytesIn", Long.valueOf(paramRWCache.mdB));
        }
        if ((paramRWCache.cUP & 0x100) != 0) {
          paramHolder.put("videoCountIn", Integer.valueOf(paramRWCache.mdC));
        }
        if ((paramRWCache.cUP & 0x200) != 0) {
          paramHolder.put("videoBytesIn", Long.valueOf(paramRWCache.mdD));
        }
        if ((paramRWCache.cUP & 0x400) != 0) {
          paramHolder.put("mobileBytesIn", Long.valueOf(paramRWCache.mdE));
        }
        if ((paramRWCache.cUP & 0x800) != 0) {
          paramHolder.put("wifiBytesIn", Long.valueOf(paramRWCache.mdF));
        }
        if ((paramRWCache.cUP & 0x1000) != 0) {
          paramHolder.put("sysMobileBytesIn", Long.valueOf(paramRWCache.mdG));
        }
        if ((paramRWCache.cUP & 0x2000) != 0) {
          paramHolder.put("sysWifiBytesIn", Long.valueOf(paramRWCache.mdH));
        }
        if ((paramRWCache.cUP & 0x4000) != 0) {
          paramHolder.put("textCountOut", Integer.valueOf(paramRWCache.mdI));
        }
        if ((paramRWCache.cUP & 0x8000) != 0) {
          paramHolder.put("textBytesOut", Long.valueOf(paramRWCache.mdJ));
        }
        if ((paramRWCache.cUP & 0x10000) != 0) {
          paramHolder.put("imageCountOut", Integer.valueOf(paramRWCache.mdK));
        }
        if ((paramRWCache.cUP & 0x20000) != 0) {
          paramHolder.put("imageBytesOut", Long.valueOf(paramRWCache.mdL));
        }
        if ((paramRWCache.cUP & 0x40000) != 0) {
          paramHolder.put("voiceCountOut", Integer.valueOf(paramRWCache.mdM));
        }
        if ((paramRWCache.cUP & 0x80000) != 0) {
          paramHolder.put("voiceBytesOut", Long.valueOf(paramRWCache.mdN));
        }
        if ((paramRWCache.cUP & 0x100000) != 0) {
          paramHolder.put("videoCountOut", Integer.valueOf(paramRWCache.mdO));
        }
        if ((paramRWCache.cUP & 0x200000) != 0) {
          paramHolder.put("videoBytesOut", Long.valueOf(paramRWCache.mdP));
        }
        if ((paramRWCache.cUP & 0x400000) != 0) {
          paramHolder.put("mobileBytesOut", Long.valueOf(paramRWCache.mdQ));
        }
        if ((paramRWCache.cUP & 0x800000) != 0) {
          paramHolder.put("wifiBytesOut", Long.valueOf(paramRWCache.mdR));
        }
        if ((paramRWCache.cUP & 0x1000000) != 0) {
          paramHolder.put("sysMobileBytesOut", Long.valueOf(paramRWCache.mdS));
        }
        if ((paramRWCache.cUP & 0x2000000) != 0) {
          paramHolder.put("sysWifiBytesOut", Long.valueOf(paramRWCache.mdT));
        }
        if ((paramRWCache.cUP & 0x4000000) != 0) {
          paramHolder.put("realMobileBytesIn", Long.valueOf(paramRWCache.mdU));
        }
        if ((paramRWCache.cUP & 0x8000000) != 0) {
          paramHolder.put("realWifiBytesIn", Long.valueOf(paramRWCache.mdV));
        }
        if ((paramRWCache.cUP & 0x10000000) != 0) {
          paramHolder.put("realMobileBytesOut", Long.valueOf(paramRWCache.mdW));
        }
        if ((paramRWCache.cUP & 0x20000000) != 0) {
          paramHolder.put("realWifiBytesOut", Long.valueOf(paramRWCache.mdX));
        }
        if (j < 0)
        {
          paramRWCache.id = ((int)this.lvy.insert("netstat", "id", paramHolder));
          AppMethodBeat.o(187587);
          return;
        }
        this.lvy.update("netstat", paramHolder, "peroid=".concat(String.valueOf(i)), null);
      }
    }
    AppMethodBeat.o(187587);
  }
  
  public final boolean b(j paramj)
  {
    AppMethodBeat.i(151100);
    Assert.assertNotNull(paramj);
    if (paramj.mdv > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      bool = this.mei.set(Integer.valueOf(paramj.mdv), paramj);
      AppMethodBeat.o(151100);
      return bool;
    }
  }
  
  public final long bpx()
  {
    AppMethodBeat.i(151101);
    this.mei.appendAll(true);
    int j = (int)((Util.nowMilliSecond() - 1296000000L) / 86400000L);
    int i = (int)(Util.currentDayInMills() / 86400000L);
    Object localObject = "SELECT peroid FROM netstat  WHERE peroid > " + j + " order by peroid limit 1";
    localObject = this.lvy.rawQuery((String)localObject, null, 2);
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
    if (this.meh > 0L) {
      this.lvy.endTransaction(this.meh);
    }
    AppMethodBeat.o(151105);
  }
  
  public final boolean preAppend()
  {
    AppMethodBeat.i(151103);
    if (this.lvy.inTransaction())
    {
      Log.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
      AppMethodBeat.o(151103);
      return false;
    }
    this.meh = this.lvy.beginTransaction(Thread.currentThread().getId());
    if (this.meh <= 0L)
    {
      Log.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.meh + " return false");
      AppMethodBeat.o(151103);
      return false;
    }
    AppMethodBeat.o(151103);
    return true;
  }
  
  public final j wT(int paramInt)
  {
    AppMethodBeat.i(151098);
    Object localObject2 = (j)this.mei.get(Integer.valueOf(paramInt));
    Object localObject3;
    Object localObject1;
    if (localObject2 == null)
    {
      localObject3 = this.lvy.query("netstat", null, "peroid = ".concat(String.valueOf(paramInt)), null, null, null, null, 2);
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new j();
        ((j)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
      if (localObject1 != null) {
        this.mei.set(Integer.valueOf(paramInt), localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(151098);
      return localObject1;
      localObject2 = this.mei;
      localObject3 = new j();
      ((j)localObject3).cUP = 0;
      ((j)localObject3).id = 0;
      ((j)localObject3).mdv = 0;
      ((j)localObject3).mdw = 0;
      ((j)localObject3).mdx = 0L;
      ((j)localObject3).mdy = 0;
      ((j)localObject3).mdz = 0L;
      ((j)localObject3).mdA = 0;
      ((j)localObject3).mdB = 0L;
      ((j)localObject3).mdC = 0;
      ((j)localObject3).mdD = 0L;
      ((j)localObject3).mdE = 0L;
      ((j)localObject3).mdF = 0L;
      ((j)localObject3).mdG = 0L;
      ((j)localObject3).mdH = 0L;
      ((j)localObject3).mdI = 0;
      ((j)localObject3).mdJ = 0L;
      ((j)localObject3).mdK = 0;
      ((j)localObject3).mdL = 0L;
      ((j)localObject3).mdM = 0;
      ((j)localObject3).mdN = 0L;
      ((j)localObject3).mdO = 0;
      ((j)localObject3).mdP = 0L;
      ((j)localObject3).mdQ = 0L;
      ((j)localObject3).mdR = 0L;
      ((j)localObject3).mdS = 0L;
      ((j)localObject3).mdT = 0L;
      ((j)localObject3).mdU = 0L;
      ((j)localObject3).mdV = 0L;
      ((j)localObject3).mdW = 0L;
      ((j)localObject3).mdX = 0L;
      ((RWCache)localObject2).set(Integer.valueOf(paramInt), localObject3);
      continue;
      localObject1 = localObject2;
      if (((j)localObject2).mdv != paramInt) {
        localObject1 = null;
      }
    }
  }
  
  public final j wU(int paramInt)
  {
    j localj = null;
    AppMethodBeat.i(151102);
    this.mei.appendAll(true);
    Object localObject = "SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= ".concat(String.valueOf(paramInt));
    localObject = this.lvy.rawQuery((String)localObject, null, 2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.l
 * JD-Core Version:    0.7.0.1
 */