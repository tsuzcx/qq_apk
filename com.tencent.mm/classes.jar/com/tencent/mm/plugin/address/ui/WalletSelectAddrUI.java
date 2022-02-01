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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ma.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  private ListView gFr;
  private boolean iZp;
  private List<com.tencent.mm.plugin.address.d.b> jaN;
  private com.tencent.mm.plugin.address.d.b jaO;
  private a jaP;
  private com.tencent.mm.plugin.address.c.b jaQ;
  private View jaR;
  private TextView jaS;
  private p jaT;
  private boolean jaU;
  private boolean jaV;
  private com.tencent.mm.ui.widget.a.d jaW;
  private Object lockObj;
  
  public WalletSelectAddrUI()
  {
    AppMethodBeat.i(21037);
    this.jaN = new LinkedList();
    this.jaQ = null;
    this.jaS = null;
    this.lockObj = new Object();
    this.iZp = false;
    this.jaU = false;
    this.jaV = false;
    this.jaW = null;
    AppMethodBeat.o(21037);
  }
  
  private void aRQ()
  {
    AppMethodBeat.i(21041);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.aRF();
      this.jaN = com.tencent.mm.plugin.address.a.a.aRH().iYG.iYP;
      this.jaP.hqR = this.jaN;
      this.jaN.size();
      this.jaR.setVisibility(8);
      this.jaP.notifyDataSetChanged();
      AppMethodBeat.o(21041);
      return;
    }
  }
  
  private void aRV()
  {
    AppMethodBeat.i(21045);
    final ma localma = new ma();
    localma.dod.dgE = this;
    localma.dod.dof = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21030);
        WalletSelectAddrUI.k(WalletSelectAddrUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21029);
            if (WalletSelectAddrUI.9.this.jba.doe.dbS)
            {
              az.ayM();
              String str1 = bs.nullAsNil((String)c.agA().get(46, null));
              az.ayM();
              String str2 = bs.nullAsNil((String)c.agA().get(72, null));
              WalletSelectAddrUI.a(WalletSelectAddrUI.this, str1, str2);
            }
            AppMethodBeat.o(21029);
          }
        });
        AppMethodBeat.o(21030);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.a(localma, Looper.myLooper());
    AppMethodBeat.o(21045);
  }
  
  private void bU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21044);
    paramString1 = new com.tencent.mm.plugin.address.model.d(paramString1, paramString2, this.jaT);
    this.jaQ.doSceneProgress(paramString1, true);
    AppMethodBeat.o(21044);
  }
  
  private void qZ(int paramInt)
  {
    AppMethodBeat.i(21046);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, WalletAddAddressUI.class);
    ((Intent)localObject).putExtra("address_id", paramInt);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(21046);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(21043);
    this.jaQ.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 417)
      {
        if (((e)paramn).iYz)
        {
          aRQ();
          getContentView().setVisibility(0);
          if ((this.iZp) && (this.jaN.size() == 0))
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
        com.tencent.mm.plugin.address.a.a.aRF();
        paramString = com.tencent.mm.plugin.address.a.a.aRH().qW(paramString.iYA);
        if (paramString != null)
        {
          com.tencent.mm.plugin.address.a.a.aRF();
          ac.d("MicroMsg.WalletSelectAddrUI", "delte addr ".concat(String.valueOf(com.tencent.mm.plugin.address.a.a.aRH().a(paramString))));
        }
        aRQ();
        AppMethodBeat.o(21043);
        return;
      }
      if (paramn.getType() == 419)
      {
        if (this.jaO != null)
        {
          setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.jaO));
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
            if (this.jaW != null) {
              this.jaW.dismiss();
            }
            this.jaW = h.a(this, paramString, null, true, null);
            AppMethodBeat.o(21043);
            return;
            az.ayM();
            c.agA().set(196657, Boolean.TRUE);
            this.jaS.setVisibility(8);
            paramString = getString(2131755241);
            continue;
            az.ayM();
            c.agA().set(196657, Boolean.TRUE);
            this.jaS.setVisibility(8);
            aRQ();
            getContentView().setVisibility(0);
            paramString = getString(2131755242);
          }
        }
        aRV();
        AppMethodBeat.o(21043);
      }
    }
    else if ((paramn.getType() == 419) && (paramInt2 == -3103))
    {
      h.a(this, true, paramString, "", getString(2131755177), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    return 2131495894;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21042);
    this.jaS = ((TextView)findViewById(2131300994));
    this.jaS.setVisibility(8);
    this.jaS.setOnClickListener(new View.OnClickListener()
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
    this.gFr = ((ListView)findViewById(2131304652));
    this.jaP = new a(this);
    this.jaR = findViewById(2131296450);
    this.jaR.findViewById(2131296472).setVisibility(8);
    ((TextView)this.jaR.findViewById(2131296487)).setText(2131755171);
    this.gFr.setAdapter(this.jaP);
    this.gFr.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> arg1, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(21023);
        ac.d("MicroMsg.WalletSelectAddrUI", "select pos ".concat(String.valueOf(paramAnonymousInt)));
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
          WalletSelectAddrUI.h(WalletSelectAddrUI.this).doSceneProgress(paramAnonymousView, true);
        }
      }
    });
    this.gFr.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(21025);
        paramAnonymousAdapterView = WalletSelectAddrUI.this.getResources().getStringArray(2130903095);
        h.a(WalletSelectAddrUI.this.getContext(), null, paramAnonymousAdapterView, null, new h.c()
        {
          public final void kG(int paramAnonymous2Int)
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
    aRQ();
    this.jaR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21026);
        WalletSelectAddrUI.j(WalletSelectAddrUI.this);
        AppMethodBeat.o(21026);
      }
    });
    this.jaP.notifyDataSetChanged();
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
      ac.e("MicroMsg.AddrUtil", "intent == null");
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
      localb.iYY = paramIntent.getStringExtra("nationalCode");
      localb.iYW = paramIntent.getStringExtra("userName");
      localb.iYX = paramIntent.getStringExtra("telNumber");
      localb.iYU = paramIntent.getStringExtra("addressPostalCode");
      localb.iYR = paramIntent.getStringExtra("proviceFirstStageName");
      localb.iYS = paramIntent.getStringExtra("addressCitySecondStageName");
      localb.iYT = paramIntent.getStringExtra("addressCountiesThirdStageName");
      localb.iYV = paramIntent.getStringExtra("addressDetailInfo");
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
    this.jaQ = new com.tencent.mm.plugin.address.c.b(this, this);
    paramBundle = getIntent();
    this.jaU = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    this.jaV = paramBundle.getBooleanExtra("launch_from_remittance", false);
    boolean bool = paramBundle.getBooleanExtra("launch_from_webview", false);
    if ((bool) || (this.jaU))
    {
      this.iZp = true;
      getContentView().setVisibility(8);
      if (this.jaU) {
        getWindow().setBackgroundDrawableResource(2131100695);
      }
      if (bool)
      {
        ac.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
        az.ayM();
        if (((Boolean)c.agA().get(ah.a.GJK, Boolean.TRUE)).booleanValue())
        {
          ac.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
          h.a(this, getString(2131755227), getString(2131755228), getString(2131755012), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(21019);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(21019);
            }
          });
          az.ayM();
          c.agA().set(ah.a.GJK, Boolean.FALSE);
        }
      }
    }
    setMMTitle(2131755226);
    this.jaQ.addSceneEndListener(417);
    this.jaQ.addSceneEndListener(416);
    this.jaQ.addSceneEndListener(419);
    this.jaQ.addSceneEndListener(582);
    paramBundle = new e(paramBundle.getStringExtra("req_url"), paramBundle.getStringExtra("req_app_id"), 2);
    this.jaQ.doSceneProgress(paramBundle, false);
    az.ayM();
    this.jaT = new p(bs.a((Integer)c.agA().get(9, null), 0));
    com.tencent.mm.plugin.address.a.a.aRH().aRI();
    initView();
    az.ayM();
    if (c.isSDCardAvailable())
    {
      paramBundle = new com.tencent.mm.bb.l(12);
      az.agi().a(paramBundle, 0);
    }
    AppMethodBeat.o(21038);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21039);
    super.onDestroy();
    this.jaQ.removeSceneEndListener(417);
    this.jaQ.removeSceneEndListener(416);
    this.jaQ.removeSceneEndListener(419);
    this.jaQ.removeSceneEndListener(582);
    AppMethodBeat.o(21039);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21040);
    super.onResume();
    aRQ();
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
    List<com.tencent.mm.plugin.address.d.b> hqR;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(21032);
      this.hqR = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(21032);
    }
    
    private com.tencent.mm.plugin.address.d.b ra(int paramInt)
    {
      AppMethodBeat.i(21035);
      com.tencent.mm.plugin.address.d.b localb = (com.tencent.mm.plugin.address.d.b)this.hqR.get(paramInt);
      AppMethodBeat.o(21035);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(21034);
      int i = this.hqR.size();
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
        paramViewGroup.iZZ = ((ImageView)paramView.findViewById(2131298246));
        paramViewGroup.gIq = ((TextView)paramView.findViewById(2131296472));
        paramViewGroup.fwQ = ((TextView)paramView.findViewById(2131296487));
        paramView.setTag(paramViewGroup);
        com.tencent.mm.plugin.address.d.b localb = ra(paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(localb.iYR)) {
          localStringBuilder.append(localb.iYR);
        }
        if (!TextUtils.isEmpty(localb.iYS))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.iYS);
        }
        if (!TextUtils.isEmpty(localb.iYT))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.iYT);
        }
        if (!TextUtils.isEmpty(localb.iYV))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.iYV);
        }
        paramViewGroup.gIq.setText(localStringBuilder.toString());
        paramViewGroup.fwQ.setText(localb.iYW + "，" + localb.iYX);
        if ((!WalletSelectAddrUI.e(WalletSelectAddrUI.this)) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this) == null) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this).id != localb.id)) {
          break label318;
        }
        paramViewGroup.iZZ.setImageResource(2131691078);
      }
      for (;;)
      {
        AppMethodBeat.o(21033);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label318:
        paramViewGroup.iZZ.setImageBitmap(null);
      }
    }
    
    final class a
    {
      TextView fwQ;
      TextView gIq;
      ImageView iZZ;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI
 * JD-Core Version:    0.7.0.1
 */