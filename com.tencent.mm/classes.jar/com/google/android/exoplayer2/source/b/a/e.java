package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.h.r.a;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.h.s.a;
import com.google.android.exoplayer2.source.b.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public final class e
  implements r.a<s<c>>
{
  public a aJI;
  public final d aKd;
  final com.google.android.exoplayer2.source.a.a aKf;
  public final s.a<c> aKn;
  public final Uri aLN;
  public final int aLO;
  public final IdentityHashMap<a.a, e.a> aLP;
  public final Handler aLQ;
  final e.e aLR;
  public final List<e.b> aLS;
  public final r aLT;
  public a.a aLU;
  b aLV;
  public boolean aLW;
  
  public e(Uri paramUri, d paramd, com.google.android.exoplayer2.source.a.a parama, int paramInt, e.e parame, s.a<c> parama1)
  {
    this.aLN = paramUri;
    this.aKd = paramd;
    this.aKf = parama;
    this.aLO = paramInt;
    this.aLR = parame;
    this.aKn = parama1;
    this.aLS = new ArrayList();
    this.aLT = new r("HlsPlaylistTracker:MasterPlaylist");
    this.aLP = new IdentityHashMap();
    this.aLQ = new Handler();
  }
  
  static b.a a(b paramb1, b paramb2)
  {
    int i = paramb2.aKZ - paramb1.aKZ;
    paramb1 = paramb1.aLf;
    if (i < paramb1.size()) {
      return (b.a)paramb1.get(i);
    }
    return null;
  }
  
  private void s(List<a.a> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a.a locala = (a.a)paramList.get(i);
      e.a locala1 = new e.a(this, locala);
      this.aLP.put(locala, locala1);
      i += 1;
    }
  }
  
  public final b c(a.a parama)
  {
    b localb = ((e.a)this.aLP.get(parama)).aMa;
    if ((localb == null) || (parama == this.aLU) || (!this.aJI.aKS.contains(parama)) || ((this.aLV != null) && (this.aLV.aLc))) {
      return localb;
    }
    this.aLU = parama;
    ((e.a)this.aLP.get(this.aLU)).nh();
    return localb;
  }
  
  public final void d(a.a parama)
  {
    parama = (e.a)this.aLP.get(parama);
    parama.aLY.mD();
    if (parama.aMg != null) {
      throw parama.aMg;
    }
  }
  
  public static final class c
    extends IOException
  {
    public final String url;
    
    private c(String paramString)
    {
      this.url = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.e
 * JD-Core Version:    0.7.0.1
 */