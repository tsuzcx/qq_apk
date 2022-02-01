package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cu;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.an;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "Lcom/tencent/mm/autogen/table/BaseGameLifeContact;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "()V", "isValid", "", "getAccountType", "", "getAvatarUrl", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getNickname", "getProfileJumpInfo", "getTag", "getUsername", "print", "setIsValid", "", "toString", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "Companion", "plugin-gamelife_release"})
public final class a
  extends cu
  implements com.tencent.mm.plugin.gamelife.a.a
{
  private static final c.a info;
  private static final int uJk = 1;
  private static final int uJl = 2;
  private static final int uJm = 4;
  private static final int uJn = 8;
  public static final a uJo;
  boolean cKB = true;
  
  static
  {
    AppMethodBeat.i(212057);
    uJo = new a((byte)0);
    uJk = 1;
    uJl = 2;
    uJm = 4;
    uJn = 8;
    c.a locala = cu.VD();
    p.g(locala, "BaseGameLifeContact.init…eLifeContact::class.java)");
    info = locala;
    AppMethodBeat.o(212057);
  }
  
  public final String VK()
  {
    return this.field_nickname;
  }
  
  public final String czm()
  {
    return this.field_avatarURL;
  }
  
  public final an ddm()
  {
    AppMethodBeat.i(212052);
    an localan = new an();
    if (!this.cKB) {
      this.field_nickname = this.field_username;
    }
    localan.to(this.field_nickname);
    localan.aj((CharSequence)k.c(ak.getContext(), (CharSequence)this.field_nickname));
    localan.setUsername(this.field_username);
    localan.ght = localan.systemRowid;
    AppMethodBeat.o(212052);
    return localan;
  }
  
  public final String ddn()
  {
    AppMethodBeat.i(212055);
    Object localObject = this.field_jumpInfo;
    if (localObject == null)
    {
      AppMethodBeat.o(212055);
      return "";
    }
    if ((localObject != null) && (((com.tencent.mm.plugin.gamelife.b.l)localObject).uIW == com.tencent.mm.plugin.gamelife.a.uHK))
    {
      localObject = ((com.tencent.mm.plugin.gamelife.b.l)localObject).oGf;
      p.g(localObject, "jumpInfo.jump_url");
      AppMethodBeat.o(212055);
      return localObject;
    }
    AppMethodBeat.o(212055);
    return "";
  }
  
  public final int ddo()
  {
    return this.field_accountType;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String getTag()
  {
    return this.field_tag;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(212054);
    String str = this.field_username;
    p.g(str, "field_username");
    AppMethodBeat.o(212054);
    return str;
  }
  
  public final boolean isValid()
  {
    return this.cKB;
  }
  
  public final String print()
  {
    AppMethodBeat.i(212053);
    String str = "username: " + this.field_username;
    AppMethodBeat.o(212053);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212056);
    String str = "username: " + this.field_username + " nickname: " + this.field_nickname;
    AppMethodBeat.o(212056);
    return str;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact$Companion;", "", "()V", "GAME_CONTACTFLAG_BLACKLISTCONTACT", "", "getGAME_CONTACTFLAG_BLACKLISTCONTACT", "()I", "GAME_CONTACTFLAG_CHATCONTACT", "getGAME_CONTACTFLAG_CHATCONTACT", "GAME_CONTACTFLAG_CHATROOMCONTACT", "getGAME_CONTACTFLAG_CHATROOMCONTACT", "GAME_CONTACTFLAG_CONTACT", "getGAME_CONTACTFLAG_CONTACT", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.a
 * JD-Core Version:    0.7.0.1
 */