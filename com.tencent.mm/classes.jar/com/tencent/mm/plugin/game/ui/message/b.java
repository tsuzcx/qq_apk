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
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.s;
import java.util.HashMap;

public final class b
  extends FrameLayout
{
  private boolean DcA;
  e DcR;
  private int Dcz;
  private View Xd;
  private int jaR;
  
  public b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(196366);
    this.jaR = paramInt;
    this.DcA = paramBoolean;
    this.Xd = LayoutInflater.from(getContext()).inflate(g.f.CnP, this, false);
    if ((((f)h.ae(f.class)).evo().TI(2) != 0) && (this.DcA))
    {
      this.DcR = new e(getContext(), this.jaR);
      this.DcR.setEmptyCallback(new c()
      {
        public final void ezP()
        {
          AppMethodBeat.i(207449);
          b.this.refreshView();
          AppMethodBeat.o(207449);
        }
      });
      addView(this.DcR, new FrameLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(196366);
      return;
    }
    addView(this.Xd);
    AppMethodBeat.o(196366);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(196374);
    if (((f)h.ae(f.class)).evo().TI(2) == 0)
    {
      if ((this.DcR != null) && (indexOfChild(this.DcR) >= 0)) {
        removeView(this.DcR);
      }
      if ((this.Xd != null) && (indexOfChild(this.Xd) < 0)) {
        addView(this.Xd);
      }
    }
    AppMethodBeat.o(196374);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(184807);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "2");
    localHashMap.put("newnotice", String.valueOf(this.Dcz));
    g.a(getContext(), 13, 1300, 0, 1, this.jaR, g.l(localHashMap));
    this.Dcz = 0;
    AppMethodBeat.o(184807);
  }
  
  public final void setNewMessageCount(int paramInt)
  {
    this.Dcz = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.b
 * JD-Core Version:    0.7.0.1
 */