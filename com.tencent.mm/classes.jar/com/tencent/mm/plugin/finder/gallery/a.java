package com.tencent.mm.plugin.finder.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderObject;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/ConfigData;", "", "tabList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "bizScene", "extBuff", "", "lastSelectedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Ljava/util/ArrayList;I[BLcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getBizScene", "()I", "getExtBuff", "()[B", "getLastSelectedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getTabList", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class a
{
  public final int kqZ;
  public final ArrayList<Integer> xTu;
  final byte[] xTv;
  final FinderObject xTw;
  
  public a(ArrayList<Integer> paramArrayList, int paramInt, byte[] paramArrayOfByte, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(229481);
    this.xTu = paramArrayList;
    this.kqZ = paramInt;
    this.xTv = paramArrayOfByte;
    this.xTw = paramFinderObject;
    AppMethodBeat.o(229481);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(229488);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.h(this.xTu, paramObject.xTu)) || (this.kqZ != paramObject.kqZ) || (!p.h(this.xTv, paramObject.xTv)) || (!p.h(this.xTw, paramObject.xTw))) {}
      }
    }
    else
    {
      AppMethodBeat.o(229488);
      return true;
    }
    AppMethodBeat.o(229488);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(229486);
    Object localObject = this.xTu;
    int i;
    int m;
    if (localObject != null)
    {
      i = localObject.hashCode();
      m = this.kqZ;
      localObject = this.xTv;
      if (localObject == null) {
        break label92;
      }
    }
    label92:
    for (int j = Arrays.hashCode((byte[])localObject);; j = 0)
    {
      localObject = this.xTw;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(229486);
      return (j + (i * 31 + m) * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(229483);
    String str = "ConfigData(tabList=" + this.xTu + ", bizScene=" + this.kqZ + ", extBuff=" + Arrays.toString(this.xTv) + ", lastSelectedObject=" + this.xTw + ")";
    AppMethodBeat.o(229483);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.a
 * JD-Core Version:    0.7.0.1
 */