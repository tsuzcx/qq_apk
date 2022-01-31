package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  @TargetApi(21)
  public static boolean ajL()
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 21) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bool = ae.getContext().getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
      }
      return bool;
    }
  }
  
  public static boolean ajM()
  {
    Context localContext = ae.getContext();
    if (!localContext.getPackageManager().hasSystemFeature("android.hardware.nfc")) {}
    while (NfcAdapter.getDefaultAdapter(localContext) == null) {
      return false;
    }
    return true;
  }
  
  public static boolean ajN()
  {
    NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(ae.getContext());
    if (localNfcAdapter == null) {
      y.i("MicroMsg.HceUtils", "alvinluo no nfc chip !");
    }
    while (!localNfcAdapter.isEnabled()) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d
 * JD-Core Version:    0.7.0.1
 */