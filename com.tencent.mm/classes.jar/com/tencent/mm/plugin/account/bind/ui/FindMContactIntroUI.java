package com.tencent.mm.plugin.account.bind.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.ag;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactIntroUI
  extends MMWizardActivity
{
  private String hRk;
  private String lCS = null;
  private ProgressDialog lzP = null;
  private com.tencent.mm.am.h onSceneEndCallback = null;
  private String pPU = "";
  private int pPV = 2;
  private boolean pPY = false;
  private List<String[]> pPZ = null;
  private ag pQa;
  private String pQb;
  private Button pQm;
  private TextView pQn;
  private TextView pQo;
  
  private void bWj()
  {
    AppMethodBeat.i(110041);
    com.tencent.mm.plugin.b.a.TA(this.pQb);
    hideVKB();
    aAp(1);
    AppMethodBeat.o(110041);
  }
  
  private void bWq()
  {
    AppMethodBeat.i(110039);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null);
    Log.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (!bool)
    {
      AppMethodBeat.o(110039);
      return;
    }
    Object localObject = com.tencent.mm.kernel.h.aZW();
    com.tencent.mm.am.h local9 = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(110029);
        if (FindMContactIntroUI.g(FindMContactIntroUI.this) != null)
        {
          FindMContactIntroUI.g(FindMContactIntroUI.this).dismiss();
          FindMContactIntroUI.h(FindMContactIntroUI.this);
        }
        if (FindMContactIntroUI.i(FindMContactIntroUI.this) != null)
        {
          com.tencent.mm.kernel.h.aZW().b(431, FindMContactIntroUI.i(FindMContactIntroUI.this));
          FindMContactIntroUI.j(FindMContactIntroUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((ag)paramAnonymousp).bXo();
          ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label386;
          }
          paramAnonymousp = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousp.hasNext())
          {
            dib localdib = (dib)paramAnonymousp.next();
            if (localdib != null)
            {
              if (localdib.vhk != 1) {
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
            com.tencent.mm.plugin.b.a.TA("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactIntroUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactIntroUI.c(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactIntroUI.d(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.e(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.aQ(FindMContactIntroUI.this, paramAnonymousString);
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
    ((s)localObject).a(431, local9);
    localObject = getContext();
    getString(a.i.app_tip);
    this.lzP = k.a((Context)localObject, getString(a.i.app_loading), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110030);
        if (FindMContactIntroUI.i(FindMContactIntroUI.this) != null)
        {
          com.tencent.mm.kernel.h.aZW().b(431, FindMContactIntroUI.i(FindMContactIntroUI.this));
          FindMContactIntroUI.j(FindMContactIntroUI.this);
        }
        AppMethodBeat.o(110030);
      }
    });
    com.tencent.mm.kernel.h.baH().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(110032);
        for (;;)
        {
          try
          {
            FindMContactIntroUI.a(FindMContactIntroUI.this, com.tencent.mm.pluginsdk.b.eI(FindMContactIntroUI.this));
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
          FindMContactIntroUI.a(FindMContactIntroUI.this, new ag(FindMContactIntroUI.c(FindMContactIntroUI.this), FindMContactIntroUI.k(FindMContactIntroUI.this)));
          com.tencent.mm.kernel.h.aZW().a(FindMContactIntroUI.l(FindMContactIntroUI.this), 0);
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
    return a.f.findmcontact_intro;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110038);
    this.pQm = ((Button)findViewById(a.e.setting_bind_mobile_friend_btn));
    this.pQo = ((TextView)findViewById(a.e.findmcontact_skip_tv));
    this.pQn = ((TextView)findViewById(a.e.findmcontact_intro_tv));
    if ((this.pPU != null) && (this.pPU.contains("2"))) {
      this.pQn.setText(getString(a.i.find_mcontact_add_frined_tip));
    }
    for (;;)
    {
      this.hRk = ((String)com.tencent.mm.kernel.h.baE().ban().d(6, null));
      if ((this.hRk == null) || (this.hRk.equals(""))) {
        this.hRk = ((String)com.tencent.mm.kernel.h.baE().ban().d(4097, null));
      }
      this.pQm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110020);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          FindMContactIntroUI.a(FindMContactIntroUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110020);
        }
      });
      this.pQo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110024);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          k.b(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(a.i.find_mcontact_skip_alert), null, FindMContactIntroUI.this.getString(a.i.find_mcontact_skip_btn), FindMContactIntroUI.this.getString(a.i.find_mcontact_skip_add_friend), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      this.pQn.setText(getString(a.i.find_mcontact_add_frined_tip_noinvite));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110034);
    super.onCreate(paramBundle);
    setMMTitle(a.i.find_mcontact_title);
    com.tencent.mm.plugin.account.sdk.a.pFo.aDA();
    this.lCS = getIntent().getStringExtra("regsetinfo_ticket");
    this.pPU = getIntent().getStringExtra("regsetinfo_NextStep");
    this.pPV = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    if (i.bWW() != i.a.pSQ) {}
    for (boolean bool = true;; bool = false)
    {
      this.pPY = bool;
      this.pQb = com.tencent.mm.plugin.b.a.chY();
      Log.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.pPU, Integer.valueOf(this.pPV) });
      AppMethodBeat.o(110034);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110035);
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.h.aZW().b(431, this.onSceneEndCallback);
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
      bWj();
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
    com.tencent.mm.plugin.b.a.TA("RE900_100");
    if (this.pPY)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R300_100_QQ") + ",4");
      AppMethodBeat.o(110037);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R300_100_phone") + ",4");
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
        bWq();
        AppMethodBeat.o(110042);
        return;
      }
      k.a(this, getString(a.i.permission_contacts_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110021);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.pluginsdk.permission.b.lx(FindMContactIntroUI.this.getContext());
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
    if (this.pPY)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("R300_100_QQ") + ",1");
      com.tencent.mm.plugin.b.a.Tz("R300_100_QQ");
      AppMethodBeat.o(110036);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("R300_100_phone") + ",1");
    com.tencent.mm.plugin.b.a.Tz("R300_100_phone");
    AppMethodBeat.o(110036);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI
 * JD-Core Version:    0.7.0.1
 */