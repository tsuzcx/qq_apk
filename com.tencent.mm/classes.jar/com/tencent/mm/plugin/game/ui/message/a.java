package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.HashMap;

public final class a
  extends FrameLayout
{
  private boolean DcA;
  d Dcy;
  private int Dcz;
  private View Xd;
  private int jaR;
  
  public a(final Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(194462);
    this.jaR = paramInt;
    this.DcA = paramBoolean;
    this.Xd = LayoutInflater.from(getContext()).inflate(g.f.CnP, this, false);
    if ((((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().TI(1) != 0) && (this.DcA))
    {
      this.Dcy = new d(getContext(), this.jaR);
      this.Dcy.setEmptyCallback(new c()
      {
        public final void ezP()
        {
          AppMethodBeat.i(192658);
          a.this.refreshView();
          AppMethodBeat.o(192658);
        }
      });
      addView(this.Dcy, new FrameLayout.LayoutParams(-1, -1));
      paramInt = Util.nullAsNil((Integer)h.aHG().aHp().get(ar.a.Vrp, Integer.valueOf(0)));
      if (paramInt <= 0)
      {
        h.aHG().aHp().set(ar.a.Vrp, Integer.valueOf(paramInt + 1));
        paramContext = new com.tencent.mm.ui.widget.a.g(getContext(), 2, 0, true);
        paramContext.ah(getResources().getString(g.i.CoX));
        paramContext.ayu(1);
        paramContext.YnF = new g.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(191545);
            paramContext.bYF();
            AppMethodBeat.o(191545);
          }
        };
        paramContext.setCustomView(LayoutInflater.from(getContext()).inflate(g.f.CnQ, null));
        paramContext.eik();
      }
      AppMethodBeat.o(194462);
      return;
    }
    addView(this.Xd);
    AppMethodBeat.o(194462);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(194471);
    if (((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().TI(1) == 0)
    {
      if ((this.Dcy != null) && (indexOfChild(this.Dcy) >= 0)) {
        removeView(this.Dcy);
      }
      if ((this.Xd != null) && (indexOfChild(this.Xd) < 0)) {
        addView(this.Xd);
      }
    }
    AppMethodBeat.o(194471);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(184806);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "1");
    localHashMap.put("newmsg", String.valueOf(this.Dcz));
    com.tencent.mm.game.report.g.a(getContext(), 13, 1300, 0, 1, this.jaR, com.tencent.mm.game.report.g.l(localHashMap));
    this.Dcz = 0;
    AppMethodBeat.o(184806);
  }
  
  public final void setNewMessageCount(int paramInt)
  {
    this.Dcz = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.a
 * JD-Core Version:    0.7.0.1
 */