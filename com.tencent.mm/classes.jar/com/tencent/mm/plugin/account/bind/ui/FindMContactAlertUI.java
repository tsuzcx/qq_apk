package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.a;
import com.tencent.mm.plugin.account.bind.a.c;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.protocal.c.auc;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAlertUI
  extends MMWizardActivity
{
  private int X = 0;
  private int Y = 0;
  private String bSe;
  private ProgressDialog dnm = null;
  private String dqS = null;
  private f eBv = null;
  private String fcQ = "";
  private int fcR = 2;
  private String fcS = null;
  private String fcT = null;
  private boolean fcU = false;
  private List<String[]> fcV = null;
  private ag fcW;
  private String fcX;
  private String fcY;
  private String fcZ;
  private int fda = 0;
  private final int fdb = 200;
  private int fdc = 0;
  private int fdd = 0;
  private int fde = 0;
  private int fdf = 0;
  
  private void Wc()
  {
    com.tencent.mm.plugin.b.a.qj(this.fcX);
    XM();
    FW(1);
  }
  
  private void Wg()
  {
    Object localObject;
    if (this.fcU)
    {
      localObject = new StringBuilder();
      g.DN();
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_200_phone,");
      g.DN();
      com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R300_200_phone") + ",1");
      com.tencent.mm.ui.base.h.a(this, false, getString(a.i.find_mcontact_bind_alert_content), getString(a.i.app_tip), getString(a.i.app_ok), getString(a.i.app_cancel), new FindMContactAlertUI.1(this), new FindMContactAlertUI.4(this));
      return;
    }
    if (com.tencent.mm.plugin.account.friend.a.l.WO())
    {
      localObject = this.fcZ;
      String str = this.fcY;
      int i = a.i.find_mcontact_upload_ok;
      int j = a.i.find_mcontact_upload_learn_more;
      FindMContactAlertUI.5 local5 = new FindMContactAlertUI.5(this);
      FindMContactAlertUI.6 local6 = new FindMContactAlertUI.6(this);
      final c localc = new c(this);
      localc.setTitle(str);
      localc.setMessage((CharSequence)localObject);
      localc.a(i, local5);
      localc.b(j, local6);
      localc.qFr.setVisibility(0);
      localc.setCancelable(false);
      localc.show();
      localc.getWindow().clearFlags(2);
      addDialog(localc);
      localc.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          localc.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
          int i = localc.getWindow().getDecorView().getMeasuredWidth();
          int j = localc.getWindow().getDecorView().getMeasuredHeight();
          View localView = FindMContactAlertUI.a(FindMContactAlertUI.this, (ViewGroup)localc.getWindow().getDecorView());
          if (localView != null) {
            i = localView.getMeasuredWidth() * 2;
          }
          for (;;)
          {
            y.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            FindMContactAlertUI.a(FindMContactAlertUI.this, i, j);
            return;
          }
        }
      });
      localObject = findViewById(a.e.background);
      ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          this.fdi.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          int i = this.fdi.getMeasuredHeight();
          int j = this.fdi.getMeasuredWidth();
          y.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          FindMContactAlertUI.b(FindMContactAlertUI.this, j, i);
        }
      });
      return;
    }
    Wi();
  }
  
  private void Wh()
  {
    int j = getWindowManager().getDefaultDisplay().getHeight();
    int i = this.fde - (getResources().getDimensionPixelSize(a.c.PopPadding) + com.tencent.mm.cb.a.fromDPToPix(this, 48));
    int k = j / 2;
    int m = this.fdd / 2;
    int n = this.fdf;
    j = com.tencent.mm.cb.a.fromDPToPix(this, 20) + (k + m - (j - n));
    if ((i != this.X) || (j != this.Y))
    {
      this.X = i;
      this.Y = j;
      View localView = findViewById(a.e.findmcontact_arrow);
      localView.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.setMargins(i - localView.getMeasuredWidth() / 2, j, 0, 0);
      y.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localView.getMeasuredWidth()) });
      localView.setLayoutParams(localLayoutParams);
      localView.startAnimation(AnimationUtils.loadAnimation(this, a.a.arrow_appare));
    }
  }
  
  private void Wi()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    y.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bk.csb() });
    if (!bool) {
      return;
    }
    Object localObject = findViewById(a.e.findmcontact_arrow);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = g.Dk();
    f local9 = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        if (FindMContactAlertUI.f(FindMContactAlertUI.this) != null)
        {
          FindMContactAlertUI.f(FindMContactAlertUI.this).dismiss();
          FindMContactAlertUI.g(FindMContactAlertUI.this);
        }
        if (FindMContactAlertUI.h(FindMContactAlertUI.this) != null)
        {
          g.Dk().b(431, FindMContactAlertUI.h(FindMContactAlertUI.this));
          FindMContactAlertUI.i(FindMContactAlertUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((ag)paramAnonymousm).Xd();
          ((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label373;
          }
          paramAnonymousm = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousm.hasNext())
          {
            auc localauc = (auc)paramAnonymousm.next();
            if (localauc != null)
            {
              if (localauc.hQq != 1) {
                break label370;
              }
              paramAnonymousInt1 += 1;
            }
          }
          if (paramAnonymousInt1 > 0) {
            paramAnonymousInt2 = 1;
          }
        }
        for (;;)
        {
          if (paramAnonymousString == null) {}
          for (int i = 0;; i = paramAnonymousString.size())
          {
            y.d("MicroMsg.FindMContactAlertUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactAlertUI.b(FindMContactAlertUI.this) == null) || (!FindMContactAlertUI.b(FindMContactAlertUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label315;
            }
            com.tencent.mm.plugin.b.a.qj("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactAlertUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.C(FindMContactAlertUI.this, paramAnonymousString);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label315:
          FindMContactAlertUI.d(FindMContactAlertUI.this);
          return;
          Toast.makeText(FindMContactAlertUI.this, FindMContactAlertUI.this.getString(a.i.app_err_system_busy_tip, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
          FindMContactAlertUI.d(FindMContactAlertUI.this);
          return;
          label370:
          break;
          label373:
          paramAnonymousInt2 = 0;
          paramAnonymousInt1 = 0;
        }
      }
    };
    this.eBv = local9;
    ((p)localObject).a(431, local9);
    localObject = this.mController.uMN;
    getString(a.i.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b((Context)localObject, getString(a.i.app_loading), true, new FindMContactAlertUI.10(this));
    g.DS().a(new ai.a()
    {
      public final boolean JS()
      {
        try
        {
          FindMContactAlertUI.a(FindMContactAlertUI.this, com.tencent.mm.pluginsdk.a.ck(FindMContactAlertUI.this));
          StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
          if (FindMContactAlertUI.k(FindMContactAlertUI.this) == null) {}
          for (int i = 0;; i = FindMContactAlertUI.k(FindMContactAlertUI.this).size())
          {
            y.d("MicroMsg.FindMContactAlertUI", i);
            break;
          }
          return true;
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("MicroMsg.FindMContactAlertUI", localException, "", new Object[0]);
        }
      }
      
      public final boolean JT()
      {
        if ((FindMContactAlertUI.k(FindMContactAlertUI.this) != null) && (FindMContactAlertUI.k(FindMContactAlertUI.this).size() != 0))
        {
          FindMContactAlertUI.a(FindMContactAlertUI.this, new ag(FindMContactAlertUI.a(FindMContactAlertUI.this), FindMContactAlertUI.k(FindMContactAlertUI.this)));
          g.Dk().a(FindMContactAlertUI.l(FindMContactAlertUI.this), 0);
          return false;
        }
        if (FindMContactAlertUI.f(FindMContactAlertUI.this) != null)
        {
          FindMContactAlertUI.f(FindMContactAlertUI.this).dismiss();
          FindMContactAlertUI.g(FindMContactAlertUI.this);
        }
        FindMContactAlertUI.d(FindMContactAlertUI.this);
        return false;
      }
      
      public final String toString()
      {
        return super.toString() + "|doUpload";
      }
    });
    ((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
    ((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
    com.tencent.mm.plugin.report.service.h.nFQ.f(11438, new Object[] { Integer.valueOf(1) });
    y.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(1) });
  }
  
  private View h(ViewGroup paramViewGroup)
  {
    Object localObject;
    if (this.fda >= 200)
    {
      localObject = null;
      return localObject;
    }
    this.fda += 1;
    int j = paramViewGroup.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label92;
      }
      View localView = paramViewGroup.getChildAt(i);
      localObject = localView;
      if ((localView instanceof Button)) {
        break;
      }
      if ((localView instanceof ViewGroup))
      {
        localView = h((ViewGroup)localView);
        localObject = localView;
        if (localView != null) {
          break;
        }
      }
      i += 1;
    }
    label92:
    return null;
  }
  
  protected final int getLayoutId()
  {
    return a.f.findmcontact_intro_with_alert;
  }
  
  protected final void initView()
  {
    this.fcY = getString(a.i.find_mcontact_bind_alert_title);
    this.fcZ = getString(a.i.find_mcontact_bind_alert_content);
    if (!bk.bl(this.fcS)) {
      this.fcY = this.fcS;
    }
    if (!bk.bl(this.fcT)) {
      this.fcZ = this.fcT;
    }
    this.bSe = ((String)g.DP().Dz().get(6, null));
    if ((this.bSe == null) || (this.bSe.equals(""))) {
      this.bSe = ((String)g.DP().Dz().get(4097, null));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.find_mcontact_title);
    com.tencent.mm.plugin.account.a.a.eUS.tn();
    this.dqS = getIntent().getStringExtra("regsetinfo_ticket");
    this.fcQ = getIntent().getStringExtra("regsetinfo_NextStep");
    this.fcR = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.fcS = getIntent().getStringExtra("alert_title");
    this.fcT = getIntent().getStringExtra("alert_message");
    if (com.tencent.mm.plugin.account.friend.a.l.WP() != l.a.ffT) {}
    for (boolean bool = true;; bool = false)
    {
      this.fcU = bool;
      this.fcX = com.tencent.mm.plugin.b.a.YA();
      y.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.fcQ, Integer.valueOf(this.fcR) });
      if (!isFinishing()) {
        break;
      }
      return;
    }
    initView();
    Wg();
  }
  
  public void onDestroy()
  {
    y.d("MicroMsg.FindMContactAlertUI", "ondestroy");
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
    if (this.fcU)
    {
      localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R300_100_QQ") + ",2");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",RE300_100,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("RE300_100") + ",2");
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.FindMContactAlertUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
    com.tencent.mm.ui.base.h.a(this, getString(a.i.permission_contacts_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new FindMContactAlertUI.2(this), new FindMContactAlertUI.3(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.fcU)
    {
      com.tencent.mm.plugin.b.a.qi("R300_100_QQ");
      localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R300_100_QQ") + ",1");
      return;
    }
    com.tencent.mm.plugin.b.a.qi("R300_100_phone");
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",RE300_100,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("RE300_100") + ",1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI
 * JD-Core Version:    0.7.0.1
 */