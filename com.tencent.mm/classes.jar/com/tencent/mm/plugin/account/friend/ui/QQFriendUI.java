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
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.pa.b;
import com.tencent.mm.model.a.c;
import com.tencent.mm.plugin.account.friend.a.af;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.j;
import com.tencent.mm.protocal.protobuf.bcm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;

public class QQFriendUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private int abP;
  private ProgressDialog fts = null;
  private r fzp;
  private ListView iIZ;
  String iJd;
  private TextView iJe = null;
  d iNm;
  private boolean iNn = false;
  
  public int getLayoutId()
  {
    return 2131495150;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131285);
    this.iIZ = ((ListView)findViewById(2131303560));
    this.iJe = ((TextView)findViewById(2131299469));
    this.iJe.setText(2131762082);
    this.fzp = new r((byte)0);
    this.fzp.ITM = new r.b()
    {
      public final boolean Ga(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Gb(String paramAnonymousString)
      {
        AppMethodBeat.i(131275);
        QQFriendUI.a(QQFriendUI.this, bs.aLh(paramAnonymousString));
        QQFriendUI.a(QQFriendUI.this, true);
        paramAnonymousString = QQFriendUI.this;
        if (paramAnonymousString.iNm != null) {
          paramAnonymousString.iNm.FZ(paramAnonymousString.iJd);
        }
        AppMethodBeat.o(131275);
      }
      
      public final void aPa() {}
      
      public final void aPb() {}
      
      public final void aPc() {}
      
      public final void aPd() {}
    };
    addSearchMenu(true, this.fzp);
    String str;
    int i;
    if (com.tencent.mm.model.a.g.azO().yF("2") != null)
    {
      str = com.tencent.mm.model.a.g.azO().yF("2").value;
      if (str.equals("0"))
      {
        i = 0;
        com.tencent.mm.model.a.f.yJ("2");
      }
    }
    for (;;)
    {
      if (i == 0) {}
      for (this.iNm = new e(this, this.abP);; this.iNm = new f(this, this.abP))
      {
        this.iNm.a(new d.a()
        {
          public final void qL(int paramAnonymousInt)
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
        this.iIZ.setAdapter(this.iNm);
        this.iIZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(131277);
            if (paramAnonymousInt < QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount())
            {
              AppMethodBeat.o(131277);
              return;
            }
            paramAnonymousInt -= QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount();
            ac.i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount()) });
            paramAnonymousView = (as)QQFriendUI.d(QQFriendUI.this).getItem(paramAnonymousInt);
            if (QQFriendUI.this.getIntent().getBooleanExtra("qqgroup_sendmessage", false))
            {
              paramAnonymousAdapterView = new pa();
              paramAnonymousAdapterView.drC.opType = 0;
              paramAnonymousAdapterView.drC.drE = (paramAnonymousView.iLI + "@qqim");
              paramAnonymousAdapterView.drC.drF = paramAnonymousView.getDisplayName();
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousAdapterView);
              if (paramAnonymousAdapterView.drD.dbS)
              {
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("Chat_User", paramAnonymousView.iLI + "@qqim");
                paramAnonymousAdapterView.putExtra("key_need_send_video", false);
                com.tencent.mm.plugin.account.a.a.iyx.d(paramAnonymousAdapterView, QQFriendUI.this);
              }
              AppMethodBeat.o(131277);
              return;
            }
            if ((paramAnonymousView.iLJ == 1) || (paramAnonymousView.iLJ == 2))
            {
              paramAnonymousAdapterView = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramAnonymousView.getUsername());
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.fad())) {
                com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, paramAnonymousView.getUsername() + ",12");
              }
              Intent localIntent = new Intent();
              localIntent.putExtra("Contact_User", paramAnonymousView.getUsername());
              localIntent.putExtra("Contact_Nick", paramAnonymousView.Tn());
              localIntent.putExtra("Contact_Uin", paramAnonymousView.iLI);
              localIntent.putExtra("Contact_QQNick", paramAnonymousView.getDisplayName());
              localIntent.putExtra("Contact_Scene", 12);
              localIntent.putExtra("Contact_RemarkName", paramAnonymousView.aQc());
              paramAnonymousAdapterView = (com.tencent.mm.plugin.account.friend.a.k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg();
              Object localObject = paramAnonymousView.getUsername();
              localObject = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + bs.aLh(String.valueOf(localObject)) + "\"";
              localObject = paramAnonymousAdapterView.hpA.a((String)localObject, null, 2);
              if (localObject == null) {
                paramAnonymousAdapterView = null;
              }
              for (;;)
              {
                if (paramAnonymousAdapterView != null) {
                  localIntent.putExtra("Contact_Sex", paramAnonymousAdapterView.exL);
                }
                localIntent.putExtra("Contact_ShowUserName", false);
                if (!bs.isNullOrNil(paramAnonymousView.getUsername())) {
                  break;
                }
                ac.e("MicroMsg.QQFriendUI", "username is null. can't start contact ui. friend is:%s", new Object[] { paramAnonymousView.toString() });
                AppMethodBeat.o(131277);
                return;
                paramAnonymousAdapterView = null;
                if (((Cursor)localObject).moveToFirst())
                {
                  paramAnonymousAdapterView = new j();
                  paramAnonymousAdapterView.username = ((Cursor)localObject).getString(0);
                  paramAnonymousAdapterView.exL = ((Cursor)localObject).getInt(1);
                  paramAnonymousAdapterView.exU = ((Cursor)localObject).getInt(2);
                  paramAnonymousAdapterView.exV = ((Cursor)localObject).getString(3);
                  paramAnonymousAdapterView.exW = ((Cursor)localObject).getString(4);
                  paramAnonymousAdapterView.signature = ((Cursor)localObject).getString(5);
                }
                ((Cursor)localObject).close();
              }
              com.tencent.mm.plugin.account.a.a.iyx.c(localIntent, QQFriendUI.this);
              AppMethodBeat.o(131277);
              return;
            }
            if (paramAnonymousView.iLJ == 0)
            {
              paramAnonymousAdapterView = new Intent(QQFriendUI.this, InviteFriendUI.class);
              paramAnonymousAdapterView.putExtra("friend_type", 0);
              paramAnonymousAdapterView.putExtra("friend_user_name", paramAnonymousView.getUsername());
              paramAnonymousAdapterView.putExtra("friend_num", paramAnonymousView.iLI);
              paramAnonymousAdapterView.putExtra("friend_nick", paramAnonymousView.getDisplayName());
              paramAnonymousAdapterView.putExtra("friend_weixin_nick", paramAnonymousView.Tn());
              paramAnonymousAdapterView.putExtra("friend_scene", 12);
              paramAnonymousView = QQFriendUI.this;
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.aeD(), "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(131277);
          }
        });
        ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(this.iNm);
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
            paramAnonymousView = QQFriendUI.c(QQFriendUI.this);
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
            Object localObject = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
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
    ac.d("MicroMsg.QQFriendUI", "onConfigurationChanged: orientation = " + paramConfiguration.orientation);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(131286);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131280);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(143, this);
    paramBundle = getIntent().getStringExtra("qqgroup_name");
    this.abP = getIntent().getIntExtra("qqgroup_id", -1);
    Object localObject1 = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
    int i = this.abP;
    ac.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
    Object localObject2 = "update qqlist set reserved4=0 where groupid=".concat(String.valueOf(i));
    ((at)localObject1).hpA.execSQL("qqlist", (String)localObject2);
    if (com.tencent.mm.plugin.account.friend.a.l.qO(this.abP))
    {
      localObject1 = new af(this.abP);
      com.tencent.mm.kernel.g.agi().a((n)localObject1, 0);
      localObject2 = getContext();
      getString(2131755906);
      this.fts = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131762072), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131274);
          com.tencent.mm.kernel.g.agi().a(this.iNo);
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
    com.tencent.mm.model.a.f.yK("2");
    ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.iNm);
    com.tencent.mm.kernel.g.agi().b(143, this);
    this.iNm.cVi();
    p.aBy().cancel();
    super.onDestroy();
    AppMethodBeat.o(131282);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(131284);
    ac.v("MicroMsg.QQFriendUI", "qq friend onKeyDown");
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(131284);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(131283);
    p.aBh().e(this.iNm);
    super.onPause();
    AppMethodBeat.o(131283);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131281);
    super.onResume();
    p.aBh().d(this.iNm);
    this.iNm.notifyDataSetChanged();
    AppMethodBeat.o(131281);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(131287);
    ac.i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((bcm)((af)paramn).rr.hvr.hvw).fZz != 1)
    {
      AppMethodBeat.o(131287);
      return;
    }
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.iNm.Xb();
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