package com.tencent.mm.aj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class o
{
  private static List<String> hQe;
  private static int hQf;
  private static a hQg;
  
  static
  {
    AppMethodBeat.i(150317);
    hQe = null;
    hQf = 0;
    hQg = new a(new b());
    AppMethodBeat.o(150317);
  }
  
  public static void D(Runnable paramRunnable)
  {
    AppMethodBeat.i(150315);
    if (!g.ajP().aiZ())
    {
      AppMethodBeat.o(150315);
      return;
    }
    Object localObject = p.aEN();
    ArrayList localArrayList = new ArrayList();
    localObject = ((j)localObject).hKK.a("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(0));
    }
    ((Cursor)localObject).close();
    hQe = localArrayList;
    if (localArrayList.size() <= 0)
    {
      AppMethodBeat.o(150315);
      return;
    }
    hQg.hQh.hQi = paramRunnable;
    hQg.ay(10L, 10L);
    AppMethodBeat.o(150315);
  }
  
  public static void aEK()
  {
    AppMethodBeat.i(150316);
    hQf = 0;
    hQg.stopTimer();
    AppMethodBeat.o(150316);
  }
  
  static final class a
    extends aw
  {
    final o.b hQh;
    
    public a(o.b paramb)
    {
      super(true);
      this.hQh = paramb;
    }
  }
  
  static final class b
    implements aw.a
  {
    Runnable hQi;
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(150314);
      int j = o.hQe.size();
      ae.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:".concat(String.valueOf(j)));
      if ((j <= 2000) || (o.hQf >= 300))
      {
        if (this.hQi != null) {
          this.hQi.run();
        }
        o.aEL();
        AppMethodBeat.o(150314);
        return false;
      }
      long l = g.ajR().gDX.yi(Thread.currentThread().getId());
      int i = j - 1;
      while (i >= j - 30)
      {
        o.Qe();
        String str = (String)o.hQe.get(i);
        o.hQe.remove(i);
        p.aEA();
        e.L(str, false);
        p.aEA();
        e.L(str, true);
        p.aEN().DM(str);
        i -= 1;
      }
      g.ajR().gDX.sW(l);
      AppMethodBeat.o(150314);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.o
 * JD-Core Version:    0.7.0.1
 */