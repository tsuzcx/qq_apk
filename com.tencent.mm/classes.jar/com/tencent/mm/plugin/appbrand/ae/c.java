package com.tencent.mm.plugin.appbrand.ae;

import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public abstract class c<_Model extends IAutoDBItem,  extends b>
  extends MAutoStorage<_Model>
{
  private final ISQLiteDatabase tVz;
  
  public c(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
    this.tVz = paramISQLiteDatabase;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.c
 * JD-Core Version:    0.7.0.1
 */