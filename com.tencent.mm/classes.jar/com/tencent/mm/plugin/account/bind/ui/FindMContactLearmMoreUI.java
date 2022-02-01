package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactLearmMoreUI
  extends MMWizardActivity
{
  private String dzn;
  private ProgressDialog fMu = null;
  private String fPq = null;
  private String jaS = "";
  private int jaT = 2;
  private List<String[]> jaX = null;
  private aj jaY;
  private Button jbp;
  private TextView jbq;
  private f onSceneEndCallback = null;
  
  private void aSa()
  {
    AppMethodBeat.i(110062);
    hideVKB();
    abK(1);
    AppMethodBeat.o(110062);
  }
  
  private void aSg()
  {
    AppMethodBeat.i(110060);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ad.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.flS() });
    if (!bool)
    {
      AppMethodBeat.o(110060);
      return;
    }
    Object localObject = g.aiU();
    f local3 = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(110048);
        if (FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this) != null)
        {
          FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this).dismiss();
          FindMContactLearmMoreUI.d(FindMContactLearmMoreUI.this);
        }
        if (FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this) != null)
        {
          g.aiU().b(431, FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this));
          FindMContactLearmMoreUI.f(FindMContactLearmMoreUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((aj)paramAnonymousn).aTg();
          ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label392;
          }
          paramAnonymousn = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousn.hasNext())
          {
            buj localbuj = (buj)paramAnonymousn.next();
            if (localbuj != null)
            {
              if (localbuj.nDG != 1) {
                break label389;
              }
              paramAnonymousInt1 += 1;
            }
          }
          if (paramAnonymousInt1 > 0) {
            paramAnonymousInt2 = 1;
          }
        }
        for (;;)
        {
          if (paramAnonymousString == null) {}
          for (int i = 0;; i = paramAnonymousString.size())
          {
            ad.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this) == null) || (!FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label325;
            }
            com.tencent.mm.plugin.b.a.Ma("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactLearmMoreUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactLearmMoreUI.h(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactLearmMoreUI.i(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.al(FindMContactLearmMoreUI.this, paramAnonymousString);
            AppMethodBeat.o(110048);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label325:
          FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
          AppMethodBeat.o(110048);
          return;
          Toast.makeText(FindMContactLearmMoreUI.this, FindMContactLearmMoreUI.this.getString(2131755733, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
          FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
          AppMethodBeat.o(110048);
          return;
          label389:
          break;
          label392:
          paramAnonymousInt2 = 0;
          paramAnonymousInt1 = 0;
        }
      }
    };
    this.onSceneEndCallback = local3;
    ((q)localObject).a(431, local3);
    localObject = getContext();
    getString(2131755906);
    this.fMu = h.b((Context)localObject, getString(2131755804), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110049);
        if (FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this) != null)
        {
          g.aiU().b(431, FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this));
          FindMContactLearmMoreUI.f(FindMContactLearmMoreUI.this);
        }
        AppMethodBeat.o(110049);
      }
    });
    g.ajF().a(new aq.a()
    {
      public final boolean aEm()
      {
        AppMethodBeat.i(110051);
        for (;;)
        {
          try
          {
            FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this, com.tencent.mm.pluginsdk.b.dr(FindMContactLearmMoreUI.this));
            StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
            if (FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this) != null) {
              continue;
            }
            i = 0;
            ad.d("MicroMsg.FindMContactLearmMoreUI", i);
          }
          catch (Exception localException)
          {
            int i;
            ad.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", localException, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(110051);
          return true;
          i = FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this).size();
        }
      }
      
      public final boolean aEn()
      {
        AppMethodBeat.i(110050);
        if ((FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this) != null) && (FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this).size() != 0))
        {
          FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this, new aj(FindMContactLearmMoreUI.h(FindMContactLearmMoreUI.this), FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this)));
          g.aiU().a(FindMContactLearmMoreUI.k(FindMContactLearmMoreUI.this), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(110050);
          return false;
          if (FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this) != null)
          {
            FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this).dismiss();
            FindMContactLearmMoreUI.d(FindMContactLearmMoreUI.this);
          }
          FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(110052);
        String str = super.toString() + "|doUpload";
        AppMethodBeat.o(110052);
        return str;
      }
    });
    ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
    ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
    AppMethodBeat.o(110060);
  }
  
  public int getLayoutId()
  {
    return 2131494130;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110059);
    setMMTitle(2131759142);
    this.jbp = ((Button)findViewById(2131302999));
    this.jbq = ((TextView)findViewById(2131297690));
    this.jbp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110046);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        l.fr(true);
        ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
        FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110046);
      }
    });
    this.jbq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110047);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        l.fr(false);
        ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
        FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110047);
      }
    });
    g.ajC().ajl().set(12323, Boolean.TRUE);
    this.dzn = ((String)g.ajC().ajl().get(6, null));
    if ((this.dzn == null) || (this.dzn.equals(""))) {
      this.dzn = ((String)g.ajC().ajl().get(4097, null));
    }
    AppMethodBeat.o(110059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110055);
    super.onCreate(paramBundle);
    this.fPq = getIntent().getStringExtra("regsetinfo_ticket");
    this.jaS = getIntent().getStringExtra("regsetinfo_NextStep");
    this.jaT = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    initView();
    AppMethodBeat.o(110055);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110056);
    if (this.onSceneEndCallback != null)
    {
      g.aiU().b(431, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    super.onDestroy();
    AppMethodBeat.o(110056);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(110061);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aSa();
      AppMethodBeat.o(110061);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(110061);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(110058);
    super.onPause();
    StringBuilder localStringBuilder = new StringBuilder();
    g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",RE300_600,");
    g.ajA();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("RE300_600") + ",2");
    AppMethodBeat.o(110058);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110063);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(110063);
      return;
    }
    ad.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110063);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aSg();
        AppMethodBeat.o(110063);
        return;
      }
      h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110053);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = FindMContactLearmMoreUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(110053);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110054);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(110054);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110057);
    super.onResume();
    com.tencent.mm.plugin.b.a.Kc("R300_100_phone");
    StringBuilder localStringBuilder = new StringBuilder();
    g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",RE300_600,");
    g.ajA();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("RE300_600") + ",1");
    AppMethodBeat.o(110057);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI
 * JD-Core Version:    0.7.0.1
 */