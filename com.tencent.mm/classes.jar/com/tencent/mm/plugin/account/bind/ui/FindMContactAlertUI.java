package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.b.c;
import java.util.List;

public class FindMContactAlertUI
  extends MMWizardActivity
{
  private int X = 0;
  private int Y = 0;
  private String czF;
  private ProgressDialog eeN = null;
  private String eiu = null;
  private String guB = "";
  private int guC = 2;
  private String guD = null;
  private String guE = null;
  private boolean guF = false;
  private List<String[]> guG = null;
  private ag guH;
  private String guI;
  private String guJ;
  private String guK;
  private int guL = 0;
  private final int guM = 200;
  private int guN = 0;
  private int guO = 0;
  private int guP = 0;
  private int guQ = 0;
  private f onSceneEndCallback = null;
  
  private c a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(13581);
    c localc = new c(this);
    localc.setTitle(paramString2);
    localc.setMessage(paramString1);
    localc.a(2131299953, paramOnClickListener1);
    localc.b(2131299948, paramOnClickListener2);
    localc.usy.setVisibility(0);
    localc.setCancelable(false);
    localc.show();
    localc.getWindow().clearFlags(2);
    addDialog(localc);
    AppMethodBeat.o(13581);
    return localc;
  }
  
  private void a(final c paramc)
  {
    AppMethodBeat.i(13583);
    paramc.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(13569);
        paramc.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
        int i = paramc.getWindow().getDecorView().getMeasuredWidth();
        int j = paramc.getWindow().getDecorView().getMeasuredHeight();
        View localView = FindMContactAlertUI.a(FindMContactAlertUI.this, (ViewGroup)paramc.getWindow().getDecorView());
        if (localView != null) {
          i = localView.getMeasuredWidth() * 2;
        }
        for (;;)
        {
          ab.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          FindMContactAlertUI.a(FindMContactAlertUI.this, i, j);
          AppMethodBeat.o(13569);
          return;
        }
      }
    });
    paramc = findViewById(2131824152);
    paramc.getViewTreeObserver().addOnGlobalLayoutListener(new FindMContactAlertUI.8(this, paramc));
    AppMethodBeat.o(13583);
  }
  
  private void apB()
  {
    AppMethodBeat.i(13588);
    com.tencent.mm.plugin.b.a.xD(this.guI);
    hideVKB();
    Oi(1);
    AppMethodBeat.o(13588);
  }
  
  private void apF()
  {
    AppMethodBeat.i(13582);
    if (this.guF)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_200_phone,");
      g.RJ();
      com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R300_200_phone") + ",1");
      com.tencent.mm.ui.base.h.a(this, false, getString(2131299929), getString(2131297087), getString(2131297018), getString(2131296888), new DialogInterface.OnClickListener()new FindMContactAlertUI.4
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(13563);
          l.dx(true);
          com.tencent.mm.plugin.b.a.xD("R200_100");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("mobile_input_purpose", 4);
          paramAnonymousDialogInterface.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
          com.tencent.mm.plugin.account.a.a.gmO.a(FindMContactAlertUI.this, paramAnonymousDialogInterface);
          com.tencent.mm.plugin.b.a.xD("R300_300_phone");
          paramAnonymousDialogInterface = new StringBuilder();
          g.RJ();
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.append(com.tencent.mm.kernel.a.QX()).append(",").append(FindMContactAlertUI.this.getClass().getName()).append(",R300_200_phone,");
          g.RJ();
          com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R300_200_phone") + ",2");
          AppMethodBeat.o(13563);
        }
      }, new FindMContactAlertUI.4(this));
      AppMethodBeat.o(13582);
      return;
    }
    if (l.aqp())
    {
      a(a(this.guK, this.guJ, new FindMContactAlertUI.5(this), new FindMContactAlertUI.6(this)));
      AppMethodBeat.o(13582);
      return;
    }
    apH();
    AppMethodBeat.o(13582);
  }
  
  private void apG()
  {
    AppMethodBeat.i(13585);
    int j = getWindowManager().getDefaultDisplay().getHeight();
    int i = this.guP - (getResources().getDimensionPixelSize(2131427814) + com.tencent.mm.cb.a.fromDPToPix(this, 48));
    int k = j / 2;
    int m = this.guO / 2;
    int n = this.guQ;
    j = com.tencent.mm.cb.a.fromDPToPix(this, 20) + (k + m - (j - n));
    if ((i != this.X) || (j != this.Y))
    {
      this.X = i;
      this.Y = j;
      View localView = findViewById(2131824153);
      localView.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.setMargins(i - localView.getMeasuredWidth() / 2, j, 0, 0);
      ab.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localView.getMeasuredWidth()) });
      localView.setLayoutParams(localLayoutParams);
      localView.startAnimation(AnimationUtils.loadAnimation(this, 2131034148));
    }
    AppMethodBeat.o(13585);
  }
  
  private void apH()
  {
    AppMethodBeat.i(13586);
    boolean bool = b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ab.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY() });
    if (!bool)
    {
      AppMethodBeat.o(13586);
      return;
    }
    Object localObject = findViewById(2131824153);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = g.Rc();
    FindMContactAlertUI.9 local9 = new FindMContactAlertUI.9(this);
    this.onSceneEndCallback = local9;
    ((p)localObject).a(431, local9);
    localObject = getContext();
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131296987), true, new FindMContactAlertUI.10(this));
    g.RO().a(new FindMContactAlertUI.11(this));
    ((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
    ((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
    com.tencent.mm.plugin.report.service.h.qsU.e(11438, new Object[] { Integer.valueOf(1) });
    ab.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(1) });
    AppMethodBeat.o(13586);
  }
  
  private View f(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(13584);
    if (this.guL >= 200)
    {
      AppMethodBeat.o(13584);
      return null;
    }
    this.guL += 1;
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof Button))
      {
        AppMethodBeat.o(13584);
        return localView;
      }
      if ((localView instanceof ViewGroup))
      {
        localView = f((ViewGroup)localView);
        if (localView != null)
        {
          AppMethodBeat.o(13584);
          return localView;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(13584);
    return null;
  }
  
  public int getLayoutId()
  {
    return 2130969590;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13580);
    this.guJ = getString(2131299930);
    this.guK = getString(2131299929);
    if (!bo.isNullOrNil(this.guD)) {
      this.guJ = this.guD;
    }
    if (!bo.isNullOrNil(this.guE)) {
      this.guK = this.guE;
    }
    this.czF = ((String)g.RL().Ru().get(6, null));
    if ((this.czF == null) || (this.czF.equals(""))) {
      this.czF = ((String)g.RL().Ru().get(4097, null));
    }
    AppMethodBeat.o(13580);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13576);
    super.onCreate(paramBundle);
    setMMTitle(2131299946);
    com.tencent.mm.plugin.account.a.a.gmP.BR();
    this.eiu = getIntent().getStringExtra("regsetinfo_ticket");
    this.guB = getIntent().getStringExtra("regsetinfo_NextStep");
    this.guC = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.guD = getIntent().getStringExtra("alert_title");
    this.guE = getIntent().getStringExtra("alert_message");
    if (l.aqq() != l.a.gxB) {}
    for (boolean bool = true;; bool = false)
    {
      this.guF = bool;
      this.guI = com.tencent.mm.plugin.b.a.awy();
      ab.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.guB, Integer.valueOf(this.guC) });
      if (!isFinishing()) {
        break;
      }
      AppMethodBeat.o(13576);
      return;
    }
    initView();
    apF();
    AppMethodBeat.o(13576);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13577);
    ab.d("MicroMsg.FindMContactAlertUI", "ondestroy");
    if (this.onSceneEndCallback != null)
    {
      g.Rc().b(431, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    super.onDestroy();
    AppMethodBeat.o(13577);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(13587);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      apB();
      AppMethodBeat.o(13587);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(13587);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(13579);
    super.onPause();
    if (this.guF)
    {
      localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R300_100_QQ") + ",2");
      AppMethodBeat.o(13579);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",RE300_100,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("RE300_100") + ",2");
    AppMethodBeat.o(13579);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(13589);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(13589);
      return;
    }
    ab.i("MicroMsg.FindMContactAlertUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(13589);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        apH();
        AppMethodBeat.o(13589);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302069), getString(2131302083), getString(2131300996), getString(2131296888), false, new FindMContactAlertUI.2(this), new FindMContactAlertUI.3(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13578);
    super.onResume();
    if (this.guF)
    {
      com.tencent.mm.plugin.b.a.xC("R300_100_QQ");
      localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R300_100_QQ") + ",1");
      AppMethodBeat.o(13578);
      return;
    }
    com.tencent.mm.plugin.b.a.xC("R300_100_phone");
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",RE300_100,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("RE300_100") + ",1");
    AppMethodBeat.o(13578);
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