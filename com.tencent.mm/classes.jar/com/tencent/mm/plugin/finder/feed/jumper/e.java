package com.tencent.mm.plugin.finder.feed.jumper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/CommonJumperReporter;", "", "()V", "EID_HALF_SCREEN_LEAVE", "", "EID_HALF_SCREEN_SLIDE_UP", "EID_JUMP_ICON", "LEAVE_TYPE_BACK_FEED", "", "LEAVE_TYPE_JUMP_NEXT", "TYPE_COMM", "TYPE_HOT", "getScene", "source", "onClick", "", "context", "Landroid/content/Context;", "infoEx", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "type", "onExposed", "onLeave", "leaveType", "onSlideUp", "report", "eid", "eventCode", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e BdD;
  
  static
  {
    AppMethodBeat.i(364209);
    BdD = new e();
    AppMethodBeat.o(364209);
  }
  
  public static int avS(String paramString)
  {
    AppMethodBeat.i(364202);
    if (s.p("comment", paramString))
    {
      AppMethodBeat.o(364202);
      return 2;
    }
    AppMethodBeat.o(364202);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.e
 * JD-Core Version:    0.7.0.1
 */