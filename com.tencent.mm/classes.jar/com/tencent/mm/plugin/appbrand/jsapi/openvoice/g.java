package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
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
    AppMethodBeat.i(226930);
    Log.i(TAG, "hasJoinVoIPChat");
    paramJSONObject = (b)com.tencent.mm.kernel.g.af(b.class);
    if (paramJSONObject != null)
    {
      paramJSONObject.a(new com.tencent.mm.plugin.ball.c.i()
      {
        public final void bH(List<BallInfo> paramAnonymousList)
        {
          AppMethodBeat.i(226929);
          HashMap localHashMap = new HashMap();
          boolean bool = q.qta.qtB;
          if (bool)
          {
            localHashMap.put("join", Boolean.TRUE);
            paramc.i(paramInt, g.this.n("ok", localHashMap));
            Log.i(g.TAG, "hasVoIPChat:%b, now is voip talking", new Object[] { Boolean.valueOf(bool) });
            AppMethodBeat.o(226929);
            return;
          }
          if ((paramAnonymousList == null) || (paramAnonymousList.size() == 0))
          {
            localHashMap.put("join", Boolean.FALSE);
            paramc.i(paramInt, g.this.n("ok", localHashMap));
            Log.i(g.TAG, "ballInfoList is empty, hasVoIPChat false!");
            AppMethodBeat.o(226929);
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
            paramc.i(paramInt, g.this.n("ok", localHashMap));
            AppMethodBeat.o(226929);
            return;
          }
        }
      });
      AppMethodBeat.o(226930);
      return;
    }
    Log.e(TAG, "IFloatBallService is null");
    paramJSONObject = new HashMap();
    paramJSONObject.put("join", Boolean.FALSE);
    paramc.i(paramInt, n("ok", paramJSONObject));
    AppMethodBeat.o(226930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.g
 * JD-Core Version:    0.7.0.1
 */