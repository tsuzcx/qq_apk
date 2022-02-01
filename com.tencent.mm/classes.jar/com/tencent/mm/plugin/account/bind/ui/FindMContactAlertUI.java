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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cik;
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
  private String dSf;
  private ProgressDialog gtM = null;
  private String gwF = null;
  private String jxR;
  private String kbO = "";
  private int kbP = 2;
  private String kbQ = null;
  private String kbR = null;
  private boolean kbS = false;
  private List<String[]> kbT = null;
  private aj kbU;
  private String kbV;
  private String kbW;
  private int kbX = 0;
  private final int kbY = 200;
  private int kbZ = 0;
  private int kca = 0;
  private int kcb = 0;
  private int kcc = 0;
  private i onSceneEndCallback = null;
  
  private d a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(110005);
    d locald = new d(this, (byte)0);
    locald.setTitle(paramString2);
    locald.setMessage(paramString1);
    locald.a(2131759474, paramOnClickListener1);
    locald.b(2131759469, paramOnClickListener2);
    locald.bT(-1, true);
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
          Log.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          FindMContactAlertUI.a(FindMContactAlertUI.this, i, j);
          AppMethodBeat.o(109993);
          return;
        }
      }
    });
    paramd = findViewById(2131297171);
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
  
  private void bnm()
  {
    AppMethodBeat.i(110012);
    com.tencent.mm.plugin.b.a.bwV(this.kbV);
    hideVKB();
    ala(1);
    AppMethodBeat.o(110012);
  }
  
  private void bnq()
  {
    AppMethodBeat.i(110006);
    if (this.kbS)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_200_phone,");
      g.aAf();
      com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R300_200_phone") + ",1");
      com.tencent.mm.ui.base.h.a(this, false, getString(2131759450), getString(2131755998), getString(2131755921), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109987);
          com.tencent.mm.plugin.account.friend.a.l.gl(true);
          com.tencent.mm.plugin.b.a.bwV("R200_100");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("mobile_input_purpose", 4);
          paramAnonymousDialogInterface.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
          com.tencent.mm.plugin.account.a.a.jRt.a(FindMContactAlertUI.this, paramAnonymousDialogInterface);
          com.tencent.mm.plugin.b.a.bwV("R300_300_phone");
          paramAnonymousDialogInterface = new StringBuilder();
          g.aAf();
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.append(com.tencent.mm.kernel.a.azt()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
          g.aAf();
          com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R300_200_phone") + ",2");
          AppMethodBeat.o(109987);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109990);
          com.tencent.mm.plugin.account.friend.a.l.gl(false);
          paramAnonymousDialogInterface = new StringBuilder();
          g.aAf();
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.append(com.tencent.mm.kernel.a.azt()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
          g.aAf();
          com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R300_200_phone") + ",2");
          FindMContactAlertUI.d(FindMContactAlertUI.this);
          AppMethodBeat.o(109990);
        }
      });
      AppMethodBeat.o(110006);
      return;
    }
    if (com.tencent.mm.plugin.account.friend.a.l.bnY())
    {
      a(a(this.kbW, this.jxR, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109991);
          com.tencent.mm.plugin.account.friend.a.l.gl(true);
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
          MMWizardActivity.ay(FindMContactAlertUI.this, paramAnonymousDialogInterface);
          AppMethodBeat.o(109992);
        }
      }));
      AppMethodBeat.o(110006);
      return;
    }
    bns();
    AppMethodBeat.o(110006);
  }
  
  private void bnr()
  {
    AppMethodBeat.i(110009);
    int j = getWindowManager().getDefaultDisplay().getHeight();
    int i = this.kcb - (getResources().getDimensionPixelSize(2131165541) + com.tencent.mm.cb.a.fromDPToPix(this, 48));
    int k = j / 2;
    int m = this.kca / 2;
    int n = this.kcc;
    j = com.tencent.mm.cb.a.fromDPToPix(this, 20) + (k + m - (j - n));
    if ((i != this.X) || (j != this.Y))
    {
      this.X = i;
      this.Y = j;
      View localView = findViewById(2131301516);
      localView.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.setMargins(i - localView.getMeasuredWidth() / 2, j, 0, 0);
      Log.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localView.getMeasuredWidth()) });
      localView.setLayoutParams(localLayoutParams);
      localView.startAnimation(AnimationUtils.loadAnimation(this, 2130772013));
    }
    AppMethodBeat.o(110009);
  }
  
  private void bns()
  {
    AppMethodBeat.i(110010);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    Log.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (!bool)
    {
      AppMethodBeat.o(110010);
      return;
    }
    Object localObject = findViewById(2131301516);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = g.azz();
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
          g.azz().b(431, FindMContactAlertUI.h(FindMContactAlertUI.this));
          FindMContactAlertUI.i(FindMContactAlertUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((aj)paramAnonymousq).bor();
          ((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label392;
          }
          paramAnonymousq = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousq.hasNext())
          {
            cik localcik = (cik)paramAnonymousq.next();
            if (localcik != null)
            {
              if (localcik.oTW != 1) {
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
            Log.d("MicroMsg.FindMContactAlertUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactAlertUI.b(FindMContactAlertUI.this) == null) || (!FindMContactAlertUI.b(FindMContactAlertUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label325;
            }
            com.tencent.mm.plugin.b.a.bwV("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactAlertUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.ay(FindMContactAlertUI.this, paramAnonymousString);
            AppMethodBeat.o(109995);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label325:
          FindMContactAlertUI.d(FindMContactAlertUI.this);
          AppMethodBeat.o(109995);
          return;
          Toast.makeText(FindMContactAlertUI.this, FindMContactAlertUI.this.getString(2131755804, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
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
    ((t)localObject).a(431, local9);
    localObject = getContext();
    getString(2131755998);
    this.gtM = com.tencent.mm.ui.base.h.a((Context)localObject, getString(2131755886), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109996);
        if (FindMContactAlertUI.h(FindMContactAlertUI.this) != null)
        {
          g.azz().b(431, FindMContactAlertUI.h(FindMContactAlertUI.this));
          FindMContactAlertUI.i(FindMContactAlertUI.this);
          FindMContactAlertUI.j(FindMContactAlertUI.this);
        }
        AppMethodBeat.o(109996);
      }
    });
    g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(109998);
        for (;;)
        {
          try
          {
            FindMContactAlertUI.a(FindMContactAlertUI.this, com.tencent.mm.pluginsdk.b.dO(FindMContactAlertUI.this));
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
          g.azz().a(FindMContactAlertUI.l(FindMContactAlertUI.this), 0);
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
    ((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
    ((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
    com.tencent.mm.plugin.report.service.h.CyF.a(11438, new Object[] { Integer.valueOf(1) });
    Log.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(1) });
    AppMethodBeat.o(110010);
  }
  
  private View e(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110008);
    if (this.kbX >= 200)
    {
      AppMethodBeat.o(110008);
      return null;
    }
    this.kbX += 1;
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
    return 2131494685;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110004);
    this.jxR = getString(2131759451);
    this.kbW = getString(2131759450);
    if (!Util.isNullOrNil(this.kbQ)) {
      this.jxR = this.kbQ;
    }
    if (!Util.isNullOrNil(this.kbR)) {
      this.kbW = this.kbR;
    }
    this.dSf = ((String)g.aAh().azQ().get(6, null));
    if ((this.dSf == null) || (this.dSf.equals(""))) {
      this.dSf = ((String)g.aAh().azQ().get(4097, null));
    }
    AppMethodBeat.o(110004);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110000);
    super.onCreate(paramBundle);
    setMMTitle(2131759467);
    com.tencent.mm.plugin.account.a.a.jRu.Xc();
    this.gwF = getIntent().getStringExtra("regsetinfo_ticket");
    this.kbO = getIntent().getStringExtra("regsetinfo_NextStep");
    this.kbP = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.kbQ = getIntent().getStringExtra("alert_title");
    this.kbR = getIntent().getStringExtra("alert_message");
    if (com.tencent.mm.plugin.account.friend.a.l.bnZ() != l.a.keL) {}
    for (boolean bool = true;; bool = false)
    {
      this.kbS = bool;
      this.kbV = com.tencent.mm.plugin.b.a.bpZ();
      Log.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.kbO, Integer.valueOf(this.kbP) });
      if (!isFinishing()) {
        break;
      }
      AppMethodBeat.o(110000);
      return;
    }
    initView();
    bnq();
    AppMethodBeat.o(110000);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110001);
    Log.d("MicroMsg.FindMContactAlertUI", "ondestroy");
    if (this.onSceneEndCallback != null)
    {
      g.azz().b(431, this.onSceneEndCallback);
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
      bnm();
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
    if (this.kbS)
    {
      localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R300_100_QQ") + ",2");
      AppMethodBeat.o(110003);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE300_100,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("RE300_100") + ",2");
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
        bns();
        AppMethodBeat.o(110013);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763866), getString(2131763890), getString(2131762043), getString(2131755761), false, new FindMContactAlertUI.2(this), new FindMContactAlertUI.3(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110002);
    super.onResume();
    if (this.kbS)
    {
      com.tencent.mm.plugin.b.a.bwU("R300_100_QQ");
      localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R300_100_QQ") + ",1");
      AppMethodBeat.o(110002);
      return;
    }
    com.tencent.mm.plugin.b.a.bwU("R300_100_phone");
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE300_100,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("RE300_100") + ",1");
    AppMethodBeat.o(110002);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI
 * JD-Core Version:    0.7.0.1
 */