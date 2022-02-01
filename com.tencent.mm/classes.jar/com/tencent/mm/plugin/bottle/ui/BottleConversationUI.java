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
import com.tencent.mm.bb.f;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.o;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.bottle.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q.a;

public class BottleConversationUI
  extends MMActivity
{
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private ListView mRu;
  private a mRv;
  private n.d mRw;
  private String talker;
  private p tipDialog;
  
  public BottleConversationUI()
  {
    AppMethodBeat.i(22677);
    this.mRw = new n.d()
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
    int i = u.aqK();
    int j = u.aqS();
    az.arV();
    com.tencent.mm.model.c.afk().set(7, Integer.valueOf(i | 0x1000));
    az.arV();
    com.tencent.mm.model.c.afk().set(34, Integer.valueOf(j & 0xFFFFFFBF));
    this.mRu = ((ListView)findViewById(2131305951));
    this.emptyTipTv = ((TextView)findViewById(2131299468));
    this.emptyTipTv.setText(2131756702);
    this.mRv = new a(this, new q.a()
    {
      public final void aIp()
      {
        AppMethodBeat.i(22664);
        BottleConversationUI localBottleConversationUI = BottleConversationUI.this;
        String str = BottleConversationUI.this.getString(2131756708);
        int i = o.aqz();
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
    this.mRv.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dw(View paramAnonymousView)
      {
        AppMethodBeat.i(22669);
        int i = BottleConversationUI.c(BottleConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(22669);
        return i;
      }
    });
    this.mRv.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22670);
        BottleConversationUI.c(BottleConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(22670);
      }
    });
    this.mRv.a(new MMSlideDelView.f()
    {
      public final void cO(Object paramAnonymousObject)
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
    this.mRu.setAdapter(this.mRv);
    final com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(this);
    this.mRu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
    this.mRu.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(22673);
        paramAnonymousAdapterView = (am)BottleConversationUI.a(BottleConversationUI.this).getItem(paramAnonymousInt);
        paramAnonymousView = new Intent();
        paramAnonymousView.addFlags(67108864);
        paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
        paramAnonymousView.putExtra("finish_direct", true);
        paramAnonymousView.putExtra("key_need_send_video", false);
        com.tencent.mm.plugin.bottle.a.hYt.d(paramAnonymousView, BottleConversationUI.this);
        AppMethodBeat.o(22673);
      }
    });
    com.tencent.mm.plugin.bottle.a.hYu.Ll();
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
        paramAnonymousView = BottleConversationUI.c(BottleConversationUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
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
    this.talker = ((am)this.mRv.getItem(paramView.position)).field_username;
    paramContextMenuInfo = this.mRv;
    az.arV();
    paramContextMenu.setHeaderTitle(getString(2131756698, new Object[] { paramContextMenuInfo.K(com.tencent.mm.model.c.apM().aHY(this.talker)) }));
    paramContextMenu.add(paramView.position, 0, 0, 2131756699);
    AppMethodBeat.o(22683);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22679);
    this.mRv.cHX();
    super.onDestroy();
    AppMethodBeat.o(22679);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22681);
    az.arV();
    com.tencent.mm.model.c.apM().b(this.mRv);
    az.arV();
    com.tencent.mm.model.c.apR().b(this.mRv);
    az.arV();
    Object localObject = com.tencent.mm.model.c.apO().Gu(8);
    if ((localObject != null) && (((du)localObject).field_msgId > 0L))
    {
      ad.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + ((du)localObject).field_createTime);
      az.arV();
      com.tencent.mm.model.c.afk().set(12306, Long.valueOf(((du)localObject).field_createTime));
    }
    az.arV();
    localObject = com.tencent.mm.model.c.apR().aIn("floatbottle");
    if ((localObject == null) || (bt.nullAsNil(((ay)localObject).field_username).length() <= 0)) {
      ad.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
    }
    for (;;)
    {
      this.mRv.onPause();
      super.onPause();
      AppMethodBeat.o(22681);
      return;
      ((am)localObject).jT(0);
      az.arV();
      if (com.tencent.mm.model.c.apR().a((am)localObject, ((ay)localObject).field_username) == -1) {
        ad.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22680);
    super.onResume();
    az.arV();
    com.tencent.mm.model.c.apM().a(this.mRv);
    az.arV();
    com.tencent.mm.model.c.apR().a(this.mRv);
    this.mRv.a(null, null);
    AppMethodBeat.o(22680);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI
 * JD-Core Version:    0.7.0.1
 */