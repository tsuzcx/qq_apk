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

public final class b
  extends FrameLayout
{
  View GG;
  private int fRv;
  private int uFO;
  d uGb;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183881);
    this.fRv = paramInt;
    this.GG = LayoutInflater.from(getContext()).inflate(2131494354, this, false);
    if (((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().In(2) != 0)
    {
      this.uGb = new d(getContext(), this.fRv);
      addView(this.uGb, new FrameLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(183881);
      return;
    }
    addView(this.GG);
    AppMethodBeat.o(183881);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(184807);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "2");
    localHashMap.put("newnotice", String.valueOf(this.uFO));
    com.tencent.mm.game.report.f.a(getContext(), 13, 1300, 0, 1, this.fRv, com.tencent.mm.game.report.f.r(localHashMap));
    this.uFO = 0;
    AppMethodBeat.o(184807);
  }
  
  public final void setNewMessageCount(int paramInt)
  {
    this.uFO = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.b
 * JD-Core Version:    0.7.0.1
 */