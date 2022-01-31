package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.b.b.a;
import com.tencent.mm.plugin.ipcall.a.b.d.1;
import com.tencent.mm.plugin.ipcall.a.b.d.a;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

public final class j
  implements b.a, e
{
  ImageView dpY;
  TextView eXu;
  String fsv;
  boolean lAa = false;
  boolean lAb = false;
  private AudioManager lAc = null;
  boolean lAd = false;
  private boolean lAe = true;
  boolean lAf = false;
  DialPad ltd;
  int lvA;
  int lvB;
  String lvw;
  String lvx;
  String lvy;
  String lvz;
  Bitmap lzA;
  EditText lzJ;
  TextView lzK;
  ImageView lzL;
  IPCallFuncButton lzM;
  IPCallFuncButton lzN;
  IPCallFuncButton lzO;
  ImageButton lzP;
  public TextView lzQ;
  public View lzR;
  ImageButton lzS;
  int lzT = -1;
  String lzU;
  IPCallTalkUI lzV;
  com.tencent.mm.plugin.ipcall.c lzW;
  j.a lzX;
  private long lzY;
  long lzZ = -1L;
  
  public j(IPCallTalkUI paramIPCallTalkUI)
  {
    this.lzV = paramIPCallTalkUI;
    this.lzW = i.bcl();
    this.lzW.lof = this;
  }
  
  private void d(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    bdl();
    if (!bk.bl(paramString1)) {}
    for (;;)
    {
      if ((2 == paramInt) && (paramString2 != null)) {
        this.eXu.setText(paramString2);
      }
      while ((1 != paramInt) || (paramString2 == null))
      {
        return;
        if (!bk.bl(paramString3)) {
          break label90;
        }
        paramString1 = this.lzV.getString(R.l.ip_call_alter_tip);
        break;
      }
      h.a(this.lzV, paramString2, paramString1, this.lzV.getString(R.l.ip_call_alter_tip_ok), false, new j.7(this));
      return;
      label90:
      paramString1 = paramString3;
    }
  }
  
  final void FU(String paramString)
  {
    if (!bk.bl(this.fsv))
    {
      dD(this.fsv, com.tencent.mm.plugin.ipcall.b.a.Ge(paramString));
      return;
    }
    dD(com.tencent.mm.plugin.ipcall.b.a.Ge(paramString), "");
  }
  
  public final void bbN()
  {
    y.d("MicroMsg.TalkUIController", "onUserAccept");
    if (i.bck().bcb())
    {
      this.lAa = this.lzO.isChecked();
      this.lAb = this.lzO.isChecked();
      i.bcj().gV(this.lzO.isChecked());
    }
    if (i.bck().bcc()) {
      i.bcj().lqp.setMute(this.lzM.isChecked());
    }
  }
  
  public final void bbO()
  {
    y.d("MicroMsg.TalkUIController", "onOthersideShutdown");
    bdl();
    sT(10);
    au.getNotification().cancel(42);
    if (this.lzX != null) {
      this.lzX.hd(true);
    }
  }
  
  public final void bbP()
  {
    this.lzV.finish();
  }
  
  public final void bbQ()
  {
    this.lzY = i.bcl().bbK();
    sT(5);
  }
  
  public final void bby()
  {
    int j = 0;
    y.i("MicroMsg.TalkUIController", "onInviteSuccess");
    String str1 = i.bcg().loW.lqf;
    String str2 = i.bcg().loW.lqg;
    if ((!bk.bl(str1)) && (!bk.bl(str2)) && (!str1.equals(str2)))
    {
      y.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", new Object[] { str1, str2 });
      FU(str2);
    }
    y.i("MicroMsg.TalkUIController", "callFlag:" + i.bcg().loW.lpT);
    int k = i.bcg().loW.lpT;
    int i = j;
    if ((k & 0x1) > 0)
    {
      i = j;
      if ((k & 0x2) > 0)
      {
        i = j;
        if ((k & 0x8) <= 0) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      y.i("MicroMsg.TalkUIController", "isNotFree");
      h.a(this.lzV, R.l.ipcall_actitivy_out_of_area_desc, R.l.ipcall_actitivy_out_of_area_title, R.l.ipcall_actitivy_out_of_area_continue, R.l.ipcall_actitivy_out_of_area_cancel, true, null, new j.3(this));
    }
    sT(3);
  }
  
  public final void bbz()
  {
    y.d("MicroMsg.TalkUIController", "onStartRing");
    if (i.bck().bcb())
    {
      this.lAa = this.lzO.isChecked();
      this.lAb = this.lzO.isChecked();
      i.bcj().gV(this.lzO.isChecked());
    }
  }
  
  final void bdj()
  {
    i.bcj().bER = this.lzV;
    Object localObject = i.bcj();
    ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).lqq.lqD = ((d.a)localObject);
    localObject = ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).lqq;
    if (!((com.tencent.mm.plugin.ipcall.a.b.d)localObject).iah.uil)
    {
      ((com.tencent.mm.plugin.ipcall.a.b.d)localObject).iah.a((SensorController.a)localObject);
      d.1 local1 = new d.1((com.tencent.mm.plugin.ipcall.a.b.d)localObject);
      if (!((com.tencent.mm.plugin.ipcall.a.b.d)localObject).ial.W(local1)) {
        break label85;
      }
    }
    label85:
    for (((com.tencent.mm.plugin.ipcall.a.b.d)localObject).iam = 0L;; ((com.tencent.mm.plugin.ipcall.a.b.d)localObject).iam = -1L)
    {
      i.bcj().lqt = this;
      i.bcj().a(this);
      return;
    }
  }
  
  final void bdk()
  {
    this.lzJ.setKeyListener(null);
    this.lzJ.setHorizontallyScrolling(true);
    this.ltd.setVisibility(4);
    this.ltd.setTalkUIMode(true);
    if (!bk.bl(this.lzU)) {
      FU(this.lzU);
    }
    if (com.tencent.mm.compatible.util.d.gF(16))
    {
      this.lzJ.setTypeface(Typeface.create("sans-serif-light", 0));
      this.lzK.setTypeface(Typeface.create("sans-serif-light", 0));
    }
    if (!bk.bl(this.lvx)) {
      this.lzA = com.tencent.mm.plugin.ipcall.b.a.f(this.lzV, this.lvx, true);
    }
    if ((this.lzA == null) && (!bk.bl(this.lvw)) && (com.tencent.mm.plugin.ipcall.b.a.WS())) {
      this.lzA = com.tencent.mm.plugin.ipcall.b.a.az(this.lzV, this.lvw);
    }
    if ((this.lzA == null) && (!bk.bl(this.lvz))) {
      this.lzA = com.tencent.mm.ag.b.c(this.lvz, 480, 480, 4);
    }
    if (this.lzA == null)
    {
      this.lzL.setVisibility(0);
      this.dpY.setVisibility(8);
    }
    if (this.lzA != null)
    {
      this.lzL.setVisibility(8);
      this.dpY.setVisibility(0);
      this.dpY.setImageBitmap(this.lzA);
    }
    this.lzS.setOnClickListener(new j.8(this));
    this.lzO.setClickCallback(new j.9(this));
    this.lzM.setClickCallback(new j.10(this));
    this.lzN.setClickCallback(new j.11(this));
    this.lzP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        j.b(j.this);
      }
    });
    this.ltd.setDialButtonClickListener(new j.2(this));
  }
  
  public final void bdl()
  {
    if (this.lzQ != null) {
      this.lzQ.setVisibility(4);
    }
    if (this.lzR != null) {
      this.lzR.setVisibility(4);
    }
  }
  
  public final void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    y.d("MicroMsg.TalkUIController", "onError, error: %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt2 == 1) {
      this.lAe = false;
    }
    if (paramInt1 == 8) {
      if (paramInt2 == 1)
      {
        if (!bk.bl(paramString1)) {
          break label160;
        }
        paramString1 = this.lzV.getString(R.l.ip_call_alter_tip);
      }
    }
    label160:
    for (;;)
    {
      h.a(this.lzV, paramString2, paramString1, this.lzV.getString(R.l.ip_call_alter_tip_ok), false, new j.4(this));
      for (;;)
      {
        au.getNotification().cancel(42);
        if ((this.lzX != null) && (!this.lAf)) {
          this.lzX.hd(this.lAe);
        }
        return;
        d(paramString1, paramString2, paramInt2, this.lzV.getString(R.l.ip_call_alter_account_overdue_tip));
        continue;
        d(paramString1, paramString2, paramInt2, null);
      }
    }
  }
  
  final void dD(String paramString1, String paramString2)
  {
    this.lzJ.setText(paramString1);
    if (!bk.bl(paramString1)) {
      this.lzJ.setSelection(this.lzJ.getText().length() - 1);
    }
    this.lzK.setText(paramString2);
  }
  
  public final void gX(boolean paramBoolean)
  {
    y.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (i.bck().bcb())
    {
      if (paramBoolean)
      {
        i.bcj();
        this.lAa = com.tencent.mm.plugin.ipcall.a.b.a.ys();
        i.bcj().gV(false);
        this.lzO.setEnable(false);
      }
    }
    else {
      return;
    }
    i.bcj().gV(this.lAa);
    this.lzO.setEnable(true);
    this.lzO.setChecked(this.lAa);
  }
  
  public final void gY(boolean paramBoolean)
  {
    y.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (i.bck().bcb())
    {
      if (paramBoolean)
      {
        i.bcj();
        this.lAb = com.tencent.mm.plugin.ipcall.a.b.a.ys();
        i.bcj().gV(false);
        this.lzO.setEnable(false);
      }
    }
    else {
      return;
    }
    i.bcj().gV(this.lAb);
    this.lzO.setEnable(true);
    this.lzO.setChecked(this.lAb);
  }
  
  public final void sT(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      return;
    case 3: 
      paramInt = i.bcg().loW.lpT;
      Object localObject = ae.getContext();
      if (((paramInt & 0x1) > 0) && ((paramInt & 0x2) <= 0)) {
        localObject = ((Context)localObject).getString(R.l.ipcall_talk_free) + " ";
      }
      while (this.lzT != -1)
      {
        String str = com.tencent.mm.plugin.ipcall.b.a.sU(this.lzT);
        this.eXu.setText((String)localObject + this.lzV.getString(R.l.ip_call_status_calling_format, new Object[] { str }));
        return;
        if ((paramInt & 0x8) > 0) {
          localObject = ((Context)localObject).getString(R.l.ipcall_talk_in_package) + " ";
        } else {
          localObject = "";
        }
      }
      this.eXu.setText((String)localObject + this.lzV.getString(R.l.ip_call_status_calling));
      return;
    case 5: 
      this.eXu.setText(String.format("%02d:%02d", new Object[] { Long.valueOf(this.lzY / 60L), Long.valueOf(this.lzY % 60L) }));
      return;
    }
    this.eXu.setText(R.l.ip_call_status_other_side_shutdown);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j
 * JD-Core Version:    0.7.0.1
 */