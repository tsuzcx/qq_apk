package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem$MsgState;", "", "id", "", "token", "isExposing", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "()Z", "setExposing", "(Z)V", "getToken", "setToken", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
{
  boolean Hol;
  private String id;
  String token;
  
  public a$b(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(274865);
    this.id = paramString1;
    this.token = paramString2;
    this.Hol = paramBoolean;
    AppMethodBeat.o(274865);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(274879);
    if (this == paramObject)
    {
      AppMethodBeat.o(274879);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(274879);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.id, paramObject.id))
    {
      AppMethodBeat.o(274879);
      return false;
    }
    if (!s.p(this.token, paramObject.token))
    {
      AppMethodBeat.o(274879);
      return false;
    }
    if (this.Hol != paramObject.Hol)
    {
      AppMethodBeat.o(274879);
      return false;
    }
    AppMethodBeat.o(274879);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(274869);
    String str = "MsgState(id=" + this.id + ", token=" + this.token + ", isExposing=" + this.Hol + ')';
    AppMethodBeat.o(274869);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.a.b
 * JD-Core Version:    0.7.0.1
 */