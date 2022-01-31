package com.tencent.mm.plugin.appbrand.config;

import org.json.JSONObject;

public abstract class a$g
{
  static final JSONObject fOg = new JSONObject();
  public String fNR;
  public String fNU;
  public String fNV;
  public double fNW = 1.0D;
  public String fNX = "default";
  public String fNY = "#000000";
  public String fNZ;
  public String fOa;
  public boolean fOb = false;
  public boolean fOc = false;
  public boolean fOd = false;
  public String fOe;
  public String fOf = "portrait";
  
  public static e.b sg(String paramString)
  {
    if ("landscape".equals(paramString)) {
      return e.b.fOt;
    }
    if ("portrait".equals(paramString)) {
      return e.b.fOq;
    }
    if ("auto".equals(paramString)) {
      return e.b.fOr;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.g
 * JD-Core Version:    0.7.0.1
 */