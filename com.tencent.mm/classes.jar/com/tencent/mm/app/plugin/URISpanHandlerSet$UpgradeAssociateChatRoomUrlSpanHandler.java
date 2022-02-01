package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.base.h;

@URISpanHandlerSet.a
class URISpanHandlerSet$UpgradeAssociateChatRoomUrlSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$UpgradeAssociateChatRoomUrlSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Xp()
  {
    return new int[] { 53 };
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, com.tencent.mm.pluginsdk.ui.span.i parami)
  {
    AppMethodBeat.i(231458);
    if (paramu.type == 53) {
      Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl");
    }
    for (;;)
    {
      int i;
      try
      {
        paramView = Uri.parse(paramu.url).getQueryParameter("roomname");
        if (Util.isNullOrNil(paramView))
        {
          Log.w("MicroMsg.URISpanHandlerSet", "Username is null.");
          AppMethodBeat.o(231458);
          return true;
        }
        if (ab.Eq(paramView))
        {
          parami = ((c)g.af(c.class)).aSX().Kd(paramView);
          if (parami == null)
          {
            Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl %s member is null", new Object[] { paramView });
            AppMethodBeat.o(231458);
            return true;
          }
          Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl room:%s chatroomStatus:%s owener:%s", new Object[] { paramView, Integer.valueOf(parami.field_chatroomStatus), Util.nullAs(parami.field_roomowner, "") });
          if (parami.field_memberCount >= v.aTT())
          {
            i = 1;
            if (!ab.ID(paramView)) {
              break label298;
            }
            if (parami.JO(z.aTY())) {
              break label388;
            }
            Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：no owner");
            if (URISpanHandlerSet.a(this.dnW) != null)
            {
              h.a(URISpanHandlerSet.a(this.dnW), URISpanHandlerSet.a(this.dnW).getString(2131757314), "", URISpanHandlerSet.a(this.dnW).getString(2131755873), false, null);
              break label614;
              ManagerRoomByWeworkUI.c(paramView, 2, 2, j);
              AppMethodBeat.o(231458);
              return true;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
        }
      }
      catch (Exception paramView)
      {
        Log.e("MicroMsg.URISpanHandlerSet", "handle click link error: %s, url: %s", new Object[] { paramView.getMessage(), paramu.url });
      }
      for (;;)
      {
        AppMethodBeat.o(231458);
        return true;
        label298:
        if ((ab.IB(paramView)) && (!parami.JO(z.aTY())))
        {
          Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：isAssociateChatRoom ");
          if (URISpanHandlerSet.a(this.dnW) != null) {
            h.a(URISpanHandlerSet.a(this.dnW), URISpanHandlerSet.a(this.dnW).getString(2131757311), "", URISpanHandlerSet.a(this.dnW).getString(2131755873), false, null);
          }
          for (;;)
          {
            AppMethodBeat.o(231458);
            return true;
            Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
          }
        }
        label388:
        if (i != 0)
        {
          Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：exceed maxnum");
          if (URISpanHandlerSet.a(this.dnW) != null) {
            h.a(URISpanHandlerSet.a(this.dnW), URISpanHandlerSet.a(this.dnW).getString(2131757312), "", URISpanHandlerSet.a(this.dnW).getString(2131755873), false, null);
          }
          for (;;)
          {
            ManagerRoomByWeworkUI.c(paramView, 2, 2, 2);
            AppMethodBeat.o(231458);
            return true;
            Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
          }
        }
        com.tencent.mm.plugin.newtips.a.exl().TC(25);
        com.tencent.mm.plugin.newtips.a.exl().TC(26);
        com.tencent.mm.plugin.newtips.a.exl().TC(27);
        parami = new Intent();
        parami.setClass(MMApplicationContext.getContext(), ManagerRoomByWeworkUI.class);
        parami.addFlags(268435456);
        parami.putExtra("RoomInfo_Id", paramView);
        parami.putExtra("upgrade_openim_room_from_scene", 2);
        paramView = MMApplicationContext.getContext();
        parami = new com.tencent.mm.hellhoundlib.b.a().bl(parami);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, parami.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$UpgradeAssociateChatRoomUrlSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)parami.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/app/plugin/URISpanHandlerSet$UpgradeAssociateChatRoomUrlSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(231458);
      return false;
      label614:
      int j = 1;
      if (i != 0) {
        j = 3;
      }
    }
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
  {
    AppMethodBeat.i(179565);
    if (paramString.trim().toLowerCase().startsWith("weixin://weixingroupupdate?"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 53, null);
      AppMethodBeat.o(179565);
      return paramString;
    }
    AppMethodBeat.o(179565);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.UpgradeAssociateChatRoomUrlSpanHandler
 * JD-Core Version:    0.7.0.1
 */