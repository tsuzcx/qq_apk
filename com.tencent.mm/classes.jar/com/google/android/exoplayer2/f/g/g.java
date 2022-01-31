package com.google.android.exoplayer2.f.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.i.j;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends b
{
  private final f aPX = new f();
  private final j aPY = new j();
  private final e.a aPZ = new e.a();
  private final a aQa = new a();
  private final List<d> aQb = new ArrayList();
  
  public g()
  {
    super("WebvttDecoder");
  }
  
  private static int i(j paramj)
  {
    int j = 0;
    int i = -1;
    while (i == -1)
    {
      j = paramj.position;
      String str = paramj.readLine();
      if (str == null) {
        i = 0;
      } else if ("STYLE".equals(str)) {
        i = 2;
      } else if ("NOTE".startsWith(str)) {
        i = 1;
      } else {
        i = 3;
      }
    }
    paramj.setPosition(j);
    return i;
  }
  
  private static void j(j paramj)
  {
    while (!TextUtils.isEmpty(paramj.readLine())) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.g
 * JD-Core Version:    0.7.0.1
 */