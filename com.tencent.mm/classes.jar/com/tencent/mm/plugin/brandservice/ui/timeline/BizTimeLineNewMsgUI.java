package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.b;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.c.a;

public class BizTimeLineNewMsgUI
  extends MMActivity
  implements h
{
  private TextView emptyTipTv;
  private int fromScene;
  private ListView gJa;
  private int jUm;
  private int jUn;
  private a jVd;
  View jWo;
  private ProgressBar jWp;
  private TextView jWq;
  private View jWr;
  View jWs;
  View jWt;
  private e jWu;
  private q jWv;
  private n.d jWw;
  
  public BizTimeLineNewMsgUI()
  {
    AppMethodBeat.i(14163);
    this.fromScene = 1;
    this.jUm = 0;
    this.jUn = 0;
    this.jWw = new BizTimeLineNewMsgUI.7(this);
    AppMethodBeat.o(14163);
  }
  
  public final void aWN()
  {
    AppMethodBeat.i(14165);
    if (this.jWu != null) {
      this.jWu.notifyDataSetChanged();
    }
    AppMethodBeat.o(14165);
  }
  
  public int getLayoutId()
  {
    return 2130968877;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(14164);
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)$(2131821852));
    this.emptyTipTv.setText(2131297691);
    setMMTitle(getString(2131297718));
    this.fromScene = getIntent().getIntExtra("biz_time_line_line_enter_scene", 1);
    if (this.fromScene == 1) {}
    for (paramBundle = t.n(z.afp().fnw.query("BizTimeLineSingleMsgInfo", null, "status!=?", new String[] { "4" }, null, null, "createTime DESC "));; paramBundle = t.n(z.afp().fnw.query("BizTimeLineSingleMsgInfo", null, null, null, null, null, "createTime DESC limit 20")))
    {
      this.jWu = new e(this, paramBundle, this.fromScene);
      this.gJa = ((ListView)$(2131821899));
      paramBundle = this.gJa;
      this.jWo = getLayoutInflater().inflate(2130968869, null);
      this.jWp = ((ProgressBar)this.jWo.findViewById(2131821857));
      this.jWq = ((TextView)this.jWo.findViewById(2131821858));
      this.jWr = this.jWo.findViewById(2131821855);
      this.jWs = this.jWo.findViewById(2131821856);
      this.jWt = this.jWo.findViewById(2131821859);
      paramBundle.addFooterView(this.jWo);
      this.gJa.setAdapter(this.jWu);
      this.gJa.setFooterDividersEnabled(false);
      this.gJa.setOnScrollListener(new BizTimeLineNewMsgUI.2(this));
      this.gJa.setOnItemClickListener(new BizTimeLineNewMsgUI.3(this));
      this.gJa.setEmptyView(this.emptyTipTv);
      if ((this.fromScene == 1) && (this.jWo != null))
      {
        this.jWp.setVisibility(8);
        this.jWq.setText(getString(2131297717));
        this.jWo.setBackgroundResource(2130837948);
        this.jWr.setVisibility(0);
        this.jWo.setOnClickListener(new BizTimeLineNewMsgUI.6(this));
      }
      this.gJa.setOnTouchListener(new BizTimeLineNewMsgUI.4(this));
      this.jVd = new a(this);
      this.gJa.setOnItemLongClickListener(new BizTimeLineNewMsgUI.5(this));
      setBackBtn(new BizTimeLineNewMsgUI.1(this));
      setActionbarColor(-1052684);
      AppMethodBeat.o(14164);
      return;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(14169);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 1, 0, 2131297686);
    AppMethodBeat.o(14169);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(14166);
    super.onDestroy();
    Object localObject = this.jWu;
    z.afp().a(((e)localObject).jSD);
    localObject = z.afp();
    ((t)localObject).fnw.execSQL("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4");
    r.a locala = new r.a();
    locala.ywM = r.b.ywQ;
    ((t)localObject).a(locala);
    AppMethodBeat.o(14166);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(14168);
    super.onPause();
    AppMethodBeat.o(14168);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(14167);
    super.onResume();
    AppMethodBeat.o(14167);
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