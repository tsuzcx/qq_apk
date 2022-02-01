package com.tencent.mm.plugin.appbrand.game.g;

import android.annotation.SuppressLint;
import com.hilive.mediasdk.MediaSdk;
import com.hilive.mediasdk.MediaSdk.MediaCallbacker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$4
  implements Runnable
{
  public b$4(b paramb, JSONObject paramJSONObject, d paramd) {}
  
  @SuppressLint({"DefaultLocale"})
  public final void run()
  {
    AppMethodBeat.i(45326);
    try
    {
      Log.i("MicroMsg.GameRecorderMgr", "hy: trigger editorGetTrack " + this.opT.toString());
      b.i(this.opS).editorGetTrack(this.opT.toString().getBytes(), new MediaSdk.MediaCallbacker()
      {
        public final void onResult(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(174733);
          try
          {
            paramAnonymousArrayOfByte = new JSONObject(new String(paramAnonymousArrayOfByte));
            int i = paramAnonymousArrayOfByte.optInt("errCode", 601);
            if (i == 0)
            {
              b.4.this.opI.a(0, 0, "ok", paramAnonymousArrayOfByte);
              AppMethodBeat.o(174733);
              return;
            }
            b.4.this.opI.a(1, i, String.format("editorGetTrack failed!: errCode: %d", new Object[] { Integer.valueOf(i) }), paramAnonymousArrayOfByte);
            AppMethodBeat.o(174733);
            return;
          }
          catch (JSONException paramAnonymousArrayOfByte)
          {
            b.4.this.opI.a(1, -1, "editorGetTrack error: " + paramAnonymousArrayOfByte.getMessage(), null);
            AppMethodBeat.o(174733);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            b.4.this.opI.a(1, -1, "editorGetTrack error: " + paramAnonymousArrayOfByte.getMessage(), null);
            AppMethodBeat.o(174733);
          }
        }
      });
      AppMethodBeat.o(45326);
      return;
    }
    catch (Exception localException)
    {
      this.opI.a(1, -1, "editorGetTrack error: " + localException.getMessage(), null);
      AppMethodBeat.o(45326);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.4
 * JD-Core Version:    0.7.0.1
 */