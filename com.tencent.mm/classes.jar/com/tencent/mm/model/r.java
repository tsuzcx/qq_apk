package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.api.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/model/BizTeenModeServiceProxy;", "Lcom/tencent/mm/api/IBizTeenModeService;", "()V", "isInited", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "checkInit", "", "init", "isBizTeenModeAllowAll", "isBizTeenModeDenyAll", "isTeenMode", "release", "reportRemoveBizContact", "bizInfo", "Lcom/tencent/mm/api/BizInfo;", "reportTeenModeToast", "scene", "", "username", "", "nickname", "Companion", "plugin-biz_release"})
public final class r
  implements q
{
  public static final a iCt;
  private MultiProcessMMKV cQe;
  private boolean iCs;
  
  static
  {
    AppMethodBeat.i(212422);
    iCt = new a((byte)0);
    AppMethodBeat.o(212422);
  }
  
  private final void aTL()
  {
    AppMethodBeat.i(212415);
    if (!this.iCs)
    {
      int i = a.azs();
      String str = i + "_biz_teen_mode_mmkv";
      this.cQe = MultiProcessMMKV.getMMKV(str, 2);
      Log.i("MicroMsg.BizTeenModeServiceProxy", "alvinluo initBizTeenModeServiceProxy key: %s", new Object[] { str });
      this.iCs = true;
    }
    AppMethodBeat.o(212415);
  }
  
  public final boolean Vt()
  {
    AppMethodBeat.i(212416);
    aTL();
    MultiProcessMMKV localMultiProcessMMKV = this.cQe;
    if (localMultiProcessMMKV != null)
    {
      boolean bool = localMultiProcessMMKV.getBoolean("is_teen_mode", false);
      AppMethodBeat.o(212416);
      return bool;
    }
    AppMethodBeat.o(212416);
    return false;
  }
  
  public final boolean Vu()
  {
    int i = -1;
    AppMethodBeat.i(212417);
    aTL();
    MultiProcessMMKV localMultiProcessMMKV = this.cQe;
    if (localMultiProcessMMKV != null) {}
    for (boolean bool = localMultiProcessMMKV.getBoolean("is_teen_mode", false); !bool; bool = false)
    {
      AppMethodBeat.o(212417);
      return true;
    }
    localMultiProcessMMKV = this.cQe;
    if (localMultiProcessMMKV != null) {
      i = localMultiProcessMMKV.getInt("biz_teen_mode_acct_option", -1);
    }
    Log.i("MicroMsg.BizTeenModeServiceProxy", "alvinluo isBizTeenModeAllowAll isTeenMode: %b, bizTeenModeAcctOption: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((!bool) || (i == 1))
    {
      AppMethodBeat.o(212417);
      return true;
    }
    AppMethodBeat.o(212417);
    return false;
  }
  
  public final boolean Vv()
  {
    int i = -1;
    AppMethodBeat.i(212418);
    aTL();
    MultiProcessMMKV localMultiProcessMMKV = this.cQe;
    if (localMultiProcessMMKV != null) {}
    for (boolean bool = localMultiProcessMMKV.getBoolean("is_teen_mode", false);; bool = false)
    {
      localMultiProcessMMKV = this.cQe;
      if (localMultiProcessMMKV != null) {
        i = localMultiProcessMMKV.getInt("biz_teen_mode_acct_option", -1);
      }
      Log.i("MicroMsg.BizTeenModeServiceProxy", "alvinluo isBizTeenModeDenyAll isTeenMode: %b, bizTeenModeAcctOption: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((!bool) || (i != 2)) {
        break;
      }
      AppMethodBeat.o(212418);
      return true;
    }
    AppMethodBeat.o(212418);
    return false;
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(212419);
    Log.w("MicroMsg.BizTeenModeServiceProxy", "reportRemoveBizContact not implemented in non-MM process");
    AppMethodBeat.o(212419);
  }
  
  public final void d(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(212421);
    Log.w("MicroMsg.BizTeenModeServiceProxy", "reportTeenModeToast not implemented in non-MM process");
    AppMethodBeat.o(212421);
  }
  
  public final void o(int paramInt, String paramString)
  {
    AppMethodBeat.i(212420);
    Log.w("MicroMsg.BizTeenModeServiceProxy", "reportTeenModeToast not implemented in non-MM process");
    AppMethodBeat.o(212420);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/model/BizTeenModeServiceProxy$Companion;", "", "()V", "TAG", "", "plugin-biz_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.r
 * JD-Core Version:    0.7.0.1
 */