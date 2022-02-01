package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface v
{
  public abstract void Si();
  
  public abstract void a(m paramm, boolean paramBoolean);
  
  public abstract void a(u paramu, g paramg, d paramd);
  
  public static final class a
  {
    public final byte[] cWg;
    public final String language;
    public final int type;
    
    public a(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      this.language = paramString;
      this.type = paramInt;
      this.cWg = paramArrayOfByte;
    }
  }
  
  public static abstract interface c
  {
    public abstract SparseArray<v> Sq();
    
    public abstract v a(int paramInt, v.b paramb);
  }
  
  public static final class d
  {
    private String cTX;
    private final String cWj;
    private final int cWk;
    private final int cWl;
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
        this.cWj = str;
        this.cWk = paramInt2;
        this.cWl = paramInt3;
        this.trackId = -2147483648;
        AppMethodBeat.o(92301);
        return;
      }
    }
    
    private void Sx()
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
    
    public final void Sv()
    {
      AppMethodBeat.i(92302);
      if (this.trackId == -2147483648) {}
      for (int i = this.cWk;; i = this.trackId + this.cWl)
      {
        this.trackId = i;
        this.cTX = (this.cWj + this.trackId);
        AppMethodBeat.o(92302);
        return;
      }
    }
    
    public final String Sw()
    {
      AppMethodBeat.i(92304);
      Sx();
      String str = this.cTX;
      AppMethodBeat.o(92304);
      return str;
    }
    
    public final int getTrackId()
    {
      AppMethodBeat.i(92303);
      Sx();
      int i = this.trackId;
      AppMethodBeat.o(92303);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.v
 * JD-Core Version:    0.7.0.1
 */