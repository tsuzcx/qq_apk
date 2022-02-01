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
import com.tencent.mm.am.af;
import com.tencent.mm.aw.o;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.storage.t.b;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;

public class BizTimeLineNewMsgUI
  extends MMActivity
  implements j
{
  private int dcS;
  private TextView emptyTipTv;
  private int fromScene;
  private ListView iwH;
  private int mUE;
  private int mUF;
  private com.tencent.mm.ui.widget.b.a mVN;
  private g mXA;
  private s mXB;
  private int mXC;
  private n.d mXD;
  private long mXp;
  View mXu;
  private ProgressBar mXv;
  private TextView mXw;
  private View mXx;
  View mXy;
  View mXz;
  
  public BizTimeLineNewMsgUI()
  {
    AppMethodBeat.i(5923);
    this.fromScene = 1;
    this.mUE = 0;
    this.mUF = 0;
    this.dcS = 0;
    this.mXp = 0L;
    this.mXC = 0;
    this.mXD = new n.d()
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
            af.awl().wc(BizTimeLineNewMsgUI.m(BizTimeLineNewMsgUI.this).field_msgId);
            paramAnonymousMenuItem = b.mWx;
            b.a(BizTimeLineNewMsgUI.m(BizTimeLineNewMsgUI.this), 2, BizTimeLineNewMsgUI.n(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.b(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.d(BizTimeLineNewMsgUI.this));
          }
        }
      }
    };
    AppMethodBeat.o(5923);
  }
  
  public final void bCM()
  {
    AppMethodBeat.i(5925);
    if (this.mXA != null) {
      this.mXA.notifyDataSetChanged();
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
    this.dcS = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.mXp = (System.currentTimeMillis() / 1000L);
    this.fromScene = getIntent().getIntExtra("biz_time_line_line_enter_scene", 1);
    if (this.fromScene == 1) {}
    for (paramBundle = v.p(af.awl().gPa.query("BizTimeLineSingleMsgInfo", null, "status!=?", new String[] { "4" }, null, null, "createTime DESC "));; paramBundle = v.p(af.awl().gPa.query("BizTimeLineSingleMsgInfo", null, null, null, null, null, "createTime DESC limit 20")))
    {
      this.mXA = new g(this, paramBundle, this.fromScene, this.dcS, this.mXp);
      this.iwH = ((ListView)$(2131297355));
      paramBundle = this.iwH;
      this.mXu = getLayoutInflater().inflate(2131493205, null);
      this.mXv = ((ProgressBar)this.mXu.findViewById(2131297352));
      this.mXw = ((TextView)this.mXu.findViewById(2131297353));
      this.mXx = this.mXu.findViewById(2131297453);
      this.mXy = this.mXu.findViewById(2131297351);
      this.mXz = this.mXu.findViewById(2131297359);
      paramBundle.addFooterView(this.mXu);
      this.iwH.setAdapter(this.mXA);
      this.iwH.setFooterDividersEnabled(false);
      this.iwH.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(5917);
          o.ayJ().cq(paramAnonymousInt);
          AppMethodBeat.o(5917);
        }
      });
      this.iwH.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5918);
          paramAnonymousAdapterView = BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).xP(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            ad.e("MicroMsg.BizTimeLineNewMsgUI", "onItemClick info is null");
            AppMethodBeat.o(5918);
            return;
          }
          if (paramAnonymousAdapterView.eJP())
          {
            ad.i("MicroMsg.BizTimeLineNewMsgUI", "System XML msg onItemClick");
            paramAnonymousView = b.mWx;
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
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.adn(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(5918);
              return;
              if (BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this) == 1) {
                paramAnonymousView.putExtra("biz_time_line_line_enter_scene", 0);
              }
            }
          }
          if (((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(paramAnonymousAdapterView.field_msgId).field_msgId == 0L)
          {
            com.tencent.mm.ui.base.h.cf(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.this.getString(2131756630));
            AppMethodBeat.o(5918);
            return;
          }
          paramAnonymousView = b.mWx;
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
      this.iwH.setEmptyView(this.emptyTipTv);
      if ((this.fromScene == 1) && (this.mXu != null))
      {
        this.mXv.setVisibility(8);
        this.mXw.setText(getString(2131756633));
        this.mXu.setBackgroundResource(2131231244);
        this.mXx.setVisibility(0);
        this.mXu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(5921);
            BizTimeLineNewMsgUI.i(BizTimeLineNewMsgUI.this).setOnClickListener(null);
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).mXq = true;
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).xQ(BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).getCount() - 1);
            BizTimeLineNewMsgUI.j(BizTimeLineNewMsgUI.this).setVisibility(0);
            BizTimeLineNewMsgUI.k(BizTimeLineNewMsgUI.this).setText(BizTimeLineNewMsgUI.this.getString(2131756625));
            BizTimeLineNewMsgUI.i(BizTimeLineNewMsgUI.this).setBackgroundColor(BizTimeLineNewMsgUI.this.getResources().getColor(2131100002));
            BizTimeLineNewMsgUI.l(BizTimeLineNewMsgUI.this).setVisibility(8);
            AppMethodBeat.o(5921);
          }
        });
      }
      this.iwH.setOnTouchListener(new View.OnTouchListener()
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
      this.mVN = new com.tencent.mm.ui.widget.b.a(this);
      this.iwH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5920);
          BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).xP(paramAnonymousInt));
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
    Object localObject = this.mXA;
    af.awl().a(((g)localObject).mSg);
    localObject = af.awl();
    ((v)localObject).gPa.execSQL("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4");
    t.a locala = new t.a();
    locala.FeG = t.b.FeK;
    ((v)localObject).a(locala);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI
 * JD-Core Version:    0.7.0.1
 */