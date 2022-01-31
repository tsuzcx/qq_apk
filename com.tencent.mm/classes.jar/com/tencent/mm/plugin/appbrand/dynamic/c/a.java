package com.tencent.mm.plugin.appbrand.dynamic.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.protocal.MMProtocalJni;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    if (!((e)g.r(e.class)).Jn().Jt()) {}
    label88:
    int i;
    do
    {
      do
      {
        return true;
      } while ((!"//widget".equals(paramArrayOfString[0])) || (paramArrayOfString.length < 2));
      String str = paramArrayOfString[1].toLowerCase();
      switch (str.hashCode())
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return true;
        case 0: 
          com.tencent.mm.cg.a.post(new a.1(this, paramArrayOfString));
          return true;
          if (!str.equals("assert")) {
            break label88;
          }
          i = 0;
          continue;
          if (!str.equals("jniassert")) {
            break label88;
          }
          i = 1;
          continue;
          if (!str.equals("debugger")) {
            break label88;
          }
          i = 2;
        }
      }
      com.tencent.mm.cg.a.post(new a.2(this, paramArrayOfString));
      return true;
    } while ((paramArrayOfString.length <= 2) || (TextUtils.isEmpty(paramArrayOfString[2])));
    paramArrayOfString = paramArrayOfString[2];
    switch (paramArrayOfString.hashCode())
    {
    default: 
      label252:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return true;
      case 0: 
        ((e)g.r(e.class)).Jn().bJ(true);
        return true;
        if (!paramArrayOfString.equals("-or")) {
          break label252;
        }
        i = 0;
        continue;
        if (!paramArrayOfString.equals("-cr")) {
          break label252;
        }
        i = 1;
        continue;
        if (!paramArrayOfString.equals("-ocb")) {
          break label252;
        }
        i = 2;
      }
    }
    ((e)g.r(e.class)).Jn().bJ(false);
    return true;
    ((e)g.r(e.class)).Jn().bu(paramContext);
    return true;
  }
  
  private static class b
    implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c.a
 * JD-Core Version:    0.7.0.1
 */