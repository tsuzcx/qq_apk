package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.f.a.g;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.j;
import java.util.List;

final class r
{
  private final List<Format> aDA;
  private final k[] aDD;
  
  public r(List<Format> paramList)
  {
    this.aDA = paramList;
    this.aDD = new k[paramList.size()];
  }
  
  public final void a(long paramLong, j paramj)
  {
    g.a(paramLong, paramj, this.aDD);
  }
  
  public final void a(f paramf, u.d paramd)
  {
    int i = 0;
    if (i < this.aDD.length)
    {
      paramd.mg();
      k localk = paramf.cQ(paramd.mh());
      Format localFormat = (Format)this.aDA.get(i);
      String str2 = localFormat.aus;
      boolean bool;
      if (("application/cea-608".equals(str2)) || ("application/cea-708".equals(str2)))
      {
        bool = true;
        label72:
        a.b(bool, "Invalid closed caption mime type provided: " + str2);
        if (localFormat.id == null) {
          break label159;
        }
      }
      label159:
      for (String str1 = localFormat.id;; str1 = paramd.mi())
      {
        localk.f(Format.a(str1, str2, localFormat.auH, localFormat.auI, localFormat.auJ));
        this.aDD[i] = localk;
        i += 1;
        break;
        bool = false;
        break label72;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.r
 * JD-Core Version:    0.7.0.1
 */