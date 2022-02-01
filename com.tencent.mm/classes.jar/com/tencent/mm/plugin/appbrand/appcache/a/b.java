package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b<_Request extends a, _Response>
{
  public static abstract interface a<_Response, _Progress>
  {
    public abstract void a(String paramString, a parama, _Response param_Response);
    
    public abstract void cr(_Progress param_Progress);
    
    public static enum a
    {
      final int code;
      
      static
      {
        AppMethodBeat.i(90674);
        nIF = new a("OK", 0, 0);
        nIG = new a("FAILED", 1, 101);
        nIH = new a("LOCAL_FILE_NOT_FOUND", 2, 102);
        nII = new a("PKG_INTEGRITY_FAILED", 3, 104);
        nIJ = new a("PKG_INVALID", 4, 105);
        nIK = new a("SEVER_FILE_NOT_FOUND", 5, 106);
        nIL = new a("DISK_FULL", 6, 110);
        nIM = new a("ENV_ERR", 7, 200);
        nIN = new a[] { nIF, nIG, nIH, nII, nIJ, nIK, nIL, nIM };
        AppMethodBeat.o(90674);
      }
      
      private a(int paramInt)
      {
        this.code = paramInt;
      }
      
      public final int bHC()
      {
        return this.code;
      }
    }
  }
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.a.b
 * JD-Core Version:    0.7.0.1
 */