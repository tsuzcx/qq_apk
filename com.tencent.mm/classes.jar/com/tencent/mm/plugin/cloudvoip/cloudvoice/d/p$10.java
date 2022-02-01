package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dqc;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p$10
  implements Runnable
{
  public p$10(p paramp, JSONObject paramJSONObject, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(90867);
    Object localObject2 = new LinkedList();
    Object localObject1 = this.kBU.optJSONArray("openIdList");
    if (localObject1 != null)
    {
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        ((LinkedList)localObject2).add(((JSONArray)localObject1).optString(i, ""));
        i += 1;
      }
    }
    localObject1 = new ArrayList();
    localObject2 = ((LinkedList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if (str != null)
      {
        dqc localdqc = p.m(this.ouS).We(str);
        if (localdqc != null)
        {
          ac.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: subscribe, get member OK for openid:%s", new Object[] { str });
          ((ArrayList)localObject1).add(localdqc);
        }
      }
    }
    ac.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: subscribe, videoMembers %s", new Object[] { localObject1 });
    l.K((ArrayList)localObject1);
    this.ouV.a(0, 0, "ok", Integer.valueOf(0));
    AppMethodBeat.o(90867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.10
 * JD-Core Version:    0.7.0.1
 */