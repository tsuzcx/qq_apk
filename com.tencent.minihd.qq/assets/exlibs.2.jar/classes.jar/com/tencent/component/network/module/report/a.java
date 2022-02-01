package com.tencent.component.network.module.report;

import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.module.base.b;
import java.util.ArrayList;
import java.util.Random;

final class a
  extends ArrayList
{
  private final boolean b(ReportObj paramReportObj)
  {
    return paramReportObj.p != 0;
  }
  
  public boolean a(ReportObj paramReportObj)
  {
    if (b(paramReportObj))
    {
      b.c("BusinessReport", "download a img fail. need report");
      return super.add(paramReportObj);
    }
    if ((paramReportObj != null) && ((paramReportObj instanceof ReportHandler.DownloadReportObject)) && (((ReportHandler.DownloadReportObject)paramReportObj).a())) {
      return super.add(paramReportObj);
    }
    int i = BusinessReport.a();
    if (i <= 0) {
      return false;
    }
    if (BusinessReport.a().nextInt(Math.round(100 / i)) == 0) {
      return super.add(paramReportObj);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.report.a
 * JD-Core Version:    0.7.0.1
 */