package com.tencent.mm.plugin.fts.ui.hotsearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.BaseState;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/FTSMainState;", "Lcom/tencent/mm/sdk/statecenter/BaseState;", "()V", "educationHeight", "", "getEducationHeight", "()I", "setEducationHeight", "(I)V", "hotSearchUrl", "", "getHotSearchUrl", "()Ljava/lang/String;", "setHotSearchUrl", "(Ljava/lang/String;)V", "isHotSearchPageFinish", "", "()Z", "setHotSearchPageFinish", "(Z)V", "scene", "getScene", "setScene", "sessionId", "getSessionId", "setSessionId", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends BaseState
{
  public String Hzr = "";
  public int Hzs;
  public boolean Hzt;
  public int scene;
  public String sessionId = "";
  
  public final Object clone()
  {
    AppMethodBeat.i(265744);
    Object localObject = super.clone();
    AppMethodBeat.o(265744);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.hotsearch.a.a
 * JD-Core Version:    0.7.0.1
 */