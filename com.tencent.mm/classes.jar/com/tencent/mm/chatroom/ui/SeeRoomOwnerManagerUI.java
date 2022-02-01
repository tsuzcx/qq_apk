package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bz;
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
  private com.tencent.mm.storage.x ftP;
  private String fvZ;
  
  public int getResourceId()
  {
    return 2131951711;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(12909);
    super.onCreate(paramBundle);
    setMMTitle(2131762632);
    setBackBtn(new com.tencent.mm.ui.x()
    {
      public final void WP()
      {
        AppMethodBeat.i(12906);
        SeeRoomOwnerManagerUI.this.finish();
        AppMethodBeat.o(12906);
      }
    });
    this.fvZ = getIntent().getStringExtra("RoomInfo_Id");
    this.ftP = ((c)g.ab(c.class)).awK().xN(bs.nullAsNil(this.fvZ));
    String str;
    if (this.ftP != null)
    {
      paramBundle = new PreferenceTitleCategory(getContext());
      paramBundle.setTitle(2131762723);
      getPreferenceScreen().b(paramBundle);
      ac.i("MicroMsg.SeeRoomOwnerManagerUI", "[onCreate] owner:%s", new Object[] { this.ftP.field_roomowner });
      paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.ftP.field_roomowner);
      Object localObject = new NormalIconPreference(getContext())
      {
        public final void onBindView(View paramAnonymousView)
        {
          AppMethodBeat.i(12907);
          super.onBindView(paramAnonymousView);
          a.b.a(this.HEC, paramBundle.field_username, 0.15F, false);
          this.HEC.setVisibility(0);
          AppMethodBeat.o(12907);
        }
      };
      ((NormalIconPreference)localObject).setKey(paramBundle.field_username);
      ((NormalIconPreference)localObject).getExtras().putString("username", paramBundle.field_username);
      ((NormalIconPreference)localObject).setTitle(com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), paramBundle.aaS()));
      getPreferenceScreen().b((Preference)localObject);
      paramBundle = new PreferenceTitleCategory(getContext());
      paramBundle.setTitle(2131762637);
      localObject = this.ftP.aDl().iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if (this.ftP.aMU(str))
        {
          ac.i("MicroMsg.SeeRoomOwnerManagerUI", "[resetData] Room Manager:%s", new Object[] { str });
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
      final ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str);
      NormalIconPreference local3 = new NormalIconPreference(getContext())
      {
        public final void onBindView(View paramAnonymousView)
        {
          AppMethodBeat.i(12908);
          super.onBindView(paramAnonymousView);
          a.b.a(this.HEC, localai.field_username, 0.15F, false);
          this.HEC.setVisibility(0);
          AppMethodBeat.o(12908);
        }
      };
      local3.setKey(str);
      local3.getExtras().putString("username", localai.field_username);
      local3.setTitle(com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), localai.aaS()));
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
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramf);
      paramPreference = ((av)localObject1).field_username;
      paramf = ((ai)localObject1).aaS();
      localObject1 = ((av)localObject1).field_nickname;
      if (!bs.isNullOrNil(paramf)) {
        break label370;
      }
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awC().alK(paramPreference);
      if ((localObject2 == null) || (bs.isNullOrNil(((bz)localObject2).field_encryptUsername))) {
        break label370;
      }
      paramf = ((bz)localObject2).field_conRemark;
    }
    label370:
    for (;;)
    {
      if (!bs.isNullOrNil(paramPreference))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramPreference);
        ((Intent)localObject2).putExtra("Contact_RemarkName", paramf);
        if (this.ftP != null) {
          ((Intent)localObject2).putExtra("Contact_RoomNickname", this.ftP.wk(paramPreference));
        }
        ((Intent)localObject2).putExtra("Contact_Nick", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.fvZ);
        paramf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramPreference);
        if ((paramf != null) && ((int)paramf.fLJ > 0) && (com.tencent.mm.n.b.ln(paramf.field_type)))
        {
          localObject1 = new st();
          ((st)localObject1).dvI.intent = ((Intent)localObject2);
          ((st)localObject1).dvI.username = paramPreference;
          a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        }
        if ((paramf != null) && (paramf.fad())) {
          h.wUl.kvStat(10298, paramf.field_username + ",14");
        }
        ((Intent)localObject2).putExtra("Contact_Scene", 96);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.fvZ);
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