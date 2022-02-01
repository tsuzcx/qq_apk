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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class WalletMultiRcptSelectUI
  extends MMPreference
{
  private int dBK = 0;
  private RcptItem jwN = null;
  private RcptItem jwO = null;
  private List<RcptItem> jwP;
  private f screen;
  
  private void aVF()
  {
    AppMethodBeat.i(21009);
    switch (this.dBK)
    {
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_stage", this.dBK);
      localIntent.putExtra("key_province", this.jwN);
      localIntent.putExtra("key_city", this.jwO);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(21009);
      return;
      this.jwO = null;
      this.dBK = 1;
      continue;
      this.jwN = null;
      this.dBK = 0;
    }
  }
  
  private void y(Intent paramIntent)
  {
    AppMethodBeat.i(21014);
    if (paramIntent == null)
    {
      ae.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
      AppMethodBeat.o(21014);
      return;
    }
    this.dBK = paramIntent.getIntExtra("key_stage", 0);
    this.jwN = ((RcptItem)paramIntent.getParcelableExtra("key_province"));
    this.jwO = ((RcptItem)paramIntent.getParcelableExtra("key_city"));
    String str = paramIntent.getStringExtra("extra_province");
    if (str != null)
    {
      a.aVq();
      this.jwN = a.aVs().KE(str);
      if (this.jwN != null) {
        this.dBK = 1;
      }
    }
    paramIntent = paramIntent.getStringExtra("extra_city");
    if ((paramIntent != null) && (1 == this.dBK))
    {
      a.aVq();
      this.jwO = a.aVs().bU(this.jwN.code, paramIntent);
      if (this.jwO != null) {
        this.dBK = 2;
      }
    }
    AppMethodBeat.o(21014);
  }
  
  public int getResourceId()
  {
    return 2131951709;
  }
  
  public void initView()
  {
    int i = 2131755226;
    AppMethodBeat.i(21013);
    Object localObject = getIntent();
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("ui_title", 2131755226);
    }
    setMMTitle(i);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(21008);
        WalletMultiRcptSelectUI.a(WalletMultiRcptSelectUI.this);
        AppMethodBeat.o(21008);
        return true;
      }
    });
    y((Intent)localObject);
    localObject = a.aVs().juK;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ae.e("MicroMsg.MultiRptSelectUI", "list == null || list.isEmpty(), need loadata!");
      a.aVs().aVt();
    }
    switch (this.dBK)
    {
    default: 
      a.aVq();
      localObject = a.aVs().juK;
    }
    for (;;)
    {
      this.jwP = ((List)localObject);
      if ((this.jwP != null) && (this.jwP.size() > 0)) {
        break label257;
      }
      ae.e("MicroMsg.MultiRptSelectUI", "initZoneItems error ,check zone lists!");
      AppMethodBeat.o(21013);
      return;
      a.aVq();
      localObject = a.aVs().juK;
      continue;
      if ((this.jwN != null) && (!bu.isNullOrNil(this.jwN.code)))
      {
        a.aVq();
        localObject = a.aVs().KC(this.jwN.code);
      }
      else
      {
        if ((this.jwO == null) || (bu.isNullOrNil(this.jwO.code))) {
          break;
        }
        a.aVq();
        localObject = a.aVs().KD(this.jwO.code);
      }
    }
    label257:
    this.screen.removeAll();
    i = 0;
    if (i < this.jwP.size())
    {
      RcptItem localRcptItem;
      if ((this.jwP.get(i) != null) && (!bu.isNullOrNil(((RcptItem)this.jwP.get(i)).name)))
      {
        localObject = new RcptPreference(this);
        localRcptItem = (RcptItem)this.jwP.get(i);
        if ((localRcptItem != null) && (!bu.isNullOrNil(localRcptItem.name))) {
          break label377;
        }
        ae.e("MicroMsg.RcptPreference", "setZoneItem item = null");
      }
      for (;;)
      {
        this.screen.b((Preference)localObject);
        i += 1;
        break;
        label377:
        ((RcptPreference)localObject).setKey(localRcptItem.code + localObject.hashCode());
        ((RcptPreference)localObject).jwE = localRcptItem;
      }
    }
    localObject = new PreferenceSmallCategory(this);
    this.screen.b((Preference)localObject);
    AppMethodBeat.o(21013);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(21017);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21017);
      return;
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
        AppMethodBeat.o(21017);
        return;
      }
      y(paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(21016);
    aVF();
    super.onBackPressed();
    AppMethodBeat.o(21016);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21010);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(21010);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21012);
    super.onDestroy();
    AppMethodBeat.o(21012);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(21015);
    if ((paramPreference instanceof RcptPreference))
    {
      paramf = ((RcptPreference)paramPreference).jwE;
      if ((paramf == null) || (bu.isNullOrNil(paramf.name)))
      {
        ae.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
        AppMethodBeat.o(21015);
        return false;
      }
      if (!paramf.juH) {
        this.dBK = 2;
      }
      switch (this.dBK)
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
      paramf.putExtra("key_stage", this.dBK);
      paramf.putExtra("key_province", this.jwN);
      paramf.putExtra("key_city", this.jwO);
      if (-1 != i) {
        paramf.putExtra("ui_title", i);
      }
      startActivityForResult(paramf, 1);
      for (;;)
      {
        AppMethodBeat.o(21015);
        return false;
        this.jwN = paramf;
        this.dBK = 1;
        break;
        this.jwO = paramf;
        this.dBK = 2;
        break;
        paramPreference = new StringBuilder();
        if (this.jwN != null) {
          paramPreference.append(this.jwN.name).append(" ");
        }
        if (this.jwO != null) {
          paramPreference.append(this.jwO.name).append(" ");
        }
        paramPreference.append(paramf.name);
        ae.d("MicroMsg.MultiRptSelectUI", "area_result: " + paramPreference.toString() + ",item.name: " + paramf.name);
        Intent localIntent = new Intent();
        localIntent.putExtra("karea_result", paramPreference.toString());
        localIntent.putExtra("kpost_code", paramf.juG);
        localIntent.putExtra("kwcode", paramf.code);
        setResult(-1, localIntent);
        finish();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21011);
    super.onResume();
    AppMethodBeat.o(21011);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI
 * JD-Core Version:    0.7.0.1
 */