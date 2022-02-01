package com.tencent.mm.plugin.handoff.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"cdata", "", "", "api-handoff_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final String fP(Object paramObject)
  {
    AppMethodBeat.i(121712);
    s.u(paramObject, "<this>");
    paramObject = "<![CDATA[" + paramObject + "]]>";
    AppMethodBeat.o(121712);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.a
 * JD-Core Version:    0.7.0.1
 */