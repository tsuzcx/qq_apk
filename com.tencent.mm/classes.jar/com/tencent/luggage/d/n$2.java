package com.tencent.luggage.d;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$2
  extends l
{
  n$2(n paramn) {}
  
  public final WebResourceResponse a(WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(90846);
    if (this.bzx.uz() != null)
    {
      paramWebResourceRequest = this.bzx.uz().a(paramWebResourceRequest, paramBundle);
      AppMethodBeat.o(90846);
      return paramWebResourceRequest;
    }
    AppMethodBeat.o(90846);
    return null;
  }
  
  public final void bE(String paramString)
  {
    AppMethodBeat.i(90843);
    if (this.bzx.uz() != null) {
      this.bzx.uz().a(this.bzx, paramString);
    }
    AppMethodBeat.o(90843);
  }
  
  public final void bF(String paramString)
  {
    AppMethodBeat.i(90844);
    if (this.bzx.uz() != null) {
      this.bzx.uz().b(this.bzx, paramString);
    }
    this.bzx.ua();
    AppMethodBeat.o(90844);
  }
  
  public final String ux()
  {
    AppMethodBeat.i(90845);
    String str = n.a(this.bzx);
    AppMethodBeat.o(90845);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.n.2
 * JD-Core Version:    0.7.0.1
 */