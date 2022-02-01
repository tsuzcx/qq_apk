package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.dd;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "Lcom/tencent/mm/autogen/table/BaseGameLifeContact;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "()V", "isValid", "", "getAccountType", "", "getAvatarUrl", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getNickname", "getProfileJumpInfo", "getTag", "getUsername", "print", "setIsValid", "", "toString", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "Companion", "plugin-gamelife_release"})
public final class a
  extends dd
  implements com.tencent.mm.plugin.gamelife.a.a
{
  private static final int Dhg = 1;
  private static final int Dhh = 2;
  private static final int Dhi = 4;
  private static final int Dhj = 8;
  public static final a Dhk;
  private static final IAutoDBItem.MAutoDBInfo info;
  boolean cSY = true;
  
  static
  {
    AppMethodBeat.i(203341);
    Dhk = new a((byte)0);
    Dhg = 1;
    Dhh = 2;
    Dhi = 4;
    Dhj = 8;
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = dd.aoY();
    p.j(localMAutoDBInfo, "BaseGameLifeContact.init…eLifeContact::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(203341);
  }
  
  public final String Mm()
  {
    return this.field_avatarURL;
  }
  
  public final as eAf()
  {
    AppMethodBeat.i(203320);
    as localas = new as();
    if (!this.cSY) {
      this.field_nickname = this.field_username;
    }
    localas.setNickname(this.field_nickname);
    localas.aC((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)this.field_nickname));
    localas.setUsername(this.field_username);
    localas.jxt = localas.systemRowid;
    AppMethodBeat.o(203320);
    return localas;
  }
  
  public final String eAg()
  {
    AppMethodBeat.i(203328);
    Object localObject = this.field_jumpInfo;
    if (localObject == null)
    {
      AppMethodBeat.o(203328);
      return "";
    }
    if ((localObject != null) && (((com.tencent.mm.plugin.gamelife.b.l)localObject).jump_type == com.tencent.mm.plugin.gamelife.a.DeD))
    {
      localObject = ((com.tencent.mm.plugin.gamelife.b.l)localObject).jump_url;
      p.j(localObject, "jumpInfo.jump_url");
      AppMethodBeat.o(203328);
      return localObject;
    }
    AppMethodBeat.o(203328);
    return "";
  }
  
  public final int eAh()
  {
    return this.field_accountType;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getNickname()
  {
    return this.field_nickname;
  }
  
  public final String getTag()
  {
    return this.field_tag;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(203323);
    String str = this.field_username;
    p.j(str, "field_username");
    AppMethodBeat.o(203323);
    return str;
  }
  
  public final boolean isValid()
  {
    return this.cSY;
  }
  
  public final String print()
  {
    AppMethodBeat.i(203321);
    String str = "username: " + this.field_username;
    AppMethodBeat.o(203321);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203334);
    String str = "username: " + this.field_username + " nickname: " + this.field_nickname;
    AppMethodBeat.o(203334);
    return str;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact$Companion;", "", "()V", "GAME_CONTACTFLAG_BLACKLISTCONTACT", "", "getGAME_CONTACTFLAG_BLACKLISTCONTACT", "()I", "GAME_CONTACTFLAG_CHATCONTACT", "getGAME_CONTACTFLAG_CHATCONTACT", "GAME_CONTACTFLAG_CHATROOMCONTACT", "getGAME_CONTACTFLAG_CHATROOMCONTACT", "GAME_CONTACTFLAG_CONTACT", "getGAME_CONTACTFLAG_CONTACT", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.a
 * JD-Core Version:    0.7.0.1
 */