package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransferConfig;", "", "()V", "KEY_HAD_CLEAN_NO_ENCRYPT_MMKV_DATA", "", "KEY_HAD_FINISH_TRANSFER_TO_ENCRYPT_MMKV", "KEY_HAD_TRANSFER_TO_ENCRYPT_MMKV", "clearHadTransferToEncryptMMKV", "", "uin", "", "appId", "hadFinishTransferToEncryptMMKV", "", "hadHadCleanNoEncryptMMKVData", "hadTransferToEncryptMMKV", "markHadCleanNoEncryptMMKVData", "markHadFinishTransferToEncryptMMKV", "markHadTransferToEncryptMMKV", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k qMi;
  
  static
  {
    AppMethodBeat.i(323153);
    qMi = new k();
    AppMethodBeat.o(323153);
  }
  
  public static void o(long paramLong, String paramString)
  {
    AppMethodBeat.i(323128);
    s.u(paramString, "appId");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getDefault();
    a.a locala = a.qLF;
    localMultiProcessMMKV.putBoolean(a.a.b("keyHadFinishTransferToEncryptMMKV", paramLong, paramString), true).apply();
    AppMethodBeat.o(323128);
  }
  
  public static void p(long paramLong, String paramString)
  {
    AppMethodBeat.i(323136);
    s.u(paramString, "appId");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getDefault();
    a.a locala = a.qLF;
    localMultiProcessMMKV.putBoolean(a.a.b("hadTransferToEncryptMMKV", paramLong, paramString), true).apply();
    AppMethodBeat.o(323136);
  }
  
  public static void q(long paramLong, String paramString)
  {
    AppMethodBeat.i(323139);
    s.u(paramString, "appId");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getDefault();
    a.a locala = a.qLF;
    localMultiProcessMMKV.putBoolean(a.a.b("hadTransferToEncryptMMKV", paramLong, paramString), false).apply();
    AppMethodBeat.o(323139);
  }
  
  public static void r(long paramLong, String paramString)
  {
    AppMethodBeat.i(323143);
    s.u(paramString, "appId");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getDefault();
    a.a locala = a.qLF;
    localMultiProcessMMKV.putBoolean(a.a.b("keyHadCleanNoEncryptMMKVData", paramLong, paramString), true).apply();
    AppMethodBeat.o(323143);
  }
  
  public static boolean s(long paramLong, String paramString)
  {
    AppMethodBeat.i(323145);
    s.u(paramString, "appId");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getDefault();
    a.a locala = a.qLF;
    boolean bool = localMultiProcessMMKV.getBoolean(a.a.b("keyHadFinishTransferToEncryptMMKV", paramLong, paramString), false);
    AppMethodBeat.o(323145);
    return bool;
  }
  
  public static boolean t(long paramLong, String paramString)
  {
    AppMethodBeat.i(323148);
    s.u(paramString, "appId");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getDefault();
    a.a locala = a.qLF;
    boolean bool = localMultiProcessMMKV.getBoolean(a.a.b("keyHadCleanNoEncryptMMKVData", paramLong, paramString), false);
    AppMethodBeat.o(323148);
    return bool;
  }
  
  public static boolean u(long paramLong, String paramString)
  {
    AppMethodBeat.i(323150);
    s.u(paramString, "appId");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getDefault();
    a.a locala = a.qLF;
    boolean bool = localMultiProcessMMKV.getBoolean(a.a.b("hadTransferToEncryptMMKV", paramLong, paramString), false);
    AppMethodBeat.o(323150);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.k
 * JD-Core Version:    0.7.0.1
 */