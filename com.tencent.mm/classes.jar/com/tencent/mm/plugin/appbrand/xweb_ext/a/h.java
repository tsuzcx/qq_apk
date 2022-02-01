package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.q;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.q.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.q.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.q.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.a.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/MakeupApplyAdapter;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "makeupApplyLogic", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyLogic;", "getMakeupApplyLogic", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyLogic;", "applyBlusherStick", "", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "applyEyeBrow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "applyEyeShadowV2", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfoV2;", "applyFaceContour", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "applyLipStickV1", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV1;", "applyLipStickV2", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2;", "applyMakeup", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "path", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.f
{
  private final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g uTU;
  
  public h(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o paramo)
  {
    AppMethodBeat.i(317066);
    if ((paramo instanceof o)) {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapter", "weEffectManager is IWeEffectWorkaroundManager");
    }
    for (paramo = ((o)paramo).uUB.auj();; paramo = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g)new com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.s(paramo))
    {
      this.uTU = paramo;
      AppMethodBeat.o(317066);
      return;
    }
  }
  
  public final void a(o.b paramb, String paramString)
  {
    AppMethodBeat.i(317076);
    kotlin.g.b.s.u(paramb, "type");
    kotlin.g.b.s.u(paramString, "path");
    this.uTU.a(paramb, paramString);
    AppMethodBeat.o(317076);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(317118);
    kotlin.g.b.s.u(paramb, "info");
    Object localObject1 = i.uTV;
    kotlin.g.b.s.u(paramb, "info");
    u localu = new u(i.a((i)localObject1), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i)paramb));
    if ((!localu.jKS()) && (!y.bDX(ah.v(localu.jKT()))))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      paramb = null;
    }
    while (paramb == null)
    {
      AppMethodBeat.o(317118);
      return false;
      Object localObject2 = new c();
      ((c)localObject2).alpha = paramb.alpha;
      ((c)localObject2).eAs = paramb.eAs;
      ((c)localObject2).uTR = paramb.eAt.jsonVal;
      paramb = i.e(localu, new u(paramb.path));
      if (paramb == null) {
        paramb = "";
      }
      for (;;)
      {
        kotlin.g.b.s.u(paramb, "<set-?>");
        ((c)localObject2).path = paramb;
        paramb = (a)localObject2;
        if (paramb.isValid()) {
          break label208;
        }
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        y.ew(ah.v(localu.jKT()), true);
        paramb = null;
        break;
        localObject1 = paramb.getName();
        paramb = (b)localObject1;
        if (localObject1 == null) {
          paramb = "";
        }
      }
      label208:
      localObject1 = ah.v(new u(localu, "config.json").jKT());
      kotlin.g.b.s.s(localObject1, "configFile.absolutePath");
      Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", kotlin.g.b.s.X("convert2PathImpl, configPath: ", localObject1));
      localObject2 = com.tencent.mm.sticker.a.acBM;
      a.a.a((com.tencent.mm.sticker.a)paramb, (String)localObject1);
      paramb = y.n(ah.v(localu.jKT()), false);
    }
    this.uTU.a(o.b.eAK, paramb);
    AppMethodBeat.o(317118);
    return true;
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c paramc)
  {
    AppMethodBeat.i(317134);
    kotlin.g.b.s.u(paramc, "info");
    Object localObject1 = i.uTV;
    kotlin.g.b.s.u(paramc, "info");
    u localu = new u(i.a((i)localObject1), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i)paramc));
    if ((!localu.jKS()) && (!y.bDX(ah.v(localu.jKT()))))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      paramc = null;
    }
    while (paramc == null)
    {
      AppMethodBeat.o(317134);
      return false;
      d locald = new d();
      locald.alpha = paramc.alpha;
      locald.eAs = paramc.eAs;
      locald.uTR = paramc.eAt.jsonVal;
      localObject1 = i.e(localu, new u(paramc.path));
      if (localObject1 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        kotlin.g.b.s.u(localObject1, "<set-?>");
        locald.path = ((String)localObject1);
        locald.eAv = paramc.eAv;
        paramc = (a)locald;
        if (paramc.isValid()) {
          break label222;
        }
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        y.ew(ah.v(localu.jKT()), true);
        paramc = null;
        break;
        localObject2 = ((u)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      label222:
      localObject1 = ah.v(new u(localu, "config.json").jKT());
      kotlin.g.b.s.s(localObject1, "configFile.absolutePath");
      Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", kotlin.g.b.s.X("convert2PathImpl, configPath: ", localObject1));
      Object localObject2 = com.tencent.mm.sticker.a.acBM;
      a.a.a((com.tencent.mm.sticker.a)paramc, (String)localObject1);
      paramc = y.n(ah.v(localu.jKT()), false);
    }
    this.uTU.a(o.b.eAM, paramc);
    AppMethodBeat.o(317134);
    return true;
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d paramd)
  {
    a.a locala = null;
    AppMethodBeat.i(317108);
    kotlin.g.b.s.u(paramd, "info");
    Object localObject = i.uTV;
    kotlin.g.b.s.u(paramd, "info");
    u localu = new u(i.a((i)localObject), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i)paramd));
    if ((!localu.jKS()) && (!y.bDX(ah.v(localu.jKT()))))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      paramd = locala;
    }
    while (paramd == null)
    {
      AppMethodBeat.o(317108);
      return false;
      e locale = new e();
      locale.alpha = paramd.alpha;
      locale.uTR = paramd.eAt.jsonVal;
      localObject = i.e(localu, new u(paramd.path));
      label143:
      int i;
      if (localObject == null)
      {
        localObject = "";
        kotlin.g.b.s.u(localObject, "<set-?>");
        locale.path = ((String)localObject);
        localObject = (CharSequence)paramd.eAw;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label249;
        }
        i = 1;
        label178:
        if (i == 0) {
          break label254;
        }
        paramd = null;
      }
      for (;;)
      {
        locale.eAw = paramd;
        paramd = (a)locale;
        if (paramd.isValid()) {
          break label304;
        }
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        y.ew(ah.v(localu.jKT()), true);
        paramd = locala;
        break;
        String str = ((u)localObject).getName();
        localObject = str;
        if (str != null) {
          break label143;
        }
        localObject = "";
        break label143;
        label249:
        i = 0;
        break label178;
        label254:
        paramd = paramd.eAw;
        kotlin.g.b.s.checkNotNull(paramd);
        paramd = i.e(localu, new u(paramd));
        if (paramd == null)
        {
          paramd = "";
        }
        else
        {
          localObject = paramd.getName();
          paramd = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d)localObject;
          if (localObject == null) {
            paramd = "";
          }
        }
      }
      label304:
      localObject = ah.v(new u(localu, "config.json").jKT());
      kotlin.g.b.s.s(localObject, "configFile.absolutePath");
      Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", kotlin.g.b.s.X("convert2PathImpl, configPath: ", localObject));
      locala = com.tencent.mm.sticker.a.acBM;
      a.a.a((com.tencent.mm.sticker.a)paramd, (String)localObject);
      paramd = y.n(ah.v(localu.jKT()), false);
    }
    this.uTU.a(o.b.eAJ, paramd);
    AppMethodBeat.o(317108);
    return true;
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.e parame)
  {
    AppMethodBeat.i(317127);
    kotlin.g.b.s.u(parame, "info");
    Object localObject1 = i.uTV;
    kotlin.g.b.s.u(parame, "info");
    u localu = new u(i.a((i)localObject1), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i)parame));
    if ((!localu.jKS()) && (!y.bDX(ah.v(localu.jKT()))))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      parame = null;
    }
    while (parame == null)
    {
      AppMethodBeat.o(317127);
      return false;
      Object localObject2 = new f();
      ((f)localObject2).eAs = parame.eAs;
      ((f)localObject2).alpha = parame.alpha;
      parame = i.e(localu, new u(parame.path));
      if (parame == null) {
        parame = "";
      }
      for (;;)
      {
        kotlin.g.b.s.u(parame, "<set-?>");
        ((f)localObject2).path = parame;
        parame = (a)localObject2;
        if (parame.isValid()) {
          break label198;
        }
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        y.ew(ah.v(localu.jKT()), true);
        parame = null;
        break;
        localObject1 = parame.getName();
        parame = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.e)localObject1;
        if (localObject1 == null) {
          parame = "";
        }
      }
      label198:
      localObject1 = ah.v(new u(localu, "config.json").jKT());
      kotlin.g.b.s.s(localObject1, "configFile.absolutePath");
      Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", kotlin.g.b.s.X("convert2PathImpl, configPath: ", localObject1));
      localObject2 = com.tencent.mm.sticker.a.acBM;
      a.a.a((com.tencent.mm.sticker.a)parame, (String)localObject1);
      parame = y.n(ah.v(localu.jKT()), false);
    }
    this.uTU.a(o.b.eAL, parame);
    AppMethodBeat.o(317127);
    return true;
  }
  
  public final boolean a(q paramq)
  {
    AppMethodBeat.i(317091);
    kotlin.g.b.s.u(paramq, "info");
    Object localObject1 = i.uTV;
    kotlin.g.b.s.u(paramq, "info");
    localObject1 = new u(i.a((i)localObject1), i.a((com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i)paramq));
    if ((!((u)localObject1).jKS()) && (!y.bDX(ah.v(((u)localObject1).jKT()))))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, create resDir fail");
      paramq = null;
    }
    while (paramq == null)
    {
      AppMethodBeat.o(317091);
      return false;
      Object localObject2 = new g();
      ((g)localObject2).alpha = paramq.alpha;
      ((g)localObject2).eBa = paramq.eAX.eBa;
      ((g)localObject2).eBb = paramq.eAX.eBb;
      ((g)localObject2).eBc = paramq.eAX.eBc;
      ((g)localObject2).uTS = paramq.eAY.jsonVal;
      ((g)localObject2).eAs = paramq.eAs;
      ((g)localObject2).uTT = paramq.eAZ.jsonVal;
      paramq = (a)localObject2;
      if (!paramq.isValid())
      {
        Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "convert2PathImpl, flattenInfo is invalid");
        y.ew(ah.v(((u)localObject1).jKT()), true);
        paramq = null;
      }
      else
      {
        localObject2 = ah.v(new u((u)localObject1, "config.json").jKT());
        kotlin.g.b.s.s(localObject2, "configFile.absolutePath");
        Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", kotlin.g.b.s.X("convert2PathImpl, configPath: ", localObject2));
        a.a locala = com.tencent.mm.sticker.a.acBM;
        a.a.a((com.tencent.mm.sticker.a)paramq, (String)localObject2);
        paramq = y.n(ah.v(((u)localObject1).jKT()), false);
      }
    }
    this.uTU.a(o.b.eAI, paramq);
    AppMethodBeat.o(317091);
    return true;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g auj()
  {
    return this.uTU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.h
 * JD-Core Version:    0.7.0.1
 */