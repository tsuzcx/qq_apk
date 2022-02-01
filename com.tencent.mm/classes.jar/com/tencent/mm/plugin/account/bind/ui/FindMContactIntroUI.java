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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactIntroUI
  extends MMWizardActivity
{
  private String fLC;
  private ProgressDialog iXX = null;
  private String jaS = null;
  private Button mTF;
  private TextView mTG;
  private TextView mTH;
  private String mTn = "";
  private int mTo = 2;
  private boolean mTr = false;
  private List<String[]> mTs = null;
  private aj mTt;
  private String mTu;
  private i onSceneEndCallback = null;
  
  private void bxB()
  {
    AppMethodBeat.i(110039);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    Log.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (!bool)
    {
      AppMethodBeat.o(110039);
      return;
    }
    Object localObject = com.tencent.mm.kernel.h.aGY();
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
          com.tencent.mm.kernel.h.aGY().b(431, FindMContactIntroUI.i(FindMContactIntroUI.this));
          FindMContactIntroUI.j(FindMContactIntroUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((aj)paramAnonymousq).byA();
          ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label386;
          }
          paramAnonymousq = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousq.hasNext())
          {
            crg localcrg = (crg)paramAnonymousq.next();
            if (localcrg != null)
            {
              if (localcrg.rVU != 1) {
                break label383;
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
            com.tencent.mm.plugin.b.a.bkD("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactIntroUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactIntroUI.c(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactIntroUI.d(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.e(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.aH(FindMContactIntroUI.this, paramAnonymousString);
            AppMethodBeat.o(110029);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label325:
          FindMContactIntroUI.b(FindMContactIntroUI.this);
          AppMethodBeat.o(110029);
          return;
          Toast.makeText(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(a.i.app_err_system_busy_tip, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
          AppMethodBeat.o(110029);
          return;
          label383:
          break;
          label386:
          paramAnonymousInt2 = 0;
          paramAnonymousInt1 = 0;
        }
      }
    };
    this.onSceneEndCallback = local9;
    ((t)localObject).a(431, local9);
    localObject = getContext();
    getString(a.i.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a((Context)localObject, getString(a.i.app_loading), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110030);
        if (FindMContactIntroUI.i(FindMContactIntroUI.this) != null)
        {
          com.tencent.mm.kernel.h.aGY().b(431, FindMContactIntroUI.i(FindMContactIntroUI.this));
          FindMContactIntroUI.j(FindMContactIntroUI.this);
        }
        AppMethodBeat.o(110030);
      }
    });
    com.tencent.mm.kernel.h.aHJ().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(110032);
        for (;;)
        {
          try
          {
            FindMContactIntroUI.a(FindMContactIntroUI.this, com.tencent.mm.pluginsdk.b.dN(FindMContactIntroUI.this));
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
          com.tencent.mm.kernel.h.aGY().a(FindMContactIntroUI.l(FindMContactIntroUI.this), 0);
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
  
  private void bxv()
  {
    AppMethodBeat.i(110041);
    com.tencent.mm.plugin.b.a.bkD(this.mTu);
    hideVKB();
    atX(1);
    AppMethodBeat.o(110041);
  }
  
  public int getLayoutId()
  {
    return a.f.findmcontact_intro;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110038);
    this.mTF = ((Button)findViewById(a.e.setting_bind_mobile_friend_btn));
    this.mTH = ((TextView)findViewById(a.e.findmcontact_skip_tv));
    this.mTG = ((TextView)findViewById(a.e.findmcontact_intro_tv));
    if ((this.mTn != null) && (this.mTn.contains("2"))) {
      this.mTG.setText(getString(a.i.find_mcontact_add_frined_tip));
    }
    for (;;)
    {
      this.fLC = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(6, null));
      if ((this.fLC == null) || (this.fLC.equals(""))) {
        this.fLC = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(4097, null));
      }
      this.mTF.setOnClickListener(new FindMContactIntroUI.1(this));
      this.mTH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110024);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.ui.base.h.c(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(a.i.find_mcontact_skip_alert), null, FindMContactIntroUI.this.getString(a.i.find_mcontact_skip_btn), FindMContactIntroUI.this.getString(a.i.find_mcontact_skip_add_friend), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      this.mTG.setText(getString(a.i.find_mcontact_add_frined_tip_noinvite));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110034);
    super.onCreate(paramBundle);
    setMMTitle(a.i.find_mcontact_title);
    com.tencent.mm.plugin.account.sdk.a.mIH.abF();
    this.jaS = getIntent().getStringExtra("regsetinfo_ticket");
    this.mTn = getIntent().getStringExtra("regsetinfo_NextStep");
    this.mTo = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    if (com.tencent.mm.plugin.account.friend.a.l.byi() != l.a.mWk) {}
    for (boolean bool = true;; bool = false)
    {
      this.mTr = bool;
      this.mTu = com.tencent.mm.plugin.b.a.bAt();
      Log.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.mTn, Integer.valueOf(this.mTo) });
      AppMethodBeat.o(110034);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110035);
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.h.aGY().b(431, this.onSceneEndCallback);
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
      bxv();
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
    com.tencent.mm.plugin.b.a.bkD("RE900_100");
    if (this.mTr)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R300_100_QQ") + ",4");
      AppMethodBeat.o(110037);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R300_100_phone") + ",4");
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
        bxB();
        AppMethodBeat.o(110042);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(a.i.permission_contacts_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new FindMContactIntroUI.2(this), new FindMContactIntroUI.3(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110036);
    super.onResume();
    initView();
    if (this.mTr)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("R300_100_QQ") + ",1");
      com.tencent.mm.plugin.b.a.bgi("R300_100_QQ");
      AppMethodBeat.o(110036);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("R300_100_phone") + ",1");
    com.tencent.mm.plugin.b.a.bgi("R300_100_phone");
    AppMethodBeat.o(110036);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI
 * JD-Core Version:    0.7.0.1
 */