package com.tencent.mm.aa.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class c
{
  a hph;
  private com.tencent.mm.aa.d.a hpi;
  public d hpj;
  b hpk;
  
  public c(Context paramContext, e parame, com.tencent.mm.aa.d.a parama, b paramb)
  {
    AppMethodBeat.i(144805);
    this.hph = new a(paramContext, parame);
    this.hpi = parama;
    this.hpk = paramb;
    AppMethodBeat.o(144805);
  }
  
  public final String h(String paramString1, String paramString2, final int paramInt)
  {
    AppMethodBeat.i(144806);
    try
    {
      Object localObject = this.hpj;
      if (Util.isNullOrNil(paramString1)) {}
      for (localObject = null; localObject == null; localObject = (com.tencent.mm.aa.b.b)((d)localObject).hpo.get(paramString1))
      {
        paramString2 = this.hpk.Fx(paramString1);
        AppMethodBeat.o(144806);
        return paramString2;
      }
      paramString2 = this.hpk.a(this.hph, this.hpi, (com.tencent.mm.aa.b.b)localObject, paramString2, new b.a()
      {
        public final void bt(Object paramAnonymousObject)
        {
          AppMethodBeat.i(144803);
          e locale = c.this.hph.hpm;
          int i = paramInt;
          if (paramAnonymousObject == null) {}
          for (paramAnonymousObject = "";; paramAnonymousObject = paramAnonymousObject.toString())
          {
            Object localObject = paramAnonymousObject;
            if (Util.isNullOrNil(paramAnonymousObject)) {
              localObject = "{}";
            }
            locale.hpr.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(i), localObject }), null);
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
    e hpm;
    ad.b hpn;
    Context mContext;
    
    a(Context paramContext, e parame)
    {
      AppMethodBeat.i(144804);
      this.mContext = paramContext;
      this.hpm = parame;
      this.hpn = new ad.b();
      AppMethodBeat.o(144804);
    }
    
    public final ad.b ayQ()
    {
      return this.hpn;
    }
    
    public final Context getContext()
    {
      return this.mContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aa.c.c
 * JD-Core Version:    0.7.0.1
 */