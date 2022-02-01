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
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
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
  f mEx;
  private com.tencent.mm.plugin.card.base.b oDm;
  private List<com.tencent.mm.plugin.card.model.b> oDr;
  private TextView oLl;
  
  public CardDetailPreference()
  {
    AppMethodBeat.i(113190);
    this.TAG = "MicroMsg.CardDetailPreference";
    this.oDr = new ArrayList();
    AppMethodBeat.o(113190);
  }
  
  private void Zz(String paramString)
  {
    AppMethodBeat.i(113196);
    PreferenceTitleCategory localPreferenceTitleCategory = new PreferenceTitleCategory(this);
    if (TextUtils.isEmpty(paramString)) {
      localPreferenceTitleCategory.setTitle(" ");
    }
    for (;;)
    {
      this.mEx.b(localPreferenceTitleCategory);
      AppMethodBeat.o(113196);
      return;
      localPreferenceTitleCategory.setTitle(paramString);
    }
  }
  
  private void bXk()
  {
    AppMethodBeat.i(113193);
    int i = 0;
    while (i < this.oDr.size())
    {
      com.tencent.mm.plugin.card.model.b localb = (com.tencent.mm.plugin.card.model.b)this.oDr.get(i);
      Preference localPreference = new Preference(this);
      localPreference.setLayoutResource(2131494804);
      localPreference.setKey(localb.title);
      localPreference.setTitle(localb.title);
      if (!TextUtils.isEmpty(localb.oEp)) {
        localPreference.setSummary(localb.oEp);
      }
      if (localb.oEA) {
        bXm();
      }
      this.mEx.b(localPreference);
      i += 1;
    }
    AppMethodBeat.o(113193);
  }
  
  private void bXl()
  {
    AppMethodBeat.i(113194);
    if ((this.oDm.bVc().GjZ != null) && (this.oDm.bVc().GjZ != null))
    {
      int i = 0;
      while (i < this.oDm.bVc().GjZ.size())
      {
        aai localaai = (aai)this.oDm.bVc().GjZ.get(i);
        if (!TextUtils.isEmpty(localaai.oEp))
        {
          CardTextPreference localCardTextPreference = new CardTextPreference(this);
          localCardTextPreference.setLayoutResource(2131494804);
          localCardTextPreference.setTitle(localaai.oEp);
          localCardTextPreference.bZV();
          Zz(localaai.title);
          this.mEx.b(localCardTextPreference);
        }
        i += 1;
      }
      bXm();
    }
    AppMethodBeat.o(113194);
  }
  
  private void bXm()
  {
    AppMethodBeat.i(113195);
    PreferenceSmallCategory localPreferenceSmallCategory = new PreferenceSmallCategory(this);
    this.mEx.b(localPreferenceSmallCategory);
    AppMethodBeat.o(113195);
  }
  
  public View getFooterView()
  {
    AppMethodBeat.i(113198);
    View localView = getLayoutInflater().inflate(2131495637, null);
    this.oLl = ((TextView)localView.findViewById(2131305128));
    this.oLl.setVisibility(8);
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
    this.oDm = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    if ((this.oDm == null) || (this.oDm.bVc() == null) || (this.oDm.bVd() == null))
    {
      ae.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113192);
      return;
    }
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.oDm.bVc().oFF)) {
      ((StringBuilder)localObject).append(this.oDm.bVc().oFF);
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
    this.mEx = getPreferenceScreen();
    this.oDr.clear();
    if ((this.oDm.bVd().GhK != null) && (this.oDm.bVd().GhK.size() > 0)) {
      this.oDr.addAll(l.cI(this.oDm.bVd().GhK));
    }
    if ((this.oDm.bVd().GhL != null) && (this.oDm.bVd().GhL.size() > 0))
    {
      localObject = l.cI(this.oDm.bVd().GhL);
      ((com.tencent.mm.plugin.card.model.b)((List)localObject).get(0)).oEA = true;
      this.oDr.addAll((Collection)localObject);
    }
    bXm();
    bXl();
    bXk();
    if (!TextUtils.isEmpty(this.oDm.bVc().Gka))
    {
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(2131494804);
      ((CardTextPreference)localObject).setTitle(getString(2131756949));
      ((CardTextPreference)localObject).setKey("key_pic_detail");
      ((CardTextPreference)localObject).bZV();
      bXm();
      this.mEx.b((Preference)localObject);
    }
    if (!TextUtils.isEmpty(this.oDm.bVc().GjX))
    {
      bXm();
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(2131494804);
      ((CardTextPreference)localObject).setKey("card_phone");
      ((CardTextPreference)localObject).setTitle(2131756925);
      ((CardTextPreference)localObject).setSummary(this.oDm.bVc().GjX);
      ((CardTextPreference)localObject).oWv = getResources().getColor(2131100547);
      ((CardTextPreference)localObject).bZU();
      this.mEx.b((Preference)localObject);
      Zz("");
    }
    if ((this.oDm.bVc() != null) && (!TextUtils.isEmpty(this.oDm.bVc().source)) && (this.oLl != null))
    {
      this.oLl.setText(this.oDm.bVc().source);
      this.oLl.setVisibility(0);
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
      paramf = this.oDm.bVc().GjX;
      Intent localIntent = new Intent("android.intent.action.DIAL");
      localIntent.setFlags(268435456);
      localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramf))));
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    if (paramPreference.mKey.equals("key_pic_detail")) {
      com.tencent.mm.plugin.card.d.b.a(this, this.oDm.bVc().Gka, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(113197);
      return false;
      int i = 0;
      while (i < this.oDr.size())
      {
        paramf = (com.tencent.mm.plugin.card.model.b)this.oDr.get(i);
        if ((paramf.title != null) && (paramf.title.equals(paramPreference.mKey)) && (!TextUtils.isEmpty(paramf.url)))
        {
          if (com.tencent.mm.plugin.card.d.b.Q(this.oDm.bVg(), paramf.GjJ, paramf.GjK))
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