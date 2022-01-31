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
  private g aBo;
  private final g aYT;
  private g aYU;
  private g aYV;
  private g aYW;
  private g aYX;
  private final w<? super g> aYq;
  private final Context context;
  
  public m(Context paramContext, w<? super g> paramw, g paramg)
  {
    AppMethodBeat.i(95816);
    this.context = paramContext.getApplicationContext();
    this.aYq = paramw;
    this.aYT = ((g)a.checkNotNull(paramg));
    AppMethodBeat.o(95816);
  }
  
  private g qs()
  {
    AppMethodBeat.i(95821);
    if (this.aYV == null) {
      this.aYV = new c(this.context, this.aYq);
    }
    g localg = this.aYV;
    AppMethodBeat.o(95821);
    return localg;
  }
  
  private g qt()
  {
    AppMethodBeat.i(95822);
    if (this.aYX == null) {}
    try
    {
      this.aYX = ((g)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      label38:
      if (this.aYX == null) {
        this.aYX = this.aYT;
      }
      g localg = this.aYX;
      AppMethodBeat.o(95822);
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
    AppMethodBeat.i(95817);
    boolean bool;
    String str;
    if (this.aBo == null)
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
      this.aBo = qs();
    }
    for (;;)
    {
      long l = this.aBo.a(paramj);
      AppMethodBeat.o(95817);
      return l;
      bool = false;
      break;
      label83:
      if (this.aYU == null) {
        this.aYU = new q(this.aYq);
      }
      this.aBo = this.aYU;
      continue;
      label116:
      if ("asset".equals(str))
      {
        this.aBo = qs();
      }
      else if ("content".equals(str))
      {
        if (this.aYW == null) {
          this.aYW = new e(this.context, this.aYq);
        }
        this.aBo = this.aYW;
      }
      else if ("rtmp".equals(str))
      {
        this.aBo = qt();
      }
      else
      {
        this.aBo = this.aYT;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(95820);
    if (this.aBo != null) {
      try
      {
        this.aBo.close();
        return;
      }
      finally
      {
        this.aBo = null;
        AppMethodBeat.o(95820);
      }
    }
    AppMethodBeat.o(95820);
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(95819);
    if (this.aBo == null)
    {
      AppMethodBeat.o(95819);
      return null;
    }
    Uri localUri = this.aBo.getUri();
    AppMethodBeat.o(95819);
    return localUri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95818);
    paramInt1 = this.aBo.read(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(95818);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.h.m
 * JD-Core Version:    0.7.0.1
 */