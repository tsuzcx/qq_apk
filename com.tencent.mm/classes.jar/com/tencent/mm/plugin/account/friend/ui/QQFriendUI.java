package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.model.a.c;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.af;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.sdk.a.a;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.t.b;

public class QQFriendUI
  extends MMActivity
  implements i
{
  private ProgressDialog iXX = null;
  private com.tencent.mm.ui.tools.t jjS;
  private int ka;
  private ListView mUE;
  String mUI;
  private TextView mUJ = null;
  d mYP;
  private boolean mYQ = false;
  
  public int getLayoutId()
  {
    return a.d.qq_friend;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131285);
    this.mUE = ((ListView)findViewById(a.c.qq_friend_lv));
    this.mUJ = ((TextView)findViewById(a.c.empty_qq_search_tip_tv));
    this.mUJ.setText(a.g.qq_search_no_friend);
    this.jjS = new com.tencent.mm.ui.tools.t((byte)0);
    this.jjS.XUl = new t.b()
    {
      public final boolean aat(String paramAnonymousString)
      {
        return false;
      }
      
      public final void aau(String paramAnonymousString)
      {
        AppMethodBeat.i(131275);
        QQFriendUI.a(QQFriendUI.this, Util.escapeSqlValue(paramAnonymousString));
        QQFriendUI.a(QQFriendUI.this, true);
        paramAnonymousString = QQFriendUI.this;
        if (paramAnonymousString.mYP != null) {
          paramAnonymousString.mYP.aas(paramAnonymousString.mUI);
        }
        AppMethodBeat.o(131275);
      }
      
      public final void bxH() {}
      
      public final void bxI() {}
      
      public final void bxJ() {}
      
      public final void bxK() {}
    };
    addSearchMenu(true, this.jjS);
    String str;
    int i;
    if (g.bga().Sk("2") != null)
    {
      str = g.bga().Sk("2").value;
      if (str.equals("0"))
      {
        i = 0;
        com.tencent.mm.model.a.f.So("2");
      }
    }
    for (;;)
    {
      if (i == 0) {}
      for (this.mYP = new e(this, this.ka);; this.mYP = new f(this, this.ka))
      {
        this.mYP.a(new d.a()
        {
          public final void yi(int paramAnonymousInt)
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
        this.mUE.setAdapter(this.mYP);
        this.mUE.setOnItemClickListener(new QQFriendUI.4(this));
        ((at)((a)com.tencent.mm.kernel.h.ag(a.class)).getQQListStg()).add(this.mYP);
        setBackBtn(new QQFriendUI.5(this));
        setToTop(new QQFriendUI.6(this));
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
    com.tencent.mm.kernel.h.aGY().a(143, this);
    paramBundle = getIntent().getStringExtra("qqgroup_name");
    this.ka = getIntent().getIntExtra("qqgroup_id", -1);
    Object localObject1 = (at)((a)com.tencent.mm.kernel.h.ag(a.class)).getQQListStg();
    int i = this.ka;
    Log.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
    Object localObject2 = "update qqlist set reserved4=0 where groupid=".concat(String.valueOf(i));
    ((at)localObject1).lvy.execSQL("qqlist", (String)localObject2);
    if (l.yl(this.ka))
    {
      localObject1 = new af(this.ka);
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
      localObject2 = getContext();
      getString(a.g.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a((Context)localObject2, getString(a.g.qq_friend_loading), true, new QQFriendUI.1(this, (af)localObject1));
    }
    setMMTitle(paramBundle);
    initView();
    AppMethodBeat.o(131280);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131282);
    com.tencent.mm.model.a.f.Sp("2");
    ((at)((a)com.tencent.mm.kernel.h.ag(a.class)).getQQListStg()).remove(this.mYP);
    com.tencent.mm.kernel.h.aGY().b(143, this);
    this.mYP.eKd();
    com.tencent.mm.am.q.bhR().cancel();
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
    com.tencent.mm.am.q.bhz().e(this.mYP);
    super.onPause();
    AppMethodBeat.o(131283);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131281);
    super.onResume();
    com.tencent.mm.am.q.bhz().d(this.mYP);
    this.mYP.notifyDataSetChanged();
    AppMethodBeat.o(131281);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(131287);
    Log.i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((caw)d.b.b(((af)paramq).rr.lBR)).jUk != 1)
    {
      AppMethodBeat.o(131287);
      return;
    }
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.mYP.atr();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.QQFriendUI
 * JD-Core Version:    0.7.0.1
 */