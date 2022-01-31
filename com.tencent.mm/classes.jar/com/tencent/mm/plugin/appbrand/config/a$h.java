package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.config.a.a.b;
import org.json.JSONObject;

public abstract class a$h
{
  static final JSONObject hhx = new JSONObject();
  public String hhh;
  public String hhl;
  public String hhm;
  public double hhn = 1.0D;
  public String hho = "default";
  public String hhp = "#000000";
  public String hhq;
  public boolean hhr = false;
  public boolean hhs = false;
  public boolean hht = false;
  public boolean hhu = false;
  public String hhv;
  public String hhw;
  
  public static a.b zX(String paramString)
  {
    if ("landscape".equals(paramString)) {
      return a.b.hkG;
    }
    if ("portrait".equals(paramString)) {
      return a.b.hkD;
    }
    if ("auto".equals(paramString)) {
      return a.b.hkE;
    }
    return null;
  }
  
  public final boolean ayo()
  {
    return "custom".equalsIgnoreCase(this.hho);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.h
 * JD-Core Version:    0.7.0.1
 */