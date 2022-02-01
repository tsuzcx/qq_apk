package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.model.f;
import com.tencent.mm.plugin.account.friend.model.f.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import java.util.List;

public class FindMContactInviteUI
  extends MMWizardActivity
{
  private TextView emptyTipTv;
  private int loginType;
  private ProgressDialog lzP;
  private com.tencent.mm.am.h onSceneEndCallback;
  private int pPV;
  private String pQb;
  private ListView pRl;
  private Button pUA;
  private List<String[]> pUB;
  private boolean pUC;
  private f.a pUD;
  private String pUF;
  private f pUu;
  private View pUv;
  private TextView pUw;
  private TextView pUx;
  private TextView pUy;
  private TextView pUz;
  
  public FindMContactInviteUI()
  {
    AppMethodBeat.i(131212);
    this.lzP = null;
    this.emptyTipTv = null;
    this.pUw = null;
    this.pUx = null;
    this.pUy = null;
    this.pUz = null;
    this.pUA = null;
    this.pUF = null;
    this.onSceneEndCallback = null;
    this.pPV = 2;
    this.pUC = true;
    this.pUD = new f.a()
    {
      public final void notifyDataSetChanged()
      {
        AppMethodBeat.i(131204);
        if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 2) && (FindMContactInviteUI.d(FindMContactInviteUI.this) == 1))
        {
          FindMContactInviteUI.e(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getString(a.g.find_mcontact_invite_all_continue));
          if (!FindMContactInviteUI.b(FindMContactInviteUI.this).bWS()) {
            break label243;
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
            break label305;
          }
          FindMContactInviteUI.g(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getResources().getQuantityString(a.e.find_mcontact_already_invite_count, FindMContactInviteUI.b(FindMContactInviteUI.this).getSelectCount(), new Object[] { Integer.valueOf(FindMContactInviteUI.b(FindMContactInviteUI.this).getSelectCount()) }));
          AppMethodBeat.o(131204);
          return;
          FindMContactInviteUI.e(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getString(a.g.find_mcontact_invite_all, new Object[] { Integer.valueOf(FindMContactInviteUI.b(FindMContactInviteUI.this).getCount()) }));
          break;
          label243:
          if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 1) && (FindMContactInviteUI.e(FindMContactInviteUI.this).getVisibility() == 8) && (FindMContactInviteUI.f(FindMContactInviteUI.this) != null))
          {
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(0);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(8);
          }
        }
        label305:
        FindMContactInviteUI.g(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getResources().getQuantityString(a.e.find_mcontact_invite_friend_cnt, FindMContactInviteUI.b(FindMContactInviteUI.this).getCount(), new Object[] { Integer.valueOf(FindMContactInviteUI.b(FindMContactInviteUI.this).getCount()) }));
        AppMethodBeat.o(131204);
      }
    };
    AppMethodBeat.o(131212);
  }
  
  private void bWj()
  {
    AppMethodBeat.i(131215);
    com.tencent.mm.plugin.b.a.TA(this.pQb);
    hideVKB();
    aAp(1);
    AppMethodBeat.o(131215);
  }
  
  private void bXE()
  {
    AppMethodBeat.i(131217);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(a.g.app_tip);
    this.lzP = k.a(localAppCompatActivity, getString(a.g.mobile_friend_loading), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    com.tencent.mm.kernel.h.baH().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(131202);
        try
        {
          FindMContactInviteUI.a(FindMContactInviteUI.this, com.tencent.mm.pluginsdk.b.eI(FindMContactInviteUI.this));
          FindMContactInviteUI.b(FindMContactInviteUI.this).pPZ = FindMContactInviteUI.c(FindMContactInviteUI.this);
          FindMContactInviteUI.b(FindMContactInviteUI.this).w(((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getFriendData());
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
    return a.d.find_mcontact_add;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131220);
    this.emptyTipTv = ((TextView)findViewById(a.c.mobile_friend_empty_msg_tip_tv));
    this.emptyTipTv.setText(a.g.mobile_friend_empty_qmsg_tip);
    this.pRl = ((ListView)findViewById(a.c.mobile_friend_lv));
    if ((this.pPV != 2) && (this.pPV == 1))
    {
      this.pUv = LayoutInflater.from(this).inflate(a.d.find_mcontact_header_style_two, null);
      this.pUw = ((TextView)this.pUv.findViewById(a.c.findmcontact_count));
      this.pUx = ((TextView)this.pUv.findViewById(a.c.findmcontact_tip));
      this.pUy = ((TextView)this.pUv.findViewById(a.c.find_mcontact_title));
      this.pUA = ((Button)this.pUv.findViewById(a.c.find_mcontact_addall));
      this.pUx.setText(getString(a.g.find_mcontact_invite_friend));
      this.pUy.setText(getString(a.g.find_mcontact_invite_friend));
      this.pUA.setText(getString(a.g.find_mcontact_invite_all_continue));
    }
    for (;;)
    {
      this.pUu = new f(this, this.pUD, 2);
      this.pUA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131205);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new StringBuilder();
          com.tencent.mm.kernel.h.baC();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.b.aZR()).append(",").append(FindMContactInviteUI.this.getClass().getName()).append(",R300_400_AddAllButton,");
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R300_300_AddAllButton") + ",3");
          if (FindMContactInviteUI.d(FindMContactInviteUI.this) == 2)
          {
            FindMContactInviteUI.b(FindMContactInviteUI.this).hM(true);
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
              FindMContactInviteUI.b(FindMContactInviteUI.this).hM(true);
              FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
              FindMContactInviteUI.h(FindMContactInviteUI.this);
            }
            else
            {
              FindMContactInviteUI.b(FindMContactInviteUI.this).hM(true);
              FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
              FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(8);
              if (FindMContactInviteUI.f(FindMContactInviteUI.this) != null) {
                FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(0);
              }
            }
          }
        }
      });
      if (this.pUz != null)
      {
        this.pUz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131206);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(0);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(8);
            FindMContactInviteUI.b(FindMContactInviteUI.this).hM(false);
            FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131206);
          }
        });
        this.pUz.setVisibility(8);
      }
      this.pRl.addHeaderView(this.pUv);
      this.pRl.setAdapter(this.pUu);
      this.pRl.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      this.pRl.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(131207);
          if (FindMContactInviteUI.b(FindMContactInviteUI.this) != null)
          {
            paramAnonymousView = FindMContactInviteUI.b(FindMContactInviteUI.this);
            if (paramAnonymousView.pSE != null) {
              paramAnonymousView.pSE.B(paramAnonymousMotionEvent);
            }
          }
          AppMethodBeat.o(131207);
          return false;
        }
      });
      addTextOptionMenu(0, getString(a.g.app_finish), new MenuItem.OnMenuItemClickListener()
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = FindMContactInviteUI.i(FindMContactInviteUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131209);
        }
      });
      AppMethodBeat.o(131220);
      return;
      this.pUv = LayoutInflater.from(this).inflate(a.d.find_mcontact_header, null);
      this.pUw = ((TextView)this.pUv.findViewById(a.c.findmcontact_count));
      this.pUx = ((TextView)this.pUv.findViewById(a.c.findmcontact_tip));
      this.pUy = ((TextView)this.pUv.findViewById(a.c.find_mcontact_title));
      this.pUA = ((Button)this.pUv.findViewById(a.c.find_mcontact_addall));
      this.pUx.setText(getString(a.g.find_mcontact_invite_your_friend));
      this.pUy.setText(getString(a.g.find_mcontact_invite_friend));
      this.pUA.setText(getString(a.g.find_mcontact_invite_all, new Object[] { Integer.valueOf(0) }));
      this.pUz = ((TextView)this.pUv.findViewById(a.c.mobile_all_unselect));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131213);
    super.onCreate(paramBundle);
    setMMTitle(a.g.find_mcontact_invite_title);
    com.tencent.mm.plugin.account.sdk.a.pFo.aDA();
    this.pUF = getIntent().getStringExtra("regsetinfo_ticket");
    this.loginType = getIntent().getIntExtra("login_type", 0);
    this.pPV = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.pQb = com.tencent.mm.plugin.b.a.chY();
    initView();
    AppMethodBeat.o(131213);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131219);
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.h.aZW().b(432, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    if (this.pUu != null)
    {
      f localf = this.pUu;
      if (localf.pSE != null)
      {
        localf.pSE.detach();
        localf.pSE = null;
      }
    }
    ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).clearFriendData();
    super.onDestroy();
    AppMethodBeat.o(131219);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(131214);
    if (paramInt == 4)
    {
      bWj();
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
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R300_400_QQ") + ",2");
      AppMethodBeat.o(131218);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R300_400_phone,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R300_400_phone") + ",2");
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
        bXE();
        AppMethodBeat.o(131221);
        return;
      }
      this.pUC = false;
      k.a(this, getString(a.g.permission_contacts_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(131199);
          com.tencent.mm.pluginsdk.permission.b.lx(FindMContactInviteUI.this.getContext());
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
    this.pUu.notifyDataSetChanged();
    StringBuilder localStringBuilder;
    if (this.loginType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("R300_400_QQ") + ",1");
    }
    while (this.pUC)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null);
      Log.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
      if (!bool)
      {
        AppMethodBeat.o(131216);
        return;
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.baC();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R300_400_phone,");
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("R300_400_phone") + ",1");
      }
      else
      {
        bXE();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI
 * JD-Core Version:    0.7.0.1
 */