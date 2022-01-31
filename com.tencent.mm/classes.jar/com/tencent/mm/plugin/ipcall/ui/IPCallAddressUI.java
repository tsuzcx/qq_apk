package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.d.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class IPCallAddressUI
  extends MMActivity
  implements f
{
  private Runnable luA = new IPCallAddressUI.3(this);
  private View luh;
  private ListView lut;
  private e luu = null;
  private int luv = 0;
  private boolean luw = false;
  private boolean lux = true;
  private boolean luy = false;
  private com.tencent.mm.sdk.b.c luz = new IPCallAddressUI.1(this);
  
  private void bcV()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    y.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bk.csb() });
    if (bool) {
      com.tencent.mm.sdk.f.e.post(this.luA, "IPCallAddressUI_LoadSystemAddressBook");
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ip_call_address_ui;
  }
  
  public void onBackPressed()
  {
    if (this.luv == 1)
    {
      com.tencent.mm.plugin.ipcall.b.eUR.q(new Intent(), this);
      return;
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Hx();
    if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uqF, Boolean.valueOf(false))).booleanValue())
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uqF, Boolean.valueOf(false));
      paramBundle = new Intent();
      paramBundle.setClass(this.mController.uMN, IPCallAcitivityUI.class);
      this.mController.uMN.startActivity(paramBundle);
      overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
      this.lux = false;
    }
    setBackBtn(new IPCallAddressUI.2(this));
    if (this.lux)
    {
      this.luy = true;
      bcV();
    }
    au.Hx();
    this.luw = ((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uqb, Boolean.valueOf(true))).booleanValue();
    setMMTitle(R.l.ip_call_func_name);
    this.lut = ((ListView)findViewById(R.h.addres_list));
    this.luh = findViewById(R.h.address_ui_hint_ll);
    this.luu = new e(this, this.lut, this.luh);
    paramBundle = this.luu;
    paramBundle.lug = new h(paramBundle.lui);
    ViewGroup localViewGroup = (ViewGroup)View.inflate(paramBundle.lui, R.i.ipcall_address_header_item, null);
    paramBundle.luf.addHeaderView(localViewGroup, null, false);
    paramBundle.luf.setAdapter(paramBundle.lug);
    paramBundle.luk = ((TextView)localViewGroup.findViewById(R.h.account_balance_tv));
    paramBundle.lul = ((TextView)localViewGroup.findViewById(R.h.account_package_tv));
    paramBundle.lum = ((LinearLayout)localViewGroup.findViewById(R.h.account_activity_ll));
    paramBundle.lun = ((TextView)localViewGroup.findViewById(R.h.account_activity_tv));
    paramBundle.luo = ((ImageView)localViewGroup.findViewById(R.h.unread_iv));
    localViewGroup.findViewById(R.h.account_rl).setOnClickListener(new e.1(paramBundle));
    localViewGroup.findViewById(R.h.contact_rl).setOnClickListener(new e.2(paramBundle));
    localViewGroup.findViewById(R.h.dial_rl).setOnClickListener(new e.3(paramBundle));
    paramBundle.luf.setOnItemClickListener(new e.4(paramBundle));
    paramBundle.luf.setOnItemLongClickListener(new e.5(paramBundle));
    au.Hx();
    if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uqb, Boolean.valueOf(true))).booleanValue())
    {
      com.tencent.mm.plugin.ipcall.a.d.bbW().gP(true);
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uqb, Boolean.valueOf(false));
      if (paramBundle.lug.getCount() <= 0) {
        break label554;
      }
      paramBundle.luh.setVisibility(8);
    }
    for (;;)
    {
      paramBundle.bcU();
      paramBundle.bcT();
      paramBundle.luj = true;
      au.Dk().a(257, this);
      com.tencent.mm.sdk.b.a.udP.c(this.luz);
      this.luv = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
      com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 0L, 1L, true);
      return;
      com.tencent.mm.plugin.ipcall.a.d.bbW().gP(false);
      break;
      label554:
      paramBundle.luh.setVisibility(0);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    y.d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.luu != null)
    {
      Object localObject = this.luu;
      ((e)localObject).luf.setOnItemClickListener(null);
      ((e)localObject).luf.setOnItemLongClickListener(null);
      localObject = ((e)localObject).lug;
      o.JQ().b((d.a)localObject);
    }
    au.Dk().b(257, this);
    com.tencent.mm.sdk.b.a.udP.d(this.luz);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      if (paramArrayOfInt == null)
      {
        i = -1;
        y.w("MicroMsg.IPCallAddressUI", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bk.csb() });
      }
    }
    do
    {
      return;
      i = paramArrayOfInt.length;
      break;
      y.i("MicroMsg.IPCallAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramArrayOfInt[0] == 0) || (!this.luw));
    this.luw = false;
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_contacts_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new IPCallAddressUI.4(this), new IPCallAddressUI.5(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    e locale;
    if (this.luu != null)
    {
      locale = this.luu;
      if ((locale.lug != null) && (!locale.luj))
      {
        locale.lug.notifyDataSetChanged();
        if (locale.lug.getCount() <= 0) {
          break label89;
        }
        locale.luh.setVisibility(8);
      }
    }
    for (;;)
    {
      locale.luj = false;
      supportInvalidateOptionsMenu();
      com.tencent.mm.plugin.ipcall.a.f.b.bcJ().gZ(true);
      if (!this.luy)
      {
        this.luy = true;
        bcV();
      }
      return;
      label89:
      locale.luh.setVisibility(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if (((paramm instanceof g)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.luu != null)) {
      this.luu.bcU();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI
 * JD-Core Version:    0.7.0.1
 */