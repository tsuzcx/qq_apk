package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.StickerBackType;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.TriggerAction;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.a.a;
import com.tencent.mm.sticker.e;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyAdapterCoreLogic;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseResApplyAdapterCoreLogic;", "()V", "STICKER_ELEMENT_RES_NAME_DELIMITER", "", "STICKER_ELEMENT_RES_NAME_DELIMITER_2", "STICKER_ELEMENT_RES_NAME_SUFFIX", "", "TAG", "stickerTransform", "Lcom/tencent/mm/sticker/StickerTransform;", "getStickerTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "stickerTransform$delegate", "Lkotlin/Lazy;", "convert2StickerApplyParams", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyParams;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "itemInfoList", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "copyStickerItemResourcesIfNeed", "", "itemResCount", "", "itemResDir", "Lcom/tencent/mm/vfs/VFSFile;", "itemName", "stickerResDir", "generateStickerResDirName", "realConvert2StickerApplyParams", "stickerType", "plugin-appbrand-integration_release"})
public final class k
  extends b
{
  private static final f oGQ;
  public static final k oGR;
  
  static
  {
    AppMethodBeat.i(229747);
    oGR = new k();
    oGQ = kotlin.g.ah((kotlin.g.a.a)c.oGT);
    AppMethodBeat.o(229747);
  }
  
  private static boolean a(int paramInt, o paramo1, String paramString, o paramo2)
  {
    AppMethodBeat.i(229746);
    paramo2 = new o(paramo2, paramString);
    paramString = com.tencent.mm.plugin.appbrand.jsapi.ag.c.d.mJM;
    if (com.tencent.mm.plugin.appbrand.jsapi.ag.c.d.D(paramo2))
    {
      Log.i("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, stickerItemDir(" + paramo2 + ") already exist");
      AppMethodBeat.o(229746);
      return true;
    }
    paramString = paramo1.b((w)new k.a(kotlin.k.j.mY(0, paramInt)));
    paramo1 = paramString;
    if (paramString == null) {
      paramo1 = new o[0];
    }
    p.g(paramo1, "itemResDir.listFiles { _…        } ?: emptyArray()");
    if (paramInt != paramo1.length)
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, can not find all res");
      AppMethodBeat.o(229746);
      return false;
    }
    if ((!paramo2.exists()) && (!paramo2.mkdirs()))
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, create stickerItemDir fail");
      AppMethodBeat.o(229746);
      return false;
    }
    int i = paramo1.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramString = paramo1[paramInt];
      p.g(paramString, "itemResFile");
      Object localObject = paramString.getName();
      p.g(localObject, "itemResFile.name");
      Log.d("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, itemResName: ".concat(String.valueOf(localObject)));
      localObject = new o(paramo2, (String)localObject);
      if (0L > com.tencent.mm.vfs.s.nw(paramString.getAbsolutePath(), ((o)localObject).getAbsolutePath()))
      {
        Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, copy fail");
        AppMethodBeat.o(229746);
        return false;
      }
      paramInt += 1;
    }
    paramo1 = com.tencent.mm.plugin.appbrand.jsapi.ag.c.d.mJM;
    if (!com.tencent.mm.plugin.appbrand.jsapi.ag.c.d.C(paramo2))
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, record stickerItemDir fail");
      AppMethodBeat.o(229746);
      return false;
    }
    AppMethodBeat.o(229746);
    return true;
  }
  
  private static String bZ(List<StickerItemInfo> paramList)
  {
    int i = 0;
    AppMethodBeat.i(229745);
    paramList = ((Collection)paramList).toArray(new StickerItemInfo[0]);
    if (paramList == null)
    {
      paramList = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(229745);
      throw paramList;
    }
    paramList = (StickerItemInfo[])paramList;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('[');
    int j = paramList.length;
    while (i < j)
    {
      ((StringBuilder)localObject).append(paramList[i].Qc());
      ((StringBuilder)localObject).append(", ");
      i += 1;
    }
    ((StringBuilder)localObject).append(']');
    paramList = ((StringBuilder)localObject).toString();
    p.g(paramList, "StringBuilder().apply(builderAction).toString()");
    localObject = kotlin.n.d.UTF_8;
    if (paramList == null)
    {
      paramList = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(229745);
      throw paramList;
    }
    paramList = paramList.getBytes((Charset)localObject);
    p.g(paramList, "(this as java.lang.String).getBytes(charset)");
    paramList = com.tencent.mm.b.g.getMessageDigest(paramList);
    p.g(paramList, "MD5.getMessageDigest(ite…nfoListStr.toByteArray())");
    AppMethodBeat.o(229745);
    return paramList;
  }
  
  public final m b(l.c paramc, List<StickerItemInfo> paramList)
  {
    AppMethodBeat.i(229744);
    p.h(paramc, "type");
    p.h(paramList, "itemInfoList");
    o localo = new o(cdJ(), bZ(paramList));
    Object localObject1 = (Iterable)kotlin.a.j.a((Iterable)paramList, (Comparator)new b());
    paramList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (StickerItemInfo)((Iterator)localObject1).next();
      if (!a(((StickerItemInfo)localObject3).frameCount, new o(((StickerItemInfo)localObject3).cHM), ((StickerItemInfo)localObject3).name, localo))
      {
        paramc = null;
        if (paramc == null) {
          com.tencent.mm.vfs.s.deleteDir(localo.getAbsolutePath());
        }
        AppMethodBeat.o(229744);
        return paramc;
      }
      localObject2 = ((StickerItemInfo)localObject3).name;
      com.tencent.mm.sticker.d locald = new com.tencent.mm.sticker.d();
      locald.setName(((StickerItemInfo)localObject3).name);
      locald.len = ((StickerItemInfo)localObject3).frameCount;
      locald.NMN = ((StickerItemInfo)localObject3).cHL.getJsonVal();
      if (l.c.cGL == paramc) {
        locald.NMO = ((StickerItemInfo)localObject3).cHP.getJsonVal();
      }
      for (;;)
      {
        paramList.add(kotlin.s.U(localObject2, locald));
        break;
        localObject3 = ((StickerItemInfo)localObject3).cHO;
        if (localObject3 != null)
        {
          double[] arrayOfDouble = new double[4];
          arrayOfDouble[0] = ((StickerItemInfo.a)localObject3).cHQ;
          arrayOfDouble[1] = ((StickerItemInfo.a)localObject3).cHR;
          arrayOfDouble[2] = ((StickerItemInfo.a)localObject3).cHS;
          arrayOfDouble[3] = ((StickerItemInfo.a)localObject3).cHT;
          p.h(arrayOfDouble, "<set-?>");
          locald.NMR = arrayOfDouble;
        }
      }
    }
    Object localObject2 = (HashMap)ae.a((Iterable)paramList, (Map)new HashMap());
    localObject1 = new e();
    ((e)localObject1).jgT = 1.0D;
    switch (l.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      paramc = new kotlin.m();
      AppMethodBeat.o(229744);
      throw paramc;
    case 1: 
      paramList = "Sticker2D";
    }
    for (;;)
    {
      ((e)localObject1).setType(paramList);
      ((e)localObject1).s((HashMap)localObject2);
      if (l.c.cGN == paramc) {
        ((e)localObject1).a((com.tencent.mm.sticker.g)oGQ.getValue());
      }
      paramList = new o(localo, "config.json").getAbsolutePath();
      p.g(paramList, "stickerConfigFile.absolutePath");
      Log.d("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "realConvert2StickerApplyParams, stickerConfigPath: ".concat(String.valueOf(paramList)));
      localObject2 = com.tencent.mm.sticker.a.NMI;
      a.a.a((com.tencent.mm.sticker.a)localObject1, paramList);
      paramList = localo.getAbsolutePath();
      p.g(paramList, "stickerResDir.absolutePath");
      paramc = new m(paramc, paramList);
      break;
      paramList = "StickerFixed";
      continue;
      paramList = "Segment";
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(229741);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((StickerItemInfo)paramT1).id), (Comparable)Integer.valueOf(((StickerItemInfo)paramT2).id));
      AppMethodBeat.o(229741);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sticker/StickerTransform;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<com.tencent.mm.sticker.g>
  {
    public static final c oGT;
    
    static
    {
      AppMethodBeat.i(229743);
      oGT = new c();
      AppMethodBeat.o(229743);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.k
 * JD-Core Version:    0.7.0.1
 */