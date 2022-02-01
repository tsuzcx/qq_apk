package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.an.a;
import com.tencent.mm.an.af;
import com.tencent.mm.an.d;
import com.tencent.mm.an.e;
import com.tencent.mm.an.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cfs;
import com.tencent.mm.protocal.protobuf.gdt;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EnterpriseBizContactListUI
  extends MMActivity
{
  private long enterTime;
  private boolean eoc = false;
  private long oVP = 0L;
  private View vDA;
  private MMHandler vDB;
  private f vDx;
  public String vDy;
  private EnterpriseBizContactListView vDz;
  
  private void ek(List<gdt> paramList)
  {
    AppMethodBeat.i(301557);
    Object localObject = paramList;
    if (paramList == null)
    {
      localObject = new LinkedList();
      paramList = new gdt();
      paramList.type = 1;
      paramList.MEz = getString(d.i.enterprise_chat_entry_title);
      paramList.icon_url = ("https://" + WeChatHosts.domainString(d.i.host_wwcdn_weixin_qq_com) + "/node/wework/images/icon_im.48490d44c5.png");
      ((LinkedList)localObject).add(paramList);
    }
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      gdt localgdt = (gdt)((Iterator)localObject).next();
      if (localgdt.type != 2)
      {
        EnterpriseBizContactListView.b localb = EnterpriseBizContactListView.b.dcx();
        localb.vDP = true;
        localb.vDQ = localgdt;
        paramList.add(localb);
      }
    }
    this.vDz.setFixedBrandServiceItem(paramList);
    this.vDz.bDL();
    AppMethodBeat.o(301557);
  }
  
  public void finish()
  {
    AppMethodBeat.i(5691);
    this.oVP = (System.currentTimeMillis() / 1000L);
    super.finish();
    AppMethodBeat.o(5691);
  }
  
  public int getLayoutId()
  {
    return d.f.enterprise_biz_list_sort;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5692);
    setMMTitle(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.vDy).aSU());
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
    if (!Util.isNullOrNil(this.vDy))
    {
      com.tencent.mm.api.c localc = g.hU(this.vDy);
      if ((localc != null) && (localc.aAP())) {
        addIconOptionMenu(1, d.i.actionbar_title_new_group_chat, d.h.actionbar_icon_dark_add, this.vDx.dcy());
      }
    }
    this.vDA = findViewById(d.e.enterprist_biz_child_not_found);
    this.vDz = ((EnterpriseBizContactListView)findViewById(d.e.enterprise_new_biz_list_view));
    this.vDz.setFatherBizName(this.vDy);
    this.vDz.setExcludeBizChat(true);
    this.vDz.dcv();
    this.vDz.setEmptyListener(new EnterpriseBizContactListView.a()
    {
      public final void Hf(int paramAnonymousInt)
      {
        int j = 8;
        AppMethodBeat.i(301596);
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
          AppMethodBeat.o(301596);
          return;
          i = 8;
          break;
        }
      }
    });
    ek(g.MF(this.vDy));
    af.bHq();
    e.a(this.vDy, new a(this));
    AppMethodBeat.o(5692);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(5693);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.vDx != null) && (this.vDx.h(paramInt1, paramInt2, paramIntent)))
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
    this.vDy = getIntent().getStringExtra("enterprise_biz_name");
    this.vDx = new f(this, this.vDy);
    this.enterTime = (System.currentTimeMillis() / 1000L);
    if (this.vDB == null) {
      this.vDB = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(5686);
          if ((paramAnonymousMessage != null) && (paramAnonymousMessage.what == 1) && (EnterpriseBizContactListUI.this != null) && (!EnterpriseBizContactListUI.this.isFinishing()))
          {
            af.bHt().Mh(EnterpriseBizContactListUI.this.vDy);
            af.bHf();
            paramAnonymousMessage = com.tencent.mm.an.f.Mr(EnterpriseBizContactListUI.this.vDy);
            int i = 0;
            while (i < paramAnonymousMessage.size())
            {
              String str = (String)paramAnonymousMessage.get(i);
              if ((ab.IR(str)) && ((g.MC(str)) || (g.Dn(str)))) {
                af.bHt().Mh(str);
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
      this.vDB.sendEmptyMessageDelayed(1, 500L);
      AppMethodBeat.o(5687);
      return;
      this.vDB.removeMessages(1);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5690);
    if (this.vDz != null) {
      EnterpriseBizContactListView.release();
    }
    if ((this.enterTime <= 0L) || (this.oVP <= 0L))
    {
      super.onDestroy();
      AppMethodBeat.o(5690);
      return;
    }
    long l = this.oVP - this.enterTime;
    d locald = af.bHq().Mi(this.vDy);
    int i;
    if (locald != null)
    {
      i = locald.field_qyUin;
      label78:
      if (locald == null) {
        break label200;
      }
    }
    label200:
    for (int j = locald.field_userUin;; j = 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
      Log.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
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
    if (!ab.IR(this.vDy))
    {
      Log.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", new Object[] { this.vDy });
      finish();
      AppMethodBeat.o(5688);
      return;
    }
    initView();
    int k;
    int i;
    d locald;
    int j;
    long l1;
    if (!this.eoc)
    {
      k = getIntent().getIntExtra("enterprise_from_scene", 5);
      i = -1;
      if (this.vDz != null) {
        i = this.vDz.getContactCount();
      }
      locald = af.bHq().Mi(this.vDy);
      if (locald == null) {
        break label376;
      }
      j = locald.field_qyUin;
      if (locald == null) {
        break label381;
      }
      l1 = locald.field_wwCorpId;
      label126:
      if (locald == null) {
        break label387;
      }
    }
    label387:
    for (long l2 = locald.field_wwUserVid;; l2 = 0L)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(12892, new Object[] { this.vDy, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      Log.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.vDy, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      this.eoc = true;
      AppMethodBeat.o(5688);
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
  
  static final class a
    implements com.tencent.mm.am.h
  {
    private final WeakReference<EnterpriseBizContactListUI> tzB;
    
    public a(EnterpriseBizContactListUI paramEnterpriseBizContactListUI)
    {
      AppMethodBeat.i(301592);
      this.tzB = new WeakReference(paramEnterpriseBizContactListUI);
      AppMethodBeat.o(301592);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final p paramp)
    {
      AppMethodBeat.i(301595);
      try
      {
        if (this.tzB.get() != null)
        {
          paramString = (EnterpriseBizContactListUI)this.tzB.get();
          boolean bool = paramString.isFinishing();
          if (bool) {
            return;
          }
          paramp = (cfs)c.c.b(((com.tencent.mm.am.c)paramp.getReqResp()).otC);
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(301713);
              try
              {
                EnterpriseBizContactListUI.a(paramString, paramp.aapi.YSw);
                return;
              }
              finally
              {
                AppMethodBeat.o(301713);
              }
            }
          });
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(301595);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI
 * JD-Core Version:    0.7.0.1
 */