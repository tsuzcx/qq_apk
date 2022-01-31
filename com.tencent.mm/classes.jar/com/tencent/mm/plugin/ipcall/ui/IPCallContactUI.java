package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.n;
import java.util.ArrayList;
import java.util.HashMap;

public class IPCallContactUI
  extends MMActivity
{
  private ah dPi = new IPCallContactUI.2(this, Looper.getMainLooper());
  private n drn = new n((byte)0);
  private String feq;
  private Runnable luA = new IPCallContactUI.8(this);
  private ProgressDialog luI = null;
  private c luJ;
  private RelativeLayout luK;
  private LinearLayout luL;
  private IPCallAddressCountView luM = null;
  private VerticalScrollBar luN;
  private LinearLayout luO;
  private int luP = -1;
  private int luQ = -1;
  private a.a luR = new IPCallContactUI.7(this);
  private Runnable luS = new Runnable()
  {
    public final void run()
    {
      if ((IPCallContactUI.d(IPCallContactUI.this) != null) && (IPCallContactUI.b(IPCallContactUI.this) != null) && (!IPCallContactUI.d(IPCallContactUI.this).idd))
      {
        IPCallContactUI.d(IPCallContactUI.this).pA(IPCallContactUI.h(IPCallContactUI.this));
        IPCallContactUI.f(IPCallContactUI.this).sendEmptyMessage(2);
        IPCallContactUI.b(IPCallContactUI.this).invalidateViews();
      }
    }
  };
  private boolean luT = true;
  private ListView lut;
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ip_call_contact_ui;
  }
  
  public final void ha(boolean paramBoolean)
  {
    this.luT = paramBoolean;
    if (this.luT) {
      this.luJ.notifyDataSetChanged();
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.ip_call_address_list);
    setBackBtn(new IPCallContactUI.1(this));
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    y.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bk.csb() });
    if (bool)
    {
      this.luK = ((RelativeLayout)findViewById(R.h.layout));
      this.luL = ((LinearLayout)findViewById(R.h.address_ui_shadow));
      this.lut = ((ListView)findViewById(R.h.addres_list));
      this.luN = ((VerticalScrollBar)findViewById(R.h.address_scrollbar));
      this.luO = ((LinearLayout)findViewById(R.h.address_ui_hint_ll));
      this.drn.weq = new IPCallContactUI.5(this);
      this.drn.wev = R.l.app_search;
      a(this.drn);
      this.luJ = new c(this.mController.uMN);
      c.lsH = b.bcL();
      this.luM = new IPCallAddressCountView(this.mController.uMN, this.luJ.bcR());
      this.lut.addFooterView(this.luM, null, false);
      this.lut.setAdapter(this.luJ);
      this.lut.setOnItemClickListener(new IPCallContactUI.6(this));
      this.luN.setVisibility(0);
      this.lut.setOnScrollListener(new IPCallContactUI.11(this));
      this.luN.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void eU(String paramAnonymousString)
        {
          if ("↑".equals(paramAnonymousString)) {
            IPCallContactUI.b(IPCallContactUI.this).setSelection(0);
          }
          for (;;)
          {
            return;
            c localc = IPCallContactUI.d(IPCallContactUI.this);
            if (localc.dsf.containsKey(paramAnonymousString)) {}
            for (int i = ((Integer)localc.dsf.get(paramAnonymousString)).intValue(); i != -1; i = -1)
            {
              IPCallContactUI.b(IPCallContactUI.this).setSelection(i);
              return;
            }
          }
        }
      });
      if (this.luJ.bcR() <= 0)
      {
        this.luK.setVisibility(8);
        paramBundle = this.mController.uMN;
        this.mController.uMN.getString(R.l.app_tip);
        this.luI = h.b(paramBundle, this.mController.uMN.getString(R.l.ip_call_extracting_address_hint), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            IPCallContactUI.this.finish();
          }
        });
        e.post(this.luA, "IPCall_LoadSystemAddressBook");
      }
    }
    else
    {
      return;
    }
    com.tencent.mm.plugin.ipcall.a.bbv().bbw();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    y.d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.plugin.ipcall.a.a locala = com.tencent.mm.plugin.ipcall.a.a.bbR();
    a.a locala1 = this.luR;
    if (locala.lot.contains(locala1)) {
      locala.lot.remove(locala1);
    }
    this.dPi.removeMessages(1);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.IPCallContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (paramArrayOfInt[0] == 0);
    h.a(this, getString(R.l.permission_contacts_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new IPCallContactUI.3(this), new IPCallContactUI.4(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    supportInvalidateOptionsMenu();
  }
  
  public final void pA(String paramString)
  {
    this.feq = paramString;
    this.dPi.removeCallbacks(this.luS);
    this.dPi.postDelayed(this.luS, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI
 * JD-Core Version:    0.7.0.1
 */