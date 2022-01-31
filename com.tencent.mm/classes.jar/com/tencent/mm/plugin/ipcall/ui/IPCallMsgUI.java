package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;

public class IPCallMsgUI
  extends MMActivity
{
  private View kxj;
  private boolean kxk;
  private ListView list;
  private IPCallMsgUI.a nTS;
  private View nTT;
  private k.a nTU;
  
  public IPCallMsgUI()
  {
    AppMethodBeat.i(22205);
    this.kxk = true;
    this.nTU = new IPCallMsgUI.7(this);
    AppMethodBeat.o(22205);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969939;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22208);
    setMMTitle(2131300924);
    this.nTT = findViewById(2131825298);
    this.list = ((ListView)findViewById(2131825297));
    this.kxj = w.hM(this).inflate(2130970164, null);
    this.list.addFooterView(this.kxj);
    this.nTS = new IPCallMsgUI.a(this, this, new g());
    this.nTS.setGetViewPositionCallback(new IPCallMsgUI.1(this));
    this.nTS.setPerformItemClickListener(new IPCallMsgUI.2(this));
    this.nTS.a(new IPCallMsgUI.3(this));
    this.list.setAdapter(this.nTS);
    this.list.setOnItemClickListener(new IPCallMsgUI.4(this));
    this.list.setOnScrollListener(new IPCallMsgUI.5(this));
    if (this.nTS.getCount() == 0)
    {
      this.list.setVisibility(8);
      this.nTT.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (this.nTS.bem()) {
        this.list.removeFooterView(this.kxj);
      }
      setBackBtn(new IPCallMsgUI.6(this));
      if (this.nTS.bem()) {
        this.list.removeFooterView(this.kxj);
      }
      AppMethodBeat.o(22208);
      return;
      this.list.setVisibility(0);
      this.nTT.setVisibility(8);
      enableOptionMenu(true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22206);
    super.onCreate(paramBundle);
    i.bJw().add(this.nTU);
    initView();
    AppMethodBeat.o(22206);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22207);
    ab.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
    i.bJw().remove(this.nTU);
    this.nTS.bKb();
    h localh = i.bJw();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isRead", Short.valueOf((short)1));
    localh.db.update(localh.getTableName(), localContentValues, "isRead!=? ", new String[] { "1" });
    super.onDestroy();
    AppMethodBeat.o(22207);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI
 * JD-Core Version:    0.7.0.1
 */