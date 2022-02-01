package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom.Resp;
import com.tencent.mm.plugin.game.d.ae;
import com.tencent.mm.plugin.game.d.as;
import com.tencent.mm.plugin.game.d.at;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class CreateOrJoinChatroomUI
  extends MMBaseActivity
{
  private String Nb;
  private ProgressDialog hNi = null;
  private String jqQ;
  private String mAppId;
  private String mPackageName;
  private String ukS;
  private String ukT;
  private String ukU;
  private String ukV;
  private int ukW = 1;
  
  private void HS(int paramInt)
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
      ((CreateChatroom.Resp)localObject2).transaction = this.ukS;
      ((CreateChatroom.Resp)localObject2).extMsg = this.ukV;
      ((CreateChatroom.Resp)localObject2).errCode = paramInt;
      ((CreateChatroom.Resp)localObject2).toBundle(localBundle);
    }
    for (;;)
    {
      localObject1 = new MMessageActV2.Args();
      ((MMessageActV2.Args)localObject1).targetPkgName = this.mPackageName;
      ((MMessageActV2.Args)localObject1).bundle = localBundle;
      com.tencent.mm.pluginsdk.model.app.q.bb(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.bc(localBundle);
      MMessageActV2.send(aj.getContext(), (MMessageActV2.Args)localObject1);
      AppMethodBeat.o(41868);
      return;
      if (this.Nb.equals("action_join"))
      {
        localObject2 = new JoinChatroom.Resp();
        if (localObject1 != null) {
          ((JoinChatroom.Resp)localObject2).openId = ((g)localObject1).field_openId;
        }
        ((JoinChatroom.Resp)localObject2).transaction = this.ukS;
        ((JoinChatroom.Resp)localObject2).extMsg = this.ukV;
        ((JoinChatroom.Resp)localObject2).errCode = paramInt;
        ((JoinChatroom.Resp)localObject2).toBundle(localBundle);
      }
    }
  }
  
  private void cZO()
  {
    AppMethodBeat.i(41866);
    if ((this.hNi != null) && (this.hNi.isShowing())) {
      this.hNi.cancel();
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
      HS(0);
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
          q.a.EJC.b(this, paramIntent, true, null);
        }
      }
      else if (paramInt2 == 0) {
        HS(-2);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41864);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
    paramBundle = getIntent();
    this.Nb = paramBundle.getStringExtra("action");
    this.mPackageName = paramBundle.getStringExtra("package_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    this.ukS = paramBundle.getStringExtra("key_transaction");
    this.ukT = paramBundle.getStringExtra("group_id");
    this.ukU = paramBundle.getStringExtra("chatroom_name");
    this.jqQ = paramBundle.getStringExtra("chatroom_nickname");
    this.ukV = paramBundle.getStringExtra("ext_msg");
    if ((bt.isNullOrNil(this.Nb)) || (bt.isNullOrNil(this.mAppId)) || (bt.isNullOrNil(this.ukT)))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
      finish();
      AppMethodBeat.o(41864);
      return;
    }
    this.hNi = com.tencent.mm.ui.base.h.b(this, getBaseContext().getString(2131759996), true, null);
    com.tencent.mm.al.b localb;
    Object localObject;
    if (this.Nb.equals("action_create"))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", new Object[] { this.mAppId, this.ukT, this.ukU });
      paramBundle = new b.a();
      paramBundle.hNM = new com.tencent.mm.plugin.game.d.ad();
      paramBundle.hNN = new ae();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
      paramBundle.funcId = 1205;
      localb = paramBundle.aDC();
      localObject = (com.tencent.mm.plugin.game.d.ad)localb.hNK.hNQ;
      ((com.tencent.mm.plugin.game.d.ad)localObject).gsT = this.mAppId;
      ((com.tencent.mm.plugin.game.d.ad)localObject).ugt = this.ukT;
      if (this.ukU == null)
      {
        paramBundle = new byte[0];
        ((com.tencent.mm.plugin.game.d.ad)localObject).ugu = new com.tencent.mm.bx.b(paramBundle);
        if (this.jqQ != null) {
          break label372;
        }
      }
      label372:
      for (paramBundle = new byte[0];; paramBundle = this.jqQ.getBytes())
      {
        ((com.tencent.mm.plugin.game.d.ad)localObject).ugv = new com.tencent.mm.bx.b(paramBundle);
        x.a(localb, new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(41862);
            paramAnonymousb = (ae)paramAnonymousb.hNL.hNQ;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if (paramAnonymousInt1 == 4) {
                CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousb.qel);
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
            paramAnonymousString = paramAnonymousb.ugw;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", new Object[] { paramAnonymousString });
            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousString);
            AppMethodBeat.o(41862);
            return 0;
          }
        });
        AppMethodBeat.o(41864);
        return;
        paramBundle = this.ukU.getBytes();
        break;
      }
    }
    if (this.Nb.equals("action_join"))
    {
      paramBundle = new b.a();
      paramBundle.hNM = new as();
      paramBundle.hNN = new at();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
      paramBundle.funcId = 1206;
      localb = paramBundle.aDC();
      localObject = (as)localb.hNK.hNQ;
      ((as)localObject).gsT = this.mAppId;
      ((as)localObject).ugt = this.ukT;
      if (this.jqQ != null) {
        break label513;
      }
    }
    label513:
    for (paramBundle = new byte[0];; paramBundle = this.jqQ.getBytes())
    {
      ((as)localObject).ugv = new com.tencent.mm.bx.b(paramBundle);
      x.a(localb, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(41863);
          paramAnonymousb = (at)paramAnonymousb.hNL.hNQ;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            if (paramAnonymousInt1 == 4) {
              CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousb.qel);
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
          paramAnonymousString = paramAnonymousb.uhh;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CreateOrJoinChatroomUI", "Join Url: %s", new Object[] { paramAnonymousString });
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
    cZO();
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