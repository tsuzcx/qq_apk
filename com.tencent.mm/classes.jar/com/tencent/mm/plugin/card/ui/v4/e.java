package com.tencent.mm.plugin.card.ui.v4;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "", "msg", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "IDLE", "LOADING", "DELETING", "INCOMPLETE", "UP_TO_DATE", "FAILED", "plugin-card_release"})
public enum e
{
  String msg;
  
  static
  {
    AppMethodBeat.i(201679);
    e locale1 = new e("IDLE", 0, "");
    qjn = locale1;
    e locale2 = new e("LOADING", 1, "");
    qjo = locale2;
    e locale3 = new e("DELETING", 2, "");
    qjp = locale3;
    e locale4 = new e("INCOMPLETE", 3, "");
    qjq = locale4;
    e locale5 = new e("UP_TO_DATE", 4, "");
    qjr = locale5;
    e locale6 = new e("FAILED", 5, "");
    qjs = locale6;
    qjt = new e[] { locale1, locale2, locale3, locale4, locale5, locale6 };
    AppMethodBeat.o(201679);
  }
  
  private e(String paramString)
  {
    this.msg = paramString;
  }
  
  public final void ajT(String paramString)
  {
    AppMethodBeat.i(201680);
    p.h(paramString, "<set-?>");
    this.msg = paramString;
    AppMethodBeat.o(201680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.e
 * JD-Core Version:    0.7.0.1
 */