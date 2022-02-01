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
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.am.a;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.d;
import com.tencent.mm.api.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.axs;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EnterpriseBizContactListUI
  extends MMActivity
{
  private boolean clz = false;
  private long enterTime;
  private long ioQ = 0L;
  private e nYi;
  public String nYj;
  private EnterpriseBizContactListView nYk;
  private View nYl;
  private ap nYm;
  
  private void ce(List<eaw> paramList)
  {
    AppMethodBeat.i(209441);
    Object localObject = paramList;
    if (paramList == null)
    {
      localObject = new LinkedList();
      paramList = new eaw();
      paramList.type = 1;
      paramList.wCQ = getString(2131758431);
      paramList.pkr = "https://wwcdn.weixin.qq.com/node/wework/images/icon_im.48490d44c5.png";
      ((LinkedList)localObject).add(paramList);
    }
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      eaw localeaw = (eaw)((Iterator)localObject).next();
      if (localeaw.type != 2)
      {
        EnterpriseBizContactListView.b localb = EnterpriseBizContactListView.b.bNY();
        localb.nYC = true;
        localb.nYD = localeaw;
        paramList.add(localb);
      }
    }
    this.nYk.setFixedBrandServiceItem(paramList);
    this.nYk.refresh();
    AppMethodBeat.o(209441);
  }
  
  public void finish()
  {
    AppMethodBeat.i(5691);
    this.ioQ = (System.currentTimeMillis() / 1000L);
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
    setMMTitle(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.nYj).adu());
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
    if (!bt.isNullOrNil(this.nYj))
    {
      c localc = com.tencent.mm.am.g.eS(this.nYj);
      if ((localc != null) && (localc.Kn())) {
        addIconOptionMenu(1, 2131755134, 2131689489, this.nYi.bNZ());
      }
    }
    this.nYl = findViewById(2131299506);
    this.nYk = ((EnterpriseBizContactListView)findViewById(2131299504));
    this.nYk.setFatherBizName(this.nYj);
    this.nYk.setExcludeBizChat(true);
    this.nYk.bNW();
    this.nYk.setEmptyListener(new EnterpriseBizContactListView.a()
    {
      public final void zm(int paramAnonymousInt)
      {
        int j = 8;
        AppMethodBeat.i(209437);
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
          AppMethodBeat.o(209437);
          return;
          i = 8;
          break;
        }
      }
    });
    ce(com.tencent.mm.am.g.DU(this.nYj));
    ag.aGi();
    com.tencent.mm.am.e.a(this.nYj, new a(this));
    AppMethodBeat.o(5692);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(5693);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.nYi != null) && (this.nYi.d(paramInt1, paramInt2, paramIntent)))
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
    this.nYj = getIntent().getStringExtra("enterprise_biz_name");
    this.nYi = new e(this, this.nYj);
    this.enterTime = (System.currentTimeMillis() / 1000L);
    if (this.nYm == null) {
      this.nYm = new ap()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(5686);
          if ((paramAnonymousMessage != null) && (paramAnonymousMessage.what == 1) && (EnterpriseBizContactListUI.this != null) && (!EnterpriseBizContactListUI.this.isFinishing()))
          {
            ag.aGl().Dx(EnterpriseBizContactListUI.this.nYj);
            ag.aFZ();
            paramAnonymousMessage = com.tencent.mm.am.f.DG(EnterpriseBizContactListUI.this.nYj);
            int i = 0;
            while (i < paramAnonymousMessage.size())
            {
              String str = (String)paramAnonymousMessage.get(i);
              if ((w.zD(str)) && ((com.tencent.mm.am.g.DR(str)) || (com.tencent.mm.am.g.vd(str)))) {
                ag.aGl().Dx(str);
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
      this.nYm.sendEmptyMessageDelayed(1, 500L);
      AppMethodBeat.o(5687);
      return;
      this.nYm.removeMessages(1);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5690);
    if (this.nYk != null) {
      EnterpriseBizContactListView.release();
    }
    if ((this.enterTime <= 0L) || (this.ioQ <= 0L))
    {
      super.onDestroy();
      AppMethodBeat.o(5690);
      return;
    }
    long l = this.ioQ - this.enterTime;
    d locald = ag.aGi().Dy(this.nYj);
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
      com.tencent.mm.plugin.report.service.g.yhR.f(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
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
    if (!w.zD(this.nYj))
    {
      ad.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", new Object[] { this.nYj });
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
    if (!this.clz)
    {
      k = getIntent().getIntExtra("enterprise_from_scene", 5);
      i = -1;
      if (this.nYk != null) {
        i = this.nYk.getContactCount();
      }
      locald = ag.aGi().Dy(this.nYj);
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
      com.tencent.mm.plugin.report.service.g.yhR.f(12892, new Object[] { this.nYj, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      ad.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.nYj, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      this.clz = true;
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
    implements com.tencent.mm.al.f
  {
    private final WeakReference<EnterpriseBizContactListUI> med;
    
    public a(EnterpriseBizContactListUI paramEnterpriseBizContactListUI)
    {
      AppMethodBeat.i(209439);
      this.med = new WeakReference(paramEnterpriseBizContactListUI);
      AppMethodBeat.o(209439);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
    {
      AppMethodBeat.i(209440);
      try
      {
        if (this.med.get() != null)
        {
          paramString = (EnterpriseBizContactListUI)this.med.get();
          boolean bool = paramString.isFinishing();
          if (bool)
          {
            AppMethodBeat.o(209440);
            return;
          }
          paramn = (axs)((b)paramn.getReqResp()).hNL.hNQ;
          h.LTJ.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(209438);
              try
              {
                EnterpriseBizContactListUI.a(paramString, paramn.GvG.FHK);
                AppMethodBeat.o(209438);
                return;
              }
              catch (Throwable localThrowable)
              {
                AppMethodBeat.o(209438);
              }
            }
          });
        }
        AppMethodBeat.o(209440);
        return;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(209440);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI
 * JD-Core Version:    0.7.0.1
 */