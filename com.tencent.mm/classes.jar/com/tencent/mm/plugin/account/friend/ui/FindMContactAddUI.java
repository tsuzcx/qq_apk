package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.plugin.account.friend.a.i.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class FindMContactAddUI
  extends MMWizardActivity
{
  private TextView emptyTipTv;
  private ProgressDialog fOC;
  private String fRw;
  private String jdL;
  private int jdM;
  private String jdS;
  private ListView jfb;
  private i jik;
  private View jil;
  private TextView jim;
  private TextView jin;
  private TextView jio;
  private TextView jip;
  private Button jiq;
  private int jir;
  private List<String[]> jis;
  private boolean jit;
  private i.a jiu;
  private f onSceneEndCallback;
  
  public FindMContactAddUI()
  {
    AppMethodBeat.i(131187);
    this.fOC = null;
    this.emptyTipTv = null;
    this.jim = null;
    this.jin = null;
    this.jio = null;
    this.jip = null;
    this.jiq = null;
    this.fRw = null;
    this.onSceneEndCallback = null;
    this.jdL = "";
    this.jdM = 2;
    this.jit = true;
    this.jiu = new i.a()
    {
      public final void notifyDataSetChanged()
      {
        AppMethodBeat.i(131181);
        if ((FindMContactAddUI.e(FindMContactAddUI.this) != 2) && (FindMContactAddUI.e(FindMContactAddUI.this) == 1))
        {
          FindMContactAddUI.f(FindMContactAddUI.this).setText(FindMContactAddUI.this.getString(2131759111));
          if (!FindMContactAddUI.c(FindMContactAddUI.this).aTj()) {
            break label240;
          }
          if ((FindMContactAddUI.e(FindMContactAddUI.this) != 1) && (FindMContactAddUI.f(FindMContactAddUI.this).getVisibility() == 0) && (FindMContactAddUI.g(FindMContactAddUI.this) != null))
          {
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(8);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(0);
          }
        }
        for (;;)
        {
          if ((FindMContactAddUI.c(FindMContactAddUI.this).getSelectCount() <= 0) || (FindMContactAddUI.e(FindMContactAddUI.this) == 1)) {
            break label302;
          }
          FindMContactAddUI.h(FindMContactAddUI.this).setText(FindMContactAddUI.this.getResources().getQuantityString(2131623941, FindMContactAddUI.c(FindMContactAddUI.this).getSelectCount(), new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getSelectCount()) }));
          AppMethodBeat.o(131181);
          return;
          FindMContactAddUI.f(FindMContactAddUI.this).setText(FindMContactAddUI.this.getString(2131759110, new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getCount()) }));
          break;
          label240:
          if ((FindMContactAddUI.e(FindMContactAddUI.this) != 1) && (FindMContactAddUI.f(FindMContactAddUI.this).getVisibility() == 8) && (FindMContactAddUI.g(FindMContactAddUI.this) != null))
          {
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(0);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(8);
          }
        }
        label302:
        FindMContactAddUI.h(FindMContactAddUI.this).setText(FindMContactAddUI.this.getResources().getQuantityString(2131623944, FindMContactAddUI.c(FindMContactAddUI.this).getCount(), new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getCount()) }));
        AppMethodBeat.o(131181);
      }
    };
    AppMethodBeat.o(131187);
  }
  
  private void aSz()
  {
    AppMethodBeat.i(131191);
    com.tencent.mm.plugin.b.a.KB(this.jdS);
    hideVKB();
    acs(1);
    AppMethodBeat.o(131191);
  }
  
  private void aTV()
  {
    AppMethodBeat.i(131189);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.fOC = h.b(localAppCompatActivity, getString(2131761251), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    g.ajU().a(new ar.a()
    {
      public final boolean aEC()
      {
        AppMethodBeat.i(131179);
        try
        {
          FindMContactAddUI.a(FindMContactAddUI.this, com.tencent.mm.pluginsdk.b.dt(FindMContactAddUI.this));
          FindMContactAddUI.c(FindMContactAddUI.this).jdQ = FindMContactAddUI.d(FindMContactAddUI.this);
          FindMContactAddUI.c(FindMContactAddUI.this).s(((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
          AppMethodBeat.o(131179);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.FindMContactAddUI", localException, "", new Object[0]);
          }
        }
      }
      
      public final boolean aED()
      {
        AppMethodBeat.i(131178);
        if (FindMContactAddUI.a(FindMContactAddUI.this) != null)
        {
          FindMContactAddUI.a(FindMContactAddUI.this).dismiss();
          FindMContactAddUI.b(FindMContactAddUI.this);
        }
        FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
        AppMethodBeat.o(131178);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(131180);
        String str = super.toString() + "|listMFriendData";
        AppMethodBeat.o(131180);
        return str;
      }
    });
    AppMethodBeat.o(131189);
  }
  
  public int getLayoutId()
  {
    return 2131494008;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131195);
    this.emptyTipTv = ((TextView)findViewById(2131302350));
    this.emptyTipTv.setText(2131761249);
    this.jfb = ((ListView)findViewById(2131302352));
    if ((this.jdM != 2) && (this.jdM == 1))
    {
      this.jil = LayoutInflater.from(this).inflate(2131494010, null);
      this.jim = ((TextView)this.jil.findViewById(2131300082));
      this.jin = ((TextView)this.jil.findViewById(2131300085));
      this.jio = ((TextView)this.jil.findViewById(2131299970));
      this.jiq = ((Button)this.jil.findViewById(2131299969));
      this.jin.setText(getString(2131759143));
      this.jio.setText(getString(2131759144));
      this.jiq.setText(getString(2131759111));
    }
    for (;;)
    {
      this.jik = new i(this, this.jiu, 1);
      this.jiq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131182);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new StringBuilder();
          g.ajP();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.a.ajd()).append(",").append(FindMContactAddUI.this.getClass().getName()).append(",R300_300_AddAllButton,");
          g.ajP();
          com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R300_300_AddAllButton") + ",3");
          if (FindMContactAddUI.e(FindMContactAddUI.this) == 2)
          {
            FindMContactAddUI.c(FindMContactAddUI.this).fr(true);
            FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(8);
            if (FindMContactAddUI.g(FindMContactAddUI.this) != null) {
              FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(0);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131182);
            return;
            if (FindMContactAddUI.e(FindMContactAddUI.this) == 1)
            {
              FindMContactAddUI.c(FindMContactAddUI.this).fr(true);
              FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
              FindMContactAddUI.i(FindMContactAddUI.this);
            }
            else
            {
              FindMContactAddUI.c(FindMContactAddUI.this).fr(true);
              FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
              FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(8);
              if (FindMContactAddUI.g(FindMContactAddUI.this) != null) {
                FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(0);
              }
            }
          }
        }
      });
      if (this.jip != null)
      {
        this.jip.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131183);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(0);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(8);
            FindMContactAddUI.c(FindMContactAddUI.this).fr(false);
            FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131183);
          }
        });
        this.jip.setVisibility(8);
      }
      this.jfb.addHeaderView(this.jil);
      this.jfb.setAdapter(this.jik);
      addTextOptionMenu(0, getString(2131755830), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(131184);
          FindMContactAddUI.i(FindMContactAddUI.this);
          AppMethodBeat.o(131184);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131185);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = FindMContactAddUI.j(FindMContactAddUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$7", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$7", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131185);
        }
      });
      AppMethodBeat.o(131195);
      return;
      this.jil = LayoutInflater.from(this).inflate(2131494009, null);
      this.jim = ((TextView)this.jil.findViewById(2131300082));
      this.jin = ((TextView)this.jil.findViewById(2131300085));
      this.jio = ((TextView)this.jil.findViewById(2131299970));
      this.jiq = ((Button)this.jil.findViewById(2131299969));
      this.jin.setText(getString(2131759143));
      this.jio.setText(getString(2131759144));
      this.jiq.setText(getString(2131759110, new Object[] { Integer.valueOf(0) }));
      this.jip = ((TextView)this.jil.findViewById(2131302345));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131188);
    super.onCreate(paramBundle);
    setMMTitle(2131759115);
    com.tencent.mm.plugin.account.a.a.iUA.MP();
    this.fRw = getIntent().getStringExtra("regsetinfo_ticket");
    this.jdL = getIntent().getStringExtra("regsetinfo_NextStep");
    this.jdM = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.jir = getIntent().getIntExtra("login_type", 0);
    this.jdS = com.tencent.mm.plugin.b.a.aVo();
    initView();
    AppMethodBeat.o(131188);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131194);
    if (this.onSceneEndCallback != null)
    {
      g.ajj().b(30, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    super.onDestroy();
    AppMethodBeat.o(131194);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(131190);
    if (paramInt == 4)
    {
      aSz();
      AppMethodBeat.o(131190);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(131190);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(131193);
    super.onPause();
    if (this.jir == 1)
    {
      localStringBuilder = new StringBuilder();
      g.ajP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
      g.ajP();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R300_300_QQ") + ",2");
      AppMethodBeat.o(131193);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R300_300_phone,");
    g.ajP();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R300_300_phone") + ",2");
    AppMethodBeat.o(131193);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131196);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(131196);
      return;
    }
    ae.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131196);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aTV();
        AppMethodBeat.o(131196);
        return;
      }
      this.jit = false;
      h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(131176);
          paramAnonymousDialogInterface = FindMContactAddUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          FindMContactAddUI.q(FindMContactAddUI.this);
          FindMContactAddUI.this.finish();
          AppMethodBeat.o(131176);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(131177);
          FindMContactAddUI.q(FindMContactAddUI.this);
          FindMContactAddUI.this.finish();
          AppMethodBeat.o(131177);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131192);
    super.onResume();
    this.jik.notifyDataSetChanged();
    StringBuilder localStringBuilder;
    if (this.jir == 1)
    {
      localStringBuilder = new StringBuilder();
      g.ajP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
      g.ajP();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("R300_300_QQ") + ",1");
      com.tencent.mm.plugin.b.a.KA("R300_300_QQ");
    }
    while (this.jit)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
      ae.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN() });
      if (!bool)
      {
        AppMethodBeat.o(131192);
        return;
        localStringBuilder = new StringBuilder();
        g.ajP();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R300_300_phone,");
        g.ajP();
        com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("R300_300_phone") + ",1");
        com.tencent.mm.plugin.b.a.KA("R300_300_phone");
      }
      else
      {
        aTV();
      }
    }
    AppMethodBeat.o(131192);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI
 * JD-Core Version:    0.7.0.1
 */