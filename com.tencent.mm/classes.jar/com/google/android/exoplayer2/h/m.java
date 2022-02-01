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
  private g cLk;
  private final Context context;
  private final g diD;
  private g diE;
  private g diF;
  private g diG;
  private g diH;
  private final w<? super g> did;
  
  public m(Context paramContext, w<? super g> paramw, g paramg)
  {
    AppMethodBeat.i(93059);
    this.context = paramContext.getApplicationContext();
    this.did = paramw;
    this.diD = ((g)a.checkNotNull(paramg));
    AppMethodBeat.o(93059);
  }
  
  private g Ul()
  {
    AppMethodBeat.i(93064);
    if (this.diF == null) {
      this.diF = new c(this.context, this.did);
    }
    g localg = this.diF;
    AppMethodBeat.o(93064);
    return localg;
  }
  
  private g Um()
  {
    AppMethodBeat.i(93065);
    if (this.diH == null) {}
    try
    {
      this.diH = ((g)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      label38:
      if (this.diH == null) {
        this.diH = this.diD;
      }
      g localg = this.diH;
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
    if (this.cLk == null)
    {
      bool = true;
      a.checkState(bool);
      str = paramj.uri.getScheme();
      if (!x.h(paramj.uri)) {
        break label116;
      }
      if (!paramj.uri.getPath().startsWith("/android_asset/")) {
        break label83;
      }
      this.cLk = Ul();
    }
    for (;;)
    {
      long l = this.cLk.a(paramj);
      AppMethodBeat.o(93060);
      return l;
      bool = false;
      break;
      label83:
      if (this.diE == null) {
        this.diE = new q(this.did);
      }
      this.cLk = this.diE;
      continue;
      label116:
      if ("asset".equals(str))
      {
        this.cLk = Ul();
      }
      else if ("content".equals(str))
      {
        if (this.diG == null) {
          this.diG = new e(this.context, this.did);
        }
        this.cLk = this.diG;
      }
      else if ("rtmp".equals(str))
      {
        this.cLk = Um();
      }
      else
      {
        this.cLk = this.diD;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93063);
    if (this.cLk != null) {
      try
      {
        this.cLk.close();
        return;
      }
      finally
      {
        this.cLk = null;
        AppMethodBeat.o(93063);
      }
    }
    AppMethodBeat.o(93063);
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(93062);
    if (this.cLk == null)
    {
      AppMethodBeat.o(93062);
      return null;
    }
    Uri localUri = this.cLk.getUri();
    AppMethodBeat.o(93062);
    return localUri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93061);
    paramInt1 = this.cLk.read(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93061);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.m
 * JD-Core Version:    0.7.0.1
 */