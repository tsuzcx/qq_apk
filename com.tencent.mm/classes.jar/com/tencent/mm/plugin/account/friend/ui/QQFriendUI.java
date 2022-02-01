package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
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
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pj.b;
import com.tencent.mm.model.a.c;
import com.tencent.mm.plugin.account.friend.a.af;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.j;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;

public class QQFriendUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private int adG;
  private ProgressDialog fMu = null;
  private r fSC;
  private ListView jci;
  String jcm;
  private TextView jcn = null;
  d jgv;
  private boolean jgw = false;
  
  public int getLayoutId()
  {
    return 2131495150;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131285);
    this.jci = ((ListView)findViewById(2131303560));
    this.jcn = ((TextView)findViewById(2131299469));
    this.jcn.setText(2131762082);
    this.fSC = new r((byte)0);
    this.fSC.KKQ = new r.b()
    {
      public final boolean Jp(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Jq(String paramAnonymousString)
      {
        AppMethodBeat.i(131275);
        QQFriendUI.a(QQFriendUI.this, bt.aQN(paramAnonymousString));
        QQFriendUI.a(QQFriendUI.this, true);
        paramAnonymousString = QQFriendUI.this;
        if (paramAnonymousString.jgv != null) {
          paramAnonymousString.jgv.Jo(paramAnonymousString.jcm);
        }
        AppMethodBeat.o(131275);
      }
      
      public final void aSm() {}
      
      public final void aSn() {}
      
      public final void aSo() {}
      
      public final void aSp() {}
    };
    addSearchMenu(true, this.fSC);
    String str;
    int i;
    if (com.tencent.mm.model.a.g.aCR().BE("2") != null)
    {
      str = com.tencent.mm.model.a.g.aCR().BE("2").value;
      if (str.equals("0"))
      {
        i = 0;
        com.tencent.mm.model.a.f.BI("2");
      }
    }
    for (;;)
    {
      if (i == 0) {}
      for (this.jgv = new e(this, this.adG);; this.jgv = new f(this, this.adG))
      {
        this.jgv.a(new d.a()
        {
          public final void rl(int paramAnonymousInt)
          {
            AppMethodBeat.i(131276);
            if (QQFriendUI.a(QQFriendUI.this))
            {
              if (paramAnonymousInt <= 0) {
                break label46;
              }
              QQFriendUI.b(QQFriendUI.this).setVisibility(8);
            }
            for (;;)
            {
              QQFriendUI.a(QQFriendUI.this, false);
              AppMethodBeat.o(131276);
              return;
              label46:
              QQFriendUI.b(QQFriendUI.this).setVisibility(0);
            }
          }
        });
        this.jci.setAdapter(this.jgv);
        this.jci.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(131277);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousAdapterView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).mr(paramAnonymousInt);
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).qY(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
            if (paramAnonymousInt < QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount())
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(131277);
              return;
            }
            paramAnonymousInt -= QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount();
            ad.i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount()) });
            paramAnonymousView = (as)QQFriendUI.d(QQFriendUI.this).getItem(paramAnonymousInt);
            if (QQFriendUI.this.getIntent().getBooleanExtra("qqgroup_sendmessage", false))
            {
              paramAnonymousAdapterView = new pj();
              paramAnonymousAdapterView.dDu.opType = 0;
              paramAnonymousAdapterView.dDu.dDw = (paramAnonymousView.jeR + "@qqim");
              paramAnonymousAdapterView.dDu.dDx = paramAnonymousView.getDisplayName();
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousAdapterView);
              if (paramAnonymousAdapterView.dDv.dno)
              {
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("Chat_User", paramAnonymousView.jeR + "@qqim");
                paramAnonymousAdapterView.putExtra("key_need_send_video", false);
                com.tencent.mm.plugin.account.a.a.iRG.d(paramAnonymousAdapterView, QQFriendUI.this);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(131277);
              return;
              if ((paramAnonymousView.jeS == 1) || (paramAnonymousView.jeS == 2))
              {
                paramAnonymousAdapterView = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramAnonymousView.getUsername());
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.fqg())) {
                  com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, paramAnonymousView.getUsername() + ",12");
                }
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("Contact_User", paramAnonymousView.getUsername());
                ((Intent)localObject1).putExtra("Contact_Nick", paramAnonymousView.VC());
                ((Intent)localObject1).putExtra("Contact_Uin", paramAnonymousView.jeR);
                ((Intent)localObject1).putExtra("Contact_QQNick", paramAnonymousView.getDisplayName());
                ((Intent)localObject1).putExtra("Contact_Scene", 12);
                ((Intent)localObject1).putExtra("Contact_RemarkName", paramAnonymousView.aTo());
                paramAnonymousAdapterView = (k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg();
                Object localObject2 = paramAnonymousView.getUsername();
                localObject2 = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + bt.aQN(String.valueOf(localObject2)) + "\"";
                localObject2 = paramAnonymousAdapterView.hHS.a((String)localObject2, null, 2);
                if (localObject2 == null) {
                  paramAnonymousAdapterView = null;
                }
                for (;;)
                {
                  if (paramAnonymousAdapterView != null) {
                    ((Intent)localObject1).putExtra("Contact_Sex", paramAnonymousAdapterView.ePk);
                  }
                  ((Intent)localObject1).putExtra("Contact_ShowUserName", false);
                  if (!bt.isNullOrNil(paramAnonymousView.getUsername())) {
                    break;
                  }
                  ad.e("MicroMsg.QQFriendUI", "username is null. can't start contact ui. friend is:%s", new Object[] { paramAnonymousView.toString() });
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                  AppMethodBeat.o(131277);
                  return;
                  paramAnonymousAdapterView = null;
                  if (((Cursor)localObject2).moveToFirst())
                  {
                    paramAnonymousAdapterView = new j();
                    paramAnonymousAdapterView.username = ((Cursor)localObject2).getString(0);
                    paramAnonymousAdapterView.ePk = ((Cursor)localObject2).getInt(1);
                    paramAnonymousAdapterView.ePt = ((Cursor)localObject2).getInt(2);
                    paramAnonymousAdapterView.ePu = ((Cursor)localObject2).getString(3);
                    paramAnonymousAdapterView.ePv = ((Cursor)localObject2).getString(4);
                    paramAnonymousAdapterView.signature = ((Cursor)localObject2).getString(5);
                  }
                  ((Cursor)localObject2).close();
                }
                com.tencent.mm.plugin.account.a.a.iRG.c((Intent)localObject1, QQFriendUI.this);
              }
              else if (paramAnonymousView.jeS == 0)
              {
                paramAnonymousAdapterView = new Intent(QQFriendUI.this, InviteFriendUI.class);
                paramAnonymousAdapterView.putExtra("friend_type", 0);
                paramAnonymousAdapterView.putExtra("friend_user_name", paramAnonymousView.getUsername());
                paramAnonymousAdapterView.putExtra("friend_num", paramAnonymousView.jeR);
                paramAnonymousAdapterView.putExtra("friend_nick", paramAnonymousView.getDisplayName());
                paramAnonymousAdapterView.putExtra("friend_weixin_nick", paramAnonymousView.VC());
                paramAnonymousAdapterView.putExtra("friend_scene", 12);
                paramAnonymousView = QQFriendUI.this;
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahp(), "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          }
        });
        ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(this.jgv);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(131278);
            QQFriendUI.this.hideVKB();
            QQFriendUI.this.finish();
            AppMethodBeat.o(131278);
            return true;
          }
        });
        setToTop(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131279);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            paramAnonymousView = QQFriendUI.c(QQFriendUI.this);
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
            localObject = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131279);
          }
        });
        AppMethodBeat.o(131285);
        return;
        if (!str.equals("1")) {
          break label262;
        }
        i = 1;
        break;
      }
      label262:
      i = 1;
      break;
      i = 1;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(131286);
    ad.d("MicroMsg.QQFriendUI", "onConfigurationChanged: orientation = " + paramConfiguration.orientation);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(131286);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131280);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aiU().a(143, this);
    paramBundle = getIntent().getStringExtra("qqgroup_name");
    this.adG = getIntent().getIntExtra("qqgroup_id", -1);
    Object localObject1 = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
    int i = this.adG;
    ad.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
    Object localObject2 = "update qqlist set reserved4=0 where groupid=".concat(String.valueOf(i));
    ((at)localObject1).hHS.execSQL("qqlist", (String)localObject2);
    if (com.tencent.mm.plugin.account.friend.a.l.ro(this.adG))
    {
      localObject1 = new af(this.adG);
      com.tencent.mm.kernel.g.aiU().a((n)localObject1, 0);
      localObject2 = getContext();
      getString(2131755906);
      this.fMu = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131762072), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131274);
          com.tencent.mm.kernel.g.aiU().a(this.jgx);
          AppMethodBeat.o(131274);
        }
      });
    }
    setMMTitle(paramBundle);
    initView();
    AppMethodBeat.o(131280);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131282);
    com.tencent.mm.model.a.f.BJ("2");
    ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.jgv);
    com.tencent.mm.kernel.g.aiU().b(143, this);
    this.jgv.det();
    p.aEz().cancel();
    super.onDestroy();
    AppMethodBeat.o(131282);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(131284);
    ad.v("MicroMsg.QQFriendUI", "qq friend onKeyDown");
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(131284);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(131283);
    p.aEk().e(this.jgv);
    super.onPause();
    AppMethodBeat.o(131283);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131281);
    super.onResume();
    p.aEk().d(this.jgv);
    this.jgv.notifyDataSetChanged();
    AppMethodBeat.o(131281);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(131287);
    ad.i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((bgq)((af)paramn).rr.hNK.hNQ).gsV != 1)
    {
      AppMethodBeat.o(131287);
      return;
    }
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jgv.Zu();
      AppMethodBeat.o(131287);
      return;
    }
    Toast.makeText(this, 2131762071, 0).show();
    AppMethodBeat.o(131287);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.QQFriendUI
 * JD-Core Version:    0.7.0.1
 */