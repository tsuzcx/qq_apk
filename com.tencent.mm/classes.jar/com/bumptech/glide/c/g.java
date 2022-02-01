package com.bumptech.glide.c;

import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.d.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.List;

public final class g
{
  public static f.a a(List<f> paramList, InputStream paramInputStream, b paramb)
  {
    AppMethodBeat.i(76846);
    if (paramInputStream == null)
    {
      paramList = f.a.aCt;
      AppMethodBeat.o(76846);
      return paramList;
    }
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      localObject = new m(paramInputStream, paramb);
    }
    ((InputStream)localObject).mark(5242880);
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        paramInputStream = (f)paramList.get(i);
      }
      try
      {
        paramInputStream = paramInputStream.c((InputStream)localObject);
        paramb = f.a.aCt;
        if (paramInputStream != paramb) {
          return paramInputStream;
        }
        ((InputStream)localObject).reset();
        i += 1;
      }
      finally
      {
        ((InputStream)localObject).reset();
        AppMethodBeat.o(76846);
      }
    }
    return paramList;
  }
  
  public static int b(List<f> paramList, InputStream paramInputStream, b paramb)
  {
    AppMethodBeat.i(76847);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(76847);
      return -1;
    }
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      localObject = new m(paramInputStream, paramb);
    }
    ((InputStream)localObject).mark(5242880);
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        paramInputStream = (f)paramList.get(i);
      }
      try
      {
        int k = paramInputStream.a((InputStream)localObject, paramb);
        if (k != -1) {
          return k;
        }
        ((InputStream)localObject).reset();
        i += 1;
      }
      finally
      {
        ((InputStream)localObject).reset();
        AppMethodBeat.o(76847);
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.g
 * JD-Core Version:    0.7.0.1
 */