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
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.protocal.protobuf.ghm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/BallHelper;", "", "()V", "TAG", "", "canDrawOverlays", "", "getAvailableActiveBallCount", "", "safeString", "toHandOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Jlx;
  
  static
  {
    AppMethodBeat.i(266245);
    Jlx = new a();
    AppMethodBeat.o(266245);
  }
  
  private static String aIg(String paramString)
  {
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  public static HandOff f(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(266238);
    s.u(paramMultiTaskInfo, "<this>");
    for (;;)
    {
      try
      {
        Object localObject1 = paramMultiTaskInfo.field_showData;
        String str1;
        Object localObject3;
        String str2;
        long l;
        if (localObject1 == null)
        {
          localObject1 = null;
          str1 = aIg((String)localObject1);
          localObject1 = paramMultiTaskInfo.field_showData;
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          localObject3 = aIg((String)localObject1);
          localObject1 = paramMultiTaskInfo.field_showData;
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          str2 = aIg((String)localObject1);
          l = paramMultiTaskInfo.field_createTime;
        }
        Object localObject4;
        switch (paramMultiTaskInfo.field_type)
        {
        case 2: 
          if (localObject1 == null)
          {
            AppMethodBeat.o(266238);
            return null;
            localObject1 = ((drz)localObject1).aaXP;
            continue;
            localObject1 = ((drz)localObject1).title;
            continue;
            localObject1 = ((drz)localObject1).nickname;
            continue;
            localObject1 = new ghm();
            ((ghm)localObject1).parseFrom(paramMultiTaskInfo.field_data);
            localObject4 = (CharSequence)((ghm)localObject1).acdA;
            if (localObject4 == null) {
              break label564;
            }
            if (!n.bp((CharSequence)localObject4)) {
              break label569;
            }
            break label564;
            if (i == 0)
            {
              localObject1 = ((ghm)localObject1).acdA;
              s.s(localObject1, "showUrl");
              localObject4 = paramMultiTaskInfo.field_id;
              s.s(localObject4, "field_id");
              localObject1 = new HandOffURL((String)localObject3, (String)localObject1, str1, 2, null, null, (String)localObject4, 48, null);
              ((HandOffURL)localObject1).setNickname(str2);
              localObject1 = (HandOff)localObject1;
              continue;
            }
            localObject1 = aIg(((ghm)localObject1).idu);
          }
          break;
        case 1: 
          localObject3 = new fi();
          ((fi)localObject3).parseFrom(paramMultiTaskInfo.field_data);
          if (((fi)localObject3).appServiceType == 4)
          {
            localObject1 = aIg(((fi)localObject3).appId);
            localObject3 = aIg(((fi)localObject3).username);
            localObject4 = paramMultiTaskInfo.field_id;
            s.s(localObject4, "field_id");
            localObject1 = (HandOffMP)new HandOffMG(str1, str2, (String)localObject1, "", (String)localObject3, 2, null, null, (String)localObject4, 192, null);
            localObject1 = (HandOff)localObject1;
            continue;
          }
          localObject1 = aIg(((fi)localObject3).appId);
          localObject3 = aIg(((fi)localObject3).username);
          localObject4 = paramMultiTaskInfo.field_id;
          s.s(localObject4, "field_id");
          localObject1 = new HandOffMP(str1, str2, (String)localObject1, "", (String)localObject3, 2, null, null, (String)localObject4, 192, null);
          break;
        case 4: 
          localObject1 = HandOffFile.Companion;
          localObject1 = (HandOff)HandOffFile.a.fromMultiTask(paramMultiTaskInfo);
          continue;
          str1 = paramMultiTaskInfo.field_id;
          s.s(str1, "field_id");
          ((HandOff)localObject1).setKey(str1);
          ((HandOff)localObject1).setCreateTime(l);
          AppMethodBeat.o(266238);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.BallHelper", "parse multiTaskInfo[id:" + paramMultiTaskInfo.field_id + ", type:" + paramMultiTaskInfo.field_type + "] fail:" + localException.getLocalizedMessage());
        AppMethodBeat.o(266238);
        return null;
      }
      Object localObject2 = null;
      continue;
      label564:
      int i = 1;
      continue;
      label569:
      i = 0;
    }
  }
  
  public static final int fJP()
  {
    AppMethodBeat.i(266221);
    if (aw.isMultiTaskMode())
    {
      AppMethodBeat.o(266221);
      return 1000;
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = Settings.canDrawOverlays(MMApplicationContext.getContext()); bool; bool = true)
    {
      int i = d.dU(((b)h.ax(b.class)).cXM()).size();
      AppMethodBeat.o(266221);
      return 5 - i;
    }
    AppMethodBeat.o(266221);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.a
 * JD-Core Version:    0.7.0.1
 */