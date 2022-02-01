package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.da;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.base.w;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/MegaVideoBulletUtil;", "", "()V", "changeMegaVideoBulletSwitch", "", "context", "Landroid/content/Context;", "objectId", "", "isTurnOn", "", "plugin-finder_release"})
public final class as
{
  public static final as AJf;
  
  static
  {
    AppMethodBeat.i(282315);
    AJf = new as();
    AppMethodBeat.o(282315);
  }
  
  public static void a(final Context paramContext, final long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(282314);
    p.k(paramContext, "context");
    String str = z.bdh();
    p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
    int i;
    if (paramBoolean)
    {
      i = 1;
      localObject = aj.Bnu;
      localObject = aj.a.fZ(paramContext);
      if (localObject == null) {
        break label119;
      }
    }
    label119:
    for (Object localObject = ((aj)localObject).ekY();; localObject = null)
    {
      localObject = new da(str, paramLong, i, (bid)localObject);
      h.aGY().a(((da)localObject).getType(), (i)new a((da)localObject, paramBoolean, paramContext, paramLong));
      h.aGY().b((q)localObject);
      AppMethodBeat.o(282314);
      return;
      i = 0;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/MegaVideoBulletUtil$changeMegaVideoBulletSwitch$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class a
    implements i
  {
    a(da paramda, boolean paramBoolean, Context paramContext, long paramLong) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(288525);
      if (((paramq instanceof da)) && (((da)paramq).xbk == this.AJg.xbk)) {
        h.aGY().b(this.AJg.getType(), (i)this);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject;
        cvy localcvy;
        if (paramBoolean)
        {
          paramInt1 = b.j.mega_video_has_open_bullet_ok;
          w.makeText(paramContext, paramInt1, 0).show();
          paramString = e.AmW;
          paramq = e.a.MM(paramLong);
          if (paramq == null) {
            break label269;
          }
          paramString = new bs(paramq);
          if (!paramBoolean) {
            break label228;
          }
          localObject = paramString.xcy;
          if (localObject != null)
          {
            localcvy = paramString.xcy;
            if (localcvy == null) {
              p.iCn();
            }
            ((cvy)localObject).permissionFlag = (localcvy.permissionFlag & 0xFFFFFFF7);
          }
        }
        for (;;)
        {
          localObject = e.AmW;
          e.a.o(paramq);
          paramq = new hu();
          paramq.fEL.type = 10;
          paramq.fEL.id = paramString.mf();
          paramq.fEL.fEz = 1;
          EventCenter.instance.publish((IEvent)paramq);
          AppMethodBeat.o(288525);
          return;
          paramInt1 = b.j.mega_video_has_close_bullet_ok;
          break;
          label228:
          localObject = paramString.xcy;
          if (localObject != null)
          {
            localcvy = paramString.xcy;
            if (localcvy == null) {
              p.iCn();
            }
            ((cvy)localObject).permissionFlag = (localcvy.permissionFlag | 0x8);
          }
        }
        label269:
        AppMethodBeat.o(288525);
        return;
      }
      if (paramBoolean) {}
      for (paramInt1 = b.j.mega_video_has_open_bullet_no_ok;; paramInt1 = b.j.mega_video_has_close_bullet_no_ok)
      {
        w.makeText(paramContext, paramInt1, 0).show();
        AppMethodBeat.o(288525);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.as
 * JD-Core Version:    0.7.0.1
 */