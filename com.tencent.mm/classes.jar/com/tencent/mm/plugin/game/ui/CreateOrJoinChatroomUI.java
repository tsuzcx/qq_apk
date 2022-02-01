package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom.Resp;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.protobuf.am;
import com.tencent.mm.plugin.game.protobuf.an;
import com.tencent.mm.plugin.game.protobuf.bb;
import com.tencent.mm.plugin.game.protobuf.bc;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.k;

@a(7)
public class CreateOrJoinChatroomUI
  extends MMBaseActivity
{
  private String IMQ;
  private String IMR;
  private String IMS;
  private String IMT;
  private int IMU = 1;
  private String eb;
  private String mAppId;
  private String mPackageName;
  private ProgressDialog osY = null;
  private String qgV;
  
  private void XF(int paramInt)
  {
    AppMethodBeat.i(41868);
    Object localObject1 = h.s(this.mAppId, true, false);
    Bundle localBundle = new Bundle();
    Object localObject2;
    if (this.eb.equals("action_create"))
    {
      localObject2 = new CreateChatroom.Resp();
      if (localObject1 != null) {
        ((CreateChatroom.Resp)localObject2).openId = ((g)localObject1).field_openId;
      }
      ((CreateChatroom.Resp)localObject2).transaction = this.IMQ;
      ((CreateChatroom.Resp)localObject2).extMsg = this.IMT;
      ((CreateChatroom.Resp)localObject2).errCode = paramInt;
      ((CreateChatroom.Resp)localObject2).toBundle(localBundle);
    }
    for (;;)
    {
      localObject1 = new MMessageActV2.Args();
      ((MMessageActV2.Args)localObject1).targetPkgName = this.mPackageName;
      ((MMessageActV2.Args)localObject1).bundle = localBundle;
      u.bS(localBundle);
      u.bT(localBundle);
      MMessageActV2.send(MMApplicationContext.getContext(), (MMessageActV2.Args)localObject1);
      AppMethodBeat.o(41868);
      return;
      if (this.eb.equals("action_join"))
      {
        localObject2 = new JoinChatroom.Resp();
        if (localObject1 != null) {
          ((JoinChatroom.Resp)localObject2).openId = ((g)localObject1).field_openId;
        }
        ((JoinChatroom.Resp)localObject2).transaction = this.IMQ;
        ((JoinChatroom.Resp)localObject2).extMsg = this.IMT;
        ((JoinChatroom.Resp)localObject2).errCode = paramInt;
        ((JoinChatroom.Resp)localObject2).toBundle(localBundle);
      }
    }
  }
  
  private void fHk()
  {
    AppMethodBeat.i(41866);
    if ((this.osY != null) && (this.osY.isShowing())) {
      this.osY.cancel();
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
      XF(0);
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
          r.a.XNV.b(this, paramIntent, true, null);
        }
      }
      else if (paramInt2 == 0) {
        XF(-2);
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
    this.eb = paramBundle.getStringExtra("action");
    this.mPackageName = paramBundle.getStringExtra("package_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    this.IMQ = paramBundle.getStringExtra("key_transaction");
    this.IMR = paramBundle.getStringExtra("group_id");
    this.IMS = paramBundle.getStringExtra("chatroom_name");
    this.qgV = paramBundle.getStringExtra("chatroom_nickname");
    this.IMT = paramBundle.getStringExtra("ext_msg");
    if ((Util.isNullOrNil(this.eb)) || (Util.isNullOrNil(this.mAppId)) || (Util.isNullOrNil(this.IMR)))
    {
      Log.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
      finish();
      AppMethodBeat.o(41864);
      return;
    }
    this.osY = k.a(this, getBaseContext().getString(h.i.Icb), true, null);
    c localc;
    Object localObject;
    if (this.eb.equals("action_create"))
    {
      Log.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", new Object[] { this.mAppId, this.IMR, this.IMS });
      paramBundle = new c.a();
      paramBundle.otE = new am();
      paramBundle.otF = new an();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
      paramBundle.funcId = 1205;
      localc = paramBundle.bEF();
      localObject = (am)c.b.b(localc.otB);
      ((am)localObject).muA = this.mAppId;
      ((am)localObject).IIA = this.IMR;
      if (this.IMS == null)
      {
        paramBundle = new byte[0];
        ((am)localObject).IIB = new b(paramBundle);
        if (this.qgV != null) {
          break label372;
        }
      }
      label372:
      for (paramBundle = new byte[0];; paramBundle = this.qgV.getBytes())
      {
        ((am)localObject).IIC = new b(paramBundle);
        z.a(localc, new z.a()
        {
          public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
          {
            AppMethodBeat.i(41862);
            paramAnonymousc = (an)c.c.b(paramAnonymousc.otC);
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              Log.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if (paramAnonymousInt1 == 4) {
                CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousc.ytv);
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
            paramAnonymousString = paramAnonymousc.IID;
            Log.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", new Object[] { paramAnonymousString });
            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this);
            CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousString);
            AppMethodBeat.o(41862);
            return 0;
          }
        });
        AppMethodBeat.o(41864);
        return;
        paramBundle = this.IMS.getBytes();
        break;
      }
    }
    if (this.eb.equals("action_join"))
    {
      paramBundle = new c.a();
      paramBundle.otE = new bb();
      paramBundle.otF = new bc();
      paramBundle.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
      paramBundle.funcId = 1206;
      localc = paramBundle.bEF();
      localObject = (bb)c.b.b(localc.otB);
      ((bb)localObject).muA = this.mAppId;
      ((bb)localObject).IIA = this.IMR;
      if (this.qgV != null) {
        break label513;
      }
    }
    label513:
    for (paramBundle = new byte[0];; paramBundle = this.qgV.getBytes())
    {
      ((bb)localObject).IIC = new b(paramBundle);
      z.a(localc, new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
        {
          AppMethodBeat.i(41863);
          paramAnonymousc = (bc)c.c.b(paramAnonymousc.otC);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            if (paramAnonymousInt1 == 4) {
              CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, paramAnonymousc.ytv);
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
          paramAnonymousString = paramAnonymousc.IJn;
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
    fHk();
    super.onDestroy();
    AppMethodBeat.o(41865);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.CreateOrJoinChatroomUI
 * JD-Core Version:    0.7.0.1
 */