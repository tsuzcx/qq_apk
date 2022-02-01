package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b<_Request extends a, _Response>
{
  public static abstract interface a<_Response, _Progress>
  {
    public abstract void a(String paramString, a parama, _Response param_Response);
    
    public abstract void dM(_Progress param_Progress);
    
    public static enum a
    {
      public final int code;
      
      static
      {
        AppMethodBeat.i(90674);
        qIw = new a("OK", 0, 0);
        qIx = new a("FAILED", 1, 101);
        qIy = new a("LOCAL_FILE_NOT_FOUND", 2, 102);
        qIz = new a("PKG_INVALID", 3, 105);
        qIA = new a("SEVER_FILE_NOT_FOUND", 4, 106);
        qIB = new a("DISK_FULL", 5, 110);
        qIC = new a("ENV_ERR", 6, 120);
        qID = new a[] { qIw, qIx, qIy, qIz, qIA, qIB, qIC };
        AppMethodBeat.o(90674);
      }
      
      private a(int paramInt)
      {
        this.code = paramInt;
      }
    }
  }
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.a.b
 * JD-Core Version:    0.7.0.1
 */