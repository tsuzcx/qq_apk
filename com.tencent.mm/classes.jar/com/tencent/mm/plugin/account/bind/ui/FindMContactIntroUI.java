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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactIntroUI
  extends MMWizardActivity
{
  private String dSf;
  private ProgressDialog gtM = null;
  private String gwF = null;
  private String kbO = "";
  private int kbP = 2;
  private boolean kbS = false;
  private List<String[]> kbT = null;
  private aj kbU;
  private String kbV;
  private Button kcg;
  private TextView kch;
  private TextView kci;
  private i onSceneEndCallback = null;
  
  private void bnm()
  {
    AppMethodBeat.i(110041);
    com.tencent.mm.plugin.b.a.bwV(this.kbV);
    hideVKB();
    ala(1);
    AppMethodBeat.o(110041);
  }
  
  private void bns()
  {
    AppMethodBeat.i(110039);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    Log.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (!bool)
    {
      AppMethodBeat.o(110039);
      return;
    }
    Object localObject = g.azz();
    i local9 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(110029);
        if (FindMContactIntroUI.g(FindMContactIntroUI.this) != null)
        {
          FindMContactIntroUI.g(FindMContactIntroUI.this).dismiss();
          FindMContactIntroUI.h(FindMContactIntroUI.this);
        }
        if (FindMContactIntroUI.i(FindMContactIntroUI.this) != null)
        {
          g.azz().b(431, FindMContactIntroUI.i(FindMContactIntroUI.this));
          FindMContactIntroUI.j(FindMContactIntroUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((aj)paramAnonymousq).bor();
          ((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label385;
          }
          paramAnonymousq = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousq.hasNext())
          {
            cik localcik = (cik)paramAnonymousq.next();
            if (localcik != null)
            {
              if (localcik.oTW != 1) {
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
            Log.d("MicroMsg.FindMContactIntroUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactIntroUI.d(FindMContactIntroUI.this) == null) || (!FindMContactIntroUI.d(FindMContactIntroUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label325;
            }
            com.tencent.mm.plugin.b.a.bwV("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactIntroUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactIntroUI.c(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactIntroUI.d(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.e(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.ay(FindMContactIntroUI.this, paramAnonymousString);
            AppMethodBeat.o(110029);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label325:
          FindMContactIntroUI.b(FindMContactIntroUI.this);
          AppMethodBeat.o(110029);
          return;
          Toast.makeText(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(2131755804, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
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
    ((t)localObject).a(431, local9);
    localObject = getContext();
    getString(2131755998);
    this.gtM = h.a((Context)localObject, getString(2131755886), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110030);
        if (FindMContactIntroUI.i(FindMContactIntroUI.this) != null)
        {
          g.azz().b(431, FindMContactIntroUI.i(FindMContactIntroUI.this));
          FindMContactIntroUI.j(FindMContactIntroUI.this);
        }
        AppMethodBeat.o(110030);
      }
    });
    g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(110032);
        for (;;)
        {
          try
          {
            FindMContactIntroUI.a(FindMContactIntroUI.this, com.tencent.mm.pluginsdk.b.dO(FindMContactIntroUI.this));
            StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
            if (FindMContactIntroUI.k(FindMContactIntroUI.this) != null) {
              continue;
            }
            i = 0;
            Log.d("MicroMsg.FindMContactIntroUI", i);
          }
          catch (Exception localException)
          {
            int i;
            Log.printErrStackTrace("MicroMsg.FindMContactIntroUI", localException, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(110032);
          return true;
          i = FindMContactIntroUI.k(FindMContactIntroUI.this).size();
        }
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(110031);
        if ((FindMContactIntroUI.k(FindMContactIntroUI.this) != null) && (FindMContactIntroUI.k(FindMContactIntroUI.this).size() != 0))
        {
          FindMContactIntroUI.a(FindMContactIntroUI.this, new aj(FindMContactIntroUI.c(FindMContactIntroUI.this), FindMContactIntroUI.k(FindMContactIntroUI.this)));
          g.azz().a(FindMContactIntroUI.l(FindMContactIntroUI.this), 0);
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
  
  public int getLayoutId()
  {
    return 2131494683;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110038);
    this.kcg = ((Button)findViewById(2131307675));
    this.kci = ((TextView)findViewById(2131301519));
    this.kch = ((TextView)findViewById(2131301518));
    if ((this.kbO != null) && (this.kbO.contains("2"))) {
      this.kch.setText(getString(2131759447));
    }
    for (;;)
    {
      this.dSf = ((String)g.aAh().azQ().get(6, null));
      if ((this.dSf == null) || (this.dSf.equals(""))) {
        this.dSf = ((String)g.aAh().azQ().get(4097, null));
      }
      this.kcg.setOnClickListener(new FindMContactIntroUI.1(this));
      this.kci.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110024);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          h.c(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(2131759464), null, FindMContactIntroUI.this.getString(2131759465), FindMContactIntroUI.this.getString(2131759463), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      this.kch.setText(getString(2131759448));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110034);
    super.onCreate(paramBundle);
    setMMTitle(2131759467);
    com.tencent.mm.plugin.account.a.a.jRu.Xc();
    this.gwF = getIntent().getStringExtra("regsetinfo_ticket");
    this.kbO = getIntent().getStringExtra("regsetinfo_NextStep");
    this.kbP = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    if (com.tencent.mm.plugin.account.friend.a.l.bnZ() != l.a.keL) {}
    for (boolean bool = true;; bool = false)
    {
      this.kbS = bool;
      this.kbV = com.tencent.mm.plugin.b.a.bpZ();
      Log.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.kbO, Integer.valueOf(this.kbP) });
      AppMethodBeat.o(110034);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110035);
    if (this.onSceneEndCallback != null)
    {
      g.azz().b(431, this.onSceneEndCallback);
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
      bnm();
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
    com.tencent.mm.plugin.b.a.bwV("RE900_100");
    if (this.kbS)
    {
      localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R300_100_QQ") + ",4");
      AppMethodBeat.o(110037);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R300_100_phone") + ",4");
    AppMethodBeat.o(110037);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110042);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(110042);
      return;
    }
    Log.i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110042);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bns();
        AppMethodBeat.o(110042);
        return;
      }
      h.a(this, getString(2131763866), getString(2131763890), getString(2131762043), getString(2131755761), false, new FindMContactIntroUI.2(this), new FindMContactIntroUI.3(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110036);
    super.onResume();
    initView();
    if (this.kbS)
    {
      localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R300_100_QQ") + ",1");
      com.tencent.mm.plugin.b.a.bwU("R300_100_QQ");
      AppMethodBeat.o(110036);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R300_100_phone") + ",1");
    com.tencent.mm.plugin.b.a.bwU("R300_100_phone");
    AppMethodBeat.o(110036);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI
 * JD-Core Version:    0.7.0.1
 */