package androidx.compose.ui.platform.a;

import androidx.compose.ui.d.e;
import androidx.compose.ui.d.f;
import androidx.compose.ui.d.g;
import androidx.compose.ui.k.b;
import androidx.compose.ui.k.c;
import androidx.compose.ui.k.j;
import androidx.compose.ui.k.k;
import androidx.compose.ui.k.o;
import androidx.compose.ui.k.r;
import androidx.core.g.a.d;
import androidx.core.g.a.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"isLazyCollection", "", "Landroidx/compose/ui/semantics/CollectionInfo;", "(Landroidx/compose/ui/semantics/CollectionInfo;)Z", "calculateIfHorizontallyStacked", "items", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "setCollectionInfo", "", "node", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "setCollectionItemInfo", "toAccessibilityCollectionInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionInfoCompat;", "kotlin.jvm.PlatformType", "toAccessibilityCollectionItemInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionItemInfoCompat;", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "itemNode", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final boolean S(List<o> paramList)
  {
    AppMethodBeat.i(206872);
    if (((Collection)paramList).size() < 2)
    {
      AppMethodBeat.o(206872);
      return true;
    }
    long l;
    List localList;
    Object localObject1;
    int k;
    int i;
    if ((paramList.size() == 0) || (paramList.size() == 1))
    {
      paramList = (List)ab.aivy;
      if (((Collection)paramList).size() == 1)
      {
        l = ((e)p.oK(paramList)).avp;
        float f = e.K(l);
        if (e.L(l) >= f) {
          break label334;
        }
        AppMethodBeat.o(206872);
        return true;
      }
    }
    else
    {
      localList = (List)new ArrayList();
      localObject1 = paramList.get(0);
      k = p.oE(paramList);
      if (k > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      int j = i + 1;
      Object localObject2 = paramList.get(i + 1);
      o localo = (o)localObject2;
      localObject1 = (o)localObject1;
      localList.add(e.N(f.x(Math.abs(e.F(((o)localObject1).zX().sx()) - e.F(localo.zX().sx())), Math.abs(e.G(((o)localObject1).zX().sx()) - e.G(localo.zX().sx())))));
      if (j >= k)
      {
        paramList = localList;
        break;
        if (paramList.isEmpty())
        {
          paramList = new UnsupportedOperationException("Empty collection can't be reduced.");
          AppMethodBeat.o(206872);
          throw paramList;
        }
        localObject1 = p.oK(paramList);
        j = p.oE(paramList);
        if (j > 0)
        {
          i = 1;
          label283:
          l = ((e)paramList.get(i)).avp;
          localObject1 = e.N(e.g(((e)localObject1).avp, l));
          if (i != j) {}
        }
        for (;;)
        {
          l = ((e)localObject1).avp;
          break;
          label334:
          AppMethodBeat.o(206872);
          return false;
          i += 1;
          break label283;
        }
      }
      i = j;
      localObject1 = localObject2;
    }
  }
  
  public static final void a(o paramo, d paramd)
  {
    AppMethodBeat.i(206862);
    s.u(paramo, "node");
    s.u(paramd, "info");
    Object localObject1 = paramo.Aa();
    Object localObject2 = r.aXu;
    if ((c)k.a((j)localObject1, r.Al()) != null)
    {
      AppMethodBeat.o(206862);
      throw null;
    }
    localObject1 = paramo.Ac();
    if (localObject1 == null)
    {
      AppMethodBeat.o(206862);
      return;
    }
    localObject2 = ((o)localObject1).Aa();
    Object localObject3 = r.aXu;
    int k;
    if (k.a((j)localObject2, r.Aj()) != null)
    {
      localObject2 = ((o)localObject1).Aa();
      localObject3 = r.aXu;
      localObject2 = (b)k.a((j)localObject2, r.Ak());
      if (localObject2 != null)
      {
        if ((((b)localObject2).rowCount < 0) || (((b)localObject2).columnCount < 0)) {}
        for (i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(206862);
          return;
        }
      }
      localObject2 = paramo.Aa();
      localObject3 = r.aXu;
      if (!((j)localObject2).b(r.Az()))
      {
        AppMethodBeat.o(206862);
        return;
      }
      localObject2 = (List)new ArrayList();
      localObject1 = ((o)localObject1).aA(false);
      k = ((List)localObject1).size() - 1;
      if (k < 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localObject3 = (o)((List)localObject1).get(i);
      Object localObject4 = ((o)localObject3).Aa();
      r localr = r.aXu;
      if (((j)localObject4).b(r.Az())) {
        ((List)localObject2).add(localObject3);
      }
      if (j > k)
      {
        int m;
        if (!((Collection)localObject2).isEmpty())
        {
          i = 1;
          if (i != 0)
          {
            boolean bool = S((List)localObject2);
            m = ((List)localObject2).size() - 1;
            if (m >= 0)
            {
              i = 0;
              label318:
              k = i + 1;
              localObject1 = (o)((List)localObject2).get(i);
              if (((o)localObject1).id == paramo.id)
              {
                if (!bool) {
                  break label474;
                }
                j = 0;
                label355:
                if (!bool) {
                  break label479;
                }
                label360:
                localObject1 = ((o)localObject1).Aa();
                localObject3 = r.aXu;
                localObject4 = r.Az();
                localObject3 = (kotlin.g.a.a)a.a.aWf;
                s.u(localObject4, "key");
                s.u(localObject3, "defaultValue");
                localObject1 = ((j)localObject1).aXc.get(localObject4);
                if (localObject1 != null) {
                  break label490;
                }
                localObject1 = ((kotlin.g.a.a)localObject3).invoke();
              }
            }
          }
        }
        label474:
        label479:
        label490:
        for (;;)
        {
          localObject1 = d.c.a(j, 1, i, 1, false, ((Boolean)localObject1).booleanValue());
          if (localObject1 != null) {
            paramd.aC(localObject1);
          }
          if (k > m)
          {
            AppMethodBeat.o(206862);
            return;
            i = 0;
            break;
            j = i;
            break label355;
            i = 0;
            break label360;
          }
          i = k;
          break label318;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.a.a
 * JD-Core Version:    0.7.0.1
 */