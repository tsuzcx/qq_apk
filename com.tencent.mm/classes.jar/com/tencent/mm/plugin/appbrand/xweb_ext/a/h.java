package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/MakeupApplyAdapter;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "makeupApplyLogic", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyLogic;", "getMakeupApplyLogic", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyLogic;", "applyBlusherStick", "", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "applyEyeBrow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "applyEyeShadow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "applyFaceContour", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "applyLipStick", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "applyMakeup", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "path", "", "plugin-appbrand-integration_release"})
public final class h
  implements com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.e
{
  private final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.f rID;
  
  public h(m paramm)
  {
    AppMethodBeat.i(276461);
    if ((paramm instanceof p)) {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapter", "weEffectManager is IWeEffectWorkaroundManager");
    }
    for (paramm = ((p)paramm).rJl.TE();; paramm = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.f)new com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.q(paramm))
    {
      this.rID = paramm;
      AppMethodBeat.o(276461);
      return;
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.f TE()
  {
    return this.rID;
  }
  
  public final void a(m.b paramb, String paramString)
  {
    AppMethodBeat.i(276454);
    kotlin.g.b.p.k(paramb, "type");
    kotlin.g.b.p.k(paramString, "path");
    this.rID.a(paramb, paramString);
    AppMethodBeat.o(276454);
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a parama)
  {
    AppMethodBeat.i(276458);
    kotlin.g.b.p.k(parama, "info");
    Object localObject1 = i.rIE;
    kotlin.g.b.p.k(parama, "info");
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(i.a((i)localObject1), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h)parama));
    if ((!localq.ifE()) && (!u.bBD(localq.bOF())))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      parama = null;
    }
    while (parama != null)
    {
      this.rID.a(m.b.cHn, parama);
      AppMethodBeat.o(276458);
      return true;
      c localc = new c();
      localc.alpha = parama.alpha;
      localc.type = parama.cGD.jsonVal;
      localObject1 = i.c(localq, new com.tencent.mm.vfs.q(parama.cGE));
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.vfs.q)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.k(localObject1, "<set-?>");
      localc.cGE = ((String)localObject1);
      localObject1 = i.c(localq, new com.tencent.mm.vfs.q(parama.cGG));
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.vfs.q)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.k(localObject1, "<set-?>");
      localc.cGG = ((String)localObject1);
      localc.cGI = parama.cGI;
      parama = (a)localc;
      if (!parama.isValid())
      {
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        u.deleteDir(localq.bOF());
        parama = null;
      }
      else
      {
        localObject1 = new com.tencent.mm.vfs.q(localq, "config.json").bOF();
        kotlin.g.b.p.j(localObject1, "configFile.absolutePath");
        Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(localObject1)));
        localObject2 = com.tencent.mm.sticker.a.Vas;
        com.tencent.mm.sticker.a.a.a((com.tencent.mm.sticker.a)parama, (String)localObject1);
        parama = localq.bOF();
      }
    }
    AppMethodBeat.o(276458);
    return false;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(276460);
    kotlin.g.b.p.k(paramb, "info");
    Object localObject1 = i.rIE;
    kotlin.g.b.p.k(paramb, "info");
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(i.a((i)localObject1), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h)paramb));
    if ((!localq.ifE()) && (!u.bBD(localq.bOF())))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      paramb = null;
    }
    while (paramb != null)
    {
      this.rID.a(m.b.cHp, paramb);
      AppMethodBeat.o(276460);
      return true;
      d locald = new d();
      locald.alpha = paramb.alpha;
      localObject1 = i.c(localq, new com.tencent.mm.vfs.q(paramb.cGL));
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.vfs.q)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.k(localObject1, "<set-?>");
      locald.cGL = ((String)localObject1);
      localObject1 = i.c(localq, new com.tencent.mm.vfs.q(paramb.cGN));
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.vfs.q)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.k(localObject1, "<set-?>");
      locald.cGN = ((String)localObject1);
      locald.cGI = paramb.cGI;
      paramb = (a)locald;
      if (!paramb.isValid())
      {
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        u.deleteDir(localq.bOF());
        paramb = null;
      }
      else
      {
        localObject1 = new com.tencent.mm.vfs.q(localq, "config.json").bOF();
        kotlin.g.b.p.j(localObject1, "configFile.absolutePath");
        Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(localObject1)));
        localObject2 = com.tencent.mm.sticker.a.Vas;
        com.tencent.mm.sticker.a.a.a((com.tencent.mm.sticker.a)paramb, (String)localObject1);
        paramb = localq.bOF();
      }
    }
    AppMethodBeat.o(276460);
    return false;
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c paramc)
  {
    com.tencent.mm.sticker.a.a locala = null;
    AppMethodBeat.i(276457);
    kotlin.g.b.p.k(paramc, "info");
    Object localObject = i.rIE;
    kotlin.g.b.p.k(paramc, "info");
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(i.a((i)localObject), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h)paramc));
    if ((!localq.ifE()) && (!u.bBD(localq.bOF())))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      paramc = locala;
    }
    while (paramc != null)
    {
      this.rID.a(m.b.cHm, paramc);
      AppMethodBeat.o(276457);
      return true;
      e locale = new e();
      locale.alpha = paramc.alpha;
      localObject = i.c(localq, new com.tencent.mm.vfs.q(paramc.cGQ));
      String str;
      if (localObject != null)
      {
        str = ((com.tencent.mm.vfs.q)localObject).getName();
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      kotlin.g.b.p.k(localObject, "<set-?>");
      locale.cGQ = ((String)localObject);
      localObject = i.c(localq, new com.tencent.mm.vfs.q(paramc.cGS));
      if (localObject != null)
      {
        str = ((com.tencent.mm.vfs.q)localObject).getName();
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      kotlin.g.b.p.k(localObject, "<set-?>");
      locale.cGS = ((String)localObject);
      localObject = (CharSequence)paramc.cGU;
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
        locale.cGU = paramc;
        paramc = (a)locale;
        if (paramc.isValid()) {
          break label339;
        }
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        u.deleteDir(localq.bOF());
        paramc = locala;
        break;
        i = 0;
        break label240;
        label292:
        paramc = paramc.cGU;
        if (paramc == null) {
          kotlin.g.b.p.iCn();
        }
        paramc = i.c(localq, new com.tencent.mm.vfs.q(paramc));
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
      localObject = new com.tencent.mm.vfs.q(localq, "config.json").bOF();
      kotlin.g.b.p.j(localObject, "configFile.absolutePath");
      Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(localObject)));
      locala = com.tencent.mm.sticker.a.Vas;
      com.tencent.mm.sticker.a.a.a((com.tencent.mm.sticker.a)paramc, (String)localObject);
      paramc = localq.bOF();
    }
    AppMethodBeat.o(276457);
    return false;
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d paramd)
  {
    AppMethodBeat.i(276459);
    kotlin.g.b.p.k(paramd, "info");
    Object localObject1 = i.rIE;
    kotlin.g.b.p.k(paramd, "info");
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(i.a((i)localObject1), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h)paramd));
    if ((!localq.ifE()) && (!u.bBD(localq.bOF())))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      paramd = null;
    }
    while (paramd != null)
    {
      this.rID.a(m.b.cHo, paramd);
      AppMethodBeat.o(276459);
      return true;
      f localf = new f();
      localf.cGZ = paramd.cGZ;
      localf.cHa = paramd.cHa;
      localObject1 = i.c(localq, new com.tencent.mm.vfs.q(paramd.cHb));
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.vfs.q)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.k(localObject1, "<set-?>");
      localf.cHb = ((String)localObject1);
      localObject1 = i.c(localq, new com.tencent.mm.vfs.q(paramd.cHd));
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.vfs.q)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.k(localObject1, "<set-?>");
      localf.cHd = ((String)localObject1);
      localf.cGI = paramd.cGI;
      paramd = (a)localf;
      if (!paramd.isValid())
      {
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        u.deleteDir(localq.bOF());
        paramd = null;
      }
      else
      {
        localObject1 = new com.tencent.mm.vfs.q(localq, "config.json").bOF();
        kotlin.g.b.p.j(localObject1, "configFile.absolutePath");
        Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(localObject1)));
        localObject2 = com.tencent.mm.sticker.a.Vas;
        com.tencent.mm.sticker.a.a.a((com.tencent.mm.sticker.a)paramd, (String)localObject1);
        paramd = localq.bOF();
      }
    }
    AppMethodBeat.o(276459);
    return false;
  }
  
  public final boolean a(o paramo)
  {
    AppMethodBeat.i(276456);
    kotlin.g.b.p.k(paramo, "info");
    Object localObject1 = i.rIE;
    kotlin.g.b.p.k(paramo, "info");
    localObject1 = new com.tencent.mm.vfs.q(i.a((i)localObject1), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h)paramo));
    if ((!((com.tencent.mm.vfs.q)localObject1).ifE()) && (!u.bBD(((com.tencent.mm.vfs.q)localObject1).bOF())))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      paramo = null;
    }
    while (paramo != null)
    {
      this.rID.a(m.b.cHl, paramo);
      AppMethodBeat.o(276456);
      return true;
      Object localObject2 = new g();
      ((g)localObject2).alpha = paramo.alpha;
      ((g)localObject2).cHD = paramo.cHA.cHD;
      ((g)localObject2).cHE = paramo.cHA.cHE;
      ((g)localObject2).cHF = paramo.cHA.cHF;
      ((g)localObject2).type = paramo.cHB.jsonVal;
      ((g)localObject2).cGI = paramo.cGI;
      ((g)localObject2).rIC = paramo.cHC.jsonVal;
      paramo = (a)localObject2;
      if (!paramo.isValid())
      {
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        u.deleteDir(((com.tencent.mm.vfs.q)localObject1).bOF());
        paramo = null;
      }
      else
      {
        localObject2 = new com.tencent.mm.vfs.q((com.tencent.mm.vfs.q)localObject1, "config.json").bOF();
        kotlin.g.b.p.j(localObject2, "configFile.absolutePath");
        Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, configPath: ".concat(String.valueOf(localObject2)));
        com.tencent.mm.sticker.a.a locala = com.tencent.mm.sticker.a.Vas;
        com.tencent.mm.sticker.a.a.a((com.tencent.mm.sticker.a)paramo, (String)localObject2);
        paramo = ((com.tencent.mm.vfs.q)localObject1).bOF();
      }
    }
    AppMethodBeat.o(276456);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.h
 * JD-Core Version:    0.7.0.1
 */