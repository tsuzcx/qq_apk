package com.tencent.mm.plugin.finder.api;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cf;
import com.tencent.mm.plugin.findersdk.a.ai;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "", "username", "", "(Ljava/lang/String;)V", "()V", "isContactValid", "", "()Z", "setContactValid", "(Z)V", "isNeedShowUnFollow", "setNeedShowUnFollow", "isSyncFromDB", "setSyncFromDB", "oldIsNeedShowUnFollow", "getOldIsNeedShowUnFollow", "setOldIsNeedShowUnFollow", "old_avatar_url", "kotlin.jvm.PlatformType", "getOld_avatar_url", "()Ljava/lang/String;", "setOld_avatar_url", "old_follow_flag", "", "getOld_follow_flag", "()I", "setOld_follow_flag", "(I)V", "cloneContact", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getAvatarUrl", "getCity", "getContactId", "", "getCountry", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getDisplayRemark", "getFeedCount", "getFollowFlag", "getFollowersCount", "getFrom", "getLiveAlias", "getNickname", "getPersonalMsgUpdateTime", "getProvince", "getRetryCount", "getRewardTotalAmountInWecoin", "getSex", "getSignature", "getUpdateTime", "getUsername", "getV5UserName", "getVersion", "isBlock", "isSilence", "isValid", "setAvatarUrl", "field_avatarUrl", "setCity", "city", "setCountry", "country", "setFrom", "from", "setNickname", "field_nickname", "setProvince", "province", "setSex", "sex", "setSignature", "signature", "setUsername", "field_username", "setVersion", "version", "toInfo", "toMiniInfo", "toString", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "contact", "Companion", "finder-sdk_release"})
public final class i
  extends cf
  implements ai, Cloneable
{
  private static final IAutoDBItem.MAutoDBInfo info;
  private static final int xaf = 2;
  private static final int xag = 1;
  private static final int xah = 0;
  public static final a xai;
  boolean isNeedShowUnFollow;
  public boolean xaa;
  public boolean xab;
  int xac;
  String xad;
  boolean xae;
  
  static
  {
    AppMethodBeat.i(165156);
    xai = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cf.aoY();
    p.j(localMAutoDBInfo, "BaseFinderContact.initAu…inderContact::class.java)");
    info = localMAutoDBInfo;
    xaf = 2;
    xag = 1;
    AppMethodBeat.o(165156);
  }
  
  public i()
  {
    AppMethodBeat.i(165155);
    this.xab = true;
    this.xac = this.field_follow_Flag;
    this.xad = this.field_avatarUrl;
    AppMethodBeat.o(165155);
  }
  
  public i(String paramString)
  {
    AppMethodBeat.i(210324);
    this.xab = true;
    this.xac = this.field_follow_Flag;
    this.xad = this.field_avatarUrl;
    this.field_username = paramString;
    AppMethodBeat.o(210324);
  }
  
  public final void IJ(String paramString)
  {
    AppMethodBeat.i(210302);
    p.k(paramString, "signature");
    this.field_signature = paramString;
    AppMethodBeat.o(210302);
  }
  
  public final void IK(String paramString)
  {
    AppMethodBeat.i(210305);
    p.k(paramString, "province");
    ard localard2 = this.field_extInfo;
    ard localard1 = localard2;
    if (localard2 == null) {
      localard1 = new ard();
    }
    localard1.province = paramString;
    this.field_extInfo = localard1;
    AppMethodBeat.o(210305);
  }
  
  public final void IL(String paramString)
  {
    AppMethodBeat.i(210297);
    p.k(paramString, "city");
    ard localard2 = this.field_extInfo;
    ard localard1 = localard2;
    if (localard2 == null) {
      localard1 = new ard();
    }
    localard1.city = paramString;
    this.field_extInfo = localard1;
    AppMethodBeat.o(210297);
  }
  
  public final String Mm()
  {
    String str2 = this.field_avatarUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void aAS(String paramString)
  {
    AppMethodBeat.i(165150);
    p.k(paramString, "field_avatarUrl");
    this.field_avatarUrl = paramString;
    AppMethodBeat.o(165150);
  }
  
  public final int apt()
  {
    ard localard = this.field_extInfo;
    if (localard != null) {
      return localard.sex;
    }
    return 0;
  }
  
  public final String ays()
  {
    String str2 = this.field_nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
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
    this.xaa = true;
    AppMethodBeat.o(165147);
  }
  
  public final long dnn()
  {
    return this.field_updateTime;
  }
  
  public final long dno()
  {
    return this.systemRowid;
  }
  
  public final String dnp()
  {
    AppMethodBeat.i(165151);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + " head:" + this.field_avatarUrl + " converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus + ", originalFlag:" + this.field_originalFlag + ", liveAnchorFlag:" + this.field_liveAnchorStatusFlag + ", liveSwitchFlag:" + this.field_liveSwitchFlag;
    AppMethodBeat.o(165151);
    return str;
  }
  
  public final String dnq()
  {
    AppMethodBeat.i(165152);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + "  converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus;
    AppMethodBeat.o(165152);
    return str;
  }
  
  public final long dnr()
  {
    return this.field_rewardTotalAmountInWecoin;
  }
  
  public final int dns()
  {
    return this.field_feedCount;
  }
  
  public final int dnt()
  {
    return this.field_friendFollowCount;
  }
  
  public final int dnu()
  {
    return this.field_follow_Flag;
  }
  
  public final long dnv()
  {
    return this.field_personalMsgUpdateTime;
  }
  
  public final i dnw()
  {
    AppMethodBeat.i(165154);
    i locali;
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
      locali = null;
    }
    for (;;)
    {
      AppMethodBeat.o(165154);
      return locali;
      locali = (i)locali;
    }
  }
  
  public final String getCity()
  {
    Object localObject = this.field_extInfo;
    if (localObject != null)
    {
      String str = ((ard)localObject).city;
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
    AppMethodBeat.i(210301);
    Object localObject2 = this.field_extInfo;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ard();
    }
    localObject2 = ((ard)localObject1).country;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    AppMethodBeat.o(210301);
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
      String str = ((ard)localObject).province;
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
    return this.xab;
  }
  
  public final void pw(int paramInt)
  {
    AppMethodBeat.i(210308);
    ard localard2 = this.field_extInfo;
    ard localard1 = localard2;
    if (localard2 == null) {
      localard1 = new ard();
    }
    localard1.sex = paramInt;
    this.field_extInfo = localard1;
    AppMethodBeat.o(210308);
  }
  
  public final void setNickname(String paramString)
  {
    AppMethodBeat.i(165149);
    p.k(paramString, "field_nickname");
    this.field_nickname = paramString;
    AppMethodBeat.o(165149);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(165148);
    p.k(paramString, "field_username");
    this.field_username = paramString;
    AppMethodBeat.o(165148);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(165153);
    String str = dnp();
    AppMethodBeat.o(165153);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact$Companion;", "", "()V", "FOLLOW_FLAG_FOLLOWED", "", "getFOLLOW_FLAG_FOLLOWED", "()I", "FOLLOW_FLAG_UNFOLLOWED", "getFOLLOW_FLAG_UNFOLLOWED", "FOLLOW_FLAG_WAITING", "getFOLLOW_FLAG_WAITING", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "finder-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.i
 * JD-Core Version:    0.7.0.1
 */