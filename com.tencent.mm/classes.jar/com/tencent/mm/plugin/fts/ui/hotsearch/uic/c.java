package com.tencent.mm.plugin.fts.ui.hotsearch.uic;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/uic/FTSMainDataUIC;", "Lcom/tencent/mm/plugin/mvvmbase/uic/MvvmStateCenterUIC;", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/FTSMainState;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getHotSearchUrl", "", "getInitState", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.mvvmbase.c.a<com.tencent.mm.plugin.fts.ui.hotsearch.a.a>
{
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(265781);
    AppMethodBeat.o(265781);
  }
  
  public static com.tencent.mm.plugin.fts.ui.hotsearch.a.a fyJ()
  {
    AppMethodBeat.i(265784);
    com.tencent.mm.plugin.fts.ui.hotsearch.a.a locala = new com.tencent.mm.plugin.fts.ui.hotsearch.a.a();
    String str = e.fxw();
    s.s(str, "getUnsignedSessionId()");
    s.u(str, "<set-?>");
    locala.sessionId = str;
    locala.scene = 0;
    AppMethodBeat.o(265784);
    return locala;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(265801);
    super.onCreate(paramBundle);
    paramBundle = getStateCenter();
    if (paramBundle != null) {
      paramBundle.process((q)getActivity(), (kotlin.g.a.b)new a(this));
    }
    AppMethodBeat.o(265801);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(265807);
    paramBundle = getStateCenter();
    if (paramBundle != null) {
      paramBundle.dispatch((IStateAction)new com.tencent.mm.plugin.fts.ui.hotsearch.a.b());
    }
    AppMethodBeat.o(265807);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/FTSMainState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.fts.ui.hotsearch.a.a, ah>
  {
    a(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.hotsearch.uic.c
 * JD-Core Version:    0.7.0.1
 */