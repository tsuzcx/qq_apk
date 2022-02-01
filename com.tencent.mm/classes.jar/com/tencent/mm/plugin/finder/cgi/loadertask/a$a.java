package com.tencent.mm.plugin.finder.cgi.loadertask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(k=3, mv={1, 5, 1}, xi=48)
final class a$a
  extends kotlin.d.b.a.d
{
  Object L$0;
  long Yx;
  int label;
  
  a$a(a parama, kotlin.d.d<? super a> paramd)
  {
    super(paramd);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(336608);
    this.result = paramObject;
    this.label |= 0x80000000;
    paramObject = this.AFe.aa((kotlin.d.d)this);
    AppMethodBeat.o(336608);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.loadertask.a.a
 * JD-Core Version:    0.7.0.1
 */