package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.api.c;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BizFastRejectMsgUI
  extends MMActivity
{
  private long fll;
  private int fsv;
  private int mWf;
  private long mWg;
  private MutableLiveData<Set<com.tencent.mm.plugin.brandservice.ui.timeline.b.a>> mWo;
  private Button mWp;
  private a mWq;
  private List<com.tencent.mm.plugin.brandservice.ui.timeline.b.a> mWr;
  private MRecyclerView mWs;
  private TextView mWt;
  private int mWu;
  
  public BizFastRejectMsgUI()
  {
    AppMethodBeat.i(5849);
    this.mWo = new MutableLiveData();
    AppMethodBeat.o(5849);
  }
  
  private static List<com.tencent.mm.plugin.brandservice.ui.timeline.b.a> cg(List<com.tencent.mm.plugin.brandservice.ui.timeline.b.a> paramList)
  {
    AppMethodBeat.i(5852);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.b.a locala = (com.tencent.mm.plugin.brandservice.ui.timeline.b.a)paramList.next();
      c localc = f.ei(locala.userName);
      if ((localc != null) && (localc.IW())) {
        localArrayList.add(locala);
      }
    }
    AppMethodBeat.o(5852);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131493195;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5850);
    super.onCreate(paramBundle);
    setMMTitle("文章推送设置");
    setActionbarColor(Color.parseColor("#F1F1F1"));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(5844);
        BizFastRejectMsgUI.this.finish();
        AppMethodBeat.o(5844);
        return true;
      }
    }, 2131230844);
    setBackBtnColorFilter(getResources().getColor(2131099732));
    this.mWf = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.mWu = getIntent().getIntExtra("key_time_line_msg_rank", 0);
    this.fsv = getIntent().getIntExtra("biz_time_line_line_enter_scene", 0);
    this.fll = getIntent().getLongExtra("key_time_line_msg_id", 0L);
    this.mWg = (System.currentTimeMillis() / 1000L);
    paramBundle = b.mWx;
    b.a(this.mWg, this.mWu, this.mWf, this.fsv, this.fll);
    this.mWp = ((Button)$(2131297593));
    this.mWp.setEnabled(false);
    this.mWp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(5847);
        paramAnonymousView = (Set)BizFastRejectMsgUI.d(BizFastRejectMsgUI.this).getValue();
        if ((paramAnonymousView == null) || (paramAnonymousView.isEmpty()))
        {
          BizFastRejectMsgUI.this.onBackPressed();
          AppMethodBeat.o(5847);
          return;
        }
        h.a(BizFastRejectMsgUI.this, BizFastRejectMsgUI.this.getString(2131756580), null, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(5846);
            BizFastRejectMsgUI.e(BizFastRejectMsgUI.this);
            t.cg(BizFastRejectMsgUI.this.getApplicationContext(), BizFastRejectMsgUI.this.getString(2131756579));
            BizFastRejectMsgUI.this.onBackPressed();
            AppMethodBeat.o(5846);
          }
        }, null);
        long l = System.currentTimeMillis() / 1000L;
        paramAnonymousView = paramAnonymousView.iterator();
        while (paramAnonymousView.hasNext())
        {
          com.tencent.mm.plugin.brandservice.ui.timeline.b.a locala = (com.tencent.mm.plugin.brandservice.ui.timeline.b.a)paramAnonymousView.next();
          b localb = b.mWx;
          b.a(locala.userName, l, 1, BizFastRejectMsgUI.f(BizFastRejectMsgUI.this), 1);
        }
        AppMethodBeat.o(5847);
      }
    });
    this.mWt = ((TextView)$(2131306150));
    this.mWt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(5848);
        paramAnonymousView = (Set)BizFastRejectMsgUI.d(BizFastRejectMsgUI.this).getValue();
        if ((paramAnonymousView == null) || (BizFastRejectMsgUI.b(BizFastRejectMsgUI.this) == null) || (BizFastRejectMsgUI.b(BizFastRejectMsgUI.this).size() == 0))
        {
          AppMethodBeat.o(5848);
          return;
        }
        if (paramAnonymousView.size() == BizFastRejectMsgUI.b(BizFastRejectMsgUI.this).size())
        {
          paramAnonymousView = BizFastRejectMsgUI.g(BizFastRejectMsgUI.this);
          paramAnonymousView.mWd.clear();
          paramAnonymousView.mWe.setValue(paramAnonymousView.mWd);
          paramAnonymousView.aql.notifyChanged();
          AppMethodBeat.o(5848);
          return;
        }
        paramAnonymousView = BizFastRejectMsgUI.g(BizFastRejectMsgUI.this);
        paramAnonymousView.mWd.addAll(paramAnonymousView.mWc);
        paramAnonymousView.mWe.setValue(paramAnonymousView.mWd);
        paramAnonymousView.aql.notifyChanged();
        AppMethodBeat.o(5848);
      }
    });
    this.mWs = ((MRecyclerView)$(2131304273));
    String str = getIntent().getStringExtra("key_reject_biz_info_xml");
    paramBundle = b.mWx;
    paramBundle = (List)new ArrayList();
    if (str == null) {}
    for (;;)
    {
      this.mWr = cg(paramBundle);
      if (this.mWr.isEmpty())
      {
        this.mWs.setVisibility(8);
        ((View)$(2131304520)).setVisibility(8);
        ((View)$(2131306123)).setVisibility(0);
      }
      this.mWq = new a(this.mWr, this.mWo, this.mWg, this.fll, this.mWf);
      this.mWs.setLayoutManager(new LinearLayoutManager());
      this.mWs.setAdapter(this.mWq);
      this.mWs.addHeaderView(getLayoutInflater().inflate(2131493197, null));
      this.mWo.observe(this, new Observer() {});
      AppMethodBeat.o(5850);
      return;
      Map localMap = bw.K(str, "sysmsg");
      if (localMap == null) {
        ad.i("MicroMsg.BizFastRejectTool", "parse xml failed , xml = %s", new Object[] { str });
      } else if ((String)localMap.get(".sysmsg.BizMsgRejectRecommend.BizAccount.UserName") == null) {
        ad.i("MicroMsg.BizFastRejectTool", "no msg in map , xml = %s", new Object[] { str });
      } else {
        paramBundle = b.d(localMap, 2147483647);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5851);
    super.onResume();
    if (isFinishing())
    {
      AppMethodBeat.o(5851);
      return;
    }
    int i = this.mWr.size();
    Iterator localIterator = this.mWr.iterator();
    while (localIterator.hasNext())
    {
      c localc = f.ei(((com.tencent.mm.plugin.brandservice.ui.timeline.b.a)localIterator.next()).userName);
      if ((localc == null) || (!localc.IW())) {
        localIterator.remove();
      }
    }
    if (this.mWr.isEmpty())
    {
      this.mWs.setVisibility(8);
      ((View)$(2131304520)).setVisibility(8);
      ((View)$(2131306123)).setVisibility(0);
      AppMethodBeat.o(5851);
      return;
    }
    if ((this.mWq != null) && (i != this.mWr.size())) {
      this.mWq.aql.notifyChanged();
    }
    AppMethodBeat.o(5851);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizFastRejectMsgUI
 * JD-Core Version:    0.7.0.1
 */