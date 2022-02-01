package com.tencent.mm.plugin.groupsolitaire.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ea;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.HashMap;

public class a
  extends ea
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public String IvM;
  public String Jjl;
  public int Jjm;
  public boolean Jjn;
  public HashMap<Integer, b> Jjo;
  public boolean Jjp;
  public int Jjq;
  public String dIC;
  public String header;
  
  static
  {
    AppMethodBeat.i(110397);
    info = ea.aJm();
    AppMethodBeat.o(110397);
  }
  
  public a()
  {
    AppMethodBeat.i(110393);
    this.header = "";
    this.Jjl = "";
    this.IvM = "";
    this.dIC = " ";
    this.Jjm = 1;
    this.Jjn = false;
    this.Jjo = new HashMap();
    this.Jjp = false;
    this.Jjq = 0;
    AppMethodBeat.o(110393);
  }
  
  public final void fJu()
  {
    if (this.Jjm == 0)
    {
      this.Jjm = 1;
      this.header = "";
    }
  }
  
  /* Error */
  public final a fJv()
  {
    // Byte code:
    //   0: ldc 79
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: new 2	com/tencent/mm/plugin/groupsolitaire/c/a
    //   11: dup
    //   12: invokespecial 80	com/tencent/mm/plugin/groupsolitaire/c/a:<init>	()V
    //   15: astore_2
    //   16: aload_2
    //   17: aload_0
    //   18: getfield 84	com/tencent/mm/plugin/groupsolitaire/c/a:systemRowid	J
    //   21: putfield 84	com/tencent/mm/plugin/groupsolitaire/c/a:systemRowid	J
    //   24: aload_2
    //   25: aload_0
    //   26: getfield 87	com/tencent/mm/plugin/groupsolitaire/c/a:field_username	Ljava/lang/String;
    //   29: putfield 87	com/tencent/mm/plugin/groupsolitaire/c/a:field_username	Ljava/lang/String;
    //   32: aload_2
    //   33: aload_0
    //   34: getfield 90	com/tencent/mm/plugin/groupsolitaire/c/a:field_key	Ljava/lang/String;
    //   37: putfield 90	com/tencent/mm/plugin/groupsolitaire/c/a:field_key	Ljava/lang/String;
    //   40: aload_2
    //   41: aload_0
    //   42: getfield 93	com/tencent/mm/plugin/groupsolitaire/c/a:field_content	Ljava/lang/String;
    //   45: putfield 93	com/tencent/mm/plugin/groupsolitaire/c/a:field_content	Ljava/lang/String;
    //   48: aload_2
    //   49: aload_0
    //   50: getfield 96	com/tencent/mm/plugin/groupsolitaire/c/a:field_creator	Ljava/lang/String;
    //   53: putfield 96	com/tencent/mm/plugin/groupsolitaire/c/a:field_creator	Ljava/lang/String;
    //   56: aload_2
    //   57: aload_0
    //   58: getfield 99	com/tencent/mm/plugin/groupsolitaire/c/a:field_num	I
    //   61: putfield 99	com/tencent/mm/plugin/groupsolitaire/c/a:field_num	I
    //   64: aload_2
    //   65: aload_0
    //   66: getfield 102	com/tencent/mm/plugin/groupsolitaire/c/a:field_firstMsgId	J
    //   69: putfield 102	com/tencent/mm/plugin/groupsolitaire/c/a:field_firstMsgId	J
    //   72: aload_2
    //   73: aload_0
    //   74: getfield 105	com/tencent/mm/plugin/groupsolitaire/c/a:field_msgSvrId	J
    //   77: putfield 105	com/tencent/mm/plugin/groupsolitaire/c/a:field_msgSvrId	J
    //   80: aload_2
    //   81: aload_0
    //   82: getfield 108	com/tencent/mm/plugin/groupsolitaire/c/a:field_active	I
    //   85: putfield 108	com/tencent/mm/plugin/groupsolitaire/c/a:field_active	I
    //   88: aload_2
    //   89: aload_0
    //   90: getfield 111	com/tencent/mm/plugin/groupsolitaire/c/a:field_lastActiveTime	J
    //   93: putfield 111	com/tencent/mm/plugin/groupsolitaire/c/a:field_lastActiveTime	J
    //   96: aload_2
    //   97: aload_0
    //   98: getfield 47	com/tencent/mm/plugin/groupsolitaire/c/a:header	Ljava/lang/String;
    //   101: putfield 47	com/tencent/mm/plugin/groupsolitaire/c/a:header	Ljava/lang/String;
    //   104: aload_2
    //   105: aload_0
    //   106: getfield 49	com/tencent/mm/plugin/groupsolitaire/c/a:Jjl	Ljava/lang/String;
    //   109: putfield 49	com/tencent/mm/plugin/groupsolitaire/c/a:Jjl	Ljava/lang/String;
    //   112: aload_2
    //   113: aload_0
    //   114: getfield 51	com/tencent/mm/plugin/groupsolitaire/c/a:IvM	Ljava/lang/String;
    //   117: putfield 51	com/tencent/mm/plugin/groupsolitaire/c/a:IvM	Ljava/lang/String;
    //   120: aload_2
    //   121: aload_0
    //   122: getfield 55	com/tencent/mm/plugin/groupsolitaire/c/a:dIC	Ljava/lang/String;
    //   125: putfield 55	com/tencent/mm/plugin/groupsolitaire/c/a:dIC	Ljava/lang/String;
    //   128: aload_2
    //   129: aload_0
    //   130: getfield 57	com/tencent/mm/plugin/groupsolitaire/c/a:Jjm	I
    //   133: putfield 57	com/tencent/mm/plugin/groupsolitaire/c/a:Jjm	I
    //   136: aload_2
    //   137: aload_0
    //   138: getfield 68	com/tencent/mm/plugin/groupsolitaire/c/a:Jjq	I
    //   141: putfield 68	com/tencent/mm/plugin/groupsolitaire/c/a:Jjq	I
    //   144: aload_2
    //   145: aload_0
    //   146: getfield 66	com/tencent/mm/plugin/groupsolitaire/c/a:Jjp	Z
    //   149: putfield 66	com/tencent/mm/plugin/groupsolitaire/c/a:Jjp	Z
    //   152: aload_2
    //   153: new 61	java/util/HashMap
    //   156: dup
    //   157: invokespecial 62	java/util/HashMap:<init>	()V
    //   160: putfield 64	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   163: iconst_1
    //   164: istore_1
    //   165: iload_1
    //   166: aload_0
    //   167: getfield 64	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   170: invokevirtual 115	java/util/HashMap:size	()I
    //   173: if_icmpgt +41 -> 214
    //   176: aload_0
    //   177: getfield 64	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   180: iload_1
    //   181: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 127	com/tencent/mm/plugin/groupsolitaire/c/b
    //   190: astore_3
    //   191: aload_2
    //   192: getfield 64	com/tencent/mm/plugin/groupsolitaire/c/a:Jjo	Ljava/util/HashMap;
    //   195: iload_1
    //   196: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: aload_3
    //   200: invokevirtual 131	com/tencent/mm/plugin/groupsolitaire/c/b:fJw	()Lcom/tencent/mm/plugin/groupsolitaire/c/b;
    //   203: invokevirtual 135	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   206: pop
    //   207: iload_1
    //   208: iconst_1
    //   209: iadd
    //   210: istore_1
    //   211: goto -46 -> 165
    //   214: ldc 79
    //   216: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_2
    //   220: areturn
    //   221: astore_3
    //   222: aload 4
    //   224: astore_2
    //   225: ldc 137
    //   227: ldc 139
    //   229: iconst_2
    //   230: anewarray 141	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: aload_3
    //   236: invokevirtual 145	java/lang/Object:getClass	()Ljava/lang/Class;
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: aload_3
    //   243: invokevirtual 149	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   246: aastore
    //   247: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: goto -36 -> 214
    //   253: astore_3
    //   254: goto -29 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	a
    //   164	47	1	i	int
    //   15	210	2	localObject1	java.lang.Object
    //   190	10	3	localb	b
    //   221	22	3	localException1	java.lang.Exception
    //   253	1	3	localException2	java.lang.Exception
    //   6	217	4	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   8	16	221	java/lang/Exception
    //   16	163	253	java/lang/Exception
    //   165	207	253	java/lang/Exception
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public String toString()
  {
    AppMethodBeat.i(110394);
    String str = "GroupSolitatire{header='" + this.header + '\'' + ", example='" + this.Jjl + '\'' + ", tail='" + this.IvM + '\'' + ", separator='" + this.dIC + '\'' + ", hasRealTitle=" + this.Jjm + ", content=" + this.Jjo + ", includeRepeatedContent=" + this.Jjp + ", includeWhiteContentNum=" + this.Jjq + ", field_username='" + this.field_username + '\'' + ", field_key='" + this.field_key + '\'' + ", field_content='" + this.field_content + '\'' + ", field_creator='" + this.field_creator + '\'' + ", field_num=" + this.field_num + ", field_firstMsgId=" + this.field_firstMsgId + ", field_msgSvrId=" + this.field_msgSvrId + ", field_active=" + this.field_active + ", field_lastActiveTime=" + this.field_lastActiveTime + ", systemRowid=" + this.systemRowid + '}';
    AppMethodBeat.o(110394);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.c.a
 * JD-Core Version:    0.7.0.1
 */