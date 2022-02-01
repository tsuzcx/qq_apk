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
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.e;
import com.tencent.mm.ba.g;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.model.s;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.bottle.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s.a;

public class BottleConversationUI
  extends MMActivity
{
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private ListView pli;
  private a plj;
  private o.g plk;
  private String talker;
  private q tipDialog;
  
  public BottleConversationUI()
  {
    AppMethodBeat.i(22677);
    this.plk = new o.g()
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
    return 2131496720;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22682);
    int i = z.aUc();
    int j = z.aUl();
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(7, Integer.valueOf(i | 0x1000));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(34, Integer.valueOf(j & 0xFFFFFFBF));
    this.pli = ((ListView)findViewById(2131309254));
    this.emptyTipTv = ((TextView)findViewById(2131300096));
    this.emptyTipTv.setText(2131756860);
    this.plj = new a(this, new s.a()
    {
      public final void bnE()
      {
        AppMethodBeat.i(22664);
        BottleConversationUI localBottleConversationUI = BottleConversationUI.this;
        String str = BottleConversationUI.this.getString(2131756866);
        int i = s.aTQ();
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
    this.plj.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dr(View paramAnonymousView)
      {
        AppMethodBeat.i(22669);
        int i = BottleConversationUI.c(BottleConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(22669);
        return i;
      }
    });
    this.plj.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22670);
        BottleConversationUI.c(BottleConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(22670);
      }
    });
    this.plj.a(new MMSlideDelView.f()
    {
      public final void cZ(Object paramAnonymousObject)
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
    this.pli.setAdapter(this.plj);
    final com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(this);
    this.pli.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
    this.pli.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(22673);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/bottle/ui/BottleConversationUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = (az)BottleConversationUI.a(BottleConversationUI.this).getItem(paramAnonymousInt);
        paramAnonymousView = new Intent();
        paramAnonymousView.addFlags(67108864);
        paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
        paramAnonymousView.putExtra("finish_direct", true);
        paramAnonymousView.putExtra("key_need_send_video", false);
        com.tencent.mm.plugin.bottle.a.jRt.d(paramAnonymousView, BottleConversationUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/bottle/ui/BottleConversationUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(22673);
      }
    });
    com.tencent.mm.plugin.bottle.a.jRu.WZ();
    setBackBtn(new BottleConversationUI.8(this));
    setToTop(new BottleConversationUI.9(this));
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
    this.talker = ((az)this.plj.getItem(paramView.position)).field_username;
    paramContextMenuInfo = this.plj;
    bg.aVF();
    paramContextMenu.setHeaderTitle(getString(2131756856, new Object[] { paramContextMenuInfo.S(com.tencent.mm.model.c.aSN().Kn(this.talker)) }));
    paramContextMenu.add(paramView.position, 0, 0, 2131756857);
    AppMethodBeat.o(22683);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22679);
    this.plj.ebf();
    super.onDestroy();
    AppMethodBeat.o(22679);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22681);
    bg.aVF();
    com.tencent.mm.model.c.aSN().remove(this.plj);
    bg.aVF();
    com.tencent.mm.model.c.aST().remove(this.plj);
    bg.aVF();
    Object localObject = com.tencent.mm.model.c.aSQ().Qo(8);
    if ((localObject != null) && (((eo)localObject).field_msgId > 0L))
    {
      Log.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + ((eo)localObject).field_createTime);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(12306, Long.valueOf(((eo)localObject).field_createTime));
    }
    bg.aVF();
    localObject = com.tencent.mm.model.c.aST().bjY("floatbottle");
    if ((localObject == null) || (Util.nullAsNil(((bb)localObject).field_username).length() <= 0)) {
      Log.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
    }
    for (;;)
    {
      this.plj.onPause();
      super.onPause();
      AppMethodBeat.o(22681);
      return;
      ((az)localObject).nt(0);
      bg.aVF();
      if (com.tencent.mm.model.c.aST().a((az)localObject, ((bb)localObject).field_username) == -1) {
        Log.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22680);
    super.onResume();
    bg.aVF();
    com.tencent.mm.model.c.aSN().add(this.plj);
    bg.aVF();
    com.tencent.mm.model.c.aST().add(this.plj);
    this.plj.onNotifyChange(null, null);
    AppMethodBeat.o(22680);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI
 * JD-Core Version:    0.7.0.1
 */