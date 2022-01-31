package com.tencent.mm.plugin.account.bind.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.ccw;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public final class f
  implements com.tencent.mm.ah.f
{
  Context context;
  private String feA;
  private String feB;
  private a feC;
  private View feu;
  com.tencent.mm.ui.base.p fev;
  c few;
  SecurityImage fex;
  String fey;
  private byte[] fez;
  
  public f(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.feu = null;
    this.fev = null;
    this.few = null;
    this.fey = "";
    this.fex = null;
    this.fez = null;
    this.feA = "";
    this.feC = parama;
  }
  
  public final void Fj()
  {
    g.Dk().a(384, this);
  }
  
  public final void Wr()
  {
    this.feu = View.inflate(this.context, a.f.sendqqpwd_dialog, null);
    Object localObject = (EditText)this.feu.findViewById(a.e.sendqqpwd_content);
    ((EditText)localObject).setHint(a.i.bind_qq_verify_textview_pwd);
    localObject = new f.1(this, (EditText)localObject);
    f.2 local2 = new f.2(this);
    this.few = h.a(this.context, this.context.getString(a.i.bind_qq_verify_alert_pwd), this.feu, (DialogInterface.OnClickListener)localObject, local2);
  }
  
  public final void onDetach()
  {
    g.Dk().b(384, this);
    if (this.feC != null) {
      this.feC.Wq();
    }
  }
  
  @TargetApi(17)
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    onDetach();
    if ((paramm == null) || (paramm.getType() != 384)) {}
    label20:
    label506:
    do
    {
      do
      {
        return;
        if (this.fev != null)
        {
          this.fev.dismiss();
          this.fev = null;
        }
        this.feA = aa.a(((ccw)((ab)paramm).dmK.ecF.ecN).tii);
        paramm = (ab)paramm;
        if ((((ccw)paramm.dmK.ecF.ecN).syk != null) && (((ccw)paramm.dmK.ecF.ecN).syk.tFK > 0)) {}
        for (paramm = g.DN().CU().bH(paramm.eAo);; paramm = aa.a(((ccw)paramm.dmK.ecF.ecN).svJ))
        {
          this.fez = paramm;
          if ((this.feC != null) && (this.feC.bG(paramInt1, paramInt2))) {
            break;
          }
          if ((this.context instanceof Activity))
          {
            paramm = (Activity)this.context;
            if ((paramm.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramm.isDestroyed()))) {
              break;
            }
          }
          if (paramInt1 != 4) {
            break label506;
          }
          switch (paramInt2)
          {
          default: 
            paramString = com.tencent.mm.i.a.eI(paramString);
            if (paramString == null) {
              break label20;
            }
            paramString.a(this.context, null, null);
            return;
          }
        }
      } while (!g.DK());
      if (this.fex == null)
      {
        this.fex = SecurityImage.a.a(this.context, a.i.regbyqq_secimg_title, 0, this.fez, this.feA, this.feB, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface = new ab(5, f.this.fey, f.this.fex.getSecImgSid(), f.this.fex.getSecImgCode(), f.this.fex.getSecImgEncryptKey(), true, 1);
            f.this.Fj();
            g.Dk().a(paramAnonymousDialogInterface, 0);
            f localf = f.this;
            Context localContext = f.this.context;
            f.this.context.getString(a.i.app_tip);
            localf.fev = h.b(localContext, f.this.context.getString(a.i.login_logining), true, new f.5.1(this, paramAnonymousDialogInterface));
          }
        }, null, new f.6(this), new f.b(this));
        return;
      }
      this.fex.a(0, this.fez, this.feA, this.feB);
      return;
      paramString = new f.4(this);
      this.few = h.a(this.context, this.context.getString(a.i.bind_qq_verify_alert_wrong), this.context.getString(a.i.app_tip), paramString, null);
      return;
      this.few = h.h(this.context, a.i.chatting_niceqq_expired_tip, a.i.app_tip);
      return;
      this.few = h.b(this.context, this.context.getString(a.i.bind_qq_verify_alert_failed_freq_limit), this.context.getString(a.i.app_tip), true);
      return;
      paramString = com.tencent.mm.i.a.eI(paramString);
    } while (paramString == null);
    paramString.a(this.context, null, null);
  }
  
  public static abstract interface a
  {
    public abstract void Wq();
    
    public abstract boolean bG(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f
 * JD-Core Version:    0.7.0.1
 */