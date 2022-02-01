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
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.h;
import com.tencent.mm.plugin.game.model.o.o;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;

public final class f
  implements View.OnClickListener, View.OnLongClickListener
{
  private b Ddl;
  private int jaR;
  
  public f(int paramInt, b paramb)
  {
    this.jaR = paramInt;
    this.Ddl = paramb;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(183902);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    if (!(paramView.getTag() instanceof a))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(183902);
      return;
    }
    localObject = (a)paramView.getTag();
    if ((((a)localObject).DbB == null) || (((a)localObject).Ddp == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(183902);
      return;
    }
    int i = p.a(paramView.getContext(), ((a)localObject).DbB, ((a)localObject).Ddp, ((a)localObject).DbB.field_appId, this.jaR);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "2");
    if (((a)localObject).isNew) {}
    for (paramView = "1";; paramView = "2")
    {
      localHashMap.put("isnew", paramView);
      localHashMap.put("fold", String.valueOf(((a)localObject).DbB.field_hasMergedCount));
      localHashMap.put("ext_data", ((a)localObject).DbB.CJY);
      g.a(MMApplicationContext.getContext(), 13, 1301, ((a)localObject).CLN, i, 0, ((a)localObject).DbB.field_appId, this.jaR, ((a)localObject).DbB.CJW, ((a)localObject).DbB.field_gameMsgId, ((a)localObject).DbB.CJX, g.l(localHashMap));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(183902);
      return;
    }
  }
  
  public final boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(183903);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
    if (!(paramView.getTag() instanceof a))
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(183903);
      return false;
    }
    localObject = (a)paramView.getTag();
    if (((a)localObject).DbB == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(183903);
      return false;
    }
    com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(paramView.getContext(), paramView);
    locala.Yrf = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(183900);
        if (!Util.isNullOrNil(this.Ddm.DbB.CJR.CKQ))
        {
          if (!c.aKz(this.Ddm.DbB.CJR.CKQ)) {
            break label77;
          }
          paramAnonymousContextMenu.add(0, 13, 0, g.i.Cpv);
        }
        for (;;)
        {
          paramAnonymousContextMenu.add(0, 11, 0, g.i.CoC);
          AppMethodBeat.o(183900);
          return;
          label77:
          paramAnonymousContextMenu.add(0, 12, 0, g.i.Cpx);
        }
      }
    };
    locala.ODU = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(183901);
        if (paramAnonymousMenuItem.getItemId() == 11)
        {
          ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().delete(this.Ddm.DbB, new String[0]);
          if (f.a(f.this) != null)
          {
            f.a(f.this).ezQ();
            AppMethodBeat.o(183901);
          }
        }
        else
        {
          if (paramAnonymousMenuItem.getItemId() == 12)
          {
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f.a(MMApplicationContext.getContext());
            paramAnonymousMenuItem.bBl(MMApplicationContext.getResources().getString(g.i.Cpw)).ayp(g.i.Cpx).HL(true);
            paramAnonymousMenuItem.c(new f.c()
            {
              public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(195627);
                if (paramAnonymous2Boolean) {
                  c.bO(f.2.this.Ddm.DbB.CJR.CKQ, true);
                }
                AppMethodBeat.o(195627);
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
            c.bO(this.Ddm.DbB.CJR.CKQ, false);
            w.cR(paramView.getContext(), MMApplicationContext.getResources().getString(g.i.CpK));
          }
        }
        AppMethodBeat.o(183901);
      }
    };
    locala.eY(0, 0);
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(183903);
    return true;
  }
  
  public static final class a
  {
    public int CLN;
    public o DbB;
    public o.h Ddp;
    public boolean isNew;
    
    public a(o paramo, o.h paramh, int paramInt)
    {
      AppMethodBeat.i(184812);
      this.DbB = paramo;
      this.Ddp = paramh;
      this.CLN = paramInt;
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
    public abstract void ezQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.f
 * JD-Core Version:    0.7.0.1
 */