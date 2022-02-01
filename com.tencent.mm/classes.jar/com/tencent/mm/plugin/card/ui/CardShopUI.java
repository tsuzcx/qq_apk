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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.m.a;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public class CardShopUI
  extends MMActivity
  implements m.a
{
  private ProgressDialog huQ;
  private View.OnClickListener jax;
  private ListView mListView;
  BroadcastReceiver mReceiver;
  private String nTb;
  private com.tencent.mm.plugin.card.base.b nTp;
  private ArrayList<rr> nTw;
  private boolean oaf;
  private String ogi;
  private a ogj;
  private LinearLayout ogk;
  private View ogl;
  private TextView ogm;
  
  public CardShopUI()
  {
    AppMethodBeat.i(113566);
    this.nTw = new ArrayList();
    this.ogi = "";
    this.oaf = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(113559);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        if ((paramAnonymousContext != null) && (paramAnonymousContext.equals("android.intent.action.LOCALE_CHANGED")) && (CardShopUI.bSD())) {
          CardShopUI.e(CardShopUI.this);
        }
        AppMethodBeat.o(113559);
      }
    };
    this.jax = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113560);
        if (paramAnonymousView.getId() == 2131304770)
        {
          paramAnonymousView = (rr)paramAnonymousView.getTag();
          if (paramAnonymousView != null)
          {
            com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousView.dmL, paramAnonymousView.doB, paramAnonymousView.hEt);
            com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(5), CardShopUI.c(CardShopUI.this).bPm(), CardShopUI.c(CardShopUI.this).bPn(), "", paramAnonymousView.name });
          }
        }
        AppMethodBeat.o(113560);
      }
    };
    AppMethodBeat.o(113566);
  }
  
  private void aZl()
  {
    AppMethodBeat.i(113573);
    if (am.bQl().a(this.ogi, this.nTb, this))
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.huQ = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131756844), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(113558);
          paramAnonymousDialogInterface = am.bQl();
          paramAnonymousDialogInterface.a(CardShopUI.d(CardShopUI.this), CardShopUI.this);
          if (paramAnonymousDialogInterface.nUo != null) {
            g.agQ().ghe.a(paramAnonymousDialogInterface.nUo);
          }
          AppMethodBeat.o(113558);
        }
      });
      AppMethodBeat.o(113573);
      return;
    }
    com.tencent.mm.ui.base.h.cg(this, getString(2131756843));
    AppMethodBeat.o(113573);
  }
  
  private void bSB()
  {
    AppMethodBeat.i(113571);
    ac.i("MicroMsg.CardShopUI", "openLocation");
    registerReceiver();
    if (bSC())
    {
      aZl();
      AppMethodBeat.o(113571);
      return;
    }
    d.b(this);
    AppMethodBeat.o(113571);
  }
  
  private static boolean bSC()
  {
    AppMethodBeat.i(113572);
    if ((!l.aEM()) && (!l.aEN())) {}
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
  
  public final void a(boolean paramBoolean, ArrayList<rr> paramArrayList)
  {
    AppMethodBeat.i(113570);
    if (this.huQ != null)
    {
      this.huQ.dismiss();
      this.huQ = null;
    }
    if (paramArrayList == null) {}
    for (int i = 0;; i = paramArrayList.size())
    {
      ac.d("MicroMsg.CardShopUI", "onGotCardShop, isOk = %b, shop list size = %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      if (paramBoolean) {
        break;
      }
      ac.e("MicroMsg.CardShopUI", "onGotCardShop fail");
      AppMethodBeat.o(113570);
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ac.e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
      AppMethodBeat.o(113570);
      return;
    }
    if (this.nTw != null)
    {
      this.nTw.clear();
      this.nTw.addAll(paramArrayList);
      this.ogl.setVisibility(0);
    }
    for (;;)
    {
      this.ogj.notifyDataSetChanged();
      AppMethodBeat.o(113570);
      return;
      this.ogl.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493347;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113568);
    if (!TextUtils.isEmpty(this.nTp.bPi().EkS)) {
      setMMTitle(this.nTp.bPi().EkS);
    }
    for (;;)
    {
      this.mListView = ((ListView)findViewById(2131297896));
      this.ogk = ((LinearLayout)View.inflate(getBaseContext(), 2131493317, null));
      this.mListView.addHeaderView(this.ogk);
      this.ogj = new a((byte)0);
      this.mListView.setAdapter(this.ogj);
      final Intent localIntent = getIntent();
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(113556);
          if (paramAnonymousInt == 0)
          {
            ac.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
            AppMethodBeat.o(113556);
            return;
          }
          int i = paramAnonymousInt;
          if (paramAnonymousInt > 0) {
            i = paramAnonymousInt - 1;
          }
          paramAnonymousAdapterView = (rr)CardShopUI.a(CardShopUI.this).get(i);
          if ((!TextUtils.isEmpty(paramAnonymousAdapterView.Ekb)) && (!TextUtils.isEmpty(paramAnonymousAdapterView.Ekc)))
          {
            paramAnonymousInt = localIntent.getIntExtra("key_from_appbrand_type", 0);
            com.tencent.mm.plugin.card.d.b.d(CardShopUI.b(CardShopUI.this), paramAnonymousAdapterView.Ekb, paramAnonymousAdapterView.Ekc, 1052, paramAnonymousInt);
            AppMethodBeat.o(113556);
            return;
          }
          if (!TextUtils.isEmpty(paramAnonymousAdapterView.nWj))
          {
            com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousAdapterView.nWj, 1);
            com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(4), CardShopUI.c(CardShopUI.this).bPm(), CardShopUI.c(CardShopUI.this).bPn(), "", paramAnonymousAdapterView.name });
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
      this.ogl = View.inflate(this, 2131493316, null);
      if (this.ogk != null) {
        this.ogk.addView(this.ogl);
      }
      this.ogm = ((TextView)this.ogl.findViewById(2131297844));
      this.ogm.setText(2131756997);
      this.ogl.setVisibility(8);
      AppMethodBeat.o(113568);
      return;
      setMMTitle(2131756800);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113567);
    super.onCreate(paramBundle);
    this.nTp = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    String str = getIntent().getStringExtra("KEY_CARD_TP_ID");
    paramBundle = getIntent().getStringExtra("KEY_CARD_ID");
    if (this.nTp != null)
    {
      ac.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
      this.ogi = this.nTp.bPn();
      paramBundle = this.nTp.bPm();
    }
    for (;;)
    {
      this.nTb = paramBundle;
      do
      {
        if (TextUtils.isEmpty(this.ogi))
        {
          ac.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
          finish();
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
        ac.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        this.oaf = bool;
        if (this.oaf) {
          bSB();
        }
        initView();
        AppMethodBeat.o(113567);
        return;
      } while (TextUtils.isEmpty(str));
      this.ogi = str;
      if (TextUtils.isEmpty(paramBundle)) {
        paramBundle = "";
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113569);
    if (this.oaf) {
      unregisterReceiver(this.mReceiver);
    }
    am.bQl().a(this.ogi, this);
    super.onDestroy();
    AppMethodBeat.o(113569);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(113575);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.CardShopUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(113575);
      return;
    }
    ac.i("MicroMsg.CardShopUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113575);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ac.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.oaf);
        if (!this.oaf)
        {
          this.oaf = true;
          bSB();
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
    
    private rr zV(int paramInt)
    {
      AppMethodBeat.i(113563);
      rr localrr = (rr)CardShopUI.a(CardShopUI.this).get(paramInt);
      AppMethodBeat.o(113563);
      return localrr;
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
        paramViewGroup.ogo = ((TextView)paramView.findViewById(2131304767));
        paramViewGroup.ogp = ((TextView)paramView.findViewById(2131304764));
        paramViewGroup.ogq = ((TextView)paramView.findViewById(2131304763));
        paramViewGroup.ogr = ((ImageView)paramView.findViewById(2131304769));
        paramViewGroup.ogs = paramView.findViewById(2131304770);
        paramView.setTag(paramViewGroup);
      }
      rr localrr;
      for (;;)
      {
        localrr = zV(paramInt);
        if (localrr != null) {
          break;
        }
        paramViewGroup.ogo.setText("");
        paramViewGroup.ogp.setText("");
        paramViewGroup.ogq.setText("");
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.ogo.setText(localrr.name);
      if (localrr.yhi <= 0.0F) {
        paramViewGroup.ogp.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.ogq.setText(localrr.exV + localrr.exW + localrr.hEt);
        paramViewGroup.ogs.setOnClickListener(CardShopUI.f(CardShopUI.this));
        paramViewGroup.ogs.setTag(localrr);
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup.ogp.setText(l.f(CardShopUI.this.getBaseContext(), localrr.yhi));
        paramViewGroup.ogp.setVisibility(0);
      }
    }
    
    final class a
    {
      public TextView ogo;
      public TextView ogp;
      public TextView ogq;
      public ImageView ogr;
      public View ogs;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI
 * JD-Core Version:    0.7.0.1
 */