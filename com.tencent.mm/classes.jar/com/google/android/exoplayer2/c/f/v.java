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
  
  public abstract void uK();
  
  public static final class a
  {
    public final byte[] bsJ;
    public final String language;
    public final int type;
    
    public a(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      this.language = paramString;
      this.type = paramInt;
      this.bsJ = paramArrayOfByte;
    }
  }
  
  public static final class b
  {
    public final List<v.a> bsK;
    public final byte[] bsL;
    public final String language;
    public final int streamType;
    
    public b(int paramInt, String paramString, List<v.a> paramList, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(92300);
      this.streamType = paramInt;
      this.language = paramString;
      if (paramList == null) {}
      for (paramString = Collections.emptyList();; paramString = Collections.unmodifiableList(paramList))
      {
        this.bsK = paramString;
        this.bsL = paramArrayOfByte;
        AppMethodBeat.o(92300);
        return;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract v a(int paramInt, v.b paramb);
    
    public abstract SparseArray<v> uS();
  }
  
  public static final class d
  {
    private String bqA;
    private final String bsM;
    private final int bsN;
    private final int bsO;
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
        this.bsM = str;
        this.bsN = paramInt2;
        this.bsO = paramInt3;
        this.trackId = -2147483648;
        AppMethodBeat.o(92301);
        return;
      }
    }
    
    private void uY()
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
      uY();
      int i = this.trackId;
      AppMethodBeat.o(92303);
      return i;
    }
    
    public final void uW()
    {
      AppMethodBeat.i(92302);
      if (this.trackId == -2147483648) {}
      for (int i = this.bsN;; i = this.trackId + this.bsO)
      {
        this.trackId = i;
        this.bqA = (this.bsM + this.trackId);
        AppMethodBeat.o(92302);
        return;
      }
    }
    
    public final String uX()
    {
      AppMethodBeat.i(92304);
      uY();
      String str = this.bqA;
      AppMethodBeat.o(92304);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.v
 * JD-Core Version:    0.7.0.1
 */