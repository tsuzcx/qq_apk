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
import com.tencent.mm.ao.af;
import com.tencent.mm.ay.q;
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.aa.b;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.ag.d;
import com.tencent.mm.storage.ag.e;
import com.tencent.mm.storage.ag.f;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.g;
import java.util.Map;
import kotlin.g.b.p;

public class BizTimeLineNewMsgUI
  extends MMActivity
  implements h
{
  private TextView emptyTipTv;
  private int fromScene;
  private int fwM;
  private ListView niO;
  private long sBg;
  View sBm;
  private ProgressBar sBn;
  private TextView sBo;
  private View sBp;
  View sBq;
  View sBr;
  private e sBs;
  private z sBt;
  private int sBu;
  private q.g sBv;
  private int syc;
  private int syd;
  private com.tencent.mm.ui.widget.b.a szq;
  
  public BizTimeLineNewMsgUI()
  {
    AppMethodBeat.i(5923);
    this.fromScene = 1;
    this.syc = 0;
    this.syd = 0;
    this.fwM = 0;
    this.sBg = 0L;
    this.sBu = 0;
    this.sBv = new q.g()
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
            af.bjD().UI(BizTimeLineNewMsgUI.m(BizTimeLineNewMsgUI.this).field_msgId);
          }
        }
      }
    };
    AppMethodBeat.o(5923);
  }
  
  public final void cAe()
  {
    AppMethodBeat.i(5925);
    if (this.sBs != null) {
      this.sBs.notifyDataSetChanged();
    }
    AppMethodBeat.o(5925);
  }
  
  public int getLayoutId()
  {
    return d.f.stO;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5924);
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)$(d.e.empty_msg_tip_tv));
    this.emptyTipTv.setText(d.i.suE);
    setMMTitle(getString(d.i.esT));
    this.fwM = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.sBg = (System.currentTimeMillis() / 1000L);
    this.fromScene = getIntent().getIntExtra("biz_time_line_line_enter_scene", 1);
    if (this.fromScene == 1) {}
    for (paramBundle = ae.r(af.bjD().lvy.query("BizTimeLineSingleMsgInfo", null, "status!=?", new String[] { "4" }, null, null, "createTime DESC "));; paramBundle = ae.r(af.bjD().lvy.query("BizTimeLineSingleMsgInfo", null, null, null, null, null, "createTime DESC limit 20")))
    {
      this.sBs = new e(this, paramBundle, this.fromScene, this.fwM, this.sBg);
      this.niO = ((ListView)$(d.e.sqX));
      paramBundle = this.niO;
      this.sBm = getLayoutInflater().inflate(d.f.stJ, null);
      this.sBn = ((ProgressBar)this.sBm.findViewById(d.e.sqU));
      this.sBo = ((TextView)this.sBm.findViewById(d.e.sqV));
      this.sBp = this.sBm.findViewById(d.e.bottom_line);
      this.sBq = this.sBm.findViewById(d.e.sqT);
      this.sBr = this.sBm.findViewById(d.e.sra);
      paramBundle.addFooterView(this.sBm);
      this.niO.setAdapter(this.sBs);
      this.niO.setFooterDividersEnabled(false);
      this.niO.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(5917);
          q.bml().onScrollStateChanged(paramAnonymousInt);
          AppMethodBeat.o(5917);
        }
      });
      this.niO.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5918);
          Object localObject1 = new b();
          ((b)localObject1).bn(paramAnonymousAdapterView);
          ((b)localObject1).bn(paramAnonymousView);
          ((b)localObject1).sg(paramAnonymousInt);
          ((b)localObject1).Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject1).aFi());
          localObject1 = BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).GK(paramAnonymousInt);
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
          if (((z)localObject1).hwD())
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("rawUrl", ((z)localObject1).hwJ().ozt);
            paramAnonymousAdapterView.putExtra("geta8key_username", ((z)localObject1).hwJ().userName);
            paramAnonymousAdapterView.putExtra("geta8key_scene", 56);
            c.b(BizTimeLineNewMsgUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
            i = j;
            paramAnonymousAdapterView = paramAnonymousView;
          }
          for (;;)
          {
            ag.a(paramAnonymousAdapterView, 1, i, ((z)localObject1).field_msgId, paramAnonymousInt, BizTimeLineNewMsgUI.b(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this) - 1, (int)BizTimeLineNewMsgUI.d(BizTimeLineNewMsgUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(5918);
            return;
            if (ag.P((z)localObject1))
            {
              Object localObject2 = BizTimeLineNewMsgUI.this.getContext();
              p.k(localObject2, "context");
              if ((localObject1 == null) || (Util.isNullOrNil(((z)localObject1).field_content))) {}
              for (;;)
              {
                paramAnonymousAdapterView = ag.N((z)localObject1);
                i = ag.f((z)localObject1);
                break;
                if (((z)localObject1).hwE())
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
              if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(((z)localObject1).field_msgId).field_msgId == 0L)
              {
                com.tencent.mm.ui.base.h.cO(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.this.getString(d.i.suR));
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
      this.niO.setEmptyView(this.emptyTipTv);
      if ((this.fromScene == 1) && (this.sBm != null))
      {
        this.sBn.setVisibility(8);
        this.sBo.setText(getString(d.i.suT));
        this.sBm.setBackgroundResource(d.d.spw);
        this.sBp.setVisibility(0);
        this.sBm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(5921);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            BizTimeLineNewMsgUI.i(BizTimeLineNewMsgUI.this).setOnClickListener(null);
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).sBh = true;
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).GL(BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).getCount() - 1);
            BizTimeLineNewMsgUI.j(BizTimeLineNewMsgUI.this).setVisibility(0);
            BizTimeLineNewMsgUI.k(BizTimeLineNewMsgUI.this).setText(BizTimeLineNewMsgUI.this.getString(d.i.suO));
            BizTimeLineNewMsgUI.i(BizTimeLineNewMsgUI.this).setBackgroundColor(BizTimeLineNewMsgUI.this.getResources().getColor(d.b.spf));
            BizTimeLineNewMsgUI.l(BizTimeLineNewMsgUI.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(5921);
          }
        });
      }
      this.niO.setOnTouchListener(new View.OnTouchListener()
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
      this.szq = new com.tencent.mm.ui.widget.b.a(this);
      this.niO.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5920);
          BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).GK(paramAnonymousInt));
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
    paramContextMenu.add(0, 1, 0, d.i.suC);
    AppMethodBeat.o(5929);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5926);
    super.onDestroy();
    Object localObject = this.sBs;
    af.bjD().a(((e)localObject).soO);
    localObject = af.bjD();
    ((ae)localObject).lvy.execSQL("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4");
    aa.a locala = new aa.a();
    locala.VeB = aa.b.VeF;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI
 * JD-Core Version:    0.7.0.1
 */