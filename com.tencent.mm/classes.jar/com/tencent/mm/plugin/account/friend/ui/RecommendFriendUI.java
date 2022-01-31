package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.protocal.c.ayw;
import com.tencent.mm.protocal.c.ayz;
import com.tencent.mm.protocal.c.zn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI
  extends MMActivity
  implements f
{
  private ProgressDialog dnm = null;
  private LinkedList<zn> fhA = new LinkedList();
  private boolean fhB;
  private b fit;
  private ListView fiu;
  private TextView fiv;
  private LinkedList<ayz> fiw = new LinkedList();
  private int fix = -1;
  private boolean fiy = false;
  
  private void Xr()
  {
    this.fiv.setVisibility(0);
    this.fiu.setVisibility(8);
  }
  
  private void Xs()
  {
    if (this.fix == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", bool);
      y.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.fhA.size());
      this.fit.fhA = this.fhA;
      this.fiu.setAdapter(this.fit);
      showOptionMenu(false);
      this.fhB = true;
      setMMTitle(a.h.settings_invite_qq_friends);
      this.fit.fhB = this.fhB;
      this.fit.notifyDataSetChanged();
      return;
    }
  }
  
  private void goBack()
  {
    if (this.fix != 0)
    {
      finish();
      return;
    }
    if ((this.fhB) || (this.fiy))
    {
      finish();
      return;
    }
    Xs();
  }
  
  private void kc(int paramInt)
  {
    y.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.fiw.size());
    this.fit.a(this.fiw, paramInt);
    this.fiu.setAdapter(this.fit);
    this.fhB = false;
    String str;
    int i;
    if (this.fix == 0)
    {
      str = "";
      i = 0;
      if (i < this.fhA.size())
      {
        if (paramInt != ((zn)this.fhA.get(i)).sTj) {
          break label142;
        }
        str = ((zn)this.fhA.get(i)).sYM;
      }
    }
    label142:
    for (;;)
    {
      i += 1;
      break;
      setMMTitle(str);
      this.fit.fhB = this.fhB;
      this.fit.notifyDataSetChanged();
      return;
    }
  }
  
  protected final int getLayoutId()
  {
    return a.e.inviteqqfriends;
  }
  
  protected final void initView()
  {
    this.fiv = ((TextView)findViewById(a.d.empty_tip_tv));
    if (this.fix == 1)
    {
      setMMTitle(a.h.settings_recommend_by_mb);
      this.fiv.setText(a.h.settings_recommend_no_mb_contact);
    }
    for (;;)
    {
      this.fit = new b(getLayoutInflater());
      this.fiu = ((ListView)findViewById(a.d.inviteqqfriends_friend_lv));
      this.fiu.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 0;
          if (!RecommendFriendUI.a(RecommendFriendUI.this))
          {
            RecommendFriendUI.b(RecommendFriendUI.this).kb(paramAnonymousInt);
            if (RecommendFriendUI.b(RecommendFriendUI.this).Xq().length > 0)
            {
              RecommendFriendUI.this.showOptionMenu(true);
              return;
            }
            RecommendFriendUI.this.showOptionMenu(false);
            return;
          }
          paramAnonymousAdapterView = RecommendFriendUI.this;
          paramAnonymousView = RecommendFriendUI.b(RecommendFriendUI.this);
          if (!paramAnonymousView.fhB) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = ((zn)paramAnonymousView.fhA.get(paramAnonymousInt)).sTj)
          {
            RecommendFriendUI.a(paramAnonymousAdapterView, paramAnonymousInt);
            return;
          }
        }
      });
      this.fiu.setAdapter(this.fit);
      addTextOptionMenu(0, getString(a.h.inviteqqfriends_invite), new RecommendFriendUI.2(this));
      showOptionMenu(false);
      this.fiy = true;
      aa localaa = new aa(this.fix);
      g.Dk().a(localaa, 0);
      AppCompatActivity localAppCompatActivity = this.mController.uMN;
      getString(a.h.app_tip);
      this.dnm = h.b(localAppCompatActivity, getString(a.h.inviteqqfriends_loading_friends_info), true, new RecommendFriendUI.5(this, localaa));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          RecommendFriendUI.d(RecommendFriendUI.this);
          return true;
        }
      });
      new RecommendFriendUI.4(this);
      return;
      if (this.fix == 2)
      {
        setMMTitle(a.h.settings_recommend_by_mail);
        this.fiv.setText(a.h.settings_recommend_no_mail_contact);
      }
      else
      {
        setMMTitle(a.h.settings_invite_qq_friends);
        this.fiv.setText(a.h.settings_recommend_no_qq_contact);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.fix = bk.getInt(getIntent().getStringExtra("recommend_type"), 0);
    this.fhB = false;
    g.Dk().a(135, this);
    initView();
  }
  
  protected void onDestroy()
  {
    g.Dk().b(135, this);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramm.getType() != 135))
    {
      Xr();
      return;
    }
    this.fiw = ((ayw)((aa)paramm).dmK.ecF.ecN).kVS;
    this.fhA = ((ayw)((aa)paramm).dmK.ecF.ecN).swl;
    this.fiy = false;
    if (this.fiw.size() <= 0)
    {
      Xr();
      return;
    }
    if ((this.fix == 0) && (this.fhA.size() <= 0))
    {
      Xr();
      return;
    }
    if (this.fix != 0)
    {
      kc(-1);
      return;
    }
    Xs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI
 * JD-Core Version:    0.7.0.1
 */