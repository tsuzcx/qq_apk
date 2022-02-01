package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.dn;
import com.tencent.mm.plugin.gamelife.b.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.au;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "Lcom/tencent/mm/autogen/table/BaseGameLifeContact;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "()V", "isValid", "", "getAccountType", "", "getAvatarUrl", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getNickname", "getProfileJumpInfo", "getTag", "getUsername", "print", "setIsValid", "", "toString", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends dn
  implements com.tencent.mm.plugin.gamelife.a.a
{
  public static final a.a Jbe;
  private static final int Jbf;
  private static final int Jbg;
  private static final int Jbh;
  private static final int Jbi;
  private static final IAutoDBItem.MAutoDBInfo info;
  boolean clZ = true;
  
  static
  {
    AppMethodBeat.i(268029);
    Jbe = new a.a((byte)0);
    Jbf = 1;
    Jbg = 2;
    Jbh = 4;
    Jbi = 8;
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = dn.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(GameLifeContact::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(268029);
  }
  
  public final String amx()
  {
    return this.field_avatarURL;
  }
  
  public final au bSb()
  {
    AppMethodBeat.i(268042);
    au localau = new au();
    if (!this.clZ) {
      this.field_nickname = this.field_username;
    }
    localau.setNickname(this.field_nickname);
    localau.acDG = ((CharSequence)p.b(MMApplicationContext.getContext(), (CharSequence)this.field_nickname));
    localau.setUsername(this.field_username);
    localau.maN = localau.systemRowid;
    AppMethodBeat.o(268042);
    return localau;
  }
  
  public final String fIg()
  {
    AppMethodBeat.i(268090);
    Object localObject = this.field_jumpInfo;
    if (localObject == null)
    {
      AppMethodBeat.o(268090);
      return "";
    }
    if (((l)localObject).jump_type == com.tencent.mm.plugin.gamelife.a.IYU)
    {
      localObject = ((l)localObject).jump_url;
      s.s(localObject, "jumpInfo.jump_url");
      AppMethodBeat.o(268090);
      return localObject;
    }
    AppMethodBeat.o(268090);
    return "";
  }
  
  public final int fIh()
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
    AppMethodBeat.i(268063);
    String str = this.field_username;
    s.s(str, "field_username");
    AppMethodBeat.o(268063);
    return str;
  }
  
  public final boolean isValid()
  {
    return this.clZ;
  }
  
  public final String print()
  {
    AppMethodBeat.i(268049);
    String str = s.X("username: ", this.field_username);
    AppMethodBeat.o(268049);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(268101);
    String str = "username: " + this.field_username + " nickname: " + this.field_nickname;
    AppMethodBeat.o(268101);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.a
 * JD-Core Version:    0.7.0.1
 */