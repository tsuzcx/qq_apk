package com.tencent.mm.plugin.brandservice.ui.timeline;

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
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelimage.r;
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
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ac.b;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ai.d;
import com.tencent.mm.storage.ai.e;
import com.tencent.mm.storage.ai.f;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import java.util.Map;
import kotlin.g.b.s;

public class BizTimeLineNewMsgUI
  extends MMActivity
  implements h
{
  private TextView emptyTipTv;
  private int fromScene;
  private int hBm;
  private ListView qgc;
  View uiE;
  private com.tencent.mm.ui.widget.b.a vEV;
  private long vGG;
  private ProgressBar vGM;
  private TextView vGN;
  private View vGO;
  View vGP;
  View vGQ;
  private e vGR;
  private ab vGS;
  private int vGT;
  private u.i vGU;
  private int x_down;
  private int y_down;
  
  public BizTimeLineNewMsgUI()
  {
    AppMethodBeat.i(5923);
    this.fromScene = 1;
    this.x_down = 0;
    this.y_down = 0;
    this.hBm = 0;
    this.vGG = 0L;
    this.vGT = 0;
    this.vGU = new u.i()
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
            af.bHo().yQ(BizTimeLineNewMsgUI.m(BizTimeLineNewMsgUI.this).field_msgId);
          }
        }
      }
    };
    AppMethodBeat.o(5923);
  }
  
  public final void dcZ()
  {
    AppMethodBeat.i(5925);
    if (this.vGR != null) {
      this.vGR.notifyDataSetChanged();
    }
    AppMethodBeat.o(5925);
  }
  
  public int getLayoutId()
  {
    return d.f.biz_time_line_new_msg_activity;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5924);
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)$(d.e.empty_msg_tip_tv));
    this.emptyTipTv.setText(d.i.biz_time_line_empty_biz_new_msg_tip);
    setMMTitle(getString(d.i.biz_time_line_new_msg_title));
    this.hBm = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.vGG = (System.currentTimeMillis() / 1000L);
    this.fromScene = getIntent().getIntExtra("biz_time_line_line_enter_scene", 1);
    if (this.fromScene == 1) {}
    for (paramBundle = ag.s(af.bHo().omV.query("BizTimeLineSingleMsgInfo", null, "status!=?", new String[] { "4" }, null, null, "createTime DESC "));; paramBundle = ag.s(af.bHo().omV.query("BizTimeLineSingleMsgInfo", null, null, null, null, null, "createTime DESC limit 20")))
    {
      this.vGR = new e(this, paramBundle, this.fromScene, this.hBm, this.vGG);
      this.qgc = ((ListView)$(d.e.biz_time_line_new_msg_lv));
      paramBundle = this.qgc;
      this.uiE = getLayoutInflater().inflate(d.f.biz_time_line_footer_layout, null);
      this.vGM = ((ProgressBar)this.uiE.findViewById(d.e.biz_time_line_loading_more_pb));
      this.vGN = ((TextView)this.uiE.findViewById(d.e.biz_time_line_loading_more_tv));
      this.vGO = this.uiE.findViewById(d.e.bottom_line);
      this.vGP = this.uiE.findViewById(d.e.biz_time_line_loading_layout);
      this.vGQ = this.uiE.findViewById(d.e.biz_time_line_no_more_layout);
      paramBundle.addFooterView(this.uiE);
      this.qgc.setAdapter(this.vGR);
      this.qgc.setFooterDividersEnabled(false);
      this.qgc.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(5917);
          r.bKe().onScrollStateChanged(paramAnonymousInt);
          AppMethodBeat.o(5917);
        }
      });
      this.qgc.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5918);
          Object localObject1 = new b();
          ((b)localObject1).cH(paramAnonymousAdapterView);
          ((b)localObject1).cH(paramAnonymousView);
          ((b)localObject1).sc(paramAnonymousInt);
          ((b)localObject1).hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject1).aYj());
          localObject1 = BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).Hk(paramAnonymousInt);
          if (localObject1 == null)
          {
            Log.e("MicroMsg.BizTimeLineNewMsgUI", "onItemClick info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(5918);
            return;
          }
          paramAnonymousView = ((ab)localObject1).field_talker;
          int j = 0;
          int i;
          if (((ab)localObject1).iYh())
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("rawUrl", ((ab)localObject1).iYn().rDm);
            paramAnonymousAdapterView.putExtra("geta8key_username", ((ab)localObject1).iYn().userName);
            paramAnonymousAdapterView.putExtra("geta8key_scene", 56);
            c.b(BizTimeLineNewMsgUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
            i = j;
            paramAnonymousAdapterView = paramAnonymousView;
          }
          for (;;)
          {
            ai.a(paramAnonymousAdapterView, 1, i, ((ab)localObject1).field_msgId, paramAnonymousInt, BizTimeLineNewMsgUI.b(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this) - 1, (int)BizTimeLineNewMsgUI.d(BizTimeLineNewMsgUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(5918);
            return;
            if (ai.O((ab)localObject1))
            {
              Object localObject2 = BizTimeLineNewMsgUI.this.getContext();
              s.u(localObject2, "context");
              if ((localObject1 == null) || (Util.isNullOrNil(((ab)localObject1).field_content))) {}
              for (;;)
              {
                paramAnonymousAdapterView = ai.M((ab)localObject1);
                i = ai.h((ab)localObject1);
                break;
                if (((ab)localObject1).iYi())
                {
                  paramAnonymousAdapterView = XmlParser.parseXml(((ab)localObject1).field_content, "msg", null);
                  if (paramAnonymousAdapterView != null)
                  {
                    paramAnonymousView = (kotlin.g.a.a)new ai.d((ab)localObject1, paramAnonymousAdapterView, (Context)localObject2);
                    kotlin.g.a.a locala = (kotlin.g.a.a)new ai.e(paramAnonymousAdapterView, (Context)localObject2, (ab)localObject1);
                    localObject2 = (kotlin.g.a.a)new ai.f(paramAnonymousAdapterView, (ab)localObject1, (Context)localObject2);
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
            if (((ab)localObject1).field_msgId > 0L)
            {
              paramAnonymousAdapterView = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((ab)localObject1).field_msgId);
              if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.field_msgId == 0L))
              {
                k.cZ(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.this.getString(d.i.biz_time_line_new_msg_delete_tips));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(5918);
                return;
              }
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.putExtra("Chat_User", ((ab)localObject1).field_talker);
              paramAnonymousAdapterView.putExtra("finish_direct", true);
              paramAnonymousAdapterView.putExtra("from_global_search", true);
              paramAnonymousAdapterView.putExtra("msg_local_id", ((ab)localObject1).field_msgId);
              paramAnonymousAdapterView.putExtra("specific_chat_from_scene", 9);
              paramAnonymousAdapterView.putExtra("preChatTYPE", 13);
              c.g(BizTimeLineNewMsgUI.this.getContext(), ".ui.chatting.ChattingUI", paramAnonymousAdapterView);
              paramAnonymousAdapterView = paramAnonymousView;
              i = j;
            }
          }
        }
      });
      this.qgc.setEmptyView(this.emptyTipTv);
      if ((this.fromScene == 1) && (this.uiE != null))
      {
        this.vGM.setVisibility(8);
        this.vGN.setText(getString(d.i.biz_time_line_new_msg_show_more_msg));
        this.uiE.setBackgroundResource(d.d.biz_time_line_bg_selector);
        this.vGO.setVisibility(0);
        this.uiE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(5921);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            BizTimeLineNewMsgUI.i(BizTimeLineNewMsgUI.this).setOnClickListener(null);
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).vGH = true;
            BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).Hl(BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).getCount() - 1);
            BizTimeLineNewMsgUI.j(BizTimeLineNewMsgUI.this).setVisibility(0);
            BizTimeLineNewMsgUI.k(BizTimeLineNewMsgUI.this).setText(BizTimeLineNewMsgUI.this.getString(d.i.biz_time_line_loading_more_tips));
            BizTimeLineNewMsgUI.i(BizTimeLineNewMsgUI.this).setBackgroundColor(BizTimeLineNewMsgUI.this.getResources().getColor(d.b.biz_timeline_bg));
            BizTimeLineNewMsgUI.l(BizTimeLineNewMsgUI.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(5921);
          }
        });
      }
      this.qgc.setOnTouchListener(new View.OnTouchListener()
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
      this.vEV = new com.tencent.mm.ui.widget.b.a(this);
      this.qgc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5920);
          BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).Hk(paramAnonymousInt));
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
    paramContextMenu.add(0, 1, 0, d.i.biz_time_line_delete_msg);
    AppMethodBeat.o(5929);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5926);
    super.onDestroy();
    Object localObject = this.vGR;
    af.bHo().a(((e)localObject).vAF);
    localObject = af.bHo();
    ((ag)localObject).omV.execSQL("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4");
    ac.a locala = new ac.a();
    locala.acFX = ac.b.acGb;
    ((ag)localObject).a(locala);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI
 * JD-Core Version:    0.7.0.1
 */