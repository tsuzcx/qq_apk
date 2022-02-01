package com.google.android.exoplayer2.f.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends b
{
  private final f bDJ;
  private final m bDK;
  private final e.a bDL;
  private final a bDM;
  private final List<d> bDN;
  
  public g()
  {
    super("WebvttDecoder");
    AppMethodBeat.i(92908);
    this.bDJ = new f();
    this.bDK = new m();
    this.bDL = new e.a();
    this.bDM = new a();
    this.bDN = new ArrayList();
    AppMethodBeat.o(92908);
  }
  
  private static int G(m paramm)
  {
    AppMethodBeat.i(92909);
    int j = 0;
    int i = -1;
    while (i == -1)
    {
      j = paramm.position;
      String str = paramm.readLine();
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
    paramm.setPosition(j);
    AppMethodBeat.o(92909);
    return i;
  }
  
  private static void H(m paramm)
  {
    AppMethodBeat.i(92910);
    while (!TextUtils.isEmpty(paramm.readLine())) {}
    AppMethodBeat.o(92910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.g
 * JD-Core Version:    0.7.0.1
 */