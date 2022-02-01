package com.tencent.mm.plugin.hld;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.inputmethodservice.InputMethodService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/hld/WxHldService;", "Landroid/inputmethodservice/InputMethodService;", "()V", "onCreate", "", "Companion", "plugin-hld_release"})
public class WxHldService
  extends InputMethodService
{
  public static final a yjs;
  
  static
  {
    AppMethodBeat.i(192242);
    yjs = new a((byte)0);
    AppMethodBeat.o(192242);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(192241);
    super.onCreate();
    Log.i("WxIme.WxHldService", "not available ime, switch to another ime.");
    getPackageManager().setComponentEnabledSetting(new ComponentName((Context)this, "com.tencent.mm.plugin.hld.WxHldService"), 2, 1);
    AppMethodBeat.o(192241);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/hld/WxHldService$Companion;", "", "()V", "IME_ID_NAME", "", "TAG", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.WxHldService
 * JD-Core Version:    0.7.0.1
 */