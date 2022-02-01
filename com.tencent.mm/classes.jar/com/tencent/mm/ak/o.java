package com.tencent.mm.ak;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class o
{
  private static List<String> gUu;
  private static int gUv;
  private static a gUw;
  
  static
  {
    AppMethodBeat.i(150317);
    gUu = null;
    gUv = 0;
    gUw = new a(new b());
    AppMethodBeat.o(150317);
  }
  
  public static void E(Runnable paramRunnable)
  {
    AppMethodBeat.i(150315);
    if (!g.afz().aeI())
    {
      AppMethodBeat.o(150315);
      return;
    }
    Object localObject = p.auF();
    ArrayList localArrayList = new ArrayList();
    localObject = ((j)localObject).gPa.a("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(0));
    }
    ((Cursor)localObject).close();
    gUu = localArrayList;
    if (localArrayList.size() <= 0)
    {
      AppMethodBeat.o(150315);
      return;
    }
    gUw.gUx.gUy = paramRunnable;
    gUw.av(10L, 10L);
    AppMethodBeat.o(150315);
  }
  
  public static void auB()
  {
    AppMethodBeat.i(150316);
    gUv = 0;
    gUw.stopTimer();
    AppMethodBeat.o(150316);
  }
  
  static final class a
    extends av
  {
    final o.b gUx;
    
    public a(o.b paramb)
    {
      super(true);
      this.gUx = paramb;
    }
  }
  
  static final class b
    implements av.a
  {
    Runnable gUy;
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(150314);
      int j = o.apA().size();
      ad.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:".concat(String.valueOf(j)));
      if ((j <= 2000) || (o.gUv >= 300))
      {
        if (this.gUy != null) {
          this.gUy.run();
        }
        o.auC();
        AppMethodBeat.o(150314);
        return false;
      }
      long l = g.afB().gda.rb(Thread.currentThread().getId());
      int i = j - 1;
      while (i >= j - 30)
      {
        o.auD();
        String str = (String)o.apA().get(i);
        o.apA().remove(i);
        p.auq();
        e.K(str, false);
        p.auq();
        e.K(str, true);
        p.auF().wf(str);
        i -= 1;
      }
      g.afB().gda.mX(l);
      AppMethodBeat.o(150314);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.o
 * JD-Core Version:    0.7.0.1
 */