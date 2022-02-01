package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.s;
import java.util.HashMap;

public final class a
  extends FrameLayout
{
  View GG;
  private int fRv;
  c uFN;
  private int uFO;
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183869);
    this.fRv = paramInt;
    this.GG = LayoutInflater.from(getContext()).inflate(2131494354, this, false);
    if (((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().In(1) != 0)
    {
      this.uFN = new c(getContext(), this.fRv);
      addView(this.uFN, new FrameLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(183869);
      return;
    }
    addView(this.GG);
    AppMethodBeat.o(183869);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(184806);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "1");
    localHashMap.put("newmsg", String.valueOf(this.uFO));
    com.tencent.mm.game.report.f.a(getContext(), 13, 1300, 0, 1, this.fRv, com.tencent.mm.game.report.f.r(localHashMap));
    this.uFO = 0;
    AppMethodBeat.o(184806);
  }
  
  public final void setNewMessageCount(int paramInt)
  {
    this.uFO = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.a
 * JD-Core Version:    0.7.0.1
 */