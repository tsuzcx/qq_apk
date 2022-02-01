package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/SlotReader;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "<set-?>", "", "currentEnd", "getCurrentEnd", "()I", "currentGroup", "getCurrentGroup", "currentSlot", "currentSlotEnd", "emptyCount", "groupAux", "getGroupAux", "()Ljava/lang/Object;", "groupEnd", "getGroupEnd", "groupKey", "getGroupKey", "groupNode", "getGroupNode", "groupObjectKey", "getGroupObjectKey", "groupSize", "getGroupSize", "groupSlotCount", "getGroupSlotCount", "groupSlotIndex", "getGroupSlotIndex", "groups", "", "groupsSize", "inEmpty", "", "getInEmpty", "()Z", "isGroupEnd", "isNode", "nodeCount", "getNodeCount", "parent", "getParent", "parentNodes", "getParentNodes", "size", "getSize", "slot", "getSlot", "slots", "", "[Ljava/lang/Object;", "slotsSize", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "index", "beginEmpty", "", "close", "endEmpty", "endGroup", "extractKeys", "", "Landroidx/compose/runtime/KeyInfo;", "get", "groupGet", "hasObjectKey", "next", "node", "parentOf", "reposition", "restoreParent", "skipGroup", "skipToGroupEnd", "startGroup", "startNode", "aux", "objectKey", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bd
{
  final be anZ;
  final int[] apB;
  final int apC;
  private final Object[] apD;
  private final int apE;
  int apF;
  int apG;
  int apH;
  int apI;
  int emptyCount;
  int parent;
  
  public bd(be parambe)
  {
    AppMethodBeat.i(201996);
    this.anZ = parambe;
    this.apB = this.anZ.apB;
    this.apC = this.anZ.apC;
    this.apD = this.anZ.apD;
    this.apE = this.anZ.apE;
    this.apG = this.apC;
    this.parent = -1;
    AppMethodBeat.o(201996);
  }
  
  private final Object c(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(202001);
    if (bf.f(paramArrayOfInt, paramInt))
    {
      paramArrayOfInt = this.apD[paramArrayOfInt[(paramInt * 5 + 4)]];
      AppMethodBeat.o(202001);
      return paramArrayOfInt;
    }
    paramArrayOfInt = h.alD;
    paramArrayOfInt = h.a.ox();
    AppMethodBeat.o(202001);
    return paramArrayOfInt;
  }
  
  private final Object d(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(202007);
    if (bf.i(paramArrayOfInt, paramInt))
    {
      paramArrayOfInt = this.apD[bf.j(paramArrayOfInt, paramInt)];
      AppMethodBeat.o(202007);
      return paramArrayOfInt;
    }
    paramArrayOfInt = h.alD;
    paramArrayOfInt = h.a.ox();
    AppMethodBeat.o(202007);
    return paramArrayOfInt;
  }
  
  private final Object e(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(202013);
    if (bf.g(paramArrayOfInt, paramInt))
    {
      paramArrayOfInt = this.apD[bf.h(paramArrayOfInt, paramInt)];
      AppMethodBeat.o(202013);
      return paramArrayOfInt;
    }
    AppMethodBeat.o(202013);
    return null;
  }
  
  public final int bG(int paramInt)
  {
    return this.apB[(paramInt * 5 + 2)];
  }
  
  public final boolean bH(int paramInt)
  {
    AppMethodBeat.i(202024);
    boolean bool = bf.f(this.apB, paramInt);
    AppMethodBeat.o(202024);
    return bool;
  }
  
  public final int bI(int paramInt)
  {
    AppMethodBeat.i(202029);
    paramInt = bf.l(this.apB, paramInt);
    AppMethodBeat.o(202029);
    return paramInt;
  }
  
  public final Object bJ(int paramInt)
  {
    AppMethodBeat.i(202032);
    if (bf.f(this.apB, paramInt))
    {
      Object localObject = c(this.apB, paramInt);
      AppMethodBeat.o(202032);
      return localObject;
    }
    AppMethodBeat.o(202032);
    return null;
  }
  
  public final int bK(int paramInt)
  {
    return this.apB[(paramInt * 5 + 3)];
  }
  
  public final int bL(int paramInt)
  {
    return this.apB[(paramInt * 5)];
  }
  
  public final boolean bM(int paramInt)
  {
    AppMethodBeat.i(202091);
    boolean bool = bf.g(this.apB, paramInt);
    AppMethodBeat.o(202091);
    return bool;
  }
  
  public final Object bN(int paramInt)
  {
    AppMethodBeat.i(202108);
    Object localObject = e(this.apB, paramInt);
    AppMethodBeat.o(202108);
    return localObject;
  }
  
  public final Object bO(int paramInt)
  {
    AppMethodBeat.i(202123);
    Object localObject = d(this.apB, paramInt);
    AppMethodBeat.o(202123);
    return localObject;
  }
  
  public final Object bP(int paramInt)
  {
    AppMethodBeat.i(202136);
    int i = this.apF;
    int j = bf.k(this.apB, i);
    i += 1;
    if (i < this.apC) {}
    for (i = this.apB[(i * 5 + 4)];; i = this.apE)
    {
      paramInt = j + paramInt;
      if (paramInt >= i) {
        break;
      }
      localObject = this.apD[paramInt];
      AppMethodBeat.o(202136);
      return localObject;
    }
    Object localObject = h.alD;
    localObject = h.a.ox();
    AppMethodBeat.o(202136);
    return localObject;
  }
  
  public final void bQ(int paramInt)
  {
    AppMethodBeat.i(202191);
    if (this.emptyCount == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Cannot reposition while in an empty region".toString());
      AppMethodBeat.o(202191);
      throw localThrowable;
    }
    this.apF = paramInt;
    if (paramInt < this.apC)
    {
      paramInt = this.apB[(paramInt * 5 + 2)];
      this.parent = paramInt;
      if (paramInt >= 0) {
        break label108;
      }
    }
    label108:
    for (this.apG = this.apC;; this.apG = (paramInt + this.apB[(paramInt * 5 + 3)]))
    {
      this.apH = 0;
      this.apI = 0;
      AppMethodBeat.o(202191);
      return;
      paramInt = -1;
      break;
    }
  }
  
  public final c bR(int paramInt)
  {
    AppMethodBeat.i(202216);
    Object localObject = this.anZ.apL;
    int i = bf.b((ArrayList)localObject, paramInt, this.apC);
    if (i < 0)
    {
      c localc = new c(paramInt);
      ((ArrayList)localObject).add(-(i + 1), localc);
      AppMethodBeat.o(202216);
      return localc;
    }
    localObject = ((ArrayList)localObject).get(i);
    s.s(localObject, "get(location)");
    localObject = (c)localObject;
    AppMethodBeat.o(202216);
    return localObject;
  }
  
  public final void close()
  {
    AppMethodBeat.i(202162);
    this.anZ.a(this);
    AppMethodBeat.o(202162);
  }
  
  public final Object next()
  {
    AppMethodBeat.i(202144);
    if ((this.emptyCount > 0) || (this.apH >= this.apI))
    {
      localObject = h.alD;
      localObject = h.a.ox();
      AppMethodBeat.o(202144);
      return localObject;
    }
    Object localObject = this.apD;
    int i = this.apH;
    this.apH = (i + 1);
    localObject = localObject[i];
    AppMethodBeat.o(202144);
    return localObject;
  }
  
  public final void oi()
  {
    AppMethodBeat.i(202185);
    if (this.emptyCount == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Cannot skip the enclosing group while in an empty region".toString());
      AppMethodBeat.o(202185);
      throw localThrowable;
    }
    this.apF = this.apG;
    AppMethodBeat.o(202185);
  }
  
  public final boolean pI()
  {
    AppMethodBeat.i(202038);
    if ((pJ()) || (this.apF == this.apG))
    {
      AppMethodBeat.o(202038);
      return true;
    }
    AppMethodBeat.o(202038);
    return false;
  }
  
  public final boolean pJ()
  {
    return this.emptyCount > 0;
  }
  
  public final int pK()
  {
    return this.apB[(this.apF * 5 + 3)];
  }
  
  public final int pL()
  {
    if (this.apF < this.apG) {
      return this.apB[(this.apF * 5)];
    }
    return 0;
  }
  
  public final int pM()
  {
    AppMethodBeat.i(202083);
    int i = this.apH;
    int j = bf.k(this.apB, this.parent);
    AppMethodBeat.o(202083);
    return i - j;
  }
  
  public final Object pN()
  {
    AppMethodBeat.i(202100);
    if (this.apF < this.apG)
    {
      Object localObject = e(this.apB, this.apF);
      AppMethodBeat.o(202100);
      return localObject;
    }
    AppMethodBeat.o(202100);
    return null;
  }
  
  public final Object pO()
  {
    AppMethodBeat.i(202119);
    if (this.apF < this.apG)
    {
      Object localObject = d(this.apB, this.apF);
      AppMethodBeat.o(202119);
      return localObject;
    }
    AppMethodBeat.o(202119);
    return Integer.valueOf(0);
  }
  
  public final int pP()
  {
    AppMethodBeat.i(202128);
    if (this.parent >= 0)
    {
      int i = bf.l(this.apB, this.parent);
      AppMethodBeat.o(202128);
      return i;
    }
    AppMethodBeat.o(202128);
    return 0;
  }
  
  public final void pQ()
  {
    this.emptyCount += 1;
  }
  
  public final void pR()
  {
    AppMethodBeat.i(202158);
    if (this.emptyCount > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Unbalanced begin/end empty".toString());
      AppMethodBeat.o(202158);
      throw localThrowable;
    }
    this.emptyCount -= 1;
    AppMethodBeat.o(202158);
  }
  
  public final void pS()
  {
    AppMethodBeat.i(202173);
    if (this.emptyCount <= 0)
    {
      if (this.apB[(this.apF * 5 + 2)] == this.parent) {}
      for (i = 1; i == 0; i = 0)
      {
        Throwable localThrowable = (Throwable)new IllegalArgumentException("Invalid slot table detected".toString());
        AppMethodBeat.o(202173);
        throw localThrowable;
      }
      this.parent = this.apF;
      this.apG = (this.apF + this.apB[(this.apF * 5 + 3)]);
      i = this.apF;
      this.apF = (i + 1);
      this.apH = bf.k(this.apB, i);
      if (i < this.apC - 1) {
        break label150;
      }
    }
    label150:
    for (int i = this.apE;; i = this.apB[((i + 1) * 5 + 4)])
    {
      this.apI = i;
      AppMethodBeat.o(202173);
      return;
    }
  }
  
  public final int pT()
  {
    int j = 1;
    AppMethodBeat.i(202179);
    if (this.emptyCount == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Cannot skip while in an empty region".toString());
      AppMethodBeat.o(202179);
      throw localThrowable;
    }
    if (bf.f(this.apB, this.apF)) {}
    for (i = j;; i = bf.l(this.apB, this.apF))
    {
      this.apF += this.apB[(this.apF * 5 + 3)];
      AppMethodBeat.o(202179);
      return i;
    }
  }
  
  public final void pU()
  {
    AppMethodBeat.i(202200);
    int i;
    if (this.emptyCount == 0)
    {
      if (this.apF == this.apG) {}
      for (i = 1; i == 0; i = 0)
      {
        Throwable localThrowable = (Throwable)new IllegalArgumentException("endGroup() not called at the end of a group".toString());
        AppMethodBeat.o(202200);
        throw localThrowable;
      }
      i = this.apB[(this.parent * 5 + 2)];
      this.parent = i;
      if (i >= 0) {
        break label100;
      }
      i = this.apC;
    }
    for (;;)
    {
      this.apG = i;
      AppMethodBeat.o(202200);
      return;
      label100:
      i += this.apB[(i * 5 + 3)];
    }
  }
  
  public final List<ah> pV()
  {
    AppMethodBeat.i(202210);
    List localList = (List)new ArrayList();
    if (this.emptyCount > 0)
    {
      AppMethodBeat.o(202210);
      return localList;
    }
    int i = 0;
    int j = this.apF;
    if (j < this.apG)
    {
      int m = this.apB[(j * 5)];
      Object localObject = e(this.apB, j);
      if (bf.f(this.apB, j)) {}
      for (int k = 1;; k = bf.l(this.apB, j))
      {
        localList.add(new ah(m, localObject, j, k, i));
        j += this.apB[(j * 5 + 3)];
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(202210);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.bd
 * JD-Core Version:    0.7.0.1
 */