package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/NonStandardAppConstants;", "", "()V", "APPID_2_SCENE", "", "", "", "APPID_2_USERNAME", "getAPPID_2_USERNAME", "()Ljava/util/Map;", "APPID_ARRAY", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAPPID_ARRAY", "()Ljava/util/ArrayList;", "TAG", "register", "", "username", "appId", "scene", "api-protocol_release"})
public final class t
{
  private static final ArrayList<String> lfI;
  private static final Map<String, String> lfJ;
  public static final Map<String, Integer> lfK;
  public static final t lfL;
  
  static
  {
    AppMethodBeat.i(194322);
    lfL = new t();
    lfI = j.ac(new String[] { "wxfedb0854e2b1820d", "wx97b7aebac2183fd2", "wxa06c02b5c00ff39b", "wxf337cbaa27790d8e" });
    lfJ = ae.f(new o[] { s.U("wxfedb0854e2b1820d", "gh_a23053671f48@app"), s.U("wx97b7aebac2183fd2", "gh_232f4c80080c@app"), s.U("wxa06c02b5c00ff39b", "gh_f93dfd4799d3@app"), s.U("wxf337cbaa27790d8e", "gh_c9d570035c3b@app") });
    lfK = ae.f(new o[] { s.U("wxfedb0854e2b1820d", Integer.valueOf(998)), s.U("wx97b7aebac2183fd2", Integer.valueOf(998)), s.U("wxa06c02b5c00ff39b", Integer.valueOf(998)), s.U("wxf337cbaa27790d8e", Integer.valueOf(998)) });
    AppMethodBeat.o(194322);
  }
  
  public static ArrayList<String> bAf()
  {
    return lfI;
  }
  
  public static Map<String, String> bAg()
  {
    return lfJ;
  }
  
  public static void x(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(194321);
    p.h(paramString1, "username");
    p.h(paramString2, "appId");
    Log.i("MicroMsg.AppBrand.NonStandardAppConstants", "register, username:" + paramString1 + ", appId:" + paramString2 + ", scene:" + paramInt);
    lfI.add(paramString2);
    lfJ.put(paramString2, paramString1);
    lfK.put(paramString2, Integer.valueOf(paramInt));
    AppMethodBeat.o(194321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.t
 * JD-Core Version:    0.7.0.1
 */