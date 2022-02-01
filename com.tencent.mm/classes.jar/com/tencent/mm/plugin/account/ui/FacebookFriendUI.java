package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
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
import com.tencent.mm.am.f.a;
import com.tencent.mm.an.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.ui.tools.t.b;
import com.tencent.mm.ui.v.a;

@Deprecated
public class FacebookFriendUI
  extends MMActivity
  implements f.a, i
{
  private ProgressDialog iXX = null;
  private ListView mUE;
  private View mUG;
  String mUI;
  private TextView mUJ = null;
  private boolean mYQ = false;
  e ncG;
  
  private void ch(String paramString1, String paramString2)
  {
    AppMethodBeat.i(127977);
    com.tencent.mm.ui.base.h.a(this, paramString2, paramString1, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(127961);
        Object localObject = new Intent(FacebookFriendUI.this.getContext(), FacebookAuthUI.class);
        ((Intent)localObject).putExtra("is_force_unbind", true);
        paramAnonymousDialogInterface = FacebookFriendUI.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        FacebookFriendUI.this.finish();
        AppMethodBeat.o(127961);
      }
    }, null);
    AppMethodBeat.o(127977);
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(127978);
    this.ncG.notifyDataSetChanged();
    AppMethodBeat.o(127978);
  }
  
  public int getLayoutId()
  {
    return r.g.fb_friend;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127975);
    this.mUE = ((ListView)findViewById(r.f.mobile_friend_lv));
    this.mUJ = ((TextView)findViewById(r.f.empty_facebook_friend_search_tip_tv));
    this.mUJ.setText(r.j.facebook_friend_search_no_friend);
    Object localObject1 = (TextView)findViewById(r.f.empty_msg_tip_tv);
    ((TextView)localObject1).setText(r.j.facebook_empty_friend_tip);
    Object localObject2 = new com.tencent.mm.ui.tools.t((byte)0);
    ((com.tencent.mm.ui.tools.t)localObject2).XUl = new t.b()
    {
      public final boolean aat(String paramAnonymousString)
      {
        return false;
      }
      
      public final void aau(String paramAnonymousString)
      {
        AppMethodBeat.i(127958);
        FacebookFriendUI.a(FacebookFriendUI.this, Util.escapeSqlValue(paramAnonymousString));
        paramAnonymousString = FacebookFriendUI.this;
        if (paramAnonymousString.ncG != null) {
          paramAnonymousString.ncG.aas(paramAnonymousString.mUI);
        }
        AppMethodBeat.o(127958);
      }
      
      public final void bxH() {}
      
      public final void bxI() {}
      
      public final void bxJ() {}
      
      public final void bxK() {}
    };
    addSearchMenu(true, (com.tencent.mm.ui.tools.t)localObject2);
    this.ncG = new e(this, new v.a()
    {
      public final void bxN()
      {
        AppMethodBeat.i(127962);
        if ((z.bdH()) && (FacebookFriendUI.a(FacebookFriendUI.this)))
        {
          if (FacebookFriendUI.b(FacebookFriendUI.this).getCount() != 0) {
            break label56;
          }
          this.ncI.setVisibility(0);
        }
        for (;;)
        {
          FacebookFriendUI.c(FacebookFriendUI.this);
          AppMethodBeat.o(127962);
          return;
          label56:
          this.ncI.setVisibility(8);
        }
      }
    });
    this.ncG.ncC = new e.a()
    {
      public final void yi(int paramAnonymousInt)
      {
        AppMethodBeat.i(127963);
        if (paramAnonymousInt > 0)
        {
          FacebookFriendUI.d(FacebookFriendUI.this).setVisibility(8);
          AppMethodBeat.o(127963);
          return;
        }
        FacebookFriendUI.d(FacebookFriendUI.this).setVisibility(0);
        AppMethodBeat.o(127963);
      }
    };
    this.mUE.setAdapter(this.ncG);
    this.mUG = findViewById(r.f.mobile_friend_mobile_not_bind_ll);
    this.mUE.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(127964);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/FacebookFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousAdapterView = (g)FacebookFriendUI.b(FacebookFriendUI.this).getItem(paramAnonymousInt - FacebookFriendUI.e(FacebookFriendUI.this).getHeaderViewsCount());
        if ((paramAnonymousAdapterView.status == 100) || (paramAnonymousAdapterView.status == 101))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.getUsername());
          paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.getNickName());
          paramAnonymousView.putExtra("Contact_KFacebookId", paramAnonymousAdapterView.hDe);
          paramAnonymousView.putExtra("Contact_KFacebookName", paramAnonymousAdapterView.byc());
          paramAnonymousView.putExtra("Contact_Scene", 31);
          com.tencent.mm.plugin.account.sdk.a.mIG.c(paramAnonymousView, FacebookFriendUI.this);
        }
        if (paramAnonymousAdapterView.status == 102)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(127964);
          return;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(127964);
      }
    });
    Log.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + z.bdH());
    if (z.bdH())
    {
      this.mUE.setVisibility(0);
      this.mUG.setVisibility(8);
      long l = Util.nullAsNil((Long)com.tencent.mm.kernel.h.aHG().aHp().b(65831, null));
      localObject1 = Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(65830, null));
      if ((Util.milliSecondsToNow(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        localObject2 = new c(getString(r.j.facebook_app_id));
        ((c)localObject2).bAo((String)localObject1);
        new j((c)localObject2, new k()
        {
          public final void K(Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(127965);
            super.K(paramAnonymousBundle);
            AppMethodBeat.o(127965);
          }
          
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(127966);
            super.onError(paramAnonymousInt, paramAnonymousString);
            if (paramAnonymousInt == 3) {
              FacebookFriendUI.f(FacebookFriendUI.this);
            }
            AppMethodBeat.o(127966);
          }
        }).bxF();
      }
      localObject1 = new ad();
      ((ad)localObject1).byw();
      localObject2 = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(127967);
          com.tencent.mm.kernel.h.aHG().aHp().i(65829, Integer.valueOf(1));
          com.tencent.mm.kernel.h.aGY().a(this.ncJ, 0);
          AppMethodBeat.o(127967);
          return false;
        }
      }, false);
      if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(65829, null)) > 0)
      {
        com.tencent.mm.kernel.h.aHG().aHp().i(65829, Integer.valueOf(1));
        com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
        AppCompatActivity localAppCompatActivity = getContext();
        getString(r.j.app_tip);
        this.iXX = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(r.j.qq_friend_loading), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(127968);
            this.ncK.stopTimer();
            com.tencent.mm.kernel.h.aGY().a(this.ncJ);
            AppMethodBeat.o(127968);
          }
        });
        addTextOptionMenu(0, getString(r.j.find_friends_by_facebook_invite), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(127969);
            paramAnonymousMenuItem = FacebookFriendUI.this;
            Object localObject = new Intent(FacebookFriendUI.this, InviteFacebookFriendsUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$8", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$8", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(127969);
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
          AppMethodBeat.i(127959);
          FacebookFriendUI.this.hideVKB();
          FacebookFriendUI.this.finish();
          AppMethodBeat.o(127959);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(127960);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          paramAnonymousView = FacebookFriendUI.e(FacebookFriendUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(127960);
        }
      });
      AppMethodBeat.o(127975);
      return;
      ((MTimerHandler)localObject2).startTimer(5000L);
      break;
      this.mUE.setVisibility(8);
      this.mUG.setVisibility(0);
      ((TextView)findViewById(r.f.mobile_friend_mobile_not_bind_tv)).setText(r.j.fb_friend_not_bind);
      this.mUG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(127970);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/FacebookFriendUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          paramAnonymousView = FacebookFriendUI.this;
          localObject = new Intent(FacebookFriendUI.this, FacebookAuthUI.class);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(127970);
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127971);
    super.onCreate(paramBundle);
    setMMTitle(r.j.find_friends_by_facebook);
    com.tencent.mm.kernel.h.aGY().a(32, this);
    initView();
    AppMethodBeat.o(127971);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127974);
    com.tencent.mm.kernel.h.aGY().b(32, this);
    this.ncG.eKd();
    super.onDestroy();
    AppMethodBeat.o(127974);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127973);
    super.onPause();
    com.tencent.mm.am.q.bhz().e(this);
    AppMethodBeat.o(127973);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127972);
    super.onResume();
    com.tencent.mm.am.q.bhz().d(this);
    this.ncG.notifyDataSetChanged();
    AppMethodBeat.o(127972);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(127976);
    Log.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() != 32)
    {
      AppMethodBeat.o(127976);
      return;
    }
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = "error";
      }
      ch(getString(r.j.app_tip), paramq);
      AppMethodBeat.o(127976);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.ncG.onNotifyChange(null, null);
      AppMethodBeat.o(127976);
      return;
    }
    Toast.makeText(this, r.j.mobile_friend_err, 0).show();
    AppMethodBeat.o(127976);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI
 * JD-Core Version:    0.7.0.1
 */