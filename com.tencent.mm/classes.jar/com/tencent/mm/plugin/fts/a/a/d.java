package com.tencent.mm.plugin.fts.a.a;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class d
{
  public TextPaint eLQ;
  public CharSequence mRW;
  public g mRX;
  public boolean mRY;
  public boolean mRZ;
  public d.a mSa;
  public int mSb;
  public float mSc;
  public CharSequence mSd;
  public CharSequence mSe;
  public String mSf;
  public String mSg;
  
  public d()
  {
    AppMethodBeat.i(114243);
    this.mSa = d.a.mSh;
    this.mSb = Color.parseColor("#07C160");
    this.mSd = "";
    this.mSe = "";
    this.mSf = "";
    this.mSg = "";
    AppMethodBeat.o(114243);
  }
  
  public static final d a(CharSequence paramCharSequence, g paramg)
  {
    AppMethodBeat.i(114246);
    d locald = new d();
    locald.mRW = paramCharSequence;
    locald.mRX = paramg;
    AppMethodBeat.o(114246);
    return locald;
  }
  
  public static final d a(CharSequence paramCharSequence, g paramg, float paramFloat, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(114248);
    paramCharSequence = a(paramCharSequence, paramg, false, false, paramFloat, paramTextPaint);
    AppMethodBeat.o(114248);
    return paramCharSequence;
  }
  
  public static final d a(CharSequence paramCharSequence, g paramg, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114247);
    paramCharSequence = a(paramCharSequence, paramg, paramBoolean1, paramBoolean2, 0.0F, null);
    AppMethodBeat.o(114247);
    return paramCharSequence;
  }
  
  public static final d a(CharSequence paramCharSequence, g paramg, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(114249);
    d locald = new d();
    locald.mRW = paramCharSequence;
    locald.mRX = paramg;
    locald.mRY = paramBoolean1;
    locald.mRZ = paramBoolean2;
    locald.mSc = paramFloat;
    locald.eLQ = paramTextPaint;
    AppMethodBeat.o(114249);
    return locald;
  }
  
  public static final d a(CharSequence paramCharSequence1, g paramg, boolean paramBoolean1, boolean paramBoolean2, TextPaint paramTextPaint, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    AppMethodBeat.i(114250);
    d locald = new d();
    locald.mRW = paramCharSequence1;
    locald.mRX = paramg;
    locald.mRY = paramBoolean1;
    locald.mRZ = paramBoolean2;
    locald.mSc = 400.0F;
    locald.eLQ = paramTextPaint;
    locald.mSd = paramCharSequence2;
    locald.mSe = paramCharSequence3;
    AppMethodBeat.o(114250);
    return locald;
  }
  
  public static final d a(CharSequence paramCharSequence, List<String> paramList)
  {
    AppMethodBeat.i(114244);
    paramCharSequence = b(paramCharSequence, bo.d(paramList, " "));
    AppMethodBeat.o(114244);
    return paramCharSequence;
  }
  
  public static final d a(CharSequence paramCharSequence, List<String> paramList, d.a parama, int paramInt)
  {
    AppMethodBeat.i(114251);
    paramCharSequence = a(paramCharSequence, paramList);
    paramCharSequence.mSa = parama;
    paramCharSequence.mSb = paramInt;
    AppMethodBeat.o(114251);
    return paramCharSequence;
  }
  
  public static final d b(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(114245);
    d locald = new d();
    locald.mRW = paramCharSequence;
    locald.mRX = g.aU(paramString, false);
    locald.mRY = false;
    locald.mRZ = false;
    AppMethodBeat.o(114245);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.d
 * JD-Core Version:    0.7.0.1
 */