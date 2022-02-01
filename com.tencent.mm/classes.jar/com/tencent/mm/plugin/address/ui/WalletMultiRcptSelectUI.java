package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
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
  private int fMU = 0;
  private RcptItem nmQ = null;
  private RcptItem nmR = null;
  private List<RcptItem> nnn;
  private f screen;
  
  private void bAV()
  {
    AppMethodBeat.i(21009);
    switch (this.fMU)
    {
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_stage", this.fMU);
      localIntent.putExtra("key_province", this.nmQ);
      localIntent.putExtra("key_city", this.nmR);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(21009);
      return;
      this.nmR = null;
      this.fMU = 1;
      continue;
      this.nmQ = null;
      this.fMU = 0;
    }
  }
  
  private void z(Intent paramIntent)
  {
    AppMethodBeat.i(21014);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
      AppMethodBeat.o(21014);
      return;
    }
    this.fMU = paramIntent.getIntExtra("key_stage", 0);
    this.nmQ = ((RcptItem)paramIntent.getParcelableExtra("key_province"));
    this.nmR = ((RcptItem)paramIntent.getParcelableExtra("key_city"));
    String str = paramIntent.getStringExtra("extra_province");
    if (str != null)
    {
      a.bAn();
      this.nmQ = a.bAp().abl(str);
      if (this.nmQ != null) {
        this.fMU = 1;
      }
    }
    paramIntent = paramIntent.getStringExtra("extra_city");
    if ((paramIntent != null) && (1 == this.fMU))
    {
      a.bAn();
      this.nmR = a.bAp().cj(this.nmQ.code, paramIntent);
      if (this.nmR != null) {
        this.fMU = 2;
      }
    }
    AppMethodBeat.o(21014);
  }
  
  public int getResourceId()
  {
    return R.o.eXN;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(21013);
    Object localObject = getIntent();
    int i = R.l.enQ;
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("ui_title", R.l.enQ);
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
    z((Intent)localObject);
    if (a.bAp().kc(0).isEmpty())
    {
      Log.e("MicroMsg.MultiRptSelectUI", "list == null || list.isEmpty(), need loadata!");
      a.bAp().bAr();
    }
    switch (this.fMU)
    {
    default: 
      a.bAn();
      localObject = a.bAp().kc(0);
    }
    for (;;)
    {
      this.nnn = ((List)localObject);
      if ((this.nnn != null) && (this.nnn.size() > 0)) {
        break label259;
      }
      Log.e("MicroMsg.MultiRptSelectUI", "initZoneItems error ,check zone lists!");
      AppMethodBeat.o(21013);
      return;
      a.bAn();
      localObject = a.bAp().kc(0);
      continue;
      if ((this.nmQ != null) && (!Util.isNullOrNil(this.nmQ.code)))
      {
        a.bAn();
        localObject = a.bAp().bkE(this.nmQ.code);
      }
      else
      {
        if ((this.nmR == null) || (Util.isNullOrNil(this.nmR.code))) {
          break;
        }
        a.bAn();
        localObject = a.bAp().bkE(this.nmR.code);
      }
    }
    label259:
    this.screen.removeAll();
    i = j;
    if (i < this.nnn.size())
    {
      RcptItem localRcptItem;
      if ((this.nnn.get(i) != null) && (!Util.isNullOrNil(((RcptItem)this.nnn.get(i)).name)))
      {
        localObject = new RcptPreference(this);
        localRcptItem = (RcptItem)this.nnn.get(i);
        if ((localRcptItem != null) && (!Util.isNullOrNil(localRcptItem.name))) {
          break label382;
        }
        Log.e("MicroMsg.RcptPreference", "setZoneItem item = null");
      }
      for (;;)
      {
        this.screen.b((Preference)localObject);
        i += 1;
        break;
        label382:
        ((RcptPreference)localObject).setKey(localRcptItem.code + localObject.hashCode());
        ((RcptPreference)localObject).nmF = localRcptItem;
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
      z(paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(21016);
    bAV();
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
      paramf = ((RcptPreference)paramPreference).nmF;
      if ((paramf == null) || (Util.isNullOrNil(paramf.name)))
      {
        Log.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
        AppMethodBeat.o(21015);
        return false;
      }
      if (paramf.type != RcptItem.nkE) {
        break label208;
      }
      i = 1;
      if (i == 0)
      {
        if (paramf.type != RcptItem.nkF) {
          break label213;
        }
        i = 1;
        label79:
        if (i == 0) {
          this.fMU = 2;
        }
      }
      switch (this.fMU)
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
      paramf.putExtra("key_stage", this.fMU);
      paramf.putExtra("key_province", this.nmQ);
      paramf.putExtra("key_city", this.nmR);
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
        this.nmQ = paramf;
        this.fMU = 1;
        break label120;
        this.nmR = paramf;
        this.fMU = 2;
        break label120;
        paramPreference = new StringBuilder();
        if (this.nmQ != null) {
          paramPreference.append(this.nmQ.name).append(" ");
        }
        if (this.nmR != null) {
          paramPreference.append(this.nmR.name).append(" ");
        }
        paramPreference.append(paramf.name);
        Log.d("MicroMsg.MultiRptSelectUI", "area_result: " + paramPreference.toString() + ",item.name: " + paramf.name);
        Intent localIntent = new Intent();
        localIntent.putExtra("karea_result", paramPreference.toString());
        localIntent.putExtra("kpost_code", paramf.nkC);
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