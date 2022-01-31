package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.bk;

public final class f$c
{
  public String imagePath;
  public d khL;
  boolean khM;
  public f.c.a khN = new f.c.a(this);
  public long timeStamp;
  public int type = 0;
  
  public f$c(d paramd)
  {
    this.khL = paramd;
    Object localObject;
    if ((paramd.aRQ()) || (paramd.aRR())) {
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramd.bNH);
    }
    for (;;)
    {
      this.imagePath = ((String)localObject);
      this.timeStamp = paramd.khA.field_updateTime;
      if ((paramd.aRQ()) || (paramd.aRR()))
      {
        this.khM = true;
        this.khN.khO = bk.jL(paramd.bNH.duration);
      }
      return;
      String str = com.tencent.mm.plugin.fav.a.b.b(paramd.bNH);
      localObject = str;
      if (!new com.tencent.mm.vfs.b(str).exists()) {
        localObject = com.tencent.mm.plugin.fav.a.b.c(paramd.bNH);
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((this.khL != null) && ((paramObject instanceof d)) && (paramObject != null)) {
      return this.khL.bNH.kgC.equals(((d)paramObject).bNH.kgC);
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.c
 * JD-Core Version:    0.7.0.1
 */