package com.google.android.exoplayer2.f.d;

import android.text.Html;
import android.text.TextUtils;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends com.google.android.exoplayer2.f.b
{
  private static final Pattern bum;
  private final StringBuilder bun;
  
  static
  {
    AppMethodBeat.i(92818);
    bum = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    AppMethodBeat.o(92818);
  }
  
  public a()
  {
    super("SubripDecoder");
    AppMethodBeat.i(92814);
    this.bun = new StringBuilder();
    AppMethodBeat.o(92814);
  }
  
  private static long a(Matcher paramMatcher, int paramInt)
  {
    AppMethodBeat.i(92816);
    long l1 = Long.parseLong(paramMatcher.group(paramInt + 1));
    long l2 = Long.parseLong(paramMatcher.group(paramInt + 2));
    long l3 = Long.parseLong(paramMatcher.group(paramInt + 3));
    long l4 = Long.parseLong(paramMatcher.group(paramInt + 4));
    AppMethodBeat.o(92816);
    return (l1 * 60L * 60L * 1000L + l2 * 60L * 1000L + l3 * 1000L + l4) * 1000L;
  }
  
  private b h(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92815);
    ArrayList localArrayList = new ArrayList();
    h localh = new h();
    paramArrayOfByte = new m(paramArrayOfByte, paramInt);
    Object localObject;
    do
    {
      localObject = paramArrayOfByte.readLine();
    } while ((localObject != null) && (((String)localObject).length() == 0));
    for (;;)
    {
      try
      {
        Integer.parseInt((String)localObject);
        localObject = paramArrayOfByte.readLine();
        if (localObject != null)
        {
          localObject = bum.matcher((CharSequence)localObject);
          if (!((Matcher)localObject).matches()) {
            break;
          }
          localh.add(a((Matcher)localObject, 1));
          if (TextUtils.isEmpty(((Matcher)localObject).group(6))) {
            break label257;
          }
          localh.add(a((Matcher)localObject, 6));
          paramInt = 1;
          this.bun.setLength(0);
          localObject = paramArrayOfByte.readLine();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if (this.bun.length() > 0) {
              this.bun.append("<br>");
            }
            this.bun.append(((String)localObject).trim());
            continue;
          }
          localArrayList.add(new com.google.android.exoplayer2.f.a(Html.fromHtml(this.bun.toString())));
          if (paramInt == 0) {
            break;
          }
          localArrayList.add(null);
          break;
        }
        paramArrayOfByte = new com.google.android.exoplayer2.f.a[localArrayList.size()];
        localArrayList.toArray(paramArrayOfByte);
        paramArrayOfByte = new b(paramArrayOfByte, localh.toArray());
        AppMethodBeat.o(92815);
        return paramArrayOfByte;
      }
      catch (NumberFormatException localNumberFormatException) {}
      break;
      label257:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.d.a
 * JD-Core Version:    0.7.0.1
 */