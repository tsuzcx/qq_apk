package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ay.e;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.k;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.bottle.a.b;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.j;

public class BottleConversationUI
  extends MMActivity
{
  private TextView emptyTipTv;
  private ListView hZn;
  private a hZo;
  private String hZp;
  private n.d hZq = new BottleConversationUI.2(this);
  private boolean isDeleteCancel = false;
  private String talker;
  private p tipDialog = null;
  
  protected final int getLayoutId()
  {
    return R.i.tmessage;
  }
  
  protected final void initView()
  {
    int i = q.Gn();
    int j = q.Gu();
    au.Hx();
    com.tencent.mm.model.c.Dz().o(7, Integer.valueOf(i | 0x1000));
    au.Hx();
    com.tencent.mm.model.c.Dz().o(34, Integer.valueOf(j & 0xFFFFFFBF));
    this.hZn = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.bottle_empty_msg_tip);
    this.hZo = new a(this, new r.a()
    {
      public final void Wp()
      {
        BottleConversationUI localBottleConversationUI = BottleConversationUI.this;
        String str = BottleConversationUI.this.getString(R.l.bottle_opt_list);
        int i = k.Gf();
        if (i <= 0) {
          localBottleConversationUI.setMMTitle(str);
        }
        while (BottleConversationUI.a(BottleConversationUI.this).getCount() <= 0)
        {
          BottleConversationUI.b(BottleConversationUI.this).setVisibility(0);
          BottleConversationUI.c(BottleConversationUI.this).setVisibility(8);
          return;
          localBottleConversationUI.setMMTitle(str + "(" + i + ")");
        }
        BottleConversationUI.b(BottleConversationUI.this).setVisibility(8);
        BottleConversationUI.c(BottleConversationUI.this).setVisibility(0);
      }
    });
    this.hZo.setGetViewPositionCallback(new BottleConversationUI.4(this));
    this.hZo.setPerformItemClickListener(new BottleConversationUI.5(this));
    this.hZo.a(new BottleConversationUI.6(this));
    this.hZn.setAdapter(this.hZo);
    Object localObject = new j(this);
    this.hZn.setOnItemLongClickListener(new BottleConversationUI.7(this, (j)localObject));
    this.hZn.setOnItemClickListener(new BottleConversationUI.8(this));
    com.tencent.mm.plugin.bottle.a.eUS.tk();
    setBackBtn(new BottleConversationUI.9(this));
    localObject = getIntent().getStringExtra("conversation_from");
    if ((bk.bl((String)localObject)) && (bk.bl(this.hZp))) {
      addTextOptionMenu(0, getString(R.l.contact_into_goto_floatbottle_str_btn), new BottleConversationUI.10(this));
    }
    for (;;)
    {
      new BottleConversationUI.11(this);
      return;
      if (!bk.bl((String)localObject)) {
        this.hZp = ((String)localObject);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.talker = ((ak)this.hZo.getItem(paramView.position)).field_username;
    int i = R.l.bottle_chatting_from_city;
    paramContextMenuInfo = this.hZo;
    au.Hx();
    paramContextMenu.setHeaderTitle(getString(i, new Object[] { paramContextMenuInfo.D(com.tencent.mm.model.c.Fw().abl(this.talker)) }));
    paramContextMenu.add(paramView.position, 0, 0, R.l.bottle_conversation_delete);
  }
  
  public void onDestroy()
  {
    this.hZo.bcS();
    super.onDestroy();
  }
  
  public void onPause()
  {
    au.Hx();
    com.tencent.mm.model.c.Fw().b(this.hZo);
    au.Hx();
    com.tencent.mm.model.c.FB().b(this.hZo);
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Fy().tE(8);
    if ((localObject != null) && (((cs)localObject).field_msgId > 0L))
    {
      y.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + ((cs)localObject).field_createTime);
      au.Hx();
      com.tencent.mm.model.c.Dz().o(12306, Long.valueOf(((cs)localObject).field_createTime));
    }
    au.Hx();
    localObject = com.tencent.mm.model.c.FB().abv("floatbottle");
    if ((localObject == null) || (bk.pm(((as)localObject).field_username).length() <= 0)) {
      y.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
    }
    for (;;)
    {
      this.hZo.onPause();
      super.onPause();
      return;
      ((ak)localObject).fy(0);
      au.Hx();
      if (com.tencent.mm.model.c.FB().a((ak)localObject, ((as)localObject).field_username) == -1) {
        y.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    au.Hx();
    com.tencent.mm.model.c.Fw().a(this.hZo);
    au.Hx();
    com.tencent.mm.model.c.FB().a(this.hZo);
    this.hZo.a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI
 * JD-Core Version:    0.7.0.1
 */