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

public final class h
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public h()
  {
    super("onTapCallback", 327);
  }
  
  public final void a(com.tencent.mm.ac.c.a parama, JSONObject paramJSONObject, final b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121324);
    parama = parama.aGj();
    b localb = new b();
    localb.id = parama.getString("__page_view_id", "");
    localb.fXM = paramJSONObject.optString("eventId", "");
    localb.oij = paramJSONObject.optBoolean("hasHandler");
    localb.oik = paramJSONObject.optBoolean("res");
    XIPCInvoker.a(parama.getString("__process_name", MMApplicationContext.getProcessName()), localb, a.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(121324);
  }
  
  static class a
    implements d<h.b, Bundle>
  {}
  
  public static final class b
    implements com.tencent.mm.ipcinvoker.extension.f
  {
    String fXM;
    String id;
    boolean oij;
    boolean oik;
    
    public final void e(Parcel paramParcel)
    {
      int j = 1;
      AppMethodBeat.i(121322);
      paramParcel.writeString(this.id);
      if (this.oij)
      {
        i = 1;
        paramParcel.writeInt(i);
        paramParcel.writeString(this.fXM);
        if (!this.oik) {
          break label62;
        }
      }
      label62:
      for (int i = j;; i = 0)
      {
        paramParcel.writeInt(i);
        AppMethodBeat.o(121322);
        return;
        i = 0;
        break;
      }
    }
    
    public final void readFromParcel(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(121323);
      this.id = paramParcel.readString();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.oij = bool1;
        this.fXM = paramParcel.readString();
        if (paramParcel.readInt() != 1) {
          break label64;
        }
      }
      label64:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.oik = bool1;
        AppMethodBeat.o(121323);
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.h
 * JD-Core Version:    0.7.0.1
 */