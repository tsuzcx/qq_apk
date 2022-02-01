package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p;
import com.tencent.mm.sdk.platformtools.ae;
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
  
  final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(222621);
    ae.i(TAG, "hasJoinVoIPChat");
    paramJSONObject = (com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class);
    if (paramJSONObject != null)
    {
      paramJSONObject.a(new com.tencent.mm.plugin.ball.c.i()
      {
        public final void bq(List<BallInfo> paramAnonymousList)
        {
          AppMethodBeat.i(222620);
          HashMap localHashMap = new HashMap();
          boolean bool = p.pdY.pey;
          if (bool)
          {
            localHashMap.put("join", Boolean.TRUE);
            paramc.h(paramInt, g.this.n("ok", localHashMap));
            ae.i(g.TAG, "hasVoIPChat:%b, now is voip talking", new Object[] { Boolean.valueOf(bool) });
            AppMethodBeat.o(222620);
            return;
          }
          if ((paramAnonymousList == null) || (paramAnonymousList.size() == 0))
          {
            localHashMap.put("join", Boolean.FALSE);
            paramc.h(paramInt, g.this.n("ok", localHashMap));
            ae.i(g.TAG, "ballInfoList is empty, hasVoIPChat false!");
            AppMethodBeat.o(222620);
            return;
          }
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            BallInfo localBallInfo = (BallInfo)paramAnonymousList.next();
            if ((localBallInfo.type == 17) || (localBallInfo.type == 19))
            {
              ae.i(g.TAG, "has appbrand doing voip");
              bool = true;
            }
          }
          for (;;)
          {
            ae.i(g.TAG, "hasVoIPChat:%b", new Object[] { Boolean.valueOf(bool) });
            localHashMap.put("join", Boolean.valueOf(bool));
            paramc.h(paramInt, g.this.n("ok", localHashMap));
            AppMethodBeat.o(222620);
            return;
          }
        }
      });
      AppMethodBeat.o(222621);
      return;
    }
    ae.e(TAG, "IFloatBallService is null");
    paramJSONObject = new HashMap();
    paramJSONObject.put("join", Boolean.FALSE);
    paramc.h(paramInt, n("ok", paramJSONObject));
    AppMethodBeat.o(222621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.g
 * JD-Core Version:    0.7.0.1
 */