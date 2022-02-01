package com.tencent.mm.aj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class o
{
  private static List<String> iLk;
  private static int iLl;
  private static a iLm;
  
  static
  {
    AppMethodBeat.i(150317);
    iLk = null;
    iLl = 0;
    iLm = new a(new b());
    AppMethodBeat.o(150317);
  }
  
  public static void H(Runnable paramRunnable)
  {
    AppMethodBeat.i(150315);
    if (!g.aAf().azp())
    {
      AppMethodBeat.o(150315);
      return;
    }
    Object localObject = p.aYB();
    ArrayList localArrayList = new ArrayList();
    localObject = ((j)localObject).iFy.rawQuery("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(0));
    }
    ((Cursor)localObject).close();
    iLk = localArrayList;
    if (localArrayList.size() <= 0)
    {
      AppMethodBeat.o(150315);
      return;
    }
    iLm.iLn.iLo = paramRunnable;
    iLm.startTimer(10L);
    AppMethodBeat.o(150315);
  }
  
  public static void aYx()
  {
    AppMethodBeat.i(150316);
    iLl = 0;
    iLm.stopTimer();
    AppMethodBeat.o(150316);
  }
  
  static final class a
    extends MTimerHandler
  {
    final o.b iLn;
    
    public a(o.b paramb)
    {
      super(true);
      this.iLn = paramb;
    }
  }
  
  static final class b
    implements MTimerHandler.CallBack
  {
    Runnable iLo;
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(150314);
      int j = o.iLk.size();
      Log.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:".concat(String.valueOf(j)));
      if ((j <= 2000) || (o.iLl >= 300))
      {
        if (this.iLo != null) {
          this.iLo.run();
        }
        o.aYy();
        AppMethodBeat.o(150314);
        return false;
      }
      long l = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
      int i = j - 1;
      while (i >= j - 30)
      {
        o.aYz();
        String str = (String)o.iLk.get(i);
        o.iLk.remove(i);
        p.aYn();
        e.N(str, false);
        p.aYn();
        e.N(str, true);
        p.aYB().My(str);
        i -= 1;
      }
      g.aAh().hqK.endTransaction(l);
      AppMethodBeat.o(150314);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.o
 * JD-Core Version:    0.7.0.1
 */