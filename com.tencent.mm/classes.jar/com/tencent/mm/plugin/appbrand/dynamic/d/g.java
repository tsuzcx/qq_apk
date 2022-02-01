package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b.b.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.extension.f;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public g()
  {
    super("makePhoneCall", 327);
  }
  
  public final void a(com.tencent.mm.ab.c.a parama, JSONObject paramJSONObject, final b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121318);
    parama = parama.ail();
    a locala = new a((byte)0);
    locala.id = parama.getString("__page_view_id", "");
    locala.dIm = paramJSONObject.optString("phoneNumber", "");
    XIPCInvoker.a(parama.getString("__process_name", aj.getProcessName()), locala, b.class, new d() {});
    AppMethodBeat.o(121318);
  }
  
  static final class a
    implements f
  {
    String dIm;
    String id;
    
    public final void d(Parcel paramParcel)
    {
      AppMethodBeat.i(121314);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.dIm);
      AppMethodBeat.o(121314);
    }
    
    public final void readFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(121315);
      this.id = paramParcel.readString();
      this.dIm = paramParcel.readString();
      AppMethodBeat.o(121315);
    }
  }
  
  static class b
    implements b<g.a, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.g
 * JD-Core Version:    0.7.0.1
 */