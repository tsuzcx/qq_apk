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
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.a.h;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.widget.CardTextPreference;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
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
  f mrf;
  private com.tencent.mm.plugin.card.base.b tmU;
  private List<com.tencent.mm.plugin.card.model.b> tmZ;
  private TextView tuV;
  
  public CardDetailPreference()
  {
    AppMethodBeat.i(113190);
    this.TAG = "MicroMsg.CardDetailPreference";
    this.tmZ = new ArrayList();
    AppMethodBeat.o(113190);
  }
  
  private void arr(String paramString)
  {
    AppMethodBeat.i(113196);
    PreferenceTitleCategory localPreferenceTitleCategory = new PreferenceTitleCategory(this);
    if (TextUtils.isEmpty(paramString)) {
      localPreferenceTitleCategory.setTitle(" ");
    }
    for (;;)
    {
      this.mrf.b(localPreferenceTitleCategory);
      AppMethodBeat.o(113196);
      return;
      localPreferenceTitleCategory.setTitle(paramString);
    }
  }
  
  private void cIC()
  {
    AppMethodBeat.i(113193);
    int i = 0;
    while (i < this.tmZ.size())
    {
      com.tencent.mm.plugin.card.model.b localb = (com.tencent.mm.plugin.card.model.b)this.tmZ.get(i);
      Preference localPreference = new Preference(this);
      localPreference.setLayoutResource(a.e.mm_preference);
      localPreference.setKey(localb.title);
      localPreference.setTitle(localb.title);
      if (!TextUtils.isEmpty(localb.tnY)) {
        localPreference.aF(localb.tnY);
      }
      if (localb.toi) {
        cIE();
      }
      this.mrf.b(localPreference);
      i += 1;
    }
    AppMethodBeat.o(113193);
  }
  
  private void cID()
  {
    AppMethodBeat.i(113194);
    if ((this.tmU.cGs().SfQ != null) && (this.tmU.cGs().SfQ != null))
    {
      int i = 0;
      while (i < this.tmU.cGs().SfQ.size())
      {
        acg localacg = (acg)this.tmU.cGs().SfQ.get(i);
        if (!TextUtils.isEmpty(localacg.tnY))
        {
          CardTextPreference localCardTextPreference = new CardTextPreference(this);
          localCardTextPreference.setLayoutResource(a.e.mm_preference);
          localCardTextPreference.setTitle(localacg.tnY);
          localCardTextPreference.cLm();
          arr(localacg.title);
          this.mrf.b(localCardTextPreference);
        }
        i += 1;
      }
      cIE();
    }
    AppMethodBeat.o(113194);
  }
  
  private void cIE()
  {
    AppMethodBeat.i(113195);
    PreferenceSmallCategory localPreferenceSmallCategory = new PreferenceSmallCategory(this);
    this.mrf.b(localPreferenceSmallCategory);
    AppMethodBeat.o(113195);
  }
  
  public View getFooterView()
  {
    AppMethodBeat.i(113198);
    View localView = getLayoutInflater().inflate(a.e.source_layout, null);
    this.tuV = ((TextView)localView.findViewById(a.d.source));
    this.tuV.setVisibility(8);
    AppMethodBeat.o(113198);
    return localView;
  }
  
  public int getResourceId()
  {
    return a.h.tmp;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113192);
    this.tmU = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    if ((this.tmU == null) || (this.tmU.cGs() == null) || (this.tmU.cGt() == null))
    {
      Log.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113192);
      return;
    }
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.tmU.cGs().tpo)) {
      ((StringBuilder)localObject).append(this.tmU.cGs().tpo);
    }
    ((StringBuilder)localObject).append(getString(a.g.tka));
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
    this.mrf = getPreferenceScreen();
    this.tmZ.clear();
    if ((this.tmU.cGt().SdA != null) && (this.tmU.cGt().SdA.size() > 0)) {
      this.tmZ.addAll(l.cU(this.tmU.cGt().SdA));
    }
    if ((this.tmU.cGt().SdB != null) && (this.tmU.cGt().SdB.size() > 0))
    {
      localObject = l.cU(this.tmU.cGt().SdB);
      ((com.tencent.mm.plugin.card.model.b)((List)localObject).get(0)).toi = true;
      this.tmZ.addAll((Collection)localObject);
    }
    cIE();
    cID();
    cIC();
    if (!TextUtils.isEmpty(this.tmU.cGs().SfR))
    {
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(a.e.mm_preference);
      ((CardTextPreference)localObject).setTitle(getString(a.g.tlj));
      ((CardTextPreference)localObject).setKey("key_pic_detail");
      ((CardTextPreference)localObject).cLm();
      cIE();
      this.mrf.b((Preference)localObject);
    }
    if (!TextUtils.isEmpty(this.tmU.cGs().SfO))
    {
      cIE();
      localObject = new CardTextPreference(this);
      ((CardTextPreference)localObject).setLayoutResource(a.e.mm_preference);
      ((CardTextPreference)localObject).setKey("card_phone");
      ((CardTextPreference)localObject).setTitle(a.g.tkS);
      ((CardTextPreference)localObject).aF(this.tmU.cGs().SfO);
      ((CardTextPreference)localObject).tHk = getResources().getColor(a.a.link_color);
      ((CardTextPreference)localObject).cLl();
      this.mrf.b((Preference)localObject);
      arr("");
    }
    if ((this.tmU.cGs() != null) && (!TextUtils.isEmpty(this.tmU.cGs().source)) && (this.tuV != null))
    {
      this.tuV.setText(this.tmU.cGs().source);
      this.tuV.setVisibility(0);
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
      paramf = this.tmU.cGs().SfO;
      Intent localIntent = new Intent("android.intent.action.DIAL");
      localIntent.setFlags(268435456);
      localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramf))));
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/util/CardActivityHelper", "doDial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    if (paramPreference.mKey.equals("key_pic_detail")) {
      com.tencent.mm.plugin.card.d.b.a(this, this.tmU.cGs().SfR, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(113197);
      return false;
      int i = 0;
      while (i < this.tmZ.size())
      {
        paramf = (com.tencent.mm.plugin.card.model.b)this.tmZ.get(i);
        if ((paramf.title != null) && (paramf.title.equals(paramPreference.mKey)) && (!TextUtils.isEmpty(paramf.url)))
        {
          if (com.tencent.mm.plugin.card.d.b.S(this.tmU.cGw(), paramf.SfB, paramf.SfC))
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