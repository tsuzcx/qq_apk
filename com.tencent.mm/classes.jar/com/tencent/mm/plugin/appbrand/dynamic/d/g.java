package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.b.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public g()
  {
    super("makePhoneCall", 327);
  }
  
  public final void a(com.tencent.mm.ac.c.a parama, JSONObject paramJSONObject, final b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121318);
    parama = parama.aGj();
    a locala = new a((byte)0);
    locala.id = parama.getString("__page_view_id", "");
    locala.fVa = paramJSONObject.optString("phoneNumber", "");
    XIPCInvoker.a(parama.getString("__process_name", MMApplicationContext.getProcessName()), locala, b.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(121318);
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.extension.f
  {
    String fVa;
    String id;
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(121314);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.fVa);
      AppMethodBeat.o(121314);
    }
    
    public final void readFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(121315);
      this.id = paramParcel.readString();
      this.fVa = paramParcel.readString();
      AppMethodBeat.o(121315);
    }
  }
  
  static class b
    implements d<g.a, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.g
 * JD-Core Version:    0.7.0.1
 */