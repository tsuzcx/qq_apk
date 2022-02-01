package com.tencent.mm.plugin.account.bind.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.bind.a.a;
import com.tencent.mm.plugin.account.bind.a.c;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.ag;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAlertUI
  extends MMWizardActivity
{
  private int X = 0;
  private int Y = 0;
  private String hRk;
  private String lCS = null;
  private ProgressDialog lzP = null;
  private com.tencent.mm.am.h onSceneEndCallback = null;
  private String pPU = "";
  private int pPV = 2;
  private String pPW = null;
  private String pPX = null;
  private boolean pPY = false;
  private List<String[]> pPZ = null;
  private ag pQa;
  private String pQb;
  private String pQc;
  private int pQd = 0;
  private final int pQe = 200;
  private int pQf = 0;
  private int pQg = 0;
  private int pQh = 0;
  private int pQi = 0;
  private String phh;
  
  private e a(String paramString1, String paramString2, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(304875);
    e locale = new e(this, (byte)0);
    locale.setTitle(paramString2);
    locale.setMessage(paramString1);
    locale.a(paramInt1, paramOnClickListener1);
    locale.b(paramInt2, paramOnClickListener2);
    locale.cX(-1, true);
    locale.setCancelable(false);
    locale.show();
    locale.getWindow().clearFlags(2);
    addDialog(locale);
    AppMethodBeat.o(304875);
    return locale;
  }
  
  private void a(final e parame)
  {
    AppMethodBeat.i(110007);
    parame.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(109993);
        parame.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
        int i = parame.getWindow().getDecorView().getMeasuredWidth();
        int j = parame.getWindow().getDecorView().getMeasuredHeight();
        View localView = FindMContactAlertUI.a(FindMContactAlertUI.this, (ViewGroup)parame.getWindow().getDecorView());
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
    parame = findViewById(a.e.background);
    parame.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(109994);
        parame.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        int i = parame.getMeasuredHeight();
        int j = parame.getMeasuredWidth();
        Log.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        FindMContactAlertUI.b(FindMContactAlertUI.this, j, i);
        AppMethodBeat.o(109994);
      }
    });
    AppMethodBeat.o(110007);
  }
  
  private void bWj()
  {
    AppMethodBeat.i(110012);
    com.tencent.mm.plugin.b.a.TA(this.pQb);
    hideVKB();
    aAp(1);
    AppMethodBeat.o(110012);
  }
  
  private void bWo()
  {
    AppMethodBeat.i(110006);
    if (this.pPY)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R300_200_phone,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R300_200_phone") + ",1");
      k.a(this, false, getString(a.i.find_mcontact_bind_alert_content), getString(a.i.app_tip), getString(a.i.app_ok), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109987);
          i.hN(true);
          com.tencent.mm.plugin.b.a.TA("R200_100");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("mobile_input_purpose", 4);
          paramAnonymousDialogInterface.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
          com.tencent.mm.plugin.account.sdk.a.pFn.a(FindMContactAlertUI.this, paramAnonymousDialogInterface);
          com.tencent.mm.plugin.b.a.TA("R300_300_phone");
          paramAnonymousDialogInterface = new StringBuilder();
          com.tencent.mm.kernel.h.baC();
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.append(com.tencent.mm.kernel.b.aZR()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R300_200_phone") + ",2");
          AppMethodBeat.o(109987);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109990);
          i.hN(false);
          paramAnonymousDialogInterface = new StringBuilder();
          com.tencent.mm.kernel.h.baC();
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.append(com.tencent.mm.kernel.b.aZR()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R300_200_phone") + ",2");
          FindMContactAlertUI.d(FindMContactAlertUI.this);
          AppMethodBeat.o(109990);
        }
      });
      AppMethodBeat.o(110006);
      return;
    }
    if (i.bWV())
    {
      a(a(this.pQc, this.phh, a.i.find_mcontact_upload_ok, a.i.find_mcontact_upload_learn_more, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109991);
          i.hN(true);
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
          MMWizardActivity.aQ(FindMContactAlertUI.this, paramAnonymousDialogInterface);
          AppMethodBeat.o(109992);
        }
      }));
      AppMethodBeat.o(110006);
      return;
    }
    bWq();
    AppMethodBeat.o(110006);
  }
  
  private void bWp()
  {
    AppMethodBeat.i(110009);
    int j = getWindowManager().getDefaultDisplay().getHeight();
    int i = this.pQh - (getResources().getDimensionPixelSize(a.c.PopPadding) + com.tencent.mm.cd.a.fromDPToPix(this, 48));
    int k = j / 2;
    int m = this.pQg / 2;
    int n = this.pQi;
    j = com.tencent.mm.cd.a.fromDPToPix(this, 20) + (k + m - (j - n));
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
  
  private void bWq()
  {
    AppMethodBeat.i(110010);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null);
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
    localObject = com.tencent.mm.kernel.h.aZW();
    com.tencent.mm.am.h local9 = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(109995);
        if (FindMContactAlertUI.f(FindMContactAlertUI.this) != null)
        {
          FindMContactAlertUI.f(FindMContactAlertUI.this).dismiss();
          FindMContactAlertUI.g(FindMContactAlertUI.this);
        }
        if (FindMContactAlertUI.h(FindMContactAlertUI.this) != null)
        {
          com.tencent.mm.kernel.h.aZW().b(431, FindMContactAlertUI.h(FindMContactAlertUI.this));
          FindMContactAlertUI.i(FindMContactAlertUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((ag)paramAnonymousp).bXo();
          ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label393;
          }
          paramAnonymousp = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousp.hasNext())
          {
            dib localdib = (dib)paramAnonymousp.next();
            if (localdib != null)
            {
              if (localdib.vhk != 1) {
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
            com.tencent.mm.plugin.b.a.TA("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactAlertUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.aQ(FindMContactAlertUI.this, paramAnonymousString);
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
    ((s)localObject).a(431, local9);
    localObject = getContext();
    getString(a.i.app_tip);
    this.lzP = k.a((Context)localObject, getString(a.i.app_loading), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109996);
        if (FindMContactAlertUI.h(FindMContactAlertUI.this) != null)
        {
          com.tencent.mm.kernel.h.aZW().b(431, FindMContactAlertUI.h(FindMContactAlertUI.this));
          FindMContactAlertUI.i(FindMContactAlertUI.this);
          FindMContactAlertUI.j(FindMContactAlertUI.this);
        }
        AppMethodBeat.o(109996);
      }
    });
    com.tencent.mm.kernel.h.baH().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(109998);
        for (;;)
        {
          try
          {
            FindMContactAlertUI.a(FindMContactAlertUI.this, com.tencent.mm.pluginsdk.b.eI(FindMContactAlertUI.this));
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
          FindMContactAlertUI.a(FindMContactAlertUI.this, new ag(FindMContactAlertUI.a(FindMContactAlertUI.this), FindMContactAlertUI.k(FindMContactAlertUI.this)));
          com.tencent.mm.kernel.h.aZW().a(FindMContactAlertUI.l(FindMContactAlertUI.this), 0);
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
    ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).syncUploadMContactStatus(true, false);
    ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).syncAddrBookAndUpload();
    com.tencent.mm.plugin.report.service.h.OAn.b(11438, new Object[] { Integer.valueOf(1) });
    Log.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(1) });
    AppMethodBeat.o(110010);
  }
  
  private View j(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110008);
    if (this.pQd >= 200)
    {
      AppMethodBeat.o(110008);
      return null;
    }
    this.pQd += 1;
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
        localView = j((ViewGroup)localView);
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
    this.phh = getString(a.i.find_mcontact_bind_alert_title);
    this.pQc = getString(a.i.find_mcontact_bind_alert_content);
    if (!Util.isNullOrNil(this.pPW)) {
      this.phh = this.pPW;
    }
    if (!Util.isNullOrNil(this.pPX)) {
      this.pQc = this.pPX;
    }
    this.hRk = ((String)com.tencent.mm.kernel.h.baE().ban().d(6, null));
    if ((this.hRk == null) || (this.hRk.equals(""))) {
      this.hRk = ((String)com.tencent.mm.kernel.h.baE().ban().d(4097, null));
    }
    AppMethodBeat.o(110004);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110000);
    super.onCreate(paramBundle);
    setMMTitle(a.i.find_mcontact_title);
    com.tencent.mm.plugin.account.sdk.a.pFo.aDA();
    this.lCS = getIntent().getStringExtra("regsetinfo_ticket");
    this.pPU = getIntent().getStringExtra("regsetinfo_NextStep");
    this.pPV = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.pPW = getIntent().getStringExtra("alert_title");
    this.pPX = getIntent().getStringExtra("alert_message");
    if (i.bWW() != i.a.pSQ) {}
    for (boolean bool = true;; bool = false)
    {
      this.pPY = bool;
      this.pQb = com.tencent.mm.plugin.b.a.chY();
      Log.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.pPU, Integer.valueOf(this.pPV) });
      if (!isFinishing()) {
        break;
      }
      AppMethodBeat.o(110000);
      return;
    }
    initView();
    bWo();
    AppMethodBeat.o(110000);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110001);
    Log.d("MicroMsg.FindMContactAlertUI", "ondestroy");
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.h.aZW().b(431, this.onSceneEndCallback);
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
      bWj();
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
    if (this.pPY)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R300_100_QQ") + ",2");
      AppMethodBeat.o(110003);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",RE300_100,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("RE300_100") + ",2");
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
        bWq();
        AppMethodBeat.o(110013);
        return;
      }
      k.a(this, getString(a.i.permission_contacts_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109988);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.pluginsdk.permission.b.lx(FindMContactAlertUI.this.getContext());
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
    if (this.pPY)
    {
      com.tencent.mm.plugin.b.a.Tz("R300_100_QQ");
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("R300_100_QQ") + ",1");
      AppMethodBeat.o(110002);
      return;
    }
    com.tencent.mm.plugin.b.a.Tz("R300_100_phone");
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",RE300_100,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("RE300_100") + ",1");
    AppMethodBeat.o(110002);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI
 * JD-Core Version:    0.7.0.1
 */