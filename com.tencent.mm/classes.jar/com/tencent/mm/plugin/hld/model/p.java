package com.tencent.mm.plugin.hld.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.hld.WxHldService;
import com.tencent.mm.plugin.hld.a.b;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/WxImeEnterService;", "Lcom/tencent/mm/plugin/hld/api/IWxImeEnterService;", "()V", "checkInInputMethodList", "", "closeIme", "context", "Landroid/content/Context;", "createContactWidget", "Lcom/tencent/mm/pluginsdk/deprecated/IBodyWidget;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "enableIme", "fetchCloudResource", "filterEnableIme", "", "getImeIndependView", "Lcom/tencent/mm/plugin/hld/api/IImeIndependView;", "getImeService", "Lcom/tencent/mm/plugin/hld/api/IImeService;", "handleAttrChange", "oriAttr", "", "hasFinishFirstCloudResDownload", "inInputMethodListBySystem", "isCurrentIme", "isImeEnable", "isImeInstall", "isInImeList", "isSafetyKeyboard", "reportLabShow", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  implements d
{
  public static final p.a Jwx;
  
  static
  {
    AppMethodBeat.i(311927);
    Jwx = new p.a((byte)0);
    AppMethodBeat.o(311927);
  }
  
  public final void Ym(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(312005);
    Object localObject = com.tencent.mm.plugin.hld.c.a.JoL;
    localObject = i.JyA;
    int i = i.fOs();
    Log.i("WxIme.WxImeDictFetcher", "handleAttrChange oriAttr:" + paramInt + " newAttr:" + i);
    if (i != paramInt)
    {
      if ((i & 0x20000) != 131072) {
        break label97;
      }
      bool1 = true;
      localObject = i.JyA;
      if (bool1 != i.fOo()) {
        if (bool1) {
          break label102;
        }
      }
    }
    label97:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.tencent.mm.plugin.hld.c.a.wQ(bool1);
      AppMethodBeat.o(312005);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void fKE()
  {
    AppMethodBeat.i(311975);
    Object localObject = l.JyV;
    localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    boolean bool = l.iz((Context)localObject);
    Log.i("WxIme.WxImeEnterService", "fetchCloudResource, isCurrentIme:" + bool + ", " + Util.getStack());
    if (MMApplicationContext.isMainProcess())
    {
      if (bool)
      {
        localObject = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
        ((Intent)localObject).putExtra("ime_first_fetch_cloud_resource_check", true);
        c.n((Intent)localObject, "hld");
        AppMethodBeat.o(311975);
      }
    }
    else
    {
      localObject = l.JyV;
      l.fOR();
    }
    AppMethodBeat.o(311975);
  }
  
  public final boolean fKF()
  {
    AppMethodBeat.i(311984);
    l locall = l.JyV;
    if (l.fOM() == 2)
    {
      AppMethodBeat.o(311984);
      return true;
    }
    AppMethodBeat.o(311984);
    return false;
  }
  
  public final b fKG()
  {
    AppMethodBeat.i(311991);
    if (MMApplicationContext.isImeProcess())
    {
      localObject = WxHldService.Jnb;
      localObject = WxHldService.fKD();
      AppMethodBeat.o(311991);
      return localObject;
    }
    Object localObject = (b)com.tencent.mm.plugin.hld.d.a.JqJ;
    AppMethodBeat.o(311991);
    return localObject;
  }
  
  public final boolean fKH()
  {
    AppMethodBeat.i(311996);
    if (!MMApplicationContext.isImeProcess())
    {
      AppMethodBeat.o(311996);
      return true;
    }
    AppMethodBeat.o(311996);
    return false;
  }
  
  public final void fKI()
  {
    AppMethodBeat.i(312013);
    k localk = k.JvH;
    k.jp(12, 6);
    AppMethodBeat.o(312013);
  }
  
  public final boolean fKJ()
  {
    AppMethodBeat.i(312021);
    l locall = l.JyV;
    boolean bool = l.fKJ();
    AppMethodBeat.o(312021);
    return bool;
  }
  
  public final boolean fKK()
  {
    AppMethodBeat.i(312031);
    l locall = l.JyV;
    boolean bool = l.fKK();
    AppMethodBeat.o(312031);
    return bool;
  }
  
  public final void fKL()
  {
    AppMethodBeat.i(312040);
    l locall = l.JyV;
    l.fKL();
    AppMethodBeat.o(312040);
  }
  
  public final void ia(Context paramContext)
  {
    AppMethodBeat.i(311936);
    s.u(paramContext, "context");
    boolean bool = ic(paramContext);
    l locall = l.JyV;
    l.ia(paramContext);
    if (!bool)
    {
      paramContext = k.JvH;
      k.Yy(1);
    }
    AppMethodBeat.o(311936);
  }
  
  public final void ib(Context paramContext)
  {
    AppMethodBeat.i(311947);
    s.u(paramContext, "context");
    l locall = l.JyV;
    l.iB(paramContext);
    AppMethodBeat.o(311947);
  }
  
  public final boolean ic(Context paramContext)
  {
    AppMethodBeat.i(311957);
    s.u(paramContext, "context");
    l locall = l.JyV;
    boolean bool = l.ic(paramContext);
    AppMethodBeat.o(311957);
    return bool;
  }
  
  public final boolean id(Context paramContext)
  {
    AppMethodBeat.i(311963);
    s.u(paramContext, "context");
    l locall = l.JyV;
    boolean bool = l.id(paramContext);
    AppMethodBeat.o(311963);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.p
 * JD-Core Version:    0.7.0.1
 */