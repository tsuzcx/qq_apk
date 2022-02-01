package com.tencent.mm.plugin.finder.live.gala.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.utils.bq;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/plugin/FinderLiveGalaGroupHintPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "context", "Lcom/tencent/mm/ui/MMActivity;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "finderLiveHintBottomSheet", "Lcom/tencent/mm/plugin/finder/live/gala/FinderLiveGalaHintBottomSheet;", "getFinderLiveHintBottomSheet", "()Lcom/tencent/mm/plugin/finder/live/gala/FinderLiveGalaHintBottomSheet;", "finderLiveHintBottomSheet$delegate", "Lkotlin/Lazy;", "isFromChatEnter", "", "checkShowActionSheet", "", "handleShareToChatGroup", "params", "Landroid/os/Bundle;", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "switchToBox", "groupId", "", "transmitToGroup", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.live.plugin.b
{
  public static final a adlE;
  private final kotlin.j adlF;
  private final boolean adlG;
  
  static
  {
    AppMethodBeat.i(371216);
    adlE = new a((byte)0);
    AppMethodBeat.o(371216);
  }
  
  public a(MMActivity paramMMActivity, ViewGroup paramViewGroup, final com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(371200);
    this.adlF = kotlin.k.cm((kotlin.g.a.a)new c(paramMMActivity, paramb));
    this.adlG = paramMMActivity.getIntent().getBooleanExtra("key_enter_live_param_is_from_chat_group", false);
    AppMethodBeat.o(371200);
  }
  
  final com.tencent.mm.plugin.finder.live.gala.a ivv()
  {
    AppMethodBeat.i(371221);
    com.tencent.mm.plugin.finder.live.gala.a locala = (com.tencent.mm.plugin.finder.live.gala.a)this.adlF.getValue();
    AppMethodBeat.o(371221);
    return locala;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    com.tencent.mm.plugin.finder.live.gala.a locala = null;
    AppMethodBeat.i(371226);
    kotlin.g.b.s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    label130:
    label317:
    do
    {
      do
      {
        AppMethodBeat.o(371226);
        return;
        if (paramBundle != null) {
          break;
        }
      } while (bool);
      paramBundle = (com.tencent.mm.plugin.finder.live.business.b)business(com.tencent.mm.plugin.finder.live.business.b.class);
      paramc = this.mJe.getContext();
      if ((paramc instanceof Activity)) {}
      for (paramc = (Activity)paramc;; paramc = null)
      {
        if (!paramBundle.cr(paramc)) {
          break label130;
        }
        Log.i("GalaGroupHintPlugin", "checkShowActionSheet skip by couplets dialog");
        AppMethodBeat.o(371226);
        return;
        bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW");
        break;
      }
      locala = ivv();
      paramc = com.tencent.mm.plugin.finder.live.gala.d.b.admb;
      paramc = (bfv)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgQ.getValue();
      if (paramc == null)
      {
        paramc = "";
        locala.abwL = com.tencent.mm.plugin.finder.live.gala.d.b.bhS(paramc);
        paramc = new StringBuilder("isFromChatEnter: ").append(this.adlG).append(", ");
        paramBundle = com.tencent.mm.plugin.finder.live.gala.d.b.admb;
        paramc = paramc.append(com.tencent.mm.plugin.finder.live.gala.d.b.jdm()).append(", ");
        paramBundle = bq.akii;
        Log.i("GalaGroupHintPlugin", bq.B(getBuContext()));
        paramc = com.tencent.mm.plugin.finder.live.gala.d.b.admb;
        if (com.tencent.mm.plugin.finder.live.gala.d.b.jdm())
        {
          paramc = bq.akii;
          if (bq.B(getBuContext()))
          {
            paramBundle = ivv();
            if (!this.adlG) {
              break label317;
            }
          }
        }
      }
      for (paramc = com.tencent.mm.plugin.finder.live.gala.a.a.adlz;; paramc = com.tencent.mm.plugin.finder.live.gala.a.a.adly)
      {
        paramBundle.a(paramc);
        paramc = com.tencent.mm.plugin.finder.live.gala.d.b.admb;
        com.tencent.mm.plugin.finder.live.gala.d.b.jdn();
        AppMethodBeat.o(371226);
        return;
        paramBundle = paramc.id;
        paramc = paramBundle;
        if (paramBundle != null) {
          break;
        }
        paramc = "";
        break;
      }
    } while ((paramBundle == null) || (paramBundle.getInt("requestCode") != 16));
    bool = paramBundle.getBoolean("is_share_success");
    paramc = paramBundle.getStringArrayList("current_group_select");
    int i;
    if (bool)
    {
      paramBundle = (Collection)paramc;
      if ((paramBundle != null) && (!paramBundle.isEmpty())) {
        break label460;
      }
      i = 1;
      label382:
      if (i == 0) {
        kotlinx.coroutines.j.a(ar.d((f)bg.kCi()), null, null, (m)new d(paramc, this, null), 3);
      }
    }
    paramBundle = new StringBuilder("handleShareToChatGroup: ").append(bool).append(" groupId: ");
    if (paramc == null) {}
    for (paramc = locala;; paramc = p.a((Iterable)paramc, (CharSequence)",", null, null, 0, null, null, 62))
    {
      Log.i("GalaGroupHintPlugin", paramc);
      break;
      label460:
      i = 0;
      break label382;
    }
  }
  
  public final void tO(int paramInt) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/plugin/FinderLiveGalaGroupHintPlugin$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/gala/FinderLiveGalaHintBottomSheet;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.gala.a>
  {
    c(MMActivity paramMMActivity, com.tencent.mm.live.b.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    d(ArrayList<String> paramArrayList, a parama, d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(371218);
      paramObject = (d)new d(this.adlI, jdField_this, paramd);
      AppMethodBeat.o(371218);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(371206);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(371206);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = (String)p.oM((List)this.adlI);
      localObject = jdField_this;
      kotlin.g.b.s.s(paramObject, "lastGroupId");
      a.a((a)localObject, paramObject);
      paramObject = ah.aiuX;
      AppMethodBeat.o(371206);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    e(a parama, String paramString, d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(371198);
      paramObject = (d)new e(this.adlJ, this.adlK, paramd);
      AppMethodBeat.o(371198);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(371194);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(371194);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)this.adlJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class);
        String str = this.adlK;
        d locald = (d)this;
        this.label = 1;
        if (paramObject.c(str, true, locald) == localObject)
        {
          AppMethodBeat.o(371194);
          return localObject;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)this.adlJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class);
      localObject = bq.akii;
      paramObject.a(bq.bLz(this.adlK));
      paramObject = com.tencent.mm.plugin.finder.live.gala.c.a.adlY;
      com.tencent.mm.plugin.finder.live.gala.c.a.aCS(this.adlK);
      paramObject = ah.aiuX;
      AppMethodBeat.o(371194);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.gala.b.a
 * JD-Core Version:    0.7.0.1
 */