package com.tencent.mm.ab.c;

import android.content.Context;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b.b.a;
import com.tencent.mm.model.y.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class c
{
  a gzM;
  private com.tencent.mm.ab.d.a gzN;
  public d gzO;
  b gzP;
  
  public c(Context paramContext, e parame, com.tencent.mm.ab.d.a parama, b paramb)
  {
    AppMethodBeat.i(144805);
    this.gzM = new a(paramContext, parame);
    this.gzN = parama;
    this.gzP = paramb;
    AppMethodBeat.o(144805);
  }
  
  public final String i(String paramString1, String paramString2, final int paramInt)
  {
    AppMethodBeat.i(144806);
    try
    {
      Object localObject = this.gzO;
      if (bt.isNullOrNil(paramString1)) {}
      for (localObject = null; localObject == null; localObject = (com.tencent.mm.ab.b.b)((d)localObject).gzT.get(paramString1))
      {
        paramString2 = this.gzP.wC(paramString1);
        AppMethodBeat.o(144806);
        return paramString2;
      }
      paramString2 = this.gzP.a(this.gzM, this.gzN, (com.tencent.mm.ab.b.b)localObject, paramString2, new b.a()
      {
        public final void bk(Object paramAnonymousObject)
        {
          AppMethodBeat.i(144803);
          e locale = c.this.gzM.gzR;
          int i = paramInt;
          if (paramAnonymousObject == null) {}
          for (paramAnonymousObject = "";; paramAnonymousObject = paramAnonymousObject.toString())
          {
            Object localObject = paramAnonymousObject;
            if (bt.isNullOrNil(paramAnonymousObject)) {
              localObject = "{}";
            }
            locale.gzW.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(i), localObject }), null);
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
      ad.e("MicroMsg.MiniJsApiCore", "Invoke JsApi error: %s, %s", new Object[] { paramString1, Log.getStackTraceString(paramString2) });
      AppMethodBeat.o(144806);
      throw paramString2;
    }
  }
  
  static final class a
    implements a
  {
    e gzR;
    y.b gzS;
    Context mContext;
    
    a(Context paramContext, e parame)
    {
      AppMethodBeat.i(144804);
      this.mContext = paramContext;
      this.gzR = parame;
      this.gzS = new y.b();
      AppMethodBeat.o(144804);
    }
    
    public final y.b ail()
    {
      return this.gzS;
    }
    
    public final Context getContext()
    {
      return this.mContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ab.c.c
 * JD-Core Version:    0.7.0.1
 */