package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.ig;
import com.tencent.mm.protocal.b.a.b;
import java.util.LinkedList;

final class i$1
  implements Runnable
{
  i$1(String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public final void run()
  {
    ig localig = new ig();
    b localb = new b();
    localb.title = this.dYK;
    localb.bHk = this.lmY;
    localb.srm = new LinkedList();
    com.tencent.mm.protocal.b.a.a locala = new com.tencent.mm.protocal.b.a.a();
    locala.srk = this.lmZ;
    localb.srm.add(locala);
    locala = new com.tencent.mm.protocal.b.a.a();
    locala.srk = this.lna;
    localb.srm.add(locala);
    localig.bQt.type = 1;
    localig.bQt.bQu = localb;
    localig.bQt.bQv = this.lnb;
    localig.bQt.bQw = this.lnc;
    com.tencent.mm.sdk.b.a.udP.m(localig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.i.1
 * JD-Core Version:    0.7.0.1
 */