package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom.Resp;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.ao;
import com.tencent.mm.plugin.game.d.z;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(7)
public class CreateOrJoinChatroomUI
  extends MMBaseActivity
{
  private String CO;
  private ProgressDialog ecf = null;
  private String fsv;
  private String kWT;
  private String kWU;
  private String kWV;
  private String kWW;
  private int kWX = 1;
  private String mAppId;
  private String mPackageName;
  
  private void aZW()
  {
    if ((this.ecf != null) && (this.ecf.isShowing())) {
      this.ecf.cancel();
    }
  }
  
  private void se(int paramInt)
  {
    Object localObject1 = g.by(this.mAppId, true);
    Bundle localBundle = new Bundle();
    Object localObject2;
    if (this.CO.equals("action_create"))
    {
      localObject2 = new CreateChatroom.Resp();
      if (localObject1 != null) {
        ((CreateChatroom.Resp)localObject2).openId = ((f)localObject1).field_openId;
      }
      ((CreateChatroom.Resp)localObject2).transaction = this.kWT;
      ((CreateChatroom.Resp)localObject2).extMsg = this.kWW;
      ((CreateChatroom.Resp)localObject2).errCode = paramInt;
      ((CreateChatroom.Resp)localObject2).toBundle(localBundle);
    }
    for (;;)
    {
      localObject1 = new MMessageActV2.Args();
      ((MMessageActV2.Args)localObject1).targetPkgName = this.mPackageName;
      ((MMessageActV2.Args)localObject1).bundle = localBundle;
      com.tencent.mm.pluginsdk.model.app.p.ak(localBundle);
      com.tencent.mm.pluginsdk.model.app.p.al(localBundle);
      MMessageActV2.send(ae.getContext(), (MMessageActV2.Args)localObject1);
      return;
      if (this.CO.equals("action_join"))
      {
        localObject2 = new JoinChatroom.Resp();
        if (localObject1 != null) {
          ((JoinChatroom.Resp)localObject2).openId = ((f)localObject1).field_openId;
        }
        ((JoinChatroom.Resp)localObject2).transaction = this.kWT;
        ((JoinChatroom.Resp)localObject2).extMsg = this.kWW;
        ((JoinChatroom.Resp)localObject2).errCode = paramInt;
        ((JoinChatroom.Resp)localObject2).toBundle(localBundle);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 5)
    {
      if (paramInt2 != 4) {
        break label20;
      }
      se(0);
    }
    for (;;)
    {
      finish();
      return;
      label20:
      if (paramInt2 == 5)
      {
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("rawUrl");
          p.a.rSH.b(this, paramIntent, true, null);
        }
      }
      else if (paramInt2 == 0) {
        se(-2);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
    paramBundle = getIntent();
    this.CO = paramBundle.getStringExtra("action");
    this.mPackageName = paramBundle.getStringExtra("package_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    this.kWT = paramBundle.getStringExtra("key_transaction");
    this.kWU = paramBundle.getStringExtra("group_id");
    this.kWV = paramBundle.getStringExtra("chatroom_name");
    this.fsv = paramBundle.getStringExtra("chatroom_nickname");
    this.kWW = paramBundle.getStringExtra("ext_msg");
    if ((bk.bl(this.CO)) || (bk.bl(this.mAppId)) || (bk.bl(this.kWU)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
      finish();
    }
    label357:
    do
    {
      return;
      this.ecf = h.b(this, getBaseContext().getString(g.i.game_verify_authority_tips_jumping), true, null);
      if (this.CO.equals("action_create"))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", new Object[] { this.mAppId, this.kWU, this.kWV });
        paramBundle = new b.a();
        paramBundle.ecH = new com.tencent.mm.plugin.game.d.y();
        paramBundle.ecI = new z();
        paramBundle.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
        paramBundle.ecG = 1205;
        localb = paramBundle.Kt();
        localObject = (com.tencent.mm.plugin.game.d.y)localb.ecE.ecN;
        ((com.tencent.mm.plugin.game.d.y)localObject).kRX = this.mAppId;
        ((com.tencent.mm.plugin.game.d.y)localObject).kTb = this.kWU;
        if (this.kWV == null)
        {
          paramBundle = new byte[0];
          ((com.tencent.mm.plugin.game.d.y)localObject).kTc = new com.tencent.mm.bv.b(paramBundle);
          if (this.fsv != null) {
            break label357;
          }
        }
        for (paramBundle = new byte[0];; paramBundle = this.fsv.getBytes())
        {
          ((com.tencent.mm.plugin.game.d.y)localObject).kTd = new com.tencent.mm.bv.b(paramBundle);
          w.a(localb, new CreateOrJoinChatroomUI.1(this));
          return;
          paramBundle = this.kWV.getBytes();
          break;
        }
      }
    } while (!this.CO.equals("action_join"));
    paramBundle = new b.a();
    paramBundle.ecH = new an();
    paramBundle.ecI = new ao();
    paramBundle.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
    paramBundle.ecG = 1206;
    com.tencent.mm.ah.b localb = paramBundle.Kt();
    Object localObject = (an)localb.ecE.ecN;
    ((an)localObject).kRX = this.mAppId;
    ((an)localObject).kTb = this.kWU;
    if (this.fsv == null) {}
    for (paramBundle = new byte[0];; paramBundle = this.fsv.getBytes())
    {
      ((an)localObject).kTd = new com.tencent.mm.bv.b(paramBundle);
      w.a(localb, new CreateOrJoinChatroomUI.2(this));
      return;
    }
  }
  
  protected void onDestroy()
  {
    aZW();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.CreateOrJoinChatroomUI
 * JD-Core Version:    0.7.0.1
 */