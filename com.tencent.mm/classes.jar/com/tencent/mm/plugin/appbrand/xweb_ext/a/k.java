package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.StickerBackType;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.TriggerAction;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.a.a;
import com.tencent.mm.sticker.e;
import com.tencent.mm.vfs.y;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;>;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.n.n;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyAdapterCoreLogic;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseResApplyAdapterCoreLogic;", "()V", "STICKER_ELEMENT_RES_NAME_DELIMITER", "", "STICKER_ELEMENT_RES_NAME_DELIMITER_2", "STICKER_ELEMENT_RES_NAME_SUFFIX", "", "TAG", "stickerTransform", "Lcom/tencent/mm/sticker/StickerTransform;", "getStickerTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "stickerTransform$delegate", "Lkotlin/Lazy;", "convert2StickerApplyParams", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyParams;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "itemInfoList", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "copyStickerItemResourcesIfNeed", "", "itemResCount", "", "itemResDir", "Lcom/tencent/mm/vfs/VFSFile;", "itemName", "stickerResDir", "generateStickerResDirName", "realConvert2StickerApplyParams", "stickerType", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends b
{
  public static final k uTX;
  private static final j uTY;
  
  static
  {
    AppMethodBeat.i(317166);
    uTX = new k();
    uTY = kotlin.k.cm((kotlin.g.a.a)c.uTZ);
    AppMethodBeat.o(317166);
  }
  
  private static boolean a(int paramInt, com.tencent.mm.vfs.u paramu1, String paramString, com.tencent.mm.vfs.u paramu2)
  {
    AppMethodBeat.i(317143);
    paramu2 = new com.tencent.mm.vfs.u(paramu2, paramString);
    paramString = com.tencent.mm.plugin.appbrand.jsapi.al.c.d.sPx;
    if (com.tencent.mm.plugin.appbrand.jsapi.al.c.d.C(paramu2))
    {
      Log.i("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, stickerItemDir(" + paramu2 + ") already exist");
      AppMethodBeat.o(317143);
      return true;
    }
    paramString = paramu1.b(new k..ExternalSyntheticLambda0(kotlin.k.k.qt(0, paramInt)));
    paramu1 = paramString;
    if (paramString == null) {
      paramu1 = (com.tencent.mm.vfs.u[])new com.tencent.mm.vfs.u[0];
    }
    if (paramInt != paramu1.length)
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, can not find all res");
      AppMethodBeat.o(317143);
      return false;
    }
    if ((!paramu2.jKS()) && (!paramu2.jKY()))
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, create stickerItemDir fail");
      AppMethodBeat.o(317143);
      return false;
    }
    int i = paramu1.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramString = paramu1[paramInt];
      Object localObject = paramString.getName();
      s.s(localObject, "itemResFile.name");
      Log.d("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", s.X("copyStickerItemResourcesIfNeed, itemResName: ", localObject));
      localObject = new com.tencent.mm.vfs.u(paramu2, (String)localObject);
      if (0L > y.O(com.tencent.mm.vfs.ah.v(paramString.jKT()), com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)localObject).jKT()), false))
      {
        Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, copy fail");
        AppMethodBeat.o(317143);
        return false;
      }
      paramInt += 1;
    }
    paramu1 = com.tencent.mm.plugin.appbrand.jsapi.al.c.d.sPx;
    if (!com.tencent.mm.plugin.appbrand.jsapi.al.c.d.B(paramu2))
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, record stickerItemDir fail");
      AppMethodBeat.o(317143);
      return false;
    }
    AppMethodBeat.o(317143);
    return true;
  }
  
  private static final boolean a(kotlin.k.g paramg, com.tencent.mm.vfs.u paramu, String paramString)
  {
    AppMethodBeat.i(317161);
    s.u(paramg, "$range");
    s.u(paramString, "name");
    paramu = n.a((CharSequence)paramString, new char[] { '.' }, 0, 6);
    if ((2 > paramu.size()) || (!s.p("png", kotlin.a.p.oM(paramu))))
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", s.X("copyStickerItemResourcesIfNeed, invalid res: ", paramString));
      AppMethodBeat.o(317161);
      return false;
    }
    paramu = n.a((CharSequence)paramu.get(0), new char[] { '_' }, 0, 6);
    Object localObject = ((Collection)paramu).toArray(new String[0]);
    if (localObject == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(317161);
      throw paramg;
    }
    localObject = Arrays.toString((Object[])localObject);
    s.s(localObject, "java.util.Arrays.toString(this)");
    Log.d("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", s.X("copyStickerItemResourcesIfNeed, nameList2: ", localObject));
    if (2 > paramu.size())
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", s.X("copyStickerItemResourcesIfNeed, invalid res: ", paramString));
      AppMethodBeat.o(317161);
      return false;
    }
    paramu = n.bJF((String)kotlin.a.p.oM(paramu));
    if ((paramu != null) && (paramg.aKs(paramu.intValue())))
    {
      AppMethodBeat.o(317161);
      return true;
    }
    AppMethodBeat.o(317161);
    return false;
  }
  
  private static String dN(List<StickerItemInfo> paramList)
  {
    int i = 0;
    AppMethodBeat.i(317126);
    paramList = ((Collection)paramList).toArray(new StickerItemInfo[0]);
    if (paramList == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(317126);
      throw paramList;
    }
    paramList = (StickerItemInfo[])paramList;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('[');
    int j = paramList.length;
    while (i < j)
    {
      ((StringBuilder)localObject).append(paramList[i].aui());
      ((StringBuilder)localObject).append(", ");
      i += 1;
    }
    ((StringBuilder)localObject).append(']');
    paramList = ((StringBuilder)localObject).toString();
    s.s(paramList, "StringBuilder().apply(builderAction).toString()");
    localObject = kotlin.n.d.UTF_8;
    if (paramList == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(317126);
      throw paramList;
    }
    paramList = paramList.getBytes((Charset)localObject);
    s.s(paramList, "(this as java.lang.String).getBytes(charset)");
    paramList = com.tencent.mm.b.g.getMessageDigest(paramList);
    s.s(paramList, "getMessageDigest(itemInfoListStr.toByteArray())");
    AppMethodBeat.o(317126);
    return paramList;
  }
  
  public final l b(o.c paramc, List<StickerItemInfo> paramList)
  {
    AppMethodBeat.i(317172);
    s.u(paramc, "type");
    s.u(paramList, "itemInfoList");
    com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u(cTD(), dN(paramList));
    Object localObject1 = (Iterable)kotlin.a.p.a((Iterable)paramList, (Comparator)new k.b());
    paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (StickerItemInfo)((Iterator)localObject1).next();
      if (!a(((StickerItemInfo)localObject3).frameCount, new com.tencent.mm.vfs.u(((StickerItemInfo)localObject3).eBX), ((StickerItemInfo)localObject3).name, localu))
      {
        paramc = null;
        if (paramc == null) {
          y.ew(com.tencent.mm.vfs.ah.v(localu.jKT()), true);
        }
        AppMethodBeat.o(317172);
        return paramc;
      }
      localObject2 = ((StickerItemInfo)localObject3).name;
      com.tencent.mm.sticker.d locald = new com.tencent.mm.sticker.d();
      locald.setName(((StickerItemInfo)localObject3).name);
      locald.len = ((StickerItemInfo)localObject3).frameCount;
      locald.acBQ = ((StickerItemInfo)localObject3).eBW.getJsonVal();
      if (o.c.eAO == paramc) {
        locald.acBR = ((StickerItemInfo)localObject3).eCa.getJsonVal();
      }
      for (;;)
      {
        localObject3 = kotlin.ah.aiuX;
        paramList.add(v.Y(localObject2, locald));
        break;
        localObject3 = ((StickerItemInfo)localObject3).eBZ;
        if (localObject3 != null)
        {
          double[] arrayOfDouble = new double[4];
          arrayOfDouble[0] = ((StickerItemInfo.a)localObject3).eCb;
          arrayOfDouble[1] = ((StickerItemInfo.a)localObject3).eCc;
          arrayOfDouble[2] = ((StickerItemInfo.a)localObject3).eCd;
          arrayOfDouble[3] = ((StickerItemInfo.a)localObject3).eCe;
          s.u(arrayOfDouble, "<set-?>");
          locald.acBU = arrayOfDouble;
        }
      }
    }
    Object localObject2 = (HashMap)ak.a((Iterable)paramList, (Map)new HashMap());
    localObject1 = new e();
    ((e)localObject1).dFr = 1.0D;
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      paramc = new kotlin.p();
      AppMethodBeat.o(317172);
      throw paramc;
    case 1: 
      paramList = "Sticker2D";
    }
    for (;;)
    {
      ((e)localObject1).setType(paramList);
      ((e)localObject1).y((HashMap)localObject2);
      if (o.c.eAQ == paramc) {
        ((e)localObject1).a((com.tencent.mm.sticker.g)uTY.getValue());
      }
      paramList = com.tencent.mm.vfs.ah.v(new com.tencent.mm.vfs.u(localu, "config.json").jKT());
      s.s(paramList, "stickerConfigFile.absolutePath");
      Log.d("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", s.X("realConvert2StickerApplyParams, stickerConfigPath: ", paramList));
      localObject2 = com.tencent.mm.sticker.a.acBM;
      a.a.a((com.tencent.mm.sticker.a)localObject1, paramList);
      localObject1 = y.n(com.tencent.mm.vfs.ah.v(localu.jKT()), false);
      paramList = (List<StickerItemInfo>)localObject1;
      if (localObject1 == null) {
        paramList = "";
      }
      paramc = new l(paramc, paramList);
      break;
      paramList = "StickerFixed";
      continue;
      paramList = "Segment";
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sticker/StickerTransform;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.sticker.g>
  {
    public static final c uTZ;
    
    static
    {
      AppMethodBeat.i(317129);
      uTZ = new c();
      AppMethodBeat.o(317129);
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