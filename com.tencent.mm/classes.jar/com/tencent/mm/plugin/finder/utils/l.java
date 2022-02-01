package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import d.g.a.b;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "task", "Lkotlin/Function1;", "", "id", "", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTask", "()Lkotlin/jvm/functions/Function1;", "token", "", "getToken", "()I", "setToken", "(I)V", "call", "toString", "uniqueId", "plugin-finder_release"})
public final class l
  extends c
{
  private final String id;
  private final b<l, y> qTq;
  public int token;
  
  private l(b<? super l, y> paramb, String paramString)
  {
    AppMethodBeat.i(167990);
    this.qTq = paramb;
    this.id = paramString;
    this.token = -1;
    AppMethodBeat.o(167990);
  }
  
  public final String abi()
  {
    return this.id;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167989);
    this.qTq.aA(this);
    AppMethodBeat.o(167989);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(178464);
    String str = "{token=" + this.token + " id=" + this.id + '}';
    AppMethodBeat.o(178464);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.l
 * JD-Core Version:    0.7.0.1
 */