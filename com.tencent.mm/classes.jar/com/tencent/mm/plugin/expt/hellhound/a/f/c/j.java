package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class j
{
  public static final a rho;
  
  static
  {
    AppMethodBeat.i(185603);
    rho = new a((byte)0);
    AppMethodBeat.o(185603);
  }
  
  public static final void aaB(String paramString)
  {
    AppMethodBeat.i(185605);
    if (paramString == null)
    {
      AppMethodBeat.o(185605);
      return;
    }
    bot localbot = a.crS();
    if (localbot == null)
    {
      AppMethodBeat.o(185605);
      return;
    }
    int i = localbot.Hck.size() - 1;
    if (i >= 0)
    {
      bou localbou = (bou)localbot.Hck.get(i);
      if ((localbou == null) || ((p.i(paramString, localbou.dAa) ^ true))) {}
      for (;;)
      {
        i -= 1;
        break;
        localbot.Hck.remove(i);
      }
    }
    if ((localbot == null) || (localbot.Hck.isEmpty()))
    {
      AppMethodBeat.o(185605);
      return;
    }
    try
    {
      paramString = localbot.toByteArray();
      if (paramString != null) {
        b.p("mmkv_ssionPg_matched_bckup", paramString);
      }
      AppMethodBeat.o(185605);
      return;
    }
    catch (IOException paramString)
    {
      ae.printErrStackTrace("HABBYGE-MALI.SessionPageBackup", (Throwable)paramString, "SessionPageBackup, _write: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(185605);
    }
  }
  
  public static final List<bou> agd(String paramString)
  {
    AppMethodBeat.i(185604);
    if (paramString == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    Object localObject = a.crS();
    if (localObject == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((bot)localObject).Hck.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bou localbou = (bou)((Iterator)localObject).next();
      if ((localbou != null) && (!(p.i(paramString, localbou.dAa) ^ true))) {
        localArrayList.add(localbou);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(185604);
    return paramString;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/HellPageFlow;", "_write", "", "path", "backup", "pageItems", "", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", "getBackup", "sessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    static bot crS()
    {
      AppMethodBeat.i(185602);
      byte[] arrayOfByte = b.getBytes("mmkv_ssionPg_matched_bckup");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(185602);
        return null;
      }
      bot localbot = new bot();
      try
      {
        localbot.parseFrom(arrayOfByte);
        AppMethodBeat.o(185602);
        return localbot;
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("HABBYGE-MALI.SessionPageBackup", (Throwable)localIOException, "SessionPageBackup, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(185602);
      }
      return null;
    }
    
    public static void reset()
    {
      AppMethodBeat.i(185601);
      b.p("mmkv_ssionPg_matched_bckup", new byte[0]);
      AppMethodBeat.o(185601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.j
 * JD-Core Version:    0.7.0.1
 */