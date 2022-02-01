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
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.m.a;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class CardShopUI
  extends MMActivity
  implements m.a
{
  private ProgressDialog hNi;
  private View.OnClickListener jtG;
  private ListView mListView;
  BroadcastReceiver mReceiver;
  private boolean oDz;
  private String oJB;
  private a oJC;
  private LinearLayout oJD;
  private View oJE;
  private TextView oJF;
  private com.tencent.mm.plugin.card.base.b owK;
  private ArrayList<tl> owR;
  private String oww;
  
  public CardShopUI()
  {
    AppMethodBeat.i(113566);
    this.owR = new ArrayList();
    this.oJB = "";
    this.oDz = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(113559);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        if ((paramAnonymousContext != null) && (paramAnonymousContext.equals("android.intent.action.LOCALE_CHANGED")) && (CardShopUI.bXi())) {
          CardShopUI.e(CardShopUI.this);
        }
        AppMethodBeat.o(113559);
      }
    };
    this.jtG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113560);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/card/ui/CardShopUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramAnonymousView.getId() == 2131304770)
        {
          paramAnonymousView = (tl)paramAnonymousView.getTag();
          if (paramAnonymousView != null)
          {
            com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousView.dyz, paramAnonymousView.dAp, paramAnonymousView.hWY);
            com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(5), CardShopUI.c(CardShopUI.this).bTR(), CardShopUI.c(CardShopUI.this).bTS(), "", paramAnonymousView.name });
          }
        }
        a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113560);
      }
    };
    AppMethodBeat.o(113566);
  }
  
  private void bXg()
  {
    AppMethodBeat.i(113571);
    ad.i("MicroMsg.CardShopUI", "openLocation");
    registerReceiver();
    if (bXh())
    {
      bcJ();
      AppMethodBeat.o(113571);
      return;
    }
    d.c(this);
    AppMethodBeat.o(113571);
  }
  
  private static boolean bXh()
  {
    AppMethodBeat.i(113572);
    if ((!l.aHR()) && (!l.aHS())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(113572);
      return true;
    }
    AppMethodBeat.o(113572);
    return false;
  }
  
  private void bcJ()
  {
    AppMethodBeat.i(113573);
    if (am.bUQ().a(this.oJB, this.oww, this))
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.hNi = h.b(localAppCompatActivity, getString(2131756844), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(113558);
          paramAnonymousDialogInterface = am.bUQ();
          paramAnonymousDialogInterface.a(CardShopUI.d(CardShopUI.this), CardShopUI.this);
          if (paramAnonymousDialogInterface.oxJ != null) {
            com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousDialogInterface.oxJ);
          }
          AppMethodBeat.o(113558);
        }
      });
      AppMethodBeat.o(113573);
      return;
    }
    h.cl(this, getString(2131756843));
    AppMethodBeat.o(113573);
  }
  
  private void registerReceiver()
  {
    AppMethodBeat.i(113574);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.LOCALE_CHANGED");
    registerReceiver(this.mReceiver, localIntentFilter);
    AppMethodBeat.o(113574);
  }
  
  public final void a(boolean paramBoolean, ArrayList<tl> paramArrayList)
  {
    AppMethodBeat.i(113570);
    if (this.hNi != null)
    {
      this.hNi.dismiss();
      this.hNi = null;
    }
    if (paramArrayList == null) {}
    for (int i = 0;; i = paramArrayList.size())
    {
      ad.d("MicroMsg.CardShopUI", "onGotCardShop, isOk = %b, shop list size = %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      if (paramBoolean) {
        break;
      }
      ad.e("MicroMsg.CardShopUI", "onGotCardShop fail");
      AppMethodBeat.o(113570);
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ad.e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
      AppMethodBeat.o(113570);
      return;
    }
    if (this.owR != null)
    {
      this.owR.clear();
      this.owR.addAll(paramArrayList);
      this.oJE.setVisibility(0);
    }
    for (;;)
    {
      this.oJC.notifyDataSetChanged();
      AppMethodBeat.o(113570);
      return;
      this.oJE.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493347;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113568);
    if (!TextUtils.isEmpty(this.owK.bTN().FSb)) {
      setMMTitle(this.owK.bTN().FSb);
    }
    for (;;)
    {
      this.mListView = ((ListView)findViewById(2131297896));
      this.oJD = ((LinearLayout)View.inflate(getBaseContext(), 2131493317, null));
      this.mListView.addHeaderView(this.oJD);
      this.oJC = new a((byte)0);
      this.mListView.setAdapter(this.oJC);
      final Intent localIntent = getIntent();
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(113556);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          a.b("com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          if (paramAnonymousInt == 0)
          {
            ad.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
            a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113556);
            return;
          }
          int i = paramAnonymousInt;
          if (paramAnonymousInt > 0) {
            i = paramAnonymousInt - 1;
          }
          paramAnonymousAdapterView = (tl)CardShopUI.a(CardShopUI.this).get(i);
          if ((!TextUtils.isEmpty(paramAnonymousAdapterView.FRk)) && (!TextUtils.isEmpty(paramAnonymousAdapterView.FRl)))
          {
            paramAnonymousInt = localIntent.getIntExtra("key_from_appbrand_type", 0);
            com.tencent.mm.plugin.card.d.b.d(CardShopUI.b(CardShopUI.this), paramAnonymousAdapterView.FRk, paramAnonymousAdapterView.FRl, 1052, paramAnonymousInt);
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113556);
            return;
            if (!TextUtils.isEmpty(paramAnonymousAdapterView.ozD))
            {
              com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousAdapterView.ozD, 1);
              com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(4), CardShopUI.c(CardShopUI.this).bTR(), CardShopUI.c(CardShopUI.this).bTS(), "", paramAnonymousAdapterView.name });
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
      this.oJE = View.inflate(this, 2131493316, null);
      if (this.oJD != null) {
        this.oJD.addView(this.oJE);
      }
      this.oJF = ((TextView)this.oJE.findViewById(2131297844));
      this.oJF.setText(2131756997);
      this.oJE.setVisibility(8);
      AppMethodBeat.o(113568);
      return;
      setMMTitle(2131756800);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113567);
    super.onCreate(paramBundle);
    this.owK = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    String str = getIntent().getStringExtra("KEY_CARD_TP_ID");
    paramBundle = getIntent().getStringExtra("KEY_CARD_ID");
    if (this.owK != null)
    {
      ad.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
      this.oJB = this.owK.bTS();
      paramBundle = this.owK.bTR();
    }
    for (;;)
    {
      this.oww = paramBundle;
      do
      {
        if (TextUtils.isEmpty(this.oJB))
        {
          ad.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
          finish();
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
        ad.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        this.oDz = bool;
        if (this.oDz) {
          bXg();
        }
        initView();
        AppMethodBeat.o(113567);
        return;
      } while (TextUtils.isEmpty(str));
      this.oJB = str;
      if (TextUtils.isEmpty(paramBundle)) {
        paramBundle = "";
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113569);
    if (this.oDz) {
      unregisterReceiver(this.mReceiver);
    }
    am.bUQ().a(this.oJB, this);
    super.onDestroy();
    AppMethodBeat.o(113569);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(113575);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.CardShopUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(113575);
      return;
    }
    ad.i("MicroMsg.CardShopUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113575);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ad.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.oDz);
        if (!this.oDz)
        {
          this.oDz = true;
          bXg();
        }
        AppMethodBeat.o(113575);
        return;
      }
      h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131757558), false, new CardShopUI.6(this), null);
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
    
    private tl AE(int paramInt)
    {
      AppMethodBeat.i(113563);
      tl localtl = (tl)CardShopUI.a(CardShopUI.this).get(paramInt);
      AppMethodBeat.o(113563);
      return localtl;
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
        paramView = View.inflate(CardShopUI.this.getContext(), 2131493345, null);
        paramViewGroup = new a();
        paramViewGroup.oJH = ((TextView)paramView.findViewById(2131304767));
        paramViewGroup.oJI = ((TextView)paramView.findViewById(2131304764));
        paramViewGroup.oJJ = ((TextView)paramView.findViewById(2131304763));
        paramViewGroup.oJK = ((ImageView)paramView.findViewById(2131304769));
        paramViewGroup.oJL = paramView.findViewById(2131304770);
        paramView.setTag(paramViewGroup);
      }
      tl localtl;
      for (;;)
      {
        localtl = AE(paramInt);
        if (localtl != null) {
          break;
        }
        paramViewGroup.oJH.setText("");
        paramViewGroup.oJI.setText("");
        paramViewGroup.oJJ.setText("");
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.oJH.setText(localtl.name);
      if (localtl.zxp <= 0.0F) {
        paramViewGroup.oJI.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.oJJ.setText(localtl.ePu + localtl.ePv + localtl.hWY);
        paramViewGroup.oJL.setOnClickListener(CardShopUI.f(CardShopUI.this));
        paramViewGroup.oJL.setTag(localtl);
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup.oJI.setText(l.f(CardShopUI.this.getBaseContext(), localtl.zxp));
        paramViewGroup.oJI.setVisibility(0);
      }
    }
    
    final class a
    {
      public TextView oJH;
      public TextView oJI;
      public TextView oJJ;
      public ImageView oJK;
      public View oJL;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI
 * JD-Core Version:    0.7.0.1
 */