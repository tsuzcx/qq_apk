package com.tencent.mm.bd;

import android.os.HandlerThread;
import android.util.Base64;
import com.tencent.map.swlocation.api.LocationUpdateListener;
import com.tencent.map.swlocation.api.ServerMessageListener;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final byte[] exK = "@wechat*weixin!!".getBytes();
  private static b exL;
  private boolean exM = false;
  private ai exN;
  int exO = 5000;
  int exP = 5000;
  int exQ = 30000;
  private int exR = 3600;
  private c exS;
  private List<d> exT = new ArrayList();
  private List<d> exU = new ArrayList();
  private com.tencent.mm.sdk.b.c exV = new b.3(this);
  private am exW;
  private LocationUpdateListener exX;
  private int exY;
  private ServerMessageListener exZ;
  private long startTime = 0L;
  
  public b()
  {
    com.tencent.mm.kernel.g.DQ();
    this.exW = new am(com.tencent.mm.kernel.g.DS().mnU.getLooper(), new b.4(this), false);
    this.exX = new b.5(this);
    this.exY = 0;
    this.exZ = new b.6(this);
  }
  
  public static b PQ()
  {
    if (exL == null) {
      exL = new b();
    }
    return exL;
  }
  
  private static String PR()
  {
    String str = q.zf();
    com.tencent.mm.kernel.g.DN();
    Object localObject = new o(a.CK()).toString();
    str = str + "_" + (String)localObject;
    try
    {
      localObject = new af();
      byte[] arrayOfByte1 = str.getBytes("UTF-8");
      byte[] arrayOfByte2 = exK;
      localObject = new String(Base64.encode(((af)localObject).a(arrayOfByte1, arrayOfByte1.length, arrayOfByte2), 0), "UTF-8");
      y.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new Object[] { localObject, bk.aac(str) });
      return localObject;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      y.e("MicroMsg.SenseWhereHelper", "create imei error: " + localException.toString());
    }
    return "";
  }
  
  private boolean PT()
  {
    com.tencent.mm.kernel.g.DN();
    if (new o(a.CK()).longValue() < 1000000L)
    {
      y.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
      return false;
    }
    Object localObject = com.tencent.mm.m.g.AA().getValue("AndroidSenseWhereArgs");
    if (bk.bl((String)localObject))
    {
      y.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
      return false;
    }
    try
    {
      y.d("MicroMsg.SenseWhereHelper", "sense where config : " + (String)localObject);
      localObject = ((String)localObject).split(";");
      int i = bk.getInt(localObject[0], 0);
      com.tencent.mm.kernel.g.DN();
      int j = h.aT(a.CK() + 5, 100);
      if (j > i)
      {
        y.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        return false;
      }
      this.exP = bk.getInt(localObject[1], 5000);
      this.exO = bk.getInt(localObject[2], 5000);
      this.exQ = bk.getInt(localObject[3], 30000);
      this.exR = bk.getInt(localObject[4], 3600);
      y.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", new Object[] { Integer.valueOf(this.exP), Integer.valueOf(this.exO), Integer.valueOf(this.exQ), Integer.valueOf(this.exR) });
      long l = bk.cn(((Long)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.utr, Long.valueOf(0L))).longValue());
      if (l > this.exR) {
        return true;
      }
      y.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(this.exR) });
      return false;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      y.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + localException.toString());
      y.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
    }
    return false;
  }
  
  public static void PU()
  {
    if (bk.cn(bk.a((Long)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.utq, null), 0L)) * 1000L > 21600000L)
    {
      y.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
      k localk = new k(36);
      com.tencent.mm.kernel.g.DO().dJT.a(localk, 0);
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.utq, Long.valueOf(bk.UX()));
    }
  }
  
  public final void PS()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().O(new b.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bd.b
 * JD-Core Version:    0.7.0.1
 */