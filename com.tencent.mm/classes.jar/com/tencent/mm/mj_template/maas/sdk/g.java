package com.tencent.mm.mj_template.maas.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/sdk/MaasSdkResRecord;", "", "()V", "KEY_RES_UPDATE_TIME", "", "KEY_SDK_COMPAT_VERSION", "KEY_SDK_LOAD_END", "KEY_SDK_LOAD_START", "KEY_SDK_RES_VERSION", "KEY_SDK_SHA1", "KEY_SDK_UPDATE_TIME", "kvName", "getCompatVersion", "", "getKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getLoadEnd", "getLoadStart", "getResUpdate", "", "getSdkResVersion", "getSdkSha1", "getSdkUpdate", "hasResUpdate", "", "loadFailCount", "onLoadEnd", "", "onLoadStart", "onResUpdate", "onSdkUpdate", "setCompatVersion", "version", "setSdkResVersion", "resVersion", "setSdkSha1", "sha1", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g obV;
  
  static
  {
    AppMethodBeat.i(240140);
    obV = new g();
    AppMethodBeat.o(240140);
  }
  
  public static int bxM()
  {
    AppMethodBeat.i(240120);
    int i = bxX().getInt("KEY_SDK_COMPAT_VERSION", 0);
    AppMethodBeat.o(240120);
    return i;
  }
  
  public static MultiProcessMMKV bxX()
  {
    AppMethodBeat.i(240076);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("maas_sdk");
    s.s(localMultiProcessMMKV, "getMMKV(kvName)");
    AppMethodBeat.o(240076);
    return localMultiProcessMMKV;
  }
  
  public static boolean bxY()
  {
    AppMethodBeat.i(240090);
    if (bxX().getLong("KEY_SDK_UPDATE_TIME", 0L) < bxX().getLong("KEY_RES_UPDATE_TIME", 0L))
    {
      AppMethodBeat.o(240090);
      return true;
    }
    AppMethodBeat.o(240090);
    return false;
  }
  
  public static int bxZ()
  {
    AppMethodBeat.i(240101);
    int i = bxX().getInt("KEY_SDK_LOAD_START", 0);
    AppMethodBeat.o(240101);
    return i;
  }
  
  public static int bya()
  {
    AppMethodBeat.i(240112);
    int i = bxX().getInt("KEY_SDK_LOAD_END", 0);
    AppMethodBeat.o(240112);
    return i;
  }
  
  public static String byb()
  {
    AppMethodBeat.i(240127);
    String str = bxX().getString("KEY_SDK_SHA1", "");
    if (str == null)
    {
      AppMethodBeat.o(240127);
      return "";
    }
    AppMethodBeat.o(240127);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.sdk.g
 * JD-Core Version:    0.7.0.1
 */