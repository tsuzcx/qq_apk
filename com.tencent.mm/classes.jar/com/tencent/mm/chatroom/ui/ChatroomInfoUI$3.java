package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;

final class ChatroomInfoUI$3
  implements ContactListExpandPreference.a
{
  ChatroomInfoUI$3(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void JR()
  {
    AppMethodBeat.i(103965);
    if (ChatroomInfoUI.m(this.efA) != null) {
      ChatroomInfoUI.m(this.efA).dnF();
    }
    AppMethodBeat.o(103965);
  }
  
  public final void iw(int paramInt)
  {
    AppMethodBeat.i(103963);
    ChatroomInfoUI.l(this.efA);
    AppMethodBeat.o(103963);
  }
  
  public final void ix(int paramInt)
  {
    AppMethodBeat.i(103964);
    String str = ChatroomInfoUI.m(this.efA).Mb(paramInt);
    Object localObject1 = bo.nullAsNil(ChatroomInfoUI.m(this.efA).Md(paramInt));
    Object localObject2;
    if (bo.isNullOrNil((String)localObject1))
    {
      g.RM();
      localObject2 = ((j)g.E(j.class)).YB().TM(str);
      if ((localObject2 != null) && (!bo.isNullOrNil(((bv)localObject2).field_encryptUsername))) {
        localObject1 = ((bv)localObject2).field_conRemark;
      }
    }
    for (;;)
    {
      if (bo.isNullOrNil(str))
      {
        AppMethodBeat.o(103964);
        return;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", str);
      ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
      if ((ChatroomInfoUI.n(this.efA)) && (ChatroomInfoUI.c(this.efA) != null)) {
        ((Intent)localObject2).putExtra("Contact_RoomNickname", ChatroomInfoUI.c(this.efA).nE(str));
      }
      ((Intent)localObject2).putExtra("Contact_Nick", bo.nullAsNil(ChatroomInfoUI.m(this.efA).Mc(paramInt)));
      ((Intent)localObject2).putExtra("Contact_RoomMember", true);
      ((Intent)localObject2).putExtra("room_name", ChatroomInfoUI.o(this.efA).field_username);
      localObject1 = ((j)g.E(j.class)).YA().arw(str);
      if ((localObject1 != null) && ((int)((com.tencent.mm.n.a)localObject1).euF > 0) && (com.tencent.mm.n.a.je(((aq)localObject1).field_type)))
      {
        qr localqr = new qr();
        localqr.cHh.intent = ((Intent)localObject2);
        localqr.cHh.username = str;
        com.tencent.mm.sdk.b.a.ymk.l(localqr);
      }
      if (ChatroomInfoUI.n(this.efA))
      {
        h.qsU.idkeyStat(219L, 9L, 1L, true);
        if ((localObject1 != null) && (((ad)localObject1).dwz())) {
          h.qsU.kvStat(10298, ((aq)localObject1).field_username + ",14");
        }
        ((Intent)localObject2).putExtra("Contact_Scene", 14);
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("Is_RoomOwner", ChatroomInfoUI.q(this.efA));
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", ChatroomInfoUI.b(this.efA));
        if (t.nK(ChatroomInfoUI.b(this.efA)))
        {
          localObject1 = new v();
          ((v)localObject1).fq(ChatroomInfoUI.b(this.efA));
          ((v)localObject1).cTE = 12L;
          ((v)localObject1).ake();
        }
        ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", 8);
        d.b(this.efA, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
        AppMethodBeat.o(103964);
        return;
        if (ChatroomInfoUI.p(this.efA))
        {
          ((Intent)localObject2).putExtra("Contact_Scene", 44);
          if (!r.nB(((aq)localObject1).field_username)) {
            ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
          }
        }
      }
    }
  }
  
  public final void iy(int paramInt)
  {
    AppMethodBeat.i(103966);
    ChatroomInfoUI.r(this.efA);
    AppMethodBeat.o(103966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.3
 * JD-Core Version:    0.7.0.1
 */