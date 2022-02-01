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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class FindMContactInviteUI
  extends MMWizardActivity
{
  private TextView emptyTipTv;
  private ProgressDialog gtM;
  private int kbP;
  private String kbV;
  private ListView kde;
  private com.tencent.mm.plugin.account.friend.a.i kgn;
  private View kgo;
  private TextView kgp;
  private TextView kgq;
  private TextView kgr;
  private TextView kgs;
  private Button kgt;
  private List<String[]> kgu;
  private boolean kgv;
  private i.a kgw;
  private String kgy;
  private int loginType;
  private com.tencent.mm.ak.i onSceneEndCallback;
  
  public FindMContactInviteUI()
  {
    AppMethodBeat.i(131212);
    this.gtM = null;
    this.emptyTipTv = null;
    this.kgp = null;
    this.kgq = null;
    this.kgr = null;
    this.kgs = null;
    this.kgt = null;
    this.kgy = null;
    this.onSceneEndCallback = null;
    this.kbP = 2;
    this.kgv = true;
    this.kgw = new i.a()
    {
      public final void notifyDataSetChanged()
      {
        AppMethodBeat.i(131204);
        if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 2) && (FindMContactInviteUI.d(FindMContactInviteUI.this) == 1))
        {
          FindMContactInviteUI.e(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getString(2131759454));
          if (!FindMContactInviteUI.b(FindMContactInviteUI.this).bnV()) {
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
          FindMContactInviteUI.e(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getString(2131759453, new Object[] { Integer.valueOf(FindMContactInviteUI.b(FindMContactInviteUI.this).getCount()) }));
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
  
  private void bnm()
  {
    AppMethodBeat.i(131215);
    com.tencent.mm.plugin.b.a.bwV(this.kbV);
    hideVKB();
    ala(1);
    AppMethodBeat.o(131215);
  }
  
  private void boH()
  {
    AppMethodBeat.i(131217);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755998);
    this.gtM = h.a(localAppCompatActivity, getString(2131763077), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(131202);
        try
        {
          FindMContactInviteUI.a(FindMContactInviteUI.this, com.tencent.mm.pluginsdk.b.dO(FindMContactInviteUI.this));
          FindMContactInviteUI.b(FindMContactInviteUI.this).kbT = FindMContactInviteUI.c(FindMContactInviteUI.this);
          FindMContactInviteUI.b(FindMContactInviteUI.this).s(((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
          AppMethodBeat.o(131202);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.FindMContactInviteUI", localException, "", new Object[0]);
          }
        }
      }
      
      public final boolean onPostExecute()
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
    return 2131494188;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131220);
    this.emptyTipTv = ((TextView)findViewById(2131304747));
    this.emptyTipTv.setText(2131763075);
    this.kde = ((ListView)findViewById(2131304749));
    if ((this.kbP != 2) && (this.kbP == 1))
    {
      this.kgo = LayoutInflater.from(this).inflate(2131494190, null);
      this.kgp = ((TextView)this.kgo.findViewById(2131301517));
      this.kgq = ((TextView)this.kgo.findViewById(2131301520));
      this.kgr = ((TextView)this.kgo.findViewById(2131300729));
      this.kgt = ((Button)this.kgo.findViewById(2131300728));
      this.kgq.setText(getString(2131759455));
      this.kgr.setText(getString(2131759455));
      this.kgt.setText(getString(2131759454));
    }
    for (;;)
    {
      this.kgn = new com.tencent.mm.plugin.account.friend.a.i(this, this.kgw, 2);
      this.kgt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131205);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new StringBuilder();
          g.aAf();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.a.azt()).append(",").append(FindMContactInviteUI.this.getClass().getName()).append(",R300_400_AddAllButton,");
          g.aAf();
          com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R300_300_AddAllButton") + ",3");
          if (FindMContactInviteUI.d(FindMContactInviteUI.this) == 2)
          {
            FindMContactInviteUI.b(FindMContactInviteUI.this).gk(true);
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
              FindMContactInviteUI.b(FindMContactInviteUI.this).gk(true);
              FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
              FindMContactInviteUI.h(FindMContactInviteUI.this);
            }
            else
            {
              FindMContactInviteUI.b(FindMContactInviteUI.this).gk(true);
              FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
              FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(8);
              if (FindMContactInviteUI.f(FindMContactInviteUI.this) != null) {
                FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(0);
              }
            }
          }
        }
      });
      if (this.kgs != null)
      {
        this.kgs.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131206);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(0);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(8);
            FindMContactInviteUI.b(FindMContactInviteUI.this).gk(false);
            FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131206);
          }
        });
        this.kgs.setVisibility(8);
      }
      this.kde.addHeaderView(this.kgo);
      this.kde.setAdapter(this.kgn);
      this.kde.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      this.kde.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(131207);
          if (FindMContactInviteUI.b(FindMContactInviteUI.this) != null)
          {
            paramAnonymousView = FindMContactInviteUI.b(FindMContactInviteUI.this);
            if (paramAnonymousView.kex != null) {
              paramAnonymousView.kex.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          AppMethodBeat.o(131207);
          return false;
        }
      });
      addTextOptionMenu(0, getString(2131755858), new FindMContactInviteUI.10(this));
      setToTop(new FindMContactInviteUI.11(this));
      AppMethodBeat.o(131220);
      return;
      this.kgo = LayoutInflater.from(this).inflate(2131494189, null);
      this.kgp = ((TextView)this.kgo.findViewById(2131301517));
      this.kgq = ((TextView)this.kgo.findViewById(2131301520));
      this.kgr = ((TextView)this.kgo.findViewById(2131300729));
      this.kgt = ((Button)this.kgo.findViewById(2131300728));
      this.kgq.setText(getString(2131759458));
      this.kgr.setText(getString(2131759455));
      this.kgt.setText(getString(2131759453, new Object[] { Integer.valueOf(0) }));
      this.kgs = ((TextView)this.kgo.findViewById(2131304742));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131213);
    super.onCreate(paramBundle);
    setMMTitle(2131759457);
    com.tencent.mm.plugin.account.a.a.jRu.Xc();
    this.kgy = getIntent().getStringExtra("regsetinfo_ticket");
    this.loginType = getIntent().getIntExtra("login_type", 0);
    this.kbP = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.kbV = com.tencent.mm.plugin.b.a.bpZ();
    initView();
    AppMethodBeat.o(131213);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131219);
    if (this.onSceneEndCallback != null)
    {
      g.azz().b(432, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    if (this.kgn != null)
    {
      com.tencent.mm.plugin.account.friend.a.i locali = this.kgn;
      if (locali.kex != null)
      {
        locali.kex.detach();
        locali.kex = null;
      }
    }
    ((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).clearFriendData();
    super.onDestroy();
    AppMethodBeat.o(131219);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(131214);
    if (paramInt == 4)
    {
      bnm();
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
    if (this.loginType == 1)
    {
      localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R300_400_QQ") + ",2");
      AppMethodBeat.o(131218);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_400_phone,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R300_400_phone") + ",2");
    AppMethodBeat.o(131218);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131221);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(131221);
      return;
    }
    Log.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131221);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        boH();
        AppMethodBeat.o(131221);
        return;
      }
      this.kgv = false;
      h.a(this, getString(2131763866), getString(2131763890), getString(2131762043), getString(2131755761), false, new FindMContactInviteUI.3(this), new FindMContactInviteUI.4(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131216);
    super.onResume();
    this.kgn.notifyDataSetChanged();
    StringBuilder localStringBuilder;
    if (this.loginType == 1)
    {
      localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R300_400_QQ") + ",1");
    }
    while (this.kgv)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
      Log.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
      if (!bool)
      {
        AppMethodBeat.o(131216);
        return;
        localStringBuilder = new StringBuilder();
        g.aAf();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_400_phone,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R300_400_phone") + ",1");
      }
      else
      {
        boH();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI
 * JD-Core Version:    0.7.0.1
 */