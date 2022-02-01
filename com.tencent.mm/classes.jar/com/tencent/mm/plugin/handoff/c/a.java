package com.tencent.mm.plugin.handoff.c;

import android.os.Build.VERSION;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.handoff.model.HandOffFile.a;
import com.tencent.mm.plugin.handoff.model.HandOffMG;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.fky;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/BallHelper;", "", "()V", "TAG", "", "canDrawOverlays", "", "getAvailableActiveBallCount", "", "safeString", "toHandOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "plugin-handoff_release"})
public final class a
{
  public static final a DrR;
  
  static
  {
    AppMethodBeat.i(248545);
    DrR = new a();
    AppMethodBeat.o(248545);
  }
  
  private static String aLp(String paramString)
  {
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  public static final int eBN()
  {
    AppMethodBeat.i(248542);
    if (ar.isMultiTaskMode())
    {
      AppMethodBeat.o(248542);
      return 1000;
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = Settings.canDrawOverlays(MMApplicationContext.getContext()); bool; bool = true)
    {
      com.tencent.mm.kernel.c.a locala = h.ae(b.class);
      p.j(locala, "MMKernel.service(IFloatBallService::class.java)");
      int i = d.cc(((b)locala).cvc()).size();
      AppMethodBeat.o(248542);
      return 5 - i;
    }
    AppMethodBeat.o(248542);
    return -1;
  }
  
  public static HandOff f(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(248544);
    p.k(paramMultiTaskInfo, "$this$toHandOff");
    for (;;)
    {
      try
      {
        Object localObject1 = paramMultiTaskInfo.field_showData;
        if (localObject1 == null) {
          break label546;
        }
        localObject1 = ((dar)localObject1).TIg;
        String str1 = aLp((String)localObject1);
        localObject1 = paramMultiTaskInfo.field_showData;
        if (localObject1 == null) {
          break label552;
        }
        localObject1 = ((dar)localObject1).title;
        Object localObject3 = aLp((String)localObject1);
        localObject1 = paramMultiTaskInfo.field_showData;
        if (localObject1 == null) {
          break label558;
        }
        localObject1 = ((dar)localObject1).nickname;
        String str2 = aLp((String)localObject1);
        long l = paramMultiTaskInfo.field_createTime;
        Object localObject4;
        switch (paramMultiTaskInfo.field_type)
        {
        case 2: 
          if (localObject1 != null)
          {
            str1 = paramMultiTaskInfo.field_id;
            p.j(str1, "field_id");
            ((HandOff)localObject1).setKey(str1);
            ((HandOff)localObject1).setCreateTime(l);
            AppMethodBeat.o(248544);
            return localObject1;
            localObject1 = new fky();
            ((fky)localObject1).parseFrom(paramMultiTaskInfo.field_data);
            localObject4 = (CharSequence)((fky)localObject1).UJs;
            if (localObject4 == null) {
              break label564;
            }
            if (!n.ba((CharSequence)localObject4)) {
              break label569;
            }
            break label564;
            if (i == 0)
            {
              localObject1 = ((fky)localObject1).UJs;
              p.j(localObject1, "showUrl");
              localObject4 = paramMultiTaskInfo.field_id;
              p.j(localObject4, "field_id");
              localObject1 = new HandOffURL((String)localObject3, (String)localObject1, str1, 2, null, null, (String)localObject4, 48, null);
              ((HandOffURL)localObject1).setNickname(str2);
              localObject1 = (HandOff)localObject1;
              continue;
            }
            localObject1 = aLp(((fky)localObject1).fXu);
          }
          break;
        case 1: 
          localObject3 = new eo();
          ((eo)localObject3).parseFrom(paramMultiTaskInfo.field_data);
          if (((eo)localObject3).cwR == 4)
          {
            localObject1 = aLp(((eo)localObject3).appId);
            localObject3 = aLp(((eo)localObject3).username);
            localObject4 = paramMultiTaskInfo.field_id;
            p.j(localObject4, "field_id");
            localObject1 = (HandOffMP)new HandOffMG(str1, str2, (String)localObject1, "", (String)localObject3, 2, null, null, (String)localObject4, 192, null);
            localObject1 = (HandOff)localObject1;
            continue;
          }
          localObject1 = aLp(((eo)localObject3).appId);
          localObject3 = aLp(((eo)localObject3).username);
          localObject4 = paramMultiTaskInfo.field_id;
          p.j(localObject4, "field_id");
          localObject1 = new HandOffMP(str1, str2, (String)localObject1, "", (String)localObject3, 2, null, null, (String)localObject4, 192, null);
          break;
        case 4: 
          localObject1 = HandOffFile.Companion;
          localObject1 = (HandOff)HandOffFile.a.fromMultiTask(paramMultiTaskInfo);
          continue;
          AppMethodBeat.o(248544);
          return null;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.BallHelper", "parse multiTaskInfo[id:" + paramMultiTaskInfo.field_id + ", type:" + paramMultiTaskInfo.field_type + "] fail:" + localException.getLocalizedMessage());
        AppMethodBeat.o(248544);
        return null;
      }
      Object localObject2 = null;
      continue;
      label546:
      localObject2 = null;
      continue;
      label552:
      localObject2 = null;
      continue;
      label558:
      localObject2 = null;
      continue;
      label564:
      int i = 1;
      continue;
      label569:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.a
 * JD-Core Version:    0.7.0.1
 */