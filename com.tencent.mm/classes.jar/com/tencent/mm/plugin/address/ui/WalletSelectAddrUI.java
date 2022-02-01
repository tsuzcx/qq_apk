package com.tencent.mm.plugin.address.ui;

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
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.pb;
import com.tencent.mm.autogen.a.pb.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.wallet_core.model.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletSelectAddrUI
  extends MMActivity
  implements com.tencent.mm.plugin.address.c.a
{
  private Object lockObj;
  private ListView nlI;
  private boolean qiC;
  private com.tencent.mm.plugin.address.c.b qkA;
  private View qkB;
  private TextView qkC;
  private com.tencent.mm.b.p qkD;
  private boolean qkE;
  private boolean qkF;
  private com.tencent.mm.ui.widget.a.e qkG;
  private boolean qkH;
  private boolean qkq;
  private List<com.tencent.mm.plugin.address.d.b> qkx;
  private com.tencent.mm.plugin.address.d.b qky;
  private a qkz;
  
  public WalletSelectAddrUI()
  {
    AppMethodBeat.i(21037);
    this.qkx = new LinkedList();
    this.qkA = null;
    this.qkC = null;
    this.lockObj = new Object();
    this.qiC = false;
    this.qkE = false;
    this.qkF = false;
    this.qkG = null;
    AppMethodBeat.o(21037);
  }
  
  private void bZH()
  {
    AppMethodBeat.i(21045);
    final pb localpb = new pb();
    localpb.hRT.hHU = this;
    localpb.hRT.hRV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21030);
        WalletSelectAddrUI.l(WalletSelectAddrUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21029);
            if (WalletSelectAddrUI.9.this.qkL.hRU.hCQ)
            {
              bh.bCz();
              String str1 = Util.nullAsNil((String)c.ban().d(46, null));
              bh.bCz();
              String str2 = Util.nullAsNil((String)c.ban().d(72, null));
              WalletSelectAddrUI.a(WalletSelectAddrUI.this, str1, str2);
            }
            AppMethodBeat.o(21029);
          }
        });
        AppMethodBeat.o(21030);
      }
    };
    localpb.asyncPublish(Looper.myLooper());
    AppMethodBeat.o(21045);
  }
  
  private void bZr()
  {
    AppMethodBeat.i(21041);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.bZe();
      this.qkx = com.tencent.mm.plugin.address.a.a.bZg().qhS.qib;
      this.qkz.bMQ = this.qkx;
      this.qkx.size();
      this.qkB.setVisibility(8);
      this.qkz.notifyDataSetChanged();
      AppMethodBeat.o(21041);
      return;
    }
  }
  
  private void cy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21044);
    paramString1 = new com.tencent.mm.plugin.address.model.d(paramString1, paramString2, this.qkD);
    this.qkA.doSceneProgress(paramString1, true);
    AppMethodBeat.o(21044);
  }
  
  private void yH(int paramInt)
  {
    AppMethodBeat.i(21046);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, WalletAddAddressUI.class);
    ((Intent)localObject).putExtra("address_id", paramInt);
    ((Intent)localObject).putExtra("force_light_mode", this.qkq);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(21046);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(21043);
    this.qkA.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp.getType() == 417)
      {
        if (((com.tencent.mm.plugin.address.model.e)paramp).qhG)
        {
          bZr();
          getContentView().findViewById(R.h.fqC).setVisibility(0);
          if ((this.qiC) && (this.qkx.size() == 0))
          {
            paramString = new Intent();
            paramString.setClass(this, WalletAddAddressUI.class);
            startActivityForResult(paramString, 1);
          }
        }
        AppMethodBeat.o(21043);
        return;
      }
      if (paramp.getType() == 416)
      {
        paramString = (f)paramp;
        com.tencent.mm.plugin.address.a.a.bZe();
        paramString = com.tencent.mm.plugin.address.a.a.bZg().yz(paramString.qhH);
        if (paramString != null)
        {
          com.tencent.mm.plugin.address.a.a.bZe();
          Log.d("MicroMsg.WalletSelectAddrUI", "delte addr ".concat(String.valueOf(com.tencent.mm.plugin.address.a.a.bZg().a(paramString))));
        }
        bZr();
        AppMethodBeat.o(21043);
        return;
      }
      if (paramp.getType() == 419)
      {
        if (this.qky != null)
        {
          setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.qky));
          finish();
          AppMethodBeat.o(21043);
        }
      }
      else if (paramp.getType() == 582)
      {
        paramString = getString(R.l.gqY);
        switch (((com.tencent.mm.plugin.address.model.d)paramp).status)
        {
        default: 
        case 1: 
        case 2: 
        case 0: 
          for (;;)
          {
            if (this.qkG != null) {
              this.qkG.dismiss();
            }
            this.qkG = k.a(this, paramString, null, true, null);
            AppMethodBeat.o(21043);
            return;
            bh.bCz();
            c.ban().B(196657, Boolean.TRUE);
            this.qkC.setVisibility(8);
            paramString = getString(R.l.gqZ);
            continue;
            bh.bCz();
            c.ban().B(196657, Boolean.TRUE);
            this.qkC.setVisibility(8);
            bZr();
            getContentView().setVisibility(0);
            paramString = getString(R.l.gra);
          }
        }
        bZH();
        AppMethodBeat.o(21043);
      }
    }
    else if ((paramp.getType() == 419) && (paramInt2 == -3103))
    {
      k.a(this, true, paramString, "", getString(R.l.gpY), getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public boolean convertActivityFromTranslucent()
  {
    return !this.qkH;
  }
  
  public int getLayoutId()
  {
    return R.i.gpe;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21042);
    this.qkC = ((TextView)findViewById(R.h.fKy));
    this.qkC.setVisibility(8);
    this.qkC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21022);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        k.a(WalletSelectAddrUI.this, true, WalletSelectAddrUI.this.getString(R.l.gqW, new Object[] { WalletSelectAddrUI.a(WalletSelectAddrUI.this).toString() }), "", WalletSelectAddrUI.this.getString(R.l.gqX), WalletSelectAddrUI.this.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
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
    this.nlI = ((ListView)findViewById(R.h.settings_lv_address));
    this.qkz = new a(this);
    this.qkB = findViewById(R.h.fqq);
    this.qkB.findViewById(R.h.fqE).setVisibility(8);
    ((TextView)this.qkB.findViewById(R.h.fqL)).setText(R.l.gpS);
    this.nlI.setAdapter(this.qkz);
    this.nlI.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> arg1, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(21023);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(???);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
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
    this.nlI.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(21025);
        paramAnonymousAdapterView = WalletSelectAddrUI.this.getResources().getStringArray(R.c.fjW);
        k.a(WalletSelectAddrUI.this.getContext(), null, paramAnonymousAdapterView, null, new k.d()
        {
          public final void qz(int paramAnonymous2Int)
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
    bZr();
    this.qkB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21026);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WalletSelectAddrUI.j(WalletSelectAddrUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(21026);
      }
    });
    this.qkz.notifyDataSetChanged();
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
    addIconOptionMenu(0, R.l.gpU, R.k.actionbar_icon_dark_add, new MenuItem.OnMenuItemClickListener()
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
      localb.qik = paramIntent.getStringExtra("nationalCode");
      localb.qii = paramIntent.getStringExtra("userName");
      localb.qij = paramIntent.getStringExtra("telNumber");
      localb.qig = paramIntent.getStringExtra("addressPostalCode");
      localb.qid = paramIntent.getStringExtra("proviceFirstStageName");
      localb.qie = paramIntent.getStringExtra("addressCitySecondStageName");
      localb.qif = paramIntent.getStringExtra("addressCountiesThirdStageName");
      localb.qil = paramIntent.getStringExtra("addressCountiesFourStageName");
      localb.qih = paramIntent.getStringExtra("addressDetailInfo");
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
    this.qkE = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    this.qkF = paramBundle.getBooleanExtra("launch_from_remittance", false);
    boolean bool = paramBundle.getBooleanExtra("launch_from_webview", false);
    if ((bool) || (this.qkE))
    {
      this.qiC = true;
      getContentView().findViewById(R.h.fqC).setVisibility(8);
      if ((this.qkE) && (!this.qkH)) {
        getWindow().setBackgroundDrawableResource(R.e.navpage);
      }
      if (bool)
      {
        Log.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
        bh.bCz();
        if (((Boolean)c.ban().get(at.a.acNW, Boolean.TRUE)).booleanValue())
        {
          Log.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
          k.a(this, getString(R.l.gqR), getString(R.l.gqS), getString(R.l.gps), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(21019);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(21019);
            }
          });
          bh.bCz();
          c.ban().set(at.a.acNW, Boolean.FALSE);
        }
      }
    }
    this.qkA = new com.tencent.mm.plugin.address.c.b(this, this);
    setMMTitle(R.l.gqQ);
    this.qkA.addSceneEndListener(417);
    this.qkA.addSceneEndListener(416);
    this.qkA.addSceneEndListener(419);
    this.qkA.addSceneEndListener(582);
    Object localObject1 = new com.tencent.mm.plugin.address.model.e(paramBundle.getStringExtra("req_url"), paramBundle.getStringExtra("req_app_id"), 2);
    this.qkA.doSceneProgress((com.tencent.mm.am.p)localObject1, false);
    bh.bCz();
    this.qkD = new com.tencent.mm.b.p(Util.nullAs((Integer)c.ban().d(9, null), 0));
    localObject1 = com.tencent.mm.plugin.address.a.a.bZg();
    try
    {
      Object localObject2 = (String)((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.acVz, null);
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject2 = ((String)localObject2).getBytes(kotlin.n.d.ISO_8859_1);
        ((j)localObject1).qhS = ((com.tencent.mm.plugin.address.d.a)new com.tencent.mm.plugin.address.d.a().parseFrom((byte[])localObject2));
        j.a(((j)localObject1).qhS);
      }
      initView();
      this.qkq = paramBundle.getBooleanExtra("force_light_mode", false);
      if (this.qkq)
      {
        getContentView().findViewById(R.h.content).setBackgroundColor(getContext().getResources().getColor(R.e.BW_BG_100));
        getContentView().findViewById(R.h.fqC).setBackgroundColor(getContext().getResources().getColor(R.e.BW_BG_100));
        setActionbarColor(getContext().getResources().getColor(R.e.UN_BW_93));
        setNavigationbarColor(getContext().getResources().getColor(R.e.UN_BW_93));
      }
      bh.bCz();
      if (c.isSDCardAvailable())
      {
        paramBundle = new com.tencent.mm.modelpackage.p(12);
        bh.aZW().a(paramBundle, 0);
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
    AppMethodBeat.i(267178);
    super.onCreateBeforeSetContentView();
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("content_view_height", -1);
    if (i != -1) {}
    for (boolean bool = true;; bool = false)
    {
      this.qkH = bool;
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
      Log.i("MicroMsg.WalletSelectAddrUI", "forceTransparent = " + this.qkH);
      AppMethodBeat.o(267178);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21039);
    super.onDestroy();
    this.qkA.removeSceneEndListener(417);
    this.qkA.removeSceneEndListener(416);
    this.qkA.removeSceneEndListener(419);
    this.qkA.removeSceneEndListener(582);
    AppMethodBeat.o(21039);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21040);
    super.onResume();
    bZr();
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
    List<com.tencent.mm.plugin.address.d.b> bMQ;
    private final Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(21032);
      this.bMQ = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(21032);
    }
    
    private com.tencent.mm.plugin.address.d.b yI(int paramInt)
    {
      AppMethodBeat.i(21035);
      com.tencent.mm.plugin.address.d.b localb = (com.tencent.mm.plugin.address.d.b)this.bMQ.get(paramInt);
      AppMethodBeat.o(21035);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(21034);
      int i = this.bMQ.size();
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
        paramView = View.inflate(this.context, R.i.gpd, null);
        paramViewGroup.qjm = ((ImageView)paramView.findViewById(R.h.fBk));
        paramViewGroup.noc = ((TextView)paramView.findViewById(R.h.fqE));
        paramViewGroup.lDF = ((TextView)paramView.findViewById(R.h.fqL));
        if (WalletSelectAddrUI.k(WalletSelectAddrUI.this))
        {
          paramView.setBackgroundResource(R.g.fnz);
          paramViewGroup.lDF.setTextColor(WalletSelectAddrUI.this.getContext().getResources().getColor(R.e.UN_BW_0_Alpha_0_9));
          paramViewGroup.noc.setTextColor(WalletSelectAddrUI.this.getContext().getResources().getColor(R.e.UN_BW_0_Alpha_0_3));
        }
        paramView.setTag(paramViewGroup);
        com.tencent.mm.plugin.address.d.b localb = yI(paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(localb.qid)) {
          localStringBuilder.append(localb.qid);
        }
        if (!TextUtils.isEmpty(localb.qie))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.qie);
        }
        if (!TextUtils.isEmpty(localb.qif))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.qif);
        }
        if (!TextUtils.isEmpty(localb.qil))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.qil);
        }
        if (!TextUtils.isEmpty(localb.qih))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.qih);
        }
        paramViewGroup.noc.setText(localStringBuilder.toString());
        paramViewGroup.lDF.setText(localb.qii + "，" + localb.qij);
        if ((!WalletSelectAddrUI.e(WalletSelectAddrUI.this)) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this) == null) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this).id != localb.id)) {
          break label416;
        }
        paramViewGroup.qjm.setImageResource(R.k.radio_on);
      }
      for (;;)
      {
        AppMethodBeat.o(21033);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label416:
        paramViewGroup.qjm.setImageBitmap(null);
      }
    }
    
    final class a
    {
      TextView lDF;
      TextView noc;
      ImageView qjm;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI
 * JD-Core Version:    0.7.0.1
 */