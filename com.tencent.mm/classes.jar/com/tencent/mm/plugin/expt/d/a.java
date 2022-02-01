package com.tencent.mm.plugin.expt.d;

import android.util.Pair;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/biz/ChatListMonitor;", "", "()V", "CLASS_HEADER", "", "INTERFACE_NAME", "METHOD_DESC", "METHOD_NAME", "mChatListListener", "com/tencent/mm/plugin/expt/biz/ChatListMonitor$mChatListListener$1", "Lcom/tencent/mm/plugin/expt/biz/ChatListMonitor$mChatListListener$1;", "mChatMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "monitor", "", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a zxG;
  private static final HashMap<String, Map<String, List<Pair<String, String>>>> zxH;
  private static final a zxI;
  
  static
  {
    AppMethodBeat.i(299562);
    zxG = new a();
    zxH = new HashMap();
    zxI = new a();
    AppMethodBeat.o(299562);
  }
  
  public static void ayW()
  {
    AppMethodBeat.i(299559);
    List localList = (List)new ArrayList();
    localList.add(new Pair("onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("android/view/View$OnTouchListener", localList);
    ((Map)zxH).put("com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", localHashMap);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.e((Map)zxH, (d)zxI);
    AppMethodBeat.o(299559);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/biz/ChatListMonitor$mChatListListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(299551);
      if (paramString1 != null)
      {
        if (!n.U(paramString1, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", false))
        {
          AppMethodBeat.o(299551);
          return;
        }
        if ((s.p(paramString2, "onTouch")) && (s.p(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z")) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2) && ((paramArrayOfObject[1] instanceof MotionEvent)) && ((((MotionEvent)paramArrayOfObject[1]).getAction() & 0xFF) == 0))
        {
          com.tencent.mm.plugin.expt.hellhound.a.oI(false);
          com.tencent.mm.plugin.expt.hellhound.a.aqz("temp_6");
        }
      }
      AppMethodBeat.o(299551);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.a
 * JD-Core Version:    0.7.0.1
 */