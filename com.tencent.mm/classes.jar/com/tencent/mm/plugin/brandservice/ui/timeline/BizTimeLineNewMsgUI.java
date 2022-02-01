package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x.a;
import com.tencent.mm.storage.x.b;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.e;

public class BizTimeLineNewMsgUI
  extends MMActivity
  implements i
{
  private int dlK;
  private TextView emptyTipTv;
  private int fromScene;
  private ListView jpT;
  private int nYw;
  private int nYx;
  private com.tencent.mm.ui.widget.b.a nZK;
  private long oaT;
  View oaY;
  private ProgressBar oaZ;
  private TextView oba;
  private View obb;
  View obc;
  View obd;
  private f obe;
  private w obf;
  private int obg;
  private n.e obh;
  
  public BizTimeLineNewMsgUI()
  {
    AppMethodBeat.i(5923);
    this.fromScene = 1;
    this.nYw = 0;
    this.nYx = 0;
    this.dlK = 0;
    this.oaT = 0L;
    this.obg = 0;
    this.obh = new n.e()
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
          if (BizTimeLineNewMsgUI.j(BizTimeLineNewMsgUI.this) != null) {
            ag.aGg().Dv(BizTimeLineNewMsgUI.j(BizTimeLineNewMsgUI.this).field_msgId);
          }
        }
      }
    };
    AppMethodBeat.o(5923);
  }
  
  public final void bOo()
  {
    AppMethodBeat.i(5925);
    if (this.obe != null) {
      this.obe.notifyDataSetChanged();
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
    this.dlK = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.oaT = (System.currentTimeMillis() / 1000L);
    this.fromScene = getIntent().getIntExtra("biz_time_line_line_enter_scene", 1);
    if (this.fromScene == 1) {}
    for (paramBundle = z.o(ag.aGg().hHS.query("BizTimeLineSingleMsgInfo", null, "status!=?", new String[] { "4" }, null, null, "createTime DESC "));; paramBundle = z.o(ag.aGg().hHS.query("BizTimeLineSingleMsgInfo", null, null, null, null, null, "createTime DESC limit 20")))
    {
      this.obe = new f(this, paramBundle, this.fromScene, this.dlK, this.oaT);
      this.jpT = ((ListView)$(2131297355));
      paramBundle = this.jpT;
      this.oaY = getLayoutInflater().inflate(2131493205, null);
      this.oaZ = ((ProgressBar)this.oaY.findViewById(2131297352));
      this.oba = ((TextView)this.oaY.findViewById(2131297353));
      this.obb = this.oaY.findViewById(2131297453);
      this.obc = this.oaY.findViewById(2131297351);
      this.obd = this.oaY.findViewById(2131297359);
      paramBundle.addFooterView(this.oaY);
      this.jpT.setAdapter(this.obe);
      this.jpT.setFooterDividersEnabled(false);
      this.jpT.setOnScrollListener(new BizTimeLineNewMsgUI.2(this));
      this.jpT.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5918);
          b localb = new b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          paramAnonymousAdapterView = BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).zq(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            ad.e("MicroMsg.BizTimeLineNewMsgUI", "onItemClick info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(5918);
            return;
          }
          if (paramAnonymousAdapterView.fpg())
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.fpk().kwk);
            paramAnonymousView.putExtra("geta8key_username", paramAnonymousAdapterView.fpk().userName);
            paramAnonymousView.putExtra("geta8key_scene", 56);
            d.b(BizTimeLineNewMsgUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(5918);
            return;
            if (((l)g.ab(l.class)).dlK().xY(paramAnonymousAdapterView.field_msgId).field_msgId == 0L)
            {
              com.tencent.mm.ui.base.h.cl(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.this.getString(2131756630));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(5918);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_talker);
            paramAnonymousView.putExtra("finish_direct", true);
            paramAnonymousView.putExtra("from_global_search", true);
            paramAnonymousView.putExtra("msg_local_id", paramAnonymousAdapterView.field_msgId);
            paramAnonymousView.putExtra("specific_chat_from_scene", 9);
            paramAnonymousView.putExtra("preChatTYPE", 13);
            d.f(BizTimeLineNewMsgUI.this.getContext(), ".ui.chatting.ChattingUI", paramAnonymousView);
          }
        }
      });
      this.jpT.setEmptyView(this.emptyTipTv);
      if ((this.fromScene == 1) && (this.oaY != null))
      {
        this.oaZ.setVisibility(8);
        this.oba.setText(getString(2131756633));
        this.oaY.setBackgroundResource(2131231244);
        this.obb.setVisibility(0);
        this.oaY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(5921);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            BizTimeLineNewMsgUI.f(BizTimeLineNewMsgUI.this).setOnClickListener(null);
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).oaU = true;
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).zr(BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).getCount() - 1);
            BizTimeLineNewMsgUI.g(BizTimeLineNewMsgUI.this).setVisibility(0);
            BizTimeLineNewMsgUI.h(BizTimeLineNewMsgUI.this).setText(BizTimeLineNewMsgUI.this.getString(2131756625));
            BizTimeLineNewMsgUI.f(BizTimeLineNewMsgUI.this).setBackgroundColor(BizTimeLineNewMsgUI.this.getResources().getColor(2131100002));
            BizTimeLineNewMsgUI.i(BizTimeLineNewMsgUI.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(5921);
          }
        });
      }
      this.jpT.setOnTouchListener(new BizTimeLineNewMsgUI.4(this));
      this.nZK = new com.tencent.mm.ui.widget.b.a(this);
      this.jpT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5920);
          BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).zq(paramAnonymousInt));
          BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this, paramAnonymousInt);
          BizTimeLineNewMsgUI.e(BizTimeLineNewMsgUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.b(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.d(BizTimeLineNewMsgUI.this));
          AppMethodBeat.o(5920);
          return true;
        }
      });
      setBackBtn(new BizTimeLineNewMsgUI.1(this));
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
    Object localObject = this.obe;
    ag.aGg().a(((f)localObject).nVS);
    localObject = ag.aGg();
    ((z)localObject).hHS.execSQL("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4");
    x.a locala = new x.a();
    locala.IoG = x.b.IoK;
    ((z)localObject).a(locala);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI
 * JD-Core Version:    0.7.0.1
 */