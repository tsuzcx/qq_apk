package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
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
import com.tencent.mm.an.ac;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.f.a.kq;
import com.tencent.mm.f.a.kq.b;
import com.tencent.mm.f.a.kr;
import com.tencent.mm.f.a.kr.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.ma;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.s;
import java.lang.ref.WeakReference;

public class VerifyQQUI
  extends MMWizardActivity
  implements i
{
  private String fIi;
  private String fIk;
  private byte[] lAw;
  private SecurityImage mUP;
  private long mVe;
  private String mVf;
  private String mVg;
  private String mVh;
  private b mVi;
  private s tipDialog;
  
  public VerifyQQUI()
  {
    AppMethodBeat.i(110211);
    this.tipDialog = null;
    this.mVe = 0L;
    this.mVf = "";
    this.lAw = null;
    this.mVg = "";
    this.mUP = null;
    this.mVi = new b(this);
    AppMethodBeat.o(110211);
  }
  
  public int getLayoutId()
  {
    return a.f.bindqq_verifyqq;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110216);
    Object localObject = new kq();
    ((kq)localObject).fIg.context = this;
    EventCenter.instance.publish((IEvent)localObject);
    this.fIi = ((kq)localObject).fIh.fIi;
    localObject = new kr();
    EventCenter.instance.publish((IEvent)localObject);
    this.fIk = ((kr)localObject).fIj.fIk;
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
    addTextOptionMenu(0, getString(a.i.app_finish), this.mVi);
    AppMethodBeat.o(110216);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110212);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(144, this);
    AppMethodBeat.o(110212);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110213);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(144, this);
    AppMethodBeat.o(110213);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110214);
    super.onResume();
    initView();
    AppMethodBeat.o(110214);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(110217);
    Log.i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.plugin.account.bind.a.b localb = (com.tencent.mm.plugin.account.bind.a.b)paramq;
    byte[] arrayOfByte = com.tencent.mm.kernel.h.aHE().aGC().Gq(localb.maC);
    Log.i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", new Object[] { Integer.valueOf(Util.nullAs(arrayOfByte, new byte[0]).length), Long.valueOf(localb.maC) });
    if (Util.isNullOrNil(arrayOfByte)) {
      arrayOfByte = z.a(((ma)d.c.b(localb.rr.lBS)).RIH);
    }
    for (;;)
    {
      this.lAw = arrayOfByte;
      this.mVg = ((ma)d.c.b(((com.tencent.mm.plugin.account.bind.a.b)paramq).rr.lBS)).RRu;
      if (this.lAw != null) {
        Log.d("MicroMsg.VerifyQQUI", "imgSid:" + this.mVg + " img len" + this.lAw.length + " " + f.avD());
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.account.sdk.a.mIH.abC();
        com.tencent.mm.ui.base.h.a(getContext(), a.i.bind_qq_verify_alert_succ, a.i.bind_qq_verify_alert_title, new DialogInterface.OnClickListener()
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
          paramString = com.tencent.mm.h.a.Kb(paramString);
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
        paramString = com.tencent.mm.h.a.Kb(paramString);
        if (paramString != null)
        {
          paramString.a(this, null, null);
          i = 1;
        }
        else
        {
          com.tencent.mm.ui.base.h.p(getContext(), a.i.bind_qq_verify_alert_wrong, a.i.bind_qq_verify_alert_failed_title);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.p(getContext(), a.i.bind_qq_verify_alert_failed_content, a.i.bind_qq_verify_alert_failed_title);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.p(getContext(), a.i.bind_qq_verify_alert_failed_niceqq, a.i.app_tip);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.p(getContext(), a.i.bind_qq_verify_alert_failed_denial, a.i.app_tip);
          i = 1;
          continue;
          if (this.lAw != null) {
            Log.d("MicroMsg.VerifyQQUI", "imgSid:" + this.mVg + " img len" + this.lAw.length + " " + f.avD());
          }
          if (!com.tencent.mm.kernel.h.aHB())
          {
            i = 1;
          }
          else
          {
            if (this.mUP == null) {
              this.mUP = SecurityImage.a.a(getContext(), a.i.regbyqq_secimg_title, 0, this.lAw, this.mVg, this.mVh, new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(110205);
                  paramAnonymousDialogInterface = new com.tencent.mm.plugin.account.bind.a.b(VerifyQQUI.c(VerifyQQUI.this), VerifyQQUI.d(VerifyQQUI.this), VerifyQQUI.e(VerifyQQUI.this).getSecImgSid(), VerifyQQUI.e(VerifyQQUI.this).getSecImgCode(), VerifyQQUI.e(VerifyQQUI.this).getSecImgEncryptKey(), VerifyQQUI.f(VerifyQQUI.this), VerifyQQUI.g(VerifyQQUI.this), true);
                  com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
                  VerifyQQUI localVerifyQQUI = VerifyQQUI.this;
                  AppCompatActivity localAppCompatActivity = VerifyQQUI.this.getContext();
                  VerifyQQUI.this.getString(a.i.bind_qq_verify_alert_title);
                  VerifyQQUI.a(localVerifyQQUI, com.tencent.mm.ui.base.h.a(localAppCompatActivity, VerifyQQUI.this.getString(a.i.bind_qq_verify_alert_binding), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(110204);
                      com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface);
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
              if (this.lAw != null) {
                Log.d("MicroMsg.VerifyQQUI", "imgSid:" + this.mVg + " img len" + this.lAw.length + " " + f.avD());
              }
              this.mUP.b(0, this.lAw, this.mVg, this.mVh);
            }
            com.tencent.mm.ui.base.h.p(getContext(), a.i.bind_qq_verify_alert_failed_freq_limit, a.i.app_tip);
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
    
    public final void bxQ()
    {
      AppMethodBeat.i(110207);
      com.tencent.mm.plugin.account.bind.a.b localb = new com.tencent.mm.plugin.account.bind.a.b(VerifyQQUI.c(VerifyQQUI.this), VerifyQQUI.d(VerifyQQUI.this), VerifyQQUI.i(VerifyQQUI.this), "", VerifyQQUI.j(VerifyQQUI.this), 2, true);
      com.tencent.mm.kernel.h.aGY().a(localb, 0);
      AppMethodBeat.o(110207);
    }
  }
  
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    WeakReference<VerifyQQUI> cNB;
    
    protected b(VerifyQQUI paramVerifyQQUI)
    {
      AppMethodBeat.i(110209);
      this.cNB = new WeakReference(paramVerifyQQUI);
      AppMethodBeat.o(110209);
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(110210);
      paramMenuItem = (VerifyQQUI)this.cNB.get();
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
          com.tencent.mm.ui.base.h.p(paramMenuItem.getContext(), a.i.bind_qq_verify_alert_qq, a.i.bind_qq_verify_alert_failed_title);
          AppMethodBeat.o(110210);
          return true;
        }
      }
      catch (Exception localException)
      {
        com.tencent.mm.ui.base.h.p(paramMenuItem.getContext(), a.i.bind_qq_verify_alert_qq, a.i.bind_qq_verify_alert_failed_title);
        AppMethodBeat.o(110210);
        return true;
      }
      if (VerifyQQUI.d(paramMenuItem).equals(""))
      {
        com.tencent.mm.ui.base.h.p(paramMenuItem.getContext(), a.i.bind_qq_verify_alert_pwd, a.i.bind_qq_verify_alert_failed_title);
        AppMethodBeat.o(110210);
        return true;
      }
      paramMenuItem.hideVKB();
      final com.tencent.mm.plugin.account.bind.a.b localb = new com.tencent.mm.plugin.account.bind.a.b(VerifyQQUI.c(paramMenuItem), VerifyQQUI.d(paramMenuItem), "", "", "", VerifyQQUI.f(paramMenuItem), VerifyQQUI.g(paramMenuItem), false);
      com.tencent.mm.kernel.h.aGY().a(localb, 0);
      localObject = paramMenuItem.getContext();
      paramMenuItem.getString(a.i.bind_qq_verify_alert_title);
      VerifyQQUI.a(paramMenuItem, com.tencent.mm.ui.base.h.a((Context)localObject, paramMenuItem.getString(a.i.bind_qq_verify_alert_binding), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(110208);
          com.tencent.mm.kernel.h.aGY().a(localb);
          AppMethodBeat.o(110208);
        }
      }));
      AppMethodBeat.o(110210);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.VerifyQQUI
 * JD-Core Version:    0.7.0.1
 */