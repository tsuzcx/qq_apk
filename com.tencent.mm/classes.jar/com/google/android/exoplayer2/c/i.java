package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i
{
  public static final a.a aBA;
  private static final Pattern aBB;
  public int awW = -1;
  public int awX = -1;
  
  static
  {
    AppMethodBeat.i(94883);
    aBA = new i.1();
    aBB = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    AppMethodBeat.o(94883);
  }
  
  private boolean l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(94882);
    if (!"iTunSMPB".equals(paramString1))
    {
      AppMethodBeat.o(94882);
      return false;
    }
    paramString1 = aBB.matcher(paramString2);
    if (paramString1.find()) {
      try
      {
        int i = Integer.parseInt(paramString1.group(1), 16);
        int j = Integer.parseInt(paramString1.group(2), 16);
        if ((i > 0) || (j > 0))
        {
          this.awW = i;
          this.awX = j;
          AppMethodBeat.o(94882);
          return true;
        }
      }
      catch (NumberFormatException paramString1) {}
    }
    AppMethodBeat.o(94882);
    return false;
  }
  
  public final boolean c(Metadata paramMetadata)
  {
    AppMethodBeat.i(94881);
    int i = 0;
    while (i < paramMetadata.aND.length)
    {
      Object localObject = paramMetadata.aND[i];
      if ((localObject instanceof CommentFrame))
      {
        localObject = (CommentFrame)localObject;
        if (l(((CommentFrame)localObject).description, ((CommentFrame)localObject).text))
        {
          AppMethodBeat.o(94881);
          return true;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(94881);
    return false;
  }
  
  public final boolean oa()
  {
    return (this.awW != -1) && (this.awX != -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.c.i
 * JD-Core Version:    0.7.0.1
 */