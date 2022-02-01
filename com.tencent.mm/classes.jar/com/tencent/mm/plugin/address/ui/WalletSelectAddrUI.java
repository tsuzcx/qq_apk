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
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.mk.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private ListView hbO;
  private boolean jvr;
  private List<com.tencent.mm.plugin.address.d.b> jwR;
  private com.tencent.mm.plugin.address.d.b jwS;
  private a jwT;
  private com.tencent.mm.plugin.address.c.b jwU;
  private View jwV;
  private TextView jwW;
  private p jwX;
  private boolean jwY;
  private boolean jwZ;
  private com.tencent.mm.ui.widget.a.d jxa;
  private Object lockObj;
  
  public WalletSelectAddrUI()
  {
    AppMethodBeat.i(21037);
    this.jwR = new LinkedList();
    this.jwU = null;
    this.jwW = null;
    this.lockObj = new Object();
    this.jvr = false;
    this.jwY = false;
    this.jwZ = false;
    this.jxa = null;
    AppMethodBeat.o(21037);
  }
  
  private void aVB()
  {
    AppMethodBeat.i(21041);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.aVq();
      this.jwR = com.tencent.mm.plugin.address.a.a.aVs().juI.juR;
      this.jwT.hMc = this.jwR;
      this.jwR.size();
      this.jwV.setVisibility(8);
      this.jwT.notifyDataSetChanged();
      AppMethodBeat.o(21041);
      return;
    }
  }
  
  private void aVG()
  {
    AppMethodBeat.i(21045);
    final mk localmk = new mk();
    localmk.dAW.dtg = this;
    localmk.dAW.dAY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21030);
        WalletSelectAddrUI.k(WalletSelectAddrUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21029);
            if (WalletSelectAddrUI.9.this.jxe.dAX.doq)
            {
              bc.aCg();
              String str1 = bu.nullAsNil((String)c.ajA().get(46, null));
              bc.aCg();
              String str2 = bu.nullAsNil((String)c.ajA().get(72, null));
              WalletSelectAddrUI.a(WalletSelectAddrUI.this, str1, str2);
            }
            AppMethodBeat.o(21029);
          }
        });
        AppMethodBeat.o(21030);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.a(localmk, Looper.myLooper());
    AppMethodBeat.o(21045);
  }
  
  private void bW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21044);
    paramString1 = new com.tencent.mm.plugin.address.model.d(paramString1, paramString2, this.jwX);
    this.jwU.doSceneProgress(paramString1, true);
    AppMethodBeat.o(21044);
  }
  
  private void rC(int paramInt)
  {
    AppMethodBeat.i(21046);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, WalletAddAddressUI.class);
    ((Intent)localObject).putExtra("address_id", paramInt);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(21046);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(21043);
    this.jwU.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 417)
      {
        if (((e)paramn).juB)
        {
          aVB();
          getContentView().setVisibility(0);
          if ((this.jvr) && (this.jwR.size() == 0))
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
        com.tencent.mm.plugin.address.a.a.aVq();
        paramString = com.tencent.mm.plugin.address.a.a.aVs().rz(paramString.juC);
        if (paramString != null)
        {
          com.tencent.mm.plugin.address.a.a.aVq();
          ae.d("MicroMsg.WalletSelectAddrUI", "delte addr ".concat(String.valueOf(com.tencent.mm.plugin.address.a.a.aVs().a(paramString))));
        }
        aVB();
        AppMethodBeat.o(21043);
        return;
      }
      if (paramn.getType() == 419)
      {
        if (this.jwS != null)
        {
          setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.jwS));
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
            if (this.jxa != null) {
              this.jxa.dismiss();
            }
            this.jxa = h.a(this, paramString, null, true, null);
            AppMethodBeat.o(21043);
            return;
            bc.aCg();
            c.ajA().set(196657, Boolean.TRUE);
            this.jwW.setVisibility(8);
            paramString = getString(2131755241);
            continue;
            bc.aCg();
            c.ajA().set(196657, Boolean.TRUE);
            this.jwW.setVisibility(8);
            aVB();
            getContentView().setVisibility(0);
            paramString = getString(2131755242);
          }
        }
        aVG();
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
    this.jwW = ((TextView)findViewById(2131300994));
    this.jwW.setVisibility(8);
    this.jwW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21022);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        h.a(WalletSelectAddrUI.this, true, WalletSelectAddrUI.this.getString(2131755237, new Object[] { WalletSelectAddrUI.a(WalletSelectAddrUI.this).toString() }), "", WalletSelectAddrUI.this.getString(2131755238), WalletSelectAddrUI.this.getString(2131755691), new DialogInterface.OnClickListener()
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
    this.hbO = ((ListView)findViewById(2131304652));
    this.jwT = new a(this);
    this.jwV = findViewById(2131296450);
    this.jwV.findViewById(2131296472).setVisibility(8);
    ((TextView)this.jwV.findViewById(2131296487)).setText(2131755171);
    this.hbO.setAdapter(this.jwT);
    this.hbO.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> arg1, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(21023);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(???);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        ae.d("MicroMsg.WalletSelectAddrUI", "select pos ".concat(String.valueOf(paramAnonymousInt)));
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
    this.hbO.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(21025);
        paramAnonymousAdapterView = WalletSelectAddrUI.this.getResources().getStringArray(2130903095);
        h.a(WalletSelectAddrUI.this.getContext(), null, paramAnonymousAdapterView, null, new h.c()
        {
          public final void lh(int paramAnonymous2Int)
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
    aVB();
    this.jwV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21026);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletSelectAddrUI.j(WalletSelectAddrUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(21026);
      }
    });
    this.jwT.notifyDataSetChanged();
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
      ae.e("MicroMsg.AddrUtil", "intent == null");
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
      localb.jva = paramIntent.getStringExtra("nationalCode");
      localb.juY = paramIntent.getStringExtra("userName");
      localb.juZ = paramIntent.getStringExtra("telNumber");
      localb.juW = paramIntent.getStringExtra("addressPostalCode");
      localb.juT = paramIntent.getStringExtra("proviceFirstStageName");
      localb.juU = paramIntent.getStringExtra("addressCitySecondStageName");
      localb.juV = paramIntent.getStringExtra("addressCountiesThirdStageName");
      localb.juX = paramIntent.getStringExtra("addressDetailInfo");
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
    this.jwU = new com.tencent.mm.plugin.address.c.b(this, this);
    paramBundle = getIntent();
    this.jwY = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    this.jwZ = paramBundle.getBooleanExtra("launch_from_remittance", false);
    boolean bool = paramBundle.getBooleanExtra("launch_from_webview", false);
    if ((bool) || (this.jwY))
    {
      this.jvr = true;
      getContentView().setVisibility(8);
      if (this.jwY) {
        getWindow().setBackgroundDrawableResource(2131100695);
      }
      if (bool)
      {
        ae.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
        bc.aCg();
        if (((Boolean)c.ajA().get(am.a.IQA, Boolean.TRUE)).booleanValue())
        {
          ae.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
          h.a(this, getString(2131755227), getString(2131755228), getString(2131755012), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(21019);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(21019);
            }
          });
          bc.aCg();
          c.ajA().set(am.a.IQA, Boolean.FALSE);
        }
      }
    }
    setMMTitle(2131755226);
    this.jwU.addSceneEndListener(417);
    this.jwU.addSceneEndListener(416);
    this.jwU.addSceneEndListener(419);
    this.jwU.addSceneEndListener(582);
    paramBundle = new e(paramBundle.getStringExtra("req_url"), paramBundle.getStringExtra("req_app_id"), 2);
    this.jwU.doSceneProgress(paramBundle, false);
    bc.aCg();
    this.jwX = new p(bu.a((Integer)c.ajA().get(9, null), 0));
    com.tencent.mm.plugin.address.a.a.aVs().aVt();
    initView();
    bc.aCg();
    if (c.isSDCardAvailable())
    {
      paramBundle = new com.tencent.mm.bb.l(12);
      bc.ajj().a(paramBundle, 0);
    }
    AppMethodBeat.o(21038);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21039);
    super.onDestroy();
    this.jwU.removeSceneEndListener(417);
    this.jwU.removeSceneEndListener(416);
    this.jwU.removeSceneEndListener(419);
    this.jwU.removeSceneEndListener(582);
    AppMethodBeat.o(21039);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21040);
    super.onResume();
    aVB();
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
    List<com.tencent.mm.plugin.address.d.b> hMc;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(21032);
      this.hMc = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(21032);
    }
    
    private com.tencent.mm.plugin.address.d.b rD(int paramInt)
    {
      AppMethodBeat.i(21035);
      com.tencent.mm.plugin.address.d.b localb = (com.tencent.mm.plugin.address.d.b)this.hMc.get(paramInt);
      AppMethodBeat.o(21035);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(21034);
      int i = this.hMc.size();
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
        paramViewGroup.jwb = ((ImageView)paramView.findViewById(2131298246));
        paramViewGroup.heO = ((TextView)paramView.findViewById(2131296472));
        paramViewGroup.fSj = ((TextView)paramView.findViewById(2131296487));
        paramView.setTag(paramViewGroup);
        com.tencent.mm.plugin.address.d.b localb = rD(paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(localb.juT)) {
          localStringBuilder.append(localb.juT);
        }
        if (!TextUtils.isEmpty(localb.juU))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.juU);
        }
        if (!TextUtils.isEmpty(localb.juV))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.juV);
        }
        if (!TextUtils.isEmpty(localb.juX))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.juX);
        }
        paramViewGroup.heO.setText(localStringBuilder.toString());
        paramViewGroup.fSj.setText(localb.juY + "，" + localb.juZ);
        if ((!WalletSelectAddrUI.e(WalletSelectAddrUI.this)) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this) == null) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this).id != localb.id)) {
          break label318;
        }
        paramViewGroup.jwb.setImageResource(2131691078);
      }
      for (;;)
      {
        AppMethodBeat.o(21033);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label318:
        paramViewGroup.jwb.setImageBitmap(null);
      }
    }
    
    final class a
    {
      TextView fSj;
      TextView heO;
      ImageView jwb;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI
 * JD-Core Version:    0.7.0.1
 */