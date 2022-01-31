package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.bo;

public final class m
{
  public String appId;
  public int bDc;
  public int cmE;
  public final String cpW;
  public final o htX;
  public volatile long iHI;
  public volatile boolean iHJ;
  public int iHK;
  public int iHL;
  public long iHM;
  public long iHN;
  public String iHg;
  public int scene;
  
  public m(o paramo)
  {
    AppMethodBeat.i(132650);
    this.iHJ = false;
    this.htX = paramo;
    this.cpW = paramo.atS().vZ();
    AppMethodBeat.o(132650);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132651);
    String str = "kv_14576{, networkType='" + this.iHg + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.bDc + ", appState=" + this.cmE + ", scene=" + this.scene + ", sessionId='" + this.cpW + '\'' + ", is_download_code=" + this.iHK + ", is_load_x5=" + this.iHL + ", cost_time=" + this.iHM + ", event_time=" + this.iHN + ", load_time=" + this.iHI + ", real_time=" + bo.yB() + '}';
    AppMethodBeat.o(132651);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.m
 * JD-Core Version:    0.7.0.1
 */