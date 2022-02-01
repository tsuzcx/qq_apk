package com.tencent.mm.plugin.finder.live.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgh;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$AtWxContact;", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "preIndex", "", "suffixIndex", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;II)V", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getPreIndex", "()I", "getSuffixIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ay$e
{
  final bgh Ddj;
  private final int Ddk;
  private final int Ddl;
  
  public ay$e(bgh parambgh, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(353712);
    this.Ddj = parambgh;
    this.Ddk = paramInt1;
    this.Ddl = paramInt2;
    AppMethodBeat.o(353712);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(353729);
    if (this == paramObject)
    {
      AppMethodBeat.o(353729);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(353729);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(this.Ddj, paramObject.Ddj))
    {
      AppMethodBeat.o(353729);
      return false;
    }
    if (this.Ddk != paramObject.Ddk)
    {
      AppMethodBeat.o(353729);
      return false;
    }
    if (this.Ddl != paramObject.Ddl)
    {
      AppMethodBeat.o(353729);
      return false;
    }
    AppMethodBeat.o(353729);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(353720);
    int i = this.Ddj.hashCode();
    int j = this.Ddk;
    int k = this.Ddl;
    AppMethodBeat.o(353720);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(353718);
    String str = "AtWxContact(contact=" + this.Ddj + ", preIndex=" + this.Ddk + ", suffixIndex=" + this.Ddl + ')';
    AppMethodBeat.o(353718);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ay.e
 * JD-Core Version:    0.7.0.1
 */