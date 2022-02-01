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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.account.friend.model.aa;
import com.tencent.mm.plugin.account.friend.model.d;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.mm.ui.x.a;

@Deprecated
public class MMFBFriendUI
  extends MMActivity
  implements com.tencent.mm.am.h, AvatarStorage.a
{
  private ProgressDialog lzP = null;
  private ListView pRl;
  private View pRn;
  String pRp;
  private TextView pRq = null;
  private boolean pVy = false;
  private com.tencent.mm.ui.mmfb.sdk.f pWC;
  g qbT;
  
  private void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(305107);
    com.tencent.mm.ui.base.k.a(this, paramString2, paramString1, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(305109);
        Object localObject = new Intent(MMFBFriendUI.this.getContext(), MMFBAuthUI.class);
        ((Intent)localObject).putExtra("is_force_unbind", true);
        paramAnonymousDialogInterface = MMFBFriendUI.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/MMFBFriendUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/MMFBFriendUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        MMFBFriendUI.this.finish();
        AppMethodBeat.o(305109);
      }
    }, null);
    AppMethodBeat.o(305107);
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(305162);
    this.qbT.notifyDataSetChanged();
    AppMethodBeat.o(305162);
  }
  
  public int getLayoutId()
  {
    return r.g.fb_friend;
  }
  
  public void initView()
  {
    AppMethodBeat.i(305154);
    this.pRl = ((ListView)findViewById(r.f.mobile_friend_lv));
    this.pRq = ((TextView)findViewById(r.f.empty_facebook_friend_search_tip_tv));
    this.pRq.setText(r.j.facebook_friend_search_no_friend);
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
        AppMethodBeat.i(305115);
        MMFBFriendUI.a(MMFBFriendUI.this, Util.escapeSqlValue(paramAnonymousString));
        paramAnonymousString = MMFBFriendUI.this;
        if (paramAnonymousString.qbT != null) {
          paramAnonymousString.qbT.SM(paramAnonymousString.pRp);
        }
        AppMethodBeat.o(305115);
      }
      
      public final void bWw() {}
      
      public final void bWx() {}
      
      public final void bWy() {}
      
      public final void bWz() {}
    };
    addSearchMenu(true, (com.tencent.mm.ui.tools.s)localObject2);
    this.qbT = new g(this, new x.a()
    {
      public final void bWC()
      {
        AppMethodBeat.i(305111);
        if ((z.bBz()) && (MMFBFriendUI.a(MMFBFriendUI.this)))
        {
          if (MMFBFriendUI.b(MMFBFriendUI.this).getCount() != 0) {
            break label56;
          }
          this.qar.setVisibility(0);
        }
        for (;;)
        {
          MMFBFriendUI.c(MMFBFriendUI.this);
          AppMethodBeat.o(305111);
          return;
          label56:
          this.qar.setVisibility(8);
        }
      }
    });
    this.qbT.qbP = new g.a()
    {
      public final void yo(int paramAnonymousInt)
      {
        AppMethodBeat.i(305113);
        if (paramAnonymousInt > 0)
        {
          MMFBFriendUI.d(MMFBFriendUI.this).setVisibility(8);
          AppMethodBeat.o(305113);
          return;
        }
        MMFBFriendUI.d(MMFBFriendUI.this).setVisibility(0);
        AppMethodBeat.o(305113);
      }
    };
    this.pRl.setAdapter(this.qbT);
    this.pRn = findViewById(r.f.mobile_friend_mobile_not_bind_ll);
    this.pRl.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(305140);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MMFBFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = (d)MMFBFriendUI.b(MMFBFriendUI.this).getItem(paramAnonymousInt - MMFBFriendUI.e(MMFBFriendUI.this).getHeaderViewsCount());
        if ((paramAnonymousAdapterView.status == 100) || (paramAnonymousAdapterView.status == 101))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.getUsername());
          paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.getNickName());
          paramAnonymousView.putExtra("Contact_KFacebookId", paramAnonymousAdapterView.kaa);
          paramAnonymousView.putExtra("Contact_KFacebookName", paramAnonymousAdapterView.bWR());
          paramAnonymousView.putExtra("Contact_Scene", 31);
          com.tencent.mm.plugin.account.sdk.a.pFn.c(paramAnonymousView, MMFBFriendUI.this);
        }
        if (paramAnonymousAdapterView.status == 102)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MMFBFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(305140);
          return;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MMFBFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(305140);
      }
    });
    Log.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + z.bBz());
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
        new j(this.pWC, new com.tencent.mm.plugin.account.model.k()
        {
          public final void T(Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(305144);
            super.T(paramAnonymousBundle);
            AppMethodBeat.o(305144);
          }
          
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(305146);
            super.onError(paramAnonymousInt, paramAnonymousString);
            if (paramAnonymousInt == 3) {
              MMFBFriendUI.f(MMFBFriendUI.this);
            }
            AppMethodBeat.o(305146);
          }
        }).bWu();
      }
      localObject1 = new aa();
      ((aa)localObject1).bXk();
      localObject2 = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(305151);
          com.tencent.mm.kernel.h.baE().ban().B(65829, Integer.valueOf(1));
          com.tencent.mm.kernel.h.aZW().a(this.qas, 0);
          AppMethodBeat.o(305151);
          return false;
        }
      }, false);
      if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(65829, null)) > 0)
      {
        com.tencent.mm.kernel.h.baE().ban().B(65829, Integer.valueOf(1));
        com.tencent.mm.kernel.h.aZW().a((p)localObject1, 0);
        AppCompatActivity localAppCompatActivity = getContext();
        getString(r.j.app_tip);
        this.lzP = com.tencent.mm.ui.base.k.a(localAppCompatActivity, getString(r.j.qq_friend_loading), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(304951);
            this.qat.stopTimer();
            com.tencent.mm.kernel.h.aZW().a(this.qas);
            AppMethodBeat.o(304951);
          }
        });
        addTextOptionMenu(0, getString(r.j.find_friends_by_facebook_invite), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(304957);
            paramAnonymousMenuItem = MMFBFriendUI.this;
            Object localObject = new Intent(MMFBFriendUI.this, InviteMMFBFriendsUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/MMFBFriendUI$8", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/account/ui/MMFBFriendUI$8", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(304957);
            return true;
          }
        });
      }
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(305117);
          MMFBFriendUI.this.hideVKB();
          MMFBFriendUI.this.finish();
          AppMethodBeat.o(305117);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305108);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MMFBFriendUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          paramAnonymousView = MMFBFriendUI.e(MMFBFriendUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/account/ui/MMFBFriendUI$11", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/account/ui/MMFBFriendUI$11", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MMFBFriendUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(305108);
        }
      });
      AppMethodBeat.o(305154);
      return;
      ((MTimerHandler)localObject2).startTimer(5000L);
      break;
      this.pRl.setVisibility(8);
      this.pRn.setVisibility(0);
      ((TextView)findViewById(r.f.mobile_friend_mobile_not_bind_tv)).setText(r.j.fb_friend_not_bind);
      this.pRn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(304944);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MMFBFriendUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          paramAnonymousView = MMFBFriendUI.this;
          localObject = new Intent(MMFBFriendUI.this, MMFBAuthUI.class);
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/MMFBFriendUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/ui/MMFBFriendUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MMFBFriendUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(304944);
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305128);
    super.onCreate(paramBundle);
    setMMTitle(r.j.find_friends_by_facebook);
    com.tencent.mm.kernel.h.aZW().a(32, this);
    initView();
    AppMethodBeat.o(305128);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(305142);
    com.tencent.mm.kernel.h.aZW().b(32, this);
    this.qbT.fSd();
    super.onDestroy();
    if (this.pWC != null) {
      this.pWC.cf(this);
    }
    AppMethodBeat.o(305142);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(305139);
    super.onPause();
    q.bFp().e(this);
    AppMethodBeat.o(305139);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(305132);
    super.onResume();
    q.bFp().d(this);
    this.qbT.notifyDataSetChanged();
    AppMethodBeat.o(305132);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(305157);
    Log.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramp.getType() != 32)
    {
      AppMethodBeat.o(305157);
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
      AppMethodBeat.o(305157);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.qbT.onNotifyChange(null, null);
      AppMethodBeat.o(305157);
      return;
    }
    Toast.makeText(this, r.j.mobile_friend_err, 0).show();
    AppMethodBeat.o(305157);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MMFBFriendUI
 * JD-Core Version:    0.7.0.1
 */