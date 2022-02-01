package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.cf;
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
  private ab fLO;
  private String fPi;
  
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
      public final void Zi()
      {
        AppMethodBeat.i(12906);
        SeeRoomOwnerManagerUI.this.finish();
        AppMethodBeat.o(12906);
      }
    });
    this.fPi = getIntent().getStringExtra("RoomInfo_Id");
    this.fLO = ((c)com.tencent.mm.kernel.g.ab(c.class)).azz().AN(bt.nullAsNil(this.fPi));
    String str;
    if (this.fLO != null)
    {
      paramBundle = new PreferenceTitleCategory(getContext());
      paramBundle.setTitle(2131762723);
      getPreferenceScreen().b(paramBundle);
      ad.i("MicroMsg.SeeRoomOwnerManagerUI", "[onCreate] owner:%s", new Object[] { this.fLO.field_roomowner });
      paramBundle = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.fLO.field_roomowner);
      Object localObject = new NormalIconPreference(getContext())
      {
        public final void onBindView(View paramAnonymousView)
        {
          AppMethodBeat.i(12907);
          super.onBindView(paramAnonymousView);
          a.b.a(this.Jss, paramBundle.field_username, 0.15F, false);
          this.Jss.setVisibility(0);
          AppMethodBeat.o(12907);
        }
      };
      ((NormalIconPreference)localObject).setKey(paramBundle.field_username);
      ((NormalIconPreference)localObject).getExtras().putString("username", paramBundle.field_username);
      ((NormalIconPreference)localObject).setTitle(k.c(getContext(), paramBundle.adv()));
      getPreferenceScreen().b((Preference)localObject);
      paramBundle = new PreferenceTitleCategory(getContext());
      paramBundle.setTitle(2131762637);
      localObject = this.fLO.aGo().iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if (this.fLO.aSH(str))
        {
          ad.i("MicroMsg.SeeRoomOwnerManagerUI", "[resetData] Room Manager:%s", new Object[] { str });
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
      final am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(str);
      NormalIconPreference local3 = new NormalIconPreference(getContext())
      {
        public final void onBindView(View paramAnonymousView)
        {
          AppMethodBeat.i(12908);
          super.onBindView(paramAnonymousView);
          a.b.a(this.Jss, localam.field_username, 0.15F, false);
          this.Jss.setVisibility(0);
          AppMethodBeat.o(12908);
        }
      };
      local3.setKey(str);
      local3.getExtras().putString("username", localam.field_username);
      local3.setTitle(k.c(getContext(), localam.adv()));
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
      localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramf);
      paramPreference = ((aw)localObject1).field_username;
      paramf = ((am)localObject1).adv();
      localObject1 = ((aw)localObject1).field_nickname;
      if (!bt.isNullOrNil(paramf)) {
        break label370;
      }
      localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azq().aqz(paramPreference);
      if ((localObject2 == null) || (bt.isNullOrNil(((cf)localObject2).field_encryptUsername))) {
        break label370;
      }
      paramf = ((cf)localObject2).field_conRemark;
    }
    label370:
    for (;;)
    {
      if (!bt.isNullOrNil(paramPreference))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramPreference);
        ((Intent)localObject2).putExtra("Contact_RemarkName", paramf);
        if (this.fLO != null) {
          ((Intent)localObject2).putExtra("Contact_RoomNickname", this.fLO.zf(paramPreference));
        }
        ((Intent)localObject2).putExtra("Contact_Nick", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.fPi);
        paramf = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramPreference);
        if ((paramf != null) && ((int)paramf.gfj > 0) && (com.tencent.mm.o.b.lM(paramf.field_type)))
        {
          localObject1 = new tk();
          ((tk)localObject1).dHR.intent = ((Intent)localObject2);
          ((tk)localObject1).dHR.username = paramPreference;
          a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
        }
        if ((paramf != null) && (paramf.fqg())) {
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, paramf.field_username + ",14");
        }
        ((Intent)localObject2).putExtra("Contact_Scene", 96);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.fPi);
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