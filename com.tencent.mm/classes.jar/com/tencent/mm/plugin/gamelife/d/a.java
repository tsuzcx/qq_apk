package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cz;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "Lcom/tencent/mm/autogen/table/BaseGameLifeContact;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "()V", "isValid", "", "getAccountType", "", "getAvatarUrl", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getNickname", "getProfileJumpInfo", "getTag", "getUsername", "print", "setIsValid", "", "toString", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "Companion", "plugin-gamelife_release"})
public final class a
  extends cz
  implements com.tencent.mm.plugin.gamelife.a.a
{
  private static final IAutoDBItem.MAutoDBInfo info;
  private static final int ybB = 1;
  private static final int ybC = 2;
  private static final int ybD = 4;
  private static final int ybE = 8;
  public static final a.a ybF;
  boolean daZ = true;
  
  static
  {
    AppMethodBeat.i(241297);
    ybF = new a.a((byte)0);
    ybB = 1;
    ybC = 2;
    ybD = 4;
    ybE = 8;
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cz.ajs();
    p.g(localMAutoDBInfo, "BaseGameLifeContact.init…eLifeContact::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(241297);
  }
  
  public final String cXH()
  {
    return this.field_avatarURL;
  }
  
  public final as dWW()
  {
    AppMethodBeat.i(241292);
    as localas = new as();
    if (!this.daZ) {
      this.field_nickname = this.field_username;
    }
    localas.setNickname(this.field_nickname);
    localas.ao((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)this.field_nickname));
    localas.setUsername(this.field_username);
    localas.gMZ = localas.systemRowid;
    AppMethodBeat.o(241292);
    return localas;
  }
  
  public final String dWX()
  {
    AppMethodBeat.i(241295);
    Object localObject = this.field_jumpInfo;
    if (localObject == null)
    {
      AppMethodBeat.o(241295);
      return "";
    }
    if ((localObject != null) && (((com.tencent.mm.plugin.gamelife.b.l)localObject).uSc == com.tencent.mm.plugin.gamelife.a.xZW))
    {
      localObject = ((com.tencent.mm.plugin.gamelife.b.l)localObject).pTL;
      p.g(localObject, "jumpInfo.jump_url");
      AppMethodBeat.o(241295);
      return localObject;
    }
    AppMethodBeat.o(241295);
    return "";
  }
  
  public final int dWY()
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
    AppMethodBeat.i(241294);
    String str = this.field_username;
    p.g(str, "field_username");
    AppMethodBeat.o(241294);
    return str;
  }
  
  public final boolean isValid()
  {
    return this.daZ;
  }
  
  public final String print()
  {
    AppMethodBeat.i(241293);
    String str = "username: " + this.field_username;
    AppMethodBeat.o(241293);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(241296);
    String str = "username: " + this.field_username + " nickname: " + this.field_nickname;
    AppMethodBeat.o(241296);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.a
 * JD-Core Version:    0.7.0.1
 */