package com.tencent.mm.plugin.finder.debugconfig;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.plugin.finder.view.sidebar.DraggableConstraintLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/debugconfig/FinderDebugCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static final a ANf;
  
  static
  {
    AppMethodBeat.i(329797);
    ANf = new a();
    AppMethodBeat.o(329797);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(329804);
    if (Log.getLogLevel() > 1)
    {
      AppMethodBeat.o(329804);
      return false;
    }
    if (paramArrayOfString == null)
    {
      paramString = null;
      if (paramString != null) {
        switch (paramString.hashCode())
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(329804);
      return true;
      paramString = paramArrayOfString[1];
      break;
      if (paramString.equals("sba"))
      {
        int i = Integer.parseInt(paramArrayOfString[2]);
        paramContext = DraggableConstraintLayout.GIg;
        DraggableConstraintLayout.UO(i);
        continue;
        if (paramString.equals("pms"))
        {
          if (Integer.parseInt(paramArrayOfString[2]) != 1) {}
          for (boolean bool = true;; bool = false)
          {
            paramArrayOfString = com.tencent.mm.sensitive.ui.a.acvO;
            paramArrayOfString = MultiProcessMMKV.getMMKV(com.tencent.mm.sensitive.ui.a.iUt());
            paramString = com.tencent.mm.sensitive.ui.a.acvO;
            paramArrayOfString.putBoolean(com.tencent.mm.sensitive.ui.a.iUu(), bool);
            if (!bool) {
              break label264;
            }
            aa.makeText(paramContext, (CharSequence)"使用旧版权限弹窗", 0).show();
            break;
            if (!paramString.equals("pmsc")) {
              break;
            }
            paramArrayOfString = com.tencent.mm.sensitive.ui.a.acvO;
            paramArrayOfString = MultiProcessMMKV.getMMKV(com.tencent.mm.sensitive.ui.a.iUt());
            paramString = com.tencent.mm.sensitive.ui.a.acvO;
            if (!paramArrayOfString.getBoolean(com.tencent.mm.sensitive.ui.a.iUu(), true)) {
              break label280;
            }
            aa.makeText(paramContext, (CharSequence)"正在使用旧版权限弹窗", 0).show();
            break;
            if (!paramString.equals("olymock")) {
              break;
            }
            paramContext = bj.GlQ;
            bj.qR(0L);
            break;
          }
          label264:
          aa.makeText(paramContext, (CharSequence)"使用新版权限弹窗", 0).show();
          continue;
          label280:
          aa.makeText(paramContext, (CharSequence)"正在使用新版权限弹窗", 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.debugconfig.a
 * JD-Core Version:    0.7.0.1
 */