package com.tencent.mobileqq.activity.widget.qqmusic.business.radio;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.widget.qqmusic.network.Network;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.DeleteSongXmlRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.DeleteSongXmlBody;
import com.tencent.mobileqq.music.SongInfo;

public class SingleSongRadioBehaviorReport
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 12;
  public static final int k = 15;
  public static final int l = 16;
  public static final int m = 1;
  public static final int n = 9;
  public static final int o = 13;
  public static final int p = 15;
  public static int q = 1;
  private int r = 1;
  
  private void a(SongInfo paramSongInfo, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    paramString1 = new DeleteSongXmlRequest();
    paramString1.a(DeleteSongXmlBody.a(BaseApplicationImpl.getContext(), null, paramSongInfo, paramLong, paramString2, paramInt, this.r));
    Network.a(paramString1, null);
  }
  
  private void a(SongInfo paramSongInfo, String paramString1, long paramLong, String paramString2, SingleSongRadioBehaviorReport.SingleSongRadioBehaviorReportListener paramSingleSongRadioBehaviorReportListener, int paramInt)
  {
    a(paramSongInfo, paramString1, paramLong, paramString2, paramInt);
  }
  
  public static void a(SongInfo paramSongInfo, String paramString1, long paramLong, String paramString2, SingleSongRadioBehaviorReport.SingleSongRadioBehaviorReportListener paramSingleSongRadioBehaviorReportListener, int paramInt1, int paramInt2)
  {
    if (paramSongInfo == null) {
      return;
    }
    try
    {
      SingleSongRadioBehaviorReport localSingleSongRadioBehaviorReport = new SingleSongRadioBehaviorReport();
      localSingleSongRadioBehaviorReport.a(paramInt2);
      localSingleSongRadioBehaviorReport.a(paramSongInfo, paramString1, paramLong, paramString2, paramSingleSongRadioBehaviorReportListener, paramInt1);
      return;
    }
    catch (Exception paramSongInfo)
    {
      paramSongInfo.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    this.r = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.radio.SingleSongRadioBehaviorReport
 * JD-Core Version:    0.7.0.1
 */