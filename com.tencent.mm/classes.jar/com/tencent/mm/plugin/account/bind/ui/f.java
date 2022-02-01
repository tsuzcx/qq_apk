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
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.djo;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;

public final class f
  implements com.tencent.mm.al.g
{
  Context context;
  private View ija;
  p ijb;
  d ijc;
  SecurityImage ijd;
  String ije;
  private byte[] ijf;
  private String ijg;
  private String ijh;
  private a iji;
  
  public f(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.ija = null;
    this.ijb = null;
    this.ijc = null;
    this.ije = "";
    this.ijd = null;
    this.ijf = null;
    this.ijg = "";
    this.iji = parama;
  }
  
  public final void aIr()
  {
    AppMethodBeat.i(110184);
    this.ija = View.inflate(this.context, 2131495370, null);
    Object localObject = (EditText)this.ija.findViewById(2131304589);
    ((EditText)localObject).setHint(2131756547);
    localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110175);
        f.this.ijc = null;
        paramAnonymousDialogInterface = f.this;
        Object localObject = this.ijj.getText().toString().trim();
        paramAnonymousDialogInterface.apt();
        paramAnonymousDialogInterface.ije = ((String)localObject);
        localObject = paramAnonymousDialogInterface.context;
        paramAnonymousDialogInterface.context.getString(2131755906);
        paramAnonymousDialogInterface.ijb = h.b((Context)localObject, paramAnonymousDialogInterface.context.getString(2131763077), true, new f.3(paramAnonymousDialogInterface));
        com.tencent.mm.kernel.g.aeS().a(new ac(5, paramAnonymousDialogInterface.ije, "", "", "", false, 1), 0);
        AppMethodBeat.o(110175);
      }
    };
    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110176);
        f.this.ijc = null;
        f.this.onDetach();
        AppMethodBeat.o(110176);
      }
    };
    this.ijc = h.a(this.context, this.context.getString(2131756542), this.ija, (DialogInterface.OnClickListener)localObject, local2);
    AppMethodBeat.o(110184);
  }
  
  public final void apt()
  {
    AppMethodBeat.i(110182);
    com.tencent.mm.kernel.g.aeS().a(384, this);
    AppMethodBeat.o(110182);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(110183);
    com.tencent.mm.kernel.g.aeS().b(384, this);
    if (this.iji != null) {
      this.iji.aIq();
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
    if (this.ijb != null)
    {
      this.ijb.dismiss();
      this.ijb = null;
    }
    this.ijg = com.tencent.mm.platformtools.z.a(((djo)((ac)paramn).rr.gUT.gUX).DzX);
    paramn = (ac)paramn;
    if ((((djo)paramn.rr.gUT.gUX).CBe != null) && (((djo)paramn.rr.gUT.gUX).CBe.getILen() > 0)) {}
    for (paramn = com.tencent.mm.kernel.g.afz().aeA().mc(paramn.hsH);; paramn = com.tencent.mm.platformtools.z.a(((djo)paramn.rr.gUT.gUX).CxB))
    {
      this.ijf = paramn;
      if ((this.iji == null) || (!this.iji.dy(paramInt1, paramInt2))) {
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
        paramString = com.tencent.mm.h.a.oG(paramString);
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
        if (com.tencent.mm.kernel.g.afw())
        {
          if (this.ijd == null)
          {
            this.ijd = SecurityImage.a.a(this.context, 0, this.ijf, this.ijg, this.ijh, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(110180);
                paramAnonymousDialogInterface = new ac(5, f.this.ije, f.this.ijd.getSecImgSid(), f.this.ijd.getSecImgCode(), f.this.ijd.getSecImgEncryptKey(), true, 1);
                f.this.apt();
                com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface, 0);
                f localf = f.this;
                Context localContext = f.this.context;
                f.this.context.getString(2131755906);
                localf.ijb = h.b(localContext, f.this.context.getString(2131760781), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(110179);
                    f.this.onDetach();
                    com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface);
                    AppMethodBeat.o(110179);
                  }
                });
                AppMethodBeat.o(110180);
              }
            }, null, new DialogInterface.OnDismissListener()new b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                f.this.ijd = null;
              }
            }, new b());
            AppMethodBeat.o(110185);
            return;
          }
          this.ijd.b(0, this.ijf, this.ijg, this.ijh);
        }
        AppMethodBeat.o(110185);
        return;
      case -3: 
        paramString = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(110178);
            f.this.ijc = null;
            f.this.onDetach();
            f.this.aIr();
            AppMethodBeat.o(110178);
          }
        };
        this.ijc = h.a(this.context, this.context.getString(2131756546), this.context.getString(2131755906), paramString, null);
        AppMethodBeat.o(110185);
        return;
      case -72: 
        this.ijc = h.j(this.context, 2131757258, 2131755906);
        AppMethodBeat.o(110185);
        return;
      case -34: 
        this.ijc = h.c(this.context, this.context.getString(2131756539), this.context.getString(2131755906), true);
        AppMethodBeat.o(110185);
        return;
      }
      AppMethodBeat.o(110185);
      return;
    }
    paramString = com.tencent.mm.h.a.oG(paramString);
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
    public abstract void aIq();
    
    public abstract boolean dy(int paramInt1, int paramInt2);
  }
  
  final class b
    extends SecurityImage.b
  {
    b() {}
    
    public final void aIs()
    {
      AppMethodBeat.i(110181);
      f.this.apt();
      ac localac = new ac(5, f.this.ije, f.this.ijd.getSecImgSid(), f.this.ijd.getSecImgCode(), f.this.ijd.getSecImgEncryptKey(), true, 1);
      com.tencent.mm.kernel.g.aeS().a(localac, 0);
      AppMethodBeat.o(110181);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f
 * JD-Core Version:    0.7.0.1
 */