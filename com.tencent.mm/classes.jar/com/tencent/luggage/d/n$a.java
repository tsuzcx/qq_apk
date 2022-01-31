package com.tencent.luggage.d;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class n$a
  extends e.a
{
  public n$a() {}
  
  protected n$a(e.a parama)
  {
    super(parama);
  }
  
  public WebResourceResponse a(WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(90849);
    if ((this.byM instanceof a))
    {
      paramWebResourceRequest = ((a)this.byM).a(paramWebResourceRequest, paramBundle);
      AppMethodBeat.o(90849);
      return paramWebResourceRequest;
    }
    AppMethodBeat.o(90849);
    return null;
  }
  
  public void a(n paramn, String paramString)
  {
    AppMethodBeat.i(90847);
    if ((this.byM instanceof a)) {
      ((a)this.byM).a(paramn, paramString);
    }
    AppMethodBeat.o(90847);
  }
  
  public void b(n paramn, String paramString)
  {
    AppMethodBeat.i(90848);
    if ((this.byM instanceof a)) {
      ((a)this.byM).b(paramn, paramString);
    }
    AppMethodBeat.o(90848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.d.n.a
 * JD-Core Version:    0.7.0.1
 */