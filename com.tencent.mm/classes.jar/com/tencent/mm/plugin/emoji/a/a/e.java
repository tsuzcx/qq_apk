package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.protocal.c.vn;

public final class e
{
  public static boolean a(vn paramvn)
  {
    if (paramvn == null) {
      return false;
    }
    return cC(paramvn.sSh, 1);
  }
  
  public static boolean b(vn paramvn)
  {
    boolean bool2 = false;
    if (paramvn == null)
    {
      bool1 = false;
      if (!bool1) {
        if (paramvn != null) {
          break label38;
        }
      }
    }
    label38:
    for (boolean bool1 = false;; bool1 = cC(paramvn.sSg, 8))
    {
      if (bool1) {
        bool2 = true;
      }
      return bool2;
      bool1 = cC(paramvn.sSg, 4);
      break;
    }
  }
  
  public static boolean cC(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  public static boolean pU(int paramInt)
  {
    return (cC(paramInt, 4)) || (cC(paramInt, 8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.e
 * JD-Core Version:    0.7.0.1
 */