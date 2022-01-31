package com.tencent.mm.aj;

import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bk;

public final class a
{
  private static int eie = 0;
  private static int eif = 0;
  
  public static String a(a.a parama)
  {
    if (parama == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(bk.pm(parama.eio));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(bk.pm(parama.eim));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(bk.pm(parama.eij));
    return localStringBuilder.toString();
  }
  
  public static String b(a.a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!q.gS(parama.bRO))
    {
      localStringBuilder.append(parama.eig);
      localStringBuilder.append(": ");
    }
    if (bk.bl(parama.eio)) {
      if (bk.bl(parama.eim)) {
        parama = parama.eij;
      }
    }
    for (;;)
    {
      localStringBuilder.append(parama);
      return localStringBuilder.toString();
      parama = parama.eim;
      continue;
      parama = parama.eio;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aj.a
 * JD-Core Version:    0.7.0.1
 */