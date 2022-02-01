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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.m.a;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public class CardShopUI
  extends MMActivity
  implements m.a
{
  private ProgressDialog lBo;
  private ListView mListView;
  BroadcastReceiver mReceiver;
  private View.OnClickListener nmC;
  private String tmG;
  private com.tencent.mm.plugin.card.base.b tmU;
  private ArrayList<uu> tnb;
  private boolean ttL;
  private String tzO;
  private a tzP;
  private LinearLayout tzQ;
  private View tzR;
  private TextView tzS;
  
  public CardShopUI()
  {
    AppMethodBeat.i(113566);
    this.tnb = new ArrayList();
    this.tzO = "";
    this.ttL = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(113559);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        if ((paramAnonymousContext != null) && (paramAnonymousContext.equals("android.intent.action.LOCALE_CHANGED")) && (CardShopUI.cJP())) {
          CardShopUI.e(CardShopUI.this);
        }
        AppMethodBeat.o(113559);
      }
    };
    this.nmC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113560);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/card/ui/CardShopUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramAnonymousView.getId() == a.d.tgT)
        {
          paramAnonymousView = (uu)paramAnonymousView.getTag();
          if (paramAnonymousView != null)
          {
            com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousView.latitude, paramAnonymousView.longitude, paramAnonymousView.lLg);
            com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(5), CardShopUI.c(CardShopUI.this).cGw(), CardShopUI.c(CardShopUI.this).cGx(), "", paramAnonymousView.name });
          }
        }
        a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113560);
      }
    };
    AppMethodBeat.o(113566);
  }
  
  private void bJU()
  {
    AppMethodBeat.i(113573);
    if (am.cHv().a(this.tzO, this.tmG, this))
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(a.g.app_tip);
      this.lBo = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(a.g.tkh), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(113558);
          paramAnonymousDialogInterface = am.cHv();
          paramAnonymousDialogInterface.a(CardShopUI.d(CardShopUI.this), CardShopUI.this);
          if (paramAnonymousDialogInterface.tnU != null) {
            com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousDialogInterface.tnU);
          }
          AppMethodBeat.o(113558);
        }
      });
      AppMethodBeat.o(113573);
      return;
    }
    com.tencent.mm.ui.base.h.cO(this, getString(a.g.tkg));
    AppMethodBeat.o(113573);
  }
  
  private void cJN()
  {
    AppMethodBeat.i(113571);
    Log.i("MicroMsg.CardShopUI", "openLocation");
    registerReceiver();
    if (cJO())
    {
      bJU();
      AppMethodBeat.o(113571);
      return;
    }
    d.d(this);
    AppMethodBeat.o(113571);
  }
  
  private static boolean cJO()
  {
    AppMethodBeat.i(113572);
    if ((!l.blr()) && (!l.bls())) {}
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
  
  public final void a(boolean paramBoolean, ArrayList<uu> paramArrayList)
  {
    AppMethodBeat.i(113570);
    if (this.lBo != null)
    {
      this.lBo.dismiss();
      this.lBo = null;
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
    if (this.tnb != null)
    {
      this.tnb.clear();
      this.tnb.addAll(paramArrayList);
      this.tzR.setVisibility(0);
    }
    for (;;)
    {
      this.tzP.notifyDataSetChanged();
      AppMethodBeat.o(113570);
      return;
      this.tzR.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return a.e.tjh;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113568);
    if (!TextUtils.isEmpty(this.tmU.cGs().Sgr)) {
      setMMTitle(this.tmU.cGs().Sgr);
    }
    for (;;)
    {
      this.mListView = ((ListView)findViewById(a.d.tdv));
      this.tzQ = ((LinearLayout)View.inflate(getBaseContext(), a.e.tiQ, null));
      this.mListView.addHeaderView(this.tzQ);
      this.tzP = new a((byte)0);
      this.mListView.setAdapter(this.tzP);
      final Intent localIntent = getIntent();
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(113556);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          a.c("com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
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
          paramAnonymousAdapterView = (uu)CardShopUI.a(CardShopUI.this).get(i);
          if ((!TextUtils.isEmpty(paramAnonymousAdapterView.SfB)) && (!TextUtils.isEmpty(paramAnonymousAdapterView.SfC)))
          {
            paramAnonymousInt = localIntent.getIntExtra("key_from_appbrand_type", 0);
            com.tencent.mm.plugin.card.d.b.e(CardShopUI.b(CardShopUI.this), paramAnonymousAdapterView.SfB, paramAnonymousAdapterView.SfC, 1052, paramAnonymousInt);
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113556);
            return;
            if (!TextUtils.isEmpty(paramAnonymousAdapterView.jump_url))
            {
              com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousAdapterView.jump_url, 1);
              com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(4), CardShopUI.c(CardShopUI.this).cGw(), CardShopUI.c(CardShopUI.this).cGx(), "", paramAnonymousAdapterView.name });
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
      this.tzR = View.inflate(this, a.e.tiP, null);
      if (this.tzQ != null) {
        this.tzQ.addView(this.tzR);
      }
      this.tzS = ((TextView)this.tzR.findViewById(a.d.tcG));
      this.tzS.setText(a.g.tlM);
      this.tzR.setVisibility(8);
      AppMethodBeat.o(113568);
      return;
      setMMTitle(a.g.tjH);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113567);
    super.onCreate(paramBundle);
    this.tmU = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    String str = getIntent().getStringExtra("KEY_CARD_TP_ID");
    paramBundle = getIntent().getStringExtra("KEY_CARD_ID");
    if (this.tmU != null)
    {
      Log.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
      this.tzO = this.tmU.cGx();
      paramBundle = this.tmU.cGw();
    }
    for (;;)
    {
      this.tmG = paramBundle;
      do
      {
        if (TextUtils.isEmpty(this.tzO))
        {
          Log.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
          finish();
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69, null, null);
        Log.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        this.ttL = bool;
        if (this.ttL) {
          cJN();
        }
        initView();
        AppMethodBeat.o(113567);
        return;
      } while (TextUtils.isEmpty(str));
      this.tzO = str;
      if (TextUtils.isEmpty(paramBundle)) {
        paramBundle = "";
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113569);
    if (this.ttL) {
      unregisterReceiver(this.mReceiver);
    }
    am.cHv().a(this.tzO, this);
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
        Log.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.ttL);
        if (!this.ttL)
        {
          this.ttL = true;
          cJN();
        }
        AppMethodBeat.o(113575);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(a.g.permission_location_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.confirm_dialog_cancel), false, new CardShopUI.6(this), null);
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
    
    private uu HX(int paramInt)
    {
      AppMethodBeat.i(113563);
      uu localuu = (uu)CardShopUI.a(CardShopUI.this).get(paramInt);
      AppMethodBeat.o(113563);
      return localuu;
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
        paramView = View.inflate(CardShopUI.this.getContext(), a.e.tjg, null);
        paramViewGroup = new a();
        paramViewGroup.tzU = ((TextView)paramView.findViewById(a.d.tgQ));
        paramViewGroup.tzV = ((TextView)paramView.findViewById(a.d.tgP));
        paramViewGroup.tzW = ((TextView)paramView.findViewById(a.d.tgO));
        paramViewGroup.tzX = ((ImageView)paramView.findViewById(a.d.tgS));
        paramViewGroup.tzY = paramView.findViewById(a.d.tgT);
        paramView.setTag(paramViewGroup);
      }
      uu localuu;
      for (;;)
      {
        localuu = HX(paramInt);
        if (localuu != null) {
          break;
        }
        paramViewGroup.tzU.setText("");
        paramViewGroup.tzV.setText("");
        paramViewGroup.tzW.setText("");
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.tzU.setText(localuu.name);
      if (localuu.KjR <= 0.0F) {
        paramViewGroup.tzV.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.tzW.setText(localuu.province + localuu.city + localuu.lLg);
        paramViewGroup.tzY.setOnClickListener(CardShopUI.f(CardShopUI.this));
        paramViewGroup.tzY.setTag(localuu);
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup.tzV.setText(l.f(CardShopUI.this.getBaseContext(), localuu.KjR));
        paramViewGroup.tzV.setVisibility(0);
      }
    }
    
    final class a
    {
      public TextView tzU;
      public TextView tzV;
      public TextView tzW;
      public ImageView tzX;
      public View tzY;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI
 * JD-Core Version:    0.7.0.1
 */