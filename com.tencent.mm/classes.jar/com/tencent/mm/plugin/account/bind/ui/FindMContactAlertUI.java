package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.a.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAlertUI
  extends MMWizardActivity
{
  private int X = 0;
  private int Y = 0;
  private String dnz;
  private ProgressDialog fts = null;
  private String fwd = null;
  private String iHJ = "";
  private int iHK = 2;
  private String iHL = null;
  private String iHM = null;
  private boolean iHN = false;
  private List<String[]> iHO = null;
  private aj iHP;
  private String iHQ;
  private String iHR;
  private int iHS = 0;
  private final int iHT = 200;
  private int iHU = 0;
  private int iHV = 0;
  private int iHW = 0;
  private int iHX = 0;
  private String igp;
  private com.tencent.mm.ak.g onSceneEndCallback = null;
  
  private d a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(110005);
    d locald = new d(this);
    locald.setTitle(paramString2);
    locald.setMessage(paramString1);
    locald.a(2131759140, paramOnClickListener1);
    locald.b(2131759135, paramOnClickListener2);
    locald.Bqt.setVisibility(0);
    locald.setCancelable(false);
    locald.show();
    locald.getWindow().clearFlags(2);
    addDialog(locald);
    AppMethodBeat.o(110005);
    return locald;
  }
  
  private void a(final d paramd)
  {
    AppMethodBeat.i(110007);
    paramd.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(109993);
        paramd.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
        int i = paramd.getWindow().getDecorView().getMeasuredWidth();
        int j = paramd.getWindow().getDecorView().getMeasuredHeight();
        View localView = FindMContactAlertUI.a(FindMContactAlertUI.this, (ViewGroup)paramd.getWindow().getDecorView());
        if (localView != null) {
          i = localView.getMeasuredWidth() * 2;
        }
        for (;;)
        {
          ac.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          FindMContactAlertUI.a(FindMContactAlertUI.this, i, j);
          AppMethodBeat.o(109993);
          return;
        }
      }
    });
    paramd = findViewById(2131297029);
    paramd.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(109994);
        paramd.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        int i = paramd.getMeasuredHeight();
        int j = paramd.getMeasuredWidth();
        ac.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        FindMContactAlertUI.b(FindMContactAlertUI.this, j, i);
        AppMethodBeat.o(109994);
      }
    });
    AppMethodBeat.o(110007);
  }
  
  private void aOO()
  {
    AppMethodBeat.i(110012);
    com.tencent.mm.plugin.b.a.IL(this.iHQ);
    hideVKB();
    ZA(1);
    AppMethodBeat.o(110012);
  }
  
  private void aOS()
  {
    AppMethodBeat.i(110006);
    if (this.iHN)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R300_200_phone,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R300_200_phone") + ",1");
      com.tencent.mm.ui.base.h.a(this, false, getString(2131759116), getString(2131755906), getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()new FindMContactAlertUI.4
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109987);
          com.tencent.mm.plugin.account.friend.a.l.fn(true);
          com.tencent.mm.plugin.b.a.IL("R200_100");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("mobile_input_purpose", 4);
          paramAnonymousDialogInterface.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
          com.tencent.mm.plugin.account.a.a.iyx.a(FindMContactAlertUI.this, paramAnonymousDialogInterface);
          com.tencent.mm.plugin.b.a.IL("R300_300_phone");
          paramAnonymousDialogInterface = new StringBuilder();
          com.tencent.mm.kernel.g.agP();
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.append(com.tencent.mm.kernel.a.agc()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R300_200_phone") + ",2");
          AppMethodBeat.o(109987);
        }
      }, new FindMContactAlertUI.4(this));
      AppMethodBeat.o(110006);
      return;
    }
    if (com.tencent.mm.plugin.account.friend.a.l.aPB())
    {
      a(a(this.iHR, this.igp, new FindMContactAlertUI.5(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109992);
          paramAnonymousDialogInterface = new Intent(FindMContactAlertUI.this, FindMContactLearmMoreUI.class);
          paramAnonymousDialogInterface.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
          MMWizardActivity.aj(FindMContactAlertUI.this, paramAnonymousDialogInterface);
          AppMethodBeat.o(109992);
        }
      }));
      AppMethodBeat.o(110006);
      return;
    }
    aOU();
    AppMethodBeat.o(110006);
  }
  
  private void aOT()
  {
    AppMethodBeat.i(110009);
    int j = getWindowManager().getDefaultDisplay().getHeight();
    int i = this.iHW - (getResources().getDimensionPixelSize(2131165523) + com.tencent.mm.cc.a.fromDPToPix(this, 48));
    int k = j / 2;
    int m = this.iHV / 2;
    int n = this.iHX;
    j = com.tencent.mm.cc.a.fromDPToPix(this, 20) + (k + m - (j - n));
    if ((i != this.X) || (j != this.Y))
    {
      this.X = i;
      this.Y = j;
      View localView = findViewById(2131300081);
      localView.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.setMargins(i - localView.getMeasuredWidth() / 2, j, 0, 0);
      ac.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localView.getMeasuredWidth()) });
      localView.setLayoutParams(localLayoutParams);
      localView.startAnimation(AnimationUtils.loadAnimation(this, 2130772008));
    }
    AppMethodBeat.o(110009);
  }
  
  private void aOU()
  {
    AppMethodBeat.i(110010);
    boolean bool = b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ac.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi() });
    if (!bool)
    {
      AppMethodBeat.o(110010);
      return;
    }
    Object localObject = findViewById(2131300081);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = com.tencent.mm.kernel.g.agi();
    com.tencent.mm.ak.g local9 = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(109995);
        if (FindMContactAlertUI.f(FindMContactAlertUI.this) != null)
        {
          FindMContactAlertUI.f(FindMContactAlertUI.this).dismiss();
          FindMContactAlertUI.g(FindMContactAlertUI.this);
        }
        if (FindMContactAlertUI.h(FindMContactAlertUI.this) != null)
        {
          com.tencent.mm.kernel.g.agi().b(431, FindMContactAlertUI.h(FindMContactAlertUI.this));
          FindMContactAlertUI.i(FindMContactAlertUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((aj)paramAnonymousn).aPU();
          ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label392;
          }
          paramAnonymousn = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousn.hasNext())
          {
            bpw localbpw = (bpw)paramAnonymousn.next();
            if (localbpw != null)
            {
              if (localbpw.ndj != 1) {
                break label389;
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
            ac.d("MicroMsg.FindMContactAlertUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactAlertUI.b(FindMContactAlertUI.this) == null) || (!FindMContactAlertUI.b(FindMContactAlertUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label325;
            }
            com.tencent.mm.plugin.b.a.IL("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactAlertUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.aj(FindMContactAlertUI.this, paramAnonymousString);
            AppMethodBeat.o(109995);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label325:
          FindMContactAlertUI.d(FindMContactAlertUI.this);
          AppMethodBeat.o(109995);
          return;
          Toast.makeText(FindMContactAlertUI.this, FindMContactAlertUI.this.getString(2131755733, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
          FindMContactAlertUI.d(FindMContactAlertUI.this);
          AppMethodBeat.o(109995);
          return;
          label389:
          break;
          label392:
          paramAnonymousInt2 = 0;
          paramAnonymousInt1 = 0;
        }
      }
    };
    this.onSceneEndCallback = local9;
    ((q)localObject).a(431, local9);
    localObject = getContext();
    getString(2131755906);
    this.fts = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131755804), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109996);
        if (FindMContactAlertUI.h(FindMContactAlertUI.this) != null)
        {
          com.tencent.mm.kernel.g.agi().b(431, FindMContactAlertUI.h(FindMContactAlertUI.this));
          FindMContactAlertUI.i(FindMContactAlertUI.this);
          FindMContactAlertUI.j(FindMContactAlertUI.this);
        }
        AppMethodBeat.o(109996);
      }
    });
    com.tencent.mm.kernel.g.agU().a(new ap.a()
    {
      public final boolean aBj()
      {
        AppMethodBeat.i(109998);
        for (;;)
        {
          try
          {
            FindMContactAlertUI.a(FindMContactAlertUI.this, com.tencent.mm.pluginsdk.a.dt(FindMContactAlertUI.this));
            StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
            if (FindMContactAlertUI.k(FindMContactAlertUI.this) != null) {
              continue;
            }
            i = 0;
            ac.d("MicroMsg.FindMContactAlertUI", i);
          }
          catch (Exception localException)
          {
            int i;
            ac.printErrStackTrace("MicroMsg.FindMContactAlertUI", localException, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(109998);
          return true;
          i = FindMContactAlertUI.k(FindMContactAlertUI.this).size();
        }
      }
      
      public final boolean aBk()
      {
        AppMethodBeat.i(109997);
        if ((FindMContactAlertUI.k(FindMContactAlertUI.this) != null) && (FindMContactAlertUI.k(FindMContactAlertUI.this).size() != 0))
        {
          FindMContactAlertUI.a(FindMContactAlertUI.this, new aj(FindMContactAlertUI.a(FindMContactAlertUI.this), FindMContactAlertUI.k(FindMContactAlertUI.this)));
          com.tencent.mm.kernel.g.agi().a(FindMContactAlertUI.l(FindMContactAlertUI.this), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(109997);
          return false;
          if (FindMContactAlertUI.f(FindMContactAlertUI.this) != null)
          {
            FindMContactAlertUI.f(FindMContactAlertUI.this).dismiss();
            FindMContactAlertUI.g(FindMContactAlertUI.this);
          }
          FindMContactAlertUI.d(FindMContactAlertUI.this);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(109999);
        String str = super.toString() + "|doUpload";
        AppMethodBeat.o(109999);
        return str;
      }
    });
    ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
    ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
    com.tencent.mm.plugin.report.service.h.wUl.f(11438, new Object[] { Integer.valueOf(1) });
    ac.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(1) });
    AppMethodBeat.o(110010);
  }
  
  private View d(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110008);
    if (this.iHS >= 200)
    {
      AppMethodBeat.o(110008);
      return null;
    }
    this.iHS += 1;
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof Button))
      {
        AppMethodBeat.o(110008);
        return localView;
      }
      if ((localView instanceof ViewGroup))
      {
        localView = d((ViewGroup)localView);
        if (localView != null)
        {
          AppMethodBeat.o(110008);
          return localView;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(110008);
    return null;
  }
  
  public int getLayoutId()
  {
    return 2131494131;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110004);
    this.igp = getString(2131759117);
    this.iHR = getString(2131759116);
    if (!bs.isNullOrNil(this.iHL)) {
      this.igp = this.iHL;
    }
    if (!bs.isNullOrNil(this.iHM)) {
      this.iHR = this.iHM;
    }
    this.dnz = ((String)com.tencent.mm.kernel.g.agR().agA().get(6, null));
    if ((this.dnz == null) || (this.dnz.equals(""))) {
      this.dnz = ((String)com.tencent.mm.kernel.g.agR().agA().get(4097, null));
    }
    AppMethodBeat.o(110004);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110000);
    super.onCreate(paramBundle);
    setMMTitle(2131759133);
    com.tencent.mm.plugin.account.a.a.iyy.Lm();
    this.fwd = getIntent().getStringExtra("regsetinfo_ticket");
    this.iHJ = getIntent().getStringExtra("regsetinfo_NextStep");
    this.iHK = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.iHL = getIntent().getStringExtra("alert_title");
    this.iHM = getIntent().getStringExtra("alert_message");
    if (com.tencent.mm.plugin.account.friend.a.l.aPC() != l.a.iKF) {}
    for (boolean bool = true;; bool = false)
    {
      this.iHN = bool;
      this.iHQ = com.tencent.mm.plugin.b.a.EL();
      ac.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.iHJ, Integer.valueOf(this.iHK) });
      if (!isFinishing()) {
        break;
      }
      AppMethodBeat.o(110000);
      return;
    }
    initView();
    aOS();
    AppMethodBeat.o(110000);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110001);
    ac.d("MicroMsg.FindMContactAlertUI", "ondestroy");
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.g.agi().b(431, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    super.onDestroy();
    AppMethodBeat.o(110001);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(110011);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aOO();
      AppMethodBeat.o(110011);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(110011);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(110003);
    super.onPause();
    if (this.iHN)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R300_100_QQ") + ",2");
      AppMethodBeat.o(110003);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",RE300_100,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("RE300_100") + ",2");
    AppMethodBeat.o(110003);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110013);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(110013);
      return;
    }
    ac.i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110013);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aOU();
        AppMethodBeat.o(110013);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131755691), false, new FindMContactAlertUI.2(this), new FindMContactAlertUI.3(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110002);
    super.onResume();
    if (this.iHN)
    {
      com.tencent.mm.plugin.b.a.IK("R300_100_QQ");
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("R300_100_QQ") + ",1");
      AppMethodBeat.o(110002);
      return;
    }
    com.tencent.mm.plugin.b.a.IK("R300_100_phone");
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",RE300_100,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("RE300_100") + ",1");
    AppMethodBeat.o(110002);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI
 * JD-Core Version:    0.7.0.1
 */