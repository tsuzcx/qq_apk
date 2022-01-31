package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.honey_pay.a.c;
import com.tencent.mm.plugin.honey_pay.a.d;
import com.tencent.mm.plugin.honey_pay.a.g;
import com.tencent.mm.plugin.honey_pay.a.n;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.a;
import java.io.IOException;

public class HoneyPayCheckPwdUI
  extends HoneyPayBaseUI
{
  private TextView iJG;
  private String ikj;
  private TextView kPB;
  private int mScene;
  private String nHE;
  private ckm nHF;
  private EditHintPasswdView nID;
  private String nIE;
  private String nIF;
  private long nIG;
  private int nIH;
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(41855);
    super.cleanUiData(paramInt);
    if (this.nID != null) {
      this.nID.cfK();
    }
    AppMethodBeat.o(41855);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969869;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41852);
    this.nID = ((EditHintPasswdView)findViewById(2131825034));
    a.a(this.nID);
    this.nID.setOnInputValidListener(new HoneyPayCheckPwdUI.1(this));
    setEditFocusListener(this.nID, 0, false);
    this.iJG = ((TextView)findViewById(2131825031));
    this.kPB = ((TextView)findViewById(2131825032));
    if (this.mScene == 1) {
      this.iJG.setText(2131300660);
    }
    for (;;)
    {
      this.kPB.setText(2131300662);
      AppMethodBeat.o(41852);
      return;
      if (this.mScene == 2) {
        this.iJG.setText(2131300661);
      } else {
        this.iJG.setText(2131300663);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41851);
    super.onCreate(paramBundle);
    this.ikj = getIntent().getStringExtra("key_username");
    this.nIE = getIntent().getStringExtra("key_take_message");
    this.nIG = getIntent().getLongExtra("key_credit_line", 0L);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.nHE = getIntent().getStringExtra("key_card_no");
    this.nIF = getIntent().getStringExtra("key_wishing");
    if (this.mScene == 1)
    {
      this.nIH = getIntent().getIntExtra("key_cardtype", 0);
      if (this.nIH == 0)
      {
        ab.w("MicroMsg.HoneyPayCheckPwdUI", "error card type: %s", new Object[] { Integer.valueOf(this.nIH) });
        finish();
      }
    }
    if (this.mScene == 3) {
      paramBundle = new ckm();
    }
    try
    {
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_toke_mess");
      if ((arrayOfByte == null) || (arrayOfByte.length == 0))
      {
        ab.w("MicroMsg.HoneyPayCheckPwdUI", "toke mess is null when unbind !!!");
        finish();
      }
      paramBundle.parseFrom(arrayOfByte);
      this.nHF = paramBundle;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.HoneyPayCheckPwdUI", paramBundle, "", new Object[0]);
        finish();
      }
    }
    setMMTitle("");
    addSceneEndListener(2662);
    addSceneEndListener(2685);
    addSceneEndListener(2630);
    addSceneEndListener(2815);
    addSceneEndListener(2659);
    initView();
    AppMethodBeat.o(41851);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41853);
    super.onDestroy();
    removeSceneEndListener(2662);
    removeSceneEndListener(2685);
    removeSceneEndListener(2630);
    removeSceneEndListener(2815);
    removeSceneEndListener(2659);
    AppMethodBeat.o(41853);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41854);
    ab.d("MicroMsg.HoneyPayCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof z))
    {
      paramm = (z)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.mScene == 1)
        {
          paramString = paramm.ubZ;
          ab.i("MicroMsg.HoneyPayCheckPwdUI", "do give card");
          showSafeProgress();
          paramString = new c(paramString, this.nIG, this.ikj, this.nIE, this.nIH, this.nIF);
          paramString.o(this);
          doSceneProgress(paramString, false);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(41854);
      return true;
      if (this.mScene == 2)
      {
        paramString = paramm.ubZ;
        ab.i("MicroMsg.HoneyPayCheckPwdUI", "do modify quota");
        showSafeProgress();
        paramString = new com.tencent.mm.plugin.honey_pay.a.h(this.nIG, paramString, this.nHE);
        paramString.o(this);
        doSceneProgress(paramString, false);
      }
      else if (this.mScene == 3)
      {
        paramString = paramm.ubZ;
        ab.i("MicroMsg.HoneyPayCheckPwdUI", "do unbind: %s", new Object[] { this.nHE });
        showSafeProgress();
        paramString = new n(this.nHE, paramString);
        paramString.o(this);
        doSceneProgress(paramString, false);
        continue;
        if (this.nID != null) {
          this.nID.cfK();
        }
        hideProgress();
        if ((!paramm.hasProcessWalletError()) && (!bo.isNullOrNil(paramString)))
        {
          ab.i("MicroMsg.HoneyPayCheckPwdUI", "show normal error msg");
          com.tencent.mm.ui.base.h.a(getContext(), paramString, null, false, new HoneyPayCheckPwdUI.10(this));
        }
        AppMethodBeat.o(41854);
        return true;
        if ((paramm instanceof c))
        {
          paramString = (c)paramm;
          hideProgress();
          paramString.a(new HoneyPayCheckPwdUI.13(this, paramString)).b(new HoneyPayCheckPwdUI.12(this)).c(new HoneyPayCheckPwdUI.11(this));
        }
        else if ((paramm instanceof com.tencent.mm.plugin.honey_pay.a.h))
        {
          hideProgress();
          paramString = (com.tencent.mm.plugin.honey_pay.a.h)paramm;
          paramString.a(new HoneyPayCheckPwdUI.16(this, paramString)).b(new p.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
            {
              AppMethodBeat.i(41848);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).cfK();
              }
              com.tencent.mm.plugin.report.service.h.qsU.j(875L, 9L, 1L);
              AppMethodBeat.o(41848);
            }
          }).c(new HoneyPayCheckPwdUI.14(this));
        }
        else if ((paramm instanceof d))
        {
          paramString = (d)paramm;
          paramString.a(new HoneyPayCheckPwdUI.3(this, paramString)).b(new HoneyPayCheckPwdUI.2(this, paramString)).c(new HoneyPayCheckPwdUI.17(this));
        }
        else if ((paramm instanceof g))
        {
          paramString = (g)paramm;
          this.nHF = paramString.nHh.xaX;
          paramString.a(new HoneyPayCheckPwdUI.6(this)).b(new HoneyPayCheckPwdUI.5(this)).c(new HoneyPayCheckPwdUI.4(this));
        }
        else if ((paramm instanceof n))
        {
          hideProgress();
          ((n)paramm).a(new HoneyPayCheckPwdUI.9(this)).b(new HoneyPayCheckPwdUI.8(this)).c(new HoneyPayCheckPwdUI.7(this));
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */