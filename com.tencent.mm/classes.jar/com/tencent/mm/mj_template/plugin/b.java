package com.tencent.mm.mj_template.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.mj_template.api.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.z;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/plugin/FinderMaasXConfigImpl;", "Lcom/tencent/mm/mj_template/api/IFinderMaasXConfig;", "()V", "TAG", "", "albumQuickCreation", "", "fallbackNoNetError", "fallbackWhenNetError", "offlineStrategy", "showCreationSameEntry", "versionMin", "", "iVersionMax", "type", "showEventPostEntry", "showFeedCreationSameEntry", "showMainPostEntry", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  public static final b ocx;
  
  static
  {
    AppMethodBeat.i(239648);
    ocx = new b();
    AppMethodBeat.o(239648);
  }
  
  public static boolean byp()
  {
    AppMethodBeat.i(239633);
    int i = ((c)h.ax(c.class)).a(c.a.zeP, b.a.agsq, 0);
    Log.i("FinderMaasXConfigImpl", s.X("finder fallback ", Integer.valueOf(i)));
    if (i == 1)
    {
      AppMethodBeat.o(239633);
      return true;
    }
    AppMethodBeat.o(239633);
    return false;
  }
  
  public static boolean byq()
  {
    AppMethodBeat.i(239638);
    int i = ((c)h.ax(c.class)).a(c.a.zeP, b.a.agsq, 0);
    Log.i("FinderMaasXConfigImpl", s.X("finder fallback ", Integer.valueOf(i)));
    if (i == 2)
    {
      AppMethodBeat.o(239638);
      return true;
    }
    AppMethodBeat.o(239638);
    return false;
  }
  
  public static boolean byr()
  {
    AppMethodBeat.i(239645);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zeQ, false);
    Log.i("FinderMaasXConfigImpl", s.X("offlineStrategy: ", Boolean.valueOf(bool)));
    AppMethodBeat.o(239645);
    return bool;
  }
  
  public final boolean af(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(239664);
    paramInt2 = z.aKc(paramInt2);
    if ((1001000 < paramInt1) || (1001000L > (paramInt2 & 0xFFFFFFFF)))
    {
      Log.i("FinderMaasXConfigImpl", "showEventPostEntry sdk version 1001000 not match template version range [" + paramInt1 + ", " + z.cJ(paramInt2) + ']');
      AppMethodBeat.o(239664);
      return false;
    }
    boolean bool1;
    switch (paramInt3)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      Log.i("FinderMaasXConfigImpl", s.X("showEventPostEntry: ", Boolean.valueOf(bool1)));
      Object localObject = com.tencent.mm.mj_template.album_template.b.nWa;
      boolean bool2 = com.tencent.mm.mj_template.album_template.b.bwC();
      AppMethodBeat.o(239664);
      return bool1 & bool2;
      if (((c)h.ax(c.class)).a(c.a.zex, b.a.agsa, 0) == 1)
      {
        bool1 = true;
      }
      else
      {
        bool1 = false;
        continue;
        localObject = i.agtt;
        localObject = i.a(b.a.agsu, Integer.valueOf(-1));
        if (s.p(localObject, Integer.valueOf(0))) {
          break;
        }
        if (s.p(localObject, Integer.valueOf(1)))
        {
          bool1 = true;
        }
        else
        {
          bool1 = ((c)h.ax(c.class)).a(c.a.zeC, false);
          Log.i("FinderMaasXConfigImpl", s.X("MaasTemplateCamera transfer enable:", Boolean.valueOf(bool1)));
          if ((bool1) && (BuildInfo.IS_ARM64)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
      }
    }
  }
  
  public final boolean ag(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(239674);
    paramInt2 = z.aKc(paramInt2);
    if ((1001000 < paramInt1) || (1001000L > (paramInt2 & 0xFFFFFFFF)))
    {
      Log.i("FinderMaasXConfigImpl", "showCreationSameEntry sdk version 1001000 not match template version range [" + paramInt1 + ", " + z.cJ(paramInt2) + ']');
      AppMethodBeat.o(239674);
      return false;
    }
    boolean bool1;
    switch (paramInt3)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      bool2 = ((cn)h.az(cn.class)).showPostEntry();
      Log.i("FinderMaasXConfigImpl", "showCreationSameEntry: " + bool1 + ", enbalePost: " + bool2);
      Object localObject = com.tencent.mm.mj_template.album_template.b.nWa;
      boolean bool3 = com.tencent.mm.mj_template.album_template.b.bwC();
      AppMethodBeat.o(239674);
      return bool2 & bool1 & bool3;
      bool1 = bool2;
      if (((c)h.ax(c.class)).a(c.a.zey, b.a.agsb, 0) != 1)
      {
        bool1 = false;
        continue;
        localObject = i.agtt;
        localObject = i.a(b.a.agst, Integer.valueOf(-1));
        if (s.p(localObject, Integer.valueOf(0))) {
          break;
        }
        bool1 = bool2;
        if (!s.p(localObject, Integer.valueOf(1)))
        {
          bool1 = ((c)h.ax(c.class)).a(c.a.zeB, false);
          Log.i("FinderMaasXConfigImpl", s.X("MaasTemplateCamera transfer enable:", Boolean.valueOf(bool1)));
          if (bool1)
          {
            bool1 = bool2;
            if (BuildInfo.IS_ARM64) {}
          }
          else
          {
            bool1 = false;
          }
        }
      }
    }
  }
  
  public final boolean ah(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(239684);
    paramInt2 = z.aKc(paramInt2);
    if ((1001000 < paramInt1) || (1001000L > (paramInt2 & 0xFFFFFFFF)))
    {
      Log.i("FinderMaasXConfigImpl", "showFeedCreationSameEntry sdk version 1001000 not match template version range [" + paramInt1 + ", " + z.cJ(paramInt2) + ']');
      AppMethodBeat.o(239684);
      return false;
    }
    boolean bool1;
    switch (paramInt3)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      bool2 = ((cn)h.az(cn.class)).showPostEntry();
      Log.i("FinderMaasXConfigImpl", "showFeedCreationSameEntry: " + bool1 + ", enbalePost: " + bool2);
      Object localObject = com.tencent.mm.mj_template.album_template.b.nWa;
      boolean bool3 = com.tencent.mm.mj_template.album_template.b.bwC();
      AppMethodBeat.o(239684);
      return bool2 & bool1 & bool3;
      bool1 = bool2;
      if (((c)h.ax(c.class)).a(c.a.zez, b.a.agsc, 0) != 1)
      {
        bool1 = false;
        continue;
        localObject = i.agtt;
        localObject = i.a(b.a.agss, Integer.valueOf(-1));
        if (s.p(localObject, Integer.valueOf(0))) {
          break;
        }
        bool1 = bool2;
        if (!s.p(localObject, Integer.valueOf(1)))
        {
          bool1 = ((c)h.ax(c.class)).a(c.a.zeA, false);
          Log.i("FinderMaasXConfigImpl", s.X("MaasTemplateCamera follow enable:", Boolean.valueOf(bool1)));
          if (bool1)
          {
            bool1 = bool2;
            if (BuildInfo.IS_ARM64) {}
          }
          else
          {
            bool1 = false;
          }
        }
      }
    }
  }
  
  public final boolean bxg()
  {
    AppMethodBeat.i(239656);
    if (((c)h.ax(c.class)).a(c.a.zew, b.a.agrZ, 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("FinderMaasXConfigImpl", s.X("showMainPostEntry: ", Boolean.valueOf(bool1)));
      com.tencent.mm.mj_template.album_template.b localb = com.tencent.mm.mj_template.album_template.b.nWa;
      boolean bool2 = com.tencent.mm.mj_template.album_template.b.bwC();
      AppMethodBeat.o(239656);
      return bool1 & bool2;
    }
  }
  
  public final boolean bxh()
  {
    AppMethodBeat.i(239690);
    if (((c)h.ax(c.class)).a(c.a.zeD, b.a.agsd, 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("FinderMaasXConfigImpl", s.X("albumQuickCreation: ", Boolean.valueOf(bool1)));
      com.tencent.mm.mj_template.album_template.b localb = com.tencent.mm.mj_template.album_template.b.nWa;
      boolean bool2 = com.tencent.mm.mj_template.album_template.b.bwC();
      AppMethodBeat.o(239690);
      return bool1 & bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.plugin.b
 * JD-Core Version:    0.7.0.1
 */