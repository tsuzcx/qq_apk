package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.c;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.b.p;
import com.tencent.mm.be.o;
import com.tencent.mm.f.a.nt;
import com.tencent.mm.f.a.nt.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.wallet_core.c.aa;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletSelectAddrUI
  extends MMActivity
  implements com.tencent.mm.plugin.address.c.a
{
  private ListView kJh;
  private Object lockObj;
  private boolean nlt;
  private boolean nnA;
  private boolean nnk;
  private List<com.tencent.mm.plugin.address.d.b> nnp;
  private com.tencent.mm.plugin.address.d.b nnq;
  private a nnr;
  private TextView nns;
  private com.tencent.mm.plugin.address.c.b nnt;
  private View nnu;
  private TextView nnv;
  private p nnw;
  private boolean nnx;
  private boolean nny;
  private com.tencent.mm.ui.widget.a.d nnz;
  
  public WalletSelectAddrUI()
  {
    AppMethodBeat.i(21037);
    this.nnp = new LinkedList();
    this.nnt = null;
    this.nnv = null;
    this.lockObj = new Object();
    this.nlt = false;
    this.nnx = false;
    this.nny = false;
    this.nnz = null;
    AppMethodBeat.o(21037);
  }
  
  private void bAB()
  {
    AppMethodBeat.i(21041);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.bAn();
      this.nnp = com.tencent.mm.plugin.address.a.a.bAp().nkJ.nkS;
      this.nnr.lxh = this.nnp;
      this.nnp.size();
      this.nnu.setVisibility(8);
      this.nnr.notifyDataSetChanged();
      AppMethodBeat.o(21041);
      return;
    }
  }
  
  private void bAW()
  {
    AppMethodBeat.i(21045);
    final nt localnt = new nt();
    localnt.fMj.fDf = this;
    localnt.fMj.fMl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21030);
        WalletSelectAddrUI.l(WalletSelectAddrUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21029);
            if (WalletSelectAddrUI.9.this.nnE.fMk.fyl)
            {
              bh.beI();
              String str1 = Util.nullAsNil((String)c.aHp().b(46, null));
              bh.beI();
              String str2 = Util.nullAsNil((String)c.aHp().b(72, null));
              WalletSelectAddrUI.a(WalletSelectAddrUI.this, str1, str2);
            }
            AppMethodBeat.o(21029);
          }
        });
        AppMethodBeat.o(21030);
      }
    };
    EventCenter.instance.asyncPublish(localnt, Looper.myLooper());
    AppMethodBeat.o(21045);
  }
  
  private void ck(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21044);
    paramString1 = new com.tencent.mm.plugin.address.model.d(paramString1, paramString2, this.nnw);
    this.nnt.doSceneProgress(paramString1, true);
    AppMethodBeat.o(21044);
  }
  
  private void yz(int paramInt)
  {
    AppMethodBeat.i(21046);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, WalletAddAddressUI.class);
    ((Intent)localObject).putExtra("address_id", paramInt);
    ((Intent)localObject).putExtra("force_light_mode", this.nnk);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(21046);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return !this.nnA;
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(21043);
    this.nnt.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() == 417)
      {
        if (((e)paramq).nkx)
        {
          bAB();
          getContentView().findViewById(R.h.dqo).setVisibility(0);
          if ((this.nlt) && (this.nnp.size() == 0))
          {
            paramString = new Intent();
            paramString.setClass(this, WalletAddAddressUI.class);
            startActivityForResult(paramString, 1);
          }
        }
        AppMethodBeat.o(21043);
        return;
      }
      if (paramq.getType() == 416)
      {
        paramString = (f)paramq;
        com.tencent.mm.plugin.address.a.a.bAn();
        paramString = com.tencent.mm.plugin.address.a.a.bAp().yt(paramString.nky);
        if (paramString != null)
        {
          com.tencent.mm.plugin.address.a.a.bAn();
          Log.d("MicroMsg.WalletSelectAddrUI", "delte addr ".concat(String.valueOf(com.tencent.mm.plugin.address.a.a.bAp().a(paramString))));
        }
        bAB();
        AppMethodBeat.o(21043);
        return;
      }
      if (paramq.getType() == 419)
      {
        if (this.nnq != null)
        {
          setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.nnq));
          finish();
          AppMethodBeat.o(21043);
        }
      }
      else if (paramq.getType() == 582)
      {
        paramString = getString(R.l.enY);
        switch (((com.tencent.mm.plugin.address.model.d)paramq).status)
        {
        default: 
        case 1: 
        case 2: 
        case 0: 
          for (;;)
          {
            if (this.nnz != null) {
              this.nnz.dismiss();
            }
            this.nnz = com.tencent.mm.ui.base.h.a(this, paramString, null, true, null);
            AppMethodBeat.o(21043);
            return;
            bh.beI();
            c.aHp().i(196657, Boolean.TRUE);
            this.nnv.setVisibility(8);
            paramString = getString(R.l.enZ);
            continue;
            bh.beI();
            c.aHp().i(196657, Boolean.TRUE);
            this.nnv.setVisibility(8);
            bAB();
            getContentView().setVisibility(0);
            paramString = getString(R.l.eoa);
          }
        }
        bAW();
        AppMethodBeat.o(21043);
      }
    }
    else if ((paramq.getType() == 419) && (paramInt2 == -3103))
    {
      com.tencent.mm.ui.base.h.a(this, true, paramString, "", getString(R.l.emX), getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21031);
          paramAnonymousDialogInterface.dismiss();
          WalletSelectAddrUI.a(WalletSelectAddrUI.this, WalletSelectAddrUI.g(WalletSelectAddrUI.this).id);
          AppMethodBeat.o(21031);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21020);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(21020);
        }
      });
    }
    AppMethodBeat.o(21043);
  }
  
  public int getLayoutId()
  {
    return R.i.ema;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21042);
    this.nnv = ((TextView)findViewById(R.h.dJd));
    this.nnv.setVisibility(8);
    this.nnv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21022);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.ui.base.h.a(WalletSelectAddrUI.this, true, WalletSelectAddrUI.this.getString(R.l.enW, new Object[] { WalletSelectAddrUI.a(WalletSelectAddrUI.this).toString() }), "", WalletSelectAddrUI.this.getString(R.l.enX), WalletSelectAddrUI.this.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(21021);
            WalletSelectAddrUI.b(WalletSelectAddrUI.this);
            AppMethodBeat.o(21021);
          }
        }, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(21022);
      }
    });
    this.nns = ((TextView)findViewById(R.h.input_tip));
    if (this.nny)
    {
      this.nns.setText(R.l.eoc);
      this.nns.setVisibility(0);
    }
    for (;;)
    {
      this.kJh = ((ListView)findViewById(R.h.settings_lv_address));
      this.nnr = new a(this);
      this.nnu = findViewById(R.h.dqc);
      this.nnu.findViewById(R.h.dqq).setVisibility(8);
      ((TextView)this.nnu.findViewById(R.h.dqx)).setText(R.l.emR);
      this.kJh.setAdapter(this.nnr);
      this.kJh.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> arg1, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(21023);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(???);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          Log.d("MicroMsg.WalletSelectAddrUI", "select pos ".concat(String.valueOf(paramAnonymousInt)));
          synchronized (WalletSelectAddrUI.c(WalletSelectAddrUI.this))
          {
            if (paramAnonymousInt < WalletSelectAddrUI.d(WalletSelectAddrUI.this).size())
            {
              WalletSelectAddrUI.a(WalletSelectAddrUI.this, (com.tencent.mm.plugin.address.d.b)WalletSelectAddrUI.d(WalletSelectAddrUI.this).get(paramAnonymousInt));
              if ((WalletSelectAddrUI.e(WalletSelectAddrUI.this)) || (WalletSelectAddrUI.f(WalletSelectAddrUI.this)) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this) == null)) {
                break label199;
              }
              WalletSelectAddrUI.a(WalletSelectAddrUI.this, WalletSelectAddrUI.g(WalletSelectAddrUI.this).id);
            }
            label199:
            while ((WalletSelectAddrUI.g(WalletSelectAddrUI.this) == null) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this).id == 0))
            {
              WalletSelectAddrUI.i(WalletSelectAddrUI.this).notifyDataSetChanged();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(21023);
              return;
            }
            paramAnonymousView = new g(WalletSelectAddrUI.g(WalletSelectAddrUI.this).id);
            WalletSelectAddrUI.h(WalletSelectAddrUI.this).doSceneProgress(paramAnonymousView, true);
          }
        }
      });
      this.kJh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(21025);
          paramAnonymousAdapterView = WalletSelectAddrUI.this.getResources().getStringArray(R.c.djV);
          com.tencent.mm.ui.base.h.a(WalletSelectAddrUI.this.getContext(), null, paramAnonymousAdapterView, null, new h.d()
          {
            public final void qy(int paramAnonymous2Int)
            {
              AppMethodBeat.i(21024);
              for (;;)
              {
                synchronized (WalletSelectAddrUI.c(WalletSelectAddrUI.this))
                {
                  if (paramAnonymousInt >= WalletSelectAddrUI.d(WalletSelectAddrUI.this).size()) {
                    break label204;
                  }
                  com.tencent.mm.plugin.address.d.b localb = (com.tencent.mm.plugin.address.d.b)WalletSelectAddrUI.d(WalletSelectAddrUI.this).get(paramAnonymousInt);
                  if (localb == null)
                  {
                    AppMethodBeat.o(21024);
                    return;
                  }
                }
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(21024);
                  return;
                  WalletSelectAddrUI.a(WalletSelectAddrUI.this, localObject1.id);
                  AppMethodBeat.o(21024);
                  return;
                  localf = new f(localObject1.id);
                  WalletSelectAddrUI.a(WalletSelectAddrUI.this, null);
                  WalletSelectAddrUI.h(WalletSelectAddrUI.this).doSceneProgress(localf, true);
                  AppMethodBeat.o(21024);
                  return;
                  WalletSelectAddrUI.b(WalletSelectAddrUI.this, localf);
                }
                label204:
                f localf = null;
              }
            }
          });
          AppMethodBeat.o(21025);
          return true;
        }
      });
      bAB();
      this.nnu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21026);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          WalletSelectAddrUI.j(WalletSelectAddrUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21026);
        }
      });
      this.nnr.notifyDataSetChanged();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(21027);
          WalletSelectAddrUI.this.setResult(0);
          WalletSelectAddrUI.this.finish();
          AppMethodBeat.o(21027);
          return true;
        }
      });
      addIconOptionMenu(0, R.l.emT, R.k.actionbar_icon_dark_add, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(21028);
          WalletSelectAddrUI.j(WalletSelectAddrUI.this);
          AppMethodBeat.o(21028);
          return true;
        }
      });
      AppMethodBeat.o(21042);
      return;
      this.nns.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(21047);
    if (paramInt1 == 1)
    {
      if (-1 != paramInt2) {
        break label174;
      }
      if (paramIntent != null) {
        break label51;
      }
      Log.e("MicroMsg.AddrUtil", "intent == null");
      paramIntent = null;
      setResult(-1, com.tencent.mm.plugin.address.e.a.b(paramIntent));
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(21047);
      return;
      label51:
      com.tencent.mm.plugin.address.d.b localb = new com.tencent.mm.plugin.address.d.b();
      localb.nlb = paramIntent.getStringExtra("nationalCode");
      localb.nkZ = paramIntent.getStringExtra("userName");
      localb.nla = paramIntent.getStringExtra("telNumber");
      localb.nkX = paramIntent.getStringExtra("addressPostalCode");
      localb.nkU = paramIntent.getStringExtra("proviceFirstStageName");
      localb.nkV = paramIntent.getStringExtra("addressCitySecondStageName");
      localb.nkW = paramIntent.getStringExtra("addressCountiesThirdStageName");
      localb.nlc = paramIntent.getStringExtra("addressCountiesFourStageName");
      localb.nkY = paramIntent.getStringExtra("addressDetailInfo");
      paramIntent = localb;
      break;
      label174:
      setResult(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21038);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.nnx = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    this.nny = paramBundle.getBooleanExtra("launch_from_remittance", false);
    boolean bool = paramBundle.getBooleanExtra("launch_from_webview", false);
    if ((bool) || (this.nnx))
    {
      this.nlt = true;
      getContentView().findViewById(R.h.dqo).setVisibility(8);
      if ((this.nnx) && (!this.nnA)) {
        getWindow().setBackgroundDrawableResource(R.e.navpage);
      }
      if (bool)
      {
        Log.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
        bh.beI();
        if (((Boolean)c.aHp().get(ar.a.VmB, Boolean.TRUE)).booleanValue())
        {
          Log.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
          com.tencent.mm.ui.base.h.a(this, getString(R.l.enR), getString(R.l.enS), getString(R.l.emp), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(21019);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(21019);
            }
          });
          bh.beI();
          c.aHp().set(ar.a.VmB, Boolean.FALSE);
        }
      }
    }
    this.nnt = new com.tencent.mm.plugin.address.c.b(this, this);
    setMMTitle(R.l.enQ);
    this.nnt.addSceneEndListener(417);
    this.nnt.addSceneEndListener(416);
    this.nnt.addSceneEndListener(419);
    this.nnt.addSceneEndListener(582);
    Object localObject1 = new e(paramBundle.getStringExtra("req_url"), paramBundle.getStringExtra("req_app_id"), 2);
    this.nnt.doSceneProgress((q)localObject1, false);
    bh.beI();
    this.nnw = new p(Util.nullAs((Integer)c.aHp().b(9, null), 0));
    localObject1 = com.tencent.mm.plugin.address.a.a.bAp();
    try
    {
      Object localObject2 = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.VtU, null);
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject2 = ((String)localObject2).getBytes(kotlin.n.d.ISO_8859_1);
        ((l)localObject1).nkJ = ((com.tencent.mm.plugin.address.d.a)new com.tencent.mm.plugin.address.d.a().parseFrom((byte[])localObject2));
      }
      initView();
      this.nnk = paramBundle.getBooleanExtra("force_light_mode", false);
      if (this.nnk)
      {
        getContentView().findViewById(R.h.content).setBackgroundColor(getContext().getResources().getColor(R.e.BW_BG_100));
        getContentView().findViewById(R.h.dqo).setBackgroundColor(getContext().getResources().getColor(R.e.BW_BG_100));
        setActionbarColor(getContext().getResources().getColor(R.e.UN_BW_93));
        setNavigationbarColor(getContext().getResources().getColor(R.e.UN_BW_93));
      }
      bh.beI();
      if (c.isSDCardAvailable())
      {
        paramBundle = new o(12);
        bh.aGY().a(paramBundle, 0);
      }
      AppMethodBeat.o(21038);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletAddrMgr", localException, "", new Object[0]);
      }
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(227239);
    super.onCreateBeforeSetContentView();
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("content_view_height", -1);
    if (i != -1) {}
    for (boolean bool = true;; bool = false)
    {
      this.nnA = bool;
      if (bool)
      {
        WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
        localLayoutParams.height = i;
        localLayoutParams.width = -1;
        localLayoutParams.gravity = 80;
        getWindow().setAttributes(localLayoutParams);
        setFinishOnTouchOutside(localIntent.getBooleanExtra("click_empty_close", false));
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        com.tencent.mm.ui.base.b.a(this, null);
      }
      Log.i("MicroMsg.WalletSelectAddrUI", "forceTransparent = " + this.nnA);
      AppMethodBeat.o(227239);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21039);
    super.onDestroy();
    this.nnt.removeSceneEndListener(417);
    this.nnt.removeSceneEndListener(416);
    this.nnt.removeSceneEndListener(419);
    this.nnt.removeSceneEndListener(582);
    AppMethodBeat.o(21039);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21040);
    super.onResume();
    bAB();
    AppMethodBeat.o(21040);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    extends BaseAdapter
  {
    private final Context context;
    List<com.tencent.mm.plugin.address.d.b> lxh;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(21032);
      this.lxh = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(21032);
    }
    
    private com.tencent.mm.plugin.address.d.b yA(int paramInt)
    {
      AppMethodBeat.i(21035);
      com.tencent.mm.plugin.address.d.b localb = (com.tencent.mm.plugin.address.d.b)this.lxh.get(paramInt);
      AppMethodBeat.o(21035);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(21034);
      int i = this.lxh.size();
      AppMethodBeat.o(21034);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(21033);
      paramViewGroup = new a();
      if (paramView == null)
      {
        paramView = View.inflate(this.context, R.i.elZ, null);
        paramViewGroup.nmd = ((ImageView)paramView.findViewById(R.h.dAp));
        paramViewGroup.kMh = ((TextView)paramView.findViewById(R.h.dqq));
        paramViewGroup.jbF = ((TextView)paramView.findViewById(R.h.dqx));
        if (WalletSelectAddrUI.k(WalletSelectAddrUI.this))
        {
          paramView.setBackgroundResource(R.g.dnn);
          paramViewGroup.jbF.setTextColor(WalletSelectAddrUI.this.getContext().getResources().getColor(R.e.UN_BW_0_Alpha_0_9));
          paramViewGroup.kMh.setTextColor(WalletSelectAddrUI.this.getContext().getResources().getColor(R.e.UN_BW_0_Alpha_0_3));
        }
        paramView.setTag(paramViewGroup);
        com.tencent.mm.plugin.address.d.b localb = yA(paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(localb.nkU)) {
          localStringBuilder.append(localb.nkU);
        }
        if (!TextUtils.isEmpty(localb.nkV))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.nkV);
        }
        if (!TextUtils.isEmpty(localb.nkW))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.nkW);
        }
        if (!TextUtils.isEmpty(localb.nlc))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.nlc);
        }
        if (!TextUtils.isEmpty(localb.nkY))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.nkY);
        }
        paramViewGroup.kMh.setText(localStringBuilder.toString());
        paramViewGroup.jbF.setText(localb.nkZ + "，" + localb.nla);
        if ((!WalletSelectAddrUI.e(WalletSelectAddrUI.this)) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this) == null) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this).id != localb.id)) {
          break label416;
        }
        paramViewGroup.nmd.setImageResource(R.k.radio_on);
      }
      for (;;)
      {
        AppMethodBeat.o(21033);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label416:
        paramViewGroup.nmd.setImageBitmap(null);
      }
    }
    
    final class a
    {
      TextView jbF;
      TextView kMh;
      ImageView nmd;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI
 * JD-Core Version:    0.7.0.1
 */