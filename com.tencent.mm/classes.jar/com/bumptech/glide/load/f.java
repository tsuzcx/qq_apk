package com.bumptech.glide.load;

import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.d.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.List;

public final class f
{
  public static ImageHeaderParser.ImageType a(List<ImageHeaderParser> paramList, InputStream paramInputStream, b paramb)
  {
    AppMethodBeat.i(76846);
    if (paramInputStream == null)
    {
      paramList = ImageHeaderParser.ImageType.UNKNOWN;
      AppMethodBeat.o(76846);
      return paramList;
    }
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      localObject = new n(paramInputStream, paramb);
    }
    ((InputStream)localObject).mark(5242880);
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        paramInputStream = (ImageHeaderParser)paramList.get(i);
      }
      try
      {
        paramInputStream = paramInputStream.c((InputStream)localObject);
        paramb = ImageHeaderParser.ImageType.UNKNOWN;
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
  
  public static int b(List<ImageHeaderParser> paramList, InputStream paramInputStream, b paramb)
  {
    AppMethodBeat.i(76847);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(76847);
      return -1;
    }
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      localObject = new n(paramInputStream, paramb);
    }
    ((InputStream)localObject).mark(5242880);
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        paramInputStream = (ImageHeaderParser)paramList.get(i);
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
 * Qualified Name:     com.bumptech.glide.load.f
 * JD-Core Version:    0.7.0.1
 */