package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import java.util.HashMap;

public final class a
  extends FrameLayout
{
  d IWS;
  private int IWT;
  private boolean IWU;
  private View bEx;
  private int lCR;
  
  public a(final Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(276790);
    this.lCR = paramInt;
    this.IWU = paramBoolean;
    this.bEx = LayoutInflater.from(getContext()).inflate(h.f.HZX, this, false);
    if ((((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XC(1) != 0) && (this.IWU))
    {
      this.IWS = new d(getContext(), this.lCR);
      this.IWS.setEmptyCallback(new c()
      {
        public final void fHQ()
        {
          AppMethodBeat.i(276789);
          a.this.refreshView();
          AppMethodBeat.o(276789);
        }
      });
      addView(this.IWS, new FrameLayout.LayoutParams(-1, -1));
      paramInt = Util.nullAsNil((Integer)h.baE().ban().get(at.a.acSR, Integer.valueOf(0)));
      if (paramInt <= 0)
      {
        h.baE().ban().set(at.a.acSR, Integer.valueOf(paramInt + 1));
        paramContext = new j(getContext(), 2, 0, true);
        paramContext.au(getResources().getString(h.i.Ibf));
        paramContext.aFe(1);
        paramContext.agfR = new j.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(276787);
            paramContext.cyW();
            AppMethodBeat.o(276787);
          }
        };
        paramContext.setCustomView(LayoutInflater.from(getContext()).inflate(h.f.HZY, null));
        paramContext.dDn();
      }
      AppMethodBeat.o(276790);
      return;
    }
    addView(this.bEx);
    AppMethodBeat.o(276790);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(276797);
    if (((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XC(1) == 0)
    {
      if ((this.IWS != null) && (indexOfChild(this.IWS) >= 0)) {
        removeView(this.IWS);
      }
      if ((this.bEx != null) && (indexOfChild(this.bEx) < 0)) {
        addView(this.bEx);
      }
    }
    AppMethodBeat.o(276797);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(184806);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "1");
    localHashMap.put("newmsg", String.valueOf(this.IWT));
    g.a(getContext(), 13, 1300, 0, 1, this.lCR, g.s(localHashMap));
    this.IWT = 0;
    AppMethodBeat.o(184806);
  }
  
  public final void setNewMessageCount(int paramInt)
  {
    this.IWT = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.a
 * JD-Core Version:    0.7.0.1
 */