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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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

public class FindMContactInviteUI
  extends MMWizardActivity
{
  private TextView emptyTipTv;
  private ProgressDialog fOC;
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
  private String jiw;
  private f onSceneEndCallback;
  
  public FindMContactInviteUI()
  {
    AppMethodBeat.i(131212);
    this.fOC = null;
    this.emptyTipTv = null;
    this.jim = null;
    this.jin = null;
    this.jio = null;
    this.jip = null;
    this.jiq = null;
    this.jiw = null;
    this.onSceneEndCallback = null;
    this.jdM = 2;
    this.jit = true;
    this.jiu = new i.a()
    {
      public final void notifyDataSetChanged()
      {
        AppMethodBeat.i(131204);
        if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 2) && (FindMContactInviteUI.d(FindMContactInviteUI.this) == 1))
        {
          FindMContactInviteUI.e(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getString(2131759120));
          if (!FindMContactInviteUI.b(FindMContactInviteUI.this).aTj()) {
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
  
  private void aSz()
  {
    AppMethodBeat.i(131215);
    com.tencent.mm.plugin.b.a.KB(this.jdS);
    hideVKB();
    acs(1);
    AppMethodBeat.o(131215);
  }
  
  private void aTV()
  {
    AppMethodBeat.i(131217);
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
        AppMethodBeat.i(131202);
        try
        {
          FindMContactInviteUI.a(FindMContactInviteUI.this, com.tencent.mm.pluginsdk.b.dt(FindMContactInviteUI.this));
          FindMContactInviteUI.b(FindMContactInviteUI.this).jdQ = FindMContactInviteUI.c(FindMContactInviteUI.this);
          FindMContactInviteUI.b(FindMContactInviteUI.this).s(((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
          AppMethodBeat.o(131202);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.FindMContactInviteUI", localException, "", new Object[0]);
          }
        }
      }
      
      public final boolean aED()
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
    this.jfb = ((ListView)findViewById(2131302352));
    if ((this.jdM != 2) && (this.jdM == 1))
    {
      this.jil = LayoutInflater.from(this).inflate(2131494010, null);
      this.jim = ((TextView)this.jil.findViewById(2131300082));
      this.jin = ((TextView)this.jil.findViewById(2131300085));
      this.jio = ((TextView)this.jil.findViewById(2131299970));
      this.jiq = ((Button)this.jil.findViewById(2131299969));
      this.jin.setText(getString(2131759121));
      this.jio.setText(getString(2131759121));
      this.jiq.setText(getString(2131759120));
    }
    for (;;)
    {
      this.jik = new i(this, this.jiu, 2);
      this.jiq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131205);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new StringBuilder();
          g.ajP();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.a.ajd()).append(",").append(FindMContactInviteUI.this.getClass().getName()).append(",R300_400_AddAllButton,");
          g.ajP();
          com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R300_300_AddAllButton") + ",3");
          if (FindMContactInviteUI.d(FindMContactInviteUI.this) == 2)
          {
            FindMContactInviteUI.b(FindMContactInviteUI.this).fr(true);
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
              FindMContactInviteUI.b(FindMContactInviteUI.this).fr(true);
              FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
              FindMContactInviteUI.h(FindMContactInviteUI.this);
            }
            else
            {
              FindMContactInviteUI.b(FindMContactInviteUI.this).fr(true);
              FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
              FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(8);
              if (FindMContactInviteUI.f(FindMContactInviteUI.this) != null) {
                FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(0);
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
            AppMethodBeat.i(131206);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(0);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(8);
            FindMContactInviteUI.b(FindMContactInviteUI.this).fr(false);
            FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131206);
          }
        });
        this.jip.setVisibility(8);
      }
      this.jfb.addHeaderView(this.jil);
      this.jfb.setAdapter(this.jik);
      this.jfb.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      this.jfb.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(131207);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          if (FindMContactInviteUI.b(FindMContactInviteUI.this) != null)
          {
            paramAnonymousView = FindMContactInviteUI.b(FindMContactInviteUI.this);
            if (paramAnonymousView.jgu != null) {
              paramAnonymousView.jgu.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(131207);
          return false;
        }
      });
      addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(131208);
          FindMContactInviteUI.h(FindMContactInviteUI.this);
          AppMethodBeat.o(131208);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131209);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = FindMContactInviteUI.i(FindMContactInviteUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131209);
        }
      });
      AppMethodBeat.o(131220);
      return;
      this.jil = LayoutInflater.from(this).inflate(2131494009, null);
      this.jim = ((TextView)this.jil.findViewById(2131300082));
      this.jin = ((TextView)this.jil.findViewById(2131300085));
      this.jio = ((TextView)this.jil.findViewById(2131299970));
      this.jiq = ((Button)this.jil.findViewById(2131299969));
      this.jin.setText(getString(2131759124));
      this.jio.setText(getString(2131759121));
      this.jiq.setText(getString(2131759119, new Object[] { Integer.valueOf(0) }));
      this.jip = ((TextView)this.jil.findViewById(2131302345));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131213);
    super.onCreate(paramBundle);
    setMMTitle(2131759123);
    com.tencent.mm.plugin.account.a.a.iUA.MP();
    this.jiw = getIntent().getStringExtra("regsetinfo_ticket");
    this.jir = getIntent().getIntExtra("login_type", 0);
    this.jdM = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.jdS = com.tencent.mm.plugin.b.a.aVo();
    initView();
    AppMethodBeat.o(131213);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131219);
    if (this.onSceneEndCallback != null)
    {
      g.ajj().b(432, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    if (this.jik != null)
    {
      i locali = this.jik;
      if (locali.jgu != null)
      {
        locali.jgu.detach();
        locali.jgu = null;
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
      aSz();
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
    if (this.jir == 1)
    {
      localStringBuilder = new StringBuilder();
      g.ajP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      g.ajP();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R300_400_QQ") + ",2");
      AppMethodBeat.o(131218);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R300_400_phone,");
    g.ajP();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R300_400_phone") + ",2");
    AppMethodBeat.o(131218);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131221);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(131221);
      return;
    }
    ae.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131221);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aTV();
        AppMethodBeat.o(131221);
        return;
      }
      this.jit = false;
      h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(131199);
          paramAnonymousDialogInterface = FindMContactInviteUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          FindMContactInviteUI.n(FindMContactInviteUI.this);
          FindMContactInviteUI.this.finish();
          AppMethodBeat.o(131199);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(131200);
          FindMContactInviteUI.n(FindMContactInviteUI.this);
          FindMContactInviteUI.this.finish();
          AppMethodBeat.o(131200);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131216);
    super.onResume();
    this.jik.notifyDataSetChanged();
    StringBuilder localStringBuilder;
    if (this.jir == 1)
    {
      localStringBuilder = new StringBuilder();
      g.ajP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      g.ajP();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("R300_400_QQ") + ",1");
    }
    while (this.jit)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
      ae.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN() });
      if (!bool)
      {
        AppMethodBeat.o(131216);
        return;
        localStringBuilder = new StringBuilder();
        g.ajP();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R300_400_phone,");
        g.ajP();
        com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("R300_400_phone") + ",1");
      }
      else
      {
        aTV();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI
 * JD-Core Version:    0.7.0.1
 */