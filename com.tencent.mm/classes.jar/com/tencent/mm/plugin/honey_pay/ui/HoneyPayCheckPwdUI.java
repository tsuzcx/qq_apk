package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.a.d;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tencent.mm.wallet_core.ui.formview.a;
import java.io.IOException;

public class HoneyPayCheckPwdUI
  extends HoneyPayBaseUI
{
  private TextView lHT;
  private TextView lHk;
  private String lJm;
  private int mScene;
  private String uRv;
  private dok uRw;
  private EditHintPasswdView uSv;
  private String uSw;
  private String uSx;
  private long uSy;
  private int uSz;
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(64744);
    super.cleanUiData(paramInt);
    if (this.uSv != null) {
      this.uSv.dHv();
    }
    AppMethodBeat.o(64744);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494446;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64741);
    this.uSv = ((EditHintPasswdView)findViewById(2131301026));
    a.a(this.uSv);
    this.uSv.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(64722);
        if (paramAnonymousBoolean)
        {
          if (HoneyPayCheckPwdUI.a(HoneyPayCheckPwdUI.this) != 1) {
            break label40;
          }
          HoneyPayCheckPwdUI.b(HoneyPayCheckPwdUI.this);
        }
        for (;;)
        {
          HoneyPayCheckPwdUI.this.hideTenpayKB();
          AppMethodBeat.o(64722);
          return;
          label40:
          if (HoneyPayCheckPwdUI.a(HoneyPayCheckPwdUI.this) == 2) {
            HoneyPayCheckPwdUI.c(HoneyPayCheckPwdUI.this);
          } else if (HoneyPayCheckPwdUI.a(HoneyPayCheckPwdUI.this) == 3) {
            HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
          } else {
            ae.w("MicroMsg.HoneyPayCheckPwdUI", "unknown scene: %s", new Object[] { Integer.valueOf(HoneyPayCheckPwdUI.a(HoneyPayCheckPwdUI.this)) });
          }
        }
      }
    });
    setEditFocusListener(this.uSv, 0, false);
    this.lHk = ((TextView)findViewById(2131306825));
    this.lHT = ((TextView)findViewById(2131306821));
    if (this.mScene == 1) {
      this.lHk.setText(2131760257);
    }
    for (;;)
    {
      this.lHT.setText(2131760259);
      AppMethodBeat.o(64741);
      return;
      if (this.mScene == 2) {
        this.lHk.setText(2131760258);
      } else {
        this.lHk.setText(2131760260);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64740);
    super.onCreate(paramBundle);
    this.lJm = getIntent().getStringExtra("key_username");
    this.uSw = getIntent().getStringExtra("key_take_message");
    this.uSy = getIntent().getLongExtra("key_credit_line", 0L);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.uRv = getIntent().getStringExtra("key_card_no");
    this.uSx = getIntent().getStringExtra("key_wishing");
    if (this.mScene == 1)
    {
      this.uSz = getIntent().getIntExtra("key_cardtype", 0);
      if (this.uSz == 0)
      {
        ae.w("MicroMsg.HoneyPayCheckPwdUI", "error card type: %s", new Object[] { Integer.valueOf(this.uSz) });
        finish();
      }
    }
    if (this.mScene == 3) {
      paramBundle = new dok();
    }
    try
    {
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_toke_mess");
      if ((arrayOfByte == null) || (arrayOfByte.length == 0))
      {
        ae.w("MicroMsg.HoneyPayCheckPwdUI", "toke mess is null when unbind !!!");
        finish();
      }
      paramBundle.parseFrom(arrayOfByte);
      this.uRw = paramBundle;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.HoneyPayCheckPwdUI", paramBundle, "", new Object[0]);
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
    AppMethodBeat.o(64740);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64742);
    super.onDestroy();
    removeSceneEndListener(2662);
    removeSceneEndListener(2685);
    removeSceneEndListener(2630);
    removeSceneEndListener(2815);
    removeSceneEndListener(2659);
    AppMethodBeat.o(64742);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(64743);
    ae.d("MicroMsg.HoneyPayCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof ab))
    {
      paramn = (ab)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.mScene == 1)
        {
          paramString = paramn.DgT;
          ae.i("MicroMsg.HoneyPayCheckPwdUI", "do give card");
          showSafeProgress();
          paramString = new com.tencent.mm.plugin.honey_pay.a.c(paramString, this.uSy, this.lJm, this.uSw, this.uSz, this.uSx);
          paramString.t(this);
          doSceneProgress(paramString, false);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(64743);
      return true;
      if (this.mScene == 2)
      {
        paramString = paramn.DgT;
        ae.i("MicroMsg.HoneyPayCheckPwdUI", "do modify quota");
        showSafeProgress();
        paramString = new com.tencent.mm.plugin.honey_pay.a.h(this.uSy, paramString, this.uRv);
        paramString.t(this);
        doSceneProgress(paramString, false);
      }
      else if (this.mScene == 3)
      {
        paramString = paramn.DgT;
        ae.i("MicroMsg.HoneyPayCheckPwdUI", "do unbind: %s", new Object[] { this.uRv });
        showSafeProgress();
        paramString = new com.tencent.mm.plugin.honey_pay.a.n(this.uRv, paramString);
        paramString.t(this);
        doSceneProgress(paramString, false);
        continue;
        if (this.uSv != null) {
          this.uSv.dHv();
        }
        hideProgress();
        if ((!paramn.hasProcessWalletError()) && (!bu.isNullOrNil(paramString)))
        {
          ae.i("MicroMsg.HoneyPayCheckPwdUI", "show normal error msg");
          com.tencent.mm.ui.base.h.a(getContext(), paramString, null, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
        AppMethodBeat.o(64743);
        return true;
        if ((paramn instanceof com.tencent.mm.plugin.honey_pay.a.c))
        {
          paramString = (com.tencent.mm.plugin.honey_pay.a.c)paramn;
          hideProgress();
          paramString.a(new HoneyPayCheckPwdUI.13(this, paramString)).b(new r.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(64734);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).dHv();
              }
              com.tencent.mm.plugin.report.service.g.yxI.n(875L, 3L, 1L);
              AppMethodBeat.o(64734);
            }
          }).c(new r.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(64733);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).dHv();
              }
              com.tencent.mm.plugin.report.service.g.yxI.n(875L, 3L, 1L);
              AppMethodBeat.o(64733);
            }
          });
        }
        else if ((paramn instanceof com.tencent.mm.plugin.honey_pay.a.h))
        {
          hideProgress();
          paramString = (com.tencent.mm.plugin.honey_pay.a.h)paramn;
          paramString.a(new HoneyPayCheckPwdUI.16(this, paramString)).b(new r.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(64737);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).dHv();
              }
              com.tencent.mm.plugin.report.service.g.yxI.n(875L, 9L, 1L);
              AppMethodBeat.o(64737);
            }
          }).c(new r.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(64736);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).dHv();
              }
              com.tencent.mm.plugin.report.service.g.yxI.n(875L, 9L, 1L);
              AppMethodBeat.o(64736);
            }
          });
        }
        else if ((paramn instanceof d))
        {
          paramString = (d)paramn;
          paramString.a(new r.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(64726);
              HoneyPayCheckPwdUI.a(HoneyPayCheckPwdUI.this, paramString.uQW.GQG);
              if (paramString.uQW.GQH != null)
              {
                com.tencent.mm.plugin.honey_pay.model.c.a(HoneyPayCheckPwdUI.this, paramString.uQW.GQH, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(64725);
                    HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
                    AppMethodBeat.o(64725);
                  }
                });
                HoneyPayCheckPwdUI.this.hideProgress();
                AppMethodBeat.o(64726);
                return;
              }
              HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
              AppMethodBeat.o(64726);
            }
          }).b(new r.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(64724);
              if (paramString.uQW.GQH != null) {
                com.tencent.mm.plugin.honey_pay.model.c.a(HoneyPayCheckPwdUI.this, paramString.uQW.GQH, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(64723);
                    HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
                    AppMethodBeat.o(64723);
                  }
                });
              }
              for (;;)
              {
                HoneyPayCheckPwdUI.this.hideProgress();
                AppMethodBeat.o(64724);
                return;
                if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                  HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).dHv();
                }
              }
            }
          }).c(new r.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(64739);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).dHv();
              }
              HoneyPayCheckPwdUI.this.hideProgress();
              AppMethodBeat.o(64739);
            }
          });
        }
        else if ((paramn instanceof com.tencent.mm.plugin.honey_pay.a.g))
        {
          paramString = (com.tencent.mm.plugin.honey_pay.a.g)paramn;
          this.uRw = paramString.uQZ.GQG;
          paramString.a(new r.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(64729);
              HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
              AppMethodBeat.o(64729);
            }
          }).b(new r.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(64728);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).dHv();
              }
              HoneyPayCheckPwdUI.this.hideProgress();
              AppMethodBeat.o(64728);
            }
          }).c(new r.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(64727);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).dHv();
              }
              HoneyPayCheckPwdUI.this.hideProgress();
              AppMethodBeat.o(64727);
            }
          });
        }
        else if ((paramn instanceof com.tencent.mm.plugin.honey_pay.a.n))
        {
          hideProgress();
          ((com.tencent.mm.plugin.honey_pay.a.n)paramn).a(new HoneyPayCheckPwdUI.9(this)).b(new r.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(64731);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).dHv();
              }
              com.tencent.mm.plugin.report.service.g.yxI.n(875L, 7L, 1L);
              AppMethodBeat.o(64731);
            }
          }).c(new r.a()
          {
            public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(64730);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).dHv();
              }
              com.tencent.mm.plugin.report.service.g.yxI.n(875L, 7L, 1L);
              AppMethodBeat.o(64730);
            }
          });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */