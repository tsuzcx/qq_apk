package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.pk;
import com.tencent.mm.h.b.a.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;

final class ChatroomInfoUI$3
  implements ContactListExpandPreference.a
{
  ChatroomInfoUI$3(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void gh(int paramInt)
  {
    ChatroomInfoUI.l(this.dod);
  }
  
  public final void gi(int paramInt)
  {
    String str = ChatroomInfoUI.m(this.dod).Ed(paramInt);
    Object localObject1 = bk.pm(ChatroomInfoUI.m(this.dod).Ef(paramInt));
    Object localObject2;
    if (bk.bl((String)localObject1))
    {
      g.DQ();
      localObject2 = ((j)g.r(j.class)).Fx().Id(str);
      if ((localObject2 != null) && (!bk.bl(((bv)localObject2).field_encryptUsername))) {
        localObject1 = ((bv)localObject2).field_conRemark;
      }
    }
    for (;;)
    {
      if (bk.bl(str)) {
        return;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", str);
      ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
      if ((ChatroomInfoUI.n(this.dod)) && (ChatroomInfoUI.c(this.dod) != null)) {
        ((Intent)localObject2).putExtra("Contact_RoomNickname", ChatroomInfoUI.c(this.dod).gV(str));
      }
      ((Intent)localObject2).putExtra("Contact_Nick", bk.pm(ChatroomInfoUI.m(this.dod).Ee(paramInt)));
      ((Intent)localObject2).putExtra("Contact_RoomMember", true);
      ((Intent)localObject2).putExtra("room_name", ChatroomInfoUI.o(this.dod).field_username);
      localObject1 = ((j)g.r(j.class)).Fw().abl(str);
      if ((localObject1 != null) && ((int)((com.tencent.mm.n.a)localObject1).dBe > 0) && (com.tencent.mm.n.a.gR(((ao)localObject1).field_type)))
      {
        pk localpk = new pk();
        localpk.bYW.intent = ((Intent)localObject2);
        localpk.bYW.username = str;
        com.tencent.mm.sdk.b.a.udP.m(localpk);
      }
      if (ChatroomInfoUI.n(this.dod))
      {
        h.nFQ.a(219L, 9L, 1L, true);
        if ((localObject1 != null) && (((ad)localObject1).cua())) {
          h.nFQ.aC(10298, ((ao)localObject1).field_username + ",14");
        }
        ((Intent)localObject2).putExtra("Contact_Scene", 14);
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("Is_RoomOwner", ChatroomInfoUI.q(this.dod));
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", ChatroomInfoUI.b(this.dod));
        if (s.hb(ChatroomInfoUI.b(this.dod)))
        {
          localObject1 = new m();
          ((m)localObject1).ciU = ChatroomInfoUI.b(this.dod);
          ((m)localObject1).ciV = 12L;
          ((m)localObject1).QX();
        }
        ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", 8);
        d.b(this.dod, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
        return;
        if (ChatroomInfoUI.p(this.dod))
        {
          ((Intent)localObject2).putExtra("Contact_Scene", 44);
          if (!q.gS(((ao)localObject1).field_username)) {
            ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
          }
        }
      }
    }
  }
  
  public final void gj(int paramInt)
  {
    ChatroomInfoUI.r(this.dod);
  }
  
  public final void xy()
  {
    if (ChatroomInfoUI.m(this.dod) != null) {
      ChatroomInfoUI.m(this.dod).cmP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.3
 * JD-Core Version:    0.7.0.1
 */