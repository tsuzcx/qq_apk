package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.akc;
import com.tencent.mm.protocal.c.auo;
import com.tencent.mm.protocal.c.bmp;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MySafeDeviceListUI
  extends MMPreference
  implements com.tencent.mm.ah.f, j.a
{
  private ProgressDialog dnm = null;
  private com.tencent.mm.ui.base.preference.f dnn;
  private int fkh = -2;
  private List<SafeDeviceListPreference> fki;
  private a fkj;
  private List<d> fkk;
  private MenuItem.OnMenuItemClickListener fkl = new MySafeDeviceListUI.1(this);
  private ah handler = new MySafeDeviceListUI.3(this);
  
  private void XD()
  {
    this.fki.clear();
    this.fkk = com.tencent.mm.plugin.account.security.a.g.XB().Xy();
    this.dnn.removeAll();
    this.dnn.addPreferencesFromResource(a.e.safe_device_list_pref);
    if (this.fkk.size() == 0)
    {
      this.dnn.ade("my_safe_device_list_tip");
      showOptionMenu(false);
      return;
    }
    if (this.fkh == 1)
    {
      addTextOptionMenu(0, getString(a.d.safe_device_edit), this.fkl);
      this.fkh ^= 0xFFFFFFFF;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    Iterator localIterator = this.fkk.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      SafeDeviceListPreference localSafeDeviceListPreference = new SafeDeviceListPreference(this);
      localSafeDeviceListPreference.setKey("mysafedevice_" + locald.field_uid);
      localSafeDeviceListPreference.setTitle(j.b(this, locald.field_name));
      localSafeDeviceListPreference.setSummary(localSimpleDateFormat.format(new Date(locald.field_createtime * 1000L)));
      localSafeDeviceListPreference.fkt = this.fkj;
      localSafeDeviceListPreference.fku = this.fkj;
      localSafeDeviceListPreference.fkq = locald;
      this.dnn.a(localSafeDeviceListPreference, -1);
      this.fki.add(localSafeDeviceListPreference);
    }
    showOptionMenu(true);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    y.i("MicroMsg.MySafeDeviceListUI", "notify " + paramString);
    this.handler.post(new MySafeDeviceListUI.6(this));
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if (bk.bl(paramf))
    {
      y.e("MicroMsg.MySafeDeviceListUI", "null key");
      return false;
    }
    if (paramf.startsWith("mysafedevice_"))
    {
      paramf = (SafeDeviceListPreference)paramPreference;
      if (paramf != null)
      {
        paramf = paramf.fkq;
        h.a(this.mController.uMN, getString(a.d.safe_device_edit_title), paramf.field_name, getString(a.d.safe_device_mod_name_hint), -1, new MySafeDeviceListUI.4(this, paramf));
      }
    }
    return true;
  }
  
  protected final void initView()
  {
    setBackBtn(new MySafeDeviceListUI.5(this));
    this.dnn = this.vdd;
    this.fki = new LinkedList();
    this.fkj = new a((byte)0);
    addTextOptionMenu(0, getString(a.d.safe_device_edit), this.fkl);
    setMMTitle(a.d.settings_manage_login_device);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Dk().a(850, this);
    com.tencent.mm.kernel.g.Dk().a(361, this);
    com.tencent.mm.plugin.account.security.a.g.XB().c(this);
    initView();
    paramBundle = new b();
    com.tencent.mm.kernel.g.Dk().a(paramBundle, 0);
    getString(a.d.app_tip);
    this.dnm = h.b(this, getString(a.d.app_waiting), true, new MySafeDeviceListUI.2(this, paramBundle));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.kernel.g.Dk().b(850, this);
    com.tencent.mm.kernel.g.Dk().b(361, this);
    com.tencent.mm.plugin.account.security.a.g.XB().d(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    XD();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    Object localObject = null;
    y.i("MicroMsg.MySafeDeviceListUI", "errorCode %d, errorMsg %s, scene %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramm });
    if ((this.dnm != null) && (this.dnm.isShowing()))
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (paramm.getType() == 850)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = (b)paramm;
        paramString = localObject;
        if (paramm.fjR != null)
        {
          paramString = localObject;
          if (paramm.fjR.tgG != null)
          {
            paramString = localObject;
            if (paramm.fjR.tgG.tFS != null) {
              paramString = paramm.fjR.tgG.tFS;
            }
          }
        }
        if ((paramString != null) && (paramString != null))
        {
          com.tencent.mm.plugin.account.security.a.g.XB().gk("SafeDeviceInfo", "delete from SafeDeviceInfo");
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramm = (auo)paramString.next();
            com.tencent.mm.plugin.account.security.a.g.XB().a(new d(paramm));
          }
        }
      }
    }
    else if (paramm.getType() == 361)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label300;
      }
      paramString = (c)paramm;
      paramm = new d();
      paramm.field_devicetype = paramString.bJp;
      paramm.field_name = paramString.deviceName;
      paramm.field_uid = paramString.bwK;
      paramm.field_createtime = 0L;
      com.tencent.mm.plugin.account.security.a.g.XB().c(paramm, new String[0]);
      h.bC(this, com.tencent.mm.cb.a.ac(this, a.d.safe_device_mod_name_ok));
    }
    label300:
    while (!com.tencent.mm.plugin.account.a.a.eUS.a(this, paramInt1, paramInt2, paramString)) {
      return;
    }
  }
  
  public final int xj()
  {
    return -1;
  }
  
  private final class a
    implements SafeDeviceListPreference.a, SafeDeviceListPreference.b
  {
    private a() {}
    
    public final void onFailed(String paramString)
    {
      y.e("MicroMsg.MySafeDeviceListUI", "delete safedevice failed" + paramString);
    }
    
    public final void pY(String paramString)
    {
      MySafeDeviceListUI.b(MySafeDeviceListUI.this).ade(paramString);
      MySafeDeviceListUI.d(MySafeDeviceListUI.this).sendEmptyMessage(0);
      MySafeDeviceListUI.this.addTextOptionMenu(0, MySafeDeviceListUI.this.getString(a.d.safe_device_edit), MySafeDeviceListUI.e(MySafeDeviceListUI.this));
      MySafeDeviceListUI.a(MySafeDeviceListUI.this, MySafeDeviceListUI.f(MySafeDeviceListUI.this) ^ 0xFFFFFFFF);
      MySafeDeviceListUI.g(MySafeDeviceListUI.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI
 * JD-Core Version:    0.7.0.1
 */