package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eum;
import com.tencent.mm.protocal.protobuf.gnd;
import com.tencent.mm.protocal.protobuf.gne;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedUsageInfo;", "", "usageInfo", "Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfo;", "(Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfo;)V", "flattenList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem;", "Lkotlin/collections/ArrayList;", "size", "", "getSize", "()I", "get", "index", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class e
{
  final int size;
  private final ArrayList<d> ujT;
  
  public e(gnd paramgnd)
  {
    AppMethodBeat.i(322864);
    this.ujT = new ArrayList();
    Object localObject1 = this.ujT;
    Object localObject2 = paramgnd.acin;
    s.s(localObject2, "usageInfo.wxa_item");
    ((ArrayList)localObject1).add(new d.a((gne)localObject2));
    localObject1 = paramgnd.acin.acip;
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (eum)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject3 = this.ujT;
          localObject4 = paramgnd.acin;
          s.s(localObject4, "usageInfo.wxa_item");
          ((ArrayList)localObject3).add(new d.d(new m((gne)localObject4, null, (eum)localObject2)));
        }
      }
    }
    localObject1 = paramgnd.acio;
    if (localObject1 != null)
    {
      localObject4 = ((Iterable)localObject1).iterator();
      label396:
      label407:
      label410:
      while (((Iterator)localObject4).hasNext())
      {
        localObject2 = (gne)((Iterator)localObject4).next();
        if (localObject2 != null)
        {
          localObject1 = ((gne)localObject2).acip;
          if (localObject1 == null)
          {
            localObject1 = null;
            label211:
            localObject3 = (Collection)localObject1;
            if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
              break label407;
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label410;
            }
            Object localObject5 = this.ujT;
            localObject3 = ((gne)localObject2).xkX;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            ((ArrayList)localObject5).add(new d.c((String)localObject2));
            this.ujT.addAll((Collection)localObject1);
            break;
            localObject1 = (Iterable)localObject1;
            localObject3 = (Collection)new ArrayList();
            localObject5 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject1 = (eum)((Iterator)localObject5).next();
              gne localgne;
              if (localObject1 != null)
              {
                localgne = paramgnd.acin;
                s.s(localgne, "usageInfo.wxa_item");
              }
              for (localObject1 = new d.d(new m(localgne, (gne)localObject2, (eum)localObject1));; localObject1 = null)
              {
                if (localObject1 == null) {
                  break label396;
                }
                ((Collection)localObject3).add(localObject1);
                break;
              }
            }
            localObject1 = (List)localObject3;
            break label211;
          }
        }
      }
    }
    this.ujT.add(d.b.ujR);
    this.size = this.ujT.size();
    AppMethodBeat.o(322864);
  }
  
  public final d Dr(int paramInt)
  {
    AppMethodBeat.i(322876);
    Object localObject = this.ujT.get(paramInt);
    s.s(localObject, "flattenList[index]");
    localObject = (d)localObject;
    AppMethodBeat.o(322876);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.e
 * JD-Core Version:    0.7.0.1
 */