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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.plugin.account.friend.a.i.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class FindMContactAddUI
  extends MMWizardActivity
{
  private TextView emptyTipTv;
  private ProgressDialog fMu;
  private String fPq;
  private String jaS;
  private int jaT;
  private String jaZ;
  private ListView jci;
  private boolean jfA;
  private i.a jfB;
  private i jfr;
  private View jfs;
  private TextView jft;
  private TextView jfu;
  private TextView jfv;
  private TextView jfw;
  private Button jfx;
  private int jfy;
  private List<String[]> jfz;
  private f onSceneEndCallback;
  
  public FindMContactAddUI()
  {
    AppMethodBeat.i(131187);
    this.fMu = null;
    this.emptyTipTv = null;
    this.jft = null;
    this.jfu = null;
    this.jfv = null;
    this.jfw = null;
    this.jfx = null;
    this.fPq = null;
    this.onSceneEndCallback = null;
    this.jaS = "";
    this.jaT = 2;
    this.jfA = true;
    this.jfB = new i.a()
    {
      public final void notifyDataSetChanged()
      {
        AppMethodBeat.i(131181);
        if ((FindMContactAddUI.e(FindMContactAddUI.this) != 2) && (FindMContactAddUI.e(FindMContactAddUI.this) == 1))
        {
          FindMContactAddUI.f(FindMContactAddUI.this).setText(FindMContactAddUI.this.getString(2131759111));
          if (!FindMContactAddUI.c(FindMContactAddUI.this).aSK()) {
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
  
  private void aSa()
  {
    AppMethodBeat.i(131191);
    com.tencent.mm.plugin.b.a.Ma(this.jaZ);
    hideVKB();
    abK(1);
    AppMethodBeat.o(131191);
  }
  
  private void aTw()
  {
    AppMethodBeat.i(131189);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.fMu = h.b(localAppCompatActivity, getString(2131761251), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    g.ajF().a(new aq.a()
    {
      public final boolean aEm()
      {
        AppMethodBeat.i(131179);
        try
        {
          FindMContactAddUI.a(FindMContactAddUI.this, com.tencent.mm.pluginsdk.b.dr(FindMContactAddUI.this));
          FindMContactAddUI.c(FindMContactAddUI.this).jaX = FindMContactAddUI.d(FindMContactAddUI.this);
          FindMContactAddUI.c(FindMContactAddUI.this).s(((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
          AppMethodBeat.o(131179);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.FindMContactAddUI", localException, "", new Object[0]);
          }
        }
      }
      
      public final boolean aEn()
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
    this.jci = ((ListView)findViewById(2131302352));
    if ((this.jaT != 2) && (this.jaT == 1))
    {
      this.jfs = LayoutInflater.from(this).inflate(2131494010, null);
      this.jft = ((TextView)this.jfs.findViewById(2131300082));
      this.jfu = ((TextView)this.jfs.findViewById(2131300085));
      this.jfv = ((TextView)this.jfs.findViewById(2131299970));
      this.jfx = ((Button)this.jfs.findViewById(2131299969));
      this.jfu.setText(getString(2131759143));
      this.jfv.setText(getString(2131759144));
      this.jfx.setText(getString(2131759111));
    }
    for (;;)
    {
      this.jfr = new i(this, this.jfB, 1);
      this.jfx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131182);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new StringBuilder();
          g.ajA();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.a.aiO()).append(",").append(FindMContactAddUI.this.getClass().getName()).append(",R300_300_AddAllButton,");
          g.ajA();
          com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R300_300_AddAllButton") + ",3");
          if (FindMContactAddUI.e(FindMContactAddUI.this) == 2)
          {
            FindMContactAddUI.c(FindMContactAddUI.this).fq(true);
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
              FindMContactAddUI.c(FindMContactAddUI.this).fq(true);
              FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
              FindMContactAddUI.i(FindMContactAddUI.this);
            }
            else
            {
              FindMContactAddUI.c(FindMContactAddUI.this).fq(true);
              FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
              FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(8);
              if (FindMContactAddUI.g(FindMContactAddUI.this) != null) {
                FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(0);
              }
            }
          }
        }
      });
      if (this.jfw != null)
      {
        this.jfw.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131183);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(0);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(8);
            FindMContactAddUI.c(FindMContactAddUI.this).fq(false);
            FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131183);
          }
        });
        this.jfw.setVisibility(8);
      }
      this.jci.addHeaderView(this.jfs);
      this.jci.setAdapter(this.jfr);
      addTextOptionMenu(0, getString(2131755830), new FindMContactAddUI.10(this));
      setToTop(new FindMContactAddUI.11(this));
      AppMethodBeat.o(131195);
      return;
      this.jfs = LayoutInflater.from(this).inflate(2131494009, null);
      this.jft = ((TextView)this.jfs.findViewById(2131300082));
      this.jfu = ((TextView)this.jfs.findViewById(2131300085));
      this.jfv = ((TextView)this.jfs.findViewById(2131299970));
      this.jfx = ((Button)this.jfs.findViewById(2131299969));
      this.jfu.setText(getString(2131759143));
      this.jfv.setText(getString(2131759144));
      this.jfx.setText(getString(2131759110, new Object[] { Integer.valueOf(0) }));
      this.jfw = ((TextView)this.jfs.findViewById(2131302345));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131188);
    super.onCreate(paramBundle);
    setMMTitle(2131759115);
    com.tencent.mm.plugin.account.a.a.iRH.MU();
    this.fPq = getIntent().getStringExtra("regsetinfo_ticket");
    this.jaS = getIntent().getStringExtra("regsetinfo_NextStep");
    this.jaT = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.jfy = getIntent().getIntExtra("login_type", 0);
    this.jaZ = com.tencent.mm.plugin.b.a.Mp();
    initView();
    AppMethodBeat.o(131188);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131194);
    if (this.onSceneEndCallback != null)
    {
      g.aiU().b(30, this.onSceneEndCallback);
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
      aSa();
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
    if (this.jfy == 1)
    {
      localStringBuilder = new StringBuilder();
      g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
      g.ajA();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R300_300_QQ") + ",2");
      AppMethodBeat.o(131193);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R300_300_phone,");
    g.ajA();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R300_300_phone") + ",2");
    AppMethodBeat.o(131193);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131196);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(131196);
      return;
    }
    ad.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131196);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aTw();
        AppMethodBeat.o(131196);
        return;
      }
      this.jfA = false;
      h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131755691), false, new FindMContactAddUI.4(this), new FindMContactAddUI.5(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131192);
    super.onResume();
    this.jfr.notifyDataSetChanged();
    StringBuilder localStringBuilder;
    if (this.jfy == 1)
    {
      localStringBuilder = new StringBuilder();
      g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
      g.ajA();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("R300_300_QQ") + ",1");
      com.tencent.mm.plugin.b.a.Kc("R300_300_QQ");
    }
    while (this.jfA)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
      ad.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.flS() });
      if (!bool)
      {
        AppMethodBeat.o(131192);
        return;
        localStringBuilder = new StringBuilder();
        g.ajA();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R300_300_phone,");
        g.ajA();
        com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("R300_300_phone") + ",1");
        com.tencent.mm.plugin.b.a.Kc("R300_300_phone");
      }
      else
      {
        aTw();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI
 * JD-Core Version:    0.7.0.1
 */