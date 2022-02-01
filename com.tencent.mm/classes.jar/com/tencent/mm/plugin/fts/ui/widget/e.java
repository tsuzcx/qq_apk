package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceSearchViewHelper;", "Lcom/tencent/mm/ui/tools/SearchViewHelper;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "mHasVoiceSearch", "", "voiceSearchListener", "Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceSearchViewHelper$VoiceSearchListener;", "getVoiceSearchListener", "()Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceSearchViewHelper$VoiceSearchListener;", "setVoiceSearchListener", "(Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceSearchViewHelper$VoiceSearchListener;)V", "enableVoiceSearch", "", "enable", "hasVoiceSearch", "onCreateOptionsMenu", "Landroidx/fragment/app/FragmentActivity;", "menu", "Landroid/view/Menu;", "requireVoiceSearch", "setCursorVisible", "visible", "setSearchContent", "content", "", "Companion", "VoiceSearchListener", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.ui.tools.s
{
  public static final e.a HDC;
  public boolean HDD;
  public e.b HDE;
  private final AppCompatActivity activity;
  
  static
  {
    AppMethodBeat.i(265866);
    HDC = new e.a((byte)0);
    AppMethodBeat.o(265866);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(265863);
    this.activity = paramAppCompatActivity;
    AppMethodBeat.o(265863);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, Menu paramMenu)
  {
    AppMethodBeat.i(265877);
    if (paramFragmentActivity == null)
    {
      Log.w("MicroMsg.FTS.FTSVoiceSearchViewHelper", "on add search menu, activity is null");
      AppMethodBeat.o(265877);
      return;
    }
    if (this.afKy == null) {
      this.afKy = ((com.tencent.mm.ui.tools.e)new FTSActionBarSearchView((Context)paramFragmentActivity));
    }
    super.a(paramFragmentActivity, paramMenu);
    AppMethodBeat.o(265877);
  }
  
  public final boolean bPO()
  {
    return this.HDD;
  }
  
  public final void bPP()
  {
    AppMethodBeat.i(265890);
    e.b localb = this.HDE;
    if (localb != null) {
      localb.fyv();
    }
    AppMethodBeat.o(265890);
  }
  
  public final void setCursorVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(112330);
    com.tencent.mm.ui.tools.e locale = this.afKy;
    if ((locale != null) && ((locale instanceof FTSActionBarSearchView))) {
      ((FTSActionBarSearchView)locale).setCursorVisible(paramBoolean);
    }
    AppMethodBeat.o(112330);
  }
  
  public final void setSearchContent(String paramString)
  {
    AppMethodBeat.i(112331);
    try
    {
      super.setSearchContent(paramString);
      AppMethodBeat.o(112331);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.FTS.FTSVoiceSearchViewHelper", kotlin.g.b.s.X("setSearchContent exception: ", paramString.getMessage()));
      AppMethodBeat.o(112331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */