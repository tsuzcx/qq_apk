package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/MakeupApplyAdapter;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "makeupApplyLogic", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyLogic;", "getMakeupApplyLogic", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyLogic;", "applyBlusherStick", "", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "applyEyeBrow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "applyEyeShadow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "applyFaceContour", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "applyLipStick", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "applyMakeup", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "path", "", "plugin-appbrand-integration_release"})
public final class h
  implements com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.e
{
  private final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.f oGN;
  
  public h(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l paraml)
  {
    AppMethodBeat.i(229731);
    if ((paraml instanceof p)) {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapter", "weEffectManager is IWeEffectWorkaroundManager");
    }
    for (paraml = ((p)paraml).oHv.Qd();; paraml = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.f)new com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.p(paraml))
    {
      this.oGN = paraml;
      AppMethodBeat.o(229731);
      return;
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.f Qd()
  {
    return this.oGN;
  }
  
  public final void a(l.b paramb, String paramString)
  {
    AppMethodBeat.i(229725);
    kotlin.g.b.p.h(paramb, "type");
    kotlin.g.b.p.h(paramString, "path");
    this.oGN.a(paramb, paramString);
    AppMethodBeat.o(229725);
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a parama)
  {
    AppMethodBeat.i(229728);
    kotlin.g.b.p.h(parama, "info");
    Object localObject1 = i.oGO;
    kotlin.g.b.p.h(parama, "info");
    o localo = new o(i.a((i)localObject1), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h)parama));
    if ((!localo.exists()) && (!s.boN(localo.getAbsolutePath())))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      parama = null;
    }
    while (parama != null)
    {
      this.oGN.a(l.b.cGH, parama);
      AppMethodBeat.o(229728);
      return true;
      c localc = new c();
      localc.alpha = parama.alpha;
      localc.type = parama.cFX.jsonVal;
      localObject1 = i.c(localo, new o(parama.cFY));
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((o)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.h(localObject1, "<set-?>");
      localc.cFY = ((String)localObject1);
      localObject1 = i.c(localo, new o(parama.cGa));
      if (localObject1 != null)
      {
        localObject2 = ((o)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.h(localObject1, "<set-?>");
      localc.cGa = ((String)localObject1);
      localc.cGc = parama.cGc;
      parama = (a)localc;
      if (!parama.isValid())
      {
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        s.deleteDir(localo.getAbsolutePath());
        parama = null;
      }
      else
      {
        localObject1 = new o(localo, "config.json").getAbsolutePath();
        kotlin.g.b.p.g(localObject1, "configFile.absolutePath");
        Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(localObject1)));
        localObject2 = com.tencent.mm.sticker.a.NMI;
        com.tencent.mm.sticker.a.a.a((com.tencent.mm.sticker.a)parama, (String)localObject1);
        parama = localo.getAbsolutePath();
      }
    }
    AppMethodBeat.o(229728);
    return false;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(229730);
    kotlin.g.b.p.h(paramb, "info");
    Object localObject1 = i.oGO;
    kotlin.g.b.p.h(paramb, "info");
    o localo = new o(i.a((i)localObject1), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h)paramb));
    if ((!localo.exists()) && (!s.boN(localo.getAbsolutePath())))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      paramb = null;
    }
    while (paramb != null)
    {
      this.oGN.a(l.b.cGJ, paramb);
      AppMethodBeat.o(229730);
      return true;
      d locald = new d();
      locald.alpha = paramb.alpha;
      localObject1 = i.c(localo, new o(paramb.cGf));
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((o)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.h(localObject1, "<set-?>");
      locald.cGf = ((String)localObject1);
      localObject1 = i.c(localo, new o(paramb.cGh));
      if (localObject1 != null)
      {
        localObject2 = ((o)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.h(localObject1, "<set-?>");
      locald.cGh = ((String)localObject1);
      locald.cGc = paramb.cGc;
      paramb = (a)locald;
      if (!paramb.isValid())
      {
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        s.deleteDir(localo.getAbsolutePath());
        paramb = null;
      }
      else
      {
        localObject1 = new o(localo, "config.json").getAbsolutePath();
        kotlin.g.b.p.g(localObject1, "configFile.absolutePath");
        Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(localObject1)));
        localObject2 = com.tencent.mm.sticker.a.NMI;
        com.tencent.mm.sticker.a.a.a((com.tencent.mm.sticker.a)paramb, (String)localObject1);
        paramb = localo.getAbsolutePath();
      }
    }
    AppMethodBeat.o(229730);
    return false;
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c paramc)
  {
    com.tencent.mm.sticker.a.a locala = null;
    AppMethodBeat.i(229727);
    kotlin.g.b.p.h(paramc, "info");
    Object localObject = i.oGO;
    kotlin.g.b.p.h(paramc, "info");
    o localo = new o(i.a((i)localObject), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h)paramc));
    if ((!localo.exists()) && (!s.boN(localo.getAbsolutePath())))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      paramc = locala;
    }
    while (paramc != null)
    {
      this.oGN.a(l.b.cGG, paramc);
      AppMethodBeat.o(229727);
      return true;
      e locale = new e();
      locale.alpha = paramc.alpha;
      localObject = i.c(localo, new o(paramc.cGk));
      String str;
      if (localObject != null)
      {
        str = ((o)localObject).getName();
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      kotlin.g.b.p.h(localObject, "<set-?>");
      locale.cGk = ((String)localObject);
      localObject = i.c(localo, new o(paramc.cGm));
      if (localObject != null)
      {
        str = ((o)localObject).getName();
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      kotlin.g.b.p.h(localObject, "<set-?>");
      locale.cGm = ((String)localObject);
      localObject = (CharSequence)paramc.cGo;
      int i;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        label240:
        if (i == 0) {
          break label292;
        }
        paramc = null;
      }
      for (;;)
      {
        locale.cGo = paramc;
        paramc = (a)locale;
        if (paramc.isValid()) {
          break label339;
        }
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        s.deleteDir(localo.getAbsolutePath());
        paramc = locala;
        break;
        i = 0;
        break label240;
        label292:
        paramc = paramc.cGo;
        if (paramc == null) {
          kotlin.g.b.p.hyc();
        }
        paramc = i.c(localo, new o(paramc));
        if (paramc != null)
        {
          localObject = paramc.getName();
          paramc = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramc = "";
        }
      }
      label339:
      localObject = new o(localo, "config.json").getAbsolutePath();
      kotlin.g.b.p.g(localObject, "configFile.absolutePath");
      Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(localObject)));
      locala = com.tencent.mm.sticker.a.NMI;
      com.tencent.mm.sticker.a.a.a((com.tencent.mm.sticker.a)paramc, (String)localObject);
      paramc = localo.getAbsolutePath();
    }
    AppMethodBeat.o(229727);
    return false;
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d paramd)
  {
    AppMethodBeat.i(229729);
    kotlin.g.b.p.h(paramd, "info");
    Object localObject1 = i.oGO;
    kotlin.g.b.p.h(paramd, "info");
    o localo = new o(i.a((i)localObject1), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h)paramd));
    if ((!localo.exists()) && (!s.boN(localo.getAbsolutePath())))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      paramd = null;
    }
    while (paramd != null)
    {
      this.oGN.a(l.b.cGI, paramd);
      AppMethodBeat.o(229729);
      return true;
      f localf = new f();
      localf.cGt = paramd.cGt;
      localf.cGu = paramd.cGu;
      localObject1 = i.c(localo, new o(paramd.cGv));
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((o)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.h(localObject1, "<set-?>");
      localf.cGv = ((String)localObject1);
      localObject1 = i.c(localo, new o(paramd.cGx));
      if (localObject1 != null)
      {
        localObject2 = ((o)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.h(localObject1, "<set-?>");
      localf.cGx = ((String)localObject1);
      localf.cGc = paramd.cGc;
      paramd = (a)localf;
      if (!paramd.isValid())
      {
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        s.deleteDir(localo.getAbsolutePath());
        paramd = null;
      }
      else
      {
        localObject1 = new o(localo, "config.json").getAbsolutePath();
        kotlin.g.b.p.g(localObject1, "configFile.absolutePath");
        Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(localObject1)));
        localObject2 = com.tencent.mm.sticker.a.NMI;
        com.tencent.mm.sticker.a.a.a((com.tencent.mm.sticker.a)paramd, (String)localObject1);
        paramd = localo.getAbsolutePath();
      }
    }
    AppMethodBeat.o(229729);
    return false;
  }
  
  public final boolean a(n paramn)
  {
    AppMethodBeat.i(229726);
    kotlin.g.b.p.h(paramn, "info");
    Object localObject1 = i.oGO;
    kotlin.g.b.p.h(paramn, "info");
    localObject1 = new o(i.a((i)localObject1), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h)paramn));
    if ((!((o)localObject1).exists()) && (!s.boN(((o)localObject1).getAbsolutePath())))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      paramn = null;
    }
    while (paramn != null)
    {
      this.oGN.a(l.b.cGF, paramn);
      AppMethodBeat.o(229726);
      return true;
      Object localObject2 = new g();
      ((g)localObject2).alpha = paramn.alpha;
      ((g)localObject2).cGX = paramn.cGU.cGX;
      ((g)localObject2).cGY = paramn.cGU.cGY;
      ((g)localObject2).cGZ = paramn.cGU.cGZ;
      ((g)localObject2).type = paramn.cGV.jsonVal;
      ((g)localObject2).cGc = paramn.cGc;
      ((g)localObject2).oGM = paramn.cGW.jsonVal;
      paramn = (a)localObject2;
      if (!paramn.isValid())
      {
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        s.deleteDir(((o)localObject1).getAbsolutePath());
        paramn = null;
      }
      else
      {
        localObject2 = new o((o)localObject1, "config.json").getAbsolutePath();
        kotlin.g.b.p.g(localObject2, "configFile.absolutePath");
        Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(localObject2)));
        com.tencent.mm.sticker.a.a locala = com.tencent.mm.sticker.a.NMI;
        com.tencent.mm.sticker.a.a.a((com.tencent.mm.sticker.a)paramn, (String)localObject2);
        paramn = ((o)localObject1).getAbsolutePath();
      }
    }
    AppMethodBeat.o(229726);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.h
 * JD-Core Version:    0.7.0.1
 */