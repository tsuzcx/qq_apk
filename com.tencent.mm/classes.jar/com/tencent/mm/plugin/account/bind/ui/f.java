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
import com.tencent.mm.ak.ac;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ept;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;

public final class f
  implements i
{
  Context context;
  private View kdm;
  com.tencent.mm.ui.base.q kdn;
  com.tencent.mm.ui.widget.a.d kdo;
  SecurityImage kdp;
  String kdq;
  private byte[] kdr;
  private String kds;
  private String kdt;
  private a kdu;
  
  public f(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.kdm = null;
    this.kdn = null;
    this.kdo = null;
    this.kdq = "";
    this.kdp = null;
    this.kdr = null;
    this.kds = "";
    this.kdu = parama;
  }
  
  public final void aSs()
  {
    AppMethodBeat.i(110182);
    g.azz().a(384, this);
    AppMethodBeat.o(110182);
  }
  
  public final void bnG()
  {
    AppMethodBeat.i(110184);
    this.kdm = View.inflate(this.context, 2131496231, null);
    Object localObject = (EditText)this.kdm.findViewById(2131307635);
    ((EditText)localObject).setHint(2131756683);
    localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110175);
        f.this.kdo = null;
        paramAnonymousDialogInterface = f.this;
        Object localObject = this.kdv.getText().toString().trim();
        paramAnonymousDialogInterface.aSs();
        paramAnonymousDialogInterface.kdq = ((String)localObject);
        localObject = paramAnonymousDialogInterface.context;
        paramAnonymousDialogInterface.context.getString(2131755998);
        paramAnonymousDialogInterface.kdn = h.a((Context)localObject, paramAnonymousDialogInterface.context.getString(2131765237), true, new f.3(paramAnonymousDialogInterface));
        g.azz().a(new ad(5, paramAnonymousDialogInterface.kdq, "", "", "", false, 1), 0);
        AppMethodBeat.o(110175);
      }
    };
    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(110176);
        f.this.kdo = null;
        f.this.onDetach();
        AppMethodBeat.o(110176);
      }
    };
    this.kdo = h.a(this.context, this.context.getString(2131756678), this.kdm, (DialogInterface.OnClickListener)localObject, local2);
    AppMethodBeat.o(110184);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(110183);
    g.azz().b(384, this);
    if (this.kdu != null) {
      this.kdu.bnF();
    }
    AppMethodBeat.o(110183);
  }
  
  @TargetApi(17)
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(110185);
    onDetach();
    if ((paramq == null) || (paramq.getType() != 384))
    {
      AppMethodBeat.o(110185);
      return;
    }
    if (this.kdn != null)
    {
      this.kdn.dismiss();
      this.kdn = null;
    }
    this.kds = z.a(((ept)((ad)paramq).rr.iLL.iLR).Mdj);
    paramq = (ad)paramq;
    if ((((ept)paramq.rr.iLL.iLR).KLb != null) && (((ept)paramq.rr.iLL.iLR).KLb.getILen() > 0)) {}
    for (paramq = g.aAf().azh().Ai(paramq.jkB);; paramq = z.a(((ept)paramq.rr.iLL.iLR).KHp))
    {
      this.kdr = paramq;
      if ((this.kdu == null) || (!this.kdu.dI(paramInt1, paramInt2))) {
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
        paramString = com.tencent.mm.h.a.Dk(paramString);
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
        if (g.aAc())
        {
          if (this.kdp == null)
          {
            this.kdp = SecurityImage.a.a(this.context, 0, this.kdr, this.kds, this.kdt, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(110180);
                paramAnonymousDialogInterface = new ad(5, f.this.kdq, f.this.kdp.getSecImgSid(), f.this.kdp.getSecImgCode(), f.this.kdp.getSecImgEncryptKey(), true, 1);
                f.this.aSs();
                g.azz().a(paramAnonymousDialogInterface, 0);
                f localf = f.this;
                Context localContext = f.this.context;
                f.this.context.getString(2131755998);
                localf.kdn = h.a(localContext, f.this.context.getString(2131762532), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(110179);
                    f.this.onDetach();
                    g.azz().a(paramAnonymousDialogInterface);
                    AppMethodBeat.o(110179);
                  }
                });
                AppMethodBeat.o(110180);
              }
            }, null, new DialogInterface.OnDismissListener()new b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                f.this.kdp = null;
              }
            }, new b());
            AppMethodBeat.o(110185);
            return;
          }
          this.kdp.b(0, this.kdr, this.kds, this.kdt);
        }
        AppMethodBeat.o(110185);
        return;
      case -3: 
        paramString = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(110178);
            f.this.kdo = null;
            f.this.onDetach();
            f.this.bnG();
            AppMethodBeat.o(110178);
          }
        };
        this.kdo = h.a(this.context, this.context.getString(2131756682), this.context.getString(2131755998), paramString, null);
        AppMethodBeat.o(110185);
        return;
      case -72: 
        this.kdo = h.n(this.context, 2131757471, 2131755998);
        AppMethodBeat.o(110185);
        return;
      case -34: 
        this.kdo = h.c(this.context, this.context.getString(2131756675), this.context.getString(2131755998), true);
        AppMethodBeat.o(110185);
        return;
      }
      AppMethodBeat.o(110185);
      return;
    }
    paramString = com.tencent.mm.h.a.Dk(paramString);
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
    public abstract void bnF();
    
    public abstract boolean dI(int paramInt1, int paramInt2);
  }
  
  final class b
    extends SecurityImage.b
  {
    b() {}
    
    public final void bnH()
    {
      AppMethodBeat.i(110181);
      f.this.aSs();
      ad localad = new ad(5, f.this.kdq, f.this.kdp.getSecImgSid(), f.this.kdp.getSecImgCode(), f.this.kdp.getSecImgEncryptKey(), true, 1);
      g.azz().a(localad, 0);
      AppMethodBeat.o(110181);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f
 * JD-Core Version:    0.7.0.1
 */