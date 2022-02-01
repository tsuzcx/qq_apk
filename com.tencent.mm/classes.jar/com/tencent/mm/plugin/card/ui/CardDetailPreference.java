package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.a.h;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.widget.CardTextPreference;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
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
  f pkD;
  private com.tencent.mm.plugin.card.base.b wru;
  private List<com.tencent.mm.plugin.card.model.b> wrz;
  private TextView wzs;
  
  public CardDetailPreference()
  {
    AppMethodBeat.i(113190);
    this.TAG = "MicroMsg.CardDetailPreference";
    this.wrz = new ArrayList();
    AppMethodBeat.o(113190);
  }
  
  private void akW(String paramString)
  {
    AppMethodBeat.i(113196);
    PreferenceTitleCategory localPreferenceTitleCategory = new PreferenceTitleCategory(this);
    if (TextUtils.isEmpty(paramString)) {
      localPreferenceTitleCategory.setTitle(" ");
    }
    for (;;)
    {
      this.pkD.c(localPreferenceTitleCategory);
      AppMethodBeat.o(113196);
      return;
      localPreferenceTitleCategory.setTitle(paramString);
    }
  }
  
  private void dlT()
  {
    AppMethodBeat.i(113193);
    int i = 0;
    while (i < this.wrz.size())
    {
      com.tencent.mm.plugin.card.model.b localb = (com.tencent.mm.plugin.card.model.b)this.wrz.get(i);
      Preference localPreference = new Preference(this);
      localPreference.setLayoutResource(a.e.mm_preference);
      localPreference.setKey(localb.title);
      localPreference.setTitle(localb.title);
      if (!TextUtils.isEmpty(localb.wsz)) {
        localPreference.aS(localb.wsz);
      }
      if (localb.wsJ) {
        dlV();
      }
      this.pkD.c(localPreference);
      i += 1;
    }
    AppMethodBeat.o(113193);
  }
  
  private void dlU()
  {
    AppMethodBeat.i(113194);
    if ((this.wru.djK().ZdL != null) && (this.wru.djK().ZdL != null))
    {
      int i = 0;
      while (i < this.wru.djK().ZdL.size())
      {
        aek localaek = (aek)this.wru.djK().ZdL.get(i);
        if (!TextUtils.isEmpty(localaek.wsz))
        {
          CardTextPreference localCardTextPreference = new CardTextPreference(this);
          localCardTextPreference.setLayoutResource(a.e.mm_preference);
          localCardTextPreference.setTitle(localaek.wsz);
          localCardTextPreference.doV();
          akW(localaek.title);
          this.pkD.c(localCardTextPreference);
        }
        i += 1;
      }
      dlV();
    }
    AppMethodBeat.o(113194);
  }
  
  private void dlV()
  {
    AppMethodBeat.i(113195);
    PreferenceSmallCategory localPreferenceSmallCategory = new PreferenceSmallCategory(this);
    this.pkD.c(localPreferenceSmallCategory);
    AppMethodBeat.o(113195);
  }
  
  public View getFooterView()
  {
    AppMethodBeat.i(113198);
    View localView = getLayoutInflater().inflate(a.e.source_layout, null);
    this.wzs = ((TextView)localView.findViewById(a.d.source));
    this.wzs.setVisibility(8);
    AppMethodBeat.o(113198);
    return localView;
  }
  
  public int getResourceId()
  {
    return a.h.wqP;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113192);
    this.wru = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    if ((this.wru == null) || (this.wru.djK() == null) || (this.wru.djL() == null))
    {
      Log.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113192);
      return;
    }
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.wru.djK().wtN)) {
      ((StringBuilder)localObject).append(this.wru.djK().wtN);
    }
    ((StringBuilder)localObject).append(getString(a.g.woy));
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
    this.pkD = getPreferenceScreen();
    this.wrz.clear();
    if ((this.wru.djL().Zbu != null) && (this.wru.djL().Zbu.size() > 0)) {
      this.wrz.addAll(l.eP(this.wru.djL().Zbu));
    }
    if ((this.wru.djL().Zbv != null) && (this.wru.djL().Zbv.size() > 0))
    {
      localObject = l.eP(this.wru.djL().Zbv);
      ((com.tencent.mm.plugin.card.model.b)((List)localObject).get(0)).wsJ = true;
      this.wrz.addAll((Collection)localObject);
    }
    dlV();
    dlU();
    dlT();
    if (!TextUtils.isEmpty(this.wru.djK().ZdM))
    {
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(a.e.mm_preference);
      ((CardTextPreference)localObject).setTitle(getString(a.g.wpI));
      ((CardTextPreference)localObject).setKey("key_pic_detail");
      ((CardTextPreference)localObject).doV();
      dlV();
      this.pkD.c((Preference)localObject);
    }
    if (!TextUtils.isEmpty(this.wru.djK().ZdJ))
    {
      dlV();
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(a.e.mm_preference);
      ((CardTextPreference)localObject).setKey("card_phone");
      ((CardTextPreference)localObject).setTitle(a.g.wpr);
      ((CardTextPreference)localObject).aS(this.wru.djK().ZdJ);
      ((CardTextPreference)localObject).wKL = getResources().getColor(a.a.link_color);
      ((CardTextPreference)localObject).doU();
      this.pkD.c((Preference)localObject);
      akW("");
    }
    if ((this.wru.djK() != null) && (!TextUtils.isEmpty(this.wru.djK().source)) && (this.wzs != null))
    {
      this.wzs.setText(this.wru.djK().source);
      this.wzs.setVisibility(0);
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
      paramf = this.wru.djK().ZdJ;
      Intent localIntent = new Intent("android.intent.action.DIAL");
      localIntent.setFlags(268435456);
      localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramf))));
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    if (paramPreference.mKey.equals("key_pic_detail")) {
      com.tencent.mm.plugin.card.c.b.a(this, this.wru.djK().ZdM, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(113197);
      return false;
      int i = 0;
      while (i < this.wrz.size())
      {
        paramf = (com.tencent.mm.plugin.card.model.b)this.wrz.get(i);
        if ((paramf.title != null) && (paramf.title.equals(paramPreference.mKey)) && (!TextUtils.isEmpty(paramf.url)))
        {
          if (com.tencent.mm.plugin.card.c.b.V(this.wru.djO(), paramf.Zdw, paramf.Zdx))
          {
            AppMethodBeat.o(113197);
            return false;
          }
          com.tencent.mm.plugin.card.c.b.a(this, paramf.url, 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailPreference
 * JD-Core Version:    0.7.0.1
 */