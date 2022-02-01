package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public abstract interface v
{
  public abstract void a(m paramm, boolean paramBoolean);
  
  public abstract void a(u paramu, g paramg, d paramd);
  
  public abstract void tg();
  
  public static final class a
  {
    public final String aTm;
    public final byte[] biu;
    public final int type;
    
    public a(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      this.aTm = paramString;
      this.type = paramInt;
      this.biu = paramArrayOfByte;
    }
  }
  
  public static final class b
  {
    public final String aTm;
    public final List<v.a> biv;
    public final byte[] biw;
    public final int streamType;
    
    public b(int paramInt, String paramString, List<v.a> paramList, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(92300);
      this.streamType = paramInt;
      this.aTm = paramString;
      if (paramList == null) {}
      for (paramString = Collections.emptyList();; paramString = Collections.unmodifiableList(paramList))
      {
        this.biv = paramString;
        this.biw = paramArrayOfByte;
        AppMethodBeat.o(92300);
        return;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract v a(int paramInt, v.b paramb);
    
    public abstract SparseArray<v> to();
  }
  
  public static final class d
  {
    private String bgl;
    private final String bix;
    private final int biy;
    private final int biz;
    private int trackId;
    
    public d(int paramInt1, int paramInt2)
    {
      this(-2147483648, paramInt1, paramInt2);
    }
    
    public d(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(92301);
      if (paramInt1 != -2147483648) {}
      for (String str = paramInt1 + "/";; str = "")
      {
        this.bix = str;
        this.biy = paramInt2;
        this.biz = paramInt3;
        this.trackId = -2147483648;
        AppMethodBeat.o(92301);
        return;
      }
    }
    
    private void tu()
    {
      AppMethodBeat.i(92305);
      if (this.trackId == -2147483648)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("generateNewId() must be called before retrieving ids.");
        AppMethodBeat.o(92305);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(92305);
    }
    
    public final int getTrackId()
    {
      AppMethodBeat.i(92303);
      tu();
      int i = this.trackId;
      AppMethodBeat.o(92303);
      return i;
    }
    
    public final void ts()
    {
      AppMethodBeat.i(92302);
      if (this.trackId == -2147483648) {}
      for (int i = this.biy;; i = this.trackId + this.biz)
      {
        this.trackId = i;
        this.bgl = (this.bix + this.trackId);
        AppMethodBeat.o(92302);
        return;
      }
    }
    
    public final String tt()
    {
      AppMethodBeat.i(92304);
      tu();
      String str = this.bgl;
      AppMethodBeat.o(92304);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.v
 * JD-Core Version:    0.7.0.1
 */