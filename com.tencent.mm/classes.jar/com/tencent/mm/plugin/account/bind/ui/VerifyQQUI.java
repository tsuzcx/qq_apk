package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.g.a.jc.b;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.jd.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;

public class VerifyQQUI
  extends MMWizardActivity
  implements com.tencent.mm.ak.g
{
  private String dkA;
  private String dky;
  private byte[] htZ;
  private String iJA;
  private String iJB;
  private String iJC;
  private b iJD;
  private SecurityImage iJk;
  private long iJz;
  private p tipDialog;
  
  public VerifyQQUI()
  {
    AppMethodBeat.i(110211);
    this.tipDialog = null;
    this.iJz = 0L;
    this.iJA = "";
    this.htZ = null;
    this.iJB = "";
    this.iJk = null;
    this.iJD = new b(this);
    AppMethodBeat.o(110211);
  }
  
  public int getLayoutId()
  {
    return 2131493187;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110216);
    Object localObject = new jc();
    ((jc)localObject).dkw.context = this;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    this.dky = ((jc)localObject).dkx.dky;
    localObject = new jd();
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    this.dkA = ((jd)localObject).dkz.dkA;
    setMMTitle(2131756549);
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
    findViewById(2131297264);
    findViewById(2131297263);
    addTextOptionMenu(0, getString(2131755779), this.iJD);
    AppMethodBeat.o(110216);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110212);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(144, this);
    AppMethodBeat.o(110212);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110213);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(144, this);
    AppMethodBeat.o(110213);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110214);
    super.onResume();
    initView();
    AppMethodBeat.o(110214);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(110217);
    ac.i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.plugin.account.bind.a.b localb = (com.tencent.mm.plugin.account.bind.a.b)paramn;
    byte[] arrayOfByte = com.tencent.mm.kernel.g.agP().afQ().pQ(localb.hTj);
    ac.i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", new Object[] { Integer.valueOf(bs.m(arrayOfByte, new byte[0]).length), Long.valueOf(localb.hTj) });
    if (bs.cv(arrayOfByte)) {
      arrayOfByte = com.tencent.mm.platformtools.z.a(((lj)localb.rr.hvs.hvw).DPX);
    }
    for (;;)
    {
      this.htZ = arrayOfByte;
      this.iJB = ((lj)((com.tencent.mm.plugin.account.bind.a.b)paramn).rr.hvs.hvw).DYT;
      if (this.htZ != null) {
        ac.d("MicroMsg.VerifyQQUI", "imgSid:" + this.iJB + " img len" + this.htZ.length + " " + f.YG());
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.account.a.a.iyy.Lj();
        h.a(getContext(), 2131756544, 2131756545, new DialogInterface.OnClickListener()
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
          paramString = com.tencent.mm.h.a.rM(paramString);
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
        paramString = com.tencent.mm.h.a.rM(paramString);
        if (paramString != null)
        {
          paramString.a(this, null, null);
          i = 1;
        }
        else
        {
          h.l(getContext(), 2131756546, 2131756541);
          i = 1;
          continue;
          h.l(getContext(), 2131756537, 2131756541);
          i = 1;
          continue;
          h.l(getContext(), 2131756540, 2131755906);
          i = 1;
          continue;
          h.l(getContext(), 2131756538, 2131755906);
          i = 1;
          continue;
          if (this.htZ != null) {
            ac.d("MicroMsg.VerifyQQUI", "imgSid:" + this.iJB + " img len" + this.htZ.length + " " + f.YG());
          }
          if (!com.tencent.mm.kernel.g.agM())
          {
            i = 1;
          }
          else
          {
            if (this.iJk == null) {
              this.iJk = SecurityImage.a.a(getContext(), 0, this.htZ, this.iJB, this.iJC, new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(110205);
                  paramAnonymousDialogInterface = new com.tencent.mm.plugin.account.bind.a.b(VerifyQQUI.c(VerifyQQUI.this), VerifyQQUI.d(VerifyQQUI.this), VerifyQQUI.e(VerifyQQUI.this).getSecImgSid(), VerifyQQUI.e(VerifyQQUI.this).getSecImgCode(), VerifyQQUI.e(VerifyQQUI.this).getSecImgEncryptKey(), VerifyQQUI.f(VerifyQQUI.this), VerifyQQUI.g(VerifyQQUI.this), true);
                  com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
                  VerifyQQUI localVerifyQQUI = VerifyQQUI.this;
                  AppCompatActivity localAppCompatActivity = VerifyQQUI.this.getContext();
                  VerifyQQUI.this.getString(2131756545);
                  VerifyQQUI.a(localVerifyQQUI, h.b(localAppCompatActivity, VerifyQQUI.this.getString(2131756536), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(110204);
                      com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface);
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
              if (this.htZ != null) {
                ac.d("MicroMsg.VerifyQQUI", "imgSid:" + this.iJB + " img len" + this.htZ.length + " " + f.YG());
              }
              this.iJk.b(0, this.htZ, this.iJB, this.iJC);
            }
            h.l(getContext(), 2131756539, 2131755906);
            i = 1;
            continue;
            i = 0;
          }
        }
      }
      Toast.makeText(this, getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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
    
    public final void aPj()
    {
      AppMethodBeat.i(110207);
      com.tencent.mm.plugin.account.bind.a.b localb = new com.tencent.mm.plugin.account.bind.a.b(VerifyQQUI.c(VerifyQQUI.this), VerifyQQUI.d(VerifyQQUI.this), VerifyQQUI.i(VerifyQQUI.this), "", VerifyQQUI.j(VerifyQQUI.this), 2, true);
      com.tencent.mm.kernel.g.agi().a(localb, 0);
      AppMethodBeat.o(110207);
    }
  }
  
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    WeakReference<VerifyQQUI> cnv;
    
    protected b(VerifyQQUI paramVerifyQQUI)
    {
      AppMethodBeat.i(110209);
      this.cnv = new WeakReference(paramVerifyQQUI);
      AppMethodBeat.o(110209);
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(110210);
      paramMenuItem = (VerifyQQUI)this.cnv.get();
      if ((paramMenuItem == null) || (paramMenuItem.isFinishing()))
      {
        AppMethodBeat.o(110210);
        return true;
      }
      Object localObject = (EditText)paramMenuItem.findViewById(2131297264);
      EditText localEditText = (EditText)paramMenuItem.findViewById(2131297263);
      localObject = ((EditText)localObject).getText().toString().trim();
      VerifyQQUI.a(paramMenuItem, localEditText.getText().toString().trim());
      try
      {
        VerifyQQUI.a(paramMenuItem, bs.getLong((String)localObject, 0L));
        if (VerifyQQUI.c(paramMenuItem) < 10000L)
        {
          h.l(paramMenuItem.getContext(), 2131756543, 2131756541);
          AppMethodBeat.o(110210);
          return true;
        }
      }
      catch (Exception localException)
      {
        h.l(paramMenuItem.getContext(), 2131756543, 2131756541);
        AppMethodBeat.o(110210);
        return true;
      }
      if (VerifyQQUI.d(paramMenuItem).equals(""))
      {
        h.l(paramMenuItem.getContext(), 2131756542, 2131756541);
        AppMethodBeat.o(110210);
        return true;
      }
      paramMenuItem.hideVKB();
      final com.tencent.mm.plugin.account.bind.a.b localb = new com.tencent.mm.plugin.account.bind.a.b(VerifyQQUI.c(paramMenuItem), VerifyQQUI.d(paramMenuItem), "", "", "", VerifyQQUI.f(paramMenuItem), VerifyQQUI.g(paramMenuItem), false);
      com.tencent.mm.kernel.g.agi().a(localb, 0);
      localObject = paramMenuItem.getContext();
      paramMenuItem.getString(2131756545);
      VerifyQQUI.a(paramMenuItem, h.b((Context)localObject, paramMenuItem.getString(2131756536), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(110208);
          com.tencent.mm.kernel.g.agi().a(localb);
          AppMethodBeat.o(110208);
        }
      }));
      AppMethodBeat.o(110210);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.VerifyQQUI
 * JD-Core Version:    0.7.0.1
 */