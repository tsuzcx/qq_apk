package com.tencent.mm.aj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.c;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.protocal.protobuf.cbg;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import org.json.JSONObject;

public final class k
{
  private b.a dZA;
  int fwt;
  private com.tencent.mm.modelgeo.d fwu;
  private int fwv;
  int fww;
  boolean fwx;
  n.b fwy;
  public caf fwz;
  String userName;
  
  protected k()
  {
    AppMethodBeat.i(11405);
    this.userName = null;
    this.fwt = 0;
    this.fwv = 2;
    this.fww = 10;
    this.fwx = false;
    this.fwy = new k.1(this);
    this.dZA = new k.2(this);
    this.fww = bo.getInt(((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nr().R("BrandService", "continueLocationReportInterval"), 5);
    if (this.fww < this.fwv) {
      this.fww = this.fwv;
    }
    ab.i("MicroMsg.ReportLocation", "reportLocation interval %d", new Object[] { Integer.valueOf(this.fww) });
    AppMethodBeat.o(11405);
  }
  
  public static void a(caf paramcaf, String paramString)
  {
    AppMethodBeat.i(11408);
    if ((paramcaf == null) || (paramcaf.xLK <= 0))
    {
      AppMethodBeat.o(11408);
      return;
    }
    int i = Math.min(paramcaf.xLK, 30);
    paramcaf.xLN = 0;
    paramcaf.xLO = 0;
    paramString = ((j)g.E(j.class)).bPQ().k(paramString, i, 0L);
    while (paramString.moveToNext())
    {
      Object localObject = new bi();
      ((bi)localObject).convertFrom(paramString);
      if (((dd)localObject).field_isSend != 1) {
        if (((bi)localObject).dxP())
        {
          paramcaf.xLO += 1;
        }
        else
        {
          localObject = bf.pA(((dd)localObject).dns);
          if ((localObject != null) && (((bf.b)localObject).fmE == 3)) {
            paramcaf.xLN += 1;
          }
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(11408);
  }
  
  static void a(String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    AppMethodBeat.i(11412);
    b(paramString, paramInt1, paramFloat1, paramFloat2, paramInt2);
    AppMethodBeat.o(11412);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, LinkedList<to> paramLinkedList, int paramInt4, caf paramcaf, cbg paramcbg)
  {
    AppMethodBeat.i(11414);
    if (paramInt2 == 3) {}
    for (String str = "<event></event>";; str = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) }))
    {
      ab.i("MicroMsg.ReportLocation", "doScene, info: %s", new Object[] { str });
      g.RK().eHt.a(new q(paramString, paramInt1, str, paramLinkedList, paramInt4, paramcaf, paramcbg), 0);
      AppMethodBeat.o(11414);
      return;
    }
  }
  
  public static void a(String paramString, cbg paramcbg, int paramInt)
  {
    AppMethodBeat.i(11409);
    a(paramString, paramInt, 0, 0.0F, 0.0F, 0, null, 0, null, paramcbg);
    AppMethodBeat.o(11409);
  }
  
  private static void b(String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    AppMethodBeat.i(11413);
    a(paramString, 11, paramInt1, paramFloat1, paramFloat2, paramInt2, null, 0, null, null);
    AppMethodBeat.o(11413);
  }
  
  public final void a(String paramString, caf paramcaf)
  {
    AppMethodBeat.i(11407);
    com.tencent.mm.sdk.g.d.ysm.execute(new k.4(this, paramcaf, paramString));
    AppMethodBeat.o(11407);
  }
  
  public final void a(String paramString, bi parambi, int paramInt, caf paramcaf)
  {
    AppMethodBeat.i(11406);
    com.tencent.mm.sdk.g.d.ysm.execute(new k.3(this, paramcaf, paramString, parambi, paramInt));
    AppMethodBeat.o(11406);
  }
  
  public final void afa()
  {
    AppMethodBeat.i(11411);
    ab.i("MicroMsg.ReportLocation", "Stop report");
    this.fwt = 0;
    if (this.fwu != null) {
      this.fwu.c(this.dZA);
    }
    if (g.RJ().QU()) {
      ((j)g.E(j.class)).YA().b(this.fwy);
    }
    AppMethodBeat.o(11411);
  }
  
  public final void se(String paramString)
  {
    AppMethodBeat.i(11410);
    ab.i("MicroMsg.ReportLocation", "Start report");
    this.userName = paramString;
    Object localObject = f.rS(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(11410);
      return;
    }
    if (this.fwt != 0) {
      afa();
    }
    this.fwt = 0;
    if (((d)localObject).aea())
    {
      ab.i("MicroMsg.ReportLocation", "need update contact %s", new Object[] { paramString });
      com.tencent.mm.ah.b.qT(paramString);
    }
    d.b localb = ((d)localObject).cU(false);
    if (localb == null)
    {
      AppMethodBeat.o(11410);
      return;
    }
    if ((localb.aec()) && (((d)localObject).adZ()))
    {
      this.fwu = com.tencent.mm.modelgeo.d.agQ();
      localObject = ((d)localObject).cU(false);
      boolean bool;
      if (((d.b)localObject).fvc != null)
      {
        if (bo.getInt(((d.b)localObject).fvc.optString("ReportLocationType"), 0) == 2)
        {
          bool = true;
          ((d.b)localObject).fvp = bool;
        }
      }
      else {
        if (!((d.b)localObject).fvp) {
          break label218;
        }
      }
      label218:
      for (int i = 3;; i = 2)
      {
        this.fwt = i;
        if ((!com.tencent.mm.modelgeo.d.agR()) && (!com.tencent.mm.modelgeo.d.agS())) {
          break label223;
        }
        this.fwu.a(this.dZA, true);
        AppMethodBeat.o(11410);
        return;
        bool = false;
        break;
      }
      label223:
      a(paramString, 2, 0.0F, 0.0F, 0);
      AppMethodBeat.o(11410);
      return;
    }
    if ((localb.aec()) && (!((d)localObject).adZ())) {
      a(paramString, 1, 0.0F, 0.0F, 0);
    }
    AppMethodBeat.o(11410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.k
 * JD-Core Version:    0.7.0.1
 */