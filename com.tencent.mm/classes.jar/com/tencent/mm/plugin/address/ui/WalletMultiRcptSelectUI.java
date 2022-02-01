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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class WalletMultiRcptSelectUI
  extends MMPreference
{
  private int dAF = 0;
  private RcptItem jtS = null;
  private RcptItem jtT = null;
  private List<RcptItem> jtU;
  private f screen;
  
  private void aVg()
  {
    AppMethodBeat.i(21009);
    switch (this.dAF)
    {
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_stage", this.dAF);
      localIntent.putExtra("key_province", this.jtS);
      localIntent.putExtra("key_city", this.jtT);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(21009);
      return;
      this.jtT = null;
      this.dAF = 1;
      continue;
      this.jtS = null;
      this.dAF = 0;
    }
  }
  
  private void y(Intent paramIntent)
  {
    AppMethodBeat.i(21014);
    if (paramIntent == null)
    {
      ad.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
      AppMethodBeat.o(21014);
      return;
    }
    this.dAF = paramIntent.getIntExtra("key_stage", 0);
    this.jtS = ((RcptItem)paramIntent.getParcelableExtra("key_province"));
    this.jtT = ((RcptItem)paramIntent.getParcelableExtra("key_city"));
    String str = paramIntent.getStringExtra("extra_province");
    if (str != null)
    {
      a.aUR();
      this.jtS = a.aUT().Kf(str);
      if (this.jtS != null) {
        this.dAF = 1;
      }
    }
    paramIntent = paramIntent.getStringExtra("extra_city");
    if ((paramIntent != null) && (1 == this.dAF))
    {
      a.aUR();
      this.jtT = a.aUT().bU(this.jtS.code, paramIntent);
      if (this.jtT != null) {
        this.dAF = 2;
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
    localObject = a.aUT().jrR;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ad.e("MicroMsg.MultiRptSelectUI", "list == null || list.isEmpty(), need loadata!");
      a.aUT().aUU();
    }
    switch (this.dAF)
    {
    default: 
      a.aUR();
      localObject = a.aUT().jrR;
    }
    for (;;)
    {
      this.jtU = ((List)localObject);
      if ((this.jtU != null) && (this.jtU.size() > 0)) {
        break label257;
      }
      ad.e("MicroMsg.MultiRptSelectUI", "initZoneItems error ,check zone lists!");
      AppMethodBeat.o(21013);
      return;
      a.aUR();
      localObject = a.aUT().jrR;
      continue;
      if ((this.jtS != null) && (!bt.isNullOrNil(this.jtS.code)))
      {
        a.aUR();
        localObject = a.aUT().Kd(this.jtS.code);
      }
      else
      {
        if ((this.jtT == null) || (bt.isNullOrNil(this.jtT.code))) {
          break;
        }
        a.aUR();
        localObject = a.aUT().Ke(this.jtT.code);
      }
    }
    label257:
    this.screen.removeAll();
    i = 0;
    if (i < this.jtU.size())
    {
      RcptItem localRcptItem;
      if ((this.jtU.get(i) != null) && (!bt.isNullOrNil(((RcptItem)this.jtU.get(i)).name)))
      {
        localObject = new RcptPreference(this);
        localRcptItem = (RcptItem)this.jtU.get(i);
        if ((localRcptItem != null) && (!bt.isNullOrNil(localRcptItem.name))) {
          break label377;
        }
        ad.e("MicroMsg.RcptPreference", "setZoneItem item = null");
      }
      for (;;)
      {
        this.screen.b((Preference)localObject);
        i += 1;
        break;
        label377:
        ((RcptPreference)localObject).setKey(localRcptItem.code + localObject.hashCode());
        ((RcptPreference)localObject).jtJ = localRcptItem;
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
    aVg();
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
      paramf = ((RcptPreference)paramPreference).jtJ;
      if ((paramf == null) || (bt.isNullOrNil(paramf.name)))
      {
        ad.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
        AppMethodBeat.o(21015);
        return false;
      }
      if (!paramf.jrO) {
        this.dAF = 2;
      }
      switch (this.dAF)
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
      paramf.putExtra("key_stage", this.dAF);
      paramf.putExtra("key_province", this.jtS);
      paramf.putExtra("key_city", this.jtT);
      if (-1 != i) {
        paramf.putExtra("ui_title", i);
      }
      startActivityForResult(paramf, 1);
      for (;;)
      {
        AppMethodBeat.o(21015);
        return false;
        this.jtS = paramf;
        this.dAF = 1;
        break;
        this.jtT = paramf;
        this.dAF = 2;
        break;
        paramPreference = new StringBuilder();
        if (this.jtS != null) {
          paramPreference.append(this.jtS.name).append(" ");
        }
        if (this.jtT != null) {
          paramPreference.append(this.jtT.name).append(" ");
        }
        paramPreference.append(paramf.name);
        ad.d("MicroMsg.MultiRptSelectUI", "area_result: " + paramPreference.toString() + ",item.name: " + paramf.name);
        Intent localIntent = new Intent();
        localIntent.putExtra("karea_result", paramPreference.toString());
        localIntent.putExtra("kpost_code", paramf.jrN);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI
 * JD-Core Version:    0.7.0.1
 */