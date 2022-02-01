package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.k;

public abstract interface b<_Request extends a, _Response, _Progress extends k>
{
  public static abstract interface a<_Response, _Progress>
  {
    public abstract void a(String paramString, a parama, _Response param_Response);
    
    public abstract void cr(_Progress param_Progress);
    
    public static enum a
    {
      public final int code;
      
      static
      {
        AppMethodBeat.i(90674);
        kOC = new a("OK", 0, 0);
        kOD = new a("FAILED", 1, 101);
        kOE = new a("LOCAL_FILE_NOT_FOUND", 2, 102);
        kOF = new a("PKG_INTEGRITY_FAILED", 3, 104);
        kOG = new a("PKG_INVALID", 4, 105);
        kOH = new a("SEVER_FILE_NOT_FOUND", 5, 106);
        kOI = new a("DISK_FULL", 6, 110);
        kOJ = new a("ENV_ERR", 7, 200);
        kOK = new a[] { kOC, kOD, kOE, kOF, kOG, kOH, kOI, kOJ };
        AppMethodBeat.o(90674);
      }
      
      private a(int paramInt)
      {
        this.code = paramInt;
      }
      
      public final int bwv()
      {
        return this.code;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void bwD();
  }
  
  public static abstract interface c
  {
    public abstract void bwE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.a.b
 * JD-Core Version:    0.7.0.1
 */