package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.protocal.protobuf.efp;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderObjectWordingConfig;", "", "()V", "SRV_Placeholder", "", "configMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "Lkotlin/collections/HashMap;", "extInfoList", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfoList;", "getExtInfoList", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfoList;", "images", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDynamicImage;", "getImages", "()Ljava/util/LinkedList;", "setImages", "(Ljava/util/LinkedList;)V", "sameStyleSheetMap", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "getExtInfo", "type", "getSameStyleActionSheet", "appid", "getSameStyleIconUrl", "getSameStyleJumpWording", "preLoadIcon", "", "info", "url", "resetConfig", "infoList", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h FNM;
  private static final HashMap<String, efo> FNN;
  private static final brl FNO;
  private static final HashMap<Integer, brk> mUV;
  private static LinkedList<bre> msn;
  
  static
  {
    AppMethodBeat.i(339537);
    FNM = new h();
    mUV = new HashMap();
    msn = new LinkedList();
    FNN = new HashMap();
    FNO = new brl();
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adek, "");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(339537);
      throw ((Throwable)localObject);
    }
    localObject = Util.decodeHexString((String)localObject);
    FNO.parseFrom((byte[])localObject);
    a(FNO);
    AppMethodBeat.o(339537);
  }
  
  public static brk TA(int paramInt)
  {
    AppMethodBeat.i(339483);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eUp().bmg()).intValue() == 1) {
      paramInt = 1;
    }
    localObject = (brk)mUV.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(339483);
    return localObject;
  }
  
  public static void a(brl parambrl)
  {
    AppMethodBeat.i(339520);
    kotlin.g.b.s.u(parambrl, "infoList");
    mUV.clear();
    Object localObject1 = parambrl.ZZF;
    Object localObject3;
    int i;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (brk)((Iterator)localObject1).next();
        localObject3 = (Map)mUV;
        i = ((brk)localObject2).objectType;
        kotlin.g.b.s.s(localObject2, "it");
        ((Map)localObject3).put(Integer.valueOf(i), localObject2);
        localObject3 = p.ExI;
        localObject3 = p.eCl();
        localObject4 = new com.tencent.mm.plugin.finder.loader.s(((brk)localObject2).ZZx, v.FKY);
        p localp = p.ExI;
        ((com.tencent.mm.loader.d)localObject3).a(localObject4, p.a(p.a.ExJ));
        localObject3 = p.ExI;
        localObject3 = p.eCl();
        localObject4 = new com.tencent.mm.plugin.finder.loader.s(((brk)localObject2).ZZy, v.FKY);
        localp = p.ExI;
        ((com.tencent.mm.loader.d)localObject3).a(localObject4, p.a(p.a.ExJ));
        localObject3 = p.ExI;
        localObject3 = p.eCl();
        localObject4 = new com.tencent.mm.plugin.finder.loader.s(((brk)localObject2).ZZz, v.FKY);
        localp = p.ExI;
        ((com.tencent.mm.loader.d)localObject3).a(localObject4, p.a(p.a.ExJ));
        localObject3 = p.ExI;
        localObject3 = p.eCl();
        localObject2 = new com.tencent.mm.plugin.finder.loader.s(((brk)localObject2).ZZA, v.FKY);
        localObject4 = p.ExI;
        ((com.tencent.mm.loader.d)localObject3).a(localObject2, p.a(p.a.ExJ));
      }
    }
    Object localObject2 = parambrl.msn;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new LinkedList();
    }
    msn = (LinkedList)localObject1;
    FNN.clear();
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eSf().bmg()).intValue() == 1)
    {
      localObject1 = FNN;
      localObject2 = new efo();
      ((efo)localObject2).abkX = "https://miaojian.weixin.qq.com/download/apps?channel=1104";
      ((efo)localObject2).abkY = "com.tencent.phoenix";
      ((efo)localObject2).abkW = "miaojian://createVideo?scene=channels&from=channels-samestyle&miaojianExtInfo=";
      ((efo)localObject2).abkZ = "A24DC0755072F64C480DC06DCD3412BF";
      ((efo)localObject2).abkV = "https://apps.apple.com/app/apple-store/id1530922601?pt=69276&ct=channels1&mt=8";
      ((efo)localObject2).desc = null;
      ((efo)localObject2).icon = "http://dldir1.qq.com/weixin/checkresupdate/outlined_miaojian_658e3fe317814fc8a1c209e9a5937e01.png";
      ((efo)localObject2).title = "秒剪做同款";
      ((efo)localObject2).type = 0;
      ((efo)localObject2).abkU = "https://v.vuevideo.net/vfromwx/createvideo?scene=channels";
      ((efo)localObject2).value = "wxa5e0de08d96cc09d";
      ((efo)localObject2).abla = "http://dldir1.qq.com/weixin/checkresupdate/outlined_miaojian_dark_6b87f03b481440249680c17b73dac97b.png";
      localObject3 = ah.aiuX;
      ((HashMap)localObject1).put("wxa5e0de08d96cc09d", localObject2);
    }
    localObject1 = parambrl.ZZJ;
    if (localObject1 != null)
    {
      localObject1 = ((efp)localObject1).ablb;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        label550:
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (efo)((Iterator)localObject1).next();
          localObject3 = ((efo)localObject2).value;
          localObject4 = (CharSequence)localObject3;
          if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label550;
            }
            localObject4 = (Map)FNN;
            kotlin.g.b.s.s(localObject2, "sheet");
            ((Map)localObject4).put(localObject3, localObject2);
            aAS(((efo)localObject2).icon);
            aAS(((efo)localObject2).abla);
            break;
          }
        }
      }
    }
    com.tencent.mm.ae.d.e("FinderObjectWordingConfig", (a)new h.a(parambrl));
    AppMethodBeat.o(339520);
  }
  
  public static efo aAP(String paramString)
  {
    AppMethodBeat.i(339491);
    kotlin.g.b.s.u(paramString, "appid");
    paramString = (efo)FNN.get(paramString);
    AppMethodBeat.o(339491);
    return paramString;
  }
  
  public static String aAQ(String paramString)
  {
    AppMethodBeat.i(339498);
    kotlin.g.b.s.u(paramString, "appid");
    if (aw.isDarkMode())
    {
      paramString = (efo)FNN.get(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(339498);
        return "";
      }
      paramString = paramString.abla;
      if (paramString == null)
      {
        AppMethodBeat.o(339498);
        return "";
      }
      AppMethodBeat.o(339498);
      return paramString;
    }
    paramString = (efo)FNN.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(339498);
      return "";
    }
    paramString = paramString.icon;
    if (paramString == null)
    {
      AppMethodBeat.o(339498);
      return "";
    }
    AppMethodBeat.o(339498);
    return paramString;
  }
  
  public static String aAR(String paramString)
  {
    AppMethodBeat.i(339502);
    kotlin.g.b.s.u(paramString, "appid");
    paramString = (efo)FNN.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(339502);
      return "";
    }
    paramString = paramString.title;
    if (paramString == null)
    {
      AppMethodBeat.o(339502);
      return "";
    }
    AppMethodBeat.o(339502);
    return paramString;
  }
  
  private static void aAS(String paramString)
  {
    AppMethodBeat.i(339527);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = p.ExI;
        localObject = p.eCl();
        paramString = new com.tencent.mm.plugin.finder.loader.s(paramString, v.FKY);
        p localp = p.ExI;
        ((com.tencent.mm.loader.d)localObject).a(paramString, p.a(p.a.ExJ));
      }
      AppMethodBeat.o(339527);
      return;
    }
  }
  
  public static LinkedList<bre> fat()
  {
    return msn;
  }
  
  public static brl fau()
  {
    return FNO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.h
 * JD-Core Version:    0.7.0.1
 */