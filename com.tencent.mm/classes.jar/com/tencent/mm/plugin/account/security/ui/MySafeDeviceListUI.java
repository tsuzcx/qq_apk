package com.tencent.mm.plugin.account.security.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bwg;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MySafeDeviceListUI
  extends MMPreference
  implements com.tencent.mm.ai.f, k.a
{
  private ProgressDialog eeN;
  private a gBA;
  private List<d> gBB;
  private MenuItem.OnMenuItemClickListener gBC;
  private int gBy;
  private List<SafeDeviceListPreference> gBz;
  private ak handler;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public MySafeDeviceListUI()
  {
    AppMethodBeat.i(69881);
    this.gBy = -2;
    this.eeN = null;
    this.gBC = new MySafeDeviceListUI.1(this);
    this.handler = new MySafeDeviceListUI.3(this);
    AppMethodBeat.o(69881);
  }
  
  private void arf()
  {
    AppMethodBeat.i(69887);
    this.gBz.clear();
    this.gBB = com.tencent.mm.plugin.account.security.a.g.ard().ara();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131165267);
    if (this.gBB.size() == 0)
    {
      this.screen.aty("my_safe_device_list_tip");
      showOptionMenu(false);
      AppMethodBeat.o(69887);
      return;
    }
    if (this.gBy == 1)
    {
      addTextOptionMenu(0, getString(2131302845), this.gBC);
      this.gBy ^= 0xFFFFFFFF;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    Iterator localIterator = this.gBB.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      SafeDeviceListPreference localSafeDeviceListPreference = new SafeDeviceListPreference(this);
      localSafeDeviceListPreference.setKey("mysafedevice_" + locald.field_uid);
      localSafeDeviceListPreference.setTitle(j.b(this, locald.field_name));
      localSafeDeviceListPreference.setSummary(localSimpleDateFormat.format(new Date(locald.field_createtime * 1000L)));
      localSafeDeviceListPreference.gBK = this.gBA;
      localSafeDeviceListPreference.gBL = this.gBA;
      localSafeDeviceListPreference.gBH = locald;
      this.screen.a(localSafeDeviceListPreference, -1);
      this.gBz.add(localSafeDeviceListPreference);
    }
    showOptionMenu(true);
    AppMethodBeat.o(69887);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(69888);
    ab.i("MicroMsg.MySafeDeviceListUI", "notify ".concat(String.valueOf(paramString)));
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69878);
        MySafeDeviceListUI.g(MySafeDeviceListUI.this);
        AppMethodBeat.o(69878);
      }
    });
    AppMethodBeat.o(69888);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69886);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(69877);
        MySafeDeviceListUI.this.finish();
        AppMethodBeat.o(69877);
        return true;
      }
    });
    this.screen = getPreferenceScreen();
    this.gBz = new LinkedList();
    this.gBA = new a((byte)0);
    addTextOptionMenu(0, getString(2131302845), this.gBC);
    setMMTitle(2131303300);
    AppMethodBeat.o(69886);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69882);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Rc().a(850, this);
    com.tencent.mm.kernel.g.Rc().a(361, this);
    com.tencent.mm.plugin.account.security.a.g.ard().add(this);
    initView();
    paramBundle = new b();
    com.tencent.mm.kernel.g.Rc().a(paramBundle, 0);
    getString(2131297087);
    this.eeN = h.b(this, getString(2131297112), true, new MySafeDeviceListUI.2(this, paramBundle));
    AppMethodBeat.o(69882);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69883);
    super.onDestroy();
    com.tencent.mm.kernel.g.Rc().b(850, this);
    com.tencent.mm.kernel.g.Rc().b(361, this);
    com.tencent.mm.plugin.account.security.a.g.ard().remove(this);
    AppMethodBeat.o(69883);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69885);
    paramf = paramPreference.mKey;
    if (bo.isNullOrNil(paramf))
    {
      ab.e("MicroMsg.MySafeDeviceListUI", "null key");
      AppMethodBeat.o(69885);
      return false;
    }
    if (paramf.startsWith("mysafedevice_"))
    {
      paramf = (SafeDeviceListPreference)paramPreference;
      if (paramf != null)
      {
        paramf = paramf.gBH;
        h.a(getContext(), getString(2131302847), paramf.field_name, getString(2131302850), -1, new MySafeDeviceListUI.4(this, paramf));
      }
    }
    AppMethodBeat.o(69885);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69884);
    super.onResume();
    arf();
    AppMethodBeat.o(69884);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    Object localObject = null;
    AppMethodBeat.i(69889);
    ab.i("MicroMsg.MySafeDeviceListUI", "errorCode %d, errorMsg %s, scene %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramm });
    if ((this.eeN != null) && (this.eeN.isShowing()))
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (paramm.getType() == 850)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = (b)paramm;
        paramString = localObject;
        if (paramm.gBi != null)
        {
          paramString = localObject;
          if (paramm.gBi.xfo != null)
          {
            paramString = localObject;
            if (paramm.gBi.xfo.xJI != null) {
              paramString = paramm.gBi.xfo.xJI;
            }
          }
        }
        if ((paramString != null) && (paramString != null))
        {
          com.tencent.mm.plugin.account.security.a.g.ard().execSQL("SafeDeviceInfo", "delete from SafeDeviceInfo");
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramm = (baw)paramString.next();
            com.tencent.mm.plugin.account.security.a.g.ard().a(new d(paramm));
          }
        }
        AppMethodBeat.o(69889);
      }
    }
    else if (paramm.getType() == 361)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (c)paramm;
        paramm = new d();
        paramm.field_devicetype = paramString.cqJ;
        paramm.field_name = paramString.deviceName;
        paramm.field_uid = paramString.bYu;
        paramm.field_createtime = 0L;
        com.tencent.mm.plugin.account.security.a.g.ard().update(paramm, new String[0]);
        h.bO(this, com.tencent.mm.cb.a.aq(this, 2131302851));
        AppMethodBeat.o(69889);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.gmP.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(69889);
        return;
      }
    }
    AppMethodBeat.o(69889);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements SafeDeviceListPreference.a, SafeDeviceListPreference.b
  {
    private a() {}
    
    public final void onFailed(String paramString)
    {
      AppMethodBeat.i(69880);
      ab.e("MicroMsg.MySafeDeviceListUI", "delete safedevice failed".concat(String.valueOf(paramString)));
      AppMethodBeat.o(69880);
    }
    
    public final void xu(String paramString)
    {
      AppMethodBeat.i(69879);
      MySafeDeviceListUI.b(MySafeDeviceListUI.this).aty(paramString);
      MySafeDeviceListUI.d(MySafeDeviceListUI.this).sendEmptyMessage(0);
      MySafeDeviceListUI.this.addTextOptionMenu(0, MySafeDeviceListUI.this.getString(2131302845), MySafeDeviceListUI.e(MySafeDeviceListUI.this));
      MySafeDeviceListUI.a(MySafeDeviceListUI.this, MySafeDeviceListUI.f(MySafeDeviceListUI.this) ^ 0xFFFFFFFF);
      MySafeDeviceListUI.g(MySafeDeviceListUI.this);
      AppMethodBeat.o(69879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI
 * JD-Core Version:    0.7.0.1
 */