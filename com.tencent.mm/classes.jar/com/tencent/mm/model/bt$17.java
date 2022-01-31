package com.tencent.mm.model;

final class bt$17
  extends bt.a
{
  bt$17(bt parambt)
  {
    super(parambt, (byte)0);
  }
  
  public final void a(br parambr, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      parambr.dXz = paramVarArgs[0];
    }
  }
  
  public final boolean a(br parambr)
  {
    if ((System.currentTimeMillis() - parambr.dXA > 3600000L) && (parambr.dXz.length() > 0))
    {
      bt.o(parambr.key, parambr.dXz);
      parambr.dXz = "";
      parambr.dXA = System.currentTimeMillis();
      return true;
    }
    return false;
  }
  
  public final br e(int paramInt, Object... paramVarArgs)
  {
    br localbr = new br();
    localbr.key = paramInt;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      localbr.dXz = paramVarArgs[0];
    }
    localbr.dXA = 0L;
    return localbr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.bt.17
 * JD-Core Version:    0.7.0.1
 */