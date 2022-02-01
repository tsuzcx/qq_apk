package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bc
  extends e
{
  private f czm;
  private String lzw;
  private Map<String, Object> lzx;
  int lzy;
  
  public bc L(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(140645);
    if (paramMap == null)
    {
      AppMethodBeat.o(140645);
      return this;
    }
    com.tencent.luggage.h.e.m(paramMap);
    this.lzx = paramMap;
    AppMethodBeat.o(140645);
    return this;
  }
  
  public bc Zh(String paramString)
  {
    this.lzw = paramString;
    return this;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(221220);
    if (this.czm == null)
    {
      AppMethodBeat.o(221220);
      return;
    }
    this.czm.a(this, paramo);
    AppMethodBeat.o(221220);
  }
  
  public bc b(f paramf, int paramInt)
  {
    AppMethodBeat.i(140643);
    h(paramf);
    this.lzy = paramInt;
    AppMethodBeat.o(140643);
    return this;
  }
  
  public void bEo()
  {
    AppMethodBeat.i(140647);
    a(null);
    AppMethodBeat.o(140647);
  }
  
  public final String getData()
  {
    AppMethodBeat.i(140646);
    String str;
    if (this.lzw != null)
    {
      str = this.lzw;
      AppMethodBeat.o(140646);
      return str;
    }
    if (this.lzx != null)
    {
      com.tencent.luggage.h.e.m(this.lzx);
      str = new JSONObject(this.lzx).toString();
      AppMethodBeat.o(140646);
      return str;
    }
    AppMethodBeat.o(140646);
    return null;
  }
  
  public bc h(f paramf)
  {
    if (paramf == null) {
      return this;
    }
    this.czm = paramf;
    this.lzy = 0;
    return this;
  }
  
  public final bc p(String paramString, Object paramObject)
  {
    AppMethodBeat.i(140644);
    if (this.lzx == null) {
      this.lzx = new HashMap();
    }
    this.lzx.put(paramString, paramObject);
    AppMethodBeat.o(140644);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bc
 * JD-Core Version:    0.7.0.1
 */