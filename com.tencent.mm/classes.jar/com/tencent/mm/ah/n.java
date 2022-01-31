package com.tencent.mm.ah;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.List;

public final class n
{
  private static int fsA;
  private static n.a fsB;
  private static List<String> fsz;
  
  static
  {
    AppMethodBeat.i(77953);
    fsz = null;
    fsA = 0;
    fsB = new n.a(new n.b());
    AppMethodBeat.o(77953);
  }
  
  public static void adb()
  {
    AppMethodBeat.i(77952);
    fsA = 0;
    fsB.stopTimer();
    AppMethodBeat.o(77952);
  }
  
  public static void w(Runnable paramRunnable)
  {
    AppMethodBeat.i(77951);
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(77951);
      return;
    }
    Object localObject = o.adg();
    ArrayList localArrayList = new ArrayList();
    localObject = ((i)localObject).fnw.a("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(0));
    }
    ((Cursor)localObject).close();
    fsz = localArrayList;
    if (localArrayList.size() <= 0)
    {
      AppMethodBeat.o(77951);
      return;
    }
    fsB.fsC.fsD = paramRunnable;
    fsB.ag(10L, 10L);
    AppMethodBeat.o(77951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ah.n
 * JD-Core Version:    0.7.0.1
 */