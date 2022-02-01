package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cg;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.x;
import java.util.Iterator;
import java.util.List;

public class SeeRoomOwnerManagerUI
  extends MMPreference
{
  private ac fNS;
  private String fRo;
  
  public int getResourceId()
  {
    return 2131951711;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(12909);
    super.onCreate(paramBundle);
    setMMTitle(2131762632);
    setBackBtn(new x()
    {
      public final void Zr()
      {
        AppMethodBeat.i(12906);
        SeeRoomOwnerManagerUI.this.finish();
        AppMethodBeat.o(12906);
      }
    });
    this.fRo = getIntent().getStringExtra("RoomInfo_Id");
    this.fNS = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(bu.nullAsNil(this.fRo));
    String str;
    if (this.fNS != null)
    {
      paramBundle = new PreferenceTitleCategory(getContext());
      paramBundle.setTitle(2131762723);
      getPreferenceScreen().b(paramBundle);
      ae.i("MicroMsg.SeeRoomOwnerManagerUI", "[onCreate] owner:%s", new Object[] { this.fNS.field_roomowner });
      paramBundle = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.fNS.field_roomowner);
      Object localObject = new NormalIconPreference(getContext())
      {
        public final void onBindView(View paramAnonymousView)
        {
          AppMethodBeat.i(12907);
          super.onBindView(paramAnonymousView);
          a.b.a(this.JNh, paramBundle.field_username, 0.15F, false);
          this.JNh.setVisibility(0);
          AppMethodBeat.o(12907);
        }
      };
      ((NormalIconPreference)localObject).setKey(paramBundle.field_username);
      ((NormalIconPreference)localObject).getExtras().putString("username", paramBundle.field_username);
      ((NormalIconPreference)localObject).setTitle(k.c(getContext(), paramBundle.adG()));
      getPreferenceScreen().b((Preference)localObject);
      paramBundle = new PreferenceTitleCategory(getContext());
      paramBundle.setTitle(2131762637);
      localObject = this.fNS.aGE().iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if (this.fNS.aUg(str))
        {
          ae.i("MicroMsg.SeeRoomOwnerManagerUI", "[resetData] Room Manager:%s", new Object[] { str });
          if (i != 0) {
            break label417;
          }
          getPreferenceScreen().b(paramBundle);
          i = 1;
        }
      }
    }
    label417:
    for (;;)
    {
      final an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(str);
      NormalIconPreference local3 = new NormalIconPreference(getContext())
      {
        public final void onBindView(View paramAnonymousView)
        {
          AppMethodBeat.i(12908);
          super.onBindView(paramAnonymousView);
          a.b.a(this.JNh, localan.field_username, 0.15F, false);
          this.JNh.setVisibility(0);
          AppMethodBeat.o(12908);
        }
      };
      local3.setKey(str);
      local3.getExtras().putString("username", localan.field_username);
      local3.setTitle(k.c(getContext(), localan.adG()));
      getPreferenceScreen().b(local3);
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
      localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramf);
      paramPreference = ((aw)localObject1).field_username;
      paramf = ((an)localObject1).adG();
      localObject1 = ((aw)localObject1).field_nickname;
      if (!bu.isNullOrNil(paramf)) {
        break label370;
      }
      localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azG().arE(paramPreference);
      if ((localObject2 == null) || (bu.isNullOrNil(((cg)localObject2).field_encryptUsername))) {
        break label370;
      }
      paramf = ((cg)localObject2).field_conRemark;
    }
    label370:
    for (;;)
    {
      if (!bu.isNullOrNil(paramPreference))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramPreference);
        ((Intent)localObject2).putExtra("Contact_RemarkName", paramf);
        if (this.fNS != null) {
          ((Intent)localObject2).putExtra("Contact_RoomNickname", this.fNS.zP(paramPreference));
        }
        ((Intent)localObject2).putExtra("Contact_Nick", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.fRo);
        paramf = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramPreference);
        if ((paramf != null) && ((int)paramf.ght > 0) && (com.tencent.mm.contact.c.lO(paramf.field_type)))
        {
          localObject1 = new tl();
          ((tl)localObject1).dIV.intent = ((Intent)localObject2);
          ((tl)localObject1).dIV.username = paramPreference;
          a.IvT.l((b)localObject1);
        }
        if ((paramf != null) && (paramf.fug())) {
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, paramf.field_username + ",14");
        }
        ((Intent)localObject2).putExtra("Contact_Scene", 96);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.fRo);
        d.b(this, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomOwnerManagerUI
 * JD-Core Version:    0.7.0.1
 */