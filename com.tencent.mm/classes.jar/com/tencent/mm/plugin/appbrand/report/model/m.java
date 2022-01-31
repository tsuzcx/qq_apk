package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.sdk.platformtools.bk;

public final class m
{
  public String appId;
  public int bFu;
  public final String bIB;
  public int cau;
  public String gYR;
  public volatile long gZs;
  public volatile boolean gZt = false;
  public int gZu;
  public int gZv;
  public long gZw;
  public long gZx;
  public final n gaS;
  public int scene;
  
  public m(n paramn)
  {
    this.gaS = paramn;
    this.bIB = paramn.aac().fJO;
  }
  
  public final String toString()
  {
    return "kv_14576{, networkType='" + this.gYR + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.cau + ", appState=" + this.bFu + ", scene=" + this.scene + ", sessionId='" + this.bIB + '\'' + ", is_download_code=" + this.gZu + ", is_load_x5=" + this.gZv + ", cost_time=" + this.gZw + ", event_time=" + this.gZx + ", load_time=" + this.gZs + ", real_time=" + bk.UZ() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.m
 * JD-Core Version:    0.7.0.1
 */