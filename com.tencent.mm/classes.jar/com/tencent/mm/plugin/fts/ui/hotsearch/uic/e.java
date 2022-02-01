package com.tencent.mm.plugin.fts.ui.hotsearch.uic;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.hotsearch.a.g;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/uic/FTSMainVoiceSearchUIC;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.mvvmbase.a
{
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(265778);
    AppMethodBeat.o(265778);
  }
  
  private static final void a(e parame, com.tencent.mm.plugin.fts.ui.hotsearch.a.a parama)
  {
    AppMethodBeat.i(265780);
    s.u(parame, "this$0");
    s.u(parama, "state");
    parama = (g)parama.checkAction(g.class);
    if (parama != null) {
      new com.tencent.mm.plugin.fts.ui.widget.a((Context)parame.getActivity(), parama.Hzw).show();
    }
    AppMethodBeat.o(265780);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(265788);
    super.onCreate(paramBundle);
    paramBundle = getStateCenter();
    if (paramBundle != null) {
      paramBundle.observe((q)getActivity(), new e..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(265788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.hotsearch.uic.e
 * JD-Core Version:    0.7.0.1
 */