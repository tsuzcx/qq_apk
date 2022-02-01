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
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.h;
import com.tencent.mm.plugin.game.model.o.o;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import java.util.HashMap;

public final class f
  implements View.OnClickListener, View.OnLongClickListener
{
  private b IXD;
  private int lCR;
  
  public f(int paramInt, b paramb)
  {
    this.lCR = paramInt;
    this.IXD = paramb;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(183902);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    if (!(paramView.getTag() instanceof a))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(183902);
      return;
    }
    localObject = (a)paramView.getTag();
    if ((((a)localObject).IVV == null) || (((a)localObject).IXH == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(183902);
      return;
    }
    int i = p.a(paramView.getContext(), ((a)localObject).IVV, ((a)localObject).IXH, ((a)localObject).IVV.field_appId, this.lCR);
    HashMap localHashMap = new HashMap();
    localHashMap.put("tab", "2");
    if (((a)localObject).isNew) {}
    for (paramView = "1";; paramView = "2")
    {
      localHashMap.put("isnew", paramView);
      localHashMap.put("fold", String.valueOf(((a)localObject).IVV.field_hasMergedCount));
      localHashMap.put("ext_data", ((a)localObject).IVV.IEi);
      g.a(MMApplicationContext.getContext(), 13, 1301, ((a)localObject).IFU, i, 0, ((a)localObject).IVV.field_appId, this.lCR, ((a)localObject).IVV.IEh, ((a)localObject).IVV.field_gameMsgId, ((a)localObject).IVV.mNoticeId, g.s(localHashMap));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(183902);
      return;
    }
  }
  
  public final boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(183903);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aYj());
    if (!(paramView.getTag() instanceof a))
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(183903);
      return false;
    }
    localObject = (a)paramView.getTag();
    if (((a)localObject).IVV == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(183903);
      return false;
    }
    com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(paramView.getContext(), paramView);
    locala.agjt = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(183900);
        if (!Util.isNullOrNil(this.IXE.IVV.IEc.IEY))
        {
          if (!c.aHq(this.IXE.IVV.IEc.IEY)) {
            break label77;
          }
          paramAnonymousContextMenu.add(0, 13, 0, h.i.IbD);
        }
        for (;;)
        {
          paramAnonymousContextMenu.add(0, 11, 0, h.i.IaK);
          AppMethodBeat.o(183900);
          return;
          label77:
          paramAnonymousContextMenu.add(0, 12, 0, h.i.IbF);
        }
      }
    };
    locala.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(183901);
        if (paramAnonymousMenuItem.getItemId() == 11)
        {
          ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().delete(this.IXE.IVV, new String[0]);
          if (f.a(f.this) != null)
          {
            f.a(f.this).fHR();
            AppMethodBeat.o(183901);
          }
        }
        else
        {
          if (paramAnonymousMenuItem.getItemId() == 12)
          {
            paramAnonymousMenuItem = new g.a(MMApplicationContext.getContext());
            paramAnonymousMenuItem.bDE(MMApplicationContext.getResources().getString(h.i.IbE)).aEX(h.i.IbF).NF(true);
            paramAnonymousMenuItem.c(new g.c()
            {
              public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(276798);
                if (paramAnonymous2Boolean) {
                  c.cj(f.2.this.IXE.IVV.IEc.IEY, true);
                }
                AppMethodBeat.o(276798);
              }
            }).d(new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymous2DialogInterface) {}
            }).show();
            AppMethodBeat.o(183901);
            return;
          }
          if (paramAnonymousMenuItem.getItemId() == 13)
          {
            c.cj(this.IXE.IVV.IEc.IEY, false);
            aa.db(paramView.getContext(), MMApplicationContext.getResources().getString(h.i.IbS));
          }
        }
        AppMethodBeat.o(183901);
      }
    };
    locala.cMz();
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(183903);
    return true;
  }
  
  public static final class a
  {
    public int IFU;
    public o IVV;
    public o.h IXH;
    public boolean isNew;
    
    public a(o paramo, o.h paramh, int paramInt)
    {
      AppMethodBeat.i(184812);
      this.IVV = paramo;
      this.IXH = paramh;
      this.IFU = paramInt;
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
    public abstract void fHR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.f
 * JD-Core Version:    0.7.0.1
 */