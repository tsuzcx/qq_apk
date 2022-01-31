package com.tencent.mm.be;

import android.os.HandlerThread;
import android.util.Base64;
import com.tencent.map.swlocation.api.LocationUpdateListener;
import com.tencent.map.swlocation.api.ServerMessageListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.ba.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static b fNA;
  private static final byte[] fNz;
  private boolean fNB;
  private al fNC;
  int fND;
  int fNE;
  int fNF;
  private int fNG;
  private c fNH;
  private List<d> fNI;
  private List<d> fNJ;
  private com.tencent.mm.sdk.b.c fNK;
  private ap fNL;
  private LocationUpdateListener fNM;
  private int fNN;
  private ServerMessageListener fNO;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(78554);
    fNz = "@wechat*weixin!!".getBytes();
    AppMethodBeat.o(78554);
  }
  
  public b()
  {
    AppMethodBeat.i(78535);
    this.fNB = false;
    this.startTime = 0L;
    this.fND = 5000;
    this.fNE = 5000;
    this.fNF = 30000;
    this.fNG = 3600;
    this.fNI = new ArrayList();
    this.fNJ = new ArrayList();
    this.fNK = new b.3(this);
    com.tencent.mm.kernel.g.RM();
    this.fNL = new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new b.4(this), false);
    this.fNM = new b.5(this);
    this.fNN = 0;
    this.fNO = new b.6(this);
    AppMethodBeat.o(78535);
  }
  
  public static b aiV()
  {
    AppMethodBeat.i(78534);
    if (fNA == null) {
      fNA = new b();
    }
    b localb = fNA;
    AppMethodBeat.o(78534);
    return localb;
  }
  
  private static String aiW()
  {
    AppMethodBeat.i(78536);
    String str = q.bP(true);
    com.tencent.mm.kernel.g.RJ();
    Object localObject = new com.tencent.mm.a.p(a.getUin()).toString();
    str = str + "_" + (String)localObject;
    try
    {
      localObject = new af();
      byte[] arrayOfByte1 = str.getBytes("UTF-8");
      byte[] arrayOfByte2 = fNz;
      localObject = new String(Base64.encode(((af)localObject).a(arrayOfByte1, arrayOfByte1.length, arrayOfByte2), 0), "UTF-8");
      ab.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new Object[] { localObject, bo.aqg(str) });
      AppMethodBeat.o(78536);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      ab.e("MicroMsg.SenseWhereHelper", "create imei error: " + localException.toString());
      AppMethodBeat.o(78536);
    }
    return "";
  }
  
  private boolean aiY()
  {
    AppMethodBeat.i(78539);
    com.tencent.mm.kernel.g.RJ();
    if (new com.tencent.mm.a.p(a.getUin()).longValue() < 1000000L)
    {
      ab.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
      AppMethodBeat.o(78539);
      return false;
    }
    Object localObject = com.tencent.mm.m.g.Nq().getValue("AndroidSenseWhereArgs");
    if (bo.isNullOrNil((String)localObject))
    {
      ab.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
      AppMethodBeat.o(78539);
      return false;
    }
    try
    {
      ab.d("MicroMsg.SenseWhereHelper", "sense where config : ".concat(String.valueOf(localObject)));
      localObject = ((String)localObject).split(";");
      int i = bo.getInt(localObject[0], 0);
      com.tencent.mm.kernel.g.RJ();
      int j = i.bQ(a.getUin() + 5, 100);
      if (j > i)
      {
        ab.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(78539);
        return false;
      }
      this.fNE = bo.getInt(localObject[1], 5000);
      this.fND = bo.getInt(localObject[2], 5000);
      this.fNF = bo.getInt(localObject[3], 30000);
      this.fNG = bo.getInt(localObject[4], 3600);
      ab.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", new Object[] { Integer.valueOf(this.fNE), Integer.valueOf(this.fND), Integer.valueOf(this.fNF), Integer.valueOf(this.fNG) });
      long l = bo.gz(((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yDt, Long.valueOf(0L))).longValue());
      i = this.fNG;
      if (l > i)
      {
        AppMethodBeat.o(78539);
        return true;
      }
      ab.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(this.fNG) });
      AppMethodBeat.o(78539);
      return false;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      ab.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + localException.toString());
      ab.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
      AppMethodBeat.o(78539);
    }
    return false;
  }
  
  public static void aiZ()
  {
    AppMethodBeat.i(78540);
    if (bo.gz(bo.a((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yDs, null), 0L)) * 1000L > 21600000L)
    {
      ab.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
      k localk = new k(36);
      com.tencent.mm.kernel.g.RK().eHt.a(localk, 0);
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yDs, Long.valueOf(bo.aox()));
    }
    AppMethodBeat.o(78540);
  }
  
  public final void a(float paramFloat1, float paramFloat2, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(78537);
    if (com.tencent.mm.kernel.g.RJ().QU())
    {
      com.tencent.mm.kernel.g.RJ();
      if (!a.QP()) {}
    }
    else
    {
      AppMethodBeat.o(78537);
      return;
    }
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RO().ac(new b.1(this, paramInt2, paramFloat1, paramFloat2, paramInt3, paramInt1, paramString1, paramString2));
    AppMethodBeat.o(78537);
  }
  
  public final void aiX()
  {
    AppMethodBeat.i(78538);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RO().ac(new b.2(this));
    AppMethodBeat.o(78538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.be.b
 * JD-Core Version:    0.7.0.1
 */