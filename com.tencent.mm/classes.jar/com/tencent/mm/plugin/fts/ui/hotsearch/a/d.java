package com.tencent.mm.plugin.fts.ui.hotsearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/SearchEducationItemClickAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "()V", "ftsNeedHideKeyBoard", "", "getFtsNeedHideKeyBoard", "()Z", "setFtsNeedHideKeyBoard", "(Z)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "type", "", "getType", "()I", "setType", "(I)V", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends BaseStateAction
{
  public boolean Hzv;
  public String title = "";
  public int type;
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(265739);
    s.u(paramString, "<set-?>");
    this.title = paramString;
    AppMethodBeat.o(265739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.hotsearch.a.d
 * JD-Core Version:    0.7.0.1
 */