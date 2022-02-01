package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.ao.a;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.ao.g;
import com.tencent.mm.api.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.fhh;
import com.tencent.mm.protocal.protobuf.nw;
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
  private boolean cwe = false;
  private long enterTime;
  private long mcV = 0L;
  private e sxO;
  public String sxP;
  private EnterpriseBizContactListView sxQ;
  private View sxR;
  private MMHandler sxS;
  
  private void cs(List<fhh> paramList)
  {
    AppMethodBeat.i(266324);
    Object localObject = paramList;
    if (paramList == null)
    {
      localObject = new LinkedList();
      paramList = new fhh();
      paramList.type = 1;
      paramList.GHJ = getString(d.i.svi);
      paramList.ufC = ("https://" + WeChatHosts.domainString(d.i.host_wwcdn_weixin_qq_com) + "/node/wework/images/icon_im.48490d44c5.png");
      ((LinkedList)localObject).add(paramList);
    }
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      fhh localfhh = (fhh)((Iterator)localObject).next();
      if (localfhh.type != 2)
      {
        EnterpriseBizContactListView.b localb = EnterpriseBizContactListView.b.czF();
        localb.syi = true;
        localb.syj = localfhh;
        paramList.add(localb);
      }
    }
    this.sxQ.setFixedBrandServiceItem(paramList);
    this.sxQ.bfU();
    AppMethodBeat.o(266324);
  }
  
  public void finish()
  {
    AppMethodBeat.i(5691);
    this.mcV = (System.currentTimeMillis() / 1000L);
    super.finish();
    AppMethodBeat.o(5691);
  }
  
  public int getLayoutId()
  {
    return d.f.sun;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5692);
    setMMTitle(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.sxP).ayr());
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
    if (!Util.isNullOrNil(this.sxP))
    {
      c localc = g.gu(this.sxP);
      if ((localc != null) && (localc.YX())) {
        addIconOptionMenu(1, d.i.actionbar_title_new_group_chat, d.h.actionbar_icon_dark_add, this.sxO.czG());
      }
    }
    this.sxR = findViewById(d.e.srQ);
    this.sxQ = ((EnterpriseBizContactListView)findViewById(d.e.srO));
    this.sxQ.setFatherBizName(this.sxP);
    this.sxQ.setExcludeBizChat(true);
    this.sxQ.czD();
    this.sxQ.setEmptyListener(new EnterpriseBizContactListView.a()
    {
      public final void GG(int paramAnonymousInt)
      {
        int j = 8;
        AppMethodBeat.i(257358);
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
          AppMethodBeat.o(257358);
          return;
          i = 8;
          break;
        }
      }
    });
    cs(g.UG(this.sxP));
    af.bjF();
    com.tencent.mm.ao.e.a(this.sxP, new a(this));
    AppMethodBeat.o(5692);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(5693);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.sxO != null) && (this.sxO.e(paramInt1, paramInt2, paramIntent)))
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
    this.sxP = getIntent().getStringExtra("enterprise_biz_name");
    this.sxO = new e(this, this.sxP);
    this.enterTime = (System.currentTimeMillis() / 1000L);
    if (this.sxS == null) {
      this.sxS = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(5686);
          if ((paramAnonymousMessage != null) && (paramAnonymousMessage.what == 1) && (EnterpriseBizContactListUI.this != null) && (!EnterpriseBizContactListUI.this.isFinishing()))
          {
            af.bjI().Ui(EnterpriseBizContactListUI.this.sxP);
            af.bjv();
            paramAnonymousMessage = f.Us(EnterpriseBizContactListUI.this.sxP);
            int i = 0;
            while (i < paramAnonymousMessage.size())
            {
              String str = (String)paramAnonymousMessage.get(i);
              if ((ab.Ql(str)) && ((g.UD(str)) || (g.KI(str)))) {
                af.bjI().Ui(str);
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
      this.sxS.sendEmptyMessageDelayed(1, 500L);
      AppMethodBeat.o(5687);
      return;
      this.sxS.removeMessages(1);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5690);
    if (this.sxQ != null) {
      EnterpriseBizContactListView.release();
    }
    if ((this.enterTime <= 0L) || (this.mcV <= 0L))
    {
      super.onDestroy();
      AppMethodBeat.o(5690);
      return;
    }
    long l = this.mcV - this.enterTime;
    com.tencent.mm.ao.d locald = af.bjF().Uj(this.sxP);
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
      com.tencent.mm.plugin.report.service.h.IzE.a(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
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
    if (!ab.Ql(this.sxP))
    {
      Log.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", new Object[] { this.sxP });
      finish();
      AppMethodBeat.o(5688);
      return;
    }
    initView();
    int k;
    int i;
    com.tencent.mm.ao.d locald;
    int j;
    long l1;
    if (!this.cwe)
    {
      k = getIntent().getIntExtra("enterprise_from_scene", 5);
      i = -1;
      if (this.sxQ != null) {
        i = this.sxQ.getContactCount();
      }
      locald = af.bjF().Uj(this.sxP);
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
      com.tencent.mm.plugin.report.service.h.IzE.a(12892, new Object[] { this.sxP, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      Log.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.sxP, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      this.cwe = true;
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
    implements com.tencent.mm.an.i
  {
    private final WeakReference<EnterpriseBizContactListUI> quK;
    
    public a(EnterpriseBizContactListUI paramEnterpriseBizContactListUI)
    {
      AppMethodBeat.i(264985);
      this.quK = new WeakReference(paramEnterpriseBizContactListUI);
      AppMethodBeat.o(264985);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final q paramq)
    {
      AppMethodBeat.i(264986);
      try
      {
        if (this.quK.get() != null)
        {
          paramString = (EnterpriseBizContactListUI)this.quK.get();
          boolean bool = paramString.isFinishing();
          if (bool)
          {
            AppMethodBeat.o(264986);
            return;
          }
          paramq = (brb)d.c.b(((com.tencent.mm.an.d)paramq.getReqResp()).lBS);
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(266987);
              try
              {
                EnterpriseBizContactListUI.a(paramString, paramq.TbW.RUY);
                AppMethodBeat.o(266987);
                return;
              }
              catch (Throwable localThrowable)
              {
                AppMethodBeat.o(266987);
              }
            }
          });
        }
        AppMethodBeat.o(264986);
        return;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(264986);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI
 * JD-Core Version:    0.7.0.1
 */