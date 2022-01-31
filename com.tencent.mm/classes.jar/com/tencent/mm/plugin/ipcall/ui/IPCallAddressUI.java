package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.d.g;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

public class IPCallAddressUI
  extends MMActivity
  implements f
{
  private ListView nRL;
  private e nRM;
  private int nRN;
  private boolean nRO;
  private boolean nRP;
  private boolean nRQ;
  private com.tencent.mm.sdk.b.c nRR;
  private Runnable nRS;
  private View nRz;
  
  public IPCallAddressUI()
  {
    AppMethodBeat.i(22055);
    this.nRM = null;
    this.nRN = 0;
    this.nRO = false;
    this.nRP = true;
    this.nRQ = false;
    this.nRR = new IPCallAddressUI.1(this);
    this.nRS = new IPCallAddressUI.3(this);
    AppMethodBeat.o(22055);
  }
  
  private void bKf()
  {
    AppMethodBeat.i(22057);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ab.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY() });
    if (bool) {
      com.tencent.mm.sdk.g.d.post(this.nRS, "IPCallAddressUI_LoadSystemAddressBook");
    }
    AppMethodBeat.o(22057);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969921;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(22062);
    if (this.nRN == 1)
    {
      com.tencent.mm.plugin.ipcall.b.gmO.p(new Intent(), this);
      AppMethodBeat.o(22062);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(22062);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22056);
    super.onCreate(paramBundle);
    aw.aaz();
    if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yAF, Boolean.FALSE)).booleanValue())
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yAF, Boolean.FALSE);
      paramBundle = new Intent();
      paramBundle.setClass(getContext(), IPCallAcitivityUI.class);
      getContext().startActivity(paramBundle);
      overridePendingTransition(2131034266, 2131034263);
      this.nRP = false;
    }
    setBackBtn(new IPCallAddressUI.2(this));
    if (this.nRP)
    {
      this.nRQ = true;
      bKf();
    }
    aw.aaz();
    this.nRO = ((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yAb, Boolean.TRUE)).booleanValue();
    setMMTitle(2131300847);
    this.nRL = ((ListView)findViewById(2131825168));
    this.nRz = findViewById(2131825169);
    this.nRM = new e(this, this.nRL, this.nRz);
    paramBundle = this.nRM;
    paramBundle.nRy = new h(paramBundle.nRA);
    ViewGroup localViewGroup = (ViewGroup)View.inflate(paramBundle.nRA, 2130969933, null);
    paramBundle.nRx.addHeaderView(localViewGroup, null, false);
    paramBundle.nRx.setAdapter(paramBundle.nRy);
    paramBundle.nRC = ((TextView)localViewGroup.findViewById(2131825253));
    paramBundle.nRD = ((TextView)localViewGroup.findViewById(2131825254));
    paramBundle.nRE = ((LinearLayout)localViewGroup.findViewById(2131825255));
    paramBundle.nRF = ((TextView)localViewGroup.findViewById(2131825257));
    paramBundle.nRG = ((ImageView)localViewGroup.findViewById(2131825256));
    localViewGroup.findViewById(2131825252).setOnClickListener(new e.1(paramBundle));
    localViewGroup.findViewById(2131825259).setOnClickListener(new e.2(paramBundle));
    localViewGroup.findViewById(2131825260).setOnClickListener(new e.3(paramBundle));
    paramBundle.nRx.setOnItemClickListener(new e.4(paramBundle));
    paramBundle.nRx.setOnItemLongClickListener(new e.5(paramBundle));
    aw.aaz();
    if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yAb, Boolean.TRUE)).booleanValue())
    {
      com.tencent.mm.plugin.ipcall.a.d.bJd().iy(true);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yAb, Boolean.FALSE);
      if (paramBundle.nRy.getCount() <= 0) {
        break label548;
      }
      paramBundle.nRz.setVisibility(8);
    }
    for (;;)
    {
      paramBundle.bKe();
      paramBundle.bKd();
      paramBundle.nRB = true;
      aw.Rc().a(257, this);
      a.ymk.c(this.nRR);
      this.nRN = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 0L, 1L, true);
      AppMethodBeat.o(22056);
      return;
      com.tencent.mm.plugin.ipcall.a.d.bJd().iy(false);
      break;
      label548:
      paramBundle.nRz.setVisibility(0);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(22061);
    ab.d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(22061);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22058);
    super.onDestroy();
    if (this.nRM != null)
    {
      Object localObject = this.nRM;
      ((e)localObject).nRx.setOnItemClickListener(null);
      ((e)localObject).nRx.setOnItemLongClickListener(null);
      localObject = ((e)localObject).nRy;
      o.acQ().b((d.a)localObject);
    }
    aw.Rc().b(257, this);
    a.ymk.d(this.nRR);
    AppMethodBeat.o(22058);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(22063);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(22063);
      return;
    }
    ab.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22063);
      return;
      if ((paramArrayOfInt[0] != 0) && (this.nRO))
      {
        this.nRO = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131302069), getString(2131302083), getString(2131300996), getString(2131297837), false, new IPCallAddressUI.4(this), new IPCallAddressUI.5(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22059);
    super.onResume();
    e locale;
    if (this.nRM != null)
    {
      locale = this.nRM;
      if ((locale.nRy != null) && (!locale.nRB))
      {
        locale.nRy.notifyDataSetChanged();
        if (locale.nRy.getCount() <= 0) {
          break label101;
        }
        locale.nRz.setVisibility(8);
      }
    }
    for (;;)
    {
      locale.nRB = false;
      supportInvalidateOptionsMenu();
      com.tencent.mm.plugin.ipcall.a.f.b.bJQ().iJ(true);
      if (!this.nRQ)
      {
        this.nRQ = true;
        bKf();
      }
      AppMethodBeat.o(22059);
      return;
      label101:
      locale.nRz.setVisibility(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(22060);
    if (((paramm instanceof g)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.nRM != null)) {
      this.nRM.bKe();
    }
    AppMethodBeat.o(22060);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI
 * JD-Core Version:    0.7.0.1
 */