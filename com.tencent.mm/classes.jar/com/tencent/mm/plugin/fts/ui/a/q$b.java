package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.m;

public final class q$b
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public q$b(q paramq)
  {
    super(paramq);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(62029);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969650, paramViewGroup, false);
    paramViewGroup = (q.a)this.mZO.mZN;
    paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131821210));
    paramViewGroup.gpL = ((TextView)paramContext.findViewById(2131821212));
    paramViewGroup.gpM = ((TextView)paramContext.findViewById(2131821007));
    paramViewGroup.hrR = paramContext.findViewById(2131821148);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(62029);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(62030);
    parama = (q.a)parama;
    parama1 = (q)parama1;
    m.p(parama.hrR, this.mZO.mTH);
    if ((parama1.username != null) && (parama1.username.length() > 0))
    {
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.egq, parama1.username);
      if (!t.nK(parama1.username)) {
        break label137;
      }
      m.a(((b)com.tencent.mm.kernel.g.E(b.class)).a(paramContext, parama1.jVn), parama.gpL);
    }
    for (;;)
    {
      parama.gpL.setMaxWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 200));
      m.a(parama1.jVo, parama.gpM);
      AppMethodBeat.o(62030);
      return;
      parama.egq.setImageResource(2130838493);
      break;
      label137:
      m.a(parama1.jVn, parama.gpL);
    }
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(62031);
    paramVarArgs = (q)paramVarArgs;
    a(this.mZO.mRX.mSw, paramVarArgs.hrL);
    Intent localIntent = new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true);
    if (t.nK(paramVarArgs.username))
    {
      v localv = new v();
      localv.fq(paramVarArgs.username);
      localv.cTE = 3L;
      localv.ake();
    }
    d.f(paramContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(62031);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.q.b
 * JD-Core Version:    0.7.0.1
 */