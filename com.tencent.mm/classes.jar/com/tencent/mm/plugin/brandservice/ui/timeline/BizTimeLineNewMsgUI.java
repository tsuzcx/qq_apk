package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.al.ag;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ab.b;
import com.tencent.mm.storage.ab.c;
import com.tencent.mm.storage.ab.d;
import com.tencent.mm.storage.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x.a;
import com.tencent.mm.storage.x.b;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.e;
import d.g.b.p;
import java.util.Map;

public class BizTimeLineNewMsgUI
  extends MMActivity
  implements i
{
  private int dmM;
  private TextView emptyTipTv;
  private int fromScene;
  private ListView jsM;
  private int oef;
  private int oeg;
  private com.tencent.mm.ui.widget.b.a ofu;
  private long ogK;
  View ogP;
  private ProgressBar ogQ;
  private TextView ogR;
  private View ogS;
  View ogT;
  View ogU;
  private f ogV;
  private w ogW;
  private int ogX;
  private n.e ogY;
  
  public BizTimeLineNewMsgUI()
  {
    AppMethodBeat.i(5923);
    this.fromScene = 1;
    this.oef = 0;
    this.oeg = 0;
    this.dmM = 0;
    this.ogK = 0L;
    this.ogX = 0;
    this.ogY = new n.e()
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
          if (BizTimeLineNewMsgUI.m(BizTimeLineNewMsgUI.this) != null) {
            ag.aGw().DU(BizTimeLineNewMsgUI.m(BizTimeLineNewMsgUI.this).field_msgId);
          }
        }
      }
    };
    AppMethodBeat.o(5923);
  }
  
  public final void bPl()
  {
    AppMethodBeat.i(5925);
    if (this.ogV != null) {
      this.ogV.notifyDataSetChanged();
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
    this.dmM = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.ogK = (System.currentTimeMillis() / 1000L);
    this.fromScene = getIntent().getIntExtra("biz_time_line_line_enter_scene", 1);
    if (this.fromScene == 1) {}
    for (paramBundle = z.o(ag.aGw().hKK.query("BizTimeLineSingleMsgInfo", null, "status!=?", new String[] { "4" }, null, null, "createTime DESC "));; paramBundle = z.o(ag.aGw().hKK.query("BizTimeLineSingleMsgInfo", null, null, null, null, null, "createTime DESC limit 20")))
    {
      this.ogV = new f(this, paramBundle, this.fromScene, this.dmM, this.ogK);
      this.jsM = ((ListView)$(2131297355));
      paramBundle = this.jsM;
      this.ogP = getLayoutInflater().inflate(2131493205, null);
      this.ogQ = ((ProgressBar)this.ogP.findViewById(2131297352));
      this.ogR = ((TextView)this.ogP.findViewById(2131297353));
      this.ogS = this.ogP.findViewById(2131297453);
      this.ogT = this.ogP.findViewById(2131297351);
      this.ogU = this.ogP.findViewById(2131297359);
      paramBundle.addFooterView(this.ogP);
      this.jsM.setAdapter(this.ogV);
      this.jsM.setFooterDividersEnabled(false);
      this.jsM.setOnScrollListener(new BizTimeLineNewMsgUI.2(this));
      this.jsM.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5918);
          Object localObject1 = new b();
          ((b)localObject1).bd(paramAnonymousAdapterView);
          ((b)localObject1).bd(paramAnonymousView);
          ((b)localObject1).mu(paramAnonymousInt);
          ((b)localObject1).rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject1).ahF());
          paramAnonymousView = BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).zz(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            ae.e("MicroMsg.BizTimeLineNewMsgUI", "onItemClick info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(5918);
            return;
          }
          paramAnonymousAdapterView = paramAnonymousView.field_talker;
          int i = 0;
          if (paramAnonymousView.ftd())
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView.fti().kzz);
            ((Intent)localObject1).putExtra("geta8key_username", paramAnonymousView.fti().userName);
            ((Intent)localObject1).putExtra("geta8key_scene", 56);
            d.b(BizTimeLineNewMsgUI.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          }
          for (;;)
          {
            ab.a(paramAnonymousAdapterView, 1, i, paramAnonymousView.field_msgId, paramAnonymousInt, BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.d(BizTimeLineNewMsgUI.this) - 1, (int)BizTimeLineNewMsgUI.b(BizTimeLineNewMsgUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(5918);
            return;
            if (ab.x(paramAnonymousView))
            {
              Object localObject2 = BizTimeLineNewMsgUI.this.getContext();
              p.h(localObject2, "context");
              if ((paramAnonymousView == null) || (bu.isNullOrNil(paramAnonymousView.field_content))) {}
              for (;;)
              {
                paramAnonymousAdapterView = ab.v(paramAnonymousView);
                i = ab.d(paramAnonymousView);
                break;
                if (paramAnonymousView.fte())
                {
                  paramAnonymousAdapterView = bx.M(paramAnonymousView.field_content, "msg");
                  if (paramAnonymousAdapterView != null)
                  {
                    localObject1 = (d.g.a.a)new ab.b(paramAnonymousView, paramAnonymousAdapterView, (Context)localObject2);
                    d.g.a.a locala = (d.g.a.a)new ab.c(paramAnonymousAdapterView, paramAnonymousView, (Context)localObject2);
                    localObject2 = (d.g.a.a)new ab.d(paramAnonymousAdapterView, paramAnonymousView, (Context)localObject2);
                    switch (bu.getInt((String)paramAnonymousAdapterView.get(".msg.appmsg.mmreader.notify_msg.act"), 0))
                    {
                    default: 
                      break;
                    case 1: 
                      ((d.g.a.a)localObject1).invoke();
                      break;
                    case 2: 
                      locala.invoke();
                      break;
                    case 3: 
                      ((d.g.a.a)localObject2).invoke();
                    }
                  }
                }
              }
            }
            if (((l)g.ab(l.class)).doJ().ys(paramAnonymousView.field_msgId).field_msgId == 0L)
            {
              com.tencent.mm.ui.base.h.cm(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.this.getString(2131756630));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(5918);
              return;
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("Chat_User", paramAnonymousView.field_talker);
            ((Intent)localObject1).putExtra("finish_direct", true);
            ((Intent)localObject1).putExtra("from_global_search", true);
            ((Intent)localObject1).putExtra("msg_local_id", paramAnonymousView.field_msgId);
            ((Intent)localObject1).putExtra("specific_chat_from_scene", 9);
            ((Intent)localObject1).putExtra("preChatTYPE", 13);
            d.f(BizTimeLineNewMsgUI.this.getContext(), ".ui.chatting.ChattingUI", (Intent)localObject1);
          }
        }
      });
      this.jsM.setEmptyView(this.emptyTipTv);
      if ((this.fromScene == 1) && (this.ogP != null))
      {
        this.ogQ.setVisibility(8);
        this.ogR.setText(getString(2131756633));
        this.ogP.setBackgroundResource(2131231244);
        this.ogS.setVisibility(0);
        this.ogP.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(5921);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            BizTimeLineNewMsgUI.i(BizTimeLineNewMsgUI.this).setOnClickListener(null);
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).ogL = true;
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).zA(BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).getCount() - 1);
            BizTimeLineNewMsgUI.j(BizTimeLineNewMsgUI.this).setVisibility(0);
            BizTimeLineNewMsgUI.k(BizTimeLineNewMsgUI.this).setText(BizTimeLineNewMsgUI.this.getString(2131756625));
            BizTimeLineNewMsgUI.i(BizTimeLineNewMsgUI.this).setBackgroundColor(BizTimeLineNewMsgUI.this.getResources().getColor(2131100002));
            BizTimeLineNewMsgUI.l(BizTimeLineNewMsgUI.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(5921);
          }
        });
      }
      this.jsM.setOnTouchListener(new BizTimeLineNewMsgUI.4(this));
      this.ofu = new com.tencent.mm.ui.widget.b.a(this);
      this.jsM.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5920);
          BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).zz(paramAnonymousInt));
          BizTimeLineNewMsgUI.b(BizTimeLineNewMsgUI.this, paramAnonymousInt);
          BizTimeLineNewMsgUI.h(BizTimeLineNewMsgUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.e(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.f(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.g(BizTimeLineNewMsgUI.this));
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
    Object localObject = this.ogV;
    ag.aGw().a(((f)localObject).obB);
    localObject = ag.aGw();
    ((z)localObject).hKK.execSQL("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4");
    x.a locala = new x.a();
    locala.IIW = x.b.IJa;
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