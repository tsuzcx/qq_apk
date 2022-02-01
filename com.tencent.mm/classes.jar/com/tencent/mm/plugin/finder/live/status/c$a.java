package com.tencent.mm.plugin.finder.live.status;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.d.a.a.a.b;
import com.tencent.d.a.a.a.b.b.e;
import com.tencent.d.a.a.a.b.b.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.protocal.protobuf.fmo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/status/WinterOlympics2022LiveStatusService$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "doJumpSource", "", "context", "Landroid/content/Context;", "extParams", "Landroid/os/Bundle;", "isHasCustomPullDown", "onAttach", "", "textStatusID", "", "", "onDetach", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
  extends k
{
  private List<? extends TextStatusJumpInfo> DHi;
  
  c$a(String paramString)
  {
    super(paramString);
  }
  
  public final boolean etQ()
  {
    return false;
  }
  
  public final boolean g(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(351530);
    Object localObject1 = this.DHi;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (TextStatusJumpInfo)((Iterator)localObject1).next();
        if (s.p(((TextStatusJumpInfo)localObject2).jumpType, "13"))
        {
          localObject1 = Base64.decode(((TextStatusJumpInfo)localObject2).keyBusiBuf, 0);
          Object localObject3 = new fmo();
          ((fmo)localObject3).parseFrom((byte[])localObject1);
          brs localbrs;
          if (paramContext != null)
          {
            localObject1 = (b)h.az(b.class);
            localObject2 = ((fmo)localObject3).username;
            localbrs = new brs();
            localbrs.ZVq = ((fmo)localObject3).abMR;
            localbrs.ZVp = "";
            localbrs.ZVs = ((fmo)localObject3).abMS;
            localbrs.ZVr = ((fmo)localObject3).abMP;
            localObject3 = ah.aiuX;
            localObject3 = new dwa();
            b.e.a locala = b.e.ahon;
            ((dwa)localObject3).abbK = b.e.a.jVZ();
            if (paramBundle == null) {
              break label219;
            }
          }
          label219:
          for (paramBundle = paramBundle.getString("userName", "");; paramBundle = "")
          {
            ((dwa)localObject3).hLv = paramBundle;
            paramBundle = ah.aiuX;
            ((b)localObject1).gotoLive(paramContext, (String)localObject2, localbrs, (dwa)localObject3);
            AppMethodBeat.o(351530);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(351530);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void y(String paramString, List<TextStatusJumpInfo> paramList)
  {
    this.DHi = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.status.c.a
 * JD-Core Version:    0.7.0.1
 */