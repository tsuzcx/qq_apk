package com.tencent.mm.plugin.finder.api;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ce;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "", "username", "", "(Ljava/lang/String;)V", "()V", "isContactValid", "", "()Z", "setContactValid", "(Z)V", "isNeedShowUnFollow", "setNeedShowUnFollow", "isSyncFromDB", "setSyncFromDB", "oldIsNeedShowUnFollow", "getOldIsNeedShowUnFollow", "setOldIsNeedShowUnFollow", "old_avatar_url", "kotlin.jvm.PlatformType", "getOld_avatar_url", "()Ljava/lang/String;", "setOld_avatar_url", "old_follow_flag", "", "getOld_follow_flag", "()I", "setOld_follow_flag", "(I)V", "cloneContact", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getAvatarUrl", "getCity", "getContactId", "", "getCountry", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getDisplayRemark", "getNickname", "getProvince", "getRetryCount", "getSex", "getSignature", "getUpdateTime", "getUsername", "getVersion", "isBlock", "isSilence", "isValid", "setAvatarUrl", "field_avatarUrl", "setCity", "city", "setCountry", "country", "setNickname", "field_nickname", "setProvince", "province", "setSex", "sex", "setSignature", "signature", "setUsername", "field_username", "setVersion", "version", "toInfo", "toMiniInfo", "toString", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "contact", "Companion", "plugin-finder_release"})
public final class g
  extends ce
  implements ah, Cloneable
{
  private static final IAutoDBItem.MAutoDBInfo info;
  private static final int tsA = 2;
  private static final int tsB = 1;
  private static final int tsC = 0;
  public static final a tsD;
  boolean isNeedShowUnFollow;
  public boolean tsv;
  public boolean tsw;
  int tsx;
  String tsy;
  boolean tsz;
  
  static
  {
    AppMethodBeat.i(165156);
    tsD = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = ce.ajs();
    p.g(localMAutoDBInfo, "BaseFinderContact.initAu…inderContact::class.java)");
    info = localMAutoDBInfo;
    tsA = 2;
    tsB = 1;
    AppMethodBeat.o(165156);
  }
  
  public g()
  {
    AppMethodBeat.i(165155);
    this.tsw = true;
    this.tsx = this.field_follow_Flag;
    this.tsy = this.field_avatarUrl;
    AppMethodBeat.o(165155);
  }
  
  public g(String paramString)
  {
    AppMethodBeat.i(242194);
    this.tsw = true;
    this.tsx = this.field_follow_Flag;
    this.tsy = this.field_avatarUrl;
    this.field_username = paramString;
    AppMethodBeat.o(242194);
  }
  
  public final void BV(String paramString)
  {
    AppMethodBeat.i(242190);
    p.h(paramString, "signature");
    this.field_signature = paramString;
    AppMethodBeat.o(242190);
  }
  
  public final void BW(String paramString)
  {
    AppMethodBeat.i(242191);
    p.h(paramString, "province");
    app localapp2 = this.field_extInfo;
    app localapp1 = localapp2;
    if (localapp2 == null) {
      localapp1 = new app();
    }
    localapp1.fuJ = paramString;
    this.field_extInfo = localapp1;
    AppMethodBeat.o(242191);
  }
  
  public final void BX(String paramString)
  {
    AppMethodBeat.i(242188);
    p.h(paramString, "city");
    app localapp2 = this.field_extInfo;
    app localapp1 = localapp2;
    if (localapp2 == null) {
      localapp1 = new app();
    }
    localapp1.fuK = paramString;
    this.field_extInfo = localapp1;
    AppMethodBeat.o(242188);
  }
  
  public final int ajE()
  {
    app localapp = this.field_extInfo;
    if (localapp != null) {
      return localapp.fuA;
    }
    return 0;
  }
  
  public final String arJ()
  {
    String str2 = this.field_nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void asL(String paramString)
  {
    AppMethodBeat.i(165150);
    p.h(paramString, "field_avatarUrl");
    this.field_avatarUrl = paramString;
    AppMethodBeat.o(165150);
  }
  
  public final String cXH()
  {
    String str2 = this.field_avatarUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final long cXI()
  {
    return this.field_updateTime;
  }
  
  public final long cXJ()
  {
    return this.systemRowid;
  }
  
  public final String cXK()
  {
    AppMethodBeat.i(165151);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + " head:" + this.field_avatarUrl + " converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus + ", originalFlag:" + this.field_originalFlag + ", liveAnchorFlag:" + this.field_liveAnchorStatusFlag + ", liveSwitchFlag:" + this.field_liveSwitchFlag;
    AppMethodBeat.o(165151);
    return str;
  }
  
  public final String cXL()
  {
    AppMethodBeat.i(165152);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + "  converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus;
    AppMethodBeat.o(165152);
    return str;
  }
  
  public final g cXM()
  {
    AppMethodBeat.i(165154);
    g localg;
    try
    {
      Object localObject = super.clone();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
        AppMethodBeat.o(165154);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("LocalFinderContact", (Throwable)localException, "", new Object[0]);
      Log.e("LocalFinderContact", "clone Contact error. e: ".concat(String.valueOf(localException)));
      localg = null;
    }
    for (;;)
    {
      AppMethodBeat.o(165154);
      return localg;
      localg = (g)localg;
    }
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
    this.tsv = true;
    AppMethodBeat.o(165147);
  }
  
  public final String getCity()
  {
    Object localObject = this.field_extInfo;
    if (localObject != null)
    {
      String str = ((app)localObject).fuK;
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
    AppMethodBeat.i(242189);
    Object localObject2 = this.field_extInfo;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new app();
    }
    localObject2 = ((app)localObject1).country;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    AppMethodBeat.o(242189);
    return localObject1;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getNickname()
  {
    String str2 = this.field_nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getProvince()
  {
    Object localObject = this.field_extInfo;
    if (localObject != null)
    {
      String str = ((app)localObject).fuJ;
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
  
  public final String getSignature()
  {
    String str2 = this.field_signature;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
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
    return this.tsw;
  }
  
  public final void nj(int paramInt)
  {
    AppMethodBeat.i(242192);
    app localapp2 = this.field_extInfo;
    app localapp1 = localapp2;
    if (localapp2 == null) {
      localapp1 = new app();
    }
    localapp1.fuA = paramInt;
    this.field_extInfo = localapp1;
    AppMethodBeat.o(242192);
  }
  
  public final void setNickname(String paramString)
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
  
  public final String toString()
  {
    AppMethodBeat.i(165153);
    String str = cXK();
    AppMethodBeat.o(165153);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact$Companion;", "", "()V", "FOLLOW_FLAG_FOLLOWED", "", "getFOLLOW_FLAG_FOLLOWED", "()I", "FOLLOW_FLAG_UNFOLLOWED", "getFOLLOW_FLAG_UNFOLLOWED", "FOLLOW_FLAG_WAITING", "getFOLLOW_FLAG_WAITING", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.g
 * JD-Core Version:    0.7.0.1
 */