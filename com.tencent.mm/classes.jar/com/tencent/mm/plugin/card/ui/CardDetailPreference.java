package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.widget.CardTextPreference;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CardDetailPreference
  extends MMPreference
{
  private final String TAG;
  f lxI;
  private com.tencent.mm.plugin.card.base.b nqp;
  private List<com.tencent.mm.plugin.card.model.b> nqu;
  private TextView nyp;
  
  public CardDetailPreference()
  {
    AppMethodBeat.i(113190);
    this.TAG = "MicroMsg.CardDetailPreference";
    this.nqu = new ArrayList();
    AppMethodBeat.o(113190);
  }
  
  private void QN(String paramString)
  {
    AppMethodBeat.i(113196);
    PreferenceTitleCategory localPreferenceTitleCategory = new PreferenceTitleCategory(this);
    if (TextUtils.isEmpty(paramString)) {
      localPreferenceTitleCategory.setTitle(" ");
    }
    for (;;)
    {
      this.lxI.b(localPreferenceTitleCategory);
      AppMethodBeat.o(113196);
      return;
      localPreferenceTitleCategory.setTitle(paramString);
    }
  }
  
  private void bKd()
  {
    AppMethodBeat.i(113193);
    int i = 0;
    while (i < this.nqu.size())
    {
      com.tencent.mm.plugin.card.model.b localb = (com.tencent.mm.plugin.card.model.b)this.nqu.get(i);
      Preference localPreference = new Preference(this);
      localPreference.setLayoutResource(2131494804);
      localPreference.setKey(localb.title);
      localPreference.setTitle(localb.title);
      if (!TextUtils.isEmpty(localb.nrs)) {
        localPreference.setSummary(localb.nrs);
      }
      if (localb.nrD) {
        bKf();
      }
      this.lxI.b(localPreference);
      i += 1;
    }
    AppMethodBeat.o(113193);
  }
  
  private void bKe()
  {
    AppMethodBeat.i(113194);
    if ((this.nqp.bHV().CRG != null) && (this.nqp.bHV().CRG != null))
    {
      int i = 0;
      while (i < this.nqp.bHV().CRG.size())
      {
        xo localxo = (xo)this.nqp.bHV().CRG.get(i);
        if (!TextUtils.isEmpty(localxo.nrs))
        {
          CardTextPreference localCardTextPreference = new CardTextPreference(this);
          localCardTextPreference.setLayoutResource(2131494804);
          localCardTextPreference.setTitle(localxo.nrs);
          localCardTextPreference.bMQ();
          QN(localxo.title);
          this.lxI.b(localCardTextPreference);
        }
        i += 1;
      }
      bKf();
    }
    AppMethodBeat.o(113194);
  }
  
  private void bKf()
  {
    AppMethodBeat.i(113195);
    PreferenceSmallCategory localPreferenceSmallCategory = new PreferenceSmallCategory(this);
    this.lxI.b(localPreferenceSmallCategory);
    AppMethodBeat.o(113195);
  }
  
  public View getFooterView()
  {
    AppMethodBeat.i(113198);
    View localView = getLayoutInflater().inflate(2131495637, null);
    this.nyp = ((TextView)localView.findViewById(2131305128));
    this.nyp.setVisibility(8);
    AppMethodBeat.o(113198);
    return localView;
  }
  
  public int getResourceId()
  {
    return 2131951633;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113192);
    this.nqp = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    if ((this.nqp == null) || (this.nqp.bHV() == null) || (this.nqp.bHW() == null))
    {
      ad.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113192);
      return;
    }
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.nqp.bHV().nsJ)) {
      ((StringBuilder)localObject).append(this.nqp.bHV().nsJ);
    }
    ((StringBuilder)localObject).append(getString(2131756829));
    setMMTitle(((StringBuilder)localObject).toString());
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113189);
        CardDetailPreference.this.finish();
        AppMethodBeat.o(113189);
        return true;
      }
    });
    this.lxI = getPreferenceScreen();
    this.nqu.clear();
    if ((this.nqp.bHW().CPq != null) && (this.nqp.bHW().CPq.size() > 0)) {
      this.nqu.addAll(l.cC(this.nqp.bHW().CPq));
    }
    if ((this.nqp.bHW().CPr != null) && (this.nqp.bHW().CPr.size() > 0))
    {
      localObject = l.cC(this.nqp.bHW().CPr);
      ((com.tencent.mm.plugin.card.model.b)((List)localObject).get(0)).nrD = true;
      this.nqu.addAll((Collection)localObject);
    }
    bKf();
    bKe();
    bKd();
    if (!TextUtils.isEmpty(this.nqp.bHV().CRH))
    {
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(2131494804);
      ((CardTextPreference)localObject).setTitle(getString(2131756949));
      ((CardTextPreference)localObject).setKey("key_pic_detail");
      ((CardTextPreference)localObject).bMQ();
      bKf();
      this.lxI.b((Preference)localObject);
    }
    if (!TextUtils.isEmpty(this.nqp.bHV().CRE))
    {
      bKf();
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(2131494804);
      ((CardTextPreference)localObject).setKey("card_phone");
      ((CardTextPreference)localObject).setTitle(2131756925);
      ((CardTextPreference)localObject).setSummary(this.nqp.bHV().CRE);
      ((CardTextPreference)localObject).nJy = getResources().getColor(2131100547);
      ((CardTextPreference)localObject).bMP();
      this.lxI.b((Preference)localObject);
      QN("");
    }
    if ((this.nqp.bHV() != null) && (!TextUtils.isEmpty(this.nqp.bHV().source)) && (this.nyp != null))
    {
      this.nyp.setText(this.nqp.bHV().source);
      this.nyp.setVisibility(0);
    }
    AppMethodBeat.o(113192);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113191);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(113191);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(113197);
    if (paramPreference.mKey.equals("card_phone"))
    {
      paramf = this.nqp.bHV().CRE;
      Intent localIntent = new Intent("android.intent.action.DIAL");
      localIntent.setFlags(268435456);
      localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramf))));
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    if (paramPreference.mKey.equals("key_pic_detail")) {
      com.tencent.mm.plugin.card.d.b.a(this, this.nqp.bHV().CRH, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(113197);
      return false;
      int i = 0;
      while (i < this.nqu.size())
      {
        paramf = (com.tencent.mm.plugin.card.model.b)this.nqu.get(i);
        if ((paramf.title != null) && (paramf.title.equals(paramPreference.mKey)) && (!TextUtils.isEmpty(paramf.url)))
        {
          if (com.tencent.mm.plugin.card.d.b.O(this.nqp.bHZ(), paramf.CRq, paramf.CRr))
          {
            AppMethodBeat.o(113197);
            return false;
          }
          com.tencent.mm.plugin.card.d.b.a(this, paramf.url, 1);
        }
        i += 1;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailPreference
 * JD-Core Version:    0.7.0.1
 */