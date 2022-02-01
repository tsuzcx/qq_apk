package com.tencent.mm.plugin.lite.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static d Kah;
  HashMap<Integer, com.tencent.liteapp.jsapi.b> JZV;
  public c Kai;
  b Kaj;
  
  private d()
  {
    AppMethodBeat.i(271538);
    this.Kai = new c();
    this.Kaj = new b();
    this.JZV = new HashMap();
    AppMethodBeat.o(271538);
  }
  
  public static d fUb()
  {
    try
    {
      AppMethodBeat.i(271548);
      if (Kah == null) {
        Kah = new d();
      }
      d locald = Kah;
      AppMethodBeat.o(271548);
      return locald;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.b.b.d
 * JD-Core Version:    0.7.0.1
 */