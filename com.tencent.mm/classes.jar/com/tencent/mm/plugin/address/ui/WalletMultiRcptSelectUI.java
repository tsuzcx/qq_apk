package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class WalletMultiRcptSelectUI
  extends MMPreference
{
  private int cAX = 0;
  private RcptItem gNa = null;
  private RcptItem gNb = null;
  private List<RcptItem> gNc;
  private f screen;
  
  private void asB()
  {
    AppMethodBeat.i(16966);
    switch (this.cAX)
    {
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_stage", this.cAX);
      localIntent.putExtra("key_province", this.gNa);
      localIntent.putExtra("key_city", this.gNb);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(16966);
      return;
      this.gNb = null;
      this.cAX = 1;
      continue;
      this.gNa = null;
      this.cAX = 0;
    }
  }
  
  private void z(Intent paramIntent)
  {
    AppMethodBeat.i(16971);
    if (paramIntent == null)
    {
      ab.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
      AppMethodBeat.o(16971);
      return;
    }
    this.cAX = paramIntent.getIntExtra("key_stage", 0);
    this.gNa = ((RcptItem)paramIntent.getParcelableExtra("key_province"));
    this.gNb = ((RcptItem)paramIntent.getParcelableExtra("key_city"));
    String str = paramIntent.getStringExtra("extra_province");
    if (str != null)
    {
      a.asl();
      this.gNa = a.asn().xH(str);
      if (this.gNa != null) {
        this.cAX = 1;
      }
    }
    paramIntent = paramIntent.getStringExtra("extra_city");
    if ((paramIntent != null) && (1 == this.cAX))
    {
      a.asl();
      this.gNb = a.asn().bo(this.gNa.code, paramIntent);
      if (this.gNb != null) {
        this.cAX = 2;
      }
    }
    AppMethodBeat.o(16971);
  }
  
  public int getResourceId()
  {
    return 2131165266;
  }
  
  public void initView()
  {
    int i = 2131296494;
    AppMethodBeat.i(16970);
    Object localObject = getIntent();
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("ui_title", 2131296494);
    }
    setMMTitle(i);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(16964);
        WalletMultiRcptSelectUI.a(WalletMultiRcptSelectUI.this);
        AppMethodBeat.o(16964);
        return true;
      }
    });
    z((Intent)localObject);
    localObject = a.asn().gKV;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ab.e("MicroMsg.MultiRptSelectUI", "list == null || list.isEmpty(), need loadata!");
      a.asn().aso();
    }
    switch (this.cAX)
    {
    default: 
      a.asl();
      localObject = a.asn().gKV;
    }
    for (;;)
    {
      this.gNc = ((List)localObject);
      if ((this.gNc != null) && (this.gNc.size() > 0)) {
        break label257;
      }
      ab.e("MicroMsg.MultiRptSelectUI", "initZoneItems error ,check zone lists!");
      AppMethodBeat.o(16970);
      return;
      a.asl();
      localObject = a.asn().gKV;
      continue;
      if ((this.gNa != null) && (!bo.isNullOrNil(this.gNa.code)))
      {
        a.asl();
        localObject = a.asn().xF(this.gNa.code);
      }
      else
      {
        if ((this.gNb == null) || (bo.isNullOrNil(this.gNb.code))) {
          break;
        }
        a.asl();
        localObject = a.asn().xG(this.gNb.code);
      }
    }
    label257:
    this.screen.removeAll();
    i = 0;
    if (i < this.gNc.size())
    {
      RcptItem localRcptItem;
      if ((this.gNc.get(i) != null) && (!bo.isNullOrNil(((RcptItem)this.gNc.get(i)).name)))
      {
        localObject = new RcptPreference(this);
        localRcptItem = (RcptItem)this.gNc.get(i);
        if ((localRcptItem != null) && (!bo.isNullOrNil(localRcptItem.name))) {
          break label377;
        }
        ab.e("MicroMsg.RcptPreference", "setZoneItem item = null");
      }
      for (;;)
      {
        this.screen.b((Preference)localObject);
        i += 1;
        break;
        label377:
        ((RcptPreference)localObject).setKey(localRcptItem.code + localObject.hashCode());
        ((RcptPreference)localObject).gMR = localRcptItem;
      }
    }
    localObject = new PreferenceSmallCategory(this);
    this.screen.b((Preference)localObject);
    AppMethodBeat.o(16970);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(16974);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(16974);
      return;
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
        AppMethodBeat.o(16974);
        return;
      }
      z(paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(16973);
    asB();
    super.onBackPressed();
    AppMethodBeat.o(16973);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(16967);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(16967);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(16969);
    super.onDestroy();
    AppMethodBeat.o(16969);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(16972);
    if ((paramPreference instanceof RcptPreference))
    {
      paramf = ((RcptPreference)paramPreference).gMR;
      if ((paramf == null) || (bo.isNullOrNil(paramf.name)))
      {
        ab.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
        AppMethodBeat.o(16972);
        return false;
      }
      if (!paramf.gKT) {
        this.cAX = 2;
      }
      switch (this.cAX)
      {
      default: 
        paramf = getIntent();
        if (paramf == null) {
          break;
        }
      }
    }
    for (int i = paramf.getIntExtra("ui_title", -1);; i = -1)
    {
      paramf = new Intent(this, WalletMultiRcptSelectUI.class);
      paramf.putExtra("key_stage", this.cAX);
      paramf.putExtra("key_province", this.gNa);
      paramf.putExtra("key_city", this.gNb);
      if (-1 != i) {
        paramf.putExtra("ui_title", i);
      }
      startActivityForResult(paramf, 1);
      for (;;)
      {
        AppMethodBeat.o(16972);
        return false;
        this.gNa = paramf;
        this.cAX = 1;
        break;
        this.gNb = paramf;
        this.cAX = 2;
        break;
        paramPreference = new StringBuilder();
        if (this.gNa != null) {
          paramPreference.append(this.gNa.name).append(" ");
        }
        if (this.gNb != null) {
          paramPreference.append(this.gNb.name).append(" ");
        }
        paramPreference.append(paramf.name);
        ab.d("MicroMsg.MultiRptSelectUI", "area_result: " + paramPreference.toString() + ",item.name: " + paramf.name);
        Intent localIntent = new Intent();
        localIntent.putExtra("karea_result", paramPreference.toString());
        localIntent.putExtra("kpost_code", paramf.gKS);
        localIntent.putExtra("kwcode", paramf.code);
        setResult(-1, localIntent);
        finish();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(16968);
    super.onResume();
    AppMethodBeat.o(16968);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI
 * JD-Core Version:    0.7.0.1
 */