package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.sdk.b.a.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.q.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.protocal.protobuf.gcm;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

class RemoteDebugJsEngine$4
  extends IListener<com.tencent.mm.autogen.a.q>
{
  RemoteDebugJsEngine$4(q paramq, androidx.lifecycle.q paramq1)
  {
    super(paramq1);
    AppMethodBeat.i(319703);
    this.__eventId = com.tencent.mm.autogen.a.q.class.getName().hashCode();
    AppMethodBeat.o(319703);
  }
  
  private boolean a(com.tencent.mm.autogen.a.q paramq)
  {
    AppMethodBeat.i(147023);
    if ((paramq == null) || (paramq.hzo == null) || (paramq.hzo.hzr == null))
    {
      AppMethodBeat.o(147023);
      return true;
    }
    long l = System.currentTimeMillis();
    if (q.b(this.rdY).rdu.eul == 1) {
      Log.d("MicroMsg.RemoteDebugJsEngine", "NEW_REMOTE_DEBUG_TYPE and do onReceiveNetworkHeader");
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("api_name", paramq.hzo.hzp);
        ((JSONObject)localObject).put("task_id", paramq.hzo.hzq);
        ((JSONObject)localObject).put("request_headers", paramq.hzo.hzr.toString());
        ((JSONObject)localObject).put("timestamp", l);
        if (q.f(this.rdY) != null)
        {
          paramq = q.f(this.rdY);
          localObject = ((JSONObject)localObject).toString();
          Log.d("MicroMsg.RemoteDebugMsgMrg", "onReceiveNetworkHeader data:%s", new Object[] { localObject });
          localObject = "typeof DebuggerConnection.onReceiveNetworkHeader === 'function' && DebuggerConnection.onReceiveNetworkHeader('" + y.agF((String)localObject) + "')";
          paramq.esY.rdo.getJsRuntime().evaluateJavascript((String)localObject, null);
        }
        AppMethodBeat.o(147023);
        return true;
      }
      catch (Exception paramq)
      {
        Log.printDebugStack("MicroMsg.RemoteDebugJsEngine", "", new Object[] { paramq });
        continue;
      }
      Object localObject = new gcm();
      ((gcm)localObject).hzp = paramq.hzo.hzp;
      ((gcm)localObject).hzq = paramq.hzo.hzq;
      ((gcm)localObject).acax = paramq.hzo.hzr.toString();
      ((gcm)localObject).timestamp = l;
      paramq = x.a((a)localObject, q.b(this.rdY), "networkDebugAPI");
      this.rdY.a(paramq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugJsEngine.4
 * JD-Core Version:    0.7.0.1
 */