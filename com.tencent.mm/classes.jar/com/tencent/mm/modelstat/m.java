package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ax.b;
import com.tencent.mm.sdk.platformtools.ax.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import junit.framework.Assert;

public final class m
  extends j
  implements ax.c<Integer, k>
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) " };
  private static final String[] eEr = { "realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut" };
  public h dXo;
  private long eEo;
  public ax<Integer, k> eEp;
  private long eEq;
  
  public m(h paramh)
  {
    this.dXo = paramh;
    this.eEp = new ax(this, g.DS().mnU.getLooper(), 30, 2, 300000L, 1000L);
    paramh = new HashSet();
    Object localObject1 = eEr;
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      paramh.add(localObject1[i]);
      i += 1;
    }
    localObject1 = this.dXo.a("PRAGMA table_info(netstat);", null, 2);
    i = ((Cursor)localObject1).getColumnIndex("name");
    while (((Cursor)localObject1).moveToNext()) {
      paramh.remove(((Cursor)localObject1).getString(i));
    }
    ((Cursor)localObject1).close();
    localObject1 = eEr;
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      Object localObject2 = localObject1[i];
      if (paramh.contains(localObject2))
      {
        localObject2 = "ALTER TABLE netstat ADD COLUMN " + (String)localObject2 + " INT;";
        this.dXo.gk("netstat", (String)localObject2);
      }
      i += 1;
    }
    this.eEq = System.currentTimeMillis();
  }
  
  public final long Rv()
  {
    this.eEp.mx(true);
    int j = (int)((bk.UY() - 1296000000L) / 86400000L);
    int i = (int)(bk.crW() / 86400000L);
    Object localObject = "SELECT peroid FROM netstat  WHERE peroid > " + j + " order by peroid limit 1";
    localObject = this.dXo.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("peroid"));
    }
    ((Cursor)localObject).close();
    return i * 86400000L;
  }
  
  public final boolean Rw()
  {
    if (this.dXo.inTransaction())
    {
      y.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
      return false;
    }
    this.eEo = this.dXo.eV(Thread.currentThread().getId());
    if (this.eEo <= 0L)
    {
      y.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.eEo + " return false");
      return false;
    }
    return true;
  }
  
  public final void Rx()
  {
    if (this.eEo > 0L) {
      this.dXo.hI(this.eEo);
    }
  }
  
  public final void a(k paramk)
  {
    Assert.assertNotNull(paramk);
    long l = System.currentTimeMillis();
    if (paramk.eDC <= 0) {
      paramk.eDC = ((int)(l / 86400000L));
    }
    if (paramk.eDC <= 0) {
      return;
    }
    k localk = ji(paramk.eDC);
    if ((localk != null) && (paramk.eDC == localk.eDC))
    {
      localk.bcw |= 0x1;
      paramk.eDD += localk.eDE;
      paramk.eDE += localk.eDE;
      paramk.eDF += localk.eDG;
      paramk.eDG += localk.eDG;
      paramk.eDH += localk.eDH;
      paramk.eDI += localk.eDI;
      paramk.eDJ += localk.eDJ;
      paramk.eDK += localk.eDK;
      paramk.eDL += localk.eDL;
      paramk.eDM += localk.eDM;
      paramk.eDN += localk.eDN;
      paramk.eDO += localk.eDO;
      paramk.eDP += localk.eDQ;
      paramk.eDQ += localk.eDQ;
      paramk.eDR += localk.eDS;
      paramk.eDS += localk.eDS;
      paramk.eDT += localk.eDT;
      paramk.eDU += localk.eDU;
      paramk.eDV += localk.eDV;
      paramk.eDW += localk.eDW;
      paramk.eDX += localk.eDX;
      paramk.eDY += localk.eDY;
      paramk.eDZ += localk.eDZ;
      paramk.eEa += localk.eEa;
      paramk.eEb += localk.eEb;
      paramk.eEc += localk.eEc;
      paramk.eEd += localk.eEd;
      paramk.eEe += localk.eEe;
      if ((paramk.eDL <= 4096) && (paramk.eDM <= 4096) && (paramk.eDX <= 4096)) {
        int i = paramk.eDY;
      }
      paramk.id = localk.id;
      if (l - this.eEq > 300000L) {
        y.i("MicroMsg.NetStat", paramk.toString());
      }
    }
    for (;;)
    {
      this.eEq = l;
      b(paramk);
      return;
      paramk.bcw |= 0x2;
      paramk.id = -1;
      if (localk != null) {
        y.i("MicroMsg.NetStat", localk.toString());
      } else {
        y.i("MicroMsg.NetStat", "NetStat started.");
      }
    }
  }
  
  public final void a(ax<Integer, k> paramax, ax.b<Integer, k> paramb)
  {
    int i = paramb.uhL;
    paramax = (k)paramb.values;
    if ((paramax != null) && (i == 1))
    {
      i = paramax.eDC;
      int j = paramax.id;
      if (i > 0)
      {
        paramb = new ContentValues();
        if ((paramax.bcw & 0x2) != 0) {
          paramb.put("peroid", Integer.valueOf(paramax.eDC));
        }
        if ((paramax.bcw & 0x4) != 0) {
          paramb.put("textCountIn", Integer.valueOf(paramax.eDD));
        }
        if ((paramax.bcw & 0x8) != 0) {
          paramb.put("textBytesIn", Integer.valueOf(paramax.eDE));
        }
        if ((paramax.bcw & 0x10) != 0) {
          paramb.put("imageCountIn", Integer.valueOf(paramax.eDF));
        }
        if ((paramax.bcw & 0x20) != 0) {
          paramb.put("imageBytesIn", Integer.valueOf(paramax.eDG));
        }
        if ((paramax.bcw & 0x40) != 0) {
          paramb.put("voiceCountIn", Integer.valueOf(paramax.eDH));
        }
        if ((paramax.bcw & 0x80) != 0) {
          paramb.put("voiceBytesIn", Integer.valueOf(paramax.eDI));
        }
        if ((paramax.bcw & 0x100) != 0) {
          paramb.put("videoCountIn", Integer.valueOf(paramax.eDJ));
        }
        if ((paramax.bcw & 0x200) != 0) {
          paramb.put("videoBytesIn", Integer.valueOf(paramax.eDK));
        }
        if ((paramax.bcw & 0x400) != 0) {
          paramb.put("mobileBytesIn", Integer.valueOf(paramax.eDL));
        }
        if ((paramax.bcw & 0x800) != 0) {
          paramb.put("wifiBytesIn", Integer.valueOf(paramax.eDM));
        }
        if ((paramax.bcw & 0x1000) != 0) {
          paramb.put("sysMobileBytesIn", Integer.valueOf(paramax.eDN));
        }
        if ((paramax.bcw & 0x2000) != 0) {
          paramb.put("sysWifiBytesIn", Integer.valueOf(paramax.eDO));
        }
        if ((paramax.bcw & 0x4000) != 0) {
          paramb.put("textCountOut", Integer.valueOf(paramax.eDP));
        }
        if ((paramax.bcw & 0x8000) != 0) {
          paramb.put("textBytesOut", Integer.valueOf(paramax.eDQ));
        }
        if ((paramax.bcw & 0x10000) != 0) {
          paramb.put("imageCountOut", Integer.valueOf(paramax.eDR));
        }
        if ((paramax.bcw & 0x20000) != 0) {
          paramb.put("imageBytesOut", Integer.valueOf(paramax.eDS));
        }
        if ((paramax.bcw & 0x40000) != 0) {
          paramb.put("voiceCountOut", Integer.valueOf(paramax.eDT));
        }
        if ((paramax.bcw & 0x80000) != 0) {
          paramb.put("voiceBytesOut", Integer.valueOf(paramax.eDU));
        }
        if ((paramax.bcw & 0x100000) != 0) {
          paramb.put("videoCountOut", Integer.valueOf(paramax.eDV));
        }
        if ((paramax.bcw & 0x200000) != 0) {
          paramb.put("videoBytesOut", Integer.valueOf(paramax.eDW));
        }
        if ((paramax.bcw & 0x400000) != 0) {
          paramb.put("mobileBytesOut", Integer.valueOf(paramax.eDX));
        }
        if ((paramax.bcw & 0x800000) != 0) {
          paramb.put("wifiBytesOut", Integer.valueOf(paramax.eDY));
        }
        if ((paramax.bcw & 0x1000000) != 0) {
          paramb.put("sysMobileBytesOut", Integer.valueOf(paramax.eDZ));
        }
        if ((paramax.bcw & 0x2000000) != 0) {
          paramb.put("sysWifiBytesOut", Integer.valueOf(paramax.eEa));
        }
        if ((paramax.bcw & 0x4000000) != 0) {
          paramb.put("realMobileBytesIn", Integer.valueOf(paramax.eEb));
        }
        if ((paramax.bcw & 0x8000000) != 0) {
          paramb.put("realWifiBytesIn", Integer.valueOf(paramax.eEc));
        }
        if ((paramax.bcw & 0x10000000) != 0) {
          paramb.put("realMobileBytesOut", Integer.valueOf(paramax.eEd));
        }
        if ((paramax.bcw & 0x20000000) != 0) {
          paramb.put("realWifiBytesOut", Integer.valueOf(paramax.eEe));
        }
        if (j >= 0) {
          break label781;
        }
        paramax.id = ((int)this.dXo.insert("netstat", "id", paramb));
      }
    }
    return;
    label781:
    this.dXo.update("netstat", paramb, "peroid=" + i, null);
  }
  
  public final boolean b(k paramk)
  {
    Assert.assertNotNull(paramk);
    if (paramk.eDC > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      return this.eEp.n(Integer.valueOf(paramk.eDC), paramk);
    }
  }
  
  public final k ji(int paramInt)
  {
    k localk1 = (k)this.eEp.get(Integer.valueOf(paramInt));
    Object localObject;
    if (localk1 == null)
    {
      localObject = this.dXo.a("netstat", null, "peroid = " + paramInt, null, null, null, null, 2);
      if (((Cursor)localObject).moveToFirst())
      {
        localk1 = new k();
        localk1.d((Cursor)localObject);
      }
      ((Cursor)localObject).close();
      if (localk1 != null)
      {
        this.eEp.n(Integer.valueOf(paramInt), localk1);
        localObject = localk1;
      }
    }
    do
    {
      return localObject;
      localObject = this.eEp;
      k localk2 = new k();
      localk2.bcw = 0;
      localk2.id = 0;
      localk2.eDC = 0;
      localk2.eDD = 0;
      localk2.eDE = 0;
      localk2.eDF = 0;
      localk2.eDG = 0;
      localk2.eDH = 0;
      localk2.eDI = 0;
      localk2.eDJ = 0;
      localk2.eDK = 0;
      localk2.eDL = 0;
      localk2.eDM = 0;
      localk2.eDN = 0;
      localk2.eDO = 0;
      localk2.eDP = 0;
      localk2.eDQ = 0;
      localk2.eDR = 0;
      localk2.eDS = 0;
      localk2.eDT = 0;
      localk2.eDU = 0;
      localk2.eDV = 0;
      localk2.eDW = 0;
      localk2.eDX = 0;
      localk2.eDY = 0;
      localk2.eDZ = 0;
      localk2.eEa = 0;
      localk2.eEb = 0;
      localk2.eEc = 0;
      localk2.eEd = 0;
      localk2.eEe = 0;
      ((ax)localObject).n(Integer.valueOf(paramInt), localk2);
      return localk1;
      localObject = localk1;
    } while (localk1.eDC == paramInt);
    return null;
  }
  
  public final k jj(int paramInt)
  {
    k localk = null;
    this.eEp.mx(true);
    Object localObject = "SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= " + paramInt;
    localObject = this.dXo.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localk = new k();
      localk.d((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.m
 * JD-Core Version:    0.7.0.1
 */