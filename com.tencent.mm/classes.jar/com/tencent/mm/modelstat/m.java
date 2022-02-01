package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.b;
import com.tencent.mm.sdk.platformtools.bh.c;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import java.util.HashSet;
import junit.framework.Assert;

public final class m
  extends com.tencent.mm.sdk.e.k
  implements bh.c<Integer, k>
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) " };
  private static final String[] itI = { "realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut" };
  public h hKK;
  private long itF;
  public bh<Integer, k> itG;
  private long itH;
  
  public m(h paramh)
  {
    AppMethodBeat.i(151097);
    this.hKK = paramh;
    this.itG = new bh(this, g.ajU().IxZ.getLooper(), 30, 2);
    paramh = new HashSet();
    Object localObject1 = itI;
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      paramh.add(localObject1[i]);
      i += 1;
    }
    localObject1 = this.hKK.a("PRAGMA table_info(netstat);", null, 2);
    i = ((Cursor)localObject1).getColumnIndex("name");
    while (((Cursor)localObject1).moveToNext()) {
      paramh.remove(((Cursor)localObject1).getString(i));
    }
    ((Cursor)localObject1).close();
    localObject1 = itI;
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      Object localObject2 = localObject1[i];
      if (paramh.contains(localObject2))
      {
        localObject2 = "ALTER TABLE netstat ADD COLUMN " + (String)localObject2 + " INT;";
        this.hKK.execSQL("netstat", (String)localObject2);
      }
      i += 1;
    }
    this.itH = System.currentTimeMillis();
    AppMethodBeat.o(151097);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(151099);
    Assert.assertNotNull(paramk);
    long l = System.currentTimeMillis();
    if (paramk.isT <= 0) {
      paramk.isT = ((int)(l / 86400000L));
    }
    if (paramk.isT <= 0)
    {
      AppMethodBeat.o(151099);
      return;
    }
    k localk = qe(paramk.isT);
    if ((localk != null) && (paramk.isT == localk.isT))
    {
      localk.dEu |= 0x1;
      paramk.isU = ((int)(paramk.isU + localk.isV));
      paramk.isV += localk.isV;
      paramk.isW = ((int)(paramk.isW + localk.isX));
      paramk.isX += localk.isX;
      paramk.isY += localk.isY;
      paramk.isZ += localk.isZ;
      paramk.ita += localk.ita;
      paramk.itb += localk.itb;
      paramk.itc += localk.itc;
      paramk.itd += localk.itd;
      paramk.ite += localk.ite;
      paramk.itf += localk.itf;
      paramk.itg = ((int)(paramk.itg + localk.ith));
      paramk.ith += localk.ith;
      paramk.iti = ((int)(paramk.iti + localk.itj));
      paramk.itj += localk.itj;
      paramk.itk += localk.itk;
      paramk.itl += localk.itl;
      paramk.itm += localk.itm;
      paramk.itn += localk.itn;
      paramk.ito += localk.ito;
      paramk.itp += localk.itp;
      paramk.itq += localk.itq;
      paramk.itr += localk.itr;
      paramk.its += localk.its;
      paramk.itt += localk.itt;
      paramk.itu += localk.itu;
      paramk.itv += localk.itv;
      paramk.id = localk.id;
      paramk.dEu |= 0x2;
      if (l - this.itH > 300000L) {
        ae.i("MicroMsg.NetStat", paramk.toString());
      }
    }
    for (;;)
    {
      this.itH = l;
      b(paramk);
      AppMethodBeat.o(151099);
      return;
      paramk.dEu |= 0x2;
      paramk.id = -1;
      if (localk != null) {
        ae.i("MicroMsg.NetStat", localk.toString());
      } else {
        ae.i("MicroMsg.NetStat", "NetStat started.");
      }
    }
  }
  
  public final void a(bh.b<Integer, k> paramb)
  {
    AppMethodBeat.i(151104);
    int i = paramb.IzP;
    paramb = (k)paramb.values;
    if ((paramb != null) && (i == 1))
    {
      i = paramb.isT;
      int j = paramb.id;
      if (i > 0)
      {
        ContentValues localContentValues = new ContentValues();
        if ((paramb.dEu & 0x2) != 0) {
          localContentValues.put("peroid", Integer.valueOf(paramb.isT));
        }
        if ((paramb.dEu & 0x4) != 0) {
          localContentValues.put("textCountIn", Integer.valueOf(paramb.isU));
        }
        if ((paramb.dEu & 0x8) != 0) {
          localContentValues.put("textBytesIn", Long.valueOf(paramb.isV));
        }
        if ((paramb.dEu & 0x10) != 0) {
          localContentValues.put("imageCountIn", Integer.valueOf(paramb.isW));
        }
        if ((paramb.dEu & 0x20) != 0) {
          localContentValues.put("imageBytesIn", Long.valueOf(paramb.isX));
        }
        if ((paramb.dEu & 0x40) != 0) {
          localContentValues.put("voiceCountIn", Integer.valueOf(paramb.isY));
        }
        if ((paramb.dEu & 0x80) != 0) {
          localContentValues.put("voiceBytesIn", Long.valueOf(paramb.isZ));
        }
        if ((paramb.dEu & 0x100) != 0) {
          localContentValues.put("videoCountIn", Integer.valueOf(paramb.ita));
        }
        if ((paramb.dEu & 0x200) != 0) {
          localContentValues.put("videoBytesIn", Long.valueOf(paramb.itb));
        }
        if ((paramb.dEu & 0x400) != 0) {
          localContentValues.put("mobileBytesIn", Long.valueOf(paramb.itc));
        }
        if ((paramb.dEu & 0x800) != 0) {
          localContentValues.put("wifiBytesIn", Long.valueOf(paramb.itd));
        }
        if ((paramb.dEu & 0x1000) != 0) {
          localContentValues.put("sysMobileBytesIn", Long.valueOf(paramb.ite));
        }
        if ((paramb.dEu & 0x2000) != 0) {
          localContentValues.put("sysWifiBytesIn", Long.valueOf(paramb.itf));
        }
        if ((paramb.dEu & 0x4000) != 0) {
          localContentValues.put("textCountOut", Integer.valueOf(paramb.itg));
        }
        if ((paramb.dEu & 0x8000) != 0) {
          localContentValues.put("textBytesOut", Long.valueOf(paramb.ith));
        }
        if ((paramb.dEu & 0x10000) != 0) {
          localContentValues.put("imageCountOut", Integer.valueOf(paramb.iti));
        }
        if ((paramb.dEu & 0x20000) != 0) {
          localContentValues.put("imageBytesOut", Long.valueOf(paramb.itj));
        }
        if ((paramb.dEu & 0x40000) != 0) {
          localContentValues.put("voiceCountOut", Integer.valueOf(paramb.itk));
        }
        if ((paramb.dEu & 0x80000) != 0) {
          localContentValues.put("voiceBytesOut", Long.valueOf(paramb.itl));
        }
        if ((paramb.dEu & 0x100000) != 0) {
          localContentValues.put("videoCountOut", Integer.valueOf(paramb.itm));
        }
        if ((paramb.dEu & 0x200000) != 0) {
          localContentValues.put("videoBytesOut", Long.valueOf(paramb.itn));
        }
        if ((paramb.dEu & 0x400000) != 0) {
          localContentValues.put("mobileBytesOut", Long.valueOf(paramb.ito));
        }
        if ((paramb.dEu & 0x800000) != 0) {
          localContentValues.put("wifiBytesOut", Long.valueOf(paramb.itp));
        }
        if ((paramb.dEu & 0x1000000) != 0) {
          localContentValues.put("sysMobileBytesOut", Long.valueOf(paramb.itq));
        }
        if ((paramb.dEu & 0x2000000) != 0) {
          localContentValues.put("sysWifiBytesOut", Long.valueOf(paramb.itr));
        }
        if ((paramb.dEu & 0x4000000) != 0) {
          localContentValues.put("realMobileBytesIn", Long.valueOf(paramb.its));
        }
        if ((paramb.dEu & 0x8000000) != 0) {
          localContentValues.put("realWifiBytesIn", Long.valueOf(paramb.itt));
        }
        if ((paramb.dEu & 0x10000000) != 0) {
          localContentValues.put("realMobileBytesOut", Long.valueOf(paramb.itu));
        }
        if ((paramb.dEu & 0x20000000) != 0) {
          localContentValues.put("realWifiBytesOut", Long.valueOf(paramb.itv));
        }
        if (j < 0)
        {
          paramb.id = ((int)this.hKK.a("netstat", "id", localContentValues));
          AppMethodBeat.o(151104);
          return;
        }
        this.hKK.update("netstat", localContentValues, "peroid=".concat(String.valueOf(i)), null);
      }
    }
    AppMethodBeat.o(151104);
  }
  
  public final long aMg()
  {
    AppMethodBeat.i(151101);
    this.itG.wR(true);
    int j = (int)((bu.fpO() - 1296000000L) / 86400000L);
    int i = (int)(bu.fpI() / 86400000L);
    Object localObject = "SELECT peroid FROM netstat  WHERE peroid > " + j + " order by peroid limit 1";
    localObject = this.hKK.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("peroid"));
    }
    ((Cursor)localObject).close();
    long l = i;
    AppMethodBeat.o(151101);
    return l * 86400000L;
  }
  
  public final boolean aMh()
  {
    AppMethodBeat.i(151103);
    if (this.hKK.inTransaction())
    {
      ae.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
      AppMethodBeat.o(151103);
      return false;
    }
    this.itF = this.hKK.yi(Thread.currentThread().getId());
    if (this.itF <= 0L)
    {
      ae.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.itF + " return false");
      AppMethodBeat.o(151103);
      return false;
    }
    AppMethodBeat.o(151103);
    return true;
  }
  
  public final void aMi()
  {
    AppMethodBeat.i(151105);
    if (this.itF > 0L) {
      this.hKK.sW(this.itF);
    }
    AppMethodBeat.o(151105);
  }
  
  public final boolean b(k paramk)
  {
    AppMethodBeat.i(151100);
    Assert.assertNotNull(paramk);
    if (paramk.isT > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      bool = this.itG.I(Integer.valueOf(paramk.isT), paramk);
      AppMethodBeat.o(151100);
      return bool;
    }
  }
  
  public final k qe(int paramInt)
  {
    AppMethodBeat.i(151098);
    Object localObject2 = (k)this.itG.get(Integer.valueOf(paramInt));
    Object localObject3;
    Object localObject1;
    if (localObject2 == null)
    {
      localObject3 = this.hKK.a("netstat", null, "peroid = ".concat(String.valueOf(paramInt)), null, null, null, null, 2);
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new k();
        ((k)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
      if (localObject1 != null) {
        this.itG.I(Integer.valueOf(paramInt), localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(151098);
      return localObject1;
      localObject2 = this.itG;
      localObject3 = new k();
      ((k)localObject3).dEu = 0;
      ((k)localObject3).id = 0;
      ((k)localObject3).isT = 0;
      ((k)localObject3).isU = 0;
      ((k)localObject3).isV = 0L;
      ((k)localObject3).isW = 0;
      ((k)localObject3).isX = 0L;
      ((k)localObject3).isY = 0;
      ((k)localObject3).isZ = 0L;
      ((k)localObject3).ita = 0;
      ((k)localObject3).itb = 0L;
      ((k)localObject3).itc = 0L;
      ((k)localObject3).itd = 0L;
      ((k)localObject3).ite = 0L;
      ((k)localObject3).itf = 0L;
      ((k)localObject3).itg = 0;
      ((k)localObject3).ith = 0L;
      ((k)localObject3).iti = 0;
      ((k)localObject3).itj = 0L;
      ((k)localObject3).itk = 0;
      ((k)localObject3).itl = 0L;
      ((k)localObject3).itm = 0;
      ((k)localObject3).itn = 0L;
      ((k)localObject3).ito = 0L;
      ((k)localObject3).itp = 0L;
      ((k)localObject3).itq = 0L;
      ((k)localObject3).itr = 0L;
      ((k)localObject3).its = 0L;
      ((k)localObject3).itt = 0L;
      ((k)localObject3).itu = 0L;
      ((k)localObject3).itv = 0L;
      ((bh)localObject2).I(Integer.valueOf(paramInt), localObject3);
      continue;
      localObject1 = localObject2;
      if (((k)localObject2).isT != paramInt) {
        localObject1 = null;
      }
    }
  }
  
  public final k qf(int paramInt)
  {
    k localk = null;
    AppMethodBeat.i(151102);
    this.itG.wR(true);
    Object localObject = "SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= ".concat(String.valueOf(paramInt));
    localObject = this.hKK.a((String)localObject, null, 2);
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