package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.i.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.List;

public class FindMContactInviteUI
  extends MMWizardActivity
{
  private TextView emptyTipTv;
  private ProgressDialog iXX;
  private int loginType;
  private int mTo;
  private String mTu;
  private ListView mUE;
  private com.tencent.mm.plugin.account.friend.a.i mXM;
  private View mXN;
  private TextView mXO;
  private TextView mXP;
  private TextView mXQ;
  private TextView mXR;
  private Button mXS;
  private List<String[]> mXT;
  private boolean mXU;
  private i.a mXV;
  private String mXX;
  private com.tencent.mm.an.i onSceneEndCallback;
  
  public FindMContactInviteUI()
  {
    AppMethodBeat.i(131212);
    this.iXX = null;
    this.emptyTipTv = null;
    this.mXO = null;
    this.mXP = null;
    this.mXQ = null;
    this.mXR = null;
    this.mXS = null;
    this.mXX = null;
    this.onSceneEndCallback = null;
    this.mTo = 2;
    this.mXU = true;
    this.mXV = new i.a()
    {
      public final void notifyDataSetChanged()
      {
        AppMethodBeat.i(131204);
        if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 2) && (FindMContactInviteUI.d(FindMContactInviteUI.this) == 1))
        {
          FindMContactInviteUI.e(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getString(a.g.find_mcontact_invite_all_continue));
          if (!FindMContactInviteUI.b(FindMContactInviteUI.this).bye()) {
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
  
  private void bxv()
  {
    AppMethodBeat.i(131215);
    com.tencent.mm.plugin.b.a.bkD(this.mTu);
    hideVKB();
    atX(1);
    AppMethodBeat.o(131215);
  }
  
  private void byQ()
  {
    AppMethodBeat.i(131217);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(a.g.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(a.g.mobile_friend_loading), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    com.tencent.mm.kernel.h.aHJ().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(131202);
        try
        {
          FindMContactInviteUI.a(FindMContactInviteUI.this, com.tencent.mm.pluginsdk.b.dN(FindMContactInviteUI.this));
          FindMContactInviteUI.b(FindMContactInviteUI.this).mTs = FindMContactInviteUI.c(FindMContactInviteUI.this);
          FindMContactInviteUI.b(FindMContactInviteUI.this).t(((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getFriendData());
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
    this.mUE = ((ListView)findViewById(a.c.mobile_friend_lv));
    if ((this.mTo != 2) && (this.mTo == 1))
    {
      this.mXN = LayoutInflater.from(this).inflate(a.d.find_mcontact_header_style_two, null);
      this.mXO = ((TextView)this.mXN.findViewById(a.c.findmcontact_count));
      this.mXP = ((TextView)this.mXN.findViewById(a.c.findmcontact_tip));
      this.mXQ = ((TextView)this.mXN.findViewById(a.c.find_mcontact_title));
      this.mXS = ((Button)this.mXN.findViewById(a.c.find_mcontact_addall));
      this.mXP.setText(getString(a.g.find_mcontact_invite_friend));
      this.mXQ.setText(getString(a.g.find_mcontact_invite_friend));
      this.mXS.setText(getString(a.g.find_mcontact_invite_all_continue));
    }
    for (;;)
    {
      this.mXM = new com.tencent.mm.plugin.account.friend.a.i(this, this.mXV, 2);
      this.mXS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131205);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new StringBuilder();
          com.tencent.mm.kernel.h.aHE();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.b.aGR()).append(",").append(FindMContactInviteUI.this.getClass().getName()).append(",R300_400_AddAllButton,");
          com.tencent.mm.kernel.h.aHE();
          com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R300_300_AddAllButton") + ",3");
          if (FindMContactInviteUI.d(FindMContactInviteUI.this) == 2)
          {
            FindMContactInviteUI.b(FindMContactInviteUI.this).gW(true);
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
              FindMContactInviteUI.b(FindMContactInviteUI.this).gW(true);
              FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
              FindMContactInviteUI.h(FindMContactInviteUI.this);
            }
            else
            {
              FindMContactInviteUI.b(FindMContactInviteUI.this).gW(true);
              FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
              FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(8);
              if (FindMContactInviteUI.f(FindMContactInviteUI.this) != null) {
                FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(0);
              }
            }
          }
        }
      });
      if (this.mXR != null)
      {
        this.mXR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131206);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(0);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(8);
            FindMContactInviteUI.b(FindMContactInviteUI.this).gW(false);
            FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131206);
          }
        });
        this.mXR.setVisibility(8);
      }
      this.mUE.addHeaderView(this.mXN);
      this.mUE.setAdapter(this.mXM);
      this.mUE.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      this.mUE.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(131207);
          if (FindMContactInviteUI.b(FindMContactInviteUI.this) != null)
          {
            paramAnonymousView = FindMContactInviteUI.b(FindMContactInviteUI.this);
            if (paramAnonymousView.mVX != null) {
              paramAnonymousView.mVX.B(paramAnonymousMotionEvent);
            }
          }
          AppMethodBeat.o(131207);
          return false;
        }
      });
      addTextOptionMenu(0, getString(a.g.app_finish), new FindMContactInviteUI.10(this));
      setToTop(new FindMContactInviteUI.11(this));
      AppMethodBeat.o(131220);
      return;
      this.mXN = LayoutInflater.from(this).inflate(a.d.find_mcontact_header, null);
      this.mXO = ((TextView)this.mXN.findViewById(a.c.findmcontact_count));
      this.mXP = ((TextView)this.mXN.findViewById(a.c.findmcontact_tip));
      this.mXQ = ((TextView)this.mXN.findViewById(a.c.find_mcontact_title));
      this.mXS = ((Button)this.mXN.findViewById(a.c.find_mcontact_addall));
      this.mXP.setText(getString(a.g.find_mcontact_invite_your_friend));
      this.mXQ.setText(getString(a.g.find_mcontact_invite_friend));
      this.mXS.setText(getString(a.g.find_mcontact_invite_all, new Object[] { Integer.valueOf(0) }));
      this.mXR = ((TextView)this.mXN.findViewById(a.c.mobile_all_unselect));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131213);
    super.onCreate(paramBundle);
    setMMTitle(a.g.find_mcontact_invite_title);
    com.tencent.mm.plugin.account.sdk.a.mIH.abF();
    this.mXX = getIntent().getStringExtra("regsetinfo_ticket");
    this.loginType = getIntent().getIntExtra("login_type", 0);
    this.mTo = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.mTu = com.tencent.mm.plugin.b.a.bAt();
    initView();
    AppMethodBeat.o(131213);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131219);
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.h.aGY().b(432, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    if (this.mXM != null)
    {
      com.tencent.mm.plugin.account.friend.a.i locali = this.mXM;
      if (locali.mVX != null)
      {
        locali.mVX.detach();
        locali.mVX = null;
      }
    }
    ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).clearFriendData();
    super.onDestroy();
    AppMethodBeat.o(131219);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(131214);
    if (paramInt == 4)
    {
      bxv();
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
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R300_400_QQ") + ",2");
      AppMethodBeat.o(131218);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R300_400_phone,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R300_400_phone") + ",2");
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
        byQ();
        AppMethodBeat.o(131221);
        return;
      }
      this.mXU = false;
      com.tencent.mm.ui.base.h.a(this, getString(a.g.permission_contacts_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.app_cancel), false, new FindMContactInviteUI.3(this), new FindMContactInviteUI.4(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131216);
    super.onResume();
    this.mXM.notifyDataSetChanged();
    StringBuilder localStringBuilder;
    if (this.loginType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("R300_400_QQ") + ",1");
    }
    while (this.mXU)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
      Log.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
      if (!bool)
      {
        AppMethodBeat.o(131216);
        return;
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R300_400_phone,");
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("R300_400_phone") + ",1");
      }
      else
      {
        byQ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI
 * JD-Core Version:    0.7.0.1
 */