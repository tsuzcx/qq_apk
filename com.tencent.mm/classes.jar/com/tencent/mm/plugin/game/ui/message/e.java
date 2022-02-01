package com.tencent.mm.plugin.game.ui.message;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.e;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;
import java.util.HashMap;

public final class e
  implements View.OnClickListener, View.OnLongClickListener
{
  private int fwc;
  private b tvF;
  
  public e(int paramInt, b paramb)
  {
    this.fwc = paramInt;
    this.tvF = paramb;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(183902);
    if (!(paramView.getTag() instanceof a))
    {
      AppMethodBeat.o(183902);
      return;
    }
    a locala = (a)paramView.getTag();
    if ((locala.tvI == null) || (locala.tvJ == null))
    {
      AppMethodBeat.o(183902);
      return;
    }
    int i = p.a(paramView.getContext(), locala.tvI, locala.tvJ, locala.tvI.field_appId, this.fwc);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "2");
    if (locala.isNew) {}
    for (paramView = "1";; paramView = "2")
    {
      localHashMap.put("isnew", paramView);
      localHashMap.put("fold", String.valueOf(locala.tvI.field_hasMergedCount));
      localHashMap.put("ext_data", locala.tvI.teK);
      com.tencent.mm.game.report.e.a(ai.getContext(), 13, 1301, locala.tgt, i, 0, locala.tvI.field_appId, this.fwc, locala.tvI.teI, locala.tvI.field_gameMsgId, locala.tvI.teJ, com.tencent.mm.game.report.e.k(localHashMap));
      AppMethodBeat.o(183902);
      return;
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(183903);
    if (!(paramView.getTag() instanceof a))
    {
      AppMethodBeat.o(183903);
      return false;
    }
    final a locala = (a)paramView.getTag();
    if (locala.tvI == null)
    {
      AppMethodBeat.o(183903);
      return false;
    }
    paramView = new a(paramView.getContext(), paramView);
    paramView.JiR = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(183900);
        paramAnonymousContextMenu.add(0, 11, 0, 2131759843);
        AppMethodBeat.o(183900);
      }
    };
    paramView.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(183901);
        if (paramAnonymousMenuItem.getItemId() == 11)
        {
          ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().delete(locala.tvI, new String[0]);
          if (e.a(e.this) != null) {
            e.a(e.this).cRC();
          }
        }
        AppMethodBeat.o(183901);
      }
    };
    paramView.ej(0, 0);
    AppMethodBeat.o(183903);
    return true;
  }
  
  public static final class a
  {
    public boolean isNew;
    public int tgt;
    public o tvI;
    public o.e tvJ;
    
    public a(o paramo, o.e parame, int paramInt)
    {
      AppMethodBeat.i(184812);
      this.tvI = paramo;
      this.tvJ = parame;
      this.tgt = paramInt;
      if (!paramo.field_isRead) {}
      for (boolean bool = true;; bool = false)
      {
        this.isNew = bool;
        AppMethodBeat.o(184812);
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void cRC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.e
 * JD-Core Version:    0.7.0.1
 */