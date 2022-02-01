package com.tencent.mm.plugin.game.ui.message;

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
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.g;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.n.e;
import java.util.HashMap;

public final class e
  implements View.OnClickListener, View.OnLongClickListener
{
  private int fRv;
  private b uGt;
  
  public e(int paramInt, b paramb)
  {
    this.fRv = paramInt;
    this.uGt = paramb;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(183902);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    if (!(paramView.getTag() instanceof a))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(183902);
      return;
    }
    localObject = (a)paramView.getTag();
    if ((((a)localObject).uGw == null) || (((a)localObject).uGx == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(183902);
      return;
    }
    int i = p.a(paramView.getContext(), ((a)localObject).uGw, ((a)localObject).uGx, ((a)localObject).uGw.field_appId, this.fRv);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "2");
    if (((a)localObject).isNew) {}
    for (paramView = "1";; paramView = "2")
    {
      localHashMap.put("isnew", paramView);
      localHashMap.put("fold", String.valueOf(((a)localObject).uGw.field_hasMergedCount));
      localHashMap.put("ext_data", ((a)localObject).uGw.unF);
      com.tencent.mm.game.report.f.a(ak.getContext(), 13, 1301, ((a)localObject).upr, i, 0, ((a)localObject).uGw.field_appId, this.fRv, ((a)localObject).uGw.unD, ((a)localObject).uGw.field_gameMsgId, ((a)localObject).uGw.unE, com.tencent.mm.game.report.f.r(localHashMap));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(183902);
      return;
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(183903);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahF());
    if (!(paramView.getTag() instanceof a))
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(183903);
      return false;
    }
    localObject = (a)paramView.getTag();
    if (((a)localObject).uGw == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(183903);
      return false;
    }
    paramView = new com.tencent.mm.ui.widget.b.a(paramView.getContext(), paramView);
    paramView.LwG = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(183900);
        paramAnonymousContextMenu.add(0, 11, 0, 2131759843);
        AppMethodBeat.o(183900);
      }
    };
    paramView.LfT = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(183901);
        if (paramAnonymousMenuItem.getItemId() == 11)
        {
          ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().delete(this.uGv.uGw, new String[0]);
          if (e.a(e.this) != null) {
            e.a(e.this).dcY();
          }
        }
        AppMethodBeat.o(183901);
      }
    };
    paramView.el(0, 0);
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(183903);
    return true;
  }
  
  public static final class a
  {
    public boolean isNew;
    public o uGw;
    public o.g uGx;
    public int upr;
    
    public a(o paramo, o.g paramg, int paramInt)
    {
      AppMethodBeat.i(184812);
      this.uGw = paramo;
      this.uGx = paramg;
      this.upr = paramInt;
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
    public abstract void dcY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.e
 * JD-Core Version:    0.7.0.1
 */