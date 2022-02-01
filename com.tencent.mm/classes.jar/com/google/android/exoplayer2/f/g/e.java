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
    int ddA;
    Layout.Alignment ddw;
    float ddx;
    int ddy;
    float ddz;
    SpannableStringBuilder dha;
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
    
    private a Ua()
    {
      AppMethodBeat.i(92896);
      if (this.ddw == null) {
        this.ddA = -2147483648;
      }
      for (;;)
      {
        AppMethodBeat.o(92896);
        return this;
        switch (e.1.dgZ[this.ddw.ordinal()])
        {
        default: 
          new StringBuilder("Unrecognized alignment: ").append(this.ddw);
          this.ddA = 0;
          break;
        case 1: 
          this.ddA = 0;
          break;
        case 2: 
          this.ddA = 1;
          break;
        case 3: 
          this.ddA = 2;
        }
      }
    }
    
    public final e TZ()
    {
      AppMethodBeat.i(92895);
      if ((this.ddz != 1.4E-45F) && (this.ddA == -2147483648)) {
        Ua();
      }
      e locale = new e(this.startTime, this.endTime, this.dha, this.ddw, this.ddx, this.lineType, this.ddy, this.ddz, this.ddA, this.width);
      AppMethodBeat.o(92895);
      return locale;
    }
    
    public final void reset()
    {
      this.startTime = 0L;
      this.endTime = 0L;
      this.dha = null;
      this.ddw = null;
      this.ddx = 1.4E-45F;
      this.lineType = -2147483648;
      this.ddy = -2147483648;
      this.ddz = 1.4E-45F;
      this.ddA = -2147483648;
      this.width = 1.4E-45F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.e
 * JD-Core Version:    0.7.0.1
 */