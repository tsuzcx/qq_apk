package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class at
  extends b
{
  private c cnn;
  private String kvu;
  private Map<String, Object> kvv;
  int kvw;
  
  public at I(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(140645);
    if (paramMap == null)
    {
      AppMethodBeat.o(140645);
      return this;
    }
    d.k(paramMap);
    this.kvv = paramMap;
    AppMethodBeat.o(140645);
    return this;
  }
  
  public at PQ(String paramString)
  {
    this.kvu = paramString;
    return this;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(201178);
    if (this.cnn == null)
    {
      AppMethodBeat.o(201178);
      return;
    }
    this.cnn.a(this, paramo);
    AppMethodBeat.o(201178);
  }
  
  public at b(c paramc, int paramInt)
  {
    AppMethodBeat.i(140643);
    h(paramc);
    this.kvw = paramInt;
    AppMethodBeat.o(140643);
    return this;
  }
  
  public void bja()
  {
    AppMethodBeat.i(140647);
    a(null);
    AppMethodBeat.o(140647);
  }
  
  public final String getData()
  {
    AppMethodBeat.i(140646);
    String str;
    if (this.kvu != null)
    {
      str = this.kvu;
      AppMethodBeat.o(140646);
      return str;
    }
    if (this.kvv != null)
    {
      d.k(this.kvv);
      str = new JSONObject(this.kvv).toString();
      AppMethodBeat.o(140646);
      return str;
    }
    AppMethodBeat.o(140646);
    return null;
  }
  
  public at h(c paramc)
  {
    if (paramc == null) {
      return this;
    }
    this.cnn = paramc;
    this.kvw = 0;
    return this;
  }
  
  public final at p(String paramString, Object paramObject)
  {
    AppMethodBeat.i(140644);
    if (this.kvv == null) {
      this.kvv = new HashMap();
    }
    this.kvv.put(paramString, paramObject);
    AppMethodBeat.o(140644);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.at
 * JD-Core Version:    0.7.0.1
 */