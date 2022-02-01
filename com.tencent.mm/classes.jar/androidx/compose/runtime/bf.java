package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Aux_Mask", "", "Aux_Shift", "DataAnchor_Offset", "GroupInfo_Offset", "Group_Fields_Size", "Key_Offset", "MinGroupGrowthSize", "MinSlotsGrowthSize", "NodeBit_Mask", "NodeCount_Mask", "NodeKey", "ObjectKey_Mask", "ObjectKey_Shift", "ParentAnchor_Offset", "Size_Offset", "Slots_Shift", "parentAnchorPivot", "countOneBits", "value", "addAux", "", "", "address", "auxIndex", "dataAnchor", "dataAnchors", "", "len", "getOrAdd", "Landroidx/compose/runtime/Anchor;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "index", "effectiveSize", "block", "Lkotlin/Function0;", "groupInfo", "groupSize", "groupSizes", "hasAux", "", "hasObjectKey", "initGroup", "key", "isNode", "hasDataKey", "hasData", "parentAnchor", "keys", "locationOf", "nodeCount", "nodeCounts", "nodeIndex", "objectKeyIndex", "parentAnchors", "search", "location", "slice", "indices", "", "slotAnchor", "updateDataAnchor", "anchor", "updateGroupSize", "updateNodeCount", "updateParentAnchor", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class bf
{
  static final int b(ArrayList<c> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202019);
    int j = paramArrayList.size() - 1;
    int i = 0;
    while (i <= j)
    {
      int n = i + j >>> 1;
      int m = ((c)paramArrayList.get(n)).location;
      int k = m;
      if (m < 0) {
        k = m + paramInt2;
      }
      k = s.compare(k, paramInt1);
      if (k < 0)
      {
        i = n + 1;
      }
      else if (k > 0)
      {
        j = n - 1;
      }
      else
      {
        AppMethodBeat.o(202019);
        return n;
      }
    }
    paramInt1 = -(i + 1);
    AppMethodBeat.o(202019);
    return paramInt1;
  }
  
  static final int bS(int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    default: 
      i = 3;
    case 1: 
    case 2: 
    case 4: 
      return i;
    case 0: 
      return 0;
    case 3: 
      return 2;
    case 5: 
      return 2;
    }
    return 2;
  }
  
  static final void c(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    paramArrayOfInt[(paramInt1 * 5 + 4)] = paramInt2;
  }
  
  static final boolean f(int[] paramArrayOfInt, int paramInt)
  {
    return (paramArrayOfInt[(paramInt * 5 + 1)] & 0x40000000) != 0;
  }
  
  static final boolean g(int[] paramArrayOfInt, int paramInt)
  {
    return (paramArrayOfInt[(paramInt * 5 + 1)] & 0x20000000) != 0;
  }
  
  static final int h(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(201988);
    int i = paramInt * 5;
    paramInt = paramArrayOfInt[(i + 4)];
    i = bS(paramArrayOfInt[(i + 1)] >> 30);
    AppMethodBeat.o(201988);
    return i + paramInt;
  }
  
  static final boolean i(int[] paramArrayOfInt, int paramInt)
  {
    return (paramArrayOfInt[(paramInt * 5 + 1)] & 0x10000000) != 0;
  }
  
  static final int j(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(201994);
    int i = paramInt * 5;
    if (i >= paramArrayOfInt.length)
    {
      paramInt = paramArrayOfInt.length;
      AppMethodBeat.o(201994);
      return paramInt;
    }
    paramInt = paramArrayOfInt[(i + 4)];
    i = bS(paramArrayOfInt[(i + 1)] >> 29);
    AppMethodBeat.o(201994);
    return i + paramInt;
  }
  
  static final int k(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(202000);
    int i = paramInt * 5;
    paramInt = paramArrayOfInt[(i + 4)];
    i = bS(paramArrayOfInt[(i + 1)] >> 28);
    AppMethodBeat.o(202000);
    return i + paramInt;
  }
  
  static final int l(int[] paramArrayOfInt, int paramInt)
  {
    return paramArrayOfInt[(paramInt * 5 + 1)] & 0x7FFFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.bf
 * JD-Core Version:    0.7.0.1
 */