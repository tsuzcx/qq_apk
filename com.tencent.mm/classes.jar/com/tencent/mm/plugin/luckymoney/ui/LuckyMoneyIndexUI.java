package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.s.b;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyIndexUI
  extends LuckyMoneyBaseUI
{
  private int mChannel;
  private LinearLayout vJp;
  private LinearLayout vJq;
  private LinearLayout vJr;
  
  private void dmn()
  {
    AppMethodBeat.i(65606);
    com.tencent.mm.plugin.luckymoney.b.a.dkG();
    j localj = com.tencent.mm.plugin.luckymoney.b.a.dkH().dlk();
    if (localj == null)
    {
      AppMethodBeat.o(65606);
      return;
    }
    ImageView localImageView = (ImageView)findViewById(2131301834);
    if ((localj.vAb & 0x1) == 1)
    {
      ae.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
      localImageView.setImageResource(2131233038);
      AppMethodBeat.o(65606);
      return;
    }
    localImageView.setImageResource(2131233039);
    AppMethodBeat.o(65606);
  }
  
  public int getLayoutId()
  {
    return 2131494645;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65605);
    setMMTitle(2131760973);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65598);
        LuckyMoneyIndexUI.this.finish();
        AppMethodBeat.o(65598);
        return true;
      }
    });
    this.vJp = ((LinearLayout)findViewById(2131301833));
    this.vJq = ((LinearLayout)findViewById(2131301831));
    this.vJr = ((LinearLayout)findViewById(2131301828));
    ((Button)findViewById(2131301832)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65599);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
        LuckyMoneyIndexUI.a(LuckyMoneyIndexUI.this, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65599);
      }
    });
    ((Button)findViewById(2131301830)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65600);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
        LuckyMoneyIndexUI.a(LuckyMoneyIndexUI.this, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65600);
      }
    });
    addTextOptionMenu(0, getString(2131760892), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65602);
        com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
        paramAnonymousMenuItem = new LinkedList();
        LinkedList localLinkedList = new LinkedList();
        paramAnonymousMenuItem.add(LuckyMoneyIndexUI.this.getString(2131760896));
        localLinkedList.add(Integer.valueOf(0));
        paramAnonymousMenuItem.add(LuckyMoneyIndexUI.this.getString(2131760898));
        localLinkedList.add(Integer.valueOf(1));
        com.tencent.mm.ui.base.h.b(LuckyMoneyIndexUI.this.getContext(), "", paramAnonymousMenuItem, localLinkedList, "", new h.d()
        {
          public final void cv(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            paramAnonymous2Int1 = 1;
            AppMethodBeat.i(65601);
            switch (paramAnonymous2Int2)
            {
            default: 
              com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5) });
              paramAnonymous2Int1 = 2;
            }
            for (;;)
            {
              Object localObject = new Intent();
              ((Intent)localObject).setClass(LuckyMoneyIndexUI.this.getContext(), LuckyMoneyMyRecordUI.class);
              ((Intent)localObject).putExtra("key_type", paramAnonymous2Int1);
              LuckyMoneyIndexUI localLuckyMoneyIndexUI = LuckyMoneyIndexUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localLuckyMoneyIndexUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$4$1", "onClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localLuckyMoneyIndexUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localLuckyMoneyIndexUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$4$1", "onClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(65601);
              return;
              com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6) });
            }
          }
        });
        AppMethodBeat.o(65602);
        return true;
      }
    }, null, s.b.JwH);
    dmn();
    AppMethodBeat.o(65605);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65603);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    initView();
    doSceneProgress(new ai("v1.0", ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWU, Integer.valueOf(0))).intValue(), (byte)0), false);
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(65603);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65604);
    super.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.eMV(), null);
    AppMethodBeat.o(65604);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65607);
    if ((paramn instanceof ai))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ai)paramn;
        paramn = new h.c();
        paramn.textColor = getResources().getColor(2131100589);
        paramn.vLu = 101;
        h.a(this, this.vJp, paramString.vAy, paramn, "Text");
        paramn = new h.c();
        paramn.textColor = getResources().getColor(2131100589);
        paramn.vLu = 100;
        h.a(this, this.vJq, paramString.vCp, paramn, "Text");
        paramn = new h.c();
        paramn.vLu = 102;
        h.a(this, this.vJr, paramString.vCn, paramn, "Pic");
        dmn();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI
 * JD-Core Version:    0.7.0.1
 */