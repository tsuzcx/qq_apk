package com.tencent.mm.plugin.bottle.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.p.a;

public class BottleConversationUI
  extends MMActivity
{
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private ListView jSl;
  private a jSm;
  private n.d jSn;
  private String talker;
  private p tipDialog;
  
  public BottleConversationUI()
  {
    AppMethodBeat.i(18566);
    this.jSn = new BottleConversationUI.10(this);
    this.isDeleteCancel = false;
    this.tipDialog = null;
    AppMethodBeat.o(18566);
  }
  
  public int getLayoutId()
  {
    return 2130971000;
  }
  
  public void initView()
  {
    AppMethodBeat.i(18571);
    int i = r.Zr();
    int j = r.Zy();
    aw.aaz();
    c.Ru().set(7, Integer.valueOf(i | 0x1000));
    aw.aaz();
    c.Ru().set(34, Integer.valueOf(j & 0xFFFFFFBF));
    this.jSl = ((ListView)findViewById(2131823736));
    this.emptyTipTv = ((TextView)findViewById(2131821852));
    this.emptyTipTv.setText(2131297778);
    this.jSm = new a(this, new p.a()
    {
      public final void apT()
      {
        AppMethodBeat.i(18553);
        BottleConversationUI localBottleConversationUI = BottleConversationUI.this;
        String str = BottleConversationUI.this.getString(2131297784);
        int i = com.tencent.mm.model.l.Zj();
        if (i <= 0) {
          localBottleConversationUI.setMMTitle(str);
        }
        while (BottleConversationUI.a(BottleConversationUI.this).getCount() <= 0)
        {
          BottleConversationUI.b(BottleConversationUI.this).setVisibility(0);
          BottleConversationUI.c(BottleConversationUI.this).setVisibility(8);
          AppMethodBeat.o(18553);
          return;
          localBottleConversationUI.setMMTitle(str + "(" + i + ")");
        }
        BottleConversationUI.b(BottleConversationUI.this).setVisibility(8);
        BottleConversationUI.c(BottleConversationUI.this).setVisibility(0);
        AppMethodBeat.o(18553);
      }
    });
    this.jSm.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dc(View paramAnonymousView)
      {
        AppMethodBeat.i(18558);
        int i = BottleConversationUI.c(BottleConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(18558);
        return i;
      }
    });
    this.jSm.setPerformItemClickListener(new BottleConversationUI.4(this));
    this.jSm.a(new BottleConversationUI.5(this));
    this.jSl.setAdapter(this.jSm);
    com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(this);
    this.jSl.setOnItemLongClickListener(new BottleConversationUI.6(this, locall));
    this.jSl.setOnItemClickListener(new BottleConversationUI.7(this));
    com.tencent.mm.plugin.bottle.a.gmP.BO();
    setBackBtn(new BottleConversationUI.8(this));
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(18564);
        BackwardSupportUtil.c.a(BottleConversationUI.c(BottleConversationUI.this));
        AppMethodBeat.o(18564);
      }
    });
    AppMethodBeat.o(18571);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18567);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(18567);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(18572);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.talker = ((ak)this.jSm.getItem(paramView.position)).field_username;
    paramContextMenuInfo = this.jSm;
    aw.aaz();
    paramContextMenu.setHeaderTitle(getString(2131297774, new Object[] { paramContextMenuInfo.E(c.YA().arw(this.talker)) }));
    paramContextMenu.add(paramView.position, 0, 0, 2131297775);
    AppMethodBeat.o(18572);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(18568);
    this.jSm.bKb();
    super.onDestroy();
    AppMethodBeat.o(18568);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(18570);
    aw.aaz();
    c.YA().b(this.jSm);
    aw.aaz();
    c.YF().b(this.jSm);
    aw.aaz();
    Object localObject = c.YC().yU(8);
    if ((localObject != null) && (((dd)localObject).field_msgId > 0L))
    {
      ab.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + ((dd)localObject).field_createTime);
      aw.aaz();
      c.Ru().set(12306, Long.valueOf(((dd)localObject).field_createTime));
    }
    aw.aaz();
    localObject = c.YF().arH("floatbottle");
    if ((localObject == null) || (bo.nullAsNil(((au)localObject).field_username).length() <= 0)) {
      ab.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
    }
    for (;;)
    {
      this.jSm.onPause();
      super.onPause();
      AppMethodBeat.o(18570);
      return;
      ((ak)localObject).hJ(0);
      aw.aaz();
      if (c.YF().a((ak)localObject, ((au)localObject).field_username) == -1) {
        ab.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(18569);
    super.onResume();
    aw.aaz();
    c.YA().a(this.jSm);
    aw.aaz();
    c.YF().a(this.jSm);
    this.jSm.a(null, null);
    AppMethodBeat.o(18569);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI
 * JD-Core Version:    0.7.0.1
 */