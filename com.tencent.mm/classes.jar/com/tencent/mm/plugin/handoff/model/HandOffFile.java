package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "fullPath", "", "fileType", "title", "md5", "size", "", "source", "", "svrId", "extId", "cdnURL", "aesKey", "authKey", "fileStatus", "appId", "sdkVersion", "mediaId", "uploadedSize", "handOffType", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "getAppId", "setAppId", "getAuthKey", "setAuthKey", "getCdnURL", "setCdnURL", "getExtId", "setExtId", "getFileStatus", "()I", "setFileStatus", "(I)V", "getFileType", "setFileType", "getFullPath", "setFullPath", "getMd5", "setMd5", "getMediaId", "setMediaId", "getSdkVersion", "setSdkVersion", "getSize", "()J", "setSize", "(J)V", "getSource", "setSource", "getSvrId", "setSvrId", "getTitle", "setTitle", "getUploadedSize", "setUploadedSize", "body", "copy", "describeContents", "getDataType", "toBallInfo", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "toString", "update", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public final class HandOffFile
  extends HandOff
{
  public static final Parcelable.Creator<HandOffFile> CREATOR;
  public static final a tBi;
  public String appId;
  public int dbL;
  private String fPC;
  private String fQi;
  public String gKe;
  public String md5;
  public String mediaId;
  public int nmu;
  public long size;
  private String tBc;
  public String tBd;
  private String tBe;
  private String tBf;
  public int tBg;
  private long tBh;
  private String title;
  
  static
  {
    AppMethodBeat.i(121708);
    tBi = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(121708);
  }
  
  public HandOffFile(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(121707);
    String str = paramParcel.readString();
    if (str == null) {
      k.fOy();
    }
    this.gKe = str;
    str = paramParcel.readString();
    if (str == null) {
      k.fOy();
    }
    this.tBc = str;
    str = paramParcel.readString();
    if (str == null) {
      k.fOy();
    }
    this.title = str;
    str = paramParcel.readString();
    if (str == null) {
      k.fOy();
    }
    this.md5 = str;
    this.size = paramParcel.readLong();
    this.dbL = paramParcel.readInt();
    str = paramParcel.readString();
    if (str == null) {
      k.fOy();
    }
    this.tBd = str;
    str = paramParcel.readString();
    if (str == null) {
      k.fOy();
    }
    this.tBe = str;
    str = paramParcel.readString();
    if (str == null) {
      k.fOy();
    }
    this.tBf = str;
    str = paramParcel.readString();
    if (str == null) {
      k.fOy();
    }
    this.fQi = str;
    str = paramParcel.readString();
    if (str == null) {
      k.fOy();
    }
    this.fPC = str;
    this.tBg = paramParcel.readInt();
    str = paramParcel.readString();
    if (str == null) {
      k.fOy();
    }
    this.appId = str;
    this.nmu = paramParcel.readInt();
    str = paramParcel.readString();
    if (str == null) {
      k.fOy();
    }
    this.mediaId = str;
    this.tBh = paramParcel.readLong();
    AppMethodBeat.o(121707);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11, long paramLong2, int paramInt4, String paramString12, String paramString13, String paramString14)
  {
    super(paramInt4, paramString12, paramString13, paramString14);
    AppMethodBeat.i(121705);
    this.gKe = paramString1;
    this.tBc = paramString2;
    this.title = paramString3;
    this.md5 = paramString4;
    this.size = paramLong1;
    this.dbL = paramInt1;
    this.tBd = paramString5;
    this.tBe = paramString6;
    this.tBf = paramString7;
    this.fQi = paramString8;
    this.fPC = paramString9;
    this.tBg = paramInt2;
    this.appId = paramString10;
    this.nmu = paramInt3;
    this.mediaId = paramString11;
    this.tBh = paramLong2;
    AppMethodBeat.o(121705);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong, 1, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
  }
  
  public static final HandOffFile L(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(121711);
    paramBallInfo = a.L(paramBallInfo);
    AppMethodBeat.o(121711);
    return paramBallInfo;
  }
  
  public static final HandOffFile a(agx paramagx, g paramg, bo parambo)
  {
    AppMethodBeat.i(121709);
    paramagx = a.a(paramagx, paramg, parambo);
    AppMethodBeat.o(121709);
    return paramagx;
  }
  
  public static final HandOffFile b(agx paramagx, g paramg)
  {
    AppMethodBeat.i(121710);
    paramagx = a.a(paramagx, paramg, null);
    AppMethodBeat.o(121710);
    return paramagx;
  }
  
  public final void K(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(121702);
    k.h(paramBallInfo, "ballInfo");
    try
    {
      paramBallInfo.ep("handoff#fullPath", this.gKe);
      paramBallInfo.ep("handoff#fileType", this.tBc);
      paramBallInfo.ep("handoff#title", this.title);
      paramBallInfo.ep("handoff#md5", this.md5);
      paramBallInfo.R("handoff#size", this.size);
      paramBallInfo.ck("handoff#source", this.dbL);
      paramBallInfo.ep("handoff#svrId", this.tBd);
      paramBallInfo.ep("handoff#extId", this.tBe);
      paramBallInfo.ep("handoff#cdnURL", this.tBf);
      paramBallInfo.ep("handoff#aesKey", this.fQi);
      paramBallInfo.ep("handoff#authKey", this.fPC);
      paramBallInfo.ck("handoff#fileStatus", this.tBg);
      paramBallInfo.ep("handoff#appId", this.appId);
      paramBallInfo.ck("handoff#sdkVersion", this.nmu);
      paramBallInfo.ep("handoff#KmediaId", this.mediaId);
      paramBallInfo.R("handoff#KUploadedSize", this.tBh);
      paramBallInfo.ep("handoff#from", this.dsT);
      paramBallInfo.ep("handoff#to", this.hmj);
      paramBallInfo.ep("handoff#key", this.key);
      AppMethodBeat.o(121702);
      return;
    }
    catch (Exception paramBallInfo)
    {
      AppMethodBeat.o(121702);
    }
  }
  
  public final void air(String paramString)
  {
    AppMethodBeat.i(121696);
    k.h(paramString, "<set-?>");
    this.gKe = paramString;
    AppMethodBeat.o(121696);
  }
  
  public final void ais(String paramString)
  {
    AppMethodBeat.i(121697);
    k.h(paramString, "<set-?>");
    this.tBf = paramString;
    AppMethodBeat.o(121697);
  }
  
  public final void ait(String paramString)
  {
    AppMethodBeat.i(121698);
    k.h(paramString, "<set-?>");
    this.fQi = paramString;
    AppMethodBeat.o(121698);
  }
  
  protected final String cSF()
  {
    AppMethodBeat.i(121700);
    String str = n.aWZ("\n        <filetype>" + a.di(this.tBc) + "</filetype>\n        <title>" + a.di(this.title) + "</title>\n        <md5>" + a.di(this.md5) + "</md5>\n        <uploadedsize>" + a.di(Long.valueOf(this.tBh)) + "</uploadedsize>\n        <size>" + a.di(Long.valueOf(this.size)) + "</size>\n        <source>" + a.di(Integer.valueOf(this.dbL)) + "</source>\n        <id>" + a.di(this.tBd) + "</id>\n        <extid>" + a.di(this.tBe) + "</extid>\n        <cdnurl>" + a.di(this.tBf) + "</cdnurl>\n        <aeskey>" + a.di(this.fQi) + "</aeskey>\n        <authkey>" + a.di(this.fPC) + "</authkey>\n        <filestatus>" + a.di(Integer.valueOf(this.tBg)) + "</filestatus>\n        <appid>" + a.di(this.appId) + "</appid>\n        <sdkversion>" + a.di(Integer.valueOf(this.nmu)) + "</sdkversion>\n        <mediaid>" + a.di(this.mediaId) + "</mediaid>\n    ");
    AppMethodBeat.o(121700);
    return str;
  }
  
  public final HandOff cSG()
  {
    AppMethodBeat.i(121703);
    Object localObject = new HandOffFile(this.gKe, this.tBc, this.title, this.md5, this.size, this.dbL, this.tBd, this.tBe, this.tBf, this.fQi, this.fPC, this.tBg, this.appId, this.nmu, this.mediaId, this.tBh, this.tBa, this.dsT, this.hmj, this.key);
    ((HandOffFile)localObject).adU(this.id);
    localObject = (HandOff)localObject;
    AppMethodBeat.o(121703);
    return localObject;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final int getDataType()
  {
    return 1;
  }
  
  public final void j(HandOff paramHandOff)
  {
    AppMethodBeat.i(121699);
    k.h(paramHandOff, "newHandOff");
    super.j(paramHandOff);
    if ((paramHandOff instanceof HandOffFile))
    {
      this.gKe = ((HandOffFile)paramHandOff).gKe;
      this.tBc = ((HandOffFile)paramHandOff).tBc;
      this.title = ((HandOffFile)paramHandOff).title;
      this.md5 = ((HandOffFile)paramHandOff).md5;
      this.size = ((HandOffFile)paramHandOff).size;
      this.dbL = ((HandOffFile)paramHandOff).dbL;
      this.tBd = ((HandOffFile)paramHandOff).tBd;
      this.tBe = ((HandOffFile)paramHandOff).tBe;
      this.tBf = ((HandOffFile)paramHandOff).tBf;
      this.fQi = ((HandOffFile)paramHandOff).fQi;
      this.fPC = ((HandOffFile)paramHandOff).fPC;
      this.tBg = ((HandOffFile)paramHandOff).tBg;
      this.appId = ((HandOffFile)paramHandOff).appId;
      this.nmu = ((HandOffFile)paramHandOff).nmu;
      this.mediaId = ((HandOffFile)paramHandOff).mediaId;
      this.tBh = ((HandOffFile)paramHandOff).tBh;
    }
    AppMethodBeat.o(121699);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121704);
    String str = "HandOffFile(key='" + this.key + "', id='" + this.id + "', createTime='" + this.createTime + ", fullPath='" + this.gKe + "', fileType='" + this.tBc + "', title='" + this.title + "', md5='" + this.md5 + "', size=" + this.size + ", source=" + this.dbL + ", svrId='" + this.tBd + "', extId='" + this.tBe + "', cdnURL='" + this.tBf + "', aesKey='" + this.fQi + "', authKey='" + this.fPC + "', fileStatus=" + this.tBg + ", appId='" + this.appId + "', sdkVersion=" + this.nmu + ", mediaId='" + this.mediaId + "', uploadedSize=" + this.tBh + ')';
    AppMethodBeat.o(121704);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121701);
    k.h(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.gKe);
    paramParcel.writeString(this.tBc);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.md5);
    paramParcel.writeLong(this.size);
    paramParcel.writeInt(this.dbL);
    paramParcel.writeString(this.tBd);
    paramParcel.writeString(this.tBe);
    paramParcel.writeString(this.tBf);
    paramParcel.writeString(this.fQi);
    paramParcel.writeString(this.fPC);
    paramParcel.writeInt(this.tBg);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.nmu);
    paramParcel.writeString(this.mediaId);
    paramParcel.writeLong(this.tBh);
    AppMethodBeat.o(121701);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/model/HandOffFile$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "KAesKey", "", "KAppId", "KAuthKey", "KCdnURL", "KExtId", "KFileStatus", "KFileType", "KFrom", "KFullPath", "KKey", "KMd5", "KMediaId", "KSdkVersion", "KSize", "KSource", "KSvrId", "KTitle", "KTo", "KUploadedSize", "fromBallInfo", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "fromFavItem", "dataItem", "Lcom/tencent/mm/protocal/protobuf/FavDataItem;", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "api-handoff_release"})
  public static final class a
  {
    public static HandOffFile L(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(121695);
      k.h(paramBallInfo, "ballInfo");
      String str1 = paramBallInfo.eq("handoff#fullPath", "");
      String str2 = paramBallInfo.eq("handoff#fileType", "");
      String str3 = paramBallInfo.eq("handoff#title", "");
      String str4 = paramBallInfo.eq("handoff#md5", "");
      long l1 = paramBallInfo.SL("handoff#size");
      int i = paramBallInfo.getIntExtra("handoff#source", 0);
      String str5 = paramBallInfo.eq("handoff#svrId", "");
      String str6 = paramBallInfo.eq("handoff#extId", "");
      String str7 = paramBallInfo.eq("handoff#cdnURL", "");
      String str8 = paramBallInfo.eq("handoff#aesKey", "");
      String str9 = paramBallInfo.eq("handoff#authKey", "");
      int j = paramBallInfo.getIntExtra("handoff#fileStatus", 0);
      String str10 = paramBallInfo.eq("handoff#appId", "");
      int k = paramBallInfo.getIntExtra("handoff#sdkVersion", 0);
      String str11 = paramBallInfo.eq("handoff#KmediaId", "");
      long l2 = paramBallInfo.SL("handoff#KUploadedSize");
      String str12 = paramBallInfo.eq("handoff#from", "");
      String str13 = paramBallInfo.eq("handoff#to", "");
      paramBallInfo = paramBallInfo.eq("handoff#key", "");
      k.g(str1, "fullPath");
      k.g(str2, "fileType");
      k.g(str3, "title");
      k.g(str4, "md5");
      k.g(str5, "svrId");
      k.g(str6, "extId");
      k.g(str7, "cdnURL");
      k.g(str8, "aesKey");
      k.g(str9, "authKey");
      k.g(str10, "appId");
      k.g(str11, "mediaId");
      k.g(str12, "from");
      k.g(str13, "to");
      k.g(paramBallInfo, "key");
      paramBallInfo = new HandOffFile(str1, str2, str3, str4, l1, i, str5, str6, str7, str8, str9, j, str10, k, str11, l2, 2, str12, str13, paramBallInfo);
      AppMethodBeat.o(121695);
      return paramBallInfo;
    }
    
    public static HandOffFile a(agx paramagx, g paramg, bo parambo)
    {
      AppMethodBeat.i(121694);
      k.h(paramagx, "dataItem");
      String str7 = bs.nullAsNil(b.d(paramagx));
      String str8 = bs.nullAsNil(paramagx.eRA());
      String str9 = bs.nullAsNil(paramagx.getTitle());
      String str10 = bs.nullAsNil(paramagx.eRB());
      long l = bs.g(Long.valueOf(paramagx.eRC()));
      String str4 = bs.nullAsNil(paramagx.eRy());
      String str11 = bs.nullAsNil(paramagx.eRz());
      String str12 = bs.nullAsNil(paramagx.eRF());
      String str5 = bs.nullAsNil(paramagx.eRG());
      String str13 = bs.nullAsNil(paramagx.eRD());
      String str3 = "";
      int i = 3;
      String str1 = "";
      String str6 = "";
      String str2;
      Object localObject;
      int j;
      if (paramg != null)
      {
        i = 2;
        paramg = String.valueOf(paramg.field_id);
        str2 = str6;
        localObject = str1;
        k.g(str7, "fullPath");
        k.g(str8, "fileExt");
        k.g(str9, "fileName");
        k.g(str10, "fileMd5");
        k.g(str13, "extId");
        k.g(str4, "cdnURL");
        if (((CharSequence)str4).length() <= 0) {
          break label397;
        }
        j = 1;
        label198:
        if (j == 0) {
          break label403;
        }
      }
      label397:
      label403:
      for (paramagx = str4;; paramagx = str5)
      {
        for (;;)
        {
          k.g(paramagx, "if (cdnURL.isNotEmpty()) cdnURL else tpURL");
          k.g(str11, "aesKey");
          k.g(str12, "authKey");
          paramagx = new HandOffFile(str7, str8, str9, str10, l, i, paramg, str13, paramagx, str11, str12, "", "", (String)localObject, str2);
          AppMethodBeat.o(121694);
          return paramagx;
          paramg = str3;
          localObject = str1;
          str2 = str6;
          if (parambo == null) {
            break;
          }
          i = 1;
          localObject = str3;
          try
          {
            paramg = String.valueOf(parambo.TA());
            localObject = paramg;
            paramagx = paramagx.eRE();
            localObject = paramg;
            k.g(paramagx, "dataItem.dataProtoItem");
            localObject = paramg;
            paramagx = paramagx.eRH();
            localObject = paramg;
            k.g(paramagx, "dataItem.dataProtoItem.dataSourceItem");
            localObject = paramg;
            paramagx = paramagx.eRI();
            localObject = paramg;
            k.g(paramagx, "dataItem.dataProtoItem.dataSourceItem.fromUser");
          }
          catch (Exception paramagx)
          {
            try
            {
              str2 = parambo.TC();
              k.g(str2, "msg.talker");
              localObject = paramagx;
            }
            catch (Exception parambo)
            {
              break label378;
            }
            paramagx = paramagx;
            paramagx = str1;
            paramg = (g)localObject;
          }
        }
        label378:
        ac.w("HandOffService", "Get null from record msg, use default value");
        localObject = paramagx;
        str2 = str6;
        break;
        j = 0;
        break label198;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/handoff/model/HandOffFile$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "api-handoff_release"})
  public static final class b
    implements Parcelable.Creator<HandOffFile>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffFile
 * JD-Core Version:    0.7.0.1
 */