package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/NonStandardAppConstants;", "", "()V", "APPID_2_SCENE", "Ljava/util/concurrent/ConcurrentHashMap;", "", "kotlin.jvm.PlatformType", "", "APPID_2_USERNAME", "getAPPID_2_USERNAME", "()Ljava/util/concurrent/ConcurrentHashMap;", "APPID_ARRAY", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getAPPID_ARRAY", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "TAG", "register", "", "username", "appId", "scene", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final w raK;
  private static final CopyOnWriteArrayList<String> raL;
  private static final ConcurrentHashMap<String, String> raM;
  public static final ConcurrentHashMap<String, Integer> raN;
  
  static
  {
    AppMethodBeat.i(323373);
    raK = new w();
    raL = new CopyOnWriteArrayList((Collection)p.al(new String[] { "wxfedb0854e2b1820d", "wx97b7aebac2183fd2", "wxa06c02b5c00ff39b", "wxf337cbaa27790d8e" }));
    raM = new ConcurrentHashMap(ak.f(new r[] { v.Y("wxfedb0854e2b1820d", "gh_a23053671f48@app"), v.Y("wx97b7aebac2183fd2", "gh_232f4c80080c@app"), v.Y("wxa06c02b5c00ff39b", "gh_f93dfd4799d3@app"), v.Y("wxf337cbaa27790d8e", "gh_c9d570035c3b@app") }));
    raN = new ConcurrentHashMap(ak.f(new r[] { v.Y("wxfedb0854e2b1820d", Integer.valueOf(998)), v.Y("wx97b7aebac2183fd2", Integer.valueOf(998)), v.Y("wxa06c02b5c00ff39b", Integer.valueOf(998)), v.Y("wxf337cbaa27790d8e", Integer.valueOf(998)) }));
    AppMethodBeat.o(323373);
  }
  
  public static void G(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(323371);
    s.u(paramString1, "username");
    s.u(paramString2, "appId");
    Log.i("MicroMsg.AppBrand.NonStandardAppConstants", "register, username:" + paramString1 + ", appId:" + paramString2 + ", scene:" + paramInt);
    raL.add(paramString2);
    ((Map)raM).put(paramString2, paramString1);
    ((Map)raN).put(paramString2, Integer.valueOf(paramInt));
    AppMethodBeat.o(323371);
  }
  
  public static CopyOnWriteArrayList<String> ckS()
  {
    return raL;
  }
  
  public static ConcurrentHashMap<String, String> ckT()
  {
    return raM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.w
 * JD-Core Version:    0.7.0.1
 */