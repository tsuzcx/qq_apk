package com.tencent.mm.am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.List;

public final class p
{
  private static List<String> lBr;
  private static int lBs;
  private static a lBt;
  
  static
  {
    AppMethodBeat.i(150317);
    lBr = null;
    lBs = 0;
    lBt = new a(new b());
    AppMethodBeat.o(150317);
  }
  
  public static void H(Runnable paramRunnable)
  {
    AppMethodBeat.i(150315);
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      AppMethodBeat.o(150315);
      return;
    }
    Object localObject = q.bhP();
    ArrayList localArrayList = new ArrayList();
    localObject = ((k)localObject).lvy.rawQuery("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(0));
    }
    ((Cursor)localObject).close();
    lBr = localArrayList;
    if (localArrayList.size() <= 0)
    {
      AppMethodBeat.o(150315);
      return;
    }
    lBt.lBu.lBv = paramRunnable;
    lBt.startTimer(10L);
    AppMethodBeat.o(150315);
  }
  
  public static void bhL()
  {
    AppMethodBeat.i(150316);
    lBs = 0;
    lBt.stopTimer();
    AppMethodBeat.o(150316);
  }
  
  static final class a
    extends MTimerHandler
  {
    final p.b lBu;
    
    public a(p.b paramb)
    {
      super(true);
      this.lBu = paramb;
    }
  }
  
  static final class b
    implements MTimerHandler.CallBack
  {
    Runnable lBv;
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(150314);
      int j = p.lBr.size();
      Log.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:".concat(String.valueOf(j)));
      if ((j <= 2000) || (p.lBs >= 300))
      {
        if (this.lBv != null) {
          this.lBv.run();
        }
        p.bhM();
        AppMethodBeat.o(150314);
        return false;
      }
      long l = com.tencent.mm.kernel.h.aHG().kcF.beginTransaction(Thread.currentThread().getId());
      int i = j - 1;
      while (i >= j - 30)
      {
        p.bhN();
        String str = (String)p.lBr.get(i);
        p.lBr.remove(i);
        q.bhz();
        f.P(str, false);
        q.bhz();
        f.P(str, true);
        q.bhP().TT(str);
        i -= 1;
      }
      com.tencent.mm.kernel.h.aHG().kcF.endTransaction(l);
      AppMethodBeat.o(150314);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.am.p
 * JD-Core Version:    0.7.0.1
 */