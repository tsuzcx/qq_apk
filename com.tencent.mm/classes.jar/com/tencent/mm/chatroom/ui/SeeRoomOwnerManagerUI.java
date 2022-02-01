package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xc;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.ad;
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
  private String lyn;
  private aj lzy;
  
  public int getResourceId()
  {
    return a.k.lJZ;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(12909);
    super.onCreate(paramBundle);
    setMMTitle(a.i.lIt);
    setBackBtn(new ad()
    {
      public final void d(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(241482);
        SeeRoomOwnerManagerUI.this.finish();
        AppMethodBeat.o(241482);
      }
    });
    this.lyn = getIntent().getStringExtra("RoomInfo_Id");
    this.lzy = ((b)com.tencent.mm.kernel.h.ax(b.class)).bzK().Ju(Util.nullAsNil(this.lyn));
    String str;
    if (this.lzy != null)
    {
      paramBundle = new PreferenceTitleCategory(getContext());
      paramBundle.setTitle(a.i.lJk);
      getPreferenceScreen().c(paramBundle);
      Log.i("MicroMsg.SeeRoomOwnerManagerUI", "[onCreate] owner:%s", new Object[] { this.lzy.field_roomowner });
      paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.lzy.field_roomowner);
      Object localObject = new NormalIconPreference(getContext())
      {
        public final void onBindView(View paramAnonymousView)
        {
          AppMethodBeat.i(12907);
          super.onBindView(paramAnonymousView);
          a.b.a(jnn(), paramBundle.field_username, 0.15F, false);
          jnn().setVisibility(0);
          AppMethodBeat.o(12907);
        }
      };
      ((NormalIconPreference)localObject).setKey(paramBundle.field_username);
      ((NormalIconPreference)localObject).getExtras().putString("username", paramBundle.field_username);
      ((NormalIconPreference)localObject).setTitle(p.b(getContext(), paramBundle.aSV()));
      getPreferenceScreen().c((Preference)localObject);
      paramBundle = new PreferenceTitleCategory(getContext());
      paramBundle.setTitle(a.i.lIu);
      localObject = this.lzy.bHw().iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if (this.lzy.bvK(str))
        {
          Log.i("MicroMsg.SeeRoomOwnerManagerUI", "[resetData] Room Manager:%s", new Object[] { str });
          if (i != 0) {
            break label420;
          }
          getPreferenceScreen().c(paramBundle);
          i = 1;
        }
      }
    }
    label420:
    for (;;)
    {
      final au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(str);
      NormalIconPreference local3 = new NormalIconPreference(getContext())
      {
        public final void onBindView(View paramAnonymousView)
        {
          AppMethodBeat.i(12908);
          super.onBindView(paramAnonymousView);
          a.b.a(jnn(), localau.field_username, 0.15F, false);
          jnn().setVisibility(0);
          AppMethodBeat.o(12908);
        }
      };
      local3.setKey(str);
      local3.getExtras().putString("username", localau.field_username);
      local3.setTitle(p.b(getContext(), localau.aSV()));
      getPreferenceScreen().c(local3);
      break;
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(12909);
      return;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(12910);
    Object localObject1;
    Object localObject2;
    if ((paramPreference instanceof NormalIconPreference))
    {
      paramf = paramPreference.getExtras().getString("username");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramf);
      paramPreference = ((az)localObject1).field_username;
      paramf = ((au)localObject1).aSV();
      localObject1 = ((az)localObject1).field_nickname;
      if (!Util.isNullOrNil(paramf)) {
        break label370;
      }
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB().aMi(paramPreference);
      if ((localObject2 == null) || (Util.isNullOrNil(((cr)localObject2).field_encryptUsername))) {
        break label370;
      }
      paramf = ((cr)localObject2).field_conRemark;
    }
    label370:
    for (;;)
    {
      if (!Util.isNullOrNil(paramPreference))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramPreference);
        ((Intent)localObject2).putExtra("Contact_RemarkName", paramf);
        if (this.lzy != null) {
          ((Intent)localObject2).putExtra("Contact_RoomNickname", this.lzy.getDisplayName(paramPreference));
        }
        ((Intent)localObject2).putExtra("Contact_Nick", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.lyn);
        paramf = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramPreference);
        if ((paramf != null) && ((int)paramf.maN > 0) && (d.rs(paramf.field_type)))
        {
          localObject1 = new xc();
          ((xc)localObject1).iaC.intent = ((Intent)localObject2);
          ((xc)localObject1).iaC.username = paramPreference;
          ((xc)localObject1).publish();
        }
        if ((paramf != null) && (paramf.iZC())) {
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramf.field_username + ",14");
        }
        ((Intent)localObject2).putExtra("Contact_Scene", 96);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.lyn);
        c.b(this, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      }
      AppMethodBeat.o(12910);
      return false;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomOwnerManagerUI
 * JD-Core Version:    0.7.0.1
 */