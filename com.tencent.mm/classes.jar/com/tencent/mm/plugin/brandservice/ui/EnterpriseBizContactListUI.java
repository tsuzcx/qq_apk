package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.api.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.protocal.protobuf.ewv;
import com.tencent.mm.protocal.protobuf.og;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EnterpriseBizContactListUI
  extends MMActivity
{
  private boolean cxw = false;
  private long enterTime;
  private long jmU = 0L;
  private e poP;
  public String poQ;
  private EnterpriseBizContactListView poR;
  private View poS;
  private MMHandler poT;
  
  private void cv(List<ewv> paramList)
  {
    AppMethodBeat.i(194860);
    Object localObject = paramList;
    if (paramList == null)
    {
      localObject = new LinkedList();
      paramList = new ewv();
      paramList.type = 1;
      paramList.AOv = getString(2131758728);
      paramList.qGB = ("https://" + WeChatHosts.domainString(2131761752) + "/node/wework/images/icon_im.48490d44c5.png");
      ((LinkedList)localObject).add(paramList);
    }
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ewv localewv = (ewv)((Iterator)localObject).next();
      if (localewv.type != 2)
      {
        EnterpriseBizContactListView.b localb = EnterpriseBizContactListView.b.cmb();
        localb.ppj = true;
        localb.ppk = localewv;
        paramList.add(localb);
      }
    }
    this.poR.setFixedBrandServiceItem(paramList);
    this.poR.refresh();
    AppMethodBeat.o(194860);
  }
  
  public void finish()
  {
    AppMethodBeat.i(5691);
    this.jmU = (System.currentTimeMillis() / 1000L);
    super.finish();
    AppMethodBeat.o(5691);
  }
  
  public int getLayoutId()
  {
    return 2131493997;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5692);
    setMMTitle(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.poQ).arI());
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
    if (!Util.isNullOrNil(this.poQ))
    {
      c localc = com.tencent.mm.al.g.fJ(this.poQ);
      if ((localc != null) && (localc.UF())) {
        addIconOptionMenu(1, 2131755152, 2131689491, this.poP.cmc());
      }
    }
    this.poS = findViewById(2131300143);
    this.poR = ((EnterpriseBizContactListView)findViewById(2131300141));
    this.poR.setFatherBizName(this.poQ);
    this.poR.setExcludeBizChat(true);
    this.poR.clZ();
    this.poR.setEmptyListener(new EnterpriseBizContactListView.a()
    {
      public final void Da(int paramAnonymousInt)
      {
        int j = 8;
        AppMethodBeat.i(194856);
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
          AppMethodBeat.o(194856);
          return;
          i = 8;
          break;
        }
      }
    });
    cv(com.tencent.mm.al.g.Nk(this.poQ));
    ag.bar();
    com.tencent.mm.al.e.a(this.poQ, new a(this));
    AppMethodBeat.o(5692);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(5693);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.poP != null) && (this.poP.e(paramInt1, paramInt2, paramIntent)))
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
    this.poQ = getIntent().getStringExtra("enterprise_biz_name");
    this.poP = new e(this, this.poQ);
    this.enterTime = (System.currentTimeMillis() / 1000L);
    if (this.poT == null) {
      this.poT = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(5686);
          if ((paramAnonymousMessage != null) && (paramAnonymousMessage.what == 1) && (EnterpriseBizContactListUI.this != null) && (!EnterpriseBizContactListUI.this.isFinishing()))
          {
            ag.bau().MN(EnterpriseBizContactListUI.this.poQ);
            ag.bah();
            paramAnonymousMessage = f.MW(EnterpriseBizContactListUI.this.poQ);
            int i = 0;
            while (i < paramAnonymousMessage.size())
            {
              String str = (String)paramAnonymousMessage.get(i);
              if ((ab.IS(str)) && ((com.tencent.mm.al.g.Nh(str)) || (com.tencent.mm.al.g.DQ(str)))) {
                ag.bau().MN(str);
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
      this.poT.sendEmptyMessageDelayed(1, 500L);
      AppMethodBeat.o(5687);
      return;
      this.poT.removeMessages(1);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5690);
    if (this.poR != null) {
      EnterpriseBizContactListView.release();
    }
    if ((this.enterTime <= 0L) || (this.jmU <= 0L))
    {
      super.onDestroy();
      AppMethodBeat.o(5690);
      return;
    }
    long l = this.jmU - this.enterTime;
    com.tencent.mm.al.d locald = ag.bar().MO(this.poQ);
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
      com.tencent.mm.plugin.report.service.h.CyF.a(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
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
    if (!ab.IS(this.poQ))
    {
      Log.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", new Object[] { this.poQ });
      finish();
      AppMethodBeat.o(5688);
      return;
    }
    initView();
    int k;
    int i;
    com.tencent.mm.al.d locald;
    int j;
    long l1;
    if (!this.cxw)
    {
      k = getIntent().getIntExtra("enterprise_from_scene", 5);
      i = -1;
      if (this.poR != null) {
        i = this.poR.getContactCount();
      }
      locald = ag.bar().MO(this.poQ);
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
      com.tencent.mm.plugin.report.service.h.CyF.a(12892, new Object[] { this.poQ, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      Log.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.poQ, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      this.cxw = true;
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
    implements com.tencent.mm.ak.i
  {
    private final WeakReference<EnterpriseBizContactListUI> nsR;
    
    public a(EnterpriseBizContactListUI paramEnterpriseBizContactListUI)
    {
      AppMethodBeat.i(194858);
      this.nsR = new WeakReference(paramEnterpriseBizContactListUI);
      AppMethodBeat.o(194858);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final q paramq)
    {
      AppMethodBeat.i(194859);
      try
      {
        if (this.nsR.get() != null)
        {
          paramString = (EnterpriseBizContactListUI)this.nsR.get();
          boolean bool = paramString.isFinishing();
          if (bool)
          {
            AppMethodBeat.o(194859);
            return;
          }
          paramq = (bjs)((com.tencent.mm.ak.d)paramq.getReqResp()).iLL.iLR;
          com.tencent.f.h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194857);
              try
              {
                EnterpriseBizContactListUI.a(paramString, paramq.LTl.KUa);
                AppMethodBeat.o(194857);
                return;
              }
              catch (Throwable localThrowable)
              {
                AppMethodBeat.o(194857);
              }
            }
          });
        }
        AppMethodBeat.o(194859);
        return;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(194859);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI
 * JD-Core Version:    0.7.0.1
 */