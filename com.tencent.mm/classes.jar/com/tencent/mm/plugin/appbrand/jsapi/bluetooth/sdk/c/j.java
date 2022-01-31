package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

public final class j
{
  public static final j gmO = new j(0, "");
  public static final j gmP = new j(-1, "fail:internal error");
  public static final j gmQ = new j(10000, "fail:not init");
  public static final j gmR = new j(10001, "fail:not available");
  public static final j gmS = new j(10002, "fail:no device");
  public static final j gmT = new j(10003, "fail:connection fail");
  public static final j gmU = new j(10004, "fail:no service");
  public static final j gmV = new j(10005, "fail:no characteristic");
  public static final j gmW = new j(10006, "fail:no connection");
  public static final j gmX = new j(10007, "fail:property not support");
  public static final j gmY = new j(10008, "fail:system error");
  public static final j gmZ = new j(10009, "fail:system not support");
  public static final j gna = new j(10008, "fail:no descriptor");
  public static final j gnb = new j(10008, "fail:fail to set descriptor");
  public static final j gnc = new j(10008, "fail:fail to write descriptor");
  public static final j gnd = new j(10012, "fail:operate time out");
  public static final j gne = new j(-1, "fail:already connect");
  public static final j gnf = new j(10013, "fail:invalid data");
  public static final j gng = new j(10008, "fail:not found service");
  public String aox;
  public int errCode;
  
  public j(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.aox = paramString;
  }
  
  public final String toString()
  {
    return "Result{errCode=" + this.errCode + ", errMsg='" + this.aox + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j
 * JD-Core Version:    0.7.0.1
 */