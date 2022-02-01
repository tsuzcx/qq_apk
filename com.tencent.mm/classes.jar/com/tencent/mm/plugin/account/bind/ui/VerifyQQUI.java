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
import com.tencent.mm.ak.ac;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.ka.b;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.kb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.bind.a.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public class VerifyQQUI
  extends MMWizardActivity
  implements i
{
  private String dOX;
  private String dOZ;
  private byte[] iKr;
  private long kdE;
  private String kdF;
  private String kdG;
  private String kdH;
  private b kdI;
  private SecurityImage kdp;
  private com.tencent.mm.ui.base.q tipDialog;
  
  public VerifyQQUI()
  {
    AppMethodBeat.i(110211);
    this.tipDialog = null;
    this.kdE = 0L;
    this.kdF = "";
    this.iKr = null;
    this.kdG = "";
    this.kdp = null;
    this.kdI = new b(this);
    AppMethodBeat.o(110211);
  }
  
  public int getLayoutId()
  {
    return 2131493233;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110216);
    Object localObject = new ka();
    ((ka)localObject).dOV.context = this;
    EventCenter.instance.publish((IEvent)localObject);
    this.dOX = ((ka)localObject).dOW.dOX;
    localObject = new kb();
    EventCenter.instance.publish((IEvent)localObject);
    this.dOZ = ((kb)localObject).dOY.dOZ;
    setMMTitle(2131756685);
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
    findViewById(2131297420);
    findViewById(2131297419);
    addTextOptionMenu(0, getString(2131755858), this.kdI);
    AppMethodBeat.o(110216);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110212);
    super.onCreate(paramBundle);
    g.azz().a(144, this);
    AppMethodBeat.o(110212);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110213);
    super.onDestroy();
    g.azz().b(144, this);
    AppMethodBeat.o(110213);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110214);
    super.onResume();
    initView();
    AppMethodBeat.o(110214);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(110217);
    Log.i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    b localb = (b)paramq;
    byte[] arrayOfByte = g.aAf().azh().Ai(localb.jkB);
    Log.i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", new Object[] { Integer.valueOf(Util.nullAs(arrayOfByte, new byte[0]).length), Long.valueOf(localb.jkB) });
    if (Util.isNullOrNil(arrayOfByte)) {
      arrayOfByte = z.a(((mk)localb.rr.iLL.iLR).KHp);
    }
    for (;;)
    {
      this.iKr = arrayOfByte;
      this.kdG = ((mk)((b)paramq).rr.iLL.iLR).KQw;
      if (this.iKr != null) {
        Log.d("MicroMsg.VerifyQQUI", "imgSid:" + this.kdG + " img len" + this.iKr.length + " " + f.apq());
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.account.a.a.jRu.WZ();
        h.a(getContext(), 2131756680, 2131756681, new DialogInterface.OnClickListener()
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
          paramString = com.tencent.mm.h.a.Dk(paramString);
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
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if (paramString != null)
        {
          paramString.a(this, null, null);
          i = 1;
        }
        else
        {
          h.n(getContext(), 2131756682, 2131756677);
          i = 1;
          continue;
          h.n(getContext(), 2131756673, 2131756677);
          i = 1;
          continue;
          h.n(getContext(), 2131756676, 2131755998);
          i = 1;
          continue;
          h.n(getContext(), 2131756674, 2131755998);
          i = 1;
          continue;
          if (this.iKr != null) {
            Log.d("MicroMsg.VerifyQQUI", "imgSid:" + this.kdG + " img len" + this.iKr.length + " " + f.apq());
          }
          if (!g.aAc())
          {
            i = 1;
          }
          else
          {
            if (this.kdp == null) {
              this.kdp = SecurityImage.a.a(getContext(), 0, this.iKr, this.kdG, this.kdH, new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(110205);
                  paramAnonymousDialogInterface = new b(VerifyQQUI.c(VerifyQQUI.this), VerifyQQUI.d(VerifyQQUI.this), VerifyQQUI.e(VerifyQQUI.this).getSecImgSid(), VerifyQQUI.e(VerifyQQUI.this).getSecImgCode(), VerifyQQUI.e(VerifyQQUI.this).getSecImgEncryptKey(), VerifyQQUI.f(VerifyQQUI.this), VerifyQQUI.g(VerifyQQUI.this), true);
                  g.azz().a(paramAnonymousDialogInterface, 0);
                  VerifyQQUI localVerifyQQUI = VerifyQQUI.this;
                  AppCompatActivity localAppCompatActivity = VerifyQQUI.this.getContext();
                  VerifyQQUI.this.getString(2131756681);
                  VerifyQQUI.a(localVerifyQQUI, h.a(localAppCompatActivity, VerifyQQUI.this.getString(2131756672), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(110204);
                      g.azz().a(paramAnonymousDialogInterface);
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
              if (this.iKr != null) {
                Log.d("MicroMsg.VerifyQQUI", "imgSid:" + this.kdG + " img len" + this.iKr.length + " " + f.apq());
              }
              this.kdp.b(0, this.iKr, this.kdG, this.kdH);
            }
            h.n(getContext(), 2131756675, 2131755998);
            i = 1;
            continue;
            i = 0;
          }
        }
      }
      Toast.makeText(this, getString(2131760805, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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
    
    public final void bnH()
    {
      AppMethodBeat.i(110207);
      b localb = new b(VerifyQQUI.c(VerifyQQUI.this), VerifyQQUI.d(VerifyQQUI.this), VerifyQQUI.i(VerifyQQUI.this), "", VerifyQQUI.j(VerifyQQUI.this), 2, true);
      g.azz().a(localb, 0);
      AppMethodBeat.o(110207);
    }
  }
  
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    WeakReference<VerifyQQUI> cMO;
    
    protected b(VerifyQQUI paramVerifyQQUI)
    {
      AppMethodBeat.i(110209);
      this.cMO = new WeakReference(paramVerifyQQUI);
      AppMethodBeat.o(110209);
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(110210);
      paramMenuItem = (VerifyQQUI)this.cMO.get();
      if ((paramMenuItem == null) || (paramMenuItem.isFinishing()))
      {
        AppMethodBeat.o(110210);
        return true;
      }
      Object localObject = (EditText)paramMenuItem.findViewById(2131297420);
      EditText localEditText = (EditText)paramMenuItem.findViewById(2131297419);
      localObject = ((EditText)localObject).getText().toString().trim();
      VerifyQQUI.a(paramMenuItem, localEditText.getText().toString().trim());
      try
      {
        VerifyQQUI.a(paramMenuItem, Util.getLong((String)localObject, 0L));
        if (VerifyQQUI.c(paramMenuItem) < 10000L)
        {
          h.n(paramMenuItem.getContext(), 2131756679, 2131756677);
          AppMethodBeat.o(110210);
          return true;
        }
      }
      catch (Exception localException)
      {
        h.n(paramMenuItem.getContext(), 2131756679, 2131756677);
        AppMethodBeat.o(110210);
        return true;
      }
      if (VerifyQQUI.d(paramMenuItem).equals(""))
      {
        h.n(paramMenuItem.getContext(), 2131756678, 2131756677);
        AppMethodBeat.o(110210);
        return true;
      }
      paramMenuItem.hideVKB();
      final b localb = new b(VerifyQQUI.c(paramMenuItem), VerifyQQUI.d(paramMenuItem), "", "", "", VerifyQQUI.f(paramMenuItem), VerifyQQUI.g(paramMenuItem), false);
      g.azz().a(localb, 0);
      localObject = paramMenuItem.getContext();
      paramMenuItem.getString(2131756681);
      VerifyQQUI.a(paramMenuItem, h.a((Context)localObject, paramMenuItem.getString(2131756672), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(110208);
          g.azz().a(localb);
          AppMethodBeat.o(110208);
        }
      }));
      AppMethodBeat.o(110210);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.VerifyQQUI
 * JD-Core Version:    0.7.0.1
 */