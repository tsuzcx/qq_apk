package com.tencent.mm.plugin.expt.c;

import android.util.Pair;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/biz/ChatListMonitor;", "", "()V", "CLASS_HEADER", "", "INTERFACE_NAME", "METHOD_DESC", "METHOD_NAME", "mChatListListener", "com/tencent/mm/plugin/expt/biz/ChatListMonitor$mChatListListener$1", "Lcom/tencent/mm/plugin/expt/biz/ChatListMonitor$mChatListListener$1;", "mChatMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "monitor", "", "plugin-expt_release"})
public final class a
{
  private static final HashMap<String, Map<String, List<Pair<String, String>>>> wcL;
  private static final a wcM;
  public static final a wcN;
  
  static
  {
    AppMethodBeat.i(251333);
    wcN = new a();
    wcL = new HashMap();
    wcM = new a();
    AppMethodBeat.o(251333);
  }
  
  public static void Xr()
  {
    AppMethodBeat.i(251330);
    List localList = (List)new ArrayList();
    localList.add(new Pair("onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("android/view/View$OnTouchListener", localList);
    ((Map)wcL).put("com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", localHashMap);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.e((Map)wcL, (d)wcM);
    AppMethodBeat.o(251330);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/biz/ChatListMonitor$mChatListListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class a
    implements d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(253687);
      if (paramString1 != null)
      {
        if (!n.M(paramString1, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", false))
        {
          AppMethodBeat.o(253687);
          return;
        }
        if ((p.h(paramString2, "onTouch")) && (p.h(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z")) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2) && ((paramArrayOfObject[1] instanceof MotionEvent)))
        {
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type android.view.MotionEvent");
            AppMethodBeat.o(253687);
            throw paramString1;
          }
          if ((((MotionEvent)paramString1).getAction() & 0xFF) == 0)
          {
            com.tencent.mm.plugin.expt.hellhound.a.ni(false);
            com.tencent.mm.plugin.expt.hellhound.a.aww("temp_6");
          }
        }
      }
      AppMethodBeat.o(253687);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.a
 * JD-Core Version:    0.7.0.1
 */