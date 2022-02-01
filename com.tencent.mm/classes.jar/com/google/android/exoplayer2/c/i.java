package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i
{
  public static final a.a aRA;
  private static final Pattern aRB;
  public int aNa = -1;
  public int aNb = -1;
  
  static
  {
    AppMethodBeat.i(91998);
    aRA = new a.a()
    {
      public final boolean g(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5)
      {
        return (paramAnonymousInt2 == 67) && (paramAnonymousInt3 == 79) && (paramAnonymousInt4 == 77) && ((paramAnonymousInt5 == 77) || (paramAnonymousInt1 == 2));
      }
    };
    aRB = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    AppMethodBeat.o(91998);
  }
  
  private boolean m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(91997);
    if (!"iTunSMPB".equals(paramString1))
    {
      AppMethodBeat.o(91997);
      return false;
    }
    paramString1 = aRB.matcher(paramString2);
    if (paramString1.find()) {
      try
      {
        int i = Integer.parseInt(paramString1.group(1), 16);
        int j = Integer.parseInt(paramString1.group(2), 16);
        if ((i > 0) || (j > 0))
        {
          this.aNa = i;
          this.aNb = j;
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
    while (i < paramMetadata.bdA.length)
    {
      Object localObject = paramMetadata.bdA[i];
      if ((localObject instanceof CommentFrame))
      {
        localObject = (CommentFrame)localObject;
        if (m(((CommentFrame)localObject).description, ((CommentFrame)localObject).text))
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
  
  public final boolean su()
  {
    return (this.aNa != -1) && (this.aNb != -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.i
 * JD-Core Version:    0.7.0.1
 */