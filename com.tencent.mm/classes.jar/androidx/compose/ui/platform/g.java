package androidx.compose.ui.platform;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import androidx.compose.ui.e.at;
import androidx.compose.ui.i.f;
import androidx.compose.ui.k.i;
import androidx.compose.ui.k.j;
import androidx.compose.ui.k.k;
import androidx.compose.ui.k.o;
import androidx.compose.ui.k.r;
import androidx.compose.ui.k.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"isPassword", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "isTextField", "accessibilityEquals", "Landroidx/compose/ui/semantics/AccessibilityAction;", "other", "", "enabled", "excludeLineAndPageGranularities", "findById", "Landroidx/compose/ui/platform/ScrollObservationScope;", "", "id", "", "findClosestParentNode", "Landroidx/compose/ui/node/LayoutNode;", "selector", "Lkotlin/Function1;", "getAllUncoveredSemanticsNodesToMap", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "hasPaneTitle", "propertiesDeleted", "oldNode", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  static final f a(f paramf, b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(206876);
    for (paramf = paramf.xu(); paramf != null; paramf = paramf.xu()) {
      if (((Boolean)paramb.invoke(paramf)).booleanValue())
      {
        AppMethodBeat.o(206876);
        return paramf;
      }
    }
    AppMethodBeat.o(206876);
    return null;
  }
  
  static final void a(Region paramRegion, o paramo1, Map<Integer, am> paramMap, o paramo2)
  {
    AppMethodBeat.i(206917);
    if (((paramRegion.isEmpty()) && (paramo2.id != paramo1.id)) || ((!paramo2.aOb.aOw) && (!paramo2.isFake)))
    {
      AppMethodBeat.o(206917);
      return;
    }
    Rect localRect = at.f(paramo2.zX());
    Object localObject = new Region();
    ((Region)localObject).set(localRect);
    int i;
    if (paramo2.id == paramo1.id)
    {
      i = -1;
      if (!((Region)localObject).op(paramRegion, (Region)localObject, Region.Op.INTERSECT)) {
        break label211;
      }
      localObject = ((Region)localObject).getBounds();
      s.s(localObject, "region.bounds");
      paramMap.put(Integer.valueOf(i), new am(paramo2, (Rect)localObject));
      paramo2 = paramo2.aA(false);
      i = paramo2.size() - 1;
      if (i < 0) {}
    }
    for (;;)
    {
      int j = i - 1;
      a(paramRegion, paramo1, paramMap, (o)paramo2.get(i));
      if (j < 0)
      {
        paramRegion.op(localRect, paramRegion, Region.Op.REVERSE_DIFFERENCE);
        AppMethodBeat.o(206917);
        return;
        i = paramo2.id;
        break;
        label211:
        if (paramo2.isFake)
        {
          paramMap.put(Integer.valueOf(i), new am(paramo2, at.f(new androidx.compose.ui.d.g(0.0F, 0.0F, 10.0F, 10.0F))));
          AppMethodBeat.o(206917);
          return;
        }
        if (i == -1)
        {
          paramRegion = ((Region)localObject).getBounds();
          s.s(paramRegion, "region.bounds");
          paramMap.put(Integer.valueOf(i), new am(paramo2, paramRegion));
        }
        AppMethodBeat.o(206917);
        return;
      }
      i = j;
    }
  }
  
  static final boolean b(o paramo, f.f paramf)
  {
    AppMethodBeat.i(206885);
    paramf = paramf.aSy.iterator();
    while (paramf.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramf.next();
      if (!paramo.Aa().b((t)localEntry.getKey()))
      {
        AppMethodBeat.o(206885);
        return true;
      }
    }
    AppMethodBeat.o(206885);
    return false;
  }
  
  static final boolean e(o paramo)
  {
    AppMethodBeat.i(206880);
    paramo = paramo.Aa();
    r localr = r.aXu;
    if (k.a(paramo, r.An()) == null)
    {
      AppMethodBeat.o(206880);
      return true;
    }
    AppMethodBeat.o(206880);
    return false;
  }
  
  static final boolean f(o paramo)
  {
    AppMethodBeat.i(206891);
    paramo = paramo.Aa();
    r localr = r.aXu;
    boolean bool = paramo.b(r.Ai());
    AppMethodBeat.o(206891);
    return bool;
  }
  
  public static final al g(List<al> paramList, int paramInt)
  {
    AppMethodBeat.i(206907);
    s.u(paramList, "<this>");
    int k = paramList.size() - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (((al)paramList.get(i)).aVa == paramInt)
      {
        paramList = (al)paramList.get(i);
        AppMethodBeat.o(206907);
        return paramList;
      }
      if (j > k)
      {
        AppMethodBeat.o(206907);
        return null;
      }
    }
  }
  
  static final boolean g(o paramo)
  {
    AppMethodBeat.i(206895);
    paramo = paramo.Aa();
    r localr = r.aXu;
    boolean bool = paramo.b(r.AB());
    AppMethodBeat.o(206895);
    return bool;
  }
  
  static final boolean h(o paramo)
  {
    AppMethodBeat.i(206902);
    paramo = paramo.aSy;
    i locali = i.aWM;
    boolean bool = paramo.b(i.zM());
    AppMethodBeat.o(206902);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/node/LayoutNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<f, Boolean>
  {
    public static final a aSE;
    
    static
    {
      AppMethodBeat.i(206544);
      aSE = new a();
      AppMethodBeat.o(206544);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.g
 * JD-Core Version:    0.7.0.1
 */