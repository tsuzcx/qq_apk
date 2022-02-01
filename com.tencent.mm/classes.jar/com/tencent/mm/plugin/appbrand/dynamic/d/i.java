package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.extension.f;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public i()
  {
    super("openApp", 326);
  }
  
  public final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, final b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121330);
    parama = parama.ayQ();
    b localb = new b();
    localb.id = parama.getString("__page_view_id", "");
    localb.url = paramJSONObject.optString("url", "");
    XIPCInvoker.a(parama.getString("__process_name", MMApplicationContext.getProcessName()), localb, a.class, new d() {});
    AppMethodBeat.o(121330);
  }
  
  static class a
    implements b<i.b, Bundle>
  {}
  
  public static final class b
    implements f
  {
    String id;
    String url;
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(121328);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.url);
      AppMethodBeat.o(121328);
    }
    
    public final void readFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(121329);
      this.id = paramParcel.readString();
      this.url = paramParcel.readString();
      AppMethodBeat.o(121329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.i
 * JD-Core Version:    0.7.0.1
 */