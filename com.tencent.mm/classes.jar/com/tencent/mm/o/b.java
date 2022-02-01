package com.tencent.mm.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.b;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.api.j;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements f
{
  public final void a(f.b paramb) {}
  
  public final int aTl()
  {
    return 10002;
  }
  
  public final long aTm()
  {
    return 0L;
  }
  
  public final void aTn() {}
  
  public final g.b b(g.a parama)
  {
    AppMethodBeat.i(114099);
    parama = ((v)h.az(v.class)).getSysCmdMsgExtension().b(parama);
    AppMethodBeat.o(114099);
    return parama;
  }
  
  public final void b(g.c paramc)
  {
    AppMethodBeat.i(114100);
    Object localObject;
    if ((paramc != null) && ((paramc.otU instanceof j)))
    {
      localObject = ((j)paramc.otU).field_businessInfo;
      if ((localObject == null) || (((tb)localObject).YYw == null)) {}
    }
    try
    {
      localObject = ((tb)localObject).YYw.ZV();
      Log.i("FunctionMsg.NewXmlMsgExtension", "bussinessInfo:%s", new Object[] { localObject });
      localObject = new JSONObject((String)localObject);
      paramc.otW = ((JSONObject)localObject).optString("msgid");
      paramc.otV = ((JSONObject)localObject).optString("msgtype");
      label93:
      ((v)h.az(v.class)).getSysCmdMsgExtension().b(paramc);
      AppMethodBeat.o(114100);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label93;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.o.b
 * JD-Core Version:    0.7.0.1
 */