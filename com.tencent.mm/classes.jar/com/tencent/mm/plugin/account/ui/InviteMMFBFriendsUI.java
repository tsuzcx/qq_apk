package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.i.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.model.aa;
import com.tencent.mm.plugin.account.friend.model.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.mmfb.sdk.e;
import com.tencent.mm.ui.mmfb.sdk.f.a;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.mm.ui.x.a;
import java.util.ArrayList;
import java.util.List;

public class InviteMMFBFriendsUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private ProgressDialog lzP = null;
  private ListView pRl;
  private View pRn;
  String pRp;
  private com.tencent.mm.ui.mmfb.sdk.f pWC;
  InviteMMFBFriendsUI.a qap;
  private final int recommendType = 5;
  
  private void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(305015);
    com.tencent.mm.ui.base.k.a(this, paramString2, paramString1, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(305264);
        Object localObject = new Intent(InviteMMFBFriendsUI.this.getContext(), MMFBAuthUI.class);
        ((Intent)localObject).putExtra("is_force_unbind", true);
        paramAnonymousDialogInterface = InviteMMFBFriendsUI.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/InviteMMFBFriendsUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/InviteMMFBFriendsUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        InviteMMFBFriendsUI.this.finish();
        AppMethodBeat.o(305264);
      }
    }, null);
    AppMethodBeat.o(305015);
  }
  
  public int getLayoutId()
  {
    return r.g.fb_friend;
  }
  
  public void initView()
  {
    AppMethodBeat.i(305028);
    this.pRl = ((ListView)findViewById(r.f.mobile_friend_lv));
    Object localObject1 = (TextView)findViewById(r.f.empty_msg_tip_tv);
    ((TextView)localObject1).setText(r.j.facebook_empty_friend_tip);
    Object localObject2 = new com.tencent.mm.ui.tools.s(true);
    ((com.tencent.mm.ui.tools.s)localObject2).afKz = new s.c()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(305262);
        InviteMMFBFriendsUI.a(InviteMMFBFriendsUI.this, Util.escapeSqlValue(paramAnonymousString));
        paramAnonymousString = InviteMMFBFriendsUI.this;
        if (paramAnonymousString.qap != null)
        {
          InviteMMFBFriendsUI.a locala = paramAnonymousString.qap;
          locala.pQS = Util.escapeSqlValue(paramAnonymousString.pRp.trim());
          locala.fSd();
          locala.aNy();
        }
        AppMethodBeat.o(305262);
      }
      
      public final void bWw() {}
      
      public final void bWx() {}
      
      public final void bWy() {}
      
      public final void bWz() {}
    };
    addSearchMenu(true, (com.tencent.mm.ui.tools.s)localObject2);
    this.qap = new InviteMMFBFriendsUI.a(this, new x.a()
    {
      public final void bWC()
      {
        AppMethodBeat.i(305236);
        if (z.bBz())
        {
          if (InviteMMFBFriendsUI.a(InviteMMFBFriendsUI.this).getCount() == 0)
          {
            this.qar.setVisibility(0);
            AppMethodBeat.o(305236);
            return;
          }
          this.qar.setVisibility(8);
        }
        AppMethodBeat.o(305236);
      }
    });
    this.pRl.setAdapter(this.qap);
    this.pRn = findViewById(r.f.mobile_friend_mobile_not_bind_ll);
    this.pRl.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(305238);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/InviteMMFBFriendsUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (InviteMMFBFriendsUI.a(InviteMMFBFriendsUI.this).bYa().length >= 50)
        {
          com.tencent.mm.ui.base.k.s(InviteMMFBFriendsUI.this, r.j.facebook_invitefriends_tips_max, r.j.app_tip);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteMMFBFriendsUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(305238);
          return;
        }
        InviteMMFBFriendsUI.a(InviteMMFBFriendsUI.this).yv(paramAnonymousInt - InviteMMFBFriendsUI.b(InviteMMFBFriendsUI.this).getHeaderViewsCount());
        if (InviteMMFBFriendsUI.a(InviteMMFBFriendsUI.this).bYa().length > 0) {
          InviteMMFBFriendsUI.this.showOptionMenu(true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteMMFBFriendsUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(305238);
          return;
          InviteMMFBFriendsUI.this.showOptionMenu(false);
        }
      }
    });
    Log.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + z.bBz());
    if (z.bBz())
    {
      this.pRl.setVisibility(0);
      this.pRn.setVisibility(8);
      long l = Util.nullAsNil((Long)com.tencent.mm.kernel.h.baE().ban().d(65831, null));
      localObject1 = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(65830, null));
      if ((Util.milliSecondsToNow(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        this.pWC = new com.tencent.mm.ui.mmfb.sdk.f();
        this.pWC.bCk((String)localObject1);
        new com.tencent.mm.plugin.account.model.j(this.pWC, new com.tencent.mm.plugin.account.model.k()
        {
          public final void T(Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(305233);
            super.T(paramAnonymousBundle);
            AppMethodBeat.o(305233);
          }
          
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(305234);
            super.onError(paramAnonymousInt, paramAnonymousString);
            if (paramAnonymousInt == 3) {
              InviteMMFBFriendsUI.c(InviteMMFBFriendsUI.this);
            }
            AppMethodBeat.o(305234);
          }
        }).bWu();
      }
      localObject1 = new aa();
      ((aa)localObject1).bXk();
      localObject2 = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(305235);
          com.tencent.mm.kernel.h.baE().ban().B(65829, Integer.valueOf(1));
          com.tencent.mm.kernel.h.aZW().a(this.qas, 0);
          AppMethodBeat.o(305235);
          return false;
        }
      }, false);
      if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(65829, null)) <= 0) {
        break label443;
      }
      com.tencent.mm.kernel.h.baE().ban().B(65829, Integer.valueOf(1));
      com.tencent.mm.kernel.h.aZW().a((p)localObject1, 0);
    }
    for (;;)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(r.j.app_tip);
      this.lzP = com.tencent.mm.ui.base.k.a(localAppCompatActivity, getString(r.j.qq_friend_loading), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(305245);
          this.qat.stopTimer();
          com.tencent.mm.kernel.h.aZW().a(this.qas);
          AppMethodBeat.o(305245);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(305249);
          InviteMMFBFriendsUI.this.hideVKB();
          InviteMMFBFriendsUI.this.finish();
          AppMethodBeat.o(305249);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305244);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/InviteMMFBFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = InviteMMFBFriendsUI.b(InviteMMFBFriendsUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/account/ui/InviteMMFBFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/account/ui/InviteMMFBFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteMMFBFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(305244);
        }
      });
      addTextOptionMenu(0, getString(r.j.facebook_invitefriends_sendinvite), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(305009);
          com.tencent.mm.ui.mmfb.sdk.f localf = new com.tencent.mm.ui.mmfb.sdk.f();
          Bundle localBundle = new Bundle();
          localBundle.putString("message", InviteMMFBFriendsUI.this.getString(r.j.facebook_invite_message));
          final long[] arrayOfLong = InviteMMFBFriendsUI.a(InviteMMFBFriendsUI.this).bYa();
          paramAnonymousMenuItem = Long.toString(arrayOfLong[0]);
          int i = 1;
          while (i < arrayOfLong.length)
          {
            paramAnonymousMenuItem = paramAnonymousMenuItem + ",";
            paramAnonymousMenuItem = paramAnonymousMenuItem + Long.toString(arrayOfLong[i]);
            i += 1;
          }
          localBundle.putString("to", paramAnonymousMenuItem);
          localf.a(InviteMMFBFriendsUI.this, "apprequests", localBundle, new f.a()
          {
            public final void T(Bundle paramAnonymous2Bundle)
            {
              AppMethodBeat.i(305118);
              Log.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
              paramAnonymous2Bundle = new ArrayList();
              paramAnonymous2Bundle.add(new i.a(33, Integer.toString(arrayOfLong.length)));
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new i(paramAnonymous2Bundle));
              paramAnonymous2Bundle = arrayOfLong;
              int j = paramAnonymous2Bundle.length;
              int i = 0;
              while (i < j)
              {
                long l = paramAnonymous2Bundle[i];
                m localm = new m();
                localm.username = Long.toString(l);
                localm.pSV = 5;
                localm.hdp = ((int)Util.nowSecond());
                com.tencent.mm.plugin.account.b.getInviteFriendOpenStg().b(localm);
                i += 1;
              }
              com.tencent.mm.ui.base.k.a(InviteMMFBFriendsUI.this, r.j.facebook_invitefriends_tips_invitemore, r.j.app_tip, r.j.app_yes, r.j.app_no, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(305179);
                  InviteMMFBFriendsUI.a(InviteMMFBFriendsUI.this).aNy();
                  AppMethodBeat.o(305179);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(305169);
                  InviteMMFBFriendsUI.this.finish();
                  AppMethodBeat.o(305169);
                }
              });
              AppMethodBeat.o(305118);
            }
            
            public final void a(e paramAnonymous2e)
            {
              AppMethodBeat.i(305114);
              Log.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
              AppMethodBeat.o(305114);
            }
            
            public final void a(com.tencent.mm.ui.mmfb.sdk.h paramAnonymous2h)
            {
              AppMethodBeat.i(305112);
              Log.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
              AppMethodBeat.o(305112);
            }
            
            public final void onCancel()
            {
              AppMethodBeat.i(305119);
              Log.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
              AppMethodBeat.o(305119);
            }
          });
          AppMethodBeat.o(305009);
          return true;
        }
      });
      showOptionMenu(false);
      AppMethodBeat.o(305028);
      return;
      label443:
      ((MTimerHandler)localObject2).startTimer(5000L);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305023);
    super.onCreate(paramBundle);
    setMMTitle(r.j.facebook_invitefriends_title);
    com.tencent.mm.kernel.h.aZW().a(32, this);
    initView();
    AppMethodBeat.o(305023);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(305025);
    com.tencent.mm.kernel.h.aZW().b(32, this);
    this.qap.fSd();
    if (this.pWC != null) {
      this.pWC.cf(this);
    }
    super.onDestroy();
    AppMethodBeat.o(305025);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(305030);
    Log.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramp.getType() != 32)
    {
      AppMethodBeat.o(305030);
      return;
    }
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramp = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramp = "error";
      }
      cv(getString(r.j.app_tip), paramp);
      AppMethodBeat.o(305030);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.qap.onNotifyChange(null, null);
      AppMethodBeat.o(305030);
      return;
    }
    Toast.makeText(this, r.j.mobile_friend_err, 0).show();
    AppMethodBeat.o(305030);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteMMFBFriendsUI
 * JD-Core Version:    0.7.0.1
 */