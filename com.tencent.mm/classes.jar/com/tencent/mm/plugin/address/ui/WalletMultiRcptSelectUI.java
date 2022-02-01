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
  private int drg = 0;
  private RcptItem iAI = null;
  private RcptItem iAJ = null;
  private List<RcptItem> iAK;
  private f screen;
  
  private void aLd()
  {
    AppMethodBeat.i(21009);
    switch (this.drg)
    {
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_stage", this.drg);
      localIntent.putExtra("key_province", this.iAI);
      localIntent.putExtra("key_city", this.iAJ);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(21009);
      return;
      this.iAJ = null;
      this.drg = 1;
      continue;
      this.iAI = null;
      this.drg = 0;
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
    this.drg = paramIntent.getIntExtra("key_stage", 0);
    this.iAI = ((RcptItem)paramIntent.getParcelableExtra("key_province"));
    this.iAJ = ((RcptItem)paramIntent.getParcelableExtra("key_city"));
    String str = paramIntent.getStringExtra("extra_province");
    if (str != null)
    {
      a.aKO();
      this.iAI = a.aKQ().CN(str);
      if (this.iAI != null) {
        this.drg = 1;
      }
    }
    paramIntent = paramIntent.getStringExtra("extra_city");
    if ((paramIntent != null) && (1 == this.drg))
    {
      a.aKO();
      this.iAJ = a.aKQ().bK(this.iAI.code, paramIntent);
      if (this.iAJ != null) {
        this.drg = 2;
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
    localObject = a.aKQ().iyF;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ad.e("MicroMsg.MultiRptSelectUI", "list == null || list.isEmpty(), need loadata!");
      a.aKQ().aKR();
    }
    switch (this.drg)
    {
    default: 
      a.aKO();
      localObject = a.aKQ().iyF;
    }
    for (;;)
    {
      this.iAK = ((List)localObject);
      if ((this.iAK != null) && (this.iAK.size() > 0)) {
        break label257;
      }
      ad.e("MicroMsg.MultiRptSelectUI", "initZoneItems error ,check zone lists!");
      AppMethodBeat.o(21013);
      return;
      a.aKO();
      localObject = a.aKQ().iyF;
      continue;
      if ((this.iAI != null) && (!bt.isNullOrNil(this.iAI.code)))
      {
        a.aKO();
        localObject = a.aKQ().CL(this.iAI.code);
      }
      else
      {
        if ((this.iAJ == null) || (bt.isNullOrNil(this.iAJ.code))) {
          break;
        }
        a.aKO();
        localObject = a.aKQ().CM(this.iAJ.code);
      }
    }
    label257:
    this.screen.removeAll();
    i = 0;
    if (i < this.iAK.size())
    {
      RcptItem localRcptItem;
      if ((this.iAK.get(i) != null) && (!bt.isNullOrNil(((RcptItem)this.iAK.get(i)).name)))
      {
        localObject = new RcptPreference(this);
        localRcptItem = (RcptItem)this.iAK.get(i);
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
        ((RcptPreference)localObject).iAz = localRcptItem;
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
    aLd();
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
      paramf = ((RcptPreference)paramPreference).iAz;
      if ((paramf == null) || (bt.isNullOrNil(paramf.name)))
      {
        ad.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
        AppMethodBeat.o(21015);
        return false;
      }
      if (!paramf.iyC) {
        this.drg = 2;
      }
      switch (this.drg)
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
      paramf.putExtra("key_stage", this.drg);
      paramf.putExtra("key_province", this.iAI);
      paramf.putExtra("key_city", this.iAJ);
      if (-1 != i) {
        paramf.putExtra("ui_title", i);
      }
      startActivityForResult(paramf, 1);
      for (;;)
      {
        AppMethodBeat.o(21015);
        return false;
        this.iAI = paramf;
        this.drg = 1;
        break;
        this.iAJ = paramf;
        this.drg = 2;
        break;
        paramPreference = new StringBuilder();
        if (this.iAI != null) {
          paramPreference.append(this.iAI.name).append(" ");
        }
        if (this.iAJ != null) {
          paramPreference.append(this.iAJ.name).append(" ");
        }
        paramPreference.append(paramf.name);
        ad.d("MicroMsg.MultiRptSelectUI", "area_result: " + paramPreference.toString() + ",item.name: " + paramf.name);
        Intent localIntent = new Intent();
        localIntent.putExtra("karea_result", paramPreference.toString());
        localIntent.putExtra("kpost_code", paramf.iyB);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI
 * JD-Core Version:    0.7.0.1
 */