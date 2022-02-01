package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public abstract class g
{
  public final Format aSv;
  public final String bnZ;
  public final String bob;
  public final long boh;
  public final long boi;
  public final List<d> boj;
  public final f bok;
  
  private g(String paramString1, Format paramFormat, String paramString2, h paramh, List<d> paramList)
  {
    this.bnZ = paramString1;
    this.boh = -1L;
    this.aSv = paramFormat;
    this.bob = paramString2;
    if (paramList == null) {}
    for (paramString1 = Collections.emptyList();; paramString1 = Collections.unmodifiableList(paramList))
    {
      this.boj = paramString1;
      this.bok = paramh.a(this);
      this.boi = x.b(paramh.bor, 1000000L, paramh.bdm);
      return;
    }
  }
  
  public abstract String getCacheKey();
  
  public abstract f um();
  
  public abstract com.google.android.exoplayer2.source.dash.d un();
  
  public static final class a
    extends g
    implements com.google.android.exoplayer2.source.dash.d
  {
    private final h.a bol;
    
    public a(String paramString1, Format paramFormat, String paramString2, h.a parama, List<d> paramList)
    {
      super(paramFormat, paramString2, parama, paramList, (byte)0);
      this.bol = parama;
    }
    
    public final int ah(long paramLong)
    {
      AppMethodBeat.i(10564);
      int i = this.bol.ah(paramLong);
      AppMethodBeat.o(10564);
      return i;
    }
    
    public final long eH(int paramInt)
    {
      AppMethodBeat.i(10562);
      long l = this.bol.eO(paramInt);
      AppMethodBeat.o(10562);
      return l;
    }
    
    public final f eI(int paramInt)
    {
      AppMethodBeat.i(10560);
      f localf = this.bol.a(this, paramInt);
      AppMethodBeat.o(10560);
      return localf;
    }
    
    public final String getCacheKey()
    {
      return null;
    }
    
    public final int j(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(10561);
      h.a locala = this.bol;
      int k = locala.bos;
      int i = locala.ah(paramLong2);
      if (i == 0)
      {
        AppMethodBeat.o(10561);
        return k;
      }
      if (locala.bot == null)
      {
        paramLong2 = locala.duration * 1000000L / locala.bdm;
        j = locala.bos + (int)(paramLong1 / paramLong2);
        if (j < k)
        {
          AppMethodBeat.o(10561);
          return k;
        }
        if (i == -1)
        {
          AppMethodBeat.o(10561);
          return j;
        }
        i = Math.min(j, k + i - 1);
        AppMethodBeat.o(10561);
        return i;
      }
      i = k + i - 1;
      int j = k;
      while (j <= i)
      {
        int m = (i - j) / 2 + j;
        paramLong2 = locala.eO(m);
        if (paramLong2 < paramLong1)
        {
          j = m + 1;
        }
        else if (paramLong2 > paramLong1)
        {
          i = m - 1;
        }
        else
        {
          AppMethodBeat.o(10561);
          return m;
        }
      }
      if (j == k)
      {
        AppMethodBeat.o(10561);
        return j;
      }
      AppMethodBeat.o(10561);
      return i;
    }
    
    public final long k(int paramInt, long paramLong)
    {
      AppMethodBeat.i(10563);
      h.a locala = this.bol;
      if (locala.bot != null)
      {
        paramLong = ((h.d)locala.bot.get(paramInt - locala.bos)).duration * 1000000L / locala.bdm;
        AppMethodBeat.o(10563);
        return paramLong;
      }
      int i = locala.ah(paramLong);
      if ((i != -1) && (paramInt == i + locala.bos - 1))
      {
        long l = locala.eO(paramInt);
        AppMethodBeat.o(10563);
        return paramLong - l;
      }
      paramLong = locala.duration * 1000000L / locala.bdm;
      AppMethodBeat.o(10563);
      return paramLong;
    }
    
    public final int ui()
    {
      return this.bol.bos;
    }
    
    public final boolean uj()
    {
      AppMethodBeat.i(10565);
      boolean bool = this.bol.uj();
      AppMethodBeat.o(10565);
      return bool;
    }
    
    public final f um()
    {
      return null;
    }
    
    public final com.google.android.exoplayer2.source.dash.d un()
    {
      return this;
    }
  }
  
  public static final class b
    extends g
  {
    public final long aLn;
    private final f bom;
    private final i bon;
    private final String cacheKey;
    public final Uri uri;
    
    public b(String paramString1, Format paramFormat, String paramString2, h.e parame, List<d> paramList)
    {
      super(paramFormat, paramString2, parame, paramList, (byte)0);
      AppMethodBeat.i(10566);
      this.uri = Uri.parse(paramString2);
      if (parame.boy <= 0L)
      {
        paramString2 = null;
        this.bom = paramString2;
        if (paramString1 == null) {
          break label134;
        }
        paramString1 = paramString1 + "." + paramFormat.id + ".-1";
        label79:
        this.cacheKey = paramString1;
        this.aLn = -1L;
        if (this.bom == null) {
          break label139;
        }
      }
      label134:
      label139:
      for (paramString1 = null;; paramString1 = new i(new f(null, 0L, -1L)))
      {
        this.bon = paramString1;
        AppMethodBeat.o(10566);
        return;
        paramString2 = new f(null, parame.box, parame.boy);
        break;
        paramString1 = null;
        break label79;
      }
    }
    
    public final String getCacheKey()
    {
      return this.cacheKey;
    }
    
    public final f um()
    {
      return this.bom;
    }
    
    public final com.google.android.exoplayer2.source.dash.d un()
    {
      return this.bon;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.manifest.g
 * JD-Core Version:    0.7.0.1
 */