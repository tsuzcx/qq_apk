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
import com.tencent.mm.plugin.game.d.ab;
import com.tencent.mm.plugin.game.d.aq;
import com.tencent.mm.plugin.game.d.ar;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class CreateOrJoinChatroomUI
  extends MMBaseActivity
{
  private String Lj;
  private ProgressDialog huQ = null;
  private String iXH;
  private String mAppId;
  private String mPackageName;
  private String tmt;
  private String tmu;
  private String tmv;
  private String tmw;
  private int tmx = 1;
  
  private void Gz(int paramInt)
  {
    AppMethodBeat.i(41868);
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.k(this.mAppId, true, false);
    Bundle localBundle = new Bundle();
    Object localObject2;
    if (this.Lj.equals("action_create"))
    {
      localObject2 = new CreateChatroom.Resp();
      if (localObject1 != null) {
        ((CreateChatroom.Resp)localObject2).openId = ((g)localObject1).field_openId;
      }
      ((CreateChatroom.Resp)localObject2).transaction = this.tmt;
      ((CreateChatroom.Resp)localObject2).extMsg = this.tmw;
      ((CreateChatroom.Resp)localObject2).errCode = paramInt;
      ((CreateChatroom.Resp)localObject2).toBundle(localBundle);
    }
    for (;;)
    {
      localObject1 = new MMessageActV2.Args();
      ((MMessageActV2.Args)localObject1).targetPkgName = this.mPackageName;
      ((MMessageActV2.Args)localObject1).bundle = localBundle;
      q.aW(localBundle);
      q.aX(localBundle);
      MMessageActV2.send(ai.getContext(), (MMessageActV2.Args)localObject1);
      AppMethodBeat.o(41868);
      return;
      if (this.Lj.equals("action_join"))
      {
        localObject2 = new JoinChatroom.Resp();
        if (localObject1 != null) {
          ((JoinChatroom.Resp)localObject2).openId = ((g)localObject1).field_openId;
        }
        ((JoinChatroom.Resp)localObject2).transaction = this.tmt;
        ((JoinChatroom.Resp)localObject2).extMsg = this.tmw;
        ((JoinChatroom.Resp)localObject2).errCode = paramInt;
        ((JoinChatroom.Resp)localObject2).toBundle(localBundle);
      }
    }
  }
  
  private void cRi()
  {
    AppMethodBeat.i(41866);
    if ((this.huQ != null) && (this.huQ.isShowing())) {
      this.huQ.cancel();
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
      Gz(0);
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
          p.a.DfG.b(this, paramIntent, true, null);
        }
      }
      else if (paramInt2 == 0) {
        Gz(-2);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41864);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
    paramBundle = getIntent();
    this.Lj = paramBundle.getStringExtra("action");
    this.mPackageName = paramBundle.getStringExtra("package_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    this.tmt = paramBundle.getStringExtra("key_transaction");
    this.tmu = paramBundle.getStringExtra("group_id");
    this.tmv = paramBundle.getStringExtra("chatroom_name");
    this.iXH = paramBundle.getStringExtra("chatroom_nickname");
    this.tmw = paramBundle.getStringExtra("ext_msg");
    if ((bs.isNullOrNil(this.Lj)) || (bs.isNullOrNil(this.mAppId)) || (bs.isNullOrNil(this.tmu)))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
      finish();
      AppMethodBeat.o(41864);
      return;
    }
    this.huQ = com.tencent.mm.ui.base.h.b(this, getBaseContext().getString(2131759996), true, null);
    com.tencent.mm.ak.b localb;
    Object localObject;
    if (this.Lj.equals("action_create"))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", new Object[] { this.mAppId, this.tmu, this.tmv });
      paramBundle = new b.a();
      paramBundle.hvt = new ab();
      paramBundle.hvu = new com.tencent.mm.plugin.game.d.ac();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
      paramBundle.funcId = 1205;
      localb = paramBundle.aAz();
      localObject = (ab)localb.hvr.hvw;
      ((ab)localObject).fZx = this.mAppId;
      ((ab)localObject).tiy = this.tmu;
      if (this.tmv == null)
      {
        paramBundle = new byte[0];
        ((ab)localObject).tiz = new com.tencent.mm.bw.b(paramBundle);
        if (this.iXH != null) {
          break label372;
        }
      }
      label372:
      for (paramBundle = new byte[0];; paramBundle = this.iXH.getBytes())
      {
        ((ab)localObject).tiA = new com.tencent.mm.bw.b(paramBundle);
        x.a(localb, new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(41862);
            paramAnonymousb = (com.tencent.mm.plugin.game.d.ac)paramAnonymousb.hvs.hvw;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if (paramAnonymousInt1 == 4) {
                CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousb.pAG);
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
            paramAnonymousString = paramAnonymousb.tiB;
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", new Object[] { paramAnonymousString });
            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousString);
            AppMethodBeat.o(41862);
            return 0;
          }
        });
        AppMethodBeat.o(41864);
        return;
        paramBundle = this.tmv.getBytes();
        break;
      }
    }
    if (this.Lj.equals("action_join"))
    {
      paramBundle = new b.a();
      paramBundle.hvt = new aq();
      paramBundle.hvu = new ar();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
      paramBundle.funcId = 1206;
      localb = paramBundle.aAz();
      localObject = (aq)localb.hvr.hvw;
      ((aq)localObject).fZx = this.mAppId;
      ((aq)localObject).tiy = this.tmu;
      if (this.iXH != null) {
        break label513;
      }
    }
    label513:
    for (paramBundle = new byte[0];; paramBundle = this.iXH.getBytes())
    {
      ((aq)localObject).tiA = new com.tencent.mm.bw.b(paramBundle);
      x.a(localb, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(41863);
          paramAnonymousb = (ar)paramAnonymousb.hvs.hvw;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            if (paramAnonymousInt1 == 4) {
              CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousb.pAG);
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
          paramAnonymousString = paramAnonymousb.tjm;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CreateOrJoinChatroomUI", "Join Url: %s", new Object[] { paramAnonymousString });
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
    cRi();
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