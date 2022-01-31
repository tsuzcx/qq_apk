package com.tencent.mm.ai;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import org.json.JSONObject;

public final class k
{
  private a.a dig = new k.2(this);
  int egr = 0;
  private c egs;
  private int egt = 2;
  int egu = 10;
  boolean egv = false;
  m.b egw = new k.1(this);
  String userName = null;
  
  protected k()
  {
    if (this.egu < this.egt) {
      this.egu = this.egt;
    }
    y.i("MicroMsg.ReportLocation", "reportLocation interval %d", new Object[] { Integer.valueOf(this.egu) });
  }
  
  static void a(String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    a(paramString, 11, paramInt1, paramFloat1, paramFloat2, paramInt2, null, 0);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, LinkedList<qj> paramLinkedList, int paramInt4)
  {
    if (paramInt2 == 3) {}
    for (String str = "<event></event>";; str = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) }))
    {
      y.i("MicroMsg.ReportLocation", "doScene, info: %s", new Object[] { str });
      g.DO().dJT.a(new q(paramString, paramInt1, str, paramLinkedList, paramInt4), 0);
      return;
    }
  }
  
  public static void li(String paramString)
  {
    a(paramString, 12, 0, 0.0F, 0.0F, 0, null, 0);
  }
  
  public final void Mr()
  {
    y.i("MicroMsg.ReportLocation", "Stop report");
    this.egr = 0;
    if (this.egs != null) {
      this.egs.c(this.dig);
    }
    if (g.DN().Dc()) {
      ((j)g.r(j.class)).Fw().b(this.egw);
    }
  }
  
  public final void a(String paramString, bi parambi, int paramInt)
  {
    if ((parambi == null) || (!parambi.ctz()))
    {
      a(paramString, 10, 0, 0.0F, 0.0F, 0, null, paramInt);
      return;
    }
    g.DS().O(new k.3(this, parambi, paramString, paramInt));
  }
  
  public final void lj(String paramString)
  {
    y.i("MicroMsg.ReportLocation", "Start report");
    this.userName = paramString;
    Object localObject = f.kX(paramString);
    if (localObject == null) {}
    d.b localb;
    label190:
    label195:
    do
    {
      do
      {
        return;
        if (this.egr != 0) {
          Mr();
        }
        this.egr = 0;
        if (((d)localObject).Ls())
        {
          y.i("MicroMsg.ReportLocation", "need update contact %s", new Object[] { paramString });
          com.tencent.mm.ag.b.ka(paramString);
        }
        localb = ((d)localObject).bS(false);
      } while (localb == null);
      if ((localb.Lu()) && (((d)localObject).Lr()))
      {
        this.egs = c.Ob();
        localObject = ((d)localObject).bS(false);
        boolean bool;
        if (((d.b)localObject).efa != null)
        {
          if (bk.getInt(((d.b)localObject).efa.optString("ReportLocationType"), 0) == 2)
          {
            bool = true;
            ((d.b)localObject).efn = bool;
          }
        }
        else {
          if (!((d.b)localObject).efn) {
            break label190;
          }
        }
        for (int i = 3;; i = 2)
        {
          this.egr = i;
          if ((!c.Oc()) && (!c.Od())) {
            break label195;
          }
          this.egs.a(this.dig, true);
          return;
          bool = false;
          break;
        }
        a(paramString, 2, 0.0F, 0.0F, 0);
        return;
      }
    } while ((!localb.Lu()) || (((d)localObject).Lr()));
    a(paramString, 1, 0.0F, 0.0F, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.k
 * JD-Core Version:    0.7.0.1
 */