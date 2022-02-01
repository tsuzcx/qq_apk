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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.bind.a.a;
import com.tencent.mm.plugin.account.bind.a.c;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
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
  private String fLC;
  private ProgressDialog iXX = null;
  private String jaS = null;
  private int mTA = 0;
  private int mTB = 0;
  private String mTn = "";
  private int mTo = 2;
  private String mTp = null;
  private String mTq = null;
  private boolean mTr = false;
  private List<String[]> mTs = null;
  private aj mTt;
  private String mTu;
  private String mTv;
  private int mTw = 0;
  private final int mTx = 200;
  private int mTy = 0;
  private int mTz = 0;
  private String mnu;
  private i onSceneEndCallback = null;
  
  private d a(String paramString1, String paramString2, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(241492);
    d locald = new d(this, (byte)0);
    locald.setTitle(paramString2);
    locald.setMessage(paramString1);
    locald.a(paramInt1, paramOnClickListener1);
    locald.b(paramInt2, paramOnClickListener2);
    locald.cg(-1, true);
    locald.setCancelable(false);
    locald.show();
    locald.getWindow().clearFlags(2);
    addDialog(locald);
    AppMethodBeat.o(241492);
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
          Log.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          FindMContactAlertUI.a(FindMContactAlertUI.this, i, j);
          AppMethodBeat.o(109993);
          return;
        }
      }
    });
    paramd = findViewById(a.e.background);
    paramd.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(109994);
        paramd.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        int i = paramd.getMeasuredHeight();
        int j = paramd.getMeasuredWidth();
        Log.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        FindMContactAlertUI.b(FindMContactAlertUI.this, j, i);
        AppMethodBeat.o(109994);
      }
    });
    AppMethodBeat.o(110007);
  }
  
  private void bxA()
  {
    AppMethodBeat.i(110009);
    int j = getWindowManager().getDefaultDisplay().getHeight();
    int i = this.mTA - (getResources().getDimensionPixelSize(a.c.PopPadding) + com.tencent.mm.ci.a.fromDPToPix(this, 48));
    int k = j / 2;
    int m = this.mTz / 2;
    int n = this.mTB;
    j = com.tencent.mm.ci.a.fromDPToPix(this, 20) + (k + m - (j - n));
    if ((i != this.X) || (j != this.Y))
    {
      this.X = i;
      this.Y = j;
      View localView = findViewById(a.e.findmcontact_arrow);
      localView.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.setMargins(i - localView.getMeasuredWidth() / 2, j, 0, 0);
      Log.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localView.getMeasuredWidth()) });
      localView.setLayoutParams(localLayoutParams);
      localView.startAnimation(AnimationUtils.loadAnimation(this, a.a.arrow_appare));
    }
    AppMethodBeat.o(110009);
  }
  
  private void bxB()
  {
    AppMethodBeat.i(110010);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    Log.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (!bool)
    {
      AppMethodBeat.o(110010);
      return;
    }
    Object localObject = findViewById(a.e.findmcontact_arrow);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = com.tencent.mm.kernel.h.aGY();
    i local9 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(109995);
        if (FindMContactAlertUI.f(FindMContactAlertUI.this) != null)
        {
          FindMContactAlertUI.f(FindMContactAlertUI.this).dismiss();
          FindMContactAlertUI.g(FindMContactAlertUI.this);
        }
        if (FindMContactAlertUI.h(FindMContactAlertUI.this) != null)
        {
          com.tencent.mm.kernel.h.aGY().b(431, FindMContactAlertUI.h(FindMContactAlertUI.this));
          FindMContactAlertUI.i(FindMContactAlertUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((aj)paramAnonymousq).byA();
          ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label393;
          }
          paramAnonymousq = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousq.hasNext())
          {
            crg localcrg = (crg)paramAnonymousq.next();
            if (localcrg != null)
            {
              if (localcrg.rVU != 1) {
                break label390;
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
            Log.d("MicroMsg.FindMContactAlertUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactAlertUI.b(FindMContactAlertUI.this) == null) || (!FindMContactAlertUI.b(FindMContactAlertUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label325;
            }
            com.tencent.mm.plugin.b.a.bkD("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactAlertUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.aH(FindMContactAlertUI.this, paramAnonymousString);
            AppMethodBeat.o(109995);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label325:
          FindMContactAlertUI.d(FindMContactAlertUI.this);
          AppMethodBeat.o(109995);
          return;
          Toast.makeText(FindMContactAlertUI.this, FindMContactAlertUI.this.getString(a.i.app_err_system_busy_tip, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
          FindMContactAlertUI.d(FindMContactAlertUI.this);
          AppMethodBeat.o(109995);
          return;
          label390:
          break;
          label393:
          paramAnonymousInt2 = 0;
          paramAnonymousInt1 = 0;
        }
      }
    };
    this.onSceneEndCallback = local9;
    ((t)localObject).a(431, local9);
    localObject = getContext();
    getString(a.i.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a((Context)localObject, getString(a.i.app_loading), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109996);
        if (FindMContactAlertUI.h(FindMContactAlertUI.this) != null)
        {
          com.tencent.mm.kernel.h.aGY().b(431, FindMContactAlertUI.h(FindMContactAlertUI.this));
          FindMContactAlertUI.i(FindMContactAlertUI.this);
          FindMContactAlertUI.j(FindMContactAlertUI.this);
        }
        AppMethodBeat.o(109996);
      }
    });
    com.tencent.mm.kernel.h.aHJ().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(109998);
        for (;;)
        {
          try
          {
            FindMContactAlertUI.a(FindMContactAlertUI.this, com.tencent.mm.pluginsdk.b.dN(FindMContactAlertUI.this));
            StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
            if (FindMContactAlertUI.k(FindMContactAlertUI.this) != null) {
              continue;
            }
            i = 0;
            Log.d("MicroMsg.FindMContactAlertUI", i);
          }
          catch (Exception localException)
          {
            int i;
            Log.printErrStackTrace("MicroMsg.FindMContactAlertUI", localException, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(109998);
          return true;
          i = FindMContactAlertUI.k(FindMContactAlertUI.this).size();
        }
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(109997);
        if ((FindMContactAlertUI.k(FindMContactAlertUI.this) != null) && (FindMContactAlertUI.k(FindMContactAlertUI.this).size() != 0))
        {
          FindMContactAlertUI.a(FindMContactAlertUI.this, new aj(FindMContactAlertUI.a(FindMContactAlertUI.this), FindMContactAlertUI.k(FindMContactAlertUI.this)));
          com.tencent.mm.kernel.h.aGY().a(FindMContactAlertUI.l(FindMContactAlertUI.this), 0);
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
    ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).syncUploadMContactStatus(true, false);
    ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).syncAddrBookAndUpload();
    com.tencent.mm.plugin.report.service.h.IzE.a(11438, new Object[] { Integer.valueOf(1) });
    Log.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(1) });
    AppMethodBeat.o(110010);
  }
  
  private void bxv()
  {
    AppMethodBeat.i(110012);
    com.tencent.mm.plugin.b.a.bkD(this.mTu);
    hideVKB();
    atX(1);
    AppMethodBeat.o(110012);
  }
  
  private void bxz()
  {
    AppMethodBeat.i(110006);
    if (this.mTr)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R300_200_phone,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R300_200_phone") + ",1");
      com.tencent.mm.ui.base.h.a(this, false, getString(a.i.find_mcontact_bind_alert_content), getString(a.i.app_tip), getString(a.i.app_ok), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new FindMContactAlertUI.4
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109987);
          com.tencent.mm.plugin.account.friend.a.l.gX(true);
          com.tencent.mm.plugin.b.a.bkD("R200_100");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("mobile_input_purpose", 4);
          paramAnonymousDialogInterface.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
          com.tencent.mm.plugin.account.sdk.a.mIG.a(FindMContactAlertUI.this, paramAnonymousDialogInterface);
          com.tencent.mm.plugin.b.a.bkD("R300_300_phone");
          paramAnonymousDialogInterface = new StringBuilder();
          com.tencent.mm.kernel.h.aHE();
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.append(com.tencent.mm.kernel.b.aGR()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
          com.tencent.mm.kernel.h.aHE();
          com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R300_200_phone") + ",2");
          AppMethodBeat.o(109987);
        }
      }, new FindMContactAlertUI.4(this));
      AppMethodBeat.o(110006);
      return;
    }
    if (com.tencent.mm.plugin.account.friend.a.l.byh())
    {
      a(a(this.mTv, this.mnu, a.i.find_mcontact_upload_ok, a.i.find_mcontact_upload_learn_more, new FindMContactAlertUI.5(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109992);
          paramAnonymousDialogInterface = new Intent(FindMContactAlertUI.this, FindMContactLearmMoreUI.class);
          paramAnonymousDialogInterface.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
          MMWizardActivity.aH(FindMContactAlertUI.this, paramAnonymousDialogInterface);
          AppMethodBeat.o(109992);
        }
      }));
      AppMethodBeat.o(110006);
      return;
    }
    bxB();
    AppMethodBeat.o(110006);
  }
  
  private View f(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110008);
    if (this.mTw >= 200)
    {
      AppMethodBeat.o(110008);
      return null;
    }
    this.mTw += 1;
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
        localView = f((ViewGroup)localView);
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
    return a.f.findmcontact_intro_with_alert;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110004);
    this.mnu = getString(a.i.find_mcontact_bind_alert_title);
    this.mTv = getString(a.i.find_mcontact_bind_alert_content);
    if (!Util.isNullOrNil(this.mTp)) {
      this.mnu = this.mTp;
    }
    if (!Util.isNullOrNil(this.mTq)) {
      this.mTv = this.mTq;
    }
    this.fLC = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(6, null));
    if ((this.fLC == null) || (this.fLC.equals(""))) {
      this.fLC = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(4097, null));
    }
    AppMethodBeat.o(110004);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110000);
    super.onCreate(paramBundle);
    setMMTitle(a.i.find_mcontact_title);
    com.tencent.mm.plugin.account.sdk.a.mIH.abF();
    this.jaS = getIntent().getStringExtra("regsetinfo_ticket");
    this.mTn = getIntent().getStringExtra("regsetinfo_NextStep");
    this.mTo = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.mTp = getIntent().getStringExtra("alert_title");
    this.mTq = getIntent().getStringExtra("alert_message");
    if (com.tencent.mm.plugin.account.friend.a.l.byi() != l.a.mWk) {}
    for (boolean bool = true;; bool = false)
    {
      this.mTr = bool;
      this.mTu = com.tencent.mm.plugin.b.a.bAt();
      Log.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.mTn, Integer.valueOf(this.mTo) });
      if (!isFinishing()) {
        break;
      }
      AppMethodBeat.o(110000);
      return;
    }
    initView();
    bxz();
    AppMethodBeat.o(110000);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110001);
    Log.d("MicroMsg.FindMContactAlertUI", "ondestroy");
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.h.aGY().b(431, this.onSceneEndCallback);
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
      bxv();
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
    if (this.mTr)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R300_100_QQ") + ",2");
      AppMethodBeat.o(110003);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",RE300_100,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("RE300_100") + ",2");
    AppMethodBeat.o(110003);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110013);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(110013);
      return;
    }
    Log.i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110013);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bxB();
        AppMethodBeat.o(110013);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(a.i.permission_contacts_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new FindMContactAlertUI.2(this), new FindMContactAlertUI.3(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110002);
    super.onResume();
    if (this.mTr)
    {
      com.tencent.mm.plugin.b.a.bgi("R300_100_QQ");
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("R300_100_QQ") + ",1");
      AppMethodBeat.o(110002);
      return;
    }
    com.tencent.mm.plugin.b.a.bgi("R300_100_phone");
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",RE300_100,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("RE300_100") + ",1");
    AppMethodBeat.o(110002);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI
 * JD-Core Version:    0.7.0.1
 */