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
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MySafeDeviceListUI
  extends MMPreference
  implements com.tencent.mm.al.f, k.a
{
  private ProgressDialog fMu;
  private ap handler;
  private int jih;
  private List<SafeDeviceListPreference> jii;
  private a jij;
  private List<d> jik;
  private MenuItem.OnMenuItemClickListener jil;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public MySafeDeviceListUI()
  {
    AppMethodBeat.i(125563);
    this.jih = -2;
    this.fMu = null;
    this.jil = new MenuItem.OnMenuItemClickListener()
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
  
  private void aTI()
  {
    AppMethodBeat.i(125569);
    this.jii.clear();
    this.jik = com.tencent.mm.plugin.account.security.a.g.aTG().aTD();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951710);
    if (this.jik.size() == 0)
    {
      this.screen.aVE("my_safe_device_list_tip");
      showOptionMenu(false);
      AppMethodBeat.o(125569);
      return;
    }
    if (this.jih == 1)
    {
      addTextOptionMenu(0, getString(2131762757), this.jil);
      this.jih ^= 0xFFFFFFFF;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    Iterator localIterator = this.jik.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      SafeDeviceListPreference localSafeDeviceListPreference = new SafeDeviceListPreference(this);
      localSafeDeviceListPreference.setKey("mysafedevice_" + locald.field_uid);
      localSafeDeviceListPreference.setTitle(k.c(this, locald.field_name));
      localSafeDeviceListPreference.setSummary(localSimpleDateFormat.format(new Date(locald.field_createtime * 1000L)));
      localSafeDeviceListPreference.jit = this.jij;
      localSafeDeviceListPreference.jiu = this.jij;
      localSafeDeviceListPreference.jiq = locald;
      this.screen.a(localSafeDeviceListPreference, -1);
      this.jii.add(localSafeDeviceListPreference);
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
    this.jii = new LinkedList();
    this.jij = new a((byte)0);
    addTextOptionMenu(0, getString(2131762757), this.jil);
    setMMTitle(2131763269);
    AppMethodBeat.o(125568);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125564);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aiU().a(850, this);
    com.tencent.mm.kernel.g.aiU().a(361, this);
    com.tencent.mm.plugin.account.security.a.g.aTG().add(this);
    initView();
    paramBundle = new b();
    com.tencent.mm.kernel.g.aiU().a(paramBundle, 0);
    getString(2131755906);
    this.fMu = h.b(this, getString(2131755936), true, new MySafeDeviceListUI.2(this, paramBundle));
    AppMethodBeat.o(125564);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125565);
    super.onDestroy();
    com.tencent.mm.kernel.g.aiU().b(850, this);
    com.tencent.mm.kernel.g.aiU().b(361, this);
    com.tencent.mm.plugin.account.security.a.g.aTG().remove(this);
    AppMethodBeat.o(125565);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
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
        paramf = paramf.jiq;
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
              h.cl(MySafeDeviceListUI.this.getContext(), MySafeDeviceListUI.this.getString(2131762758));
              AppMethodBeat.o(125558);
              return false;
            }
            paramAnonymousCharSequence = new c(paramf.field_uid, paramAnonymousCharSequence, paramf.field_devicetype);
            com.tencent.mm.kernel.g.aiU().a(paramAnonymousCharSequence, 0);
            if (MySafeDeviceListUI.c(MySafeDeviceListUI.this) != null) {
              MySafeDeviceListUI.c(MySafeDeviceListUI.this).dismiss();
            }
            MySafeDeviceListUI.a(MySafeDeviceListUI.this, h.b(MySafeDeviceListUI.this, com.tencent.mm.cc.a.az(MySafeDeviceListUI.this, 2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(125557);
                com.tencent.mm.kernel.g.aiU().a(paramAnonymousCharSequence);
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
    aTI();
    AppMethodBeat.o(125566);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject = null;
    AppMethodBeat.i(125571);
    ad.i("MicroMsg.MySafeDeviceListUI", "errorCode %d, errorMsg %s, scene %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramn });
    if ((this.fMu != null) && (this.fMu.isShowing()))
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if (paramn.getType() == 850)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (b)paramn;
        paramString = localObject;
        if (paramn.jhR != null)
        {
          paramString = localObject;
          if (paramn.jhR.GCY != null)
          {
            paramString = localObject;
            if (paramn.jhR.GCY.HoF != null) {
              paramString = paramn.jhR.GCY.HoF;
            }
          }
        }
        if ((paramString != null) && (paramString != null))
        {
          com.tencent.mm.plugin.account.security.a.g.aTG().execSQL("SafeDeviceInfo", "delete from SafeDeviceInfo");
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramn = (bvx)paramString.next();
            com.tencent.mm.plugin.account.security.a.g.aTG().a(new d(paramn));
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
        paramn.field_devicetype = paramString.dow;
        paramn.field_name = paramString.deviceName;
        paramn.field_uid = paramString.cUi;
        paramn.field_createtime = 0L;
        com.tencent.mm.plugin.account.security.a.g.aTG().update(paramn, new String[0]);
        h.cl(this, com.tencent.mm.cc.a.az(this, 2131762763));
        AppMethodBeat.o(125571);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.iRH.a(this, paramInt1, paramInt2, paramString))
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
    
    public final void JS(String paramString)
    {
      AppMethodBeat.i(125561);
      MySafeDeviceListUI.b(MySafeDeviceListUI.this).aVE(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI
 * JD-Core Version:    0.7.0.1
 */