package com.tencent.luggage.d;

import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.bridge.p;
import com.tencent.luggage.webview.a.a;
import com.tencent.luggage.webview.a.b;
import com.tencent.luggage.webview.a.d;
import com.tencent.luggage.webview.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class k$4
  implements a.a
{
  private boolean bzq = false;
  
  k$4(k paramk) {}
  
  public final WebResourceResponse a(WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(90820);
    if (this.bzn.bze != null)
    {
      paramBundle = this.bzn.bze.a(paramWebResourceRequest, paramBundle);
      if (paramBundle != null)
      {
        AppMethodBeat.o(90820);
        return paramBundle;
      }
    }
    paramWebResourceRequest = this.bzn.bzi.cj(paramWebResourceRequest.getUrl().toString());
    AppMethodBeat.o(90820);
    return paramWebResourceRequest;
  }
  
  public final boolean bD(String paramString)
  {
    AppMethodBeat.i(90816);
    Iterator localIterator = this.bzn.bzj.bFK.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Pair)localIterator.next();
      e locale = (e)((Pair)localObject).first;
      localObject = (Pattern)((Pair)localObject).second;
      if ((localObject != null) && (((Pattern)localObject).matcher(paramString).matches()))
      {
        boolean bool = locale.xe();
        AppMethodBeat.o(90816);
        return bool;
      }
    }
    AppMethodBeat.o(90816);
    return false;
  }
  
  public final void bE(String paramString)
  {
    AppMethodBeat.i(90817);
    this.bzq = false;
    this.bzn.mUrl = paramString;
    this.bzn.byf.byn.tW();
    if (this.bzn.bze != null) {
      this.bzn.bze.bE(paramString);
    }
    AppMethodBeat.o(90817);
  }
  
  public final void bF(String paramString)
  {
    AppMethodBeat.i(90818);
    this.bzn.mUrl = paramString;
    this.bzn.byf.byn.onReady();
    if (this.bzn.bze != null)
    {
      this.bzn.byf.bw(this.bzn.bze.ux());
      this.bzn.bze.bF(paramString);
    }
    AppMethodBeat.o(90818);
  }
  
  public final WebResourceResponse bG(String paramString)
  {
    AppMethodBeat.i(90819);
    paramString = this.bzn.bzi.cj(paramString);
    AppMethodBeat.o(90819);
    return paramString;
  }
  
  public final String bH(String paramString)
  {
    AppMethodBeat.i(90821);
    paramString = this.bzn.byf.byn.bx(paramString);
    AppMethodBeat.o(90821);
    return paramString;
  }
  
  public final void bI(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(90822);
    if (!this.bzq)
    {
      int i = j;
      if (paramString != null)
      {
        if (paramString.length() != 0) {
          break label39;
        }
        i = j;
      }
      while (i != 0)
      {
        AppMethodBeat.o(90822);
        return;
        label39:
        paramString = Uri.parse(paramString).getPath();
        i = j;
        if (paramString != null)
        {
          i = j;
          if (paramString.trim().endsWith("html")) {
            i = 1;
          }
        }
      }
      this.bzn.byf.byn.onReady();
      if (this.bzn.bze != null) {
        this.bzn.byf.bw(this.bzn.bze.ux());
      }
      this.bzq = true;
    }
    AppMethodBeat.o(90822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.d.k.4
 * JD-Core Version:    0.7.0.1
 */