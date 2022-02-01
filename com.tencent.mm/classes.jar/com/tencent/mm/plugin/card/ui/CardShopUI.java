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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.m.a;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public class CardShopUI
  extends MMActivity
  implements m.a
{
  private ProgressDialog gUr;
  private View.OnClickListener iAw;
  private ListView mListView;
  BroadcastReceiver mPQ;
  private String nDh;
  private a nDi;
  private LinearLayout nDj;
  private View nDk;
  private TextView nDl;
  private String nqb;
  private com.tencent.mm.plugin.card.base.b nqp;
  private ArrayList<rh> nqw;
  private boolean nxf;
  
  public CardShopUI()
  {
    AppMethodBeat.i(113566);
    this.nqw = new ArrayList();
    this.nDh = "";
    this.nxf = false;
    this.mPQ = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(113559);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        if ((paramAnonymousContext != null) && (paramAnonymousContext.equals("android.intent.action.LOCALE_CHANGED")) && (CardShopUI.bLq())) {
          CardShopUI.e(CardShopUI.this);
        }
        AppMethodBeat.o(113559);
      }
    };
    this.iAw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113560);
        if (paramAnonymousView.getId() == 2131304770)
        {
          paramAnonymousView = (rh)paramAnonymousView.getTag();
          if (paramAnonymousView != null)
          {
            com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousView.dpb, paramAnonymousView.dqQ, paramAnonymousView.hdQ);
            com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(5), CardShopUI.c(CardShopUI.this).bHZ(), CardShopUI.c(CardShopUI.this).bIa(), "", paramAnonymousView.name });
          }
        }
        AppMethodBeat.o(113560);
      }
    };
    AppMethodBeat.o(113566);
  }
  
  private void aSo()
  {
    AppMethodBeat.i(113573);
    if (am.bIY().a(this.nDh, this.nqb, this))
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.gUr = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131756844), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(113558);
          paramAnonymousDialogInterface = am.bIY();
          paramAnonymousDialogInterface.a(CardShopUI.d(CardShopUI.this), CardShopUI.this);
          if (paramAnonymousDialogInterface.nro != null) {
            g.afA().gcy.a(paramAnonymousDialogInterface.nro);
          }
          AppMethodBeat.o(113558);
        }
      });
      AppMethodBeat.o(113573);
      return;
    }
    com.tencent.mm.ui.base.h.cf(this, getString(2131756843));
    AppMethodBeat.o(113573);
  }
  
  private void bLo()
  {
    AppMethodBeat.i(113571);
    ad.i("MicroMsg.CardShopUI", "openLocation");
    registerReceiver();
    if (bLp())
    {
      aSo();
      AppMethodBeat.o(113571);
      return;
    }
    d.c(this);
    AppMethodBeat.o(113571);
  }
  
  private static boolean bLp()
  {
    AppMethodBeat.i(113572);
    if ((!l.axU()) && (!l.axV())) {}
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
    registerReceiver(this.mPQ, localIntentFilter);
    AppMethodBeat.o(113574);
  }
  
  public final void a(boolean paramBoolean, ArrayList<rh> paramArrayList)
  {
    AppMethodBeat.i(113570);
    if (this.gUr != null)
    {
      this.gUr.dismiss();
      this.gUr = null;
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
    if (this.nqw != null)
    {
      this.nqw.clear();
      this.nqw.addAll(paramArrayList);
      this.nDk.setVisibility(0);
    }
    for (;;)
    {
      this.nDi.notifyDataSetChanged();
      AppMethodBeat.o(113570);
      return;
      this.nDk.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493347;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113568);
    if (!TextUtils.isEmpty(this.nqp.bHV().CSh)) {
      setMMTitle(this.nqp.bHV().CSh);
    }
    for (;;)
    {
      this.mListView = ((ListView)findViewById(2131297896));
      this.nDj = ((LinearLayout)View.inflate(getBaseContext(), 2131493317, null));
      this.mListView.addHeaderView(this.nDj);
      this.nDi = new a((byte)0);
      this.mListView.setAdapter(this.nDi);
      final Intent localIntent = getIntent();
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(113556);
          if (paramAnonymousInt == 0)
          {
            ad.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
            AppMethodBeat.o(113556);
            return;
          }
          int i = paramAnonymousInt;
          if (paramAnonymousInt > 0) {
            i = paramAnonymousInt - 1;
          }
          paramAnonymousAdapterView = (rh)CardShopUI.a(CardShopUI.this).get(i);
          if ((!TextUtils.isEmpty(paramAnonymousAdapterView.CRq)) && (!TextUtils.isEmpty(paramAnonymousAdapterView.CRr)))
          {
            paramAnonymousInt = localIntent.getIntExtra("key_from_appbrand_type", 0);
            com.tencent.mm.plugin.card.d.b.d(CardShopUI.b(CardShopUI.this), paramAnonymousAdapterView.CRq, paramAnonymousAdapterView.CRr, 1052, paramAnonymousInt);
            AppMethodBeat.o(113556);
            return;
          }
          if (!TextUtils.isEmpty(paramAnonymousAdapterView.ntj))
          {
            com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousAdapterView.ntj, 1);
            com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(4), CardShopUI.c(CardShopUI.this).bHZ(), CardShopUI.c(CardShopUI.this).bIa(), "", paramAnonymousAdapterView.name });
          }
          AppMethodBeat.o(113556);
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
      this.nDk = View.inflate(this, 2131493316, null);
      if (this.nDj != null) {
        this.nDj.addView(this.nDk);
      }
      this.nDl = ((TextView)this.nDk.findViewById(2131297844));
      this.nDl.setText(2131756997);
      this.nDk.setVisibility(8);
      AppMethodBeat.o(113568);
      return;
      setMMTitle(2131756800);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113567);
    super.onCreate(paramBundle);
    this.nqp = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    String str = getIntent().getStringExtra("KEY_CARD_TP_ID");
    paramBundle = getIntent().getStringExtra("KEY_CARD_ID");
    if (this.nqp != null)
    {
      ad.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
      this.nDh = this.nqp.bIa();
      paramBundle = this.nqp.bHZ();
    }
    for (;;)
    {
      this.nqb = paramBundle;
      do
      {
        if (TextUtils.isEmpty(this.nDh))
        {
          ad.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
          finish();
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
        ad.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        this.nxf = bool;
        if (this.nxf) {
          bLo();
        }
        initView();
        AppMethodBeat.o(113567);
        return;
      } while (TextUtils.isEmpty(str));
      this.nDh = str;
      if (TextUtils.isEmpty(paramBundle)) {
        paramBundle = "";
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113569);
    if (this.nxf) {
      unregisterReceiver(this.mPQ);
    }
    am.bIY().a(this.nDh, this);
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
        ad.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.nxf);
        if (!this.nxf)
        {
          this.nxf = true;
          bLo();
        }
        AppMethodBeat.o(113575);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131757558), false, new CardShopUI.6(this), null);
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
    
    private rh zf(int paramInt)
    {
      AppMethodBeat.i(113563);
      rh localrh = (rh)CardShopUI.a(CardShopUI.this).get(paramInt);
      AppMethodBeat.o(113563);
      return localrh;
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
        paramViewGroup.nDn = ((TextView)paramView.findViewById(2131304767));
        paramViewGroup.nDo = ((TextView)paramView.findViewById(2131304764));
        paramViewGroup.nDp = ((TextView)paramView.findViewById(2131304763));
        paramViewGroup.nDq = ((ImageView)paramView.findViewById(2131304769));
        paramViewGroup.nDr = paramView.findViewById(2131304770);
        paramView.setTag(paramViewGroup);
      }
      rh localrh;
      for (;;)
      {
        localrh = zf(paramInt);
        if (localrh != null) {
          break;
        }
        paramViewGroup.nDn.setText("");
        paramViewGroup.nDo.setText("");
        paramViewGroup.nDp.setText("");
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.nDn.setText(localrh.name);
      if (localrh.wUu <= 0.0F) {
        paramViewGroup.nDo.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.nDp.setText(localrh.evz + localrh.evA + localrh.hdQ);
        paramViewGroup.nDr.setOnClickListener(CardShopUI.f(CardShopUI.this));
        paramViewGroup.nDr.setTag(localrh);
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup.nDo.setText(l.f(CardShopUI.this.getBaseContext(), localrh.wUu));
        paramViewGroup.nDo.setVisibility(0);
      }
    }
    
    final class a
    {
      public TextView nDn;
      public TextView nDo;
      public TextView nDp;
      public ImageView nDq;
      public View nDr;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI
 * JD-Core Version:    0.7.0.1
 */