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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactIntroUI
  extends MMWizardActivity
{
  private String dAs;
  private ProgressDialog fOC = null;
  private String fRw = null;
  private String jdL = "";
  private int jdM = 2;
  private boolean jdP = false;
  private List<String[]> jdQ = null;
  private com.tencent.mm.plugin.account.friend.a.aj jdR;
  private String jdS;
  private Button jed;
  private TextView jee;
  private TextView jef;
  private f onSceneEndCallback = null;
  
  private void aSF()
  {
    AppMethodBeat.i(110039);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ae.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN() });
    if (!bool)
    {
      AppMethodBeat.o(110039);
      return;
    }
    Object localObject = g.ajj();
    f local9 = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(110029);
        if (FindMContactIntroUI.g(FindMContactIntroUI.this) != null)
        {
          FindMContactIntroUI.g(FindMContactIntroUI.this).dismiss();
          FindMContactIntroUI.h(FindMContactIntroUI.this);
        }
        if (FindMContactIntroUI.i(FindMContactIntroUI.this) != null)
        {
          g.ajj().b(431, FindMContactIntroUI.i(FindMContactIntroUI.this));
          FindMContactIntroUI.j(FindMContactIntroUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((com.tencent.mm.plugin.account.friend.a.aj)paramAnonymousn).aTF();
          ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label385;
          }
          paramAnonymousn = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousn.hasNext())
          {
            bvd localbvd = (bvd)paramAnonymousn.next();
            if (localbvd != null)
            {
              if (localbvd.nJb != 1) {
                break label382;
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
            ae.d("MicroMsg.FindMContactIntroUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactIntroUI.d(FindMContactIntroUI.this) == null) || (!FindMContactIntroUI.d(FindMContactIntroUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label325;
            }
            com.tencent.mm.plugin.b.a.KB("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactIntroUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactIntroUI.c(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactIntroUI.d(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.e(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.al(FindMContactIntroUI.this, paramAnonymousString);
            AppMethodBeat.o(110029);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label325:
          FindMContactIntroUI.b(FindMContactIntroUI.this);
          AppMethodBeat.o(110029);
          return;
          Toast.makeText(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(2131755733, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
          AppMethodBeat.o(110029);
          return;
          label382:
          break;
          label385:
          paramAnonymousInt2 = 0;
          paramAnonymousInt1 = 0;
        }
      }
    };
    this.onSceneEndCallback = local9;
    ((q)localObject).a(431, local9);
    localObject = getContext();
    getString(2131755906);
    this.fOC = h.b((Context)localObject, getString(2131755804), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110030);
        if (FindMContactIntroUI.i(FindMContactIntroUI.this) != null)
        {
          g.ajj().b(431, FindMContactIntroUI.i(FindMContactIntroUI.this));
          FindMContactIntroUI.j(FindMContactIntroUI.this);
        }
        AppMethodBeat.o(110030);
      }
    });
    g.ajU().a(new ar.a()
    {
      public final boolean aEC()
      {
        AppMethodBeat.i(110032);
        for (;;)
        {
          try
          {
            FindMContactIntroUI.a(FindMContactIntroUI.this, com.tencent.mm.pluginsdk.b.dt(FindMContactIntroUI.this));
            StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
            if (FindMContactIntroUI.k(FindMContactIntroUI.this) != null) {
              continue;
            }
            i = 0;
            ae.d("MicroMsg.FindMContactIntroUI", i);
          }
          catch (Exception localException)
          {
            int i;
            ae.printErrStackTrace("MicroMsg.FindMContactIntroUI", localException, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(110032);
          return true;
          i = FindMContactIntroUI.k(FindMContactIntroUI.this).size();
        }
      }
      
      public final boolean aED()
      {
        AppMethodBeat.i(110031);
        if ((FindMContactIntroUI.k(FindMContactIntroUI.this) != null) && (FindMContactIntroUI.k(FindMContactIntroUI.this).size() != 0))
        {
          FindMContactIntroUI.a(FindMContactIntroUI.this, new com.tencent.mm.plugin.account.friend.a.aj(FindMContactIntroUI.c(FindMContactIntroUI.this), FindMContactIntroUI.k(FindMContactIntroUI.this)));
          g.ajj().a(FindMContactIntroUI.l(FindMContactIntroUI.this), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(110031);
          return false;
          if (FindMContactIntroUI.g(FindMContactIntroUI.this) != null)
          {
            FindMContactIntroUI.g(FindMContactIntroUI.this).dismiss();
            FindMContactIntroUI.h(FindMContactIntroUI.this);
          }
          FindMContactIntroUI.b(FindMContactIntroUI.this);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(110033);
        String str = super.toString() + "|doUpload";
        AppMethodBeat.o(110033);
        return str;
      }
    });
    AppMethodBeat.o(110039);
  }
  
  private void aSz()
  {
    AppMethodBeat.i(110041);
    com.tencent.mm.plugin.b.a.KB(this.jdS);
    hideVKB();
    acs(1);
    AppMethodBeat.o(110041);
  }
  
  public int getLayoutId()
  {
    return 2131494129;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110038);
    this.jed = ((Button)findViewById(2131304623));
    this.jef = ((TextView)findViewById(2131300084));
    this.jee = ((TextView)findViewById(2131300083));
    if ((this.jdL != null) && (this.jdL.contains("2"))) {
      this.jee.setText(getString(2131759113));
    }
    for (;;)
    {
      this.dAs = ((String)g.ajR().ajA().get(6, null));
      if ((this.dAs == null) || (this.dAs.equals(""))) {
        this.dAs = ((String)g.ajR().ajA().get(4097, null));
      }
      this.jed.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110020);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          FindMContactIntroUI.a(FindMContactIntroUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110020);
        }
      });
      this.jef.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110024);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          h.e(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(2131759130), null, FindMContactIntroUI.this.getString(2131759131), FindMContactIntroUI.this.getString(2131759129), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110023);
              FindMContactIntroUI.b(FindMContactIntroUI.this);
              AppMethodBeat.o(110023);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110024);
        }
      });
      AppMethodBeat.o(110038);
      return;
      this.jee.setText(getString(2131759114));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110034);
    super.onCreate(paramBundle);
    setMMTitle(2131759133);
    com.tencent.mm.plugin.account.a.a.iUA.MP();
    this.fRw = getIntent().getStringExtra("regsetinfo_ticket");
    this.jdL = getIntent().getStringExtra("regsetinfo_NextStep");
    this.jdM = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    if (com.tencent.mm.plugin.account.friend.a.l.aTn() != l.a.jgH) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdP = bool;
      this.jdS = com.tencent.mm.plugin.b.a.aVo();
      ae.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.jdL, Integer.valueOf(this.jdM) });
      AppMethodBeat.o(110034);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110035);
    if (this.onSceneEndCallback != null)
    {
      g.ajj().b(431, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    super.onDestroy();
    AppMethodBeat.o(110035);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(110040);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aSz();
      AppMethodBeat.o(110040);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(110040);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(110037);
    super.onPause();
    com.tencent.mm.plugin.b.a.KB("RE900_100");
    if (this.jdP)
    {
      localStringBuilder = new StringBuilder();
      g.ajP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.ajP();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R300_100_QQ") + ",4");
      AppMethodBeat.o(110037);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    g.ajP();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R300_100_phone") + ",4");
    AppMethodBeat.o(110037);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110042);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(110042);
      return;
    }
    ae.i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110042);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aSF();
        AppMethodBeat.o(110042);
        return;
      }
      h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110021);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = FindMContactIntroUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(110021);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110022);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(110022);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110036);
    super.onResume();
    initView();
    if (this.jdP)
    {
      localStringBuilder = new StringBuilder();
      g.ajP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.ajP();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("R300_100_QQ") + ",1");
      com.tencent.mm.plugin.b.a.KA("R300_100_QQ");
      AppMethodBeat.o(110036);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    g.ajP();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("R300_100_phone") + ",1");
    com.tencent.mm.plugin.b.a.KA("R300_100_phone");
    AppMethodBeat.o(110036);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI
 * JD-Core Version:    0.7.0.1
 */