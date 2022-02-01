package com.tencent.mm.plugin.card.ui.v4;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "", "msg", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "IDLE", "LOADING", "DELETING", "INCOMPLETE", "UP_TO_DATE", "FAILED", "plugin-card_release"})
public enum h
{
  String msg;
  
  static
  {
    AppMethodBeat.i(253713);
    h localh1 = new h("IDLE", 0, "");
    tFj = localh1;
    h localh2 = new h("LOADING", 1, "");
    tFk = localh2;
    h localh3 = new h("DELETING", 2, "");
    tFl = localh3;
    h localh4 = new h("INCOMPLETE", 3, "");
    tFm = localh4;
    h localh5 = new h("UP_TO_DATE", 4, "");
    tFn = localh5;
    h localh6 = new h("FAILED", 5, "");
    tFo = localh6;
    tFp = new h[] { localh1, localh2, localh3, localh4, localh5, localh6 };
    AppMethodBeat.o(253713);
  }
  
  private h(String paramString)
  {
    this.msg = paramString;
  }
  
  public final void arG(String paramString)
  {
    AppMethodBeat.i(253715);
    p.k(paramString, "<set-?>");
    this.msg = paramString;
    AppMethodBeat.o(253715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.h
 * JD-Core Version:    0.7.0.1
 */