package com.tencent.mm.model;

import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

abstract class bv$a
{
  private bv$a(bv parambv) {}
  
  public void a(bt parambt, Object... paramVarArgs)
  {
    int j = 1;
    int i = j;
    if (paramVarArgs != null)
    {
      i = j;
      if (paramVarArgs.length > 0) {
        i = bo.f(paramVarArgs[0], 1);
      }
    }
    parambt.fnF = (i + bo.getInt(parambt.fnF, 0));
  }
  
  public final void a(bu parambu, int paramInt, Object... paramVarArgs)
  {
    if (parambu == null) {
      return;
    }
    Iterator localIterator = parambu.fnG.iterator();
    while (localIterator.hasNext())
    {
      bt localbt = (bt)localIterator.next();
      if (localbt.key == paramInt)
      {
        a(localbt, paramVarArgs);
        return;
      }
    }
    parambu.fnG.add(d(paramInt, paramVarArgs));
  }
  
  public abstract boolean a(bt parambt);
  
  public bt d(int paramInt, Object... paramVarArgs)
  {
    int j = 1;
    int i = j;
    if (paramVarArgs != null)
    {
      i = j;
      if (paramVarArgs.length > 0) {
        i = bo.f(paramVarArgs[0], 1);
      }
    }
    paramVarArgs = new bt();
    paramVarArgs.key = paramInt;
    paramVarArgs.fnF = String.valueOf(i);
    paramVarArgs.ePF = 0L;
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bv.a
 * JD-Core Version:    0.7.0.1
 */