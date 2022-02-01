package com.tencent.mm.plugin.game.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/data/ChatRoomInfo;", "", "itemType", "", "data", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "isMoreList", "", "roomGroupTitle", "", "createRoomJumpInfo", "Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;", "(ILcom/tencent/mm/protobuf/BaseProtoBuf;ZLjava/lang/String;Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;)V", "getCreateRoomJumpInfo", "()Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;", "setCreateRoomJumpInfo", "(Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;)V", "getData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "setData", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "()Z", "setMoreList", "(Z)V", "getItemType", "()I", "setItemType", "(I)V", "getRoomGroupTitle", "()Ljava/lang/String;", "setRoomGroupTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public com.tencent.mm.bx.a Ikc;
  public boolean Ikd;
  public String Ike;
  public JumpInfo Ikf;
  public int itemType;
  
  public a(int paramInt, com.tencent.mm.bx.a parama)
  {
    this(paramInt, parama, false, null, 28);
  }
  
  private a(int paramInt, com.tencent.mm.bx.a parama, boolean paramBoolean, String paramString)
  {
    this.itemType = paramInt;
    this.Ikc = parama;
    this.Ikd = paramBoolean;
    this.Ike = paramString;
    this.Ikf = null;
  }
  
  public a(int paramInt, String paramString)
  {
    this(paramInt, null, false, paramString, 16);
  }
  
  public a(com.tencent.mm.bx.a parama)
  {
    this(4, parama, true, null, 24);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(275681);
    if (this == paramObject)
    {
      AppMethodBeat.o(275681);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(275681);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.itemType != paramObject.itemType)
    {
      AppMethodBeat.o(275681);
      return false;
    }
    if (!s.p(this.Ikc, paramObject.Ikc))
    {
      AppMethodBeat.o(275681);
      return false;
    }
    if (this.Ikd != paramObject.Ikd)
    {
      AppMethodBeat.o(275681);
      return false;
    }
    if (!s.p(this.Ike, paramObject.Ike))
    {
      AppMethodBeat.o(275681);
      return false;
    }
    if (!s.p(this.Ikf, paramObject.Ikf))
    {
      AppMethodBeat.o(275681);
      return false;
    }
    AppMethodBeat.o(275681);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(275665);
    String str = "ChatRoomInfo(itemType=" + this.itemType + ", data=" + this.Ikc + ", isMoreList=" + this.Ikd + ", roomGroupTitle=" + this.Ike + ", createRoomJumpInfo=" + this.Ikf + ')';
    AppMethodBeat.o(275665);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.d.a
 * JD-Core Version:    0.7.0.1
 */