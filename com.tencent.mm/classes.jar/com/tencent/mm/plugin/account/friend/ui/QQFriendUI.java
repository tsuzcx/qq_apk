package com.tencent.mm.plugin.account.friend.ui;

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
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.mj;
import com.tencent.mm.h.a.mj.b;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.ac;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.protocal.c.ajg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.n;
import com.tencent.mm.ui.tools.n.b;

public class QQFriendUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private int Th;
  private ProgressDialog dnm = null;
  private n drn;
  private ListView fem;
  String feq;
  private TextView fer = null;
  d fip;
  private boolean fiq = false;
  
  protected final int getLayoutId()
  {
    return a.e.qq_friend;
  }
  
  protected final void initView()
  {
    this.fem = ((ListView)findViewById(a.d.qq_friend_lv));
    this.fer = ((TextView)findViewById(a.d.empty_qq_search_tip_tv));
    this.fer.setText(a.h.qq_search_no_friend);
    this.drn = new n((byte)0);
    this.drn.weq = new n.b()
    {
      public final void Wl() {}
      
      public final void Wm() {}
      
      public final void Wn() {}
      
      public final void Wo() {}
      
      public final boolean pB(String paramAnonymousString)
      {
        return false;
      }
      
      public final void pC(String paramAnonymousString)
      {
        QQFriendUI.a(QQFriendUI.this, bk.pl(paramAnonymousString));
        QQFriendUI.a(QQFriendUI.this, true);
        paramAnonymousString = QQFriendUI.this;
        if (paramAnonymousString.fip != null) {
          paramAnonymousString.fip.pA(paramAnonymousString.feq);
        }
      }
    };
    a(this.drn);
    String str;
    int i;
    if (com.tencent.mm.model.a.g.Iy().iX("2") != null)
    {
      str = com.tencent.mm.model.a.g.Iy().iX("2").value;
      if (str.equals("0"))
      {
        i = 0;
        com.tencent.mm.model.a.f.jb("2");
      }
    }
    for (;;)
    {
      if (i == 0) {}
      for (this.fip = new e(this, this.Th);; this.fip = new f(this, this.Th))
      {
        this.fip.a(new QQFriendUI.3(this));
        this.fem.setAdapter(this.fip);
        this.fem.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            paramAnonymousAdapterView = null;
            if (paramAnonymousInt < QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount()) {}
            do
            {
              return;
              paramAnonymousInt -= QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount();
              y.i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount()) });
              paramAnonymousView = (ao)QQFriendUI.d(QQFriendUI.this).getItem(paramAnonymousInt);
              if (!QQFriendUI.this.getIntent().getBooleanExtra("qqgroup_sendmessage", false)) {
                break;
              }
              paramAnonymousAdapterView = new mj();
              paramAnonymousAdapterView.bVE.opType = 0;
              paramAnonymousAdapterView.bVE.bVG = (paramAnonymousView.fgW + "@qqim");
              paramAnonymousAdapterView.bVE.bVH = paramAnonymousView.getDisplayName();
              com.tencent.mm.sdk.b.a.udP.m(paramAnonymousAdapterView);
            } while (!paramAnonymousAdapterView.bVF.bIe);
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("Chat_User", paramAnonymousView.fgW + "@qqim");
            paramAnonymousAdapterView.putExtra("key_need_send_video", false);
            com.tencent.mm.plugin.account.a.a.eUR.e(paramAnonymousAdapterView, QQFriendUI.this);
            return;
            Object localObject1;
            Object localObject2;
            if ((paramAnonymousView.fgX == 1) || (paramAnonymousView.fgX == 2))
            {
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramAnonymousView.getUsername());
              if ((localObject1 != null) && (((ad)localObject1).cua())) {
                com.tencent.mm.plugin.report.service.h.nFQ.aC(10298, paramAnonymousView.getUsername() + ",12");
              }
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("Contact_User", paramAnonymousView.getUsername());
              ((Intent)localObject1).putExtra("Contact_Nick", paramAnonymousView.vm());
              ((Intent)localObject1).putExtra("Contact_Uin", paramAnonymousView.fgW);
              ((Intent)localObject1).putExtra("Contact_QQNick", paramAnonymousView.getDisplayName());
              ((Intent)localObject1).putExtra("Contact_Scene", 12);
              ((Intent)localObject1).putExtra("Contact_RemarkName", paramAnonymousView.Xl());
              localObject2 = (k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg();
              String str = paramAnonymousView.getUsername();
              str = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + bk.pl(str) + "\"";
              localObject2 = ((k)localObject2).dXo.a(str, null, 2);
              if (localObject2 == null)
              {
                label461:
                if (paramAnonymousAdapterView != null) {
                  ((Intent)localObject1).putExtra("Contact_Sex", paramAnonymousAdapterView.sex);
                }
                ((Intent)localObject1).putExtra("Contact_ShowUserName", false);
                if (bk.bl(paramAnonymousView.getUsername())) {
                  y.e("MicroMsg.QQFriendUI", "username is null. can't start contact ui. friend is:%s", new Object[] { paramAnonymousView.toString() });
                }
              }
              else
              {
                if (!((Cursor)localObject2).moveToFirst()) {
                  break label744;
                }
                paramAnonymousAdapterView = new com.tencent.mm.plugin.account.friend.a.j();
                paramAnonymousAdapterView.username = ((Cursor)localObject2).getString(0);
                paramAnonymousAdapterView.sex = ((Cursor)localObject2).getInt(1);
                paramAnonymousAdapterView.cCz = ((Cursor)localObject2).getInt(2);
                paramAnonymousAdapterView.cCA = ((Cursor)localObject2).getString(3);
                paramAnonymousAdapterView.cCB = ((Cursor)localObject2).getString(4);
                paramAnonymousAdapterView.signature = ((Cursor)localObject2).getString(5);
              }
            }
            for (;;)
            {
              ((Cursor)localObject2).close();
              break label461;
              com.tencent.mm.plugin.account.a.a.eUR.d((Intent)localObject1, QQFriendUI.this);
              return;
              if (paramAnonymousView.fgX != 0) {
                break;
              }
              paramAnonymousAdapterView = new Intent(QQFriendUI.this, InviteFriendUI.class);
              paramAnonymousAdapterView.putExtra("friend_type", 0);
              paramAnonymousAdapterView.putExtra("friend_user_name", paramAnonymousView.getUsername());
              paramAnonymousAdapterView.putExtra("friend_num", paramAnonymousView.fgW);
              paramAnonymousAdapterView.putExtra("friend_nick", paramAnonymousView.getDisplayName());
              paramAnonymousAdapterView.putExtra("friend_weixin_nick", paramAnonymousView.vm());
              paramAnonymousAdapterView.putExtra("friend_scene", 12);
              QQFriendUI.this.startActivity(paramAnonymousAdapterView);
              return;
              label744:
              paramAnonymousAdapterView = null;
            }
          }
        });
        ((ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(this.fip);
        setBackBtn(new QQFriendUI.5(this));
        new QQFriendUI.6(this);
        return;
        if (!str.equals("1")) {
          break label251;
        }
        i = 1;
        break;
      }
      label251:
      i = 1;
      break;
      i = 1;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    y.d("MicroMsg.QQFriendUI", "onConfigurationChanged: orientation = " + paramConfiguration.orientation);
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Dk().a(143, this);
    paramBundle = getIntent().getStringExtra("qqgroup_name");
    this.Th = getIntent().getIntExtra("qqgroup_id", -1);
    Object localObject1 = (ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
    int i = this.Th;
    y.d("MicroMsg.QQListStorage", "delete: GroupID:" + i);
    Object localObject2 = "update qqlist set reserved4=0 where groupid=" + i;
    ((ap)localObject1).dXo.gk("qqlist", (String)localObject2);
    if (l.jY(this.Th))
    {
      localObject1 = new ac(this.Th);
      com.tencent.mm.kernel.g.Dk().a((com.tencent.mm.ah.m)localObject1, 0);
      localObject2 = this.mController.uMN;
      getString(a.h.app_tip);
      this.dnm = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(a.h.qq_friend_loading), true, new QQFriendUI.1(this, (ac)localObject1));
    }
    setMMTitle(paramBundle);
    initView();
  }
  
  public void onDestroy()
  {
    com.tencent.mm.model.a.f.jc("2");
    ((ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.fip);
    com.tencent.mm.kernel.g.Dk().b(143, this);
    this.fip.bcS();
    o.Kj().cancel();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    y.v("MicroMsg.QQFriendUI", "qq friend onKeyDown");
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    o.JQ().e(this.fip);
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    o.JQ().d(this.fip);
    this.fip.notifyDataSetChanged();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((ajg)((ac)paramm).dmK.ecE.ecN).kTS != 1) {
      return;
    }
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.fip.yc();
      return;
    }
    Toast.makeText(this, a.h.qq_friend_load_err, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.QQFriendUI
 * JD-Core Version:    0.7.0.1
 */