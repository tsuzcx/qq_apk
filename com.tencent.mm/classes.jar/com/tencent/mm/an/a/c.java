package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.m;
import com.tencent.mm.autogen.b.ai;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends ai
{
  protected static IAutoDBItem.MAutoDBInfo info;
  private Map<String, k> oxD;
  private List<String> oxE;
  
  static
  {
    AppMethodBeat.i(116441);
    info = ai.aJm();
    AppMethodBeat.o(116441);
  }
  
  public c()
  {
    AppMethodBeat.i(116434);
    this.oxD = new HashMap();
    AppMethodBeat.o(116434);
  }
  
  private void MY(String paramString)
  {
    AppMethodBeat.i(116438);
    paramString = ((m)h.ax(m.class)).hM(paramString);
    if (paramString != null) {
      this.oxD.put(paramString.field_userId, paramString);
    }
    AppMethodBeat.o(116438);
  }
  
  public final k MX(String paramString)
  {
    AppMethodBeat.i(116437);
    if ((!this.oxD.containsKey(paramString)) || (this.oxD.get(paramString) == null))
    {
      long l = System.currentTimeMillis();
      MY(paramString);
      Log.d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    if (this.oxD.containsKey(paramString))
    {
      paramString = (k)this.oxD.get(paramString);
      AppMethodBeat.o(116437);
      return paramString;
    }
    AppMethodBeat.o(116437);
    return null;
  }
  
  public final List<String> bHw()
  {
    AppMethodBeat.i(116435);
    if (this.oxE != null)
    {
      localObject = this.oxE;
      AppMethodBeat.o(116435);
      return localObject;
    }
    Object localObject = this.field_userList;
    if (Util.isNullOrNil((String)localObject))
    {
      localObject = new LinkedList();
      AppMethodBeat.o(116435);
      return localObject;
    }
    this.oxE = Util.stringsToList(((String)localObject).split(";"));
    localObject = this.oxE;
    AppMethodBeat.o(116435);
    return localObject;
  }
  
  public final boolean bHx()
  {
    AppMethodBeat.i(116439);
    if (this.field_bizChatServId == null)
    {
      AppMethodBeat.o(116439);
      return false;
    }
    boolean bool = this.field_bizChatServId.endsWith("@qy_g");
    AppMethodBeat.o(116439);
    return bool;
  }
  
  public final boolean bHy()
  {
    AppMethodBeat.i(116440);
    if (this.field_needToUpdate)
    {
      AppMethodBeat.o(116440);
      return true;
    }
    if ((bHx()) && (Util.isNullOrNil(this.field_userList)))
    {
      AppMethodBeat.o(116440);
      return true;
    }
    if ((Util.isNullOrNil(this.field_chatNamePY)) && (!Util.isNullOrNil(this.field_chatName)))
    {
      AppMethodBeat.o(116440);
      return true;
    }
    AppMethodBeat.o(116440);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getDisplayName(String paramString)
  {
    AppMethodBeat.i(116436);
    paramString = MX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(116436);
      return "";
    }
    paramString = Util.nullAs(paramString.field_userName, "");
    AppMethodBeat.o(116436);
    return paramString;
  }
  
  public final boolean nG(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.a.c
 * JD-Core Version:    0.7.0.1
 */