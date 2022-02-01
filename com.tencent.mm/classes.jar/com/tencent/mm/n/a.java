package com.tencent.mm.n;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/config/AlbumConfigControl;", "", "()V", "KEY_C2C", "", "KEY_SNS", "TAG", "getC2CSelectMaxDuration", "", "getSNSSelectMaxDuration", "plugin-videologic_release"})
public final class a
{
  public static final a gLV;
  
  static
  {
    AppMethodBeat.i(240897);
    gLV = new a();
    AppMethodBeat.o(240897);
  }
  
  public static int apH()
  {
    AppMethodBeat.i(240895);
    Object localObject = ((com.tencent.mm.plugin.zero.b.a)g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("LimitationOnSight");
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
          AppMethodBeat.o(240895);
          return 300;
        }
        AppMethodBeat.o(240895);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AlbumConfigControl", "getC2CSelectMaxDuration parse Json error!");
      }
      Log.i("MicroMsg.AlbumConfigControl", "getC2CSelectMaxDuration default result:%d", new Object[] { Integer.valueOf(300) });
      AppMethodBeat.o(240895);
      return 300;
      label150:
      int i = 300;
    }
  }
  
  public static int apI()
  {
    AppMethodBeat.i(240896);
    Object localObject = ((com.tencent.mm.plugin.zero.b.a)g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("LimitationOnSight");
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
          AppMethodBeat.o(240896);
          return 300;
        }
        AppMethodBeat.o(240896);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AlbumConfigControl", "getSNSSelectMaxDuration parse Json error!");
      }
      Log.i("MicroMsg.AlbumConfigControl", "getSNSSelectMaxDuration default result:%d", new Object[] { Integer.valueOf(300) });
      AppMethodBeat.o(240896);
      return 300;
      label150:
      int i = 300;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.n.a
 * JD-Core Version:    0.7.0.1
 */