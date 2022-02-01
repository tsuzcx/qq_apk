package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.model.s;
import java.util.HashMap;

public final class b
  extends FrameLayout
{
  private int IWT;
  private boolean IWU;
  e IXj;
  private View bEx;
  private int lCR;
  
  public b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(276784);
    this.lCR = paramInt;
    this.IWU = paramBoolean;
    this.bEx = LayoutInflater.from(getContext()).inflate(h.f.HZX, this, false);
    if ((((f)h.ax(f.class)).fCh().XC(2) != 0) && (this.IWU))
    {
      this.IXj = new e(getContext(), this.lCR);
      this.IXj.setEmptyCallback(new c()
      {
        public final void fHQ()
        {
          AppMethodBeat.i(276771);
          b.this.refreshView();
          AppMethodBeat.o(276771);
        }
      });
      addView(this.IXj, new FrameLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(276784);
      return;
    }
    addView(this.bEx);
    AppMethodBeat.o(276784);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(276794);
    if (((f)h.ax(f.class)).fCh().XC(2) == 0)
    {
      if ((this.IXj != null) && (indexOfChild(this.IXj) >= 0)) {
        removeView(this.IXj);
      }
      if ((this.bEx != null) && (indexOfChild(this.bEx) < 0)) {
        addView(this.bEx);
      }
    }
    AppMethodBeat.o(276794);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(184807);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "2");
    localHashMap.put("newnotice", String.valueOf(this.IWT));
    g.a(getContext(), 13, 1300, 0, 1, this.lCR, g.s(localHashMap));
    this.IWT = 0;
    AppMethodBeat.o(184807);
  }
  
  public final void setNewMessageCount(int paramInt)
  {
    this.IWT = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.b
 * JD-Core Version:    0.7.0.1
 */