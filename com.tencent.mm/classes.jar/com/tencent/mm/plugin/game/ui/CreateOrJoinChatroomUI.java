package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.bw.b;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom.Resp;
import com.tencent.mm.plugin.game.protobuf.ak;
import com.tencent.mm.plugin.game.protobuf.al;
import com.tencent.mm.plugin.game.protobuf.az;
import com.tencent.mm.plugin.game.protobuf.ba;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class CreateOrJoinChatroomUI
  extends MMBaseActivity
{
  private String Nl;
  private ProgressDialog iLh = null;
  private String krY;
  private String mAppId;
  private String mPackageName;
  private String xOq;
  private String xOr;
  private String xOs;
  private String xOt;
  private int xOu = 1;
  
  private void Or(int paramInt)
  {
    AppMethodBeat.i(41868);
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.o(this.mAppId, true, false);
    Bundle localBundle = new Bundle();
    Object localObject2;
    if (this.Nl.equals("action_create"))
    {
      localObject2 = new CreateChatroom.Resp();
      if (localObject1 != null) {
        ((CreateChatroom.Resp)localObject2).openId = ((g)localObject1).field_openId;
      }
      ((CreateChatroom.Resp)localObject2).transaction = this.xOq;
      ((CreateChatroom.Resp)localObject2).extMsg = this.xOt;
      ((CreateChatroom.Resp)localObject2).errCode = paramInt;
      ((CreateChatroom.Resp)localObject2).toBundle(localBundle);
    }
    for (;;)
    {
      localObject1 = new MMessageActV2.Args();
      ((MMessageActV2.Args)localObject1).targetPkgName = this.mPackageName;
      ((MMessageActV2.Args)localObject1).bundle = localBundle;
      com.tencent.mm.pluginsdk.model.app.q.bo(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.bp(localBundle);
      MMessageActV2.send(MMApplicationContext.getContext(), (MMessageActV2.Args)localObject1);
      AppMethodBeat.o(41868);
      return;
      if (this.Nl.equals("action_join"))
      {
        localObject2 = new JoinChatroom.Resp();
        if (localObject1 != null) {
          ((JoinChatroom.Resp)localObject2).openId = ((g)localObject1).field_openId;
        }
        ((JoinChatroom.Resp)localObject2).transaction = this.xOq;
        ((JoinChatroom.Resp)localObject2).extMsg = this.xOt;
        ((JoinChatroom.Resp)localObject2).errCode = paramInt;
        ((JoinChatroom.Resp)localObject2).toBundle(localBundle);
      }
    }
  }
  
  private void dWg()
  {
    AppMethodBeat.i(41866);
    if ((this.iLh != null) && (this.iLh.isShowing())) {
      this.iLh.cancel();
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
      Or(0);
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
          q.a.JSZ.b(this, paramIntent, true, null);
        }
      }
      else if (paramInt2 == 0) {
        Or(-2);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41864);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    Log.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
    paramBundle = getIntent();
    this.Nl = paramBundle.getStringExtra("action");
    this.mPackageName = paramBundle.getStringExtra("package_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    this.xOq = paramBundle.getStringExtra("key_transaction");
    this.xOr = paramBundle.getStringExtra("group_id");
    this.xOs = paramBundle.getStringExtra("chatroom_name");
    this.krY = paramBundle.getStringExtra("chatroom_nickname");
    this.xOt = paramBundle.getStringExtra("ext_msg");
    if ((Util.isNullOrNil(this.Nl)) || (Util.isNullOrNil(this.mAppId)) || (Util.isNullOrNil(this.xOr)))
    {
      Log.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
      finish();
      AppMethodBeat.o(41864);
      return;
    }
    this.iLh = com.tencent.mm.ui.base.h.a(this, getBaseContext().getString(2131761360), true, null);
    d locald;
    Object localObject;
    if (this.Nl.equals("action_create"))
    {
      Log.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", new Object[] { this.mAppId, this.xOr, this.xOs });
      paramBundle = new d.a();
      paramBundle.iLN = new ak();
      paramBundle.iLO = new al();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
      paramBundle.funcId = 1205;
      locald = paramBundle.aXF();
      localObject = (ak)locald.iLK.iLR;
      ((ak)localObject).hik = this.mAppId;
      ((ak)localObject).xKj = this.xOr;
      if (this.xOs == null)
      {
        paramBundle = new byte[0];
        ((ak)localObject).xKk = new b(paramBundle);
        if (this.krY != null) {
          break label372;
        }
      }
      label372:
      for (paramBundle = new byte[0];; paramBundle = this.krY.getBytes())
      {
        ((ak)localObject).xKl = new b(paramBundle);
        aa.a(locald, new aa.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, com.tencent.mm.ak.q paramAnonymousq)
          {
            AppMethodBeat.i(41862);
            paramAnonymousd = (al)paramAnonymousd.iLL.iLR;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              Log.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if (paramAnonymousInt1 == 4) {
                CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousd.rBL);
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
            paramAnonymousString = paramAnonymousd.xKm;
            Log.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", new Object[] { paramAnonymousString });
            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousString);
            AppMethodBeat.o(41862);
            return 0;
          }
        });
        AppMethodBeat.o(41864);
        return;
        paramBundle = this.xOs.getBytes();
        break;
      }
    }
    if (this.Nl.equals("action_join"))
    {
      paramBundle = new d.a();
      paramBundle.iLN = new az();
      paramBundle.iLO = new ba();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
      paramBundle.funcId = 1206;
      locald = paramBundle.aXF();
      localObject = (az)locald.iLK.iLR;
      ((az)localObject).hik = this.mAppId;
      ((az)localObject).xKj = this.xOr;
      if (this.krY != null) {
        break label513;
      }
    }
    label513:
    for (paramBundle = new byte[0];; paramBundle = this.krY.getBytes())
    {
      ((az)localObject).xKl = new b(paramBundle);
      aa.a(locald, new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(41863);
          paramAnonymousd = (ba)paramAnonymousd.iLL.iLR;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            if (paramAnonymousInt1 == 4) {
              CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousd.rBL);
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
          paramAnonymousString = paramAnonymousd.xKW;
          Log.i("MicroMsg.CreateOrJoinChatroomUI", "Join Url: %s", new Object[] { paramAnonymousString });
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
    dWg();
    super.onDestroy();
    AppMethodBeat.o(41865);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.CreateOrJoinChatroomUI
 * JD-Core Version:    0.7.0.1
 */