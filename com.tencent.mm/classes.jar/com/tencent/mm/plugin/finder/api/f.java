package com.tencent.mm.plugin.finder.api;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ca;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "", "()V", "isNeedShowUnFollow", "", "()Z", "setNeedShowUnFollow", "(Z)V", "isSyncFromDB", "setSyncFromDB", "oldIsNeedShowUnFollow", "getOldIsNeedShowUnFollow", "setOldIsNeedShowUnFollow", "old_avatar_url", "", "kotlin.jvm.PlatformType", "getOld_avatar_url", "()Ljava/lang/String;", "setOld_avatar_url", "(Ljava/lang/String;)V", "old_follow_flag", "", "getOld_follow_flag", "()I", "setOld_follow_flag", "(I)V", "cloneContact", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getAvatarUrl", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getNickname", "getUsername", "getVersion", "", "isBlock", "isSilence", "setAvatarUrl", "field_avatarUrl", "setNickname", "field_nickname", "setUsername", "field_username", "setVersion", "version", "toInfo", "toMiniInfo", "toString", "Companion", "plugin-finder_release"})
public final class f
  extends ca
  implements Cloneable
{
  private static final c.a info;
  private static final int qoi = 1;
  private static final int qoj = 0;
  public static final a qok;
  boolean isNeedShowUnFollow;
  public boolean qoe;
  int qof;
  String qog;
  boolean qoh;
  
  static
  {
    AppMethodBeat.i(165156);
    qok = new a((byte)0);
    c.a locala = ca.So();
    k.g(locala, "BaseFinderContact.initAu…inderContact::class.java)");
    info = locala;
    qoi = 1;
    AppMethodBeat.o(165156);
  }
  
  public f()
  {
    AppMethodBeat.i(165155);
    this.qof = this.field_follow_Flag;
    this.qog = this.field_avatarUrl;
    AppMethodBeat.o(165155);
  }
  
  public final String Su()
  {
    String str2 = this.field_nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void YQ(String paramString)
  {
    AppMethodBeat.i(165150);
    k.h(paramString, "field_avatarUrl");
    this.field_avatarUrl = paramString;
    AppMethodBeat.o(165150);
  }
  
  public final String cks()
  {
    String str2 = this.field_avatarUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String ckt()
  {
    AppMethodBeat.i(165151);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + " head:" + this.field_avatarUrl + " converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus + ", originalFlag:" + this.field_originalFlag;
    AppMethodBeat.o(165151);
    return str;
  }
  
  public final String cku()
  {
    AppMethodBeat.i(165152);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + "  converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus;
    AppMethodBeat.o(165152);
    return str;
  }
  
  public final f ckv()
  {
    AppMethodBeat.i(165154);
    f localf;
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
      localf = null;
    }
    for (;;)
    {
      AppMethodBeat.o(165154);
      return localf;
      localf = (f)localf;
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
    this.qoe = true;
    AppMethodBeat.o(165147);
  }
  
  public final c.a getDBInfo()
  {
    return info;
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
  
  public final void nd(String paramString)
  {
    AppMethodBeat.i(165149);
    k.h(paramString, "field_nickname");
    this.field_nickname = paramString;
    AppMethodBeat.o(165149);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(165148);
    k.h(paramString, "field_username");
    this.field_username = paramString;
    AppMethodBeat.o(165148);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(165153);
    String str = ckt();
    AppMethodBeat.o(165153);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact$Companion;", "", "()V", "FOLLOW_FLAG_FOLLOWED", "", "getFOLLOW_FLAG_FOLLOWED", "()I", "FOLLOW_FLAG_UNFOLLOWED", "getFOLLOW_FLAG_UNFOLLOWED", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.f
 * JD-Core Version:    0.7.0.1
 */