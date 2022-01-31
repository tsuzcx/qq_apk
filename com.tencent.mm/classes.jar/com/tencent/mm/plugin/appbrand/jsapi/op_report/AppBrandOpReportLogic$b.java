package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.util.SparseIntArray;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.blj;
import com.tencent.mm.protocal.c.blk;
import com.tencent.mm.sdk.platformtools.bk;

public final class AppBrandOpReportLogic$b
{
  private static final SparseIntArray gyE = new SparseIntArray();
  
  static void a(AppBrandOpReportLogic.ReportTask paramReportTask)
  {
    if (paramReportTask == null) {
      return;
    }
    b.a locala = new b.a();
    locala.ecG = 1345;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose";
    locala.ecI = new blk();
    String str = paramReportTask.appId;
    blj localblj = new blj();
    localblj.tEV = new avh();
    localblj.tEV.bOL = str;
    localblj.tEV.username = paramReportTask.username;
    localblj.tEV.tmZ = paramReportTask.fJy;
    localblj.tEV.sCy = paramReportTask.cau;
    localblj.tEV.pyo = paramReportTask.scene;
    localblj.tEV.tqL = paramReportTask.caB;
    localblj.tEV.tqM = 1;
    localblj.tEV.tqN = paramReportTask.bFw;
    localblj.tEV.tqO = paramReportTask.glj;
    localblj.sZc = paramReportTask.gyF;
    locala.ecH = localblj;
    w.a(locala.Kt(), new AppBrandOpReportLogic.b.1(str), true);
  }
  
  static void aR(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {
      return;
    }
    synchronized (gyE)
    {
      gyE.put(paramString.hashCode(), paramInt);
      return;
    }
  }
  
  public static int uz(String paramString)
  {
    if (bk.bl(paramString)) {
      return 0;
    }
    synchronized (gyE)
    {
      int i = gyE.get(paramString.hashCode(), 0);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.b
 * JD-Core Version:    0.7.0.1
 */