package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ea;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/MegaVideoBulletUtil;", "", "()V", "changeMegaVideoBulletSwitch", "", "context", "Landroid/content/Context;", "objectId", "", "isTurnOn", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bf
{
  public static final bf GlJ;
  
  static
  {
    AppMethodBeat.i(333091);
    GlJ = new bf();
    AppMethodBeat.o(333091);
  }
  
  public static void a(final Context paramContext, final long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(333078);
    kotlin.g.b.s.u(paramContext, "context");
    String str = z.bAW();
    kotlin.g.b.s.s(str, "getMyFinderUsername()");
    int i;
    if (paramBoolean)
    {
      i = 1;
      localObject = as.GSQ;
      localObject = as.a.hu(paramContext);
      if (localObject != null) {
        break label116;
      }
    }
    label116:
    for (Object localObject = null;; localObject = ((as)localObject).fou())
    {
      localObject = new ea(str, paramLong, i, (bui)localObject);
      com.tencent.mm.kernel.h.aZW().a(((ea)localObject).getType(), (com.tencent.mm.am.h)new a((ea)localObject, paramBoolean, paramContext, paramLong));
      com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
      AppMethodBeat.o(333078);
      return;
      i = 0;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/MegaVideoBulletUtil$changeMegaVideoBulletSwitch$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.am.h
  {
    a(ea paramea, boolean paramBoolean, Context paramContext, long paramLong) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(333639);
      if (((paramp instanceof ea)) && (((ea)paramp).hKN == this.GlK.hKN)) {
        com.tencent.mm.kernel.h.aZW().b(this.GlK.getType(), (com.tencent.mm.am.h)this);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject;
        dne localdne;
        if (paramBoolean)
        {
          paramInt1 = e.h.mega_video_has_open_bullet_ok;
          aa.makeText(paramContext, paramInt1, 0).show();
          paramString = e.FMN;
          paramp = e.a.qh(paramLong);
          if (paramp == null) {
            break label284;
          }
          boolean bool = paramBoolean;
          paramString = new ca(paramp);
          if (!bool) {
            break label223;
          }
          localObject = paramString.ABK;
          if (localObject != null)
          {
            localdne = paramString.ABK;
            kotlin.g.b.s.checkNotNull(localdne);
            ((dne)localObject).permissionFlag = (localdne.permissionFlag & 0xFFFFFFF7);
          }
        }
        for (;;)
        {
          localObject = e.FMN;
          e.a.r(paramp);
          paramp = new if();
          paramp.hJB.type = 10;
          paramp.hJB.id = paramString.bZA();
          paramp.hJB.hJp = 1;
          paramp.publish();
          AppMethodBeat.o(333639);
          return;
          paramInt1 = e.h.mega_video_has_close_bullet_ok;
          break;
          label223:
          localObject = paramString.ABK;
          if (localObject != null)
          {
            localdne = paramString.ABK;
            kotlin.g.b.s.checkNotNull(localdne);
            ((dne)localObject).permissionFlag = (localdne.permissionFlag | 0x8);
          }
        }
      }
      else
      {
        if (!paramBoolean) {
          break label290;
        }
      }
      label284:
      label290:
      for (paramInt1 = e.h.mega_video_has_open_bullet_no_ok;; paramInt1 = e.h.mega_video_has_close_bullet_no_ok)
      {
        aa.makeText(paramContext, paramInt1, 0).show();
        AppMethodBeat.o(333639);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bf
 * JD-Core Version:    0.7.0.1
 */