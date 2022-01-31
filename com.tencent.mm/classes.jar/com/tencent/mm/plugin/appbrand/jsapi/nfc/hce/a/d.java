package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class d
{
  private static boolean aEj()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  @TargetApi(21)
  public static boolean aEk()
  {
    AppMethodBeat.i(137936);
    if (aEj())
    {
      boolean bool = ah.getContext().getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
      AppMethodBeat.o(137936);
      return bool;
    }
    AppMethodBeat.o(137936);
    return false;
  }
  
  public static boolean aEl()
  {
    AppMethodBeat.i(137937);
    Context localContext = ah.getContext();
    if (!localContext.getPackageManager().hasSystemFeature("android.hardware.nfc"))
    {
      AppMethodBeat.o(137937);
      return false;
    }
    if (NfcAdapter.getDefaultAdapter(localContext) == null)
    {
      AppMethodBeat.o(137937);
      return false;
    }
    AppMethodBeat.o(137937);
    return true;
  }
  
  public static boolean aEm()
  {
    AppMethodBeat.i(137938);
    NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(ah.getContext());
    if (localNfcAdapter == null)
    {
      ab.i("MicroMsg.HceUtils", "alvinluo no nfc chip !");
      AppMethodBeat.o(137938);
      return false;
    }
    if (!localNfcAdapter.isEnabled())
    {
      AppMethodBeat.o(137938);
      return false;
    }
    AppMethodBeat.o(137938);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d
 * JD-Core Version:    0.7.0.1
 */