package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ab;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.broadcast.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.protocal.protobuf.fwi;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.k;

public final class e
  implements com.tencent.mm.am.h
{
  private Context context;
  private String pRA;
  private a pRB;
  private View pRt;
  private com.tencent.mm.ui.base.w pRu;
  com.tencent.mm.ui.widget.a.e pRv;
  private SecurityImage pRw;
  private String pRx;
  private byte[] pRy;
  private String pRz;
  
  public e(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.pRt = null;
    this.pRu = null;
    this.pRv = null;
    this.pRx = "";
    this.pRw = null;
    this.pRy = null;
    this.pRz = "";
    this.pRB = parama;
  }
  
  public final void bWE()
  {
    AppMethodBeat.i(110184);
    this.pRt = View.inflate(this.context, a.f.sendqqpwd_dialog, null);
    Object localObject = (EditText)this.pRt.findViewById(a.e.sendqqpwd_content);
    ((EditText)localObject).setHint(a.i.bind_qq_verify_textview_pwd);
    localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110175);
        e.this.pRv = null;
        e.a(e.this, this.pRC.getText().toString().trim());
        AppMethodBeat.o(110175);
      }
    };
    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110176);
        e.this.pRv = null;
        e.this.onDetach();
        AppMethodBeat.o(110176);
      }
    };
    this.pRv = k.a(this.context, this.context.getString(a.i.bind_qq_verify_alert_pwd), this.pRt, (DialogInterface.OnClickListener)localObject, local2);
    AppMethodBeat.o(110184);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(110182);
    com.tencent.mm.kernel.h.aZW().a(384, this);
    AppMethodBeat.o(110182);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(110183);
    com.tencent.mm.kernel.h.aZW().b(384, this);
    if (this.pRB != null) {
      this.pRB.bWD();
    }
    AppMethodBeat.o(110183);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(110185);
    onDetach();
    if ((paramp == null) || (paramp.getType() != 384))
    {
      AppMethodBeat.o(110185);
      return;
    }
    if (this.pRu != null)
    {
      this.pRu.dismiss();
      this.pRu = null;
    }
    this.pRz = com.tencent.mm.platformtools.w.a(((fwi)c.c.b(((ae)paramp).rr.otC)).aaAR);
    paramp = (ae)paramp;
    if ((((fwi)c.c.b(paramp.rr.otC)).YJl != null) && (((fwi)c.c.b(paramp.rr.otC)).YJl.abwJ > 0)) {}
    for (paramp = com.tencent.mm.kernel.h.baC().aZE().iA(paramp.oTt);; paramp = com.tencent.mm.platformtools.w.a(((fwi)c.c.b(paramp.rr.otC)).YFI))
    {
      this.pRy = paramp;
      if ((this.pRB == null) || (!this.pRB.fa(paramInt1, paramInt2))) {
        break;
      }
      AppMethodBeat.o(110185);
      return;
    }
    if ((this.context instanceof Activity))
    {
      paramp = (Activity)this.context;
      if ((paramp.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramp.isDestroyed())))
      {
        AppMethodBeat.o(110185);
        return;
      }
    }
    if (paramInt1 == 4)
    {
      switch (paramInt2)
      {
      default: 
        paramString = a.CH(paramString);
        if (paramString != null)
        {
          paramString.a(this.context, null, null);
          AppMethodBeat.o(110185);
          return;
        }
        break;
      case -311: 
      case -310: 
      case -6: 
        if (com.tencent.mm.kernel.h.baz())
        {
          if (this.pRw == null)
          {
            this.pRw = SecurityImage.a.a(this.context, a.i.regbyqq_secimg_title, 0, this.pRy, this.pRz, this.pRA, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(110180);
                paramAnonymousDialogInterface = new ae(5, e.a(e.this), e.b(e.this).getSecImgSid(), e.b(e.this).getSecImgCode(), e.b(e.this).getSecImgEncryptKey(), true, 1);
                e.this.bwk();
                com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
                e locale = e.this;
                Context localContext = e.c(e.this);
                e.c(e.this).getString(a.i.app_tip);
                e.a(locale, k.a(localContext, e.c(e.this).getString(a.i.login_logining), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(110179);
                    e.this.onDetach();
                    com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                    AppMethodBeat.o(110179);
                  }
                }));
                AppMethodBeat.o(110180);
              }
            }, null, new DialogInterface.OnDismissListener()new b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(304889);
                e.d(e.this);
                AppMethodBeat.o(304889);
              }
            }, new b());
            AppMethodBeat.o(110185);
            return;
          }
          this.pRw.b(0, this.pRy, this.pRz, this.pRA);
        }
        AppMethodBeat.o(110185);
        return;
      case -3: 
        paramString = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(110178);
            e.this.pRv = null;
            e.this.onDetach();
            e.this.bWE();
            AppMethodBeat.o(110178);
          }
        };
        this.pRv = k.a(this.context, this.context.getString(a.i.bind_qq_verify_alert_wrong), this.context.getString(a.i.app_tip), paramString, null);
        AppMethodBeat.o(110185);
        return;
      case -72: 
        this.pRv = k.s(this.context, a.i.chatting_niceqq_expired_tip, a.i.app_tip);
        AppMethodBeat.o(110185);
        return;
      case -34: 
        this.pRv = k.c(this.context, this.context.getString(a.i.bind_qq_verify_alert_failed_freq_limit), this.context.getString(a.i.app_tip), true);
        AppMethodBeat.o(110185);
        return;
      }
      AppMethodBeat.o(110185);
      return;
    }
    paramString = a.CH(paramString);
    if (paramString != null)
    {
      paramString.a(this.context, null, null);
      AppMethodBeat.o(110185);
      return;
    }
    AppMethodBeat.o(110185);
  }
  
  public static abstract interface a
  {
    public abstract void bWD();
    
    public abstract boolean fa(int paramInt1, int paramInt2);
  }
  
  final class b
    extends SecurityImage.b
  {
    b() {}
    
    public final void bWF()
    {
      AppMethodBeat.i(110181);
      e.this.bwk();
      ae localae = new ae(5, e.a(e.this), e.b(e.this).getSecImgSid(), e.b(e.this).getSecImgCode(), e.b(e.this).getSecImgEncryptKey(), true, 1);
      com.tencent.mm.kernel.h.aZW().a(localae, 0);
      AppMethodBeat.o(110181);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.e
 * JD-Core Version:    0.7.0.1
 */