package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.j;
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
  private int hSE = 0;
  private RcptItem qkt = null;
  private RcptItem qku = null;
  private List<RcptItem> qkv;
  private f screen;
  
  private void B(Intent paramIntent)
  {
    AppMethodBeat.i(21014);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
      AppMethodBeat.o(21014);
      return;
    }
    this.hSE = paramIntent.getIntExtra("key_stage", 0);
    this.qkt = ((RcptItem)paramIntent.getParcelableExtra("key_province"));
    this.qku = ((RcptItem)paramIntent.getParcelableExtra("key_city"));
    String str = paramIntent.getStringExtra("extra_province");
    if (str != null)
    {
      a.bZe();
      this.qkt = a.bZg().TC(str);
      if (this.qkt != null) {
        this.hSE = 1;
      }
    }
    paramIntent = paramIntent.getStringExtra("extra_city");
    if ((paramIntent != null) && (1 == this.hSE))
    {
      a.bZe();
      this.qku = a.bZg().cx(this.qkt.code, paramIntent);
      if (this.qku != null) {
        this.hSE = 2;
      }
    }
    AppMethodBeat.o(21014);
  }
  
  private void bZG()
  {
    AppMethodBeat.i(21009);
    switch (this.hSE)
    {
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_stage", this.hSE);
      localIntent.putExtra("key_province", this.qkt);
      localIntent.putExtra("key_city", this.qku);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(21009);
      return;
      this.qku = null;
      this.hSE = 1;
      continue;
      this.qkt = null;
      this.hSE = 0;
    }
  }
  
  public int getResourceId()
  {
    return R.o.hbo;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(21013);
    Object localObject = getIntent();
    int i = R.l.gqQ;
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("ui_title", R.l.gqQ);
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
    B((Intent)localObject);
    localObject = a.bZg().yA(0);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      Log.e("MicroMsg.MultiRptSelectUI", "list == null || list.isEmpty(), need loadata!");
      a.bZg().bZi();
    }
    switch (this.hSE)
    {
    default: 
      a.bZe();
      localObject = a.bZg().yA(0);
    }
    for (;;)
    {
      this.qkv = ((List)localObject);
      if ((this.qkv != null) && (this.qkv.size() > 0)) {
        break label263;
      }
      Log.e("MicroMsg.MultiRptSelectUI", "initZoneItems error ,check zone lists!");
      AppMethodBeat.o(21013);
      return;
      a.bZe();
      localObject = a.bZg().yA(0);
      continue;
      if ((this.qkt != null) && (!Util.isNullOrNil(this.qkt.code)))
      {
        a.bZe();
        localObject = a.bZg().TB(this.qkt.code);
      }
      else
      {
        if ((this.qku == null) || (Util.isNullOrNil(this.qku.code))) {
          break;
        }
        a.bZe();
        localObject = a.bZg().TB(this.qku.code);
      }
    }
    label263:
    this.screen.removeAll();
    i = j;
    if (i < this.qkv.size())
    {
      RcptItem localRcptItem;
      if ((this.qkv.get(i) != null) && (!Util.isNullOrNil(((RcptItem)this.qkv.get(i)).name)))
      {
        localObject = new RcptPreference(this);
        localRcptItem = (RcptItem)this.qkv.get(i);
        if ((localRcptItem != null) && (!Util.isNullOrNil(localRcptItem.name))) {
          break label386;
        }
        Log.e("MicroMsg.RcptPreference", "setZoneItem item = null");
      }
      for (;;)
      {
        this.screen.c((Preference)localObject);
        i += 1;
        break;
        label386:
        ((RcptPreference)localObject).setKey(localRcptItem.code + localObject.hashCode());
        ((RcptPreference)localObject).qjO = localRcptItem;
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
      B(paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(21016);
    bZG();
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
      paramf = ((RcptPreference)paramPreference).qjO;
      if ((paramf == null) || (Util.isNullOrNil(paramf.name)))
      {
        Log.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
        AppMethodBeat.o(21015);
        return false;
      }
      if (paramf.type != RcptItem.qhN) {
        break label208;
      }
      i = 1;
      if (i == 0)
      {
        if (paramf.type != RcptItem.qhO) {
          break label213;
        }
        i = 1;
        label79:
        if (i == 0) {
          this.hSE = 2;
        }
      }
      switch (this.hSE)
      {
      default: 
        label120:
        paramf = getIntent();
        if (paramf == null) {
          break;
        }
      }
    }
    for (int i = paramf.getIntExtra("ui_title", -1);; i = -1)
    {
      paramf = new Intent(this, WalletMultiRcptSelectUI.class);
      paramf.putExtra("key_stage", this.hSE);
      paramf.putExtra("key_province", this.qkt);
      paramf.putExtra("key_city", this.qku);
      if (-1 != i) {
        paramf.putExtra("ui_title", i);
      }
      startActivityForResult(paramf, 1);
      for (;;)
      {
        AppMethodBeat.o(21015);
        return false;
        label208:
        i = 0;
        break;
        label213:
        i = 0;
        break label79;
        this.qkt = paramf;
        this.hSE = 1;
        break label120;
        this.qku = paramf;
        this.hSE = 2;
        break label120;
        paramPreference = new StringBuilder();
        if (this.qkt != null) {
          paramPreference.append(this.qkt.name).append(" ");
        }
        if (this.qku != null) {
          paramPreference.append(this.qku.name).append(" ");
        }
        paramPreference.append(paramf.name);
        Log.d("MicroMsg.MultiRptSelectUI", "area_result: " + paramPreference.toString() + ",item.name: " + paramf.name);
        Intent localIntent = new Intent();
        localIntent.putExtra("karea_result", paramPreference.toString());
        localIntent.putExtra("kpost_code", paramf.qhL);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI
 * JD-Core Version:    0.7.0.1
 */