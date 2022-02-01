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
import com.tencent.mm.plugin.game.d.ab;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.aq;
import com.tencent.mm.plugin.game.d.ar;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class CreateOrJoinChatroomUI
  extends MMBaseActivity
{
  private String Ko;
  private ProgressDialog gUr = null;
  private String ixE;
  private String mAppId;
  private String mPackageName;
  private String seA;
  private String seB;
  private String seC;
  private String seD;
  private int seE = 1;
  
  private void ED(int paramInt)
  {
    AppMethodBeat.i(41868);
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.j(this.mAppId, true, false);
    Bundle localBundle = new Bundle();
    Object localObject2;
    if (this.Ko.equals("action_create"))
    {
      localObject2 = new CreateChatroom.Resp();
      if (localObject1 != null) {
        ((CreateChatroom.Resp)localObject2).openId = ((g)localObject1).field_openId;
      }
      ((CreateChatroom.Resp)localObject2).transaction = this.seA;
      ((CreateChatroom.Resp)localObject2).extMsg = this.seD;
      ((CreateChatroom.Resp)localObject2).errCode = paramInt;
      ((CreateChatroom.Resp)localObject2).toBundle(localBundle);
    }
    for (;;)
    {
      localObject1 = new MMessageActV2.Args();
      ((MMessageActV2.Args)localObject1).targetPkgName = this.mPackageName;
      ((MMessageActV2.Args)localObject1).bundle = localBundle;
      q.aS(localBundle);
      q.aT(localBundle);
      MMessageActV2.send(aj.getContext(), (MMessageActV2.Args)localObject1);
      AppMethodBeat.o(41868);
      return;
      if (this.Ko.equals("action_join"))
      {
        localObject2 = new JoinChatroom.Resp();
        if (localObject1 != null) {
          ((JoinChatroom.Resp)localObject2).openId = ((g)localObject1).field_openId;
        }
        ((JoinChatroom.Resp)localObject2).transaction = this.seA;
        ((JoinChatroom.Resp)localObject2).extMsg = this.seD;
        ((JoinChatroom.Resp)localObject2).errCode = paramInt;
        ((JoinChatroom.Resp)localObject2).toBundle(localBundle);
      }
    }
  }
  
  private void cDY()
  {
    AppMethodBeat.i(41866);
    if ((this.gUr != null) && (this.gUr.isShowing())) {
      this.gUr.cancel();
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
      ED(0);
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
          p.a.BNw.b(this, paramIntent, true, null);
        }
      }
      else if (paramInt2 == 0) {
        ED(-2);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41864);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    ad.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
    paramBundle = getIntent();
    this.Ko = paramBundle.getStringExtra("action");
    this.mPackageName = paramBundle.getStringExtra("package_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    this.seA = paramBundle.getStringExtra("key_transaction");
    this.seB = paramBundle.getStringExtra("group_id");
    this.seC = paramBundle.getStringExtra("chatroom_name");
    this.ixE = paramBundle.getStringExtra("chatroom_nickname");
    this.seD = paramBundle.getStringExtra("ext_msg");
    if ((bt.isNullOrNil(this.Ko)) || (bt.isNullOrNil(this.mAppId)) || (bt.isNullOrNil(this.seB)))
    {
      ad.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
      finish();
      AppMethodBeat.o(41864);
      return;
    }
    this.gUr = com.tencent.mm.ui.base.h.b(this, getBaseContext().getString(2131759996), true, null);
    com.tencent.mm.al.b localb;
    Object localObject;
    if (this.Ko.equals("action_create"))
    {
      ad.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", new Object[] { this.mAppId, this.seB, this.seC });
      paramBundle = new b.a();
      paramBundle.gUU = new ab();
      paramBundle.gUV = new ac();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
      paramBundle.funcId = 1205;
      localb = paramBundle.atI();
      localObject = (ab)localb.gUS.gUX;
      ((ab)localObject).fVC = this.mAppId;
      ((ab)localObject).saE = this.seB;
      if (this.seC == null)
      {
        paramBundle = new byte[0];
        ((ab)localObject).saF = new com.tencent.mm.bx.b(paramBundle);
        if (this.ixE != null) {
          break label372;
        }
      }
      label372:
      for (paramBundle = new byte[0];; paramBundle = this.ixE.getBytes())
      {
        ((ab)localObject).saG = new com.tencent.mm.bx.b(paramBundle);
        x.a(localb, new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(41862);
            paramAnonymousb = (ac)paramAnonymousb.gUT.gUX;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              ad.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if (paramAnonymousInt1 == 4) {
                CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousb.oXv);
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
            paramAnonymousString = paramAnonymousb.saH;
            ad.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", new Object[] { paramAnonymousString });
            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousString);
            AppMethodBeat.o(41862);
            return 0;
          }
        });
        AppMethodBeat.o(41864);
        return;
        paramBundle = this.seC.getBytes();
        break;
      }
    }
    if (this.Ko.equals("action_join"))
    {
      paramBundle = new b.a();
      paramBundle.gUU = new aq();
      paramBundle.gUV = new ar();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
      paramBundle.funcId = 1206;
      localb = paramBundle.atI();
      localObject = (aq)localb.gUS.gUX;
      ((aq)localObject).fVC = this.mAppId;
      ((aq)localObject).saE = this.seB;
      if (this.ixE != null) {
        break label513;
      }
    }
    label513:
    for (paramBundle = new byte[0];; paramBundle = this.ixE.getBytes())
    {
      ((aq)localObject).saG = new com.tencent.mm.bx.b(paramBundle);
      x.a(localb, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(41863);
          paramAnonymousb = (ar)paramAnonymousb.gUT.gUX;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            if (paramAnonymousInt1 == 4) {
              CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousb.oXv);
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
          paramAnonymousString = paramAnonymousb.sbs;
          ad.i("MicroMsg.CreateOrJoinChatroomUI", "Join Url: %s", new Object[] { paramAnonymousString });
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
    cDY();
    super.onDestroy();
    AppMethodBeat.o(41865);
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