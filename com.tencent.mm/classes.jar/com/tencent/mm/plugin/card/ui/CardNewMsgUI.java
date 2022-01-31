package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.b.k.a;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;

public class CardNewMsgUI
  extends MMActivity
  implements k.a
{
  View.OnClickListener gMO;
  private CardNewMsgUI.a kxh;
  private View kxi;
  private View kxj;
  private boolean kxk;
  private ListView mListView;
  private View xy;
  
  public CardNewMsgUI()
  {
    AppMethodBeat.i(88610);
    this.kxj = null;
    this.kxk = false;
    this.gMO = new CardNewMsgUI.9(this);
    AppMethodBeat.o(88610);
  }
  
  private void az(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(88615);
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramString);
    localIntent.putExtra("key_is_share_card", paramBoolean);
    localIntent.putExtra("key_from_scene", 4);
    startActivity(localIntent);
    AppMethodBeat.o(88615);
  }
  
  private void bcI()
  {
    AppMethodBeat.i(88614);
    if (am.bch().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.xy.setVisibility(8);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.kxh.notifyDataSetChanged();
      AppMethodBeat.o(88614);
      return;
      this.mListView.setVisibility(8);
      this.xy.setVisibility(0);
      enableOptionMenu(false);
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(88616);
    if (((paramg.field_msg_type & 0x1) == 0) || ((paramg.field_msg_type & 0x3) == 0))
    {
      AppMethodBeat.o(88616);
      return;
    }
    bcI();
    this.kxh.a(null, null);
    AppMethodBeat.o(88616);
  }
  
  public int getLayoutId()
  {
    return 2130968974;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88613);
    setMMTitle(2131297999);
    setBackBtn(new CardNewMsgUI.1(this));
    this.mListView = ((ListView)findViewById(2131822305));
    this.kxh = new CardNewMsgUI.a(this);
    this.mListView.setAdapter(this.kxh);
    this.mListView.setOnItemClickListener(new CardNewMsgUI.2(this));
    this.mListView.setOnItemLongClickListener(new CardNewMsgUI.3(this));
    this.mListView.setOnScrollListener(new CardNewMsgUI.4(this));
    this.kxh.a(new CardNewMsgUI.5(this));
    addTextOptionMenu(0, getString(2131297876), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(88597);
        com.tencent.mm.plugin.report.service.h.qsU.e(11582, new Object[] { "CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", "" });
        CardNewMsgUI.h(CardNewMsgUI.this);
        AppMethodBeat.o(88597);
        return true;
      }
    });
    this.xy = findViewById(2131821981);
    bcI();
    this.kxi = w.hM(this).inflate(2130968971, null);
    this.kxj = w.hM(this).inflate(2130970164, null);
    int i = am.bcf().bbZ();
    if (i > 0)
    {
      this.mListView.addFooterView(this.kxi);
      AppMethodBeat.o(88613);
      return;
    }
    if ((!this.kxh.bem()) && (i == 0) && (am.bcf().getCount() > 0))
    {
      this.mListView.addFooterView(this.kxj);
      this.kxk = true;
      AppMethodBeat.o(88613);
      return;
    }
    if ((this.kxh.bem()) && (i == 0)) {
      am.bcf().getCount();
    }
    AppMethodBeat.o(88613);
  }
  
  public final void onChange() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88611);
    super.onCreate(paramBundle);
    initView();
    am.bch().a(this);
    am.bch().bbR();
    AppMethodBeat.o(88611);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88612);
    this.kxh.bKb();
    am.bch().b(this);
    if (am.bcf().bbZ() > 0) {
      am.bcf().bca();
    }
    super.onDestroy();
    AppMethodBeat.o(88612);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI
 * JD-Core Version:    0.7.0.1
 */