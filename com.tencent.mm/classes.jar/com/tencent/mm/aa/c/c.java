package com.tencent.mm.aa.c;

import android.content.Context;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.model.y.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public final class c
{
  a ggc;
  private com.tencent.mm.aa.d.a ggd;
  public d gge;
  b ggf;
  
  public c(Context paramContext, e parame, com.tencent.mm.aa.d.a parama, b paramb)
  {
    AppMethodBeat.i(144805);
    this.ggc = new a(paramContext, parame);
    this.ggd = parama;
    this.ggf = paramb;
    AppMethodBeat.o(144805);
  }
  
  public final String j(String paramString1, String paramString2, final int paramInt)
  {
    AppMethodBeat.i(144806);
    try
    {
      Object localObject = this.gge;
      if (bs.isNullOrNil(paramString1)) {}
      for (localObject = null; localObject == null; localObject = (com.tencent.mm.aa.b.b)((d)localObject).ggj.get(paramString1))
      {
        paramString2 = this.ggf.tM(paramString1);
        AppMethodBeat.o(144806);
        return paramString2;
      }
      paramString2 = this.ggf.a(this.ggc, this.ggd, (com.tencent.mm.aa.b.b)localObject, paramString2, new b.a()
      {
        public final void bi(Object paramAnonymousObject)
        {
          AppMethodBeat.i(144803);
          e locale = c.this.ggc.ggh;
          int i = paramInt;
          if (paramAnonymousObject == null) {}
          for (paramAnonymousObject = "";; paramAnonymousObject = paramAnonymousObject.toString())
          {
            Object localObject = paramAnonymousObject;
            if (bs.isNullOrNil(paramAnonymousObject)) {
              localObject = "{}";
            }
            locale.ggm.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(i), localObject }), null);
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
      ac.e("MicroMsg.MiniJsApiCore", "Invoke JsApi error: %s, %s", new Object[] { paramString1, Log.getStackTraceString(paramString2) });
      AppMethodBeat.o(144806);
      throw paramString2;
    }
  }
  
  static final class a
    implements a
  {
    e ggh;
    y.b ggi;
    Context mContext;
    
    a(Context paramContext, e parame)
    {
      AppMethodBeat.i(144804);
      this.mContext = paramContext;
      this.ggh = parame;
      this.ggi = new y.b();
      AppMethodBeat.o(144804);
    }
    
    public final y.b afz()
    {
      return this.ggi;
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