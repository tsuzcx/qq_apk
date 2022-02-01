package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.eg;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.autogen.a.nk;
import com.tencent.mm.autogen.a.su;
import com.tencent.mm.autogen.mmdata.rpt.de;
import com.tencent.mm.autogen.mmdata.rpt.df;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import org.json.JSONObject;

public final class a
{
  df APA;
  p APB;
  int APC;
  int APD;
  String APF;
  boolean APG;
  long APH;
  int APJ;
  int APK;
  IListener<su> APL;
  private de APz;
  int m;
  int n;
  int o;
  int p;
  double q;
  IListener<gh> qlY;
  IListener<eg> qnK;
  IListener<nk> qnf;
  int z;
  
  protected a()
  {
    AppMethodBeat.i(366748);
    this.APz = new de();
    this.APA = new df();
    this.APC = 0;
    this.APD = 0;
    this.APF = "";
    this.APG = false;
    this.qnK = new FinderDynamicTimeHelper.1(this, com.tencent.mm.app.f.hfK);
    this.APL = new FinderDynamicTimeHelper.2(this, com.tencent.mm.app.f.hfK);
    this.qnf = new FinderDynamicTimeHelper.3(this, com.tencent.mm.app.f.hfK);
    this.qlY = new FinderDynamicTimeHelper.4(this, com.tencent.mm.app.f.hfK);
    this.APH = h.baE().ban().a(at.a.adbE, 0L);
    this.APC = h.baE().ban().getInt(at.a.adbF, 0);
    this.APD = h.baE().ban().getInt(at.a.adbG, 0);
    Log.i("MicroMsg.FinderDynamicTimeHelper", "load  redDotDynamicTime[%d] dropRedDotCount[%d] deepReadCount[%d]", new Object[] { Long.valueOf(this.APH), Integer.valueOf(this.APC), Integer.valueOf(this.APD) });
    AppMethodBeat.o(366748);
  }
  
  static void showDebugToast(String paramString)
  {
    AppMethodBeat.i(366754);
    Log.i("MicroMsg.FinderDynamicTimeHelper", "show debug [%s]", new Object[] { paramString });
    AppMethodBeat.o(366754);
  }
  
  public final boolean a(long paramLong, int paramInt, btw parambtw)
  {
    AppMethodBeat.i(366778);
    long l;
    boolean bool;
    label90:
    Object localObject;
    if (!this.APG) {
      switch (paramInt)
      {
      case 11: 
      case 12: 
      case 15: 
      case 16: 
      default: 
        l = q.ASF.eaB();
        if (paramLong <= l)
        {
          bool = true;
          if ((this.APG) && (parambtw != null))
          {
            localObject = this.APz;
            ((de)localObject).ikf = ((de)localObject).F("TipsId", parambtw.ZYN, true);
            ((de)localObject).iyT = parambtw.type;
            parambtw = q.ASF;
            parambtw = ((de)localObject).eE(q.eaP());
            parambtw.ijY = cn.bDw();
            if (!bool) {
              break label354;
            }
          }
        }
        break;
      }
    }
    label354:
    for (paramInt = 1;; paramInt = 2)
    {
      parambtw.ilm = paramInt;
      parambtw.iyV = (l / 1000L);
      parambtw.iyY = this.APD;
      parambtw.iyX = this.APC;
      parambtw.iyW = paramLong;
      parambtw.iyZ = parambtw.F("ConfigJson", this.APF.replaceAll(",", ";"), true);
      parambtw.bMH();
      showDebugToast(this.APz.aIF());
      AppMethodBeat.o(366778);
      return bool;
      l = q.ASF.eaz();
      break;
      l = q.ASF.eaB();
      break;
      l = q.ASF.eaD();
      break;
      l = q.ASF.eaC();
      break;
      l = q.ASF.eaE();
      break;
      l = q.ASF.eaF();
      break;
      l = this.APH;
      localObject = q.ASF;
      l = l * 1000L / q.ebb();
      break;
      bool = false;
      break label90;
    }
  }
  
  final void bZN()
  {
    AppMethodBeat.i(366763);
    this.APG = false;
    this.APF = ((c)h.ax(c.class)).a(c.a.zrA, "");
    if ((!Util.isNullOrNil(this.APF)) && (!"-1".equals(this.APF))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.APF);
      this.APJ = localJSONObject.optInt("dropY", 1800);
      this.APK = localJSONObject.optInt("deepY", 1800);
      this.p = localJSONObject.optInt("p", 7200);
      this.z = localJSONObject.optInt("z", 2);
      this.o = localJSONObject.optInt("o", 40);
      this.m = localJSONObject.optInt("m", 86400);
      this.n = localJSONObject.optInt("n", 1800);
      this.q = localJSONObject.optDouble("q", 1.100000023841858D);
      this.APG = true;
      if (this.APH <= 0L)
      {
        this.APH = this.p;
        this.APD = 0;
      }
      for (this.APC = 0;; this.APC = 0)
      {
        label211:
        sz();
        Log.i("MicroMsg.FinderDynamicTimeHelper", "resetControl config[%s] needDynamicTime[%b] redDotDynamicTime[%d] dropRedDotCount[%d] deepReadCount[%d]", new Object[] { this.APF, Boolean.valueOf(this.APG), Long.valueOf(this.APH), Integer.valueOf(this.APC), Integer.valueOf(this.APD) });
        AppMethodBeat.o(366763);
        return;
        this.APH = 0L;
        this.APD = 0;
      }
    }
    catch (Exception localException)
    {
      break label211;
    }
  }
  
  final void sz()
  {
    AppMethodBeat.i(366756);
    h.baE().ban().set(at.a.adbE, Long.valueOf(this.APH));
    h.baE().ban().set(at.a.adbF, Integer.valueOf(this.APC));
    h.baE().ban().set(at.a.adbG, Integer.valueOf(this.APD));
    AppMethodBeat.o(366756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.a
 * JD-Core Version:    0.7.0.1
 */