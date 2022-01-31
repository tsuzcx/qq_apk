package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class FindMContactInviteUI
  extends MMWizardActivity
{
  private ProgressDialog eeN;
  private TextView emptyTipTv;
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
  private String gze;
  private f onSceneEndCallback;
  
  public FindMContactInviteUI()
  {
    AppMethodBeat.i(108551);
    this.eeN = null;
    this.emptyTipTv = null;
    this.gyU = null;
    this.gyV = null;
    this.gyW = null;
    this.gyX = null;
    this.gyY = null;
    this.gze = null;
    this.onSceneEndCallback = null;
    this.guC = 2;
    this.gzb = true;
    this.gzc = new FindMContactInviteUI.6(this);
    AppMethodBeat.o(108551);
  }
  
  private void apB()
  {
    AppMethodBeat.i(108554);
    com.tencent.mm.plugin.b.a.xD(this.guI);
    hideVKB();
    Oi(1);
    AppMethodBeat.o(108554);
  }
  
  private void aqT()
  {
    AppMethodBeat.i(108556);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131297087);
    this.eeN = h.b(localAppCompatActivity, getString(2131301579), true, new FindMContactInviteUI.1(this));
    g.RO().a(new FindMContactInviteUI.5(this));
    AppMethodBeat.o(108556);
  }
  
  public int getLayoutId()
  {
    return 2130969585;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108559);
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
      this.gyV.setText(getString(2131299934));
      this.gyW.setText(getString(2131299934));
      this.gyY.setText(getString(2131299933));
    }
    for (;;)
    {
      this.gyS = new i(this, this.gzc, 2);
      this.gyY.setOnClickListener(new FindMContactInviteUI.7(this));
      if (this.gyX != null)
      {
        this.gyX.setOnClickListener(new FindMContactInviteUI.8(this));
        this.gyX.setVisibility(8);
      }
      this.gvV.addHeaderView(this.gyT);
      this.gvV.setAdapter(this.gyS);
      this.gvV.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      this.gvV.setOnTouchListener(new FindMContactInviteUI.9(this));
      addTextOptionMenu(0, getString(2131296964), new FindMContactInviteUI.10(this));
      setToTop(new FindMContactInviteUI.11(this));
      AppMethodBeat.o(108559);
      return;
      this.gyT = LayoutInflater.from(this).inflate(2130969586, null);
      this.gyU = ((TextView)this.gyT.findViewById(2131824145));
      this.gyV = ((TextView)this.gyT.findViewById(2131824144));
      this.gyW = ((TextView)this.gyT.findViewById(2131824148));
      this.gyY = ((Button)this.gyT.findViewById(2131824147));
      this.gyV.setText(getString(2131299937));
      this.gyW.setText(getString(2131299934));
      this.gyY.setText(getString(2131299932, new Object[] { Integer.valueOf(0) }));
      this.gyX = ((TextView)this.gyT.findViewById(2131824146));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108552);
    super.onCreate(paramBundle);
    setMMTitle(2131299936);
    com.tencent.mm.plugin.account.a.a.gmP.BR();
    this.gze = getIntent().getStringExtra("regsetinfo_ticket");
    this.gyZ = getIntent().getIntExtra("login_type", 0);
    this.guC = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.guI = com.tencent.mm.plugin.b.a.awy();
    initView();
    AppMethodBeat.o(108552);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108558);
    if (this.onSceneEndCallback != null)
    {
      g.Rc().b(432, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    if (this.gyS != null)
    {
      i locali = this.gyS;
      if (locali.gxo != null)
      {
        locali.gxo.detach();
        locali.gxo = null;
      }
    }
    ((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).clearFriendData();
    super.onDestroy();
    AppMethodBeat.o(108558);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(108553);
    if (paramInt == 4)
    {
      apB();
      AppMethodBeat.o(108553);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(108553);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(108557);
    super.onPause();
    if (this.gyZ == 1)
    {
      localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R300_400_QQ") + ",2");
      AppMethodBeat.o(108557);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_400_phone,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R300_400_phone") + ",2");
    AppMethodBeat.o(108557);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(108560);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(108560);
      return;
    }
    ab.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108560);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aqT();
        AppMethodBeat.o(108560);
        return;
      }
      this.gzb = false;
      h.a(this, getString(2131302069), getString(2131302083), getString(2131300996), getString(2131296888), false, new FindMContactInviteUI.3(this), new FindMContactInviteUI.4(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(108555);
    super.onResume();
    this.gyS.notifyDataSetChanged();
    StringBuilder localStringBuilder;
    if (this.gyZ == 1)
    {
      localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R300_400_QQ") + ",1");
    }
    while (this.gzb)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
      ab.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY() });
      if (!bool)
      {
        AppMethodBeat.o(108555);
        return;
        localStringBuilder = new StringBuilder();
        g.RJ();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_400_phone,");
        g.RJ();
        com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R300_400_phone") + ",1");
      }
      else
      {
        aqT();
      }
    }
    AppMethodBeat.o(108555);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI
 * JD-Core Version:    0.7.0.1
 */