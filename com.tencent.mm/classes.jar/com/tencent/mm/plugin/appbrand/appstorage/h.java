package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.appbrand.appstorage.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageScheme;", "", "()V", "TAG", "", "getStorageScheme", "", "appId", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h qMa;
  
  static
  {
    AppMethodBeat.i(323135);
    qMa = new h();
    AppMethodBeat.o(323135);
  }
  
  public static int VZ(String paramString)
  {
    AppMethodBeat.i(323130);
    s.u(paramString, "appId");
    long l = new p(((a)com.tencent.mm.kernel.h.ax(a.class)).WE(paramString)).longValue();
    Object localObject = k.qMi;
    int i;
    if (k.u(l, paramString))
    {
      localObject = k.qMi;
      if (k.s(l, paramString)) {
        i = 5;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandKVStorageScheme", s.X("getStorageScheme:", Integer.valueOf(i)));
      AppMethodBeat.o(323130);
      return i;
      i = 4;
      continue;
      localObject = MMApplicationContext.getDefaultPreference();
      i.a locala = i.uxx;
      locala = i.uxx;
      if (((SharedPreferences)localObject).getBoolean(i.a.b(i.cOM(), l, paramString), false))
      {
        i = 2;
      }
      else
      {
        locala = i.uxx;
        locala = i.uxx;
        if ((((SharedPreferences)localObject).getBoolean(i.a.b(i.cic(), l, paramString), false)) && (!j.qMg.chS())) {
          i = 3;
        } else {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.h
 * JD-Core Version:    0.7.0.1
 */