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
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ac;
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
  f lZC;
  private com.tencent.mm.plugin.card.base.b nTp;
  private List<com.tencent.mm.plugin.card.model.b> nTu;
  private TextView obq;
  
  public CardDetailPreference()
  {
    AppMethodBeat.i(113190);
    this.TAG = "MicroMsg.CardDetailPreference";
    this.nTu = new ArrayList();
    AppMethodBeat.o(113190);
  }
  
  private void UZ(String paramString)
  {
    AppMethodBeat.i(113196);
    PreferenceTitleCategory localPreferenceTitleCategory = new PreferenceTitleCategory(this);
    if (TextUtils.isEmpty(paramString)) {
      localPreferenceTitleCategory.setTitle(" ");
    }
    for (;;)
    {
      this.lZC.b(localPreferenceTitleCategory);
      AppMethodBeat.o(113196);
      return;
      localPreferenceTitleCategory.setTitle(paramString);
    }
  }
  
  private void bRq()
  {
    AppMethodBeat.i(113193);
    int i = 0;
    while (i < this.nTu.size())
    {
      com.tencent.mm.plugin.card.model.b localb = (com.tencent.mm.plugin.card.model.b)this.nTu.get(i);
      Preference localPreference = new Preference(this);
      localPreference.setLayoutResource(2131494804);
      localPreference.setKey(localb.title);
      localPreference.setTitle(localb.title);
      if (!TextUtils.isEmpty(localb.nUs)) {
        localPreference.setSummary(localb.nUs);
      }
      if (localb.nUD) {
        bRs();
      }
      this.lZC.b(localPreference);
      i += 1;
    }
    AppMethodBeat.o(113193);
  }
  
  private void bRr()
  {
    AppMethodBeat.i(113194);
    if ((this.nTp.bPi().Ekr != null) && (this.nTp.bPi().Ekr != null))
    {
      int i = 0;
      while (i < this.nTp.bPi().Ekr.size())
      {
        yg localyg = (yg)this.nTp.bPi().Ekr.get(i);
        if (!TextUtils.isEmpty(localyg.nUs))
        {
          CardTextPreference localCardTextPreference = new CardTextPreference(this);
          localCardTextPreference.setLayoutResource(2131494804);
          localCardTextPreference.setTitle(localyg.nUs);
          localCardTextPreference.bUb();
          UZ(localyg.title);
          this.lZC.b(localCardTextPreference);
        }
        i += 1;
      }
      bRs();
    }
    AppMethodBeat.o(113194);
  }
  
  private void bRs()
  {
    AppMethodBeat.i(113195);
    PreferenceSmallCategory localPreferenceSmallCategory = new PreferenceSmallCategory(this);
    this.lZC.b(localPreferenceSmallCategory);
    AppMethodBeat.o(113195);
  }
  
  public View getFooterView()
  {
    AppMethodBeat.i(113198);
    View localView = getLayoutInflater().inflate(2131495637, null);
    this.obq = ((TextView)localView.findViewById(2131305128));
    this.obq.setVisibility(8);
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
    this.nTp = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    if ((this.nTp == null) || (this.nTp.bPi() == null) || (this.nTp.bPj() == null))
    {
      ac.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113192);
      return;
    }
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.nTp.bPi().nVJ)) {
      ((StringBuilder)localObject).append(this.nTp.bPi().nVJ);
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
    this.lZC = getPreferenceScreen();
    this.nTu.clear();
    if ((this.nTp.bPj().Eib != null) && (this.nTp.bPj().Eib.size() > 0)) {
      this.nTu.addAll(l.cE(this.nTp.bPj().Eib));
    }
    if ((this.nTp.bPj().Eic != null) && (this.nTp.bPj().Eic.size() > 0))
    {
      localObject = l.cE(this.nTp.bPj().Eic);
      ((com.tencent.mm.plugin.card.model.b)((List)localObject).get(0)).nUD = true;
      this.nTu.addAll((Collection)localObject);
    }
    bRs();
    bRr();
    bRq();
    if (!TextUtils.isEmpty(this.nTp.bPi().Eks))
    {
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(2131494804);
      ((CardTextPreference)localObject).setTitle(getString(2131756949));
      ((CardTextPreference)localObject).setKey("key_pic_detail");
      ((CardTextPreference)localObject).bUb();
      bRs();
      this.lZC.b((Preference)localObject);
    }
    if (!TextUtils.isEmpty(this.nTp.bPi().Ekp))
    {
      bRs();
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(2131494804);
      ((CardTextPreference)localObject).setKey("card_phone");
      ((CardTextPreference)localObject).setTitle(2131756925);
      ((CardTextPreference)localObject).setSummary(this.nTp.bPi().Ekp);
      ((CardTextPreference)localObject).omy = getResources().getColor(2131100547);
      ((CardTextPreference)localObject).bUa();
      this.lZC.b((Preference)localObject);
      UZ("");
    }
    if ((this.nTp.bPi() != null) && (!TextUtils.isEmpty(this.nTp.bPi().source)) && (this.obq != null))
    {
      this.obq.setText(this.nTp.bPi().source);
      this.obq.setVisibility(0);
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
      paramf = this.nTp.bPi().Ekp;
      Intent localIntent = new Intent("android.intent.action.DIAL");
      localIntent.setFlags(268435456);
      localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramf))));
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    if (paramPreference.mKey.equals("key_pic_detail")) {
      com.tencent.mm.plugin.card.d.b.a(this, this.nTp.bPi().Eks, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(113197);
      return false;
      int i = 0;
      while (i < this.nTu.size())
      {
        paramf = (com.tencent.mm.plugin.card.model.b)this.nTu.get(i);
        if ((paramf.title != null) && (paramf.title.equals(paramPreference.mKey)) && (!TextUtils.isEmpty(paramf.url)))
        {
          if (com.tencent.mm.plugin.card.d.b.O(this.nTp.bPm(), paramf.Ekb, paramf.Ekc))
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