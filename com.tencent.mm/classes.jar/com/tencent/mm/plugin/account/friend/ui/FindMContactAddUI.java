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

public class FindMContactAddUI
  extends MMWizardActivity
{
  private TextView emptyTipTv;
  private ProgressDialog gtM;
  private String gwF;
  private String kbO;
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
  private int loginType;
  private com.tencent.mm.ak.i onSceneEndCallback;
  
  public FindMContactAddUI()
  {
    AppMethodBeat.i(131187);
    this.gtM = null;
    this.emptyTipTv = null;
    this.kgp = null;
    this.kgq = null;
    this.kgr = null;
    this.kgs = null;
    this.kgt = null;
    this.gwF = null;
    this.onSceneEndCallback = null;
    this.kbO = "";
    this.kbP = 2;
    this.kgv = true;
    this.kgw = new i.a()
    {
      public final void notifyDataSetChanged()
      {
        AppMethodBeat.i(131181);
        if ((FindMContactAddUI.e(FindMContactAddUI.this) != 2) && (FindMContactAddUI.e(FindMContactAddUI.this) == 1))
        {
          FindMContactAddUI.f(FindMContactAddUI.this).setText(FindMContactAddUI.this.getString(2131759445));
          if (!FindMContactAddUI.c(FindMContactAddUI.this).bnV()) {
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
          FindMContactAddUI.f(FindMContactAddUI.this).setText(FindMContactAddUI.this.getString(2131759444, new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getCount()) }));
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
  
  private void bnm()
  {
    AppMethodBeat.i(131191);
    com.tencent.mm.plugin.b.a.bwV(this.kbV);
    hideVKB();
    ala(1);
    AppMethodBeat.o(131191);
  }
  
  private void boH()
  {
    AppMethodBeat.i(131189);
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
        AppMethodBeat.i(131179);
        try
        {
          FindMContactAddUI.a(FindMContactAddUI.this, com.tencent.mm.pluginsdk.b.dO(FindMContactAddUI.this));
          FindMContactAddUI.c(FindMContactAddUI.this).kbT = FindMContactAddUI.d(FindMContactAddUI.this);
          FindMContactAddUI.c(FindMContactAddUI.this).s(((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
          AppMethodBeat.o(131179);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.FindMContactAddUI", localException, "", new Object[0]);
          }
        }
      }
      
      public final boolean onPostExecute()
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
    return 2131494188;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131195);
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
      this.kgq.setText(getString(2131759477));
      this.kgr.setText(getString(2131759478));
      this.kgt.setText(getString(2131759445));
    }
    for (;;)
    {
      this.kgn = new com.tencent.mm.plugin.account.friend.a.i(this, this.kgw, 1);
      this.kgt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131182);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new StringBuilder();
          g.aAf();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.a.azt()).append(",").append(FindMContactAddUI.this.getClass().getName()).append(",R300_300_AddAllButton,");
          g.aAf();
          com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R300_300_AddAllButton") + ",3");
          if (FindMContactAddUI.e(FindMContactAddUI.this) == 2)
          {
            FindMContactAddUI.c(FindMContactAddUI.this).gk(true);
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
              FindMContactAddUI.c(FindMContactAddUI.this).gk(true);
              FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
              FindMContactAddUI.i(FindMContactAddUI.this);
            }
            else
            {
              FindMContactAddUI.c(FindMContactAddUI.this).gk(true);
              FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
              FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(8);
              if (FindMContactAddUI.g(FindMContactAddUI.this) != null) {
                FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(0);
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
            AppMethodBeat.i(131183);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(0);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(8);
            FindMContactAddUI.c(FindMContactAddUI.this).gk(false);
            FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131183);
          }
        });
        this.kgs.setVisibility(8);
      }
      this.kde.addHeaderView(this.kgo);
      this.kde.setAdapter(this.kgn);
      addTextOptionMenu(0, getString(2131755916), new FindMContactAddUI.10(this));
      setToTop(new FindMContactAddUI.11(this));
      AppMethodBeat.o(131195);
      return;
      this.kgo = LayoutInflater.from(this).inflate(2131494189, null);
      this.kgp = ((TextView)this.kgo.findViewById(2131301517));
      this.kgq = ((TextView)this.kgo.findViewById(2131301520));
      this.kgr = ((TextView)this.kgo.findViewById(2131300729));
      this.kgt = ((Button)this.kgo.findViewById(2131300728));
      this.kgq.setText(getString(2131759477));
      this.kgr.setText(getString(2131759478));
      this.kgt.setText(getString(2131759444, new Object[] { Integer.valueOf(0) }));
      this.kgs = ((TextView)this.kgo.findViewById(2131304742));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131188);
    super.onCreate(paramBundle);
    setMMTitle(2131759449);
    com.tencent.mm.plugin.account.a.a.jRu.Xc();
    this.gwF = getIntent().getStringExtra("regsetinfo_ticket");
    this.kbO = getIntent().getStringExtra("regsetinfo_NextStep");
    this.kbP = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.loginType = getIntent().getIntExtra("login_type", 0);
    this.kbV = com.tencent.mm.plugin.b.a.bpZ();
    initView();
    AppMethodBeat.o(131188);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131194);
    if (this.onSceneEndCallback != null)
    {
      g.azz().b(30, this.onSceneEndCallback);
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
      bnm();
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
    if (this.loginType == 1)
    {
      localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R300_300_QQ") + ",2");
      AppMethodBeat.o(131193);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_300_phone,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R300_300_phone") + ",2");
    AppMethodBeat.o(131193);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131196);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(131196);
      return;
    }
    Log.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131196);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        boH();
        AppMethodBeat.o(131196);
        return;
      }
      this.kgv = false;
      h.a(this, getString(2131763866), getString(2131763890), getString(2131762043), getString(2131755761), false, new FindMContactAddUI.4(this), new FindMContactAddUI.5(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131192);
    super.onResume();
    this.kgn.notifyDataSetChanged();
    StringBuilder localStringBuilder;
    if (this.loginType == 1)
    {
      localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R300_300_QQ") + ",1");
      com.tencent.mm.plugin.b.a.bwU("R300_300_QQ");
    }
    while (this.kgv)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
      Log.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
      if (!bool)
      {
        AppMethodBeat.o(131192);
        return;
        localStringBuilder = new StringBuilder();
        g.aAf();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_300_phone,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R300_300_phone") + ",1");
        com.tencent.mm.plugin.b.a.bwU("R300_300_phone");
      }
      else
      {
        boH();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI
 * JD-Core Version:    0.7.0.1
 */