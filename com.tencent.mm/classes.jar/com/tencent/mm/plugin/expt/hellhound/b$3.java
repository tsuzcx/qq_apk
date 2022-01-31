package com.tencent.mm.plugin.expt.hellhound;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.c;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.plugin.expt.hellhound.core.stack.g;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.sdk.platformtools.ab;

final class b$3
  implements b.b
{
  public final void brm()
  {
    AppMethodBeat.i(152236);
    d.brC();
    be localbe = g.Mh("com.tencent.mm.ui.LauncherUI");
    if (localbe == null)
    {
      AppMethodBeat.o(152236);
      return;
    }
    ab.w("HellhoundService", "habbyge-mali, fragment, onChattingUIFragmentSessionEnd: " + localbe.wnt);
    Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.Mf(com.tencent.mm.plugin.expt.hellhound.core.b.Mb(localbe.wnt));
    if (localFragment != null)
    {
      ab.w("HellhoundService", "HABBYGE-MALI, chat fragment, onPause: " + localFragment.getClass().getSimpleName());
      a.a(localFragment, 1);
      c.a(localFragment, 1);
    }
    com.tencent.mm.plugin.expt.hellhound.a.b.b.brY().a(null, localbe, 7, null);
    AppMethodBeat.o(152236);
  }
  
  public final void ec(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152234);
    ab.i("HellhoundService", "habbyge-mali, setFragmentListener, onResume: " + paramString1 + ", " + paramString2);
    com.tencent.mm.plugin.expt.hellhound.a.b.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.b.brY();
    com.tencent.mm.plugin.expt.hellhound.a.b.b.g(paramString1, paramString2, System.currentTimeMillis());
    d.brC();
    be localbe = e.brH();
    if (localbe == null)
    {
      AppMethodBeat.o(152234);
      return;
    }
    Object localObject;
    if ((localbe.wns == null) || (localbe.wns.isEmpty()))
    {
      localbe.wns = paramString2;
      paramString2 = d.brG();
      localObject = new StringBuilder("habbyge-mali, fragment, in: ").append(localbe.wns).append(" / ");
      if (!TextUtils.isEmpty(localbe.wnt)) {
        break label271;
      }
      if (paramString2 != null) {
        break label260;
      }
      paramString1 = "Null";
      label132:
      ab.i("HellhoundService", paramString1);
      if (!TextUtils.isEmpty(localbe.wnt)) {
        break label279;
      }
    }
    label260:
    label271:
    label279:
    for (paramString1 = paramString2;; paramString1 = localbe)
    {
      localb.a(null, localbe, 4, paramString1);
      paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.Mf(com.tencent.mm.plugin.expt.hellhound.core.b.Mb(localbe.wns));
      if (paramString1 != null)
      {
        ab.w("HellhoundService", "HABBYGE-MALI, fragment, onResume: " + paramString1.getClass().getSimpleName());
        a.a(paramString1, 0);
        c.a(paramString1, 0);
      }
      AppMethodBeat.o(152234);
      return;
      paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(localbe.wns);
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(paramString2);
      if ((paramString1 != null) && (paramString1.equals(localObject))) {
        break;
      }
      localbe.wns = paramString2;
      break;
      paramString1 = paramString2.wnr.activityName;
      break label132;
      paramString1 = localbe.wnt;
      break label132;
    }
  }
  
  public final void ed(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152235);
    ab.i("HellhoundService", "habbyge-mali, setFragmentListener, onPause: " + paramString1 + ", " + paramString2);
    com.tencent.mm.plugin.expt.hellhound.a.b.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.b.brY();
    com.tencent.mm.plugin.expt.hellhound.a.b.b.h(paramString1, paramString2, System.currentTimeMillis());
    d.brC();
    paramString1 = g.Mh(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(152235);
      return;
    }
    if ((paramString1.wnt == null) || (paramString1.wnt.isEmpty())) {}
    for (paramString1.wnt = paramString2;; paramString1.wnt = paramString2)
    {
      String str1;
      String str2;
      do
      {
        ab.w("HellhoundService", "habbyge-mali, fragment, out: " + paramString1.wnt);
        localb.a(null, paramString1, 5, null);
        paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.Mf(com.tencent.mm.plugin.expt.hellhound.core.b.Mb(paramString1.wnt));
        if (paramString1 != null)
        {
          ab.w("HellhoundService", "HABBYGE-MALI, fragment, onPause: " + paramString1.getClass().getSimpleName());
          a.a(paramString1, 1);
          c.a(paramString1, 1);
        }
        AppMethodBeat.o(152235);
        return;
        str1 = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(paramString1.wnt);
        str2 = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(paramString2);
      } while ((str1 != null) && (str1.equals(str2)));
    }
  }
  
  public final void vi(int paramInt)
  {
    AppMethodBeat.i(152237);
    com.tencent.mm.plugin.expt.hellhound.a.b.b.brY().ei(8, paramInt);
    Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.Mf("MoreTabUI");
    if (localFragment != null)
    {
      ab.w("HellhoundService", "HABBYGE-MALI, onStoryGalleryViewResume: " + localFragment.getClass().getSimpleName());
      a.a(localFragment, 0);
      c.a(localFragment, 0);
    }
    AppMethodBeat.o(152237);
  }
  
  public final void vj(int paramInt)
  {
    AppMethodBeat.i(152238);
    Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.Mf("MoreTabUI");
    if (localFragment != null)
    {
      ab.w("HellhoundService", "HABBYGE-MALI, onStoryGalleryViewPause: " + localFragment.getClass().getSimpleName());
      a.a(localFragment, 1);
      c.a(localFragment, 1);
    }
    com.tencent.mm.plugin.expt.hellhound.a.b.b.brY().ei(9, paramInt);
    AppMethodBeat.o(152238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.3
 * JD-Core Version:    0.7.0.1
 */