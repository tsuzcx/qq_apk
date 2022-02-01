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
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.p;
import com.tencent.mm.bb.n;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.model.bg;
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
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletSelectAddrUI
  extends MMActivity
  implements com.tencent.mm.plugin.address.c.a
{
  private ListView hUI;
  private boolean ktF;
  private boolean kuZ;
  private List<com.tencent.mm.plugin.address.d.b> kvf;
  private com.tencent.mm.plugin.address.d.b kvg;
  private a kvh;
  private com.tencent.mm.plugin.address.c.b kvi;
  private View kvj;
  private TextView kvk;
  private p kvl;
  private boolean kvm;
  private boolean kvn;
  private com.tencent.mm.ui.widget.a.d kvo;
  private boolean kvp;
  private Object lockObj;
  
  public WalletSelectAddrUI()
  {
    AppMethodBeat.i(21037);
    this.kvf = new LinkedList();
    this.kvi = null;
    this.kvk = null;
    this.lockObj = new Object();
    this.ktF = false;
    this.kvm = false;
    this.kvn = false;
    this.kvo = null;
    AppMethodBeat.o(21037);
  }
  
  private void bqn()
  {
    AppMethodBeat.i(21041);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.bqb();
      this.kvf = com.tencent.mm.plugin.address.a.a.bqd().ksX.ktf;
      this.kvh.iHf = this.kvf;
      this.kvf.size();
      this.kvj.setVisibility(8);
      this.kvh.notifyDataSetChanged();
      AppMethodBeat.o(21041);
      return;
    }
  }
  
  private void bqs()
  {
    AppMethodBeat.i(21045);
    nb localnb = new nb();
    localnb.dSL.dKq = this;
    localnb.dSL.dSN = new WalletSelectAddrUI.9(this, localnb);
    EventCenter.instance.asyncPublish(localnb, Looper.myLooper());
    AppMethodBeat.o(21045);
  }
  
  private void cf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21044);
    paramString1 = new com.tencent.mm.plugin.address.model.d(paramString1, paramString2, this.kvl);
    this.kvi.doSceneProgress(paramString1, true);
    AppMethodBeat.o(21044);
  }
  
  private void vs(int paramInt)
  {
    AppMethodBeat.i(21046);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, WalletAddAddressUI.class);
    ((Intent)localObject).putExtra("address_id", paramInt);
    ((Intent)localObject).putExtra("force_light_mode", this.kuZ);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(21046);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(21043);
    this.kvi.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() == 417)
      {
        if (((e)paramq).ksQ)
        {
          bqn();
          getContentView().findViewById(2131296544).setVisibility(0);
          if ((this.ktF) && (this.kvf.size() == 0))
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
        com.tencent.mm.plugin.address.a.a.bqb();
        paramString = com.tencent.mm.plugin.address.a.a.bqd().vp(paramString.ksR);
        if (paramString != null)
        {
          com.tencent.mm.plugin.address.a.a.bqb();
          Log.d("MicroMsg.WalletSelectAddrUI", "delte addr ".concat(String.valueOf(com.tencent.mm.plugin.address.a.a.bqd().a(paramString))));
        }
        bqn();
        AppMethodBeat.o(21043);
        return;
      }
      if (paramq.getType() == 419)
      {
        if (this.kvg != null)
        {
          setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.kvg));
          finish();
          AppMethodBeat.o(21043);
        }
      }
      else if (paramq.getType() == 582)
      {
        paramString = getString(2131755274);
        switch (((com.tencent.mm.plugin.address.model.d)paramq).status)
        {
        default: 
        case 1: 
        case 2: 
        case 0: 
          for (;;)
          {
            if (this.kvo != null) {
              this.kvo.dismiss();
            }
            this.kvo = h.a(this, paramString, null, true, null);
            AppMethodBeat.o(21043);
            return;
            bg.aVF();
            c.azQ().set(196657, Boolean.TRUE);
            this.kvk.setVisibility(8);
            paramString = getString(2131755275);
            continue;
            bg.aVF();
            c.azQ().set(196657, Boolean.TRUE);
            this.kvk.setVisibility(8);
            bqn();
            getContentView().setVisibility(0);
            paramString = getString(2131755276);
          }
        }
        bqs();
        AppMethodBeat.o(21043);
      }
    }
    else if ((paramq.getType() == 419) && (paramInt2 == -3103))
    {
      h.a(this, true, paramString, "", getString(2131755195), getString(2131755761), new DialogInterface.OnClickListener()new WalletSelectAddrUI.2
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
  
  public boolean convertActivityFromTranslucent()
  {
    return !this.kvp;
  }
  
  public int getLayoutId()
  {
    return 2131496874;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21042);
    this.kvk = ((TextView)findViewById(2131302635));
    this.kvk.setVisibility(8);
    this.kvk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21022);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        h.a(WalletSelectAddrUI.this, true, WalletSelectAddrUI.this.getString(2131755271, new Object[] { WalletSelectAddrUI.a(WalletSelectAddrUI.this).toString() }), "", WalletSelectAddrUI.this.getString(2131755272), WalletSelectAddrUI.this.getString(2131755761), new DialogInterface.OnClickListener()
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
    this.hUI = ((ListView)findViewById(2131307705));
    this.kvh = new a(this);
    this.kvj = findViewById(2131296522);
    this.kvj.findViewById(2131296546).setVisibility(8);
    ((TextView)this.kvj.findViewById(2131296561)).setText(2131755189);
    this.hUI.setAdapter(this.kvh);
    this.hUI.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> arg1, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(21023);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(???);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
    this.hUI.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(21025);
        paramAnonymousAdapterView = WalletSelectAddrUI.this.getResources().getStringArray(2130903097);
        h.a(WalletSelectAddrUI.this.getContext(), null, paramAnonymousAdapterView, null, new h.d()
        {
          public final void oj(int paramAnonymous2Int)
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
    bqn();
    this.kvj.setOnClickListener(new WalletSelectAddrUI.6(this));
    this.kvh.notifyDataSetChanged();
    setBackBtn(new WalletSelectAddrUI.7(this));
    addIconOptionMenu(0, 2131755191, 2131689491, new WalletSelectAddrUI.8(this));
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
      localb.kto = paramIntent.getStringExtra("nationalCode");
      localb.ktm = paramIntent.getStringExtra("userName");
      localb.ktn = paramIntent.getStringExtra("telNumber");
      localb.ktk = paramIntent.getStringExtra("addressPostalCode");
      localb.kth = paramIntent.getStringExtra("proviceFirstStageName");
      localb.kti = paramIntent.getStringExtra("addressCitySecondStageName");
      localb.ktj = paramIntent.getStringExtra("addressCountiesThirdStageName");
      localb.ktl = paramIntent.getStringExtra("addressDetailInfo");
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
    paramBundle = getIntent();
    this.kvm = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    this.kvn = paramBundle.getBooleanExtra("launch_from_remittance", false);
    boolean bool = paramBundle.getBooleanExtra("launch_from_webview", false);
    if ((bool) || (this.kvm))
    {
      this.ktF = true;
      getContentView().findViewById(2131296544).setVisibility(8);
      if ((this.kvm) && (!this.kvp)) {
        getWindow().setBackgroundDrawableResource(2131100888);
      }
      if (bool)
      {
        Log.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
        bg.aVF();
        if (((Boolean)c.azQ().get(ar.a.NYB, Boolean.TRUE)).booleanValue())
        {
          Log.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
          h.a(this, getString(2131755261), getString(2131755262), getString(2131755013), new WalletSelectAddrUI.1(this));
          bg.aVF();
          c.azQ().set(ar.a.NYB, Boolean.FALSE);
        }
      }
    }
    this.kvi = new com.tencent.mm.plugin.address.c.b(this, this);
    setMMTitle(2131755260);
    this.kvi.addSceneEndListener(417);
    this.kvi.addSceneEndListener(416);
    this.kvi.addSceneEndListener(419);
    this.kvi.addSceneEndListener(582);
    e locale = new e(paramBundle.getStringExtra("req_url"), paramBundle.getStringExtra("req_app_id"), 2);
    this.kvi.doSceneProgress(locale, false);
    bg.aVF();
    this.kvl = new p(Util.nullAs((Integer)c.azQ().get(9, null), 0));
    com.tencent.mm.plugin.address.a.a.bqd().bqe();
    initView();
    this.kuZ = paramBundle.getBooleanExtra("force_light_mode", false);
    if (this.kuZ)
    {
      getContentView().findViewById(2131299180).setBackgroundColor(getContext().getResources().getColor(2131099694));
      getContentView().findViewById(2131296544).setBackgroundColor(getContext().getResources().getColor(2131099694));
      setActionbarColor(getContext().getResources().getColor(2131099837));
      setNavigationbarColor(getContext().getResources().getColor(2131099837));
    }
    bg.aVF();
    if (c.isSDCardAvailable())
    {
      paramBundle = new n(12);
      bg.azz().a(paramBundle, 0);
    }
    AppMethodBeat.o(21038);
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(231582);
    super.onCreateBeforeSetContentView();
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("content_view_height", -1);
    if (i != -1) {}
    for (boolean bool = true;; bool = false)
    {
      this.kvp = bool;
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
      Log.i("MicroMsg.WalletSelectAddrUI", "forceTransparent = " + this.kvp);
      AppMethodBeat.o(231582);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21039);
    super.onDestroy();
    this.kvi.removeSceneEndListener(417);
    this.kvi.removeSceneEndListener(416);
    this.kvi.removeSceneEndListener(419);
    this.kvi.removeSceneEndListener(582);
    AppMethodBeat.o(21039);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21040);
    super.onResume();
    bqn();
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
    List<com.tencent.mm.plugin.address.d.b> iHf;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(21032);
      this.iHf = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(21032);
    }
    
    private com.tencent.mm.plugin.address.d.b vt(int paramInt)
    {
      AppMethodBeat.i(21035);
      com.tencent.mm.plugin.address.d.b localb = (com.tencent.mm.plugin.address.d.b)this.iHf.get(paramInt);
      AppMethodBeat.o(21035);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(21034);
      int i = this.iHf.size();
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
        paramView = View.inflate(this.context, 2131496873, null);
        paramViewGroup.kup = ((ImageView)paramView.findViewById(2131298630));
        paramViewGroup.hXC = ((TextView)paramView.findViewById(2131296546));
        paramViewGroup.gxs = ((TextView)paramView.findViewById(2131296561));
        if (WalletSelectAddrUI.k(WalletSelectAddrUI.this))
        {
          paramView.setBackgroundResource(2131231900);
          paramViewGroup.gxs.setTextColor(WalletSelectAddrUI.this.getContext().getResources().getColor(2131099836));
          paramViewGroup.hXC.setTextColor(WalletSelectAddrUI.this.getContext().getResources().getColor(2131099834));
        }
        paramView.setTag(paramViewGroup);
        com.tencent.mm.plugin.address.d.b localb = vt(paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(localb.kth)) {
          localStringBuilder.append(localb.kth);
        }
        if (!TextUtils.isEmpty(localb.kti))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.kti);
        }
        if (!TextUtils.isEmpty(localb.ktj))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.ktj);
        }
        if (!TextUtils.isEmpty(localb.ktl))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(localb.ktl);
        }
        paramViewGroup.hXC.setText(localStringBuilder.toString());
        paramViewGroup.gxs.setText(localb.ktm + "，" + localb.ktn);
        if ((!WalletSelectAddrUI.e(WalletSelectAddrUI.this)) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this) == null) || (WalletSelectAddrUI.g(WalletSelectAddrUI.this).id != localb.id)) {
          break label378;
        }
        paramViewGroup.kup.setImageResource(2131691380);
      }
      for (;;)
      {
        AppMethodBeat.o(21033);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label378:
        paramViewGroup.kup.setImageBitmap(null);
      }
    }
    
    final class a
    {
      TextView gxs;
      TextView hXC;
      ImageView kup;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI
 * JD-Core Version:    0.7.0.1
 */