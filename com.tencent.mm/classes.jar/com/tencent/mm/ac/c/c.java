package com.tencent.mm.ac.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.b.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class c
{
  a mBd;
  private com.tencent.mm.ac.d.a mBe;
  public d mBf;
  b mBg;
  
  public c(Context paramContext, e parame, com.tencent.mm.ac.d.a parama, b paramb)
  {
    AppMethodBeat.i(144805);
    this.mBd = new a(paramContext, parame);
    this.mBe = parama;
    this.mBg = paramb;
    AppMethodBeat.o(144805);
  }
  
  public final String k(String paramString1, String paramString2, final int paramInt)
  {
    AppMethodBeat.i(144806);
    try
    {
      Object localObject = this.mBf;
      if (Util.isNullOrNil(paramString1)) {}
      for (localObject = null; localObject == null; localObject = (com.tencent.mm.ac.b.b)((d)localObject).mBk.get(paramString1))
      {
        paramString2 = this.mBg.Fg(paramString1);
        AppMethodBeat.o(144806);
        return paramString2;
      }
      paramString2 = this.mBg.a(this.mBd, this.mBe, (com.tencent.mm.ac.b.b)localObject, paramString2, new b.a()
      {
        public final void cN(Object paramAnonymousObject)
        {
          AppMethodBeat.i(144803);
          e locale = c.this.mBd.mBi;
          int i = paramInt;
          if (paramAnonymousObject == null) {}
          for (paramAnonymousObject = "";; paramAnonymousObject = paramAnonymousObject.toString())
          {
            Object localObject = paramAnonymousObject;
            if (Util.isNullOrNil(paramAnonymousObject)) {
              localObject = "{}";
            }
            locale.mBn.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(i), localObject }), null);
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
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MiniJsApiCore", "Invoke JsApi error: %s, %s", new Object[] { paramString1, android.util.Log.getStackTraceString(paramString2) });
      AppMethodBeat.o(144806);
      throw paramString2;
    }
  }
  
  static final class a
    implements a
  {
    e mBi;
    ad.b mBj;
    Context mContext;
    
    a(Context paramContext, e parame)
    {
      AppMethodBeat.i(144804);
      this.mContext = paramContext;
      this.mBi = parame;
      this.mBj = new ad.b();
      AppMethodBeat.o(144804);
    }
    
    public final ad.b aZk()
    {
      return this.mBj;
    }
    
    public final Context getContext()
    {
      return this.mContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ac.c.c
 * JD-Core Version:    0.7.0.1
 */