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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class WalletMultiRcptSelectUI
  extends MMPreference
{
  private int dTz = 0;
  private RcptItem kvb = null;
  private RcptItem kvc = null;
  private List<RcptItem> kvd;
  private f screen;
  
  private void bqr()
  {
    AppMethodBeat.i(21009);
    switch (this.dTz)
    {
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_stage", this.dTz);
      localIntent.putExtra("key_province", this.kvb);
      localIntent.putExtra("key_city", this.kvc);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(21009);
      return;
      this.kvc = null;
      this.dTz = 1;
      continue;
      this.kvb = null;
      this.dTz = 0;
    }
  }
  
  private void y(Intent paramIntent)
  {
    AppMethodBeat.i(21014);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
      AppMethodBeat.o(21014);
      return;
    }
    this.dTz = paramIntent.getIntExtra("key_stage", 0);
    this.kvb = ((RcptItem)paramIntent.getParcelableExtra("key_province"));
    this.kvc = ((RcptItem)paramIntent.getParcelableExtra("key_city"));
    String str = paramIntent.getStringExtra("extra_province");
    if (str != null)
    {
      a.bqb();
      this.kvb = a.bqd().TD(str);
      if (this.kvb != null) {
        this.dTz = 1;
      }
    }
    paramIntent = paramIntent.getStringExtra("extra_city");
    if ((paramIntent != null) && (1 == this.dTz))
    {
      a.bqb();
      this.kvc = a.bqd().cd(this.kvb.code, paramIntent);
      if (this.kvc != null) {
        this.dTz = 2;
      }
    }
    AppMethodBeat.o(21014);
  }
  
  public int getResourceId()
  {
    return 2132017254;
  }
  
  public void initView()
  {
    int i = 2131755260;
    AppMethodBeat.i(21013);
    Object localObject = getIntent();
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("ui_title", 2131755260);
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
    localObject = a.bqd().ksZ;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      Log.e("MicroMsg.MultiRptSelectUI", "list == null || list.isEmpty(), need loadata!");
      a.bqd().bqe();
    }
    switch (this.dTz)
    {
    default: 
      a.bqb();
      localObject = a.bqd().ksZ;
    }
    for (;;)
    {
      this.kvd = ((List)localObject);
      if ((this.kvd != null) && (this.kvd.size() > 0)) {
        break label257;
      }
      Log.e("MicroMsg.MultiRptSelectUI", "initZoneItems error ,check zone lists!");
      AppMethodBeat.o(21013);
      return;
      a.bqb();
      localObject = a.bqd().ksZ;
      continue;
      if ((this.kvb != null) && (!Util.isNullOrNil(this.kvb.code)))
      {
        a.bqb();
        localObject = a.bqd().TB(this.kvb.code);
      }
      else
      {
        if ((this.kvc == null) || (Util.isNullOrNil(this.kvc.code))) {
          break;
        }
        a.bqb();
        localObject = a.bqd().TC(this.kvc.code);
      }
    }
    label257:
    this.screen.removeAll();
    i = 0;
    if (i < this.kvd.size())
    {
      RcptItem localRcptItem;
      if ((this.kvd.get(i) != null) && (!Util.isNullOrNil(((RcptItem)this.kvd.get(i)).name)))
      {
        localObject = new RcptPreference(this);
        localRcptItem = (RcptItem)this.kvd.get(i);
        if ((localRcptItem != null) && (!Util.isNullOrNil(localRcptItem.name))) {
          break label377;
        }
        Log.e("MicroMsg.RcptPreference", "setZoneItem item = null");
      }
      for (;;)
      {
        this.screen.c((Preference)localObject);
        i += 1;
        break;
        label377:
        ((RcptPreference)localObject).setKey(localRcptItem.code + localObject.hashCode());
        ((RcptPreference)localObject).kuR = localRcptItem;
      }
    }
    localObject = new PreferenceSmallCategory(this);
    this.screen.c((Preference)localObject);
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
    bqr();
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
      paramf = ((RcptPreference)paramPreference).kuR;
      if ((paramf == null) || (Util.isNullOrNil(paramf.name)))
      {
        Log.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
        AppMethodBeat.o(21015);
        return false;
      }
      if (!paramf.ksW) {
        this.dTz = 2;
      }
      switch (this.dTz)
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
      paramf.putExtra("key_stage", this.dTz);
      paramf.putExtra("key_province", this.kvb);
      paramf.putExtra("key_city", this.kvc);
      if (-1 != i) {
        paramf.putExtra("ui_title", i);
      }
      startActivityForResult(paramf, 1);
      for (;;)
      {
        AppMethodBeat.o(21015);
        return false;
        this.kvb = paramf;
        this.dTz = 1;
        break;
        this.kvc = paramf;
        this.dTz = 2;
        break;
        paramPreference = new StringBuilder();
        if (this.kvb != null) {
          paramPreference.append(this.kvb.name).append(" ");
        }
        if (this.kvc != null) {
          paramPreference.append(this.kvc.name).append(" ");
        }
        paramPreference.append(paramf.name);
        Log.d("MicroMsg.MultiRptSelectUI", "area_result: " + paramPreference.toString() + ",item.name: " + paramf.name);
        Intent localIntent = new Intent();
        localIntent.putExtra("karea_result", paramPreference.toString());
        localIntent.putExtra("kpost_code", paramf.ksV);
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