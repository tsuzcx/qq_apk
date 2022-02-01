package com.tencent.mm.plugin.honey_pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.honey_pay.a.d;
import com.tencent.mm.plugin.honey_pay.a.g;
import com.tencent.mm.plugin.honey_pay.a.n;
import com.tencent.mm.plugin.wallet_core.c.ac;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.cmz;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.fnr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import java.io.IOException;

public class HoneyPayCheckPwdUI
  extends HoneyPayBaseUI
{
  private String JAW;
  private fnr JAX;
  private EditHintPasswdView JCc;
  private String JCd;
  private String JCe;
  private long JCf;
  private int mScene;
  private TextView pJi;
  private TextView sUt;
  private String sWX;
  private int wIT;
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(64744);
    super.cleanUiData(paramInt);
    if (this.JCc != null) {
      this.JCc.gGd();
    }
    AppMethodBeat.o(64744);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.honey_pay_check_pwd_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64741);
    this.JCc = ((EditHintPasswdView)findViewById(a.f.input_et));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.JCc);
    this.JCc.setOnInputValidListener(new EditHintPasswdView.a()
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
            Log.w("MicroMsg.HoneyPayCheckPwdUI", "unknown scene: %s", new Object[] { Integer.valueOf(HoneyPayCheckPwdUI.a(HoneyPayCheckPwdUI.this)) });
          }
        }
      }
    });
    setEditFocusListener(this.JCc, 0, false);
    this.sUt = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.pJi = ((TextView)findViewById(a.f.wallet_pwd_content_1));
    if (this.mScene == 1) {
      this.sUt.setText(a.i.honey_pay_check_pwd_create_desc_text);
    }
    for (;;)
    {
      this.pJi.setText(a.i.honey_pay_check_pwd_title_text);
      AppMethodBeat.o(64741);
      return;
      if (this.mScene == 2) {
        this.sUt.setText(a.i.honey_pay_check_pwd_modify_desc_text);
      } else {
        this.sUt.setText(a.i.honey_pay_check_pwd_unbind_desc_text);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64740);
    super.onCreate(paramBundle);
    this.sWX = getIntent().getStringExtra("key_username");
    this.JCd = getIntent().getStringExtra("key_take_message");
    this.JCf = getIntent().getLongExtra("key_credit_line", 0L);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.JAW = getIntent().getStringExtra("key_card_no");
    this.JCe = getIntent().getStringExtra("key_wishing");
    if (this.mScene == 1)
    {
      this.wIT = getIntent().getIntExtra("key_cardtype", 0);
      if (this.wIT == 0)
      {
        Log.w("MicroMsg.HoneyPayCheckPwdUI", "error card type: %s", new Object[] { Integer.valueOf(this.wIT) });
        finish();
      }
    }
    if (this.mScene == 3) {
      paramBundle = new fnr();
    }
    try
    {
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_toke_mess");
      if ((arrayOfByte == null) || (arrayOfByte.length == 0))
      {
        Log.w("MicroMsg.HoneyPayCheckPwdUI", "toke mess is null when unbind !!!");
        finish();
      }
      paramBundle.parseFrom(arrayOfByte);
      this.JAX = paramBundle;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.HoneyPayCheckPwdUI", paramBundle, "", new Object[0]);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(64743);
    Log.d("MicroMsg.HoneyPayCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp instanceof ac))
    {
      paramp = (ac)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.mScene == 1)
        {
          paramString = paramp.Vyh;
          Log.i("MicroMsg.HoneyPayCheckPwdUI", "do give card");
          showSafeProgress();
          paramString = new com.tencent.mm.plugin.honey_pay.a.c(paramString, this.JCf, this.sWX, this.JCd, this.wIT, this.JCe);
          paramString.r(this);
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
        paramString = paramp.Vyh;
        Log.i("MicroMsg.HoneyPayCheckPwdUI", "do modify quota");
        showSafeProgress();
        paramString = new com.tencent.mm.plugin.honey_pay.a.h(this.JCf, paramString, this.JAW);
        paramString.r(this);
        doSceneProgress(paramString, false);
      }
      else if (this.mScene == 3)
      {
        paramString = paramp.Vyh;
        Log.i("MicroMsg.HoneyPayCheckPwdUI", "do unbind: %s", new Object[] { this.JAW });
        showSafeProgress();
        paramString = new n(this.JAW, paramString);
        paramString.r(this);
        doSceneProgress(paramString, false);
        continue;
        if (this.JCc != null) {
          this.JCc.gGd();
        }
        hideProgress();
        if ((!paramp.hasProcessWalletError()) && (!Util.isNullOrNil(paramString)))
        {
          Log.i("MicroMsg.HoneyPayCheckPwdUI", "show normal error msg");
          k.a(getContext(), paramString, null, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
        AppMethodBeat.o(64743);
        return true;
        if ((paramp instanceof com.tencent.mm.plugin.honey_pay.a.c))
        {
          paramString = (com.tencent.mm.plugin.honey_pay.a.c)paramp;
          hideProgress();
          paramString.a(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64735);
              Log.i("MicroMsg.HoneyPayCheckPwdUI", "create success");
              paramAnonymousp = new Intent(HoneyPayCheckPwdUI.this.getContext(), HoneyPayMainUI.class);
              paramAnonymousp.putExtra("key_create_succ", true);
              if (paramString.JAx.Zqc != null)
              {
                paramAnonymousp.putExtra("key_card_no", paramString.JAx.Zqc.aatc);
                paramAnonymousp.putExtra("key_card_type", paramString.JAx.Zqc.wtN);
              }
              Toast.makeText(HoneyPayCheckPwdUI.this.getContext(), a.i.honey_pay_create_card_success_word, 1).show();
              paramAnonymousString = HoneyPayCheckPwdUI.this;
              paramAnonymousp = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousp);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString, paramAnonymousp.aYi(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString.startActivity((Intent)paramAnonymousp.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.OAn.p(875L, 2L, 1L);
              AppMethodBeat.o(64735);
            }
          }).b(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64734);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).gGd();
              }
              com.tencent.mm.plugin.report.service.h.OAn.p(875L, 3L, 1L);
              AppMethodBeat.o(64734);
            }
          }).c(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64733);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).gGd();
              }
              com.tencent.mm.plugin.report.service.h.OAn.p(875L, 3L, 1L);
              AppMethodBeat.o(64733);
            }
          });
        }
        else if ((paramp instanceof com.tencent.mm.plugin.honey_pay.a.h))
        {
          hideProgress();
          paramString = (com.tencent.mm.plugin.honey_pay.a.h)paramp;
          paramString.a(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64738);
              Log.i("MicroMsg.HoneyPayCheckPwdUI", "modify success");
              paramAnonymousString = new Intent();
              paramAnonymousString.putExtra("key_modify_create_line_succ", true);
              paramAnonymousString.putExtra("key_credit_line", paramString.JAD);
              HoneyPayCheckPwdUI.this.setResult(-1, paramAnonymousString);
              HoneyPayCheckPwdUI.this.finish();
              com.tencent.mm.plugin.report.service.h.OAn.p(875L, 8L, 1L);
              AppMethodBeat.o(64738);
            }
          }).b(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64737);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).gGd();
              }
              com.tencent.mm.plugin.report.service.h.OAn.p(875L, 9L, 1L);
              AppMethodBeat.o(64737);
            }
          }).c(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64736);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).gGd();
              }
              com.tencent.mm.plugin.report.service.h.OAn.p(875L, 9L, 1L);
              AppMethodBeat.o(64736);
            }
          });
        }
        else if ((paramp instanceof d))
        {
          paramString = (d)paramp;
          paramString.a(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64726);
              HoneyPayCheckPwdUI.a(HoneyPayCheckPwdUI.this, paramString.JAy.aaqT);
              if (paramString.JAy.aaqU != null)
              {
                com.tencent.mm.plugin.honey_pay.model.c.a(HoneyPayCheckPwdUI.this, paramString.JAy.aaqU, new DialogInterface.OnClickListener()
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
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64724);
              if (paramString.JAy.aaqU != null) {
                com.tencent.mm.plugin.honey_pay.model.c.a(HoneyPayCheckPwdUI.this, paramString.JAy.aaqU, new DialogInterface.OnClickListener()
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
                  HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).gGd();
                }
              }
            }
          }).c(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64739);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).gGd();
              }
              HoneyPayCheckPwdUI.this.hideProgress();
              AppMethodBeat.o(64739);
            }
          });
        }
        else if ((paramp instanceof g))
        {
          paramString = (g)paramp;
          this.JAX = paramString.JAB.aaqT;
          paramString.a(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64729);
              HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
              AppMethodBeat.o(64729);
            }
          }).b(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64728);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).gGd();
              }
              HoneyPayCheckPwdUI.this.hideProgress();
              AppMethodBeat.o(64728);
            }
          }).c(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64727);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).gGd();
              }
              HoneyPayCheckPwdUI.this.hideProgress();
              AppMethodBeat.o(64727);
            }
          });
        }
        else if ((paramp instanceof n))
        {
          hideProgress();
          ((n)paramp).a(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64732);
              HoneyPayCheckPwdUI.this.setResult(-1);
              HoneyPayCheckPwdUI.this.finish();
              com.tencent.mm.plugin.report.service.h.OAn.p(875L, 6L, 1L);
              AppMethodBeat.o(64732);
            }
          }).b(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64731);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).gGd();
              }
              com.tencent.mm.plugin.report.service.h.OAn.p(875L, 7L, 1L);
              AppMethodBeat.o(64731);
            }
          }).c(new r.a()
          {
            public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(64730);
              if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
                HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).gGd();
              }
              com.tencent.mm.plugin.report.service.h.OAn.p(875L, 7L, 1L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */