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
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.w.b;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyIndexUI
  extends LuckyMoneyBaseUI
{
  private LinearLayout EJx;
  private LinearLayout EJy;
  private LinearLayout EJz;
  private int mChannel;
  
  private void ePL()
  {
    AppMethodBeat.i(65606);
    if (ag.PS(getIntent().getStringExtra("key_username"))) {
      com.tencent.mm.plugin.luckymoney.b.a.eNR();
    }
    for (o localo = com.tencent.mm.plugin.luckymoney.b.a.eNT().eOz(); localo == null; localo = com.tencent.mm.plugin.luckymoney.b.a.eNS().eOz())
    {
      AppMethodBeat.o(65606);
      return;
      com.tencent.mm.plugin.luckymoney.b.a.eNR();
    }
    ImageView localImageView = (ImageView)findViewById(a.f.lucky_money_index_top_decoration);
    if ((localo.EyQ & 0x1) == 1)
    {
      Log.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
      localImageView.setImageResource(a.e.lucky_money_index_top_decoration);
      AppMethodBeat.o(65606);
      return;
    }
    localImageView.setImageResource(a.e.lucky_money_index_topbg_temporary);
    AppMethodBeat.o(65606);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_index_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65605);
    setMMTitle(a.i.lucky_money_title);
    setBackBtn(new LuckyMoneyIndexUI.1(this));
    this.EJx = ((LinearLayout)findViewById(a.f.lucky_money_index_tail_opertaion));
    this.EJy = ((LinearLayout)findViewById(a.f.lucky_money_index_middle_opertaion));
    this.EJz = ((LinearLayout)findViewById(a.f.lucky_money_index_banner_opertaion));
    ((Button)findViewById(a.f.lucky_money_index_normal)).setOnClickListener(new LuckyMoneyIndexUI.2(this));
    ((Button)findViewById(a.f.lucky_money_index_group)).setOnClickListener(new LuckyMoneyIndexUI.3(this));
    addTextOptionMenu(0, getString(a.i.lucky_money_mine_title), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65602);
        com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
        paramAnonymousMenuItem = new LinkedList();
        LinkedList localLinkedList = new LinkedList();
        paramAnonymousMenuItem.add(LuckyMoneyIndexUI.this.getString(a.i.lucky_money_my_receive));
        localLinkedList.add(Integer.valueOf(0));
        paramAnonymousMenuItem.add(LuckyMoneyIndexUI.this.getString(a.i.lucky_money_my_send));
        localLinkedList.add(Integer.valueOf(1));
        com.tencent.mm.ui.base.h.b(LuckyMoneyIndexUI.this.getContext(), "", paramAnonymousMenuItem, localLinkedList, "", new h.e()
        {
          public final void cS(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            paramAnonymous2Int1 = 1;
            AppMethodBeat.i(65601);
            switch (paramAnonymous2Int2)
            {
            default: 
              com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5) });
              paramAnonymous2Int1 = 2;
            }
            for (;;)
            {
              Object localObject = new Intent();
              ((Intent)localObject).setClass(LuckyMoneyIndexUI.this.getContext(), LuckyMoneyMyRecordUI.class);
              ((Intent)localObject).putExtra("key_username", LuckyMoneyIndexUI.this.getIntent().getStringExtra("key_username"));
              ((Intent)localObject).putExtra("key_type", paramAnonymous2Int1);
              LuckyMoneyIndexUI localLuckyMoneyIndexUI = LuckyMoneyIndexUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(localLuckyMoneyIndexUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$4$1", "onClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localLuckyMoneyIndexUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localLuckyMoneyIndexUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$4$1", "onClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(65601);
              return;
              com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6) });
            }
          }
        });
        AppMethodBeat.o(65602);
        return true;
      }
    }, null, w.b.Wav);
    ePL();
    AppMethodBeat.o(65605);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65603);
    super.onCreate(paramBundle);
    ((b)com.tencent.mm.kernel.h.ae(b.class)).a(this, null);
    initView();
    if (ag.PS(getIntent().getStringExtra("key_username"))) {
      doSceneProgress(new as("v1.0", ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vtz, Integer.valueOf(0))).intValue()), false);
    }
    for (;;)
    {
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(65603);
      return;
      doSceneProgress(new ar("v1.0", ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vty, Integer.valueOf(0))).intValue()), false);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65604);
    super.onResume();
    b localb = (b)com.tencent.mm.kernel.h.ae(b.class);
    localb.a(this, localb.gNk(), null);
    AppMethodBeat.o(65604);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(65607);
    if ((paramq instanceof ar))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ar)paramq;
        paramq = new i.c();
        paramq.textColor = getResources().getColor(a.c.lucky_money_index_operation_text_color);
        paramq.ELF = 101;
        i.a(this, this.EJx, paramString.Ezp, paramq, "Text");
        paramq = new i.c();
        paramq.textColor = getResources().getColor(a.c.lucky_money_index_operation_text_color);
        paramq.ELF = 100;
        i.a(this, this.EJy, paramString.EBv, paramq, "Text");
        paramq = new i.c();
        paramq.ELF = 102;
        i.a(this, this.EJz, paramString.EBt, paramq, "Pic");
        ePL();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI
 * JD-Core Version:    0.7.0.1
 */