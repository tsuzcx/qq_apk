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
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dpd;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;

public final class f
  implements com.tencent.mm.ak.g
{
  Context context;
  private View iJh;
  p iJi;
  d iJj;
  SecurityImage iJk;
  String iJl;
  private byte[] iJm;
  private String iJn;
  private String iJo;
  private a iJp;
  
  public f(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.iJh = null;
    this.iJi = null;
    this.iJj = null;
    this.iJl = "";
    this.iJk = null;
    this.iJm = null;
    this.iJn = "";
    this.iJp = parama;
  }
  
  public final void aPi()
  {
    AppMethodBeat.i(110184);
    this.iJh = View.inflate(this.context, 2131495370, null);
    Object localObject = (EditText)this.iJh.findViewById(2131304589);
    ((EditText)localObject).setHint(2131756547);
    localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110175);
        f.this.iJj = null;
        paramAnonymousDialogInterface = f.this;
        Object localObject = this.iJq.getText().toString().trim();
        paramAnonymousDialogInterface.awk();
        paramAnonymousDialogInterface.iJl = ((String)localObject);
        localObject = paramAnonymousDialogInterface.context;
        paramAnonymousDialogInterface.context.getString(2131755906);
        paramAnonymousDialogInterface.iJi = h.b((Context)localObject, paramAnonymousDialogInterface.context.getString(2131763077), true, new f.3(paramAnonymousDialogInterface));
        com.tencent.mm.kernel.g.agi().a(new ac(5, paramAnonymousDialogInterface.iJl, "", "", "", false, 1), 0);
        AppMethodBeat.o(110175);
      }
    };
    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110176);
        f.this.iJj = null;
        f.this.onDetach();
        AppMethodBeat.o(110176);
      }
    };
    this.iJj = h.a(this.context, this.context.getString(2131756542), this.iJh, (DialogInterface.OnClickListener)localObject, local2);
    AppMethodBeat.o(110184);
  }
  
  public final void awk()
  {
    AppMethodBeat.i(110182);
    com.tencent.mm.kernel.g.agi().a(384, this);
    AppMethodBeat.o(110182);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(110183);
    com.tencent.mm.kernel.g.agi().b(384, this);
    if (this.iJp != null) {
      this.iJp.aPh();
    }
    AppMethodBeat.o(110183);
  }
  
  @TargetApi(17)
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(110185);
    onDetach();
    if ((paramn == null) || (paramn.getType() != 384))
    {
      AppMethodBeat.o(110185);
      return;
    }
    if (this.iJi != null)
    {
      this.iJi.dismiss();
      this.iJi = null;
    }
    this.iJn = com.tencent.mm.platformtools.z.a(((dpd)((ac)paramn).rr.hvs.hvw).EVt);
    paramn = (ac)paramn;
    if ((((dpd)paramn.rr.hvs.hvw).DTC != null) && (((dpd)paramn.rr.hvs.hvw).DTC.getILen() > 0)) {}
    for (paramn = com.tencent.mm.kernel.g.agP().afQ().pQ(paramn.hTj);; paramn = com.tencent.mm.platformtools.z.a(((dpd)paramn.rr.hvs.hvw).DPX))
    {
      this.iJm = paramn;
      if ((this.iJp == null) || (!this.iJp.dy(paramInt1, paramInt2))) {
        break;
      }
      AppMethodBeat.o(110185);
      return;
    }
    if ((this.context instanceof Activity))
    {
      paramn = (Activity)this.context;
      if ((paramn.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramn.isDestroyed())))
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
        paramString = com.tencent.mm.h.a.rM(paramString);
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
        if (com.tencent.mm.kernel.g.agM())
        {
          if (this.iJk == null)
          {
            this.iJk = SecurityImage.a.a(this.context, 0, this.iJm, this.iJn, this.iJo, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(110180);
                paramAnonymousDialogInterface = new ac(5, f.this.iJl, f.this.iJk.getSecImgSid(), f.this.iJk.getSecImgCode(), f.this.iJk.getSecImgEncryptKey(), true, 1);
                f.this.awk();
                com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
                f localf = f.this;
                Context localContext = f.this.context;
                f.this.context.getString(2131755906);
                localf.iJi = h.b(localContext, f.this.context.getString(2131760781), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(110179);
                    f.this.onDetach();
                    com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface);
                    AppMethodBeat.o(110179);
                  }
                });
                AppMethodBeat.o(110180);
              }
            }, null, new DialogInterface.OnDismissListener()new b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                f.this.iJk = null;
              }
            }, new b());
            AppMethodBeat.o(110185);
            return;
          }
          this.iJk.b(0, this.iJm, this.iJn, this.iJo);
        }
        AppMethodBeat.o(110185);
        return;
      case -3: 
        paramString = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(110178);
            f.this.iJj = null;
            f.this.onDetach();
            f.this.aPi();
            AppMethodBeat.o(110178);
          }
        };
        this.iJj = h.a(this.context, this.context.getString(2131756546), this.context.getString(2131755906), paramString, null);
        AppMethodBeat.o(110185);
        return;
      case -72: 
        this.iJj = h.l(this.context, 2131757258, 2131755906);
        AppMethodBeat.o(110185);
        return;
      case -34: 
        this.iJj = h.c(this.context, this.context.getString(2131756539), this.context.getString(2131755906), true);
        AppMethodBeat.o(110185);
        return;
      }
      AppMethodBeat.o(110185);
      return;
    }
    paramString = com.tencent.mm.h.a.rM(paramString);
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
    public abstract void aPh();
    
    public abstract boolean dy(int paramInt1, int paramInt2);
  }
  
  final class b
    extends SecurityImage.b
  {
    b() {}
    
    public final void aPj()
    {
      AppMethodBeat.i(110181);
      f.this.awk();
      ac localac = new ac(5, f.this.iJl, f.this.iJk.getSecImgSid(), f.this.iJk.getSecImgCode(), f.this.iJk.getSecImgEncryptKey(), true, 1);
      com.tencent.mm.kernel.g.agi().a(localac, 0);
      AppMethodBeat.o(110181);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f
 * JD-Core Version:    0.7.0.1
 */