package com.tencent.mm.plugin.emoji.magicemoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static final a.b xiO;
  private static final a.b xiQ;
  private static final a.b xiR;
  public static final List<a.b> xiS;
  public static a.b xiT;
  
  static
  {
    AppMethodBeat.i(258020);
    xiO = new a.b("wx2690c73c8ea361df", "gh_487599f74952@app", 2);
    xiQ = new a.b("wxee05a56a82581763", "gh_d01293fea884@app", 2);
    xiR = new a.b("wx9d5f7f0bf2dc950c", "gh_2ae1569f5edf@app", 0);
    ArrayList localArrayList = new ArrayList(2);
    xiS = localArrayList;
    localArrayList.add(xiQ);
    xiS.add(xiR);
    Log.i("MicroMsg.ConstantsMagicEmoji", "hy: using test mode: %b", new Object[] { Boolean.FALSE });
    xiT = xiR;
    AppMethodBeat.o(258020);
  }
  
  public static boolean a(a.a parama)
  {
    return (parama == a.a.qYz) || (parama == a.a.qYA) || (parama == a.a.qYB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.b.a
 * JD-Core Version:    0.7.0.1
 */