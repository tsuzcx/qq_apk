package com.tencent.mm.plugin.appbrand.dynamic.c;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.l;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, final String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(10799);
    if (!((e)g.E(e.class)).acl().acr())
    {
      AppMethodBeat.o(10799);
      return true;
    }
    if (!"//widget".equals(paramArrayOfString[0]))
    {
      AppMethodBeat.o(10799);
      return true;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(10799);
      return true;
    }
    paramString = paramArrayOfString[1].toLowerCase();
    int i;
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
      label115:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(10799);
      return true;
      if (!paramString.equals("assert")) {
        break;
      }
      i = 0;
      break label115;
      if (!paramString.equals("jniassert")) {
        break;
      }
      i = 1;
      break label115;
      if (!paramString.equals("debugger")) {
        break;
      }
      i = 2;
      break label115;
      com.tencent.mm.ch.a.post(new a.1(this, paramArrayOfString));
      continue;
      com.tencent.mm.ch.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(10794);
          String str2 = "com.tencent.mm";
          String str1 = str2;
          if (paramArrayOfString.length > 2)
          {
            str1 = str2;
            if (!TextUtils.isEmpty(paramArrayOfString[2])) {
              str1 = "com.tencent.mm" + ":" + paramArrayOfString[2];
            }
          }
          f.a(str1, null, a.b.class, null);
          AppMethodBeat.o(10794);
        }
      });
      continue;
      if ((paramArrayOfString.length <= 2) || (TextUtils.isEmpty(paramArrayOfString[2])))
      {
        AppMethodBeat.o(10799);
        return true;
      }
      paramArrayOfString = paramArrayOfString[2];
      switch (paramArrayOfString.hashCode())
      {
      default: 
        label296:
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          break;
        case 0: 
          ((e)g.E(e.class)).acl().cL(true);
          break;
          if (!paramArrayOfString.equals("-or")) {
            break label296;
          }
          i = 0;
          continue;
          if (!paramArrayOfString.equals("-cr")) {
            break label296;
          }
          i = 1;
          continue;
          if (!paramArrayOfString.equals("-ocb")) {
            break label296;
          }
          i = 2;
        }
      }
      ((e)g.E(e.class)).acl().cL(false);
      continue;
      ((e)g.E(e.class)).acl().bY(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c.a
 * JD-Core Version:    0.7.0.1
 */