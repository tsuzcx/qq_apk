package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/Pending;", "", "keyInfos", "", "Landroidx/compose/runtime/KeyInfo;", "startIndex", "", "(Ljava/util/List;I)V", "groupIndex", "getGroupIndex", "()I", "setGroupIndex", "(I)V", "groupInfos", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupInfo;", "Lkotlin/collections/HashMap;", "getKeyInfos", "()Ljava/util/List;", "keyMap", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "getKeyMap", "()Ljava/util/HashMap;", "keyMap$delegate", "Lkotlin/Lazy;", "getStartIndex", "used", "", "getUsed", "usedKeys", "getNext", "key", "dataKey", "nodePositionOf", "keyInfo", "recordUsed", "", "registerInsert", "", "insertIndex", "registerMoveNode", "from", "to", "count", "registerMoveSlot", "slotPositionOf", "updateNodeCount", "group", "newCount", "updatedNodeCountOf", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ar
{
  final List<ah> aoA;
  int aoB;
  final List<ah> aoC;
  private final HashMap<Integer, ab> aoD;
  private final kotlin.j aoE;
  final int startIndex;
  
  public ar(List<ah> paramList, int paramInt)
  {
    AppMethodBeat.i(201937);
    this.aoA = paramList;
    this.startIndex = paramInt;
    if (this.startIndex >= 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      paramList = (Throwable)new IllegalArgumentException("Invalid start index".toString());
      AppMethodBeat.o(201937);
      throw paramList;
    }
    this.aoC = ((List)new ArrayList());
    paramList = (ar)this;
    HashMap localHashMap = new HashMap();
    int k = paramList.aoA.size();
    int i;
    if (k > 0) {
      i = 0;
    }
    int m;
    for (paramInt = 0;; paramInt = m + paramInt)
    {
      int j = i + 1;
      ah localah = (ah)paramList.aoA.get(i);
      ((Map)localHashMap).put(Integer.valueOf(localah.location), new ab(i, paramInt, localah.aoo));
      m = localah.aoo;
      if (j >= k)
      {
        this.aoD = localHashMap;
        this.aoE = k.cm((a)new a(this));
        AppMethodBeat.o(201937);
        return;
      }
      i = j;
    }
  }
  
  private HashMap<Object, LinkedHashSet<ah>> pz()
  {
    AppMethodBeat.i(201941);
    HashMap localHashMap = (HashMap)this.aoE.getValue();
    AppMethodBeat.o(201941);
    return localHashMap;
  }
  
  public final void L(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201955);
    Object localObject;
    ab localab;
    int j;
    int i;
    if (paramInt1 > paramInt2)
    {
      localObject = this.aoD.values();
      s.s(localObject, "groupInfos.values");
      localObject = ((Iterable)localObject).iterator();
      label120:
      while (((Iterator)localObject).hasNext())
      {
        localab = (ab)((Iterator)localObject).next();
        j = localab.anX;
        if (j == paramInt1)
        {
          localab.anX = paramInt2;
        }
        else
        {
          if (paramInt2 <= j) {
            if (j < paramInt1) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label120;
            }
            localab.anX = (j + 1);
            break;
            i = 0;
            continue;
            i = 0;
          }
        }
      }
      AppMethodBeat.o(201955);
      return;
    }
    if (paramInt2 > paramInt1)
    {
      localObject = this.aoD.values();
      s.s(localObject, "groupInfos.values");
      localObject = ((Iterable)localObject).iterator();
      label245:
      while (((Iterator)localObject).hasNext())
      {
        localab = (ab)((Iterator)localObject).next();
        j = localab.anX;
        if (j == paramInt1)
        {
          localab.anX = paramInt2;
        }
        else
        {
          if (paramInt1 + 1 <= j) {
            if (j < paramInt2) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label245;
            }
            localab.anX = (j - 1);
            break;
            i = 0;
            continue;
            i = 0;
          }
        }
      }
    }
    AppMethodBeat.o(201955);
  }
  
  public final boolean M(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201969);
    ab localab1 = (ab)this.aoD.get(Integer.valueOf(paramInt1));
    if (localab1 != null)
    {
      paramInt1 = localab1.alO;
      int i = paramInt2 - localab1.anY;
      localab1.anY = paramInt2;
      if (i != 0)
      {
        Object localObject = this.aoD.values();
        s.s(localObject, "groupInfos.values");
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ab localab2 = (ab)((Iterator)localObject).next();
          if ((localab2.alO >= paramInt1) && (!s.p(localab2, localab1))) {
            localab2.alO += i;
          }
        }
      }
      AppMethodBeat.o(201969);
      return true;
    }
    AppMethodBeat.o(201969);
    return false;
  }
  
  public final void a(ah paramah, int paramInt)
  {
    AppMethodBeat.i(201965);
    s.u(paramah, "keyInfo");
    ((Map)this.aoD).put(Integer.valueOf(paramah.location), new ab(-1, paramInt, 0));
    AppMethodBeat.o(201965);
  }
  
  public final boolean a(ah paramah)
  {
    AppMethodBeat.i(201948);
    s.u(paramah, "keyInfo");
    boolean bool = this.aoC.add(paramah);
    AppMethodBeat.o(201948);
    return bool;
  }
  
  public final int b(ah paramah)
  {
    AppMethodBeat.i(201973);
    s.u(paramah, "keyInfo");
    paramah = (ab)this.aoD.get(Integer.valueOf(paramah.location));
    if (paramah == null)
    {
      AppMethodBeat.o(201973);
      return -1;
    }
    int i = paramah.anX;
    AppMethodBeat.o(201973);
    return i;
  }
  
  public final int c(ah paramah)
  {
    AppMethodBeat.i(201976);
    s.u(paramah, "keyInfo");
    paramah = (ab)this.aoD.get(Integer.valueOf(paramah.location));
    if (paramah == null)
    {
      AppMethodBeat.o(201976);
      return -1;
    }
    int i = paramah.alO;
    AppMethodBeat.o(201976);
    return i;
  }
  
  public final int d(ah paramah)
  {
    AppMethodBeat.i(201978);
    s.u(paramah, "keyInfo");
    ab localab = (ab)this.aoD.get(Integer.valueOf(paramah.location));
    if (localab == null)
    {
      i = paramah.aoo;
      AppMethodBeat.o(201978);
      return i;
    }
    int i = localab.anY;
    AppMethodBeat.o(201978);
    return i;
  }
  
  public final void h(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(201961);
    Object localObject;
    ab localab;
    int j;
    int i;
    if (paramInt1 > paramInt2)
    {
      localObject = this.aoD.values();
      s.s(localObject, "groupInfos.values");
      localObject = ((Iterable)localObject).iterator();
      label157:
      while (((Iterator)localObject).hasNext())
      {
        localab = (ab)((Iterator)localObject).next();
        j = localab.alO;
        if (paramInt1 <= j) {
          if (j < paramInt1 + paramInt3) {
            i = 1;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label115;
          }
          localab.alO = (j - paramInt1 + paramInt2);
          break;
          i = 0;
          continue;
          i = 0;
        }
        label115:
        if (paramInt2 <= j) {
          if (j < paramInt1) {
            i = 1;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label157;
          }
          localab.alO = (j + paramInt3);
          break;
          i = 0;
          continue;
          i = 0;
        }
      }
      AppMethodBeat.o(201961);
      return;
    }
    if (paramInt2 > paramInt1)
    {
      localObject = this.aoD.values();
      s.s(localObject, "groupInfos.values");
      localObject = ((Iterable)localObject).iterator();
      label275:
      label319:
      while (((Iterator)localObject).hasNext())
      {
        localab = (ab)((Iterator)localObject).next();
        j = localab.alO;
        if (paramInt1 <= j) {
          if (j < paramInt1 + paramInt3) {
            i = 1;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label275;
          }
          localab.alO = (j - paramInt1 + paramInt2);
          break;
          i = 0;
          continue;
          i = 0;
        }
        if (paramInt1 + 1 <= j) {
          if (j < paramInt2) {
            i = 1;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label319;
          }
          localab.alO = (j - paramInt3);
          break;
          i = 0;
          continue;
          i = 0;
        }
      }
    }
    AppMethodBeat.o(201961);
  }
  
  public final ah k(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(201944);
    if (paramObject != null) {}
    for (paramObject = new ag(Integer.valueOf(paramInt), paramObject);; paramObject = Integer.valueOf(paramInt))
    {
      paramObject = (ah)j.a(pz(), paramObject);
      AppMethodBeat.o(201944);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/HashMap;", "", "Ljava/util/LinkedHashSet;", "Landroidx/compose/runtime/KeyInfo;", "Lkotlin/collections/LinkedHashSet;", "Lkotlin/collections/HashMap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<HashMap<Object, LinkedHashSet<ah>>>
  {
    a(ar paramar)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.ar
 * JD-Core Version:    0.7.0.1
 */