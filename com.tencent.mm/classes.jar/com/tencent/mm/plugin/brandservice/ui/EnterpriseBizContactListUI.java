package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ai.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.z;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.g;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.k;

public class EnterpriseBizContactListUI
  extends MMActivity
{
  private boolean bCk = false;
  private long diQ;
  private long eCu = 0L;
  public String ido;
  private k idp;
  private EnterpriseBizContactListView idq;
  private ah idr;
  
  public void finish()
  {
    this.eCu = (System.currentTimeMillis() / 1000L);
    super.finish();
  }
  
  protected final int getLayoutId()
  {
    return b.e.enterprise_biz_list_sort;
  }
  
  protected final void initView()
  {
    setMMTitle(((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(this.ido).Bp());
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        EnterpriseBizContactListUI.this.XM();
        EnterpriseBizContactListUI.this.finish();
        return true;
      }
    });
    if (!bk.bl(this.ido))
    {
      com.tencent.mm.ai.d locald = f.kX(this.ido);
      if ((locald != null) && (locald.Ly())) {
        addIconOptionMenu(1, b.h.actionbar_title_new_group_chat, b.g.actionbar_icon_dark_add, new EnterpriseBizContactListUI.2(this));
      }
    }
    this.idq = ((EnterpriseBizContactListView)findViewById(b.d.enterprise_new_biz_list_view));
    this.idq.setFatherBizName(this.ido);
    this.idq.setExcludeBizChat(false);
    this.idq.refresh();
    this.idq.axD();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramInt2 != -1) || (paramIntent == null));
    String str1 = paramIntent.getStringExtra("be_send_card_name");
    String str2 = paramIntent.getStringExtra("received_card_name");
    boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    com.tencent.mm.plugin.messenger.a.g.bhI().o(str1, str2, bool);
    com.tencent.mm.plugin.messenger.a.g.bhI().dO(paramIntent, str2);
    com.tencent.mm.ui.widget.snackbar.b.h(this, this.mController.uMN.getString(b.h.has_send));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ido = getIntent().getStringExtra("enterprise_biz_name");
    this.diQ = (System.currentTimeMillis() / 1000L);
    if (this.idr == null) {
      this.idr = new EnterpriseBizContactListUI.3(this);
    }
    for (;;)
    {
      this.idr.sendEmptyMessageDelayed(1, 500L);
      return;
      this.idr.removeMessages(1);
    }
  }
  
  protected void onDestroy()
  {
    if (this.idq != null) {
      EnterpriseBizContactListView.release();
    }
    if ((this.diQ <= 0L) || (this.eCu <= 0L))
    {
      super.onDestroy();
      return;
    }
    long l = this.eCu - this.diQ;
    com.tencent.mm.ai.b localb = z.MH().kD(this.ido);
    int i;
    if (localb != null)
    {
      i = localb.field_qyUin;
      label66:
      if (localb == null) {
        break label188;
      }
    }
    label188:
    for (int j = localb.field_userUin;; j = 0)
    {
      h.nFQ.f(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
      y.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
      break;
      i = 0;
      break label66;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!com.tencent.mm.model.s.hk(this.ido))
    {
      y.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", new Object[] { this.ido });
      finish();
    }
    do
    {
      return;
      initView();
    } while (this.bCk);
    int k = getIntent().getIntExtra("enterprise_from_scene", 5);
    int i = -1;
    if (this.idq != null) {
      i = this.idq.getContactCount();
    }
    com.tencent.mm.ai.b localb = z.MH().kD(this.ido);
    int j;
    long l1;
    if (localb != null)
    {
      j = localb.field_qyUin;
      if (localb == null) {
        break label363;
      }
      l1 = localb.field_wwCorpId;
      label114:
      if (localb == null) {
        break label369;
      }
    }
    label363:
    label369:
    for (long l2 = localb.field_wwUserVid;; l2 = 0L)
    {
      h.nFQ.f(12892, new Object[] { this.ido, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      y.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.ido, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      this.bCk = true;
      return;
      j = 0;
      break;
      l1 = 0L;
      break label114;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI
 * JD-Core Version:    0.7.0.1
 */