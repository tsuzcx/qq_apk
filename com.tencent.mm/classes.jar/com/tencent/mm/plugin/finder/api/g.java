package com.tencent.mm.plugin.finder.api;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "", "username", "", "(Ljava/lang/String;)V", "()V", "isContactValid", "", "()Z", "setContactValid", "(Z)V", "isNeedShowUnFollow", "setNeedShowUnFollow", "isSyncFromDB", "setSyncFromDB", "oldIsNeedShowUnFollow", "getOldIsNeedShowUnFollow", "setOldIsNeedShowUnFollow", "old_avatar_url", "kotlin.jvm.PlatformType", "getOld_avatar_url", "()Ljava/lang/String;", "setOld_avatar_url", "old_follow_flag", "", "getOld_follow_flag", "()I", "setOld_follow_flag", "(I)V", "cloneContact", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getAvatarUrl", "getCity", "getContactId", "", "getCountry", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getDisplayRemark", "getNickname", "getProvince", "getRetryCount", "getSex", "getSignature", "getUpdateTime", "getUsername", "getVersion", "isBlock", "isSilence", "isValid", "setAvatarUrl", "field_avatarUrl", "setCity", "city", "setCountry", "country", "setNickname", "field_nickname", "setProvince", "province", "setSex", "sex", "setSignature", "signature", "setUsername", "field_username", "setVersion", "version", "toInfo", "toMiniInfo", "toString", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "contact", "Companion", "plugin-finder_release"})
public final class g
  extends cd
  implements r, Cloneable
{
  private static final c.a info;
  private static final int rHA = 0;
  public static final a rHB;
  private static final int rHy = 2;
  private static final int rHz = 1;
  boolean isNeedShowUnFollow;
  public boolean rHt;
  public boolean rHu;
  int rHv;
  String rHw;
  boolean rHx;
  
  static
  {
    AppMethodBeat.i(165156);
    rHB = new a((byte)0);
    c.a locala = cd.Vv();
    p.g(locala, "BaseFinderContact.initAu…inderContact::class.java)");
    info = locala;
    rHy = 2;
    rHz = 1;
    AppMethodBeat.o(165156);
  }
  
  public g()
  {
    AppMethodBeat.i(165155);
    this.rHu = true;
    this.rHv = this.field_follow_Flag;
    this.rHw = this.field_avatarUrl;
    AppMethodBeat.o(165155);
  }
  
  public g(String paramString)
  {
    AppMethodBeat.i(201011);
    this.rHu = true;
    this.rHv = this.field_follow_Flag;
    this.rHw = this.field_avatarUrl;
    this.field_username = paramString;
    AppMethodBeat.o(201011);
  }
  
  public final String Hu()
  {
    String str2 = this.field_signature;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String VC()
  {
    String str2 = this.field_nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final int VI()
  {
    alx localalx = this.field_extInfo;
    if (localalx != null) {
      return localalx.ePk;
    }
    return 0;
  }
  
  public final String adv()
  {
    String str2 = this.field_nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void ahb(String paramString)
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
    this.rHt = true;
    AppMethodBeat.o(165147);
  }
  
  public final String cxL()
  {
    String str2 = this.field_avatarUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final long cxM()
  {
    return this.field_updateTime;
  }
  
  public final long cxN()
  {
    return this.systemRowid;
  }
  
  public final String cxO()
  {
    AppMethodBeat.i(165151);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + " head:" + this.field_avatarUrl + " converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus + ", originalFlag:" + this.field_originalFlag;
    AppMethodBeat.o(165151);
    return str;
  }
  
  public final String cxP()
  {
    AppMethodBeat.i(165152);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + "  converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus;
    AppMethodBeat.o(165152);
    return str;
  }
  
  public final g cxQ()
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
      ad.printErrStackTrace("LocalFinderContact", (Throwable)localException, "", new Object[0]);
      ad.e("LocalFinderContact", "clone Contact error. e: ".concat(String.valueOf(localException)));
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
      String str = ((alx)localObject).ePv;
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
    AppMethodBeat.i(201006);
    alx localalx = this.field_extInfo;
    Object localObject = localalx;
    if (localalx == null) {
      localObject = new alx();
    }
    localObject = ((alx)localObject).country;
    p.g(localObject, "extInfo.country");
    AppMethodBeat.o(201006);
    return localObject;
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
      String str = ((alx)localObject).ePu;
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
    return this.rHu;
  }
  
  public final void kf(int paramInt)
  {
    AppMethodBeat.i(201009);
    alx localalx2 = this.field_extInfo;
    alx localalx1 = localalx2;
    if (localalx2 == null) {
      localalx1 = new alx();
    }
    localalx1.ePk = paramInt;
    this.field_extInfo = localalx1;
    AppMethodBeat.o(201009);
  }
  
  public final void sT(String paramString)
  {
    AppMethodBeat.i(165149);
    p.h(paramString, "field_nickname");
    this.field_nickname = paramString;
    AppMethodBeat.o(165149);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(165148);
    p.h(paramString, "field_username");
    this.field_username = paramString;
    AppMethodBeat.o(165148);
  }
  
  public final void tk(String paramString)
  {
    AppMethodBeat.i(201007);
    p.h(paramString, "signature");
    this.field_signature = paramString;
    AppMethodBeat.o(201007);
  }
  
  public final void tl(String paramString)
  {
    AppMethodBeat.i(201008);
    p.h(paramString, "province");
    alx localalx2 = this.field_extInfo;
    alx localalx1 = localalx2;
    if (localalx2 == null) {
      localalx1 = new alx();
    }
    localalx1.ePu = paramString;
    this.field_extInfo = localalx1;
    AppMethodBeat.o(201008);
  }
  
  public final void tm(String paramString)
  {
    AppMethodBeat.i(201005);
    p.h(paramString, "city");
    alx localalx2 = this.field_extInfo;
    alx localalx1 = localalx2;
    if (localalx2 == null) {
      localalx1 = new alx();
    }
    localalx1.ePv = paramString;
    this.field_extInfo = localalx1;
    AppMethodBeat.o(201005);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(165153);
    String str = cxO();
    AppMethodBeat.o(165153);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact$Companion;", "", "()V", "FOLLOW_FLAG_FOLLOWED", "", "getFOLLOW_FLAG_FOLLOWED", "()I", "FOLLOW_FLAG_UNFOLLOWED", "getFOLLOW_FLAG_UNFOLLOWED", "FOLLOW_FLAG_WAITING", "getFOLLOW_FLAG_WAITING", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.g
 * JD-Core Version:    0.7.0.1
 */