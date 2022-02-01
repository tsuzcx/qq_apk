package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h.a.c.k;

public abstract interface b<_Request extends a, _Response, _Progress extends k>
{
  public static abstract interface a<_Response, _Progress>
  {
    public abstract void a(String paramString, a parama, _Response param_Response);
    
    public abstract void ci(_Progress param_Progress);
    
    public static enum a
    {
      public final int code;
      
      static
      {
        AppMethodBeat.i(90674);
        iPs = new a("OK", 0, 0);
        iPt = new a("FAILED", 1, 101);
        iPu = new a("LOCAL_FILE_NOT_FOUND", 2, 102);
        iPw = new a("PKG_INTEGRITY_FAILED", 3, 104);
        iPx = new a("PKG_INVALID", 4, 105);
        iPy = new a("SEVER_FILE_NOT_FOUND", 5, 106);
        iPz = new a("DISK_FULL", 6, 110);
        iPA = new a("ENV_ERR", 7, 200);
        iPB = new a[] { iPs, iPt, iPu, iPw, iPx, iPy, iPz, iPA };
        AppMethodBeat.o(90674);
      }
      
      private a(int paramInt)
      {
        this.code = paramInt;
      }
      
      public final int aQs()
      {
        return this.code;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void aQB();
  }
  
  public static abstract interface c
  {
    public abstract void aQC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.a.b
 * JD-Core Version:    0.7.0.1
 */