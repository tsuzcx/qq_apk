package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
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
import com.tencent.mm.ui.base.h;
import java.util.List;

public class FindMContactIntroUI
  extends MMWizardActivity
{
  private String czF;
  private ProgressDialog eeN = null;
  private String eiu = null;
  private String guB = "";
  private int guC = 2;
  private boolean guF = false;
  private List<String[]> guG = null;
  private ag guH;
  private String guI;
  private Button guU;
  private TextView guV;
  private TextView guW;
  private f onSceneEndCallback = null;
  
  private void apB()
  {
    AppMethodBeat.i(13617);
    com.tencent.mm.plugin.b.a.xD(this.guI);
    hideVKB();
    Oi(1);
    AppMethodBeat.o(13617);
  }
  
  private void apH()
  {
    AppMethodBeat.i(13615);
    boolean bool = b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ab.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY() });
    if (!bool)
    {
      AppMethodBeat.o(13615);
      return;
    }
    Object localObject = g.Rc();
    FindMContactIntroUI.9 local9 = new FindMContactIntroUI.9(this);
    this.onSceneEndCallback = local9;
    ((p)localObject).a(431, local9);
    localObject = getContext();
    getString(2131297087);
    this.eeN = h.b((Context)localObject, getString(2131296987), true, new FindMContactIntroUI.10(this));
    g.RO().a(new FindMContactIntroUI.11(this));
    AppMethodBeat.o(13615);
  }
  
  public int getLayoutId()
  {
    return 2130969588;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13614);
    this.guU = ((Button)findViewById(2131824149));
    this.guW = ((TextView)findViewById(2131824151));
    this.guV = ((TextView)findViewById(2131824150));
    if ((this.guB != null) && (this.guB.contains("2"))) {
      this.guV.setText(getString(2131299926));
    }
    for (;;)
    {
      this.czF = ((String)g.RL().Ru().get(6, null));
      if ((this.czF == null) || (this.czF.equals(""))) {
        this.czF = ((String)g.RL().Ru().get(4097, null));
      }
      this.guU.setOnClickListener(new FindMContactIntroUI.1(this));
      this.guW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(13600);
          h.d(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(2131299943), null, FindMContactIntroUI.this.getString(2131299944), FindMContactIntroUI.this.getString(2131299942), new FindMContactIntroUI.4.1(this), new FindMContactIntroUI.4.2(this));
          AppMethodBeat.o(13600);
        }
      });
      AppMethodBeat.o(13614);
      return;
      this.guV.setText(getString(2131299927));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13610);
    super.onCreate(paramBundle);
    setMMTitle(2131299946);
    com.tencent.mm.plugin.account.a.a.gmP.BR();
    this.eiu = getIntent().getStringExtra("regsetinfo_ticket");
    this.guB = getIntent().getStringExtra("regsetinfo_NextStep");
    this.guC = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    if (l.aqq() != l.a.gxB) {}
    for (boolean bool = true;; bool = false)
    {
      this.guF = bool;
      this.guI = com.tencent.mm.plugin.b.a.awy();
      ab.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.guB, Integer.valueOf(this.guC) });
      AppMethodBeat.o(13610);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13611);
    if (this.onSceneEndCallback != null)
    {
      g.Rc().b(431, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    super.onDestroy();
    AppMethodBeat.o(13611);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(13616);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      apB();
      AppMethodBeat.o(13616);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(13616);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(13613);
    super.onPause();
    com.tencent.mm.plugin.b.a.xD("RE900_100");
    if (this.guF)
    {
      localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R300_100_QQ") + ",4");
      AppMethodBeat.o(13613);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R300_100_phone") + ",4");
    AppMethodBeat.o(13613);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(13618);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(13618);
      return;
    }
    ab.i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(13618);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        apH();
        AppMethodBeat.o(13618);
        return;
      }
      h.a(this, getString(2131302069), getString(2131302083), getString(2131300996), getString(2131296888), false, new FindMContactIntroUI.2(this), new FindMContactIntroUI.3(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13612);
    super.onResume();
    initView();
    if (this.guF)
    {
      localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R300_100_QQ") + ",1");
      com.tencent.mm.plugin.b.a.xC("R300_100_QQ");
      AppMethodBeat.o(13612);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R300_100_phone") + ",1");
    com.tencent.mm.plugin.b.a.xC("R300_100_phone");
    AppMethodBeat.o(13612);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI
 * JD-Core Version:    0.7.0.1
 */