package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletSelectAddrUI
  extends MMActivity
  implements com.tencent.mm.plugin.address.c.a
{
  private List<com.tencent.mm.plugin.address.d.b> iAM;
  private com.tencent.mm.plugin.address.d.b iAN;
  private a iAO;
  private com.tencent.mm.plugin.address.c.b iAP;
  private View iAQ;
  private TextView iAR;
  private p iAS;
  private boolean iAT;
  private boolean iAU;
  private com.tencent.mm.ui.widget.a.d iAV;
  private ListView izP;
  private boolean izm;
  private Object lockObj;
  
  public WalletSelectAddrUI()
  {
    AppMethodBeat.i(21037);
    this.iAM = new LinkedList();
    this.iAP = null;
    this.iAR = null;
    this.lockObj = new Object();
    this.izm = false;
    this.iAT = false;
    this.iAU = false;
    this.iAV = null;
    AppMethodBeat.o(21037);
  }
  
  private void aKZ()
  {
    AppMethodBeat.i(21041);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.aKO();
      this.iAM = com.tencent.mm.plugin.address.a.a.aKQ().iyD.iyM;
      this.iAO.gQr = this.iAM;
      this.iAM.size();
      this.iAQ.setVisibility(8);
      this.iAO.notifyDataSetChanged();
      AppMethodBeat.o(21041);
      return;
    }
  }
  
  private void aLe()
  {
    AppMethodBeat.i(21045);
    lr locallr = new lr();
    locallr.dqs.djj = this;
    locallr.dqs.dqu = new WalletSelectAddrUI.9(this, locallr);
    com.tencent.mm.sdk.b.a.ESL.a(locallr, Looper.myLooper());
    AppMethodBeat.o(21045);
  }
  
  private void bM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21044);
    paramString1 = new com.tencent.mm.plugin.address.model.d(paramString1, paramString2, this.iAS);
    this.iAP.e(paramString1);
    AppMethodBeat.o(21044);
  }
  
  private void qm(int paramInt)
  {
    AppMethodBeat.i(21046);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, WalletAddAddressUI.class);
    ((Intent)localObject).putExtra("address_id", paramInt);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(21046);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(21043);
    this.iAP.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 417)
      {
        if (((e)paramn).iyw)
        {
          aKZ();
          getContentView().setVisibility(0);
          if ((this.izm) && (this.iAM.size() == 0))
          {
            paramString = new Intent();
            paramString.setClass(this, WalletAddAddressUI.class);
            startActivityForResult(paramString, 1);
          }
        }
        AppMethodBeat.o(21043);
        return;
      }
      if (paramn.getType() == 416)
      {
        paramString = (f)paramn;
        com.tencent.mm.plugin.address.a.a.aKO();
        paramString = com.tencent.mm.plugin.address.a.a.aKQ().qj(paramString.iyx);
        if (paramString != null)
        {
          com.tencent.mm.plugin.address.a.a.aKO();
          ad.d("MicroMsg.WalletSelectAddrUI", "delte addr ".concat(String.valueOf(com.tencent.mm.plugin.address.a.a.aKQ().a(paramString))));
        }
        aKZ();
        AppMethodBeat.o(21043);
        return;
      }
      if (paramn.getType() == 419)
      {
        if (this.iAN != null)
        {
          setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.iAN));
          finish();
          AppMethodBeat.o(21043);
        }
      }
      else if (paramn.getType() == 582)
      {
        paramString = getString(2131755240);
        switch (((com.tencent.mm.plugin.address.model.d)paramn).status)
        {
        default: 
        case 1: 
        case 2: 
        case 0: 
          for (;;)
          {
            if (this.iAV != null) {
              this.iAV.dismiss();
            }
            this.iAV = h.a(this, paramString, null, true, null);
            AppMethodBeat.o(21043);
            return;
            az.arV();
            c.afk().set(196657, Boolean.TRUE);
            this.iAR.setVisibility(8);
            paramString = getString(2131755241);
            continue;
            az.arV();
            c.afk().set(196657, Boolean.TRUE);
            this.iAR.setVisibility(8);
            aKZ();
            getContentView().setVisibility(0);
            paramString = getString(2131755242);
          }
        }
        aLe();
        AppMethodBeat.o(21043);
      }
    }
    else if ((paramn.getType() == 419) && (paramInt2 == -3103))
    {
      h.a(this, true, paramString, "", getString(2131755177), getString(2131755691), new DialogInterface.OnClickListener()new WalletSelectAddrUI.2
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21031);
          paramAnonymousDialogInterface.dismiss();
          WalletSelectAddrUI.a(WalletSelectAddrUI.this, WalletSelectAddrUI.g(WalletSelectAddrUI.this).id);
          AppMethodBeat.o(21031);
        }
      }, new WalletSelectAddrUI.2(this));
    }
    AppMethodBeat.o(21043);
  }
  
  public int getLayoutId()
  {
    return 2131495894;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21042);
    this.iAR = ((TextView)findViewById(2131300994));
    this.iAR.setVisibility(8);
    this.iAR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21022);
        h.a(WalletSelectAddrUI.this, true, WalletSelectAddrUI.this.getString(2131755237, new Object[] { WalletSelectAddrUI.a(WalletSelectAddrUI.this).toString() }), "", WalletSelectAddrUI.this.getString(2131755238), WalletSelectAddrUI.this.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(21021);
            WalletSelectAddrUI.b(WalletSelectAddrUI.this);
            AppMethodBeat.o(21021);
          }
        }, null);
        AppMethodBeat.o(21022);
      }
    });
    this.izP = ((ListView)findViewById(2131304652));
    this.iAO = new a(this);
    this.iAQ = findViewById(2131296450);
    this.iAQ.findViewById(2131296472).setVisibility(8);
    ((TextView)this.iAQ.findViewById(2131296487)).setText(2131755171);
    this.izP.setAdapter(this.iAO);
    this.izP.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> arg1, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(21023);
        ad.d("MicroMsg.WalletSelectAddrUI", "select pos ".concat(String.valueOf(paramAnonymousInt)));
        synchronized (WalletSelectAddrUI.c(WalletSelectAddrUI.this))
        {
          if (paramAnonymousInt < WalletSelectAddrUI.d(WalletSelectAddrUI.this).size())
          {
            WalletSelectAddrUI.a(WalletSelectAddrUI.this, (com.tencent.mm.plugin.address.d.b)WalletSelectAddrUI.d(WalletSelectAddrUI.this).get(paramAnonymousInt));
            if ((WalletSelectAddrUI.e(WalletSelectAddrUI.this)) || (WalletSelectAddrUI.f(WalletSelectAddrUI.this)) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this) == null)) {
              break label136;
            }
            WalletSelectAddrUI.a(WalletSelectAddrUI.this, WalletSelectAddrUI.g(WalletSelectAddrUI.this).id);
          }
          label136:
          while ((WalletSelectAddrUI.g(WalletSelectAddrUI.this) == null) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this).id == 0))
          {
            WalletSelectAddrUI.i(WalletSelectAddrUI.this).notifyDataSetChanged();
            AppMethodBeat.o(21023);
            return;
          }
          paramAnonymousView = new g(WalletSelectAddrUI.g(WalletSelectAddrUI.this).id);
          WalletSelectAddrUI.h(WalletSelectAddrUI.this).e(paramAnonymousView);
        }
      }
    });
    this.izP.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(21025);
        paramAnonymousAdapterView = WalletSelectAddrUI.this.getResources().getStringArray(2130903095);
        h.a(WalletSelectAddrUI.this.getContext(), null, paramAnonymousAdapterView, null, new h.c()
        {
          public final void kM(int paramAnonymous2Int)
          {
            AppMethodBeat.i(21024);
            for (;;)
            {
              synchronized (WalletSelectAddrUI.c(WalletSelectAddrUI.this))
              {
                if (paramAnonymousInt >= WalletSelectAddrUI.d(WalletSelectAddrUI.this).size()) {
                  break label203;
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
                WalletSelectAddrUI.h(WalletSelectAddrUI.this).e(localf);
                AppMethodBeat.o(21024);
                return;
                WalletSelectAddrUI.b(WalletSelectAddrUI.this, localf);
              }
              label203:
              f localf = null;
            }
          }
        });
        AppMethodBeat.o(21025);
        return true;
      }
    });
    aKZ();
    this.iAQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21026);
        WalletSelectAddrUI.j(WalletSelectAddrUI.this);
        AppMethodBeat.o(21026);
      }
    });
    this.iAO.notifyDataSetChanged();
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
    addIconOptionMenu(0, 2131755173, 2131689489, new MenuItem.OnMenuItemClickListener()
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
        break label162;
      }
      if (paramIntent != null) {
        break label51;
      }
      ad.e("MicroMsg.AddrUtil", "intent == null");
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
      localb.iyV = paramIntent.getStringExtra("nationalCode");
      localb.iyT = paramIntent.getStringExtra("userName");
      localb.iyU = paramIntent.getStringExtra("telNumber");
      localb.iyR = paramIntent.getStringExtra("addressPostalCode");
      localb.iyO = paramIntent.getStringExtra("proviceFirstStageName");
      localb.iyP = paramIntent.getStringExtra("addressCitySecondStageName");
      localb.iyQ = paramIntent.getStringExtra("addressCountiesThirdStageName");
      localb.iyS = paramIntent.getStringExtra("addressDetailInfo");
      paramIntent = localb;
      break;
      label162:
      setResult(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21038);
    super.onCreate(paramBundle);
    this.iAP = new com.tencent.mm.plugin.address.c.b(this, this);
    paramBundle = getIntent();
    this.iAT = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    this.iAU = paramBundle.getBooleanExtra("launch_from_remittance", false);
    if ((paramBundle.getBooleanExtra("launch_from_webview", false)) || (this.iAT))
    {
      this.izm = true;
      getContentView().setVisibility(8);
      if (this.iAT) {
        getWindow().setBackgroundDrawableResource(2131100695);
      }
      ad.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
      az.arV();
      if (((Boolean)c.afk().get(ae.a.FlV, Boolean.TRUE)).booleanValue())
      {
        ad.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
        h.a(this, getString(2131755227), getString(2131755228), getString(2131755012), new WalletSelectAddrUI.1(this));
        az.arV();
        c.afk().set(ae.a.FlV, Boolean.FALSE);
      }
    }
    setMMTitle(2131755226);
    this.iAP.addSceneEndListener(417);
    this.iAP.addSceneEndListener(416);
    this.iAP.addSceneEndListener(419);
    this.iAP.addSceneEndListener(582);
    paramBundle = new e(paramBundle.getStringExtra("req_url"), paramBundle.getStringExtra("req_app_id"), 2);
    this.iAP.e(paramBundle);
    az.arV();
    this.iAS = new p(bt.a((Integer)c.afk().get(9, null), 0));
    com.tencent.mm.plugin.address.a.a.aKQ().aKR();
    initView();
    az.arV();
    if (c.isSDCardAvailable())
    {
      paramBundle = new com.tencent.mm.bc.l(12);
      az.aeS().a(paramBundle, 0);
    }
    AppMethodBeat.o(21038);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21039);
    super.onDestroy();
    this.iAP.removeSceneEndListener(417);
    this.iAP.removeSceneEndListener(416);
    this.iAP.removeSceneEndListener(419);
    this.iAP.removeSceneEndListener(582);
    AppMethodBeat.o(21039);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21040);
    super.onResume();
    aKZ();
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
    List<com.tencent.mm.plugin.address.d.b> gQr;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(21032);
      this.gQr = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(21032);
    }
    
    private com.tencent.mm.plugin.address.d.b qn(int paramInt)
    {
      AppMethodBeat.i(21035);
      com.tencent.mm.plugin.address.d.b localb = (com.tencent.mm.plugin.address.d.b)this.gQr.get(paramInt);
      AppMethodBeat.o(21035);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(21034);
      int i = this.gQr.size();
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
        paramView = View.inflate(this.context, 2131495893, null);
        paramViewGroup.izY = ((ImageView)paramView.findViewById(2131298246));
        paramViewGroup.izX = ((TextView)paramView.findViewById(2131296472));
        paramViewGroup.ftj = ((TextView)paramView.findViewById(2131296487));
        paramView.setTag(paramViewGroup);
        com.tencent.mm.plugin.address.d.b localb = qn(paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(localb.iyO)) {
          localStringBuilder.append(localb.iyO);
        }
        if (!TextUtils.isEmpty(localb.iyP))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.iyP);
        }
        if (!TextUtils.isEmpty(localb.iyQ))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.iyQ);
        }
        if (!TextUtils.isEmpty(localb.iyS))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.iyS);
        }
        paramViewGroup.izX.setText(localStringBuilder.toString());
        paramViewGroup.ftj.setText(localb.iyT + "，" + localb.iyU);
        if ((!WalletSelectAddrUI.e(WalletSelectAddrUI.this)) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this) == null) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this).id != localb.id)) {
          break label318;
        }
        paramViewGroup.izY.setImageResource(2131691078);
      }
      for (;;)
      {
        AppMethodBeat.o(21033);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label318:
        paramViewGroup.izY.setImageBitmap(null);
      }
    }
    
    final class a
    {
      TextView ftj;
      TextView izX;
      ImageView izY;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI
 * JD-Core Version:    0.7.0.1
 */