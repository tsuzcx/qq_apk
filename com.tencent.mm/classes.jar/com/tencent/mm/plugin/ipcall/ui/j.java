package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.b.b.a;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class j
  implements b.a, e
{
  ImageView ehv;
  private String gJX;
  private TextView gpr;
  private String mCountryCode;
  DialPad nQw;
  private String nSM;
  private String nSN;
  private String nSO;
  private int nSP;
  private int nSQ;
  Bitmap nWM;
  EditText nWV;
  TextView nWW;
  ImageView nWX;
  private IPCallFuncButton nWY;
  private IPCallFuncButton nWZ;
  private IPCallFuncButton nXa;
  private ImageButton nXb;
  public TextView nXc;
  public View nXd;
  private ImageButton nXe;
  private int nXf;
  String nXg;
  IPCallTalkUI nXh;
  com.tencent.mm.plugin.ipcall.c nXi;
  j.a nXj;
  private long nXk;
  long nXl;
  boolean nXm;
  boolean nXn;
  private AudioManager nXo;
  private boolean nXp;
  private boolean nXq;
  private boolean nXr;
  
  public j(IPCallTalkUI paramIPCallTalkUI)
  {
    AppMethodBeat.i(22411);
    this.nXf = -1;
    this.nXl = -1L;
    this.nXm = false;
    this.nXn = false;
    this.nXo = null;
    this.nXp = false;
    this.nXq = true;
    this.nXr = false;
    this.nXh = paramIPCallTalkUI;
    this.nXi = i.bJs();
    this.nXi.nLC = this;
    AppMethodBeat.o(22411);
  }
  
  private void bKA()
  {
    AppMethodBeat.i(22422);
    this.nXf = com.tencent.mm.plugin.ipcall.b.a.eW(this.nSN, this.nSM);
    xV(1);
    this.nXi.a(this.gJX, this.nSM, this.nSO, this.nXg, this.nSN, this.nXf, this.nSP, this.nSQ);
    ab.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", new Object[] { this.nXg });
    i.bJp().setCountryCode(this.mCountryCode);
    AppMethodBeat.o(22422);
  }
  
  private void bKB()
  {
    AppMethodBeat.i(22423);
    if (i.bJn().nMs != null)
    {
      this.gJX = i.bJn().nMs.nickname;
      this.nXg = i.bJn().nMs.nNB;
      this.nSO = i.bJn().nMs.cGY;
      this.nSN = i.bJn().nMs.cJk;
      this.nSM = i.bJn().nMs.nNA;
      this.nXf = i.bJn().nMs.nND;
      ab.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", new Object[] { this.gJX, this.nXg, this.nSO, this.nSN, this.nSM, Integer.valueOf(this.nXf) });
    }
    AppMethodBeat.o(22423);
  }
  
  private void bKC()
  {
    AppMethodBeat.i(22424);
    i.bJr();
    ab.i("MicroMsg.TalkUIController", f.stateToString(i.bJr().mCurrentState));
    xV(i.bJr().mCurrentState);
    bKE();
    bKD();
    AppMethodBeat.o(22424);
  }
  
  private void bKD()
  {
    AppMethodBeat.i(22425);
    if (i.bJr().bJi())
    {
      IPCallFuncButton localIPCallFuncButton = this.nXa;
      i.bJq();
      localIPCallFuncButton.setChecked(com.tencent.mm.plugin.ipcall.a.b.a.KM());
      this.nWY.setChecked(i.bJq().nNL.efg);
    }
    AppMethodBeat.o(22425);
  }
  
  private void bKE()
  {
    AppMethodBeat.i(22426);
    String str1 = i.bJn().nMs.nNB;
    String str2 = i.bJn().nMs.nNC;
    if (!bo.isNullOrNil(str2))
    {
      Rw(str2);
      this.nWW.setText(com.tencent.mm.plugin.ipcall.b.a.RG(str2));
      AppMethodBeat.o(22426);
      return;
    }
    if (!bo.isNullOrNil(str1))
    {
      Rw(str1);
      this.nWW.setText(com.tencent.mm.plugin.ipcall.b.a.RG(str1));
    }
    AppMethodBeat.o(22426);
  }
  
  private void bKu()
  {
    AppMethodBeat.i(22413);
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(12058, this.mCountryCode);
    com.tencent.mm.ui.base.h.a(this.nXh, this.nXh.getString(2131297832), this.nXh.getString(2131297833), false, new j.6(this));
    AppMethodBeat.o(22413);
  }
  
  private void bKv()
  {
    AppMethodBeat.i(22415);
    if ((!bo.isNullOrNil(this.mCountryCode)) && (!com.tencent.mm.plugin.ipcall.b.a.RE(this.nSM)))
    {
      this.nXg = (this.mCountryCode + this.nSM);
      if (!this.nXg.startsWith("+"))
      {
        this.nXg = ("+" + this.nXg);
        AppMethodBeat.o(22415);
      }
    }
    else
    {
      this.nXg = this.nSM;
    }
    AppMethodBeat.o(22415);
  }
  
  private void bKw()
  {
    AppMethodBeat.i(22416);
    i.bJq().cmc = this.nXh;
    i.bJq().bJF();
    i.bJq().nNP = this;
    i.bJq().a(this);
    AppMethodBeat.o(22416);
  }
  
  private void bKx()
  {
    AppMethodBeat.i(22417);
    this.nWV.setKeyListener(null);
    this.nWV.setHorizontallyScrolling(true);
    this.nQw.setVisibility(4);
    this.nQw.setTalkUIMode(true);
    bKy();
    bKz();
    AppMethodBeat.o(22417);
  }
  
  private void bKy()
  {
    AppMethodBeat.i(22419);
    if (!bo.isNullOrNil(this.nXg)) {
      Rw(this.nXg);
    }
    if (d.fv(16))
    {
      this.nWV.setTypeface(Typeface.create("sans-serif-light", 0));
      this.nWW.setTypeface(Typeface.create("sans-serif-light", 0));
    }
    if (!bo.isNullOrNil(this.nSN)) {
      this.nWM = com.tencent.mm.plugin.ipcall.b.a.f(this.nXh, this.nSN, true);
    }
    if ((this.nWM == null) && (!bo.isNullOrNil(this.nSM)) && (com.tencent.mm.plugin.ipcall.b.a.aqt())) {
      this.nWM = com.tencent.mm.plugin.ipcall.b.a.aI(this.nXh, this.nSM);
    }
    if ((this.nWM == null) && (!bo.isNullOrNil(this.nSO))) {
      this.nWM = com.tencent.mm.ah.b.d(this.nSO, 480, 480, 4);
    }
    if (this.nWM == null)
    {
      this.nWX.setVisibility(0);
      this.ehv.setVisibility(8);
    }
    if (this.nWM != null)
    {
      this.nWX.setVisibility(8);
      this.ehv.setVisibility(0);
      this.ehv.setImageBitmap(this.nWM);
    }
    this.nXe.setOnClickListener(new j.8(this));
    this.nXa.setClickCallback(new j.9(this));
    this.nWY.setClickCallback(new j.10(this));
    this.nWZ.setClickCallback(new j.11(this));
    this.nXb.setOnClickListener(new j.12(this));
    AppMethodBeat.o(22419);
  }
  
  private void bKz()
  {
    AppMethodBeat.i(22420);
    this.nQw.setDialButtonClickListener(new DialPad.a()
    {
      public final void Rh(String paramAnonymousString)
      {
        AppMethodBeat.i(22400);
        String str2 = j.this.nWV.getText().toString();
        if (bo.isNullOrNil(str2)) {
          j.this.nXl = System.currentTimeMillis();
        }
        long l = System.currentTimeMillis();
        String str1 = str2;
        if (l - j.this.nXl >= 3000L) {
          str1 = str2 + " ";
        }
        str1 = str1 + paramAnonymousString;
        j.this.nXl = l;
        j.this.eV(str1, "");
        com.tencent.mm.plugin.ipcall.c.QV(paramAnonymousString);
        com.tencent.mm.plugin.report.service.h.qsU.e(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        AppMethodBeat.o(22400);
      }
      
      public final void Ri(String paramAnonymousString) {}
    });
    AppMethodBeat.o(22420);
  }
  
  private void d(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(22414);
    bKF();
    if (!bo.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if ((2 == paramInt) && (paramString2 != null))
      {
        this.gpr.setText(paramString2);
        AppMethodBeat.o(22414);
        return;
        if (bo.isNullOrNil(paramString3)) {
          paramString1 = this.nXh.getString(2131300831);
        }
      }
      else
      {
        if ((1 == paramInt) && (paramString2 != null)) {
          com.tencent.mm.ui.base.h.a(this.nXh, paramString2, paramString1, this.nXh.getString(2131300832), false, new j.7(this));
        }
        AppMethodBeat.o(22414);
        return;
      }
      paramString1 = paramString3;
    }
  }
  
  private void xV(int paramInt)
  {
    AppMethodBeat.i(22427);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22427);
      return;
      AppMethodBeat.o(22427);
      return;
      String str1 = com.tencent.mm.plugin.ipcall.b.c.xY(i.bJn().nMs.nNp);
      if (this.nXf != -1)
      {
        String str2 = com.tencent.mm.plugin.ipcall.b.a.xW(this.nXf);
        this.gpr.setText(str1 + this.nXh.getString(2131300896, new Object[] { str2 }));
        AppMethodBeat.o(22427);
        return;
      }
      this.gpr.setText(str1 + this.nXh.getString(2131300895));
      AppMethodBeat.o(22427);
      return;
      AppMethodBeat.o(22427);
      return;
      this.gpr.setText(String.format("%02d:%02d", new Object[] { Long.valueOf(this.nXk / 60L), Long.valueOf(this.nXk % 60L) }));
      AppMethodBeat.o(22427);
      return;
      this.gpr.setText(2131300899);
    }
  }
  
  final void Rw(String paramString)
  {
    AppMethodBeat.i(22418);
    if (!bo.isNullOrNil(this.gJX))
    {
      eV(this.gJX, com.tencent.mm.plugin.ipcall.b.a.RG(paramString));
      AppMethodBeat.o(22418);
      return;
    }
    eV(com.tencent.mm.plugin.ipcall.b.a.RG(paramString), "");
    AppMethodBeat.o(22418);
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(22412);
    this.nXp = this.nXh.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
    ab.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Boolean.valueOf(this.nXp) });
    this.nWX = ((ImageView)this.nXh.findViewById(2131825230));
    this.ehv = ((ImageView)this.nXh.findViewById(2131825231));
    this.nWV = ((EditText)this.nXh.findViewById(2131825223));
    this.gpr = ((TextView)this.nXh.findViewById(2131825220));
    this.nWW = ((TextView)this.nXh.findViewById(2131825228));
    this.nWY = ((IPCallFuncButton)this.nXh.findViewById(2131825225));
    this.nWZ = ((IPCallFuncButton)this.nXh.findViewById(2131825226));
    this.nXa = ((IPCallFuncButton)this.nXh.findViewById(2131825227));
    this.nXb = ((ImageButton)this.nXh.findViewById(2131825232));
    this.nXe = ((ImageButton)this.nXh.findViewById(2131825233));
    this.nXc = ((TextView)this.nXh.findViewById(2131825222));
    this.nXd = this.nXh.findViewById(2131825221);
    this.nQw = ((DialPad)this.nXh.findViewById(2131825219));
    if (this.nXp)
    {
      bKB();
      bKw();
      bKx();
      bKC();
      AppMethodBeat.o(22412);
      return;
    }
    if (i.bJr().bJh())
    {
      com.tencent.mm.ui.base.h.a(this.nXh, 2131300736, 2131297087, false, new j.1(this));
      AppMethodBeat.o(22412);
      return;
    }
    bKw();
    this.gJX = paramString1;
    this.nSM = paramString2;
    this.nSN = paramString3;
    this.mCountryCode = paramString4;
    this.nSP = paramInt1;
    this.nSQ = paramInt2;
    if (!bo.isNullOrNil(this.nSM)) {
      this.nSM = com.tencent.mm.plugin.ipcall.b.c.RK(this.nSM);
    }
    if (bo.isNullOrNil(this.mCountryCode)) {
      if (com.tencent.mm.plugin.ipcall.b.a.RE(this.nSM))
      {
        paramString1 = com.tencent.mm.plugin.ipcall.b.a.RC(this.nSM);
        if (!bo.isNullOrNil(paramString1)) {
          break label578;
        }
        this.nSM = com.tencent.mm.plugin.ipcall.b.a.RF(this.nSM);
      }
    }
    for (this.mCountryCode = com.tencent.mm.plugin.ipcall.b.c.bKM();; this.mCountryCode = paramString1)
    {
      ab.i("MicroMsg.TalkUIController", "final mCountryCode: %s", new Object[] { this.mCountryCode });
      com.tencent.mm.plugin.ipcall.a.c.bIZ().QX(this.mCountryCode);
      if (bo.isNullOrNil(this.gJX)) {
        this.gJX = com.tencent.mm.plugin.ipcall.b.a.aF(this.nXh, this.nSM);
      }
      this.nSO = paramString5;
      bKv();
      ab.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", new Object[] { this.nXg });
      if (!com.tencent.mm.plugin.ipcall.a.c.bIZ().xE(bo.getInt(this.mCountryCode, -1))) {
        break;
      }
      bKu();
      AppMethodBeat.o(22412);
      return;
      label578:
      this.nSM = com.tencent.mm.plugin.ipcall.b.a.RH(this.nSM);
    }
    if (!at.isNetworkConnected(this.nXh))
    {
      Toast.makeText(this.nXh, 2131304713, 1).show();
      this.nXh.finish();
      AppMethodBeat.o(22412);
      return;
    }
    long l1 = this.nXh.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1L);
    long l2 = System.currentTimeMillis();
    if ((l1 > l2) && (l1 != -1L))
    {
      ab.i("MicroMsg.TalkUIController", "onDisasterHappen");
      com.tencent.mm.ui.base.h.a(this.nXh, this.nXh.getString(2131300841, new Object[] { String.valueOf((l1 - l2) / 1000L + 1L) }), this.nXh.getString(2131300831), this.nXh.getString(2131300832), false, new j.5(this));
      AppMethodBeat.o(22412);
      return;
    }
    bKx();
    if ((!this.nXp) || (!i.bJr().bJh())) {
      bKA();
    }
    this.nXr = false;
    AppMethodBeat.o(22412);
  }
  
  public final void bIG()
  {
    int j = 0;
    AppMethodBeat.i(22428);
    ab.i("MicroMsg.TalkUIController", "onInviteSuccess");
    String str1 = i.bJn().nMs.nNB;
    String str2 = i.bJn().nMs.nNC;
    if ((!bo.isNullOrNil(str1)) && (!bo.isNullOrNil(str2)) && (!str1.equals(str2)))
    {
      ab.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", new Object[] { str1, str2 });
      Rw(str2);
    }
    ab.i("MicroMsg.TalkUIController", "callFlag:" + i.bJn().nMs.nNp);
    int k = i.bJn().nMs.nNp;
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
      ab.i("MicroMsg.TalkUIController", "isNotFree");
      com.tencent.mm.ui.base.h.a(this.nXh, 2131300911, 2131300912, 2131300910, 2131300909, true, null, new j.3(this));
    }
    xV(3);
    AppMethodBeat.o(22428);
  }
  
  public final void bIH()
  {
    AppMethodBeat.i(22429);
    ab.d("MicroMsg.TalkUIController", "onStartRing");
    if (i.bJr().bJi())
    {
      this.nXm = this.nXa.isChecked();
      this.nXn = this.nXa.isChecked();
      i.bJq().iE(this.nXa.isChecked());
    }
    AppMethodBeat.o(22429);
  }
  
  public final void bIU()
  {
    AppMethodBeat.i(22430);
    ab.d("MicroMsg.TalkUIController", "onUserAccept");
    if (i.bJr().bJi())
    {
      this.nXm = this.nXa.isChecked();
      this.nXn = this.nXa.isChecked();
      i.bJq().iE(this.nXa.isChecked());
    }
    if (i.bJr().bJj()) {
      i.bJq().nNL.setMute(this.nWY.isChecked());
    }
    AppMethodBeat.o(22430);
  }
  
  public final void bIV()
  {
    AppMethodBeat.i(22431);
    ab.d("MicroMsg.TalkUIController", "onOthersideShutdown");
    bKF();
    xV(10);
    aw.getNotification().cancel(42);
    if (this.nXj != null) {
      this.nXj.iN(true);
    }
    AppMethodBeat.o(22431);
  }
  
  public final void bIW()
  {
    AppMethodBeat.i(22436);
    this.nXh.finish();
    AppMethodBeat.o(22436);
  }
  
  public final void bIX()
  {
    AppMethodBeat.i(22435);
    this.nXk = i.bJs().bIR();
    xV(5);
    AppMethodBeat.o(22435);
  }
  
  public final void bKF()
  {
    AppMethodBeat.i(22437);
    if (this.nXc != null) {
      this.nXc.setVisibility(4);
    }
    if (this.nXd != null) {
      this.nXd.setVisibility(4);
    }
    AppMethodBeat.o(22437);
  }
  
  public final void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(22432);
    ab.d("MicroMsg.TalkUIController", "onError, error: %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt2 == 1) {
      this.nXq = false;
    }
    if (paramInt1 == 8) {
      if (paramInt2 == 1)
      {
        if (!bo.isNullOrNil(paramString1)) {
          break label172;
        }
        paramString1 = this.nXh.getString(2131300831);
      }
    }
    label172:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this.nXh, paramString2, paramString1, this.nXh.getString(2131300832), false, new j.4(this));
      for (;;)
      {
        aw.getNotification().cancel(42);
        if ((this.nXj != null) && (!this.nXr)) {
          this.nXj.iN(this.nXq);
        }
        AppMethodBeat.o(22432);
        return;
        d(paramString1, paramString2, paramInt2, this.nXh.getString(2131300830));
        continue;
        d(paramString1, paramString2, paramInt2, null);
      }
    }
  }
  
  final void eV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(22421);
    this.nWV.setText(paramString1);
    if (!bo.isNullOrNil(paramString1)) {
      this.nWV.setSelection(this.nWV.getText().length() - 1);
    }
    this.nWW.setText(paramString2);
    AppMethodBeat.o(22421);
  }
  
  public final void iH(boolean paramBoolean)
  {
    AppMethodBeat.i(22433);
    ab.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (i.bJr().bJi())
    {
      if (paramBoolean)
      {
        i.bJq();
        this.nXm = com.tencent.mm.plugin.ipcall.a.b.a.KM();
        i.bJq().iE(false);
        this.nXa.setEnable(false);
        AppMethodBeat.o(22433);
        return;
      }
      i.bJq().iE(this.nXm);
      this.nXa.setEnable(true);
      this.nXa.setChecked(this.nXm);
    }
    AppMethodBeat.o(22433);
  }
  
  public final void iI(boolean paramBoolean)
  {
    AppMethodBeat.i(22434);
    ab.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (i.bJr().bJi())
    {
      if (paramBoolean)
      {
        i.bJq();
        this.nXn = com.tencent.mm.plugin.ipcall.a.b.a.KM();
        i.bJq().iE(false);
        this.nXa.setEnable(false);
        AppMethodBeat.o(22434);
        return;
      }
      i.bJq().iE(this.nXn);
      this.nXa.setEnable(true);
      this.nXa.setChecked(this.nXn);
    }
    AppMethodBeat.o(22434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j
 * JD-Core Version:    0.7.0.1
 */