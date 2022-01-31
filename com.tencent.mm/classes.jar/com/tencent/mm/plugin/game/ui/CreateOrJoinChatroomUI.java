package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.w;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom.Resp;
import com.tencent.mm.plugin.game.d.aa;
import com.tencent.mm.plugin.game.d.ao;
import com.tencent.mm.plugin.game.d.ap;
import com.tencent.mm.plugin.game.d.z;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(7)
public class CreateOrJoinChatroomUI
  extends MMBaseActivity
{
  private String Dx;
  private ProgressDialog fsw = null;
  private String gJX;
  private String mAppId;
  private String mPackageName;
  private String nuV;
  private String nuW;
  private String nuX;
  private String nuY;
  private int nuZ = 1;
  
  private void bHe()
  {
    AppMethodBeat.i(111706);
    if ((this.fsw != null) && (this.fsw.isShowing())) {
      this.fsw.cancel();
    }
    AppMethodBeat.o(111706);
  }
  
  private void xd(int paramInt)
  {
    AppMethodBeat.i(111708);
    Object localObject1 = g.ca(this.mAppId, true);
    Bundle localBundle = new Bundle();
    Object localObject2;
    if (this.Dx.equals("action_create"))
    {
      localObject2 = new CreateChatroom.Resp();
      if (localObject1 != null) {
        ((CreateChatroom.Resp)localObject2).openId = ((f)localObject1).field_openId;
      }
      ((CreateChatroom.Resp)localObject2).transaction = this.nuV;
      ((CreateChatroom.Resp)localObject2).extMsg = this.nuY;
      ((CreateChatroom.Resp)localObject2).errCode = paramInt;
      ((CreateChatroom.Resp)localObject2).toBundle(localBundle);
    }
    for (;;)
    {
      localObject1 = new MMessageActV2.Args();
      ((MMessageActV2.Args)localObject1).targetPkgName = this.mPackageName;
      ((MMessageActV2.Args)localObject1).bundle = localBundle;
      p.aC(localBundle);
      p.aD(localBundle);
      MMessageActV2.send(ah.getContext(), (MMessageActV2.Args)localObject1);
      AppMethodBeat.o(111708);
      return;
      if (this.Dx.equals("action_join"))
      {
        localObject2 = new JoinChatroom.Resp();
        if (localObject1 != null) {
          ((JoinChatroom.Resp)localObject2).openId = ((f)localObject1).field_openId;
        }
        ((JoinChatroom.Resp)localObject2).transaction = this.nuV;
        ((JoinChatroom.Resp)localObject2).extMsg = this.nuY;
        ((JoinChatroom.Resp)localObject2).errCode = paramInt;
        ((JoinChatroom.Resp)localObject2).toBundle(localBundle);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(111707);
    if (paramInt1 == 5)
    {
      if (paramInt2 != 4) {
        break label30;
      }
      xd(0);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(111707);
      return;
      label30:
      if (paramInt2 == 5)
      {
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("rawUrl");
          r.a.vJD.b(this, paramIntent, true, null);
        }
      }
      else if (paramInt2 == 0) {
        xd(-2);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111704);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    ab.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
    paramBundle = getIntent();
    this.Dx = paramBundle.getStringExtra("action");
    this.mPackageName = paramBundle.getStringExtra("package_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    this.nuV = paramBundle.getStringExtra("key_transaction");
    this.nuW = paramBundle.getStringExtra("group_id");
    this.nuX = paramBundle.getStringExtra("chatroom_name");
    this.gJX = paramBundle.getStringExtra("chatroom_nickname");
    this.nuY = paramBundle.getStringExtra("ext_msg");
    if ((bo.isNullOrNil(this.Dx)) || (bo.isNullOrNil(this.mAppId)) || (bo.isNullOrNil(this.nuW)))
    {
      ab.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
      finish();
      AppMethodBeat.o(111704);
      return;
    }
    this.fsw = h.b(this, getBaseContext().getString(2131300468), true, null);
    com.tencent.mm.ai.b localb;
    Object localObject;
    if (this.Dx.equals("action_create"))
    {
      ab.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", new Object[] { this.mAppId, this.nuW, this.nuX });
      paramBundle = new b.a();
      paramBundle.fsX = new z();
      paramBundle.fsY = new aa();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
      paramBundle.funcId = 1205;
      localb = paramBundle.ado();
      localObject = (z)localb.fsV.fta;
      ((z)localObject).npZ = this.mAppId;
      ((z)localObject).nrb = this.nuW;
      if (this.nuX == null)
      {
        paramBundle = new byte[0];
        ((z)localObject).nrc = new com.tencent.mm.bv.b(paramBundle);
        if (this.gJX != null) {
          break label372;
        }
      }
      label372:
      for (paramBundle = new byte[0];; paramBundle = this.gJX.getBytes())
      {
        ((z)localObject).nrd = new com.tencent.mm.bv.b(paramBundle);
        w.a(localb, new CreateOrJoinChatroomUI.1(this));
        AppMethodBeat.o(111704);
        return;
        paramBundle = this.nuX.getBytes();
        break;
      }
    }
    if (this.Dx.equals("action_join"))
    {
      paramBundle = new b.a();
      paramBundle.fsX = new ao();
      paramBundle.fsY = new ap();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
      paramBundle.funcId = 1206;
      localb = paramBundle.ado();
      localObject = (ao)localb.fsV.fta;
      ((ao)localObject).npZ = this.mAppId;
      ((ao)localObject).nrb = this.nuW;
      if (this.gJX != null) {
        break label513;
      }
    }
    label513:
    for (paramBundle = new byte[0];; paramBundle = this.gJX.getBytes())
    {
      ((ao)localObject).nrd = new com.tencent.mm.bv.b(paramBundle);
      w.a(localb, new CreateOrJoinChatroomUI.2(this));
      AppMethodBeat.o(111704);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111705);
    bHe();
    super.onDestroy();
    AppMethodBeat.o(111705);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.CreateOrJoinChatroomUI
 * JD-Core Version:    0.7.0.1
 */