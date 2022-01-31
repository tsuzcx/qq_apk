package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.n;

@Deprecated
public class FacebookFriendUI
  extends MMActivity
  implements d.a, f
{
  private ProgressDialog dnm = null;
  private ListView fem;
  private View feo;
  String feq;
  private TextView fer = null;
  private boolean fiq = false;
  d flN;
  
  private void aS(String paramString1, String paramString2)
  {
    h.a(this, paramString2, paramString1, new FacebookFriendUI.4(this), null);
  }
  
  protected final int getLayoutId()
  {
    return q.g.fb_friend;
  }
  
  protected final void initView()
  {
    this.fem = ((ListView)findViewById(q.f.mobile_friend_lv));
    this.fer = ((TextView)findViewById(q.f.empty_facebook_friend_search_tip_tv));
    this.fer.setText(q.j.facebook_friend_search_no_friend);
    Object localObject1 = (TextView)findViewById(q.f.empty_msg_tip_tv);
    ((TextView)localObject1).setText(q.j.facebook_empty_friend_tip);
    Object localObject2 = new n((byte)0);
    ((n)localObject2).weq = new FacebookFriendUI.1(this);
    a((n)localObject2);
    this.flN = new d(this, new FacebookFriendUI.5(this, (TextView)localObject1));
    this.flN.flJ = new FacebookFriendUI.6(this);
    this.fem.setAdapter(this.flN);
    this.feo = findViewById(q.f.mobile_friend_mobile_not_bind_ll);
    this.fem.setOnItemClickListener(new FacebookFriendUI.7(this));
    y.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + q.GL());
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
        new com.tencent.mm.plugin.account.model.g((c)localObject2, new FacebookFriendUI.8(this)).Xx();
      }
      localObject1 = new ab();
      ((ab)localObject1).Xa();
      localObject2 = new am(new FacebookFriendUI.9(this, (ab)localObject1), false);
      if (bk.g((Integer)com.tencent.mm.kernel.g.DP().Dz().get(65829, null)) > 0)
      {
        com.tencent.mm.kernel.g.DP().Dz().o(65829, Integer.valueOf(1));
        com.tencent.mm.kernel.g.Dk().a((m)localObject1, 0);
        AppCompatActivity localAppCompatActivity = this.mController.uMN;
        getString(q.j.app_tip);
        this.dnm = h.b(localAppCompatActivity, getString(q.j.qq_friend_loading), true, new FacebookFriendUI.10(this, (am)localObject2, (ab)localObject1));
        addTextOptionMenu(0, getString(q.j.find_friends_by_facebook_invite), new FacebookFriendUI.11(this));
      }
    }
    for (;;)
    {
      setBackBtn(new FacebookFriendUI.2(this));
      new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          BackwardSupportUtil.c.a(FacebookFriendUI.e(FacebookFriendUI.this));
        }
      };
      return;
      ((am)localObject2).S(5000L, 5000L);
      break;
      this.fem.setVisibility(8);
      this.feo.setVisibility(0);
      ((TextView)findViewById(q.f.mobile_friend_mobile_not_bind_tv)).setText(q.j.fb_friend_not_bind);
      this.feo.setOnClickListener(new FacebookFriendUI.12(this));
    }
  }
  
  public final void kk(String paramString)
  {
    this.flN.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(q.j.find_friends_by_facebook);
    com.tencent.mm.kernel.g.Dk().a(32, this);
    initView();
  }
  
  public void onDestroy()
  {
    com.tencent.mm.kernel.g.Dk().b(32, this);
    this.flN.bcS();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    o.JQ().e(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    o.JQ().d(this);
    this.flN.notifyDataSetChanged();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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
      this.flN.a(null, null);
      return;
    }
    Toast.makeText(this, q.j.mobile_friend_err, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI
 * JD-Core Version:    0.7.0.1
 */