package com.tencent.mm.plugin.account.security.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.protocal.protobuf.bur;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.protocal.protobuf.dqm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MySafeDeviceListUI
  extends MMPreference
  implements i, MStorage.IOnStorageChange
{
  private ProgressDialog gtM;
  private MMHandler handler;
  private int kjd;
  private List<SafeDeviceListPreference> kje;
  private a kjf;
  private List<d> kjg;
  private MenuItem.OnMenuItemClickListener kjh;
  private f screen;
  
  public MySafeDeviceListUI()
  {
    AppMethodBeat.i(125563);
    this.kjd = -2;
    this.gtM = null;
    this.kjh = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125554);
        MySafeDeviceListUI.a(MySafeDeviceListUI.this);
        AppMethodBeat.o(125554);
        return true;
      }
    };
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(125556);
        MySafeDeviceListUI.b(MySafeDeviceListUI.this).notifyDataSetChanged();
        super.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(125556);
      }
    };
    AppMethodBeat.o(125563);
  }
  
  private void boT()
  {
    AppMethodBeat.i(125569);
    this.kje.clear();
    this.kjg = com.tencent.mm.plugin.account.security.a.g.boR().boO();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2132017255);
    if (this.kjg.size() == 0)
    {
      this.screen.bmi("my_safe_device_list_tip");
      showOptionMenu(false);
      AppMethodBeat.o(125569);
      return;
    }
    if (this.kjd == 1)
    {
      addTextOptionMenu(0, getString(2131764842), this.kjh);
      this.kjd ^= 0xFFFFFFFF;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    Iterator localIterator = this.kjg.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      SafeDeviceListPreference localSafeDeviceListPreference = new SafeDeviceListPreference(this);
      localSafeDeviceListPreference.setKey("mysafedevice_" + locald.field_uid);
      localSafeDeviceListPreference.setTitle(com.tencent.mm.pluginsdk.ui.span.l.c(this, locald.field_name));
      localSafeDeviceListPreference.setSummary(localSimpleDateFormat.format(new Date(locald.field_createtime * 1000L)));
      localSafeDeviceListPreference.kjp = this.kjf;
      localSafeDeviceListPreference.kjq = this.kjf;
      localSafeDeviceListPreference.kjm = locald;
      this.screen.a(localSafeDeviceListPreference, -1);
      this.kje.add(localSafeDeviceListPreference);
    }
    showOptionMenu(true);
    AppMethodBeat.o(125569);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125568);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125559);
        MySafeDeviceListUI.this.finish();
        AppMethodBeat.o(125559);
        return true;
      }
    });
    this.screen = getPreferenceScreen();
    this.kje = new LinkedList();
    this.kjf = new a((byte)0);
    addTextOptionMenu(0, getString(2131764842), this.kjh);
    setMMTitle(2131765443);
    AppMethodBeat.o(125568);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125564);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.azz().a(850, this);
    com.tencent.mm.kernel.g.azz().a(361, this);
    com.tencent.mm.plugin.account.security.a.g.boR().add(this);
    initView();
    paramBundle = new b();
    com.tencent.mm.kernel.g.azz().a(paramBundle, 0);
    getString(2131755998);
    this.gtM = h.a(this, getString(2131756029), true, new MySafeDeviceListUI.2(this, paramBundle));
    AppMethodBeat.o(125564);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125565);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(850, this);
    com.tencent.mm.kernel.g.azz().b(361, this);
    com.tencent.mm.plugin.account.security.a.g.boR().remove(this);
    AppMethodBeat.o(125565);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(125570);
    Log.i("MicroMsg.MySafeDeviceListUI", "notify ".concat(String.valueOf(paramString)));
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125560);
        MySafeDeviceListUI.g(MySafeDeviceListUI.this);
        AppMethodBeat.o(125560);
      }
    });
    AppMethodBeat.o(125570);
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(125567);
    paramf = paramPreference.mKey;
    if (Util.isNullOrNil(paramf))
    {
      Log.e("MicroMsg.MySafeDeviceListUI", "null key");
      AppMethodBeat.o(125567);
      return false;
    }
    if (paramf.startsWith("mysafedevice_"))
    {
      paramf = (SafeDeviceListPreference)paramPreference;
      if (paramf != null)
      {
        paramf = paramf.kjm;
        h.a(getContext(), getString(2131764844), paramf.field_name, getString(2131764847), -1, new h.b()
        {
          public final boolean onFinish(final CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(125558);
            if (paramAnonymousCharSequence == null) {}
            for (paramAnonymousCharSequence = ""; paramAnonymousCharSequence.equals(paramf.field_name); paramAnonymousCharSequence = paramAnonymousCharSequence.toString().trim())
            {
              AppMethodBeat.o(125558);
              return true;
            }
            if (paramAnonymousCharSequence.length() <= 0)
            {
              h.cD(MySafeDeviceListUI.this.getContext(), MySafeDeviceListUI.this.getString(2131764843));
              AppMethodBeat.o(125558);
              return false;
            }
            paramAnonymousCharSequence = new c(paramf.field_uid, paramAnonymousCharSequence, paramf.field_devicetype);
            com.tencent.mm.kernel.g.azz().a(paramAnonymousCharSequence, 0);
            if (MySafeDeviceListUI.c(MySafeDeviceListUI.this) != null) {
              MySafeDeviceListUI.c(MySafeDeviceListUI.this).dismiss();
            }
            MySafeDeviceListUI.a(MySafeDeviceListUI.this, h.a(MySafeDeviceListUI.this, com.tencent.mm.cb.a.aI(MySafeDeviceListUI.this, 2131756029), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(125557);
                com.tencent.mm.kernel.g.azz().a(paramAnonymousCharSequence);
                AppMethodBeat.o(125557);
              }
            }));
            AppMethodBeat.o(125558);
            return true;
          }
        });
      }
    }
    AppMethodBeat.o(125567);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125566);
    super.onResume();
    boT();
    AppMethodBeat.o(125566);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Object localObject = null;
    AppMethodBeat.i(125571);
    Log.i("MicroMsg.MySafeDeviceListUI", "errorCode %d, errorMsg %s, scene %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramq });
    if ((this.gtM != null) && (this.gtM.isShowing()))
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (paramq.getType() == 850)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (b)paramq;
        paramString = localObject;
        if (paramq.kiN != null)
        {
          paramString = localObject;
          if (paramq.kiN.MaW != null)
          {
            paramString = localObject;
            if (paramq.kiN.MaW.MTs != null) {
              paramString = paramq.kiN.MaW.MTs;
            }
          }
        }
        if ((paramString != null) && (paramString != null))
        {
          com.tencent.mm.plugin.account.security.a.g.boR().execSQL("SafeDeviceInfo", "delete from SafeDeviceInfo");
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramq = (ckf)paramString.next();
            com.tencent.mm.plugin.account.security.a.g.boR().a(new d(paramq));
          }
        }
        AppMethodBeat.o(125571);
      }
    }
    else if (paramq.getType() == 361)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (c)paramq;
        paramq = new d();
        paramq.field_devicetype = paramString.dGP;
        paramq.field_name = paramString.deviceName;
        paramq.field_uid = paramString.dGL;
        paramq.field_createtime = 0L;
        com.tencent.mm.plugin.account.security.a.g.boR().update(paramq, new String[0]);
        h.cD(this, com.tencent.mm.cb.a.aI(this, 2131764848));
        AppMethodBeat.o(125571);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.jRu.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125571);
        return;
      }
    }
    AppMethodBeat.o(125571);
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
    
    public final void Tp(String paramString)
    {
      AppMethodBeat.i(125562);
      Log.e("MicroMsg.MySafeDeviceListUI", "delete safedevice failed".concat(String.valueOf(paramString)));
      AppMethodBeat.o(125562);
    }
    
    public final void onSucceed(String paramString)
    {
      AppMethodBeat.i(125561);
      MySafeDeviceListUI.b(MySafeDeviceListUI.this).bmi(paramString);
      MySafeDeviceListUI.d(MySafeDeviceListUI.this).sendEmptyMessage(0);
      MySafeDeviceListUI.this.addTextOptionMenu(0, MySafeDeviceListUI.this.getString(2131764842), MySafeDeviceListUI.e(MySafeDeviceListUI.this));
      MySafeDeviceListUI.a(MySafeDeviceListUI.this, MySafeDeviceListUI.f(MySafeDeviceListUI.this) ^ 0xFFFFFFFF);
      MySafeDeviceListUI.g(MySafeDeviceListUI.this);
      AppMethodBeat.o(125561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI
 * JD-Core Version:    0.7.0.1
 */