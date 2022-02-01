package com.tencent.mm.plugin.appbrand.game.g;

import com.hilive.mediasdk.MediaSdk;
import com.hilive.mediasdk.MediaSdk.MediaCallbacker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$3
  implements Runnable
{
  public b$3(b paramb, JSONObject paramJSONObject, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(45324);
    try
    {
      Log.i("MicroMsg.GameRecorderMgr", "hy: trigger editorCreate " + this.opT.toString());
      b.i(this.opS).editorCreate(this.opT.toString().getBytes(), new MediaSdk.MediaCallbacker()
      {
        public final void onResult(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(174732);
          try
          {
            paramAnonymousArrayOfByte = new JSONObject(new String(paramAnonymousArrayOfByte));
            int i = paramAnonymousArrayOfByte.optInt("errCode", 601);
            if (i == 0)
            {
              b.3.this.opI.a(0, 0, "ok", paramAnonymousArrayOfByte);
              AppMethodBeat.o(174732);
              return;
            }
            b.3.this.opI.a(1, i, String.format("editorCreate failed!: errCode: %d", new Object[] { Integer.valueOf(i) }), paramAnonymousArrayOfByte);
            AppMethodBeat.o(174732);
            return;
          }
          catch (JSONException paramAnonymousArrayOfByte)
          {
            b.3.this.opI.a(1, -1, "editorCreate error: " + paramAnonymousArrayOfByte.getMessage(), null);
            AppMethodBeat.o(174732);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            b.3.this.opI.a(1, -1, "editorCreate error: " + paramAnonymousArrayOfByte.getMessage(), null);
            AppMethodBeat.o(174732);
          }
        }
      });
      AppMethodBeat.o(45324);
      return;
    }
    catch (Exception localException)
    {
      this.opI.a(1, -1, "editorCreate error: " + localException.getMessage(), null);
      AppMethodBeat.o(45324);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.3
 * JD-Core Version:    0.7.0.1
 */