package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cu;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "Lcom/tencent/mm/autogen/table/BaseGameLifeContact;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "()V", "isValid", "", "getAccountType", "", "getAvatarUrl", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getNickname", "getProfileJumpInfo", "getTag", "getUsername", "print", "setIsValid", "", "toString", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "Companion", "plugin-gamelife_release"})
public final class a
  extends cu
  implements com.tencent.mm.plugin.gamelife.a.a
{
  private static final c.a info;
  private static final int uxH = 1;
  private static final int uxI = 2;
  private static final int uxJ = 4;
  private static final int uxK = 8;
  public static final a uxL;
  boolean cJS = true;
  
  static
  {
    AppMethodBeat.i(211290);
    uxL = new a((byte)0);
    uxH = 1;
    uxI = 2;
    uxJ = 4;
    uxK = 8;
    c.a locala = cu.Vv();
    p.g(locala, "BaseGameLifeContact.init…eLifeContact::class.java)");
    info = locala;
    AppMethodBeat.o(211290);
  }
  
  public final String VC()
  {
    return this.field_nickname;
  }
  
  public final String cxL()
  {
    return this.field_avatarURL;
  }
  
  public final am daA()
  {
    AppMethodBeat.i(211285);
    am localam = new am();
    if (!this.cJS) {
      this.field_nickname = this.field_username;
    }
    localam.sT(this.field_nickname);
    localam.ak((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)this.field_nickname));
    localam.setUsername(this.field_username);
    localam.gfj = localam.systemRowid;
    AppMethodBeat.o(211285);
    return localam;
  }
  
  public final String daB()
  {
    AppMethodBeat.i(211288);
    Object localObject = this.field_jumpInfo;
    if (localObject == null)
    {
      AppMethodBeat.o(211288);
      return "";
    }
    if ((localObject != null) && (((com.tencent.mm.plugin.gamelife.b.k)localObject).uxt == com.tencent.mm.plugin.gamelife.a.uwl))
    {
      localObject = ((com.tencent.mm.plugin.gamelife.b.k)localObject).ozD;
      p.g(localObject, "jumpInfo.jump_url");
      AppMethodBeat.o(211288);
      return localObject;
    }
    AppMethodBeat.o(211288);
    return "";
  }
  
  public final int daC()
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
    AppMethodBeat.i(211287);
    String str = this.field_username;
    p.g(str, "field_username");
    AppMethodBeat.o(211287);
    return str;
  }
  
  public final boolean isValid()
  {
    return this.cJS;
  }
  
  public final String print()
  {
    AppMethodBeat.i(211286);
    String str = "username: " + this.field_username;
    AppMethodBeat.o(211286);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(211289);
    String str = "username: " + this.field_username + " nickname: " + this.field_nickname;
    AppMethodBeat.o(211289);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact$Companion;", "", "()V", "GAME_CONTACTFLAG_BLACKLISTCONTACT", "", "getGAME_CONTACTFLAG_BLACKLISTCONTACT", "()I", "GAME_CONTACTFLAG_CHATCONTACT", "getGAME_CONTACTFLAG_CHATCONTACT", "GAME_CONTACTFLAG_CHATROOMCONTACT", "getGAME_CONTACTFLAG_CHATROOMCONTACT", "GAME_CONTACTFLAG_CONTACT", "getGAME_CONTACTFLAG_CONTACT", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.a
 * JD-Core Version:    0.7.0.1
 */