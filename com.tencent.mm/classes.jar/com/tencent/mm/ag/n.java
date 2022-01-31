package com.tencent.mm.ag;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class n
{
  private static List<String> eci = null;
  private static int ecj = 0;
  private static a eck = new a(new b());
  
  public static void Kc()
  {
    ecj = 0;
    eck.stopTimer();
  }
  
  public static void p(Runnable paramRunnable)
  {
    if (!g.DN().Dc()) {}
    ArrayList localArrayList;
    do
    {
      return;
      Object localObject = o.Kh();
      localArrayList = new ArrayList();
      localObject = ((i)localObject).dXo.a("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
      while (((Cursor)localObject).moveToNext()) {
        localArrayList.add(((Cursor)localObject).getString(0));
      }
      ((Cursor)localObject).close();
      eci = localArrayList;
    } while (localArrayList.size() <= 0);
    eck.ecl.ecm = paramRunnable;
    eck.S(10L, 10L);
  }
  
  static final class a
    extends am
  {
    final n.b ecl;
    
    public a(n.b paramb)
    {
      super(true);
      this.ecl = paramb;
    }
  }
  
  static final class b
    implements am.a
  {
    Runnable ecm;
    
    public final boolean tC()
    {
      int j = n.Kd().size();
      y.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:" + j);
      if ((j <= 2000) || (n.ecj >= 300))
      {
        if (this.ecm != null) {
          this.ecm.run();
        }
        n.Ke();
        return false;
      }
      long l = g.DP().dKu.eV(Thread.currentThread().getId());
      int i = j - 1;
      while (i >= j - 30)
      {
        n.Kf();
        String str = (String)n.Kd().get(i);
        n.Kd().remove(i);
        o.JQ();
        d.B(str, false);
        o.JQ();
        d.B(str, true);
        o.Kh().kq(str);
        i -= 1;
      }
      g.DP().dKu.hI(l);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.n
 * JD-Core Version:    0.7.0.1
 */