package com.tencent.mm.plugin.hld.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.hld.WxHldService;
import com.tencent.mm.plugin.hld.a.b;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/WxImeEnterService;", "Lcom/tencent/mm/plugin/hld/api/IWxImeEnterService;", "()V", "checkInInputMethodList", "", "closeIme", "context", "Landroid/content/Context;", "createContactWidget", "Lcom/tencent/mm/pluginsdk/deprecated/IBodyWidget;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "enableIme", "fetchCloudResource", "filterEnableIme", "", "getImeIndependView", "Lcom/tencent/mm/plugin/hld/api/IImeIndependView;", "getImeService", "Lcom/tencent/mm/plugin/hld/api/IImeService;", "handleAttrChange", "oriAttr", "", "hasFinishFirstCloudResDownload", "inInputMethodListBySystem", "isCurrentIme", "isImeEnable", "isImeInstall", "isInImeList", "isSafetyKeyboard", "reportLabShow", "Companion", "plugin-hld_release"})
public final class q
  implements d
{
  public static final a DEO;
  
  static
  {
    AppMethodBeat.i(210256);
    DEO = new a((byte)0);
    AppMethodBeat.o(210256);
  }
  
  public final void Uq(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(210242);
    Object localObject = com.tencent.mm.plugin.hld.c.a.DvH;
    localObject = i.DHq;
    int i = i.eGG();
    Log.i("WxIme.WxImeDictFetcher", "handleAttrChange oriAttr:" + paramInt + " newAttr:" + i);
    if (i != paramInt)
    {
      if ((i & 0x20000) != 131072) {
        break label97;
      }
      bool1 = true;
      localObject = i.DHq;
      if (bool1 != i.eGC()) {
        if (bool1) {
          break label102;
        }
      }
    }
    label97:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.tencent.mm.plugin.hld.c.a.sK(bool1);
      AppMethodBeat.o(210242);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void eCB()
  {
    AppMethodBeat.i(210231);
    Log.i("WxIme.WxImeEnterService", "fetchCloudResource " + Util.getStack());
    if (MMApplicationContext.isMainProcess())
    {
      localObject = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
      ((Intent)localObject).putExtra("ime_first_fetch_cloud_resource_check", true);
      c.l((Intent)localObject, "hld");
      AppMethodBeat.o(210231);
      return;
    }
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.eHi();
    AppMethodBeat.o(210231);
  }
  
  public final boolean eCC()
  {
    AppMethodBeat.i(210234);
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
    if (com.tencent.mm.plugin.hld.f.l.eHd() == 2)
    {
      AppMethodBeat.o(210234);
      return true;
    }
    AppMethodBeat.o(210234);
    return false;
  }
  
  public final b eCD()
  {
    AppMethodBeat.i(210235);
    if (MMApplicationContext.isImeProcess())
    {
      localObject = WxHldService.DtA;
      localObject = WxHldService.eCA();
      AppMethodBeat.o(210235);
      return localObject;
    }
    Object localObject = (b)com.tencent.mm.plugin.hld.d.a.DxH;
    AppMethodBeat.o(210235);
    return localObject;
  }
  
  public final boolean eCE()
  {
    AppMethodBeat.i(210238);
    if (!MMApplicationContext.isImeProcess())
    {
      AppMethodBeat.o(210238);
      return true;
    }
    AppMethodBeat.o(210238);
    return false;
  }
  
  public final void eCF()
  {
    AppMethodBeat.i(210246);
    k localk = k.DDb;
    k.hL(12, 6);
    AppMethodBeat.o(210246);
  }
  
  public final boolean eCG()
  {
    AppMethodBeat.i(210249);
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
    boolean bool = com.tencent.mm.plugin.hld.f.l.eCG();
    AppMethodBeat.o(210249);
    return bool;
  }
  
  public final boolean eCH()
  {
    AppMethodBeat.i(210251);
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
    boolean bool = com.tencent.mm.plugin.hld.f.l.eCH();
    AppMethodBeat.o(210251);
    return bool;
  }
  
  public final void eCI()
  {
    AppMethodBeat.i(210254);
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.eCI();
    AppMethodBeat.o(210254);
  }
  
  public final void gH(Context paramContext)
  {
    AppMethodBeat.i(210222);
    p.k(paramContext, "context");
    boolean bool = gJ(paramContext);
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.gH(paramContext);
    if (!bool)
    {
      paramContext = k.DDb;
      k.UB(1);
    }
    AppMethodBeat.o(210222);
  }
  
  public final void gI(Context paramContext)
  {
    AppMethodBeat.i(210224);
    p.k(paramContext, "context");
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.hg(paramContext);
    AppMethodBeat.o(210224);
  }
  
  public final boolean gJ(Context paramContext)
  {
    AppMethodBeat.i(210226);
    p.k(paramContext, "context");
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
    boolean bool = com.tencent.mm.plugin.hld.f.l.gJ(paramContext);
    AppMethodBeat.o(210226);
    return bool;
  }
  
  public final boolean gK(Context paramContext)
  {
    AppMethodBeat.i(210228);
    p.k(paramContext, "context");
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
    boolean bool = com.tencent.mm.plugin.hld.f.l.gK(paramContext);
    AppMethodBeat.o(210228);
    return bool;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/WxImeEnterService$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.q
 * JD-Core Version:    0.7.0.1
 */