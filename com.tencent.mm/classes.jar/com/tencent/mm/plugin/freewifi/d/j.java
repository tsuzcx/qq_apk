package com.tencent.mm.plugin.freewifi.d;

import android.os.Build;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.protocal.c.avs;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import java.util.LinkedList;

public final class j
  extends c
{
  public j(LinkedList<avu> paramLinkedList, int paramInt)
  {
    aUp();
    avs localavs = (avs)this.dmK.ecE.ecN;
    localavs.trn = Build.BRAND;
    localavs.trm = paramInt;
    localavs.trl = paramLinkedList;
  }
  
  public final avt aUC()
  {
    return (avt)this.dmK.ecF.ecN;
  }
  
  protected final void aUp()
  {
    b.a locala = new b.a();
    locala.ecH = new avs();
    locala.ecI = new avt();
    locala.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
    locala.ecG = 1707;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final int getType()
  {
    return 1707;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.j
 * JD-Core Version:    0.7.0.1
 */