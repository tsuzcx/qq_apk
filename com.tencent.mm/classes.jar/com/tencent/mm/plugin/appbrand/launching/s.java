package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class s
  extends i<t>
{
  public static final String fQV = i.a(t.fCU, "LaunchWxaAppRespTable");
  
  public s(e parame)
  {
    super(parame, t.fCU, "LaunchWxaAppRespTable", t.cqY);
  }
  
  private boolean a(t paramt, boolean paramBoolean)
  {
    paramt.field_appIdHash = paramt.field_appId.hashCode();
    super.a(paramt, paramBoolean);
    paramBoolean = a(paramt, new String[] { "appId" });
    y.i("MicroMsg.LaunchWxaAppCacheStorage", "insertNotify appId %s ret %B", new Object[] { paramt.field_appId, Boolean.valueOf(paramBoolean) });
    return paramBoolean;
  }
  
  private boolean b(t paramt, boolean paramBoolean, String... paramVarArgs)
  {
    int i;
    if (!bk.H(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("appId"))
        {
          paramVarArgs[i] = "appIdHash";
          paramt.field_appIdHash = paramt.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.b(paramt, paramBoolean, paramVarArgs);
        y.i("MicroMsg.LaunchWxaAppCacheStorage", "updateNotify appId %s, ret %B", new Object[] { paramt.field_appId, Boolean.valueOf(paramBoolean) });
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  public final t a(String paramString, ati paramati)
  {
    if ((bk.bl(paramString)) || (paramati == null)) {
      return null;
    }
    t localt = new t();
    localt.a(paramati);
    localt.field_appId = paramString;
    paramati = new t();
    paramati.field_appId = paramString;
    boolean bool1;
    boolean bool2;
    if (!a(paramati, new String[] { "appId" }))
    {
      bool1 = true;
      if ((!bool1) && (paramati.equals(localt))) {
        break label158;
      }
      bool2 = true;
      label82:
      y.i("MicroMsg.LaunchWxaAppCacheStorage", "flush resp, appId %s, apply %B, insert %B", new Object[] { paramString, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2)
      {
        if (!bool1) {
          break label164;
        }
        a(localt, false);
      }
    }
    for (;;)
    {
      if (!bool2) {
        break label184;
      }
      if (!a(paramati, new String[] { "appId" })) {
        break label184;
      }
      return paramati;
      bool1 = false;
      break;
      label158:
      bool2 = false;
      break label82;
      label164:
      b(localt, false, new String[] { "appId" });
    }
    label184:
    return localt;
  }
  
  public final boolean a(t paramt, boolean paramBoolean, String... paramVarArgs)
  {
    int i;
    if (!bk.H(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("appId"))
        {
          paramVarArgs[i] = "appIdHash";
          paramt.field_appIdHash = paramt.field_appId.hashCode();
        }
      }
      else {
        return super.a(paramt, paramBoolean, paramVarArgs);
      }
      i += 1;
    }
  }
  
  public final boolean a(t paramt, String... paramVarArgs)
  {
    int i;
    if (!bk.H(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("appId"))
        {
          paramVarArgs[i] = "appIdHash";
          paramt.field_appIdHash = paramt.field_appId.hashCode();
        }
      }
      else {
        return super.b(paramt, paramVarArgs);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.s
 * JD-Core Version:    0.7.0.1
 */