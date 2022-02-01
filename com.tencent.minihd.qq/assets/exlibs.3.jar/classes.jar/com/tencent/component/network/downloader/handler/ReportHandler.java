package com.tencent.component.network.downloader.handler;

import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;

public abstract interface ReportHandler
{
  public abstract ReportHandler.DownloadReportObject a(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport);
  
  public abstract void a(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport);
  
  public abstract void a(ReportHandler.DownloadReportObject paramDownloadReportObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.handler.ReportHandler
 * JD-Core Version:    0.7.0.1
 */