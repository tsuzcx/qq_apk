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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.m.a;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class CardShopUI
  extends MMActivity
  implements m.a
{
  private ProgressDialog hQb;
  private View.OnClickListener jwB;
  private ListView mListView;
  BroadcastReceiver mReceiver;
  private String oCY;
  private com.tencent.mm.plugin.card.base.b oDm;
  private ArrayList<tn> oDt;
  private boolean oKb;
  private String oQd;
  private a oQe;
  private LinearLayout oQf;
  private View oQg;
  private TextView oQh;
  
  public CardShopUI()
  {
    AppMethodBeat.i(113566);
    this.oDt = new ArrayList();
    this.oQd = "";
    this.oKb = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(113559);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        if ((paramAnonymousContext != null) && (paramAnonymousContext.equals("android.intent.action.LOCALE_CHANGED")) && (CardShopUI.bYx())) {
          CardShopUI.e(CardShopUI.this);
        }
        AppMethodBeat.o(113559);
      }
    };
    this.jwB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113560);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/card/ui/CardShopUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramAnonymousView.getId() == 2131304770)
        {
          paramAnonymousView = (tn)paramAnonymousView.getTag();
          if (paramAnonymousView != null)
          {
            com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousView.dzE, paramAnonymousView.dBu, paramAnonymousView.hZQ);
            com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(5), CardShopUI.c(CardShopUI.this).bVg(), CardShopUI.c(CardShopUI.this).bVh(), "", paramAnonymousView.name });
          }
        }
        a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113560);
      }
    };
    AppMethodBeat.o(113566);
  }
  
  private void bYv()
  {
    AppMethodBeat.i(113571);
    ae.i("MicroMsg.CardShopUI", "openLocation");
    registerReceiver();
    if (bYw())
    {
      bdo();
      AppMethodBeat.o(113571);
      return;
    }
    d.c(this);
    AppMethodBeat.o(113571);
  }
  
  private static boolean bYw()
  {
    AppMethodBeat.i(113572);
    if ((!l.aIi()) && (!l.aIj())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(113572);
      return true;
    }
    AppMethodBeat.o(113572);
    return false;
  }
  
  private void bdo()
  {
    AppMethodBeat.i(113573);
    if (am.bWf().a(this.oQd, this.oCY, this))
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.hQb = h.b(localAppCompatActivity, getString(2131756844), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(113558);
          paramAnonymousDialogInterface = am.bWf();
          paramAnonymousDialogInterface.a(CardShopUI.d(CardShopUI.this), CardShopUI.this);
          if (paramAnonymousDialogInterface.oEl != null) {
            com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousDialogInterface.oEl);
          }
          AppMethodBeat.o(113558);
        }
      });
      AppMethodBeat.o(113573);
      return;
    }
    h.cm(this, getString(2131756843));
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
  
  public final void a(boolean paramBoolean, ArrayList<tn> paramArrayList)
  {
    AppMethodBeat.i(113570);
    if (this.hQb != null)
    {
      this.hQb.dismiss();
      this.hQb = null;
    }
    if (paramArrayList == null) {}
    for (int i = 0;; i = paramArrayList.size())
    {
      ae.d("MicroMsg.CardShopUI", "onGotCardShop, isOk = %b, shop list size = %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      if (paramBoolean) {
        break;
      }
      ae.e("MicroMsg.CardShopUI", "onGotCardShop fail");
      AppMethodBeat.o(113570);
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ae.e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
      AppMethodBeat.o(113570);
      return;
    }
    if (this.oDt != null)
    {
      this.oDt.clear();
      this.oDt.addAll(paramArrayList);
      this.oQg.setVisibility(0);
    }
    for (;;)
    {
      this.oQe.notifyDataSetChanged();
      AppMethodBeat.o(113570);
      return;
      this.oQg.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493347;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113568);
    if (!TextUtils.isEmpty(this.oDm.bVc().GkA)) {
      setMMTitle(this.oDm.bVc().GkA);
    }
    for (;;)
    {
      this.mListView = ((ListView)findViewById(2131297896));
      this.oQf = ((LinearLayout)View.inflate(getBaseContext(), 2131493317, null));
      this.mListView.addHeaderView(this.oQf);
      this.oQe = new a((byte)0);
      this.mListView.setAdapter(this.oQe);
      final Intent localIntent = getIntent();
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(113556);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          a.b("com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          if (paramAnonymousInt == 0)
          {
            ae.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
            a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113556);
            return;
          }
          int i = paramAnonymousInt;
          if (paramAnonymousInt > 0) {
            i = paramAnonymousInt - 1;
          }
          paramAnonymousAdapterView = (tn)CardShopUI.a(CardShopUI.this).get(i);
          if ((!TextUtils.isEmpty(paramAnonymousAdapterView.GjJ)) && (!TextUtils.isEmpty(paramAnonymousAdapterView.GjK)))
          {
            paramAnonymousInt = localIntent.getIntExtra("key_from_appbrand_type", 0);
            com.tencent.mm.plugin.card.d.b.d(CardShopUI.b(CardShopUI.this), paramAnonymousAdapterView.GjJ, paramAnonymousAdapterView.GjK, 1052, paramAnonymousInt);
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113556);
            return;
            if (!TextUtils.isEmpty(paramAnonymousAdapterView.oGf))
            {
              com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousAdapterView.oGf, 1);
              com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(4), CardShopUI.c(CardShopUI.this).bVg(), CardShopUI.c(CardShopUI.this).bVh(), "", paramAnonymousAdapterView.name });
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
      this.oQg = View.inflate(this, 2131493316, null);
      if (this.oQf != null) {
        this.oQf.addView(this.oQg);
      }
      this.oQh = ((TextView)this.oQg.findViewById(2131297844));
      this.oQh.setText(2131756997);
      this.oQg.setVisibility(8);
      AppMethodBeat.o(113568);
      return;
      setMMTitle(2131756800);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113567);
    super.onCreate(paramBundle);
    this.oDm = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    String str = getIntent().getStringExtra("KEY_CARD_TP_ID");
    paramBundle = getIntent().getStringExtra("KEY_CARD_ID");
    if (this.oDm != null)
    {
      ae.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
      this.oQd = this.oDm.bVh();
      paramBundle = this.oDm.bVg();
    }
    for (;;)
    {
      this.oCY = paramBundle;
      do
      {
        if (TextUtils.isEmpty(this.oQd))
        {
          ae.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
          finish();
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
        ae.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        this.oKb = bool;
        if (this.oKb) {
          bYv();
        }
        initView();
        AppMethodBeat.o(113567);
        return;
      } while (TextUtils.isEmpty(str));
      this.oQd = str;
      if (TextUtils.isEmpty(paramBundle)) {
        paramBundle = "";
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113569);
    if (this.oKb) {
      unregisterReceiver(this.mReceiver);
    }
    am.bWf().a(this.oQd, this);
    super.onDestroy();
    AppMethodBeat.o(113569);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(113575);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.CardShopUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(113575);
      return;
    }
    ae.i("MicroMsg.CardShopUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113575);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ae.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.oKb);
        if (!this.oKb)
        {
          this.oKb = true;
          bYv();
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
    
    private tn AQ(int paramInt)
    {
      AppMethodBeat.i(113563);
      tn localtn = (tn)CardShopUI.a(CardShopUI.this).get(paramInt);
      AppMethodBeat.o(113563);
      return localtn;
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
        paramViewGroup.oQj = ((TextView)paramView.findViewById(2131304767));
        paramViewGroup.oQk = ((TextView)paramView.findViewById(2131304764));
        paramViewGroup.oQl = ((TextView)paramView.findViewById(2131304763));
        paramViewGroup.oQm = ((ImageView)paramView.findViewById(2131304769));
        paramViewGroup.oQn = paramView.findViewById(2131304770);
        paramView.setTag(paramViewGroup);
      }
      tn localtn;
      for (;;)
      {
        localtn = AQ(paramInt);
        if (localtn != null) {
          break;
        }
        paramViewGroup.oQj.setText("");
        paramViewGroup.oQk.setText("");
        paramViewGroup.oQl.setText("");
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.oQj.setText(localtn.name);
      if (localtn.zOO <= 0.0F) {
        paramViewGroup.oQk.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.oQl.setText(localtn.eRf + localtn.eRg + localtn.hZQ);
        paramViewGroup.oQn.setOnClickListener(CardShopUI.f(CardShopUI.this));
        paramViewGroup.oQn.setTag(localtn);
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup.oQk.setText(l.f(CardShopUI.this.getBaseContext(), localtn.zOO));
        paramViewGroup.oQk.setVisibility(0);
      }
    }
    
    final class a
    {
      public TextView oQj;
      public TextView oQk;
      public TextView oQl;
      public ImageView oQm;
      public View oQn;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI
 * JD-Core Version:    0.7.0.1
 */