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
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
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
  f nRm;
  private com.tencent.mm.plugin.card.base.b pQV;
  private List<com.tencent.mm.plugin.card.model.b> pRa;
  private TextView pYZ;
  
  public CardDetailPreference()
  {
    AppMethodBeat.i(113190);
    this.TAG = "MicroMsg.CardDetailPreference";
    this.pRa = new ArrayList();
    AppMethodBeat.o(113190);
  }
  
  private void ajE(String paramString)
  {
    AppMethodBeat.i(113196);
    PreferenceTitleCategory localPreferenceTitleCategory = new PreferenceTitleCategory(this);
    if (TextUtils.isEmpty(paramString)) {
      localPreferenceTitleCategory.setTitle(" ");
    }
    for (;;)
    {
      this.nRm.c(localPreferenceTitleCategory);
      AppMethodBeat.o(113196);
      return;
      localPreferenceTitleCategory.setTitle(paramString);
    }
  }
  
  private void cva()
  {
    AppMethodBeat.i(113193);
    int i = 0;
    while (i < this.pRa.size())
    {
      com.tencent.mm.plugin.card.model.b localb = (com.tencent.mm.plugin.card.model.b)this.pRa.get(i);
      Preference localPreference = new Preference(this);
      localPreference.setLayoutResource(2131495538);
      localPreference.setKey(localb.title);
      localPreference.setTitle(localb.title);
      if (!TextUtils.isEmpty(localb.pRY)) {
        localPreference.setSummary(localb.pRY);
      }
      if (localb.pSj) {
        cvc();
      }
      this.nRm.c(localPreference);
      i += 1;
    }
    AppMethodBeat.o(113193);
  }
  
  private void cvb()
  {
    AppMethodBeat.i(113194);
    if ((this.pQV.csQ().LeD != null) && (this.pQV.csQ().LeD != null))
    {
      int i = 0;
      while (i < this.pQV.csQ().LeD.size())
      {
        abz localabz = (abz)this.pQV.csQ().LeD.get(i);
        if (!TextUtils.isEmpty(localabz.pRY))
        {
          CardTextPreference localCardTextPreference = new CardTextPreference(this);
          localCardTextPreference.setLayoutResource(2131495538);
          localCardTextPreference.setTitle(localabz.pRY);
          localCardTextPreference.cxK();
          ajE(localabz.title);
          this.nRm.c(localCardTextPreference);
        }
        i += 1;
      }
      cvc();
    }
    AppMethodBeat.o(113194);
  }
  
  private void cvc()
  {
    AppMethodBeat.i(113195);
    PreferenceSmallCategory localPreferenceSmallCategory = new PreferenceSmallCategory(this);
    this.nRm.c(localPreferenceSmallCategory);
    AppMethodBeat.o(113195);
  }
  
  public View getFooterView()
  {
    AppMethodBeat.i(113198);
    View localView = getLayoutInflater().inflate(2131496538, null);
    this.pYZ = ((TextView)localView.findViewById(2131308306));
    this.pYZ.setVisibility(8);
    AppMethodBeat.o(113198);
    return localView;
  }
  
  public int getResourceId()
  {
    return 2132017170;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113192);
    this.pQV = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    if ((this.pQV == null) || (this.pQV.csQ() == null) || (this.pQV.csR() == null))
    {
      Log.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113192);
      return;
    }
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.pQV.csQ().pTn)) {
      ((StringBuilder)localObject).append(this.pQV.csQ().pTn);
    }
    ((StringBuilder)localObject).append(getString(2131756994));
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
    this.nRm = getPreferenceScreen();
    this.pRa.clear();
    if ((this.pQV.csR().Lcn != null) && (this.pQV.csR().Lcn.size() > 0)) {
      this.pRa.addAll(l.cX(this.pQV.csR().Lcn));
    }
    if ((this.pQV.csR().Lco != null) && (this.pQV.csR().Lco.size() > 0))
    {
      localObject = l.cX(this.pQV.csR().Lco);
      ((com.tencent.mm.plugin.card.model.b)((List)localObject).get(0)).pSj = true;
      this.pRa.addAll((Collection)localObject);
    }
    cvc();
    cvb();
    cva();
    if (!TextUtils.isEmpty(this.pQV.csQ().LeE))
    {
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(2131495538);
      ((CardTextPreference)localObject).setTitle(getString(2131757119));
      ((CardTextPreference)localObject).setKey("key_pic_detail");
      ((CardTextPreference)localObject).cxK();
      cvc();
      this.nRm.c((Preference)localObject);
    }
    if (!TextUtils.isEmpty(this.pQV.csQ().LeB))
    {
      cvc();
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(2131495538);
      ((CardTextPreference)localObject).setKey("card_phone");
      ((CardTextPreference)localObject).setTitle(2131757095);
      ((CardTextPreference)localObject).setSummary(this.pQV.csQ().LeB);
      ((CardTextPreference)localObject).qlp = getResources().getColor(2131100685);
      ((CardTextPreference)localObject).cxJ();
      this.nRm.c((Preference)localObject);
      ajE("");
    }
    if ((this.pQV.csQ() != null) && (!TextUtils.isEmpty(this.pQV.csQ().source)) && (this.pYZ != null))
    {
      this.pYZ.setText(this.pQV.csQ().source);
      this.pYZ.setVisibility(0);
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
      paramf = this.pQV.csQ().LeB;
      Intent localIntent = new Intent("android.intent.action.DIAL");
      localIntent.setFlags(268435456);
      localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramf))));
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    if (paramPreference.mKey.equals("key_pic_detail")) {
      com.tencent.mm.plugin.card.d.b.a(this, this.pQV.csQ().LeE, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(113197);
      return false;
      int i = 0;
      while (i < this.pRa.size())
      {
        paramf = (com.tencent.mm.plugin.card.model.b)this.pRa.get(i);
        if ((paramf.title != null) && (paramf.title.equals(paramPreference.mKey)) && (!TextUtils.isEmpty(paramf.url)))
        {
          if (com.tencent.mm.plugin.card.d.b.V(this.pQV.csU(), paramf.Leo, paramf.Lep))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailPreference
 * JD-Core Version:    0.7.0.1
 */