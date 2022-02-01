package com.tencent.mm.plugin.game.chatroom.h;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.TplBlock;
import com.tencent.mm.plugin.game.chatroom.b.b;
import com.tencent.mm.plugin.game.chatroom.b.c;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.plugin.game.chatroom.view.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/chatroom/piece/TplMsgParser;", "", "()V", "userNameList", "", "", "parseTplMsg", "", "context", "Landroid/content/Context;", "tplBlockList", "", "Lcom/tencent/mm/plugin/game/autogen/chatroom/TplBlock;", "clickDisable", "", "callBack", "Lcom/tencent/mm/plugin/game/chatroom/piece/TplCallBack;", "game-chatroom_release"})
public final class j
{
  private final List<String> CvF;
  
  public j()
  {
    AppMethodBeat.i(210762);
    this.CvF = ((List)new ArrayList());
    AppMethodBeat.o(210762);
  }
  
  public final void a(final Context paramContext, List<? extends TplBlock> paramList, boolean paramBoolean, final i parami)
  {
    AppMethodBeat.i(210761);
    p.k(paramContext, "context");
    p.k(paramList, "tplBlockList");
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(210761);
      return;
    }
    Object localObject1 = (List)new LinkedList();
    Object localObject2 = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject3 = (TplBlock)paramList.next();
      Object localObject4;
      switch (((TplBlock)localObject3).type)
      {
      default: 
        break;
      case 0: 
        localObject3 = ((TplBlock)localObject3).content;
        if (localObject3 != null) {
          ((StringBuffer)localObject2).append((String)localObject3);
        }
        break;
      case 1: 
        if (((TplBlock)localObject3).content != null)
        {
          localObject4 = new h((byte)0);
          ((h)localObject4).start = ((StringBuffer)localObject2).length();
          ((h)localObject4).end = (((StringBuffer)localObject2).length() + ((TplBlock)localObject3).content.length());
          ((h)localObject4).CvE = ((TplBlock)localObject3).jump_info;
          ((List)localObject1).add(localObject4);
          ((StringBuffer)localObject2).append(((TplBlock)localObject3).content);
        }
        break;
      case 2: 
        localObject4 = ((TplBlock)localObject3).username;
        if (localObject4 != null)
        {
          c localc = ((b)com.tencent.mm.kernel.h.ae(b.class)).aIN((String)localObject4);
          if ((localc == null) || (((StringBuffer)localObject2).append(localc.getNickName()) == null)) {
            ((StringBuffer)localObject2).append(((TplBlock)localObject3).content);
          }
          if (localObject4 != null) {}
        }
        else
        {
          ((StringBuffer)localObject2).append(((TplBlock)localObject3).content);
        }
        break;
      }
    }
    if (((CharSequence)localObject2).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(210761);
      return;
    }
    paramList = new SpannableStringBuilder((CharSequence)localObject2);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (h)((Iterator)localObject1).next();
      paramList.setSpan(new a(paramBoolean, paramContext, (h)localObject2, parami), ((h)localObject2).start, ((h)localObject2).end, 33);
    }
    parami.b(paramList);
    ((b)com.tencent.mm.kernel.h.ae(b.class)).a(this.CvF, null);
    AppMethodBeat.o(210761);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/game/chatroom/piece/TplMsgParser$parseTplMsg$4", "Lcom/tencent/mm/plugin/game/chatroom/view/DarkPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "game-chatroom_release"})
  public static final class a
    extends d
  {
    a(boolean paramBoolean, Context paramContext, h paramh, i parami) {}
    
    public final void onClickImp(View paramView)
    {
      AppMethodBeat.i(212102);
      p.k(paramView, "widget");
      if (!this.CvG)
      {
        long l;
        switch (e.a(paramContext, this.CvH.CvE))
        {
        default: 
          AppMethodBeat.o(212102);
          return;
        case 1: 
          l = 6L;
        }
        for (;;)
        {
          paramView = parami;
          if (paramView == null) {
            break;
          }
          paramView.NM(l);
          AppMethodBeat.o(212102);
          return;
          l = 7L;
          continue;
          l = 28L;
        }
      }
      AppMethodBeat.o(212102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.j
 * JD-Core Version:    0.7.0.1
 */