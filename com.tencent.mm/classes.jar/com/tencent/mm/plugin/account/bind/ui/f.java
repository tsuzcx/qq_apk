package com.tencent.mm.plugin.account.bind.ui;

import android.annotation.TargetApi;
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
import com.tencent.mm.an.ac;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fae;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.s;

public final class f
  implements i
{
  private Context context;
  private View mUM;
  private s mUN;
  com.tencent.mm.ui.widget.a.d mUO;
  private SecurityImage mUP;
  private String mUQ;
  private byte[] mUR;
  private String mUS;
  private String mUT;
  private a mUU;
  
  public f(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.mUM = null;
    this.mUN = null;
    this.mUO = null;
    this.mUQ = "";
    this.mUP = null;
    this.mUR = null;
    this.mUS = "";
    this.mUU = parama;
  }
  
  public final void bbp()
  {
    AppMethodBeat.i(110182);
    com.tencent.mm.kernel.h.aGY().a(384, this);
    AppMethodBeat.o(110182);
  }
  
  public final void bxP()
  {
    AppMethodBeat.i(110184);
    this.mUM = View.inflate(this.context, a.f.sendqqpwd_dialog, null);
    Object localObject = (EditText)this.mUM.findViewById(a.e.sendqqpwd_content);
    ((EditText)localObject).setHint(a.i.bind_qq_verify_textview_pwd);
    localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110175);
        f.this.mUO = null;
        f.a(f.this, this.mUV.getText().toString().trim());
        AppMethodBeat.o(110175);
      }
    };
    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110176);
        f.this.mUO = null;
        f.this.onDetach();
        AppMethodBeat.o(110176);
      }
    };
    this.mUO = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(a.i.bind_qq_verify_alert_pwd), this.mUM, (DialogInterface.OnClickListener)localObject, local2);
    AppMethodBeat.o(110184);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(110183);
    com.tencent.mm.kernel.h.aGY().b(384, this);
    if (this.mUU != null) {
      this.mUU.bxO();
    }
    AppMethodBeat.o(110183);
  }
  
  @TargetApi(17)
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(110185);
    onDetach();
    if ((paramq == null) || (paramq.getType() != 384))
    {
      AppMethodBeat.o(110185);
      return;
    }
    if (this.mUN != null)
    {
      this.mUN.dismiss();
      this.mUN = null;
    }
    this.mUS = z.a(((fae)d.c.b(((ad)paramq).rr.lBS)).TmK);
    paramq = (ad)paramq;
    if ((((fae)d.c.b(paramq.rr.lBS)).RLX != null) && (((fae)d.c.b(paramq.rr.lBS)).RLX.Ufv > 0)) {}
    for (paramq = com.tencent.mm.kernel.h.aHE().aGC().Gq(paramq.maC);; paramq = z.a(((fae)d.c.b(paramq.rr.lBS)).RIH))
    {
      this.mUR = paramq;
      if ((this.mUU == null) || (!this.mUU.eg(paramInt1, paramInt2))) {
        break;
      }
      AppMethodBeat.o(110185);
      return;
    }
    if ((this.context instanceof Activity))
    {
      paramq = (Activity)this.context;
      if ((paramq.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramq.isDestroyed())))
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
        paramString = a.Kb(paramString);
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
        if (com.tencent.mm.kernel.h.aHB())
        {
          if (this.mUP == null)
          {
            this.mUP = SecurityImage.a.a(this.context, a.i.regbyqq_secimg_title, 0, this.mUR, this.mUS, this.mUT, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(110180);
                paramAnonymousDialogInterface = new ad(5, f.a(f.this), f.b(f.this).getSecImgSid(), f.b(f.this).getSecImgCode(), f.b(f.this).getSecImgEncryptKey(), true, 1);
                f.this.bbp();
                com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
                f localf = f.this;
                Context localContext = f.c(f.this);
                f.c(f.this).getString(a.i.app_tip);
                f.a(localf, com.tencent.mm.ui.base.h.a(localContext, f.c(f.this).getString(a.i.login_logining), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(110179);
                    f.this.onDetach();
                    com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface);
                    AppMethodBeat.o(110179);
                  }
                }));
                AppMethodBeat.o(110180);
              }
            }, null, new DialogInterface.OnDismissListener()new b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(241773);
                f.d(f.this);
                AppMethodBeat.o(241773);
              }
            }, new b());
            AppMethodBeat.o(110185);
            return;
          }
          this.mUP.b(0, this.mUR, this.mUS, this.mUT);
        }
        AppMethodBeat.o(110185);
        return;
      case -3: 
        paramString = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(110178);
            f.this.mUO = null;
            f.this.onDetach();
            f.this.bxP();
            AppMethodBeat.o(110178);
          }
        };
        this.mUO = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(a.i.bind_qq_verify_alert_wrong), this.context.getString(a.i.app_tip), paramString, null);
        AppMethodBeat.o(110185);
        return;
      case -72: 
        this.mUO = com.tencent.mm.ui.base.h.p(this.context, a.i.chatting_niceqq_expired_tip, a.i.app_tip);
        AppMethodBeat.o(110185);
        return;
      case -34: 
        this.mUO = com.tencent.mm.ui.base.h.c(this.context, this.context.getString(a.i.bind_qq_verify_alert_failed_freq_limit), this.context.getString(a.i.app_tip), true);
        AppMethodBeat.o(110185);
        return;
      }
      AppMethodBeat.o(110185);
      return;
    }
    paramString = a.Kb(paramString);
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
    public abstract void bxO();
    
    public abstract boolean eg(int paramInt1, int paramInt2);
  }
  
  final class b
    extends SecurityImage.b
  {
    b() {}
    
    public final void bxQ()
    {
      AppMethodBeat.i(110181);
      f.this.bbp();
      ad localad = new ad(5, f.a(f.this), f.b(f.this).getSecImgSid(), f.b(f.this).getSecImgCode(), f.b(f.this).getSecImgEncryptKey(), true, 1);
      com.tencent.mm.kernel.h.aGY().a(localad, 0);
      AppMethodBeat.o(110181);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f
 * JD-Core Version:    0.7.0.1
 */