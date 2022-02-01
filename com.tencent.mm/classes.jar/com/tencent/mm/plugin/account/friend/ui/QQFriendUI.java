package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qc.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.a.c;
import com.tencent.mm.plugin.account.friend.a.af;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.j;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;

public class QQFriendUI
  extends MMActivity
  implements i
{
  private int adT;
  private ProgressDialog gtM = null;
  private s gzP;
  private ListView kde;
  String kdi;
  private TextView kdj = null;
  d khq;
  private boolean khr = false;
  
  public int getLayoutId()
  {
    return 2131495993;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131285);
    this.kde = ((ListView)findViewById(2131306335));
    this.kdj = ((TextView)findViewById(2131300098));
    this.kdj.setText(2131764102);
    this.gzP = new s((byte)0);
    this.gzP.Qwi = new s.b()
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
        if (paramAnonymousString.khq != null) {
          paramAnonymousString.khq.SM(paramAnonymousString.kdi);
        }
        AppMethodBeat.o(131275);
      }
      
      public final void bnA() {}
      
      public final void bnB() {}
      
      public final void bny() {}
      
      public final void bnz() {}
    };
    addSearchMenu(true, this.gzP);
    String str;
    int i;
    if (com.tencent.mm.model.a.g.aWT().KR("2") != null)
    {
      str = com.tencent.mm.model.a.g.aWT().KR("2").value;
      if (str.equals("0"))
      {
        i = 0;
        com.tencent.mm.model.a.f.KV("2");
      }
    }
    for (;;)
    {
      if (i == 0) {}
      for (this.khq = new e(this, this.adT);; this.khq = new f(this, this.adT))
      {
        this.khq.a(new d.a()
        {
          public final void ve(int paramAnonymousInt)
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
        this.kde.setAdapter(this.khq);
        this.kde.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(131277);
            Object localObject1 = new b();
            ((b)localObject1).bm(paramAnonymousAdapterView);
            ((b)localObject1).bm(paramAnonymousView);
            ((b)localObject1).pH(paramAnonymousInt);
            ((b)localObject1).zo(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject1).axR());
            if (paramAnonymousInt < QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount())
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(131277);
              return;
            }
            paramAnonymousInt -= QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount();
            Log.i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount()) });
            paramAnonymousView = (com.tencent.mm.plugin.account.friend.a.as)QQFriendUI.d(QQFriendUI.this).getItem(paramAnonymousInt);
            if (QQFriendUI.this.getIntent().getBooleanExtra("qqgroup_sendmessage", false))
            {
              paramAnonymousAdapterView = new qc();
              paramAnonymousAdapterView.dWm.opType = 0;
              paramAnonymousAdapterView.dWm.dWo = (paramAnonymousView.kfN + "@qqim");
              paramAnonymousAdapterView.dWm.dWp = paramAnonymousView.getDisplayName();
              EventCenter.instance.publish(paramAnonymousAdapterView);
              if (paramAnonymousAdapterView.dWn.dFE)
              {
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("Chat_User", paramAnonymousView.kfN + "@qqim");
                paramAnonymousAdapterView.putExtra("key_need_send_video", false);
                com.tencent.mm.plugin.account.a.a.jRt.d(paramAnonymousAdapterView, QQFriendUI.this);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(131277);
              return;
              if ((paramAnonymousView.kfO == 1) || (paramAnonymousView.kfO == 2))
              {
                paramAnonymousAdapterView = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramAnonymousView.getUsername());
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.gBM())) {
                  com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, paramAnonymousView.getUsername() + ",12");
                }
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("Contact_User", paramAnonymousView.getUsername());
                ((Intent)localObject1).putExtra("Contact_Nick", paramAnonymousView.getNickname());
                ((Intent)localObject1).putExtra("Contact_Uin", paramAnonymousView.kfN);
                ((Intent)localObject1).putExtra("Contact_QQNick", paramAnonymousView.getDisplayName());
                ((Intent)localObject1).putExtra("Contact_Scene", 12);
                ((Intent)localObject1).putExtra("Contact_RemarkName", paramAnonymousView.boz());
                paramAnonymousAdapterView = (k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg();
                Object localObject2 = paramAnonymousView.getUsername();
                localObject2 = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + Util.escapeSqlValue(String.valueOf(localObject2)) + "\"";
                localObject2 = paramAnonymousAdapterView.iFy.rawQuery((String)localObject2, null, 2);
                if (localObject2 == null) {
                  paramAnonymousAdapterView = null;
                }
                for (;;)
                {
                  if (paramAnonymousAdapterView != null) {
                    ((Intent)localObject1).putExtra("Contact_Sex", paramAnonymousAdapterView.fuA);
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
                    paramAnonymousAdapterView = new j();
                    paramAnonymousAdapterView.username = ((Cursor)localObject2).getString(0);
                    paramAnonymousAdapterView.fuA = ((Cursor)localObject2).getInt(1);
                    paramAnonymousAdapterView.fuI = ((Cursor)localObject2).getInt(2);
                    paramAnonymousAdapterView.fuJ = ((Cursor)localObject2).getString(3);
                    paramAnonymousAdapterView.fuK = ((Cursor)localObject2).getString(4);
                    paramAnonymousAdapterView.signature = ((Cursor)localObject2).getString(5);
                  }
                  ((Cursor)localObject2).close();
                }
                com.tencent.mm.plugin.account.a.a.jRt.c((Intent)localObject1, QQFriendUI.this);
              }
              else if (paramAnonymousView.kfO == 0)
              {
                paramAnonymousAdapterView = new Intent(QQFriendUI.this, InviteFriendUI.class);
                paramAnonymousAdapterView.putExtra("friend_type", 0);
                paramAnonymousAdapterView.putExtra("friend_user_name", paramAnonymousView.getUsername());
                paramAnonymousAdapterView.putExtra("friend_num", paramAnonymousView.kfN);
                paramAnonymousAdapterView.putExtra("friend_nick", paramAnonymousView.getDisplayName());
                paramAnonymousAdapterView.putExtra("friend_weixin_nick", paramAnonymousView.getNickname());
                paramAnonymousAdapterView.putExtra("friend_scene", 12);
                paramAnonymousView = QQFriendUI.this;
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.axQ(), "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          }
        });
        ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).add(this.khq);
        setBackBtn(new QQFriendUI.5(this));
        setToTop(new QQFriendUI.6(this));
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
    Log.d("MicroMsg.QQFriendUI", "onConfigurationChanged: orientation = " + paramConfiguration.orientation);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(131286);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131280);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.azz().a(143, this);
    paramBundle = getIntent().getStringExtra("qqgroup_name");
    this.adT = getIntent().getIntExtra("qqgroup_id", -1);
    Object localObject1 = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
    int i = this.adT;
    Log.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
    Object localObject2 = "update qqlist set reserved4=0 where groupid=".concat(String.valueOf(i));
    ((at)localObject1).iFy.execSQL("qqlist", (String)localObject2);
    if (com.tencent.mm.plugin.account.friend.a.l.vh(this.adT))
    {
      localObject1 = new af(this.adT);
      com.tencent.mm.kernel.g.azz().a((q)localObject1, 0);
      localObject2 = getContext();
      getString(2131755998);
      this.gtM = com.tencent.mm.ui.base.h.a((Context)localObject2, getString(2131764090), true, new QQFriendUI.1(this, (af)localObject1));
    }
    setMMTitle(paramBundle);
    initView();
    AppMethodBeat.o(131280);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131282);
    com.tencent.mm.model.a.f.KW("2");
    ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).remove(this.khq);
    com.tencent.mm.kernel.g.azz().b(143, this);
    this.khq.ebf();
    p.aYD().cancel();
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
    p.aYn().e(this.khq);
    super.onPause();
    AppMethodBeat.o(131283);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131281);
    super.onResume();
    p.aYn().d(this.khq);
    this.khq.notifyDataSetChanged();
    AppMethodBeat.o(131281);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(131287);
    Log.i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((bte)((af)paramq).rr.iLK.iLR).him != 1)
    {
      AppMethodBeat.o(131287);
      return;
    }
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.khq.anp();
      AppMethodBeat.o(131287);
      return;
    }
    Toast.makeText(this, 2131764089, 0).show();
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