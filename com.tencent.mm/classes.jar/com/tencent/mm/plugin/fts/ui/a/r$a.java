package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d.a.a;

public final class r$a
  extends b.b
{
  public r$a(r paramr)
  {
    super(paramr);
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    AppMethodBeat.i(62035);
    paramVarArgs = (r)paramVarArgs;
    a(this.mZQ.mRX.mSw, paramVarArgs.hrL);
    d.f(paramContext, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true));
    AppMethodBeat.o(62035);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.r.a
 * JD-Core Version:    0.7.0.1
 */