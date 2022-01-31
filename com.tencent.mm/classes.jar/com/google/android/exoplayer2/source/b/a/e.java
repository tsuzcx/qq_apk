package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.h.u.a;
import com.google.android.exoplayer2.source.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public final class e
  implements t.a<u<c>>
{
  public final d aRI;
  final com.google.android.exoplayer2.source.a.a aRJ;
  public final u.a<c> aRR;
  public a aRo;
  public final Uri aTh;
  public final int aTi;
  public final IdentityHashMap<a.a, e.a> aTj;
  public final Handler aTk;
  final e.e aTl;
  public final List<e.b> aTm;
  public final t aTn;
  public a.a aTo;
  b aTp;
  public boolean aTq;
  
  public e(Uri paramUri, d paramd, com.google.android.exoplayer2.source.a.a parama, int paramInt, e.e parame, u.a<c> parama1)
  {
    AppMethodBeat.i(125990);
    this.aTh = paramUri;
    this.aRI = paramd;
    this.aRJ = parama;
    this.aTi = paramInt;
    this.aTl = parame;
    this.aRR = parama1;
    this.aTm = new ArrayList();
    this.aTn = new t("HlsPlaylistTracker:MasterPlaylist");
    this.aTj = new IdentityHashMap();
    this.aTk = new Handler();
    AppMethodBeat.o(125990);
  }
  
  static b.a a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(125995);
    int i = paramb2.aSt - paramb1.aSt;
    paramb1 = paramb1.aSz;
    if (i < paramb1.size())
    {
      paramb1 = (b.a)paramb1.get(i);
      AppMethodBeat.o(125995);
      return paramb1;
    }
    AppMethodBeat.o(125995);
    return null;
  }
  
  private void e(a.a parama)
  {
    AppMethodBeat.i(125993);
    if ((parama == this.aTo) || (!this.aRo.aSm.contains(parama)) || ((this.aTp != null) && (this.aTp.aSw)))
    {
      AppMethodBeat.o(125993);
      return;
    }
    this.aTo = parama;
    ((e.a)this.aTj.get(this.aTo)).pE();
    AppMethodBeat.o(125993);
  }
  
  private void u(List<a.a> paramList)
  {
    AppMethodBeat.i(125994);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a.a locala = (a.a)paramList.get(i);
      e.a locala1 = new e.a(this, locala);
      this.aTj.put(locala, locala1);
      i += 1;
    }
    AppMethodBeat.o(125994);
  }
  
  public final b c(a.a parama)
  {
    AppMethodBeat.i(125991);
    b localb = ((e.a)this.aTj.get(parama)).aTu;
    if (localb != null) {
      e(parama);
    }
    AppMethodBeat.o(125991);
    return localb;
  }
  
  public final void d(a.a parama)
  {
    AppMethodBeat.i(125992);
    this.aTj.get(parama);
    AppMethodBeat.o(125992);
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