package com.tencent.mm.plugin.appbrand.game.g;

import android.annotation.SuppressLint;
import com.hilive.mediasdk.MediaSdk;
import com.hilive.mediasdk.MediaSdk.MediaCallbacker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$7
  implements Runnable
{
  public b$7(b paramb, JSONObject paramJSONObject, d paramd) {}
  
  @SuppressLint({"DefaultLocale"})
  public final void run()
  {
    AppMethodBeat.i(45332);
    try
    {
      Log.i("MicroMsg.GameRecorderMgr", "hy: trigger editorRemoveTrack " + this.opT.toString());
      b.i(this.opS).editorDelTrack(this.opT.toString().getBytes(), new MediaSdk.MediaCallbacker()
      {
        public final void onResult(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(174736);
          try
          {
            paramAnonymousArrayOfByte = new JSONObject(new String(paramAnonymousArrayOfByte));
            int i = paramAnonymousArrayOfByte.optInt("errCode", 601);
            if (i == 0)
            {
              b.7.this.opI.a(0, 0, "ok", paramAnonymousArrayOfByte);
              AppMethodBeat.o(174736);
              return;
            }
            b.7.this.opI.a(1, i, String.format("editorRemoveTrack failed!: errCode: %d", new Object[] { Integer.valueOf(i) }), paramAnonymousArrayOfByte);
            AppMethodBeat.o(174736);
            return;
          }
          catch (JSONException paramAnonymousArrayOfByte)
          {
            b.7.this.opI.a(1, -1, "editorRemoveTrack error: " + paramAnonymousArrayOfByte.getMessage(), null);
            AppMethodBeat.o(174736);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            b.7.this.opI.a(1, -1, "editorRemoveTrack error: " + paramAnonymousArrayOfByte.getMessage(), null);
            AppMethodBeat.o(174736);
          }
        }
      });
      AppMethodBeat.o(45332);
      return;
    }
    catch (Exception localException)
    {
      this.opI.a(1, -1, "editorRemoveTrack error: " + localException.getMessage(), null);
      AppMethodBeat.o(45332);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.7
 * JD-Core Version:    0.7.0.1
 */