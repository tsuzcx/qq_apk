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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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

public class FindMContactInviteUI
  extends MMWizardActivity
{
  private TextView emptyTipTv;
  private ProgressDialog fMu;
  private int jaT;
  private String jaZ;
  private ListView jci;
  private boolean jfA;
  private i.a jfB;
  private String jfD;
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
  
  public FindMContactInviteUI()
  {
    AppMethodBeat.i(131212);
    this.fMu = null;
    this.emptyTipTv = null;
    this.jft = null;
    this.jfu = null;
    this.jfv = null;
    this.jfw = null;
    this.jfx = null;
    this.jfD = null;
    this.onSceneEndCallback = null;
    this.jaT = 2;
    this.jfA = true;
    this.jfB = new i.a()
    {
      public final void notifyDataSetChanged()
      {
        AppMethodBeat.i(131204);
        if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 2) && (FindMContactInviteUI.d(FindMContactInviteUI.this) == 1))
        {
          FindMContactInviteUI.e(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getString(2131759120));
          if (!FindMContactInviteUI.b(FindMContactInviteUI.this).aSK()) {
            break label240;
          }
          if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 1) && (FindMContactInviteUI.e(FindMContactInviteUI.this).getVisibility() == 0) && (FindMContactInviteUI.f(FindMContactInviteUI.this) != null))
          {
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(8);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(0);
          }
        }
        for (;;)
        {
          if ((FindMContactInviteUI.b(FindMContactInviteUI.this).getSelectCount() <= 0) || (FindMContactInviteUI.d(FindMContactInviteUI.this) == 1)) {
            break label302;
          }
          FindMContactInviteUI.g(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getResources().getQuantityString(2131623942, FindMContactInviteUI.b(FindMContactInviteUI.this).getSelectCount(), new Object[] { Integer.valueOf(FindMContactInviteUI.b(FindMContactInviteUI.this).getSelectCount()) }));
          AppMethodBeat.o(131204);
          return;
          FindMContactInviteUI.e(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getString(2131759119, new Object[] { Integer.valueOf(FindMContactInviteUI.b(FindMContactInviteUI.this).getCount()) }));
          break;
          label240:
          if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 1) && (FindMContactInviteUI.e(FindMContactInviteUI.this).getVisibility() == 8) && (FindMContactInviteUI.f(FindMContactInviteUI.this) != null))
          {
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(0);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(8);
          }
        }
        label302:
        FindMContactInviteUI.g(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getResources().getQuantityString(2131623943, FindMContactInviteUI.b(FindMContactInviteUI.this).getCount(), new Object[] { Integer.valueOf(FindMContactInviteUI.b(FindMContactInviteUI.this).getCount()) }));
        AppMethodBeat.o(131204);
      }
    };
    AppMethodBeat.o(131212);
  }
  
  private void aSa()
  {
    AppMethodBeat.i(131215);
    com.tencent.mm.plugin.b.a.Ma(this.jaZ);
    hideVKB();
    abK(1);
    AppMethodBeat.o(131215);
  }
  
  private void aTw()
  {
    AppMethodBeat.i(131217);
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
        AppMethodBeat.i(131202);
        try
        {
          FindMContactInviteUI.a(FindMContactInviteUI.this, com.tencent.mm.pluginsdk.b.dr(FindMContactInviteUI.this));
          FindMContactInviteUI.b(FindMContactInviteUI.this).jaX = FindMContactInviteUI.c(FindMContactInviteUI.this);
          FindMContactInviteUI.b(FindMContactInviteUI.this).s(((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
          AppMethodBeat.o(131202);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.FindMContactInviteUI", localException, "", new Object[0]);
          }
        }
      }
      
      public final boolean aEn()
      {
        AppMethodBeat.i(131201);
        if (FindMContactInviteUI.a(FindMContactInviteUI.this) != null)
        {
          FindMContactInviteUI.a(FindMContactInviteUI.this).dismiss();
          FindMContactInviteUI.a(FindMContactInviteUI.this, null);
        }
        FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
        AppMethodBeat.o(131201);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(131203);
        String str = super.toString() + "|listMFriendData";
        AppMethodBeat.o(131203);
        return str;
      }
    });
    AppMethodBeat.o(131217);
  }
  
  public int getLayoutId()
  {
    return 2131494008;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131220);
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
      this.jfu.setText(getString(2131759121));
      this.jfv.setText(getString(2131759121));
      this.jfx.setText(getString(2131759120));
    }
    for (;;)
    {
      this.jfr = new i(this, this.jfB, 2);
      this.jfx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131205);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new StringBuilder();
          g.ajA();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.a.aiO()).append(",").append(FindMContactInviteUI.this.getClass().getName()).append(",R300_400_AddAllButton,");
          g.ajA();
          com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R300_300_AddAllButton") + ",3");
          if (FindMContactInviteUI.d(FindMContactInviteUI.this) == 2)
          {
            FindMContactInviteUI.b(FindMContactInviteUI.this).fq(true);
            FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(8);
            if (FindMContactInviteUI.f(FindMContactInviteUI.this) != null) {
              FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(0);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131205);
            return;
            if (FindMContactInviteUI.d(FindMContactInviteUI.this) == 1)
            {
              FindMContactInviteUI.b(FindMContactInviteUI.this).fq(true);
              FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
              FindMContactInviteUI.h(FindMContactInviteUI.this);
            }
            else
            {
              FindMContactInviteUI.b(FindMContactInviteUI.this).fq(true);
              FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
              FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(8);
              if (FindMContactInviteUI.f(FindMContactInviteUI.this) != null) {
                FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(0);
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
            AppMethodBeat.i(131206);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(0);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(8);
            FindMContactInviteUI.b(FindMContactInviteUI.this).fq(false);
            FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131206);
          }
        });
        this.jfw.setVisibility(8);
      }
      this.jci.addHeaderView(this.jfs);
      this.jci.setAdapter(this.jfr);
      this.jci.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      this.jci.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(131207);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if (FindMContactInviteUI.b(FindMContactInviteUI.this) != null)
          {
            paramAnonymousView = FindMContactInviteUI.b(FindMContactInviteUI.this);
            if (paramAnonymousView.jdB != null) {
              paramAnonymousView.jdB.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(131207);
          return false;
        }
      });
      addTextOptionMenu(0, getString(2131755779), new FindMContactInviteUI.10(this));
      setToTop(new FindMContactInviteUI.11(this));
      AppMethodBeat.o(131220);
      return;
      this.jfs = LayoutInflater.from(this).inflate(2131494009, null);
      this.jft = ((TextView)this.jfs.findViewById(2131300082));
      this.jfu = ((TextView)this.jfs.findViewById(2131300085));
      this.jfv = ((TextView)this.jfs.findViewById(2131299970));
      this.jfx = ((Button)this.jfs.findViewById(2131299969));
      this.jfu.setText(getString(2131759124));
      this.jfv.setText(getString(2131759121));
      this.jfx.setText(getString(2131759119, new Object[] { Integer.valueOf(0) }));
      this.jfw = ((TextView)this.jfs.findViewById(2131302345));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131213);
    super.onCreate(paramBundle);
    setMMTitle(2131759123);
    com.tencent.mm.plugin.account.a.a.iRH.MU();
    this.jfD = getIntent().getStringExtra("regsetinfo_ticket");
    this.jfy = getIntent().getIntExtra("login_type", 0);
    this.jaT = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.jaZ = com.tencent.mm.plugin.b.a.Mp();
    initView();
    AppMethodBeat.o(131213);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131219);
    if (this.onSceneEndCallback != null)
    {
      g.aiU().b(432, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    if (this.jfr != null)
    {
      i locali = this.jfr;
      if (locali.jdB != null)
      {
        locali.jdB.detach();
        locali.jdB = null;
      }
    }
    ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).clearFriendData();
    super.onDestroy();
    AppMethodBeat.o(131219);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(131214);
    if (paramInt == 4)
    {
      aSa();
      AppMethodBeat.o(131214);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(131214);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(131218);
    super.onPause();
    if (this.jfy == 1)
    {
      localStringBuilder = new StringBuilder();
      g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      g.ajA();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R300_400_QQ") + ",2");
      AppMethodBeat.o(131218);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R300_400_phone,");
    g.ajA();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R300_400_phone") + ",2");
    AppMethodBeat.o(131218);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131221);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(131221);
      return;
    }
    ad.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131221);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aTw();
        AppMethodBeat.o(131221);
        return;
      }
      this.jfA = false;
      h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131755691), false, new FindMContactInviteUI.3(this), new FindMContactInviteUI.4(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131216);
    super.onResume();
    this.jfr.notifyDataSetChanged();
    StringBuilder localStringBuilder;
    if (this.jfy == 1)
    {
      localStringBuilder = new StringBuilder();
      g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      g.ajA();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("R300_400_QQ") + ",1");
    }
    while (this.jfA)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
      ad.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.flS() });
      if (!bool)
      {
        AppMethodBeat.o(131216);
        return;
        localStringBuilder = new StringBuilder();
        g.ajA();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R300_400_phone,");
        g.ajA();
        com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("R300_400_phone") + ",1");
      }
      else
      {
        aTw();
      }
    }
    AppMethodBeat.o(131216);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI
 * JD-Core Version:    0.7.0.1
 */