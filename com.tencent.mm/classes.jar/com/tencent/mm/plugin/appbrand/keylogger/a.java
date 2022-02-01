package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.StepLogInfo;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

public final class a
  implements IKeyStepAnalyser
{
  static List<IKeyStepAnalyser.b> by(List<IKeyStepAnalyser.StepLogInfo> paramList)
  {
    AppMethodBeat.i(201199);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    int j = 0;
    int i = 0;
    Object localObject = null;
    IKeyStepAnalyser.StepLogInfo localStepLogInfo;
    if (j < paramList.size())
    {
      localStepLogInfo = (IKeyStepAnalyser.StepLogInfo)paramList.get(j);
      ae.v("MicroMsg.KeyStepAnalyser", "sortOutResult time:%d step:%s", new Object[] { Long.valueOf(localStepLogInfo.time), localStepLogInfo.lHH });
      if (!"Start".equals(localStepLogInfo.lHH)) {
        break label377;
      }
      if (localObject != null) {
        localArrayList.add(0, localObject);
      }
      localHashMap.clear();
      localObject = new IKeyStepAnalyser.b();
      i = 0;
      localHashMap.put("Start", Long.valueOf(localStepLogInfo.time));
      label142:
      if (localObject != null)
      {
        if ("stepStart".equals(localStepLogInfo.errMsg)) {
          localHashMap.put(localStepLogInfo.lHH, Long.valueOf(localStepLogInfo.time));
        }
      }
      else
      {
        label180:
        if ((!localStepLogInfo.brm()) || (localObject == null)) {
          break label380;
        }
        if (localHashMap.containsKey("Start")) {
          localStepLogInfo.cqc = (localStepLogInfo.time - ((Long)localHashMap.get("Start")).longValue());
        }
        localArrayList.add(0, localObject);
        i = 1;
        localObject = null;
        localHashMap.clear();
      }
    }
    label377:
    label380:
    for (;;)
    {
      j += 1;
      break;
      if ("CollectKeyInfo".equals(localStepLogInfo.lHH))
      {
        String str = localStepLogInfo.lHJ;
        ((IKeyStepAnalyser.b)localObject).lHG.append(str).append("\n");
        break label180;
      }
      if (localHashMap.containsKey(localStepLogInfo.lHH)) {
        localStepLogInfo.cqc = (localStepLogInfo.time - ((Long)localHashMap.get(localStepLogInfo.lHH)).longValue());
      }
      ((IKeyStepAnalyser.b)localObject).lHF.add(localStepLogInfo);
      break label180;
      if ((i == 0) && (localObject != null)) {
        localArrayList.add(0, localObject);
      }
      AppMethodBeat.o(201199);
      return localArrayList;
      break label142;
    }
  }
  
  /* Error */
  static List<IKeyStepAnalyser.StepLogInfo> f(String paramString, Pattern paramPattern)
  {
    // Byte code:
    //   0: ldc 150
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 47
    //   7: ldc 152
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: aastore
    //   17: invokestatic 154	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: new 29	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 30	java/util/ArrayList:<init>	()V
    //   27: astore_3
    //   28: new 156	java/io/BufferedReader
    //   31: dup
    //   32: new 158	java/io/FileReader
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 161	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   40: invokespecial 164	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_2
    //   44: aload_2
    //   45: astore_0
    //   46: aload_2
    //   47: invokevirtual 168	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore 4
    //   52: aload 4
    //   54: ifnull +91 -> 145
    //   57: aload_2
    //   58: astore_0
    //   59: aload 4
    //   61: invokestatic 174	com/tencent/mm/plugin/appbrand/keylogger/c:Sl	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepAnalyser$StepLogInfo;
    //   64: astore 4
    //   66: aload 4
    //   68: ifnull -24 -> 44
    //   71: aload_2
    //   72: astore_0
    //   73: aload 4
    //   75: getfield 177	com/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepAnalyser$StepLogInfo:sessionId	Ljava/lang/String;
    //   78: ifnull -34 -> 44
    //   81: aload_2
    //   82: astore_0
    //   83: aload_1
    //   84: aload 4
    //   86: getfield 177	com/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepAnalyser$StepLogInfo:sessionId	Ljava/lang/String;
    //   89: invokevirtual 183	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   92: invokevirtual 188	java/util/regex/Matcher:matches	()Z
    //   95: ifeq -51 -> 44
    //   98: aload_2
    //   99: astore_0
    //   100: aload_3
    //   101: aload 4
    //   103: invokeinterface 189 2 0
    //   108: pop
    //   109: goto -65 -> 44
    //   112: astore_1
    //   113: aload_2
    //   114: astore_0
    //   115: ldc 47
    //   117: ldc 191
    //   119: iconst_1
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_1
    //   126: aastore
    //   127: invokestatic 194	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 197	java/io/BufferedReader:close	()V
    //   138: ldc 150
    //   140: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_3
    //   144: areturn
    //   145: aload_2
    //   146: invokevirtual 197	java/io/BufferedReader:close	()V
    //   149: goto -11 -> 138
    //   152: astore_0
    //   153: goto -15 -> 138
    //   156: astore_1
    //   157: aconst_null
    //   158: astore_2
    //   159: aload_2
    //   160: astore_0
    //   161: ldc 47
    //   163: ldc 191
    //   165: iconst_1
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_1
    //   172: aastore
    //   173: invokestatic 194	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload_2
    //   177: ifnull -39 -> 138
    //   180: aload_2
    //   181: invokevirtual 197	java/io/BufferedReader:close	()V
    //   184: goto -46 -> 138
    //   187: astore_0
    //   188: goto -50 -> 138
    //   191: astore_1
    //   192: aconst_null
    //   193: astore_0
    //   194: aload_0
    //   195: ifnull +7 -> 202
    //   198: aload_0
    //   199: invokevirtual 197	java/io/BufferedReader:close	()V
    //   202: ldc 150
    //   204: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload_1
    //   208: athrow
    //   209: astore_0
    //   210: goto -72 -> 138
    //   213: astore_0
    //   214: goto -12 -> 202
    //   217: astore_1
    //   218: goto -24 -> 194
    //   221: astore_1
    //   222: goto -63 -> 159
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_2
    //   228: goto -115 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramString	String
    //   0	231	1	paramPattern	Pattern
    //   43	185	2	localBufferedReader	java.io.BufferedReader
    //   27	117	3	localArrayList	ArrayList
    //   50	52	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   46	52	112	java/io/FileNotFoundException
    //   59	66	112	java/io/FileNotFoundException
    //   73	81	112	java/io/FileNotFoundException
    //   83	98	112	java/io/FileNotFoundException
    //   100	109	112	java/io/FileNotFoundException
    //   145	149	152	java/io/IOException
    //   28	44	156	java/io/IOException
    //   180	184	187	java/io/IOException
    //   28	44	191	finally
    //   134	138	209	java/io/IOException
    //   198	202	213	java/io/IOException
    //   46	52	217	finally
    //   59	66	217	finally
    //   73	81	217	finally
    //   83	98	217	finally
    //   100	109	217	finally
    //   115	130	217	finally
    //   161	176	217	finally
    //   46	52	221	java/io/IOException
    //   59	66	221	java/io/IOException
    //   73	81	221	java/io/IOException
    //   83	98	221	java/io/IOException
    //   100	109	221	java/io/IOException
    //   28	44	225	java/io/FileNotFoundException
  }
  
  public final void a(final String paramString, final Pattern paramPattern, final long paramLong, IKeyStepAnalyser.a parama)
  {
    AppMethodBeat.i(201196);
    new aq(String.format(Locale.ENGLISH, "KeyStepAnalyser:%s", new Object[] { paramString })).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201195);
        a locala = a.this;
        Object localObject = paramString;
        Pattern localPattern = paramPattern;
        long l = paramLong;
        IKeyStepAnalyser.a locala1 = this.lGF;
        ae.i("MicroMsg.KeyStepAnalyser", "doAnalyse processName:%s sessionIdPattern:%s", new Object[] { localObject, localPattern.pattern() });
        if (locala1 != null)
        {
          localObject = c.bre().V((String)localObject, l);
          if ((localObject == null) || (((List)localObject).isEmpty()))
          {
            ae.i("MicroMsg.KeyStepAnalyser", "no keystep logs");
            locala1.bz(new ArrayList());
            AppMethodBeat.o(201195);
            return;
          }
          ArrayList localArrayList = new ArrayList();
          int i = 0;
          while (i < ((List)localObject).size())
          {
            List localList = a.f((String)((List)localObject).get(i), localPattern);
            if (!localList.isEmpty()) {
              localArrayList.add(localList);
            }
            i += 1;
          }
          if (localArrayList.isEmpty())
          {
            ae.i("MicroMsg.KeyStepAnalyser", "no keystep logs");
            locala1.bz(new ArrayList());
            AppMethodBeat.o(201195);
            return;
          }
          locala1.bz(a.by(locala.bx(localArrayList)));
        }
        AppMethodBeat.o(201195);
      }
    });
    AppMethodBeat.o(201196);
  }
  
  final List<IKeyStepAnalyser.StepLogInfo> bx(List<List<IKeyStepAnalyser.StepLogInfo>> paramList)
  {
    AppMethodBeat.i(201198);
    ArrayList localArrayList = new ArrayList();
    PriorityQueue localPriorityQueue = new PriorityQueue(paramList.size(), new Comparator() {});
    int j = 0;
    int k;
    Object localObject;
    for (int i = 0; j < paramList.size(); i = k)
    {
      k = i;
      if (!((List)paramList.get(j)).isEmpty())
      {
        localObject = new a((byte)0);
        ((a)localObject).lGH = ((IKeyStepAnalyser.StepLogInfo)((List)paramList.get(j)).get(0));
        ((a)localObject).indexInArray = 0;
        ((a)localObject).lGI = j;
        localPriorityQueue.add(localObject);
        k = i + ((List)paramList.get(j)).size();
      }
      j += 1;
    }
    j = 0;
    if (j < i)
    {
      localObject = (a)localPriorityQueue.poll();
      localArrayList.add(((a)localObject).lGH);
      List localList = (List)paramList.get(((a)localObject).lGI);
      k = ((a)localObject).indexInArray + 1;
      if (k >= localList.size())
      {
        if (a.lGJ == null)
        {
          a.lGJ = new a();
          localObject = new IKeyStepAnalyser.StepLogInfo();
          ((IKeyStepAnalyser.StepLogInfo)localObject).time = 9223372036854775807L;
          a.lGJ.lGH = ((IKeyStepAnalyser.StepLogInfo)localObject);
        }
        localPriorityQueue.add(a.lGJ);
      }
      for (;;)
      {
        j += 1;
        break;
        a locala = new a((byte)0);
        locala.lGH = ((IKeyStepAnalyser.StepLogInfo)localList.get(k));
        locala.indexInArray = k;
        locala.lGI = ((a)localObject).lGI;
        localPriorityQueue.add(locala);
      }
    }
    AppMethodBeat.o(201198);
    return localArrayList;
  }
  
  static final class a
  {
    static a lGJ;
    int indexInArray;
    IKeyStepAnalyser.StepLogInfo lGH;
    int lGI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.a
 * JD-Core Version:    0.7.0.1
 */