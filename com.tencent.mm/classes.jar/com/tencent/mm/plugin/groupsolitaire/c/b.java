package com.tencent.mm.plugin.groupsolitaire.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
{
  public String content = "";
  public long createtime = 9223372036854775807L;
  public String separator = " ";
  public int uNj = 0;
  public int uNk = 0;
  public String username = "";
  
  public static boolean hw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221114);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(221114);
      return false;
    }
    boolean bool = bu.lX(paramString1.replaceAll(com.tencent.mm.plugin.groupsolitaire.b.b.dei(), "").replace(" ", "").toLowerCase(), paramString2.replaceAll(com.tencent.mm.plugin.groupsolitaire.b.b.dei(), "").replace(" ", "").toLowerCase());
    AppMethodBeat.o(221114);
    return bool;
  }
  
  /* Error */
  public final b dem()
  {
    // Byte code:
    //   0: ldc 86
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 2	com/tencent/mm/plugin/groupsolitaire/c/b
    //   8: dup
    //   9: invokespecial 87	com/tencent/mm/plugin/groupsolitaire/c/b:<init>	()V
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: getfield 21	com/tencent/mm/plugin/groupsolitaire/c/b:username	Ljava/lang/String;
    //   18: putfield 21	com/tencent/mm/plugin/groupsolitaire/c/b:username	Ljava/lang/String;
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 23	com/tencent/mm/plugin/groupsolitaire/c/b:uNj	I
    //   26: putfield 23	com/tencent/mm/plugin/groupsolitaire/c/b:uNj	I
    //   29: aload_1
    //   30: aload_0
    //   31: getfield 27	com/tencent/mm/plugin/groupsolitaire/c/b:separator	Ljava/lang/String;
    //   34: putfield 27	com/tencent/mm/plugin/groupsolitaire/c/b:separator	Ljava/lang/String;
    //   37: aload_1
    //   38: aload_0
    //   39: getfield 31	com/tencent/mm/plugin/groupsolitaire/c/b:createtime	J
    //   42: putfield 31	com/tencent/mm/plugin/groupsolitaire/c/b:createtime	J
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 33	com/tencent/mm/plugin/groupsolitaire/c/b:content	Ljava/lang/String;
    //   50: putfield 33	com/tencent/mm/plugin/groupsolitaire/c/b:content	Ljava/lang/String;
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 35	com/tencent/mm/plugin/groupsolitaire/c/b:uNk	I
    //   58: putfield 35	com/tencent/mm/plugin/groupsolitaire/c/b:uNk	I
    //   61: ldc 86
    //   63: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_1
    //   67: areturn
    //   68: astore_2
    //   69: aconst_null
    //   70: astore_1
    //   71: ldc 89
    //   73: ldc 91
    //   75: iconst_2
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_2
    //   82: invokevirtual 95	java/lang/Object:getClass	()Ljava/lang/Class;
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_2
    //   89: invokevirtual 98	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   92: aastore
    //   93: invokestatic 103	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: goto -35 -> 61
    //   99: astore_2
    //   100: goto -29 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	b
    //   12	59	1	localb	b
    //   68	21	2	localException1	java.lang.Exception
    //   99	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   5	13	68	java/lang/Exception
    //   13	61	99	java/lang/Exception
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(110401);
    paramObject = (b)paramObject;
    if (bu.lX(this.username, paramObject.username))
    {
      if (bu.lX(this.content.trim(), paramObject.content.trim()))
      {
        AppMethodBeat.o(110401);
        return true;
      }
      AppMethodBeat.o(110401);
      return false;
    }
    if (bu.lX(this.content.trim(), paramObject.content.trim()))
    {
      AppMethodBeat.o(110401);
      return true;
    }
    boolean bool = hw(this.content.trim(), paramObject.content.trim());
    AppMethodBeat.o(110401);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(110400);
    if ((bu.isNullOrNil(this.content)) || (bu.isNullOrNil(this.content.trim())))
    {
      AppMethodBeat.o(110400);
      return 0;
    }
    int i = this.content.trim().replaceAll(com.tencent.mm.plugin.groupsolitaire.b.b.dei(), "").replace(" ", "").toLowerCase().hashCode();
    AppMethodBeat.o(110400);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110398);
    String str = "GroupSolitatireItem{username='" + this.username + '\'' + ", asheader=" + this.uNj + ", separator='" + this.separator + '\'' + ", createtime=" + this.createtime + ", content='" + this.content + '\'' + ", orderNum='" + this.uNk + '\'' + '}';
    AppMethodBeat.o(110398);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.c.b
 * JD-Core Version:    0.7.0.1
 */