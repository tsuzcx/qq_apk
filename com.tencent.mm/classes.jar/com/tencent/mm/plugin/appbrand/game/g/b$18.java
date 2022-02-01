package com.tencent.mm.plugin.appbrand.game.g;

import com.hilive.mediasdk.MediaSdk;
import com.hilive.mediasdk.MediaSdk.MediaCallbacker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

final class b$18
  implements Runnable
{
  b$18(b paramb, String paramString, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(45358);
    try
    {
      Log.i("MicroMsg.GameRecorderMgr", "hy: requestAnalyze %s", new Object[] { this.val$filePath });
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("filePath", this.val$filePath);
      b.i(this.opS).analysis(localJSONObject.toString().getBytes(), new MediaSdk.MediaCallbacker()
      {
        public final void onResult(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(274781);
          try
          {
            paramAnonymousArrayOfByte = new JSONObject(new String(paramAnonymousArrayOfByte));
            b.a locala = new b.a(b.18.this.opS);
            locala.duration = paramAnonymousArrayOfByte.optLong("duration", 0L);
            locala.fileSize = paramAnonymousArrayOfByte.optLong("size", 0L);
            Log.i("MicroMsg.GameRecorderMgr", "hy: duration is %d, size is %d", new Object[] { Long.valueOf(locala.duration), Long.valueOf(locala.fileSize) });
            b.18.this.opI.a(0, 0, "ok", locala);
            AppMethodBeat.o(274781);
            return;
          }
          catch (JSONException paramAnonymousArrayOfByte)
          {
            b.18.this.opI.a(1, -1, "analysis error: " + paramAnonymousArrayOfByte.getMessage(), null);
            AppMethodBeat.o(274781);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            b.18.this.opI.a(1, -1, "analysis error: " + paramAnonymousArrayOfByte.getMessage(), null);
            AppMethodBeat.o(274781);
          }
        }
      });
      AppMethodBeat.o(45358);
      return;
    }
    catch (JSONException localJSONException)
    {
      this.opI.a(1, -1, "analysis error: " + localJSONException.getMessage(), null);
      AppMethodBeat.o(45358);
      return;
    }
    catch (Exception localException)
    {
      this.opI.a(1, -1, "analysis error: " + localException.getMessage(), null);
      AppMethodBeat.o(45358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.18
 * JD-Core Version:    0.7.0.1
 */