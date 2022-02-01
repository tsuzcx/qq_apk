package com.tencent.mm.plugin.finder.api;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "", "username", "", "(Ljava/lang/String;)V", "()V", "isContactValid", "", "()Z", "setContactValid", "(Z)V", "isNeedShowUnFollow", "setNeedShowUnFollow", "isSyncFromDB", "setSyncFromDB", "oldIsNeedShowUnFollow", "getOldIsNeedShowUnFollow", "setOldIsNeedShowUnFollow", "old_avatar_url", "kotlin.jvm.PlatformType", "getOld_avatar_url", "()Ljava/lang/String;", "setOld_avatar_url", "old_follow_flag", "", "getOld_follow_flag", "()I", "setOld_follow_flag", "(I)V", "cloneContact", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getAvatarUrl", "getCity", "getContactId", "", "getCountry", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getDisplayRemark", "getNickname", "getProvince", "getRetryCount", "getSex", "getSignature", "getUpdateTime", "getUsername", "getVersion", "isBlock", "isSilence", "isValid", "setAvatarUrl", "field_avatarUrl", "setCity", "city", "setCountry", "country", "setNickname", "field_nickname", "setProvince", "province", "setSex", "sex", "setSignature", "signature", "setUsername", "field_username", "setVersion", "version", "toInfo", "toMiniInfo", "toString", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "contact", "Companion", "plugin-finder_release"})
public final class g
  extends cd
  implements r, Cloneable
{
  private static final c.a info;
  private static final int rPJ = 2;
  private static final int rPK = 1;
  private static final int rPL = 0;
  public static final a rPM;
  boolean isNeedShowUnFollow;
  public boolean rPE;
  public boolean rPF;
  int rPG;
  String rPH;
  boolean rPI;
  
  static
  {
    AppMethodBeat.i(165156);
    rPM = new a((byte)0);
    c.a locala = cd.VD();
    p.g(locala, "BaseFinderContact.initAu…inderContact::class.java)");
    info = locala;
    rPJ = 2;
    rPK = 1;
    AppMethodBeat.o(165156);
  }
  
  public g()
  {
    AppMethodBeat.i(165155);
    this.rPF = true;
    this.rPG = this.field_follow_Flag;
    this.rPH = this.field_avatarUrl;
    AppMethodBeat.o(165155);
  }
  
  public g(String paramString)
  {
    AppMethodBeat.i(201433);
    this.rPF = true;
    this.rPG = this.field_follow_Flag;
    this.rPH = this.field_avatarUrl;
    this.field_username = paramString;
    AppMethodBeat.o(201433);
  }
  
  public final String HC()
  {
    String str2 = this.field_signature;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String VK()
  {
    String str2 = this.field_nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final int VQ()
  {
    amj localamj = this.field_extInfo;
    if (localamj != null) {
      return localamj.eQV;
    }
    return 0;
  }
  
  public final String adG()
  {
    String str2 = this.field_nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void ahY(String paramString)
  {
    AppMethodBeat.i(165150);
    p.h(paramString, "field_avatarUrl");
    this.field_avatarUrl = paramString;
    AppMethodBeat.o(165150);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(165157);
    Object localObject = super.clone();
    AppMethodBeat.o(165157);
    return localObject;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(165147);
    super.convertFrom(paramCursor);
    this.rPE = true;
    AppMethodBeat.o(165147);
  }
  
  public final String czm()
  {
    String str2 = this.field_avatarUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final long czn()
  {
    return this.field_updateTime;
  }
  
  public final long czo()
  {
    return this.systemRowid;
  }
  
  public final String czp()
  {
    AppMethodBeat.i(165151);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + " head:" + this.field_avatarUrl + " converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus + ", originalFlag:" + this.field_originalFlag;
    AppMethodBeat.o(165151);
    return str;
  }
  
  public final String czq()
  {
    AppMethodBeat.i(165152);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + "  converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus;
    AppMethodBeat.o(165152);
    return str;
  }
  
  public final g czr()
  {
    AppMethodBeat.i(165154);
    g localg;
    try
    {
      Object localObject = super.clone();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
        AppMethodBeat.o(165154);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("LocalFinderContact", (Throwable)localException, "", new Object[0]);
      ae.e("LocalFinderContact", "clone Contact error. e: ".concat(String.valueOf(localException)));
      localg = null;
    }
    for (;;)
    {
      AppMethodBeat.o(165154);
      return localg;
      localg = (g)localg;
    }
  }
  
  public final String getCity()
  {
    Object localObject = this.field_extInfo;
    if (localObject != null)
    {
      String str = ((amj)localObject).eRg;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final String getCountry()
  {
    AppMethodBeat.i(201428);
    Object localObject2 = this.field_extInfo;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new amj();
    }
    localObject2 = ((amj)localObject1).country;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    AppMethodBeat.o(201428);
    return localObject1;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String getProvince()
  {
    Object localObject = this.field_extInfo;
    if (localObject != null)
    {
      String str = ((amj)localObject).eRf;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final int getRetryCount()
  {
    return this.field_retryCount;
  }
  
  public final String getUsername()
  {
    String str2 = this.field_username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final boolean isBlock()
  {
    return this.field_spamStatus == 1;
  }
  
  public final boolean isValid()
  {
    return this.rPF;
  }
  
  public final void kh(int paramInt)
  {
    AppMethodBeat.i(201431);
    amj localamj2 = this.field_extInfo;
    amj localamj1 = localamj2;
    if (localamj2 == null) {
      localamj1 = new amj();
    }
    localamj1.eQV = paramInt;
    this.field_extInfo = localamj1;
    AppMethodBeat.o(201431);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(165148);
    p.h(paramString, "field_username");
    this.field_username = paramString;
    AppMethodBeat.o(165148);
  }
  
  public final void tF(String paramString)
  {
    AppMethodBeat.i(201429);
    p.h(paramString, "signature");
    this.field_signature = paramString;
    AppMethodBeat.o(201429);
  }
  
  public final void tG(String paramString)
  {
    AppMethodBeat.i(201430);
    p.h(paramString, "province");
    amj localamj2 = this.field_extInfo;
    amj localamj1 = localamj2;
    if (localamj2 == null) {
      localamj1 = new amj();
    }
    localamj1.eRf = paramString;
    this.field_extInfo = localamj1;
    AppMethodBeat.o(201430);
  }
  
  public final void tH(String paramString)
  {
    AppMethodBeat.i(201427);
    p.h(paramString, "city");
    amj localamj2 = this.field_extInfo;
    amj localamj1 = localamj2;
    if (localamj2 == null) {
      localamj1 = new amj();
    }
    localamj1.eRg = paramString;
    this.field_extInfo = localamj1;
    AppMethodBeat.o(201427);
  }
  
  public final void to(String paramString)
  {
    AppMethodBeat.i(165149);
    p.h(paramString, "field_nickname");
    this.field_nickname = paramString;
    AppMethodBeat.o(165149);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(165153);
    String str = czp();
    AppMethodBeat.o(165153);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact$Companion;", "", "()V", "FOLLOW_FLAG_FOLLOWED", "", "getFOLLOW_FLAG_FOLLOWED", "()I", "FOLLOW_FLAG_UNFOLLOWED", "getFOLLOW_FLAG_UNFOLLOWED", "FOLLOW_FLAG_WAITING", "getFOLLOW_FLAG_WAITING", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.g
 * JD-Core Version:    0.7.0.1
 */