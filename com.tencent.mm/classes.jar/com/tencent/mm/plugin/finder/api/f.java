package com.tencent.mm.plugin.finder.api;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cc;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "", "()V", "isNeedShowUnFollow", "", "()Z", "setNeedShowUnFollow", "(Z)V", "isSyncFromDB", "setSyncFromDB", "oldIsNeedShowUnFollow", "getOldIsNeedShowUnFollow", "setOldIsNeedShowUnFollow", "old_avatar_url", "", "kotlin.jvm.PlatformType", "getOld_avatar_url", "()Ljava/lang/String;", "setOld_avatar_url", "(Ljava/lang/String;)V", "old_follow_flag", "", "getOld_follow_flag", "()I", "setOld_follow_flag", "(I)V", "cloneContact", "convertFrom", "", "cu", "Landroid/database/Cursor;", "getAvatarUrl", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getNickname", "getUsername", "getVersion", "", "isBlock", "isSilence", "setAvatarUrl", "field_avatarUrl", "setNickname", "field_nickname", "setUsername", "field_username", "setVersion", "version", "toInfo", "toMiniInfo", "toString", "Companion", "plugin-finder_release"})
public final class f
  extends cc
  implements Cloneable
{
  private static final c.a info;
  private static final int qWD = 1;
  private static final int qWE = 0;
  public static final f.a qWF;
  boolean isNeedShowUnFollow;
  int qWA;
  String qWB;
  boolean qWC;
  public boolean qWz;
  
  static
  {
    AppMethodBeat.i(165156);
    qWF = new f.a((byte)0);
    c.a locala = cc.Th();
    k.g(locala, "BaseFinderContact.initAu…inderContact::class.java)");
    info = locala;
    qWD = 1;
    AppMethodBeat.o(165156);
  }
  
  public f()
  {
    AppMethodBeat.i(165155);
    this.qWA = this.field_follow_Flag;
    this.qWB = this.field_avatarUrl;
    AppMethodBeat.o(165155);
  }
  
  public final String Tn()
  {
    String str2 = this.field_nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void adl(String paramString)
  {
    AppMethodBeat.i(165150);
    k.h(paramString, "field_avatarUrl");
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
    this.qWz = true;
    AppMethodBeat.o(165147);
  }
  
  public final String crZ()
  {
    String str2 = this.field_avatarUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String csa()
  {
    AppMethodBeat.i(165151);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + " head:" + this.field_avatarUrl + " converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus + ", originalFlag:" + this.field_originalFlag;
    AppMethodBeat.o(165151);
    return str;
  }
  
  public final String csb()
  {
    AppMethodBeat.i(165152);
    String str = "username:" + this.field_username + " nick:" + this.field_nickname + " signature:" + this.field_signature + " version:" + this.field_version + " follow_flag:" + this.field_follow_Flag + "  converImg:" + this.field_coverImg + " spam:" + this.field_spamStatus;
    AppMethodBeat.o(165152);
    return str;
  }
  
  public final f csc()
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
      ac.printErrStackTrace("LocalFinderContact", (Throwable)localException, "", new Object[0]);
      ac.e("LocalFinderContact", "clone Contact error. e: ".concat(String.valueOf(localException)));
      localf = null;
    }
    for (;;)
    {
      AppMethodBeat.o(165154);
      return localf;
      localf = (f)localf;
    }
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
  
  public final void qj(String paramString)
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
    String str = csa();
    AppMethodBeat.o(165153);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.f
 * JD-Core Version:    0.7.0.1
 */