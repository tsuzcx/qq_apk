package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.pk;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.v;
import java.util.Iterator;
import java.util.List;

public class SeeRoomOwnerManagerUI
  extends MMPreference
{
  private u dnL;
  private String dpj;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    Object localObject1;
    Object localObject2;
    if ((paramPreference instanceof NormalIconPreference))
    {
      paramf = paramPreference.getExtras().getString("username");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramf);
      paramPreference = ((ao)localObject1).field_username;
      paramf = ((ad)localObject1).Bq();
      localObject1 = ((ao)localObject1).field_nickname;
      if (!bk.bl(paramf)) {
        break label349;
      }
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fx().Id(paramPreference);
      if ((localObject2 == null) || (bk.bl(((bv)localObject2).field_encryptUsername))) {
        break label349;
      }
      paramf = ((bv)localObject2).field_conRemark;
    }
    label349:
    for (;;)
    {
      if (!bk.bl(paramPreference))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramPreference);
        ((Intent)localObject2).putExtra("Contact_RemarkName", paramf);
        if (this.dnL != null) {
          ((Intent)localObject2).putExtra("Contact_RoomNickname", this.dnL.gV(paramPreference));
        }
        ((Intent)localObject2).putExtra("Contact_Nick", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.dpj);
        paramf = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramPreference);
        if ((paramf != null) && ((int)paramf.dBe > 0) && (com.tencent.mm.n.a.gR(paramf.field_type)))
        {
          localObject1 = new pk();
          ((pk)localObject1).bYW.intent = ((Intent)localObject2);
          ((pk)localObject1).bYW.username = paramPreference;
          com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
        }
        if ((paramf != null) && (paramf.cua())) {
          h.nFQ.aC(10298, paramf.field_username + ",14");
        }
        ((Intent)localObject2).putExtra("Contact_Scene", 96);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.dpj);
        d.b(this, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      }
      return false;
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.room_manager_owner_title);
    setBackBtn(new v()
    {
      public final void xQ()
      {
        SeeRoomOwnerManagerUI.this.finish();
      }
    });
    this.dpj = getIntent().getStringExtra("RoomInfo_Id");
    this.dnL = ((c)g.r(c.class)).FF().in(bk.pm(this.dpj));
    String str;
    if (this.dnL != null)
    {
      paramBundle = new PreferenceTitleCategory(this.mController.uMN);
      paramBundle.setTitle(a.i.room_upgrade_owner);
      this.vdd.a(paramBundle);
      y.i("MicroMsg.SeeRoomOwnerManagerUI", "[onCreate] owner:%s", new Object[] { this.dnL.field_roomowner });
      paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.dnL.field_roomowner);
      Object localObject = new NormalIconPreference(this.mController.uMN)
      {
        protected final void onBindView(View paramAnonymousView)
        {
          super.onBindView(paramAnonymousView);
          a.b.a(this.vcD, paramBundle.field_username, 0.15F, false);
          this.vcD.setVisibility(0);
        }
      };
      ((NormalIconPreference)localObject).setKey(paramBundle.field_username);
      ((NormalIconPreference)localObject).getExtras().putString("username", paramBundle.field_username);
      ((NormalIconPreference)localObject).setTitle(com.tencent.mm.pluginsdk.ui.d.j.b(this.mController.uMN, paramBundle.Bq()));
      this.vdd.a((Preference)localObject);
      paramBundle = new PreferenceTitleCategory(this.mController.uMN);
      paramBundle.setTitle(a.i.room_manager_title);
      localObject = this.dnL.MN().iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if (this.dnL.aaM(str))
        {
          y.i("MicroMsg.SeeRoomOwnerManagerUI", "[resetData] Room Manager:%s", new Object[] { str });
          if (i != 0) {
            break label430;
          }
          this.vdd.a(paramBundle);
          i = 1;
        }
      }
    }
    label430:
    for (;;)
    {
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(str);
      SeeRoomOwnerManagerUI.3 local3 = new SeeRoomOwnerManagerUI.3(this, this.mController.uMN, localad);
      local3.setKey(str);
      local3.getExtras().putString("username", localad.field_username);
      local3.setTitle(com.tencent.mm.pluginsdk.ui.d.j.b(this.mController.uMN, localad.Bq()));
      this.vdd.a(local3);
      break;
      this.vdd.notifyDataSetChanged();
      return;
    }
  }
  
  public final int xj()
  {
    return a.k.see_ower_manage_room_ui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomOwnerManagerUI
 * JD-Core Version:    0.7.0.1
 */