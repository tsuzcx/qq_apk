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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAlertUI
  extends MMWizardActivity
{
  private int X = 0;
  private int Y = 0;
  private String dzn;
  private ProgressDialog fMu = null;
  private String fPq = null;
  private String izJ;
  private String jaS = "";
  private int jaT = 2;
  private String jaU = null;
  private String jaV = null;
  private boolean jaW = false;
  private List<String[]> jaX = null;
  private aj jaY;
  private String jaZ;
  private String jba;
  private int jbb = 0;
  private final int jbc = 200;
  private int jbd = 0;
  private int jbe = 0;
  private int jbf = 0;
  private int jbg = 0;
  private f onSceneEndCallback = null;
  
  private d a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(110005);
    d locald = new d(this, (byte)0);
    locald.setTitle(paramString2);
    locald.setMessage(paramString1);
    locald.a(2131759140, paramOnClickListener1);
    locald.b(2131759135, paramOnClickListener2);
    locald.bl(-1, true);
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
          ad.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
        ad.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        FindMContactAlertUI.b(FindMContactAlertUI.this, j, i);
        AppMethodBeat.o(109994);
      }
    });
    AppMethodBeat.o(110007);
  }
  
  private void aSa()
  {
    AppMethodBeat.i(110012);
    com.tencent.mm.plugin.b.a.Ma(this.jaZ);
    hideVKB();
    abK(1);
    AppMethodBeat.o(110012);
  }
  
  private void aSe()
  {
    AppMethodBeat.i(110006);
    if (this.jaW)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R300_200_phone,");
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R300_200_phone") + ",1");
      h.a(this, false, getString(2131759116), getString(2131755906), getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109987);
          com.tencent.mm.plugin.account.friend.a.l.fr(true);
          com.tencent.mm.plugin.b.a.Ma("R200_100");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("mobile_input_purpose", 4);
          paramAnonymousDialogInterface.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
          com.tencent.mm.plugin.account.a.a.iRG.a(FindMContactAlertUI.this, paramAnonymousDialogInterface);
          com.tencent.mm.plugin.b.a.Ma("R300_300_phone");
          paramAnonymousDialogInterface = new StringBuilder();
          com.tencent.mm.kernel.g.ajA();
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.append(com.tencent.mm.kernel.a.aiO()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
          com.tencent.mm.kernel.g.ajA();
          com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R300_200_phone") + ",2");
          AppMethodBeat.o(109987);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109990);
          com.tencent.mm.plugin.account.friend.a.l.fr(false);
          paramAnonymousDialogInterface = new StringBuilder();
          com.tencent.mm.kernel.g.ajA();
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.append(com.tencent.mm.kernel.a.aiO()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
          com.tencent.mm.kernel.g.ajA();
          com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R300_200_phone") + ",2");
          FindMContactAlertUI.d(FindMContactAlertUI.this);
          AppMethodBeat.o(109990);
        }
      });
      AppMethodBeat.o(110006);
      return;
    }
    if (com.tencent.mm.plugin.account.friend.a.l.aSN())
    {
      a(a(this.jba, this.izJ, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109991);
          com.tencent.mm.plugin.account.friend.a.l.fr(true);
          FindMContactAlertUI.e(FindMContactAlertUI.this);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(109991);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109992);
          paramAnonymousDialogInterface = new Intent(FindMContactAlertUI.this, FindMContactLearmMoreUI.class);
          paramAnonymousDialogInterface.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
          MMWizardActivity.al(FindMContactAlertUI.this, paramAnonymousDialogInterface);
          AppMethodBeat.o(109992);
        }
      }));
      AppMethodBeat.o(110006);
      return;
    }
    aSg();
    AppMethodBeat.o(110006);
  }
  
  private void aSf()
  {
    AppMethodBeat.i(110009);
    int j = getWindowManager().getDefaultDisplay().getHeight();
    int i = this.jbf - (getResources().getDimensionPixelSize(2131165523) + com.tencent.mm.cc.a.fromDPToPix(this, 48));
    int k = j / 2;
    int m = this.jbe / 2;
    int n = this.jbg;
    j = com.tencent.mm.cc.a.fromDPToPix(this, 20) + (k + m - (j - n));
    if ((i != this.X) || (j != this.Y))
    {
      this.X = i;
      this.Y = j;
      View localView = findViewById(2131300081);
      localView.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.setMargins(i - localView.getMeasuredWidth() / 2, j, 0, 0);
      ad.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localView.getMeasuredWidth()) });
      localView.setLayoutParams(localLayoutParams);
      localView.startAnimation(AnimationUtils.loadAnimation(this, 2130772008));
    }
    AppMethodBeat.o(110009);
  }
  
  private void aSg()
  {
    AppMethodBeat.i(110010);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ad.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.flS() });
    if (!bool)
    {
      AppMethodBeat.o(110010);
      return;
    }
    Object localObject = findViewById(2131300081);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = com.tencent.mm.kernel.g.aiU();
    f local9 = new f()
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
          com.tencent.mm.kernel.g.aiU().b(431, FindMContactAlertUI.h(FindMContactAlertUI.this));
          FindMContactAlertUI.i(FindMContactAlertUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((aj)paramAnonymousn).aTg();
          ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label392;
          }
          paramAnonymousn = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousn.hasNext())
          {
            buj localbuj = (buj)paramAnonymousn.next();
            if (localbuj != null)
            {
              if (localbuj.nDG != 1) {
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
            ad.d("MicroMsg.FindMContactAlertUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactAlertUI.b(FindMContactAlertUI.this) == null) || (!FindMContactAlertUI.b(FindMContactAlertUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label325;
            }
            com.tencent.mm.plugin.b.a.Ma("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactAlertUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.al(FindMContactAlertUI.this, paramAnonymousString);
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
    this.fMu = h.b((Context)localObject, getString(2131755804), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109996);
        if (FindMContactAlertUI.h(FindMContactAlertUI.this) != null)
        {
          com.tencent.mm.kernel.g.aiU().b(431, FindMContactAlertUI.h(FindMContactAlertUI.this));
          FindMContactAlertUI.i(FindMContactAlertUI.this);
          FindMContactAlertUI.j(FindMContactAlertUI.this);
        }
        AppMethodBeat.o(109996);
      }
    });
    com.tencent.mm.kernel.g.ajF().a(new aq.a()
    {
      public final boolean aEm()
      {
        AppMethodBeat.i(109998);
        for (;;)
        {
          try
          {
            FindMContactAlertUI.a(FindMContactAlertUI.this, com.tencent.mm.pluginsdk.b.dr(FindMContactAlertUI.this));
            StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
            if (FindMContactAlertUI.k(FindMContactAlertUI.this) != null) {
              continue;
            }
            i = 0;
            ad.d("MicroMsg.FindMContactAlertUI", i);
          }
          catch (Exception localException)
          {
            int i;
            ad.printErrStackTrace("MicroMsg.FindMContactAlertUI", localException, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(109998);
          return true;
          i = FindMContactAlertUI.k(FindMContactAlertUI.this).size();
        }
      }
      
      public final boolean aEn()
      {
        AppMethodBeat.i(109997);
        if ((FindMContactAlertUI.k(FindMContactAlertUI.this) != null) && (FindMContactAlertUI.k(FindMContactAlertUI.this).size() != 0))
        {
          FindMContactAlertUI.a(FindMContactAlertUI.this, new aj(FindMContactAlertUI.a(FindMContactAlertUI.this), FindMContactAlertUI.k(FindMContactAlertUI.this)));
          com.tencent.mm.kernel.g.aiU().a(FindMContactAlertUI.l(FindMContactAlertUI.this), 0);
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
    com.tencent.mm.plugin.report.service.g.yhR.f(11438, new Object[] { Integer.valueOf(1) });
    ad.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(1) });
    AppMethodBeat.o(110010);
  }
  
  private View e(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110008);
    if (this.jbb >= 200)
    {
      AppMethodBeat.o(110008);
      return null;
    }
    this.jbb += 1;
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
        localView = e((ViewGroup)localView);
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
    this.izJ = getString(2131759117);
    this.jba = getString(2131759116);
    if (!bt.isNullOrNil(this.jaU)) {
      this.izJ = this.jaU;
    }
    if (!bt.isNullOrNil(this.jaV)) {
      this.jba = this.jaV;
    }
    this.dzn = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(6, null));
    if ((this.dzn == null) || (this.dzn.equals(""))) {
      this.dzn = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(4097, null));
    }
    AppMethodBeat.o(110004);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110000);
    super.onCreate(paramBundle);
    setMMTitle(2131759133);
    com.tencent.mm.plugin.account.a.a.iRH.MU();
    this.fPq = getIntent().getStringExtra("regsetinfo_ticket");
    this.jaS = getIntent().getStringExtra("regsetinfo_NextStep");
    this.jaT = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.jaU = getIntent().getStringExtra("alert_title");
    this.jaV = getIntent().getStringExtra("alert_message");
    if (com.tencent.mm.plugin.account.friend.a.l.aSO() != l.a.jdO) {}
    for (boolean bool = true;; bool = false)
    {
      this.jaW = bool;
      this.jaZ = com.tencent.mm.plugin.b.a.Mp();
      ad.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.jaS, Integer.valueOf(this.jaT) });
      if (!isFinishing()) {
        break;
      }
      AppMethodBeat.o(110000);
      return;
    }
    initView();
    aSe();
    AppMethodBeat.o(110000);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110001);
    ad.d("MicroMsg.FindMContactAlertUI", "ondestroy");
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.g.aiU().b(431, this.onSceneEndCallback);
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
      aSa();
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
    if (this.jaW)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R300_100_QQ") + ",2");
      AppMethodBeat.o(110003);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",RE300_100,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("RE300_100") + ",2");
    AppMethodBeat.o(110003);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110013);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(110013);
      return;
    }
    ad.i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110013);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aSg();
        AppMethodBeat.o(110013);
        return;
      }
      h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109988);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = FindMContactAlertUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/bind/ui/FindMContactAlertUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/bind/ui/FindMContactAlertUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(109988);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109989);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(109989);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110002);
    super.onResume();
    if (this.jaW)
    {
      com.tencent.mm.plugin.b.a.Kc("R300_100_QQ");
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("R300_100_QQ") + ",1");
      AppMethodBeat.o(110002);
      return;
    }
    com.tencent.mm.plugin.b.a.Kc("R300_100_phone");
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",RE300_100,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("RE300_100") + ",1");
    AppMethodBeat.o(110002);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI
 * JD-Core Version:    0.7.0.1
 */