package com.tencent.mm.plugin.game.chatroom.i;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
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
import java.util.List<+Lcom.tencent.mm.plugin.game.autogen.chatroom.TplBlock;>;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/piece/TplMsgParser;", "", "()V", "userNameList", "", "", "parseTplMsg", "", "context", "Landroid/content/Context;", "tplBlockList", "", "Lcom/tencent/mm/plugin/game/autogen/chatroom/TplBlock;", "clickDisable", "", "callBack", "Lcom/tencent/mm/plugin/game/chatroom/piece/TplCallBack;", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  private final List<String> Imq;
  
  public n()
  {
    AppMethodBeat.i(275920);
    this.Imq = ((List)new ArrayList());
    AppMethodBeat.o(275920);
  }
  
  public final void a(final Context paramContext, List<? extends TplBlock> paramList, boolean paramBoolean, final m paramm)
  {
    AppMethodBeat.i(275934);
    s.u(paramContext, "context");
    s.u(paramList, "tplBlockList");
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(275934);
      return;
    }
    Object localObject2 = new LinkedList();
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      TplBlock localTplBlock = (TplBlock)localIterator.next();
      paramList = localTplBlock.username;
      if (paramList != null) {
        this.Imq.add(paramList);
      }
      switch (localTplBlock.type)
      {
      default: 
        break;
      case 0: 
        paramList = localTplBlock.content;
        if (paramList != null) {
          localStringBuffer.append(paramList);
        }
        break;
      case 1: 
        if (localTplBlock.content != null)
        {
          paramList = new l((byte)0);
          paramList.start = localStringBuffer.length();
          paramList.end = (localStringBuffer.length() + localTplBlock.content.length());
          paramList.Imo = localTplBlock.jump_info;
          paramList.userName = localTplBlock.username;
          paramList.Imp = localTplBlock.can_be_at;
          ((List)localObject2).add(paramList);
          localStringBuffer.append(localTplBlock.content);
        }
        break;
      case 2: 
        localObject1 = localTplBlock.username;
        if (localObject1 == null)
        {
          paramList = null;
          label266:
          if (paramList == null) {
            localStringBuffer.append(localTplBlock.content);
          }
        }
        else
        {
          paramList = ((b)h.ax(b.class)).aFo((String)localObject1);
          if (paramList != null) {
            break label327;
          }
        }
        label327:
        for (paramList = null;; paramList = localStringBuffer.append(paramList.getNickName()))
        {
          if (paramList == null) {
            localStringBuffer.append(localTplBlock.content);
          }
          paramList = (List<? extends TplBlock>)localObject1;
          break label266;
          break;
        }
      }
    }
    if (((CharSequence)localStringBuffer).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(275934);
      return;
    }
    paramList = new SpannableStringBuilder((CharSequence)localStringBuffer);
    Object localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (l)((Iterator)localObject1).next();
      paramList.setSpan(new a(paramBoolean, paramContext, (l)localObject2, paramm), ((l)localObject2).start, ((l)localObject2).end, 33);
    }
    paramm.b(paramList);
    ((b)h.ax(b.class)).a(this.Imq, null);
    AppMethodBeat.o(275934);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/game/chatroom/piece/TplMsgParser$parseTplMsg$5", "Lcom/tencent/mm/plugin/game/chatroom/view/DarkPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends d
  {
    a(boolean paramBoolean, Context paramContext, l paraml, m paramm)
    {
      super();
    }
    
    public final void onClickImp(View paramView)
    {
      AppMethodBeat.i(275923);
      s.u(paramView, "widget");
      long l;
      if (!this.Imr) {
        switch (e.a(paramContext, this.Ims.Imo, 0, null))
        {
        default: 
          AppMethodBeat.o(275923);
          return;
        case 1: 
          l = 6L;
        }
      }
      for (;;)
      {
        paramView = paramm;
        if (paramView != null) {
          paramView.rB(l);
        }
        AppMethodBeat.o(275923);
        return;
        l = 7L;
        continue;
        l = 28L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.n
 * JD-Core Version:    0.7.0.1
 */