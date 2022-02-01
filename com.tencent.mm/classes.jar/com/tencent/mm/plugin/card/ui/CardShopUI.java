package com.tencent.mm.plugin.card.ui;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.mgr.l.a;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.HashSet;

public class CardShopUI
  extends MMActivity
  implements l.a
{
  private ListView mListView;
  BroadcastReceiver mReceiver;
  private ProgressDialog osY;
  private View.OnClickListener qjL;
  private String wEj;
  private a wEk;
  private LinearLayout wEl;
  private View wEm;
  private TextView wEn;
  private ArrayList<wl> wrB;
  private String wrg;
  private com.tencent.mm.plugin.card.base.b wru;
  private boolean wyi;
  
  public CardShopUI()
  {
    AppMethodBeat.i(113566);
    this.wrB = new ArrayList();
    this.wEj = "";
    this.wyi = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(113559);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        if ((paramAnonymousContext != null) && (paramAnonymousContext.equals("android.intent.action.LOCALE_CHANGED")) && (CardShopUI.dnf())) {
          CardShopUI.e(CardShopUI.this);
        }
        AppMethodBeat.o(113559);
      }
    };
    this.qjL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113560);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/card/ui/CardShopUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.getId() == a.d.wlt)
        {
          paramAnonymousView = (wl)paramAnonymousView.getTag();
          if (paramAnonymousView != null)
          {
            com.tencent.mm.plugin.card.c.b.a(CardShopUI.this, paramAnonymousView.latitude, paramAnonymousView.longitude, paramAnonymousView.oDI);
            com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(5), CardShopUI.c(CardShopUI.this).djO(), CardShopUI.c(CardShopUI.this).djP(), "", paramAnonymousView.name });
          }
        }
        a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113560);
      }
    };
    AppMethodBeat.o(113566);
  }
  
  private void cjw()
  {
    AppMethodBeat.i(113573);
    if (am.dkM().a(this.wEj, this.wrg, this))
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(a.g.app_tip);
      this.osY = k.a(localAppCompatActivity, getString(a.g.woF), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(113558);
          paramAnonymousDialogInterface = am.dkM();
          paramAnonymousDialogInterface.a(CardShopUI.d(CardShopUI.this), CardShopUI.this);
          if (paramAnonymousDialogInterface.wsv != null) {
            com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousDialogInterface.wsv);
          }
          AppMethodBeat.o(113558);
        }
      });
      AppMethodBeat.o(113573);
      return;
    }
    k.cZ(this, getString(a.g.woE));
    AppMethodBeat.o(113573);
  }
  
  private void dnd()
  {
    AppMethodBeat.i(113571);
    Log.i("MicroMsg.CardShopUI", "openLocation");
    registerReceiver();
    if (dne())
    {
      cjw();
      AppMethodBeat.o(113571);
      return;
    }
    com.tencent.mm.plugin.card.c.d.e(this);
    AppMethodBeat.o(113571);
  }
  
  private static boolean dne()
  {
    AppMethodBeat.i(113572);
    if ((!com.tencent.mm.modelgeo.d.bJm()) && (!com.tencent.mm.modelgeo.d.bJn())) {}
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
  
  public final void a(boolean paramBoolean, ArrayList<wl> paramArrayList)
  {
    AppMethodBeat.i(113570);
    if (this.osY != null)
    {
      this.osY.dismiss();
      this.osY = null;
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
    if (this.wrB != null)
    {
      this.wrB.clear();
      this.wrB.addAll(paramArrayList);
      this.wEm.setVisibility(0);
    }
    for (;;)
    {
      this.wEk.notifyDataSetChanged();
      AppMethodBeat.o(113570);
      return;
      this.wEm.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return a.e.wnE;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113568);
    if (!TextUtils.isEmpty(this.wru.djK().Zem)) {
      setMMTitle(this.wru.djK().Zem);
    }
    for (;;)
    {
      this.mListView = ((ListView)findViewById(a.d.whJ));
      this.wEl = ((LinearLayout)View.inflate(getBaseContext(), a.e.wnn, null));
      this.mListView.addHeaderView(this.wEl);
      this.wEk = new a((byte)0);
      this.mListView.setAdapter(this.wEk);
      final Intent localIntent = getIntent();
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(113556);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          a.c("com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
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
          paramAnonymousAdapterView = (wl)CardShopUI.a(CardShopUI.this).get(i);
          if ((!TextUtils.isEmpty(paramAnonymousAdapterView.Zdw)) && (!TextUtils.isEmpty(paramAnonymousAdapterView.Zdx)))
          {
            paramAnonymousInt = localIntent.getIntExtra("key_from_appbrand_type", 0);
            com.tencent.mm.plugin.card.c.b.f(CardShopUI.b(CardShopUI.this), paramAnonymousAdapterView.Zdw, paramAnonymousAdapterView.Zdx, 1052, paramAnonymousInt);
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113556);
            return;
            if (!TextUtils.isEmpty(paramAnonymousAdapterView.jump_url))
            {
              com.tencent.mm.plugin.card.c.b.a(CardShopUI.this, paramAnonymousAdapterView.jump_url, 1);
              com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(4), CardShopUI.c(CardShopUI.this).djO(), CardShopUI.c(CardShopUI.this).djP(), "", paramAnonymousAdapterView.name });
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
      this.wEm = View.inflate(this, a.e.wnm, null);
      if (this.wEl != null) {
        this.wEl.addView(this.wEm);
      }
      this.wEn = ((TextView)this.wEm.findViewById(a.d.wgU));
      this.wEn.setText(a.g.wql);
      this.wEm.setVisibility(8);
      AppMethodBeat.o(113568);
      return;
      setMMTitle(a.g.woe);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113567);
    super.onCreate(paramBundle);
    this.wru = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    String str = getIntent().getStringExtra("KEY_CARD_TP_ID");
    paramBundle = getIntent().getStringExtra("KEY_CARD_ID");
    if (this.wru != null)
    {
      Log.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
      this.wEj = this.wru.djP();
      paramBundle = this.wru.djO();
    }
    for (;;)
    {
      this.wrg = paramBundle;
      do
      {
        if (TextUtils.isEmpty(this.wEj))
        {
          Log.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
          finish();
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69, null);
        Log.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        this.wyi = bool;
        if (this.wyi) {
          dnd();
        }
        initView();
        AppMethodBeat.o(113567);
        return;
      } while (TextUtils.isEmpty(str));
      this.wEj = str;
      if (TextUtils.isEmpty(paramBundle)) {
        paramBundle = "";
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113569);
    if (this.wyi) {
      unregisterReceiver(this.mReceiver);
    }
    am.dkM().a(this.wEj, this);
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
        Log.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.wyi);
        if (!this.wyi)
        {
          this.wyi = true;
          dnd();
        }
        AppMethodBeat.o(113575);
        return;
      }
      k.a(this, getString(a.g.permission_location_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.confirm_dialog_cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(113561);
          com.tencent.mm.pluginsdk.permission.b.lx(CardShopUI.this.getContext());
          AppMethodBeat.o(113561);
        }
      }, null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(294357);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(CardShopUI.b.class);
    AppMethodBeat.o(294357);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private wl Iy(int paramInt)
    {
      AppMethodBeat.i(113563);
      wl localwl = (wl)CardShopUI.a(CardShopUI.this).get(paramInt);
      AppMethodBeat.o(113563);
      return localwl;
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
        paramView = View.inflate(CardShopUI.this.getContext(), a.e.wnD, null);
        paramViewGroup = new a();
        paramViewGroup.wEp = ((TextView)paramView.findViewById(a.d.wlq));
        paramViewGroup.wEq = ((TextView)paramView.findViewById(a.d.wlo));
        paramViewGroup.wEr = ((TextView)paramView.findViewById(a.d.wln));
        paramViewGroup.wEs = ((ImageView)paramView.findViewById(a.d.wls));
        paramViewGroup.wEt = paramView.findViewById(a.d.wlt);
        paramView.setTag(paramViewGroup);
      }
      wl localwl;
      for (;;)
      {
        localwl = Iy(paramInt);
        if (localwl != null) {
          break;
        }
        paramViewGroup.wEp.setText("");
        paramViewGroup.wEq.setText("");
        paramViewGroup.wEr.setText("");
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.wEp.setText(localwl.name);
      if (localwl.TG <= 0.0F) {
        paramViewGroup.wEq.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.wEr.setText(localwl.province + localwl.city + localwl.oDI);
        paramViewGroup.wEt.setOnClickListener(CardShopUI.f(CardShopUI.this));
        paramViewGroup.wEt.setTag(localwl);
        AppMethodBeat.o(113564);
        return paramView;
        paramViewGroup.wEq.setText(com.tencent.mm.plugin.card.c.l.f(CardShopUI.this.getBaseContext(), localwl.TG));
        paramViewGroup.wEq.setVisibility(0);
      }
    }
    
    final class a
    {
      public TextView wEp;
      public TextView wEq;
      public TextView wEr;
      public ImageView wEs;
      public View wEt;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI
 * JD-Core Version:    0.7.0.1
 */