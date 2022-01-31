package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.bo;

final class h$b
  extends a.b
{
  private h$b(h paramh)
  {
    super(paramh);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(61990);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969653, paramViewGroup, false);
    paramViewGroup = (h.a)this.mZe.mZd;
    paramViewGroup.gpM = ((TextView)paramContext.findViewById(2131821007));
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(61990);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(61991);
    paramContext = (h.a)parama;
    m.a(this.mZe.mZb, paramContext.gpM);
    AppMethodBeat.o(61991);
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    AppMethodBeat.i(61992);
    paramVarArgs = new Intent();
    paramVarArgs.putExtra("query_phrase_list", bo.P(this.mZe.mRX.mSy));
    paramVarArgs.putExtra("go_to_chatroom_direct", true);
    paramVarArgs.putExtra("scene_from", 3);
    d.f(paramContext, ".ui.transmit.MMCreateChatroomUI", paramVarArgs);
    AppMethodBeat.o(61992);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.h.b
 * JD-Core Version:    0.7.0.1
 */