package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.s;
import java.util.HashMap;

public final class b
  extends FrameLayout
{
  private int fwc;
  private int tvd;
  d tvn;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183881);
    this.fwc = paramInt;
    if (((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().Gw(2) != 0)
    {
      this.tvn = new d(getContext(), this.fwc);
      addView(this.tvn, new FrameLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(183881);
      return;
    }
    LayoutInflater.from(getContext()).inflate(2131494354, this, true);
    AppMethodBeat.o(183881);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(184807);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "2");
    localHashMap.put("newnotice", String.valueOf(this.tvd));
    com.tencent.mm.game.report.e.a(getContext(), 13, 1300, 0, 1, this.fwc, com.tencent.mm.game.report.e.k(localHashMap));
    this.tvd = 0;
    AppMethodBeat.o(184807);
  }
  
  public final void setNewMessageCount(int paramInt)
  {
    this.tvd = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.b
 * JD-Core Version:    0.7.0.1
 */