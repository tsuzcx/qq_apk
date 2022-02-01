package com.tencent.mm.plugin.flutter.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.i;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class c
{
  public String HjZ;
  public HashMap<String, Object> Hka;
  public int Hkb = 0;
  public boolean Hkc = false;
  public String hJP;
  public LinkedHashMap<String, Object> sDt;
  
  public c() {}
  
  public c(String paramString1, String paramString2, LinkedHashMap<String, Object> paramLinkedHashMap)
  {
    this.HjZ = paramString1;
    this.hJP = paramString2;
    this.sDt = paramLinkedHashMap;
  }
  
  public final String toJsonString()
  {
    AppMethodBeat.i(123738);
    Object localObject = new i();
    try
    {
      ((i)localObject).m("plugin", this.HjZ);
      ((i)localObject).m("entry", this.hJP);
      if (this.sDt != null) {
        ((i)localObject).m("params", new i(this.sDt));
      }
      if (this.Hka != null) {
        ((i)localObject).m("initParams", new i(this.Hka));
      }
      ((i)localObject).au("parentPageType", this.Hkb);
      ((i)localObject).A("isInitRoute", this.Hkc);
    }
    catch (g localg)
    {
      label107:
      break label107;
    }
    localObject = ((i)localObject).toString();
    AppMethodBeat.o(123738);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123739);
    String str = toJsonString();
    AppMethodBeat.o(123739);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.a.c
 * JD-Core Version:    0.7.0.1
 */