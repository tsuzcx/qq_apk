package com.tencent.mm.plugin.groupsolitaire.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.de;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends de
{
  protected static c.a info;
  public String header;
  public String separator;
  public String tUK;
  public boolean uBA;
  public HashMap<Integer, b> uBB;
  public boolean uBC;
  public int uBD;
  public String uBy;
  public int uBz;
  
  static
  {
    AppMethodBeat.i(110397);
    c.a locala = new c.a();
    locala.IhA = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IhC.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "key";
    locala.IhC.put("key", "TEXT");
    localStringBuilder.append(" key TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "content";
    locala.IhC.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "creator";
    locala.IhC.put("creator", "TEXT");
    localStringBuilder.append(" creator TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "num";
    locala.IhC.put("num", "INTEGER");
    localStringBuilder.append(" num INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "firstMsgId";
    locala.IhC.put("firstMsgId", "LONG");
    localStringBuilder.append(" firstMsgId LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "msgSvrId";
    locala.IhC.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "active";
    locala.IhC.put("active", "INTEGER default '-1' ");
    localStringBuilder.append(" active INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "lastActiveTime";
    locala.IhC.put("lastActiveTime", "LONG");
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
    this.uBy = "";
    this.tUK = "";
    this.separator = " ";
    this.uBz = 1;
    this.uBA = false;
    this.uBB = new HashMap();
    this.uBC = false;
    this.uBD = 0;
    AppMethodBeat.o(110393);
  }
  
  public final void dbt()
  {
    if (this.uBz == 0)
    {
      this.uBz = 1;
      this.header = "";
    }
  }
  
  /* Error */
  public final a dbu()
  {
    // Byte code:
    //   0: ldc 162
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: new 2	com/tencent/mm/plugin/groupsolitaire/c/a
    //   11: dup
    //   12: invokespecial 163	com/tencent/mm/plugin/groupsolitaire/c/a:<init>	()V
    //   15: astore_2
    //   16: aload_2
    //   17: aload_0
    //   18: getfield 167	com/tencent/mm/plugin/groupsolitaire/c/a:systemRowid	J
    //   21: putfield 167	com/tencent/mm/plugin/groupsolitaire/c/a:systemRowid	J
    //   24: aload_2
    //   25: aload_0
    //   26: getfield 170	com/tencent/mm/plugin/groupsolitaire/c/a:field_username	Ljava/lang/String;
    //   29: putfield 170	com/tencent/mm/plugin/groupsolitaire/c/a:field_username	Ljava/lang/String;
    //   32: aload_2
    //   33: aload_0
    //   34: getfield 173	com/tencent/mm/plugin/groupsolitaire/c/a:field_key	Ljava/lang/String;
    //   37: putfield 173	com/tencent/mm/plugin/groupsolitaire/c/a:field_key	Ljava/lang/String;
    //   40: aload_2
    //   41: aload_0
    //   42: getfield 176	com/tencent/mm/plugin/groupsolitaire/c/a:field_content	Ljava/lang/String;
    //   45: putfield 176	com/tencent/mm/plugin/groupsolitaire/c/a:field_content	Ljava/lang/String;
    //   48: aload_2
    //   49: aload_0
    //   50: getfield 179	com/tencent/mm/plugin/groupsolitaire/c/a:field_creator	Ljava/lang/String;
    //   53: putfield 179	com/tencent/mm/plugin/groupsolitaire/c/a:field_creator	Ljava/lang/String;
    //   56: aload_2
    //   57: aload_0
    //   58: getfield 182	com/tencent/mm/plugin/groupsolitaire/c/a:field_num	I
    //   61: putfield 182	com/tencent/mm/plugin/groupsolitaire/c/a:field_num	I
    //   64: aload_2
    //   65: aload_0
    //   66: getfield 185	com/tencent/mm/plugin/groupsolitaire/c/a:field_firstMsgId	J
    //   69: putfield 185	com/tencent/mm/plugin/groupsolitaire/c/a:field_firstMsgId	J
    //   72: aload_2
    //   73: aload_0
    //   74: getfield 188	com/tencent/mm/plugin/groupsolitaire/c/a:field_msgSvrId	J
    //   77: putfield 188	com/tencent/mm/plugin/groupsolitaire/c/a:field_msgSvrId	J
    //   80: aload_2
    //   81: aload_0
    //   82: getfield 191	com/tencent/mm/plugin/groupsolitaire/c/a:field_active	I
    //   85: putfield 191	com/tencent/mm/plugin/groupsolitaire/c/a:field_active	I
    //   88: aload_2
    //   89: aload_0
    //   90: getfield 194	com/tencent/mm/plugin/groupsolitaire/c/a:field_lastActiveTime	J
    //   93: putfield 194	com/tencent/mm/plugin/groupsolitaire/c/a:field_lastActiveTime	J
    //   96: aload_2
    //   97: aload_0
    //   98: getfield 130	com/tencent/mm/plugin/groupsolitaire/c/a:header	Ljava/lang/String;
    //   101: putfield 130	com/tencent/mm/plugin/groupsolitaire/c/a:header	Ljava/lang/String;
    //   104: aload_2
    //   105: aload_0
    //   106: getfield 132	com/tencent/mm/plugin/groupsolitaire/c/a:uBy	Ljava/lang/String;
    //   109: putfield 132	com/tencent/mm/plugin/groupsolitaire/c/a:uBy	Ljava/lang/String;
    //   112: aload_2
    //   113: aload_0
    //   114: getfield 134	com/tencent/mm/plugin/groupsolitaire/c/a:tUK	Ljava/lang/String;
    //   117: putfield 134	com/tencent/mm/plugin/groupsolitaire/c/a:tUK	Ljava/lang/String;
    //   120: aload_2
    //   121: aload_0
    //   122: getfield 138	com/tencent/mm/plugin/groupsolitaire/c/a:separator	Ljava/lang/String;
    //   125: putfield 138	com/tencent/mm/plugin/groupsolitaire/c/a:separator	Ljava/lang/String;
    //   128: aload_2
    //   129: aload_0
    //   130: getfield 140	com/tencent/mm/plugin/groupsolitaire/c/a:uBz	I
    //   133: putfield 140	com/tencent/mm/plugin/groupsolitaire/c/a:uBz	I
    //   136: aload_2
    //   137: aload_0
    //   138: getfield 151	com/tencent/mm/plugin/groupsolitaire/c/a:uBD	I
    //   141: putfield 151	com/tencent/mm/plugin/groupsolitaire/c/a:uBD	I
    //   144: aload_2
    //   145: aload_0
    //   146: getfield 149	com/tencent/mm/plugin/groupsolitaire/c/a:uBC	Z
    //   149: putfield 149	com/tencent/mm/plugin/groupsolitaire/c/a:uBC	Z
    //   152: aload_2
    //   153: new 144	java/util/HashMap
    //   156: dup
    //   157: invokespecial 145	java/util/HashMap:<init>	()V
    //   160: putfield 147	com/tencent/mm/plugin/groupsolitaire/c/a:uBB	Ljava/util/HashMap;
    //   163: iconst_1
    //   164: istore_1
    //   165: iload_1
    //   166: aload_0
    //   167: getfield 147	com/tencent/mm/plugin/groupsolitaire/c/a:uBB	Ljava/util/HashMap;
    //   170: invokevirtual 198	java/util/HashMap:size	()I
    //   173: if_icmpgt +41 -> 214
    //   176: aload_0
    //   177: getfield 147	com/tencent/mm/plugin/groupsolitaire/c/a:uBB	Ljava/util/HashMap;
    //   180: iload_1
    //   181: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: invokevirtual 208	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 210	com/tencent/mm/plugin/groupsolitaire/c/b
    //   190: astore_3
    //   191: aload_2
    //   192: getfield 147	com/tencent/mm/plugin/groupsolitaire/c/a:uBB	Ljava/util/HashMap;
    //   195: iload_1
    //   196: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: aload_3
    //   200: invokevirtual 214	com/tencent/mm/plugin/groupsolitaire/c/b:dbv	()Lcom/tencent/mm/plugin/groupsolitaire/c/b;
    //   203: invokevirtual 215	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   206: pop
    //   207: iload_1
    //   208: iconst_1
    //   209: iadd
    //   210: istore_1
    //   211: goto -46 -> 165
    //   214: ldc 162
    //   216: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_2
    //   220: areturn
    //   221: astore_3
    //   222: aload 4
    //   224: astore_2
    //   225: ldc 217
    //   227: ldc 219
    //   229: iconst_2
    //   230: anewarray 221	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: aload_3
    //   236: invokevirtual 225	java/lang/Object:getClass	()Ljava/lang/Class;
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: aload_3
    //   243: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   246: aastore
    //   247: invokestatic 233	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    String str = "GroupSolitatire{header='" + this.header + '\'' + ", example='" + this.uBy + '\'' + ", tail='" + this.tUK + '\'' + ", separator='" + this.separator + '\'' + ", hasRealTitle=" + this.uBz + ", content=" + this.uBB + ", includeRepeatedContent=" + this.uBC + ", includeWhiteContentNum=" + this.uBD + ", field_username='" + this.field_username + '\'' + ", field_key='" + this.field_key + '\'' + ", field_content='" + this.field_content + '\'' + ", field_creator='" + this.field_creator + '\'' + ", field_num=" + this.field_num + ", field_firstMsgId=" + this.field_firstMsgId + ", field_msgSvrId=" + this.field_msgSvrId + ", field_active=" + this.field_active + ", field_lastActiveTime=" + this.field_lastActiveTime + ", systemRowid=" + this.systemRowid + '}';
    AppMethodBeat.o(110394);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.c.a
 * JD-Core Version:    0.7.0.1
 */