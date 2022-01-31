package com.tencent.mm.av;

import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import java.util.LinkedList;

public final class g
  extends f
{
  public static e a(String paramString, bxk parambxk, int paramInt)
  {
    String str = null;
    if ((parambxk == null) || (parambxk.tNr == null) || (parambxk.tNr.sPJ == null) || (parambxk.tNr.sPJ.size() <= 0)) {}
    awd localawd;
    do
    {
      return null;
      localawd = (awd)parambxk.tNr.sPJ.get(0);
    } while (localawd == null);
    e locale = new e();
    locale.euv = paramInt;
    locale.eux = parambxk.lsK;
    locale.euy = 0.0F;
    locale.euB = "";
    locale.euC = localawd.trP;
    locale.euH = null;
    locale.euw = 1;
    locale.euG = null;
    locale.euz = localawd.bGw;
    locale.euA = localawd.kRN;
    if (parambxk.tNr != null) {
      str = parambxk.tNr.kSC;
    }
    locale.euF = str;
    locale.euE = localawd.trT;
    locale.euD = localawd.kSC;
    locale.euL = localawd.trQ;
    locale.euN = localawd.lsK;
    locale.euI = paramString;
    locale.euK = parambxk.tNq.lsK;
    locale.euR = parambxk.hPY;
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.av.g
 * JD-Core Version:    0.7.0.1
 */