package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.m.a;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public class CardShopUI
  extends MMActivity
  implements m.a
{
  private ProgressDialog iLh;
  private View.OnClickListener kuO;
  private ListView mListView;
  BroadcastReceiver mReceiver;
  private String pQH;
  private com.tencent.mm.plugin.card.base.b pQV;
  private ArrayList<us> pRc;
  private boolean pXP;
  private String qdR;
  private a qdS;
  private LinearLayout qdT;
  private View qdU;
  private TextView qdV;
  
  public CardShopUI()
  {
    AppMethodBeat.i(113566);
    this.pRc = new ArrayList();
    this.qdR = "";
    this.pXP = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(113559);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        if ((paramAnonymousContext != null) && (paramAnonymousContext.equals("android.intent.action.LOCALE_CHANGED")) && (CardShopUI.cwn())) {
          CardShopUI.e(CardShopUI.this);
        }
        AppMethodBeat.o(113559);
      }
    };
    this.kuO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113560);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/card/ui/CardShopUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.getId() == 2131307846)
        {
          paramAnonymousView = (us)paramAnonymousView.getTag();
          if (paramAnonymousView != null)
          {
            com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousView.latitude, paramAnonymousView.dTj, paramAnonymousView.iUO);
            com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(5), CardShopUI.c(CardShopUI.this).csU(), CardShopUI.c(CardShopUI.this).csV(), "", paramAnonymousView.name });
          }
        }
        a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113560);
      }
    };
    AppMethodBeat.o(113566);
  }
  
  private void byG()
  {
    AppMethodBeat.i(113573);
    if (am.ctT().a(this.qdR, this.pQH, this))
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755998);
      this.iLh = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(2131757009), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(113558);
          paramAnonymousDialogInterface = am.ctT();
          paramAnonymousDialogInterface.a(CardShopUI.d(CardShopUI.this), CardShopUI.this);
          if (paramAnonymousDialogInterface.pRU != null) {
            g.aAg().hqi.a(paramAnonymousDialogInterface.pRU);
          }
          AppMethodBeat.o(113558);
        }
      });
      AppMethodBeat.o(113573);
      return;
    }
    com.tencent.mm.ui.base.h.cD(this, getString(2131757008));
    AppMethodBeat.o(113573);
  }
  
  private void cwl()
  {
    AppMethodBeat.i(113571);
    Log.i("MicroMsg.CardShopUI", "openLocation");
    registerReceiver();
    if (cwm())
    {
      byG();
      AppMethodBeat.o(113571);
      return;
    }
    d.c(this);
    AppMethodBeat.o(113571);
  }
  
  private static boolean cwm()
  {
    AppMethodBeat.i(113572);
    if ((!l.bcc()) && (!l.bcd())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(113572);
      return true;
    }
    AppMethodBeat.o(113572);
    return false;
  }
  
  private void registerReceiver()
  {
    AppMethodBeat.i(113574);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.LOCALE_CHANGED");
    registerReceiver(this.mReceiver, localIntentFilter);
    AppMethodBeat.o(113574);
  }
  
  public final void a(boolean paramBoolean, ArrayList<us> paramArrayList)
  {
    AppMethodBeat.i(113570);
    if (this.iLh != null)
    {
      this.iLh.dismiss();
      this.iLh = null;
    }
    if (paramArrayList == null) {}
    for (int i = 0;; i = paramArrayList.size())
    {
      Log.d("MicroMsg.CardShopUI", "onGotCardShop, isOk = %b, shop list size = %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      if (paramBoolean) {
        break;
      }
      Log.e("MicroMsg.CardShopUI", "onGotCardShop fail");
      AppMethodBeat.o(113570);
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      Log.e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
      AppMethodBeat.o(113570);
      return;
    }
    if (this.pRc != null)
    {
      this.pRc.clear();
      this.pRc.addAll(paramArrayList);
      this.qdU.setVisibility(0);
    }
    for (;;)
    {
      this.qdS.notifyDataSetChanged();
      AppMethodBeat.o(113570);
      return;
      this.qdU.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493438;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113568);
    if (!TextUtils.isEmpty(this.pQV.csQ().Lfd)) {
      setMMTitle(this.pQV.csQ().Lfd);
    }
    for (;;)
    {
      this.mListView = ((ListView)findViewById(2131298214));
      this.qdT = ((LinearLayout)View.inflate(getBaseContext(), 2131493408, null));
      this.mListView.addHeaderView(this.qdT);
      this.qdS = new a((byte)0);
      this.mListView.setAdapter(this.qdS);
      final Intent localIntent = getIntent();
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(113556);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          a.b("com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          if (paramAnonymousInt == 0)
          {
            Log.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
            a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113556);
            return;
          }
          int i = paramAnonymousInt;
          if (paramAnonymousInt > 0) {
            i = paramAnonymousInt - 1;
          }
          paramAnonymousAdapterView = (us)CardShopUI.a(CardShopUI.this).get(i);
          if ((!TextUtils.isEmpty(paramAnonymousAdapterView.Leo)) && (!TextUtils.isEmpty(paramAnonymousAdapterView.Lep)))
          {
            paramAnonymousInt = localIntent.getIntExtra("key_from_appbrand_type", 0);
            com.tencent.mm.plugin.card.d.b.d(CardShopUI.b(CardShopUI.this), paramAnonymousAdapterView.Leo, paramAnonymousAdapterView.Lep, 1052, paramAnonymousInt);
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113556);
            return;
            if (!TextUtils.isEmpty(paramAnonymousAdapterView.pTL))
            {
              com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousAdapterView.pTL, 1);
              com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(4), CardShopUI.c(CardShopUI.this).csU(), CardShopUI.c(CardShopUI.this).csV(), "", paramAnonymousAdapterView.name });
            }
          }
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(113557);
          CardShopUI.this.finish();
          AppMethodBeat.o(113557);
          return true;
        }
      });
      this.qdU = View.inflate(this, 2131493407, null);
      if (this.qdT != null) {
        this.qdT.addView(this.qdU);
      }
      this.qdV = ((TextView)this.qdU.findViewById(2131298160));
      this.qdV.setText(2131757167);
      this.qdU.setVisibility(8);
      AppMethodBeat.o(113568);
      return;
      setMMTitle(2131756965);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113567);
    super.onCreate(paramBundle);
    this.pQV = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    String str = getIntent().getStringExtra("KEY_CARD_TP_ID");
    paramBundle = getIntent().getStringExtra("KEY_CARD_ID");
    if (this.pQV != null)
    {
      Log.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
      this.qdR = this.pQV.csV();
      paramBundle = this.pQV.csU();
    }
    for (;;)
    {
      this.pQH = paramBundle;
      do
      {
        if (TextUtils.isEmpty(this.qdR))
        {
          Log.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
          finish();
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69, null, null);
        Log.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        this.pXP = bool;
        if (this.pXP) {
          cwl();
        }
        initView();
        AppMethodBeat.o(113567);
        return;
      } while (TextUtils.isEmpty(str));
      this.qdR = str;
      if (TextUtils.isEmpty(paramBundle)) {
        paramBundle = "";
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113569);
    if (this.pXP) {
      unregisterReceiver(this.mReceiver);
    }
    am.ctT().a(this.qdR, this);
    super.onDestroy();
    AppMethodBeat.o(113569);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(113575);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.CardShopUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(113575);
      return;
    }
    Log.i("MicroMsg.CardShopUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113575);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        Log.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.pXP);
        if (!this.pXP)
        {
          this.pXP = true;
          cwl();
        }
        AppMethodBeat.o(113575);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131757785), false, new CardShopUI.6(this), null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private us Ev(int paramInt)
    {
      AppMethodBeat.i(113563);
      us localus = (us)CardShopUI.a(CardShopUI.this).get(paramInt);
      AppMethodBeat.o(113563);
      return localus;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113562);
      int i = CardShopUI.a(CardShopUI.this).size();
      AppMethodBeat.o(113562);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(113564);
      if (paramView == null)
      {
        paramView = View.inflate(CardShopUI.this.getContext(), 2131493436, null);
        paramViewGroup = new a();
        paramViewGroup.qdX = ((TextView)paramView.findViewById(2131307843));
        paramViewGroup.qdY = ((TextView)paramView.findViewById(2131307839));
        paramViewGroup.qdZ = ((TextView)paramView.findViewById(2131307838));
        paramViewGroup.qea = ((ImageView)paramView.findViewById(2131307845));
        paramViewGroup.qeb = paramView.findViewById(2131307846);
        paramView.setTag(paramViewGroup);
      }
      us localus;
      for (;;)
      {
        localus = Ev(paramInt);
        if (localus != null) {
          break;
        }
        paramViewGroup.qdX.setText("");
        paramViewGroup.qdY.setText("");
        paramViewGroup.qdZ.setText("");
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.qdX.setText(localus.name);
      if (localus.DWG <= 0.0F) {
        paramViewGroup.qdY.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.qdZ.setText(localus.fuJ + localus.fuK + localus.iUO);
        paramViewGroup.qeb.setOnClickListener(CardShopUI.f(CardShopUI.this));
        paramViewGroup.qeb.setTag(localus);
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup.qdY.setText(l.f(CardShopUI.this.getBaseContext(), localus.DWG));
        paramViewGroup.qdY.setVisibility(0);
      }
    }
    
    final class a
    {
      public TextView qdX;
      public TextView qdY;
      public TextView qdZ;
      public ImageView qea;
      public View qeb;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI
 * JD-Core Version:    0.7.0.1
 */