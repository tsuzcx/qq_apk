package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.api.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/model/BizTeenModeServiceProxy;", "Lcom/tencent/mm/api/IBizTeenModeService;", "()V", "isInited", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "checkInit", "", "init", "isBizTeenModeAllowAll", "isBizTeenModeDenyAll", "isTeenMode", "release", "reportRemoveBizContact", "bizInfo", "Lcom/tencent/mm/api/BizInfo;", "reportTeenModeToast", "scene", "", "username", "", "nickname", "Companion", "plugin-biz_release"})
public final class r
  implements q
{
  public static final a lso;
  private MultiProcessMMKV cQO;
  private boolean lsn;
  
  static
  {
    AppMethodBeat.i(207278);
    lso = new a((byte)0);
    AppMethodBeat.o(207278);
  }
  
  private final void bcM()
  {
    AppMethodBeat.i(207263);
    if (!this.lsn)
    {
      int i = b.aGP();
      String str = i + "_biz_teen_mode_mmkv";
      this.cQO = MultiProcessMMKV.getMMKV(str, 2);
      Log.i("MicroMsg.BizTeenModeServiceProxy", "alvinluo initBizTeenModeServiceProxy key: %s", new Object[] { str });
      this.lsn = true;
    }
    AppMethodBeat.o(207263);
  }
  
  public final boolean ZM()
  {
    AppMethodBeat.i(207267);
    bcM();
    MultiProcessMMKV localMultiProcessMMKV = this.cQO;
    if (localMultiProcessMMKV != null)
    {
      boolean bool = localMultiProcessMMKV.getBoolean("is_teen_mode", false);
      AppMethodBeat.o(207267);
      return bool;
    }
    AppMethodBeat.o(207267);
    return false;
  }
  
  public final boolean ZN()
  {
    int i = -1;
    AppMethodBeat.i(207270);
    bcM();
    MultiProcessMMKV localMultiProcessMMKV = this.cQO;
    if (localMultiProcessMMKV != null) {}
    for (boolean bool = localMultiProcessMMKV.getBoolean("is_teen_mode", false); !bool; bool = false)
    {
      AppMethodBeat.o(207270);
      return true;
    }
    localMultiProcessMMKV = this.cQO;
    if (localMultiProcessMMKV != null) {
      i = localMultiProcessMMKV.getInt("biz_teen_mode_acct_option", -1);
    }
    Log.i("MicroMsg.BizTeenModeServiceProxy", "alvinluo isBizTeenModeAllowAll isTeenMode: %b, bizTeenModeAcctOption: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((!bool) || (i == 1))
    {
      AppMethodBeat.o(207270);
      return true;
    }
    AppMethodBeat.o(207270);
    return false;
  }
  
  public final boolean ZO()
  {
    int i = -1;
    AppMethodBeat.i(207273);
    bcM();
    MultiProcessMMKV localMultiProcessMMKV = this.cQO;
    if (localMultiProcessMMKV != null) {}
    for (boolean bool = localMultiProcessMMKV.getBoolean("is_teen_mode", false);; bool = false)
    {
      localMultiProcessMMKV = this.cQO;
      if (localMultiProcessMMKV != null) {
        i = localMultiProcessMMKV.getInt("biz_teen_mode_acct_option", -1);
      }
      Log.i("MicroMsg.BizTeenModeServiceProxy", "alvinluo isBizTeenModeDenyAll isTeenMode: %b, bizTeenModeAcctOption: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((!bool) || (i != 2)) {
        break;
      }
      AppMethodBeat.o(207273);
      return true;
    }
    AppMethodBeat.o(207273);
    return false;
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(207275);
    Log.w("MicroMsg.BizTeenModeServiceProxy", "reportRemoveBizContact not implemented in non-MM process");
    AppMethodBeat.o(207275);
  }
  
  public final void d(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207277);
    Log.w("MicroMsg.BizTeenModeServiceProxy", "reportTeenModeToast not implemented in non-MM process");
    AppMethodBeat.o(207277);
  }
  
  public final void p(int paramInt, String paramString)
  {
    AppMethodBeat.i(207276);
    Log.w("MicroMsg.BizTeenModeServiceProxy", "reportTeenModeToast not implemented in non-MM process");
    AppMethodBeat.o(207276);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/model/BizTeenModeServiceProxy$Companion;", "", "()V", "TAG", "", "plugin-biz_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.r
 * JD-Core Version:    0.7.0.1
 */