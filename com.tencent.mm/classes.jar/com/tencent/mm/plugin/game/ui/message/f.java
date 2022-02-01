package com.tencent.mm.plugin.game.ui.message;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.n;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;

public final class f
  implements View.OnClickListener, View.OnLongClickListener
{
  private int gwE;
  private b xYF;
  
  public f(int paramInt, b paramb)
  {
    this.gwE = paramInt;
    this.xYF = paramb;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(183902);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if (!(paramView.getTag() instanceof a))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(183902);
      return;
    }
    localObject = (a)paramView.getTag();
    if ((((a)localObject).xYJ == null) || (((a)localObject).xYK == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(183902);
      return;
    }
    int i = p.a(paramView.getContext(), ((a)localObject).xYJ, ((a)localObject).xYK, ((a)localObject).xYJ.field_appId, this.gwE);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "2");
    if (((a)localObject).isNew) {}
    for (paramView = "1";; paramView = "2")
    {
      localHashMap.put("isnew", paramView);
      localHashMap.put("fold", String.valueOf(((a)localObject).xYJ.field_hasMergedCount));
      localHashMap.put("ext_data", ((a)localObject).xYJ.xFX);
      com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 13, 1301, ((a)localObject).xHK, i, 0, ((a)localObject).xYJ.field_appId, this.gwE, ((a)localObject).xYJ.xFV, ((a)localObject).xYJ.field_gameMsgId, ((a)localObject).xYJ.xFW, com.tencent.mm.game.report.f.t(localHashMap));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(183902);
      return;
    }
  }
  
  public final boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(183903);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
    if (!(paramView.getTag() instanceof a))
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(183903);
      return false;
    }
    localObject = (a)paramView.getTag();
    if (((a)localObject).xYJ == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(183903);
      return false;
    }
    com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(paramView.getContext(), paramView);
    locala.QSs = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(183900);
        if (!Util.isNullOrNil(this.xYG.xYJ.xFQ.xGN))
        {
          if (!c.aAN(this.xYG.xYJ.xFQ.xGN)) {
            break label75;
          }
          paramAnonymousContextMenu.add(0, 13, 0, 2131761315);
        }
        for (;;)
        {
          paramAnonymousContextMenu.add(0, 11, 0, 2131761178);
          AppMethodBeat.o(183900);
          return;
          label75:
          paramAnonymousContextMenu.add(0, 12, 0, 2131761317);
        }
      }
    };
    locala.HLY = new com.tencent.mm.ui.base.o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(183901);
        if (paramAnonymousMenuItem.getItemId() == 11)
        {
          ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().delete(this.xYG.xYJ, new String[0]);
          if (f.a(f.this) != null)
          {
            f.a(f.this).dWI();
            AppMethodBeat.o(183901);
          }
        }
        else
        {
          if (paramAnonymousMenuItem.getItemId() == 12)
          {
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f.a(MMApplicationContext.getContext());
            paramAnonymousMenuItem.bow(MMApplicationContext.getResources().getString(2131761316)).apa(2131761317).Dq(true);
            paramAnonymousMenuItem.c(new f.c()
            {
              public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(204323);
                if (paramAnonymous2Boolean) {
                  c.bJ(f.2.this.xYG.xYJ.xFQ.xGN, true);
                }
                AppMethodBeat.o(204323);
              }
            }).b(new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymous2DialogInterface) {}
            }).show();
            AppMethodBeat.o(183901);
            return;
          }
          if (paramAnonymousMenuItem.getItemId() == 13)
          {
            c.bJ(this.xYG.xYJ.xFQ.xGN, false);
            u.cG(paramView.getContext(), MMApplicationContext.getResources().getString(2131761340));
          }
        }
        AppMethodBeat.o(183901);
      }
    };
    locala.ez(0, 0);
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(183903);
    return true;
  }
  
  public static final class a
  {
    public boolean isNew;
    public int xHK;
    public o xYJ;
    public com.tencent.mm.plugin.game.model.o.g xYK;
    
    public a(o paramo, com.tencent.mm.plugin.game.model.o.g paramg, int paramInt)
    {
      AppMethodBeat.i(184812);
      this.xYJ = paramo;
      this.xYK = paramg;
      this.xHK = paramInt;
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
    public abstract void dWI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.f
 * JD-Core Version:    0.7.0.1
 */