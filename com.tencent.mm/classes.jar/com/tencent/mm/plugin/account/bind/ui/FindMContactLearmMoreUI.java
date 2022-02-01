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
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
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

public class FindMContactLearmMoreUI
  extends MMWizardActivity
{
  private String hRk;
  private String lCS = null;
  private ProgressDialog lzP = null;
  private com.tencent.mm.am.h onSceneEndCallback = null;
  private String pPU = "";
  private int pPV = 2;
  private List<String[]> pPZ = null;
  private ag pQa;
  private Button pQr;
  private TextView pQs;
  
  private void bWj()
  {
    AppMethodBeat.i(110062);
    hideVKB();
    aAp(1);
    AppMethodBeat.o(110062);
  }
  
  private void bWq()
  {
    AppMethodBeat.i(110060);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null);
    Log.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (!bool)
    {
      AppMethodBeat.o(110060);
      return;
    }
    Object localObject = com.tencent.mm.kernel.h.aZW();
    com.tencent.mm.am.h local3 = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(110048);
        if (FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this) != null)
        {
          FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this).dismiss();
          FindMContactLearmMoreUI.d(FindMContactLearmMoreUI.this);
        }
        if (FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this) != null)
        {
          com.tencent.mm.kernel.h.aZW().b(431, FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this));
          FindMContactLearmMoreUI.f(FindMContactLearmMoreUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((ag)paramAnonymousp).bXo();
          ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label393;
          }
          paramAnonymousp = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousp.hasNext())
          {
            dib localdib = (dib)paramAnonymousp.next();
            if (localdib != null)
            {
              if (localdib.vhk != 1) {
                break label390;
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
            Log.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this) == null) || (!FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label325;
            }
            com.tencent.mm.plugin.b.a.TA("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactLearmMoreUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactLearmMoreUI.h(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactLearmMoreUI.i(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.aQ(FindMContactLearmMoreUI.this, paramAnonymousString);
            AppMethodBeat.o(110048);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label325:
          FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
          AppMethodBeat.o(110048);
          return;
          Toast.makeText(FindMContactLearmMoreUI.this, FindMContactLearmMoreUI.this.getString(a.i.app_err_system_busy_tip, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
          FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
          AppMethodBeat.o(110048);
          return;
          label390:
          break;
          label393:
          paramAnonymousInt2 = 0;
          paramAnonymousInt1 = 0;
        }
      }
    };
    this.onSceneEndCallback = local3;
    ((s)localObject).a(431, local3);
    localObject = getContext();
    getString(a.i.app_tip);
    this.lzP = k.a((Context)localObject, getString(a.i.app_loading), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110049);
        if (FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this) != null)
        {
          com.tencent.mm.kernel.h.aZW().b(431, FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this));
          FindMContactLearmMoreUI.f(FindMContactLearmMoreUI.this);
        }
        AppMethodBeat.o(110049);
      }
    });
    com.tencent.mm.kernel.h.baH().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(110051);
        for (;;)
        {
          try
          {
            FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this, com.tencent.mm.pluginsdk.b.eI(FindMContactLearmMoreUI.this));
            StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
            if (FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this) != null) {
              continue;
            }
            i = 0;
            Log.d("MicroMsg.FindMContactLearmMoreUI", i);
          }
          catch (Exception localException)
          {
            int i;
            Log.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", localException, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(110051);
          return true;
          i = FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this).size();
        }
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(110050);
        if ((FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this) != null) && (FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this).size() != 0))
        {
          FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this, new ag(FindMContactLearmMoreUI.h(FindMContactLearmMoreUI.this), FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this)));
          com.tencent.mm.kernel.h.aZW().a(FindMContactLearmMoreUI.k(FindMContactLearmMoreUI.this), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(110050);
          return false;
          if (FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this) != null)
          {
            FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this).dismiss();
            FindMContactLearmMoreUI.d(FindMContactLearmMoreUI.this);
          }
          FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(110052);
        String str = super.toString() + "|doUpload";
        AppMethodBeat.o(110052);
        return str;
      }
    });
    ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).syncUploadMContactStatus(true, false);
    ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).syncAddrBookAndUpload();
    AppMethodBeat.o(110060);
  }
  
  public int getLayoutId()
  {
    return a.f.findmcontact_intro_learn_more;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110059);
    setMMTitle(a.i.find_mcontact_upload_title);
    this.pQr = ((Button)findViewById(a.e.ok_btn));
    this.pQs = ((TextView)findViewById(a.e.cancel_btn));
    this.pQr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110046);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        i.hN(true);
        ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).syncUploadMContactStatus(true, false);
        FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110046);
      }
    });
    this.pQs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110047);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        i.hN(false);
        ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).syncUploadMContactStatus(true, false);
        FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/FindMContactLearmMoreUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110047);
      }
    });
    com.tencent.mm.kernel.h.baE().ban().B(12323, Boolean.TRUE);
    this.hRk = ((String)com.tencent.mm.kernel.h.baE().ban().d(6, null));
    if ((this.hRk == null) || (this.hRk.equals(""))) {
      this.hRk = ((String)com.tencent.mm.kernel.h.baE().ban().d(4097, null));
    }
    AppMethodBeat.o(110059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110055);
    super.onCreate(paramBundle);
    this.lCS = getIntent().getStringExtra("regsetinfo_ticket");
    this.pPU = getIntent().getStringExtra("regsetinfo_NextStep");
    this.pPV = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    initView();
    AppMethodBeat.o(110055);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110056);
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.h.aZW().b(431, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    super.onDestroy();
    AppMethodBeat.o(110056);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(110061);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      bWj();
      AppMethodBeat.o(110061);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(110061);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(110058);
    super.onPause();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",RE300_600,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("RE300_600") + ",2");
    AppMethodBeat.o(110058);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110063);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(110063);
      return;
    }
    Log.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110063);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bWq();
        AppMethodBeat.o(110063);
        return;
      }
      k.a(this, getString(a.i.permission_contacts_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110053);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.pluginsdk.permission.b.lx(FindMContactLearmMoreUI.this.getContext());
          AppMethodBeat.o(110053);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110054);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(110054);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110057);
    super.onResume();
    com.tencent.mm.plugin.b.a.Tz("R300_100_phone");
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",RE300_600,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("RE300_600") + ",1");
    AppMethodBeat.o(110057);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI
 * JD-Core Version:    0.7.0.1
 */