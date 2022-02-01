package com.appaac.haptic.sync;

import com.appaac.haptic.a.g;
import com.appaac.haptic.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public boolean DEBUG;
  private String crF;
  private com.appaac.haptic.c.a crP;
  private long csa;
  private JSONArray csb;
  private JSONObject csc;
  private com.appaac.haptic.b.c.a csd;
  
  public b(String paramString, com.appaac.haptic.c.a parama)
  {
    AppMethodBeat.i(208364);
    this.DEBUG = false;
    this.csa = -1L;
    this.csb = null;
    this.csc = null;
    for (;;)
    {
      try
      {
        this.crF = paramString;
        paramString = new JSONObject(paramString);
      }
      catch (Exception paramString)
      {
        paramString.getMessage();
        continue;
      }
      try
      {
        this.csc = paramString.getJSONObject("Pattern");
        this.crP = parama;
        if ((this.crP.crJ > 0) && (this.crP.crI != null))
        {
          paramString = g.n(this.crP.crF, this.crP.crJ);
          if ((paramString != null) && (paramString.length() > 0)) {
            this.csd = g.bf(g.n(this.crP.crF, this.crP.crJ));
          }
          if (com.appaac.haptic.c.a.a(this.csd)) {
            ((com.appaac.haptic.b.c.c)this.csd.crD.get(0)).crE = this.crP.crJ;
          }
        }
        AppMethodBeat.o(208364);
        return;
      }
      catch (JSONException localJSONException)
      {
        this.csb = paramString.getJSONArray("PatternList");
      }
    }
  }
  
  /* Error */
  public final long NA()
  {
    // Byte code:
    //   0: ldc 126
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 44	com/appaac/haptic/sync/b:csc	Lorg/json/JSONObject;
    //   9: ifnull +12 -> 21
    //   12: ldc 126
    //   14: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: ldc2_w 37
    //   20: lreturn
    //   21: aload_0
    //   22: getfield 42	com/appaac/haptic/sync/b:csb	Lorg/json/JSONArray;
    //   25: ifnull +89 -> 114
    //   28: aload_0
    //   29: getfield 42	com/appaac/haptic/sync/b:csb	Lorg/json/JSONArray;
    //   32: invokevirtual 129	org/json/JSONArray:length	()I
    //   35: istore_2
    //   36: iconst_0
    //   37: istore_1
    //   38: iload_1
    //   39: iload_2
    //   40: if_icmpge +74 -> 114
    //   43: aload_0
    //   44: getfield 42	com/appaac/haptic/sync/b:csb	Lorg/json/JSONArray;
    //   47: iload_1
    //   48: invokevirtual 132	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   51: astore 7
    //   53: aload 7
    //   55: ldc 134
    //   57: invokevirtual 138	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   60: lstore_3
    //   61: aload_0
    //   62: getfield 40	com/appaac/haptic/sync/b:csa	J
    //   65: lstore 5
    //   67: lload 5
    //   69: lload_3
    //   70: lcmp
    //   71: ifge +28 -> 99
    //   74: ldc 126
    //   76: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: lload_3
    //   80: lreturn
    //   81: astore 8
    //   83: aload 7
    //   85: ldc 140
    //   87: invokevirtual 57	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   90: ldc 134
    //   92: invokevirtual 138	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   95: lstore_3
    //   96: goto -35 -> 61
    //   99: iload_1
    //   100: iconst_1
    //   101: iadd
    //   102: istore_1
    //   103: goto -65 -> 38
    //   106: astore 7
    //   108: aload 7
    //   110: invokevirtual 141	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   113: pop
    //   114: ldc 126
    //   116: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: ldc2_w 37
    //   122: lreturn
    //   123: astore 7
    //   125: aload 7
    //   127: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: pop
    //   131: goto -17 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	b
    //   37	66	1	i	int
    //   35	6	2	j	int
    //   60	36	3	l1	long
    //   65	3	5	l2	long
    //   51	33	7	localJSONObject	JSONObject
    //   106	3	7	localJSONException1	JSONException
    //   123	3	7	localException	Exception
    //   81	1	8	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   53	61	81	org/json/JSONException
    //   21	36	106	org/json/JSONException
    //   43	53	106	org/json/JSONException
    //   61	67	106	org/json/JSONException
    //   83	96	106	org/json/JSONException
    //   21	36	123	java/lang/Exception
    //   43	53	123	java/lang/Exception
    //   53	61	123	java/lang/Exception
    //   61	67	123	java/lang/Exception
    //   83	96	123	java/lang/Exception
  }
  
  public final int NB()
  {
    int k = 0;
    AppMethodBeat.i(208383);
    int j;
    int m;
    Object localObject;
    int i;
    if ((-1L == NA()) && (com.appaac.haptic.c.a.a(this.csd)) && (1 == g.c(this.csd)))
    {
      j = 1;
      m = g.bd(this.crF);
      if (1 != m) {
        break label93;
      }
      localObject = g.be(this.crF);
      i = k;
      if (com.appaac.haptic.c.a.a((com.appaac.haptic.b.a.c)localObject)) {
        i = ((com.appaac.haptic.b.b.a)localObject).getDuration();
      }
    }
    label93:
    do
    {
      do
      {
        AppMethodBeat.o(208383);
        return i;
        j = 0;
        break;
        i = k;
      } while (2 != m);
      if (j == 0) {
        break label271;
      }
      new StringBuilder("Utils.getHe20PatternCount(mRemainderHe20):").append(g.c(this.csd)).append("\n getNextScheduledTimeMs():").append(NA()).append("\n mRemainderHe20:").append(g.a(this.csd));
      localObject = this.csd;
      i = k;
    } while (!com.appaac.haptic.c.a.a((com.appaac.haptic.b.a.c)localObject));
    for (;;)
    {
      try
      {
        label158:
        localObject = ((com.appaac.haptic.b.c.c)((com.appaac.haptic.b.c.a)localObject).crD.get(((com.appaac.haptic.b.c.a)localObject).crD.size() - 1)).cry.iterator();
        i = 0;
        if (((Iterator)localObject).hasNext())
        {
          e locale = (e)((Iterator)localObject).next();
          if (locale.crw.crp.equals("continuous"))
          {
            j = locale.crw.crq;
            m = locale.crw.crr;
            j = m + j;
            if (j <= i) {
              break label310;
            }
            i = j;
            continue;
            label271:
            localObject = g.bf(this.crF);
            break label158;
          }
          j = locale.crw.crq;
          j += 22;
          continue;
        }
      }
      catch (Exception localException)
      {
        i = k;
      }
      break;
      label310:
      j = i;
    }
  }
  
  public final VibrationPattern bE(long paramLong)
  {
    AppMethodBeat.i(208377);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(208377);
      return null;
    }
    this.csa = paramLong;
    Object localObject;
    if ((this.csc != null) && (this.csb == null))
    {
      localObject = new VibrationPattern("\"Pattern\":" + this.csc.toString());
      AppMethodBeat.o(208377);
      return localObject;
    }
    if (this.csb != null)
    {
      if ((this.crP != null) && (this.crP.crJ > 0) && (com.appaac.haptic.c.a.a(this.csd)) && (((com.appaac.haptic.b.c.c)this.csd.crD.get(0)).crE >= paramLong))
      {
        localObject = g.b(this.csd);
        AppMethodBeat.o(208377);
        return localObject;
      }
      int j = this.csb.length();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          localObject = this.csb.getJSONObject(i);
          try
          {
            l = ((JSONObject)localObject).getLong("AbsoluteTime");
            if (paramLong >= l) {
              i += 1;
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              long l = ((JSONObject)localObject).getJSONObject("PatternDesc").getLong("AbsoluteTime");
            }
          }
        }
      }
      if (i > 0)
      {
        localObject = this.csb.getJSONObject(i - 1).getJSONArray("Pattern");
        localObject = new VibrationPattern("\"Pattern\":" + ((JSONArray)localObject).toString());
        AppMethodBeat.o(208377);
        return localObject;
      }
    }
    AppMethodBeat.o(208377);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.sync.b
 * JD-Core Version:    0.7.0.1
 */