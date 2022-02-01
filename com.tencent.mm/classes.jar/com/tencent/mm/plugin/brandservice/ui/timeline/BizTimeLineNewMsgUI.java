package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.av.o;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u.a;
import com.tencent.mm.storage.u.b;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;

public class BizTimeLineNewMsgUI
  extends MMActivity
  implements j
{
  private int daq;
  private TextView emptyTipTv;
  private int fromScene;
  private ListView iWK;
  private t nAa;
  private int nAb;
  private n.d nAc;
  private int nwY;
  private int nwZ;
  private com.tencent.mm.ui.widget.b.a nym;
  private long nzO;
  View nzT;
  private ProgressBar nzU;
  private TextView nzV;
  private View nzW;
  View nzX;
  View nzY;
  private g nzZ;
  
  public BizTimeLineNewMsgUI()
  {
    AppMethodBeat.i(5923);
    this.fromScene = 1;
    this.nwY = 0;
    this.nwZ = 0;
    this.daq = 0;
    this.nzO = 0L;
    this.nAb = 0;
    this.nAc = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(5922);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(5922);
          return;
          if (BizTimeLineNewMsgUI.m(BizTimeLineNewMsgUI.this) != null)
          {
            af.aDd().AF(BizTimeLineNewMsgUI.m(BizTimeLineNewMsgUI.this).field_msgId);
            paramAnonymousMenuItem = b.nyW;
            b.a(BizTimeLineNewMsgUI.m(BizTimeLineNewMsgUI.this), 2, BizTimeLineNewMsgUI.n(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.b(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.d(BizTimeLineNewMsgUI.this));
          }
        }
      }
    };
    AppMethodBeat.o(5923);
  }
  
  public final void bJU()
  {
    AppMethodBeat.i(5925);
    if (this.nzZ != null) {
      this.nzZ.notifyDataSetChanged();
    }
    AppMethodBeat.o(5925);
  }
  
  public int getLayoutId()
  {
    return 2131493213;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5924);
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)$(2131299468));
    this.emptyTipTv.setText(2131756607);
    setMMTitle(getString(2131756634));
    this.daq = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.nzO = (System.currentTimeMillis() / 1000L);
    this.fromScene = getIntent().getIntExtra("biz_time_line_line_enter_scene", 1);
    if (this.fromScene == 1) {}
    for (paramBundle = w.o(af.aDd().hpA.query("BizTimeLineSingleMsgInfo", null, "status!=?", new String[] { "4" }, null, null, "createTime DESC "));; paramBundle = w.o(af.aDd().hpA.query("BizTimeLineSingleMsgInfo", null, null, null, null, null, "createTime DESC limit 20")))
    {
      this.nzZ = new g(this, paramBundle, this.fromScene, this.daq, this.nzO);
      this.iWK = ((ListView)$(2131297355));
      paramBundle = this.iWK;
      this.nzT = getLayoutInflater().inflate(2131493205, null);
      this.nzU = ((ProgressBar)this.nzT.findViewById(2131297352));
      this.nzV = ((TextView)this.nzT.findViewById(2131297353));
      this.nzW = this.nzT.findViewById(2131297453);
      this.nzX = this.nzT.findViewById(2131297351);
      this.nzY = this.nzT.findViewById(2131297359);
      paramBundle.addFooterView(this.nzT);
      this.iWK.setAdapter(this.nzZ);
      this.iWK.setFooterDividersEnabled(false);
      this.iWK.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(5917);
          o.aFB().cp(paramAnonymousInt);
          AppMethodBeat.o(5917);
        }
      });
      this.iWK.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5918);
          paramAnonymousAdapterView = BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).yG(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            ac.e("MicroMsg.BizTimeLineNewMsgUI", "onItemClick info is null");
            AppMethodBeat.o(5918);
            return;
          }
          if (paramAnonymousAdapterView.eZn())
          {
            ac.i("MicroMsg.BizTimeLineNewMsgUI", "System XML msg onItemClick");
            paramAnonymousView = b.nyW;
            b.a(paramAnonymousAdapterView, 1, paramAnonymousInt, BizTimeLineNewMsgUI.b(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.d(BizTimeLineNewMsgUI.this));
            paramAnonymousView = new Intent(BizTimeLineNewMsgUI.this, BizFastRejectMsgUI.class);
            if (BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this) == 2) {
              paramAnonymousView.putExtra("biz_time_line_line_enter_scene", 1);
            }
            for (;;)
            {
              paramAnonymousView.putExtra("key_time_line_msg_rank", paramAnonymousInt);
              paramAnonymousView.putExtra("biz_time_line_line_session_id", BizTimeLineNewMsgUI.b(BizTimeLineNewMsgUI.this));
              paramAnonymousView.putExtra("key_time_line_msg_id", paramAnonymousAdapterView.field_msgId);
              paramAnonymousView.putExtra("key_reject_biz_info_xml", paramAnonymousAdapterView.field_content);
              paramAnonymousAdapterView = BizTimeLineNewMsgUI.this;
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.aeD(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(5918);
              return;
              if (BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this) == 1) {
                paramAnonymousView.putExtra("biz_time_line_line_enter_scene", 0);
              }
            }
          }
          if (((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(paramAnonymousAdapterView.field_msgId).field_msgId == 0L)
          {
            com.tencent.mm.ui.base.h.cg(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.this.getString(2131756630));
            AppMethodBeat.o(5918);
            return;
          }
          paramAnonymousView = b.nyW;
          b.a(paramAnonymousAdapterView, 1, paramAnonymousInt, BizTimeLineNewMsgUI.b(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.d(BizTimeLineNewMsgUI.this));
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_talker);
          paramAnonymousView.putExtra("finish_direct", true);
          paramAnonymousView.putExtra("from_global_search", true);
          paramAnonymousView.putExtra("msg_local_id", paramAnonymousAdapterView.field_msgId);
          paramAnonymousView.putExtra("specific_chat_from_scene", 9);
          paramAnonymousView.putExtra("preChatTYPE", 13);
          d.e(BizTimeLineNewMsgUI.this.getContext(), ".ui.chatting.ChattingUI", paramAnonymousView);
          AppMethodBeat.o(5918);
        }
      });
      this.iWK.setEmptyView(this.emptyTipTv);
      if ((this.fromScene == 1) && (this.nzT != null))
      {
        this.nzU.setVisibility(8);
        this.nzV.setText(getString(2131756633));
        this.nzT.setBackgroundResource(2131231244);
        this.nzW.setVisibility(0);
        this.nzT.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(5921);
            BizTimeLineNewMsgUI.i(BizTimeLineNewMsgUI.this).setOnClickListener(null);
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).nzP = true;
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).yH(BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).getCount() - 1);
            BizTimeLineNewMsgUI.j(BizTimeLineNewMsgUI.this).setVisibility(0);
            BizTimeLineNewMsgUI.k(BizTimeLineNewMsgUI.this).setText(BizTimeLineNewMsgUI.this.getString(2131756625));
            BizTimeLineNewMsgUI.i(BizTimeLineNewMsgUI.this).setBackgroundColor(BizTimeLineNewMsgUI.this.getResources().getColor(2131100002));
            BizTimeLineNewMsgUI.l(BizTimeLineNewMsgUI.this).setVisibility(8);
            AppMethodBeat.o(5921);
          }
        });
      }
      this.iWK.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(5919);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(5919);
            return false;
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this, (int)paramAnonymousMotionEvent.getRawX());
            BizTimeLineNewMsgUI.b(BizTimeLineNewMsgUI.this, (int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.nym = new com.tencent.mm.ui.widget.b.a(this);
      this.iWK.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5920);
          BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).yG(paramAnonymousInt));
          BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this, paramAnonymousInt);
          BizTimeLineNewMsgUI.h(BizTimeLineNewMsgUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.e(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.f(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.g(BizTimeLineNewMsgUI.this));
          AppMethodBeat.o(5920);
          return true;
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(5916);
          BizTimeLineNewMsgUI.this.finish();
          AppMethodBeat.o(5916);
          return true;
        }
      });
      AppMethodBeat.o(5924);
      return;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(5929);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 1, 0, 2131756602);
    AppMethodBeat.o(5929);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5926);
    super.onDestroy();
    Object localObject = this.nzZ;
    af.aDd().a(((g)localObject).nuw);
    localObject = af.aDd();
    ((w)localObject).hpA.execSQL("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4");
    u.a locala = new u.a();
    locala.GCq = u.b.GCu;
    ((w)localObject).a(locala);
    AppMethodBeat.o(5926);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5928);
    super.onPause();
    AppMethodBeat.o(5928);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5927);
    super.onResume();
    AppMethodBeat.o(5927);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI
 * JD-Core Version:    0.7.0.1
 */