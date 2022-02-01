package com.tencent.mm.plugin.game.ui.chat_tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.fp;
import com.tencent.mm.game.report.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.autogen.chatroom.GetFirstEnterInfoRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetFirstEnterInfoResponse;
import com.tencent.mm.plugin.game.chatroom.f.h;
import com.tencent.mm.plugin.game.chatroom.ui.ChatRoomBaseUI;
import com.tencent.mm.plugin.game.chatroom.view.ChatRoomListView;
import com.tencent.mm.plugin.game.chatroom.view.ChatRoomListView.4;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.h;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.plugin.game.model.o.d;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMFragmentActivity.a;

public class ChatRoomTabUI
  extends ChatRoomBaseUI
{
  private long Cuy;
  private long Cuz;
  private a Dbb;
  private String Dbc;
  private ChatTabTopArea Dbd;
  private ChatRoomListView Dbe;
  
  public ChatRoomTabUI()
  {
    AppMethodBeat.i(198718);
    this.Dbb = new a(this);
    AppMethodBeat.o(198718);
  }
  
  public final long evK()
  {
    return 1099L;
  }
  
  public final long evL()
  {
    return 10L;
  }
  
  public final long evM()
  {
    return this.Cuy;
  }
  
  public final long evN()
  {
    return this.Cuz;
  }
  
  public int getCustomBounceId()
  {
    return g.e.Ckv;
  }
  
  public int getLayoutId()
  {
    return g.f.CmJ;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(198756);
    super.onBackPressed();
    this.Dbb.onBackPressed();
    AppMethodBeat.o(198756);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(198765);
    super.onConfigurationChanged(paramConfiguration);
    this.Dbb.cN();
    AppMethodBeat.o(198765);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198745);
    Object localObject1 = getIntent().getExtras();
    if (localObject1 != null)
    {
      if (!((Bundle)localObject1).containsKey("game_report_ssid")) {
        getIntent().putExtra("game_report_ssid", getIntent().getIntExtra("game_report_from_scene", 0));
      }
      if (!((Bundle)localObject1).containsKey("game_report_sourceid")) {
        getIntent().putExtra("game_report_sourceid", 0L);
      }
      this.Cuy = getIntent().getLongExtra("game_report_ssid", 0L);
      this.Cuz = getIntent().getLongExtra("game_report_sourceid", 0L);
    }
    Object localObject2 = "";
    Object localObject3 = getIntent().getStringExtra("game_tab_entrance_msgid");
    localObject1 = d.jTj;
    d.LY("");
    localObject1 = localObject2;
    if (!Util.isNullOrNil((String)localObject3))
    {
      localObject3 = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().aJW((String)localObject3);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        ((o)localObject3).eyt();
        localObject1 = ((o)localObject3).CJS.CKh.CKd;
        localObject2 = d.jTj;
        d.LY(((o)localObject3).CJX);
      }
    }
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("game_from_detail_back", false)) {
      overridePendingTransition(MMFragmentActivity.a.ria, MMFragmentActivity.a.rib);
    }
    getSupportActionBar().hide();
    this.Dbb.a(getContentView(), new c.a()
    {
      public final void TW(int paramAnonymousInt)
      {
        AppMethodBeat.i(190388);
        if ((ChatRoomTabUI.a(ChatRoomTabUI.this).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
        {
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)ChatRoomTabUI.a(ChatRoomTabUI.this).getLayoutParams();
          localMarginLayoutParams.bottomMargin = paramAnonymousInt;
          ChatRoomTabUI.a(ChatRoomTabUI.this).setLayoutParams(localMarginLayoutParams);
        }
        AppMethodBeat.o(190388);
      }
      
      public final void aKq(String paramAnonymousString)
      {
        AppMethodBeat.i(190393);
        ChatRoomTabUI.a(ChatRoomTabUI.this, paramAnonymousString);
        AppMethodBeat.o(190393);
      }
    });
    paramBundle = (CustomTabActionBar)findViewById(g.e.Cku);
    paramBundle.setTitle(g.i.Cqg);
    paramBundle.setBackBtn(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205162);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ChatRoomTabUI.b(ChatRoomTabUI.this).evQ();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205162);
      }
    });
    int i = g.h.icons_outlined_me;
    localObject2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(206710);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = com.tencent.mm.game.report.c.jTf;
        com.tencent.mm.game.report.c.a.Fp(ChatRoomTabUI.this.getIntent().getIntExtra("game_report_from_scene", 0));
        com.tencent.mm.plugin.game.d.c.aY(ChatRoomTabUI.this, ChatRoomTabUI.c(ChatRoomTabUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(206710);
      }
    };
    paramBundle.CvS.setVisibility(0);
    paramBundle.CvS.setImageResource(i);
    paramBundle.CvS.setOnClickListener((View.OnClickListener)localObject2);
    this.Dbd = new ChatTabTopArea(this);
    this.Dbe = ((ChatRoomListView)findViewById(g.e.Ckv));
    this.Dbe.dI(this.Dbd);
    paramBundle = this.Dbe;
    localObject2 = paramBundle.Cxf;
    Log.i("GameChatRoom.GetMyChatRoomKeepAliveService", "startKeepAlive, topChatRoomName:%s", new Object[] { localObject1 });
    h.aGY().a(4989, (i)localObject2);
    ((com.tencent.mm.plugin.game.chatroom.g.b)localObject2).g(null, Util.nullAsNil((String)localObject1), "");
    if (Util.nullAsNil((Integer)h.aHG().aHp().get(ar.a.Vrq, Integer.valueOf(0))) <= 0)
    {
      localObject1 = new com.tencent.mm.an.d.a();
      ((com.tencent.mm.an.d.a)localObject1).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getfirstenterinfo";
      ((com.tencent.mm.an.d.a)localObject1).funcId = 5139;
      ((com.tencent.mm.an.d.a)localObject1).lBW = 0;
      ((com.tencent.mm.an.d.a)localObject1).respCmdId = 0;
      localObject2 = new GetFirstEnterInfoRequest();
      if (paramBundle.CvP != null) {
        ((GetFirstEnterInfoRequest)localObject2).lbs_info = paramBundle.CvP;
      }
      ((com.tencent.mm.an.d.a)localObject1).lBU = ((com.tencent.mm.cd.a)localObject2);
      ((com.tencent.mm.an.d.a)localObject1).lBV = new GetFirstEnterInfoResponse();
      aa.a(((com.tencent.mm.an.d.a)localObject1).bgN(), new ChatRoomListView.4(paramBundle, (GetFirstEnterInfoRequest)localObject2));
    }
    if (com.tencent.mm.pluginsdk.permission.b.o(paramBundle.mContext, "android.permission.ACCESS_FINE_LOCATION")) {
      paramBundle.sd(true);
    }
    for (;;)
    {
      if (Util.nullAsNil((Long)h.aHG().aHp().get(ar.a.Vrr, Long.valueOf(0L))) == 0L) {
        h.aHG().aHp().set(ar.a.Vrr, Long.valueOf(Util.nowSecond()));
      }
      paramBundle = d.jTj;
      com.tencent.mm.game.report.d.a.a(10L, 0L, 0L, 1L, 0L, this.Cuy, 0L).bpa();
      AppMethodBeat.o(198745);
      return;
      if (Util.nullAsNil((Integer)h.aHG().aHp().get(ar.a.Vrs, Integer.valueOf(0))) > 0)
      {
        paramBundle.sd(false);
      }
      else
      {
        boolean bool1;
        if (com.tencent.mm.az.b.WF((String)h.aHG().aHp().b(274436, null)))
        {
          boolean bool2 = com.tencent.mm.pluginsdk.permission.b.o(paramBundle.mContext, "android.permission.ACCESS_FINE_LOCATION");
          bool1 = bool2;
          if (!bool2)
          {
            if (((Boolean)h.aHG().aHp().get(ar.a.VvE, Boolean.FALSE)).booleanValue()) {
              break label770;
            }
            com.tencent.mm.plugin.account.sdk.b.a.b(paramBundle.mContext, paramBundle.mContext.getString(f.h.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
            label756:
            bool1 = false;
          }
        }
        for (;;)
        {
          if (!bool1) {
            break label844;
          }
          paramBundle.sd(true);
          break;
          label770:
          com.tencent.mm.pluginsdk.permission.b.b((Activity)paramBundle.mContext, "android.permission.ACCESS_FINE_LOCATION", 160);
          break label756;
          bool1 = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramBundle.mContext, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 160, null, null);
          Log.i("MicroMsg.ChatRoomListView", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool1) });
        }
        label844:
        h.aHG().aHp().set(ar.a.Vrs, Integer.valueOf(1));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(198758);
    super.onDestroy();
    com.tencent.mm.game.report.d.a locala = d.jTj;
    d.LY("");
    this.Dbb.onDestroy();
    AppMethodBeat.o(198758);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(198754);
    super.onNewIntent(paramIntent);
    this.Dbb.onNewIntent(paramIntent);
    AppMethodBeat.o(198754);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(198752);
    super.onPause();
    a.onPause();
    AppMethodBeat.o(198752);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(198768);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.ChatRoomTabUI", "dont have any permission");
      this.Dbe.sd(false);
      AppMethodBeat.o(198768);
      return;
    }
    if (paramInt == 160)
    {
      if (paramArrayOfInt[0] == 0)
      {
        this.Dbe.sd(true);
        AppMethodBeat.o(198768);
        return;
      }
      this.Dbe.sd(false);
    }
    AppMethodBeat.o(198768);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(198748);
    super.onResume();
    this.Dbb.onResume();
    this.Dbd.Dbm.ezH();
    AppMethodBeat.o(198748);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    AppMethodBeat.i(198747);
    if (!getIntent().getBooleanExtra("disable_game_page_swipe", false))
    {
      AppMethodBeat.o(198747);
      return true;
    }
    AppMethodBeat.o(198747);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.ChatRoomTabUI
 * JD-Core Version:    0.7.0.1
 */