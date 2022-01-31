package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.m;

public class EnterpriseBizContactListUI
  extends MMActivity
{
  private boolean bCp = false;
  private long eaj;
  private long fSl = 0L;
  public String jUc;
  private m jUd;
  private EnterpriseBizContactListView jUe;
  private ak jUf;
  
  public void finish()
  {
    AppMethodBeat.i(13951);
    this.fSl = (System.currentTimeMillis() / 1000L);
    super.finish();
    AppMethodBeat.o(13951);
  }
  
  public int getLayoutId()
  {
    return 2130969430;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13954);
    setMMTitle(((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(this.jUc).Oe());
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(13942);
        EnterpriseBizContactListUI.this.hideVKB();
        EnterpriseBizContactListUI.this.finish();
        AppMethodBeat.o(13942);
        return true;
      }
    });
    if (!bo.isNullOrNil(this.jUc))
    {
      com.tencent.mm.aj.d locald = f.rS(this.jUc);
      if ((locald != null) && (locald.aeg())) {
        addIconOptionMenu(1, 2131296407, 2131230736, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(13945);
            if (EnterpriseBizContactListUI.a(EnterpriseBizContactListUI.this) != null)
            {
              EnterpriseBizContactListUI.a(EnterpriseBizContactListUI.this).dismiss();
              EnterpriseBizContactListUI.a(EnterpriseBizContactListUI.this, null);
            }
            EnterpriseBizContactListUI.a(EnterpriseBizContactListUI.this, new m(EnterpriseBizContactListUI.this.getContext()));
            EnterpriseBizContactListUI.a(EnterpriseBizContactListUI.this).sao = new EnterpriseBizContactListUI.2.1(this);
            EnterpriseBizContactListUI.a(EnterpriseBizContactListUI.this).sap = new EnterpriseBizContactListUI.2.2(this);
            EnterpriseBizContactListUI.a(EnterpriseBizContactListUI.this).gr();
            AppMethodBeat.o(13945);
            return false;
          }
        });
      }
    }
    this.jUe = ((EnterpriseBizContactListView)findViewById(2131823735));
    this.jUe.setFatherBizName(this.jUc);
    this.jUe.setExcludeBizChat(false);
    this.jUe.refresh();
    this.jUe.aWB();
    AppMethodBeat.o(13954);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(13953);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(13953);
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      com.tencent.mm.plugin.messenger.a.g.bPJ().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.bPJ().fh(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.l(this, getContext().getString(2131300637));
      AppMethodBeat.o(13953);
      return;
    }
    AppMethodBeat.o(13953);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13947);
    super.onCreate(paramBundle);
    this.jUc = getIntent().getStringExtra("enterprise_biz_name");
    this.eaj = (System.currentTimeMillis() / 1000L);
    if (this.jUf == null) {
      this.jUf = new EnterpriseBizContactListUI.3(this);
    }
    for (;;)
    {
      this.jUf.sendEmptyMessageDelayed(1, 500L);
      AppMethodBeat.o(13947);
      return;
      this.jUf.removeMessages(1);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13950);
    if (this.jUe != null) {
      EnterpriseBizContactListView.release();
    }
    if ((this.eaj <= 0L) || (this.fSl <= 0L))
    {
      super.onDestroy();
      AppMethodBeat.o(13950);
      return;
    }
    long l = this.fSl - this.eaj;
    com.tencent.mm.aj.b localb = z.afr().rx(this.jUc);
    int i;
    if (localb != null)
    {
      i = localb.field_qyUin;
      label78:
      if (localb == null) {
        break label200;
      }
    }
    label200:
    for (int j = localb.field_userUin;; j = 0)
    {
      h.qsU.e(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
      ab.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
      break;
      i = 0;
      break label78;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(13949);
    super.onPause();
    AppMethodBeat.o(13949);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13948);
    super.onResume();
    if (!t.nT(this.jUc))
    {
      ab.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", new Object[] { this.jUc });
      finish();
      AppMethodBeat.o(13948);
      return;
    }
    initView();
    int k;
    int i;
    com.tencent.mm.aj.b localb;
    int j;
    long l1;
    if (!this.bCp)
    {
      k = getIntent().getIntExtra("enterprise_from_scene", 5);
      i = -1;
      if (this.jUe != null) {
        i = this.jUe.getContactCount();
      }
      localb = z.afr().rx(this.jUc);
      if (localb == null) {
        break label376;
      }
      j = localb.field_qyUin;
      if (localb == null) {
        break label381;
      }
      l1 = localb.field_wwCorpId;
      label126:
      if (localb == null) {
        break label387;
      }
    }
    label387:
    for (long l2 = localb.field_wwUserVid;; l2 = 0L)
    {
      h.qsU.e(12892, new Object[] { this.jUc, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      ab.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.jUc, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      this.bCp = true;
      AppMethodBeat.o(13948);
      return;
      label376:
      j = 0;
      break;
      label381:
      l1 = 0L;
      break label126;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI
 * JD-Core Version:    0.7.0.1
 */