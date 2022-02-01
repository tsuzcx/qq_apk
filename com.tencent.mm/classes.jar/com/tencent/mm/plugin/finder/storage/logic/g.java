package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderObjectWordingConfig;", "", "()V", "SRV_Placeholder", "", "configMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "Lkotlin/collections/HashMap;", "sameStyleSheetMap", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "getExtInfo", "type", "getSameStyleActionSheet", "appid", "getSameStyleIconUrl", "getSameStyleJumpWording", "preLoadIcon", "", "info", "url", "resetConfig", "infoList", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfoList;", "plugin-finder_release"})
public final class g
{
  private static final HashMap<String, dna> AnS;
  public static final g AnT;
  private static final HashMap<Integer, bfz> kra;
  
  static
  {
    AppMethodBeat.i(290979);
    AnT = new g();
    kra = new HashMap();
    AnS = new HashMap();
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).aHp().get(ar.a.VBO, "");
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(290979);
      throw ((Throwable)localObject);
    }
    localObject = Util.decodeHexString((String)localObject);
    bga localbga = new bga();
    localbga.parseFrom((byte[])localObject);
    a(localbga);
    AppMethodBeat.o(290979);
  }
  
  public static bfz Qt(int paramInt)
  {
    AppMethodBeat.i(290973);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dVN().aSr()).intValue() == 1) {
      paramInt = 1;
    }
    localObject = (bfz)kra.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(290973);
    return localObject;
  }
  
  public static void a(bga parambga)
  {
    AppMethodBeat.i(290977);
    p.k(parambga, "infoList");
    kra.clear();
    Object localObject1 = parambga.SQS;
    Object localObject2;
    Object localObject3;
    int i;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bfz)((Iterator)localObject1).next();
        localObject3 = (Map)kra;
        i = ((bfz)localObject2).objectType;
        p.j(localObject2, "it");
        ((Map)localObject3).put(Integer.valueOf(i), localObject2);
        localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject3 = com.tencent.mm.plugin.finder.loader.t.dJe();
        localObject4 = new com.tencent.mm.plugin.finder.loader.x(((bfz)localObject2).SQK, u.Aly);
        com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject3).a(localObject4, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
        localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject3 = com.tencent.mm.plugin.finder.loader.t.dJe();
        localObject4 = new com.tencent.mm.plugin.finder.loader.x(((bfz)localObject2).SQL, u.Aly);
        localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject3).a(localObject4, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
        localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject3 = com.tencent.mm.plugin.finder.loader.t.dJe();
        localObject4 = new com.tencent.mm.plugin.finder.loader.x(((bfz)localObject2).SQM, u.Aly);
        localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject3).a(localObject4, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
        localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject3 = com.tencent.mm.plugin.finder.loader.t.dJe();
        localObject2 = new com.tencent.mm.plugin.finder.loader.x(((bfz)localObject2).SQN, u.Aly);
        localObject4 = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject3).a(localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
      }
    }
    AnS.clear();
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dTO().aSr()).intValue() == 1)
    {
      localObject1 = AnS;
      localObject2 = new dna();
      ((dna)localObject2).TUn = "https://miaojian.weixin.qq.com/download/apps?channel=1104";
      ((dna)localObject2).TUo = "com.tencent.phoenix";
      ((dna)localObject2).TUm = "miaojian://createVideo?scene=channels&from=channels-samestyle&miaojianExtInfo=";
      ((dna)localObject2).TUp = "A24DC0755072F64C480DC06DCD3412BF";
      ((dna)localObject2).TUl = "https://apps.apple.com/app/apple-store/id1530922601?pt=69276&ct=channels1&mt=8";
      ((dna)localObject2).desc = null;
      ((dna)localObject2).icon = "http://dldir1.qq.com/weixin/checkresupdate/outlined_miaojian_658e3fe317814fc8a1c209e9a5937e01.png";
      ((dna)localObject2).title = "秒剪做同款";
      ((dna)localObject2).type = 0;
      ((dna)localObject2).TUk = "https://v.vuevideo.net/vfromwx/createvideo?scene=channels";
      ((dna)localObject2).value = "wxa5e0de08d96cc09d";
      ((dna)localObject2).TUq = "http://dldir1.qq.com/weixin/checkresupdate/outlined_miaojian_dark_6b87f03b481440249680c17b73dac97b.png";
      ((HashMap)localObject1).put("wxa5e0de08d96cc09d", localObject2);
    }
    localObject1 = parambga.SQW;
    if (localObject1 != null)
    {
      localObject1 = ((dnb)localObject1).TUr;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        label522:
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dna)((Iterator)localObject1).next();
          localObject3 = ((dna)localObject2).value;
          localObject4 = (CharSequence)localObject3;
          if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label522;
            }
            localObject4 = (Map)AnS;
            p.j(localObject2, "sheet");
            ((Map)localObject4).put(localObject3, localObject2);
            aEZ(((dna)localObject2).icon);
            aEZ(((dna)localObject2).TUq);
            break;
          }
        }
      }
    }
    com.tencent.mm.ae.d.c("FinderObjectWordingConfig", (a)new a(parambga));
    AppMethodBeat.o(290977);
  }
  
  public static dna aEW(String paramString)
  {
    AppMethodBeat.i(290974);
    p.k(paramString, "appid");
    paramString = (dna)AnS.get(paramString);
    AppMethodBeat.o(290974);
    return paramString;
  }
  
  public static String aEX(String paramString)
  {
    AppMethodBeat.i(290975);
    p.k(paramString, "appid");
    String str;
    if (ar.isDarkMode())
    {
      paramString = (dna)AnS.get(paramString);
      if (paramString != null)
      {
        str = paramString.TUq;
        paramString = str;
        if (str != null) {}
      }
      else
      {
        AppMethodBeat.o(290975);
        return "";
      }
    }
    else
    {
      paramString = (dna)AnS.get(paramString);
      if (paramString != null)
      {
        str = paramString.icon;
        paramString = str;
        if (str != null) {}
      }
      else
      {
        paramString = "";
      }
    }
    AppMethodBeat.o(290975);
    return paramString;
  }
  
  public static String aEY(String paramString)
  {
    AppMethodBeat.i(290976);
    p.k(paramString, "appid");
    paramString = (dna)AnS.get(paramString);
    if (paramString != null)
    {
      String str = paramString.title;
      paramString = str;
      if (str != null) {}
    }
    else
    {
      paramString = "";
    }
    AppMethodBeat.o(290976);
    return paramString;
  }
  
  private static void aEZ(String paramString)
  {
    AppMethodBeat.i(290978);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject = com.tencent.mm.plugin.finder.loader.t.dJe();
        paramString = new com.tencent.mm.plugin.finder.loader.x(paramString, u.Aly);
        com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject).a(paramString, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
      }
      AppMethodBeat.o(290978);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<kotlin.x>
  {
    a(bga parambga)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.g
 * JD-Core Version:    0.7.0.1
 */