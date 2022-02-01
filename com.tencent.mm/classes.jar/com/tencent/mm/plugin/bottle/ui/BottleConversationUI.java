package com.tencent.mm.plugin.bottle.ui;

import android.app.Activity;
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
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.g;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.o;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.bottle.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r.a;

public class BottleConversationUI
  extends MMActivity
{
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private ListView nUG;
  private a nUH;
  private n.e nUI;
  private String talker;
  private p tipDialog;
  
  public BottleConversationUI()
  {
    AppMethodBeat.i(22677);
    this.nUI = new n.e()
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
    return 2131495762;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22682);
    int i = u.aAq();
    int j = u.aAy();
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.ajl().set(7, Integer.valueOf(i | 0x1000));
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.ajl().set(34, Integer.valueOf(j & 0xFFFFFFBF));
    this.nUG = ((ListView)findViewById(2131305951));
    this.emptyTipTv = ((TextView)findViewById(2131299468));
    this.emptyTipTv.setText(2131756702);
    this.nUH = new a(this, new r.a()
    {
      public final void aSs()
      {
        AppMethodBeat.i(22664);
        BottleConversationUI localBottleConversationUI = BottleConversationUI.this;
        String str = BottleConversationUI.this.getString(2131756708);
        int i = o.aAe();
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
    this.nUH.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(22669);
        int i = BottleConversationUI.c(BottleConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(22669);
        return i;
      }
    });
    this.nUH.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22670);
        BottleConversationUI.c(BottleConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(22670);
      }
    });
    this.nUH.a(new MMSlideDelView.f()
    {
      public final void cP(Object paramAnonymousObject)
      {
        AppMethodBeat.i(22671);
        if (paramAnonymousObject == null)
        {
          ad.e("MicroMsg.Bottle.BottleConversationUI", "onItemDel object null");
          AppMethodBeat.o(22671);
          return;
        }
        BottleConversationUI.a(BottleConversationUI.this, paramAnonymousObject.toString());
        AppMethodBeat.o(22671);
      }
    });
    this.nUG.setAdapter(this.nUH);
    final com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(this);
    this.nUG.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(22672);
        if (paramAnonymousInt < BottleConversationUI.c(BottleConversationUI.this).getHeaderViewsCount())
        {
          ad.w("MicroMsg.Bottle.BottleConversationUI", "on header view long click, ignore");
          AppMethodBeat.o(22672);
          return true;
        }
        locall.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BottleConversationUI.this, BottleConversationUI.d(BottleConversationUI.this));
        AppMethodBeat.o(22672);
        return true;
      }
    });
    this.nUG.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(22673);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/bottle/ui/BottleConversationUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = (at)BottleConversationUI.a(BottleConversationUI.this).getItem(paramAnonymousInt);
        paramAnonymousView = new Intent();
        paramAnonymousView.addFlags(67108864);
        paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
        paramAnonymousView.putExtra("finish_direct", true);
        paramAnonymousView.putExtra("key_need_send_video", false);
        com.tencent.mm.plugin.bottle.a.iRG.d(paramAnonymousView, BottleConversationUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(22673);
      }
    });
    com.tencent.mm.plugin.bottle.a.iRH.MR();
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = BottleConversationUI.c(BottleConversationUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
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
    this.talker = ((at)this.nUH.getItem(paramView.position)).field_username;
    paramContextMenuInfo = this.nUH;
    com.tencent.mm.model.ba.aBQ();
    paramContextMenu.setHeaderTitle(getString(2131756698, new Object[] { paramContextMenuInfo.L(com.tencent.mm.model.c.azp().Bf(this.talker)) }));
    paramContextMenu.add(paramView.position, 0, 0, 2131756699);
    AppMethodBeat.o(22683);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22679);
    this.nUH.det();
    super.onDestroy();
    AppMethodBeat.o(22679);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22681);
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azp().b(this.nUH);
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azv().b(this.nUH);
    com.tencent.mm.model.ba.aBQ();
    Object localObject = com.tencent.mm.model.c.azs().JN(8);
    if ((localObject != null) && (((ei)localObject).field_msgId > 0L))
    {
      ad.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + ((ei)localObject).field_createTime);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.ajl().set(12306, Long.valueOf(((ei)localObject).field_createTime));
    }
    com.tencent.mm.model.ba.aBQ();
    localObject = com.tencent.mm.model.c.azv().aTz("floatbottle");
    if ((localObject == null) || (bt.nullAsNil(((com.tencent.mm.g.c.ba)localObject).field_username).length() <= 0)) {
      ad.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
    }
    for (;;)
    {
      this.nUH.onPause();
      super.onPause();
      AppMethodBeat.o(22681);
      return;
      ((at)localObject).kp(0);
      com.tencent.mm.model.ba.aBQ();
      if (com.tencent.mm.model.c.azv().a((at)localObject, ((com.tencent.mm.g.c.ba)localObject).field_username) == -1) {
        ad.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22680);
    super.onResume();
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azp().a(this.nUH);
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azv().a(this.nUH);
    this.nUH.a(null, null);
    AppMethodBeat.o(22680);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI
 * JD-Core Version:    0.7.0.1
 */