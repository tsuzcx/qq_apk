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

public final class h
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public h()
  {
    super("onTapCallback", 327);
  }
  
  public final void a(com.tencent.mm.ab.c.a parama, JSONObject paramJSONObject, final b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121324);
    parama = parama.aej();
    b localb = new b();
    localb.id = parama.getString("__page_view_id", "");
    localb.dAA = paramJSONObject.optString("eventId", "");
    localb.jmb = paramJSONObject.optBoolean("hasHandler");
    localb.jmc = paramJSONObject.optBoolean("res");
    XIPCInvoker.a(parama.getString("__process_name", aj.getProcessName()), localb, a.class, new d() {});
    AppMethodBeat.o(121324);
  }
  
  static class a
    implements b<h.b, Bundle>
  {}
  
  public static final class b
    implements f
  {
    String dAA;
    String id;
    boolean jmb;
    boolean jmc;
    
    public final void d(Parcel paramParcel)
    {
      int j = 1;
      AppMethodBeat.i(121322);
      paramParcel.writeString(this.id);
      if (this.jmb)
      {
        i = 1;
        paramParcel.writeInt(i);
        paramParcel.writeString(this.dAA);
        if (!this.jmc) {
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
        this.jmb = bool1;
        this.dAA = paramParcel.readString();
        if (paramParcel.readInt() != 1) {
          break label64;
        }
      }
      label64:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.jmc = bool1;
        AppMethodBeat.o(121323);
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.h
 * JD-Core Version:    0.7.0.1
 */