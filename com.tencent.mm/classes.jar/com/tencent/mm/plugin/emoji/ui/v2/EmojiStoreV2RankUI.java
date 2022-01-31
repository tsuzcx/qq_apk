package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI;
import com.tencent.mm.plugin.report.service.h;

public class EmojiStoreV2RankUI
  extends BaseEmojiStoreUI
{
  public final int blS()
  {
    return 5;
  }
  
  public final int blT()
  {
    return 105;
  }
  
  public final a blU()
  {
    AppMethodBeat.i(53667);
    f localf = new f(getContext());
    AppMethodBeat.o(53667);
    return localf;
  }
  
  public final int bmb()
  {
    return 10;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(53666);
    super.initView();
    setMMTitle(2131299213);
    AppMethodBeat.o(53666);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53665);
    super.onCreate(paramBundle);
    h.qsU.e(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(5), Integer.valueOf(5) });
    AppMethodBeat.o(53665);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RankUI
 * JD-Core Version:    0.7.0.1
 */