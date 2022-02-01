package com.tencent.mm.n;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/config/AlbumConfigControl;", "", "()V", "KEY_C2C", "", "KEY_SNS", "TAG", "getC2CSelectMaxDuration", "", "getSNSSelectMaxDuration", "plugin-videologic_release"})
public final class a
{
  public static final a jwk;
  
  static
  {
    AppMethodBeat.i(216627);
    jwk = new a();
    AppMethodBeat.o(216627);
  }
  
  public static int awa()
  {
    AppMethodBeat.i(216625);
    Object localObject = ((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("LimitationOnSight");
    Log.i("MicroMsg.AlbumConfigControl", "getC2CSelectMaxDuration getDynamicConfig:".concat(String.valueOf(localObject)));
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject).optJSONObject("kSightLimitationMaxDurationKey");
        if (localObject == null) {
          break label150;
        }
        i = ((JSONObject)localObject).optInt("c2c");
        Log.i("MicroMsg.AlbumConfigControl", "getC2CSelectMaxDuration result:%d", new Object[] { Integer.valueOf(i) });
        if (i <= 15)
        {
          AppMethodBeat.o(216625);
          return 300;
        }
        AppMethodBeat.o(216625);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AlbumConfigControl", "getC2CSelectMaxDuration parse Json error!");
      }
      Log.i("MicroMsg.AlbumConfigControl", "getC2CSelectMaxDuration default result:%d", new Object[] { Integer.valueOf(300) });
      AppMethodBeat.o(216625);
      return 300;
      label150:
      int i = 300;
    }
  }
  
  public static int awb()
  {
    AppMethodBeat.i(216626);
    Object localObject = ((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("LimitationOnSight");
    Log.i("MicroMsg.AlbumConfigControl", "getSNSSelectMaxDuration getDynamicConfig:".concat(String.valueOf(localObject)));
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject).optJSONObject("kSightLimitationMaxDurationKey");
        if (localObject == null) {
          break label150;
        }
        i = ((JSONObject)localObject).optInt("sns");
        Log.i("MicroMsg.AlbumConfigControl", "getSNSSelectMaxDuration result:%d", new Object[] { Integer.valueOf(i) });
        if (i <= 15)
        {
          AppMethodBeat.o(216626);
          return 300;
        }
        AppMethodBeat.o(216626);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AlbumConfigControl", "getSNSSelectMaxDuration parse Json error!");
      }
      Log.i("MicroMsg.AlbumConfigControl", "getSNSSelectMaxDuration default result:%d", new Object[] { Integer.valueOf(300) });
      AppMethodBeat.o(216626);
      return 300;
      label150:
      int i = 300;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.n.a
 * JD-Core Version:    0.7.0.1
 */