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
import com.tencent.mm.av.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.aa.b;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ag.d;
import com.tencent.mm.storage.ag.e;
import com.tencent.mm.storage.ag.f;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import java.util.Map;
import kotlin.g.b.p;

public class BizTimeLineNewMsgUI
  extends MMActivity
  implements g
{
  private int dEb;
  private TextView emptyTipTv;
  private int fromScene;
  private ListView krb;
  private int ppd;
  private int ppe;
  private com.tencent.mm.ui.widget.b.a pqr;
  private long prZ;
  View psf;
  private ProgressBar psg;
  private TextView psh;
  private View psi;
  View psj;
  View psk;
  private e psl;
  private z psm;
  private int psn;
  private o.g pso;
  
  public BizTimeLineNewMsgUI()
  {
    AppMethodBeat.i(5923);
    this.fromScene = 1;
    this.ppd = 0;
    this.ppe = 0;
    this.dEb = 0;
    this.prZ = 0L;
    this.psn = 0;
    this.pso = new o.g()
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
            com.tencent.mm.al.ag.bap().MX(BizTimeLineNewMsgUI.m(BizTimeLineNewMsgUI.this).field_msgId);
          }
        }
      }
    };
    AppMethodBeat.o(5923);
  }
  
  public final void cmy()
  {
    AppMethodBeat.i(5925);
    if (this.psl != null) {
      this.psl.notifyDataSetChanged();
    }
    AppMethodBeat.o(5925);
  }
  
  public int getLayoutId()
  {
    return 2131493261;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5924);
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)$(2131300096));
    this.emptyTipTv.setText(2131756748);
    setMMTitle(getString(2131756782));
    this.dEb = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.prZ = (System.currentTimeMillis() / 1000L);
    this.fromScene = getIntent().getIntExtra("biz_time_line_line_enter_scene", 1);
    if (this.fromScene == 1) {}
    for (paramBundle = ae.o(com.tencent.mm.al.ag.bap().iFy.query("BizTimeLineSingleMsgInfo", null, "status!=?", new String[] { "4" }, null, null, "createTime DESC "));; paramBundle = ae.o(com.tencent.mm.al.ag.bap().iFy.query("BizTimeLineSingleMsgInfo", null, null, null, null, null, "createTime DESC limit 20")))
    {
      this.psl = new e(this, paramBundle, this.fromScene, this.dEb, this.prZ);
      this.krb = ((ListView)$(2131297566));
      paramBundle = this.krb;
      this.psf = getLayoutInflater().inflate(2131493253, null);
      this.psg = ((ProgressBar)this.psf.findViewById(2131297563));
      this.psh = ((TextView)this.psf.findViewById(2131297564));
      this.psi = this.psf.findViewById(2131297683);
      this.psj = this.psf.findViewById(2131297562);
      this.psk = this.psf.findViewById(2131297571);
      paramBundle.addFooterView(this.psf);
      this.krb.setAdapter(this.psl);
      this.krb.setFooterDividersEnabled(false);
      this.krb.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(5917);
          q.bcV().onScrollStateChanged(paramAnonymousInt);
          AppMethodBeat.o(5917);
        }
      });
      this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5918);
          Object localObject1 = new b();
          ((b)localObject1).bm(paramAnonymousAdapterView);
          ((b)localObject1).bm(paramAnonymousView);
          ((b)localObject1).pH(paramAnonymousInt);
          ((b)localObject1).zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject1).axR());
          localObject1 = BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).De(paramAnonymousInt);
          if (localObject1 == null)
          {
            Log.e("MicroMsg.BizTimeLineNewMsgUI", "onItemClick info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(5918);
            return;
          }
          paramAnonymousView = ((z)localObject1).field_talker;
          int j = 0;
          int i;
          if (((z)localObject1).gAw())
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("rawUrl", ((z)localObject1).gAB().lDS);
            paramAnonymousAdapterView.putExtra("geta8key_username", ((z)localObject1).gAB().userName);
            paramAnonymousAdapterView.putExtra("geta8key_scene", 56);
            c.b(BizTimeLineNewMsgUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
            i = j;
            paramAnonymousAdapterView = paramAnonymousView;
          }
          for (;;)
          {
            com.tencent.mm.storage.ag.a(paramAnonymousAdapterView, 1, i, ((z)localObject1).field_msgId, paramAnonymousInt, BizTimeLineNewMsgUI.b(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this) - 1, (int)BizTimeLineNewMsgUI.d(BizTimeLineNewMsgUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(5918);
            return;
            if (com.tencent.mm.storage.ag.J((z)localObject1))
            {
              Object localObject2 = BizTimeLineNewMsgUI.this.getContext();
              p.h(localObject2, "context");
              if ((localObject1 == null) || (Util.isNullOrNil(((z)localObject1).field_content))) {}
              for (;;)
              {
                paramAnonymousAdapterView = com.tencent.mm.storage.ag.I((z)localObject1);
                i = com.tencent.mm.storage.ag.f((z)localObject1);
                break;
                if (((z)localObject1).gAx())
                {
                  paramAnonymousAdapterView = XmlParser.parseXml(((z)localObject1).field_content, "msg", null);
                  if (paramAnonymousAdapterView != null)
                  {
                    paramAnonymousView = (kotlin.g.a.a)new ag.d((z)localObject1, paramAnonymousAdapterView, (Context)localObject2);
                    kotlin.g.a.a locala = (kotlin.g.a.a)new ag.e(paramAnonymousAdapterView, (z)localObject1, (Context)localObject2);
                    localObject2 = (kotlin.g.a.a)new ag.f(paramAnonymousAdapterView, (z)localObject1, (Context)localObject2);
                    switch (Util.getInt((String)paramAnonymousAdapterView.get(".msg.appmsg.mmreader.notify_msg.act"), 0))
                    {
                    default: 
                      break;
                    case 1: 
                      paramAnonymousView.invoke();
                      break;
                    case 2: 
                      locala.invoke();
                      break;
                    case 3: 
                      ((kotlin.g.a.a)localObject2).invoke();
                    }
                  }
                }
              }
            }
            paramAnonymousAdapterView = paramAnonymousView;
            i = j;
            if (((z)localObject1).field_msgId > 0L)
            {
              if (((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(((z)localObject1).field_msgId).field_msgId == 0L)
              {
                com.tencent.mm.ui.base.h.cD(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.this.getString(2131756778));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(5918);
                return;
              }
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.putExtra("Chat_User", ((z)localObject1).field_talker);
              paramAnonymousAdapterView.putExtra("finish_direct", true);
              paramAnonymousAdapterView.putExtra("from_global_search", true);
              paramAnonymousAdapterView.putExtra("msg_local_id", ((z)localObject1).field_msgId);
              paramAnonymousAdapterView.putExtra("specific_chat_from_scene", 9);
              paramAnonymousAdapterView.putExtra("preChatTYPE", 13);
              c.f(BizTimeLineNewMsgUI.this.getContext(), ".ui.chatting.ChattingUI", paramAnonymousAdapterView);
              paramAnonymousAdapterView = paramAnonymousView;
              i = j;
            }
          }
        }
      });
      this.krb.setEmptyView(this.emptyTipTv);
      if ((this.fromScene == 1) && (this.psf != null))
      {
        this.psg.setVisibility(8);
        this.psh.setText(getString(2131756781));
        this.psf.setBackgroundResource(2131231304);
        this.psi.setVisibility(0);
        this.psf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(5921);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            BizTimeLineNewMsgUI.i(BizTimeLineNewMsgUI.this).setOnClickListener(null);
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).psa = true;
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).Df(BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).getCount() - 1);
            BizTimeLineNewMsgUI.j(BizTimeLineNewMsgUI.this).setVisibility(0);
            BizTimeLineNewMsgUI.k(BizTimeLineNewMsgUI.this).setText(BizTimeLineNewMsgUI.this.getString(2131756773));
            BizTimeLineNewMsgUI.i(BizTimeLineNewMsgUI.this).setBackgroundColor(BizTimeLineNewMsgUI.this.getResources().getColor(2131100027));
            BizTimeLineNewMsgUI.l(BizTimeLineNewMsgUI.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(5921);
          }
        });
      }
      this.krb.setOnTouchListener(new View.OnTouchListener()
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
      this.pqr = new com.tencent.mm.ui.widget.b.a(this);
      this.krb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5920);
          BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).De(paramAnonymousInt));
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
    paramContextMenu.add(0, 1, 0, 2131756743);
    AppMethodBeat.o(5929);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5926);
    super.onDestroy();
    Object localObject = this.psl;
    com.tencent.mm.al.ag.bap().a(((e)localObject).pmx);
    localObject = com.tencent.mm.al.ag.bap();
    ((ae)localObject).iFy.execSQL("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4");
    aa.a locala = new aa.a();
    locala.NQE = aa.b.NQI;
    ((ae)localObject).a(locala);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI
 * JD-Core Version:    0.7.0.1
 */