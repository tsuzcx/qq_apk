package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom.Resp;
import com.tencent.mm.plugin.game.d.aj;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.d.az;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class CreateOrJoinChatroomUI
  extends MMBaseActivity
{
  private String Nb;
  private ProgressDialog hQb = null;
  private String jtJ;
  private String mAppId;
  private String mPackageName;
  private String uwp;
  private String uwq;
  private String uwr;
  private String uws;
  private int uwt = 1;
  
  private void Iq(int paramInt)
  {
    AppMethodBeat.i(41868);
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.m(this.mAppId, true, false);
    Bundle localBundle = new Bundle();
    Object localObject2;
    if (this.Nb.equals("action_create"))
    {
      localObject2 = new CreateChatroom.Resp();
      if (localObject1 != null) {
        ((CreateChatroom.Resp)localObject2).openId = ((g)localObject1).field_openId;
      }
      ((CreateChatroom.Resp)localObject2).transaction = this.uwp;
      ((CreateChatroom.Resp)localObject2).extMsg = this.uws;
      ((CreateChatroom.Resp)localObject2).errCode = paramInt;
      ((CreateChatroom.Resp)localObject2).toBundle(localBundle);
    }
    for (;;)
    {
      localObject1 = new MMessageActV2.Args();
      ((MMessageActV2.Args)localObject1).targetPkgName = this.mPackageName;
      ((MMessageActV2.Args)localObject1).bundle = localBundle;
      com.tencent.mm.pluginsdk.model.app.q.bc(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.bd(localBundle);
      MMessageActV2.send(com.tencent.mm.sdk.platformtools.ak.getContext(), (MMessageActV2.Args)localObject1);
      AppMethodBeat.o(41868);
      return;
      if (this.Nb.equals("action_join"))
      {
        localObject2 = new JoinChatroom.Resp();
        if (localObject1 != null) {
          ((JoinChatroom.Resp)localObject2).openId = ((g)localObject1).field_openId;
        }
        ((JoinChatroom.Resp)localObject2).transaction = this.uwp;
        ((JoinChatroom.Resp)localObject2).extMsg = this.uws;
        ((JoinChatroom.Resp)localObject2).errCode = paramInt;
        ((JoinChatroom.Resp)localObject2).toBundle(localBundle);
      }
    }
  }
  
  private void dcz()
  {
    AppMethodBeat.i(41866);
    if ((this.hQb != null) && (this.hQb.isShowing())) {
      this.hQb.cancel();
    }
    AppMethodBeat.o(41866);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41867);
    if (paramInt1 == 5)
    {
      if (paramInt2 != 4) {
        break label30;
      }
      Iq(0);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(41867);
      return;
      label30:
      if (paramInt2 == 5)
      {
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("rawUrl");
          q.a.Fca.b(this, paramIntent, true, null);
        }
      }
      else if (paramInt2 == 0) {
        Iq(-2);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41864);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    ae.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
    paramBundle = getIntent();
    this.Nb = paramBundle.getStringExtra("action");
    this.mPackageName = paramBundle.getStringExtra("package_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    this.uwp = paramBundle.getStringExtra("key_transaction");
    this.uwq = paramBundle.getStringExtra("group_id");
    this.uwr = paramBundle.getStringExtra("chatroom_name");
    this.jtJ = paramBundle.getStringExtra("chatroom_nickname");
    this.uws = paramBundle.getStringExtra("ext_msg");
    if ((bu.isNullOrNil(this.Nb)) || (bu.isNullOrNil(this.mAppId)) || (bu.isNullOrNil(this.uwq)))
    {
      ae.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
      finish();
      AppMethodBeat.o(41864);
      return;
    }
    this.hQb = com.tencent.mm.ui.base.h.b(this, getBaseContext().getString(2131759996), true, null);
    com.tencent.mm.ak.b localb;
    Object localObject;
    if (this.Nb.equals("action_create"))
    {
      ae.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", new Object[] { this.mAppId, this.uwq, this.uwr });
      paramBundle = new b.a();
      paramBundle.hQF = new aj();
      paramBundle.hQG = new com.tencent.mm.plugin.game.d.ak();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
      paramBundle.funcId = 1205;
      localb = paramBundle.aDS();
      localObject = (aj)localb.hQD.hQJ;
      ((aj)localObject).gvv = this.mAppId;
      ((aj)localObject).urR = this.uwq;
      if (this.uwr == null)
      {
        paramBundle = new byte[0];
        ((aj)localObject).urS = new com.tencent.mm.bw.b(paramBundle);
        if (this.jtJ != null) {
          break label372;
        }
      }
      label372:
      for (paramBundle = new byte[0];; paramBundle = this.jtJ.getBytes())
      {
        ((aj)localObject).urT = new com.tencent.mm.bw.b(paramBundle);
        x.a(localb, new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(41862);
            paramAnonymousb = (com.tencent.mm.plugin.game.d.ak)paramAnonymousb.hQE.hQJ;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              ae.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if (paramAnonymousInt1 == 4) {
                CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousb.qkQ);
              }
              for (;;)
              {
                CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
                CreateOrJoinChatroomUI.this.finish();
                AppMethodBeat.o(41862);
                return 0;
                CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, -1);
              }
            }
            paramAnonymousString = paramAnonymousb.urU;
            ae.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", new Object[] { paramAnonymousString });
            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousString);
            AppMethodBeat.o(41862);
            return 0;
          }
        });
        AppMethodBeat.o(41864);
        return;
        paramBundle = this.uwr.getBytes();
        break;
      }
    }
    if (this.Nb.equals("action_join"))
    {
      paramBundle = new b.a();
      paramBundle.hQF = new ay();
      paramBundle.hQG = new az();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
      paramBundle.funcId = 1206;
      localb = paramBundle.aDS();
      localObject = (ay)localb.hQD.hQJ;
      ((ay)localObject).gvv = this.mAppId;
      ((ay)localObject).urR = this.uwq;
      if (this.jtJ != null) {
        break label513;
      }
    }
    label513:
    for (paramBundle = new byte[0];; paramBundle = this.jtJ.getBytes())
    {
      ((ay)localObject).urT = new com.tencent.mm.bw.b(paramBundle);
      x.a(localb, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(41863);
          paramAnonymousb = (az)paramAnonymousb.hQE.hQJ;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ae.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            if (paramAnonymousInt1 == 4) {
              CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousb.qkQ);
            }
            for (;;)
            {
              CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
              CreateOrJoinChatroomUI.this.finish();
              AppMethodBeat.o(41863);
              return 0;
              CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, -1);
            }
          }
          paramAnonymousString = paramAnonymousb.usE;
          ae.i("MicroMsg.CreateOrJoinChatroomUI", "Join Url: %s", new Object[] { paramAnonymousString });
          CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
          CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousString);
          AppMethodBeat.o(41863);
          return 0;
        }
      });
      AppMethodBeat.o(41864);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41865);
    dcz();
    super.onDestroy();
    AppMethodBeat.o(41865);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.CreateOrJoinChatroomUI
 * JD-Core Version:    0.7.0.1
 */