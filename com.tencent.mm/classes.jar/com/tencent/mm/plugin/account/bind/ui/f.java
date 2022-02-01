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
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.duu;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;

public final class f
  implements com.tencent.mm.al.f
{
  Context context;
  private View jcq;
  p jcr;
  d jcs;
  SecurityImage jct;
  String jcu;
  private byte[] jcv;
  private String jcw;
  private String jcx;
  private f.a jcy;
  
  public f(Context paramContext, f.a parama)
  {
    this.context = paramContext;
    this.jcq = null;
    this.jcr = null;
    this.jcs = null;
    this.jcu = "";
    this.jct = null;
    this.jcv = null;
    this.jcw = "";
    this.jcy = parama;
  }
  
  public final void aSu()
  {
    AppMethodBeat.i(110184);
    this.jcq = View.inflate(this.context, 2131495370, null);
    Object localObject = (EditText)this.jcq.findViewById(2131304589);
    ((EditText)localObject).setHint(2131756547);
    localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110175);
        f.this.jcs = null;
        paramAnonymousDialogInterface = f.this;
        Object localObject = this.jcz.getText().toString().trim();
        paramAnonymousDialogInterface.ayX();
        paramAnonymousDialogInterface.jcu = ((String)localObject);
        localObject = paramAnonymousDialogInterface.context;
        paramAnonymousDialogInterface.context.getString(2131755906);
        paramAnonymousDialogInterface.jcr = h.b((Context)localObject, paramAnonymousDialogInterface.context.getString(2131763077), true, new f.3(paramAnonymousDialogInterface));
        g.aiU().a(new ac(5, paramAnonymousDialogInterface.jcu, "", "", "", false, 1), 0);
        AppMethodBeat.o(110175);
      }
    };
    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110176);
        f.this.jcs = null;
        f.this.onDetach();
        AppMethodBeat.o(110176);
      }
    };
    this.jcs = h.a(this.context, this.context.getString(2131756542), this.jcq, (DialogInterface.OnClickListener)localObject, local2);
    AppMethodBeat.o(110184);
  }
  
  public final void ayX()
  {
    AppMethodBeat.i(110182);
    g.aiU().a(384, this);
    AppMethodBeat.o(110182);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(110183);
    g.aiU().b(384, this);
    if (this.jcy != null) {
      this.jcy.aSt();
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
    if (this.jcr != null)
    {
      this.jcr.dismiss();
      this.jcr = null;
    }
    this.jcw = com.tencent.mm.platformtools.z.a(((duu)((ac)paramn).rr.hNL.hNQ).GEQ);
    paramn = (ac)paramn;
    if ((((duu)paramn.rr.hNL.hNQ).FyW != null) && (((duu)paramn.rr.hNL.hNQ).FyW.getILen() > 0)) {}
    for (paramn = g.ajA().aiC().rP(paramn.imA);; paramn = com.tencent.mm.platformtools.z.a(((duu)paramn.rr.hNL.hNQ).Fvm))
    {
      this.jcv = paramn;
      if ((this.jcy == null) || (!this.jcy.dA(paramInt1, paramInt2))) {
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
        paramString = com.tencent.mm.h.a.uz(paramString);
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
        if (g.ajx())
        {
          if (this.jct == null)
          {
            this.jct = SecurityImage.a.a(this.context, 0, this.jcv, this.jcw, this.jcx, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(110180);
                paramAnonymousDialogInterface = new ac(5, f.this.jcu, f.this.jct.getSecImgSid(), f.this.jct.getSecImgCode(), f.this.jct.getSecImgEncryptKey(), true, 1);
                f.this.ayX();
                g.aiU().a(paramAnonymousDialogInterface, 0);
                f localf = f.this;
                Context localContext = f.this.context;
                f.this.context.getString(2131755906);
                localf.jcr = h.b(localContext, f.this.context.getString(2131760781), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(110179);
                    f.this.onDetach();
                    g.aiU().a(paramAnonymousDialogInterface);
                    AppMethodBeat.o(110179);
                  }
                });
                AppMethodBeat.o(110180);
              }
            }, null, new DialogInterface.OnDismissListener()new b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                f.this.jct = null;
              }
            }, new b());
            AppMethodBeat.o(110185);
            return;
          }
          this.jct.b(0, this.jcv, this.jcw, this.jcx);
        }
        AppMethodBeat.o(110185);
        return;
      case -3: 
        paramString = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(110178);
            f.this.jcs = null;
            f.this.onDetach();
            f.this.aSu();
            AppMethodBeat.o(110178);
          }
        };
        this.jcs = h.a(this.context, this.context.getString(2131756546), this.context.getString(2131755906), paramString, null);
        AppMethodBeat.o(110185);
        return;
      case -72: 
        this.jcs = h.l(this.context, 2131757258, 2131755906);
        AppMethodBeat.o(110185);
        return;
      case -34: 
        this.jcs = h.c(this.context, this.context.getString(2131756539), this.context.getString(2131755906), true);
        AppMethodBeat.o(110185);
        return;
      }
      AppMethodBeat.o(110185);
      return;
    }
    paramString = com.tencent.mm.h.a.uz(paramString);
    if (paramString != null)
    {
      paramString.a(this.context, null, null);
      AppMethodBeat.o(110185);
      return;
    }
    AppMethodBeat.o(110185);
  }
  
  final class b
    extends SecurityImage.b
  {
    b() {}
    
    public final void aSv()
    {
      AppMethodBeat.i(110181);
      f.this.ayX();
      ac localac = new ac(5, f.this.jcu, f.this.jct.getSecImgSid(), f.this.jct.getSecImgCode(), f.this.jct.getSecImgEncryptKey(), true, 1);
      g.aiU().a(localac, 0);
      AppMethodBeat.o(110181);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f
 * JD-Core Version:    0.7.0.1
 */