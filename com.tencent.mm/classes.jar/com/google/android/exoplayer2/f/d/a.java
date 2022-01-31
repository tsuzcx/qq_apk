package com.google.android.exoplayer2.f.d;

import android.text.Html;
import android.text.TextUtils;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.j;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends com.google.android.exoplayer2.f.b
{
  private static final Pattern aOO = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
  private final StringBuilder aOP = new StringBuilder();
  
  public a()
  {
    super("SubripDecoder");
  }
  
  private static long a(Matcher paramMatcher, int paramInt)
  {
    return (Long.parseLong(paramMatcher.group(paramInt + 1)) * 60L * 60L * 1000L + Long.parseLong(paramMatcher.group(paramInt + 2)) * 60L * 1000L + Long.parseLong(paramMatcher.group(paramInt + 3)) * 1000L + Long.parseLong(paramMatcher.group(paramInt + 4))) * 1000L;
  }
  
  private b g(byte[] paramArrayOfByte, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    e locale = new e();
    paramArrayOfByte = new j(paramArrayOfByte, paramInt);
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
          localObject = aOO.matcher((CharSequence)localObject);
          if (!((Matcher)localObject).matches()) {
            break;
          }
          locale.add(a((Matcher)localObject, 1));
          if (TextUtils.isEmpty(((Matcher)localObject).group(6))) {
            break label245;
          }
          locale.add(a((Matcher)localObject, 6));
          paramInt = 1;
          this.aOP.setLength(0);
          localObject = paramArrayOfByte.readLine();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if (this.aOP.length() > 0) {
              this.aOP.append("<br>");
            }
            this.aOP.append(((String)localObject).trim());
            continue;
          }
          localArrayList.add(new com.google.android.exoplayer2.f.a(Html.fromHtml(this.aOP.toString())));
          if (paramInt == 0) {
            break;
          }
          localArrayList.add(null);
          break;
        }
        paramArrayOfByte = new com.google.android.exoplayer2.f.a[localArrayList.size()];
        localArrayList.toArray(paramArrayOfByte);
        return new b(paramArrayOfByte, locale.toArray());
      }
      catch (NumberFormatException localNumberFormatException) {}
      break;
      label245:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.f.d.a
 * JD-Core Version:    0.7.0.1
 */