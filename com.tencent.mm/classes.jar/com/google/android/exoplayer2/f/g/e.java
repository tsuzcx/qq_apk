package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends a
{
  public final long endTime;
  public final long startTime;
  
  public e(long paramLong1, long paramLong2, CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3)
  {
    super(paramCharSequence, paramAlignment, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramFloat3);
    this.startTime = paramLong1;
    this.endTime = paramLong2;
  }
  
  public e(CharSequence paramCharSequence)
  {
    this(paramCharSequence, (byte)0);
  }
  
  private e(CharSequence paramCharSequence, byte paramByte)
  {
    this(0L, 0L, paramCharSequence, null, 1.4E-45F, -2147483648, -2147483648, 1.4E-45F, -2147483648, 1.4E-45F);
  }
  
  public static final class a
  {
    Layout.Alignment bpE;
    float bpF;
    int bpG;
    float bpH;
    int bpI;
    SpannableStringBuilder btm;
    long endTime;
    int lineType;
    long startTime;
    float width;
    
    public a()
    {
      AppMethodBeat.i(92894);
      reset();
      AppMethodBeat.o(92894);
    }
    
    private a uS()
    {
      AppMethodBeat.i(92896);
      if (this.bpE == null) {
        this.bpI = -2147483648;
      }
      for (;;)
      {
        AppMethodBeat.o(92896);
        return this;
        switch (e.1.btl[this.bpE.ordinal()])
        {
        default: 
          new StringBuilder("Unrecognized alignment: ").append(this.bpE);
          this.bpI = 0;
          break;
        case 1: 
          this.bpI = 0;
          break;
        case 2: 
          this.bpI = 1;
          break;
        case 3: 
          this.bpI = 2;
        }
      }
    }
    
    public final void reset()
    {
      this.startTime = 0L;
      this.endTime = 0L;
      this.btm = null;
      this.bpE = null;
      this.bpF = 1.4E-45F;
      this.lineType = -2147483648;
      this.bpG = -2147483648;
      this.bpH = 1.4E-45F;
      this.bpI = -2147483648;
      this.width = 1.4E-45F;
    }
    
    public final e uR()
    {
      AppMethodBeat.i(92895);
      if ((this.bpH != 1.4E-45F) && (this.bpI == -2147483648)) {
        uS();
      }
      e locale = new e(this.startTime, this.endTime, this.btm, this.bpE, this.bpF, this.lineType, this.bpG, this.bpH, this.bpI, this.width);
      AppMethodBeat.o(92895);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.e
 * JD-Core Version:    0.7.0.1
 */