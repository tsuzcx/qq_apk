package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.m.a;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public class CardShopUI
  extends MMActivity
  implements m.a
{
  private ProgressDialog fsw;
  private View.OnClickListener gMO;
  BroadcastReceiver jQN;
  private String kkW;
  private com.tencent.mm.plugin.card.base.b klk;
  private ArrayList<oz> klq;
  private boolean krM;
  private String kxO;
  private CardShopUI.a kxP;
  private LinearLayout kxQ;
  private View kxR;
  private TextView kxS;
  private ListView mListView;
  
  public CardShopUI()
  {
    AppMethodBeat.i(88639);
    this.klq = new ArrayList();
    this.kxO = "";
    this.krM = false;
    this.jQN = new CardShopUI.4(this);
    this.gMO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(88633);
        if (paramAnonymousView.getId() == 2131822375)
        {
          paramAnonymousView = (oz)paramAnonymousView.getTag();
          if (paramAnonymousView != null)
          {
            com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousView.cyV, paramAnonymousView.cAH, paramAnonymousView.fBq);
            com.tencent.mm.plugin.report.service.h.qsU.e(11941, new Object[] { Integer.valueOf(5), CardShopUI.c(CardShopUI.this).bbh(), CardShopUI.c(CardShopUI.this).bbi(), "", paramAnonymousView.name });
          }
        }
        AppMethodBeat.o(88633);
      }
    };
    AppMethodBeat.o(88639);
  }
  
  private void axL()
  {
    AppMethodBeat.i(88646);
    if (am.bcg().a(this.kxO, this.kkW, this))
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131297087);
      this.fsw = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131297912), true, new CardShopUI.3(this));
      AppMethodBeat.o(88646);
      return;
    }
    com.tencent.mm.ui.base.h.bO(this, getString(2131297911));
    AppMethodBeat.o(88646);
  }
  
  private void bes()
  {
    AppMethodBeat.i(88644);
    ab.i("MicroMsg.CardShopUI", "openLocation");
    registerReceiver();
    if (bet())
    {
      axL();
      AppMethodBeat.o(88644);
      return;
    }
    d.c(this);
    AppMethodBeat.o(88644);
  }
  
  private static boolean bet()
  {
    AppMethodBeat.i(88645);
    if ((!l.agR()) && (!l.agS())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(88645);
      return true;
    }
    AppMethodBeat.o(88645);
    return false;
  }
  
  private void registerReceiver()
  {
    AppMethodBeat.i(88647);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.LOCALE_CHANGED");
    registerReceiver(this.jQN, localIntentFilter);
    AppMethodBeat.o(88647);
  }
  
  public final void a(boolean paramBoolean, ArrayList<oz> paramArrayList)
  {
    AppMethodBeat.i(88643);
    if (this.fsw != null)
    {
      this.fsw.dismiss();
      this.fsw = null;
    }
    if (paramArrayList == null) {}
    for (int i = 0;; i = paramArrayList.size())
    {
      ab.d("MicroMsg.CardShopUI", "onGotCardShop, isOk = %b, shop list size = %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      if (paramBoolean) {
        break;
      }
      ab.e("MicroMsg.CardShopUI", "onGotCardShop fail");
      AppMethodBeat.o(88643);
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ab.e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
      AppMethodBeat.o(88643);
      return;
    }
    if (this.klq != null)
    {
      this.klq.clear();
      this.klq.addAll(paramArrayList);
      this.kxR.setVisibility(0);
    }
    for (;;)
    {
      this.kxP.notifyDataSetChanged();
      AppMethodBeat.o(88643);
      return;
      this.kxR.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2130968996;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88641);
    if (!TextUtils.isEmpty(this.klk.bbd().wGC)) {
      setMMTitle(this.klk.bbd().wGC);
    }
    for (;;)
    {
      this.mListView = ((ListView)findViewById(2131822377));
      this.kxQ = ((LinearLayout)View.inflate(getBaseContext(), 2130968966, null));
      this.mListView.addHeaderView(this.kxQ);
      this.kxP = new CardShopUI.a(this, (byte)0);
      this.mListView.setAdapter(this.kxP);
      Intent localIntent = getIntent();
      this.mListView.setOnItemClickListener(new CardShopUI.1(this, localIntent));
      setBackBtn(new CardShopUI.2(this));
      this.kxR = View.inflate(this, 2130968965, null);
      if (this.kxQ != null) {
        this.kxQ.addView(this.kxR);
      }
      this.kxS = ((TextView)this.kxR.findViewById(2131822272));
      this.kxS.setText(2131298055);
      this.kxR.setVisibility(8);
      AppMethodBeat.o(88641);
      return;
      setMMTitle(2131297868);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88640);
    super.onCreate(paramBundle);
    this.klk = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    String str = getIntent().getStringExtra("KEY_CARD_TP_ID");
    paramBundle = getIntent().getStringExtra("KEY_CARD_ID");
    if (this.klk != null)
    {
      ab.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
      this.kxO = this.klk.bbi();
      paramBundle = this.klk.bbh();
    }
    for (;;)
    {
      this.kkW = paramBundle;
      do
      {
        if (TextUtils.isEmpty(this.kxO))
        {
          ab.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
          finish();
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
        ab.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        this.krM = bool;
        if (this.krM) {
          bes();
        }
        initView();
        AppMethodBeat.o(88640);
        return;
      } while (TextUtils.isEmpty(str));
      this.kxO = str;
      if (TextUtils.isEmpty(paramBundle)) {
        paramBundle = "";
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88642);
    if (this.krM) {
      unregisterReceiver(this.jQN);
    }
    am.bcg().a(this.kxO, this);
    super.onDestroy();
    AppMethodBeat.o(88642);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(88648);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.CardShopUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(88648);
      return;
    }
    ab.i("MicroMsg.CardShopUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88648);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ab.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.krM);
        if (!this.krM)
        {
          this.krM = true;
          bes();
        }
        AppMethodBeat.o(88648);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131298499), false, new CardShopUI.6(this), null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI
 * JD-Core Version:    0.7.0.1
 */