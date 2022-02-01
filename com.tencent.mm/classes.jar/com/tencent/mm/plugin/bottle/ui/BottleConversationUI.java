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
import com.tencent.mm.ba.e;
import com.tencent.mm.ba.g;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.o;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.bottle.a.b;
import com.tencent.mm.plugin.bottle.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r.a;

public class BottleConversationUI
  extends MMActivity
{
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private ListView ntK;
  private a ntL;
  private n.d ntM;
  private String talker;
  private p tipDialog;
  
  public BottleConversationUI()
  {
    AppMethodBeat.i(22677);
    this.ntM = new n.d()
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
    int i = u.axA();
    int j = u.axI();
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.agA().set(7, Integer.valueOf(i | 0x1000));
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.agA().set(34, Integer.valueOf(j & 0xFFFFFFBF));
    this.ntK = ((ListView)findViewById(2131305951));
    this.emptyTipTv = ((TextView)findViewById(2131299468));
    this.emptyTipTv.setText(2131756702);
    this.ntL = new a(this, new r.a()
    {
      public final void aPg()
      {
        AppMethodBeat.i(22664);
        BottleConversationUI localBottleConversationUI = BottleConversationUI.this;
        String str = BottleConversationUI.this.getString(2131756708);
        int i = o.axp();
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
    this.ntL.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dy(View paramAnonymousView)
      {
        AppMethodBeat.i(22669);
        int i = BottleConversationUI.c(BottleConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(22669);
        return i;
      }
    });
    this.ntL.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22670);
        BottleConversationUI.c(BottleConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(22670);
      }
    });
    this.ntL.a(new MMSlideDelView.f()
    {
      public final void cN(Object paramAnonymousObject)
      {
        AppMethodBeat.i(22671);
        if (paramAnonymousObject == null)
        {
          ac.e("MicroMsg.Bottle.BottleConversationUI", "onItemDel object null");
          AppMethodBeat.o(22671);
          return;
        }
        BottleConversationUI.a(BottleConversationUI.this, paramAnonymousObject.toString());
        AppMethodBeat.o(22671);
      }
    });
    this.ntK.setAdapter(this.ntL);
    final com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(this);
    this.ntK.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(22672);
        if (paramAnonymousInt < BottleConversationUI.c(BottleConversationUI.this).getHeaderViewsCount())
        {
          ac.w("MicroMsg.Bottle.BottleConversationUI", "on header view long click, ignore");
          AppMethodBeat.o(22672);
          return true;
        }
        locall.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BottleConversationUI.this, BottleConversationUI.d(BottleConversationUI.this));
        AppMethodBeat.o(22672);
        return true;
      }
    });
    this.ntK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(22673);
        paramAnonymousAdapterView = (ap)BottleConversationUI.a(BottleConversationUI.this).getItem(paramAnonymousInt);
        paramAnonymousView = new Intent();
        paramAnonymousView.addFlags(67108864);
        paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
        paramAnonymousView.putExtra("finish_direct", true);
        paramAnonymousView.putExtra("key_need_send_video", false);
        com.tencent.mm.plugin.bottle.a.iyx.d(paramAnonymousView, BottleConversationUI.this);
        AppMethodBeat.o(22673);
      }
    });
    com.tencent.mm.plugin.bottle.a.iyy.Lj();
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
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
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
    this.talker = ((ap)this.ntL.getItem(paramView.position)).field_username;
    paramContextMenuInfo = this.ntL;
    com.tencent.mm.model.az.ayM();
    paramContextMenu.setHeaderTitle(getString(2131756698, new Object[] { paramContextMenuInfo.L(com.tencent.mm.model.c.awB().aNt(this.talker)) }));
    paramContextMenu.add(paramView.position, 0, 0, 2131756699);
    AppMethodBeat.o(22683);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22679);
    this.ntL.cVi();
    super.onDestroy();
    AppMethodBeat.o(22679);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22681);
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awB().b(this.ntL);
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awG().b(this.ntL);
    com.tencent.mm.model.az.ayM();
    Object localObject = com.tencent.mm.model.c.awD().Iq(8);
    if ((localObject != null) && (((dy)localObject).field_msgId > 0L))
    {
      ac.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + ((dy)localObject).field_createTime);
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.agA().set(12306, Long.valueOf(((dy)localObject).field_createTime));
    }
    com.tencent.mm.model.az.ayM();
    localObject = com.tencent.mm.model.c.awG().aNI("floatbottle");
    if ((localObject == null) || (bs.nullAsNil(((com.tencent.mm.g.c.az)localObject).field_username).length() <= 0)) {
      ac.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
    }
    for (;;)
    {
      this.ntL.onPause();
      super.onPause();
      AppMethodBeat.o(22681);
      return;
      ((ap)localObject).jR(0);
      com.tencent.mm.model.az.ayM();
      if (com.tencent.mm.model.c.awG().a((ap)localObject, ((com.tencent.mm.g.c.az)localObject).field_username) == -1) {
        ac.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22680);
    super.onResume();
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awB().a(this.ntL);
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awG().a(this.ntL);
    this.ntL.a(null, null);
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