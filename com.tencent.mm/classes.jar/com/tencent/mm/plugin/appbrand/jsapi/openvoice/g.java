package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class g
  extends i
{
  public static final int CTRL_INDEX = 877;
  public static final String NAME = "hasJoinVoIPChat";
  private static String TAG = "MicroMsg.OpenVoice.JsApiHasJoinVoIPChat";
  
  final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(326338);
    Log.i(TAG, "hasJoinVoIPChat");
    paramJSONObject = (b)h.ax(b.class);
    if (paramJSONObject != null)
    {
      paramJSONObject.a(new com.tencent.mm.plugin.ball.c.i()
      {
        public final void dr(List<BallInfo> paramAnonymousList)
        {
          AppMethodBeat.i(326343);
          HashMap localHashMap = new HashMap();
          boolean bool = q.wVc.wVE;
          if (bool)
          {
            localHashMap.put("join", Boolean.TRUE);
            paramc.callback(paramInt, g.this.m("ok", localHashMap));
            Log.i(g.TAG, "hasVoIPChat:%b, now is voip talking", new Object[] { Boolean.valueOf(bool) });
            AppMethodBeat.o(326343);
            return;
          }
          if ((paramAnonymousList == null) || (paramAnonymousList.size() == 0))
          {
            localHashMap.put("join", Boolean.FALSE);
            paramc.callback(paramInt, g.this.m("ok", localHashMap));
            Log.i(g.TAG, "ballInfoList is empty, hasVoIPChat false!");
            AppMethodBeat.o(326343);
            return;
          }
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            BallInfo localBallInfo = (BallInfo)paramAnonymousList.next();
            if ((localBallInfo.type == 17) || (localBallInfo.type == 19))
            {
              Log.i(g.TAG, "has appbrand doing voip");
              bool = true;
            }
          }
          for (;;)
          {
            Log.i(g.TAG, "hasVoIPChat:%b", new Object[] { Boolean.valueOf(bool) });
            localHashMap.put("join", Boolean.valueOf(bool));
            paramc.callback(paramInt, g.this.m("ok", localHashMap));
            AppMethodBeat.o(326343);
            return;
          }
        }
      });
      AppMethodBeat.o(326338);
      return;
    }
    Log.e(TAG, "IFloatBallService is null");
    paramJSONObject = new HashMap();
    paramJSONObject.put("join", Boolean.FALSE);
    paramc.callback(paramInt, m("ok", paramJSONObject));
    AppMethodBeat.o(326338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.g
 * JD-Core Version:    0.7.0.1
 */