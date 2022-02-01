package com.tencent.mm.aa.c;

import android.content.Context;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.model.z.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public final class c
{
  a gCt;
  private com.tencent.mm.aa.d.a gCu;
  public d gCv;
  b gCw;
  
  public c(Context paramContext, e parame, com.tencent.mm.aa.d.a parama, b paramb)
  {
    AppMethodBeat.i(144805);
    this.gCt = new a(paramContext, parame);
    this.gCu = parama;
    this.gCw = paramb;
    AppMethodBeat.o(144805);
  }
  
  public final String i(String paramString1, String paramString2, final int paramInt)
  {
    AppMethodBeat.i(144806);
    try
    {
      Object localObject = this.gCv;
      if (bu.isNullOrNil(paramString1)) {}
      for (localObject = null; localObject == null; localObject = (com.tencent.mm.aa.b.b)((d)localObject).gCA.get(paramString1))
      {
        paramString2 = this.gCw.xl(paramString1);
        AppMethodBeat.o(144806);
        return paramString2;
      }
      paramString2 = this.gCw.a(this.gCt, this.gCu, (com.tencent.mm.aa.b.b)localObject, paramString2, new b.a()
      {
        public final void bk(Object paramAnonymousObject)
        {
          AppMethodBeat.i(144803);
          e locale = c.this.gCt.gCy;
          int i = paramInt;
          if (paramAnonymousObject == null) {}
          for (paramAnonymousObject = "";; paramAnonymousObject = paramAnonymousObject.toString())
          {
            Object localObject = paramAnonymousObject;
            if (bu.isNullOrNil(paramAnonymousObject)) {
              localObject = "{}";
            }
            locale.gCD.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(i), localObject }), null);
            AppMethodBeat.o(144803);
            return;
          }
        }
      });
      AppMethodBeat.o(144806);
      return paramString2;
    }
    catch (Exception paramString2)
    {
      ae.e("MicroMsg.MiniJsApiCore", "Invoke JsApi error: %s, %s", new Object[] { paramString1, Log.getStackTraceString(paramString2) });
      AppMethodBeat.o(144806);
      throw paramString2;
    }
  }
  
  static final class a
    implements a
  {
    e gCy;
    z.b gCz;
    Context mContext;
    
    a(Context paramContext, e parame)
    {
      AppMethodBeat.i(144804);
      this.mContext = paramContext;
      this.gCy = parame;
      this.gCz = new z.b();
      AppMethodBeat.o(144804);
    }
    
    public final z.b aiA()
    {
      return this.gCz;
    }
    
    public final Context getContext()
    {
      return this.mContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aa.c.c
 * JD-Core Version:    0.7.0.1
 */