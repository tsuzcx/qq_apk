package com.tencent.mm.crash;

import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.nativecrash.NativeCrash.CrashCallback;

public final class a
  implements NativeCrash.CrashCallback
{
  private static ParcelFileDescriptor maZ = null;
  private static boolean sInitialized = false;
  
  private a()
  {
    AppMethodBeat.i(248355);
    sInitialized = true;
    NativeCrash.init(new ParcelFileDescriptor[] { maZ }, 1871, 0);
    NativeCrash.resetCustomInfo();
    NativeCrash.customInfo("Client Version: " + BuildInfo.CLIENT_VERSION);
    NativeCrash.customInfo("Base Version: " + com.tencent.mm.loader.i.a.CLIENT_VERSION);
    NativeCrash.crashCallback(this);
    AppMethodBeat.o(248355);
  }
  
  public static a b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(248346);
    if ((maZ != null) && (maZ != paramParcelFileDescriptor))
    {
      paramParcelFileDescriptor = new IllegalArgumentException("Try to change dumpTo fd after first calling instance().");
      AppMethodBeat.o(248346);
      throw paramParcelFileDescriptor;
    }
    maZ = paramParcelFileDescriptor;
    paramParcelFileDescriptor = a.a.mba;
    AppMethodBeat.o(248346);
    return paramParcelFileDescriptor;
  }
  
  public final boolean onCrashDumped(int paramInt, String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.crash.a
 * JD-Core Version:    0.7.0.1
 */