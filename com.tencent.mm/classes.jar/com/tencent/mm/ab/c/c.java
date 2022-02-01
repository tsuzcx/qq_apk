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
  a gbw;
  private com.tencent.mm.ab.d.a gbx;
  public d gby;
  b gbz;
  
  public c(Context paramContext, e parame, com.tencent.mm.ab.d.a parama, b paramb)
  {
    AppMethodBeat.i(144805);
    this.gbw = new a(paramContext, parame);
    this.gbx = parama;
    this.gbz = paramb;
    AppMethodBeat.o(144805);
  }
  
  public final String i(String paramString1, String paramString2, final int paramInt)
  {
    AppMethodBeat.i(144806);
    try
    {
      Object localObject = this.gby;
      if (bt.isNullOrNil(paramString1)) {}
      for (localObject = null; localObject == null; localObject = (com.tencent.mm.ab.b.b)((d)localObject).gbD.get(paramString1))
      {
        paramString2 = this.gbz.qx(paramString1);
        AppMethodBeat.o(144806);
        return paramString2;
      }
      paramString2 = this.gbz.a(this.gbw, this.gbx, (com.tencent.mm.ab.b.b)localObject, paramString2, new b.a()
      {
        public final void bl(Object paramAnonymousObject)
        {
          AppMethodBeat.i(144803);
          e locale = c.this.gbw.gbB;
          int i = paramInt;
          if (paramAnonymousObject == null) {}
          for (paramAnonymousObject = "";; paramAnonymousObject = paramAnonymousObject.toString())
          {
            Object localObject = paramAnonymousObject;
            if (bt.isNullOrNil(paramAnonymousObject)) {
              localObject = "{}";
            }
            locale.gbG.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(i), localObject }), null);
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
    e gbB;
    y.b gbC;
    Context mContext;
    
    a(Context paramContext, e parame)
    {
      AppMethodBeat.i(144804);
      this.mContext = paramContext;
      this.gbB = parame;
      this.gbC = new y.b();
      AppMethodBeat.o(144804);
    }
    
    public final y.b aej()
    {
      return this.gbC;
    }
    
    public final Context getContext()
    {
      return this.mContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ab.c.c
 * JD-Core Version:    0.7.0.1
 */