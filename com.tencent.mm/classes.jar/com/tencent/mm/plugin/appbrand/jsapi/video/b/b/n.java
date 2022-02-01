package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.i;
import java.util.List;
import java.util.Map;

public final class n
  extends j
{
  private static int kpm = 3;
  private static boolean kpn;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n kpf;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.e kpo;
  private int kpp;
  private String uuid;
  
  public n(String paramString, i<String> parami, s params, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.e parame, com.tencent.mm.plugin.appbrand.jsapi.video.b.e.e<Map<String, List<String>>> parame1, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n paramn)
  {
    super(paramString, parami, params, true, parame1);
    AppMethodBeat.i(193904);
    this.kpp = 0;
    this.kpo = parame;
    this.kpf = paramn;
    if (!kpn)
    {
      kpm = a.bcR().kon;
      kpn = true;
    }
    AppMethodBeat.o(193904);
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, l.a parama)
  {
    AppMethodBeat.i(193908);
    h.log(4, EE(), "read source error occurred " + parama.toString());
    this.kpp += 1;
    long l1 = this.kou.position + this.bxl;
    int i = this.kpp * 2000;
    h.log(4, EE(), "retrying after " + i + " ms, read start at offset " + l1 + " retry " + this.kpp + "/" + kpm);
    long l2 = i;
    g localg;
    try
    {
      Thread.sleep(l2);
      localg = new g(Uri.parse(getUri()), 0L, l1, -1L, null, 0, this.uuid, this.kou.priority);
      if ((Thread.currentThread().isInterrupted()) || (this.kpp >= kpm)) {
        break label306;
      }
      if (this.kpf.sg(1))
      {
        h.log(4, EE(), "abort retry videoRequest is cancelling " + this.kpf);
        paramArrayOfByte = new l.c("readRetry interrupted " + this.kpf, this.kou);
        AppMethodBeat.o(193908);
        throw paramArrayOfByte;
      }
    }
    catch (InterruptedException paramArrayOfByte)
    {
      h.log(5, EE(), "readRetry interrupted");
      AppMethodBeat.o(193908);
      throw parama;
    }
    a(localg);
    paramInt1 = read(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(193908);
    return paramInt1;
    label306:
    AppMethodBeat.o(193908);
    throw parama;
  }
  
  private long a(g paramg, l.a parama)
  {
    AppMethodBeat.i(193906);
    int i = 0;
    if ((parama instanceof l.f)) {
      i = ((l.f)parama).responseCode;
    }
    Object localObject1 = paramg.uri.toString();
    h.log(4, EE(), "retryOpen url=" + (String)localObject1 + " with responseCode=" + i);
    i = 0;
    Object localObject3;
    if ((!Thread.currentThread().isInterrupted()) && (i < kpm)) {
      if (this.kpo != null)
      {
        localObject3 = this.kpo.bcZ();
        h.log(4, EE(), "retryCount=" + i + " retryUrl=" + (String)localObject3);
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label458;
        }
        localObject3 = localObject1;
      }
    }
    label451:
    label458:
    for (;;)
    {
      if (((String)localObject3).equals(localObject1)) {
        h.log(5, EE(), "retryUrl is same as origin url");
      }
      i += 1;
      int j = i * 2000;
      h.log(4, EE(), "retry open retrying after " + j + " seconds  retry " + i + "/" + kpm);
      long l = j;
      try
      {
        Thread.sleep(l);
        localObject1 = new g(Uri.parse((String)localObject3), paramg.bwz, paramg.position, paramg.length, paramg.key, paramg.flags, paramg.uuid, paramg.priority);
      }
      catch (InterruptedException paramg)
      {
        Thread.currentThread().interrupt();
        paramg = new l.b("retry open interrupted " + this.kpf, this.kou);
        AppMethodBeat.o(193906);
        throw paramg;
      }
      try
      {
        l = super.b((g)localObject1);
        AppMethodBeat.o(193906);
        return l;
      }
      catch (l.a locala)
      {
        if ((this.kpf == null) || (!this.kpf.sg(1))) {
          break label451;
        }
        h.log(4, EE(), "abort retryOpen videoRequest is cancelling " + this.kpf + ", reason=" + h.h(locala));
        paramg = new l.b("retry open interrupted " + this.kpf, this.kou);
        AppMethodBeat.o(193906);
        throw paramg;
        Object localObject2 = localObject3;
      }
      h.log(4, EE(), "httpRetryLogic is null");
      AppMethodBeat.o(193906);
      throw parama;
      break;
    }
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(193905);
    this.uuid = paramg.uuid;
    long l;
    try
    {
      l = super.a(paramg);
      AppMethodBeat.o(193905);
      return l;
    }
    catch (l.a locala)
    {
      l = a(paramg, locala);
      AppMethodBeat.o(193905);
    }
    return l;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193907);
    try
    {
      int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(193907);
      return i;
    }
    catch (l.a locala)
    {
      paramInt1 = a(paramArrayOfByte, paramInt1, paramInt2, locala);
      AppMethodBeat.o(193907);
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.n
 * JD-Core Version:    0.7.0.1
 */