package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.plugin.account.friend.a.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class FindMContactAddUI
  extends MMWizardActivity
{
  private ProgressDialog eeN;
  private String eiu;
  private TextView emptyTipTv;
  private String guB;
  private int guC;
  private String guI;
  private ListView gvV;
  private i gyS;
  private View gyT;
  private TextView gyU;
  private TextView gyV;
  private TextView gyW;
  private TextView gyX;
  private Button gyY;
  private int gyZ;
  private List<String[]> gza;
  private boolean gzb;
  private i.a gzc;
  private f onSceneEndCallback;
  
  public FindMContactAddUI()
  {
    AppMethodBeat.i(108526);
    this.eeN = null;
    this.emptyTipTv = null;
    this.gyU = null;
    this.gyV = null;
    this.gyW = null;
    this.gyX = null;
    this.gyY = null;
    this.eiu = null;
    this.onSceneEndCallback = null;
    this.guB = "";
    this.guC = 2;
    this.gzb = true;
    this.gzc = new i.a()
    {
      public final void notifyDataSetChanged()
      {
        AppMethodBeat.i(108520);
        if ((FindMContactAddUI.e(FindMContactAddUI.this) != 2) && (FindMContactAddUI.e(FindMContactAddUI.this) == 1))
        {
          FindMContactAddUI.f(FindMContactAddUI.this).setText(FindMContactAddUI.this.getString(2131299924));
          if (!FindMContactAddUI.c(FindMContactAddUI.this).aqm()) {
            break label240;
          }
          if ((FindMContactAddUI.e(FindMContactAddUI.this) != 1) && (FindMContactAddUI.f(FindMContactAddUI.this).getVisibility() == 0) && (FindMContactAddUI.g(FindMContactAddUI.this) != null))
          {
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(8);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(0);
          }
        }
        for (;;)
        {
          if ((FindMContactAddUI.c(FindMContactAddUI.this).getSelectCount() <= 0) || (FindMContactAddUI.e(FindMContactAddUI.this) == 1)) {
            break label302;
          }
          FindMContactAddUI.h(FindMContactAddUI.this).setText(FindMContactAddUI.this.getResources().getQuantityString(2131361797, FindMContactAddUI.c(FindMContactAddUI.this).getSelectCount(), new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getSelectCount()) }));
          AppMethodBeat.o(108520);
          return;
          FindMContactAddUI.f(FindMContactAddUI.this).setText(FindMContactAddUI.this.getString(2131299923, new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getCount()) }));
          break;
          label240:
          if ((FindMContactAddUI.e(FindMContactAddUI.this) != 1) && (FindMContactAddUI.f(FindMContactAddUI.this).getVisibility() == 8) && (FindMContactAddUI.g(FindMContactAddUI.this) != null))
          {
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(0);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(8);
          }
        }
        label302:
        FindMContactAddUI.h(FindMContactAddUI.this).setText(FindMContactAddUI.this.getResources().getQuantityString(2131361800, FindMContactAddUI.c(FindMContactAddUI.this).getCount(), new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getCount()) }));
        AppMethodBeat.o(108520);
      }
    };
    AppMethodBeat.o(108526);
  }
  
  private void apB()
  {
    AppMethodBeat.i(108530);
    com.tencent.mm.plugin.b.a.xD(this.guI);
    hideVKB();
    Oi(1);
    AppMethodBeat.o(108530);
  }
  
  private void aqT()
  {
    AppMethodBeat.i(108528);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131297087);
    this.eeN = h.b(localAppCompatActivity, getString(2131301579), true, new FindMContactAddUI.1(this));
    g.RO().a(new FindMContactAddUI.6(this));
    AppMethodBeat.o(108528);
  }
  
  public int getLayoutId()
  {
    return 2130969585;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108534);
    this.emptyTipTv = ((TextView)findViewById(2131824142));
    this.emptyTipTv.setText(2131301577);
    this.gvV = ((ListView)findViewById(2131824128));
    if ((this.guC != 2) && (this.guC == 1))
    {
      this.gyT = LayoutInflater.from(this).inflate(2130969587, null);
      this.gyU = ((TextView)this.gyT.findViewById(2131824145));
      this.gyV = ((TextView)this.gyT.findViewById(2131824144));
      this.gyW = ((TextView)this.gyT.findViewById(2131824148));
      this.gyY = ((Button)this.gyT.findViewById(2131824147));
      this.gyV.setText(getString(2131299956));
      this.gyW.setText(getString(2131299957));
      this.gyY.setText(getString(2131299924));
    }
    for (;;)
    {
      this.gyS = new i(this, this.gzc, 1);
      this.gyY.setOnClickListener(new FindMContactAddUI.8(this));
      if (this.gyX != null)
      {
        this.gyX.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(108522);
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(0);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(8);
            FindMContactAddUI.c(FindMContactAddUI.this).dw(false);
            FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
            AppMethodBeat.o(108522);
          }
        });
        this.gyX.setVisibility(8);
      }
      this.gvV.addHeaderView(this.gyT);
      this.gvV.setAdapter(this.gyS);
      addTextOptionMenu(0, getString(2131297013), new FindMContactAddUI.10(this));
      setToTop(new FindMContactAddUI.11(this));
      AppMethodBeat.o(108534);
      return;
      this.gyT = LayoutInflater.from(this).inflate(2130969586, null);
      this.gyU = ((TextView)this.gyT.findViewById(2131824145));
      this.gyV = ((TextView)this.gyT.findViewById(2131824144));
      this.gyW = ((TextView)this.gyT.findViewById(2131824148));
      this.gyY = ((Button)this.gyT.findViewById(2131824147));
      this.gyV.setText(getString(2131299956));
      this.gyW.setText(getString(2131299957));
      this.gyY.setText(getString(2131299923, new Object[] { Integer.valueOf(0) }));
      this.gyX = ((TextView)this.gyT.findViewById(2131824146));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108527);
    super.onCreate(paramBundle);
    setMMTitle(2131299928);
    com.tencent.mm.plugin.account.a.a.gmP.BR();
    this.eiu = getIntent().getStringExtra("regsetinfo_ticket");
    this.guB = getIntent().getStringExtra("regsetinfo_NextStep");
    this.guC = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.gyZ = getIntent().getIntExtra("login_type", 0);
    this.guI = com.tencent.mm.plugin.b.a.awy();
    initView();
    AppMethodBeat.o(108527);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108533);
    if (this.onSceneEndCallback != null)
    {
      g.Rc().b(30, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    super.onDestroy();
    AppMethodBeat.o(108533);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(108529);
    if (paramInt == 4)
    {
      apB();
      AppMethodBeat.o(108529);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(108529);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(108532);
    super.onPause();
    if (this.gyZ == 1)
    {
      localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R300_300_QQ") + ",2");
      AppMethodBeat.o(108532);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_300_phone,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R300_300_phone") + ",2");
    AppMethodBeat.o(108532);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(108535);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(108535);
      return;
    }
    ab.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108535);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aqT();
        AppMethodBeat.o(108535);
        return;
      }
      this.gzb = false;
      h.a(this, getString(2131302069), getString(2131302083), getString(2131300996), getString(2131296888), false, new FindMContactAddUI.4(this), new FindMContactAddUI.5(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(108531);
    super.onResume();
    this.gyS.notifyDataSetChanged();
    StringBuilder localStringBuilder;
    if (this.gyZ == 1)
    {
      localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R300_300_QQ") + ",1");
      com.tencent.mm.plugin.b.a.xC("R300_300_QQ");
    }
    while (this.gzb)
    {
      boolean bool = b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
      ab.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY() });
      if (!bool)
      {
        AppMethodBeat.o(108531);
        return;
        localStringBuilder = new StringBuilder();
        g.RJ();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_300_phone,");
        g.RJ();
        com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R300_300_phone") + ",1");
        com.tencent.mm.plugin.b.a.xC("R300_300_phone");
      }
      else
      {
        aqT();
      }
    }
    AppMethodBeat.o(108531);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI
 * JD-Core Version:    0.7.0.1
 */