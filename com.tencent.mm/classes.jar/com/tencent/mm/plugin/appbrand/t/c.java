package com.tencent.mm.plugin.appbrand.t;

import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public abstract class c<_Model extends com.tencent.mm.sdk.e.c,  extends b>
  extends i<_Model>
{
  public c(e parame, c.a parama, String paramString, String[] paramArrayOfString)
  {
    super(parame, parama, paramString, paramArrayOfString);
  }
  
  public final boolean a(_Model param_Model, boolean paramBoolean)
  {
    super.a(param_Model, paramBoolean);
    return b(param_Model, new String[0]);
  }
  
  public final boolean a(_Model param_Model, boolean paramBoolean, String... paramVarArgs)
  {
    String[] arrayOfString;
    if (paramVarArgs != null)
    {
      arrayOfString = paramVarArgs;
      if (paramVarArgs.length != 0) {}
    }
    else
    {
      arrayOfString = ((b)param_Model).getKeys();
    }
    return super.a(param_Model, paramBoolean, arrayOfString);
  }
  
  public final boolean b(_Model param_Model, boolean paramBoolean, String... paramVarArgs)
  {
    String[] arrayOfString;
    if (paramVarArgs != null)
    {
      arrayOfString = paramVarArgs;
      if (paramVarArgs.length != 0) {}
    }
    else
    {
      arrayOfString = ((b)param_Model).getKeys();
    }
    return super.b(param_Model, paramBoolean, arrayOfString);
  }
  
  public final boolean b(_Model param_Model, String... paramVarArgs)
  {
    String[] arrayOfString;
    if (paramVarArgs != null)
    {
      arrayOfString = paramVarArgs;
      if (paramVarArgs.length != 0) {}
    }
    else
    {
      arrayOfString = ((b)param_Model).getKeys();
    }
    return super.b(param_Model, arrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.c
 * JD-Core Version:    0.7.0.1
 */