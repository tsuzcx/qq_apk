package com.tencent.mm.plugin.game.ui.message;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class GameMsgCenterUI$a
  extends i
{
  private List<GameMsgCenterUI.GameMsgCenterFragment> xYk;
  
  public GameMsgCenterUI$a(g paramg)
  {
    super(paramg);
    AppMethodBeat.i(183874);
    this.xYk = new ArrayList();
    AppMethodBeat.o(183874);
  }
  
  public final void a(GameMsgCenterUI.GameMsgCenterFragment paramGameMsgCenterFragment)
  {
    AppMethodBeat.i(183875);
    this.xYk.add(paramGameMsgCenterFragment);
    AppMethodBeat.o(183875);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(183877);
    int i = this.xYk.size();
    AppMethodBeat.o(183877);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(183876);
    Object localObject = this.xYk;
    localObject = (Fragment)((List)localObject).get(paramInt % ((List)localObject).size());
    AppMethodBeat.o(183876);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.a
 * JD-Core Version:    0.7.0.1
 */