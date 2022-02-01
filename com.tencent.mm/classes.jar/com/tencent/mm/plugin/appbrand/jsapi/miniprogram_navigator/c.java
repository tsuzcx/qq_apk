package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import org.json.JSONObject;

public abstract interface c
{
  public abstract void a(g paramg, String paramString1, int paramInt, String paramString2, a parama, JSONObject paramJSONObject, c paramc);
  
  public static final class a
  {
    public String businessType;
    public int fXa;
    public String fXb;
    public String fvd;
    public String nYD;
    public String pcH;
    public int scene;
    public int sourceType;
  }
  
  public static abstract interface b
  {
    public abstract void a(a parama);
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(242132);
        pcI = new a("PROCEED", 0);
        pcJ = new a("IGNORE", 1);
        pcK = new a("CANCEL", 2);
        pcL = new a[] { pcI, pcJ, pcK };
        AppMethodBeat.o(242132);
      }
      
      private a() {}
    }
  }
  
  public static abstract interface c
  {
    public abstract void s(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c
 * JD-Core Version:    0.7.0.1
 */