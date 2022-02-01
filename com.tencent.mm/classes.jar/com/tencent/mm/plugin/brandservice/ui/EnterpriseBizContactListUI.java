package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a;
import com.tencent.mm.am.d;
import com.tencent.mm.am.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public class EnterpriseBizContactListUI
  extends MMActivity
{
  private boolean cel = false;
  private long enterTime;
  private long huT = 0L;
  private e mUs;
  public String mUt;
  private EnterpriseBizContactListView mUu;
  private View mUv;
  private ap mUw;
  
  public void finish()
  {
    AppMethodBeat.i(5691);
    this.huT = (System.currentTimeMillis() / 1000L);
    super.finish();
    AppMethodBeat.o(5691);
  }
  
  public int getLayoutId()
  {
    return 2131493842;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5692);
    setMMTitle(((k)g.ab(k.class)).apM().aHY(this.mUt).ZW());
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(5682);
        EnterpriseBizContactListUI.this.hideVKB();
        EnterpriseBizContactListUI.this.finish();
        AppMethodBeat.o(5682);
        return true;
      }
    });
    if (!bt.isNullOrNil(this.mUt))
    {
      com.tencent.mm.api.c localc = f.ei(this.mUt);
      if (localc != null) {
        localc.Je();
      }
    }
    this.mUv = findViewById(2131299506);
    this.mUu = ((EnterpriseBizContactListView)findViewById(2131299504));
    this.mUu.setFatherBizName(this.mUt);
    this.mUu.setExcludeBizChat(true);
    this.mUu.bCA();
    this.mUu.setEmptyListener(new EnterpriseBizContactListView.a()
    {
      public final void xL(int paramAnonymousInt)
      {
        int j = 8;
        AppMethodBeat.i(192935);
        Object localObject;
        int i;
        if (EnterpriseBizContactListUI.a(EnterpriseBizContactListUI.this) != null)
        {
          localObject = EnterpriseBizContactListUI.b(EnterpriseBizContactListUI.this);
          if (paramAnonymousInt <= 0) {
            break label66;
          }
          i = 0;
          ((EnterpriseBizContactListView)localObject).setVisibility(i);
          localObject = EnterpriseBizContactListUI.a(EnterpriseBizContactListUI.this);
          if (paramAnonymousInt <= 0) {
            break label72;
          }
        }
        label66:
        label72:
        for (paramAnonymousInt = j;; paramAnonymousInt = 0)
        {
          ((View)localObject).setVisibility(paramAnonymousInt);
          AppMethodBeat.o(192935);
          return;
          i = 8;
          break;
        }
      }
    });
    this.mUu.refresh();
    AppMethodBeat.o(5692);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(5693);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.mUs != null) && (this.mUs.d(paramInt1, paramInt2, paramIntent)))
    {
      AppMethodBeat.o(5693);
      return;
    }
    AppMethodBeat.o(5693);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5687);
    super.onCreate(paramBundle);
    this.mUt = getIntent().getStringExtra("enterprise_biz_name");
    this.enterTime = (System.currentTimeMillis() / 1000L);
    if (this.mUw == null) {
      this.mUw = new ap()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(5686);
          if ((paramAnonymousMessage != null) && (paramAnonymousMessage.what == 1) && (EnterpriseBizContactListUI.this != null) && (!EnterpriseBizContactListUI.this.isFinishing()))
          {
            com.tencent.mm.am.af.awq().ws(EnterpriseBizContactListUI.this.mUt);
            com.tencent.mm.am.af.awe();
            paramAnonymousMessage = com.tencent.mm.am.e.wB(EnterpriseBizContactListUI.this.mUt);
            int i = 0;
            while (i < paramAnonymousMessage.size())
            {
              String str = (String)paramAnonymousMessage.get(i);
              if ((w.sD(str)) && ((f.wM(str)) || (f.pc(str)))) {
                com.tencent.mm.am.af.awq().ws(str);
              }
              i += 1;
            }
          }
          AppMethodBeat.o(5686);
        }
      };
    }
    for (;;)
    {
      this.mUw.sendEmptyMessageDelayed(1, 500L);
      AppMethodBeat.o(5687);
      return;
      this.mUw.removeMessages(1);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5690);
    if (this.mUu != null) {
      EnterpriseBizContactListView.release();
    }
    if ((this.enterTime <= 0L) || (this.huT <= 0L))
    {
      super.onDestroy();
      AppMethodBeat.o(5690);
      return;
    }
    long l = this.huT - this.enterTime;
    com.tencent.mm.am.c localc = com.tencent.mm.am.af.awn().wt(this.mUt);
    int i;
    if (localc != null)
    {
      i = localc.field_qyUin;
      label78:
      if (localc == null) {
        break label197;
      }
    }
    label197:
    for (int j = localc.field_userUin;; j = 0)
    {
      h.vKh.f(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
      ad.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
      break;
      i = 0;
      break label78;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5689);
    super.onPause();
    AppMethodBeat.o(5689);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5688);
    super.onResume();
    if (!w.sD(this.mUt))
    {
      ad.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", new Object[] { this.mUt });
      finish();
      AppMethodBeat.o(5688);
      return;
    }
    initView();
    int k;
    int i;
    com.tencent.mm.am.c localc;
    int j;
    long l1;
    if (!this.cel)
    {
      k = getIntent().getIntExtra("enterprise_from_scene", 5);
      i = -1;
      if (this.mUu != null) {
        i = this.mUu.getContactCount();
      }
      localc = com.tencent.mm.am.af.awn().wt(this.mUt);
      if (localc == null) {
        break label372;
      }
      j = localc.field_qyUin;
      if (localc == null) {
        break label377;
      }
      l1 = localc.field_wwCorpId;
      label125:
      if (localc == null) {
        break label383;
      }
    }
    label372:
    label377:
    label383:
    for (long l2 = localc.field_wwUserVid;; l2 = 0L)
    {
      h.vKh.f(12892, new Object[] { this.mUt, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      ad.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.mUt, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      this.cel = true;
      AppMethodBeat.o(5688);
      return;
      j = 0;
      break;
      l1 = 0L;
      break label125;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI
 * JD-Core Version:    0.7.0.1
 */