package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.List;

public class FindMContactLearmMoreUI
  extends MMWizardActivity
{
  private String bSe;
  private ProgressDialog dnm = null;
  private String dqS = null;
  private f eBv = null;
  private String fcQ = "";
  private int fcR = 2;
  private List<String[]> fcV = null;
  private ag fcW;
  private Button fdo;
  private TextView fdp;
  
  private void Wc()
  {
    XM();
    FW(1);
  }
  
  private void Wi()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    y.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bk.csb() });
    if (!bool) {
      return;
    }
    Object localObject = g.Dk();
    FindMContactLearmMoreUI.3 local3 = new FindMContactLearmMoreUI.3(this);
    this.eBv = local3;
    ((p)localObject).a(431, local3);
    localObject = this.mController.uMN;
    getString(a.i.app_tip);
    this.dnm = h.b((Context)localObject, getString(a.i.app_loading), true, new FindMContactLearmMoreUI.4(this));
    g.DS().a(new ai.a()
    {
      public final boolean JS()
      {
        try
        {
          FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this, com.tencent.mm.pluginsdk.a.ck(FindMContactLearmMoreUI.this));
          StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
          if (FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this) == null) {}
          for (int i = 0;; i = FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this).size())
          {
            y.d("MicroMsg.FindMContactLearmMoreUI", i);
            break;
          }
          return true;
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", localException, "", new Object[0]);
        }
      }
      
      public final boolean JT()
      {
        if ((FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this) != null) && (FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this).size() != 0))
        {
          FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this, new ag(FindMContactLearmMoreUI.h(FindMContactLearmMoreUI.this), FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this)));
          g.Dk().a(FindMContactLearmMoreUI.k(FindMContactLearmMoreUI.this), 0);
          return false;
        }
        if (FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this) != null)
        {
          FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this).dismiss();
          FindMContactLearmMoreUI.d(FindMContactLearmMoreUI.this);
        }
        FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
        return false;
      }
      
      public final String toString()
      {
        return super.toString() + "|doUpload";
      }
    });
    ((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
    ((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
  }
  
  protected final int getLayoutId()
  {
    return a.f.findmcontact_intro_learn_more;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.find_mcontact_upload_title);
    this.fdo = ((Button)findViewById(a.e.ok_btn));
    this.fdp = ((TextView)findViewById(a.e.cancel_btn));
    this.fdo.setOnClickListener(new FindMContactLearmMoreUI.1(this));
    this.fdp.setOnClickListener(new FindMContactLearmMoreUI.2(this));
    g.DP().Dz().o(12323, Boolean.valueOf(true));
    this.bSe = ((String)g.DP().Dz().get(6, null));
    if ((this.bSe == null) || (this.bSe.equals(""))) {
      this.bSe = ((String)g.DP().Dz().get(4097, null));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dqS = getIntent().getStringExtra("regsetinfo_ticket");
    this.fcQ = getIntent().getStringExtra("regsetinfo_NextStep");
    this.fcR = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    initView();
  }
  
  public void onDestroy()
  {
    if (this.eBv != null)
    {
      g.Dk().b(431, this.eBv);
      this.eBv = null;
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      Wc();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",RE300_600,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("RE300_600") + ",2");
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.FindMContactLearmMoreUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      Wi();
      return;
    }
    h.a(this, getString(a.i.permission_contacts_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new FindMContactLearmMoreUI.7
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        FindMContactLearmMoreUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
      }
    }, new FindMContactLearmMoreUI.7(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.mm.plugin.b.a.qi("R300_100_phone");
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",RE300_600,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("RE300_600") + ",1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI
 * JD-Core Version:    0.7.0.1
 */