package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Parcel;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.extension.f;
import com.tencent.mm.model.u.b;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public i()
  {
    super("openApp", 326);
  }
  
  protected final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    parama = parama.CD();
    b localb = new b();
    localb.id = parama.getString("__page_view_id", "");
    localb.url = paramJSONObject.optString("url", "");
    XIPCInvoker.a(parama.getString("__process_name", ae.getProcessName()), localb, i.a.class, new i.1(this, parama1));
  }
  
  public static final class b
    implements f
  {
    String id;
    String url;
    
    public final void d(Parcel paramParcel)
    {
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.url);
    }
    
    public final void readFromParcel(Parcel paramParcel)
    {
      this.id = paramParcel.readString();
      this.url = paramParcel.readString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.i
 * JD-Core Version:    0.7.0.1
 */