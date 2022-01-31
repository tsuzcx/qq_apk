package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.ipcall.a.g.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static c nLU;
  boolean bRB;
  private ArrayList<Integer> nLV;
  ArrayList<Integer> nLW;
  
  private c()
  {
    AppMethodBeat.i(21716);
    this.nLV = new ArrayList();
    this.nLW = new ArrayList();
    this.bRB = false;
    AppMethodBeat.o(21716);
  }
  
  private void QW(String paramString)
  {
    AppMethodBeat.i(21719);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21719);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("restriction");
      ab.d("MicroMsg.IPCallCountryCodeConfig", "restrictionCountryCode: %d", new Object[] { Integer.valueOf(paramString.length()) });
      this.nLW.clear();
      int i = 0;
      while (i < paramString.length())
      {
        int j = paramString.getInt(i);
        this.nLW.add(Integer.valueOf(j));
        i += 1;
      }
      AppMethodBeat.o(21719);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", paramString, "", new Object[0]);
      ab.e("MicroMsg.IPCallCountryCodeConfig", "initConfigFromContent error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(21719);
    }
  }
  
  public static c bIZ()
  {
    AppMethodBeat.i(21717);
    if (nLU == null) {
      nLU = new c();
    }
    c localc = nLU;
    AppMethodBeat.o(21717);
    return localc;
  }
  
  private void bJa()
  {
    AppMethodBeat.i(21720);
    this.nLV.clear();
    Object localObject = g.Nq().getValue("WeChatOutTopCountryCode");
    ab.d("MicroMsg.IPCallCountryCodeConfig", "popularCountryConfig: %s", new Object[] { localObject });
    if (!bo.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).trim().split(",");
      int j = localObject.length;
      try
      {
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          Integer localInteger = Integer.valueOf(bo.getInt(localObject[i], 0));
          this.nLV.add(localInteger);
          i.bJv().U(localInteger.intValue(), j);
          j -= 1;
          i += 1;
        }
        AppMethodBeat.o(21720);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ab.e("MicroMsg.IPCallCountryCodeConfig", "initPopularCountryFromDynamicConfig error: %s", new Object[] { localNumberFormatException.getMessage() });
      }
    }
    AppMethodBeat.o(21720);
  }
  
  private void bJb()
  {
    AppMethodBeat.i(21721);
    ArrayList localArrayList = i.bJv().bJW();
    if (localArrayList.size() > 0)
    {
      this.nLV = localArrayList;
      AppMethodBeat.o(21721);
      return;
    }
    bJa();
    AppMethodBeat.o(21721);
  }
  
  public final void QX(String paramString)
  {
    AppMethodBeat.i(21722);
    if (!this.bRB) {
      ix(false);
    }
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21722);
      return;
    }
    paramString = paramString.replace("+", "");
    i.bJv().U(bo.getInt(paramString, 0), bo.aoy());
    bJb();
    AppMethodBeat.o(21722);
  }
  
  public final List<Integer> bJc()
  {
    AppMethodBeat.i(21723);
    if (!this.bRB) {
      ix(false);
    }
    ArrayList localArrayList = this.nLV;
    AppMethodBeat.o(21723);
    return localArrayList;
  }
  
  /* Error */
  public final void ix(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: sipush 21718
    //   8: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: getfield 31	com/tencent/mm/plugin/ipcall/a/c:bRB	Z
    //   15: ifeq +14 -> 29
    //   18: iload_1
    //   19: ifne +10 -> 29
    //   22: sipush 21718
    //   25: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: return
    //   29: aload_0
    //   30: invokespecial 186	com/tencent/mm/plugin/ipcall/a/c:bJb	()V
    //   33: new 192	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   40: getstatic 199	com/tencent/mm/compatible/util/e:eQv	Ljava/lang/String;
    //   43: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 205
    //   48: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: astore 5
    //   56: aload_3
    //   57: astore_2
    //   58: new 210	java/io/File
    //   61: dup
    //   62: aload 5
    //   64: invokespecial 211	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 6
    //   69: aload_3
    //   70: astore_2
    //   71: aload 6
    //   73: invokevirtual 215	java/io/File:exists	()Z
    //   76: ifne +39 -> 115
    //   79: aload_3
    //   80: astore_2
    //   81: ldc 57
    //   83: ldc 217
    //   85: iconst_1
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: aload 5
    //   93: aastore
    //   94: invokestatic 77	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_3
    //   98: astore_2
    //   99: aload_0
    //   100: iconst_1
    //   101: putfield 31	com/tencent/mm/plugin/ipcall/a/c:bRB	Z
    //   104: aconst_null
    //   105: invokestatic 223	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   108: sipush 21718
    //   111: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: aload_3
    //   116: astore_2
    //   117: new 225	java/io/FileInputStream
    //   120: dup
    //   121: aload 6
    //   123: invokespecial 228	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   126: astore_3
    //   127: new 230	java/io/BufferedReader
    //   130: dup
    //   131: new 232	java/io/InputStreamReader
    //   134: dup
    //   135: aload_3
    //   136: invokespecial 234	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   139: invokespecial 237	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   142: astore 4
    //   144: ldc 90
    //   146: astore_2
    //   147: aload 4
    //   149: invokevirtual 240	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   152: astore 5
    //   154: aload 5
    //   156: ifnull +26 -> 182
    //   159: new 192	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   166: aload_2
    //   167: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 5
    //   172: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: astore_2
    //   179: goto -32 -> 147
    //   182: ldc 57
    //   184: ldc 242
    //   186: iconst_1
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_2
    //   193: aastore
    //   194: invokestatic 77	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_0
    //   198: aload_2
    //   199: invokespecial 244	com/tencent/mm/plugin/ipcall/a/c:QW	(Ljava/lang/String;)V
    //   202: aload_0
    //   203: iconst_1
    //   204: putfield 31	com/tencent/mm/plugin/ipcall/a/c:bRB	Z
    //   207: aload_3
    //   208: invokestatic 223	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   211: sipush 21718
    //   214: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: return
    //   218: astore_2
    //   219: aload 4
    //   221: astore_3
    //   222: aload_2
    //   223: astore 4
    //   225: aload_3
    //   226: astore_2
    //   227: ldc 57
    //   229: aload 4
    //   231: ldc 90
    //   233: iconst_0
    //   234: anewarray 4	java/lang/Object
    //   237: invokestatic 94	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: aload_3
    //   241: astore_2
    //   242: ldc 57
    //   244: ldc 246
    //   246: iconst_1
    //   247: anewarray 4	java/lang/Object
    //   250: dup
    //   251: iconst_0
    //   252: aload 4
    //   254: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   257: aastore
    //   258: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload_3
    //   262: invokestatic 223	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   265: sipush 21718
    //   268: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: return
    //   272: astore 4
    //   274: aload_2
    //   275: astore_3
    //   276: aload 4
    //   278: astore_2
    //   279: aload_3
    //   280: invokestatic 223	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   283: sipush 21718
    //   286: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_2
    //   290: athrow
    //   291: astore_2
    //   292: goto -13 -> 279
    //   295: astore 4
    //   297: goto -72 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	c
    //   0	300	1	paramBoolean	boolean
    //   57	142	2	localObject1	Object
    //   218	5	2	localException1	Exception
    //   226	64	2	localObject2	Object
    //   291	1	2	localObject3	Object
    //   1	279	3	localObject4	Object
    //   3	250	4	localObject5	Object
    //   272	5	4	localObject6	Object
    //   295	1	4	localException2	Exception
    //   54	117	5	str	String
    //   67	55	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   58	69	218	java/lang/Exception
    //   71	79	218	java/lang/Exception
    //   81	97	218	java/lang/Exception
    //   99	104	218	java/lang/Exception
    //   117	127	218	java/lang/Exception
    //   58	69	272	finally
    //   71	79	272	finally
    //   81	97	272	finally
    //   99	104	272	finally
    //   117	127	272	finally
    //   227	240	272	finally
    //   242	261	272	finally
    //   127	144	291	finally
    //   147	154	291	finally
    //   159	179	291	finally
    //   182	207	291	finally
    //   127	144	295	java/lang/Exception
    //   147	154	295	java/lang/Exception
    //   159	179	295	java/lang/Exception
    //   182	207	295	java/lang/Exception
  }
  
  public final boolean xE(int paramInt)
  {
    AppMethodBeat.i(21724);
    if (!this.bRB) {
      ix(false);
    }
    if ((this.nLW == null) || (this.nLW.size() <= 0))
    {
      AppMethodBeat.o(21724);
      return false;
    }
    boolean bool = this.nLW.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(21724);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.c
 * JD-Core Version:    0.7.0.1
 */