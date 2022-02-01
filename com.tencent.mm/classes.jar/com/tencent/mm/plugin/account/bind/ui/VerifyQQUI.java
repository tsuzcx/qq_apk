package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ab;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.lu;
import com.tencent.mm.autogen.a.lu.b;
import com.tencent.mm.autogen.a.lv;
import com.tencent.mm.autogen.a.lv.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.k;
import java.lang.ref.WeakReference;

public class VerifyQQUI
  extends MMWizardActivity
  implements com.tencent.mm.am.h
{
  private String hNI;
  private String hNK;
  private byte[] orX;
  private long pRL;
  private String pRM;
  private String pRN;
  private String pRO;
  private b pRP;
  private SecurityImage pRw;
  private com.tencent.mm.ui.base.w tipDialog;
  
  public VerifyQQUI()
  {
    AppMethodBeat.i(110211);
    this.tipDialog = null;
    this.pRL = 0L;
    this.pRM = "";
    this.orX = null;
    this.pRN = "";
    this.pRw = null;
    this.pRP = new b(this);
    AppMethodBeat.o(110211);
  }
  
  public int getLayoutId()
  {
    return a.f.bindqq_verifyqq;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110216);
    Object localObject = new lu();
    ((lu)localObject).hNG.context = this;
    ((lu)localObject).publish();
    this.hNI = ((lu)localObject).hNH.hNI;
    localObject = new lv();
    ((lv)localObject).publish();
    this.hNK = ((lv)localObject).hNJ.hNK;
    setMMTitle(a.i.bind_qq_verify_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(110202);
        VerifyQQUI.this.hideVKB();
        VerifyQQUI.a(VerifyQQUI.this);
        AppMethodBeat.o(110202);
        return true;
      }
    });
    findViewById(a.e.bind_qq_verify_qq_uin);
    findViewById(a.e.bind_qq_verify_qq_pwd);
    addTextOptionMenu(0, getString(a.i.app_finish), this.pRP);
    AppMethodBeat.o(110216);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110212);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(144, this);
    AppMethodBeat.o(110212);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110213);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(144, this);
    AppMethodBeat.o(110213);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110214);
    super.onResume();
    initView();
    AppMethodBeat.o(110214);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(110217);
    Log.i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.plugin.account.bind.a.b localb = (com.tencent.mm.plugin.account.bind.a.b)paramp;
    byte[] arrayOfByte = com.tencent.mm.kernel.h.baC().aZE().iA(localb.oTt);
    Log.i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", new Object[] { Integer.valueOf(Util.nullAs(arrayOfByte, new byte[0]).length), Long.valueOf(localb.oTt) });
    if (Util.isNullOrNil(arrayOfByte)) {
      arrayOfByte = com.tencent.mm.platformtools.w.a(((nb)c.c.b(localb.rr.otC)).YFI);
    }
    for (;;)
    {
      this.orX = arrayOfByte;
      this.pRN = ((nb)c.c.b(((com.tencent.mm.plugin.account.bind.a.b)paramp).rr.otC)).YOM;
      if (this.orX != null) {
        Log.d("MicroMsg.VerifyQQUI", "imgSid:" + this.pRN + " img len" + this.orX.length + " " + f.aPX());
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.account.sdk.a.pFo.aDx();
        k.a(getContext(), a.i.bind_qq_verify_alert_succ, a.i.bind_qq_verify_alert_title, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(110203);
            VerifyQQUI.b(VerifyQQUI.this);
            AppMethodBeat.o(110203);
          }
        });
        AppMethodBeat.o(110217);
        return;
      }
      int i;
      if (paramInt1 == 4) {
        switch (paramInt2)
        {
        default: 
          paramString = com.tencent.mm.broadcast.a.CH(paramString);
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
        AppMethodBeat.o(110217);
        return;
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        if (paramString != null)
        {
          paramString.a(this, null, null);
          i = 1;
        }
        else
        {
          k.s(getContext(), a.i.bind_qq_verify_alert_wrong, a.i.bind_qq_verify_alert_failed_title);
          i = 1;
          continue;
          k.s(getContext(), a.i.bind_qq_verify_alert_failed_content, a.i.bind_qq_verify_alert_failed_title);
          i = 1;
          continue;
          k.s(getContext(), a.i.bind_qq_verify_alert_failed_niceqq, a.i.app_tip);
          i = 1;
          continue;
          k.s(getContext(), a.i.bind_qq_verify_alert_failed_denial, a.i.app_tip);
          i = 1;
          continue;
          if (this.orX != null) {
            Log.d("MicroMsg.VerifyQQUI", "imgSid:" + this.pRN + " img len" + this.orX.length + " " + f.aPX());
          }
          if (!com.tencent.mm.kernel.h.baz())
          {
            i = 1;
          }
          else
          {
            if (this.pRw == null) {
              this.pRw = SecurityImage.a.a(getContext(), a.i.regbyqq_secimg_title, 0, this.orX, this.pRN, this.pRO, new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(110205);
                  paramAnonymousDialogInterface = new com.tencent.mm.plugin.account.bind.a.b(VerifyQQUI.c(VerifyQQUI.this), VerifyQQUI.d(VerifyQQUI.this), VerifyQQUI.e(VerifyQQUI.this).getSecImgSid(), VerifyQQUI.e(VerifyQQUI.this).getSecImgCode(), VerifyQQUI.e(VerifyQQUI.this).getSecImgEncryptKey(), VerifyQQUI.f(VerifyQQUI.this), VerifyQQUI.g(VerifyQQUI.this), true);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
                  VerifyQQUI localVerifyQQUI = VerifyQQUI.this;
                  AppCompatActivity localAppCompatActivity = VerifyQQUI.this.getContext();
                  VerifyQQUI.this.getString(a.i.bind_qq_verify_alert_title);
                  VerifyQQUI.a(localVerifyQQUI, k.a(localAppCompatActivity, VerifyQQUI.this.getString(a.i.bind_qq_verify_alert_binding), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(110204);
                      com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                      AppMethodBeat.o(110204);
                    }
                  }));
                  AppMethodBeat.o(110205);
                }
              }, null, new DialogInterface.OnDismissListener()new a
              {
                public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(110206);
                  VerifyQQUI.h(VerifyQQUI.this);
                  AppMethodBeat.o(110206);
                }
              }, new a());
            }
            for (;;)
            {
              i = 1;
              break;
              if (this.orX != null) {
                Log.d("MicroMsg.VerifyQQUI", "imgSid:" + this.pRN + " img len" + this.orX.length + " " + f.aPX());
              }
              this.pRw.b(0, this.orX, this.pRN, this.pRO);
            }
            k.s(getContext(), a.i.bind_qq_verify_alert_failed_freq_limit, a.i.app_tip);
            i = 1;
            continue;
            i = 0;
          }
        }
      }
      Toast.makeText(this, getString(a.i.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(110217);
      return;
    }
  }
  
  public boolean onSwipeBackFinish()
  {
    AppMethodBeat.i(110215);
    hideVKB();
    finish();
    AppMethodBeat.o(110215);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends SecurityImage.b
  {
    a() {}
    
    public final void bWF()
    {
      AppMethodBeat.i(110207);
      com.tencent.mm.plugin.account.bind.a.b localb = new com.tencent.mm.plugin.account.bind.a.b(VerifyQQUI.c(VerifyQQUI.this), VerifyQQUI.d(VerifyQQUI.this), VerifyQQUI.i(VerifyQQUI.this), "", VerifyQQUI.j(VerifyQQUI.this), 2, true);
      com.tencent.mm.kernel.h.aZW().a(localb, 0);
      AppMethodBeat.o(110207);
    }
  }
  
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    WeakReference<VerifyQQUI> eIW;
    
    protected b(VerifyQQUI paramVerifyQQUI)
    {
      AppMethodBeat.i(110209);
      this.eIW = new WeakReference(paramVerifyQQUI);
      AppMethodBeat.o(110209);
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(110210);
      paramMenuItem = (VerifyQQUI)this.eIW.get();
      if ((paramMenuItem == null) || (paramMenuItem.isFinishing()))
      {
        AppMethodBeat.o(110210);
        return true;
      }
      Object localObject = (EditText)paramMenuItem.findViewById(a.e.bind_qq_verify_qq_uin);
      EditText localEditText = (EditText)paramMenuItem.findViewById(a.e.bind_qq_verify_qq_pwd);
      localObject = ((EditText)localObject).getText().toString().trim();
      VerifyQQUI.a(paramMenuItem, localEditText.getText().toString().trim());
      try
      {
        VerifyQQUI.a(paramMenuItem, Util.getLong((String)localObject, 0L));
        if (VerifyQQUI.c(paramMenuItem) < 10000L)
        {
          k.s(paramMenuItem.getContext(), a.i.bind_qq_verify_alert_qq, a.i.bind_qq_verify_alert_failed_title);
          AppMethodBeat.o(110210);
          return true;
        }
      }
      catch (Exception localException)
      {
        k.s(paramMenuItem.getContext(), a.i.bind_qq_verify_alert_qq, a.i.bind_qq_verify_alert_failed_title);
        AppMethodBeat.o(110210);
        return true;
      }
      if (VerifyQQUI.d(paramMenuItem).equals(""))
      {
        k.s(paramMenuItem.getContext(), a.i.bind_qq_verify_alert_pwd, a.i.bind_qq_verify_alert_failed_title);
        AppMethodBeat.o(110210);
        return true;
      }
      paramMenuItem.hideVKB();
      final com.tencent.mm.plugin.account.bind.a.b localb = new com.tencent.mm.plugin.account.bind.a.b(VerifyQQUI.c(paramMenuItem), VerifyQQUI.d(paramMenuItem), "", "", "", VerifyQQUI.f(paramMenuItem), VerifyQQUI.g(paramMenuItem), false);
      com.tencent.mm.kernel.h.aZW().a(localb, 0);
      localObject = paramMenuItem.getContext();
      paramMenuItem.getString(a.i.bind_qq_verify_alert_title);
      VerifyQQUI.a(paramMenuItem, k.a((Context)localObject, paramMenuItem.getString(a.i.bind_qq_verify_alert_binding), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(110208);
          com.tencent.mm.kernel.h.aZW().a(localb);
          AppMethodBeat.o(110208);
        }
      }));
      AppMethodBeat.o(110210);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.VerifyQQUI
 * JD-Core Version:    0.7.0.1
 */