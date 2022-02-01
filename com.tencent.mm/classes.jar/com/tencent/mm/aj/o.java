package com.tencent.mm.aj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class o
{
  private static List<String> huT;
  private static int huU;
  private static a huV;
  
  static
  {
    AppMethodBeat.i(150317);
    huT = null;
    huU = 0;
    huV = new a(new b());
    AppMethodBeat.o(150317);
  }
  
  public static void G(Runnable paramRunnable)
  {
    AppMethodBeat.i(150315);
    if (!g.agP().afY())
    {
      AppMethodBeat.o(150315);
      return;
    }
    Object localObject = p.aBw();
    ArrayList localArrayList = new ArrayList();
    localObject = ((j)localObject).hpA.a("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(0));
    }
    ((Cursor)localObject).close();
    huT = localArrayList;
    if (localArrayList.size() <= 0)
    {
      AppMethodBeat.o(150315);
      return;
    }
    huV.huW.huX = paramRunnable;
    huV.au(10L, 10L);
    AppMethodBeat.o(150315);
  }
  
  public static void aBs()
  {
    AppMethodBeat.i(150316);
    huU = 0;
    huV.stopTimer();
    AppMethodBeat.o(150316);
  }
  
  static final class a
    extends au
  {
    final o.b huW;
    
    public a(o.b paramb)
    {
      super(true);
      this.huW = paramb;
    }
  }
  
  static final class b
    implements au.a
  {
    Runnable huX;
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(150314);
      int j = o.huT.size();
      ac.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:".concat(String.valueOf(j)));
      if ((j <= 2000) || (o.huU >= 300))
      {
        if (this.huX != null) {
          this.huX.run();
        }
        o.aBt();
        AppMethodBeat.o(150314);
        return false;
      }
      long l = g.agR().ghG.vE(Thread.currentThread().getId());
      int i = j - 1;
      while (i >= j - 30)
      {
        o.aBu();
        String str = (String)o.huT.get(i);
        o.huT.remove(i);
        p.aBh();
        e.L(str, false);
        p.aBh();
        e.L(str, true);
        p.aBw().Al(str);
        i -= 1;
      }
      g.agR().ghG.qL(l);
      AppMethodBeat.o(150314);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.o
 * JD-Core Version:    0.7.0.1
 */