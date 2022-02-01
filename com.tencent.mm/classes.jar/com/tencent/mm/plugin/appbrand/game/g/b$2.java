package com.tencent.mm.plugin.appbrand.game.g;

import com.hilive.mediasdk.MediaSdk;
import com.hilive.mediasdk.MediaSdk.MediaCallbacker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

final class b$2
  implements Runnable
{
  b$2(b paramb, JSONObject paramJSONObject, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(45322);
    try
    {
      Log.i("MicroMsg.GameRecorderMgr", "hy: trigger remux " + this.opT.toString());
      b.i(this.opS).remux(this.opT.toString().getBytes(), new MediaSdk.MediaCallbacker()
      {
        public final void onResult(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(174731);
          try
          {
            paramAnonymousArrayOfByte = new JSONObject(new String(paramAnonymousArrayOfByte));
            int i = paramAnonymousArrayOfByte.optInt("errCode", 601);
            if (i == 0)
            {
              b.2.this.opI.a(0, 0, "ok", paramAnonymousArrayOfByte);
              AppMethodBeat.o(174731);
              return;
            }
            b.2.this.opI.a(1, i, String.format("remux failed!: errCode: %d", new Object[] { Integer.valueOf(i) }), paramAnonymousArrayOfByte);
            AppMethodBeat.o(174731);
            return;
          }
          catch (JSONException paramAnonymousArrayOfByte)
          {
            b.2.this.opI.a(1, -1, "remux error: " + paramAnonymousArrayOfByte.getMessage(), new JSONObject());
            AppMethodBeat.o(174731);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            b.2.this.opI.a(1, -1, "remux error: " + paramAnonymousArrayOfByte.getMessage(), new JSONObject());
            AppMethodBeat.o(174731);
          }
        }
      });
      AppMethodBeat.o(45322);
      return;
    }
    catch (Exception localException)
    {
      this.opI.a(1, -1, "remux error: " + localException.getMessage(), new JSONObject());
      AppMethodBeat.o(45322);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.2
 * JD-Core Version:    0.7.0.1
 */