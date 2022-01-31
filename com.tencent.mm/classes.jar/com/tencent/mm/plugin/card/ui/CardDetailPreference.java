package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.a.h;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.widget.CardTextPreference;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.y;
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
  private final String TAG = "MicroMsg.CardDetailPreference";
  f hcp;
  private com.tencent.mm.plugin.card.base.b ikk;
  private List<com.tencent.mm.plugin.card.model.b> iko = new ArrayList();
  private TextView irS;
  
  private void aBn()
  {
    int i = 0;
    while (i < this.iko.size())
    {
      com.tencent.mm.plugin.card.model.b localb = (com.tencent.mm.plugin.card.model.b)this.iko.get(i);
      Preference localPreference = new Preference(this);
      localPreference.setLayoutResource(a.e.mm_preference);
      localPreference.setKey(localb.title);
      localPreference.setTitle(localb.title);
      if (!TextUtils.isEmpty(localb.ilq)) {
        localPreference.setSummary(localb.ilq);
      }
      if (localb.ilA) {
        aBp();
      }
      this.hcp.a(localPreference);
      i += 1;
    }
  }
  
  private void aBo()
  {
    if ((this.ikk.azx().sIr != null) && (this.ikk.azx().sIr != null))
    {
      int i = 0;
      while (i < this.ikk.azx().sIr.size())
      {
        ra localra = (ra)this.ikk.azx().sIr.get(i);
        if (!TextUtils.isEmpty(localra.ilq))
        {
          CardTextPreference localCardTextPreference = new CardTextPreference(this);
          localCardTextPreference.setLayoutResource(a.e.mm_preference);
          localCardTextPreference.setTitle(localra.ilq);
          localCardTextPreference.aDi();
          yC(localra.title);
          this.hcp.a(localCardTextPreference);
        }
        i += 1;
      }
      aBp();
    }
  }
  
  private void aBp()
  {
    PreferenceSmallCategory localPreferenceSmallCategory = new PreferenceSmallCategory(this);
    this.hcp.a(localPreferenceSmallCategory);
  }
  
  private void yC(String paramString)
  {
    PreferenceTitleCategory localPreferenceTitleCategory = new PreferenceTitleCategory(this);
    if (TextUtils.isEmpty(paramString)) {
      localPreferenceTitleCategory.setTitle(" ");
    }
    for (;;)
    {
      this.hcp.a(localPreferenceTitleCategory);
      return;
      localPreferenceTitleCategory.setTitle(paramString);
    }
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    if (paramPreference.mKey.equals("card_phone"))
    {
      paramf = this.ikk.azx().sIp;
      Intent localIntent = new Intent("android.intent.action.DIAL");
      localIntent.setFlags(268435456);
      localIntent.setData(Uri.parse("tel:" + paramf));
      startActivity(localIntent);
    }
    if (paramPreference.mKey.equals("key_pic_detail")) {
      com.tencent.mm.plugin.card.d.b.a(this, this.ikk.azx().sIs, 0);
    }
    label207:
    for (;;)
    {
      return false;
      int i = 0;
      for (;;)
      {
        if (i >= this.iko.size()) {
          break label207;
        }
        paramf = (com.tencent.mm.plugin.card.model.b)this.iko.get(i);
        if ((paramf.title != null) && (paramf.title.equals(paramPreference.mKey)) && (!TextUtils.isEmpty(paramf.url)))
        {
          if (com.tencent.mm.plugin.card.d.b.d(this.ikk.azB(), paramf.sIf, paramf.sIg, 1028, 0)) {
            break;
          }
          com.tencent.mm.plugin.card.d.b.a(this, paramf.url, 1);
        }
        i += 1;
      }
    }
  }
  
  public final View aBq()
  {
    View localView = getLayoutInflater().inflate(a.e.source_layout, null);
    this.irS = ((TextView)localView.findViewById(a.d.source));
    this.irS.setVisibility(8);
    return localView;
  }
  
  protected final void initView()
  {
    this.ikk = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    if ((this.ikk == null) || (this.ikk.azx() == null) || (this.ikk.azy() == null))
    {
      y.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
    }
    do
    {
      return;
      Object localObject = new StringBuilder();
      if (!TextUtils.isEmpty(this.ikk.azx().imz)) {
        ((StringBuilder)localObject).append(this.ikk.azx().imz);
      }
      ((StringBuilder)localObject).append(getString(a.g.card_detail_info));
      setMMTitle(((StringBuilder)localObject).toString());
      setBackBtn(new CardDetailPreference.1(this));
      this.hcp = this.vdd;
      this.iko.clear();
      if ((this.ikk.azy().sHt != null) && (this.ikk.azy().sHt.size() > 0)) {
        this.iko.addAll(l.aR(this.ikk.azy().sHt));
      }
      if ((this.ikk.azy().sHu != null) && (this.ikk.azy().sHu.size() > 0))
      {
        localObject = l.aR(this.ikk.azy().sHu);
        ((com.tencent.mm.plugin.card.model.b)((List)localObject).get(0)).ilA = true;
        this.iko.addAll((Collection)localObject);
      }
      aBp();
      aBo();
      aBn();
      if (!TextUtils.isEmpty(this.ikk.azx().sIs))
      {
        localObject = new CardTextPreference(this);
        ((CardTextPreference)localObject).setLayoutResource(a.e.mm_preference);
        ((CardTextPreference)localObject).setTitle(getString(a.g.card_picture_detail));
        ((CardTextPreference)localObject).setKey("key_pic_detail");
        ((CardTextPreference)localObject).aDi();
        aBp();
        this.hcp.a((Preference)localObject);
      }
      if (!TextUtils.isEmpty(this.ikk.azx().sIp))
      {
        aBp();
        localObject = new CardTextPreference(this);
        ((CardTextPreference)localObject).setLayoutResource(a.e.mm_preference);
        ((CardTextPreference)localObject).setKey("card_phone");
        ((CardTextPreference)localObject).setTitle(a.g.card_mall_product_seller);
        ((CardTextPreference)localObject).setSummary(this.ikk.azx().sIp);
        ((CardTextPreference)localObject).izu = getResources().getColor(a.a.link_color);
        ((CardTextPreference)localObject).aDh();
        this.hcp.a((Preference)localObject);
        yC("");
      }
    } while ((this.ikk.azx() == null) || (TextUtils.isEmpty(this.ikk.azx().aWf)) || (this.irS == null));
    this.irS.setText(this.ikk.azx().aWf);
    this.irS.setVisibility(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public final int xj()
  {
    return a.h.card_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailPreference
 * JD-Core Version:    0.7.0.1
 */