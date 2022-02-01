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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  implements com.tencent.mm.al.g, k.a
{
  private ProgressDialog fpP;
  private ap handler;
  private int ioS;
  private List<SafeDeviceListPreference> ioT;
  private a ioU;
  private List<d> ioV;
  private MenuItem.OnMenuItemClickListener ioW;
  private f screen;
  
  public MySafeDeviceListUI()
  {
    AppMethodBeat.i(125563);
    this.ioS = -2;
    this.fpP = null;
    this.ioW = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125554);
        MySafeDeviceListUI.a(MySafeDeviceListUI.this);
        AppMethodBeat.o(125554);
        return true;
      }
    };
    this.handler = new ap()
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
  
  private void aJF()
  {
    AppMethodBeat.i(125569);
    this.ioT.clear();
    this.ioV = com.tencent.mm.plugin.account.security.a.g.aJD().aJA();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951710);
    if (this.ioV.size() == 0)
    {
      this.screen.aKl("my_safe_device_list_tip");
      showOptionMenu(false);
      AppMethodBeat.o(125569);
      return;
    }
    if (this.ioS == 1)
    {
      addTextOptionMenu(0, getString(2131762757), this.ioW);
      this.ioS ^= 0xFFFFFFFF;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    Iterator localIterator = this.ioV.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      SafeDeviceListPreference localSafeDeviceListPreference = new SafeDeviceListPreference(this);
      localSafeDeviceListPreference.setKey("mysafedevice_" + locald.field_uid);
      localSafeDeviceListPreference.setTitle(com.tencent.mm.pluginsdk.ui.span.k.c(this, locald.field_name));
      localSafeDeviceListPreference.setSummary(localSimpleDateFormat.format(new Date(locald.field_createtime * 1000L)));
      localSafeDeviceListPreference.ipe = this.ioU;
      localSafeDeviceListPreference.ipf = this.ioU;
      localSafeDeviceListPreference.ipb = locald;
      this.screen.a(localSafeDeviceListPreference, -1);
      this.ioT.add(localSafeDeviceListPreference);
    }
    showOptionMenu(true);
    AppMethodBeat.o(125569);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(125570);
    ad.i("MicroMsg.MySafeDeviceListUI", "notify ".concat(String.valueOf(paramString)));
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
    this.ioT = new LinkedList();
    this.ioU = new a((byte)0);
    addTextOptionMenu(0, getString(2131762757), this.ioW);
    setMMTitle(2131763269);
    AppMethodBeat.o(125568);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125564);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(850, this);
    com.tencent.mm.kernel.g.aeS().a(361, this);
    com.tencent.mm.plugin.account.security.a.g.aJD().add(this);
    initView();
    paramBundle = new b();
    com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
    getString(2131755906);
    this.fpP = h.b(this, getString(2131755936), true, new MySafeDeviceListUI.2(this, paramBundle));
    AppMethodBeat.o(125564);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125565);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(850, this);
    com.tencent.mm.kernel.g.aeS().b(361, this);
    com.tencent.mm.plugin.account.security.a.g.aJD().remove(this);
    AppMethodBeat.o(125565);
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(125567);
    paramf = paramPreference.mKey;
    if (bt.isNullOrNil(paramf))
    {
      ad.e("MicroMsg.MySafeDeviceListUI", "null key");
      AppMethodBeat.o(125567);
      return false;
    }
    if (paramf.startsWith("mysafedevice_"))
    {
      paramf = (SafeDeviceListPreference)paramPreference;
      if (paramf != null)
      {
        paramf = paramf.ipb;
        h.a(getContext(), getString(2131762759), paramf.field_name, getString(2131762762), -1, new h.b()
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
              h.cf(MySafeDeviceListUI.this.getContext(), MySafeDeviceListUI.this.getString(2131762758));
              AppMethodBeat.o(125558);
              return false;
            }
            paramAnonymousCharSequence = new c(paramf.field_uid, paramAnonymousCharSequence, paramf.field_devicetype);
            com.tencent.mm.kernel.g.aeS().a(paramAnonymousCharSequence, 0);
            if (MySafeDeviceListUI.c(MySafeDeviceListUI.this) != null) {
              MySafeDeviceListUI.c(MySafeDeviceListUI.this).dismiss();
            }
            MySafeDeviceListUI.a(MySafeDeviceListUI.this, h.b(MySafeDeviceListUI.this, com.tencent.mm.cd.a.aq(MySafeDeviceListUI.this, 2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(125557);
                com.tencent.mm.kernel.g.aeS().a(paramAnonymousCharSequence);
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
    aJF();
    AppMethodBeat.o(125566);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject = null;
    AppMethodBeat.i(125571);
    ad.i("MicroMsg.MySafeDeviceListUI", "errorCode %d, errorMsg %s, scene %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramn });
    if ((this.fpP != null) && (this.fpP.isShowing()))
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if (paramn.getType() == 850)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (b)paramn;
        paramString = localObject;
        if (paramn.ioC != null)
        {
          paramString = localObject;
          if (paramn.ioC.Dyi != null)
          {
            paramString = localObject;
            if (paramn.ioC.Dyi.Ehr != null) {
              paramString = paramn.ioC.Dyi.Ehr;
            }
          }
        }
        if ((paramString != null) && (paramString != null))
        {
          com.tencent.mm.plugin.account.security.a.g.aJD().execSQL("SafeDeviceInfo", "delete from SafeDeviceInfo");
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramn = (bmu)paramString.next();
            com.tencent.mm.plugin.account.security.a.g.aJD().a(new d(paramn));
          }
        }
        AppMethodBeat.o(125571);
      }
    }
    else if (paramn.getType() == 361)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (c)paramn;
        paramn = new d();
        paramn.field_devicetype = paramString.dfF;
        paramn.field_name = paramString.deviceName;
        paramn.field_uid = paramString.cLR;
        paramn.field_createtime = 0L;
        com.tencent.mm.plugin.account.security.a.g.aJD().update(paramn, new String[0]);
        h.cf(this, com.tencent.mm.cd.a.aq(this, 2131762763));
        AppMethodBeat.o(125571);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.hYu.a(this, paramInt1, paramInt2, paramString))
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
    
    public final void CA(String paramString)
    {
      AppMethodBeat.i(125561);
      MySafeDeviceListUI.b(MySafeDeviceListUI.this).aKl(paramString);
      MySafeDeviceListUI.d(MySafeDeviceListUI.this).sendEmptyMessage(0);
      MySafeDeviceListUI.this.addTextOptionMenu(0, MySafeDeviceListUI.this.getString(2131762757), MySafeDeviceListUI.e(MySafeDeviceListUI.this));
      MySafeDeviceListUI.a(MySafeDeviceListUI.this, MySafeDeviceListUI.f(MySafeDeviceListUI.this) ^ 0xFFFFFFFF);
      MySafeDeviceListUI.g(MySafeDeviceListUI.this);
      AppMethodBeat.o(125561);
    }
    
    public final void onFailed(String paramString)
    {
      AppMethodBeat.i(125562);
      ad.e("MicroMsg.MySafeDeviceListUI", "delete safedevice failed".concat(String.valueOf(paramString)));
      AppMethodBeat.o(125562);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI
 * JD-Core Version:    0.7.0.1
 */