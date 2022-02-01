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
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dvr;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;

public final class f
  implements com.tencent.mm.ak.f
{
  Context context;
  private View jfj;
  p jfk;
  d jfl;
  SecurityImage jfm;
  String jfn;
  private byte[] jfo;
  private String jfp;
  private String jfq;
  private a jfr;
  
  public f(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.jfj = null;
    this.jfk = null;
    this.jfl = null;
    this.jfn = "";
    this.jfm = null;
    this.jfo = null;
    this.jfp = "";
    this.jfr = parama;
  }
  
  public final void aST()
  {
    AppMethodBeat.i(110184);
    this.jfj = View.inflate(this.context, 2131495370, null);
    Object localObject = (EditText)this.jfj.findViewById(2131304589);
    ((EditText)localObject).setHint(2131756547);
    localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110175);
        f.this.jfl = null;
        paramAnonymousDialogInterface = f.this;
        Object localObject = this.jfs.getText().toString().trim();
        paramAnonymousDialogInterface.azm();
        paramAnonymousDialogInterface.jfn = ((String)localObject);
        localObject = paramAnonymousDialogInterface.context;
        paramAnonymousDialogInterface.context.getString(2131755906);
        paramAnonymousDialogInterface.jfk = h.b((Context)localObject, paramAnonymousDialogInterface.context.getString(2131763077), true, new f.3(paramAnonymousDialogInterface));
        g.ajj().a(new ad(5, paramAnonymousDialogInterface.jfn, "", "", "", false, 1), 0);
        AppMethodBeat.o(110175);
      }
    };
    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110176);
        f.this.jfl = null;
        f.this.onDetach();
        AppMethodBeat.o(110176);
      }
    };
    this.jfl = h.a(this.context, this.context.getString(2131756542), this.jfj, (DialogInterface.OnClickListener)localObject, local2);
    AppMethodBeat.o(110184);
  }
  
  public final void azm()
  {
    AppMethodBeat.i(110182);
    g.ajj().a(384, this);
    AppMethodBeat.o(110182);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(110183);
    g.ajj().b(384, this);
    if (this.jfr != null) {
      this.jfr.aSS();
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
    if (this.jfk != null)
    {
      this.jfk.dismiss();
      this.jfk = null;
    }
    this.jfp = com.tencent.mm.platformtools.z.a(((dvr)((ad)paramn).rr.hQE.hQJ).GYt);
    paramn = (ad)paramn;
    if ((((dvr)paramn.rr.hQE.hQJ).FRu != null) && (((dvr)paramn.rr.hQE.hQJ).FRu.getILen() > 0)) {}
    for (paramn = g.ajP().aiR().sc(paramn.ipu);; paramn = com.tencent.mm.platformtools.z.a(((dvr)paramn.rr.hQE.hQJ).FNK))
    {
      this.jfo = paramn;
      if ((this.jfr == null) || (!this.jfr.dA(paramInt1, paramInt2))) {
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
        paramString = com.tencent.mm.h.a.uU(paramString);
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
        if (g.ajM())
        {
          if (this.jfm == null)
          {
            this.jfm = SecurityImage.a.a(this.context, 0, this.jfo, this.jfp, this.jfq, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(110180);
                paramAnonymousDialogInterface = new ad(5, f.this.jfn, f.this.jfm.getSecImgSid(), f.this.jfm.getSecImgCode(), f.this.jfm.getSecImgEncryptKey(), true, 1);
                f.this.azm();
                g.ajj().a(paramAnonymousDialogInterface, 0);
                f localf = f.this;
                Context localContext = f.this.context;
                f.this.context.getString(2131755906);
                localf.jfk = h.b(localContext, f.this.context.getString(2131760781), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(110179);
                    f.this.onDetach();
                    g.ajj().a(paramAnonymousDialogInterface);
                    AppMethodBeat.o(110179);
                  }
                });
                AppMethodBeat.o(110180);
              }
            }, null, new DialogInterface.OnDismissListener()new b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                f.this.jfm = null;
              }
            }, new b());
            AppMethodBeat.o(110185);
            return;
          }
          this.jfm.b(0, this.jfo, this.jfp, this.jfq);
        }
        AppMethodBeat.o(110185);
        return;
      case -3: 
        paramString = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(110178);
            f.this.jfl = null;
            f.this.onDetach();
            f.this.aST();
            AppMethodBeat.o(110178);
          }
        };
        this.jfl = h.a(this.context, this.context.getString(2131756546), this.context.getString(2131755906), paramString, null);
        AppMethodBeat.o(110185);
        return;
      case -72: 
        this.jfl = h.l(this.context, 2131757258, 2131755906);
        AppMethodBeat.o(110185);
        return;
      case -34: 
        this.jfl = h.c(this.context, this.context.getString(2131756539), this.context.getString(2131755906), true);
        AppMethodBeat.o(110185);
        return;
      }
      AppMethodBeat.o(110185);
      return;
    }
    paramString = com.tencent.mm.h.a.uU(paramString);
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
    public abstract void aSS();
    
    public abstract boolean dA(int paramInt1, int paramInt2);
  }
  
  final class b
    extends SecurityImage.b
  {
    b() {}
    
    public final void aSU()
    {
      AppMethodBeat.i(110181);
      f.this.azm();
      ad localad = new ad(5, f.this.jfn, f.this.jfm.getSecImgSid(), f.this.jfm.getSecImgCode(), f.this.jfm.getSecImgEncryptKey(), true, 1);
      g.ajj().a(localad, 0);
      AppMethodBeat.o(110181);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f
 * JD-Core Version:    0.7.0.1
 */