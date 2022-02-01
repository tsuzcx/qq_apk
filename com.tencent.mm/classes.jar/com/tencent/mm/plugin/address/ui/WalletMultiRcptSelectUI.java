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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class WalletMultiRcptSelectUI
  extends MMPreference
{
  private int doR = 0;
  private RcptItem jaJ = null;
  private RcptItem jaK = null;
  private List<RcptItem> jaL;
  private f screen;
  
  private void aRU()
  {
    AppMethodBeat.i(21009);
    switch (this.doR)
    {
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_stage", this.doR);
      localIntent.putExtra("key_province", this.jaJ);
      localIntent.putExtra("key_city", this.jaK);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(21009);
      return;
      this.jaK = null;
      this.doR = 1;
      continue;
      this.jaJ = null;
      this.doR = 0;
    }
  }
  
  private void y(Intent paramIntent)
  {
    AppMethodBeat.i(21014);
    if (paramIntent == null)
    {
      ac.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
      AppMethodBeat.o(21014);
      return;
    }
    this.doR = paramIntent.getIntExtra("key_stage", 0);
    this.jaJ = ((RcptItem)paramIntent.getParcelableExtra("key_province"));
    this.jaK = ((RcptItem)paramIntent.getParcelableExtra("key_city"));
    String str = paramIntent.getStringExtra("extra_province");
    if (str != null)
    {
      a.aRF();
      this.jaJ = a.aRH().GQ(str);
      if (this.jaJ != null) {
        this.doR = 1;
      }
    }
    paramIntent = paramIntent.getStringExtra("extra_city");
    if ((paramIntent != null) && (1 == this.doR))
    {
      a.aRF();
      this.jaK = a.aRH().bS(this.jaJ.code, paramIntent);
      if (this.jaK != null) {
        this.doR = 2;
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
    localObject = a.aRH().iYI;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ac.e("MicroMsg.MultiRptSelectUI", "list == null || list.isEmpty(), need loadata!");
      a.aRH().aRI();
    }
    switch (this.doR)
    {
    default: 
      a.aRF();
      localObject = a.aRH().iYI;
    }
    for (;;)
    {
      this.jaL = ((List)localObject);
      if ((this.jaL != null) && (this.jaL.size() > 0)) {
        break label257;
      }
      ac.e("MicroMsg.MultiRptSelectUI", "initZoneItems error ,check zone lists!");
      AppMethodBeat.o(21013);
      return;
      a.aRF();
      localObject = a.aRH().iYI;
      continue;
      if ((this.jaJ != null) && (!bs.isNullOrNil(this.jaJ.code)))
      {
        a.aRF();
        localObject = a.aRH().GO(this.jaJ.code);
      }
      else
      {
        if ((this.jaK == null) || (bs.isNullOrNil(this.jaK.code))) {
          break;
        }
        a.aRF();
        localObject = a.aRH().GP(this.jaK.code);
      }
    }
    label257:
    this.screen.removeAll();
    i = 0;
    if (i < this.jaL.size())
    {
      RcptItem localRcptItem;
      if ((this.jaL.get(i) != null) && (!bs.isNullOrNil(((RcptItem)this.jaL.get(i)).name)))
      {
        localObject = new RcptPreference(this);
        localRcptItem = (RcptItem)this.jaL.get(i);
        if ((localRcptItem != null) && (!bs.isNullOrNil(localRcptItem.name))) {
          break label377;
        }
        ac.e("MicroMsg.RcptPreference", "setZoneItem item = null");
      }
      for (;;)
      {
        this.screen.b((Preference)localObject);
        i += 1;
        break;
        label377:
        ((RcptPreference)localObject).setKey(localRcptItem.code + localObject.hashCode());
        ((RcptPreference)localObject).jaA = localRcptItem;
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
    aRU();
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
      paramf = ((RcptPreference)paramPreference).jaA;
      if ((paramf == null) || (bs.isNullOrNil(paramf.name)))
      {
        ac.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
        AppMethodBeat.o(21015);
        return false;
      }
      if (!paramf.iYF) {
        this.doR = 2;
      }
      switch (this.doR)
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
      paramf.putExtra("key_stage", this.doR);
      paramf.putExtra("key_province", this.jaJ);
      paramf.putExtra("key_city", this.jaK);
      if (-1 != i) {
        paramf.putExtra("ui_title", i);
      }
      startActivityForResult(paramf, 1);
      for (;;)
      {
        AppMethodBeat.o(21015);
        return false;
        this.jaJ = paramf;
        this.doR = 1;
        break;
        this.jaK = paramf;
        this.doR = 2;
        break;
        paramPreference = new StringBuilder();
        if (this.jaJ != null) {
          paramPreference.append(this.jaJ.name).append(" ");
        }
        if (this.jaK != null) {
          paramPreference.append(this.jaK.name).append(" ");
        }
        paramPreference.append(paramf.name);
        ac.d("MicroMsg.MultiRptSelectUI", "area_result: " + paramPreference.toString() + ",item.name: " + paramf.name);
        Intent localIntent = new Intent();
        localIntent.putExtra("karea_result", paramPreference.toString());
        localIntent.putExtra("kpost_code", paramf.iYE);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI
 * JD-Core Version:    0.7.0.1
 */