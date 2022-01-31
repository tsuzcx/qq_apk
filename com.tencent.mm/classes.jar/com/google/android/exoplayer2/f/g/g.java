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
  private final f aXr;
  private final m aXs;
  private final e.a aXt;
  private final a aXu;
  private final List<d> aXv;
  
  public g()
  {
    super("WebvttDecoder");
    AppMethodBeat.i(95740);
    this.aXr = new f();
    this.aXs = new m();
    this.aXt = new e.a();
    this.aXu = new a();
    this.aXv = new ArrayList();
    AppMethodBeat.o(95740);
  }
  
  private static int G(m paramm)
  {
    AppMethodBeat.i(95741);
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
    AppMethodBeat.o(95741);
    return i;
  }
  
  private static void H(m paramm)
  {
    AppMethodBeat.i(95742);
    while (!TextUtils.isEmpty(paramm.readLine())) {}
    AppMethodBeat.o(95742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.g
 * JD-Core Version:    0.7.0.1
 */