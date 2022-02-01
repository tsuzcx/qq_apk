package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.ay.e;
import com.tencent.mm.ay.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.model.s;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.bottle.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.x.a;

public class BottleConversationUI
  extends MMActivity
{
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private String talker;
  private w tipDialog;
  private ListView vzp;
  private a vzq;
  private u.i vzr;
  
  public BottleConversationUI()
  {
    AppMethodBeat.i(22677);
    this.vzr = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(22676);
        BottleConversationUI.a(BottleConversationUI.this, BottleConversationUI.e(BottleConversationUI.this));
        AppMethodBeat.o(22676);
      }
    };
    this.isDeleteCancel = false;
    this.tipDialog = null;
    AppMethodBeat.o(22677);
  }
  
  public int getLayoutId()
  {
    return R.i.tmessage;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22682);
    int i = z.bAQ();
    int j = z.bBf();
    bh.bCz();
    com.tencent.mm.model.c.ban().B(7, Integer.valueOf(i | 0x1000));
    bh.bCz();
    com.tencent.mm.model.c.ban().B(34, Integer.valueOf(j & 0xFFFFFFBF));
    this.vzp = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.gvQ);
    this.vzq = new a(this, new x.a()
    {
      public final void bWC()
      {
        AppMethodBeat.i(22664);
        BottleConversationUI localBottleConversationUI = BottleConversationUI.this;
        String str = BottleConversationUI.this.getString(R.l.gvR);
        int i = s.bAD();
        if (i <= 0) {
          localBottleConversationUI.setMMTitle(str);
        }
        while (BottleConversationUI.a(BottleConversationUI.this).getCount() <= 0)
        {
          BottleConversationUI.b(BottleConversationUI.this).setVisibility(0);
          BottleConversationUI.c(BottleConversationUI.this).setVisibility(8);
          AppMethodBeat.o(22664);
          return;
          localBottleConversationUI.setMMTitle(str + "(" + i + ")");
        }
        BottleConversationUI.b(BottleConversationUI.this).setVisibility(8);
        BottleConversationUI.c(BottleConversationUI.this).setVisibility(0);
        AppMethodBeat.o(22664);
      }
    });
    this.vzq.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int eB(View paramAnonymousView)
      {
        AppMethodBeat.i(22669);
        int i = BottleConversationUI.c(BottleConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(22669);
        return i;
      }
    });
    this.vzq.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22670);
        BottleConversationUI.c(BottleConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(22670);
      }
    });
    this.vzq.a(new MMSlideDelView.f()
    {
      public final void es(Object paramAnonymousObject)
      {
        AppMethodBeat.i(22671);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.Bottle.BottleConversationUI", "onItemDel object null");
          AppMethodBeat.o(22671);
          return;
        }
        BottleConversationUI.a(BottleConversationUI.this, paramAnonymousObject.toString());
        AppMethodBeat.o(22671);
      }
    });
    this.vzp.setAdapter(this.vzq);
    final com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(this);
    this.vzp.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(22672);
        if (paramAnonymousInt < BottleConversationUI.c(BottleConversationUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.Bottle.BottleConversationUI", "on header view long click, ignore");
          AppMethodBeat.o(22672);
          return true;
        }
        locall.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BottleConversationUI.this, BottleConversationUI.d(BottleConversationUI.this));
        AppMethodBeat.o(22672);
        return true;
      }
    });
    this.vzp.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(22673);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/bottle/ui/BottleConversationUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = (bb)BottleConversationUI.a(BottleConversationUI.this).getItem(paramAnonymousInt);
        paramAnonymousView = new Intent();
        paramAnonymousView.addFlags(67108864);
        paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
        paramAnonymousView.putExtra("finish_direct", true);
        paramAnonymousView.putExtra("key_need_send_video", false);
        com.tencent.mm.plugin.bottle.a.pFn.d(paramAnonymousView, BottleConversationUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(22673);
      }
    });
    com.tencent.mm.plugin.bottle.a.pFo.aDx();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(22674);
        BottleConversationUI.this.finish();
        AppMethodBeat.o(22674);
        return true;
      }
    });
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22675);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = BottleConversationUI.c(BottleConversationUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22675);
      }
    });
    AppMethodBeat.o(22682);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22678);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(22678);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(22683);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.talker = ((bb)this.vzq.getItem(paramView.position)).field_username;
    int i = R.l.gvM;
    paramContextMenuInfo = this.vzq;
    bh.bCz();
    paramContextMenu.setHeaderTitle(getString(i, new Object[] { paramContextMenuInfo.ac(com.tencent.mm.model.c.bzA().JE(this.talker)) }));
    paramContextMenu.add(paramView.position, 0, 0, R.l.gvN);
    AppMethodBeat.o(22683);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22679);
    this.vzq.fSd();
    super.onDestroy();
    AppMethodBeat.o(22679);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22681);
    bh.bCz();
    com.tencent.mm.model.c.bzA().remove(this.vzq);
    bh.bCz();
    com.tencent.mm.model.c.bzG().remove(this.vzq);
    bh.bCz();
    Object localObject = com.tencent.mm.model.c.bzD().aaD(8);
    if ((localObject != null) && (((fi)localObject).field_msgId > 0L))
    {
      Log.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + ((cc)localObject).getCreateTime());
      bh.bCz();
      com.tencent.mm.model.c.ban().B(12306, Long.valueOf(((cc)localObject).getCreateTime()));
    }
    bh.bCz();
    localObject = com.tencent.mm.model.c.bzG().bxM("floatbottle");
    if ((localObject == null) || (Util.nullAsNil(((bd)localObject).field_username).length() <= 0)) {
      Log.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
    }
    for (;;)
    {
      this.vzq.onPause();
      super.onPause();
      AppMethodBeat.o(22681);
      return;
      ((bb)localObject).pG(0);
      bh.bCz();
      if (com.tencent.mm.model.c.bzG().c((bb)localObject, ((bd)localObject).field_username) == -1) {
        Log.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22680);
    super.onResume();
    bh.bCz();
    com.tencent.mm.model.c.bzA().add(this.vzq);
    bh.bCz();
    com.tencent.mm.model.c.bzG().add(this.vzq);
    this.vzq.onNotifyChange(null, null);
    AppMethodBeat.o(22680);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI
 * JD-Core Version:    0.7.0.1
 */