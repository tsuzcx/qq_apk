package com.tencent.mm.plugin.finder.live.view.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.protocal.protobuf.bdk;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/convert/DataUtil;", "", "()V", "getLiveId", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLiveStatus", "", "getLiveUrl", "", "getSmallResolutionLiveUrl", "isValidLiveFeed", "", "promoteTitle", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "promoting", "showNavigationBar", "Lcom/tencent/mm/protocal/protobuf/DetailPage;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveWxaPreloadCtrlInfo;", "toLocal", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowAdItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowItem;", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowProductItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "Lcom/tencent/mm/protocal/protobuf/PromotingInfo;", "plugin-finder-base_release"})
public final class a
{
  public static final a zaD;
  
  static
  {
    AppMethodBeat.i(259123);
    zaD = new a();
    AppMethodBeat.o(259123);
  }
  
  public static e a(bcq parambcq)
  {
    AppMethodBeat.i(259116);
    p.k(parambcq, "$this$toLocal");
    parambcq = new e(parambcq);
    AppMethodBeat.o(259116);
    return parambcq;
  }
  
  public static bu a(bcr parambcr)
  {
    AppMethodBeat.i(259118);
    p.k(parambcr, "$this$toLocal");
    Object localObject = parambcr.DgQ;
    if (localObject == null)
    {
      AppMethodBeat.o(259118);
      return null;
    }
    switch (parambcr.item_type)
    {
    default: 
      AppMethodBeat.o(259118);
      return null;
    case 0: 
      parambcr = (com.tencent.mm.cd.a)new blm();
      localObject = ((b)localObject).toByteArray();
      try
      {
        parambcr.parseFrom((byte[])localObject);
        parambcr = (blm)parambcr;
        if (parambcr != null)
        {
          parambcr = b(parambcr);
          parambcr = (bu)parambcr;
          AppMethodBeat.o(259118);
          return parambcr;
        }
      }
      catch (Exception parambcr)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { parambcr });
          parambcr = null;
          continue;
          parambcr = null;
        }
      }
    }
    parambcr = (com.tencent.mm.cd.a)new bcq();
    localObject = ((b)localObject).toByteArray();
    try
    {
      parambcr.parseFrom((byte[])localObject);
      parambcr = (bcq)parambcr;
      if (parambcr != null)
      {
        parambcr = a(parambcr);
        parambcr = (bu)parambcr;
        AppMethodBeat.o(259118);
        return parambcr;
      }
    }
    catch (Exception parambcr)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { parambcr });
        parambcr = null;
        continue;
        parambcr = null;
      }
    }
  }
  
  public static bu a(dou paramdou)
  {
    AppMethodBeat.i(259119);
    p.k(paramdou, "$this$toLocal");
    Object localObject = paramdou.DgQ;
    if (localObject == null)
    {
      AppMethodBeat.o(259119);
      return null;
    }
    switch (paramdou.SNi)
    {
    default: 
      AppMethodBeat.o(259119);
      return null;
    case 0: 
      paramdou = (com.tencent.mm.cd.a)new blm();
      localObject = ((b)localObject).toByteArray();
      try
      {
        paramdou.parseFrom((byte[])localObject);
        paramdou = (blm)paramdou;
        if (paramdou != null)
        {
          paramdou = b(paramdou);
          paramdou = (bu)paramdou;
          AppMethodBeat.o(259119);
          return paramdou;
        }
      }
      catch (Exception paramdou)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramdou });
          paramdou = null;
          continue;
          paramdou = null;
        }
      }
    }
    paramdou = (com.tencent.mm.cd.a)new bcq();
    localObject = ((b)localObject).toByteArray();
    try
    {
      paramdou.parseFrom((byte[])localObject);
      paramdou = (bcq)paramdou;
      if (paramdou != null)
      {
        paramdou = a(paramdou);
        paramdou = (bu)paramdou;
        AppMethodBeat.o(259119);
        return paramdou;
      }
    }
    catch (Exception paramdou)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramdou });
        paramdou = null;
        continue;
        paramdou = null;
      }
    }
  }
  
  public static boolean a(bdk parambdk)
  {
    return (parambdk != null) && (parambdk.SrY == 1);
  }
  
  public static f b(blm paramblm)
  {
    AppMethodBeat.i(259117);
    p.k(paramblm, "$this$toLocal");
    paramblm = new f(paramblm);
    AppMethodBeat.o(259117);
    return paramblm;
  }
  
  public static boolean b(ahj paramahj)
  {
    return (paramahj != null) && (paramahj.SrY == 1);
  }
  
  public static String dFL()
  {
    return "";
  }
  
  private static String f(FinderObject paramFinderObject)
  {
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.liveInfo;
      if (paramFinderObject != null)
      {
        String str = paramFinderObject.kih;
        paramFinderObject = str;
        if (str != null) {
          return paramFinderObject;
        }
      }
    }
    paramFinderObject = "";
    return paramFinderObject;
  }
  
  public static String g(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(259120);
    Object localObject3 = "";
    Object localObject1 = localObject3;
    Object localObject4;
    if (paramFinderObject != null)
    {
      localObject4 = paramFinderObject.liveInfo;
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject4 = ((bac)localObject4).SJL;
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((crw)localObject4).Tzo;
          localObject1 = localObject3;
          if (localObject4 != null)
          {
            localObject1 = (com.tencent.mm.cd.a)new crx();
            localObject4 = ((b)localObject4).toByteArray();
          }
        }
      }
    }
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject4);
      localObject4 = (crx)localObject1;
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject4 = ((crx)localObject4).Tzv;
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          j = ((crv)localObject4).Tzh;
          k = ((crv)localObject4).TyU.size();
          if (j >= 0) {
            break label252;
          }
          if (((CharSequence)localObject3).length() != 0) {
            break label323;
          }
          i = 1;
          localObject1 = localObject3;
          if (i != 0)
          {
            i = ((crv)localObject4).Tzi;
            if (i >= 0) {
              break label328;
            }
            localObject1 = localObject3;
          }
        }
      }
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
      {
        i = 1;
        if (i != 0)
        {
          Log.e("MicroMsg.Sport.PushSportTask", "FinderObject.getSmallResolutionLiveUrl fail,get live stream instead!");
          localObject1 = f(paramFinderObject);
        }
        AppMethodBeat.o(259120);
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      label323:
      label328:
      for (;;)
      {
        int j;
        int k;
        int i;
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        label252:
        if (k > j)
        {
          localObject3 = ((vj)((crv)localObject4).TyU.get(j)).url;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          if (((CharSequence)localObject2).length() > 0) {}
          for (i = 1;; i = 0)
          {
            localObject3 = localObject2;
            if (i == 0) {
              break;
            }
            AppMethodBeat.o(259120);
            return localObject2;
          }
          i = 0;
          continue;
          localObject2 = localObject3;
          if (k > i)
          {
            localObject2 = ((vj)((crv)localObject4).TyU.get(j)).url;
            localObject3 = localObject2;
            if (localObject2 == null) {
              localObject3 = "";
            }
            if (((CharSequence)localObject3).length() > 0) {}
            for (i = 1;; i = 0)
            {
              localObject2 = localObject3;
              if (i == 0) {
                break;
              }
              AppMethodBeat.o(259120);
              return localObject3;
            }
            i = 0;
          }
        }
      }
    }
  }
  
  public static long h(FinderObject paramFinderObject)
  {
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.liveInfo;
      if (paramFinderObject != null) {
        return paramFinderObject.liveId;
      }
    }
    return 0L;
  }
  
  public static int i(FinderObject paramFinderObject)
  {
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.liveInfo;
      if (paramFinderObject != null) {
        return paramFinderObject.liveStatus;
      }
    }
    return 0;
  }
  
  public static boolean j(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(259122);
    if (h(paramFinderObject) != 0L)
    {
      if (((CharSequence)f(paramFinderObject)).length() > 0)
      {
        i = 1;
        if (i == 0) {
          if (((CharSequence)g(paramFinderObject)).length() <= 0) {
            break label68;
          }
        }
      }
      label68:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label73;
        }
        AppMethodBeat.o(259122);
        return true;
        i = 0;
        break;
      }
    }
    label73:
    AppMethodBeat.o(259122);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.a
 * JD-Core Version:    0.7.0.1
 */