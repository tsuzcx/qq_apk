package com.tencent.mars.cdn;

public class CdnLogic$Config
{
  public int AckSlice = 8192;
  public String ApprovedVideoHosts = "vweixinf.tc.qq.com,szwbwxsns.video.qq.com,szxzwxsns.video.qq.com,szzjwxsns.video.qq.com,shwbwxsns.video.qq.com,shxzwxsns.video.qq.com,shzjwxsns.video.qq.com,wxsnsdy.wxs.qq.com,vweixinthumb.tc.qq.com,wxsnsdythumb.wxs.qq.com,wxappthumb.tc.qq.com,wxapp.tc.qq.com";
  public int C2COverloadDelaySeconds = 10;
  public int EnableCDNVerifyConnect = 1;
  public int EnableCDNVideoRedirectOC = 1;
  public int EnableSafeCDN = 0;
  public int EnableSnsImageDownload = 0;
  public int EnableSnsStreamDownload = 0;
  public int EnableStreamUploadVideo = 1;
  public int MobileEtl = 70;
  public int Ptl = 35;
  public int SNSOverloadDelaySeconds = 60;
  public int UseDynamicETL = 0;
  public int UseStreamCDN = 1;
  public int WifiEtl = 90;
  public boolean onlyrecvPtl = false;
  public boolean onlysendETL = false;
  
  public String toString()
  {
    return String.format("wifietl:%d, nowifietl:%d,ptl:%d,UseStreamCDN:%d,onlysendetl:%b,onlyrecvptl:%b,ackslice:%d,enableverify:%d,enableoc:%d,enablevideo:%d,dynamicetl:%b,c2coverload:%d,snsoverload:%d,safecdn:%d,snsstream:%d, snsimage:%d", new Object[] { Integer.valueOf(this.WifiEtl), Integer.valueOf(this.MobileEtl), Integer.valueOf(this.Ptl), Integer.valueOf(this.UseStreamCDN), Boolean.valueOf(this.onlysendETL), Boolean.valueOf(this.onlyrecvPtl), Integer.valueOf(this.AckSlice), Integer.valueOf(this.EnableCDNVerifyConnect), Integer.valueOf(this.EnableCDNVideoRedirectOC), Integer.valueOf(this.EnableStreamUploadVideo), Integer.valueOf(this.UseDynamicETL), Integer.valueOf(this.C2COverloadDelaySeconds), Integer.valueOf(this.SNSOverloadDelaySeconds), Integer.valueOf(this.EnableSafeCDN), Integer.valueOf(this.EnableSnsStreamDownload), Integer.valueOf(this.EnableSnsImageDownload) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mars.cdn.CdnLogic.Config
 * JD-Core Version:    0.7.0.1
 */