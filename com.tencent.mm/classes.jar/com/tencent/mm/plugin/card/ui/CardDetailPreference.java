package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.widget.CardTextPreference;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.ab;
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
  f iLA;
  private com.tencent.mm.plugin.card.base.b klk;
  private List<com.tencent.mm.plugin.card.model.b> klo;
  private TextView ksZ;
  
  public CardDetailPreference()
  {
    AppMethodBeat.i(88257);
    this.TAG = "MicroMsg.CardDetailPreference";
    this.klo = new ArrayList();
    AppMethodBeat.o(88257);
  }
  
  private void Id(String paramString)
  {
    AppMethodBeat.i(88266);
    PreferenceTitleCategory localPreferenceTitleCategory = new PreferenceTitleCategory(this);
    if (TextUtils.isEmpty(paramString)) {
      localPreferenceTitleCategory.setTitle(" ");
    }
    for (;;)
    {
      this.iLA.b(localPreferenceTitleCategory);
      AppMethodBeat.o(88266);
      return;
      localPreferenceTitleCategory.setTitle(paramString);
    }
  }
  
  private void bdf()
  {
    AppMethodBeat.i(88263);
    int i = 0;
    while (i < this.klo.size())
    {
      com.tencent.mm.plugin.card.model.b localb = (com.tencent.mm.plugin.card.model.b)this.klo.get(i);
      Preference localPreference = new Preference(this);
      localPreference.setLayoutResource(2130970179);
      localPreference.setKey(localb.title);
      localPreference.setTitle(localb.title);
      if (!TextUtils.isEmpty(localb.kmn)) {
        localPreference.setSummary(localb.kmn);
      }
      if (localb.kmy) {
        bdh();
      }
      this.iLA.b(localPreference);
      i += 1;
    }
    AppMethodBeat.o(88263);
  }
  
  private void bdg()
  {
    AppMethodBeat.i(88264);
    if ((this.klk.bbd().wGa != null) && (this.klk.bbd().wGa != null))
    {
      int i = 0;
      while (i < this.klk.bbd().wGa.size())
      {
        uo localuo = (uo)this.klk.bbd().wGa.get(i);
        if (!TextUtils.isEmpty(localuo.kmn))
        {
          CardTextPreference localCardTextPreference = new CardTextPreference(this);
          localCardTextPreference.setLayoutResource(2130970179);
          localCardTextPreference.setTitle(localuo.kmn);
          localCardTextPreference.bfF();
          Id(localuo.title);
          this.iLA.b(localCardTextPreference);
        }
        i += 1;
      }
      bdh();
    }
    AppMethodBeat.o(88264);
  }
  
  private void bdh()
  {
    AppMethodBeat.i(88265);
    PreferenceSmallCategory localPreferenceSmallCategory = new PreferenceSmallCategory(this);
    this.iLA.b(localPreferenceSmallCategory);
    AppMethodBeat.o(88265);
  }
  
  public View getFooterView()
  {
    AppMethodBeat.i(88271);
    View localView = getLayoutInflater().inflate(2130970909, null);
    this.ksZ = ((TextView)localView.findViewById(2131827112));
    this.ksZ.setVisibility(8);
    AppMethodBeat.o(88271);
    return localView;
  }
  
  public int getResourceId()
  {
    return 2131165199;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88270);
    this.klk = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    if ((this.klk == null) || (this.klk.bbd() == null) || (this.klk.bbe() == null))
    {
      ab.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(88270);
      return;
    }
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.klk.bbd().knv)) {
      ((StringBuilder)localObject).append(this.klk.bbd().knv);
    }
    ((StringBuilder)localObject).append(getString(2131297897));
    setMMTitle(((StringBuilder)localObject).toString());
    setBackBtn(new CardDetailPreference.1(this));
    this.iLA = getPreferenceScreen();
    this.klo.clear();
    if ((this.klk.bbe().wDP != null) && (this.klk.bbe().wDP.size() > 0)) {
      this.klo.addAll(l.bg(this.klk.bbe().wDP));
    }
    if ((this.klk.bbe().wDQ != null) && (this.klk.bbe().wDQ.size() > 0))
    {
      localObject = l.bg(this.klk.bbe().wDQ);
      ((com.tencent.mm.plugin.card.model.b)((List)localObject).get(0)).kmy = true;
      this.klo.addAll((Collection)localObject);
    }
    bdh();
    bdg();
    bdf();
    if (!TextUtils.isEmpty(this.klk.bbd().wGb))
    {
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(2130970179);
      ((CardTextPreference)localObject).setTitle(getString(2131298007));
      ((CardTextPreference)localObject).setKey("key_pic_detail");
      ((CardTextPreference)localObject).bfF();
      bdh();
      this.iLA.b((Preference)localObject);
    }
    if (!TextUtils.isEmpty(this.klk.bbd().wFY))
    {
      bdh();
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(2130970179);
      ((CardTextPreference)localObject).setKey("card_phone");
      ((CardTextPreference)localObject).setTitle(2131297983);
      ((CardTextPreference)localObject).setSummary(this.klk.bbd().wFY);
      ((CardTextPreference)localObject).kCA = getResources().getColor(2131690214);
      ((CardTextPreference)localObject).bfE();
      this.iLA.b((Preference)localObject);
      Id("");
    }
    if ((this.klk.bbd() != null) && (!TextUtils.isEmpty(this.klk.bbd().source)) && (this.ksZ != null))
    {
      this.ksZ.setText(this.klk.bbd().source);
      this.ksZ.setVisibility(0);
    }
    AppMethodBeat.o(88270);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88258);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(88258);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(88269);
    if (paramPreference.mKey.equals("card_phone"))
    {
      paramf = this.klk.bbd().wFY;
      Intent localIntent = new Intent("android.intent.action.DIAL");
      localIntent.setFlags(268435456);
      localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramf))));
      startActivity(localIntent);
    }
    if (paramPreference.mKey.equals("key_pic_detail")) {
      com.tencent.mm.plugin.card.d.b.a(this, this.klk.bbd().wGb, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(88269);
      return false;
      int i = 0;
      while (i < this.klo.size())
      {
        paramf = (com.tencent.mm.plugin.card.model.b)this.klo.get(i);
        if ((paramf.title != null) && (paramf.title.equals(paramPreference.mKey)) && (!TextUtils.isEmpty(paramf.url)))
        {
          if (com.tencent.mm.plugin.card.d.b.d(this.klk.bbh(), paramf.wFL, paramf.wFM, 1028, 0))
          {
            AppMethodBeat.o(88269);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailPreference
 * JD-Core Version:    0.7.0.1
 */