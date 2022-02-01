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
  private final w<? super g> bEI;
  private final g bFk;
  private g bFl;
  private g bFm;
  private g bFn;
  private g bFo;
  private g bhK;
  private final Context context;
  
  public m(Context paramContext, w<? super g> paramw, g paramg)
  {
    AppMethodBeat.i(93059);
    this.context = paramContext.getApplicationContext();
    this.bEI = paramw;
    this.bFk = ((g)a.checkNotNull(paramg));
    AppMethodBeat.o(93059);
  }
  
  private g wJ()
  {
    AppMethodBeat.i(93064);
    if (this.bFm == null) {
      this.bFm = new c(this.context, this.bEI);
    }
    g localg = this.bFm;
    AppMethodBeat.o(93064);
    return localg;
  }
  
  private g wK()
  {
    AppMethodBeat.i(93065);
    if (this.bFo == null) {}
    try
    {
      this.bFo = ((g)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      label38:
      if (this.bFo == null) {
        this.bFo = this.bFk;
      }
      g localg = this.bFo;
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
    if (this.bhK == null)
    {
      bool = true;
      a.checkState(bool);
      str = paramj.uri.getScheme();
      if (!x.o(paramj.uri)) {
        break label116;
      }
      if (!paramj.uri.getPath().startsWith("/android_asset/")) {
        break label83;
      }
      this.bhK = wJ();
    }
    for (;;)
    {
      long l = this.bhK.a(paramj);
      AppMethodBeat.o(93060);
      return l;
      bool = false;
      break;
      label83:
      if (this.bFl == null) {
        this.bFl = new q(this.bEI);
      }
      this.bhK = this.bFl;
      continue;
      label116:
      if ("asset".equals(str))
      {
        this.bhK = wJ();
      }
      else if ("content".equals(str))
      {
        if (this.bFn == null) {
          this.bFn = new e(this.context, this.bEI);
        }
        this.bhK = this.bFn;
      }
      else if ("rtmp".equals(str))
      {
        this.bhK = wK();
      }
      else
      {
        this.bhK = this.bFk;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93063);
    if (this.bhK != null) {
      try
      {
        this.bhK.close();
        return;
      }
      finally
      {
        this.bhK = null;
        AppMethodBeat.o(93063);
      }
    }
    AppMethodBeat.o(93063);
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(93062);
    if (this.bhK == null)
    {
      AppMethodBeat.o(93062);
      return null;
    }
    Uri localUri = this.bhK.getUri();
    AppMethodBeat.o(93062);
    return localUri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93061);
    paramInt1 = this.bhK.read(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93061);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.h.m
 * JD-Core Version:    0.7.0.1
 */