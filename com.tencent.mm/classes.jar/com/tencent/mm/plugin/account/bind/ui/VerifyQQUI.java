package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.y;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.hz.b;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.ia.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.jv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public class VerifyQQUI
  extends MMWizardActivity
  implements f
{
  private String cxl;
  private String cxn;
  private byte[] frF;
  private SecurityImage gwg;
  private long gwv;
  private String gww;
  private String gwx;
  private String gwy;
  private VerifyQQUI.b gwz;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public VerifyQQUI()
  {
    AppMethodBeat.i(13786);
    this.tipDialog = null;
    this.gwv = 0L;
    this.gww = "";
    this.frF = null;
    this.gwx = "";
    this.gwg = null;
    this.gwz = new VerifyQQUI.b(this);
    AppMethodBeat.o(13786);
  }
  
  public int getLayoutId()
  {
    return 2130968855;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13791);
    Object localObject = new hz();
    ((hz)localObject).cxj.context = this;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    this.cxl = ((hz)localObject).cxk.cxl;
    localObject = new ia();
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    this.cxn = ((ia)localObject).cxm.cxn;
    setMMTitle(2131297656);
    setBackBtn(new VerifyQQUI.1(this));
    findViewById(2131821821);
    findViewById(2131821822);
    addTextOptionMenu(0, getString(2131296964), this.gwz);
    AppMethodBeat.o(13791);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13787);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Rc().a(144, this);
    AppMethodBeat.o(13787);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13788);
    super.onDestroy();
    com.tencent.mm.kernel.g.Rc().b(144, this);
    AppMethodBeat.o(13788);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13789);
    super.onResume();
    initView();
    AppMethodBeat.o(13789);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(13792);
    ab.i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.plugin.account.bind.a.b localb = (com.tencent.mm.plugin.account.bind.a.b)paramm;
    byte[] arrayOfByte = com.tencent.mm.kernel.g.RJ().QN().gC(localb.fQd);
    ab.i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", new Object[] { Integer.valueOf(bo.l(arrayOfByte, new byte[0]).length), Long.valueOf(localb.fQd) });
    if (bo.ce(arrayOfByte)) {
      arrayOfByte = aa.a(((jv)localb.rr.fsW.fta).woT);
    }
    for (;;)
    {
      this.frF = arrayOfByte;
      this.gwx = ((jv)((com.tencent.mm.plugin.account.bind.a.b)paramm).rr.fsW.fta).wwk;
      if (this.frF != null) {
        ab.d("MicroMsg.VerifyQQUI", "imgSid:" + this.gwx + " img len" + this.frF.length + " " + com.tencent.mm.compatible.util.g.Ml());
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.account.a.a.gmP.BO();
        h.a(getContext(), 2131297651, 2131297652, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(13778);
            VerifyQQUI.b(VerifyQQUI.this);
            AppMethodBeat.o(13778);
          }
        });
        AppMethodBeat.o(13792);
        return;
      }
      int i;
      if (paramInt1 == 4) {
        switch (paramInt2)
        {
        default: 
          paramString = com.tencent.mm.h.a.kO(paramString);
          if (paramString != null)
          {
            paramString.a(this, null, null);
            i = 1;
          }
          break;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(13792);
        return;
        paramString = com.tencent.mm.h.a.kO(paramString);
        if (paramString != null)
        {
          paramString.a(this, null, null);
          i = 1;
        }
        else
        {
          h.h(getContext(), 2131297653, 2131297648);
          i = 1;
          continue;
          h.h(getContext(), 2131297644, 2131297648);
          i = 1;
          continue;
          h.h(getContext(), 2131297647, 2131297087);
          i = 1;
          continue;
          h.h(getContext(), 2131297645, 2131297087);
          i = 1;
          continue;
          ab.d("MicroMsg.VerifyQQUI", "imgSid:" + this.gwx + " img len" + this.frF.length + " " + com.tencent.mm.compatible.util.g.Ml());
          if (!com.tencent.mm.kernel.g.RG())
          {
            i = 1;
          }
          else
          {
            if (this.gwg == null) {
              this.gwg = SecurityImage.a.a(getContext(), 0, this.frF, this.gwx, this.gwy, new VerifyQQUI.3(this), null, new VerifyQQUI.4(this), new VerifyQQUI.a(this));
            }
            for (;;)
            {
              i = 1;
              break;
              ab.d("MicroMsg.VerifyQQUI", "imgSid:" + this.gwx + " img len" + this.frF.length + " " + com.tencent.mm.compatible.util.g.Ml());
              this.gwg.b(0, this.frF, this.gwx, this.gwy);
            }
            h.h(getContext(), 2131297646, 2131297087);
            i = 1;
            continue;
            i = 0;
          }
        }
      }
      Toast.makeText(this, getString(2131300023, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(13792);
      return;
    }
  }
  
  public boolean onSwipeBackFinish()
  {
    AppMethodBeat.i(13790);
    hideVKB();
    finish();
    AppMethodBeat.o(13790);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.VerifyQQUI
 * JD-Core Version:    0.7.0.1
 */