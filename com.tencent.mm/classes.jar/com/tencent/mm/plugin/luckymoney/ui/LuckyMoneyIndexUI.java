package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.model.ae;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.t.b;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyIndexUI
  extends LuckyMoneyBaseUI
{
  private int mChannel;
  private LinearLayout zeu;
  private LinearLayout zev;
  private LinearLayout zew;
  
  private void egi()
  {
    AppMethodBeat.i(65606);
    if (af.IA(getIntent().getStringExtra("key_username"))) {
      com.tencent.mm.plugin.luckymoney.b.a.eex();
    }
    for (o localo = com.tencent.mm.plugin.luckymoney.b.a.eez().efe(); localo == null; localo = com.tencent.mm.plugin.luckymoney.b.a.eey().efe())
    {
      AppMethodBeat.o(65606);
      return;
      com.tencent.mm.plugin.luckymoney.b.a.eex();
    }
    ImageView localImageView = (ImageView)findViewById(2131304150);
    if ((localo.yUT & 0x1) == 1)
    {
      Log.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
      localImageView.setImageResource(2131233691);
      AppMethodBeat.o(65606);
      return;
    }
    localImageView.setImageResource(2131233692);
    AppMethodBeat.o(65606);
  }
  
  public int getLayoutId()
  {
    return 2131495368;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65605);
    setMMTitle(2131762747);
    setBackBtn(new LuckyMoneyIndexUI.1(this));
    this.zeu = ((LinearLayout)findViewById(2131304149));
    this.zev = ((LinearLayout)findViewById(2131304147));
    this.zew = ((LinearLayout)findViewById(2131304144));
    ((Button)findViewById(2131304148)).setOnClickListener(new LuckyMoneyIndexUI.2(this));
    ((Button)findViewById(2131304146)).setOnClickListener(new LuckyMoneyIndexUI.3(this));
    addTextOptionMenu(0, getString(2131762661), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65602);
        com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
        paramAnonymousMenuItem = new LinkedList();
        LinkedList localLinkedList = new LinkedList();
        paramAnonymousMenuItem.add(LuckyMoneyIndexUI.this.getString(2131762670));
        localLinkedList.add(Integer.valueOf(0));
        paramAnonymousMenuItem.add(LuckyMoneyIndexUI.this.getString(2131762672));
        localLinkedList.add(Integer.valueOf(1));
        com.tencent.mm.ui.base.h.b(LuckyMoneyIndexUI.this.getContext(), "", paramAnonymousMenuItem, localLinkedList, "", new h.e()
        {
          public final void cy(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            paramAnonymous2Int1 = 1;
            AppMethodBeat.i(65601);
            switch (paramAnonymous2Int2)
            {
            default: 
              com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5) });
              paramAnonymous2Int1 = 2;
            }
            for (;;)
            {
              Object localObject = new Intent();
              ((Intent)localObject).setClass(LuckyMoneyIndexUI.this.getContext(), LuckyMoneyMyRecordUI.class);
              ((Intent)localObject).putExtra("key_username", LuckyMoneyIndexUI.this.getIntent().getStringExtra("key_username"));
              ((Intent)localObject).putExtra("key_type", paramAnonymous2Int1);
              LuckyMoneyIndexUI localLuckyMoneyIndexUI = LuckyMoneyIndexUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localLuckyMoneyIndexUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$4$1", "onClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localLuckyMoneyIndexUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localLuckyMoneyIndexUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$4$1", "onClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(65601);
              return;
              com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6) });
            }
          }
        });
        AppMethodBeat.o(65602);
        return true;
      }
    }, null, t.b.OHb);
    egi();
    AppMethodBeat.o(65605);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65603);
    super.onCreate(paramBundle);
    ((b)g.af(b.class)).a(this, null);
    initView();
    if (af.IA(getIntent().getStringExtra("key_username"))) {
      doSceneProgress(new ar("v1.0", ((Integer)g.aAh().azQ().get(ar.a.Ofn, Integer.valueOf(0))).intValue()), false);
    }
    for (;;)
    {
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(65603);
      return;
      doSceneProgress(new aq("v1.0", ((Integer)g.aAh().azQ().get(ar.a.Ofm, Integer.valueOf(0))).intValue(), (byte)0), false);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65604);
    super.onResume();
    b localb = (b)g.af(b.class);
    localb.a(this, localb.fUE(), null);
    AppMethodBeat.o(65604);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(65607);
    if ((paramq instanceof aq))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aq)paramq;
        paramq = new i.c();
        paramq.textColor = getResources().getColor(2131100757);
        paramq.zgy = 101;
        i.a(this, this.zeu, paramString.yVs, paramq, "Text");
        paramq = new i.c();
        paramq.textColor = getResources().getColor(2131100757);
        paramq.zgy = 100;
        i.a(this, this.zev, paramString.yXq, paramq, "Text");
        paramq = new i.c();
        paramq.zgy = 102;
        i.a(this, this.zew, paramString.yXo, paramq, "Pic");
        egi();
      }
      AppMethodBeat.o(65607);
      return true;
    }
    AppMethodBeat.o(65607);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI
 * JD-Core Version:    0.7.0.1
 */