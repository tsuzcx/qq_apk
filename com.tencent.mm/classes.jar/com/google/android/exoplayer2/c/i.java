package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i
{
  public static final a.a bhW;
  private static final Pattern bhX;
  public int bdA = -1;
  public int bdB = -1;
  
  static
  {
    AppMethodBeat.i(91998);
    bhW = new a.a()
    {
      public final boolean g(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5)
      {
        return (paramAnonymousInt2 == 67) && (paramAnonymousInt3 == 79) && (paramAnonymousInt4 == 77) && ((paramAnonymousInt5 == 77) || (paramAnonymousInt1 == 2));
      }
    };
    bhX = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    AppMethodBeat.o(91998);
  }
  
  private boolean l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(91997);
    if (!"iTunSMPB".equals(paramString1))
    {
      AppMethodBeat.o(91997);
      return false;
    }
    paramString1 = bhX.matcher(paramString2);
    if (paramString1.find()) {
      try
      {
        int i = Integer.parseInt(paramString1.group(1), 16);
        int j = Integer.parseInt(paramString1.group(2), 16);
        if ((i > 0) || (j > 0))
        {
          this.bdA = i;
          this.bdB = j;
          AppMethodBeat.o(91997);
          return true;
        }
      }
      catch (NumberFormatException paramString1) {}
    }
    AppMethodBeat.o(91997);
    return false;
  }
  
  public final boolean c(Metadata paramMetadata)
  {
    AppMethodBeat.i(91996);
    int i = 0;
    while (i < paramMetadata.btX.length)
    {
      Object localObject = paramMetadata.btX[i];
      if ((localObject instanceof CommentFrame))
      {
        localObject = (CommentFrame)localObject;
        if (l(((CommentFrame)localObject).description, ((CommentFrame)localObject).text))
        {
          AppMethodBeat.o(91996);
          return true;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(91996);
    return false;
  }
  
  public final boolean uz()
  {
    return (this.bdA != -1) && (this.bdB != -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.i
 * JD-Core Version:    0.7.0.1
 */