package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fx;
import com.tencent.mm.openim.api.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.au;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKefuContact;", "Lcom/tencent/mm/autogen/table/BaseOpenIMKefuContact;", "Lcom/tencent/mm/openim/api/IOpenIMKefuContact;", "()V", "username", "", "(Ljava/lang/String;)V", "contactId", "", "isValid", "", "getBigHeadImageUrl", "getContactId", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getFinderUsername", "getKfUrl", "getNickname", "getOpenImAppId", "getOpenImDescWordingId", "getSmallHeadImageUrl", "getTicket", "getType", "getUsername", "setContactId", "", "setMute", "setType", "type", "setValid", "toInfo", "toShortInfo", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "unSetMute", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends fx
  implements a
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final c.a prK;
  boolean clZ;
  public long maN = -1L;
  
  static
  {
    AppMethodBeat.i(236055);
    prK = new c.a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = fx.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(OpenIMKefuContact::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(236055);
  }
  
  public final String bIQ()
  {
    return this.field_ticket;
  }
  
  public final String bRP()
  {
    return this.field_bigHeadImg;
  }
  
  public final String bRQ()
  {
    return this.field_smallHeadImg;
  }
  
  public final String bRR()
  {
    return this.field_openImAppId;
  }
  
  public final String bRS()
  {
    return this.field_openImDescWordingId;
  }
  
  public final String bRT()
  {
    AppMethodBeat.i(236102);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OpenIMKefuContact username:").append(this.field_username).append(" nick:").append(this.field_nickname).append(" contactId: ").append(this.maN).append(", type: ").append(this.field_type).append(", head:").append(this.field_bigHeadImg).append(" smallHead: ").append(this.field_smallHeadImg).append(", source: ").append(this.field_source).append(", appId: ").append(this.field_openImAppId).append(", wordingId: ").append(this.field_openImDescWordingId).append(", customInfoDetail: ").append(this.field_customInfoDetailVisible).append(", ").append(this.field_customInfoDetail).append(", finderUsername: ");
    ((StringBuilder)localObject).append(this.field_finderUsername).append(", kfUrl: ").append(this.field_kfUrl);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(236102);
    return localObject;
  }
  
  public final String bRU()
  {
    AppMethodBeat.i(236106);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname;
    AppMethodBeat.o(236106);
    return str;
  }
  
  public final au bSb()
  {
    AppMethodBeat.i(236110);
    Object localObject = g.prW;
    localObject = g.d(this);
    AppMethodBeat.o(236110);
    return localObject;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getNickname()
  {
    return this.field_nickname;
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public final boolean isValid()
  {
    return this.clZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.a.c
 * JD-Core Version:    0.7.0.1
 */