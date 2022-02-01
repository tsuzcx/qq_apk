package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;

@Deprecated
public class FacebookFriendUI
  extends MMActivity
  implements e.a, com.tencent.mm.ak.g
{
  private ProgressDialog fts = null;
  private ListView iIZ;
  private View iJb;
  String iJd;
  private TextView iJe = null;
  private boolean iNn = false;
  d iQG;
  
  private void bQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(127977);
    h.a(this, paramString2, paramString1, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(127961);
        Object localObject = new Intent(FacebookFriendUI.this.getContext(), FacebookAuthUI.class);
        ((Intent)localObject).putExtra("is_force_unbind", true);
        paramAnonymousDialogInterface = FacebookFriendUI.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        FacebookFriendUI.this.finish();
        AppMethodBeat.o(127961);
      }
    }, null);
    AppMethodBeat.o(127977);
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(127978);
    this.iQG.notifyDataSetChanged();
    AppMethodBeat.o(127978);
  }
  
  public int getLayoutId()
  {
    return 2131493996;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127975);
    this.iIZ = ((ListView)findViewById(2131302352));
    this.iJe = ((TextView)findViewById(2131299463));
    this.iJe.setText(2131758791);
    Object localObject1 = (TextView)findViewById(2131299468);
    ((TextView)localObject1).setText(2131758789);
    Object localObject2 = new r((byte)0);
    ((r)localObject2).ITM = new r.b()
    {
      public final boolean Ga(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Gb(String paramAnonymousString)
      {
        AppMethodBeat.i(127958);
        FacebookFriendUI.a(FacebookFriendUI.this, bs.aLh(paramAnonymousString));
        paramAnonymousString = FacebookFriendUI.this;
        if (paramAnonymousString.iQG != null) {
          paramAnonymousString.iQG.FZ(paramAnonymousString.iJd);
        }
        AppMethodBeat.o(127958);
      }
      
      public final void aPa() {}
      
      public final void aPb() {}
      
      public final void aPc() {}
      
      public final void aPd() {}
    };
    addSearchMenu(true, (r)localObject2);
    this.iQG = new d(this, new r.a()
    {
      public final void aPg()
      {
        AppMethodBeat.i(127962);
        if ((u.axZ()) && (FacebookFriendUI.a(FacebookFriendUI.this)))
        {
          if (FacebookFriendUI.b(FacebookFriendUI.this).getCount() != 0) {
            break label56;
          }
          this.iQI.setVisibility(0);
        }
        for (;;)
        {
          FacebookFriendUI.c(FacebookFriendUI.this);
          AppMethodBeat.o(127962);
          return;
          label56:
          this.iQI.setVisibility(8);
        }
      }
    });
    this.iQG.iQC = new d.a()
    {
      public final void qL(int paramAnonymousInt)
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
    this.iIZ.setAdapter(this.iQG);
    this.iJb = findViewById(2131302353);
    this.iIZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(127964);
        paramAnonymousAdapterView = (com.tencent.mm.plugin.account.friend.a.g)FacebookFriendUI.b(FacebookFriendUI.this).getItem(paramAnonymousInt - FacebookFriendUI.e(FacebookFriendUI.this).getHeaderViewsCount());
        if ((paramAnonymousAdapterView.status == 100) || (paramAnonymousAdapterView.status == 101))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.getUsername());
          paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.getNickName());
          paramAnonymousView.putExtra("Contact_KFacebookId", paramAnonymousAdapterView.exN);
          paramAnonymousView.putExtra("Contact_KFacebookName", paramAnonymousAdapterView.aPw());
          paramAnonymousView.putExtra("Contact_Scene", 31);
          com.tencent.mm.plugin.account.a.a.iyx.c(paramAnonymousView, FacebookFriendUI.this);
        }
        if (paramAnonymousAdapterView.status == 102)
        {
          AppMethodBeat.o(127964);
          return;
        }
        AppMethodBeat.o(127964);
      }
    });
    ac.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + u.axZ());
    if (u.axZ())
    {
      this.iIZ.setVisibility(0);
      this.iJb.setVisibility(8);
      long l = bs.g((Long)com.tencent.mm.kernel.g.agR().agA().get(65831, null));
      localObject1 = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(65830, null));
      if ((bs.Ap(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        localObject2 = new c(getString(2131758773));
        ((c)localObject2).aRc((String)localObject1);
        new j((c)localObject2, new k()
        {
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(127966);
            super.onError(paramAnonymousInt, paramAnonymousString);
            if (paramAnonymousInt == 3) {
              FacebookFriendUI.f(FacebookFriendUI.this);
            }
            AppMethodBeat.o(127966);
          }
          
          public final void w(Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(127965);
            super.w(paramAnonymousBundle);
            AppMethodBeat.o(127965);
          }
        }).aOY();
      }
      localObject1 = new ad();
      ((ad)localObject1).aPQ();
      localObject2 = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(127967);
          com.tencent.mm.kernel.g.agR().agA().set(65829, Integer.valueOf(1));
          com.tencent.mm.kernel.g.agi().a(this.iQJ, 0);
          AppMethodBeat.o(127967);
          return false;
        }
      }, false);
      if (bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(65829, null)) > 0)
      {
        com.tencent.mm.kernel.g.agR().agA().set(65829, Integer.valueOf(1));
        com.tencent.mm.kernel.g.agi().a((n)localObject1, 0);
        AppCompatActivity localAppCompatActivity = getContext();
        getString(2131755906);
        this.fts = h.b(localAppCompatActivity, getString(2131762072), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(127968);
            this.iQK.stopTimer();
            com.tencent.mm.kernel.g.agi().a(this.iQJ);
            AppMethodBeat.o(127968);
          }
        });
        addTextOptionMenu(0, getString(2131759084), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(127969);
            paramAnonymousMenuItem = FacebookFriendUI.this;
            Object localObject = new Intent(FacebookFriendUI.this, InviteFacebookFriendsUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$8", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$8", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
          paramAnonymousView = FacebookFriendUI.e(FacebookFriendUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(127960);
        }
      });
      AppMethodBeat.o(127975);
      return;
      ((au)localObject2).au(5000L, 5000L);
      break;
      this.iIZ.setVisibility(8);
      this.iJb.setVisibility(0);
      ((TextView)findViewById(2131302354)).setText(2131759040);
      this.iJb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(127970);
          paramAnonymousView = FacebookFriendUI.this;
          Object localObject = new Intent(FacebookFriendUI.this, FacebookAuthUI.class);
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(127970);
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127971);
    super.onCreate(paramBundle);
    setMMTitle(2131759083);
    com.tencent.mm.kernel.g.agi().a(32, this);
    initView();
    AppMethodBeat.o(127971);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127974);
    com.tencent.mm.kernel.g.agi().b(32, this);
    this.iQG.cVi();
    super.onDestroy();
    AppMethodBeat.o(127974);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127973);
    super.onPause();
    p.aBh().e(this);
    AppMethodBeat.o(127973);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127972);
    super.onResume();
    p.aBh().d(this);
    this.iQG.notifyDataSetChanged();
    AppMethodBeat.o(127972);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127976);
    ac.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() != 32)
    {
      AppMethodBeat.o(127976);
      return;
    }
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramn = paramString;
      if (bs.isNullOrNil(paramString)) {
        paramn = "error";
      }
      bQ(getString(2131755906), paramn);
      AppMethodBeat.o(127976);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.iQG.a(null, null);
      AppMethodBeat.o(127976);
      return;
    }
    Toast.makeText(this, 2131761250, 0).show();
    AppMethodBeat.o(127976);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI
 * JD-Core Version:    0.7.0.1
 */