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
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
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
  f mzx;
  private TextView oEJ;
  private com.tencent.mm.plugin.card.base.b owK;
  private List<com.tencent.mm.plugin.card.model.b> owP;
  
  public CardDetailPreference()
  {
    AppMethodBeat.i(113190);
    this.TAG = "MicroMsg.CardDetailPreference";
    this.owP = new ArrayList();
    AppMethodBeat.o(113190);
  }
  
  private void YI(String paramString)
  {
    AppMethodBeat.i(113196);
    PreferenceTitleCategory localPreferenceTitleCategory = new PreferenceTitleCategory(this);
    if (TextUtils.isEmpty(paramString)) {
      localPreferenceTitleCategory.setTitle(" ");
    }
    for (;;)
    {
      this.mzx.b(localPreferenceTitleCategory);
      AppMethodBeat.o(113196);
      return;
      localPreferenceTitleCategory.setTitle(paramString);
    }
  }
  
  private void bVV()
  {
    AppMethodBeat.i(113193);
    int i = 0;
    while (i < this.owP.size())
    {
      com.tencent.mm.plugin.card.model.b localb = (com.tencent.mm.plugin.card.model.b)this.owP.get(i);
      Preference localPreference = new Preference(this);
      localPreference.setLayoutResource(2131494804);
      localPreference.setKey(localb.title);
      localPreference.setTitle(localb.title);
      if (!TextUtils.isEmpty(localb.oxN)) {
        localPreference.setSummary(localb.oxN);
      }
      if (localb.oxY) {
        bVX();
      }
      this.mzx.b(localPreference);
      i += 1;
    }
    AppMethodBeat.o(113193);
  }
  
  private void bVW()
  {
    AppMethodBeat.i(113194);
    if ((this.owK.bTN().FRA != null) && (this.owK.bTN().FRA != null))
    {
      int i = 0;
      while (i < this.owK.bTN().FRA.size())
      {
        aaf localaaf = (aaf)this.owK.bTN().FRA.get(i);
        if (!TextUtils.isEmpty(localaaf.oxN))
        {
          CardTextPreference localCardTextPreference = new CardTextPreference(this);
          localCardTextPreference.setLayoutResource(2131494804);
          localCardTextPreference.setTitle(localaaf.oxN);
          localCardTextPreference.bYG();
          YI(localaaf.title);
          this.mzx.b(localCardTextPreference);
        }
        i += 1;
      }
      bVX();
    }
    AppMethodBeat.o(113194);
  }
  
  private void bVX()
  {
    AppMethodBeat.i(113195);
    PreferenceSmallCategory localPreferenceSmallCategory = new PreferenceSmallCategory(this);
    this.mzx.b(localPreferenceSmallCategory);
    AppMethodBeat.o(113195);
  }
  
  public View getFooterView()
  {
    AppMethodBeat.i(113198);
    View localView = getLayoutInflater().inflate(2131495637, null);
    this.oEJ = ((TextView)localView.findViewById(2131305128));
    this.oEJ.setVisibility(8);
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
    this.owK = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    if ((this.owK == null) || (this.owK.bTN() == null) || (this.owK.bTO() == null))
    {
      ad.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113192);
      return;
    }
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.owK.bTN().ozd)) {
      ((StringBuilder)localObject).append(this.owK.bTN().ozd);
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
    this.mzx = getPreferenceScreen();
    this.owP.clear();
    if ((this.owK.bTO().FPl != null) && (this.owK.bTO().FPl.size() > 0)) {
      this.owP.addAll(l.cF(this.owK.bTO().FPl));
    }
    if ((this.owK.bTO().FPm != null) && (this.owK.bTO().FPm.size() > 0))
    {
      localObject = l.cF(this.owK.bTO().FPm);
      ((com.tencent.mm.plugin.card.model.b)((List)localObject).get(0)).oxY = true;
      this.owP.addAll((Collection)localObject);
    }
    bVX();
    bVW();
    bVV();
    if (!TextUtils.isEmpty(this.owK.bTN().FRB))
    {
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(2131494804);
      ((CardTextPreference)localObject).setTitle(getString(2131756949));
      ((CardTextPreference)localObject).setKey("key_pic_detail");
      ((CardTextPreference)localObject).bYG();
      bVX();
      this.mzx.b((Preference)localObject);
    }
    if (!TextUtils.isEmpty(this.owK.bTN().FRy))
    {
      bVX();
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(2131494804);
      ((CardTextPreference)localObject).setKey("card_phone");
      ((CardTextPreference)localObject).setTitle(2131756925);
      ((CardTextPreference)localObject).setSummary(this.owK.bTN().FRy);
      ((CardTextPreference)localObject).oPT = getResources().getColor(2131100547);
      ((CardTextPreference)localObject).bYF();
      this.mzx.b((Preference)localObject);
      YI("");
    }
    if ((this.owK.bTN() != null) && (!TextUtils.isEmpty(this.owK.bTN().source)) && (this.oEJ != null))
    {
      this.oEJ.setText(this.owK.bTN().source);
      this.oEJ.setVisibility(0);
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
      paramf = this.owK.bTN().FRy;
      Intent localIntent = new Intent("android.intent.action.DIAL");
      localIntent.setFlags(268435456);
      localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramf))));
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    if (paramPreference.mKey.equals("key_pic_detail")) {
      com.tencent.mm.plugin.card.d.b.a(this, this.owK.bTN().FRB, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(113197);
      return false;
      int i = 0;
      while (i < this.owP.size())
      {
        paramf = (com.tencent.mm.plugin.card.model.b)this.owP.get(i);
        if ((paramf.title != null) && (paramf.title.equals(paramPreference.mKey)) && (!TextUtils.isEmpty(paramf.url)))
        {
          if (com.tencent.mm.plugin.card.d.b.P(this.owK.bTR(), paramf.FRk, paramf.FRl))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailPreference
 * JD-Core Version:    0.7.0.1
 */