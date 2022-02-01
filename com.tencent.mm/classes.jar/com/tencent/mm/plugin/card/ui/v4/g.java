package com.tencent.mm.plugin.card.ui.v4;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "", "msg", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "IDLE", "LOADING", "DELETING", "INCOMPLETE", "UP_TO_DATE", "FAILED", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum g
{
  String msg;
  
  static
  {
    AppMethodBeat.i(294377);
    wII = new g("IDLE", 0, "");
    wIJ = new g("LOADING", 1, "");
    wIK = new g("DELETING", 2, "");
    wIL = new g("INCOMPLETE", 3, "");
    wIM = new g("UP_TO_DATE", 4, "");
    wIN = new g("FAILED", 5, "");
    wIO = new g[] { wII, wIJ, wIK, wIL, wIM, wIN };
    AppMethodBeat.o(294377);
  }
  
  private g(String paramString)
  {
    this.msg = paramString;
  }
  
  public final void alk(String paramString)
  {
    AppMethodBeat.i(294382);
    s.u(paramString, "<set-?>");
    this.msg = paramString;
    AppMethodBeat.o(294382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.g
 * JD-Core Version:    0.7.0.1
 */