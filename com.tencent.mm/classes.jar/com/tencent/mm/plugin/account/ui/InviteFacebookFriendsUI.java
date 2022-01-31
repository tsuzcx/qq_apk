package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.n;
import com.tencent.mm.ui.tools.n.b;

public class InviteFacebookFriendsUI
  extends MMActivity
  implements f
{
  private ProgressDialog dnm = null;
  private ListView fem;
  private View feo;
  String feq;
  private final int fix = 5;
  InviteFacebookFriendsUI.a fmc;
  
  private void aS(String paramString1, String paramString2)
  {
    h.a(this, paramString2, paramString1, new InviteFacebookFriendsUI.2(this), null);
  }
  
  protected final int getLayoutId()
  {
    return q.g.fb_friend;
  }
  
  protected final void initView()
  {
    this.fem = ((ListView)findViewById(q.f.mobile_friend_lv));
    Object localObject1 = (TextView)findViewById(q.f.empty_msg_tip_tv);
    ((TextView)localObject1).setText(q.j.facebook_empty_friend_tip);
    Object localObject2 = new n((byte)0);
    ((n)localObject2).weq = new n.b()
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
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this, bk.pl(paramAnonymousString));
        paramAnonymousString = InviteFacebookFriendsUI.this;
        if (paramAnonymousString.fmc != null)
        {
          InviteFacebookFriendsUI.a locala = paramAnonymousString.fmc;
          locala.fdR = bk.pl(paramAnonymousString.feq.trim());
          locala.bcS();
          locala.yc();
        }
      }
    };
    a((n)localObject2);
    this.fmc = new InviteFacebookFriendsUI.a(this, new InviteFacebookFriendsUI.3(this, (TextView)localObject1));
    this.fem.setAdapter(this.fmc);
    this.feo = findViewById(q.f.mobile_friend_mobile_not_bind_ll);
    this.fem.setOnItemClickListener(new InviteFacebookFriendsUI.4(this));
    y.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + q.GL());
    if (q.GL())
    {
      this.fem.setVisibility(0);
      this.feo.setVisibility(8);
      long l = bk.c((Long)com.tencent.mm.kernel.g.DP().Dz().get(65831, null));
      localObject1 = bk.pm((String)com.tencent.mm.kernel.g.DP().Dz().get(65830, null));
      if ((bk.co(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        localObject2 = new c("290293790992170");
        ((c)localObject2).aea((String)localObject1);
        new com.tencent.mm.plugin.account.model.g((c)localObject2, new InviteFacebookFriendsUI.5(this)).Xx();
      }
      localObject1 = new ab();
      ((ab)localObject1).Xa();
      localObject2 = new am(new InviteFacebookFriendsUI.6(this, (ab)localObject1), false);
      if (bk.g((Integer)com.tencent.mm.kernel.g.DP().Dz().get(65829, null)) <= 0) {
        break label429;
      }
      com.tencent.mm.kernel.g.DP().Dz().o(65829, Integer.valueOf(1));
      com.tencent.mm.kernel.g.Dk().a((m)localObject1, 0);
    }
    for (;;)
    {
      AppCompatActivity localAppCompatActivity = this.mController.uMN;
      getString(q.j.app_tip);
      this.dnm = h.b(localAppCompatActivity, getString(q.j.qq_friend_loading), true, new InviteFacebookFriendsUI.7(this, (am)localObject2, (ab)localObject1));
      setBackBtn(new InviteFacebookFriendsUI.8(this));
      new InviteFacebookFriendsUI.9(this);
      addTextOptionMenu(0, getString(q.j.facebook_invitefriends_sendinvite), new InviteFacebookFriendsUI.10(this));
      showOptionMenu(false);
      return;
      label429:
      ((am)localObject2).S(5000L, 5000L);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(q.j.facebook_invitefriends_title);
    com.tencent.mm.kernel.g.Dk().a(32, this);
    initView();
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.kernel.g.Dk().b(32, this);
    this.fmc.bcS();
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramm.getType() != 32) {
      return;
    }
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramm = paramString;
      if (bk.bl(paramString)) {
        paramm = "error";
      }
      aS(getString(q.j.app_tip), paramm);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.fmc.a(null, null);
      return;
    }
    Toast.makeText(this, q.j.mobile_friend_err, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI
 * JD-Core Version:    0.7.0.1
 */