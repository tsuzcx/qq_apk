package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.plugin.f;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.b;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "context", "Landroid/content/Context;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "getContext", "()Landroid/content/Context;", "shouldCaptureOnClose", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends c
{
  private static final b DOA;
  public static final a DOz;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(357795);
    DOz = new a((byte)0);
    DOA = new b();
    AppMethodBeat.o(357795);
  }
  
  public d(Context paramContext, com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(357777);
    this.context = paramContext;
    AppMethodBeat.o(357777);
  }
  
  public final boolean evu()
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper$Companion;", "", "()V", "KEY_MULTI_TASK_INFO", "", "TAG", "taskBarEventListener", "com/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper$Companion$taskBarEventListener$1;", "startListeningTaskBarEvent", "", "stopListeningTaskBarEvent", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void evw()
    {
      AppMethodBeat.i(357483);
      ((b)h.ax(b.class)).a(21, (b.a)d.evv());
      AppMethodBeat.o(357483);
    }
    
    public static void evx()
    {
      AppMethodBeat.i(357488);
      ((b)h.ax(b.class)).b(21, (b.a)d.evv());
      AppMethodBeat.o(357488);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.a
  {
    public final void a(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(357481);
      s.u(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(357481);
    }
    
    public final void b(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(357502);
      s.u(paramMultiTaskInfo, "multiTaskInfo");
      Object localObject4 = new bkg();
      Object localObject5;
      int i;
      Object localObject2;
      Object localObject6;
      try
      {
        ((bkg)localObject4).parseFrom(paramMultiTaskInfo.field_data);
        ((bkg)localObject4).key = paramMultiTaskInfo.field_id;
        if (s.p(((bkg)localObject4).key, "wedraw"))
        {
          AppMethodBeat.o(357502);
          return;
        }
      }
      finally
      {
        for (;;)
        {
          Log.e("FinderLiveMultiTaskHelper", "MegaVideoFloatBallInfo parse fail", new Object[] { localObject1 });
        }
        localObject5 = new ArrayList();
        paramMultiTaskInfo = ((bkg)localObject4).ZTu;
        s.s(paramMultiTaskInfo, "data.allHistoryFinderObjectList");
        if (!((Collection)paramMultiTaskInfo).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label511;
          }
          paramMultiTaskInfo = ((bkg)localObject4).ZTu;
          s.s(paramMultiTaskInfo, "data.allHistoryFinderObjectList");
          localObject2 = (Iterable)paramMultiTaskInfo;
          paramMultiTaskInfo = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            localObject6 = aw.Gjk;
            s.s(localObject3, "it");
            paramMultiTaskInfo.add(aw.a((FinderObject)localObject3, 0, false, 6));
          }
        }
        ((ArrayList)localObject5).addAll((Collection)paramMultiTaskInfo);
      }
      Object localObject3 = new FinderLiveBundle();
      if (((bkg)localObject4).ZTu.size() > 0) {
        ((FinderLiveBundle)localObject3).CEY = androidx.core.b.a.clamp(((bkg)localObject4).ZTt, 0, ((bkg)localObject4).ZTu.size() - 1);
      }
      ((FinderLiveBundle)localObject3).ag((ArrayList)localObject5);
      ((FinderLiveBundle)localObject3).hJx = 1010;
      paramMultiTaskInfo = ((bkg)localObject4).ABJ;
      label306:
      label324:
      label342:
      label362:
      long l1;
      label373:
      long l2;
      if (paramMultiTaskInfo == null)
      {
        paramMultiTaskInfo = "";
        ((FinderLiveBundle)localObject3).awv(paramMultiTaskInfo);
        paramMultiTaskInfo = ((bkg)localObject4).ABJ;
        if (paramMultiTaskInfo != null) {
          break label968;
        }
        i = 0;
        ((FinderLiveBundle)localObject3).extFlag = i;
        paramMultiTaskInfo = ((bkg)localObject4).ABJ;
        if (paramMultiTaskInfo != null) {
          break label990;
        }
        i = 0;
        localObject5 = (ce)j.Dob;
        paramMultiTaskInfo = ((bkg)localObject4).ABJ;
        if (paramMultiTaskInfo != null) {
          break label1012;
        }
        paramMultiTaskInfo = null;
        if (paramMultiTaskInfo != null) {
          break label1023;
        }
        l1 = ((bkg)localObject4).mIH;
        l2 = ((bkg)localObject4).liveId;
        paramMultiTaskInfo = ((bkg)localObject4).ABJ;
        if (paramMultiTaskInfo != null) {
          break label1032;
        }
      }
      label898:
      label1032:
      for (paramMultiTaskInfo = null;; paramMultiTaskInfo = paramMultiTaskInfo.username)
      {
        localObject2 = paramMultiTaskInfo;
        if (paramMultiTaskInfo == null) {
          localObject2 = ((bkg)localObject4).mIC;
        }
        ce.a.a((ce)localObject5, l1, l2, (String)localObject2, ((bkg)localObject4).ZTt, i, q.w.DwU, q.n.DtG.scene);
        paramMultiTaskInfo = new Intent();
        paramMultiTaskInfo.putExtra("KEY_MULTI_TASK_INFO", ((bkg)localObject4).toByteArray());
        localObject2 = h.ax(f.class);
        s.s(localObject2, "service(IActivityRouter::class.java)");
        localObject2 = (f)localObject2;
        localObject4 = MMApplicationContext.getContext();
        s.s(localObject4, "getContext()");
        f.a.a((f)localObject2, (Context)localObject4, (FinderLiveBundle)localObject3, null, null, paramMultiTaskInfo, false, 44);
        AppMethodBeat.o(357502);
        return;
        label511:
        localObject6 = new LiveConfig.a();
        paramMultiTaskInfo = ((bkg)localObject4).ABJ;
        int j;
        label549:
        label583:
        label599:
        label611:
        StringBuilder localStringBuilder;
        if (paramMultiTaskInfo != null)
        {
          paramMultiTaskInfo = paramMultiTaskInfo.liveInfo;
          if ((paramMultiTaskInfo != null) && (paramMultiTaskInfo.liveStatus == 1))
          {
            j = 1;
            if (j == 0) {
              break label833;
            }
            paramMultiTaskInfo = ((bkg)localObject4).ABJ;
            if (paramMultiTaskInfo == null) {
              break label833;
            }
            paramMultiTaskInfo = paramMultiTaskInfo.liveInfo;
            if (paramMultiTaskInfo == null) {
              break label833;
            }
            localObject2 = paramMultiTaskInfo.mIE;
            if (localObject2 == null) {
              break label833;
            }
            if (j == 0) {
              break label887;
            }
            paramMultiTaskInfo = ((bkg)localObject4).ABJ;
            if (paramMultiTaskInfo != null) {
              break label840;
            }
            paramMultiTaskInfo = null;
            if (paramMultiTaskInfo != null) {
              break label879;
            }
            paramMultiTaskInfo = e.b.mKf;
            i = e.b.bcu();
            if (j == 0) {
              break label892;
            }
            paramMultiTaskInfo = ((bkg)localObject4).ABJ;
            if (paramMultiTaskInfo == null) {
              break label892;
            }
            paramMultiTaskInfo = paramMultiTaskInfo.liveInfo;
            if (paramMultiTaskInfo == null) {
              break label892;
            }
            paramMultiTaskInfo = paramMultiTaskInfo.ZOg;
            if (paramMultiTaskInfo == null) {
              break label892;
            }
            localObject3 = paramMultiTaskInfo.toByteArray();
            label649:
            if (j == 0)
            {
              localStringBuilder = new StringBuilder("onTaskBarItemClicked liveId:");
              paramMultiTaskInfo = ((bkg)localObject4).ABJ;
              if (paramMultiTaskInfo != null) {
                break label898;
              }
              paramMultiTaskInfo = null;
              label677:
              localStringBuilder = localStringBuilder.append(paramMultiTaskInfo).append(",liveStatus:");
              paramMultiTaskInfo = ((bkg)localObject4).ABJ;
              if (paramMultiTaskInfo != null) {
                break label923;
              }
              paramMultiTaskInfo = null;
            }
          }
        }
        for (;;)
        {
          Log.i("FinderLiveMultiTaskHelper", paramMultiTaskInfo);
          ((LiveConfig.a)localObject6).mIy = LiveConfig.mIt;
          ((LiveConfig.a)localObject6).liveId = ((bkg)localObject4).liveId;
          ((LiveConfig.a)localObject6).nonceId = ((bkg)localObject4).nonceId;
          ((LiveConfig.a)localObject6).mIH = ((bkg)localObject4).mIH;
          ((LiveConfig.a)localObject6).mIE = ((String)localObject2);
          ((LiveConfig.a)localObject6).mIF = i;
          ((LiveConfig.a)localObject6).mIC = ((bkg)localObject4).mIC;
          ((LiveConfig.a)localObject6).desc = ((bkg)localObject4).desc;
          ((LiveConfig.a)localObject6).sessionBuffer = ((bkg)localObject4).sessionBuffer;
          ((LiveConfig.a)localObject6).mIW = ((byte[])localObject3);
          paramMultiTaskInfo = ((LiveConfig.a)localObject6).bcd();
          s.s(paramMultiTaskInfo, "builder.toWhere(LiveConf…                 .build()");
          ((ArrayList)localObject5).add(paramMultiTaskInfo);
          break;
          j = 0;
          break label549;
          label833:
          localObject2 = "";
          break label583;
          label840:
          paramMultiTaskInfo = paramMultiTaskInfo.liveInfo;
          if (paramMultiTaskInfo == null)
          {
            paramMultiTaskInfo = null;
            break label599;
          }
          paramMultiTaskInfo = paramMultiTaskInfo.ZRQ;
          if (paramMultiTaskInfo == null)
          {
            paramMultiTaskInfo = null;
            break label599;
          }
          paramMultiTaskInfo = Integer.valueOf(paramMultiTaskInfo.mNn);
          break label599;
          label879:
          i = paramMultiTaskInfo.intValue();
          break label611;
          label887:
          i = 0;
          break label611;
          label892:
          localObject3 = null;
          break label649;
          paramMultiTaskInfo = paramMultiTaskInfo.liveInfo;
          if (paramMultiTaskInfo == null)
          {
            paramMultiTaskInfo = null;
            break label677;
          }
          paramMultiTaskInfo = Long.valueOf(paramMultiTaskInfo.liveId);
          break label677;
          label923:
          paramMultiTaskInfo = paramMultiTaskInfo.contact;
          if (paramMultiTaskInfo == null) {
            paramMultiTaskInfo = null;
          } else {
            paramMultiTaskInfo = Integer.valueOf(paramMultiTaskInfo.liveStatus);
          }
        }
        localObject2 = paramMultiTaskInfo.nickname;
        paramMultiTaskInfo = (MultiTaskInfo)localObject2;
        if (localObject2 != null) {
          break label306;
        }
        paramMultiTaskInfo = "";
        break label306;
        label968:
        paramMultiTaskInfo = paramMultiTaskInfo.liveInfo;
        if (paramMultiTaskInfo == null)
        {
          i = 0;
          break label324;
        }
        i = paramMultiTaskInfo.ZRR;
        break label324;
        label990:
        paramMultiTaskInfo = paramMultiTaskInfo.liveInfo;
        if (paramMultiTaskInfo == null)
        {
          i = 0;
          break label342;
        }
        i = paramMultiTaskInfo.DSe;
        break label342;
        label1012:
        paramMultiTaskInfo = Long.valueOf(paramMultiTaskInfo.id);
        break label362;
        label1023:
        l1 = paramMultiTaskInfo.longValue();
        break label373;
      }
    }
    
    public final void c(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(357507);
      s.u(paramMultiTaskInfo, "multiTaskInfo");
      if (s.p(paramMultiTaskInfo.field_id, "wedraw"))
      {
        AppMethodBeat.o(357507);
        return;
      }
      AppMethodBeat.o(357507);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.d
 * JD-Core Version:    0.7.0.1
 */