package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ai.z;
import com.tencent.mm.cf.h;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.b;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.widget.b.a;

public class BizTimeLineNewMsgUI
  extends DrawStatusBarActivity
  implements i
{
  private TextView emptyTipTv;
  private int fromScene = 1;
  private ListView fry;
  private int idy = 0;
  private int idz = 0;
  private a iep;
  private n.d ifj = new BizTimeLineNewMsgUI.7(this);
  TextView igA;
  private View igB;
  private f igC;
  private q igD;
  View igy;
  ProgressBar igz;
  
  public final void axW()
  {
    if (this.igC != null) {
      this.igC.notifyDataSetChanged();
    }
  }
  
  protected final int getLayoutId()
  {
    return b.e.biz_time_line_new_msg_activity;
  }
  
  protected final int getStatusBarColor()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return -1052684;
    }
    return super.getStatusBarColor();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)findViewById(b.d.empty_msg_tip_tv));
    this.emptyTipTv.setText(b.h.biz_time_line_empty_biz_new_msg_tip);
    setMMTitle(getString(b.h.biz_time_line_new_msg_title));
    this.fromScene = getIntent().getIntExtra("biz_time_line_line_enter_scene", 1);
    if (this.fromScene == 1) {}
    for (paramBundle = t.m(z.MF().dXo.query("BizTimeLineSingleMsgInfo", null, "status!=?", new String[] { "4" }, null, null, "createTime DESC "));; paramBundle = t.m(z.MF().dXo.query("BizTimeLineSingleMsgInfo", null, null, null, null, null, "createTime DESC limit 20")))
    {
      this.igC = new f(this, paramBundle, this.fromScene);
      this.fry = ((ListView)findViewById(b.d.biz_time_line_new_msg_lv));
      paramBundle = this.fry;
      this.igy = getLayoutInflater().inflate(b.e.biz_time_line_footer_layout, null);
      this.igz = ((ProgressBar)this.igy.findViewById(b.d.biz_time_line_loading_more_pb));
      this.igA = ((TextView)this.igy.findViewById(b.d.biz_time_line_loading_more_tv));
      this.igB = this.igy.findViewById(b.d.bottom_line);
      paramBundle.addFooterView(this.igy);
      this.fry.setAdapter(this.igC);
      this.fry.setFooterDividersEnabled(false);
      this.fry.setOnScrollListener(new BizTimeLineNewMsgUI.2(this));
      this.fry.setOnItemClickListener(new BizTimeLineNewMsgUI.3(this));
      this.fry.setEmptyView(this.emptyTipTv);
      if ((this.fromScene == 1) && (this.igy != null))
      {
        this.igz.setVisibility(8);
        this.igA.setText(getString(b.h.biz_time_line_new_msg_show_more_msg));
        this.igy.setBackgroundResource(b.c.biz_time_line_bg_selector);
        this.igB.setVisibility(0);
        this.igy.setOnClickListener(new BizTimeLineNewMsgUI.6(this));
      }
      this.fry.setOnTouchListener(new BizTimeLineNewMsgUI.4(this));
      this.iep = new a(this);
      this.fry.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.a(BizTimeLineNewMsgUI.this).oy(paramAnonymousInt));
          BizTimeLineNewMsgUI.e(BizTimeLineNewMsgUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.b(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.c(BizTimeLineNewMsgUI.this), BizTimeLineNewMsgUI.d(BizTimeLineNewMsgUI.this));
          return true;
        }
      });
      setBackBtn(new BizTimeLineNewMsgUI.1(this));
      ta(-1052684);
      return;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 1, 0, b.h.biz_time_line_delete_msg);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.igC;
    z.MF().a(((f)localObject).ibN);
    localObject = z.MF();
    ((t)localObject).dXo.gk("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4");
    r.a locala = new r.a();
    locala.unb = r.b.unf;
    ((t)localObject).b(locala);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI
 * JD-Core Version:    0.7.0.1
 */