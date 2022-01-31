package com.tencent.mm.plugin.ipcall.ui;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.ui.MMActivity;

public class IPCallMsgUI
  extends MMActivity
{
  private View iwf;
  private boolean iwg = true;
  private ListView lwE;
  private IPCallMsgUI.a lwF;
  private View lwG;
  private j.a lwH = new IPCallMsgUI.7(this);
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ipcall_msg_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.ipcall_msg_ui_title);
    this.lwG = findViewById(R.h.ipcall_msg_empty_view);
    this.lwE = ((ListView)findViewById(R.h.ipcall_msg_list));
    this.iwf = com.tencent.mm.ui.y.gt(this).inflate(R.i.mm_footerview, null);
    this.lwE.addFooterView(this.iwf);
    this.lwF = new IPCallMsgUI.a(this, this, new g());
    this.lwF.setGetViewPositionCallback(new IPCallMsgUI.1(this));
    this.lwF.setPerformItemClickListener(new IPCallMsgUI.2(this));
    this.lwF.uMi = new IPCallMsgUI.3(this);
    this.lwE.setAdapter(this.lwF);
    this.lwE.setOnItemClickListener(new IPCallMsgUI.4(this));
    this.lwE.setOnScrollListener(new IPCallMsgUI.5(this));
    if (this.lwF.getCount() == 0)
    {
      this.lwE.setVisibility(8);
      this.lwG.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (this.lwF.aCc()) {
        this.lwE.removeFooterView(this.iwf);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          IPCallMsgUI.this.finish();
          return true;
        }
      });
      if (this.lwF.aCc()) {
        this.lwE.removeFooterView(this.iwf);
      }
      return;
      this.lwE.setVisibility(0);
      this.lwG.setVisibility(8);
      enableOptionMenu(true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i.bcp().c(this.lwH);
    initView();
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
    i.bcp().d(this.lwH);
    this.lwF.bcS();
    h localh = i.bcp();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isRead", Short.valueOf((short)1));
    localh.dXw.update(localh.getTableName(), localContentValues, "isRead!=? ", new String[] { "1" });
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI
 * JD-Core Version:    0.7.0.1
 */