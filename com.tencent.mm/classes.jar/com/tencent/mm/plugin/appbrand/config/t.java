package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/NonStandardAppConstants;", "", "()V", "APPID_2_SCENE", "Ljava/util/concurrent/ConcurrentHashMap;", "", "kotlin.jvm.PlatformType", "", "APPID_2_USERNAME", "getAPPID_2_USERNAME", "()Ljava/util/concurrent/ConcurrentHashMap;", "APPID_ARRAY", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getAPPID_ARRAY", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "TAG", "register", "", "username", "appId", "scene", "api-protocol_release"})
public final class t
{
  private static final CopyOnWriteArrayList<String> oah;
  private static final ConcurrentHashMap<String, String> oai;
  public static final ConcurrentHashMap<String, Integer> oaj;
  public static final t oak;
  
  static
  {
    AppMethodBeat.i(192259);
    oak = new t();
    oah = new CopyOnWriteArrayList((Collection)j.ag(new String[] { "wxfedb0854e2b1820d", "wx97b7aebac2183fd2", "wxa06c02b5c00ff39b", "wxf337cbaa27790d8e" }));
    oai = new ConcurrentHashMap(ae.f(new o[] { s.M("wxfedb0854e2b1820d", "gh_a23053671f48@app"), s.M("wx97b7aebac2183fd2", "gh_232f4c80080c@app"), s.M("wxa06c02b5c00ff39b", "gh_f93dfd4799d3@app"), s.M("wxf337cbaa27790d8e", "gh_c9d570035c3b@app") }));
    oaj = new ConcurrentHashMap(ae.f(new o[] { s.M("wxfedb0854e2b1820d", Integer.valueOf(998)), s.M("wx97b7aebac2183fd2", Integer.valueOf(998)), s.M("wxa06c02b5c00ff39b", Integer.valueOf(998)), s.M("wxf337cbaa27790d8e", Integer.valueOf(998)) }));
    AppMethodBeat.o(192259);
  }
  
  public static void A(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(192243);
    p.k(paramString1, "username");
    p.k(paramString2, "appId");
    Log.i("MicroMsg.AppBrand.NonStandardAppConstants", "register, username:" + paramString1 + ", appId:" + paramString2 + ", scene:" + paramInt);
    oah.add(paramString2);
    ((Map)oai).put(paramString2, paramString1);
    ((Map)oaj).put(paramString2, Integer.valueOf(paramInt));
    AppMethodBeat.o(192243);
  }
  
  public static CopyOnWriteArrayList<String> bLv()
  {
    return oah;
  }
  
  public static ConcurrentHashMap<String, String> bLw()
  {
    return oai;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.t
 * JD-Core Version:    0.7.0.1
 */