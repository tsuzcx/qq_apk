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
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.g.a.ne.b;
import com.tencent.mm.plugin.account.friend.a.ac;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.q;

public class QQFriendUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private int TR;
  private ProgressDialog eeN = null;
  private q eiV;
  private ListView gvV;
  String gvZ;
  private TextView gwa = null;
  d gzW;
  private boolean gzX = false;
  
  public int getLayoutId()
  {
    return 2130970477;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108624);
    this.gvV = ((ListView)findViewById(2131826871));
    this.gwa = ((TextView)findViewById(2131826872));
    this.gwa.setText(2131302204);
    this.eiV = new q((byte)0);
    this.eiV.Axg = new QQFriendUI.2(this);
    addSearchMenu(true, this.eiV);
    String str;
    int i;
    if (com.tencent.mm.model.a.g.abw().pL("2") != null)
    {
      str = com.tencent.mm.model.a.g.abw().pL("2").value;
      if (str.equals("0"))
      {
        i = 0;
        com.tencent.mm.model.a.f.pP("2");
      }
    }
    for (;;)
    {
      if (i == 0) {}
      for (this.gzW = new e(this, this.TR);; this.gzW = new f(this, this.TR))
      {
        this.gzW.a(new QQFriendUI.3(this));
        this.gvV.setAdapter(this.gzW);
        this.gvV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(108616);
            if (paramAnonymousInt < QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount())
            {
              AppMethodBeat.o(108616);
              return;
            }
            paramAnonymousInt -= QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount();
            ab.i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(QQFriendUI.c(QQFriendUI.this).getHeaderViewsCount()) });
            paramAnonymousView = (ao)QQFriendUI.d(QQFriendUI.this).getItem(paramAnonymousInt);
            if (QQFriendUI.this.getIntent().getBooleanExtra("qqgroup_sendmessage", false))
            {
              paramAnonymousAdapterView = new ne();
              paramAnonymousAdapterView.cDp.opType = 0;
              paramAnonymousAdapterView.cDp.cDr = (paramAnonymousView.gyE + "@qqim");
              paramAnonymousAdapterView.cDp.cDs = paramAnonymousView.getDisplayName();
              com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousAdapterView);
              if (paramAnonymousAdapterView.cDq.cpz)
              {
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("Chat_User", paramAnonymousView.gyE + "@qqim");
                paramAnonymousAdapterView.putExtra("key_need_send_video", false);
                com.tencent.mm.plugin.account.a.a.gmO.d(paramAnonymousAdapterView, QQFriendUI.this);
              }
              AppMethodBeat.o(108616);
              return;
            }
            if ((paramAnonymousView.gyF == 1) || (paramAnonymousView.gyF == 2))
            {
              paramAnonymousAdapterView = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramAnonymousView.getUsername());
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.dwz())) {
                com.tencent.mm.plugin.report.service.h.qsU.kvStat(10298, paramAnonymousView.getUsername() + ",12");
              }
              Intent localIntent = new Intent();
              localIntent.putExtra("Contact_User", paramAnonymousView.getUsername());
              localIntent.putExtra("Contact_Nick", paramAnonymousView.Hs());
              localIntent.putExtra("Contact_Uin", paramAnonymousView.gyE);
              localIntent.putExtra("Contact_QQNick", paramAnonymousView.getDisplayName());
              localIntent.putExtra("Contact_Scene", 12);
              localIntent.putExtra("Contact_RemarkName", paramAnonymousView.aqP());
              paramAnonymousAdapterView = (k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg();
              Object localObject = paramAnonymousView.getUsername();
              localObject = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + bo.wC(String.valueOf(localObject)) + "\"";
              localObject = paramAnonymousAdapterView.fnw.a((String)localObject, null, 2);
              if (localObject == null) {
                paramAnonymousAdapterView = null;
              }
              for (;;)
              {
                if (paramAnonymousAdapterView != null) {
                  localIntent.putExtra("Contact_Sex", paramAnonymousAdapterView.dqC);
                }
                localIntent.putExtra("Contact_ShowUserName", false);
                if (!bo.isNullOrNil(paramAnonymousView.getUsername())) {
                  break;
                }
                ab.e("MicroMsg.QQFriendUI", "username is null. can't start contact ui. friend is:%s", new Object[] { paramAnonymousView.toString() });
                AppMethodBeat.o(108616);
                return;
                paramAnonymousAdapterView = null;
                if (((Cursor)localObject).moveToFirst())
                {
                  paramAnonymousAdapterView = new com.tencent.mm.plugin.account.friend.a.j();
                  paramAnonymousAdapterView.username = ((Cursor)localObject).getString(0);
                  paramAnonymousAdapterView.dqC = ((Cursor)localObject).getInt(1);
                  paramAnonymousAdapterView.dqL = ((Cursor)localObject).getInt(2);
                  paramAnonymousAdapterView.province = ((Cursor)localObject).getString(3);
                  paramAnonymousAdapterView.city = ((Cursor)localObject).getString(4);
                  paramAnonymousAdapterView.signature = ((Cursor)localObject).getString(5);
                }
                ((Cursor)localObject).close();
              }
              com.tencent.mm.plugin.account.a.a.gmO.c(localIntent, QQFriendUI.this);
              AppMethodBeat.o(108616);
              return;
            }
            if (paramAnonymousView.gyF == 0)
            {
              paramAnonymousAdapterView = new Intent(QQFriendUI.this, InviteFriendUI.class);
              paramAnonymousAdapterView.putExtra("friend_type", 0);
              paramAnonymousAdapterView.putExtra("friend_user_name", paramAnonymousView.getUsername());
              paramAnonymousAdapterView.putExtra("friend_num", paramAnonymousView.gyE);
              paramAnonymousAdapterView.putExtra("friend_nick", paramAnonymousView.getDisplayName());
              paramAnonymousAdapterView.putExtra("friend_weixin_nick", paramAnonymousView.Hs());
              paramAnonymousAdapterView.putExtra("friend_scene", 12);
              QQFriendUI.this.startActivity(paramAnonymousAdapterView);
            }
            AppMethodBeat.o(108616);
          }
        });
        ((ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(this.gzW);
        setBackBtn(new QQFriendUI.5(this));
        setToTop(new QQFriendUI.6(this));
        AppMethodBeat.o(108624);
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
    AppMethodBeat.i(108625);
    ab.d("MicroMsg.QQFriendUI", "onConfigurationChanged: orientation = " + paramConfiguration.orientation);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(108625);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108619);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Rc().a(143, this);
    paramBundle = getIntent().getStringExtra("qqgroup_name");
    this.TR = getIntent().getIntExtra("qqgroup_id", -1);
    Object localObject1 = (ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
    int i = this.TR;
    ab.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
    Object localObject2 = "update qqlist set reserved4=0 where groupid=".concat(String.valueOf(i));
    ((ap)localObject1).fnw.execSQL("qqlist", (String)localObject2);
    if (l.mT(this.TR))
    {
      localObject1 = new ac(this.TR);
      com.tencent.mm.kernel.g.Rc().a((m)localObject1, 0);
      localObject2 = getContext();
      getString(2131297087);
      this.eeN = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131302195), true, new QQFriendUI.1(this, (ac)localObject1));
    }
    setMMTitle(paramBundle);
    initView();
    AppMethodBeat.o(108619);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108621);
    com.tencent.mm.model.a.f.pQ("2");
    ((ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.gzW);
    com.tencent.mm.kernel.g.Rc().b(143, this);
    this.gzW.bKb();
    o.adi().cancel();
    super.onDestroy();
    AppMethodBeat.o(108621);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(108623);
    ab.v("MicroMsg.QQFriendUI", "qq friend onKeyDown");
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(108623);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(108622);
    o.acQ().e(this.gzW);
    super.onPause();
    AppMethodBeat.o(108622);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(108620);
    super.onResume();
    o.acQ().d(this.gzW);
    this.gzW.notifyDataSetChanged();
    AppMethodBeat.o(108620);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(108626);
    ab.i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((aon)((ac)paramm).rr.fsV.fta).nrS != 1)
    {
      AppMethodBeat.o(108626);
      return;
    }
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.gzW.Ku();
      AppMethodBeat.o(108626);
      return;
    }
    Toast.makeText(this, 2131302194, 0).show();
    AppMethodBeat.o(108626);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.QQFriendUI
 * JD-Core Version:    0.7.0.1
 */