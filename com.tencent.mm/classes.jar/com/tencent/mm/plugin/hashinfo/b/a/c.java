package com.tencent.mm.plugin.hashinfo.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.ac.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hashinfo/model/storage/HashUserNameMapStorage;", "Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;", "Lcom/tencent/mm/plugin/hashinfo/model/storage/HashUserNameMap;", "dbProvider", "Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "(Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;)V", "_commFinalSalt", "", "_finalSalt", "lruCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "HmacSHA256Encrypt", "text", "secretKey", "getCommFinalSalt", "getContactByHashUserName", "Lcom/tencent/mm/storage/Contact;", "hashUserName", "hashType", "", "getFinalSalt", "getMapByUserName", "userName", "getUserNameByHash", "remove", "", "update", "xor", "that", "Companion", "plugin-hashinfo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends g<b>
{
  private static final String DB_PATH;
  public static final c.a JmN;
  private static final String ptT;
  private String JmO;
  private String JmP;
  private final com.tencent.mm.b.h<String, b> JmQ;
  
  static
  {
    AppMethodBeat.i(261086);
    JmN = new c.a((byte)0);
    ptT = "HashUserNameMap";
    DB_PATH = s.X(com.tencent.mm.kernel.h.baE().cachePath, "HashInfo.db");
    AppMethodBeat.o(261086);
  }
  
  public c(final IMvvmDBProvider paramIMvvmDBProvider)
  {
    super(paramIMvvmDBProvider);
    AppMethodBeat.i(261046);
    this.JmO = "";
    this.JmP = "";
    com.tencent.mm.ae.d.d("HashUserNameMapStorage_INIT", (kotlin.g.a.a)new u(paramIMvvmDBProvider) {});
    this.JmQ = new com.tencent.mm.b.h(20);
    AppMethodBeat.o(261046);
  }
  
  private static String gn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(261059);
    Mac localMac;
    Charset localCharset;
    try
    {
      localMac = Mac.getInstance("HmacSHA256");
      localCharset = kotlin.n.d.UTF_8;
      if (paramString2 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(261059);
        throw paramString1;
      }
    }
    finally
    {
      AppMethodBeat.o(261059);
      return "";
    }
    paramString2 = paramString2.getBytes(localCharset);
    s.s(paramString2, "(this as java.lang.String).getBytes(charset)");
    localMac.init((Key)new SecretKeySpec(paramString2, "HmacSHA256"));
    if (paramString1 == null) {
      paramString1 = null;
    }
    for (;;)
    {
      paramString1 = Util.encodeHexString(localMac.doFinal(paramString1));
      s.s(paramString1, "encodeHexString(sha256_H…nal(text?.toByteArray()))");
      AppMethodBeat.o(261059);
      return paramString1;
      paramString1 = paramString1.getBytes(kotlin.n.d.UTF_8);
      s.s(paramString1, "(this as java.lang.String).getBytes(charset)");
    }
  }
  
  private static String jx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(261050);
    paramString1 = (CharSequence)paramString1;
    Collection localCollection = (Collection)new ArrayList(paramString1.length());
    int j = 0;
    int i = 0;
    while (j < paramString1.length())
    {
      int k = paramString1.charAt(j);
      localCollection.add(Character.valueOf((char)(paramString2.charAt(i) ^ k)));
      j += 1;
      i += 1;
    }
    paramString1 = p.a((Iterable)localCollection, (CharSequence)"", null, null, 0, null, (kotlin.g.a.b)c.d.JmT, 30);
    AppMethodBeat.o(261050);
    return paramString1;
  }
  
  public final void Ds(final String paramString)
  {
    AppMethodBeat.i(261110);
    s.u(paramString, "userName");
    CharSequence localCharSequence = (CharSequence)fKl();
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        if (!n.bp((CharSequence)paramString)) {
          break label86;
        }
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        com.tencent.mm.ae.d.d("MicroMsg.HashInfo.HashUserNameMapStorage", (kotlin.g.a.a)new c(this, paramString));
      }
      AppMethodBeat.o(261110);
      return;
      i = 0;
      break;
    }
  }
  
  public final String fKl()
  {
    AppMethodBeat.i(261092);
    Object localObject = (CharSequence)this.JmO;
    int i;
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i != 0)
      {
        localObject = com.tencent.mm.kernel.h.baE().ban().b(at.a.adgJ, null);
        CharSequence localCharSequence = (CharSequence)localObject;
        if ((localCharSequence != null) && (!n.bp(localCharSequence))) {
          break label102;
        }
        i = 1;
        label63:
        if (i == 0) {
          break label107;
        }
        Log.w("MicroMsg.HashInfo.HashUserNameMapStorage", "ACC_SALT is empty");
      }
    }
    for (localObject = "";; localObject = jx((String)localObject, "765272c5645917a2578092a523cd2a37ccf0b352d16d9744d5b5bd4668e71c4a"))
    {
      this.JmO = ((String)localObject);
      localObject = this.JmO;
      AppMethodBeat.o(261092);
      return localObject;
      i = 0;
      break;
      label102:
      i = 0;
      break label63;
      label107:
      s.s(localObject, "acc_salt");
    }
  }
  
  public final String fKm()
  {
    AppMethodBeat.i(261100);
    Object localObject = (CharSequence)this.JmP;
    int i;
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i != 0)
      {
        localObject = com.tencent.mm.kernel.h.baE().ban().b(at.a.adgJ, null);
        CharSequence localCharSequence = (CharSequence)localObject;
        if ((localCharSequence != null) && (!n.bp(localCharSequence))) {
          break label102;
        }
        i = 1;
        label63:
        if (i == 0) {
          break label107;
        }
        Log.w("MicroMsg.HashInfo.HashUserNameMapStorage", "ACC_SALT is empty");
      }
    }
    for (localObject = "";; localObject = jx((String)localObject, "64ad9fafb003525bbc9f8fb1a3cd271e8efc2002c3a3d23806ad66e165325d4e"))
    {
      this.JmP = ((String)localObject);
      localObject = this.JmP;
      AppMethodBeat.o(261100);
      return localObject;
      i = 0;
      break;
      label102:
      i = 0;
      break label63;
      label107:
      s.s(localObject, "acc_salt");
    }
  }
  
  public final String getUserNameByHash(String paramString, int paramInt)
  {
    AppMethodBeat.i(261122);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (n.bp((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(261122);
      return null;
    }
    Object localObject2 = (b)this.JmQ.ct(paramString);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = com.tencent.mm.plugin.hashinfo.c.a.TABLE;
      s.s(localObject2, "TABLE");
      if (paramInt != 1) {
        break label191;
      }
      localObject1 = com.tencent.mm.plugin.hashinfo.c.a.JmU;
      s.s(localObject1, "HASHUSERNAME");
    }
    for (;;)
    {
      localObject2 = ((SingleTable)localObject2).selectAll();
      String str = Util.escapeSqlValue(paramString);
      s.s(str, "escapeSqlValue(hashUserName)");
      localObject2 = (b)((SelectSql.Builder)localObject2).where((ISqlCondition)((Column)localObject1).equal(str)).build().singleQuery(this.MnQ.getDB(), b.class);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        this.JmQ.put(paramString, localObject2);
        localObject1 = localObject2;
      }
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(261122);
      return null;
      label191:
      localObject1 = com.tencent.mm.plugin.hashinfo.c.a.JmV;
      s.s(localObject1, "COMMHASHUSERNAME");
    }
    paramString = ((b)localObject1).field_UserName;
    AppMethodBeat.o(261122);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public b(c paramc, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(c paramc, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hashinfo.b.a.c
 * JD-Core Version:    0.7.0.1
 */