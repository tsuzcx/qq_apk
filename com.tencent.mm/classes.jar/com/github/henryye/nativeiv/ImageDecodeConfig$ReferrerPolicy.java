package com.github.henryye.nativeiv;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public enum ImageDecodeConfig$ReferrerPolicy
{
  static
  {
    AppMethodBeat.i(219704);
    NOT_SET = new ReferrerPolicy("NOT_SET", 0);
    NO_REFERRER = new ReferrerPolicy("NO_REFERRER", 1);
    ORIGIN = new ReferrerPolicy("ORIGIN", 2);
    $VALUES = new ReferrerPolicy[] { NOT_SET, NO_REFERRER, ORIGIN };
    AppMethodBeat.o(219704);
  }
  
  private ImageDecodeConfig$ReferrerPolicy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.ImageDecodeConfig.ReferrerPolicy
 * JD-Core Version:    0.7.0.1
 */