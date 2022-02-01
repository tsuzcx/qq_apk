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
import com.tencent.mm.al.f;
import com.tencent.mm.api.c;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bv;
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
  private long foF;
  private int fwc;
  private int nyE;
  private long nyF;
  private MutableLiveData<Set<com.tencent.mm.plugin.brandservice.ui.timeline.b.a>> nyN;
  private Button nyO;
  private a nyP;
  private List<com.tencent.mm.plugin.brandservice.ui.timeline.b.a> nyQ;
  private MRecyclerView nyR;
  private TextView nyS;
  private int nyT;
  
  public BizFastRejectMsgUI()
  {
    AppMethodBeat.i(5849);
    this.nyN = new MutableLiveData();
    AppMethodBeat.o(5849);
  }
  
  private static List<com.tencent.mm.plugin.brandservice.ui.timeline.b.a> ci(List<com.tencent.mm.plugin.brandservice.ui.timeline.b.a> paramList)
  {
    AppMethodBeat.i(5852);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.b.a locala = (com.tencent.mm.plugin.brandservice.ui.timeline.b.a)paramList.next();
      c localc = f.dX(locala.userName);
      if ((localc != null) && (localc.IF())) {
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
    this.nyE = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.nyT = getIntent().getIntExtra("key_time_line_msg_rank", 0);
    this.fwc = getIntent().getIntExtra("biz_time_line_line_enter_scene", 0);
    this.foF = getIntent().getLongExtra("key_time_line_msg_id", 0L);
    this.nyF = (System.currentTimeMillis() / 1000L);
    paramBundle = b.nyW;
    b.a(this.nyF, this.nyT, this.nyE, this.fwc, this.foF);
    this.nyO = ((Button)$(2131297593));
    this.nyO.setEnabled(false);
    this.nyO.setOnClickListener(new View.OnClickListener()
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
            t.ch(BizFastRejectMsgUI.this.getApplicationContext(), BizFastRejectMsgUI.this.getString(2131756579));
            BizFastRejectMsgUI.this.onBackPressed();
            AppMethodBeat.o(5846);
          }
        }, null);
        long l = System.currentTimeMillis() / 1000L;
        paramAnonymousView = paramAnonymousView.iterator();
        while (paramAnonymousView.hasNext())
        {
          com.tencent.mm.plugin.brandservice.ui.timeline.b.a locala = (com.tencent.mm.plugin.brandservice.ui.timeline.b.a)paramAnonymousView.next();
          b localb = b.nyW;
          b.a(locala.userName, l, 1, BizFastRejectMsgUI.f(BizFastRejectMsgUI.this), 1);
        }
        AppMethodBeat.o(5847);
      }
    });
    this.nyS = ((TextView)$(2131306150));
    this.nyS.setOnClickListener(new View.OnClickListener()
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
          paramAnonymousView.nyC.clear();
          paramAnonymousView.nyD.setValue(paramAnonymousView.nyC);
          paramAnonymousView.arg.notifyChanged();
          AppMethodBeat.o(5848);
          return;
        }
        paramAnonymousView = BizFastRejectMsgUI.g(BizFastRejectMsgUI.this);
        paramAnonymousView.nyC.addAll(paramAnonymousView.nyB);
        paramAnonymousView.nyD.setValue(paramAnonymousView.nyC);
        paramAnonymousView.arg.notifyChanged();
        AppMethodBeat.o(5848);
      }
    });
    this.nyR = ((MRecyclerView)$(2131304273));
    String str = getIntent().getStringExtra("key_reject_biz_info_xml");
    paramBundle = b.nyW;
    paramBundle = (List)new ArrayList();
    if (str == null) {}
    for (;;)
    {
      this.nyQ = ci(paramBundle);
      if (this.nyQ.isEmpty())
      {
        this.nyR.setVisibility(8);
        ((View)$(2131304520)).setVisibility(8);
        ((View)$(2131306123)).setVisibility(0);
      }
      this.nyP = new a(this.nyQ, this.nyN, this.nyF, this.foF, this.nyE);
      this.nyR.setLayoutManager(new LinearLayoutManager());
      this.nyR.setAdapter(this.nyP);
      this.nyR.addHeaderView(getLayoutInflater().inflate(2131493197, null));
      this.nyN.observe(this, new Observer() {});
      AppMethodBeat.o(5850);
      return;
      Map localMap = bv.L(str, "sysmsg");
      if (localMap == null) {
        ac.i("MicroMsg.BizFastRejectTool", "parse xml failed , xml = %s", new Object[] { str });
      } else if ((String)localMap.get(".sysmsg.BizMsgRejectRecommend.BizAccount.UserName") == null) {
        ac.i("MicroMsg.BizFastRejectTool", "no msg in map , xml = %s", new Object[] { str });
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
    int i = this.nyQ.size();
    Iterator localIterator = this.nyQ.iterator();
    while (localIterator.hasNext())
    {
      c localc = f.dX(((com.tencent.mm.plugin.brandservice.ui.timeline.b.a)localIterator.next()).userName);
      if ((localc == null) || (!localc.IF())) {
        localIterator.remove();
      }
    }
    if (this.nyQ.isEmpty())
    {
      this.nyR.setVisibility(8);
      ((View)$(2131304520)).setVisibility(8);
      ((View)$(2131306123)).setVisibility(0);
      AppMethodBeat.o(5851);
      return;
    }
    if ((this.nyP != null) && (i != this.nyQ.size())) {
      this.nyP.arg.notifyChanged();
    }
    AppMethodBeat.o(5851);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizFastRejectMsgUI
 * JD-Core Version:    0.7.0.1
 */