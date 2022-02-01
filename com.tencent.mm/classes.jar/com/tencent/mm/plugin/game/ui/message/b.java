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
  private int fsv;
  private int snk;
  d snu;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183881);
    this.fsv = paramInt;
    if (((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().EA(2) != 0)
    {
      this.snu = new d(getContext(), this.fsv);
      addView(this.snu, new FrameLayout.LayoutParams(-1, -1));
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
    localHashMap.put("newnotice", String.valueOf(this.snk));
    com.tencent.mm.game.report.e.a(getContext(), 13, 1300, 0, 1, this.fsv, com.tencent.mm.game.report.e.l(localHashMap));
    this.snk = 0;
    AppMethodBeat.o(184807);
  }
  
  public final void setNewMessageCount(int paramInt)
  {
    this.snk = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.b
 * JD-Core Version:    0.7.0.1
 */