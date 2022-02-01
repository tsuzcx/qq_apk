package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.s.b;

public class GameChooseMediaUI
  extends AlbumPreviewUI
{
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, s.b paramb)
  {
    AppMethodBeat.i(40903);
    super.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, paramOnLongClickListener, s.b.JwK);
    AppMethodBeat.o(40903);
  }
  
  public final void alU(String paramString)
  {
    AppMethodBeat.i(40904);
    ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.g.class)).a(this, paramString, 4377, null);
    AppMethodBeat.o(40904);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40901);
    super.onCreate(paramBundle);
    overridePendingTransition(MMFragmentActivity.a.Jxh, MMFragmentActivity.a.Jxi);
    AppMethodBeat.o(40901);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(40902);
    super.onDestroy();
    AppMethodBeat.o(40902);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameChooseMediaUI
 * JD-Core Version:    0.7.0.1
 */