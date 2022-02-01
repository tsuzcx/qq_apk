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
  private static List<String> hNl;
  private static int hNm;
  private static a hNn;
  
  static
  {
    AppMethodBeat.i(150317);
    hNl = null;
    hNm = 0;
    hNn = new a(new b());
    AppMethodBeat.o(150317);
  }
  
  public static void F(Runnable paramRunnable)
  {
    AppMethodBeat.i(150315);
    if (!g.ajA().aiK())
    {
      AppMethodBeat.o(150315);
      return;
    }
    Object localObject = p.aEx();
    ArrayList localArrayList = new ArrayList();
    localObject = ((j)localObject).hHS.a("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(0));
    }
    ((Cursor)localObject).close();
    hNl = localArrayList;
    if (localArrayList.size() <= 0)
    {
      AppMethodBeat.o(150315);
      return;
    }
    hNn.hNo.hNp = paramRunnable;
    hNn.az(10L, 10L);
    AppMethodBeat.o(150315);
  }
  
  public static void aEu()
  {
    AppMethodBeat.i(150316);
    hNm = 0;
    hNn.stopTimer();
    AppMethodBeat.o(150316);
  }
  
  static final class a
    extends av
  {
    final o.b hNo;
    
    public a(o.b paramb)
    {
      super(true);
      this.hNo = paramb;
    }
  }
  
  static final class b
    implements av.a
  {
    Runnable hNp;
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(150314);
      int j = o.hNl.size();
      ad.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:".concat(String.valueOf(j)));
      if ((j <= 2000) || (o.hNm >= 300))
      {
        if (this.hNp != null) {
          this.hNp.run();
        }
        o.aEv();
        AppMethodBeat.o(150314);
        return false;
      }
      long l = g.ajC().gBq.xO(Thread.currentThread().getId());
      int i = j - 1;
      while (i >= j - 30)
      {
        o.Qf();
        String str = (String)o.hNl.get(i);
        o.hNl.remove(i);
        p.aEk();
        e.L(str, false);
        p.aEk();
        e.L(str, true);
        p.aEx().Dk(str);
        i -= 1;
      }
      g.ajC().gBq.sJ(l);
      AppMethodBeat.o(150314);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ak.o
 * JD-Core Version:    0.7.0.1
 */