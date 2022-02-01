package com.tencent.mm.plugin.account.friend.ui;

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
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.sp;
import com.tencent.mm.autogen.a.sp.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.model.ac;
import com.tencent.mm.plugin.account.friend.model.ap;
import com.tencent.mm.plugin.account.friend.model.aq;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.s.c;

public class QQFriendUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private int kW;
  private com.tencent.mm.ui.tools.s lMw;
  private ProgressDialog lzP = null;
  private ListView pRl;
  String pRp;
  private TextView pRq = null;
  d pVx;
  private boolean pVy = false;
  
  public int getLayoutId()
  {
    return a.d.qq_friend;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131285);
    this.pRl = ((ListView)findViewById(a.c.qq_friend_lv));
    this.pRq = ((TextView)findViewById(a.c.empty_qq_search_tip_tv));
    this.pRq.setText(a.g.qq_search_no_friend);
    this.lMw = new com.tencent.mm.ui.tools.s(true);
    this.lMw.afKz = new s.c()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(131275);
        QQFriendUI.a(QQFriendUI.this, Util.escapeSqlValue(paramAnonymousString));
        QQFriendUI.a(QQFriendUI.this, true);
        paramAnonymousString = QQFriendUI.this;
        if (paramAnonymousString.pVx != null) {
          paramAnonymousString.pVx.SM(paramAnonymousString.pRp);
        }
        AppMethodBeat.o(131275);
      }
      
      public final void bWw() {}
      
      public final void bWx() {}
      
      public final void bWy() {}
      
      public final void bWz() {}
    };
    addSearchMenu(true, this.lMw);
    String str;
    int i;
    if (com.tencent.mm.model.a.g.bDR().Km("2") != null)
    {
      str = com.tencent.mm.model.a.g.bDR().Km("2").value;
      if (str.equals("0"))
      {
        i = 0;
        com.tencent.mm.model.a.f.Kq("2");
      }
    }
    for (;;)
    {
      if (i == 0) {}
      for (this.pVx = new e(this, this.kW);; this.pVx = new f(this, this.kW))
      {
        this.pVx.a(new d.a()
        {
          public final void yo(int paramAnonymousInt)
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
        this.pRl.setAdapter(this.pVx);
        this.pRl.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(131277);
            Object localObject1 = new b();
            ((b)localObject1).cH(paramAnonymousAdapterView);
            ((b)localObject1).cH(paramAnonymousView);
            ((b)localObject1).sc(paramAnonymousInt);
            ((b)localObject1).hB(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject1).aYj());
            if (paramAnonymousInt < QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount())
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(131277);
              return;
            }
            paramAnonymousInt -= QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount();
            Log.i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount()) });
            paramAnonymousView = (ap)QQFriendUI.d(QQFriendUI.this).getItem(paramAnonymousInt);
            if (QQFriendUI.this.getIntent().getBooleanExtra("qqgroup_sendmessage", false))
            {
              paramAnonymousAdapterView = new sp();
              paramAnonymousAdapterView.hVM.opType = 0;
              paramAnonymousAdapterView.hVM.hVO = (paramAnonymousView.pTU + "@qqim");
              paramAnonymousAdapterView.hVM.hVP = paramAnonymousView.getDisplayName();
              paramAnonymousAdapterView.publish();
              if (paramAnonymousAdapterView.hVN.hCQ)
              {
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("Chat_User", paramAnonymousView.pTU + "@qqim");
                paramAnonymousAdapterView.putExtra("key_need_send_video", false);
                com.tencent.mm.plugin.account.sdk.a.pFn.d(paramAnonymousAdapterView, QQFriendUI.this);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(131277);
              return;
              if ((paramAnonymousView.pTV == 1) || (paramAnonymousView.pTV == 2))
              {
                paramAnonymousAdapterView = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramAnonymousView.getUsername());
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.iZC())) {
                  com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramAnonymousView.getUsername() + ",12");
                }
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("Contact_User", paramAnonymousView.getUsername());
                ((Intent)localObject1).putExtra("Contact_Nick", paramAnonymousView.getNickname());
                ((Intent)localObject1).putExtra("Contact_Uin", paramAnonymousView.pTU);
                ((Intent)localObject1).putExtra("Contact_QQNick", paramAnonymousView.getDisplayName());
                ((Intent)localObject1).putExtra("Contact_Scene", 12);
                ((Intent)localObject1).putExtra("Contact_RemarkName", paramAnonymousView.bXw());
                paramAnonymousAdapterView = (com.tencent.mm.plugin.account.friend.model.h)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getFrdExtStg();
                Object localObject2 = paramAnonymousView.getUsername();
                localObject2 = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + Util.escapeSqlValue(String.valueOf(localObject2)) + "\"";
                localObject2 = paramAnonymousAdapterView.omV.rawQuery((String)localObject2, null, 2);
                if (localObject2 == null) {
                  paramAnonymousAdapterView = null;
                }
                for (;;)
                {
                  if (paramAnonymousAdapterView != null) {
                    ((Intent)localObject1).putExtra("Contact_Sex", paramAnonymousAdapterView.sex);
                  }
                  ((Intent)localObject1).putExtra("Contact_ShowUserName", false);
                  if (!Util.isNullOrNil(paramAnonymousView.getUsername())) {
                    break;
                  }
                  Log.e("MicroMsg.QQFriendUI", "username is null. can't start contact ui. friend is:%s", new Object[] { paramAnonymousView.toString() });
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                  AppMethodBeat.o(131277);
                  return;
                  paramAnonymousAdapterView = null;
                  if (((Cursor)localObject2).moveToFirst())
                  {
                    paramAnonymousAdapterView = new com.tencent.mm.plugin.account.friend.model.g();
                    paramAnonymousAdapterView.username = ((Cursor)localObject2).getString(0);
                    paramAnonymousAdapterView.sex = ((Cursor)localObject2).getInt(1);
                    paramAnonymousAdapterView.kag = ((Cursor)localObject2).getInt(2);
                    paramAnonymousAdapterView.province = ((Cursor)localObject2).getString(3);
                    paramAnonymousAdapterView.city = ((Cursor)localObject2).getString(4);
                    paramAnonymousAdapterView.signature = ((Cursor)localObject2).getString(5);
                  }
                  ((Cursor)localObject2).close();
                }
                com.tencent.mm.plugin.account.sdk.a.pFn.c((Intent)localObject1, QQFriendUI.this);
              }
              else if (paramAnonymousView.pTV == 0)
              {
                paramAnonymousAdapterView = new Intent(QQFriendUI.this, InviteFriendUI.class);
                paramAnonymousAdapterView.putExtra("friend_type", 0);
                paramAnonymousAdapterView.putExtra("friend_user_name", paramAnonymousView.getUsername());
                paramAnonymousAdapterView.putExtra("friend_num", paramAnonymousView.pTU);
                paramAnonymousAdapterView.putExtra("friend_nick", paramAnonymousView.getDisplayName());
                paramAnonymousAdapterView.putExtra("friend_weixin_nick", paramAnonymousView.getNickname());
                paramAnonymousAdapterView.putExtra("friend_scene", 12);
                paramAnonymousView = QQFriendUI.this;
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousAdapterView.aYi(), "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          }
        });
        ((aq)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).add(this.pVx);
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
            Object localObject = new b();
            ((b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
            paramAnonymousView = QQFriendUI.c(QQFriendUI.this);
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
            localObject = new Object();
            com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131279);
          }
        });
        AppMethodBeat.o(131285);
        return;
        if (!str.equals("1")) {
          break label265;
        }
        i = 1;
        break;
      }
      label265:
      i = 1;
      break;
      i = 1;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(131286);
    Log.d("MicroMsg.QQFriendUI", "onConfigurationChanged: orientation = " + paramConfiguration.orientation);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(131286);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131280);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(143, this);
    paramBundle = getIntent().getStringExtra("qqgroup_name");
    this.kW = getIntent().getIntExtra("qqgroup_id", -1);
    Object localObject1 = (aq)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg();
    int i = this.kW;
    Log.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
    Object localObject2 = "update qqlist set reserved4=0 where groupid=".concat(String.valueOf(i));
    ((aq)localObject1).omV.execSQL("qqlist", (String)localObject2);
    if (i.yr(this.kW))
    {
      localObject1 = new ac(this.kW);
      com.tencent.mm.kernel.h.aZW().a((p)localObject1, 0);
      localObject2 = getContext();
      getString(a.g.app_tip);
      this.lzP = k.a((Context)localObject2, getString(a.g.qq_friend_loading), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131274);
          com.tencent.mm.kernel.h.aZW().a(this.pVz);
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
    com.tencent.mm.model.a.f.Kr("2");
    ((aq)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).remove(this.pVx);
    com.tencent.mm.kernel.h.aZW().b(143, this);
    this.pVx.fSd();
    q.bFG().cancel();
    super.onDestroy();
    AppMethodBeat.o(131282);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(131284);
    Log.v("MicroMsg.QQFriendUI", "qq friend onKeyDown");
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(131284);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(131283);
    q.bFp().e(this.pVx);
    super.onPause();
    AppMethodBeat.o(131283);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131281);
    super.onResume();
    q.bFp().d(this.pVx);
    this.pVx.notifyDataSetChanged();
    AppMethodBeat.o(131281);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(131287);
    Log.i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((cqf)c.b.b(((ac)paramp).rr.otB)).muC != 1)
    {
      AppMethodBeat.o(131287);
      return;
    }
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.pVx.aNy();
      AppMethodBeat.o(131287);
      return;
    }
    Toast.makeText(this, a.g.qq_friend_load_err, 0).show();
    AppMethodBeat.o(131287);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.QQFriendUI
 * JD-Core Version:    0.7.0.1
 */