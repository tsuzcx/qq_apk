package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.d.a.i;
import com.tencent.mm.d.a.i.a;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.v.p;
import java.util.ArrayList;

public final class t
  extends s
{
  public t(o paramo)
  {
    super(paramo);
  }
  
  protected final i aaD()
  {
    return new aa(this.bzH);
  }
  
  protected final void b(ArrayList<i.a> paramArrayList, String paramString)
  {
    super.b(paramArrayList, paramString);
    paramArrayList.add(new aa.a(this.fyo.aay() + "WAWorker.js", aq.a(this.fyo.getRuntime(), "WAWorker.js"), this.fyo.mAppId, this.fyo.aan()));
    paramString = p.getSysInfo();
    paramArrayList.add(new i.a(this.fyo.aay() + "sourcemapSysinfo", paramString));
    paramString = aq.a(this.fyo.getRuntime(), "WASourceMap.js");
    paramArrayList.add(new i.a(this.fyo.aay() + "WASourceMap.js", paramString));
  }
  
  protected final i.a qO(String paramString)
  {
    return new aa.a(super.qO(paramString), p.a(this.fyo.getRuntime(), paramString, this.fyo.aaz()), this.fyo.mAppId, this.fyo.aan());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t
 * JD-Core Version:    0.7.0.1
 */