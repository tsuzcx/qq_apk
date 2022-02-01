package com.tencent.mm.plugin.groupsolitaire.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends cu
{
  protected static c.a info;
  public String header;
  public String separator;
  public String tyO;
  public String tyP;
  public int tyQ;
  public boolean tyR;
  public HashMap<Integer, b> tyS;
  public boolean tyT;
  public int tyU;
  
  static
  {
    AppMethodBeat.i(110397);
    c.a locala = new c.a();
    locala.GvF = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.GvH.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "key";
    locala.GvH.put("key", "TEXT");
    localStringBuilder.append(" key TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "content";
    locala.GvH.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "creator";
    locala.GvH.put("creator", "TEXT");
    localStringBuilder.append(" creator TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "num";
    locala.GvH.put("num", "INTEGER");
    localStringBuilder.append(" num INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "firstMsgId";
    locala.GvH.put("firstMsgId", "LONG");
    localStringBuilder.append(" firstMsgId LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "msgSvrId";
    locala.GvH.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "active";
    locala.GvH.put("active", "INTEGER default '-1' ");
    localStringBuilder.append(" active INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "lastActiveTime";
    locala.GvH.put("lastActiveTime", "LONG");
    localStringBuilder.append(" lastActiveTime LONG");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(110397);
  }
  
  public a()
  {
    AppMethodBeat.i(110393);
    this.header = "";
    this.tyO = "";
    this.tyP = "";
    this.separator = " ";
    this.tyQ = 1;
    this.tyR = false;
    this.tyS = new HashMap();
    this.tyT = false;
    this.tyU = 0;
    AppMethodBeat.o(110393);
  }
  
  public final void cSm()
  {
    if (this.tyQ == 0)
    {
      this.tyQ = 1;
      this.header = "";
    }
  }
  
  /* Error */
  public final a cSn()
  {
    // Byte code:
    //   0: ldc 157
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: new 2	com/tencent/mm/plugin/groupsolitaire/c/a
    //   11: dup
    //   12: invokespecial 158	com/tencent/mm/plugin/groupsolitaire/c/a:<init>	()V
    //   15: astore_2
    //   16: aload_2
    //   17: aload_0
    //   18: getfield 162	com/tencent/mm/plugin/groupsolitaire/c/a:systemRowid	J
    //   21: putfield 162	com/tencent/mm/plugin/groupsolitaire/c/a:systemRowid	J
    //   24: aload_2
    //   25: aload_0
    //   26: getfield 165	com/tencent/mm/plugin/groupsolitaire/c/a:field_username	Ljava/lang/String;
    //   29: putfield 165	com/tencent/mm/plugin/groupsolitaire/c/a:field_username	Ljava/lang/String;
    //   32: aload_2
    //   33: aload_0
    //   34: getfield 168	com/tencent/mm/plugin/groupsolitaire/c/a:field_key	Ljava/lang/String;
    //   37: putfield 168	com/tencent/mm/plugin/groupsolitaire/c/a:field_key	Ljava/lang/String;
    //   40: aload_2
    //   41: aload_0
    //   42: getfield 171	com/tencent/mm/plugin/groupsolitaire/c/a:field_content	Ljava/lang/String;
    //   45: putfield 171	com/tencent/mm/plugin/groupsolitaire/c/a:field_content	Ljava/lang/String;
    //   48: aload_2
    //   49: aload_0
    //   50: getfield 174	com/tencent/mm/plugin/groupsolitaire/c/a:field_creator	Ljava/lang/String;
    //   53: putfield 174	com/tencent/mm/plugin/groupsolitaire/c/a:field_creator	Ljava/lang/String;
    //   56: aload_2
    //   57: aload_0
    //   58: getfield 177	com/tencent/mm/plugin/groupsolitaire/c/a:field_num	I
    //   61: putfield 177	com/tencent/mm/plugin/groupsolitaire/c/a:field_num	I
    //   64: aload_2
    //   65: aload_0
    //   66: getfield 180	com/tencent/mm/plugin/groupsolitaire/c/a:field_firstMsgId	J
    //   69: putfield 180	com/tencent/mm/plugin/groupsolitaire/c/a:field_firstMsgId	J
    //   72: aload_2
    //   73: aload_0
    //   74: getfield 183	com/tencent/mm/plugin/groupsolitaire/c/a:field_msgSvrId	J
    //   77: putfield 183	com/tencent/mm/plugin/groupsolitaire/c/a:field_msgSvrId	J
    //   80: aload_2
    //   81: aload_0
    //   82: getfield 186	com/tencent/mm/plugin/groupsolitaire/c/a:field_active	I
    //   85: putfield 186	com/tencent/mm/plugin/groupsolitaire/c/a:field_active	I
    //   88: aload_2
    //   89: aload_0
    //   90: getfield 189	com/tencent/mm/plugin/groupsolitaire/c/a:field_lastActiveTime	J
    //   93: putfield 189	com/tencent/mm/plugin/groupsolitaire/c/a:field_lastActiveTime	J
    //   96: aload_2
    //   97: aload_0
    //   98: getfield 130	com/tencent/mm/plugin/groupsolitaire/c/a:header	Ljava/lang/String;
    //   101: putfield 130	com/tencent/mm/plugin/groupsolitaire/c/a:header	Ljava/lang/String;
    //   104: aload_2
    //   105: aload_0
    //   106: getfield 132	com/tencent/mm/plugin/groupsolitaire/c/a:tyO	Ljava/lang/String;
    //   109: putfield 132	com/tencent/mm/plugin/groupsolitaire/c/a:tyO	Ljava/lang/String;
    //   112: aload_2
    //   113: aload_0
    //   114: getfield 134	com/tencent/mm/plugin/groupsolitaire/c/a:tyP	Ljava/lang/String;
    //   117: putfield 134	com/tencent/mm/plugin/groupsolitaire/c/a:tyP	Ljava/lang/String;
    //   120: aload_2
    //   121: aload_0
    //   122: getfield 138	com/tencent/mm/plugin/groupsolitaire/c/a:separator	Ljava/lang/String;
    //   125: putfield 138	com/tencent/mm/plugin/groupsolitaire/c/a:separator	Ljava/lang/String;
    //   128: aload_2
    //   129: aload_0
    //   130: getfield 140	com/tencent/mm/plugin/groupsolitaire/c/a:tyQ	I
    //   133: putfield 140	com/tencent/mm/plugin/groupsolitaire/c/a:tyQ	I
    //   136: aload_2
    //   137: aload_0
    //   138: getfield 151	com/tencent/mm/plugin/groupsolitaire/c/a:tyU	I
    //   141: putfield 151	com/tencent/mm/plugin/groupsolitaire/c/a:tyU	I
    //   144: aload_2
    //   145: aload_0
    //   146: getfield 149	com/tencent/mm/plugin/groupsolitaire/c/a:tyT	Z
    //   149: putfield 149	com/tencent/mm/plugin/groupsolitaire/c/a:tyT	Z
    //   152: aload_2
    //   153: new 144	java/util/HashMap
    //   156: dup
    //   157: invokespecial 145	java/util/HashMap:<init>	()V
    //   160: putfield 147	com/tencent/mm/plugin/groupsolitaire/c/a:tyS	Ljava/util/HashMap;
    //   163: iconst_1
    //   164: istore_1
    //   165: iload_1
    //   166: aload_0
    //   167: getfield 147	com/tencent/mm/plugin/groupsolitaire/c/a:tyS	Ljava/util/HashMap;
    //   170: invokevirtual 193	java/util/HashMap:size	()I
    //   173: if_icmpgt +41 -> 214
    //   176: aload_0
    //   177: getfield 147	com/tencent/mm/plugin/groupsolitaire/c/a:tyS	Ljava/util/HashMap;
    //   180: iload_1
    //   181: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: invokevirtual 203	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 205	com/tencent/mm/plugin/groupsolitaire/c/b
    //   190: astore_3
    //   191: aload_2
    //   192: getfield 147	com/tencent/mm/plugin/groupsolitaire/c/a:tyS	Ljava/util/HashMap;
    //   195: iload_1
    //   196: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: aload_3
    //   200: invokevirtual 209	com/tencent/mm/plugin/groupsolitaire/c/b:cSo	()Lcom/tencent/mm/plugin/groupsolitaire/c/b;
    //   203: invokevirtual 210	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   206: pop
    //   207: iload_1
    //   208: iconst_1
    //   209: iadd
    //   210: istore_1
    //   211: goto -46 -> 165
    //   214: ldc 157
    //   216: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_2
    //   220: areturn
    //   221: astore_3
    //   222: aload 4
    //   224: astore_2
    //   225: ldc 212
    //   227: ldc 214
    //   229: iconst_2
    //   230: anewarray 216	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: aload_3
    //   236: invokevirtual 220	java/lang/Object:getClass	()Ljava/lang/Class;
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: aload_3
    //   243: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   246: aastore
    //   247: invokestatic 228	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110394);
    String str = "GroupSolitatire{header='" + this.header + '\'' + ", example='" + this.tyO + '\'' + ", tail='" + this.tyP + '\'' + ", separator='" + this.separator + '\'' + ", hasRealTitle=" + this.tyQ + ", content=" + this.tyS + ", includeRepeatedContent=" + this.tyT + ", includeWhiteContentNum=" + this.tyU + ", field_username='" + this.field_username + '\'' + ", field_key='" + this.field_key + '\'' + ", field_content='" + this.field_content + '\'' + ", field_creator='" + this.field_creator + '\'' + ", field_num=" + this.field_num + ", field_firstMsgId=" + this.field_firstMsgId + ", field_msgSvrId=" + this.field_msgSvrId + ", field_active=" + this.field_active + ", field_lastActiveTime=" + this.field_lastActiveTime + ", systemRowid=" + this.systemRowid + '}';
    AppMethodBeat.o(110394);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.c.a
 * JD-Core Version:    0.7.0.1
 */