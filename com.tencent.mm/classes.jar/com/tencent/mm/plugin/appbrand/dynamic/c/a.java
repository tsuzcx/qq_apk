package com.tencent.mm.plugin.appbrand.dynamic.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.protocal.MMProtocalJni;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, final String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(121281);
    if (!((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().aEc())
    {
      AppMethodBeat.o(121281);
      return true;
    }
    if (!"//widget".equals(paramArrayOfString[0]))
    {
      AppMethodBeat.o(121281);
      return true;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(121281);
      return true;
    }
    paramString = paramArrayOfString[1].toLowerCase();
    int i;
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
      label111:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(121281);
      return true;
      if (!paramString.equals("assert")) {
        break;
      }
      i = 0;
      break label111;
      if (!paramString.equals("jniassert")) {
        break;
      }
      i = 1;
      break label111;
      if (!paramString.equals("debugger")) {
        break;
      }
      i = 2;
      break label111;
      com.tencent.mm.ch.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121275);
          String str2 = "com.tencent.mm";
          String str1 = str2;
          if (paramArrayOfString.length > 2)
          {
            str1 = str2;
            if (!TextUtils.isEmpty(paramArrayOfString[2])) {
              str1 = "com.tencent.mm" + ":" + paramArrayOfString[2];
            }
          }
          h.a(str1, null, a.a.class, null);
          AppMethodBeat.o(121275);
        }
      });
      continue;
      com.tencent.mm.ch.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121276);
          String str2 = "com.tencent.mm";
          String str1 = str2;
          if (paramArrayOfString.length > 2)
          {
            str1 = str2;
            if (!TextUtils.isEmpty(paramArrayOfString[2])) {
              str1 = "com.tencent.mm" + ":" + paramArrayOfString[2];
            }
          }
          h.a(str1, null, a.b.class, null);
          AppMethodBeat.o(121276);
        }
      });
      continue;
      if ((paramArrayOfString.length <= 2) || (TextUtils.isEmpty(paramArrayOfString[2])))
      {
        AppMethodBeat.o(121281);
        return true;
      }
      paramArrayOfString = paramArrayOfString[2];
      switch (paramArrayOfString.hashCode())
      {
      default: 
        label288:
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          break;
        case 0: 
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().eC(true);
          break;
          if (!paramArrayOfString.equals("-or")) {
            break label288;
          }
          i = 0;
          continue;
          if (!paramArrayOfString.equals("-cr")) {
            break label288;
          }
          i = 1;
          continue;
          if (!paramArrayOfString.equals("-ocb")) {
            break label288;
          }
          i = 2;
        }
      }
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().eC(false);
      continue;
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().cz(paramContext);
    }
  }
  
  static class a
    implements b<Bundle, Bundle>
  {}
  
  static class b
    implements b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c.a
 * JD-Core Version:    0.7.0.1
 */