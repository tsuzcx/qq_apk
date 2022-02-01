package com.tencent.mm.plugin.appbrand.z;

import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public abstract class c<_Model extends com.tencent.mm.sdk.e.c,  extends b>
  extends j<_Model>
{
  public c(e parame, c.a parama, String paramString, String[] paramArrayOfString)
  {
    super(parame, parama, paramString, paramArrayOfString);
  }
  
  public boolean delete(_Model param_Model, boolean paramBoolean, String... paramVarArgs)
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
    return super.delete(param_Model, paramBoolean, arrayOfString);
  }
  
  public boolean get(_Model param_Model, String... paramVarArgs)
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
    return super.get(param_Model, arrayOfString);
  }
  
  public boolean insertNotify(_Model param_Model, boolean paramBoolean)
  {
    super.insertNotify(param_Model, paramBoolean);
    return get(param_Model, new String[0]);
  }
  
  public boolean updateNotify(_Model param_Model, boolean paramBoolean, String... paramVarArgs)
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
    return super.updateNotify(param_Model, paramBoolean, arrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.c
 * JD-Core Version:    0.7.0.1
 */