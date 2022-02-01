package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.y;
import java.util.Iterator;
import java.util.List;

public class SeeRoomOwnerManagerUI
  extends MMPreference
{
  private ah gtd;
  private String gwx;
  
  public int getResourceId()
  {
    return 2132017256;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(12909);
    super.onCreate(paramBundle);
    setMMTitle(2131764715);
    setBackBtn(new y()
    {
      public final void ane()
      {
        AppMethodBeat.i(12906);
        SeeRoomOwnerManagerUI.this.finish();
        AppMethodBeat.o(12906);
      }
    });
    this.gwx = getIntent().getStringExtra("RoomInfo_Id");
    this.gtd = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(Util.nullAsNil(this.gwx));
    String str;
    if (this.gtd != null)
    {
      paramBundle = new PreferenceTitleCategory(getContext());
      paramBundle.setTitle(2131764806);
      getPreferenceScreen().c(paramBundle);
      Log.i("MicroMsg.SeeRoomOwnerManagerUI", "[onCreate] owner:%s", new Object[] { this.gtd.field_roomowner });
      paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.gtd.field_roomowner);
      Object localObject = new NormalIconPreference(getContext())
      {
        public final void onBindView(View paramAnonymousView)
        {
          AppMethodBeat.i(12907);
          super.onBindView(paramAnonymousView);
          a.b.a(this.OYh, paramBundle.field_username, 0.15F, false);
          this.OYh.setVisibility(0);
          AppMethodBeat.o(12907);
        }
      };
      ((NormalIconPreference)localObject).setKey(paramBundle.field_username);
      ((NormalIconPreference)localObject).getExtras().putString("username", paramBundle.field_username);
      ((NormalIconPreference)localObject).setTitle(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), paramBundle.arJ()));
      getPreferenceScreen().c((Preference)localObject);
      paramBundle = new PreferenceTitleCategory(getContext());
      paramBundle.setTitle(2131764720);
      localObject = this.gtd.bax().iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if (this.gtd.bjf(str))
        {
          Log.i("MicroMsg.SeeRoomOwnerManagerUI", "[resetData] Room Manager:%s", new Object[] { str });
          if (i != 0) {
            break label417;
          }
          getPreferenceScreen().c(paramBundle);
          i = 1;
        }
      }
    }
    label417:
    for (;;)
    {
      final as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
      NormalIconPreference local3 = new NormalIconPreference(getContext())
      {
        public final void onBindView(View paramAnonymousView)
        {
          AppMethodBeat.i(12908);
          super.onBindView(paramAnonymousView);
          a.b.a(this.OYh, localas.field_username, 0.15F, false);
          this.OYh.setVisibility(0);
          AppMethodBeat.o(12908);
        }
      };
      local3.setKey(str);
      local3.getExtras().putString("username", localas.field_username);
      local3.setTitle(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), localas.arJ()));
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
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramf);
      paramPreference = ((ax)localObject1).field_username;
      paramf = ((as)localObject1).arJ();
      localObject1 = ((ax)localObject1).field_nickname;
      if (!Util.isNullOrNil(paramf)) {
        break label370;
      }
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSO().aEZ(paramPreference);
      if ((localObject2 == null) || (Util.isNullOrNil(((cn)localObject2).field_encryptUsername))) {
        break label370;
      }
      paramf = ((cn)localObject2).field_conRemark;
    }
    label370:
    for (;;)
    {
      if (!Util.isNullOrNil(paramPreference))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramPreference);
        ((Intent)localObject2).putExtra("Contact_RemarkName", paramf);
        if (this.gtd != null) {
          ((Intent)localObject2).putExtra("Contact_RoomNickname", this.gtd.getDisplayName(paramPreference));
        }
        ((Intent)localObject2).putExtra("Contact_Nick", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.gwx);
        paramf = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramPreference);
        if ((paramf != null) && ((int)paramf.gMZ > 0) && (com.tencent.mm.contact.c.oR(paramf.field_type)))
        {
          localObject1 = new uj();
          ((uj)localObject1).eaI.intent = ((Intent)localObject2);
          ((uj)localObject1).eaI.username = paramPreference;
          EventCenter.instance.publish((IEvent)localObject1);
        }
        if ((paramf != null) && (paramf.gBM())) {
          h.CyF.kvStat(10298, paramf.field_username + ",14");
        }
        ((Intent)localObject2).putExtra("Contact_Scene", 96);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.gwx);
        com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
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