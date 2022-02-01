package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ee;
import com.tencent.mm.autogen.a.ee.a;
import com.tencent.mm.autogen.a.jz;
import com.tencent.mm.model.bi;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.Executor;
import org.json.JSONObject;

class FlutterEmotionLogic$2
  extends IListener<ee>
{
  private boolean a(ee paramee)
  {
    AppMethodBeat.i(269879);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ProductID", paramee.hDW.productId);
      localJSONObject.put("Progress", paramee.hDW.progress);
      localJSONObject.put("Status", paramee.hDW.status);
      localJSONObject.put("CDNClientID", paramee.hDW.hDX);
      label69:
      paramee = new jz();
      paramee.hLC.hLD = true;
      paramee.hLC.hLE = new bi("onEmotionDownloadCallback", localJSONObject.toString());
      paramee.asyncPublish(new Executor()
      {
        public final void execute(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(269852);
          h.ahAA.bm(paramAnonymousRunnable);
          AppMethodBeat.o(269852);
        }
      });
      AppMethodBeat.o(269879);
      return false;
    }
    catch (Exception paramee)
    {
      break label69;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.FlutterEmotionLogic.2
 * JD-Core Version:    0.7.0.1
 */