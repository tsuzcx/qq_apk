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
  private View GQ;
  private int gwE;
  private int xXT;
  private boolean xXU;
  e xYl;
  
  public b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(204317);
    this.gwE = paramInt;
    this.xXU = paramBoolean;
    this.GQ = LayoutInflater.from(getContext()).inflate(2131494919, this, false);
    if ((((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Oo(2) != 0) && (this.xXU))
    {
      this.xYl = new e(getContext(), this.gwE);
      this.xYl.setEmptyCallback(new c()
      {
        public final void dWH()
        {
          AppMethodBeat.i(204316);
          b.this.refreshView();
          AppMethodBeat.o(204316);
        }
      });
      addView(this.xYl, new FrameLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(204317);
      return;
    }
    addView(this.GQ);
    AppMethodBeat.o(204317);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(204318);
    if (((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Oo(2) == 0)
    {
      if ((this.xYl != null) && (indexOfChild(this.xYl) >= 0)) {
        removeView(this.xYl);
      }
      if ((this.GQ != null) && (indexOfChild(this.GQ) < 0)) {
        addView(this.GQ);
      }
    }
    AppMethodBeat.o(204318);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(184807);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "2");
    localHashMap.put("newnotice", String.valueOf(this.xXT));
    com.tencent.mm.game.report.f.a(getContext(), 13, 1300, 0, 1, this.gwE, com.tencent.mm.game.report.f.t(localHashMap));
    this.xXT = 0;
    AppMethodBeat.o(184807);
  }
  
  public final void setNewMessageCount(int paramInt)
  {
    this.xXT = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.b
 * JD-Core Version:    0.7.0.1
 */