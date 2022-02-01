package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.util.u;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/BizModeSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "<set-?>", "", "bizNickname", "getBizNickname", "()Ljava/lang/String;", "bizUsername", "getBizUsername", "", "friendFollowBizCount", "getFriendFollowBizCount", "()I", "", "isBizMode", "()Z", "getAnchorUsername", "isAnchorFollowed", "onCleared", "", "updateLookAheadBizModeInfo", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c<a>
{
  public static final a Ecf;
  public boolean Ecg;
  public int Ech;
  public String hUQ;
  public String mIK;
  
  static
  {
    AppMethodBeat.i(356697);
    Ecf = new a((byte)0);
    AppMethodBeat.o(356697);
  }
  
  public b(a parama)
  {
    super(parama);
    AppMethodBeat.i(356674);
    this.hUQ = "";
    this.mIK = "";
    AppMethodBeat.o(356674);
  }
  
  private final String eyh()
  {
    AppMethodBeat.i(356681);
    String str = ((e)business(e.class)).mIC;
    AppMethodBeat.o(356681);
    return str;
  }
  
  public final void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(356714);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject = paramString1;
        if (paramString1 == null) {
          localObject = "";
        }
        this.hUQ = ((String)localObject);
        if (paramBoolean) {
          this.Ecg = paramBoolean;
        }
      }
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label123;
      }
    }
    label123:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
        this.mIK = paramString1;
      }
      if (paramInt != 0) {
        this.Ech = paramInt;
      }
      AppMethodBeat.o(356714);
      return;
      i = 0;
      break;
    }
  }
  
  public final boolean esD()
  {
    AppMethodBeat.i(356706);
    Object localObject = u.DJC;
    if (u.bUx())
    {
      AppMethodBeat.o(356706);
      return true;
    }
    if (this.Ecg)
    {
      localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.hUQ);
      if (localObject == null)
      {
        AppMethodBeat.o(356706);
        return false;
      }
      if (d.rs(((az)localObject).field_type) == true)
      {
        AppMethodBeat.o(356706);
        return true;
      }
      AppMethodBeat.o(356706);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).Ss(eyh());
    AppMethodBeat.o(356706);
    return bool;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(356721);
    Log.i("BizModeSlice", "#onCleared");
    this.Ecg = false;
    this.hUQ = "";
    this.mIK = "";
    this.Ech = 0;
    AppMethodBeat.o(356721);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/BizModeSlice$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.b
 * JD-Core Version:    0.7.0.1
 */