package com.tencent.mm.plugin.ball.a;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import java.util.HashMap;
import java.util.Map;

public final class d
  implements b
{
  public Map<Integer, b> vjp;
  
  private d()
  {
    AppMethodBeat.i(176955);
    this.vjp = new HashMap();
    AppMethodBeat.o(176955);
  }
  
  public final boolean a(Context paramContext, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(176956);
    b localb = (b)this.vjp.get(Integer.valueOf(paramBallInfo.type));
    if (localb == null)
    {
      AppMethodBeat.o(176956);
      return false;
    }
    boolean bool = localb.a(paramContext, paramBallInfo);
    AppMethodBeat.o(176956);
    return bool;
  }
  
  public final boolean a(TextView paramTextView, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(176957);
    b localb = (b)this.vjp.get(Integer.valueOf(paramBallInfo.type));
    if (localb == null)
    {
      AppMethodBeat.o(176957);
      return false;
    }
    boolean bool = localb.a(paramTextView, paramBallInfo);
    AppMethodBeat.o(176957);
    return bool;
  }
  
  public static final class a
  {
    public static d vjq;
    
    static
    {
      AppMethodBeat.i(176954);
      vjq = new d((byte)0);
      AppMethodBeat.o(176954);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.a.d
 * JD-Core Version:    0.7.0.1
 */