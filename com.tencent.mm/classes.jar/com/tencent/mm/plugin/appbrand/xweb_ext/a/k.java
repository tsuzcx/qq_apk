package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.StickerBackType;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.TriggerAction;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.a.a;
import com.tencent.mm.sticker.e;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.z;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.s;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyAdapterCoreLogic;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseResApplyAdapterCoreLogic;", "()V", "STICKER_ELEMENT_RES_NAME_DELIMITER", "", "STICKER_ELEMENT_RES_NAME_DELIMITER_2", "STICKER_ELEMENT_RES_NAME_SUFFIX", "", "TAG", "stickerTransform", "Lcom/tencent/mm/sticker/StickerTransform;", "getStickerTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "stickerTransform$delegate", "Lkotlin/Lazy;", "convert2StickerApplyParams", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyParams;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "itemInfoList", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "copyStickerItemResourcesIfNeed", "", "itemResCount", "", "itemResDir", "Lcom/tencent/mm/vfs/VFSFile;", "itemName", "stickerResDir", "generateStickerResDirName", "realConvert2StickerApplyParams", "stickerType", "plugin-appbrand-integration_release"})
public final class k
  extends b
{
  private static final f rIG;
  public static final k rIH;
  
  static
  {
    AppMethodBeat.i(283955);
    rIH = new k();
    rIG = kotlin.g.ar((kotlin.g.a.a)c.rIJ);
    AppMethodBeat.o(283955);
  }
  
  private static boolean a(int paramInt, com.tencent.mm.vfs.q paramq1, String paramString, com.tencent.mm.vfs.q paramq2)
  {
    AppMethodBeat.i(283954);
    paramq2 = new com.tencent.mm.vfs.q(paramq2, paramString);
    paramString = com.tencent.mm.plugin.appbrand.jsapi.ai.c.d.pKE;
    if (com.tencent.mm.plugin.appbrand.jsapi.ai.c.d.C(paramq2))
    {
      Log.i("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, stickerItemDir(" + paramq2 + ") already exist");
      AppMethodBeat.o(283954);
      return true;
    }
    paramString = paramq1.b((z)new k.a(i.ou(0, paramInt)));
    paramq1 = paramString;
    if (paramString == null) {
      paramq1 = new com.tencent.mm.vfs.q[0];
    }
    p.j(paramq1, "itemResDir.listFiles { _…        } ?: emptyArray()");
    if (paramInt != paramq1.length)
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, can not find all res");
      AppMethodBeat.o(283954);
      return false;
    }
    if ((!paramq2.ifE()) && (!paramq2.ifL()))
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, create stickerItemDir fail");
      AppMethodBeat.o(283954);
      return false;
    }
    int i = paramq1.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramString = paramq1[paramInt];
      p.j(paramString, "itemResFile");
      Object localObject = paramString.getName();
      p.j(localObject, "itemResFile.name");
      Log.d("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, itemResName: ".concat(String.valueOf(localObject)));
      localObject = new com.tencent.mm.vfs.q(paramq2, (String)localObject);
      if (0L > u.on(paramString.bOF(), ((com.tencent.mm.vfs.q)localObject).bOF()))
      {
        Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, copy fail");
        AppMethodBeat.o(283954);
        return false;
      }
      paramInt += 1;
    }
    paramq1 = com.tencent.mm.plugin.appbrand.jsapi.ai.c.d.pKE;
    if (!com.tencent.mm.plugin.appbrand.jsapi.ai.c.d.B(paramq2))
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, record stickerItemDir fail");
      AppMethodBeat.o(283954);
      return false;
    }
    AppMethodBeat.o(283954);
    return true;
  }
  
  private static String bV(List<StickerItemInfo> paramList)
  {
    int i = 0;
    AppMethodBeat.i(283953);
    paramList = ((Collection)paramList).toArray(new StickerItemInfo[0]);
    if (paramList == null)
    {
      paramList = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(283953);
      throw paramList;
    }
    paramList = (StickerItemInfo[])paramList;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('[');
    int j = paramList.length;
    while (i < j)
    {
      ((StringBuilder)localObject).append(paramList[i].TD());
      ((StringBuilder)localObject).append(", ");
      i += 1;
    }
    ((StringBuilder)localObject).append(']');
    paramList = ((StringBuilder)localObject).toString();
    p.j(paramList, "StringBuilder().apply(builderAction).toString()");
    localObject = kotlin.n.d.UTF_8;
    if (paramList == null)
    {
      paramList = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(283953);
      throw paramList;
    }
    paramList = paramList.getBytes((Charset)localObject);
    p.j(paramList, "(this as java.lang.String).getBytes(charset)");
    paramList = com.tencent.mm.b.g.getMessageDigest(paramList);
    p.j(paramList, "MD5.getMessageDigest(ite…nfoListStr.toByteArray())");
    AppMethodBeat.o(283953);
    return paramList;
  }
  
  public final m b(m.c paramc, List<StickerItemInfo> paramList)
  {
    AppMethodBeat.i(283952);
    p.k(paramc, "type");
    p.k(paramList, "itemInfoList");
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(cqW(), bV(paramList));
    Object localObject1 = (Iterable)j.a((Iterable)paramList, (Comparator)new b());
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (StickerItemInfo)((Iterator)localObject1).next();
      if (!a(((StickerItemInfo)localObject3).frameCount, new com.tencent.mm.vfs.q(((StickerItemInfo)localObject3).cIr), ((StickerItemInfo)localObject3).name, localq))
      {
        paramc = null;
        if (paramc == null) {
          u.deleteDir(localq.bOF());
        }
        AppMethodBeat.o(283952);
        return paramc;
      }
      localObject2 = ((StickerItemInfo)localObject3).name;
      com.tencent.mm.sticker.d locald = new com.tencent.mm.sticker.d();
      locald.setName(((StickerItemInfo)localObject3).name);
      locald.fTZ = ((StickerItemInfo)localObject3).frameCount;
      locald.Vax = ((StickerItemInfo)localObject3).cIq.getJsonVal();
      if (m.c.cHr == paramc) {
        locald.Vay = ((StickerItemInfo)localObject3).cIu.getJsonVal();
      }
      for (;;)
      {
        paramList.add(s.M(localObject2, locald));
        break;
        localObject3 = ((StickerItemInfo)localObject3).cIt;
        if (localObject3 != null)
        {
          double[] arrayOfDouble = new double[4];
          arrayOfDouble[0] = ((StickerItemInfo.a)localObject3).cIv;
          arrayOfDouble[1] = ((StickerItemInfo.a)localObject3).cIw;
          arrayOfDouble[2] = ((StickerItemInfo.a)localObject3).cIx;
          arrayOfDouble[3] = ((StickerItemInfo.a)localObject3).cIy;
          p.k(arrayOfDouble, "<set-?>");
          locald.VaB = arrayOfDouble;
        }
      }
    }
    Object localObject2 = (HashMap)ae.a((Iterable)paramList, (Map)new HashMap());
    localObject1 = new e();
    ((e)localObject1).bLJ = 1.0D;
    switch (l.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      paramc = new kotlin.m();
      AppMethodBeat.o(283952);
      throw paramc;
    case 1: 
      paramList = "Sticker2D";
    }
    for (;;)
    {
      ((e)localObject1).setType(paramList);
      ((e)localObject1).v((HashMap)localObject2);
      if (m.c.cHt == paramc) {
        ((e)localObject1).a((com.tencent.mm.sticker.g)rIG.getValue());
      }
      paramList = new com.tencent.mm.vfs.q(localq, "config.json").bOF();
      p.j(paramList, "stickerConfigFile.absolutePath");
      Log.d("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "realConvert2StickerApplyParams, stickerConfigPath: ".concat(String.valueOf(paramList)));
      localObject2 = com.tencent.mm.sticker.a.Vas;
      a.a.a((com.tencent.mm.sticker.a)localObject1, paramList);
      paramList = localq.bOF();
      p.j(paramList, "stickerResDir.absolutePath");
      paramc = new m(paramc, paramList);
      break;
      paramList = "StickerFixed";
      continue;
      paramList = "Segment";
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(269083);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((StickerItemInfo)paramT1).id), (Comparable)Integer.valueOf(((StickerItemInfo)paramT2).id));
      AppMethodBeat.o(269083);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sticker/StickerTransform;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.sticker.g>
  {
    public static final c rIJ;
    
    static
    {
      AppMethodBeat.i(256081);
      rIJ = new c();
      AppMethodBeat.o(256081);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.k
 * JD-Core Version:    0.7.0.1
 */