package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import java.util.List;

public class SeeRoomOwnerManagerUI
  extends MMPreference
{
  private com.tencent.mm.storage.u efi;
  private String egF;
  
  public int getResourceId()
  {
    return 2131165268;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(104368);
    super.onCreate(paramBundle);
    setMMTitle(2131302721);
    setBackBtn(new com.tencent.mm.ui.u()
    {
      public final void Ki()
      {
        AppMethodBeat.i(104365);
        SeeRoomOwnerManagerUI.this.finish();
        AppMethodBeat.o(104365);
      }
    });
    this.egF = getIntent().getStringExtra("RoomInfo_Id");
    this.efi = ((c)g.E(c.class)).YJ().oU(bo.nullAsNil(this.egF));
    String str;
    if (this.efi != null)
    {
      paramBundle = new PreferenceTitleCategory(getContext());
      paramBundle.setTitle(2131302811);
      getPreferenceScreen().b(paramBundle);
      ab.i("MicroMsg.SeeRoomOwnerManagerUI", "[onCreate] owner:%s", new Object[] { this.efi.field_roomowner });
      paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.efi.field_roomowner);
      Object localObject = new NormalIconPreference(getContext())
      {
        public final void onBindView(View paramAnonymousView)
        {
          AppMethodBeat.i(104366);
          super.onBindView(paramAnonymousView);
          a.b.a(this.zrd, paramBundle.field_username, 0.15F, false);
          this.zrd.setVisibility(0);
          AppMethodBeat.o(104366);
        }
      };
      ((NormalIconPreference)localObject).setKey(paramBundle.field_username);
      ((NormalIconPreference)localObject).getExtras().putString("username", paramBundle.field_username);
      ((NormalIconPreference)localObject).setTitle(com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), paramBundle.Of()));
      getPreferenceScreen().b((Preference)localObject);
      paramBundle = new PreferenceTitleCategory(getContext());
      paramBundle.setTitle(2131302726);
      localObject = this.efi.afx().iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if (this.efi.aqW(str))
        {
          ab.i("MicroMsg.SeeRoomOwnerManagerUI", "[resetData] Room Manager:%s", new Object[] { str });
          if (i != 0) {
            break label415;
          }
          getPreferenceScreen().b(paramBundle);
          i = 1;
        }
      }
    }
    label415:
    for (;;)
    {
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(str);
      SeeRoomOwnerManagerUI.3 local3 = new SeeRoomOwnerManagerUI.3(this, getContext(), localad);
      local3.setKey(str);
      local3.getExtras().putString("username", localad.field_username);
      local3.setTitle(com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), localad.Of()));
      getPreferenceScreen().b(local3);
      break;
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(104368);
      return;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(104369);
    Object localObject1;
    Object localObject2;
    if ((paramPreference instanceof NormalIconPreference))
    {
      paramf = paramPreference.getExtras().getString("username");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramf);
      paramPreference = ((aq)localObject1).field_username;
      paramf = ((ad)localObject1).Of();
      localObject1 = ((aq)localObject1).field_nickname;
      if (!bo.isNullOrNil(paramf)) {
        break label368;
      }
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YB().TM(paramPreference);
      if ((localObject2 == null) || (bo.isNullOrNil(((bv)localObject2).field_encryptUsername))) {
        break label368;
      }
      paramf = ((bv)localObject2).field_conRemark;
    }
    label368:
    for (;;)
    {
      if (!bo.isNullOrNil(paramPreference))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramPreference);
        ((Intent)localObject2).putExtra("Contact_RemarkName", paramf);
        if (this.efi != null) {
          ((Intent)localObject2).putExtra("Contact_RoomNickname", this.efi.nE(paramPreference));
        }
        ((Intent)localObject2).putExtra("Contact_Nick", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.egF);
        paramf = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramPreference);
        if ((paramf != null) && ((int)paramf.euF > 0) && (com.tencent.mm.n.a.je(paramf.field_type)))
        {
          localObject1 = new qr();
          ((qr)localObject1).cHh.intent = ((Intent)localObject2);
          ((qr)localObject1).cHh.username = paramPreference;
          com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
        }
        if ((paramf != null) && (paramf.dwz())) {
          h.qsU.kvStat(10298, paramf.field_username + ",14");
        }
        ((Intent)localObject2).putExtra("Contact_Scene", 96);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.egF);
        d.b(this, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      }
      AppMethodBeat.o(104369);
      return false;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomOwnerManagerUI
 * JD-Core Version:    0.7.0.1
 */