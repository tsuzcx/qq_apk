package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.a;
import com.tencent.mm.al.af;
import com.tencent.mm.al.d;
import com.tencent.mm.al.f;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.atu;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EnterpriseBizContactListUI
  extends MMActivity
{
  private boolean cbi = false;
  private long enterTime;
  private long hVv = 0L;
  private e nwK;
  public String nwL;
  private EnterpriseBizContactListView nwM;
  private View nwN;
  private ao nwO;
  
  private void cd(List<dvc> paramList)
  {
    AppMethodBeat.i(198635);
    Object localObject = paramList;
    if (paramList == null)
    {
      localObject = new LinkedList();
      paramList = new dvc();
      paramList.type = 1;
      paramList.vxw = getString(2131758431);
      paramList.oGN = "https://wwcdn.weixin.qq.com/node/wework/images/icon_im.48490d44c5.png";
      ((LinkedList)localObject).add(paramList);
    }
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dvc localdvc = (dvc)((Iterator)localObject).next();
      if (localdvc.type != 2)
      {
        EnterpriseBizContactListView.b localb = EnterpriseBizContactListView.b.bJF();
        localb.nxe = true;
        localb.nxf = localdvc;
        paramList.add(localb);
      }
    }
    this.nwM.setFixedBrandServiceItem(paramList);
    this.nwM.refresh();
    AppMethodBeat.o(198635);
  }
  
  public void finish()
  {
    AppMethodBeat.i(5691);
    this.hVv = (System.currentTimeMillis() / 1000L);
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
    setMMTitle(((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(this.nwL).aaR());
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
    if (!bs.isNullOrNil(this.nwL))
    {
      com.tencent.mm.api.c localc = f.dX(this.nwL);
      if ((localc != null) && (localc.IN())) {
        addIconOptionMenu(1, 2131755134, 2131689489, this.nwK.bJG());
      }
    }
    this.nwN = findViewById(2131299506);
    this.nwM = ((EnterpriseBizContactListView)findViewById(2131299504));
    this.nwM.setFatherBizName(this.nwL);
    this.nwM.setExcludeBizChat(true);
    this.nwM.bJD();
    this.nwM.setEmptyListener(new EnterpriseBizContactListView.a()
    {
      public final void yC(int paramAnonymousInt)
      {
        int j = 8;
        AppMethodBeat.i(198631);
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
          AppMethodBeat.o(198631);
          return;
          i = 8;
          break;
        }
      }
    });
    cd(f.AV(this.nwL));
    af.aDf();
    d.a(this.nwL, new a(this));
    AppMethodBeat.o(5692);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(5693);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.nwK != null) && (this.nwK.d(paramInt1, paramInt2, paramIntent)))
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
    this.nwL = getIntent().getStringExtra("enterprise_biz_name");
    this.nwK = new e(this, this.nwL);
    this.enterTime = (System.currentTimeMillis() / 1000L);
    if (this.nwO == null) {
      this.nwO = new ao()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(5686);
          if ((paramAnonymousMessage != null) && (paramAnonymousMessage.what == 1) && (EnterpriseBizContactListUI.this != null) && (!EnterpriseBizContactListUI.this.isFinishing()))
          {
            af.aDi().Ay(EnterpriseBizContactListUI.this.nwL);
            af.aCW();
            paramAnonymousMessage = com.tencent.mm.al.e.AH(EnterpriseBizContactListUI.this.nwL);
            int i = 0;
            while (i < paramAnonymousMessage.size())
            {
              String str = (String)paramAnonymousMessage.get(i);
              if ((w.wG(str)) && ((f.AS(str)) || (f.so(str)))) {
                af.aDi().Ay(str);
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
      this.nwO.sendEmptyMessageDelayed(1, 500L);
      AppMethodBeat.o(5687);
      return;
      this.nwO.removeMessages(1);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5690);
    if (this.nwM != null) {
      EnterpriseBizContactListView.release();
    }
    if ((this.enterTime <= 0L) || (this.hVv <= 0L))
    {
      super.onDestroy();
      AppMethodBeat.o(5690);
      return;
    }
    long l = this.hVv - this.enterTime;
    com.tencent.mm.al.c localc = af.aDf().Az(this.nwL);
    int i;
    if (localc != null)
    {
      i = localc.field_qyUin;
      label78:
      if (localc == null) {
        break label200;
      }
    }
    label200:
    for (int j = localc.field_userUin;; j = 0)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
      ac.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(2), Long.valueOf(l) });
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
    if (!w.wG(this.nwL))
    {
      ac.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", new Object[] { this.nwL });
      finish();
      AppMethodBeat.o(5688);
      return;
    }
    initView();
    int k;
    int i;
    com.tencent.mm.al.c localc;
    int j;
    long l1;
    if (!this.cbi)
    {
      k = getIntent().getIntExtra("enterprise_from_scene", 5);
      i = -1;
      if (this.nwM != null) {
        i = this.nwM.getContactCount();
      }
      localc = af.aDf().Az(this.nwL);
      if (localc == null) {
        break label376;
      }
      j = localc.field_qyUin;
      if (localc == null) {
        break label381;
      }
      l1 = localc.field_wwCorpId;
      label126:
      if (localc == null) {
        break label387;
      }
    }
    label387:
    for (long l2 = localc.field_wwUserVid;; l2 = 0L)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(12892, new Object[] { this.nwL, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      ac.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.nwL, Integer.valueOf(k), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2) });
      this.cbi = true;
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
    implements com.tencent.mm.ak.g
  {
    private final WeakReference<EnterpriseBizContactListUI> lEz;
    
    public a(EnterpriseBizContactListUI paramEnterpriseBizContactListUI)
    {
      AppMethodBeat.i(198633);
      this.lEz = new WeakReference(paramEnterpriseBizContactListUI);
      AppMethodBeat.o(198633);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
    {
      AppMethodBeat.i(198634);
      try
      {
        if (this.lEz.get() != null)
        {
          paramString = (EnterpriseBizContactListUI)this.lEz.get();
          boolean bool = paramString.isFinishing();
          if (bool)
          {
            AppMethodBeat.o(198634);
            return;
          }
          paramn = (atu)((b)paramn.getReqResp()).hvs.hvw;
          com.tencent.e.h.JZN.aQ(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198632);
              try
              {
                EnterpriseBizContactListUI.a(paramString, paramn.EMC.EbY);
                AppMethodBeat.o(198632);
                return;
              }
              catch (Throwable localThrowable)
              {
                AppMethodBeat.o(198632);
              }
            }
          });
        }
        AppMethodBeat.o(198634);
        return;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(198634);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI
 * JD-Core Version:    0.7.0.1
 */