package androidx.compose.ui.k;

import androidx.compose.b.a.e..ExternalSyntheticBackport0;
import androidx.compose.ui.platform.af;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "()V", "isClearingSemantics", "", "()Z", "setClearingSemantics", "(Z)V", "isMergingSemanticsOfDescendants", "setMergingSemanticsOfDescendants", "props", "", "collapsePeer", "", "peer", "collapsePeer$ui_release", "contains", "T", "key", "copy", "equals", "other", "get", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "hashCode", "", "iterator", "", "mergeChild", "child", "mergeChild$ui_release", "set", "value", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Ljava/lang/Object;)V", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements u, Iterable<Map.Entry<? extends t<?>, ? extends Object>>, kotlin.g.b.a.a
{
  public static final int Ue = 8;
  public final Map<t<?>, Object> aXc;
  public boolean aXd;
  boolean aXe;
  
  public j()
  {
    AppMethodBeat.i(205472);
    this.aXc = ((Map)new LinkedHashMap());
    AppMethodBeat.o(205472);
  }
  
  public final <T> T a(t<T> paramt)
  {
    AppMethodBeat.i(205476);
    s.u(paramt, "key");
    Object localObject = this.aXc.get(paramt);
    if (localObject == null)
    {
      paramt = new IllegalStateException("Key not present: " + paramt + " - consider getOrElse or getOrNull");
      AppMethodBeat.o(205476);
      throw paramt;
    }
    AppMethodBeat.o(205476);
    return localObject;
  }
  
  public final <T> T a(t<T> paramt, kotlin.g.a.a<? extends T> parama)
  {
    AppMethodBeat.i(205481);
    s.u(paramt, "key");
    s.u(parama, "defaultValue");
    Object localObject = this.aXc.get(paramt);
    paramt = localObject;
    if (localObject == null) {
      paramt = parama.invoke();
    }
    AppMethodBeat.o(205481);
    return paramt;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(205500);
    s.u(paramj, "child");
    paramj = paramj.aXc.entrySet().iterator();
    while (paramj.hasNext())
    {
      Object localObject1 = (Map.Entry)paramj.next();
      t localt = (t)((Map.Entry)localObject1).getKey();
      localObject1 = ((Map.Entry)localObject1).getValue();
      Object localObject2 = this.aXc.get(localt);
      localObject1 = localt.aYx.invoke(localObject2, localObject1);
      if (localObject1 != null) {
        this.aXc.put(localt, localObject1);
      }
    }
    AppMethodBeat.o(205500);
  }
  
  public final <T> void a(t<T> paramt, T paramT)
  {
    AppMethodBeat.i(205491);
    s.u(paramt, "key");
    this.aXc.put(paramt, paramT);
    AppMethodBeat.o(205491);
  }
  
  public final <T> boolean b(t<T> paramt)
  {
    AppMethodBeat.i(205496);
    s.u(paramt, "key");
    boolean bool = this.aXc.containsKey(paramt);
    AppMethodBeat.o(205496);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205506);
    if (this == paramObject)
    {
      AppMethodBeat.o(205506);
      return true;
    }
    if (!(paramObject instanceof j))
    {
      AppMethodBeat.o(205506);
      return false;
    }
    if (!s.p(this.aXc, ((j)paramObject).aXc))
    {
      AppMethodBeat.o(205506);
      return false;
    }
    if (this.aXd != ((j)paramObject).aXd)
    {
      AppMethodBeat.o(205506);
      return false;
    }
    if (this.aXe != ((j)paramObject).aXe)
    {
      AppMethodBeat.o(205506);
      return false;
    }
    AppMethodBeat.o(205506);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205510);
    int i = this.aXc.hashCode();
    int j = e..ExternalSyntheticBackport0.m(this.aXd);
    int k = e..ExternalSyntheticBackport0.m(this.aXe);
    AppMethodBeat.o(205510);
    return (i * 31 + j) * 31 + k;
  }
  
  public final Iterator<Map.Entry<t<?>, Object>> iterator()
  {
    AppMethodBeat.i(205486);
    Iterator localIterator = this.aXc.entrySet().iterator();
    AppMethodBeat.o(205486);
    return localIterator;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205514);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2 = "";
    if (this.aXd)
    {
      localStringBuilder.append("");
      localStringBuilder.append("mergeDescendants=true");
      localObject2 = ", ";
    }
    Object localObject1 = localObject2;
    if (this.aXe)
    {
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("isClearingSemantics=true");
      localObject1 = ", ";
    }
    localObject2 = this.aXc.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      t localt = (t)((Map.Entry)localObject3).getKey();
      localObject3 = ((Map.Entry)localObject3).getValue();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(localt.name);
      localStringBuilder.append(" : ");
      localStringBuilder.append(localObject3);
      localObject1 = ", ";
    }
    localObject1 = af.al(this) + "{ " + localStringBuilder + " }";
    AppMethodBeat.o(205514);
    return localObject1;
  }
  
  public final j zU()
  {
    AppMethodBeat.i(205502);
    j localj = new j();
    localj.aXd = this.aXd;
    localj.aXe = this.aXe;
    localj.aXc.putAll(this.aXc);
    AppMethodBeat.o(205502);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.k.j
 * JD-Core Version:    0.7.0.1
 */