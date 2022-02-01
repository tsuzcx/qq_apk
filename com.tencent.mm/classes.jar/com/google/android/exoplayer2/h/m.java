package com.google.android.exoplayer2.h;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class m
  implements g
{
  private g aRo;
  private final g boN;
  private g boO;
  private g boP;
  private g boQ;
  private g boR;
  private final w<? super g> bol;
  private final Context context;
  
  public m(Context paramContext, w<? super g> paramw, g paramg)
  {
    AppMethodBeat.i(93059);
    this.context = paramContext.getApplicationContext();
    this.bol = paramw;
    this.boN = ((g)a.checkNotNull(paramg));
    AppMethodBeat.o(93059);
  }
  
  private g uK()
  {
    AppMethodBeat.i(93064);
    if (this.boP == null) {
      this.boP = new c(this.context, this.bol);
    }
    g localg = this.boP;
    AppMethodBeat.o(93064);
    return localg;
  }
  
  private g uL()
  {
    AppMethodBeat.i(93065);
    if (this.boR == null) {}
    try
    {
      this.boR = ((g)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      label38:
      if (this.boR == null) {
        this.boR = this.boN;
      }
      g localg = this.boR;
      AppMethodBeat.o(93065);
      return localg;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label38;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label38;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label38;
    }
    catch (InstantiationException localInstantiationException)
    {
      break label38;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label38;
    }
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(93060);
    boolean bool;
    String str;
    if (this.aRo == null)
    {
      bool = true;
      a.checkState(bool);
      str = paramj.uri.getScheme();
      if (!x.f(paramj.uri)) {
        break label116;
      }
      if (!paramj.uri.getPath().startsWith("/android_asset/")) {
        break label83;
      }
      this.aRo = uK();
    }
    for (;;)
    {
      long l = this.aRo.a(paramj);
      AppMethodBeat.o(93060);
      return l;
      bool = false;
      break;
      label83:
      if (this.boO == null) {
        this.boO = new q(this.bol);
      }
      this.aRo = this.boO;
      continue;
      label116:
      if ("asset".equals(str))
      {
        this.aRo = uK();
      }
      else if ("content".equals(str))
      {
        if (this.boQ == null) {
          this.boQ = new e(this.context, this.bol);
        }
        this.aRo = this.boQ;
      }
      else if ("rtmp".equals(str))
      {
        this.aRo = uL();
      }
      else
      {
        this.aRo = this.boN;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93063);
    if (this.aRo != null) {
      try
      {
        this.aRo.close();
        return;
      }
      finally
      {
        this.aRo = null;
        AppMethodBeat.o(93063);
      }
    }
    AppMethodBeat.o(93063);
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(93062);
    if (this.aRo == null)
    {
      AppMethodBeat.o(93062);
      return null;
    }
    Uri localUri = this.aRo.getUri();
    AppMethodBeat.o(93062);
    return localUri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93061);
    paramInt1 = this.aRo.read(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93061);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.m
 * JD-Core Version:    0.7.0.1
 */