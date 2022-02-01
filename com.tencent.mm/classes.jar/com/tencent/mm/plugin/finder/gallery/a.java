package com.tencent.mm.plugin.finder.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderObject;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/ConfigData;", "", "tabList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "bizScene", "extBuff", "", "lastSelectedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Ljava/util/ArrayList;I[BLcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getBizScene", "()I", "getExtBuff", "()[B", "getLastSelectedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getTabList", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final ArrayList<Integer> BsZ;
  public final byte[] Buq;
  final FinderObject Bur;
  public final int mUU;
  
  public a(ArrayList<Integer> paramArrayList, int paramInt, byte[] paramArrayOfByte, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(334328);
    this.BsZ = paramArrayList;
    this.mUU = paramInt;
    this.Buq = paramArrayOfByte;
    this.Bur = paramFinderObject;
    AppMethodBeat.o(334328);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(334352);
    if (this == paramObject)
    {
      AppMethodBeat.o(334352);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(334352);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.BsZ, paramObject.BsZ))
    {
      AppMethodBeat.o(334352);
      return false;
    }
    if (this.mUU != paramObject.mUU)
    {
      AppMethodBeat.o(334352);
      return false;
    }
    if (!s.p(this.Buq, paramObject.Buq))
    {
      AppMethodBeat.o(334352);
      return false;
    }
    if (!s.p(this.Bur, paramObject.Bur))
    {
      AppMethodBeat.o(334352);
      return false;
    }
    AppMethodBeat.o(334352);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(334344);
    int k = this.BsZ.hashCode();
    int m = this.mUU;
    int i;
    if (this.Buq == null)
    {
      i = 0;
      if (this.Bur != null) {
        break label71;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(334344);
      return (i + (k * 31 + m) * 31) * 31 + j;
      i = Arrays.hashCode(this.Buq);
      break;
      label71:
      j = this.Bur.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(334337);
    String str = "ConfigData(tabList=" + this.BsZ + ", bizScene=" + this.mUU + ", extBuff=" + Arrays.toString(this.Buq) + ", lastSelectedObject=" + this.Bur + ')';
    AppMethodBeat.o(334337);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.a
 * JD-Core Version:    0.7.0.1
 */