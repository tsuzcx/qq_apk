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
import com.tencent.mm.g.a.mj;
import com.tencent.mm.g.a.mj.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private ListView gZb;
  private boolean jsy;
  private List<com.tencent.mm.plugin.address.d.b> jtW;
  private com.tencent.mm.plugin.address.d.b jtX;
  private a jtY;
  private com.tencent.mm.plugin.address.c.b jtZ;
  private View jua;
  private TextView jub;
  private p juc;
  private boolean jud;
  private boolean jue;
  private com.tencent.mm.ui.widget.a.d juf;
  private Object lockObj;
  
  public WalletSelectAddrUI()
  {
    AppMethodBeat.i(21037);
    this.jtW = new LinkedList();
    this.jtZ = null;
    this.jub = null;
    this.lockObj = new Object();
    this.jsy = false;
    this.jud = false;
    this.jue = false;
    this.juf = null;
    AppMethodBeat.o(21037);
  }
  
  private void aVc()
  {
    AppMethodBeat.i(21041);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.aUR();
      this.jtW = com.tencent.mm.plugin.address.a.a.aUT().jrP.jrY;
      this.jtY.hJj = this.jtW;
      this.jtW.size();
      this.jua.setVisibility(8);
      this.jtY.notifyDataSetChanged();
      AppMethodBeat.o(21041);
      return;
    }
  }
  
  private void aVh()
  {
    AppMethodBeat.i(21045);
    final mj localmj = new mj();
    localmj.dzR.dsa = this;
    localmj.dzR.dzT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21030);
        WalletSelectAddrUI.k(WalletSelectAddrUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21029);
            if (WalletSelectAddrUI.9.this.juj.dzS.dno)
            {
              ba.aBQ();
              String str1 = bt.nullAsNil((String)c.ajl().get(46, null));
              ba.aBQ();
              String str2 = bt.nullAsNil((String)c.ajl().get(72, null));
              WalletSelectAddrUI.a(WalletSelectAddrUI.this, str1, str2);
            }
            AppMethodBeat.o(21029);
          }
        });
        AppMethodBeat.o(21030);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.a(localmj, Looper.myLooper());
    AppMethodBeat.o(21045);
  }
  
  private void bW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21044);
    paramString1 = new com.tencent.mm.plugin.address.model.d(paramString1, paramString2, this.juc);
    this.jtZ.doSceneProgress(paramString1, true);
    AppMethodBeat.o(21044);
  }
  
  private void rz(int paramInt)
  {
    AppMethodBeat.i(21046);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, WalletAddAddressUI.class);
    ((Intent)localObject).putExtra("address_id", paramInt);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(21046);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(21043);
    this.jtZ.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 417)
      {
        if (((e)paramn).jrI)
        {
          aVc();
          getContentView().setVisibility(0);
          if ((this.jsy) && (this.jtW.size() == 0))
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
        com.tencent.mm.plugin.address.a.a.aUR();
        paramString = com.tencent.mm.plugin.address.a.a.aUT().rw(paramString.jrJ);
        if (paramString != null)
        {
          com.tencent.mm.plugin.address.a.a.aUR();
          ad.d("MicroMsg.WalletSelectAddrUI", "delte addr ".concat(String.valueOf(com.tencent.mm.plugin.address.a.a.aUT().a(paramString))));
        }
        aVc();
        AppMethodBeat.o(21043);
        return;
      }
      if (paramn.getType() == 419)
      {
        if (this.jtX != null)
        {
          setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.jtX));
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
            if (this.juf != null) {
              this.juf.dismiss();
            }
            this.juf = h.a(this, paramString, null, true, null);
            AppMethodBeat.o(21043);
            return;
            ba.aBQ();
            c.ajl().set(196657, Boolean.TRUE);
            this.jub.setVisibility(8);
            paramString = getString(2131755241);
            continue;
            ba.aBQ();
            c.ajl().set(196657, Boolean.TRUE);
            this.jub.setVisibility(8);
            aVc();
            getContentView().setVisibility(0);
            paramString = getString(2131755242);
          }
        }
        aVh();
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
    this.jub = ((TextView)findViewById(2131300994));
    this.jub.setVisibility(8);
    this.jub.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21022);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    this.gZb = ((ListView)findViewById(2131304652));
    this.jtY = new a(this);
    this.jua = findViewById(2131296450);
    this.jua.findViewById(2131296472).setVisibility(8);
    ((TextView)this.jua.findViewById(2131296487)).setText(2131755171);
    this.gZb.setAdapter(this.jtY);
    this.gZb.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> arg1, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(21023);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(???);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        ad.d("MicroMsg.WalletSelectAddrUI", "select pos ".concat(String.valueOf(paramAnonymousInt)));
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
    this.gZb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(21025);
        paramAnonymousAdapterView = WalletSelectAddrUI.this.getResources().getStringArray(2130903095);
        h.a(WalletSelectAddrUI.this.getContext(), null, paramAnonymousAdapterView, null, new h.c()
        {
          public final void lf(int paramAnonymous2Int)
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
    aVc();
    this.jua.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21026);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletSelectAddrUI.j(WalletSelectAddrUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(21026);
      }
    });
    this.jtY.notifyDataSetChanged();
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
      localb.jsh = paramIntent.getStringExtra("nationalCode");
      localb.jsf = paramIntent.getStringExtra("userName");
      localb.jsg = paramIntent.getStringExtra("telNumber");
      localb.jsd = paramIntent.getStringExtra("addressPostalCode");
      localb.jsa = paramIntent.getStringExtra("proviceFirstStageName");
      localb.jsb = paramIntent.getStringExtra("addressCitySecondStageName");
      localb.jsc = paramIntent.getStringExtra("addressCountiesThirdStageName");
      localb.jse = paramIntent.getStringExtra("addressDetailInfo");
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
    this.jtZ = new com.tencent.mm.plugin.address.c.b(this, this);
    paramBundle = getIntent();
    this.jud = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    this.jue = paramBundle.getBooleanExtra("launch_from_remittance", false);
    boolean bool = paramBundle.getBooleanExtra("launch_from_webview", false);
    if ((bool) || (this.jud))
    {
      this.jsy = true;
      getContentView().setVisibility(8);
      if (this.jud) {
        getWindow().setBackgroundDrawableResource(2131100695);
      }
      if (bool)
      {
        ad.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
        ba.aBQ();
        if (((Boolean)c.ajl().get(al.a.Iwc, Boolean.TRUE)).booleanValue())
        {
          ad.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
          h.a(this, getString(2131755227), getString(2131755228), getString(2131755012), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(21019);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(21019);
            }
          });
          ba.aBQ();
          c.ajl().set(al.a.Iwc, Boolean.FALSE);
        }
      }
    }
    setMMTitle(2131755226);
    this.jtZ.addSceneEndListener(417);
    this.jtZ.addSceneEndListener(416);
    this.jtZ.addSceneEndListener(419);
    this.jtZ.addSceneEndListener(582);
    paramBundle = new e(paramBundle.getStringExtra("req_url"), paramBundle.getStringExtra("req_app_id"), 2);
    this.jtZ.doSceneProgress(paramBundle, false);
    ba.aBQ();
    this.juc = new p(bt.a((Integer)c.ajl().get(9, null), 0));
    com.tencent.mm.plugin.address.a.a.aUT().aUU();
    initView();
    ba.aBQ();
    if (c.isSDCardAvailable())
    {
      paramBundle = new com.tencent.mm.bc.l(12);
      ba.aiU().a(paramBundle, 0);
    }
    AppMethodBeat.o(21038);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21039);
    super.onDestroy();
    this.jtZ.removeSceneEndListener(417);
    this.jtZ.removeSceneEndListener(416);
    this.jtZ.removeSceneEndListener(419);
    this.jtZ.removeSceneEndListener(582);
    AppMethodBeat.o(21039);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21040);
    super.onResume();
    aVc();
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
    List<com.tencent.mm.plugin.address.d.b> hJj;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(21032);
      this.hJj = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(21032);
    }
    
    private com.tencent.mm.plugin.address.d.b rA(int paramInt)
    {
      AppMethodBeat.i(21035);
      com.tencent.mm.plugin.address.d.b localb = (com.tencent.mm.plugin.address.d.b)this.hJj.get(paramInt);
      AppMethodBeat.o(21035);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(21034);
      int i = this.hJj.size();
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
        paramViewGroup.jti = ((ImageView)paramView.findViewById(2131298246));
        paramViewGroup.hca = ((TextView)paramView.findViewById(2131296472));
        paramViewGroup.fQd = ((TextView)paramView.findViewById(2131296487));
        paramView.setTag(paramViewGroup);
        com.tencent.mm.plugin.address.d.b localb = rA(paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(localb.jsa)) {
          localStringBuilder.append(localb.jsa);
        }
        if (!TextUtils.isEmpty(localb.jsb))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.jsb);
        }
        if (!TextUtils.isEmpty(localb.jsc))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.jsc);
        }
        if (!TextUtils.isEmpty(localb.jse))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.jse);
        }
        paramViewGroup.hca.setText(localStringBuilder.toString());
        paramViewGroup.fQd.setText(localb.jsf + "，" + localb.jsg);
        if ((!WalletSelectAddrUI.e(WalletSelectAddrUI.this)) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this) == null) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this).id != localb.id)) {
          break label318;
        }
        paramViewGroup.jti.setImageResource(2131691078);
      }
      for (;;)
      {
        AppMethodBeat.o(21033);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label318:
        paramViewGroup.jti.setImageBitmap(null);
      }
    }
    
    final class a
    {
      TextView fQd;
      TextView hca;
      ImageView jti;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI
 * JD-Core Version:    0.7.0.1
 */