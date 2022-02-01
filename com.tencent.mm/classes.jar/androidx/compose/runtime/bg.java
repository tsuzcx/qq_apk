package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.k;
import kotlin.f;
import kotlin.g.b.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/SlotWriter;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "capacity", "", "getCapacity", "()I", "<set-?>", "", "closed", "getClosed", "()Z", "currentGroup", "getCurrentGroup", "currentGroupEnd", "currentSlot", "currentSlotEnd", "endStack", "Landroidx/compose/runtime/IntStack;", "groupGapLen", "groupGapStart", "groups", "", "insertCount", "isGroupEnd", "isNode", "nodeCount", "nodeCountStack", "parent", "getParent", "size", "getSize$runtime_release", "slots", "", "[Ljava/lang/Object;", "slotsGapLen", "slotsGapOwner", "slotsGapStart", "startStack", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "advanceBy", "", "amount", "anchor", "index", "anchorIndex", "beginInsert", "close", "dataAnchorToDataIndex", "gapLen", "dataIndex", "dataIndexToDataAddress", "dataIndexToDataAnchor", "gapStart", "endGroup", "endInsert", "ensureStarted", "fixParentAnchorsFor", "firstChild", "groupAux", "groupIndexToAddress", "groupKey", "groupObjectKey", "groupSize", "groupSlots", "", "groupsAsString", "", "insertAux", "value", "insertGroups", "insertSlots", "group", "keys", "", "moveAnchors", "originalLocation", "newLocation", "moveFrom", "moveGroup", "offset", "moveGroupGapTo", "moveSlotGapTo", "node", "parentAnchorToIndex", "parentIndexToAnchor", "removeAnchors", "removeGroup", "removeGroups", "start", "len", "removeSlots", "restoreCurrentGroupEnd", "saveCurrentGroupEnd", "seek", "set", "skip", "skipGroup", "skipToGroupEnd", "startData", "key", "aux", "objectKey", "startGroup", "dataKey", "startNode", "toString", "update", "updateAnchors", "previousGapStart", "newGapStart", "updateAux", "updateNode", "updateNodeOfGroup", "updateParentNode", "verifyDataAnchors", "verifyDataAnchors$runtime_release", "verifyParentAnchors", "verifyParentAnchors$runtime_release", "auxIndex", "address", "dataIndexes", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nodeIndex", "slotIndex", "updateDataIndex", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bg
{
  private int anY;
  final be anZ;
  int[] apB;
  Object[] apD;
  int apF;
  int apH;
  private int apI;
  private ArrayList<c> apL;
  private int apM;
  private int apN;
  int apO;
  int apP;
  int apQ;
  int apR;
  int apS;
  private final ad apT;
  private final ad apU;
  private final ad apV;
  boolean closed;
  int parent;
  
  public bg(be parambe)
  {
    AppMethodBeat.i(202011);
    this.anZ = parambe;
    this.apB = this.anZ.apB;
    this.apD = this.anZ.apD;
    this.apL = this.anZ.apL;
    this.apM = this.anZ.apC;
    this.apN = (this.apB.length / 5 - this.anZ.apC);
    this.apO = this.anZ.apC;
    this.apP = this.anZ.apE;
    this.apQ = (this.apD.length - this.anZ.apE);
    this.apR = this.anZ.apC;
    this.apT = new ad();
    this.apU = new ad();
    this.apV = new ad();
    this.parent = -1;
    AppMethodBeat.o(202011);
  }
  
  private final void N(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202090);
    int k = this.apQ;
    int j = this.apP;
    int i = this.apR;
    Object localObject;
    int m;
    int n;
    if (j != paramInt1)
    {
      localObject = this.apD;
      if (paramInt1 < j)
      {
        k.a((Object[])localObject, (Object[])localObject, paramInt1 + k, paramInt1, j);
        k.a((Object[])localObject, null, paramInt1, paramInt1 + k);
      }
    }
    else
    {
      j = Math.min(paramInt2 + 1, qf());
      if (i == j) {
        break label357;
      }
      k = this.apD.length - k;
      if (j >= i) {
        break label239;
      }
      paramInt2 = bX(j);
      m = bX(i);
      n = this.apM;
    }
    for (;;)
    {
      if (paramInt2 < m)
      {
        int i1 = this.apB[(paramInt2 * 5 + 4)];
        if (i1 >= 0) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label203;
          }
          j.ah("Unexpected anchor value, expected a positive anchor".toString());
          localObject = new f();
          AppMethodBeat.o(202090);
          throw ((Throwable)localObject);
          k.a((Object[])localObject, (Object[])localObject, j, j + k, paramInt1 + k);
          break;
        }
        label203:
        bf.c(this.apB, paramInt2, -(k - i1 + 1));
        paramInt2 += 1;
        if (paramInt2 == n)
        {
          paramInt2 += this.apN;
          continue;
          label239:
          paramInt2 = bX(i);
          m = bX(j);
        }
      }
      else
      {
        for (;;)
        {
          if (paramInt2 < m)
          {
            n = this.apB[(paramInt2 * 5 + 4)];
            if (n < 0) {}
            for (i = 1; i == 0; i = 0)
            {
              j.ah("Unexpected anchor value, expected a negative anchor".toString());
              localObject = new f();
              AppMethodBeat.o(202090);
              throw ((Throwable)localObject);
            }
            bf.c(this.apB, paramInt2, n + k + 1);
            paramInt2 += 1;
            if (paramInt2 == this.apM) {
              paramInt2 += this.apN;
            }
          }
          else
          {
            this.apR = j;
            label357:
            this.apP = paramInt1;
            AppMethodBeat.o(202090);
            return;
          }
        }
      }
    }
  }
  
  private final void Q(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202102);
    int i = this.apN;
    i = this.apB.length / 5 - i;
    Object localObject;
    if (paramInt1 < paramInt2)
    {
      paramInt1 = bf.c(this.apL, paramInt1, i);
      for (;;)
      {
        if (paramInt1 >= this.apL.size()) {
          break label194;
        }
        localObject = this.apL.get(paramInt1);
        s.s(localObject, "anchors[index]");
        localObject = (c)localObject;
        int j = ((c)localObject).location;
        if (j >= 0) {
          break label115;
        }
        if (i + j >= paramInt2) {
          break;
        }
        ((c)localObject).location = (j + i);
        paramInt1 += 1;
      }
      AppMethodBeat.o(202102);
      return;
      label115:
      AppMethodBeat.o(202102);
      return;
    }
    paramInt1 = bf.c(this.apL, paramInt2, i);
    while (paramInt1 < this.apL.size())
    {
      localObject = this.apL.get(paramInt1);
      s.s(localObject, "anchors[index]");
      localObject = (c)localObject;
      paramInt2 = ((c)localObject).location;
      if (paramInt2 < 0) {
        break;
      }
      ((c)localObject).location = (-(i - paramInt2));
      paramInt1 += 1;
    }
    label194:
    AppMethodBeat.o(202102);
  }
  
  private void R(Object paramObject)
  {
    AppMethodBeat.i(202018);
    l(this.apF, paramObject);
    AppMethodBeat.o(202018);
  }
  
  private final boolean R(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202120);
    int i = this.apN;
    int j = this.apB.length / 5;
    j = bf.c(this.apL, paramInt1 + paramInt2, j - i);
    i = j;
    if (j >= this.apL.size()) {
      i = j - 1;
    }
    j = i + 1;
    int k = 0;
    if (i >= 0)
    {
      Object localObject = this.apL.get(i);
      s.s(localObject, "anchors[index]");
      localObject = (c)localObject;
      int m = b((c)localObject);
      if (m >= paramInt1)
      {
        if (m >= paramInt1 + paramInt2) {
          break label195;
        }
        ((c)localObject).location = -2147483648;
        if (k != 0) {
          break label189;
        }
        j = i;
        k = i + 1;
      }
    }
    label189:
    label195:
    for (;;)
    {
      i -= 1;
      break;
      if (j < k) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          this.apL.subList(j, k).clear();
        }
        AppMethodBeat.o(202120);
        return bool;
      }
      j = i;
    }
  }
  
  private final int S(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202167);
    if (paramInt1 < paramInt2)
    {
      AppMethodBeat.o(202167);
      return paramInt1;
    }
    paramInt1 = -(qf() - paramInt1 + 2);
    AppMethodBeat.o(202167);
    return paramInt1;
  }
  
  private final void b(int paramInt, Object paramObject1, boolean paramBoolean, Object paramObject2)
  {
    AppMethodBeat.i(202044);
    int i;
    int k;
    Object localObject;
    boolean bool1;
    label66:
    boolean bool2;
    label86:
    label123:
    int j;
    if (this.apS > 0)
    {
      i = 1;
      this.apV.bF(this.anY);
      if (i == 0) {
        break label297;
      }
      bW(1);
      k = this.apF;
      i = bX(k);
      localObject = h.alD;
      if (paramObject1 == h.a.ox()) {
        break label268;
      }
      bool1 = true;
      if (paramBoolean) {
        break label274;
      }
      localObject = h.alD;
      if (paramObject2 == h.a.ox()) {
        break label274;
      }
      bool2 = true;
      bf.a(this.apB, i, paramInt, paramBoolean, bool1, bool2, this.parent, this.apH);
      this.apI = this.apH;
      if (!paramBoolean) {
        break label280;
      }
      paramInt = 1;
      if (!bool1) {
        break label285;
      }
      i = 1;
      label131:
      if (!bool2) {
        break label291;
      }
      j = 1;
      label139:
      paramInt = j + (paramInt + i);
      if (paramInt > 0)
      {
        O(paramInt, k);
        localObject = this.apD;
        paramInt = this.apH;
        if (!paramBoolean) {
          break label444;
        }
        i = paramInt + 1;
        localObject[paramInt] = paramObject2;
        paramInt = i;
      }
    }
    label268:
    label274:
    label280:
    label285:
    label291:
    label297:
    label429:
    label444:
    for (;;)
    {
      if (bool1)
      {
        i = paramInt + 1;
        localObject[paramInt] = paramObject1;
        paramInt = i;
      }
      for (;;)
      {
        if (bool2)
        {
          i = paramInt + 1;
          localObject[paramInt] = paramObject2;
          paramInt = i;
        }
        for (;;)
        {
          this.apH = paramInt;
          this.anY = 0;
          paramInt = k + 1;
          this.parent = k;
          this.apF = paramInt;
          this.apO = paramInt;
          AppMethodBeat.o(202044);
          return;
          i = 0;
          break;
          bool1 = false;
          break label66;
          bool2 = false;
          break label86;
          paramInt = 0;
          break label123;
          i = 0;
          break label131;
          j = 0;
          break label139;
          paramInt = this.parent;
          this.apT.bF(paramInt);
          qd();
          paramInt = this.apF;
          i = bX(paramInt);
          paramObject1 = h.alD;
          if (!s.p(paramObject2, h.a.ox()))
          {
            if (!paramBoolean) {
              break label429;
            }
            R(paramObject2);
          }
          for (;;)
          {
            this.apH = o(this.apB, i);
            this.apI = n(this.apB, bX(this.apF + 1));
            this.anY = bf.l(this.apB, i);
            this.parent = paramInt;
            this.apF = (paramInt + 1);
            paramInt += this.apB[(i * 5 + 3)];
            break;
            Q(paramObject2);
          }
        }
      }
    }
  }
  
  private final void bV(int paramInt)
  {
    AppMethodBeat.i(202078);
    int k = this.apN;
    int j = this.apM;
    if (j != paramInt)
    {
      int i;
      int[] arrayOfInt;
      int m;
      int n;
      if (!((Collection)this.apL).isEmpty())
      {
        i = 1;
        if (i != 0) {
          Q(j, paramInt);
        }
        if (k > 0)
        {
          arrayOfInt = this.apB;
          i = paramInt * 5;
          m = k * 5;
          n = j * 5;
          if (paramInt >= j) {
            break label197;
          }
          k.a(arrayOfInt, arrayOfInt, m + i, i, n);
        }
        label95:
        if (paramInt >= j) {
          break label219;
        }
        i = paramInt + k;
        label105:
        m = this.apB.length / 5;
        if (i >= m) {
          break label224;
        }
      }
      label197:
      label219:
      label224:
      for (boolean bool = true;; bool = false)
      {
        j.ao(bool);
        while (i < m)
        {
          j = this.apB[(i * 5 + 2)];
          n = S(ca(j), paramInt);
          if (n != j) {
            bf.f(this.apB, i, n);
          }
          j = i + 1;
          i = j;
          if (j == paramInt) {
            i = j + k;
          }
        }
        i = 0;
        break;
        k.a(arrayOfInt, arrayOfInt, n, n + m, i + m);
        break label95;
        i = j;
        break label105;
      }
    }
    this.apM = paramInt;
    AppMethodBeat.o(202078);
  }
  
  private final int bZ(int paramInt)
  {
    AppMethodBeat.i(202139);
    paramInt = n(this.apB, bX(paramInt));
    AppMethodBeat.o(202139);
    return paramInt;
  }
  
  private final int ca(int paramInt)
  {
    AppMethodBeat.i(202174);
    if (paramInt > -2)
    {
      AppMethodBeat.o(202174);
      return paramInt;
    }
    int i = qf();
    AppMethodBeat.o(202174);
    return i + paramInt + 2;
  }
  
  static int f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1;
    if (paramInt1 > paramInt2) {
      i = -(paramInt4 - paramInt3 - paramInt1 + 1);
    }
    return i;
  }
  
  private int j(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(202146);
    int i = n(paramArrayOfInt, paramInt);
    paramInt = bf.bS(paramArrayOfInt[(paramInt * 5 + 1)] >> 29);
    AppMethodBeat.o(202146);
    return i + paramInt;
  }
  
  private static int l(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = paramInt3 - paramInt2 + paramInt1 + 1;
    }
    return i;
  }
  
  private final int m(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(202129);
    paramInt = ca(paramArrayOfInt[(bX(paramInt) * 5 + 2)]);
    AppMethodBeat.o(202129);
    return paramInt;
  }
  
  private void pS()
  {
    AppMethodBeat.i(202033);
    if (this.apS == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Key must be supplied when inserting".toString());
      AppMethodBeat.o(202033);
      throw ((Throwable)localObject);
    }
    Object localObject = h.alD;
    localObject = h.a.ox();
    h.a locala = h.alD;
    b(0, localObject, false, h.a.ox());
    AppMethodBeat.o(202033);
  }
  
  private int pT()
  {
    AppMethodBeat.i(202052);
    int i = bX(this.apF);
    int j = this.apF + this.apB[(i * 5 + 3)];
    this.apF = j;
    this.apH = n(this.apB, bX(j));
    if (bf.f(this.apB, i))
    {
      AppMethodBeat.o(202052);
      return 1;
    }
    i = bf.l(this.apB, i);
    AppMethodBeat.o(202052);
    return i;
  }
  
  private Object pY()
  {
    AppMethodBeat.i(202028);
    if (this.apS > 0) {
      O(1, this.parent);
    }
    Object localObject = this.apD;
    int i = this.apH;
    this.apH = (i + 1);
    localObject = localObject[bY(i)];
    AppMethodBeat.o(202028);
    return localObject;
  }
  
  private final void qd()
  {
    AppMethodBeat.i(202057);
    this.apU.bF(this.apB.length / 5 - this.apN - this.apO);
    AppMethodBeat.o(202057);
  }
  
  private final int qe()
  {
    AppMethodBeat.i(202065);
    int i = this.apB.length / 5 - this.apN - this.apU.pv();
    this.apO = i;
    AppMethodBeat.o(202065);
    return i;
  }
  
  private int qf()
  {
    return this.apB.length / 5 - this.apN;
  }
  
  private void set(Object paramObject)
  {
    AppMethodBeat.i(202023);
    if (this.apH <= this.apI) {}
    for (int i = 1; i == 0; i = 0)
    {
      j.ah("Writing to an invalid slot".toString());
      paramObject = new f();
      AppMethodBeat.o(202023);
      throw paramObject;
    }
    this.apD[bY(this.apH - 1)] = paramObject;
    AppMethodBeat.o(202023);
  }
  
  final void O(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202336);
    int j;
    int i;
    if (paramInt1 > 0)
    {
      N(this.apH, paramInt2);
      j = this.apP;
      i = this.apQ;
      if (i >= paramInt1) {
        break label179;
      }
      Object[] arrayOfObject1 = this.apD;
      int k = arrayOfObject1.length;
      int m = k - i;
      int n = Math.max(Math.max(k * 2, m + paramInt1), 32);
      Object[] arrayOfObject2 = new Object[n];
      paramInt2 = 0;
      while (paramInt2 < n)
      {
        arrayOfObject2[paramInt2] = null;
        paramInt2 += 1;
      }
      paramInt2 = n - m;
      k.a(arrayOfObject1, arrayOfObject2, 0, 0, j);
      k.a(arrayOfObject1, arrayOfObject2, j + paramInt2, i + j, k);
      this.apD = arrayOfObject2;
    }
    for (;;)
    {
      i = this.apI;
      if (i >= j) {
        this.apI = (i + paramInt1);
      }
      this.apP = (j + paramInt1);
      this.apQ = (paramInt2 - paramInt1);
      AppMethodBeat.o(202336);
      return;
      label179:
      paramInt2 = i;
    }
  }
  
  public final Object P(Object paramObject)
  {
    AppMethodBeat.i(202220);
    Object localObject = pY();
    set(paramObject);
    AppMethodBeat.o(202220);
    return localObject;
  }
  
  final boolean P(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202345);
    int i;
    if (paramInt2 > 0)
    {
      ArrayList localArrayList = this.apL;
      bV(paramInt1);
      if (!((Collection)localArrayList).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label123;
        }
      }
    }
    label123:
    for (boolean bool = R(paramInt1, paramInt2);; bool = false)
    {
      this.apM = paramInt1;
      this.apN += paramInt2;
      i = this.apR;
      if (i > paramInt1) {
        this.apR = (i - paramInt2);
      }
      if (this.apO >= this.apM) {
        this.apO -= paramInt2;
      }
      AppMethodBeat.o(202345);
      return bool;
      i = 0;
      break;
      AppMethodBeat.o(202345);
      return false;
    }
  }
  
  public final void Q(Object paramObject)
  {
    AppMethodBeat.i(202225);
    int i = bX(this.apF);
    if (!bf.i(this.apB, i))
    {
      j.ah("Updating the data of a group that was not created with a data slot".toString());
      paramObject = new f();
      AppMethodBeat.o(202225);
      throw paramObject;
    }
    this.apD[bY(j(this.apB, i))] = paramObject;
    AppMethodBeat.o(202225);
  }
  
  public final void S(Object paramObject)
  {
    AppMethodBeat.i(202262);
    h.a locala = h.alD;
    b(125, paramObject, true, h.a.ox());
    AppMethodBeat.o(202262);
  }
  
  public final List<c> a(be parambe, int paramInt)
  {
    AppMethodBeat.i(202297);
    s.u(parambe, "table");
    if (this.apS > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      parambe = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(202297);
      throw parambe;
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramInt == 0) && (this.apF == 0) && (this.anZ.apC == 0))
    {
      localObject1 = this.apB;
      localObject2 = this.apD;
      localObject3 = this.apL;
      localObject4 = parambe.apB;
      paramInt = parambe.apC;
      Object[] arrayOfObject = parambe.apD;
      i = parambe.apE;
      this.apB = ((int[])localObject4);
      this.apD = arrayOfObject;
      this.apL = parambe.apL;
      this.apM = paramInt;
      this.apN = (localObject4.length / 5 - paramInt);
      this.apP = i;
      this.apQ = (arrayOfObject.length - i);
      this.apR = paramInt;
      parambe.a((int[])localObject1, 0, (Object[])localObject2, 0, (ArrayList)localObject3);
      parambe = (List)this.apL;
      AppMethodBeat.o(202297);
      return parambe;
    }
    Object localObject1 = parambe.pX();
    for (;;)
    {
      int j;
      int k;
      int i1;
      int m;
      int i2;
      int i3;
      int n;
      boolean bool;
      try
      {
        i = ((bg)localObject1).bK(paramInt);
        int i4 = paramInt + i;
        j = ((bg)localObject1).bZ(paramInt);
        k = ((bg)localObject1).bZ(i4);
        i1 = k - j;
        bW(i);
        O(i1, this.apF);
        localObject2 = this.apB;
        m = this.apF;
        k.a(((bg)localObject1).apB, (int[])localObject2, m * 5, paramInt * 5, i4 * 5);
        localObject3 = this.apD;
        i2 = this.apH;
        k.a(((bg)localObject1).apD, (Object[])localObject3, i2, j, k);
        bf.f((int[])localObject2, m, this.parent);
        i3 = m + i;
        int i5 = n((int[])localObject2, m);
        j = this.apR;
        int i6 = this.apQ;
        int i7 = localObject3.length;
        i = j;
        if (m < i3)
        {
          k = m;
          n = k + 1;
          if (k != m) {
            bf.f((int[])localObject2, k, localObject2[(k * 5 + 2)] + (m - paramInt));
          }
          int i8 = n((int[])localObject2, k);
          if (j >= k) {
            break label775;
          }
          i = 0;
          bf.c((int[])localObject2, k, f(i8 + (i2 - i5), i, i6, i7));
          i = j;
          if (k != j) {
            break label872;
          }
          i = j + 1;
          break label872;
        }
        this.apR = i;
        j = bf.c(parambe.apL, paramInt, parambe.apC);
        n = bf.c(parambe.apL, i4, parambe.apC);
        if (j >= n) {
          break label783;
        }
        parambe = parambe.apL;
        localObject3 = new ArrayList(n - j);
        if (j < n)
        {
          i = j;
          k = i + 1;
          localObject4 = parambe.get(i);
          s.s(localObject4, "sourceAnchors[anchorIndex]");
          localObject4 = (c)localObject4;
          ((c)localObject4).location += m - paramInt;
          ((ArrayList)localObject3).add(localObject4);
          if (k < n) {
            break label856;
          }
        }
        i = bf.c(this.apL, this.apF, qf());
        this.anZ.apL.addAll(i, (Collection)localObject3);
        parambe.subList(j, n).clear();
        parambe = (List)localObject3;
        i = ((bg)localObject1).bG(paramInt);
        if (i >= 0)
        {
          ((bg)localObject1).pS();
          ((bg)localObject1).bT(i - ((bg)localObject1).apF);
          ((bg)localObject1).pS();
        }
        ((bg)localObject1).bT(paramInt - ((bg)localObject1).apF);
        bool = ((bg)localObject1).qc();
        if (i < 0) {
          break label882;
        }
        ((bg)localObject1).oi();
        ((bg)localObject1).qb();
        ((bg)localObject1).oi();
        ((bg)localObject1).qb();
      }
      finally
      {
        ((bg)localObject1).close();
        AppMethodBeat.o(202297);
      }
      if (paramInt == 0)
      {
        j.ah("Unexpectedly removed anchors".toString());
        parambe = new f();
        AppMethodBeat.o(202297);
        throw parambe;
        label775:
        i = this.apP;
        continue;
        label783:
        parambe = (List)ab.aivy;
      }
      else
      {
        i = this.anY;
        if (bf.f((int[])localObject2, m)) {}
        for (paramInt = 1;; paramInt = bf.l((int[])localObject2, m))
        {
          this.anY = (paramInt + i);
          this.apF = i3;
          this.apH = (i2 + i1);
          ((bg)localObject1).close();
          AppMethodBeat.o(202297);
          return parambe;
        }
        label856:
        i = k;
        continue;
        label872:
        do
        {
          k = n;
          j = i;
          break;
        } while (n < i3);
        continue;
        label882:
        if (!bool) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
    }
  }
  
  public final int b(c paramc)
  {
    AppMethodBeat.i(202303);
    s.u(paramc, "anchor");
    int i = paramc.location;
    if (i < 0)
    {
      int j = qf();
      AppMethodBeat.o(202303);
      return i + j;
    }
    AppMethodBeat.o(202303);
    return i;
  }
  
  public final int bG(int paramInt)
  {
    AppMethodBeat.i(202206);
    paramInt = m(this.apB, paramInt);
    AppMethodBeat.o(202206);
    return paramInt;
  }
  
  public final int bK(int paramInt)
  {
    AppMethodBeat.i(202192);
    paramInt = this.apB[(bX(paramInt) * 5 + 3)];
    AppMethodBeat.o(202192);
    return paramInt;
  }
  
  public final int bL(int paramInt)
  {
    AppMethodBeat.i(202178);
    paramInt = this.apB[(bX(paramInt) * 5)];
    AppMethodBeat.o(202178);
    return paramInt;
  }
  
  public final Object bN(int paramInt)
  {
    AppMethodBeat.i(202184);
    paramInt = bX(paramInt);
    if (bf.g(this.apB, paramInt))
    {
      Object localObject = this.apD[bf.h(this.apB, paramInt)];
      AppMethodBeat.o(202184);
      return localObject;
    }
    AppMethodBeat.o(202184);
    return null;
  }
  
  public final Object bO(int paramInt)
  {
    AppMethodBeat.i(202198);
    paramInt = bX(paramInt);
    if (bf.i(this.apB, paramInt))
    {
      localObject = this.apD[j(this.apB, paramInt)];
      AppMethodBeat.o(202198);
      return localObject;
    }
    Object localObject = h.alD;
    localObject = h.a.ox();
    AppMethodBeat.o(202198);
    return localObject;
  }
  
  public final c bR(int paramInt)
  {
    AppMethodBeat.i(202299);
    Object localObject = this.apL;
    int i = bf.b((ArrayList)localObject, paramInt, qf());
    if (i < 0)
    {
      if (paramInt <= this.apM) {}
      for (;;)
      {
        c localc = new c(paramInt);
        ((ArrayList)localObject).add(-(i + 1), localc);
        AppMethodBeat.o(202299);
        return localc;
        paramInt = -(qf() - paramInt);
      }
    }
    localObject = ((ArrayList)localObject).get(i);
    s.s(localObject, "get(location)");
    localObject = (c)localObject;
    AppMethodBeat.o(202299);
    return localObject;
  }
  
  public final void bT(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(202237);
    if (paramInt >= 0) {}
    Object localObject;
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Cannot seek backwards".toString());
      AppMethodBeat.o(202237);
      throw ((Throwable)localObject);
    }
    if (this.apS <= 0) {}
    for (i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("Cannot call seek() while inserting".toString());
      AppMethodBeat.o(202237);
      throw ((Throwable)localObject);
    }
    i = this.apF + paramInt;
    if ((i >= this.parent) && (i <= this.apO)) {}
    for (paramInt = j; paramInt == 0; paramInt = 0)
    {
      j.ah(("Cannot seek outside the current group (" + this.parent + '-' + this.apO + ')').toString());
      localObject = new f();
      AppMethodBeat.o(202237);
      throw ((Throwable)localObject);
    }
    this.apF = i;
    paramInt = n(this.apB, bX(i));
    this.apH = paramInt;
    this.apI = paramInt;
    AppMethodBeat.o(202237);
  }
  
  public final void bU(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(202280);
    if (this.apS <= 0) {}
    Throwable localThrowable;
    for (int i = 1; i == 0; i = 0)
    {
      localThrowable = (Throwable)new IllegalArgumentException("Cannot call ensureStarted() while inserting".toString());
      AppMethodBeat.o(202280);
      throw localThrowable;
    }
    int k = this.parent;
    if (k != paramInt)
    {
      if ((paramInt >= k) && (paramInt < this.apO)) {}
      for (i = j; i == 0; i = 0)
      {
        localThrowable = (Throwable)new IllegalArgumentException(s.X("Started group must be a subgroup of the group at ", Integer.valueOf(k)).toString());
        AppMethodBeat.o(202280);
        throw localThrowable;
      }
      i = this.apF;
      j = this.apH;
      k = this.apI;
      this.apF = paramInt;
      pS();
      this.apF = i;
      this.apH = j;
      this.apI = k;
    }
    AppMethodBeat.o(202280);
  }
  
  final void bW(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(202328);
    int n;
    int k;
    int i;
    int i1;
    int m;
    if (paramInt > 0)
    {
      n = this.apF;
      bV(n);
      k = this.apM;
      i = this.apN;
      int i2 = this.apB.length / 5;
      i1 = i2 - i;
      if (i >= paramInt) {
        break label296;
      }
      int[] arrayOfInt1 = this.apB;
      m = Math.max(Math.max(i2 * 2, i1 + paramInt), 32);
      int[] arrayOfInt2 = new int[m * 5];
      m -= i1;
      k.a(arrayOfInt1, arrayOfInt2, 0, 0, k * 5);
      k.a(arrayOfInt1, arrayOfInt2, (k + m) * 5, (i + k) * 5, i2 * 5);
      this.apB = arrayOfInt2;
      i = m;
    }
    label283:
    label296:
    for (;;)
    {
      m = this.apO;
      if (m >= k) {
        this.apO = (m + paramInt);
      }
      this.apM = (k + paramInt);
      this.apN = (i - paramInt);
      if (i1 > 0)
      {
        i = bZ(n + paramInt);
        if (this.apR >= k) {
          break label283;
        }
        label201:
        m = f(i, j, this.apQ, this.apD.length);
        n = k + paramInt;
        if (k >= n) {}
      }
      for (i = k;; i = j)
      {
        j = i + 1;
        bf.c(this.apB, i, m);
        if (j >= n)
        {
          i = this.apR;
          if (i >= k) {
            this.apR = (i + paramInt);
          }
          AppMethodBeat.o(202328);
          return;
          i = 0;
          break;
          j = this.apP;
          break label201;
        }
      }
    }
  }
  
  final int bX(int paramInt)
  {
    if (paramInt < this.apM) {
      return paramInt;
    }
    return paramInt + this.apN;
  }
  
  final int bY(int paramInt)
  {
    if (paramInt < this.apP) {
      return paramInt;
    }
    return paramInt + this.apQ;
  }
  
  public final void close()
  {
    AppMethodBeat.i(202215);
    this.closed = true;
    bV(qf());
    N(this.apD.length - this.apQ, this.apM);
    this.anZ.a(this, this.apB, this.apM, this.apD, this.apP, this.apL);
    AppMethodBeat.o(202215);
  }
  
  public final void d(int paramInt, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(202267);
    b(paramInt, paramObject1, false, paramObject2);
    AppMethodBeat.o(202267);
  }
  
  final void i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202315);
    int i = S(paramInt1, this.apM);
    while (paramInt3 < paramInt2)
    {
      bf.f(this.apB, bX(paramInt3), i);
      paramInt1 = this.apB[(bX(paramInt3) * 5 + 3)] + paramInt3;
      i(paramInt3, paramInt1, paramInt3 + 1);
      paramInt3 = paramInt1;
    }
    AppMethodBeat.o(202315);
  }
  
  final void j(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202350);
    if (paramInt2 > 0)
    {
      int i = this.apQ;
      N(paramInt1 + paramInt2, paramInt3);
      this.apP = paramInt1;
      this.apQ = (i + paramInt2);
      k.a(this.apD, null, paramInt1, paramInt1 + paramInt2);
      paramInt3 = this.apI;
      if (paramInt3 >= paramInt1) {
        this.apI = (paramInt3 - paramInt2);
      }
    }
    AppMethodBeat.o(202350);
  }
  
  public final void j(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(202257);
    h.a locala = h.alD;
    b(paramInt, paramObject, false, h.a.ox());
    AppMethodBeat.o(202257);
  }
  
  final void k(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202362);
    int j = qf();
    int i = bf.c(this.apL, paramInt1, j);
    List localList = (List)new ArrayList();
    Object localObject;
    if (i >= 0) {
      while (i < this.apL.size())
      {
        localObject = this.apL.get(i);
        s.s(localObject, "anchors[index]");
        localObject = (c)localObject;
        k = b((c)localObject);
        if ((k < paramInt1) || (k >= paramInt1 + paramInt3)) {
          break;
        }
        localList.add(localObject);
        this.apL.remove(i);
      }
    }
    paramInt3 = 0;
    int k = localList.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      i = paramInt3 + 1;
      localObject = (c)localList.get(paramInt3);
      paramInt3 = b((c)localObject) + (paramInt2 - paramInt1);
      if (paramInt3 >= this.apM) {}
      for (((c)localObject).location = (-(j - paramInt3));; ((c)localObject).location = paramInt3)
      {
        paramInt3 = bf.c(this.apL, paramInt3, j);
        this.apL.add(paramInt3, localObject);
        if (i <= k) {
          break;
        }
        AppMethodBeat.o(202362);
        return;
      }
      paramInt3 = i;
    }
  }
  
  final void l(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(202355);
    int j = bX(paramInt);
    if ((j < this.apB.length) && (bf.f(this.apB, j))) {}
    for (int i = 1; i == 0; i = 0)
    {
      j.ah(("Updating the node of a group at " + paramInt + " that was not created with as a node group").toString());
      paramObject = new f();
      AppMethodBeat.o(202355);
      throw paramObject;
    }
    this.apD[bY(n(this.apB, j))] = paramObject;
    AppMethodBeat.o(202355);
  }
  
  final int n(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(202377);
    if (paramInt >= this.apB.length / 5)
    {
      paramInt = this.apD.length;
      int i = this.apQ;
      AppMethodBeat.o(202377);
      return paramInt - i;
    }
    paramInt = l(paramArrayOfInt[(paramInt * 5 + 4)], this.apQ, this.apD.length);
    AppMethodBeat.o(202377);
    return paramInt;
  }
  
  final int o(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(202381);
    if (paramInt >= this.apB.length / 5)
    {
      paramInt = this.apD.length;
      int i = this.apQ;
      AppMethodBeat.o(202381);
      return paramInt - i;
    }
    paramInt = l(bf.k(paramArrayOfInt, paramInt), this.apQ, this.apD.length);
    AppMethodBeat.o(202381);
    return paramInt;
  }
  
  public final void oi()
  {
    AppMethodBeat.i(202243);
    int i = this.apO;
    this.apF = i;
    this.apH = n(this.apB, bX(i));
    AppMethodBeat.o(202243);
  }
  
  public final void pZ()
  {
    AppMethodBeat.i(202248);
    int i = this.apS;
    this.apS = (i + 1);
    if (i == 0) {
      qd();
    }
    AppMethodBeat.o(202248);
  }
  
  public final void qa()
  {
    int j = 1;
    AppMethodBeat.i(202253);
    if (this.apS > 0) {}
    Object localObject;
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("Unbalanced begin/end insert".toString());
      AppMethodBeat.o(202253);
      throw ((Throwable)localObject);
    }
    this.apS -= 1;
    if (this.apS == 0)
    {
      if (this.apV.aod == this.apT.aod) {}
      for (i = j; i == 0; i = 0)
      {
        j.ah("startGroup/endGroup mismatch while inserting".toString());
        localObject = new f();
        AppMethodBeat.o(202253);
        throw ((Throwable)localObject);
      }
      qe();
    }
    AppMethodBeat.o(202253);
  }
  
  public final int qb()
  {
    int m = 1;
    int k = 1;
    int j = 0;
    AppMethodBeat.i(202276);
    int i;
    int i4;
    int i5;
    int i1;
    int i2;
    int n;
    int i3;
    boolean bool;
    if (this.apS > 0)
    {
      i = 1;
      i4 = this.apF;
      i5 = this.apO;
      i1 = this.parent;
      i2 = bX(i1);
      n = this.anY;
      i3 = i4 - i1;
      bool = bf.f(this.apB, i2);
      if (i == 0) {
        break label154;
      }
      bf.d(this.apB, i2, i3);
      bf.e(this.apB, i2, n);
      j = this.apV.pv();
      if (!bool) {
        break label148;
      }
      i = k;
      label113:
      this.anY = (j + i);
      this.parent = m(this.apB, i1);
    }
    for (;;)
    {
      AppMethodBeat.o(202276);
      return n;
      i = 0;
      break;
      label148:
      i = n;
      break label113;
      label154:
      if (i4 == i5) {}
      Object localObject;
      for (i = m; i == 0; i = 0)
      {
        localObject = (Throwable)new IllegalArgumentException("Expected to be at the end of a group".toString());
        AppMethodBeat.o(202276);
        throw ((Throwable)localObject);
      }
      k = this.apB[(i2 * 5 + 3)];
      i = bf.l(this.apB, i2);
      bf.d(this.apB, i2, i3);
      bf.e(this.apB, i2, n);
      i2 = this.apT.pv();
      qe();
      this.parent = i2;
      i1 = m(this.apB, i1);
      this.anY = this.apV.pv();
      if (i1 == i2)
      {
        k = this.anY;
        if (bool) {}
        for (i = j;; i = n - i)
        {
          this.anY = (k + i);
          break;
        }
      }
      i3 -= k;
      if (bool) {}
      for (i = 0;; i = n - i)
      {
        j = i;
        k = i1;
        if (i3 == 0)
        {
          m = i;
          if (i == 0) {
            break;
          }
          k = i1;
          j = i;
        }
        for (;;)
        {
          m = j;
          if (k == 0) {
            break;
          }
          m = j;
          if (k == i2) {
            break;
          }
          if (j == 0)
          {
            m = j;
            if (i3 == 0) {
              break;
            }
          }
          i = bX(k);
          if (i3 != 0)
          {
            m = this.apB[(i * 5 + 3)];
            bf.d(this.apB, i, m + i3);
          }
          if (j != 0)
          {
            localObject = this.apB;
            bf.e((int[])localObject, i, bf.l((int[])localObject, i) + j);
          }
          if (bf.f(this.apB, i)) {
            j = 0;
          }
          k = m(this.apB, k);
        }
      }
      this.anY = (m + this.anY);
    }
  }
  
  public final boolean qc()
  {
    AppMethodBeat.i(202283);
    if (this.apS == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Cannot remove group while inserting".toString());
      AppMethodBeat.o(202283);
      throw localThrowable;
    }
    i = this.apF;
    int j = this.apH;
    int k = pT();
    boolean bool = P(i, this.apF - i);
    j(j, this.apH - j, i - 1);
    this.apF = i;
    this.apH = j;
    this.anY -= k;
    AppMethodBeat.o(202283);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202308);
    String str = "SlotWriter(current = " + this.apF + " end=" + this.apO + " size = " + qf() + " gap=" + this.apM + '-' + (this.apM + this.apN) + ')';
    AppMethodBeat.o(202308);
    return str;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/runtime/SlotWriter$groupSlots$1", "", "", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "hasNext", "", "next", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Iterator<Object>, a
  {
    private int apW;
    
    a(int paramInt1, int paramInt2, bg parambg)
    {
      AppMethodBeat.i(202386);
      this.apW = this.apX;
      AppMethodBeat.o(202386);
    }
    
    public final boolean hasNext()
    {
      return this.apW < this.apY;
    }
    
    public final Object next()
    {
      AppMethodBeat.i(202403);
      if (hasNext())
      {
        Object localObject = this.apZ.apD;
        bg localbg = this.apZ;
        int i = this.apW;
        this.apW = (i + 1);
        localObject = localObject[localbg.bY(i)];
        AppMethodBeat.o(202403);
        return localObject;
      }
      AppMethodBeat.o(202403);
      return null;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(202407);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(202407);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.bg
 * JD-Core Version:    0.7.0.1
 */