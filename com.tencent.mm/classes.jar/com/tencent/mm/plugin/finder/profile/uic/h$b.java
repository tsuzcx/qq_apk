package com.tencent.mm.plugin.finder.profile.uic;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$DescSpanInfo;", "", "signature", "", "signatureSpan", "Landroid/text/SpannableString;", "reportNickName", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "(Ljava/lang/String;Landroid/text/SpannableString;Ljava/lang/StringBuilder;)V", "getReportNickName", "()Ljava/lang/StringBuilder;", "getSignature", "()Ljava/lang/String;", "getSignatureSpan", "()Landroid/text/SpannableString;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h$b
{
  final SpannableString FeC;
  final StringBuilder FeD;
  final String signature;
  
  public h$b(String paramString, SpannableString paramSpannableString, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(348638);
    this.signature = paramString;
    this.FeC = paramSpannableString;
    this.FeD = paramStringBuilder;
    AppMethodBeat.o(348638);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(348649);
    if (this == paramObject)
    {
      AppMethodBeat.o(348649);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(348649);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.signature, paramObject.signature))
    {
      AppMethodBeat.o(348649);
      return false;
    }
    if (!s.p(this.FeC, paramObject.FeC))
    {
      AppMethodBeat.o(348649);
      return false;
    }
    if (!s.p(this.FeD, paramObject.FeD))
    {
      AppMethodBeat.o(348649);
      return false;
    }
    AppMethodBeat.o(348649);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(348646);
    int j = this.signature.hashCode();
    if (this.FeC == null) {}
    for (int i = 0;; i = this.FeC.hashCode())
    {
      int k = this.FeD.hashCode();
      AppMethodBeat.o(348646);
      return (i + j * 31) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(348641);
    String str = "DescSpanInfo(signature=" + this.signature + ", signatureSpan=" + this.FeC + ", reportNickName=" + this.FeD + ')';
    AppMethodBeat.o(348641);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.h.b
 * JD-Core Version:    0.7.0.1
 */