package com.tencent.mm.k;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/config/AlbumConfigControl;", "", "()V", "KEY_C2C", "", "KEY_SNS", "TAG", "getC2CSelectMaxDuration", "", "getFinderAlbumSelectMaxDuration", "getSNSSelectMaxDuration", "getSNSSelectMaxDurationMs", "getSNSSelectMaxDurationMsFromServer", "plugin-videologic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a lZC;
  
  static
  {
    AppMethodBeat.i(231788);
    lZC = new a();
    AppMethodBeat.o(231788);
  }
  
  public static int aQA()
  {
    AppMethodBeat.i(231786);
    int i = ((c)h.ax(c.class)).a(c.a.zaG, 1801);
    Object localObject1 = ((c)h.ax(c.class)).a(c.a.zaH, "");
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(231786);
      return i;
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      int j = ((JSONObject)localObject1).getInt("apiLevel");
      double d = ((JSONObject)localObject1).getDouble("durationMultiplier");
      int k = Build.VERSION.SDK_INT;
      if ((d >= 0.0D) && (k <= j))
      {
        j = (int)(d * i);
        return j;
      }
    }
    finally
    {
      AppMethodBeat.o(231786);
    }
    return i;
  }
  
  public static int aQy()
  {
    AppMethodBeat.i(231781);
    Object localObject = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("LimitationOnSight");
    Log.i("MicroMsg.AlbumConfigControl", s.X("getC2CSelectMaxDuration getDynamicConfig:", localObject));
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new JSONObject((String)localObject).optJSONObject("kSightLimitationMaxDurationKey");
        if (localObject == null) {}
        for (int i = 300;; i = ((JSONObject)localObject).optInt("c2c"))
        {
          Log.i("MicroMsg.AlbumConfigControl", "getC2CSelectMaxDuration result:%d", new Object[] { Integer.valueOf(i) });
          if (i > 15) {
            break;
          }
          AppMethodBeat.o(231781);
          return 300;
        }
        AppMethodBeat.o(231781);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AlbumConfigControl", "getC2CSelectMaxDuration parse Json error!");
      }
    }
    Log.i("MicroMsg.AlbumConfigControl", "getC2CSelectMaxDuration default result:%d", new Object[] { Integer.valueOf(300) });
    AppMethodBeat.o(231781);
    return 300;
  }
  
  public static int aQz()
  {
    AppMethodBeat.i(231784);
    Object localObject = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("LimitationOnSight");
    Log.i("MicroMsg.AlbumConfigControl", s.X("getSNSSelectMaxDuration getDynamicConfig:", localObject));
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new JSONObject((String)localObject).optJSONObject("kSightLimitationMaxDurationKey");
        if (localObject == null) {}
        for (int i = 300;; i = ((JSONObject)localObject).optInt("sns"))
        {
          Log.i("MicroMsg.AlbumConfigControl", "getSNSSelectMaxDuration result:%d", new Object[] { Integer.valueOf(i) });
          if (i > 15) {
            break;
          }
          AppMethodBeat.o(231784);
          return 300;
        }
        AppMethodBeat.o(231784);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AlbumConfigControl", "getSNSSelectMaxDuration parse Json error!");
      }
    }
    Log.i("MicroMsg.AlbumConfigControl", "getSNSSelectMaxDuration default result:%d", new Object[] { Integer.valueOf(300) });
    AppMethodBeat.o(231784);
    return 300;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.k.a
 * JD-Core Version:    0.7.0.1
 */