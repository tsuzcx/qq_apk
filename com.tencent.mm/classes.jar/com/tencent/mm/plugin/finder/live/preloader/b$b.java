package com.tencent.mm.plugin.finder.live.preloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(k=3, mv={1, 5, 1}, xi=48)
final class b$b
  extends kotlin.d.b.a.d
{
  Object L$0;
  int label;
  
  b$b(b paramb, kotlin.d.d<? super b> paramd)
  {
    super(paramd);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(350958);
    this.result = paramObject;
    this.label |= 0x80000000;
    paramObject = this.DmW.X((kotlin.d.d)this);
    AppMethodBeat.o(350958);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.preloader.b.b
 * JD-Core Version:    0.7.0.1
 */