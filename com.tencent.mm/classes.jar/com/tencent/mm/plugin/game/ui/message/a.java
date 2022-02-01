package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.HashMap;

public final class a
  extends FrameLayout
{
  private View GQ;
  private int gwE;
  d xXS;
  private int xXT;
  private boolean xXU;
  
  public a(final Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(204307);
    this.gwE = paramInt;
    this.xXU = paramBoolean;
    this.GQ = LayoutInflater.from(getContext()).inflate(2131494919, this, false);
    if ((((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Oo(1) != 0) && (this.xXU))
    {
      this.xXS = new d(getContext(), this.gwE);
      this.xXS.setEmptyCallback(new c()
      {
        public final void dWH()
        {
          AppMethodBeat.i(204305);
          a.this.refreshView();
          AppMethodBeat.o(204305);
        }
      });
      addView(this.xXS, new FrameLayout.LayoutParams(-1, -1));
      paramInt = Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Odi, Integer.valueOf(0)));
      if (paramInt <= 0)
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Odi, Integer.valueOf(paramInt + 1));
        paramContext = new com.tencent.mm.ui.widget.a.g(getContext(), 2, 0, true);
        paramContext.T(getResources().getString(2131761231));
        paramContext.ape(1);
        paramContext.QOT = new g.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(204306);
            paramContext.bMo();
            AppMethodBeat.o(204306);
          }
        };
        paramContext.setCustomView(LayoutInflater.from(getContext()).inflate(2131494920, null));
        paramContext.dGm();
      }
      AppMethodBeat.o(204307);
      return;
    }
    addView(this.GQ);
    AppMethodBeat.o(204307);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(204308);
    if (((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Oo(1) == 0)
    {
      if ((this.xXS != null) && (indexOfChild(this.xXS) >= 0)) {
        removeView(this.xXS);
      }
      if ((this.GQ != null) && (indexOfChild(this.GQ) < 0)) {
        addView(this.GQ);
      }
    }
    AppMethodBeat.o(204308);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(184806);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "1");
    localHashMap.put("newmsg", String.valueOf(this.xXT));
    com.tencent.mm.game.report.f.a(getContext(), 13, 1300, 0, 1, this.gwE, com.tencent.mm.game.report.f.t(localHashMap));
    this.xXT = 0;
    AppMethodBeat.o(184806);
  }
  
  public final void setNewMessageCount(int paramInt)
  {
    this.xXT = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.a
 * JD-Core Version:    0.7.0.1
 */