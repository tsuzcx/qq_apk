package com.tencent.mm.plugin.appbrand.game.g;

import android.annotation.SuppressLint;
import com.hilive.mediasdk.MediaSdk;
import com.hilive.mediasdk.MediaSdk.MediaCallbacker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$5
  implements Runnable
{
  public b$5(b paramb, JSONObject paramJSONObject, d paramd) {}
  
  @SuppressLint({"DefaultLocale"})
  public final void run()
  {
    AppMethodBeat.i(45328);
    try
    {
      Log.i("MicroMsg.GameRecorderMgr", "hy: trigger editorCreateTrack " + this.opT.toString());
      b.i(this.opS).editorAddTrack(this.opT.toString().getBytes(), new MediaSdk.MediaCallbacker()
      {
        public final void onResult(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(174734);
          try
          {
            paramAnonymousArrayOfByte = new JSONObject(new String(paramAnonymousArrayOfByte));
            int i = paramAnonymousArrayOfByte.optInt("errCode", 601);
            if (i == 0)
            {
              b.5.this.opI.a(0, 0, "ok", paramAnonymousArrayOfByte);
              AppMethodBeat.o(174734);
              return;
            }
            b.5.this.opI.a(1, i, String.format("editorCreateTrack failed!: errCode: %d", new Object[] { Integer.valueOf(i) }), paramAnonymousArrayOfByte);
            AppMethodBeat.o(174734);
            return;
          }
          catch (JSONException paramAnonymousArrayOfByte)
          {
            b.5.this.opI.a(1, -1, "editorCreateTrack error: " + paramAnonymousArrayOfByte.getMessage(), null);
            AppMethodBeat.o(174734);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            b.5.this.opI.a(1, -1, "editorCreateTrack error: " + paramAnonymousArrayOfByte.getMessage(), null);
            AppMethodBeat.o(174734);
          }
        }
      });
      AppMethodBeat.o(45328);
      return;
    }
    catch (Exception localException)
    {
      this.opI.a(1, -1, "editorCreateTrack error: " + localException.getMessage(), null);
      AppMethodBeat.o(45328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.5
 * JD-Core Version:    0.7.0.1
 */