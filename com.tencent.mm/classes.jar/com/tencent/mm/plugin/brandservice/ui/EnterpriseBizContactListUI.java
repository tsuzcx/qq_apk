package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.d;
import com.tencent.mm.api.c;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ayi;
import com.tencent.mm.protocal.protobuf.ecn;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EnterpriseBizContactListUI
  extends MMActivity
{
  private boolean clB = false;
  private long enterTime;
  private long irL = 0L;
  private e odR;
  public String odS;
  private EnterpriseBizContactListView odT;
  private View odU;
  private aq odV;
  
  private void cg(List<ecn> paramList)
  {
    AppMethodBeat.i(208395);
    Object localObject = paramList;
    if (paramList == null)
    {
      localObject = new LinkedList();
      paramList = new ecn();
      paramList.type = 1;
      paramList.wSB = getString(2131758431);
      paramList.pqW = "https://wwcdn.weixin.qq.com/node/wework/images/icon_im.48490d44c5.png";
      ((LinkedList)localObject).add(paramList);
    }
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ecn localecn = (ecn)((Iterator)localObject).next();
      if (localecn.type != 2)
      {
        EnterpriseBizContactListView.b localb = EnterpriseBizContactListView.b.bOV();
        localb.oel = true;
        localb.oem = localecn;
        paramList.add(localb);
      }
    }
    this.odT.setFixedBrandServiceItem(paramList);
    this.odT.refresh();
    AppMethodBeat.o(208395);
  }
  
  public void finish()
  {
    AppMethodBeat.i(5691);
    this.irL = (System.currentTimeMillis() / 1000L);
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
    setMMTitle(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.odS).adF());
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
    if (!bu.isNullOrNil(this.odS))
    {
      c localc = com.tencent.mm.al.g.eX(this.odS);
      if ((localc != null) && (localc.Kv())) {
        addIconOptionMenu(1, 2131755134, 2131689489, this.odR.bOW());
      }
    }
    this.odU = findViewById(2131299506);
    this.odT = ((EnterpriseBizContactListView)findViewById(2131299504));
    this.odT.setFatherBizName(this.odS);
    this.odT.setExcludeBizChat(true);
    this.odT.bOT();
    this.odT.setEmptyListener(new EnterpriseBizContactListView.a()
    {
      public final void zv(int paramAnonymousInt)
      {
        int j = 8;
        AppMethodBeat.i(208391);
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
          AppMethodBeat.o(208391);
          return;
          i = 8;
          break;
        }
      }
    });
    cg(com.tencent.mm.al.g.Ew(this.odS));
    ag.aGy();
    com.tencent.mm.al.e.a(this.odS, new a(this));
    AppMethodBeat.o(5692);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(5693);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.odR != null) && (this.odR.d(paramInt1, paramInt2, paramIntent)))
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
    this.odS = getIntent().getStringExtra("enterprise_biz_name");
    this.odR = new e(this, this.odS);
    this.enterTime = (System.currentTimeMillis() / 1000L);
    if (this.odV == null) {
      this.odV = new aq()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(5686);
          if ((paramAnonymousMessage != null) && (paramAnonymousMessage.what == 1) && (EnterpriseBizContactListUI.this != null) && (!EnterpriseBizContactListUI.this.isFinishing()))
          {
            ag.aGB().DZ(EnterpriseBizContactListUI.this.odS);
            ag.aGp();
            paramAnonymousMessage = com.tencent.mm.al.f.Ei(EnterpriseBizContactListUI.this.odS);
            int i = 0;
            while (i < paramAnonymousMessage.size())
            {
              String str = (String)paramAnonymousMessage.get(i);
              if ((x.An(str)) && ((com.tencent.mm.al.g.Et(str)) || (com.tencent.mm.al.g.vz(str)))) {
                ag.aGB().DZ(str);
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
      this.odV.sendEmptyMessageDelayed(1, 500L);
      AppMethodBeat.o(5687);
      return;
      this.odV.removeMessages(1);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5690);
    if (this.odT != null) {
      EnterpriseBizContactListView.release();
    }
    if ((this.enterTime <= 0L) || (this.irL <= 0L))
    {
      super.onDestroy();
      AppMethodBeat.o(5690);
      return;
    }
    long l = this.irL - this.enterTime;
    d locald = ag.aGy().Ea(this.odS);
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
      com.tencent.mm.plugin.report.service.g.yxI.f(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
      ae.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
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
    if (!x.An(this.odS))
    {
      ae.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", new Object[] { this.odS });
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
    if (!this.clB)
    {
      k = getIntent().getIntExtra("enterprise_from_scene", 5);
      i = -1;
      if (this.odT != null) {
        i = this.odT.getContactCount();
      }
      locald = ag.aGy().Ea(this.odS);
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
      com.tencent.mm.plugin.report.service.g.yxI.f(12892, new Object[] { this.odS, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      ae.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.odS, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      this.clB = true;
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
    implements com.tencent.mm.ak.f
  {
    private final WeakReference<EnterpriseBizContactListUI> mix;
    
    public a(EnterpriseBizContactListUI paramEnterpriseBizContactListUI)
    {
      AppMethodBeat.i(208393);
      this.mix = new WeakReference(paramEnterpriseBizContactListUI);
      AppMethodBeat.o(208393);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
    {
      AppMethodBeat.i(208394);
      try
      {
        if (this.mix.get() != null)
        {
          paramString = (EnterpriseBizContactListUI)this.mix.get();
          boolean bool = paramString.isFinishing();
          if (bool)
          {
            AppMethodBeat.o(208394);
            return;
          }
          paramn = (ayi)((b)paramn.getReqResp()).hQE.hQJ;
          h.MqF.aM(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(208392);
              try
              {
                EnterpriseBizContactListUI.a(paramString, paramn.GPf.Gag);
                AppMethodBeat.o(208392);
                return;
              }
              catch (Throwable localThrowable)
              {
                AppMethodBeat.o(208392);
              }
            }
          });
        }
        AppMethodBeat.o(208394);
        return;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(208394);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI
 * JD-Core Version:    0.7.0.1
 */