package com.tencent.mm.ac.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.b.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class c
{
  a kaY;
  private com.tencent.mm.ac.d.a kaZ;
  public d kba;
  b kbb;
  
  public c(Context paramContext, e parame, com.tencent.mm.ac.d.a parama, b paramb)
  {
    AppMethodBeat.i(144805);
    this.kaY = new a(paramContext, parame);
    this.kaZ = parama;
    this.kbb = paramb;
    AppMethodBeat.o(144805);
  }
  
  public final String h(String paramString1, String paramString2, final int paramInt)
  {
    AppMethodBeat.i(144806);
    try
    {
      Object localObject = this.kba;
      if (Util.isNullOrNil(paramString1)) {}
      for (localObject = null; localObject == null; localObject = (com.tencent.mm.ac.b.b)((d)localObject).kbf.get(paramString1))
      {
        paramString2 = this.kbb.Mx(paramString1);
        AppMethodBeat.o(144806);
        return paramString2;
      }
      paramString2 = this.kbb.a(this.kaY, this.kaZ, (com.tencent.mm.ac.b.b)localObject, paramString2, new b.a()
      {
        public final void bt(Object paramAnonymousObject)
        {
          AppMethodBeat.i(144803);
          e locale = c.this.kaY.kbd;
          int i = paramInt;
          if (paramAnonymousObject == null) {}
          for (paramAnonymousObject = "";; paramAnonymousObject = paramAnonymousObject.toString())
          {
            Object localObject = paramAnonymousObject;
            if (Util.isNullOrNil(paramAnonymousObject)) {
              localObject = "{}";
            }
            locale.kbi.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(i), localObject }), null);
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
    e kbd;
    ad.b kbe;
    Context mContext;
    
    a(Context paramContext, e parame)
    {
      AppMethodBeat.i(144804);
      this.mContext = paramContext;
      this.kbd = parame;
      this.kbe = new ad.b();
      AppMethodBeat.o(144804);
    }
    
    public final ad.b aGj()
    {
      return this.kbe;
    }
    
    public final Context getContext()
    {
      return this.mContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ac.c.c
 * JD-Core Version:    0.7.0.1
 */