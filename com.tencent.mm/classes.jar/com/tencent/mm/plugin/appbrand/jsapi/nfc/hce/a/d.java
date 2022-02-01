package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class d
{
  private static boolean bmw()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  @TargetApi(21)
  public static boolean bmx()
  {
    AppMethodBeat.i(136185);
    if (bmw())
    {
      boolean bool = ak.getContext().getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
      AppMethodBeat.o(136185);
      return bool;
    }
    AppMethodBeat.o(136185);
    return false;
  }
  
  public static boolean bmy()
  {
    AppMethodBeat.i(136186);
    Context localContext = ak.getContext();
    if (!localContext.getPackageManager().hasSystemFeature("android.hardware.nfc"))
    {
      AppMethodBeat.o(136186);
      return false;
    }
    if (NfcAdapter.getDefaultAdapter(localContext) == null)
    {
      AppMethodBeat.o(136186);
      return false;
    }
    AppMethodBeat.o(136186);
    return true;
  }
  
  public static boolean bmz()
  {
    AppMethodBeat.i(136187);
    NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(ak.getContext());
    if (localNfcAdapter == null)
    {
      ae.i("MicroMsg.HceUtils", "alvinluo no nfc chip !");
      AppMethodBeat.o(136187);
      return false;
    }
    if (!localNfcAdapter.isEnabled())
    {
      AppMethodBeat.o(136187);
      return false;
    }
    AppMethodBeat.o(136187);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d
 * JD-Core Version:    0.7.0.1
 */