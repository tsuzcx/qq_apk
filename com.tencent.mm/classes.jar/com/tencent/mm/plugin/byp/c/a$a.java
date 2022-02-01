package com.tencent.mm.plugin.byp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PString;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgConvUpdater$DigestData;", "", "digestStr", "Lcom/tencent/mm/pointers/PString;", "digestUser", "(Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;)V", "getDigestStr", "()Lcom/tencent/mm/pointers/PString;", "getDigestUser", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  public final PString waU;
  public final PString waV;
  
  public a$a(PString paramPString1, PString paramPString2)
  {
    AppMethodBeat.i(271969);
    this.waU = paramPString1;
    this.waV = paramPString2;
    AppMethodBeat.o(271969);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(271980);
    if (this == paramObject)
    {
      AppMethodBeat.o(271980);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(271980);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.waU, paramObject.waU))
    {
      AppMethodBeat.o(271980);
      return false;
    }
    if (!s.p(this.waV, paramObject.waV))
    {
      AppMethodBeat.o(271980);
      return false;
    }
    AppMethodBeat.o(271980);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(271975);
    int i = this.waU.hashCode();
    int j = this.waV.hashCode();
    AppMethodBeat.o(271975);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(271971);
    String str = "DigestData(digestStr=" + this.waU + ", digestUser=" + this.waV + ')';
    AppMethodBeat.o(271971);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.c.a.a
 * JD-Core Version:    0.7.0.1
 */