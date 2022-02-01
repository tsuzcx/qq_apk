package com.tencent.mm.plugin.emoji.ui.v3;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.ui.v3.b.a;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeMainFragment;", "Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseFragment;", "()V", "pageExposed", "", "getLayoutId", "", "getNetSceneGetStoreRecListType", "isMainTab", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setUserVisibleHint", "isVisibleToUser", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiStoreV3HomeMainFragment
  extends EmojiStoreV3HomeBaseFragment
{
  private boolean xWH;
  
  public final int dCO()
  {
    return 6910;
  }
  
  public final boolean dCl()
  {
    return true;
  }
  
  public final int getLayoutId()
  {
    return h.f.emoji_store_v3_home_main_fm;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(270478);
    a locala = a.ycU;
    a.lq(System.currentTimeMillis());
    super.onCreate(paramBundle);
    AppMethodBeat.o(270478);
  }
  
  public final void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(270485);
    super.setUserVisibleHint(paramBoolean);
    if ((!this.xWH) && (paramBoolean))
    {
      this.xWH = true;
      h.OAn.b(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(1), Integer.valueOf(1) });
    }
    AppMethodBeat.o(270485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.EmojiStoreV3HomeMainFragment
 * JD-Core Version:    0.7.0.1
 */