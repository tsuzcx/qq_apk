package com.tencent.mm.modelavatar;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.List;

public final class p
{
  private static List<String> otb;
  private static int otc;
  private static a otd;
  
  static
  {
    AppMethodBeat.i(150317);
    otb = null;
    otc = 0;
    otd = new a(new b());
    AppMethodBeat.o(150317);
  }
  
  public static void M(Runnable paramRunnable)
  {
    AppMethodBeat.i(150315);
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      AppMethodBeat.o(150315);
      return;
    }
    Object localObject = q.bFE();
    ArrayList localArrayList = new ArrayList();
    localObject = ((k)localObject).omV.rawQuery("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(0));
    }
    ((Cursor)localObject).close();
    otb = localArrayList;
    if (localArrayList.size() <= 0)
    {
      AppMethodBeat.o(150315);
      return;
    }
    otd.ote.otf = paramRunnable;
    otd.startTimer(10L);
    AppMethodBeat.o(150315);
  }
  
  public static void bFA()
  {
    AppMethodBeat.i(150316);
    otc = 0;
    otd.stopTimer();
    AppMethodBeat.o(150316);
  }
  
  static final class a
    extends MTimerHandler
  {
    final p.b ote;
    
    public a(p.b paramb)
    {
      super(true);
      this.ote = paramb;
    }
  }
  
  static final class b
    implements MTimerHandler.CallBack
  {
    Runnable otf;
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(150314);
      int j = p.otb.size();
      Log.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:".concat(String.valueOf(j)));
      if ((j <= 2000) || (p.otc >= 300))
      {
        if (this.otf != null) {
          this.otf.run();
        }
        p.bFB();
        AppMethodBeat.o(150314);
        return false;
      }
      long l = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
      int i = j - 1;
      while (i >= j - 30)
      {
        p.bFC();
        String str = (String)p.otb.get(i);
        p.otb.remove(i);
        q.bFp();
        AvatarStorage.T(str, false);
        q.bFp();
        AvatarStorage.T(str, true);
        q.bFE().LT(str);
        i -= 1;
      }
      com.tencent.mm.kernel.h.baE().mCN.endTransaction(l);
      AppMethodBeat.o(150314);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelavatar.p
 * JD-Core Version:    0.7.0.1
 */