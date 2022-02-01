package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.dcj;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath;", "", "()V", "Companion", "plugin-expt_release"})
public final class m
{
  public static final a rhq;
  
  static
  {
    AppMethodBeat.i(185607);
    rhq = new a((byte)0);
    AppMethodBeat.o(185607);
  }
  
  public static final void EL(String paramString)
  {
    AppMethodBeat.i(185608);
    if (paramString == null)
    {
      AppMethodBeat.o(185608);
      return;
    }
    dcj localdcj2 = a.crY();
    dcj localdcj1 = localdcj2;
    if (localdcj2 == null) {
      localdcj1 = new dcj();
    }
    if (localdcj1.Hco.size() > 100) {
      localdcj1.Hco.removeFirst();
    }
    localdcj1.Hco.addLast(paramString);
    if ((localdcj1 == null) || (localdcj1.Hco.isEmpty()))
    {
      AppMethodBeat.o(185608);
      return;
    }
    try
    {
      paramString = localdcj1.toByteArray();
      if (paramString != null) {
        b.p("mmkv_sionId_table_hell", paramString);
      }
      AppMethodBeat.o(185608);
      return;
    }
    catch (IOException paramString)
    {
      ae.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)paramString, "SessionTable, _write: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(185608);
    }
  }
  
  public static final dcj crX()
  {
    AppMethodBeat.i(185609);
    dcj localdcj = a.crY();
    AppMethodBeat.o(185609);
    return localdcj;
  }
  
  public static final String crj()
  {
    AppMethodBeat.i(196639);
    Object localObject = a.crY();
    if (localObject == null)
    {
      AppMethodBeat.o(196639);
      return null;
    }
    if (((dcj)localObject).Hco.isEmpty())
    {
      AppMethodBeat.o(196639);
      return null;
    }
    localObject = ((dcj)localObject).Hco;
    p.g(localObject, "table.sessions");
    localObject = (String)((LinkedList)localObject).getLast();
    AppMethodBeat.o(196639);
    return localObject;
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(185610);
    b.p("mmkv_sionId_table_hell", new byte[0]);
    AppMethodBeat.o(185610);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath$Companion;", "", "()V", "KEY_MMKV", "", "MAX_ITMES", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionTable;", "_write", "", "table", "add", "sessionId", "get", "getCurSessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    static dcj crY()
    {
      AppMethodBeat.i(185606);
      byte[] arrayOfByte = b.getBytes("mmkv_sionId_table_hell");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(185606);
        return null;
      }
      dcj localdcj = new dcj();
      try
      {
        localdcj.parseFrom(arrayOfByte);
        AppMethodBeat.o(185606);
        return localdcj;
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)localIOException, "SessionTable, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(185606);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.m
 * JD-Core Version:    0.7.0.1
 */