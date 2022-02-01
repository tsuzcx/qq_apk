package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/model/BizTeenModeServiceProxy;", "Lcom/tencent/mm/api/IBizTeenModeService;", "()V", "isInited", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "checkInit", "", "init", "isBizTeenModeAllowAll", "isBizTeenModeDenyAll", "isTeenMode", "release", "reportRemoveBizContact", "bizInfo", "Lcom/tencent/mm/api/BizInfo;", "reportTeenModeToast", "scene", "", "username", "", "nickname", "Companion", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  implements com.tencent.mm.api.r
{
  public static final a ojL;
  private MultiProcessMMKV eMf;
  private boolean ojM;
  
  static
  {
    AppMethodBeat.i(241875);
    ojL = new a((byte)0);
    AppMethodBeat.o(241875);
  }
  
  private final void checkInit()
  {
    AppMethodBeat.i(241868);
    if (!this.ojM)
    {
      int i = b.aZP();
      String str = i + "_biz_teen_mode_mmkv";
      this.eMf = MultiProcessMMKV.getMMKV(str, 2);
      Log.i("MicroMsg.BizTeenModeServiceProxy", "alvinluo initBizTeenModeServiceProxy key: %s", new Object[] { str });
      this.ojM = true;
    }
    AppMethodBeat.o(241868);
  }
  
  public final boolean aBu()
  {
    AppMethodBeat.i(241881);
    checkInit();
    MultiProcessMMKV localMultiProcessMMKV = this.eMf;
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(241881);
      return false;
    }
    boolean bool = localMultiProcessMMKV.getBoolean("is_teen_mode", false);
    AppMethodBeat.o(241881);
    return bool;
  }
  
  public final boolean aBv()
  {
    int i = -1;
    AppMethodBeat.i(241887);
    checkInit();
    MultiProcessMMKV localMultiProcessMMKV = this.eMf;
    if (localMultiProcessMMKV == null) {}
    for (boolean bool = false; !bool; bool = localMultiProcessMMKV.getBoolean("is_teen_mode", false))
    {
      AppMethodBeat.o(241887);
      return true;
    }
    localMultiProcessMMKV = this.eMf;
    if (localMultiProcessMMKV == null) {}
    for (;;)
    {
      Log.i("MicroMsg.BizTeenModeServiceProxy", "alvinluo isBizTeenModeAllowAll isTeenMode: %b, bizTeenModeAcctOption: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((bool) && (i != 1)) {
        break;
      }
      AppMethodBeat.o(241887);
      return true;
      i = localMultiProcessMMKV.getInt("biz_teen_mode_acct_option", -1);
    }
    AppMethodBeat.o(241887);
    return false;
  }
  
  public final boolean aBw()
  {
    int i = -1;
    AppMethodBeat.i(241892);
    checkInit();
    MultiProcessMMKV localMultiProcessMMKV = this.eMf;
    boolean bool;
    if (localMultiProcessMMKV == null)
    {
      bool = false;
      localMultiProcessMMKV = this.eMf;
      if (localMultiProcessMMKV != null) {
        break label83;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.BizTeenModeServiceProxy", "alvinluo isBizTeenModeDenyAll isTeenMode: %b, bizTeenModeAcctOption: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((!bool) || (i != 2)) {
        break label94;
      }
      AppMethodBeat.o(241892);
      return true;
      bool = localMultiProcessMMKV.getBoolean("is_teen_mode", false);
      break;
      label83:
      i = localMultiProcessMMKV.getInt("biz_teen_mode_acct_option", -1);
    }
    label94:
    AppMethodBeat.o(241892);
    return false;
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(241895);
    Log.w("MicroMsg.BizTeenModeServiceProxy", "reportRemoveBizContact not implemented in non-MM process");
    AppMethodBeat.o(241895);
  }
  
  public final void e(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(241913);
    Log.w("MicroMsg.BizTeenModeServiceProxy", "reportTeenModeToast not implemented in non-MM process");
    AppMethodBeat.o(241913);
  }
  
  public final void p(int paramInt, String paramString)
  {
    AppMethodBeat.i(241903);
    Log.w("MicroMsg.BizTeenModeServiceProxy", "reportTeenModeToast not implemented in non-MM process");
    AppMethodBeat.o(241903);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/model/BizTeenModeServiceProxy$Companion;", "", "()V", "TAG", "", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.r
 * JD-Core Version:    0.7.0.1
 */